package cc.syky.ui;

import cc.syky.hud.hudSupport57;

public abstract class UiWidget extends UiNode {
   public static final int v2 = 1;
   public static final int v3 = 2;
   public float v4;
   private final uiSupport99 v1;
   public float v5 = 1.0F;
   private float v7;
   private boolean v8;
   private boolean v13;
   private float v14 = 54.0F;
   public final hudSupport57 v6 = new hudSupport57(0.0F, 90.0F);
   private UiWidget.Part1 v15 = UiWidget.Part1.ALL;

   public UiWidget(float var1, boolean var2) {
      this.v4 = var1;
      this.v1 = new uiSupport99(var2);
   }

   public abstract String v2();

   public boolean v15() {
      return false;
   }

   public void v16() {
   }

   public void v18() {
   }

   public void v1(float var1) {
      this.v4 = var1;
   }

   public uiSupport99 v19() {
      return this.v1;
   }

   public boolean v17() {
      return this.v1.v1() && this.v1.v5() > 0.0F;
   }

   public void v2(float var1) {
      this.v7 = var1;
   }

   public void v3(float var1) {
      this.v14 = var1;
   }

   public float v20() {
      return this.v14;
   }

   public void v1(boolean var1, boolean var2) {
      this.v8 = var1;
      this.v13 = var2;
   }

   public void v2(uiSupport35 var1, float var2) {
      this.v1(var1, var2, UiWidget.Part1.ALL);
   }

   public void v1(uiSupport35 var1, float var2, UiWidget.Part1 var3) {
      this.v5 = var2;
      this.v15 = var3;
      boolean var4 = this.v12 < this.v14 * this.v4 - 0.5F;
      if (var4) {
         uiSupport169.v6(this.v9, this.v10, this.v11, this.v12);
      }

      try {
         this.v1(var1);
      } finally {
         this.v15 = UiWidget.Part1.ALL;
         if (var4) {
            uiSupport169.v17();
         }
      }
   }

   public float v21() {
      return 1.0F;
   }

   public final boolean v22() {
      return this.v15 != UiWidget.Part1.CONTENT;
   }

   public final boolean v24() {
      return this.v15 != UiWidget.Part1.BAND;
   }

   public final boolean v25() {
      return this.v15 == UiWidget.Part1.ALL && this.v21() < 1.0F;
   }

   public float v4(float var1) {
      return uiSupport169.v1(this.v10 + this.v12 / 2.0F, var1 * this.v4);
   }

   public void v5(float var1) {
      if (!(var1 <= 0.001F)) {
         float var2 = SignInSupport.v2(this.v4);
         float var3 = this.v10 + var2;
         float var4 = this.v10 + this.v12 - (this.v13 ? var2 : 0.0F);
         if (!(var4 <= var3)) {
            uiSupport169.v1(this.v9 + var2, var3, this.v11 - 2.0F * var2, var4 - var3, uiSupport155.v1(SignInSupport.v42(), var1 * this.v5), this.v6(var2));
         }
      }
   }

   private uiRecord7 v6(float var1) {
      if (!this.v8 && !this.v13) {
         return uiRecord7.ZERO;
      } else {
         float var2 = Math.max(0.0F, 18.0F * this.v4 - var1);
         if (this.v8 && this.v13) {
            return uiRecord7.v1(var2);
         } else {
            return this.v8 ? uiRecord7.v2(var2) : uiRecord7.v3(var2);
         }
      }
   }

   public void v26() {
      float var1 = this.v5 * this.v7;
      if (!(var1 <= 0.0F)) {
         float var2 = SignInSupport.v2(this.v4);
         float var3 = 16.0F * this.v4;
         uiSupport169.v1(
            this.v9 + var3,
            this.v10,
            this.v11 - 2.0F * var3,
            var2,
            uiSupport155.v1(SignInSupport.v1(SignInSupport.v46(), this.v4), var1),
            SignInSupport.v3(var2)
         );
      }
   }

   public void v1(uiSupport102 var1) {
      var1.v1(this);
      var1.v1(this.v9);
      var1.v1(this.v10);
      var1.v1(this.v11);
      var1.v1(this.v12);
      var1.v1(this.v1.v4());
      var1.v1(this.v7);
      var1.v1(this.v8);
      var1.v1(this.v13);
      var1.v1(this.v1.v1());
   }

   public boolean v2(float var1, float var2, int var3) {
      return this.v17() && this.v1(var1, var2) && (var3 == 1 || var3 == 2);
   }

   public static enum Part1 {
      ALL,
      BAND,
      CONTENT;

      private Part1() {
      }
   }
}
