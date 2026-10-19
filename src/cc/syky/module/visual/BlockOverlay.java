package cc.syky.module.visual;

import cc.syky.api.ModuleInfo;
import cc.syky.config.BooleanSetting;
import cc.syky.config.ColorSetting;
import cc.syky.config.EnumSetting;
import cc.syky.config.FloatSetting;
import cc.syky.config.SettingCondition;
import cc.syky.module.Module;
import cc.syky.module.ModuleCategory;
import cc.syky.ui.uiRecord14;
import java.util.ArrayList;
import java.util.List;
import net.fabricmc.fabric.api.client.rendering.v1.world.WorldRenderContext;
import net.minecraft.class_1934;
import net.minecraft.class_2338;
import net.minecraft.class_2350;
import net.minecraft.class_238;
import net.minecraft.class_239;
import net.minecraft.class_243;
import net.minecraft.class_247;
import net.minecraft.class_259;
import net.minecraft.class_265;
import net.minecraft.class_2680;
import net.minecraft.class_310;
import net.minecraft.class_3965;
import net.minecraft.class_2350.class_2351;
import net.minecraft.class_2350.class_2352;
import net.minecraft.class_239.class_240;
import net.minecraft.class_259.class_260;
import org.jetbrains.annotations.Nullable;

@ModuleInfo(
   name = "blockoverlay",
   displayName = "Block Overlay",
   category = ModuleCategory.VISUAL,
   group = "Crosshair & Highlights",
   description = "module.blockoverlay.description"
)
public final class BlockOverlay extends Module {
   private final EnumSetting<BlockOverlay.Part1> v2 = this.settings.add(new EnumSetting<>("style", BlockOverlay.Part1.CLASSIC));
   private final BooleanSetting outline = this.settings.add(new BooleanSetting("outline", true), SettingCondition.v1(this.v2, BlockOverlay.Part1.CLASSIC));
   private final ColorSetting outlineColor = this.settings.add(new ColorSetting("outlineColor", -5263441).setCondition(this.outline));
   private final FloatSetting thickness = this.settings.add(new FloatSetting("thickness", 0.5F, 0.5F, 6.0F).setCondition(this.outline));
   private final BooleanSetting fill = this.settings.add(new BooleanSetting("fill", true), SettingCondition.v1(this.v2, BlockOverlay.Part1.CLASSIC));
   private final ColorSetting fillColor = this.settings.add(new ColorSetting("fillColor", 436207615).setCondition(this.fill));
   private final BooleanSetting throughWalls = this.settings
      .add(new BooleanSetting("throughWalls", false), SettingCondition.v1(this.v2, BlockOverlay.Part1.CLASSIC));
   private final ColorSetting brightColor = this.settings.add(new ColorSetting("brightColor", -1), SettingCondition.v1(this.v2, BlockOverlay.Part1.BRIGHTNESS));
   private final FloatSetting brightness = this.settings
      .add(new FloatSetting("brightness", 0.4F, 0.05F, 1.0F), SettingCondition.v1(this.v2, BlockOverlay.Part1.BRIGHTNESS));
   private final BooleanSetting smooth = this.settings.add(new BooleanSetting("smooth", false));
   private final BooleanSetting sideOnly = this.settings.add(new BooleanSetting("sideOnly", false));
   private static final double v13 = 0.045;
   private static final double v14 = 8.0;
   private static final double v15 = 0.01;
   private static boolean v16;
   @Nullable
   private static BlockOverlay v18;
   private double v19;
   private double v17;
   private double v20;
   private boolean v21;
   private final List<class_238> v22 = new ArrayList<>();
   private final BlockOverlay.Part2 v24 = new BlockOverlay.Part2();
   @Nullable
   private class_265 v25;
   @Nullable
   private class_2350 v26;
   private double v27;
   private List<class_238> v28 = List.of();
   private class_265 v29 = class_259.method_1073();
   private long v30;
   private final uiRecord14 v32;

   public BlockOverlay(uiRecord14 var1) {
      this.v32 = var1;
   }

   @Override
   public void onEnableHook() {
      v18 = this;
      v16 = true;
   }

   @Override
   public void onDisableHook() {
      v16 = false;
      v18 = null;
      this.v21 = false;
   }

   public static boolean v17() {
      BlockOverlay var0 = v18;
      if (v16 && var0 != null && var0.v20()) {
         class_310 var1 = class_310.method_1551();
         if (var1.field_1761 == null) {
            return false;
         } else {
            class_1934 var2 = var1.field_1761.method_2920();
            return var2 == class_1934.field_9215 || var2 == class_1934.field_9220;
         }
      } else {
         return false;
      }
   }

   private boolean v20() {
      return this.v2.getValue() == BlockOverlay.Part1.BRIGHTNESS || this.outline.getValue() || this.fill.getValue();
   }

   private int v21() {
      int var1 = this.brightColor.getValue();
      int var2 = Math.round((var1 >>> 24 & 0xFF) * this.brightness.getValue());
      return var2 << 24 | var1 & 16777215;
   }

   @Override
   public void onWorldRenderContext(WorldRenderContext var1) {
      class_310 var2 = this.v32.v2().v1();
      if (var2.field_1687 != null && var2.field_1724 != null && var2.field_1761 != null && !var2.field_1690.field_1842) {
         class_1934 var3 = var2.field_1761.method_2920();
         if (var3 == class_1934.field_9215 || var3 == class_1934.field_9220) {
            class_239 var4 = var2.field_1765;
            if (var4 != null && var4.method_17783() == class_240.field_1332) {
               class_2338 var5 = ((class_3965)var4).method_17777();
               class_2680 var6 = var2.field_1687.method_8320(var5);
               if (!var6.method_26215()) {
                  class_265 var7 = var6.method_26218(var2.field_1687, var5);
                  if (!var7.method_1110()) {
                     boolean var8 = this.v2.getValue() == BlockOverlay.Part1.BRIGHTNESS;
                     boolean var9 = !var8 && this.throughWalls.getValue();
                     double var10 = var5.method_10263();
                     double var12 = var5.method_10264();
                     double var14 = var5.method_10260();
                     if (this.smooth.getValue()) {
                        long var16 = System.nanoTime();
                        double var18 = this.v21 ? Math.min((var16 - this.v30) / 1.0E9, 0.1) : 0.0;
                        this.v30 = var16;
                        double var20 = var10 - this.v19;
                        double var22 = var12 - this.v17;
                        double var24 = var14 - this.v20;
                        if (this.v21 && !(var20 * var20 + var22 * var22 + var24 * var24 > 64.0)) {
                           double var26 = 1.0 - Math.exp(-var18 / 0.045);
                           this.v19 += var20 * var26;
                           this.v17 += var22 * var26;
                           this.v20 += var24 * var26;
                        } else {
                           this.v19 = var10;
                           this.v17 = var12;
                           this.v20 = var14;
                           this.v21 = true;
                        }

                        var10 = this.v19;
                        var12 = this.v17;
                        var14 = this.v20;
                     } else {
                        this.v21 = false;
                     }

                     class_265 var28 = var7;
                     List var17 = var7.method_1090();
                     class_2350 var29 = null;
                     if (this.sideOnly.getValue()) {
                        class_3965 var19 = (class_3965)var4;
                        var29 = var19.method_17780();
                        class_243 var31 = var19.method_17784();
                        double var21 = v1(
                           var17,
                           var29,
                           var29.method_10166()
                              .method_10172(
                                 var31.field_1352 - var5.method_10263(), var31.field_1351 - var5.method_10264(), var31.field_1350 - var5.method_10260()
                              )
                        );
                        if (var7 != this.v25 || var29 != this.v26 || var21 != this.v27) {
                           this.v25 = var7;
                           this.v26 = var29;
                           this.v27 = var21;
                           this.v29 = v1(var7, var29, var21);
                           this.v28 = this.v29.method_1090();
                        }

                        if (this.v29.method_1110()) {
                           var29 = null;
                        } else {
                           var28 = this.v29;
                           var17 = this.v28;
                        }
                     }

                     if (var8 || this.fill.getValue()) {
                        int var30 = var8 ? this.v21() : this.fillColor.getValue();
                        if (var29 != null) {
                           this.v1(var29, this.v27, var10, var12, var14, var30, var8, var9);
                        } else {
                           this.v22.clear();

                           for (int var32 = 0; var32 < var17.size(); var32++) {
                              this.v22.add(((class_238)var17.get(var32)).method_989(var10, var12, var14));
                           }

                           if (var8) {
                              visualSupport9.v1(this.v22, var30);
                           } else {
                              visualSupport9.v1(this.v22, var30, var9);
                           }
                        }
                     }

                     if (!var8 && this.outline.getValue()) {
                        this.v24.v1 = var10;
                        this.v24.v2 = var12;
                        this.v24.v3 = var14;
                        this.v24.v4 = var17;
                        this.v24.v5 = this.outlineColor.getValue();
                        this.v24.v6 = this.thickness.getValue();
                        this.v24.v7 = var9;
                        this.v24.v8 = var29 == null ? -1 : var29.method_10166().ordinal();
                        this.v24.v9 = this.v27;
                        var28.method_1104(this.v24);
                     }
                  }
               }
            }
         }
      }
   }

   private void v1(class_2350 var1, double var2, double var4, double var6, double var8, int var10, boolean var11, boolean var12) {
      int var13 = var1.method_10166().ordinal();
      boolean var14 = var1.method_10171() == class_2352.field_11056;
      double var15 = var2 + (var13 == 0 ? var4 : (var13 == 1 ? var6 : var8));
      double var17 = var13 == 0 ? var6 : var4;
      double var19 = var13 == 2 ? var6 : var8;

      for (int var21 = 0; var21 < this.v28.size(); var21++) {
         class_238 var22 = this.v28.get(var21);
         double var23 = var13 == 0 ? var22.field_1322 : var22.field_1323;
         double var25 = var13 == 0 ? var22.field_1325 : var22.field_1320;
         double var27 = var13 == 2 ? var22.field_1322 : var22.field_1321;
         double var29 = var13 == 2 ? var22.field_1325 : var22.field_1324;
         if (var11) {
            visualSupport9.v2(var13, var14, var15, var17 + var23, var17 + var25, var19 + var27, var19 + var29, var10);
         } else {
            visualSupport9.v1(var13, var14, var15, var17 + var23, var17 + var25, var19 + var27, var19 + var29, var10, var12);
         }
      }
   }

   private static double v1(List<class_238> var0, class_2350 var1, double var2) {
      boolean var4 = var1.method_10171() == class_2352.field_11056;
      double var5 = var2;
      double var7 = 0.01;

      for (int var9 = 0; var9 < var0.size(); var9++) {
         class_238 var10 = (class_238)var0.get(var9);
         double var11 = var4 ? var10.method_990(var1.method_10166()) : var10.method_1001(var1.method_10166());
         double var13 = Math.abs(var11 - var2);
         if (var13 < var7) {
            var5 = var11;
            var7 = var13;
         }
      }

      return var5;
   }

   public static class_265 v1(class_265 var0, class_2350 var1, double var2) {
      class_2351 var4 = var1.method_10166();
      double var5 = var1.method_10171() == class_2352.field_11056 ? 0.01 : -0.01;
      class_265 var7 = class_259.method_1082(var0, v1(var4, var2 - var5, var2), class_247.field_16896);
      class_265 var8 = class_259.method_1082(var0, v1(var4, var2, var2 + var5), class_247.field_16896)
         .method_1096(var4.method_10172(-var5, 0.0, 0.0), var4.method_10172(0.0, -var5, 0.0), var4.method_10172(0.0, 0.0, -var5));
      return class_259.method_1072(var7, var8, class_247.field_16886);
   }

   private static class_265 v1(class_2351 var0, double var1, double var3) {
      double var5 = Math.min(var1, var3);
      double var7 = Math.max(var1, var3);
      return class_259.method_1081(
         var0.method_10172(var5, -1.0, -1.0),
         var0.method_10172(-1.0, var5, -1.0),
         var0.method_10172(-1.0, -1.0, var5),
         var0.method_10172(var7, 2.0, 2.0),
         var0.method_10172(2.0, var7, 2.0),
         var0.method_10172(2.0, 2.0, var7)
      );
   }

   public static enum Part1 {
      CLASSIC,
      BRIGHTNESS;

      private Part1() {
      }
   }

   public static final class Part2 implements class_260 {
      private static final double v10 = 0.001;
      public double v1;
      public double v2;
      public double v3;
      public List<class_238> v4 = List.of();
      public int v5;
      private final double[] v11 = new double[3];
      private final double[] v12 = new double[3];
      private final double[] v13 = new double[3];
      private final double[] v14 = new double[3];
      private final boolean[] v15 = new boolean[4];
      public float v6;
      public boolean v7;
      public int v8 = -1;
      public double v9;

      public Part2() {
      }

      public void consume(double var1, double var3, double var5, double var7, double var9, double var11) {
         if (this.v8 >= 0) {
            double var13 = this.v8 == 0 ? var1 : (this.v8 == 1 ? var3 : var5);
            double var15 = this.v8 == 0 ? var7 : (this.v8 == 1 ? var9 : var11);
            if (Math.abs(var13 - this.v9) > 1.0E-6 || Math.abs(var15 - this.v9) > 1.0E-6) {
               return;
            }
         }

         this.v11[0] = Math.min(var1, var7);
         this.v11[1] = Math.min(var3, var9);
         this.v11[2] = Math.min(var5, var11);
         this.v12[0] = Math.max(var1, var7);
         this.v12[1] = Math.max(var3, var9);
         this.v12[2] = Math.max(var5, var11);
         double var32 = this.v12[0] - this.v11[0];
         double var33 = this.v12[1] - this.v11[1];
         double var17 = this.v12[2] - this.v11[2];
         int var19 = var32 >= var33 && var32 >= var17 ? 0 : (var33 >= var17 ? 1 : 2);
         int var20 = var19 == 0 ? 1 : 0;
         int var21 = var19 == 2 ? 1 : 2;
         double var22 = (this.v11[var19] + this.v12[var19]) * 0.5;
         int var24 = 0;

         for (int var25 = 0; var25 < 4; var25++) {
            this.v15[var25] = this.v1(
               var19, var22, var20, this.v11[var20] + (var25 >> 1 == 1 ? 0.001 : -0.001), var21, this.v11[var21] + ((var25 & 1) == 1 ? 0.001 : -0.001)
            );
            var24 += this.v15[var25] ? 1 : 0;
         }

         int var34 = -1;
         if (var24 == 1) {
            for (int var26 = 0; var26 < 4 && var34 < 0; var26++) {
               var34 = this.v15[var26] ? var26 : -1;
            }
         } else if (var24 == 2 && this.v15[0] == this.v15[3]) {
            var34 = this.v15[0] ? 0 : 1;
         } else if (var24 == 3) {
            for (int var35 = 0; var35 < 4 && var34 < 0; var35++) {
               var34 = this.v15[var35] ? -1 : var35 ^ 3;
            }
         }

         if (var34 < 0) {
            visualSupport9.v1(
               this.v1 + var1,
               this.v2 + var3,
               this.v3 + var5,
               this.v1 + var7,
               this.v2 + var9,
               this.v3 + var11,
               this.v1 + 0.5,
               this.v2 + 0.5,
               this.v3 + 0.5,
               this.v5,
               this.v6,
               this.v7
            );
         } else {
            double var36 = var34 >> 1 == 1 ? 0.001 : -0.001;
            double var28 = (var34 & 1) == 1 ? 0.001 : -0.001;
            this.v13[var19] = var22;
            this.v13[var20] = this.v11[var20] + var36 * 100.0;
            this.v13[var21] = this.v11[var21] + var28 * 100.0;
            boolean var30 = this.v1(var19, this.v11[var19] - 0.001, var20, this.v11[var20] + var36, var21, this.v11[var21] + var28);
            boolean var31 = this.v1(var19, this.v12[var19] + 0.001, var20, this.v11[var20] + var36, var21, this.v11[var21] + var28);
            visualSupport9.v1(
               this.v1 + var1,
               this.v2 + var3,
               this.v3 + var5,
               this.v1 + var7,
               this.v2 + var9,
               this.v3 + var11,
               this.v1 + this.v13[0],
               this.v2 + this.v13[1],
               this.v3 + this.v13[2],
               this.v5,
               this.v6,
               this.v7,
               var30,
               var31
            );
         }
      }

      private boolean v1(int var1, double var2, int var4, double var5, int var7, double var8) {
         this.v14[var1] = var2;
         this.v14[var4] = var5;
         this.v14[var7] = var8;

         for (int var10 = 0; var10 < this.v4.size(); var10++) {
            if (this.v4.get(var10).method_1008(this.v14[0], this.v14[1], this.v14[2])) {
               return true;
            }
         }

         return false;
      }
   }
}
