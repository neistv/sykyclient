package cc.syky.ui;

import cc.syky.hud.hudSupport54;
import cc.syky.hud.hudSupport57;
import java.util.function.BooleanSupplier;
import java.util.function.IntSupplier;
import java.util.function.Supplier;
import org.jetbrains.annotations.Nullable;

public final class uiSupport57 extends uiSupport61 {
   private final String v1;
   private final BooleanSupplier v2;
   private final Runnable v3;
   private final hudSupport57 v4;
   @Nullable
   private final IntSupplier v5;
   @Nullable
   private final uiSupport65 v6;
   @Nullable
   private final uiSupport60 v7;
   @Nullable
   private final uiSupport64 v8;
   @Nullable
   private final Supplier<String> v13;
   @Nullable
   private final uiSupport65 v14;

   public uiSupport57(String var1, BooleanSupplier var2, Runnable var3) {
      this(var1, var2, var3, null, null, null, null, null, null);
   }

   public uiSupport57(
      String var1,
      BooleanSupplier var2,
      Runnable var3,
      @Nullable IntSupplier var4,
      @Nullable uiSupport65 var5,
      @Nullable uiSupport60 var6,
      @Nullable uiSupport64 var7,
      @Nullable Supplier<String> var8,
      @Nullable uiSupport65 var9
   ) {
      if ((var6 != null ? 1 : 0) + (var7 != null ? 1 : 0) + (var8 != null ? 1 : 0) > 1) {
         throw new IllegalArgumentException("a toggle row carries one stretchable guest, not two: " + var1);
      } else {
         this.v1 = var1;
         this.v2 = var2;
         this.v3 = var3;
         this.v5 = var4;
         this.v6 = var5;
         this.v7 = var6;
         this.v8 = var7;
         this.v13 = var8;
         this.v14 = var9;
         this.v4 = new hudSupport57(var2.getAsBoolean() ? 1.0F : 0.0F, 55.0F);
      }
   }

   @Override
   public float v2() {
      float var1 = this.v7() > 0.0F ? this.v7() + this.v14() : 39.0F + this.v11();
      if (this.v5 != null) {
         var1 += 39.0F;
      }

      return var1;
   }

   @Override
   public float v7() {
      if (this.v7 != null) {
         return this.v7.v1();
      } else if (this.v8 != null) {
         return this.v8.v1();
      } else {
         return this.v13 != null ? 82.0F : 0.0F;
      }
   }

   @Override
   public float v14() {
      if (this.v7 != null) {
         return this.v7.v2() + 15.0F + this.v11() + 39.0F;
      } else {
         return this.v8 == null && this.v13 == null ? 0.0F : 15.0F + this.v11() + 39.0F;
      }
   }

   @Override
   public float v8() {
      return this.v5 != null && this.v7() > 0.0F ? 39.0F : 0.0F;
   }

   @Override
   public String v1() {
      return this.v1;
   }

   private float v18() {
      this.v4.v2(this.v2.getAsBoolean() ? 1.0F : 0.0F);
      return this.v4.v2();
   }

   @Override
   public float v13() {
      return this.v18();
   }

   @Override
   public int v12() {
      return uiSupport155.v1(SignInSupport.v40(), SignInSupport.v48(), this.v18());
   }

   private float v19() {
      return this.v16() - 39.0F * this.v9();
   }

   private float v17() {
      return this.v5(SignInSupport.v4(21.0F, this.v9()));
   }

   private float v20() {
      return this.v19() - this.v11() * this.v9();
   }

   private float v21() {
      return this.v19() - 14.0F * this.v9();
   }

   private float v22() {
      return this.v20() - 15.0F * this.v9();
   }

   private float v24() {
      return this.v3(this.v14(), this.v7());
   }

   private float v25() {
      if (this.v7 != null) {
         return this.v22() - this.v7.v2() * this.v9() - this.v24();
      } else {
         return this.v8 == null && this.v13 == null ? this.v20() : this.v22() - this.v24();
      }
   }

   private float v26() {
      float var1 = this.v9();
      float var2 = this.v7 == null && this.v8 == null && this.v13 != null ? uiSupport68.v1(this.v25(), this.v24(), var1, this.v13.get()) : this.v25();
      return var2 - 39.0F * var1;
   }

   @Override
   public float v3() {
      if (this.v7 != null || this.v8 != null) {
         return Float.NaN;
      } else if (this.v5 != null) {
         return this.v26();
      } else {
         return this.v13 != null ? uiSupport68.v1(this.v25(), this.v24(), this.v9(), this.v13.get()) : this.v20();
      }
   }

   private float v27() {
      return this.v5(SignInSupport.v4(24.0F, this.v9()));
   }

   private float v28() {
      return SignInSupport.v4(30.0F, this.v9());
   }

   @Override
   public void v2(uiSupport35 var1) {
      float var2 = this.v9();
      float var3 = this.v10();
      float var4 = this.v18();
      if (this.v5 != null) {
         uiSupport107.v1(this.v26(), this.v27(), var2, this.v5.getAsInt(), var3, var4);
      }

      if (this.v7 != null) {
         this.v7.v1(var1, this.v22(), this.v24(), this.v10, this.v12, var2, var3, var4);
      } else if (this.v8 != null) {
         this.v8.v1(var1, this.v25(), this.v24(), this.v10, this.v12, var2, var3, var4);
      } else if (this.v13 != null) {
         float var5 = this.v28();
         uiSupport68.v1(this.v25(), this.v5(var5), this.v24(), var5, var2, this.v13.get(), var3, var4);
      }

      this.v1(var1, this.v21(), var4);
      uiSupport106.v1(uiSupport105.SETTINGS, this.v19(), this.v17(), var2, var4, var3);
   }

   @Override
   public boolean v1(float var1, float var2, int var3) {
      if (var3 == 0 && this.v1(var1, var2)) {
         float var4 = this.v9();
         if (this.v5 != null && this.v6 != null) {
            float var5 = this.v26();
            float var6 = this.v27();
            if (uiSupport107.v1(var1, var2, var5, var6, var4)) {
               float var11 = SignInSupport.v4(24.0F, var4);
               this.v6.onControlClick(var5, var6, var11, var11, var1, var2);
               return true;
            }
         }

         if (this.v7 != null && this.v7.v2(var1, var2, this.v22(), this.v24(), this.v10, this.v12, var4)) {
            return true;
         } else if (this.v8 != null && this.v8.v1(var1, var2, this.v25(), this.v24(), this.v10, this.v12, var4, var3)) {
            return true;
         } else {
            if (this.v13 != null && this.v14 != null) {
               float var9 = this.v24();
               float var10 = this.v28();
               float var7 = this.v25();
               float var8 = this.v5(var10);
               if (uiSupport68.v1(var1, var2, var7, var8, var9, var10, var4, this.v13.get())) {
                  this.v14.onControlClick(var7, var8, var9, var10, var1, var2);
                  return true;
               }
            }

            if (this.v2(var1, var2, this.v21())) {
               this.v6();
               return true;
            } else if (uiSupport106.v2(uiSupport105.SETTINGS, var1, var2, this.v19(), this.v17(), var4)) {
               this.v3.run();
               this.v6();
               return true;
            } else {
               this.v6();
               return false;
            }
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
         if (this.v5 != null && this.v6 != null && uiSupport107.v1(var1, var2, this.v26(), this.v27(), var3)) {
            return hudSupport54.POINTER;
         } else if (this.v7 != null && this.v7.v1(var1, var2, this.v22(), this.v24(), this.v10, this.v12, var3) != uiSupport59.Part1.NONE) {
            return hudSupport54.POINTER;
         } else {
            if (this.v8 != null) {
               hudSupport54 var4 = this.v8.v1(var1, var2, this.v25(), this.v24(), this.v10, this.v12, var3);
               if (var4 != hudSupport54.ARROW) {
                  return var4;
               }
            }

            if (this.v13 != null && this.v14 != null) {
               float var5 = this.v28();
               if (uiSupport68.v1(var1, var2, this.v25(), this.v5(var5), this.v24(), var5, var3, this.v13.get())) {
                  return hudSupport54.POINTER;
               }
            }

            if (this.v1(var1, var2, this.v21())) {
               return hudSupport54.POINTER;
            } else {
               return uiSupport106.v2(uiSupport105.SETTINGS, var1, var2, this.v19(), this.v17(), var3) ? hudSupport54.POINTER : hudSupport54.ARROW;
            }
         }
      }
   }

   @Nullable
   @Override
   public hudSupport54 v31() {
      if (this.v7 != null && this.v7.v5()) {
         return hudSupport54.POINTER;
      } else {
         return this.v8 != null ? this.v8.v4() : null;
      }
   }

   @Override
   public boolean v4(float var1, float var2, int var3) {
      return this.v8 != null && this.v8.v1(var1, var2, var3) ? true : var3 == 0 && this.v7 != null && this.v7.v4();
   }

   @Override
   public boolean v1(float var1, float var2, int var3, float var4, float var5) {
      return this.v8 != null && this.v8.v1(var1, var2, var3, var4, var5)
         ? true
         : var3 == 0 && this.v7 != null && this.v7.v1(var1, this.v22(), this.v24(), this.v9());
   }

   @Override
   public boolean v2(int var1, int var2) {
      return this.v8 != null && this.v8.v1(var1, var2);
   }

   @Override
   public boolean v3(int var1, int var2) {
      return this.v8 != null && this.v8.v2(var1, var2);
   }

   @Override
   public boolean v5() {
      return this.v8 != null && this.v8.v2();
   }

   @Override
   public void v6() {
      if (this.v8 != null) {
         this.v8.v3();
      }
   }
}
