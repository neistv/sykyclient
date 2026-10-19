package cc.syky.ui;

import com.sun.jna.Library;
import com.sun.jna.Native;
import com.sun.jna.Pointer;
import com.sun.jna.Structure;
import com.sun.jna.ptr.IntByReference;
import com.sun.jna.ptr.PointerByReference;
import java.util.List;
import java.util.Locale;
import org.jetbrains.annotations.Nullable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public final class uiSupport236 implements AutoCloseable {
   private static final Logger v1 = LoggerFactory.getLogger("syky.hardware.nvml");
   private static final int v2 = 0;
   private static final int v3 = 0;
   private final uiSupport236.Part2 v4;
   private final Pointer v5;
   private boolean v6;

   private uiSupport236(uiSupport236.Part2 var1, Pointer var2) {
      this.v4 = var1;
      this.v5 = var2;
   }

   @Nullable
   public static uiSupport236 v1() {
      uiSupport236.Part2 var0 = v4();
      if (var0 == null) {
         return null;
      } else {
         try {
            if (var0.nvmlInit_v2() != 0) {
               return null;
            } else {
               PointerByReference var1 = new PointerByReference();
               if (var0.nvmlDeviceGetHandleByIndex_v2(0, var1) != 0) {
                  var0.nvmlShutdown();
                  return null;
               } else {
                  return new uiSupport236(var0, var1.getValue());
               }
            }
         } catch (Throwable var2) {
            v1.debug("NVML unavailable ({})", var2.toString());
            return null;
         }
      }
   }

   @Nullable
   private static uiSupport236.Part2 v4() {
      for (String var1 : v5()) {
         try {
            return (uiSupport236.Part2)Native.load(var1, uiSupport236.Part2.class);
         } catch (Throwable var3) {
            v1.debug("NVML candidate '{}' unavailable ({})", var1, var3.toString());
         }
      }

      return null;
   }

   private static List<String> v5() {
      String var0 = System.getProperty("os.name", "").toLowerCase(Locale.ROOT);
      if (var0.startsWith("windows")) {
         return List.of("nvml");
      } else {
         return !var0.contains("mac") && !var0.contains("darwin") ? List.of("nvidia-ml", "libnvidia-ml.so.1") : List.of();
      }
   }

   public int v2() {
      try {
         IntByReference var1 = new IntByReference();
         return this.v4.nvmlDeviceGetTemperature(this.v5, 0, var1) == 0 ? var1.getValue() : -1;
      } catch (Throwable var2) {
         return -1;
      }
   }

   public int v3() {
      try {
         uiSupport236.Part1 var1 = new uiSupport236.Part1();
         return this.v4.nvmlDeviceGetUtilizationRates(this.v5, var1) == 0 ? var1.gpu : -1;
      } catch (Throwable var2) {
         return -1;
      }
   }

   @Override
   public void close() {
      if (!this.v6) {
         this.v6 = true;

         try {
            this.v4.nvmlShutdown();
         } catch (Throwable var2) {
         }
      }
   }

   public static final class Part1 extends Structure {
      public int gpu;
      public int memory;

      public Part1() {
      }

      public List<String> getFieldOrder() {
         return List.of("gpu", "memory");
      }
   }

   public interface Part2 extends Library {
      int nvmlInit_v2();

      int nvmlShutdown();

      int nvmlDeviceGetHandleByIndex_v2(int var1, PointerByReference var2);

      int nvmlDeviceGetTemperature(Pointer var1, int var2, IntByReference var3);

      int nvmlDeviceGetUtilizationRates(Pointer var1, uiSupport236.Part1 var2);
   }
}
