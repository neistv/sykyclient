package cc.syky.ui;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public final class uiSupport101 {
   private static final int v1 = 3;
   private static final int v2 = 4;
   private static final int v3 = 7;

   private uiSupport101() {
   }

   public static String v1(String var0) {
      if (var0 != null && !var0.isEmpty()) {
         StringBuilder var1 = new StringBuilder(var0.length());
         int var2 = 0;

         while (var2 < var0.length()) {
            int var3 = var0.codePointAt(var2);
            var2 += Character.charCount(var3);
            if (Character.isLetterOrDigit(var3)) {
               var1.appendCodePoint(Character.toLowerCase(var3));
            }
         }

         return var1.toString();
      } else {
         return "";
      }
   }

   public static uiSupport101.Part2 v1(String var0, uiSupport101.Part1 var1, uiSupport101.Part1 var2, uiSupport101.Part1 var3) {
      if (v1(var0, var1) || v1(var0, var2)) {
         return uiSupport101.Part2.NAMED;
      } else if (v1(var0, var3)) {
         return uiSupport101.Part2.GROUP;
      } else if (var0.length() < 3 || !var1.v1.contains(var0) && !var2.v1.contains(var0)) {
         return v2(var0, var1.v1) ? uiSupport101.Part2.TYPO : uiSupport101.Part2.NONE;
      } else {
         return uiSupport101.Part2.INSIDE;
      }
   }

   public static <T> List<T> v1(Iterable<T> var0, Function<T, uiSupport101.Part2> var1) {
      ArrayList var2 = new ArrayList();
      uiSupport101.Part2 var3 = uiSupport101.Part2.NONE;

      for (Object var5 : var0) {
         uiSupport101.Part2 var6 = (uiSupport101.Part2)var1.apply(var5);
         if (var6 != uiSupport101.Part2.NONE && var6.compareTo(var3) <= 0) {
            if (var6.compareTo(var3) < 0) {
               var3 = var6;
               var2.clear();
            }

            var2.add(var5);
         }
      }

      return var2;
   }

   public static boolean v1(String var0, String var1) {
      return var0.isEmpty() ? true : !var1.isEmpty() && (var1.contains(var0) || v2(var0, var1));
   }

   private static boolean v1(String var0, uiSupport101.Part1 var1) {
      if (var1.v1.isEmpty()) {
         return false;
      } else {
         for (int var5 : var1.v2) {
            if (var1.v1.startsWith(var0, var5)) {
               return true;
            }
         }

         return v1(var0, 0, var1, 0);
      }
   }

   private static boolean v1(String var0, int var1, uiSupport101.Part1 var2, int var3) {
      if (var1 == var0.length()) {
         return true;
      } else {
         for (int var4 = var3; var4 < var2.v2.length; var4++) {
            int var5 = var2.v2[var4];
            int var6 = var2.v1(var4);
            int var7 = 0;

            while (var1 + var7 < var0.length() && var5 + var7 < var6 && var0.charAt(var1 + var7) == var2.v1.charAt(var5 + var7)) {
               var7++;
            }

            for (int var8 = var7; var8 >= 1; var8--) {
               if (v1(var0, var1 + var8, var2, var4 + 1)) {
                  return true;
               }
            }
         }

         return false;
      }
   }

   private static boolean v2(String var0, String var1) {
      if (var0.length() >= 4 && !var1.isEmpty()) {
         int var2 = var0.length() >= 7 ? 2 : 1;
         return v3(var0, var1) <= var2;
      } else {
         return false;
      }
   }

   private static int v3(String var0, String var1) {
      int var2 = var0.length();
      int var3 = var1.length();
      int[] var4 = new int[var3 + 1];
      int[] var5 = new int[var3 + 1];
      int[] var6 = new int[var3 + 1];

      for (int var7 = 1; var7 <= var2; var7++) {
         var6[0] = var7;
         char var8 = var0.charAt(var7 - 1);

         for (int var9 = 1; var9 <= var3; var9++) {
            char var10 = var1.charAt(var9 - 1);
            int var11 = Math.min(var5[var9 - 1] + (var8 == var10 ? 0 : 1), Math.min(var6[var9 - 1] + 1, var5[var9] + 1));
            if (var7 > 1 && var9 > 1 && var8 == var1.charAt(var9 - 2) && var0.charAt(var7 - 2) == var10) {
               var11 = Math.min(var11, var4[var9 - 2] + 1);
            }

            var6[var9] = var11;
         }

         int[] var14 = var4;
         var4 = var5;
         var5 = var6;
         var6 = var14;
      }

      int var12 = Integer.MAX_VALUE;

      for (int var13 = 0; var13 <= var3; var13++) {
         var12 = Math.min(var12, var5[var13]);
      }

      return var12;
   }

   public static final class Part1 {
      public final String v1;
      public final int[] v2;

      private Part1(String var1, int[] var2) {
         this.v1 = var1;
         this.v2 = var2;
      }

      public static uiSupport101.Part1 v1(String var0) {
         if (var0 != null && !var0.isEmpty()) {
            StringBuilder var1 = new StringBuilder(var0.length());
            ArrayList var2 = new ArrayList();
            int var3 = -1;
            boolean var4 = true;
            int var5 = 0;

            while (var5 < var0.length()) {
               int var6 = var0.codePointAt(var5);
               var5 += Character.charCount(var6);
               if (!Character.isLetterOrDigit(var6)) {
                  var4 = true;
               } else {
                  int var7 = var5 < var0.length() ? var0.codePointAt(var5) : -1;
                  boolean var8 = var4
                     || Character.isUpperCase(var6) && Character.isLowerCase(var3)
                     || Character.isUpperCase(var6) && Character.isUpperCase(var3) && Character.isLowerCase(var7)
                     || Character.isDigit(var6) != Character.isDigit(var3);
                  if (var8) {
                     var2.add(var1.length());
                  }

                  var1.appendCodePoint(Character.toLowerCase(var6));
                  var3 = var6;
                  var4 = false;
               }
            }

            int[] var9 = new int[var2.size()];

            for (int var10 = 0; var10 < var9.length; var10++) {
               var9[var10] = (Integer)var2.get(var10);
            }

            return new uiSupport101.Part1(var1.toString(), var9);
         } else {
            return new uiSupport101.Part1("", new int[0]);
         }
      }

      public int v1(int var1) {
         return var1 + 1 < this.v2.length ? this.v2[var1 + 1] : this.v1.length();
      }
   }

   public static enum Part2 {
      NAMED,
      GROUP,
      INSIDE,
      TYPO,
      NONE;

      private Part2() {
      }
   }
}
