package cc.syky.ui;

public final class uiSupport14 {
   public static final float v1 = 36.0F;
   public static final float v2 = 18.0F;
   public static final float v3 = 15.0F;
   public static final float v4 = 16.0F;
   public static final float v5 = 8.0F;
   public static final float v6 = 261.0F;
   public static final float v7 = 70.0F;
   public static final float v8 = 20.0F;
   public static final float v9 = 15.0F;
   public static final float v10 = 16.0F;
   public static final float v11 = 6.0F;
   public static final float v12 = 3.0F;
   public static final float v13 = 19.0F;
   public static final float v14 = 31.0F;
   public static final float v15 = 1.5F;
   public static final float v16 = 15.0F;
   public static final float v18 = 243.0F;
   public static final float v19 = 18.0F;
   public static final float v17 = 225.0F;
   public static final float v20 = 3.0F;
   public static final float v21 = 39.0F;
   public static final float v22 = 40.5F;
   public static final float v24 = 13.0F;
   public static final float v25 = 13.0F;
   public static final float v26 = 47.0F;

   private uiSupport14() {
   }

   public static float v1(float var0, float var1) {
      return var0 + 30.0F * var1;
   }

   public static float v2(float var0, float var1) {
      if (var1 > 0.0F && var0 > 0.0F) {
         float var2 = var0 / var1;
         return var2 > 1.0F ? 1.0F : var2;
      } else {
         return 0.0F;
      }
   }

   public static float v3(float var0, float var1) {
      return (18.0F + var0 * 225.0F) * var1;
   }

   public static float v1(float var0, float var1, float var2) {
      float var3 = var1 * 0.5F;
      float var4 = 15.0F * var2 + var3;
      float var5 = 246.0F * var2 - var3;
      if (var5 <= var4) {
         return 130.5F * var2;
      } else if (var0 < var4) {
         return var4;
      } else {
         return var0 > var5 ? var5 : var0;
      }
   }
}
