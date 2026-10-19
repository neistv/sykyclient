package cc.syky.ui;

import cc.syky.cloud.cloudRecord5;
import cc.syky.hud.hudSupport57;
import java.util.function.BooleanSupplier;
import org.jetbrains.annotations.Nullable;

public abstract class uiSupport61 extends UiNode {
   private float v1 = 1.0F;
   private float v2 = 1.0F;
   private final hudSupport57 v3 = new hudSupport57(0.0F, 90.0F);
   @Nullable
   private uiSupport62 v4;
   @Nullable
   private uiSupport65 v5;
   @Nullable
   private BooleanSupplier v6;
   @Nullable
   private hudSupport57 v7;
   private final uiSupport50 v8 = new uiSupport50();
   private float v13 = Float.NaN;
   @Nullable
   private String v14;
   private float v15;
   @Nullable
   private uiSupport133 v16;

   public uiSupport61() {
   }

   public final void v1(float var1) {
      this.v1 = var1;
      this.v2(var1);
   }

   public void v2(float var1) {
   }

   public final float v9() {
      return this.v1;
   }

   public final void v3(float var1) {
      this.v2 = var1;
   }

   public final void v1(uiSupport62 var1) {
      this.v4 = var1;
   }

   private float v18() {
      return this.v4 == null ? 0.0F : 28.0F;
   }

   public final float v10() {
      return this.v2;
   }

   public final void v1(uiSupport65 var1, BooleanSupplier var2) {
      this.v5 = var1;
      this.v6 = var2;
      this.v7 = new hudSupport57(0.0F, 45.0F);
   }

   public final float v11() {
      return this.v5 == null ? 0.0F : 38.0F;
   }

   public final void v1(uiSupport35 var1, float var2, float var3) {
      if (this.v5 != null) {
         hudSupport57 var4 = this.v7;
         float var5 = 0.0F;
         if (var4 != null) {
            var4.v2(this.v1(var1.v1, var1.v2, var2) ? 1.0F : 0.0F);
            var5 = var4.v2();
         }

         boolean var6 = this.v6 != null && this.v6.getAsBoolean();
         int var7 = this.v8.v1(uiSupport111.v1(uiSupport110.SETTINGS, var3, var5), var6);
         uiSupport111.v1(uiSupport110.SETTINGS, this.v6(var2), this.v19(), this.v1, var7, this.v2);
      }
   }

   private float v6(float var1) {
      return var1 - 24.0F * this.v1;
   }

   private float v19() {
      return this.v5(6.0F * this.v1);
   }

   public final boolean v1(float var1, float var2, float var3) {
      return this.v5 != null && uiSupport111.v1(uiSupport110.SETTINGS, var1, var2, this.v6(var3), this.v19(), this.v1);
   }

   public final boolean v2(float var1, float var2, float var3) {
      uiSupport65 var4 = this.v5;
      if (var4 != null && this.v1(var1, var2, var3)) {
         var4.onControlClick(this.v6(var3), this.v19(), 24.0F * this.v1, 6.0F * this.v1, var1, var2);
         return true;
      } else {
         return false;
      }
   }

   public boolean v5() {
      return false;
   }

   public void v6() {
   }

   public boolean v1(int var1) {
      return false;
   }

   public boolean v4() {
      return false;
   }

   public abstract String v1();

   public int v12() {
      return SignInSupport.v37();
   }

   public float v13() {
      return 1.0F;
   }

   public abstract float v2();

   public final void v4(float var1) {
      this.v13 = var1;
   }

   public final float v3(float var1, float var2) {
      float var3 = var2 * this.v1;
      if (Float.isNaN(this.v13)) {
         return var3;
      } else {
         float var4 = this.v16() - var1 * this.v1;
         return Math.max(var3, var4 - (this.v9 + (this.v13 + this.v8()) * this.v1));
      }
   }

   public float v7() {
      return 0.0F;
   }

   public float v14() {
      return 0.0F;
   }

   public float v8() {
      return 0.0F;
   }

   public final float v15() {
      return this.v18() + Math.min(this.v17(), 134.0F);
   }

   private float v17() {
      String var1 = this.v1();
      if (!var1.equals(this.v14) || this.v15 <= 0.0F) {
         this.v14 = var1;
         this.v15 = uiSupport169.v2("syky_sans_strong", var1, 18.0F);
      }

      return this.v15;
   }

   public float v3() {
      return Float.NaN;
   }

   private float v20() {
      float var1 = 16.0F * this.v1;
      float var2 = (!Float.isNaN(this.v13) ? this.v9 + this.v13 * this.v1 : this.v16() - this.v2() * this.v1) - var1;
      float var3 = this.v3();
      return Float.isNaN(var3) ? var2 : Math.max(var2, var3 - var1);
   }

   private float v21() {
      return this.v9 + (10.0F + this.v18()) * this.v1;
   }

   public final float v16() {
      return this.v9 + this.v11 - 10.0F * this.v1;
   }

   public final float v5(float var1) {
      return uiSupport126.v1(this.v10, this.v12, var1, this.v22());
   }

   private float v22() {
      return SignInSupport.v4(47.0F, this.v1);
   }

   private float v24() {
      return uiSupport126.v1(this.v10, this.v12, this.v25(), this.v22());
   }

   private float v25() {
      return Math.min(this.v12, SignInSupport.v4(41.0F, this.v1));
   }

   private void v1(boolean var1) {
      this.v3.v2(var1 ? 1.0F : 0.0F);
      float var2 = this.v3.v2();
      if (!(var2 <= 0.001F)) {
         float var3 = this.v25();
         if (!(var3 <= 0.0F)) {
            uiSupport169.v1(
               this.v9,
               this.v24(),
               this.v11,
               var3,
               uiSupport155.v1(SignInSupport.v42(), var2 * this.v2),
               uiSupport155.v1(SignInSupport.v1(SignInSupport.v43(), this.v1), var2 * this.v2),
               SignInSupport.v2(this.v1),
               1.0F,
               uiRecord7.v1(12.0F * this.v1)
            );
         }
      }
   }

   @Override
   public final void v1(uiSupport35 var1) {
      boolean var2 = var1.v2() && this.v1(var1.v1, var1.v2);
      this.v1(var2);
      this.v26();
      this.v2(var2);
      this.v2(var1);
   }

   private void v2(boolean var1) {
      String var2 = this.v1();
      float var3 = this.v21();
      float var4 = uiSupport126.v2(this.v10, this.v12, this.v1);
      float var5 = 18.0F * this.v1;
      int var6 = uiSupport155.v1(this.v12(), this.v2);
      float var7 = this.v20();
      float var8 = this.v17() * this.v1 - (var7 - var3);
      if (!(var8 <= 0.0F) && !(this.v1 <= 0.0F)) {
         uiSupport133 var9 = this.v16;
         if (var9 == null) {
            var9 = new uiSupport133();
            this.v16 = var9;
         }

         float var10 = var9.v1(var1, var8 / this.v1, System.nanoTime()) * this.v1;
         cloudRecord5 var11 = uiSupport133.v1(var3, var7, var10, var8, 14.0F * this.v1);
         uiSupport169.v1("syky_sans_strong", var2, var3 - var10, var4, var5, var6, var11);
      } else {
         if (this.v16 != null) {
            this.v16.v1();
         }

         uiSupport169.v1("syky_sans_strong", var2, var3, var4, var5, var6);
      }
   }

   private void v26() {
      uiSupport62 var1 = this.v4;
      if (var1 != null) {
         float var2 = this.v2 * (0.5F + 0.5F * this.v13());
         var1.v1(this.v9 + 10.0F * this.v1, this.v10, this.v12, this.v1, var2);
      }
   }

   public abstract void v2(uiSupport35 var1);
}
