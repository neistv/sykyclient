package cc.syky.ui;

public enum uiSupport105 {
   MODULE(39.0F, 21.0F, 10.5F, 17.0F, 17.0F, 8.5F, 2.0F),
   SETTINGS(39.0F, 21.0F, 10.5F, 17.0F, 17.0F, 8.5F, 2.0F);

   private final float width;
   private final float height;
   private final float radius;
   private final float knobWidth;
   private final float knobHeight;
   private final float knobRadius;
   private final float knobInset;

   private uiSupport105(float var3, float var4, float var5, float var6, float var7, float var8, float var9) {
      this.width = var3;
      this.height = var4;
      this.radius = var5;
      this.knobWidth = var6;
      this.knobHeight = var7;
      this.knobRadius = var8;
      this.knobInset = var9;
   }

   public float v1() {
      return this.width;
   }

   public float v2() {
      return this.height;
   }

   public float v3() {
      return this.radius;
   }

   public float v4() {
      return this.knobWidth;
   }

   public float v5() {
      return this.knobHeight;
   }

   public float v6() {
      return this.knobRadius;
   }

   public float v7() {
      return this.knobInset;
   }

   public int v8() {
      return SignInSupport.v53();
   }

   public int v9() {
      return SignInSupport.v59();
   }

   public int v10() {
      return SignInSupport.v64();
   }

   public int v11() {
      return SignInSupport.v63();
   }

   public boolean v12() {
      return true;
   }

   public int v13() {
      return SignInSupport.v66();
   }

   public int v14() {
      return SignInSupport.v68();
   }

   public boolean v15() {
      return true;
   }
}
