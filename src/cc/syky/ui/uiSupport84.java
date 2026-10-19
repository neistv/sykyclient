package cc.syky.ui;

import cc.syky.config.ColorSetting;
import cc.syky.config.EnumSetting;
import cc.syky.hud.hudSupport54;
import org.jetbrains.annotations.Nullable;

public final class uiSupport84 extends UiNode implements uiSupport86 {
   private static final float v2 = 24.0F;
   private static final float v3 = 16.0F;
   private static final float v4 = 288.0F;
   private static final float v5 = 252.0F;
   public static final float v1 = 8.0F;
   private static final float v6 = 8.0F;
   private static final float v7 = 12.0F;
   private static final float v8 = 26.0F;
   private static final float v13 = 18.0F;
   private static final float v14 = 12.0F;
   private static final float v15 = 18.0F;
   private static final float v16 = 20.0F;
   private static final float v18 = 2.5F;
   private static final float v19 = 14.0F;
   private static final float v17 = 26.0F;
   private static final float v20 = 16.0F;
   private static final float v21 = 3.5F;
   private static final float v22 = 6.0F;
   private static final int[] v24 = new int[]{-65536, -256, -16711936, -16711681, -16776961, -65281, -65536};
   private static final int v25 = -1;
   private static final int v26 = -3618616;
   private static final int v27 = -1;
   private static final int v28 = 1073741824;
   private static final float v29 = 1.0F;
   private static final int v30 = 1493172224;
   private static final float v32 = 2.0F;
   private static final float v23 = 1.5F;
   private static final String v33 = "syky_sans_strong";
   private static final String[] v31 = new String[]{"Vibrancy is on for this element.", "The result will not match the color you pick."};
   private static final float v34 = 12.5F;
   private static final float v36 = 16.0F;
   private static final float v38 = 14.0F;
   private static final float v42 = 16.0F;
   private final ColorSetting v43;
   private final HEXSupport v37;
   @Nullable
   private final EnumSetting<?> v48;
   @Nullable
   private final uiSupport94 v40;
   private final boolean v44;
   private float v47;
   private float v49;
   private float v46;
   private float v51;
   public int v50;
   private int v60;
   private float v59;
   private float v53;
   private float v63;
   private float v64;
   private float v61;
   private float v66;
   private final int[] v68 = new int[4];
   private final int[] v52 = new int[4];
   private final int[] v75 = new int[4];
   private float v73 = Float.NaN;
   private uiRecord7 v74 = uiRecord7.ZERO;
   private uiRecord7 v72 = uiRecord7.ZERO;
   private uiRecord7 v80 = uiRecord7.ZERO;
   private uiRecord7 v84 = uiRecord7.ZERO;
   private uiRecord7 v94 = uiRecord7.ZERO;
   private float v82;

   public uiSupport84(ColorSetting var1, float var2) {
      this.v43 = var1;
      this.v47 = var2;
      this.v44 = var1.isVisible();
      this.v48 = var1.isVisibleViaEnum() ? var1.getConditionEnum() : null;
      this.v40 = this.v48 == null ? null : new uiSupport94(v1(this.v48), v2(this.v48));
      this.v7();
      this.v37 = new HEXSupport(new uiSupport84.Part1(), var2);
   }

   @Override
   public void v2(float var1) {
      this.v47 = var1;
      this.v37.v1(var1);
   }

   public float v1() {
      return 320.0F;
   }

   private float v5() {
      return this.v44 ? v31.length * 16.0F + 14.0F : 0.0F;
   }

   private float v6() {
      return this.v40 != null ? 40.0F : 0.0F;
   }

   public float v2() {
      return 16.0F + this.v6() + this.v5() + 252.0F + 18.0F + 26.0F + 12.0F + 26.0F + 18.0F + 30.0F + 16.0F;
   }

   public boolean v3() {
      return this.v37.v1();
   }

   public void v4() {
      this.v37.v2();
   }

   private void v7() {
      int var1 = this.v43.getValue();
      this.v50 = var1 >>> 24 & 0xFF;
      this.v1(var1 & 16777215);
   }

   public void v1(int var1) {
      float[] var2 = v1(var1 >>> 16 & 0xFF, var1 >>> 8 & 0xFF, var1 & 0xFF);
      if (var2[1] > 0.0F) {
         this.v49 = var2[0];
      }

      if (var2[2] > 0.0F) {
         this.v46 = var2[1];
      }

      this.v51 = var2[2];
   }

   public int v8() {
      return this.v50 << 24 | v2(this.v49, this.v46, this.v51) & 16777215;
   }

   public void v9() {
      this.v43.setValue(this.v8());
   }

   private void v10() {
      float var1 = this.v47;
      if (var1 != this.v73) {
         this.v73 = var1;
         this.v74 = uiRecord7.v1(8.0F * var1);
         float var2 = 12.0F * var1 / 2.0F;
         this.v84 = uiRecord7.v1(var2);
         this.v72 = uiRecord7.v4(var2);
         this.v80 = uiRecord7.v5(var2);
         this.v94 = uiRecord7.v1(8.0F * var1);
      }

      this.v59 = this.v9 + SignInSupport.v4(16.0F, var1);
      this.v82 = this.v10 + SignInSupport.v4(16.0F, var1);
      this.v53 = this.v10 + SignInSupport.v4(16.0F + this.v6() + this.v5(), var1);
      this.v63 = SignInSupport.v4(288.0F, var1);
      this.v64 = SignInSupport.v4(252.0F, var1);
      this.v61 = this.v53 + this.v64 + SignInSupport.v4(18.0F, var1);
      this.v66 = this.v61 + SignInSupport.v4(26.0F, var1) + SignInSupport.v4(12.0F, var1);
      float var3 = this.v66 + SignInSupport.v4(26.0F, var1) + SignInSupport.v4(18.0F, var1);
      this.v37.v1(this.v59, var3, this.v63, SignInSupport.v4(30.0F, var1));
   }

   private float v1(float var1) {
      return this.v59 + var1 / 2.0F;
   }

   private float v3(float var1) {
      return Math.max(1.0F, this.v63 - var1);
   }

   @Override
   public void v1(uiSupport35 var1) {
      this.v10();
      float var2 = this.v47;
      uiSupport97.v1(this.v9, this.v10, this.v11, this.v12, 24.0F * var2, var2, uiSupport87.v1, 318767103);
      if (this.v40 != null && this.v48 != null) {
         this.v40.v1(var1, this.v59, this.v82, var2, v2(this.v48), this.v94);
      }

      if (this.v44) {
         this.v4(var2);
      }

      int var3 = v2(this.v49, 1.0F, 1.0F);
      int var4 = v2(this.v49, this.v46, this.v51);
      this.v1(var2, var3, var4);
      this.v1(var2, var3);
      this.v2(var2, var4);
      this.v37.v1(var1);
   }

   private void v4(float var1) {
      float var2 = this.v10 + (16.0F + this.v6()) * var1;
      float var3 = 16.0F * var1;
      float var4 = 12.5F * var1;

      for (int var5 = 0; var5 < v31.length; var5++) {
         int var6 = var5 == 0 ? -218123180 : -1711295404;
         uiSupport169.v1("syky_sans_strong", v31[var5], this.v59, var2 + var5 * var3, var4, var6);
      }
   }

   private void v1(float var1, int var2, int var3) {
      this.v68[0] = -1;
      this.v68[1] = var2;
      this.v68[2] = -16777216;
      this.v68[3] = -16777216;
      uiSupport169.v1(this.v59, this.v53, this.v63, this.v64, this.v68, this.v74);
      float var4 = this.v59 + Math.clamp(this.v46, 0.0F, 1.0F) * this.v63;
      float var5 = this.v53 + (1.0F - Math.clamp(this.v51, 0.0F, 1.0F)) * this.v64;
      v1(var4, var5, var1, var3);
   }

   private void v1(float var1, int var2) {
      float var3 = SignInSupport.v4(12.0F, var1);
      float var4 = this.v61 + uiSupport169.v1((SignInSupport.v4(26.0F, var1) - var3) * 0.5F);
      float var5 = 14.0F * var1;
      float var6 = this.v1(var5);
      float var7 = this.v3(var5);
      uiSupport169.v1(this.v59, var4, this.v63, var3, v24[0], var3 / 2.0F);
      int var8 = v24.length - 1;
      float var9 = var7 / var8;

      for (int var10 = 0; var10 < var8; var10++) {
         int var11 = v24[var10];
         int var12 = v24[var10 + 1];
         this.v52[0] = var11;
         this.v52[1] = var12;
         this.v52[2] = var12;
         this.v52[3] = var11;
         uiRecord7 var13;
         if (var10 == 0) {
            var13 = this.v72;
         } else if (var10 == var8 - 1) {
            var13 = this.v80;
         } else {
            var13 = uiRecord7.ZERO;
         }

         float var14 = var10 < var8 - 1 ? 0.5F : 0.0F;
         uiSupport169.v1(var6 + var10 * var9, var4, var9 + var14, var3, this.v52, var13);
      }

      float var15 = var6 + Math.clamp(this.v49 / 360.0F, 0.0F, 1.0F) * var7;
      v2(var15, this.v61 + 26.0F * var1 / 2.0F, var1, var2);
   }

   private void v2(float var1, int var2) {
      float var3 = SignInSupport.v4(12.0F, var1);
      float var4 = this.v66 + uiSupport169.v1((SignInSupport.v4(26.0F, var1) - var3) * 0.5F);
      this.v1(var4, var3, var1);
      int var5 = var2 & 16777215;
      int var7 = 0xFF000000 | var5;
      this.v75[0] = var5;
      this.v75[1] = var7;
      this.v75[2] = var7;
      this.v75[3] = var5;
      uiSupport169.v1(this.v59, var4, this.v63, var3, this.v75, this.v84);
      float var8 = 16.0F * var1;
      float var9 = this.v1(var8) + this.v50 / 255.0F * this.v3(var8);
      v3(var9, this.v66 + 26.0F * var1 / 2.0F, var1, var2);
   }

   private void v1(float var1, float var2, float var3) {
      uiSupport169.v1(this.v59, var1, this.v63, var2, -1, var2 / 2.0F);
      float var4 = 6.0F * var3;
      int var5 = (int)Math.ceil(this.v63 / var4);
      int var6 = (int)Math.ceil(var2 / var4);
      float var7 = var2 / 2.0F;

      for (int var8 = 0; var8 < var6; var8++) {
         int var9 = var8 % 2 == 0 ? 1 : 0;

         for (int var10 = var9; var10 < var5; var10 += 2) {
            float var11 = this.v59 + var10 * var4;
            float var12 = var1 + var8 * var4;
            float var13 = Math.min(var4, this.v59 + this.v63 - var11);
            float var14 = Math.min(var4, var1 + var2 - var12);
            if (!(var11 < this.v59 + var7) && !(var11 + var13 > this.v59 + this.v63 - var7)) {
               uiSupport169.v1(var11, var12, var13, var14, -3618616);
            }
         }
      }
   }

   private static void v1(float var0, float var1, float var2, int var3) {
      float var4 = 20.0F * var2;
      float var5 = var4 / 2.0F;
      v1(var0, var1, var4, var4, var5, var2);
      uiSupport169.v1(var0 - var5, var1 - var5, var4, var4, 0xFF000000 | var3 & 16777215, var5);
      uiSupport169.v1(var0 - var5, var1 - var5, var4, var4, -1, 2.5F * var2, var5);
      v1(var0, var1, var4, var4, var2);
   }

   private static void v1(float var0, float var1, float var2, float var3, float var4) {
      float var5 = Math.max(uiSupport169.v2(), 1.0F * var4);
      float var6 = var2 + 2.0F * var5;
      float var7 = var3 + 2.0F * var5;
      uiSupport169.v1(var0 - var6 / 2.0F, var1 - var7 / 2.0F, var6, var7, 1073741824, var5, Math.min(var6, var7) / 2.0F);
   }

   private static void v1(float var0, float var1, float var2, float var3, float var4, float var5) {
      uiSupport169.v1(var0 - var2 / 2.0F, var1 - var3 / 2.0F, var2, var3, var4, 1493172224, 2.0F * var5, 0.0F, 1.5F * var5);
   }

   private static void v2(float var0, float var1, float var2, int var3) {
      float var4 = 14.0F * var2;
      float var5 = 26.0F * var2;
      v1(var0, var1, var4, var5, var4 / 2.0F, var2);
      uiSupport169.v1(var0 - var4 / 2.0F, var1 - var5 / 2.0F, var4, var5, -1, var4 / 2.0F);
      float var6 = var4 - 5.0F * var2;
      float var7 = var5 - 5.0F * var2;
      uiSupport169.v1(var0 - var6 / 2.0F, var1 - var7 / 2.0F, var6, var7, 0xFF000000 | var3 & 16777215, var6 / 2.0F);
      v1(var0, var1, var4, var5, var2);
   }

   private static void v3(float var0, float var1, float var2, int var3) {
      float var4 = 16.0F * var2;
      float var5 = var4 / 2.0F;
      v1(var0, var1, var4, var4, var5, var2);
      uiSupport169.v1(var0 - var5, var1 - var5, var4, var4, -1, var5);
      float var6 = var4 - 7.0F * var2;
      uiSupport169.v1(var0 - var6 / 2.0F, var1 - var6 / 2.0F, var6, var6, 0xFF000000 | var3 & 16777215, var6 / 2.0F);
      v1(var0, var1, var4, var4, var2);
   }

   private int v3(float var1, float var2) {
      float var3 = this.v47;
      float var4 = 26.0F * var3;
      if (var1 < this.v59 || var1 > this.v59 + this.v63) {
         return 0;
      } else if (var2 >= this.v53 && var2 <= this.v53 + this.v64) {
         return 1;
      } else if (var2 >= this.v61 && var2 <= this.v61 + var4) {
         return 2;
      } else {
         return var2 >= this.v66 && var2 <= this.v66 + var4 ? 3 : 0;
      }
   }

   @Override
   public boolean v1(float var1, float var2, int var3) {
      this.v10();
      if (var3 != 0 || !this.v1(var1, var2)) {
         return false;
      } else if (this.v37.v1(var1, var2) && this.v37.v1(var1, var2, var3)) {
         return true;
      } else {
         this.v37.v2();
         int var4 = this.v5(var1, var2);
         if (var4 >= 0 && this.v48 != null) {
            uiSupport148.v1(uiSupport146.OPTION_PICKED);
            v1(this.v48, var4);
            return true;
         } else {
            int var5 = this.v3(var1, var2);
            if (var5 != 0) {
               this.v60 = var5;
               this.v4(var1, var2);
            }

            return true;
         }
      }
   }

   @Override
   public hudSupport54 v2(float var1, float var2) {
      this.v10();
      if (!this.v1(var1, var2)) {
         return hudSupport54.ARROW;
      } else {
         if (this.v37.v1(var1, var2)) {
            hudSupport54 var3 = this.v37.v2(var1, var2);
            if (var3 != hudSupport54.ARROW) {
               return var3;
            }
         }

         return this.v3(var1, var2) == 0 && this.v5(var1, var2) < 0 ? hudSupport54.ARROW : hudSupport54.POINTER;
      }
   }

   @Nullable
   @Override
   public hudSupport54 v31() {
      return this.v60 != 0 ? hudSupport54.POINTER : this.v37.v31();
   }

   @Override
   public boolean v1(float var1, float var2, int var3, float var4, float var5) {
      if (var3 != 0) {
         return false;
      } else if (this.v60 == 0) {
         return this.v37.v1(var1, var2, var3, var4, var5);
      } else {
         this.v10();
         this.v4(var1, var2);
         return true;
      }
   }

   @Override
   public boolean v4(float var1, float var2, int var3) {
      if (var3 == 0 && this.v60 != 0) {
         this.v60 = 0;
         return true;
      } else {
         return this.v37.v4(var1, var2, var3);
      }
   }

   @Override
   public boolean v2(int var1, int var2) {
      return this.v37.v2(var1, var2);
   }

   @Override
   public boolean v3(int var1, int var2) {
      return this.v37.v3(var1, var2);
   }

   private void v4(float var1, float var2) {
      switch (this.v60) {
         case 1:
            this.v46 = Math.clamp((var1 - this.v59) / this.v63, 0.0F, 1.0F);
            this.v51 = 1.0F - Math.clamp((var2 - this.v53) / this.v64, 0.0F, 1.0F);
            this.v9();
            break;
         case 2:
            float var4 = 14.0F * this.v47;
            this.v49 = Math.clamp((var1 - this.v1(var4)) / this.v3(var4), 0.0F, 1.0F) * 360.0F;
            this.v9();
            break;
         case 3:
            float var3 = 16.0F * this.v47;
            this.v50 = Math.round(Math.clamp((var1 - this.v1(var3)) / this.v3(var3), 0.0F, 1.0F) * 255.0F);
            this.v9();
      }
   }

   private int v5(float var1, float var2) {
      return this.v40 == null ? -1 : this.v40.v1(this.v59, this.v82, this.v47, var1, var2);
   }

   private static String[] v1(EnumSetting<?> var0) {
      Enum[] var1 = var0.getValues();
      String[] var2 = new String[var1.length];

      for (int var3 = 0; var3 < var1.length; var3++) {
         var2[var3] = uiSupport78.v1(var1[var3]);
      }

      return var2;
   }

   private static int v2(EnumSetting<?> var0) {
      return var0.getValue().ordinal();
   }

   private static <E extends Enum<E>> void v1(EnumSetting<E> var0, int var1) {
      var0.setValue((E)var0.getValues()[var1]);
   }

   private static float[] v1(int var0, int var1, int var2) {
      float var3 = var0 / 255.0F;
      float var4 = var1 / 255.0F;
      float var5 = var2 / 255.0F;
      float var6 = Math.max(var3, Math.max(var4, var5));
      float var7 = Math.min(var3, Math.min(var4, var5));
      float var8 = var6 - var7;
      float var10 = var6 == 0.0F ? 0.0F : var8 / var6;
      float var11;
      if (var8 == 0.0F) {
         var11 = 0.0F;
      } else if (var6 == var3) {
         var11 = 60.0F * ((var4 - var5) / var8 % 6.0F);
      } else if (var6 == var4) {
         var11 = 60.0F * ((var5 - var3) / var8 + 2.0F);
      } else {
         var11 = 60.0F * ((var3 - var4) / var8 + 4.0F);
      }

      if (var11 < 0.0F) {
         var11 += 360.0F;
      }

      return new float[]{var11, var10, var6};
   }

   private static int v2(float var0, float var1, float var2) {
      var0 = (var0 % 360.0F + 360.0F) % 360.0F;
      float var3 = var2 * var1;
      float var4 = var3 * (1.0F - Math.abs(var0 / 60.0F % 2.0F - 1.0F));
      float var5 = var2 - var3;
      float var6;
      float var7;
      float var8;
      if (var0 < 60.0F) {
         var6 = var3;
         var7 = var4;
         var8 = 0.0F;
      } else if (var0 < 120.0F) {
         var6 = var4;
         var7 = var3;
         var8 = 0.0F;
      } else if (var0 < 180.0F) {
         var6 = 0.0F;
         var7 = var3;
         var8 = var4;
      } else if (var0 < 240.0F) {
         var6 = 0.0F;
         var7 = var4;
         var8 = var3;
      } else if (var0 < 300.0F) {
         var6 = var4;
         var7 = 0.0F;
         var8 = var3;
      } else {
         var6 = var3;
         var7 = 0.0F;
         var8 = var4;
      }

      int var9 = Math.round((var6 + var5) * 255.0F);
      int var10 = Math.round((var7 + var5) * 255.0F);
      int var11 = Math.round((var8 + var5) * 255.0F);
      return 0xFF000000 | var9 << 16 | var10 << 8 | var11;
   }

   public final class Part1 implements HEXSupport.Part1 {
      public Part1() {
      }

      @Override
      public int v1() {
         return uiSupport84.this.v8();
      }

      @Override
      public void v1(int var1) {
         uiSupport84.this.v1(var1);
         uiSupport84.this.v9();
      }

      @Override
      public void v2(int var1) {
         uiSupport84.this.v50 = Math.max(0, Math.min(255, var1));
         uiSupport84.this.v9();
      }
   }
}
