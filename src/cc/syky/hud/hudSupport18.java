package cc.syky.hud;

import cc.syky.ui.uiSupport5;

public final class hudSupport18 {
   private static final float v3 = 0.74F;
   public static final float v1 = 2.6F;
   private static final float v4 = 0.13F;
   private static final float v5 = 0.42F;
   private static final float v6 = 5.4F;
   private static final float v7 = 3.4F;
   public static final float v2 = 0.4619989F;
   private static final float v8 = 0.4619989F;
   private static final int v9 = 12;
   private static final float v10 = 0.2F;
   private static final float v11 = 0.34F;
   private final uiSupport5 v12 = new uiSupport5(5.4F, 3.4F, 12, true);
   private float v13 = 1.0F;
   private float v14 = 1.0F;
   private float v15 = 1.0F;
   private float v16 = 1.0F;
   private float v18 = 1.0F;
   private float v19;

   public hudSupport18() {
   }

   public float v1() {
      return this.v13;
   }

   public float v2() {
      return this.v15;
   }

   public float v3() {
      return this.v14;
   }

   public float v4() {
      return this.v16;
   }

   public float v5() {
      return this.v18;
   }

   public float v6() {
      return this.v19;
   }

   public void v7() {
      this.v13 = 1.0F;
      this.v14 = 1.0F;
      this.v15 = 1.0F;
      this.v16 = 1.0F;
      this.v18 = 1.0F;
      this.v19 = 0.0F;
   }

   public void v1(float var1) {
      float var2 = var1 <= 0.0F ? 0.0F : (var1 >= 1.0F ? 1.0F : var1);
      if (var2 >= 1.0F) {
         this.v7();
      } else {
         this.v12.v1(var2);
         float var3 = this.v12.v1();
         float var4 = this.v12.v2() * v2(var2);
         this.v13 = Math.max(0.0F, 1.0F - var3);
         this.v14 = hudSupport60.v1(Math.min(1.0F, this.v13 / 0.34F));
         float var5 = 1.0F - 0.26F * var3;
         float var6 = Math.max(0.2F, 1.0F + 0.13F * var4);
         this.v16 = var5 * var6;
         this.v18 = var5 / var6;
         this.v15 = hudSupport60.v2(uiSupport5.v2(var2, 0.42F));
         float var7 = 1.0F - uiSupport5.v2(var2, 0.4619989F);
         this.v19 = 2.6F * var7 * (float)Math.sqrt(var7);
      }
   }

   private static float v2(float var0) {
      return uiSupport5.v1(var0, 0.4619989F);
   }
}
