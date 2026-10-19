package cc.syky.ui;

import cc.syky.hud.hudSupport54;
import cc.syky.hud.hudSupport57;
import cc.syky.hud.hudSupport58;
import java.util.function.Consumer;
import org.jetbrains.annotations.Nullable;

public abstract class uiSupport80 extends UiNode implements uiSupport127, uiSupport86 {
   private final Consumer<uiSupport35> v1 = this::v3;
   private static final float v2 = 100.0F;
   private static final float v3 = 0.001F;
   private final uiSupport81 v4;
   private final int v5;
   private final hudSupport57[] v6;
   private final hudSupport57 v7 = new hudSupport57(0.0F, 150.0F);
   private boolean v8;
   private float v13;
   private final float[] v14;
   private final hudSupport58 v15 = new hudSupport58();
   private final uiSupport125 v16 = new uiSupport125();
   private long v18;
   private float v19;

   public uiSupport80(uiSupport81 var1, int var2, float var3) {
      this.v4 = var1;
      this.v5 = var2;
      this.v6 = new hudSupport57[var2];
      this.v14 = new float[var2];
      this.v19 = var3;
      this.v13 = var1.v2() ? 0.0F : 1.0F;
      this.v15.v8(var3);
   }

   public abstract String v1(int var1);

   public abstract boolean v2(int var1);

   public abstract void v3(int var1);

   @Nullable
   public String v2() {
      return null;
   }

   @Override
   public final void v2(float var1) {
      this.v19 = var1;
      this.v15.v8(var1);
   }

   @Override
   public final float v1() {
      return this.v15.v5();
   }

   @Override
   public final void v1(float var1) {
      this.v15.v6(var1);
   }

   public final float v3() {
      return 32.0F + this.v7() * 47.0F - 6.0F;
   }

   public final float v3(float var1) {
      String var2 = this.v2();
      if (this.v5 == 0 && var2 != null) {
         float var6 = uiSupport169.v2("syky_sans_strong", var2, 18.0F);
         return Math.max(var1, 42.0F + var6 + 16.0F);
      } else {
         float var3 = 0.0F;

         for (int var4 = 0; var4 < this.v5; var4++) {
            float var5 = uiSupport169.v2("syky_sans_strong", this.v1(var4), 18.0F);
            if (var5 > var3) {
               var3 = var5;
            }
         }

         return Math.max(Math.max(var1, 221.0F), 32.0F + this.v4.v1() + var3 + 16.0F);
      }
   }

   private float v5() {
      return this.v11 - (1.0F - this.v13) * this.v6();
   }

   private float v6() {
      return SignInSupport.v4(uiSupport79.v1(this.v4.v1()), this.v19);
   }

   @Override
   public final boolean v1(float var1, float var2) {
      return var1 >= this.v9 && var2 >= this.v10 && var1 < this.v9 + this.v5() && var2 < this.v10 + this.v12;
   }

   public final float v4() {
      return 36.5F;
   }

   private int v7() {
      return Math.max(1, Math.min(this.v5, 6));
   }

   private float v8() {
      return SignInSupport.v4(47.0F, this.v19);
   }

   private float v9() {
      return SignInSupport.v4(41.0F, this.v19);
   }

   private float v10() {
      return this.v10 + SignInSupport.v4(16.0F, this.v19);
   }

   private float v11() {
      return this.v9 + SignInSupport.v4(16.0F, this.v19);
   }

   private float v12() {
      return uiSupport169.v1(this.v11 - 2.0F * SignInSupport.v4(16.0F, this.v19)) - (1.0F - this.v13) * this.v6();
   }

   private float v13() {
      return (this.v7() - 1) * this.v8() + this.v9();
   }

   private float v14() {
      return (this.v5 - 1) * this.v8() + this.v9();
   }

   @Override
   public final void v1(uiSupport35 var1) {
      this.v15();
      float var2 = this.v5();
      uiSupport97.v1(this.v9, this.v10, var2, this.v12, this.v19);
      String var3 = this.v2();
      if (this.v5 == 0) {
         if (var3 != null) {
            this.v1(var3);
         }
      } else {
         this.v18();
         this.v2(var1);
         this.v16.v1(this.v15, this.v9, this.v10(), this.v5(), this.v13(), this.v14(), this.v19, var1.v1, var1.v2);
      }
   }

   private void v1(String var1) {
      float var2 = 18.0F * this.v19;
      uiSupport169.v1(
         "syky_sans_strong", var1, this.v11() + SignInSupport.v4(10.0F, this.v19), uiSupport169.v1(this.v10() + this.v9() / 2.0F, var2), var2, uiSupport79.v2()
      );
   }

   private void v2(uiSupport35 var1) {
      uiSupport85.v1(
         var1,
         this.v1,
         this.v15.v3() > 0.0F,
         this.v9,
         this.v10,
         this.v5(),
         this.v12,
         uiRecord7.v1(24.0F * this.v19),
         this.v10,
         this.v10(),
         9.0F * this.v19,
         this.v10 + this.v12 - 16.0F * this.v19,
         this.v10(),
         this.v13()
      );
   }

   private void v3(uiSupport35 var1) {
      float var2 = this.v8();
      float var3 = this.v9();
      float var4 = this.v10();
      float var5 = this.v11();
      float var6 = this.v12();
      float var7 = this.v15.v1();
      float var8 = 12.0F * this.v19;
      uiRecord7 var9 = uiRecord7.v1(var8);
      float var10 = this.v13;
      float var11 = SignInSupport.v4(10.0F, this.v19);
      float var12 = SignInSupport.v4(this.v4.v1(), this.v19);
      float var13 = var5 + var11 + (var12 - var11) * var10;
      float var14 = 18.0F * this.v19;
      int var15 = this.v3(var1.v1, var1.v2);

      for (int var16 = 0; var16 < this.v5; var16++) {
         this.v4(var16).v2(var16 == var15 ? 1.0F : 0.0F);
         this.v4(var16).v2();
      }

      for (int var20 = 0; var20 < this.v5; var20++) {
         float var17 = var4 + var20 * var2 - var7;
         if (!(var17 + var3 <= this.v10) && !(var17 >= this.v10 + this.v12)) {
            float var18 = SignInSupport.v1(this.v4(var20).v2());
            if (var18 > 0.002F) {
               uiSupport169.v1(
                  var5,
                  var17,
                  var6,
                  var3,
                  uiSupport155.v1(SignInSupport.v42(), var18),
                  uiSupport155.v1(SignInSupport.v1(SignInSupport.v43(), this.v19), var18),
                  SignInSupport.v2(this.v19),
                  1.0F,
                  var9
               );
            }

            this.v4.v1(var20, var5, var17, var3, this.v19);
            int var19 = uiSupport155.v1(uiSupport155.v1(uiSupport79.v2(), uiSupport79.v3(), var18), uiSupport79.v3(), this.v14[var20]);
            uiSupport169.v1("syky_sans_strong", this.v1(var20), var13, uiSupport169.v1(var17 + var3 / 2.0F, var14), var14, var19);
         }
      }
   }

   private hudSupport57 v4(int var1) {
      hudSupport57 var2 = this.v6[var1];
      if (var2 == null) {
         var2 = new hudSupport57(0.0F, 90.0F);
         this.v6[var1] = var2;
      }

      return var2;
   }

   private void v15() {
      float var1 = this.v4.v2() && !this.v16() ? 0.0F : 1.0F;
      if (!this.v8) {
         this.v4(var1);
         this.v8 = true;
      }

      boolean var2 = this.v13 >= 0.999F;

      for (int var3 = 0; var3 < this.v5; var3++) {
         this.v14[var3] = this.v4.v1(var3, this.v2(var3), var2);
      }

      this.v7.v2(var1);
      this.v13 = SignInSupport.v1(this.v7.v2());
   }

   private void v4(float var1) {
      this.v7.v3(var1);
      this.v13 = var1;
   }

   private boolean v16() {
      for (int var1 = 0; var1 < this.v5; var1++) {
         if (this.v2(var1)) {
            return true;
         }
      }

      return false;
   }

   private void v18() {
      this.v15.v7(Math.max(0.0F, this.v14() - this.v13()));
      long var1 = System.nanoTime();
      float var3 = this.v18 == 0L ? 0.0F : (float)(var1 - this.v18) / 1000000.0F;
      this.v18 = var1;
      this.v15.v9(Math.min(var3, 100.0F));
   }

   private int v3(float var1, float var2) {
      if (this.v5 != 0 && this.v1(var1, var2)) {
         float var3 = this.v11();
         if (!(var1 < var3) && !(var1 >= var3 + this.v12())) {
            float var4 = this.v10();
            if (!(var2 < var4) && !(var2 >= var4 + this.v13())) {
               float var5 = var2 - var4 + this.v15.v1();
               float var6 = this.v8();
               int var7 = (int)Math.floor(var5 / var6);
               if (var7 >= 0 && var7 < this.v5) {
                  return var5 - var7 * var6 < this.v9() ? var7 : -1;
               } else {
                  return -1;
               }
            } else {
               return -1;
            }
         } else {
            return -1;
         }
      } else {
         return -1;
      }
   }

   @Override
   public final boolean v1(float var1, float var2, int var3) {
      if (var3 != 0 || !this.v1(var1, var2)) {
         return false;
      } else if (this.v16.v1(this.v15, var1, var2)) {
         return true;
      } else {
         int var4 = this.v3(var1, var2);
         if (var4 < 0) {
            return true;
         } else {
            this.v3(var4);
            return true;
         }
      }
   }

   @Override
   public final boolean v1(float var1, float var2, int var3, float var4, float var5) {
      return this.v16.v1(this.v15, var2);
   }

   @Override
   public final boolean v4(float var1, float var2, int var3) {
      if (!this.v16.v3()) {
         return false;
      } else {
         this.v15.v3(uiSupport169.v1(this.v15.v2()));
         return true;
      }
   }

   @Override
   public final boolean v1(float var1, float var2, double var3, double var5) {
      if (!this.v1(var1, var2)) {
         return false;
      } else if (this.v15.v3() <= 0.0F) {
         return true;
      } else {
         this.v15.v2((float)(-var5) * SignInSupport.v4(47.0F, this.v19));
         this.v16.v1();
         return true;
      }
   }

   @Override
   public final hudSupport54 v2(float var1, float var2) {
      if (this.v16.v1(var1, var2)) {
         return hudSupport54.POINTER;
      } else {
         return this.v3(var1, var2) >= 0 ? hudSupport54.POINTER : hudSupport54.ARROW;
      }
   }
}
