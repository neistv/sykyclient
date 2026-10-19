package cc.syky.module.utilities;

import cc.syky.ui.uiSupport191;
import cc.syky.ui.uiSupport195;
import net.minecraft.class_310;
import net.minecraft.class_5498;
import org.jetbrains.annotations.Nullable;

public final class utilitiesSupport5 {
   private static boolean v1;
   private static boolean v2 = true;
   private static boolean v3;
   private static final uiSupport195 v4 = new uiSupport195();
   @Nullable
   private static class_5498 v5;
   @Nullable
   private static class_5498 v6;

   private utilitiesSupport5() {
   }

   public static void v1(class_310 var0, BackSupport var1, boolean var2, boolean var3) {
      v2 = var2;
      v3 = var3;
      if (var0 != null && var0.field_1724 != null && !Freelook.v17()) {
         class_5498 var4 = var0.field_1690.method_31044();
         if (!v1) {
            v5 = var4;
         }

         v4.v1(var2 && var4.method_31034());
         v1 = true;
         v1(var0, var1.v2());
      }
   }

   public static void v1(@Nullable class_310 var0) {
      if (v1) {
         class_5498 var1 = v5;
         class_5498 var2 = v6;
         v1 = false;
         v5 = null;
         v6 = null;
         v4.v1();
         if (var0 != null && var1 != null && var0.field_1690.method_31044() == var2) {
            uiSupport191.v1(var0, var1);
         }
      }
   }

   public static void v1(@Nullable class_310 var0, BackSupport var1) {
      if (v1 && var0 != null) {
         v1(var0, var1.v2());
      }
   }

   public static void v1(boolean var0, boolean var1) {
      v2 = var0;
      v3 = var1;
   }

   public static boolean v1() {
      if (v1 && v6 != null && !Freelook.v17()) {
         class_310 var0 = class_310.method_1551();
         return var0 != null && var0.field_1690.method_31044() == v6;
      } else {
         return false;
      }
   }

   public static double v2() {
      return v1() ? v4.v2(v2) : 1.0;
   }

   public static boolean v1(double var0) {
      if (v3 && var0 != 0.0 && v1()) {
         v4.v1(var0);
         return true;
      } else {
         return false;
      }
   }

   private static void v1(class_310 var0, class_5498 var1) {
      v6 = var1;
      uiSupport191.v1(var0, var1);
   }
}
