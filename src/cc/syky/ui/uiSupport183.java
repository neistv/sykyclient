package cc.syky.ui;

import cc.syky.module.utilities.BackSupport;
import net.minecraft.class_310;
import net.minecraft.class_5498;
import org.jetbrains.annotations.Nullable;

public final class uiSupport183 {
   private static uiSupport183.Part1 v1 = uiSupport183.Part1.DORMANT;
   private static boolean v2 = true;
   private static boolean v3 = true;
   private static final uiSupport195 v4 = new uiSupport195();
   @Nullable
   private static class_5498 v5;

   private uiSupport183() {
   }

   public static void v1(boolean var0, boolean var1, BackSupport var2) {
      class_310 var3 = class_310.method_1551();
      v2 = var0;
      v3 = var1;
      if (v1 == uiSupport183.Part1.DORMANT) {
         v5 = var3.field_1690.method_31044();
      }

      v4.v1(var0 && v5 != null && v5.method_31034());
      uiSupport191.v1(var3, var2.v2());
      v1 = uiSupport183.Part1.ENGAGED;
   }

   public static void v1() {
      if (v1 != uiSupport183.Part1.DORMANT) {
         class_310 var0 = class_310.method_1551();
         if (var0 != null && v5 != null) {
            uiSupport191.v1(var0, v5);
         }

         v5 = null;
         v1 = uiSupport183.Part1.DORMANT;
         v4.v1();
      }
   }

   public static class_5498 v1(class_5498 var0) {
      return v1 != uiSupport183.Part1.DORMANT && var0.method_31034() ? class_5498.field_26665 : var0;
   }

   public static boolean v2() {
      return v1 == uiSupport183.Part1.ENGAGED;
   }

   public static void v1(boolean var0, boolean var1) {
      v2 = var0;
      v3 = var1;
   }

   public static double v3() {
      return v1 == uiSupport183.Part1.DORMANT ? 1.0 : v4.v2(v2);
   }

   public static boolean v1(double var0) {
      if (v1 == uiSupport183.Part1.ENGAGED && v3 && var0 != 0.0) {
         v4.v1(var0);
         return true;
      } else {
         return false;
      }
   }

   public static enum Part1 {
      DORMANT,
      ENGAGED;

      private Part1() {
      }
   }
}
