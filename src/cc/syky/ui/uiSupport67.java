package cc.syky.ui;

import cc.syky.hud.hudSupport54;
import java.util.function.Supplier;

public final class uiSupport67 extends uiSupport61 {
   private final String v1;
   private final Supplier<String> v2;
   private final uiSupport65 v3;
   private final float v4;

   public uiSupport67(String var1, Supplier<String> var2, uiSupport65 var3, float var4) {
      this.v1 = var1;
      this.v2 = var2;
      this.v3 = var3;
      this.v4 = var4;
   }

   @Override
   public String v1() {
      return this.v1;
   }

   @Override
   public float v2() {
      return this.v4 + this.v11();
   }

   @Override
   public float v7() {
      return this.v4;
   }

   @Override
   public float v8() {
      return this.v11();
   }

   private float v18() {
      return this.v3(0.0F, this.v4);
   }

   private float v19() {
      return this.v16() - this.v18();
   }

   private float v17() {
      return this.v19() - 14.0F * this.v9();
   }

   @Override
   public float v3() {
      return this.v11() > 0.0F ? Float.NaN : uiSupport68.v1(this.v19(), this.v18(), this.v9(), this.v2.get());
   }

   @Override
   public void v2(uiSupport35 var1) {
      float var2 = this.v9();
      float var3 = this.v18();
      float var4 = SignInSupport.v4(30.0F, var2);
      this.v1(var1, this.v17(), 1.0F);
      uiSupport68.v1(this.v19(), this.v5(var4), var3, var4, var2, this.v2.get(), this.v10());
   }

   @Override
   public boolean v1(float var1, float var2, int var3) {
      if (var3 != 0 || !this.v1(var1, var2)) {
         return false;
      } else if (this.v2(var1, var2, this.v17())) {
         return true;
      } else {
         float var4 = this.v9();
         float var5 = this.v18();
         float var6 = SignInSupport.v4(30.0F, var4);
         float var7 = this.v19();
         float var8 = this.v5(var6);
         if (!uiSupport68.v1(var1, var2, var7, var8, var5, var6, var4, this.v2.get())) {
            return false;
         } else {
            if (this.v3 != null) {
               this.v3.onControlClick(var7, var8, var5, var6, var1, var2);
            }

            return true;
         }
      }
   }

   @Override
   public hudSupport54 v2(float var1, float var2) {
      if (!this.v1(var1, var2)) {
         return hudSupport54.ARROW;
      } else if (this.v1(var1, var2, this.v17())) {
         return hudSupport54.POINTER;
      } else {
         float var3 = this.v9();
         float var4 = this.v18();
         float var5 = SignInSupport.v4(30.0F, var3);
         return uiSupport68.v1(var1, var2, this.v19(), this.v5(var5), var4, var5, var3, this.v2.get()) ? hudSupport54.POINTER : hudSupport54.ARROW;
      }
   }
}
