package cc.syky.ui;

import java.lang.Character.UnicodeScript;
import java.util.Set;
import java.util.function.Predicate;
import org.jetbrains.annotations.Nullable;

public final class IIISupport {
   private static final int v1 = 5;
   private static final int v2 = 6;
   private static final String v3 = "IVXLCDM";
   private static final Set<String> v4 = Set.of(
      "gg",
      "ggs",
      "ggwp",
      "wp",
      "ez",
      "glhf",
      "gl",
      "hf",
      "afk",
      "brb",
      "gtg",
      "idk",
      "idc",
      "imo",
      "tbh",
      "ngl",
      "smh",
      "wtf",
      "omg",
      "lol",
      "lmao",
      "rip",
      "xd",
      "ty",
      "thx",
      "pls",
      "plz",
      "np",
      "wts",
      "wtb",
      "lf",
      "dm"
   );
   private static final char v5 = '§';

   private IIISupport() {
   }

   @Nullable
   public static String v1(String var0, String var1, Predicate<String> var2) {
      if (v1(var0, var1)) {
         return null;
      } else {
         int[] var3 = v1(var0);
         int var4 = var3.length / 2;
         if (var4 == 0) {
            return null;
         } else {
            String[] var5 = new String[var4];

            for (int var6 = 0; var6 < var4; var6++) {
               var5[var6] = v1(var0, var3[var6 * 2], var3[var6 * 2 + 1]);
            }

            IIISupport.Part1 var20 = v1(var5);
            boolean[] var7 = new boolean[var4];
            int var8 = 0;
            int var9 = 0;
            int var10 = 0;
            int var11 = 0;
            int var12 = 0;
            int var13 = 0;
            boolean var14 = false;

            for (int var15 = 0; var15 < var4; var15++) {
               int var16 = var3[var15 * 2];
               int var17 = var3[var15 * 2 + 1];
               int var18 = var16;

               while (var18 < var17) {
                  int var19 = var0.codePointAt(var18);
                  var18 += Character.charCount(var19);
                  if (Character.isLetter(var19)) {
                     var10++;
                  }

                  if (v2(var19)) {
                     var8++;
                  } else if (v3(var19)) {
                     var9++;
                  }
               }

               if (!v1(var0, var16, var17, var5[var15], var20, var2)) {
                  if (v3(var0, var16, var17)) {
                     var7[var15] = true;
                     var12++;
                     var11 = Math.max(var11, v4(var0, var16, var17));
                     var14 |= v5(var0, var16, var17);
                  } else if (v6(var0, var16, var17)) {
                     var13++;
                  }
               }
            }

            boolean var21 = 2 * (var8 + var9) >= var10;
            boolean var22 = var12 == 1 && var13 == 0 && var14;
            if ((var12 < 2 || var12 < var13 + 2) && !var22) {
               return null;
            } else {
               return var11 >= 5 && var8 >= 6 && var8 > var9 && var21 ? v1(var0, var3, var7, var5) : null;
            }
         }
      }
   }

   private static boolean v1(String var0, String var1) {
      int var2 = 0;

      while (var2 < var0.length() && Character.isWhitespace(var0.charAt(var2))) {
         var2++;
      }

      if (var2 == var0.length()) {
         return true;
      } else {
         char var3 = var0.charAt(var2);
         if (var3 != '/' && var3 != '{') {
            return (var3 == '!' || var3 == '#') && var2 + 1 < var0.length() && Character.isLetter(var0.codePointAt(var2 + 1))
               ? true
               : !var1.isEmpty() && var0.regionMatches(true, var2, var1, 0, var1.length());
         } else {
            return true;
         }
      }
   }

   private static int[] v1(String var0) {
      int[] var1 = new int[var0.length() + 2];
      int var2 = 0;

      for (int var3 = 0; var3 < var0.length(); var1[var2++] = var3) {
         while (var3 < var0.length() && v1(var0.codePointAt(var3))) {
            var3 += Character.charCount(var0.codePointAt(var3));
         }

         if (var3 >= var0.length()) {
            break;
         }

         int var4 = var3;

         while (var3 < var0.length() && !v1(var0.codePointAt(var3))) {
            var3 += Character.charCount(var0.codePointAt(var3));
         }

         var1[var2++] = var4;
      }

      int[] var6 = new int[var2];
      System.arraycopy(var1, 0, var6, 0, var2);
      return var6;
   }

   private static boolean v1(int var0) {
      return Character.isWhitespace(var0) || Character.isSpaceChar(var0);
   }

   private static String v1(String var0, int var1, int var2) {
      StringBuilder var3 = new StringBuilder(var2 - var1);
      int var4 = var1;

      while (var4 < var2) {
         char var5 = var0.charAt(var4);
         if ((var5 == '&' || var5 == 167) && var4 + 1 < var2) {
            var4 += 2;
         } else {
            int var6 = var0.codePointAt(var4);
            var3.appendCodePoint(var6);
            var4 += Character.charCount(var6);
         }
      }

      var4 = 0;
      int var8 = var3.length();

      while (var4 < var8 && !Character.isLetterOrDigit(var3.codePointAt(var4))) {
         var4 += Character.charCount(var3.codePointAt(var4));
      }

      while (var8 > var4 && !Character.isLetterOrDigit(var3.codePointBefore(var8))) {
         var8 -= Character.charCount(var3.codePointBefore(var8));
      }

      return var3.substring(var4, var8);
   }

   @Nullable
   private static IIISupport.Part1 v1(String[] var0) {
      int var1 = 0;
      int var2 = 0;
      int var3 = 0;

      for (String var7 : var0) {
         IIISupport.Part1 var8 = v2(var7);
         if (var8 == IIISupport.Part1.CYRILLIC) {
            var1++;
         } else if (var8 == IIISupport.Part1.LATIN) {
            var2++;
         } else if (var8 == IIISupport.Part1.OTHER) {
            var3++;
         }
      }

      if (var1 > var2 && var1 > var3) {
         return IIISupport.Part1.CYRILLIC;
      } else if (var2 > var1 && var2 > var3) {
         return IIISupport.Part1.LATIN;
      } else {
         return var3 > var1 && var3 > var2 ? IIISupport.Part1.OTHER : null;
      }
   }

   @Nullable
   private static IIISupport.Part1 v2(String var0) {
      int var1 = 0;

      while (var1 < var0.length()) {
         int var2 = var0.codePointAt(var1);
         var1 += Character.charCount(var2);
         if (v4(var2)) {
            UnicodeScript var3 = UnicodeScript.of(var2);
            if (var3 == UnicodeScript.CYRILLIC) {
               return IIISupport.Part1.CYRILLIC;
            }

            return var3 == UnicodeScript.LATIN ? IIISupport.Part1.LATIN : IIISupport.Part1.OTHER;
         }
      }

      return null;
   }

   private static boolean v1(String var0, int var1, int var2, String var3, @Nullable IIISupport.Part1 var4, Predicate<String> var5) {
      int var6 = 0;

      while (var6 < var3.length()) {
         int var7 = var3.codePointAt(var6);
         var6 += Character.charCount(var7);
         if (Character.isDigit(var7)) {
            return true;
         }
      }

      for (int var8 = var1; var8 < var2; var8++) {
         char var10 = var0.charAt(var8);
         if (var10 == '_' || var10 == '/' || var10 == '\\' || var10 == ':' || var10 == '@') {
            return true;
         }

         if (var10 == '.'
            && var8 > var1
            && var8 + 1 < var2
            && Character.isLetterOrDigit(var0.charAt(var8 - 1))
            && Character.isLetterOrDigit(var0.charAt(var8 + 1))) {
            return true;
         }
      }

      if (v2(var0, var1, var2)) {
         return true;
      } else if (v3(var3)) {
         return true;
      } else if (!var3.isEmpty() && var5.test(var3)) {
         return true;
      } else {
         IIISupport.Part1 var9 = v2(var3);
         return var4 != null && var9 != null && var9 != var4;
      }
   }

   private static boolean v2(String var0, int var1, int var2) {
      int var3 = var1;

      while (var3 + 1 < var2 && (var0.charAt(var3) == '&' || var0.charAt(var3) == 167)) {
         var3 += 2;
      }

      return var3 < var2 - 1 && var0.charAt(var3) == '[' && var0.charAt(var2 - 1) == ']';
   }

   private static boolean v3(String var0) {
      return switch (var0) {
         case "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X" -> true;
         default -> false;
      };
   }

   private static boolean v3(String var0, int var1, int var2) {
      int var3 = 0;
      int var4 = 0;
      int var5 = 0;
      int var6 = -1;
      int var7 = var1;

      while (var7 < var2) {
         int var8 = var0.codePointAt(var7);
         var7 += Character.charCount(var8);
         if (v2(var8)) {
            var3++;
            var4++;
            var5++;
            var6 = var8;
            if (var3 >= 2) {
               return true;
            }
         } else {
            var3 = 0;
            if (v3(var8)) {
               var5++;
            }
         }
      }

      return var4 == 1 && var5 == 1 && "IVXLCDM".indexOf(var6) < 0;
   }

   private static int v4(String var0, int var1, int var2) {
      int var3 = 0;
      int var4 = 0;
      int var5 = var1;

      while (var5 < var2) {
         int var6 = var0.codePointAt(var5);
         var5 += Character.charCount(var6);
         if (v3(var6)) {
            var4 = 0;
         } else if (v2(var6)) {
            var3 = Math.max(var3, ++var4);
         }
      }

      return var3;
   }

   private static boolean v5(String var0, int var1, int var2) {
      int var3 = 1;
      int var4 = -1;
      int var5 = var1;

      while (var5 < var2) {
         int var6 = var0.codePointAt(var5);
         var5 += Character.charCount(var6);
         if (!v4(var6)) {
            var3 = 1;
            var4 = -1;
         } else {
            int var7 = Character.toLowerCase(var6);
            if (var7 == var4) {
               if (++var3 >= 3) {
                  return true;
               }
            } else {
               var3 = 1;
            }

            var4 = var7;
         }
      }

      return false;
   }

   private static String v4(String var0) {
      StringBuilder var1 = new StringBuilder(var0.length());
      int var2 = 0;

      while (var2 < var0.length()) {
         int var3 = var0.codePointAt(var2);
         int var4 = Character.charCount(var3);
         int var5 = 1;

         int var6;
         for (var6 = var2 + var4;
            var6 < var0.length() && Character.toLowerCase(var0.codePointAt(var6)) == Character.toLowerCase(var3);
            var6 += Character.charCount(var0.codePointAt(var6))
         ) {
            var5++;
         }

         var1.appendCodePoint(var3);
         if (var5 == 2) {
            var1.appendCodePoint(var3);
         }

         var2 = var6;
      }

      return var1.toString();
   }

   private static boolean v6(String var0, int var1, int var2) {
      int var3 = var1;

      while (var3 < var2) {
         int var4 = var0.codePointAt(var3);
         var3 += Character.charCount(var4);
         if (v3(var4)) {
            return true;
         }
      }

      return false;
   }

   @Nullable
   private static String v1(String var0, int[] var1, boolean[] var2, String[] var3) {
      StringBuilder var4 = new StringBuilder(var0);
      int var5 = var1.length / 2;

      for (int var6 = 0; var6 < var5; var6++) {
         if (var2[var6]) {
            int var7 = var1[var6 * 2];

            while (var7 < var1[var6 * 2 + 1]) {
               int var8 = var4.codePointAt(var7);
               int var9 = Character.charCount(var8);
               int var10 = Character.toLowerCase(var8);
               if (var10 != var8 && Character.charCount(var10) == var9) {
                  var4.replace(var7, var7 + var9, new String(Character.toChars(var10)));
               }

               var7 += var9;
            }
         }
      }

      boolean var11 = true;

      for (int var12 = 0; var12 < var5; var12++) {
         int var14 = var1[var12 * 2];
         int var15 = var1[var12 * 2 + 1];
         if (var11 && var2[var12] && !v4.contains(v4(v5(var3[var12])))) {
            v1(var4, var14, var15);
         }

         var11 = v2(var4, var14, var15);
      }

      String var13 = var4.toString();
      return !var13.equals(var0) && var13.length() == var0.length() ? var13 : null;
   }

   private static void v1(StringBuilder var0, int var1, int var2) {
      int var3 = var1;

      while (var3 + 1 < var2 && (var0.charAt(var3) == '&' || var0.charAt(var3) == 167)) {
         var3 += 2;
      }

      while (var3 < var2) {
         int var4 = var0.codePointAt(var3);
         int var5 = Character.charCount(var4);
         if (v4(var4)) {
            int var6 = Character.toUpperCase(var4);
            if (var6 != var4 && Character.charCount(var6) == var5) {
               var0.replace(var3, var3 + var5, new String(Character.toChars(var6)));
            }

            return;
         }

         var3 += var5;
      }
   }

   private static boolean v2(StringBuilder var0, int var1, int var2) {
      if (var2 <= var1) {
         return false;
      } else {
         char var3 = var0.charAt(var2 - 1);
         return var3 != '!' && var3 != '?' ? var3 == '.' && (var2 - 1 == var1 || var0.charAt(var2 - 2) != '.') : true;
      }
   }

   private static String v5(String var0) {
      StringBuilder var1 = new StringBuilder(var0.length());
      int var2 = 0;

      while (var2 < var0.length()) {
         int var3 = var0.codePointAt(var2);
         var2 += Character.charCount(var3);
         var1.appendCodePoint(Character.toLowerCase(var3));
      }

      return var1.toString();
   }

   private static boolean v2(int var0) {
      return Character.isLetter(var0) && (Character.isUpperCase(var0) || Character.isTitleCase(var0)) && Character.toLowerCase(var0) != var0;
   }

   private static boolean v3(int var0) {
      return Character.isLetter(var0) && Character.isLowerCase(var0) && Character.toUpperCase(var0) != var0;
   }

   private static boolean v4(int var0) {
      return v2(var0) || v3(var0);
   }

   public static enum Part1 {
      CYRILLIC,
      LATIN,
      OTHER;

      private Part1() {
      }
   }
}
