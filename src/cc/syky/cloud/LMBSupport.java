package cc.syky.cloud;

import cc.syky.config.BooleanSetting;
import cc.syky.config.ColorSetting;
import cc.syky.config.SettingCondition;
import cc.syky.hud.AbstractHudWidget;
import cc.syky.hud.AutoSupport;
import cc.syky.hud.hudRecord4;
import cc.syky.hud.hudSupport40;
import cc.syky.hud.hudSupport49;
import cc.syky.hud.hudSupport52;
import cc.syky.ui.uiRecord7;
import java.util.Arrays;
import net.minecraft.class_1041;
import net.minecraft.class_304;
import net.minecraft.class_310;
import net.minecraft.class_315;
import net.minecraft.class_3675;

public final class LMBSupport extends AbstractHudWidget {
   public static final String v2 = "keystrokes";
   private static final float v3 = 211.0F;
   private static final float v4 = 67.0F;
   private static final float v5 = 20.0F;
   private static final float v6 = 32.0F;
   private static final float v7 = 1.213F;
   private static final float v8 = 72.0F;
   private static final float v9 = 0.0F;
   private static final float v10 = 0.0F;
   private static final float v11 = 72.0F;
   private static final float v12 = 72.0F;
   private static final float v13 = 72.0F;
   private static final float v14 = 144.0F;
   private static final float v15 = 72.0F;
   private static final float v16 = 0.0F;
   private static final float v18 = 144.0F;
   private static final float v19 = 211.0F;
   private static final float v17 = 51.0F;
   private static final float v20 = 60.0F;
   private static final float v21 = 24.0F;
   private static final float v22 = 92.0F;
   private static final float v24 = 3.0F;
   private static final float v25 = 199.0F;
   private static final float v26 = 103.0F;
   private static final float v27 = 67.0F;
   private static final float v28 = 0.0F;
   private static final float v29 = 108.0F;
   private static final float v30 = 0.05F;
   private static final int v32 = 1308622847;
   private static final float v23 = 0.18F;
   private static final float v33 = 0.16F;
   private static final float v31 = 0.07F;
   private static final String v34 = "LMB";
   private static final String v36 = "RMB";
   private static final int v38 = 0;
   private static final int v42 = 1;
   private static final int v43 = 2;
   private static final int v37 = 3;
   private static final int v48 = 4;
   private static final int v40 = 5;
   private static final int v44 = 6;
   private static final int v47 = 7;
   private static final int v49 = 0;
   private static final int v46 = 1;
   private static final float v51 = 0.004F;
   private static final String[] v50 = v46();
   private final cloudSupport101 v60;
   private final BooleanSetting v59;
   private final ColorSetting v53;
   private final BooleanSetting v63;
   private final BooleanSetting v64;
   private final BooleanSetting v61;
   private final BooleanSetting v66;
   private final BooleanSetting v68;
   private final float[] v52 = new float[7];
   private final boolean[] v75 = new boolean[7];
   private final float[] v73 = new float[2];
   private final float[] v74 = new float[2];
   private final int[] v72 = new int[2];
   private long v80;

   public LMBSupport(cloudSupport101 var1, hudSupport52 var2, float var3, float var4) {
      super("keystrokes", 11, var2, var3, var4);
      this.v60 = var1;
      AutoSupport var5 = this.v2();
      this.v59 = var5.v1(new BooleanSetting("pressedBackground", false));
      this.v53 = var5.v1(new ColorSetting("pressedBackgroundColor", 1308622847).setCondition(this.v59));
      this.v63 = var5.v1(new BooleanSetting("space", true));
      this.v64 = var5.v2(new BooleanSetting("mouseButtons", true));
      this.v61 = var5.v1(new BooleanSetting("mouseLabels", true), SettingCondition.v1(this.v64));
      this.v66 = var5.v1(new BooleanSetting("clicksPerSecond", true), SettingCondition.v1(this.v64));
      this.v68 = var5.v1(new BooleanSetting("smooth", true));
   }

   @Override
   public AbstractHudWidget.Part1 v3(hudSupport40 var1, float var2) {
      return this.v12(this.v6(211.0F, var2), this.v6(this.v44(), var2));
   }

   @Override
   public void v1(hudSupport40 var1, hudRecord4 var2, float var3) {
      float var4 = var2.v2();
      float var5 = var2.v3();
      float var6 = 20.0F * var3;
      this.v1(var1, var4, var5, 72.0F, 0.0F, 67.0F, 67.0F, var6, var3);
      this.v1(var1, var4, var5, 0.0F, 72.0F, 67.0F, 67.0F, var6, var3);
      this.v1(var1, var4, var5, 72.0F, 72.0F, 67.0F, 67.0F, var6, var3);
      this.v1(var1, var4, var5, 144.0F, 72.0F, 67.0F, 67.0F, var6, var3);
      if (this.v63.getValue()) {
         this.v1(var1, var4, var5, 0.0F, 144.0F, 211.0F, 51.0F, var6, var3);
      }

      if (this.v64.getValue()) {
         float var7 = this.v40();
         this.v1(var1, var4, var5, 0.0F, var7, 103.0F, 67.0F, var6, var3);
         this.v1(var1, var4, var5, 108.0F, var7, 103.0F, 67.0F, var6, var3);
      }
   }

   @Override
   public void v2(hudSupport40 var1, hudRecord4 var2, float var3) {
      float var4 = var2.v2();
      float var5 = var2.v3();
      boolean var6 = this.v68.getValue();
      float var7 = this.v47();
      this.v1(var7, var6);
      this.v1(0, var1.v6().v1(), this.v75[5], var7, var6);
      this.v1(1, var1.v6().v2(), this.v75[6], var7, var6);
      this.v1(var4, var5, 72.0F, 0.0F, 0, "W", var3);
      this.v1(var4, var5, 0.0F, 72.0F, 1, "A", var3);
      this.v1(var4, var5, 72.0F, 72.0F, 2, "S", var3);
      this.v1(var4, var5, 144.0F, 72.0F, 3, "D", var3);
      if (this.v63.getValue()) {
         this.v2(var4, var5, 0.0F, 144.0F, 211.0F, 51.0F, this.v52[4], var3);
         this.v2(
            hudSupport49.v21,
            var4 + this.v6(60.0F, var3),
            var5 + this.v6(168.0F, var3),
            this.v2(60.0F, 92.0F, var3),
            this.v2(168.0F, 3.0F, var3),
            this.v1(v11(this.v52[4])),
            uiRecord7.v1(1.5F * var3)
         );
      }

      if (this.v64.getValue()) {
         this.v1(var4, var5, 0.0F, 0, "LMB", var3);
         this.v1(var4, var5, 108.0F, 1, "RMB", var3);
      }
   }

   private float v40() {
      return this.v63.getValue() ? 199.0F : 144.0F;
   }

   private float v44() {
      if (this.v64.getValue()) {
         return this.v40() + 67.0F;
      } else {
         return this.v63.getValue() ? 195.0F : 139.0F;
      }
   }

   private float v47() {
      long var1 = System.nanoTime();
      long var3 = this.v80;
      this.v80 = var1;
      if (var3 == 0L) {
         return 0.0F;
      } else {
         float var5 = (float)(var1 - var3) / 1.0E9F;
         if (var5 < 0.0F) {
            return 0.0F;
         } else {
            return var5 > 0.1F ? 0.1F : var5;
         }
      }
   }

   private void v1(float var1, boolean var2) {
      this.v49();

      for (int var3 = 0; var3 < this.v52.length; var3++) {
         this.v52[var3] = v1(this.v52[var3], this.v75[var3] ? 1.0F : 0.0F, var1, 0.18F, var2);
      }
   }

   private void v1(int var1, int var2, boolean var3, float var4, boolean var5) {
      boolean var6 = this.v66.getValue() && var2 > 0;
      if (var6) {
         this.v72[var1] = var2;
      }

      this.v73[var1] = v1(this.v73[var1], var6 ? 1.0F : 0.0F, var4, 0.16F, var5);
      if (this.v73[var1] > 0.0F) {
         this.v74[var1] = 0.0F;
      } else {
         this.v74[var1] = v2(this.v74[var1], var3 ? 1.0F : 0.05F, var4, 0.07F, var5);
      }
   }

   private void v1(float var1, float var2, float var3, float var4, int var5, String var6, float var7) {
      this.v2(var1, var2, var3, var4, 67.0F, 67.0F, this.v52[var5], var7);
      this.v1(var1, var2, var3, var4, 67.0F, 67.0F, var6, v11(this.v52[var5]), var7);
   }

   private void v1(float var1, float var2, float var3, int var4, String var5, float var6) {
      float var7 = this.v40();
      this.v2(var1, var2, var3, var7, 103.0F, 67.0F, this.v52[5 + var4], var6);
      if (this.v73[var4] > 0.0F) {
         this.v1(var1, var2, var3, var7, 103.0F, 67.0F, v3(this.v72[var4]), v12(this.v73[var4]), var6);
      } else if (this.v61.getValue()) {
         this.v1(var1, var2, var3, var7, 103.0F, 67.0F, var5, v12(this.v74[var4]), var6);
      }
   }

   private void v2(float var1, float var2, float var3, float var4, float var5, float var6, float var7, float var8) {
      if (this.v59.getValue() && !(var7 <= 0.0F)) {
         int var9 = v2(this.v53.getValue(), var7);
         if (var9 >>> 24 != 0) {
            this.v1(
               var1 + this.v6(var3, var8), var2 + this.v6(var4, var8), this.v2(var3, var5, var8), this.v2(var4, var6, var8), var9, uiRecord7.v1(20.0F * var8)
            );
         }
      }
   }

   private void v49() {
      boolean[] var1 = this.v75;
      Arrays.fill(var1, false);
      class_310 var2 = this.v60.v1();
      if (var2 != null) {
         class_1041 var3 = var2.method_22683();
         class_315 var4 = var2.field_1690;
         if (var3 != null && var4 != null) {
            var1[0] = v1(var3, var4.field_1894);
            var1[1] = v1(var3, var4.field_1913);
            var1[2] = v1(var3, var4.field_1881);
            var1[3] = v1(var3, var4.field_1849);
            var1[4] = v1(var3, var4.field_1903);
            var1[5] = cloudSupport57.v1(var3, 0);
            var1[6] = cloudSupport57.v1(var3, 1);
         }
      }
   }

   private void v1(hudSupport40 var1, float var2, float var3, float var4, float var5, float var6, float var7, float var8, float var9) {
      this.v1(var1, var2 + this.v6(var4, var9), var3 + this.v6(var5, var9), this.v2(var4, var6, var9), this.v2(var5, var7, var9), var8);
   }

   private float v2(float var1, float var2, float var3) {
      return this.v6(var1 + var2, var3) - this.v6(var1, var3);
   }

   private void v1(float var1, float var2, float var3, float var4, float var5, float var6, String var7, int var8, float var9) {
      float var10 = var1 + this.v6(var3, var9) + this.v2(var3, var5, var9) * 0.5F;
      float var11 = var2 + this.v6(var4, var9) + (this.v2(var4, var6, var9) - 38.816F * var9) * 0.5F;
      this.v2("syky_sans_strong", var7, var10, var11, 32.0F * var9, var8);
   }

   private static float v1(float var0, float var1, float var2, float var3, boolean var4) {
      return var4 && !(var1 >= var0) ? v10(var0 + (var1 - var0) * v13(var2, var3)) : var1;
   }

   private static float v2(float var0, float var1, float var2, float var3, boolean var4) {
      return !var4 ? var1 : var0 + (var1 - var0) * v13(var2, var3);
   }

   private static float v13(float var0, float var1) {
      return 1.0F - (float)Math.exp(-var0 / var1);
   }

   private static float v10(float var0) {
      return var0 < 0.004F ? 0.0F : var0;
   }

   private static int v11(float var0) {
      return v12(0.05F + 0.95F * var0);
   }

   private static int v12(float var0) {
      return v13(var0) << 24 | 16777215;
   }

   private static int v2(int var0, float var1) {
      int var2 = v13((var0 >>> 24 & 0xFF) / 255.0F * var1);
      return var2 << 24 | var0 & 16777215;
   }

   private static int v13(float var0) {
      int var1 = (int)(var0 * 255.0F + 0.5F);
      if (var1 < 0) {
         return 0;
      } else {
         return var1 > 255 ? 255 : var1;
      }
   }

   private static boolean v1(class_1041 var0, class_304 var1) {
      int var2 = class_3675.method_15981(var1.method_1428()).method_1444();
      return class_3675.method_15987(var0, var2);
   }

   private static String v3(int var0) {
      return var0 >= 0 && var0 < v50.length ? v50[var0] : Integer.toString(var0);
   }

   private static String[] v46() {
      String[] var0 = new String[100];

      for (int var1 = 0; var1 < var0.length; var1++) {
         var0[var1] = Integer.toString(var1);
      }

      return var0;
   }
}
