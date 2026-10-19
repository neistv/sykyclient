package cc.syky.hud;

import java.util.HashSet;
import java.util.Locale;
import java.util.Set;
import org.jetbrains.annotations.Nullable;

public final class hudSupport63 {
   public static final String v1 = ".syky";
   public static final int v2 = 48;
   private static final String v3 = "-_.()[]+";
   private static final Set<String> v4 = v1();

   private hudSupport63() {
   }

   private static Set<String> v1() {
      HashSet var0 = new HashSet<>(Set.of("con", "prn", "aux", "nul"));

      for (int var1 = 1; var1 <= 9; var1++) {
         var0.add("com" + var1);
         var0.add("lpt" + var1);
      }

      return Set.copyOf(var0);
   }

   public static boolean v1(String var0) {
      if (var0 == null) {
         return false;
      } else {
         int var1 = var0.length();
         if (var1 != 0 && var1 <= 48) {
            char var2 = var0.charAt(0);
            char var3 = var0.charAt(var1 - 1);
            if (var2 == '_' || var2 == ' ' || var2 == '.' || var3 == ' ' || var3 == '.') {
               return false;
            } else if (var0.contains("..")) {
               return false;
            } else {
               for (int var4 = 0; var4 < var1; var4++) {
                  if (!v1(var0.charAt(var4))) {
                     return false;
                  }
               }

               String var7 = var0.toLowerCase(Locale.ROOT);
               int var5 = var7.indexOf(46);
               String var6 = var5 < 0 ? var7 : var7.substring(0, var5);
               return !v4.contains(var7) && !v4.contains(var6);
            }
         } else {
            return false;
         }
      }
   }

   private static boolean v1(char var0) {
      if (var0 >= 'a' && var0 <= 'z') {
         return true;
      } else if (var0 >= 'A' && var0 <= 'Z') {
         return true;
      } else if (var0 >= '0' && var0 <= '9') {
         return true;
      } else {
         return var0 == ' ' ? true : "-_.()[]+".indexOf(var0) >= 0;
      }
   }

   @Nullable
   public static String v2(String var0) {
      if (var0 != null && var0.endsWith(".syky")) {
         String var1 = var0.substring(0, var0.length() - ".syky".length());
         return v1(var1) ? var1 : null;
      } else {
         return null;
      }
   }

   public static String v3(String var0) {
      return var0 + ".syky";
   }
}
