package cc.syky.hud;

public final class hudSupport65 {
   public static final int v1 = 32;
   private static final int v2 = 8;
   private final float[] v3 = new float[256];
   private int v4;

   public hudSupport65() {
   }

   public void v1() {
      this.v4 = 0;
   }

   public int v2() {
      return this.v4;
   }

   public boolean v3() {
      return this.v4 == 0;
   }

   public boolean v4() {
      return this.v4 == 32;
   }

   public boolean v1(float var1, float var2, float var3, float var4, float var5, float var6, float var7, float var8) {
      if (this.v4 == 32) {
         return false;
      } else {
         int var9 = this.v4 * 8;
         this.v3[var9] = var1;
         this.v3[var9 + 1] = var2;
         this.v3[var9 + 2] = var3;
         this.v3[var9 + 3] = var4;
         this.v3[var9 + 4] = var5;
         this.v3[var9 + 5] = Math.max(var6, 0.0F);
         this.v3[var9 + 6] = var7;
         this.v3[var9 + 7] = var8;
         this.v4++;
         return true;
      }
   }

   public boolean v1(hudSupport65 var1, int var2) {
      int var3 = var2 * 8;
      return this.v1(
         var1.v3[var3], var1.v3[var3 + 1], var1.v3[var3 + 2], var1.v3[var3 + 3], var1.v3[var3 + 4], var1.v3[var3 + 5], var1.v3[var3 + 6], var1.v3[var3 + 7]
      );
   }

   public float v1(int var1) {
      return this.v3[var1 * 8];
   }

   public float v2(int var1) {
      return this.v3[var1 * 8 + 1];
   }

   public float v3(int var1) {
      return this.v3[var1 * 8 + 2];
   }

   public float v4(int var1) {
      return this.v3[var1 * 8 + 3];
   }

   public float v5(int var1) {
      return this.v3[var1 * 8 + 4];
   }

   public float v6(int var1) {
      return this.v3[var1 * 8 + 5];
   }

   public float v7(int var1) {
      return this.v3[var1 * 8 + 6];
   }

   public float v8(int var1) {
      return this.v3[var1 * 8 + 7];
   }

   public boolean v9(int var1) {
      return this.v3[var1 * 8 + 5] > 0.0F;
   }

   public float v10(int var1) {
      float var2 = this.v3[var1 * 8 + 5];
      return var2 <= 0.0F ? 0.0F : 3.0F * var2 + Math.max(Math.abs(this.v3[var1 * 8 + 6]), Math.abs(this.v3[var1 * 8 + 7])) + 1.0F;
   }
}
