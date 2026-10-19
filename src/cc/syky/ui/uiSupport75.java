package cc.syky.ui;

import cc.syky.hud.hudSupport54;

public final class uiSupport75 extends UiScreen {
   private final uiSupport80 v1;
   private final float v2;

   public uiSupport75(uiSupport80 var1) {
      this.v1 = var1;
      this.v2 = var1.v3(0.0F);
   }

   public float v1() {
      return this.v1.v4();
   }

   public static float v5() {
      return 14.0F;
   }

   @Override
   public float v2() {
      return this.v2;
   }

   @Override
   public float a_(float var1) {
      return this.v1.v3();
   }

   @Override
   public void v2(float var1) {
      this.v1.v2(var1);
   }

   @Override
   public void v11() {
      this.v1.v1(this.v9, this.v10, this.v11, this.v12);
   }

   @Override
   public void v1(uiSupport35 var1) {
      this.v1.v1(this.v9, this.v10, this.v11, this.v12);
      this.v1.v1(var1);
   }

   @Override
   public boolean v1(float var1, float var2) {
      return this.v1.v1(var1, var2);
   }

   @Override
   public boolean v1(float var1, float var2, int var3) {
      return this.v1.v1(var1, var2, var3);
   }

   @Override
   public boolean v1(float var1, float var2, int var3, float var4, float var5) {
      return this.v1.v1(var1, var2, var3, var4, var5);
   }

   @Override
   public boolean v4(float var1, float var2, int var3) {
      return this.v1.v4(var1, var2, var3);
   }

   @Override
   public boolean v1(float var1, float var2, double var3, double var5) {
      return this.v1.v1(var1, var2, var3, var5);
   }

   @Override
   public hudSupport54 v2(float var1, float var2) {
      return this.v1.v2(var1, var2);
   }
}
