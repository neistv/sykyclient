package cc.syky.ui;

public abstract class uiSupport45 extends UiNode {
   private float v1;
   private boolean v2;

   public uiSupport45(float var1) {
      this.v1 = var1;
   }

   public final void v1(float var1) {
      this.v1 = var1;
   }

   public final float v13() {
      return this.v1;
   }

   public final void v5(boolean var1) {
      this.v2 = var1;
   }

   private uiRecord7 v1() {
      float var1 = this.v2() * this.v1;
      return uiRecord7.v1(var1);
   }

   @Override
   public final void v1(uiSupport35 var1) {
      float var2 = this.v12();
      if (this.v2) {
         uiSupport97.v1(this.v9, this.v10, this.v11, this.v12, this.v1(), this.v9());
      }

      uiSupport169.v1(
         this.v9,
         this.v10,
         this.v11,
         this.v12,
         var2 > 0.0F ? uiSupport155.v1(this.v3(), SignInSupport.v5(), var2) : this.v3(),
         SignInSupport.v1(var2 > 0.0F ? uiSupport155.v1(this.v10(), SignInSupport.v6(), var2) : this.v10(), this.v1),
         SignInSupport.v2(this.v1),
         1.0F,
         this.v1()
      );
      float var3 = this.v2(var1);
      if (var3 > 0.0F) {
         uiSupport169.v1(this.v9, this.v10, this.v11, this.v12, uiSupport155.v1(this.v11(), var3), this.v1());
      }

      this.v3(var1);
   }

   public float v2() {
      return 12.0F;
   }

   public int v9() {
      return 0;
   }

   public int v3() {
      return SignInSupport.v26();
   }

   public int v11() {
      return SignInSupport.v29();
   }

   public int v10() {
      return SignInSupport.v27();
   }

   public float v2(uiSupport35 var1) {
      return 0.0F;
   }

   public final void v1(float var1, float var2, float var3) {
      if (!(var3 <= 0.0F) && !(var2 <= var1)) {
         uiSupport169.v6(var1, this.v10, var2 - var1, this.v12);

         try {
            uiSupport169.v1(this.v9, this.v10, this.v11, this.v12, uiSupport155.v1(this.v11(), var3), this.v1());
         } finally {
            uiSupport169.v17();
         }
      }
   }

   public float v12() {
      return 0.0F;
   }

   public abstract void v3(uiSupport35 var1);

   public abstract void v3(float var1, float var2);
}
