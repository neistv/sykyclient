package cc.syky.ui;

import java.util.Arrays;

public final class uiSupport202 {
   public static final long v1 = 10000L;
   private static final int v2 = 6;
   private static final int v3 = 2;
   private static final int v4 = 8;
   private final String[] v5 = new String[8];
   private final long[] v6 = new long[8];
   private int v7;

   public uiSupport202() {
   }

   public void v1(String var1, long var2) {
      String var4 = var1.strip();
      if (!var4.isEmpty()) {
         if (var4.charAt(0) != '/') {
            this.v2(var4, var2);
         } else {
            int var5 = var4.indexOf(32);
            if (var5 >= 0) {
               String var6 = var4.substring(var5 + 1).strip();
               this.v2(var6, var2);
               int var7 = var6.indexOf(32);
               if (var7 > 0) {
                  this.v2(var6.substring(var7 + 1).strip(), var2);
               }
            }
         }
      }
   }

   public boolean v1(String var1, int[] var2, long var3) {
      String var5 = var1.stripTrailing();

      for (int var6 = 0; var6 < 8; var6++) {
         String var7 = this.v5[var6];
         if (var7 != null && var3 - this.v6[var6] <= 10000L) {
            int var8 = var5.length() - var7.length();
            if (var8 >= 0 && var5.regionMatches(true, var8, var7, 0, var7.length())) {
               for (byte var9 = 1; var9 < var2.length; var9 += 2) {
                  int var10 = var8 - var2[var9];
                  if (var10 >= 0 && var10 <= 6 && !v1(var5, var2[var9], var8)) {
                     this.v5[var6] = null;
                     return true;
                  }
               }
            }
         }
      }

      return false;
   }

   public void v1() {
      Arrays.fill(this.v5, null);
   }

   private void v2(String var1, long var2) {
      if (var1.length() >= 2) {
         this.v5[this.v7] = var1;
         this.v6[this.v7] = var2;
         this.v7 = (this.v7 + 1) % 8;
      }
   }

   private static boolean v1(String var0, int var1, int var2) {
      for (int var3 = var1; var3 < var2; var3++) {
         if (uiSupport193.v1(var0.charAt(var3))) {
            return true;
         }
      }

      return false;
   }
}
