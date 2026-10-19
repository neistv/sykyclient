package cc.syky.hud;

import java.util.Arrays;

public final class hudSupport38 {
   private float[] v1 = new float[64];
   private int v2;

   public hudSupport38() {
   }

   public void v1() {
      this.v2 = 0;
   }

   public boolean v2() {
      return this.v2 == 0;
   }

   public void v1(float var1, float var2, float var3, float var4) {
      int var5 = 4 * this.v2;
      if (var5 + 4 > this.v1.length) {
         this.v1 = Arrays.copyOf(this.v1, this.v1.length * 2);
      }

      this.v1[var5] = var1;
      this.v1[var5 + 1] = var2;
      this.v1[var5 + 2] = var1 + var3;
      this.v1[var5 + 3] = var2 + var4;
      this.v2++;
   }

   public boolean v2(float var1, float var2, float var3, float var4) {
      float var5 = var1 + var3;
      float var6 = var2 + var4;

      for (int var7 = 0; var7 < this.v2; var7++) {
         int var8 = 4 * var7;
         if (var1 < this.v1[var8 + 2] && this.v1[var8] < var5 && var2 < this.v1[var8 + 3] && this.v1[var8 + 1] < var6) {
            return true;
         }
      }

      return false;
   }

   public boolean v3() {
      for (int var1 = 0; var1 < this.v2; var1++) {
         int var2 = 4 * var1;

         for (int var3 = var1 + 1; var3 < this.v2; var3++) {
            int var4 = 4 * var3;
            if (this.v1[var2] < this.v1[var4 + 2]
               && this.v1[var4] < this.v1[var2 + 2]
               && this.v1[var2 + 1] < this.v1[var4 + 3]
               && this.v1[var4 + 1] < this.v1[var2 + 3]) {
               return true;
            }
         }
      }

      return false;
   }
}
