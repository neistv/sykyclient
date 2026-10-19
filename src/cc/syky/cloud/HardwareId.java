package cc.syky.cloud;

import com.sun.jna.Platform;
import com.sun.jna.platform.win32.Advapi32Util;
import com.sun.jna.platform.win32.WinReg;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.Base64;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import org.jetbrains.annotations.Nullable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import oshi.SystemInfo;
import oshi.hardware.Baseboard;
import oshi.hardware.ComputerSystem;
import oshi.hardware.HWDiskStore;
import oshi.hardware.HardwareAbstractionLayer;

public final class HardwareId {
   private static final Logger v2 = LoggerFactory.getLogger("syky.cloud");
   public static final List<String> v1 = List.of("system", "board", "disk", "os");
   private static final String[] v3 = new String[]{
      "O.E.M",
      "OEM",
      "DEFAULT STRING",
      "NOT APPLICABLE",
      "NOT SPECIFIED",
      "NOT AVAILABLE",
      "SYSTEM SERIAL",
      "SERIAL NUMBER",
      "BASE BOARD SERIAL",
      "CHASSIS SERIAL",
      "UNKNOWN",
      "NONE",
      "N/A",
      "INVALID",
      "123456789",
      "03000200-0400-0500-0006-000700080009"
   };

   private HardwareId() {
   }

   public static CompletableFuture<String> v1() {
      CompletableFuture var0 = new CompletableFuture();
      Thread var1 = new Thread(() -> {
         try {
            var0.complete(v1(v2()));
         } catch (Throwable var2) {
            v2.debug("hardware id unavailable", var2);
            var0.complete("");
         }
      }, "syky-hwid");
      var1.setDaemon(true);
      var1.start();
      return var0;
   }

   private static Map<String, String> v2() {
      LinkedHashMap var0 = new LinkedHashMap();
      HardwareAbstractionLayer var1 = new SystemInfo().getHardware();
      ComputerSystem var2 = var1.getComputerSystem();
      var0.put("system", var2.getHardwareUUID());
      Baseboard var3 = var2.getBaseboard();
      String var4 = var3.getSerialNumber();
      if (v1(var4)) {
         var0.put("board", var3.getManufacturer() + "|" + var3.getModel() + "|" + var4);
      }

      var1.getDiskStores()
         .stream()
         .sorted(Comparator.comparing(HWDiskStore::getName))
         .<String>map(HWDiskStore::getSerial)
         .filter(HardwareId::v1)
         .findFirst()
         .ifPresent(var1x -> var0.put("disk", var1x));
      String var5 = v3();
      if (var5 != null) {
         var0.put("os", var5);
      }

      return var0;
   }

   @Nullable
   private static String v3() {
      try {
         if (Platform.isWindows()) {
            return Advapi32Util.registryGetStringValue(WinReg.HKEY_LOCAL_MACHINE, "SOFTWARE\\Microsoft\\Cryptography", "MachineGuid");
         }

         if (Platform.isLinux()) {
            return Files.readString(Path.of("/etc/machine-id"));
         }
      } catch (Exception var1) {
         v2.debug("machine id unavailable", var1);
      }

      return null;
   }

   public static String v1(Map<String, String> var0) {
      StringBuilder var1 = new StringBuilder();

      for (String var3 : v1) {
         String var4 = (String)var0.get(var3);
         if (var4 != null && v1(var4)) {
            var1.append(var1.isEmpty() ? "v1" : "").append(';').append(var3).append('=').append(v1(var3, var4));
         }
      }

      return var1.toString();
   }

   public static boolean v1(@Nullable String var0) {
      if (var0 == null) {
         return false;
      } else {
         String var1 = var0.strip().toUpperCase(Locale.ROOT);
         String var2 = var1.replace("-", "").replace(" ", "").replace("|", "");
         if (var2.length() >= 4 && var2.chars().distinct().count() != 1L) {
            for (String var6 : v3) {
               if (var1.contains(var6)) {
                  return false;
               }
            }

            return true;
         } else {
            return false;
         }
      }
   }

   private static String v1(String var0, String var1) {
      try {
         byte[] var2 = MessageDigest.getInstance("SHA-256")
            .digest(("syky-hw-v1\u0000" + var0 + "\u0000" + var1.strip().toUpperCase(Locale.ROOT)).getBytes(StandardCharsets.UTF_8));
         return Base64.getUrlEncoder().withoutPadding().encodeToString(Arrays.copyOf(var2, 16));
      } catch (NoSuchAlgorithmException var3) {
         throw new IllegalStateException("SHA-256 is part of every JVM", var3);
      }
   }
}
