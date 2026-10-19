package cc.syky.ui;

import cc.syky.hud.hudSupport60;

public final class uiSupport129 {
   public static final float v1 = 280.0F;
   private static final float v2 = 0.035F;
   private static final float v3 = 0.994F;
   private static final float v4 = 11.0F;
   private static final float v5 = 0.015F;
   private static final float v6 = 0.2F;
   private static final float v7 = 0.4F;
   private static final float v8 = 0.37F;
   private static final float v9 = 0.5F;
   private static final float v10 = 0.01F;
   private float v11 = 1.0F;
   private float v12 = 1.0F;
   private float v13 = 1.0F;
   private float v14;
   private float v15;

   public uiSupport129() {
   }

   public float v1() {
      return this.v11;
   }

   public float v2() {
      return this.v12;
   }

   public float v3() {
      return this.v13;
   }

   public float v4() {
      return this.v14;
   }

   public float v5() {
      return this.v15;
   }

   public void v6() {
      this.v11 = 1.0F;
      this.v12 = 1.0F;
      this.v13 = 1.0F;
      this.v14 = 0.0F;
      this.v15 = 0.0F;
   }

   public boolean v7() {
      return this.v11 <= 0.01F;
   }

   public void v1(float var1, float var2) {
      float var3 = Math.clamp(var1, 0.0F, 1.0F);
      if (var3 >= 1.0F) {
         this.v6();
      } else {
         float var4 = v4(var3 - 0.37F, 0.63F);
         float var5 = v3(var4);
         this.v1(0.994F + 0.0059999824F * var5);
         this.v2(1.0F - var4);
         this.v15 = 0.035F * var2 * (1.0F - var5);
         this.v11 = hudSupport60.v2(v4(var4, 0.5F));
         this.v14 = 11.0F * (1.0F - var5);
      }
   }

   public void v2(float var1, float var2) {
      float var3 = v4(Math.clamp(var1, 0.0F, 1.0F), 0.4F);
      float var4 = hudSupport60.v5(var3);
      this.v1(1.0F - 0.0059999824F * var4);
      float var5 = Math.min(var3, 1.0F - var3);
      this.v2(4.0F * var5 * var5);
      this.v15 = -0.035F * var2 * var4;
      this.v11 = 1.0F - var3 * var3 * var3;
      this.v14 = 11.0F * var4;
   }

   public void v3(float var1, float var2) {
      this.v11 *= var1;
      this.v15 += var2;
   }

   private void v1(float var1) {
      this.v12 = var1;
      this.v13 = var1;
   }

   private void v2(float var1) {
      float var2 = Math.max(0.2F, 1.0F + 0.015F * var1);
      this.v13 *= var2;
      this.v12 /= var2;
   }

   private static float v3(float var0) {
      float var1 = 1.0F - var0;
      return 1.0F - var1 * var1;
   }

   private static float v4(float var0, float var1) {
      return Math.clamp(var0 / var1, 0.0F, 1.0F);
   }
}
