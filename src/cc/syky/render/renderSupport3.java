package cc.syky.render;

public final class renderSupport3 {
   public static final int v1 = 256;
   public static final float v2 = 1.25F;
   public final double[] v3 = new double[256];
   public final double[] v4 = new double[256];
   public final double[] v5 = new double[256];
   public final float[] v6 = new float[256];
   public final float[] v7 = new float[256];
   public final float[] v8 = new float[256];
   public final float[] v9 = new float[256];
   public final float[] v10 = new float[256];
   private int v21;
   public int v11;
   public int v12;
   public float v13;
   public float v14;
   public float v15;
   public float v16;
   public float v18;
   public float v19;
   public float v17;
   public float v20;

   public renderSupport3() {
   }

   public int v1() {
      return this.v21;
   }

   public void v2() {
      this.v21 = 0;
   }

   public void v1(double var1, double var3, double var5, float var7, float var8, float var9, float var10, float var11) {
      if (this.v21 < 256) {
         this.v3[this.v21] = var1;
         this.v4[this.v21] = var3;
         this.v5[this.v21] = var5;
         this.v6[this.v21] = var7;
         this.v7[this.v21] = var8;
         this.v8[this.v21] = var9;
         this.v9[this.v21] = var10;
         this.v10[this.v21] = var11;
         this.v21++;
      }
   }

   public void v1(int var1, int var2, float var3, float var4, float var5, float var6, float var7, float var8, float var9, float var10) {
      this.v11 = var1;
      this.v12 = var2;
      this.v13 = var3;
      this.v14 = var4;
      this.v15 = var5;
      this.v16 = var6;
      this.v18 = var7;
      this.v19 = var8;
      this.v17 = var9;
      this.v20 = var10;
   }
}
