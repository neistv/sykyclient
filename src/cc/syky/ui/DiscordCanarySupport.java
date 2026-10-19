package cc.syky.ui;

import com.sun.jna.platform.win32.User32;
import com.sun.jna.platform.win32.WinDef.HWND;
import com.sun.jna.platform.win32.WinUser.WINDOWPLACEMENT;
import com.sun.jna.ptr.IntByReference;
import java.io.IOException;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import net.minecraft.class_156;
import org.jetbrains.annotations.Nullable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public final class DiscordCanarySupport {
   private static final Logger v1 = LoggerFactory.getLogger("syky.discord");
   private static final Set<String> v2 = Set.of("discord.exe", "discordptb.exe", "discordcanary.exe");
   private static final List<String> v3 = List.of("Discord", "Discord PTB", "Discord Canary");

   private DiscordCanarySupport() {
   }

   public static void v1() {
      try {
         switch (class_156.method_668()) {
            case field_1133:
               v2();
               break;
            case field_1137:
               new ProcessBuilder("open", "-a", "Discord").start();
         }
      } catch (RuntimeException | LinkageError | IOException var1) {
         v1.debug("could not bring Discord to the front", var1);
      }
   }

   private static void v2() {
      HWND var0 = v3();
      if (var0 != null) {
         User32 var1 = User32.INSTANCE;
         if (!var1.IsWindowVisible(var0)) {
            var1.ShowWindow(var0, 5);
         }

         WINDOWPLACEMENT var2 = new WINDOWPLACEMENT();
         var1.GetWindowPlacement(var0, var2);
         if (var2.showCmd == 2) {
            var1.ShowWindow(var0, 9);
         }

         var1.SetForegroundWindow(var0);
      }
   }

   @Nullable
   private static HWND v3() {
      HWND[] var0 = new HWND[]{null};
      HWND[] var1 = new HWND[]{null};
      User32 var2 = User32.INSTANCE;
      var2.EnumWindows((var3, var4) -> {
         if (!v1(var3) || !v2(v2(var3))) {
            return true;
         } else if (var2.IsWindowVisible(var3)) {
            var0[0] = var3;
            return false;
         } else {
            if (var1[0] == null) {
               var1[0] = var3;
            }

            return true;
         }
      }, null);
      return var0[0] != null ? var0[0] : var1[0];
   }

   private static boolean v1(HWND var0) {
      IntByReference var1 = new IntByReference();
      User32.INSTANCE.GetWindowThreadProcessId(var0, var1);
      return ProcessHandle.of(var1.getValue()).flatMap(var0x -> var0x.info().command()).map(DiscordCanarySupport::v1).orElse(false);
   }

   public static boolean v1(String var0) {
      int var1 = Math.max(var0.lastIndexOf(92), var0.lastIndexOf(47));
      return v2.contains(var0.substring(var1 + 1).toLowerCase(Locale.ROOT));
   }

   public static boolean v2(String var0) {
      for (String var2 : v3) {
         if (var0.equals(var2) || var0.endsWith(" - " + var2)) {
            return true;
         }
      }

      return false;
   }

   private static String v2(HWND var0) {
      int var1 = User32.INSTANCE.GetWindowTextLength(var0);
      if (var1 <= 0) {
         return "";
      } else {
         char[] var2 = new char[var1 + 1];
         int var3 = User32.INSTANCE.GetWindowText(var0, var2, var2.length);
         return new String(var2, 0, Math.max(0, var3));
      }
   }
}
