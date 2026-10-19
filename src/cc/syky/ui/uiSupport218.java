package cc.syky.ui;

import net.minecraft.class_310;
import net.minecraft.class_418;
import net.minecraft.class_437;
import net.minecraft.class_638;
import net.minecraft.class_746;
import org.jetbrains.annotations.Nullable;

public final class uiSupport218 {
   public static boolean v1;
   private static final uiSupport217 v2 = new uiSupport217();
   @Nullable
   private static class_746 v3;
   @Nullable
   private static class_418 v4;
   private static boolean v5;

   private uiSupport218() {
   }

   public static boolean v1(class_310 var0, class_437 var1) {
      if (v1 && var1 instanceof class_418 var2) {
         class_746 var3 = var0.field_1724;
         class_638 var4 = var0.field_1687;
         if (var3 == null || var4 == null || var4.method_28104().method_152()) {
            return false;
         } else if (var0.field_1755 != null) {
            return false;
         } else {
            v1(var3, var2);
            v1(var3);
            return true;
         }
      } else {
         return false;
      }
   }

   public static void v1(class_310 var0) {
      class_746 var1 = var0.field_1724;
      if (v3 != null && v3 != var1) {
         v1();
      }

      if (var1 != null) {
         if (v3 == null) {
            if (!(var0.field_1755 instanceof class_418) || v3(var0)) {
               return;
            }

            v1(var1, null);
         }

         v2.v3();
         if (v2.v4()) {
            v1(var0, var1);
         } else {
            if (v2.v1() && var1.method_29504()) {
               v1(var1);
            }
         }
      }
   }

   public static void v2(class_310 var0) {
      v1 = false;
      if (var0 != null) {
         v2(var0, var0.field_1724);
      }

      v1();
   }

   private static void v1(class_746 var0, @Nullable class_418 var1) {
      v3 = var0;
      v4 = var1;
      v5 = false;
      v2.v5();
   }

   private static void v1(class_746 var0) {
      v2.v2();
      var0.method_7331();
   }

   private static void v1(class_310 var0, class_746 var1) {
      if (!v5) {
         v5 = true;
         v2(var0, var1);
      }
   }

   private static void v2(class_310 var0, class_746 var1) {
      class_418 var2 = v4;
      v4 = null;
      if (var2 != null && var1 != null && var1.method_29504() && var0.field_1755 == null) {
         var0.method_1507(var2);
      }
   }

   private static boolean v3(class_310 var0) {
      class_638 var1 = var0.field_1687;
      return var1 == null || var1.method_28104().method_152();
   }

   private static void v1() {
      v3 = null;
      v4 = null;
      v5 = false;
      v2.v5();
   }
}
