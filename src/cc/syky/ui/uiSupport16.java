package cc.syky.ui;

import cc.syky.hud.hudSupport60;

public final class uiSupport16 {
   private static final float v2 = 0.42F;
   public static final float v1 = 3.0F;
   private static final float v3 = 0.22F;
   private static final float v4 = 0.38F;
   private static final float v5 = 0.58F;
   private static final float v6 = 4.4F;
   private static final float v7 = 5.0F;
   private static final int v8 = 8;
   private static final float v9 = 0.2F;
   private final uiSupport5 v10 = new uiSupport5(4.4F, 5.0F, 8, false);
   private float v11 = 1.0F;
   private float v12 = 1.0F;
   private float v13 = 1.0F;
   private float v14;

   public uiSupport16() {
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

   public void v5() {
      this.v11 = 1.0F;
      this.v12 = 1.0F;
      this.v13 = 1.0F;
      this.v14 = 0.0F;
   }

   public void v1(float var1) {
      float var2 = var1 <= 0.0F ? 0.0F : (var1 >= 1.0F ? 1.0F : var1);
      if (var2 >= 1.0F) {
         this.v5();
      } else {
         this.v10.v1(var2);
         float var3 = this.v10.v1();
         float var4 = this.v10.v2();
         float var5 = 1.0F - 0.58000004F * var3;
         float var6 = Math.max(0.2F, 1.0F + 0.22F * var4);
         this.v12 = var5 * var6;
         this.v13 = var5 / var6;
         this.v11 = hudSupport60.v2(uiSupport5.v2(var2, 0.38F));
         float var7 = 1.0F - uiSupport5.v2(var2, 0.58F);
         this.v14 = 3.0F * var7 * (float)Math.sqrt(var7);
      }
   }
}
