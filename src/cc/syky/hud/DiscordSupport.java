package cc.syky.hud;

import cc.syky.WhatSSupport2;
import cc.syky.sykyRecord;
import cc.syky.cloud.WhatSSupport;
import cc.syky.module.utilities.FogBlurSupport;
import cc.syky.module.visual.visualSupport2;
import cc.syky.ui.DiscordPTBSupport;
import cc.syky.ui.SignInSupport;
import cc.syky.ui.uiRecord6;
import cc.syky.ui.uiRecord7;
import cc.syky.ui.uiSupport169;
import net.minecraft.class_2960;
import org.jetbrains.annotations.Nullable;

public final class DiscordSupport {
   private static final String v1 = "syky_sans_strong";
   private static final class_2960 v2 = class_2960.method_60655("syky", "textures/ui/watermark/logo.png");
   private static final class_2960 v3 = class_2960.method_60655("syky", "textures/ui/icons/discord.png");
   private static final int v4 = 0;
   private final sykyRecord v5;
   private final WhatSSupport2 v6 = new WhatSSupport2();
   private final hudSupport5 v7 = new hudSupport5();
   private final hudSupport3 v8 = new hudSupport3();
   private final hudSupport58 v9 = new hudSupport58();
   private final hudSupport57 v10 = new hudSupport57(0.0F, 70.0F, 130.0F);
   private final hudSupport57 v11 = new hudSupport57(0.0F, 70.0F, 130.0F);
   private final float[] v12 = new float[4];
   private boolean v13;
   private float v14 = 0.5F;
   private float v15 = 0.5F;
   private uiRecord6 v16 = uiRecord6.CENTRED;
   private boolean v18;
   private boolean v19;
   @Nullable
   private visualSupport2 v17;
   private float v20;
   private float v21;
   private float v22;
   private float v24;
   private float v25;
   private float v26;
   private float v27;
   private float v28;
   private float v29 = 1.0F;
   private final float[] v30 = new float[4];
   private long v32;
   private static final float v23 = 16.666666F;

   public DiscordSupport(sykyRecord var1) {
      this.v5 = var1;
      this.v7.v1(false);
   }

   public String v1() {
      return this.v5.v2();
   }

   public void v2() {
      this.v19 = true;
   }

   private void v1(int var1, int var2) {
      float var3 = SignInSupport.v1(SignInSupport.v1((float)var1, (float)var2) * 0.30104166F * hudSupport62.v1(), 0.780027F, var1, var2, 0.86F);
      float var4 = var3 * 1.282007F;
      this.v27 = var3;
      this.v28 = var4;
      this.v29 = var3 / 578.0F;
      this.v16 = uiRecord6.v1(var1, var2, var3, var4, 56.0F * this.v29, 140.0F * this.v29, 160.0F * this.v29);
      this.v25 = var1 * this.v14 - var3 * 0.5F;
      this.v26 = var2 * this.v15 - var4 * 0.5F;
      this.v6.v1(this.v5, 498.0F);
      this.v9.v8(this.v29);
      this.v9.v7(Math.max(0.0F, this.v6.v3() * this.v29 - this.v5()));
   }

   private float v5() {
      return Math.max(0.0F, this.v28 - 98.0F * this.v29);
   }

   public boolean v1(int var1, int var2, float var3, float var4, boolean var5) {
      float var6 = this.v12();
      this.v15();
      this.v1(var1, var2);
      if (!this.v18 && this.v17 == null) {
         this.v14();
      }

      this.v9.v9(var6);
      this.v8();
      this.v7.v1(!this.v19, var6);
      if (this.v7.v2()) {
         return false;
      } else {
         boolean var7 = this.v7.v3();
         if (hudSupport.v1() && (!var7 || this.v19)) {
            if (this.v19) {
               this.v8.v2();
            } else if (this.v18 && !this.v8.v4()) {
               this.v8.v1(this.v25, this.v26, this.v27, this.v28, var3, var4);
            }
         } else {
            this.v8.v3();
         }

         this.v8.v1(this.v25, this.v26, this.v27, this.v28, hudSupport.v3());
         float var8 = var7 ? Float.NEGATIVE_INFINITY : var3;
         float var9 = var7 ? Float.NEGATIVE_INFINITY : var4;
         uiSupport169.v1(null);

         try {
            boolean var10 = hudSupport2.v1(this.v8, this.v25, this.v26, this.v27, this.v28, this.v29);

            try {
               this.v6();
               boolean var11 = var7 && this.v9();

               try {
                  this.v7(var8, var9);
                  this.v7();
                  this.v3(var8, var9);
               } finally {
                  if (var11) {
                     this.v10();
                  }
               }
            } finally {
               if (var10) {
                  hudSupport2.v1();
               }
            }
         } finally {
            uiSupport169.v15();
         }

         this.v1(var8, var9, var5);
         return true;
      }
   }

   private void v1(float var1, float var2, boolean var3) {
      hudSupport54 var4 = this.v18 ? hudSupport54.POINTER : null;
      if (!this.v1(var1, var2)) {
         if (var4 != null) {
            hudSupport53.v1(var4, var3, hudSupport54.ARROW);
         }
      } else {
         boolean var5 = this.v10(var1, var2) || this.v6(var1, var2) || var2 < this.v26 + 56.0F * this.v29;
         hudSupport53.v1(var4, var3, var5 ? hudSupport54.POINTER : hudSupport54.ARROW);
      }
   }

   private void v6() {
      float var1 = this.v7.v8();
      float var2 = this.v7.v9();
      float var3 = this.v25 + this.v27 * 0.5F;
      float var4 = this.v26 + this.v28 * 0.5F;
      float var5 = this.v27 * var1;
      float var6 = this.v28 * var2;
      float var7 = var3 - var5 * 0.5F;
      float var8 = var4 - var6 * 0.5F;
      float var9 = this.v29 * Math.min(var1, var2);
      float var10 = 40.0F * var9;
      uiSupport169.v2(var7, var8, var5, var6, var10, var9);
      uiSupport169.v2(var7, var8, var5, var6, uiRecord7.v1(var10), WhatSSupport.v6);
      uiSupport169.v19();
   }

   private void v7() {
      uiSupport169.v2(
         this.v25, this.v26, this.v27, this.v28, SignInSupport.v1(234881023, this.v29), SignInSupport.v2(this.v29), uiRecord7.v1(40.0F * this.v29), 1.0F
      );
   }

   private void v3(float var1, float var2) {
      uiSupport169.v2(v2, this.v25 + 17.0F * this.v29, this.v26 + 14.0F * this.v29, 34.0F * this.v29, 34.0F * this.v29, -1, uiRecord7.ZERO);
      uiSupport169.v4("syky_sans_strong", "syky", this.v25 + 62.0F * this.v29, this.v26 + 31.0F * this.v29 - 18.990244F * this.v29, 28.0F * this.v29, -1);
      this.v4(var1, var2);
   }

   private void v4(float var1, float var2) {
      float var3 = this.v25 + 482.0F * this.v29;
      float var4 = this.v26 + 20.0F * this.v29;
      float var5 = 74.0F * this.v29;
      float var6 = 25.0F * this.v29;
      this.v10.v2(v1(var1, var2, var3, var4, var5, var6) ? 1.0F : 0.0F);
      float var7 = this.v10.v2();
      uiRecord7 var8 = uiRecord7.v1(Math.min(17.0F * this.v29, var6 * 0.5F));
      uiSupport169.v1(var3, var4, var5, var6, v1(-419430401, -1, var7), var8);
      uiSupport169.v1(var3, var4, var5, var6, SignInSupport.v1(-1, this.v29), SignInSupport.v2(this.v29), var8, 1.0F);
      uiSupport169.v3(
         "syky_sans_strong",
         FogBlurSupport.v1("whatsnew.close", "Close"),
         var3 + var5 * 0.5F,
         var4 + var6 * 0.5F - 8.40875F * this.v29,
         14.0F * this.v29,
         -14606047
      );
   }

   private static int v1(int var0, int var1, float var2) {
      if (var2 <= 0.0F) {
         return var0;
      } else if (var2 >= 1.0F) {
         return var1;
      } else {
         int var3 = 0;

         for (byte var4 = 0; var4 < 32; var4 += 8) {
            int var5 = var0 >>> var4 & 0xFF;
            int var6 = var1 >>> var4 & 0xFF;
            var3 |= var5 + Math.round((var6 - var5) * var2) << var4;
         }

         return var3;
      }
   }

   private void v5(float var1, float var2) {
      if (this.v13) {
         this.v11.v2(this.v6(var1, var2) ? 1.0F : 0.0F);
         float var3 = 0.45F + 0.55F * this.v11.v2();
         int var4 = v1(-1, var3);
         float var5 = 20.0F * this.v29;
         float var6 = this.v12[0] + 12.0F * this.v29;
         float var7 = this.v12[1] + this.v12[3] * 0.5F;
         uiSupport169.v2(v3, var6, var7 - var5 * 0.5F, var5, var5, var4, uiRecord7.ZERO);
         uiSupport169.v4(
            "syky_sans_strong",
            FogBlurSupport.v1("whatsnew.discord", "Discord"),
            var6 + var5 + 9.0F * this.v29,
            var7 - 10.81125F * this.v29,
            18.0F * this.v29,
            var4
         );
      }
   }

   private void v8() {
      this.v13 = false;
      float var1 = uiSupport169.v2("syky_sans_strong", FogBlurSupport.v1("whatsnew.discord", "Discord"), 18.0F * this.v29);
      if (!(var1 <= 0.0F)) {
         float var2 = 20.0F * this.v29 + 9.0F * this.v29 + var1;
         float var3 = var2 + 24.0F * this.v29;
         float var4 = WhatSSupport2.v2() * this.v29;
         float var5 = this.v26 + 56.0F * this.v29 - this.v9.v1() + this.v6.v1() * this.v29;
         if (!(var5 + var4 <= this.v26) && !(var5 >= this.v26 + this.v28)) {
            this.v12[0] = this.v25 + (this.v27 - var3) * 0.5F;
            this.v12[1] = var5;
            this.v12[2] = var3;
            this.v12[3] = var4;
            this.v13 = true;
         }
      }
   }

   private boolean v6(float var1, float var2) {
      return this.v13 && v1(var1, var2, this.v12[0], this.v12[1], this.v12[2], this.v12[3]);
   }

   private static int v1(int var0, float var1) {
      int var2 = Math.round((var0 >>> 24 & 0xFF) * Math.max(0.0F, Math.min(1.0F, var1)));
      return var2 << 24 | var0 & 16777215;
   }

   private void v7(float var1, float var2) {
      float var3 = this.v25 + 40.0F * this.v29;
      float var4 = this.v26 + 56.0F * this.v29;
      float var5 = this.v27 - 80.0F * this.v29;
      float var6 = this.v5();
      if (!(var5 <= 0.0F) && !(var6 <= 0.0F)) {
         float var7 = v8(this.v9.v1(), 22.0F * this.v29);
         float var8 = v8(this.v9.v3() - this.v9.v1(), 90.0F * this.v29);
         boolean var9 = uiSupport169.v5();
         uiSupport169.v6(this.v25, this.v26, this.v27, this.v28);

         try {
            this.v6.v1(var3, var4 - this.v9.v1(), var5, this.v29);
            this.v5(var1, var2);
         } finally {
            if (var9) {
               uiSupport169.v1(
                  this.v25,
                  this.v26,
                  this.v27,
                  this.v28,
                  uiRecord7.v1(40.0F * this.v29),
                  this.v26,
                  this.v26 + 96.0F * this.v29,
                  4.5F * this.v29 * var7,
                  v9(0.1F, var7),
                  this.v26,
                  this.v26 + this.v28 - 64.0F * this.v29,
                  this.v26 + this.v28,
                  v9(0.1F, var8)
               );
            }

            uiSupport169.v17();
         }
      }
   }

   private static float v8(float var0, float var1) {
      if (!(var1 <= 0.0F) && !(var0 <= 0.0F)) {
         return var0 >= var1 ? 1.0F : var0 / var1;
      } else {
         return 0.0F;
      }
   }

   private static float v9(float var0, float var1) {
      return 1.0F - (1.0F - var0) * var1;
   }

   private boolean v9() {
      float var1 = hudSupport2.v1(this.v29);
      this.v30[0] = this.v25 - var1;
      this.v30[1] = this.v26 - var1;
      this.v30[2] = this.v27 + 2.0F * var1;
      this.v30[3] = this.v28 + 2.0F * var1;
      return uiSupport169.v2(this.v30[0], this.v30[1], this.v30[2], this.v30[3]);
   }

   private void v10() {
      float var1 = this.v25 + this.v27 * 0.5F;
      float var2 = this.v26 + this.v28 * 0.5F;
      float var3 = this.v11();
      float var4 = 2.0F * var3 + 1.0F;
      float var5 = this.v7.v8();
      float var6 = this.v7.v9();
      float var7 = var1 + (this.v30[0] - var1) * var5 - var4;
      float var8 = var2 + (this.v30[1] - var2) * var6 - var4;
      float var9 = var1 + (this.v30[0] + this.v30[2] - var1) * var5 + var4;
      float var10 = var2 + (this.v30[1] + this.v30[3] - var2) * var6 + var4;
      uiSupport169.v1(this.v7.v7(), var1, var2, var5, var6, var3, var7, var8, var9 - var7, var10 - var8);
   }

   private float v11() {
      return hudSupport70.v1() ? this.v7.v10() * this.v29 : 0.0F;
   }

   private float v12() {
      long var1 = System.nanoTime();
      long var3 = this.v32;
      this.v32 = var1;
      return var3 == 0L ? 16.666666F : (float)(var1 - var3) / 1000000.0F;
   }

   private boolean v13() {
      return !this.v7.v3() && !this.v7.v2();
   }

   public boolean v1(float var1, float var2) {
      return v1(var1, var2, this.v25, this.v26, this.v27, this.v28);
   }

   public boolean v2(float var1, float var2) {
      return this.v13() && this.v1(var1, var2);
   }

   private boolean v10(float var1, float var2) {
      return v1(var1, var2, this.v25 + 482.0F * this.v29, this.v26 + 20.0F * this.v29, 74.0F * this.v29, 25.0F * this.v29);
   }

   public boolean v1(float var1, float var2, int var3) {
      if (!this.v13() || !this.v1(var1, var2)) {
         return false;
      } else if (var3 != 0) {
         return true;
      } else if (this.v10(var1, var2)) {
         this.v2();
         return true;
      } else if (this.v6(var1, var2)) {
         DiscordPTBSupport.v1();
         return true;
      } else {
         if (var2 < this.v26 + 56.0F * this.v29) {
            this.v18 = true;
            this.v17 = null;
            if (hudSupport.v1()) {
               this.v8.v1(this.v25, this.v26, this.v27, this.v28, var1, var2);
            }
         }

         return true;
      }
   }

   public boolean v1(int var1, int var2, float var3, float var4) {
      if (this.v18 && var1 > 0 && var2 > 0) {
         this.v14 = this.v16.v1(this.v14, var3 / var1);
         this.v15 = this.v16.v2(this.v15, var4 / var2);
         return true;
      } else {
         return false;
      }
   }

   public boolean v3() {
      if (!this.v18) {
         return false;
      } else {
         this.v18 = false;
         this.v8.v1();
         this.v14();
         return true;
      }
   }

   public boolean v1(float var1, float var2, double var3) {
      if (this.v13() && this.v1(var1, var2)) {
         if (this.v9.v3() > 0.0F) {
            this.v9.v2((float)(-var3) * 60.0F * this.v29);
         }

         return true;
      } else {
         return false;
      }
   }

   public void v4() {
      this.v3();
   }

   private void v14() {
      float var1 = this.v16.v1(this.v14);
      float var2 = this.v16.v2(this.v15);
      if (var1 == this.v14 && var2 == this.v15) {
         this.v17 = null;
      } else {
         this.v20 = this.v14;
         this.v21 = this.v15;
         this.v22 = var1;
         this.v24 = var2;
         this.v17 = new visualSupport2(380L, hudSupport60::v3);
      }
   }

   private void v15() {
      visualSupport2 var1 = this.v17;
      if (var1 != null) {
         float var2 = var1.v1();
         this.v14 = this.v20 + (this.v22 - this.v20) * var2;
         this.v15 = this.v21 + (this.v24 - this.v21) * var2;
         if (var1.v2()) {
            this.v14 = this.v22;
            this.v15 = this.v24;
            this.v17 = null;
         }
      }
   }

   private static boolean v1(float var0, float var1, float var2, float var3, float var4, float var5) {
      return var0 >= var2 && var0 < var2 + var4 && var1 >= var3 && var1 < var3 + var5;
   }
}
