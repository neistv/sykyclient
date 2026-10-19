package cc.syky.ui;

import java.util.function.Predicate;
import org.jetbrains.annotations.Nullable;

public final class uiSupport198 {
   private static final int v1 = 32;

   private uiSupport198() {
   }

   @Nullable
   public static String v1(String var0, uiSupport197 var1, String var2, Predicate<String> var3) {
      if (!var0.isEmpty() && !var1.v1()) {
         String var4 = var1.v1(var0);
         if (var4.equals(var0)) {
            return null;
         } else if (var0.charAt(0) == '/') {
            return v1(var0, var4, var3);
         } else if (var4.charAt(0) == '/') {
            String var5 = v1(var4);
            return v2(var5) && var3.test(var5) ? var4 : null;
         } else {
            return !var2.isEmpty() && v1(var4, var2) ? var4 : null;
         }
      } else {
         return null;
      }
   }

   @Nullable
   private static String v1(String var0, String var1, Predicate<String> var2) {
      String var3 = v1(var0);
      String var4 = v1(var1);
      if (var3.equals(var4)) {
         return null;
      } else if (!v2(var4)) {
         return null;
      } else if (!v3(var3)) {
         return var1;
      } else {
         return var2.test(var4) && !var2.test(var3) ? var1 : null;
      }
   }

   private static String v1(String var0) {
      int var1 = var0.indexOf(32, 1);
      return var1 < 0 ? var0.substring(1) : var0.substring(1, var1);
   }

   private static boolean v2(String var0) {
      if (!var0.isEmpty() && var0.length() <= 32) {
         char var1 = var0.charAt(0);
         if (!v1(var1)) {
            return false;
         } else {
            for (int var2 = 1; var2 < var0.length(); var2++) {
               char var3 = var0.charAt(var2);
               boolean var4 = v1(var3) || var3 >= '0' && var3 <= '9' || var3 == '_' || var3 == '-' || var3 == '.' || var3 == ':';
               if (!var4) {
                  return false;
               }
            }

            return true;
         }
      } else {
         return false;
      }
   }

   private static boolean v1(char var0) {
      return var0 >= 'a' && var0 <= 'z' || var0 >= 'A' && var0 <= 'Z';
   }

   private static boolean v3(String var0) {
      for (int var1 = 0; var1 < var0.length(); var1++) {
         if (var0.charAt(var1) > 127) {
            return false;
         }
      }

      return true;
   }

   private static boolean v1(String var0, String var1) {
      return var0.equals(var1) || var0.length() > var1.length() && var0.startsWith(var1) && var0.charAt(var1.length()) == ' ';
   }
}
