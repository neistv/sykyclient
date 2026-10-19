package cc.syky.ui;

import java.util.Arrays;
import java.util.Locale;
import org.jetbrains.annotations.Nullable;

public final class uiSupport193 {
   public static final int v1 = 64;
   public static final int v2 = -1;
   public static final int[] v3 = new int[0];
   private static final int v4 = 4;
   private static final int v5 = 40;
   private static final int v6 = 4;
   private static final int v7 = 16;

   private uiSupport193() {
   }

   public static int[] v1(String var0, String var1) {
      int var2 = var1.length();
      if (var2 != 0 && var0.length() >= var2) {
         int[] var3 = v3;
         int var4 = 0;

         for (int var5 = 0; var5 + var2 <= var0.length(); var5++) {
            if (var0.regionMatches(true, var5, var1, 0, var2)
               && (var5 <= 0 || !v1(var0.charAt(var5 - 1)))
               && (var5 + var2 >= var0.length() || !v1(var0.charAt(var5 + var2)))) {
               if (var4 + 2 > var3.length) {
                  var3 = Arrays.copyOf(var3, Math.max(4, var3.length * 2));
               }

               var3[var4++] = var5;
               var3[var4++] = var5 + var2;
               var5 += var2 - 1;
            }
         }

         return var4 == var3.length ? var3 : Arrays.copyOf(var3, var4);
      } else {
         return v3;
      }
   }

   public static uiSupport193.Part1 v1(String var0) {
      return (var1, var2, var3) -> var3 - var2 == var0.length() && var1.regionMatches(true, var2, var0, 0, var0.length());
   }

   public static int v1(String var0, uiSupport193.Part1 var1) {
      int var2 = Math.min(var0.length(), 64);
      int var3 = 0;
      int var4 = 0;

      while (var4 <= 4 && var3 < var2) {
         char var5 = var0.charAt(var3);
         if (v1(var5)) {
            int var9 = v1(var0, var3);
            if (!v1(var0, var3, var9)) {
               return var1.is(var0, var3, var9) ? var3 : -1;
            }

            var3 = var9;
            var4++;
         } else {
            int var6 = var5 == '[' ? 93 : (var5 == '(' ? 41 : (var5 == '{' ? 125 : -1));
            if (var6 < 0) {
               var3++;
            } else {
               int var7 = var0.indexOf(var6, var3 + 1);
               if (var7 >= 0 && var7 - var3 <= 40) {
                  int var8 = var3 + 1;

                  while (var8 < var7 && !v1(var0.charAt(var8))) {
                     var8++;
                  }

                  if (var8 < var7 && var1.is(var0, var8, v1(var0, var8))) {
                     return var8;
                  }

                  var3 = var7 + 1;
                  var4++;
               } else {
                  var3++;
               }
            }
         }
      }

      return -1;
   }

   public static int v2(String var0, uiSupport193.Part1 var1) {
      int var2 = Math.min(var0.length(), 64);

      for (int var3 = 1; var3 < var2; var3++) {
         if (v2(var0.charAt(var3)) && (var3 + 1 >= var0.length() || var0.charAt(var3 + 1) == ' ')) {
            int var4 = var3 - 1;

            for (int var5 = 0; var4 >= 0 && !v1(var0.charAt(var4)) && var5 < 4; var5++) {
               var4--;
            }

            if (var4 >= 0 && v1(var0.charAt(var4))) {
               int var6 = var4;

               while (var6 > 0 && v1(var0.charAt(var6 - 1))) {
                  var6--;
               }

               return var1.is(var0, var6, var4 + 1) ? var6 : -1;
            } else {
               return -1;
            }
         }
      }

      return -1;
   }

   @Nullable
   public static String v2(String var0) {
      int var1 = var0.startsWith("/") ? 1 : 0;
      int var2 = var0.indexOf(32, var1);
      if (var2 >= 0 && v4(var0.substring(var1, var2))) {
         int var3 = var2 + 1;

         while (var3 < var0.length() && var0.charAt(var3) == ' ') {
            var3++;
         }

         int var4 = v1(var0, var3);
         boolean var5 = var4 == var0.length() || var0.charAt(var4) == ' ';
         return var5 && v1(var4 - var3) ? var0.substring(var3, var4) : null;
      } else {
         return null;
      }
   }

   public static boolean v3(String var0) {
      return v1(var0.length()) && v1(var0, 0) == var0.length();
   }

   public static boolean v1(char var0) {
      return var0 >= 'a' && var0 <= 'z' || var0 >= 'A' && var0 <= 'Z' || var0 >= '0' && var0 <= '9' || var0 == '_';
   }

   public static int v1(String var0, int var1) {
      int var2 = var1;

      while (var2 < var0.length() && v1(var0.charAt(var2))) {
         var2++;
      }

      return var2;
   }

   private static boolean v4(String var0) {
      String var1 = var0.toLowerCase(Locale.ROOT);

      return switch (var1) {
         case "msg", "tell", "w", "whisper", "m", "pm", "dm", "message" -> true;
         default -> false;
      };
   }

   private static boolean v1(int var0) {
      return var0 >= 1 && var0 <= 16;
   }

   private static boolean v2(char var0) {
      return var0 == ':' || var0 == '>' || var0 == '|' || var0 == 187 || var0 == 8250 || var0 == 8594 || var0 == 10140;
   }

   private static boolean v1(String var0, int var1, int var2) {
      for (int var3 = var1; var3 < var2; var3++) {
         char var4 = var0.charAt(var3);
         if (var4 < '0' || var4 > '9') {
            return false;
         }
      }

      return true;
   }

   @FunctionalInterface
   public interface Part1 {
      boolean is(String var1, int var2, int var3);
   }
}
