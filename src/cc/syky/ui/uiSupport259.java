package cc.syky.ui;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.BooleanSupplier;
import java.util.function.DoubleSupplier;
import java.util.function.IntSupplier;
import java.util.function.Supplier;
import org.jetbrains.annotations.Nullable;

public final class uiSupport259 {
   private static final Map<String, uiSupport260> v1 = new ConcurrentHashMap<>();

   private uiSupport259() {
   }

   public static void v1(String var0, Runnable var1) {
      v1(var0).v1(var1);
   }

   @Nullable
   public static <T> T v1(String var0, Supplier<T> var1, @Nullable T var2) {
      uiSupport260 var3 = v1(var0);

      try {
         Object var4 = var1.get();
         var3.v1();
         return (T)var4;
      } catch (Throwable var5) {
         var3.v1(var5);
         return (T)var2;
      }
   }

   public static boolean v1(String var0, BooleanSupplier var1, boolean var2) {
      return v1(var0).v1(var1, var2);
   }

   public static int v1(String var0, IntSupplier var1, int var2) {
      uiSupport260 var3 = v1(var0);

      try {
         int var4 = var1.getAsInt();
         var3.v1();
         return var4;
      } catch (Throwable var5) {
         var3.v1(var5);
         return var2;
      }
   }

   public static double v1(String var0, DoubleSupplier var1, double var2) {
      uiSupport260 var4 = v1(var0);

      try {
         double var5 = var1.getAsDouble();
         var4.v1();
         return var5;
      } catch (Throwable var7) {
         var4.v1(var7);
         return var2;
      }
   }

   public static float v1(String var0, uiSupport259.Part1 var1, float var2) {
      uiSupport260 var3 = v1(var0);

      try {
         float var4 = var1.getAsFloat();
         var3.v1();
         return var4;
      } catch (Throwable var5) {
         var3.v1(var5);
         return var2;
      }
   }

   private static uiSupport260 v1(String var0) {
      uiSupport260 var1 = v1.get(var0);
      return var1 != null ? var1 : v1.computeIfAbsent(var0, uiSupport260::new);
   }

   @FunctionalInterface
   public interface Part1 {
      float getAsFloat();
   }
}
