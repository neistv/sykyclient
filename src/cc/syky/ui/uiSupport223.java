package cc.syky.ui;

import java.util.UUID;
import net.minecraft.class_2561;
import net.minecraft.class_310;
import org.jetbrains.annotations.Nullable;

public final class uiSupport223 {
   public static final String v1 = "Protected";
   private static final class_2561 v6 = class_2561.method_43470("Protected");
   public static boolean v2;
   public static boolean v3;
   public static boolean v4;
   public static boolean v5;

   private uiSupport223() {
   }

   public static class_2561 v1() {
      return v6;
   }

   @Nullable
   public static String v2() {
      class_310 var0 = class_310.method_1551();
      if (var0 == null) {
         return null;
      } else {
         String var1 = var0.method_1548().method_1676();
         return var1 != null && !var1.isEmpty() ? var1 : null;
      }
   }

   public static boolean v1(UUID var0) {
      return v2 && v3(var0);
   }

   public static boolean v2(UUID var0) {
      return v3 && v3(var0);
   }

   private static boolean v3(UUID var0) {
      if (var0 == null) {
         return false;
      } else {
         class_310 var1 = class_310.method_1551();
         return var1 != null && var0.equals(var1.method_1548().method_44717());
      }
   }
}
