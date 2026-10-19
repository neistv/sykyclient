package cc.syky.ui;

import cc.syky.cloud.cloudRecord10;
import cc.syky.cloud.cloudSupport96;
import cc.syky.hud.hudSupport54;
import cc.syky.hud.hudSupport57;
import cc.syky.hud.hudSupport60;
import cc.syky.hud.hudSupport75;
import java.util.Locale;

public final class KeySupport extends UiScreen implements uiSupport86 {
   private static final String v1 = "syky_sans_strong";
   private static final int v2 = 0;
   private static final String v3 = "Keybind";
   private static final String v4 = "Key";
   private static final String v5 = "Mode";
   private static final cloudSupport96[] v6 = new cloudSupport96[]{cloudSupport96.HOLD, cloudSupport96.TOGGLE};
   private static final int v7 = 0;
   private static final int v8 = 1;
   private static final int v13 = 2;
   private static final float v14 = 13.0F;
   private static final float v15 = 3.0F;
   private static final float v16 = 17.0F;
   private static final float v18 = 0.85F;
   private final Runnable v19;
   private final hudSupport57 v17 = new hudSupport57(0.0F, 90.0F);
   private static final float v20 = 90.0F;
   private final String v21;
   private final hudSupport75 v22;
   private final PressASupport v24;
   private final uiSupport94 v25;
   private final boolean v26;
   private final int v27;
   private final float v28;
   private final float v29;
   private float v30;
   private final hudSupport57 v32 = new hudSupport57(0.0F, 150.0F);
   private final hudSupport57[] v23 = new hudSupport57[]{new hudSupport57(0.0F, 90.0F), new hudSupport57(0.0F, 90.0F)};
   private float v33 = Float.NaN;
   private uiRecord7 v31 = uiRecord7.ZERO;

   public KeySupport(String var1, hudSupport75 var2, float var3, Runnable var4) {
      this.v21 = var1;
      this.v22 = var2;
      this.v30 = var3;
      this.v19 = var4;
      this.v24 = new PressASupport(var1, var2);
      this.v26 = var2.v1(var1);
      this.v27 = this.v26 ? 2 : 1;
      String[] var5 = new String[v6.length];

      for (int var6 = 0; var6 < v6.length; var6++) {
         var5[var6] = v1(v6[var6].v1());
      }

      this.v25 = new uiSupport94(var5, v1(var2.v2(var1)));
      this.v29 = this.v25.v1();
      float var11 = 0.0F;

      for (String var10 : new String[]{"Key", "Mode"}) {
         var11 = Math.max(var11, uiSupport169.v2("syky_sans_strong", var10, 18.0F));
      }

      float var12 = 10.0F + var11 + 16.0F + this.v29 + 10.0F + 32.0F;
      float var13 = 50.0F + uiSupport169.v2("syky_sans_strong", "Keybind", 18.0F) + 16.0F + 17.0F + 18.0F;
      float var14 = 324.0F;
      this.v28 = (float)Math.ceil(Math.max(240.0F, Math.max(var14, Math.max(var12, var13))));
      this.v32.v3(this.v24.v3() ? 1.0F : 0.0F);
   }

   @Override
   public float v2() {
      return this.v28;
   }

   @Override
   public float a_(float var1) {
      return 52.0F + this.v27 * 47.0F + 26.0F;
   }

   @Override
   public void v2(float var1) {
      this.v30 = var1;
   }

   @Override
   public boolean v3() {
      return this.v24.v4();
   }

   @Override
   public void e_() {
      this.v24.v5();
   }

   private cloudSupport96 v1() {
      return this.v22.v2(this.v21);
   }

   private static int v1(cloudSupport96 var0) {
      return v6[0] == var0 ? 0 : 1;
   }

   private void v2(cloudSupport96 var1) {
      uiSupport148.v1(uiSupport146.OPTION_PICKED);
      if (var1 != this.v1()) {
         cloudRecord10 var2 = this.v24.v2();
         this.v22.v1(this.v21, var2 == null ? cloudRecord10.v1(-1) : var2, var1);
      }
   }

   private void v5() {
      if (this.v30 != this.v33) {
         this.v33 = this.v30;
         this.v31 = uiRecord7.v1(6.0F * this.v30);
      }
   }

   private float v1(int var1) {
      return this.v10 + SignInSupport.v4(65.0F, this.v30) + var1 * SignInSupport.v4(47.0F, this.v30);
   }

   private float v6() {
      return this.v9 + SignInSupport.v4(16.0F, this.v30);
   }

   private float v7() {
      return this.v9 + this.v11 - SignInSupport.v4(16.0F, this.v30);
   }

   private float v2(int var1) {
      return this.v1(var1) + 3.0F * this.v30;
   }

   private float v8() {
      return this.v7() - 10.0F * this.v30;
   }

   private float v18() {
      return this.v8() - this.v29 * this.v30;
   }

   private float v19() {
      return uiSupport126.v1(this.v1(0), 47.0F * this.v30, 21.0F * this.v30);
   }

   private float v17() {
      return uiSupport126.v1(this.v1(1), 47.0F * this.v30, 24.0F * this.v30);
   }

   private float v20() {
      return this.v9 + this.v11 - 35.0F * this.v30;
   }

   private float v21() {
      return this.v10 + 17.5F * this.v30;
   }

   private boolean v6(float var1, float var2) {
      float var3 = this.v20();
      float var4 = this.v21();
      float var5 = 17.0F * this.v30;
      return var1 >= var3 && var1 < var3 + var5 && var2 >= var4 && var2 < var4 + var5;
   }

   @Override
   public boolean v3(float var1, float var2) {
      return this.v1(var1, var2) && var2 < this.v10 + 52.0F * this.v30 && !this.v6(var1, var2);
   }

   private int v7(float var1, float var2) {
      return !this.v26 ? -1 : this.v25.v1(this.v18(), this.v17(), this.v30, var1, var2);
   }

   @Override
   public void v1(uiSupport35 var1) {
      this.v5();
      this.v24.v1();
      float var2 = this.v30;
      uiSupport97.v1(this.v9, this.v10, this.v11, this.v12, var2);
      this.v1(var1, var2);
      this.v1(var1, 0, var2);
      this.v1("Key", 0, var2);
      this.v24.v1(var1, this.v8(), this.v19(), var2, 1.0F);
      if (this.v26) {
         this.v1(var1, 1, var2);
         this.v1("Mode", 1, var2);
         this.v4(var1, var2);
      }
   }

   private void v1(uiSupport35 var1, float var2) {
      this.v32.v2(this.v24.v3() ? 1.0F : 0.0F);
      float var3 = this.v32.v2();
      float var4 = SignInSupport.v4(16.0F, var2);
      uiSupport169.v1(
         SignInSupport.v162(),
         this.v9 + SignInSupport.v4(18.0F, var2),
         this.v10 + uiSupport169.v1((SignInSupport.v4(52.0F, var2) - var4) / 2.0F),
         var4,
         var4,
         uiSupport155.v1(SignInSupport.v99(), SignInSupport.v82(), var3),
         uiRecord7.ZERO
      );
      float var5 = 18.0F * var2;
      uiSupport169.v1(
         "syky_sans_strong",
         "Keybind",
         this.v9 + 50.0F * var2,
         uiSupport169.v1(this.v10 + 52.0F * var2 / 2.0F, var5),
         var5,
         uiSupport155.v1(SignInSupport.v40(), SignInSupport.v48(), var3)
      );
      this.v2(var1, var2);
      float var6 = SignInSupport.v2(var2);
      uiSupport169.v1(
         this.v6(), this.v10 + SignInSupport.v4(52.0F, var2), this.v7() - this.v6(), var6, SignInSupport.v1(SignInSupport.v94(), var2), SignInSupport.v3(var6)
      );
   }

   private void v2(uiSupport35 var1, float var2) {
      this.v17.v2(var1.v2() && this.v6(var1.v1, var1.v2) ? 1.0F : 0.0F);
      float var3 = hudSupport60.v1(this.v17.v2());
      float var4 = 0.85F + 0.14999998F * var3;
      uiSupport112.v1(
         this.v20() + 17.0F * var2 / 2.0F,
         this.v21() + 17.0F * var2 / 2.0F,
         13.0F * var2 * var4,
         3.0F * var2 * var4,
         uiSupport155.v1(SignInSupport.v124(), SignInSupport.v117(), var3)
      );
   }

   private void v1(uiSupport35 var1, int var2, float var3) {
      hudSupport57 var4 = this.v23[var2];
      var4.v2(var1.v2() && this.v3(var1.v1, var1.v2, var2) ? 1.0F : 0.0F);
      float var5 = var4.v2();
      if (!(var5 <= 0.001F)) {
         uiSupport169.v1(
            this.v6(),
            this.v2(var2),
            this.v7() - this.v6(),
            41.0F * var3,
            uiSupport155.v1(SignInSupport.v42(), var5),
            uiSupport155.v1(SignInSupport.v1(SignInSupport.v43(), this.v30), var5),
            SignInSupport.v2(this.v30),
            1.0F,
            uiRecord7.v1(12.0F * var3)
         );
      }
   }

   private boolean v3(float var1, float var2, int var3) {
      float var4 = this.v2(var3);
      return var1 >= this.v6() && var1 < this.v7() && var2 >= var4 && var2 < var4 + 41.0F * this.v30;
   }

   private void v1(String var1, int var2, float var3) {
      uiSupport169.v1("syky_sans_strong", var1, this.v6() + 10.0F * var3, uiSupport126.v2(this.v1(var2), 47.0F * var3, var3), 18.0F * var3, SignInSupport.v37());
   }

   private void v4(uiSupport35 var1, float var2) {
      this.v25.v1(var1, this.v18(), this.v17(), var2, v1(this.v1()), this.v31);
   }

   @Override
   public boolean v1(float var1, float var2, int var3) {
      if (!this.v1(var1, var2)) {
         return false;
      } else if (this.v24.v1(var3)) {
         return true;
      } else if (var3 == 0) {
         if (this.v6(var1, var2)) {
            this.v19.run();
            return true;
         } else {
            int var4 = this.v7(var1, var2);
            if (var4 >= 0) {
               this.v2(v6[var4]);
               return true;
            } else {
               this.v24.v3(var1, var2, this.v8(), this.v19(), this.v30);
               return true;
            }
         }
      } else {
         return true;
      }
   }

   @Override
   public boolean v2(float var1, float var2, int var3) {
      return this.v24.v1(var3);
   }

   @Override
   public boolean v2(int var1, int var2) {
      return this.v24.v1(var1, var2);
   }

   @Override
   public boolean v3(int var1, int var2) {
      return this.v24.v6();
   }

   @Override
   public hudSupport54 v2(float var1, float var2) {
      if (!this.v1(var1, var2)) {
         return hudSupport54.ARROW;
      } else {
         return !this.v6(var1, var2)
               && !this.v24.v2(var1, var2, this.v8(), this.v19(), this.v30)
               && this.v7(var1, var2) < 0
               && !this.v24.v1(var1, var2, this.v8(), this.v19(), this.v30)
            ? hudSupport54.ARROW
            : hudSupport54.POINTER;
      }
   }

   private static String v1(String var0) {
      return Character.toUpperCase(var0.charAt(0)) + var0.substring(1).toLowerCase(Locale.ROOT);
   }
}
