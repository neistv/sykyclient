package cc.syky.cloud;

import org.jetbrains.annotations.Nullable;

public final class cloudSupport63 {
   @Nullable
   private static volatile cloudSupport63.Part1 v1;

   private cloudSupport63() {
   }

   public static void v1(@Nullable cloudSupport63.Part1 var0) {
      v1 = var0;
   }

   public static void v1(String var0, Throwable var1) {
      cloudSupport63.Part1 var2 = v1;
      if (var2 != null) {
         try {
            var2.v1(var0, var1);
         } catch (Throwable var4) {
         }
      }
   }

   public static void v1(String var0) {
      cloudSupport63.Part1 var1 = v1;
      if (var1 != null) {
         try {
            var1.v1(var0);
         } catch (Throwable var3) {
         }
      }
   }

   public static void v1(String var0, String var1) {
      cloudSupport63.Part1 var2 = v1;
      if (var2 != null) {
         try {
            var2.v1(var0, var1);
         } catch (Throwable var4) {
         }
      }
   }

   public interface Part1 {
      void v1(String var1, Throwable var2);

      void v1(String var1, String var2);

      default void v1(String var1) {
      }
   }
}
