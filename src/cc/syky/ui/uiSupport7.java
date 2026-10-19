package cc.syky.ui;

import cc.syky.hud.hudSupport60;

public final class uiSupport7 {
   public static final float v1 = 520.0F;
   public static final float v2 = 7.0F;
   public static final float v3 = 6.5F;
   private static final float v5 = 0.94F;
   private static final float v6 = 0.62F;
   private static final float v7 = 0.2F;
   private static final float v8 = 0.7F;
   private static final float v9 = 0.78F;
   private static final float v10 = 0.01F;
   public static final float v4 = 0.4F;
   private static final float v11 = 0.55F;
   private static final float v12 = 0.015F;
   private static final float v13 = 7.0F;
   private static final float v14 = 1.0F - 8.0F * (float)Math.exp(-7.0);
   private uiSupport7.Part1 v15 = uiSupport7.Part1.SPRING;
   private float v16 = 1.0F;
   private float v18 = 1.0F;
   private float v19 = 1.0F;
   private float v17 = 1.0F;
   private float v20;
   private float v21;

   public uiSupport7() {
   }

   public void v1(uiSupport7.Part1 var1) {
      this.v15 = var1;
   }

   public float v1() {
      return this.v16;
   }

   public float v2() {
      return this.v18;
   }

   public float v3() {
      return this.v19;
   }

   public float v4() {
      return this.v17;
   }

   public float v5() {
      return this.v20;
   }

   public float v6() {
      return this.v21;
   }

   public boolean v7() {
      return this.v19 <= 0.01F;
   }

   public void v8() {
      this.v16 = 1.0F;
      this.v18 = 1.0F;
      this.v19 = 1.0F;
      this.v17 = 1.0F;
      this.v20 = 0.0F;
      this.v21 = 0.0F;
   }

   public void v1(float var1) {
      float var2 = Math.clamp(var1, 0.0F, 1.0F);
      if (var2 >= 1.0F) {
         this.v8();
         this.v19 = 0.0F;
      } else {
         this.v4(var2);
         this.v21 = 7.0F;
         float var3 = Math.clamp(var2 / 0.62F, 0.0F, 1.0F);
         float var4 = 1.0F - var3;
         this.v19 = var4 * var4;
         this.v20 = 6.5F * (float)Math.sqrt(var3);
         this.v17 = 1.0F - 0.060000002F * var3;
      }
   }

   public void v2(float var1) {
      float var2 = Math.clamp(var1, 0.0F, 1.0F);
      if (var2 >= 1.0F) {
         this.v8();
      } else {
         this.v4(var2);
         this.v21 = 7.0F;
         if (var2 <= 0.2F) {
            this.v19 = 0.0F;
            this.v20 = 6.5F;
            this.v17 = 0.94F;
         } else {
            float var3 = Math.clamp((var2 - 0.2F) / 0.8F, 0.0F, 1.0F);
            this.v19 = hudSupport60.v2(v1(var3, 0.7F));
            float var4 = 1.0F - v1(var3, 0.78F);
            this.v20 = 6.5F * var4 * (float)Math.sqrt(var4);
            this.v17 = 0.94F + 0.060000002F * hudSupport60.v2(var3);
         }
      }
   }

   private void v4(float var1) {
      if (this.v15 == uiSupport7.Part1.GLIDE) {
         this.v18 = Math.min(1.0F, v3(var1));
         this.v16 = this.v18;
      } else {
         this.v18 = Math.min(1.0F, v5(Math.min(1.0F, var1 / 0.55F)));
         this.v16 = this.v18;
         if (!(var1 <= 0.55F)) {
            float var2 = (var1 - 0.55F) / 0.45F;
            float var3 = (float)Math.sin(Math.PI * var2);
            this.v16 = this.v18 + 0.015F * var3 * var3;
         }
      }
   }

   public static float v3(float var0) {
      float var1 = 7.0F * var0;
      return (1.0F - (1.0F + var1) * (float)Math.exp(-var1)) / v14;
   }

   private static float v5(float var0) {
      return var0 * var0 * var0 * (var0 * (var0 * 6.0F - 15.0F) + 10.0F);
   }

   private static float v1(float var0, float var1) {
      float var2 = var0 / var1;
      return var2 >= 1.0F ? 1.0F : var2;
   }

   public static enum Part1 {
      SPRING,
      GLIDE;

      private Part1() {
      }
   }
}
