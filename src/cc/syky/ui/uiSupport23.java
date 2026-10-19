package cc.syky.ui;

import cc.syky.hud.hudSupport60;

public final class uiSupport23 {
   public static final float v1 = 0.46F;
   private static final float v3 = 1.6F;
   private static final float v4 = (float)(Math.atan2(1.0, -1.6F) / 0.46F);
   private static final float v5 = 1.6F * v4;
   private static final float v6 = 0.04F;
   private static final float v7 = 1.0F;
   public static final float v2 = 3.4F;
   private static final int v8 = 12;
   private static final float v9 = 0.2F;
   private static final float v10 = v7();
   private float v11 = 1.0F;
   private float v12 = 1.0F;
   private float v13 = 1.0F;
   private float v14 = 1.0F;
   private float v15;

   public uiSupport23() {
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
      this.v14 = 1.0F;
      this.v15 = 0.0F;
   }

   public void v1(float var1) {
      float var2 = var1 <= 0.0F ? 0.0F : (var1 >= 1.0F ? 1.0F : var1);
      if (var2 >= 1.0F) {
         this.v6();
      } else {
         float var3 = (float)Math.exp(-v5 * var2);
         float var4 = v4 * var2;
         float var5 = (float)Math.cos(var4);
         float var6 = (float)Math.sin(var4);
         float var7 = uiSupport5.v1(var2, 12, true);
         float var8 = var3 * (var5 + 1.6F * var6) * var7;
         float var9 = var3 * (v5 * 1.6F + v4) * var6 / v10 * var7 * v2(var2);
         this.v11 = Math.max(0.0F, 1.0F - var8);
         float var10 = Math.max(0.2F, 1.0F + 0.04F * var9);
         this.v14 = this.v11;
         this.v13 = this.v11 * var10;
         float var11 = Math.min(1.0F, this.v11);
         this.v12 = hudSupport60.v1(Math.min(1.0F, var11 / 1.0F));
         float var12 = 1.0F - var11;
         this.v15 = 3.4F * var12 * (float)Math.sqrt(var12);
      }
   }

   private static float v2(float var0) {
      return uiSupport5.v1(var0, 0.46F);
   }

   private static float v7() {
      double var0 = Math.atan2(v4, v5) / v4;
      double var2 = v5 * 1.6F + v4;
      return (float)(Math.exp(-v5 * var0) * var2 * Math.sin(v4 * var0));
   }
}
