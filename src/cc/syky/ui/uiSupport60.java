package cc.syky.ui;

import cc.syky.hud.hudSupport57;
import java.util.Locale;
import java.util.function.DoubleConsumer;
import java.util.function.DoubleSupplier;
import org.jetbrains.annotations.Nullable;

public final class uiSupport60 {
   private final DoubleSupplier v1;
   private final DoubleConsumer v2;
   private final double v3;
   private final double v4;
   private final double v5;
   private final uiSupport60.Part1 v6;
   private final float v7;
   private final hudSupport57 v8;
   private boolean v9;
   private final hudSupport57 v10 = new hudSupport57(0.0F, 71.0F);
   private final hudSupport57 v11 = new hudSupport57(0.0F, 71.0F);
   private final hudSupport57 v12 = new hudSupport57(0.0F, 71.0F);
   private float v13 = -1.0F;
   private double v14 = Double.NaN;
   @Nullable
   private String v15;
   private float v16;

   public static String v1(double var0) {
      return Math.abs(var0) >= 100.0 ? Long.toString(Math.round(var0)) : String.format(Locale.ROOT, "%.1f", var0);
   }

   public uiSupport60(DoubleSupplier var1, DoubleConsumer var2, double var3, double var5, double var7, uiSupport60.Part1 var9, float var10) {
      this.v1 = var1;
      this.v2 = var2;
      this.v3 = var3;
      this.v4 = var5;
      this.v5 = var7;
      this.v6 = var9;
      this.v7 = var10;
      this.v8 = new hudSupport57(this.v2(var1.getAsDouble()), 18.0F);
   }

   public float v1() {
      return this.v7;
   }

   public float v2() {
      return 0.0F;
   }

   public float v3() {
      return this.v7 + this.v2();
   }

   private float v2(double var1) {
      float var3 = (float)((var1 - this.v3) / (this.v4 - this.v3));
      return var3 < 0.0F ? 0.0F : (var3 > 1.0F ? 1.0F : var3);
   }

   private float v6() {
      this.v8.v2(this.v2(this.v1.getAsDouble()));
      return this.v8.v2();
   }

   private float v1(float var1, float var2, float var3) {
      return var1 - this.v2() * var3 - var2;
   }

   public void v1(uiSupport35 var1, float var2, float var3, float var4, float var5, float var6, float var7, float var8) {
      double var9 = this.v1.getAsDouble();
      float var11 = this.v6();
      boolean var12 = var8 >= 1.0F;
      float var13 = this.v1(var2, var3, var6);
      float var14 = SignInSupport.v4(5.0F, var6);
      float var15 = uiSupport126.v1(var4, var5, var14, SignInSupport.v4(47.0F, var6));
      uiRecord7 var16 = uiRecord7.v1(2.5F * var6);
      uiSupport59.Part1 var17 = var1.v2() ? this.v1(var1.v1, var1.v2, var2, var3, var4, var5, var6) : uiSupport59.Part1.NONE;
      this.v10.v2(!this.v9 && var17 == uiSupport59.Part1.NONE ? 0.0F : 1.0F);
      this.v11.v2(!this.v9 && var17 != uiSupport59.Part1.THUMB ? 0.0F : 1.0F);
      this.v12.v2(this.v9 ? 1.0F : 0.0F);
      float var18 = this.v10.v2();
      float var19 = this.v11.v2();
      float var20 = var18 * (1.0F + 0.27272725F * this.v12.v2());
      if (var17 != uiSupport59.Part1.NONE && var3 > 0.0F) {
         float var21 = (var1.v1 - var13) / var3;
         this.v13 = var21 < 0.0F ? 0.0F : (var21 > 1.0F ? 1.0F : var21);
      }

      int var34 = var12 ? SignInSupport.v159() : uiSupport155.v1(SignInSupport.v157(), SignInSupport.v159(), var8);
      int var22 = var12 ? 872415231 : uiSupport155.v1(419430399, 872415231, var8);
      int var23 = var12 ? SignInSupport.v176() : uiSupport155.v1(SignInSupport.v166(), SignInSupport.v176(), var8);
      int var24 = var12 ? SignInSupport.v147() : uiSupport155.v1(SignInSupport.v187(), SignInSupport.v147(), var8);
      float var25 = var3 * var11;
      uiSupport169.v1(var13, var15, var3, var14, uiSupport155.v1(var22, var7), var16);
      if (var18 > 0.0F && this.v13 >= 0.0F && !this.v9) {
         uiSupport169.v1(var13, var15, var3 * this.v13, var14, uiSupport155.v1(SignInSupport.v93(), var7 * var18), var16);
      }

      uiSupport169.v1(var13, var15, var25, var14, uiSupport155.v1(var34, var7), var16);
      if (var18 > 0.0F && this.v13 >= 0.0F && this.v13 < var11 && !this.v9) {
         float var26 = var13 + var3 * this.v13;
         int var27 = uiSupport155.v1(var34, uiSupport155.v2(var34, 0.55F), var18);
         uiSupport169.v1(var26, var15, var13 + var25 - var26, var14, uiSupport155.v1(var27, var7), var16);
      }

      float var35 = var13 + var25;
      float var36 = var15 + var14 / 2.0F;
      if (var18 > 0.002F) {
         float var28 = 18.0F * var6 * var20;
         float var29 = 13.0F * var6 * var20;
         float var30 = var35 - var28 / 2.0F;
         float var31 = var36 - var29 / 2.0F;
         float var32 = 6.5F * var6 * var20;
         float var33 = 2.0F * var6 * var20;
         uiSupport169.v1(
            var30 + var33,
            var31 + var33,
            var28 - 2.0F * var33,
            var29 - 2.0F * var33,
            Math.max(0.0F, var32 - var33),
            uiSupport155.v1(SignInSupport.v116(), var7 * var18 * 0.5F),
            5.0F * var6,
            0.0F,
            3.0F * var6
         );
         uiSupport169.v1(var30, var31, var28, var29, uiSupport155.v1(var23, var7 * var18), uiRecord7.v1(var32));
      }

      if (!(var19 <= 0.002F)) {
         float var37 = 14.0F * var6 * (0.7F + 0.3F * var19);
         String var38 = this.v3(var9);
         float var39 = uiSupport169.v2("syky_sans_strong", var38, var37) / 2.0F;
         float var40 = Math.max(var13 + var39, Math.min(var35, var13 + var3 - var39));
         uiSupport169.v3("syky_sans_strong", var38, var40, uiSupport169.v1(var36 - 16.0F * var6, var37), var37, uiSupport155.v1(var24, var7 * var19));
      }
   }

   private String v3(double var1) {
      if (this.v15 == null || var1 != this.v14) {
         this.v14 = var1;
         this.v15 = this.v6.format(var1);
      }

      return this.v15;
   }

   public uiSupport59.Part1 v1(float var1, float var2, float var3, float var4, float var5, float var6, float var7) {
      float var8 = SignInSupport.v4(5.0F, var7);
      return uiSupport59.v1(
         var1,
         var2,
         this.v1(var3, var4, var7),
         var4,
         uiSupport126.v1(var5, var6, var8, SignInSupport.v4(47.0F, var7)),
         var8,
         18.0F * var7,
         13.0F * var7,
         this.v6()
      );
   }

   public boolean v2(float var1, float var2, float var3, float var4, float var5, float var6, float var7) {
      switch (this.v1(var1, var2, var3, var4, var5, var6, var7)) {
         case THUMB:
            this.v9 = true;
            this.v16 = var1 - (this.v1(var3, var4, var7) + var4 * this.v2(this.v1.getAsDouble()));
            return true;
         case TRACK:
            this.v9 = true;
            this.v16 = 0.0F;
            this.v2(var1, var3, var4, var7);
            return true;
         default:
            return false;
      }
   }

   public boolean v1(float var1, float var2, float var3, float var4) {
      if (!this.v9) {
         return false;
      } else {
         this.v2(var1, var2, var3, var4);
         return true;
      }
   }

   public boolean v4() {
      if (!this.v9) {
         return false;
      } else {
         this.v9 = false;
         return true;
      }
   }

   public boolean v5() {
      return this.v9;
   }

   private void v2(float var1, float var2, float var3, float var4) {
      float var5 = this.v1(var2, var3, var4);
      float var6 = (var1 - this.v16 - var5) / var3;
      if (var6 < 0.0F) {
         var6 = 0.0F;
      }

      if (var6 > 1.0F) {
         var6 = 1.0F;
      }

      double var7 = this.v3 + (this.v4 - this.v3) * var6;
      if (this.v5 > 0.0) {
         var7 = Math.round(var7 / this.v5) * this.v5;
      }

      if (var7 < this.v3) {
         var7 = this.v3;
      }

      if (var7 > this.v4) {
         var7 = this.v4;
      }

      this.v2.accept(var7);
   }

   @FunctionalInterface
   public interface Part1 {
      String format(double var1);
   }
}
