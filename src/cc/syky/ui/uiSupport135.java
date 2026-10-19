package cc.syky.ui;

import cc.syky.module.utilities.FogBlurSupport;

public final class uiSupport135 {
   private uiSupport135() {
   }

   public static String v1(String var0, String var1) {
      return FogBlurSupport.v1(var0, var1);
   }

   public static String v1(String var0) {
      return v1("module." + var0 + ".name", v2(var0));
   }

   public static String v2(String var0, String var1) {
      return var1 != null && !var1.isEmpty() ? v1(var1, "") : "";
   }

   public static String v3(String var0, String var1) {
      return v1("module." + var0 + ".setting." + var1 + ".name", v3(var1));
   }

   public static String v4(String var0, String var1) {
      return v1("module." + var0 + ".setting." + var1 + ".description", "");
   }

   private static String v2(String var0) {
      return var0.isEmpty() ? var0 : Character.toUpperCase(var0.charAt(0)) + var0.substring(1);
   }

   private static String v3(String var0) {
      if (var0.isEmpty()) {
         return var0;
      } else {
         StringBuilder var1 = new StringBuilder(var0.length() + 4);
         var1.append(Character.toUpperCase(var0.charAt(0)));

         for (int var2 = 1; var2 < var0.length(); var2++) {
            char var3 = var0.charAt(var2);
            if (Character.isUpperCase(var3)) {
               var1.append(' ').append(Character.toLowerCase(var3));
            } else {
               var1.append(var3);
            }
         }

         return var1.toString();
      }
   }
}
