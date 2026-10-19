package cc.syky.ui;

import cc.syky.hud.hudSupport54;
import java.util.function.IntSupplier;
import java.util.function.Supplier;
import org.jetbrains.annotations.Nullable;

public final class uiSupport66 extends uiSupport61 {
   private final String v1;
   private final IntSupplier v2;
   private final uiSupport65 v3;
   @Nullable
   private final Supplier<String> v4;
   @Nullable
   private final uiSupport65 v5;
   private final float v6;

   public uiSupport66(String var1, IntSupplier var2, uiSupport65 var3, @Nullable Supplier<String> var4, @Nullable uiSupport65 var5, float var6, float var7) {
      this.v1 = var1;
      this.v2 = var2;
      this.v3 = var3;
      this.v4 = var4;
      this.v5 = var5;
      this.v6 = Math.max(var6, 39.0F + uiSupport68.v1(var7));
   }

   @Override
   public String v1() {
      return this.v1;
   }

   @Override
   public float v2() {
      return this.v4 == null ? 24.0F : this.v6;
   }

   @Override
   public float v7() {
      return this.v4 == null ? 0.0F : this.v6;
   }

   private float v18() {
      return this.v3(0.0F, this.v6);
   }

   private float v4(float var1, float var2) {
      if (this.v4 != null) {
         float var3 = this.v18();
         return uiSupport68.v1(this.v16() - var3, var3, var1, this.v4.get()) - 15.0F * var1 - var2;
      } else {
         return this.v16() - var2;
      }
   }

   @Override
   public float v3() {
      float var1 = this.v9();
      return this.v4(var1, SignInSupport.v4(24.0F, var1));
   }

   @Override
   public void v2(uiSupport35 var1) {
      float var2 = this.v9();
      float var3 = this.v10();
      if (this.v4 != null) {
         float var4 = this.v18();
         float var5 = SignInSupport.v4(30.0F, var2);
         uiSupport68.v1(this.v16() - var4, this.v5(var5), var4, var5, var2, this.v4.get(), var3);
      }

      float var6 = SignInSupport.v4(24.0F, var2);
      uiSupport107.v1(this.v4(var2, var6), this.v5(var6), var2, this.v2.getAsInt(), var3);
   }

   @Override
   public boolean v1(float var1, float var2, int var3) {
      if (var3 == 0 && this.v1(var1, var2)) {
         float var4 = this.v9();
         float var5 = SignInSupport.v4(24.0F, var4);
         float var6 = this.v4(var4, var5);
         float var7 = this.v5(var5);
         if (uiSupport107.v1(var1, var2, var6, var7, var4)) {
            if (this.v3 != null) {
               this.v3.onControlClick(var6, var7, var5, var5, var1, var2);
            }

            return true;
         } else {
            if (this.v4 != null) {
               float var8 = this.v18();
               float var9 = SignInSupport.v4(30.0F, var4);
               float var10 = this.v16() - var8;
               float var11 = this.v5(var9);
               if (uiSupport68.v1(var1, var2, var10, var11, var8, var9, var4, this.v4.get())) {
                  if (this.v5 != null) {
                     this.v5.onControlClick(var10, var11, var8, var9, var1, var2);
                  }

                  return true;
               }
            }

            return false;
         }
      } else {
         return false;
      }
   }

   @Override
   public hudSupport54 v2(float var1, float var2) {
      if (!this.v1(var1, var2)) {
         return hudSupport54.ARROW;
      } else {
         float var3 = this.v9();
         float var4 = SignInSupport.v4(24.0F, var3);
         if (uiSupport107.v1(var1, var2, this.v4(var3, var4), this.v5(var4), var3)) {
            return hudSupport54.POINTER;
         } else {
            if (this.v4 != null) {
               float var5 = this.v18();
               float var6 = SignInSupport.v4(30.0F, var3);
               if (uiSupport68.v1(var1, var2, this.v16() - var5, this.v5(var6), var5, var6, var3, this.v4.get())) {
                  return hudSupport54.POINTER;
               }
            }

            return hudSupport54.ARROW;
         }
      }
   }
}
