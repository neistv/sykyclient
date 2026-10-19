package cc.syky.cloud;

import org.jetbrains.annotations.Nullable;

public final class cloudSupport86 {
   public static final int v1 = 2000;
   public static final int v2 = 4096;
   public static final int v3 = 1024;
   public static final int v4 = 200;

   private cloudSupport86() {
   }

   public static String v1(String var0) {
      return v1(v1(var0, true, true), 2000, 4096);
   }

   @Nullable
   public static String v2(@Nullable String var0) {
      if (var0 == null) {
         return null;
      } else {
         String var1 = v1(v1(var0, true, false), 1024, Integer.MAX_VALUE);
         return var1.isEmpty() ? null : var1;
      }
   }

   public static String v3(String var0) {
      return v1(v1(var0, false, true), 200, Integer.MAX_VALUE);
   }

   private static String v1(String var0, boolean var1, boolean var2) {
      StringBuilder var3 = new StringBuilder(var0.length());
      var0.codePoints().forEach(var3x -> {
         if (var3x != 13) {
            if (var3x == 10 && var1) {
               var3.append('\n');
            } else if (Character.isISOControl(var3x)) {
               if (Character.isWhitespace(var3x)) {
                  var3.append(' ');
               }
            } else if (var3x != 167 || !var2) {
               var3.appendCodePoint(var3x);
            }
         }
      });
      return var3.toString().strip();
   }

   private static String v1(String var0, int var1, int var2) {
      int var3 = 0;
      int var4 = 0;
      int var5 = 0;

      while (var5 < var0.length()) {
         int var6 = var0.codePointAt(var5);
         int var7 = var6 < 128 ? 1 : (var6 < 2048 ? 2 : (var6 < 65536 ? 3 : 4));
         if (var3 == var1 || var4 + var7 > var2) {
            return var0.substring(0, var5).strip();
         }

         var3++;
         var4 += var7;
         var5 += Character.charCount(var6);
      }

      return var0;
   }
}
