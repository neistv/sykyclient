package cc.syky.ui;

import cc.syky.cloud.cloudSupport51;

public final class uiSupport255 {
   public static final int v1 = 128;
   private final String[] v2;
   private final int[] v3;
   private final cloudSupport51[] v4;
   private final float[] v5;
   private final float[] v6;

   public uiSupport255(String[] var1, int[] var2, cloudSupport51[] var3, float[] var4, float[] var5) {
      int var6 = var1.length;
      if (var6 <= 128 && var2.length == var6 && var3.length == var6 && var4.length == var6 * 3 && var5.length == var6 * 3) {
         for (int var7 = 0; var7 < var6; var7++) {
            int var8 = var2[var7];
            if (var8 >= var7 || var8 < -1) {
               throw new IllegalArgumentException("bone " + var7 + " has parent " + var8 + ": parents must come first");
            }

            if (var8 >= 0 && var3[var8] != var3[var7]) {
               throw new IllegalArgumentException("bone " + var1[var7] + " is anchored apart from its parent");
            }
         }

         for (int var9 = 0; var9 < var6 * 3; var9++) {
            if (!Float.isFinite(var4[var9]) || !Float.isFinite(var5[var9])) {
               throw new IllegalArgumentException("non-finite bone data");
            }
         }

         this.v2 = var1;
         this.v3 = var2;
         this.v4 = var3;
         this.v5 = var4;
         this.v6 = var5;
      } else {
         throw new IllegalArgumentException("inconsistent skeleton of " + var6 + " bones");
      }
   }

   public static uiSupport255 v1(cloudSupport51 var0) {
      return new uiSupport255(new String[]{"root"}, new int[]{-1}, new cloudSupport51[]{var0}, new float[3], new float[3]);
   }

   public int v1() {
      return this.v2.length;
   }

   public String v1(int var1) {
      return this.v2[var1];
   }

   public int v2(int var1) {
      return this.v3[var1];
   }

   public cloudSupport51 v3(int var1) {
      return this.v4[var1];
   }

   public float v1(int var1, int var2) {
      return this.v5[var1 * 3 + var2];
   }

   public float v2(int var1, int var2) {
      return this.v6[var1 * 3 + var2];
   }

   public int v1(String var1) {
      for (int var2 = 0; var2 < this.v2.length; var2++) {
         if (this.v2[var2].equals(var1)) {
            return var2;
         }
      }

      return -1;
   }

   public boolean v2(cloudSupport51 var1) {
      for (cloudSupport51 var5 : this.v4) {
         if (var5 == var1) {
            return true;
         }
      }

      return false;
   }
}
