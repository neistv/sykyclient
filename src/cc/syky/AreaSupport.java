package cc.syky;

import java.util.Collection;

public final class AreaSupport {
   public static final int v1 = 32;
   public static final String v2 = "Point";
   public static final String v3 = "Death";
   public static final String v4 = "Area";

   private AreaSupport() {
   }

   public static String v1(String var0) {
      if (var0 != null && !var0.isEmpty()) {
         StringBuilder var1 = new StringBuilder(Math.min(var0.length(), 32));
         int var2 = 0;
         boolean var3 = false;
         int var4 = 0;

         while (var4 < var0.length() && var2 < 32) {
            int var5 = var0.codePointAt(var4);
            var4 += Character.charCount(var5);
            if (!Character.isWhitespace(var5) && !Character.isSpaceChar(var5)) {
               if (!Character.isISOControl(var5) && Character.getType(var5) != 16) {
                  if (var3) {
                     if (var2 + 1 >= 32) {
                        break;
                     }

                     var1.append(' ');
                     var2++;
                     var3 = false;
                  }

                  var1.appendCodePoint(var5);
                  var2++;
               }
            } else {
               var3 = var1.length() > 0;
            }
         }

         return var1.toString();
      } else {
         return "";
      }
   }

   public static String v1(Collection<sykyRecord4> var0) {
      return v1("Point", var0);
   }

   public static String v2(Collection<sykyRecord4> var0) {
      return v1("Area", var0);
   }

   private static String v1(String var0, Collection<sykyRecord4> var1) {
      int var2 = 1;

      while (true) {
         String var3 = var0 + " " + var2;
         boolean var4 = false;

         for (sykyRecord4 var6 : var1) {
            if (var6.v5().equals(var3)) {
               var4 = true;
               break;
            }
         }

         if (!var4) {
            return var3;
         }

         var2++;
      }
   }

   public static String v3(Collection<sykyRecord4> var0) {
      String var1 = "Death ";
      int var2 = 0;

      for (sykyRecord4 var4 : var0) {
         String var5 = var4.v5();
         if (var5.startsWith(var1) && var5.length() > var1.length() && var5.length() <= var1.length() + 9) {
            try {
               var2 = Math.max(var2, Integer.parseInt(var5.substring(var1.length())));
            } catch (NumberFormatException var7) {
            }
         }
      }

      return var1 + (var2 + 1);
   }
}
