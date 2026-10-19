package cc.syky.internal;

import net.minecraft.class_310;
import net.minecraft.class_412;
import net.minecraft.class_437;
import net.minecraft.class_442;
import net.minecraft.class_500;
import net.minecraft.class_638;
import net.minecraft.class_639;
import net.minecraft.class_642;
import org.jetbrains.annotations.Nullable;

public final class InternalSupport55 {
   public static volatile boolean v1;
   public static volatile boolean v2;
   @Nullable
   private static class_639 v3;
   @Nullable
   private static class_642 v4;

   private InternalSupport55() {
   }

   public static void v1(class_639 var0, class_642 var1) {
      v3 = var0;
      v4 = var1;
   }

   @Nullable
   public static String v1() {
      class_639 var0 = v3;
      return var0 == null ? null : var0.method_2952();
   }

   public static boolean v2() {
      return v3 != null && v4 != null;
   }

   public static void v1(class_437 var0, class_310 var1) {
      class_639 var2 = v3;
      class_642 var3 = v4;
      if (var2 != null && var3 != null) {
         class_412.method_36877(var0, var1, var2, var3, false, null);
      }
   }

   public static boolean v1(class_310 var0) {
      class_642 var1 = var0.method_1558();
      return v2() && var1 != null && !var1.method_52811();
   }

   public static void v2(class_310 var0) {
      if (v1(var0)) {
         var0.method_73360(class_638.field_61021);
         Object var1 = var0.field_1755 != null ? var0.field_1755 : new class_500(new class_442());
         v1((class_437)var1, var0);
      }
   }
}
