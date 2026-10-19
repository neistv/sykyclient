package cc.syky.module.visual;

import cc.syky.account.accountSupport13;
import cc.syky.account.accountSupport14;
import cc.syky.api.ModuleInfo;
import cc.syky.config.BooleanSetting;
import cc.syky.config.ColorSetting;
import cc.syky.config.EnumSetting;
import cc.syky.config.FloatSetting;
import cc.syky.config.IntSetting;
import cc.syky.config.SettingCondition;
import cc.syky.hud.hudSupport60;
import cc.syky.internal.InternalSupport31;
import cc.syky.internal.InternalSupport47;
import cc.syky.module.Module;
import cc.syky.module.ModuleCategory;
import cc.syky.ui.uiRecord14;
import cc.syky.ui.uiSupport155;
import net.fabricmc.fabric.api.client.rendering.v1.world.WorldRenderContext;
import net.minecraft.class_1309;
import net.minecraft.class_243;
import org.jetbrains.annotations.Nullable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@ModuleInfo(
   name = "targetesp",
   displayName = "Target Marker",
   category = ModuleCategory.VISUAL,
   group = "Crosshair & Highlights",
   description = "module.targetesp.description"
)
public final class TargetMarker extends Module {
   private static final Logger v2 = LoggerFactory.getLogger("syky.targetesp");
   private boolean name;
   private boolean displayName;
   private static final double category = Math.PI * 2;
   private static final double group = 0.46;
   private static final double description = 0.11;
   private static final double defaultEnabled = 0.16;
   private static final double subscriptions = 0.03;
   private static final int enableAction = 5;
   private static final int disableAction = 47;
   private static final double enabled = 3.0;
   private static final float v13 = 0.96F;
   private static final float v14 = 0.05F;
   private static final float v15 = 0.68F;
   private static final float v16 = 0.235F;
   private static final float v18 = 0.13F;
   private static final double v19 = 0.09;
   private static final double v17 = 70.0;
   private static final float v20 = 0.0019607844F;
   private static final float v21 = 0.3F;
   private static final float v22 = 1.05F;
   private static final float v24 = 0.514F;
   private static final float v25 = 0.22F;
   private static final float v26 = 0.55F;
   private static final float v27 = 0.2F;
   private static final float v28 = 0.8F;
   private static final long v29 = 300L;
   private static final long v30 = 550L;
   private static final long v32 = 450L;
   private static final visualSupport2.Part1 v23 = var0 -> var0;
   private static final double v33 = 0.1;
   private final uiRecord14 v31;
   private final visualSupport18 v34;
   private final EnumSetting<visualSupport17> v36 = this.settings.add(new EnumSetting<>("shape", visualSupport17.ORBS));
   private final ColorSetting color = this.settings.add(new ColorSetting("color", -7447553).setConditionEnum(this.v36));
   private final FloatSetting glowStrength = this.settings
      .add(new FloatSetting("glowStrength", 0.75F, 0.0F, 2.0F), SettingCondition.v1(this.v36, visualSupport17.CRYSTALS));
   private final FloatSetting circleGlow = this.settings
      .add(new FloatSetting("circleGlow", 1.0F, 0.0F, 2.0F), SettingCondition.v1(this.v36, visualSupport17.CIRCLE));
   private final FloatSetting scanGlow = this.settings.add(new FloatSetting("scanGlow", 1.0F, 0.0F, 2.0F), SettingCondition.v1(this.v36, visualSupport17.SCAN));
   private final FloatSetting scanSpeed = this.settings
      .add(new FloatSetting("scanSpeed", 1.0F, 0.25F, 3.0F), SettingCondition.v1(this.v36, visualSupport17.SCAN));
   private final EnumSetting<accountSupport14> v40 = this.settings
      .add(new EnumSetting<>("arrivalFrom", accountSupport14.MIDDLE), SettingCondition.v1(this.v36, visualSupport17.CRYSTALS));
   private final BooleanSetting v44 = this.settings
      .addHidden(new BooleanSetting("glowAdvanced", false), SettingCondition.v1(this.v36, visualSupport17.CRYSTALS));
   private final FloatSetting glowHaloWide = this.settings.add(new FloatSetting("glowHaloWide", 1.05F, 0.1F, 4.0F), SettingCondition.v1(this.v44));
   private final FloatSetting glowHaloNarrow = this.settings.add(new FloatSetting("glowHaloNarrow", 0.514F, 0.05F, 4.0F), SettingCondition.v1(this.v44));
   private final FloatSetting glowHaloAlpha = this.settings.add(new FloatSetting("glowHaloAlpha", 0.22F, 0.0F, 1.0F), SettingCondition.v1(this.v44));
   private final FloatSetting glowShadeFloor = this.settings.add(new FloatSetting("glowShadeFloor", 1.0F, 0.0F, 1.0F), SettingCondition.v1(this.v44));
   private final FloatSetting glowShadeGamma = this.settings.add(new FloatSetting("glowShadeGamma", 0.2F, 0.2F, 4.0F), SettingCondition.v1(this.v44));
   private final BooleanSetting v60 = this.settings
      .addHidden(new BooleanSetting("arrivalAdvanced", false), SettingCondition.v1(this.v36, visualSupport17.CRYSTALS));
   private final IntSetting arrivalTime = this.settings.add(new IntSetting("arrivalTime", 450, 100, 3000), SettingCondition.v1(this.v60));
   private final FloatSetting arrivalStagger = this.settings.add(new FloatSetting("arrivalStagger", 0.2F, 0.0F, 0.9F), SettingCondition.v1(this.v60));
   private final FloatSetting arrivalDistance = this.settings.add(new FloatSetting("arrivalDistance", 3.0F, 1.0F, 8.0F), SettingCondition.v1(this.v60));
   private final FloatSetting arrivalSettle = this.settings.add(new FloatSetting("arrivalSettle", 2.7F, 1.0F, 5.0F), SettingCondition.v1(this.v60));
   private final FloatSetting arrivalSwing = this.settings.add(new FloatSetting("arrivalSwing", 30.0F, 0.0F, 180.0F), SettingCondition.v1(this.v60));
   private final FloatSetting arrivalSpin = this.settings.add(new FloatSetting("arrivalSpin", 720.0F, 0.0F, 1080.0F), SettingCondition.v1(this.v60));
   private final FloatSetting arrivalLight = this.settings.add(new FloatSetting("arrivalLight", 0.22F, 0.02F, 1.0F), SettingCondition.v1(this.v60));
   private final FloatSetting arrivalGlowLead = this.settings.add(new FloatSetting("arrivalGlowLead", 0.6F, 0.2F, 1.0F), SettingCondition.v1(this.v60));
   private final FloatSetting orbitRadius = this.settings
      .add(new FloatSetting("orbitRadius", 0.65F, 0.3F, 2.0F), SettingCondition.v1(this.v36, visualSupport17.ORBS));
   private final IntSetting strands = this.settings.add(new IntSetting("strands", 3, 1, 8), SettingCondition.v1(this.v36, visualSupport17.ORBS));
   private final FloatSetting speed = this.settings.add(new FloatSetting("speed", 3.0F, 0.1F, 3.0F), SettingCondition.v1(this.v36, visualSupport17.ORBS));
   private final FloatSetting trail = this.settings.add(new FloatSetting("trail", 0.25F, 0.03F, 1.0F), SettingCondition.v1(this.v36, visualSupport17.ORBS));
   private final FloatSetting size = this.settings.add(new FloatSetting("size", 0.9F, 0.3F, 2.5F), SettingCondition.v1(this.v36, visualSupport17.ORBS));
   private TargetMarker.Part1 v84 = new TargetMarker.Part1();
   private TargetMarker.Part1 v94 = new TargetMarker.Part1();
   private double v82;
   private double v99;
   private long v120;
   private final double[] v88 = new double[3];

   public TargetMarker(uiRecord14 var1, visualSupport18 var2) {
      this.v31 = var1;
      this.v34 = var2;
   }

   @Override
   public void onRenderHook() {
      this.v84.v1();
      this.v94.v1();
      this.v120 = 0L;
   }

   @Override
   public void onWorldRenderContext(WorldRenderContext var1) {
      class_1309 var2 = this.v34.v1();
      if (var2 != null && var2.method_5805()) {
         if (this.v84.v1 != var2) {
            this.v1(var2);
         }

         if (this.v84.v5 != 1.0F) {
            this.v1(this.v84, this.v84.v3, 1.0F);
         }
      } else if (this.v84.v1 != null && this.v84.v5 != 0.0F) {
         this.v1(this.v84, this.v84.v3, 0.0F);
      }

      this.v17();
      class_1309 var3 = this.v84.v1;
      if (var3 == null) {
         if (!this.name) {
            this.name = true;
            v2.info("target esp: enabled but no combat target yet, nothing drawn");
         }
      } else if (!this.displayName) {
         this.displayName = true;
         v2.info("target esp: drawing on {}", var3.method_5864().method_35050());
      }

      float var4 = this.v31.v2().v1().method_61966().method_60637(false);
      this.v1(this.v94, var4);
      this.v1(this.v84, var4);
   }

   private void v1(class_1309 var1) {
      TargetMarker.Part1 var2 = this.v84;
      this.v84 = this.v94;
      if (this.v84.v1 != var1) {
         this.v84.v1(var1);
      }

      this.v94 = var2;
      if (this.v94.v1 != null && this.v94.v5 != 0.0F) {
         this.v1(this.v94, this.v94.v3, 0.0F);
      }
   }

   private void v1(TargetMarker.Part1 var1, float var2) {
      class_1309 var3 = var1.v1;
      visualSupport2 var4 = var1.v2;
      if (var3 != null && var4 != null) {
         float var5 = var1.v4 + (var1.v5 - var1.v4) * var4.v1();
         var1.v3 = var5;
         if (var1.v5 == 0.0F && var5 <= 0.005F) {
            var1.v1();
         } else {
            TargetMarker.Part2 var6 = var1.v7;
            if (var3.method_5805()) {
               var6.v1(var3, var2);
            } else if (!var6.v6) {
               var1.v1();
               return;
            }

            double var7 = var6.v1;
            double var9 = var6.v3;
            double var11 = var6.v2;
            double var13 = var6.v5;
            float var15 = 1.0F + (1.0F - var5) * 0.3F;
            double var16 = Math.max(this.orbitRadius.getValue(), var6.v4 * 0.55F) * var15;
            int var18 = this.color.getValue() & 16777215;
            int var19 = var18 | 0xFF000000;
            float var20 = this.color.getAlpha() / 255.0F * var5;
            visualSupport17 var21 = this.v36.getValue();
            if (var21 == visualSupport17.CRYSTALS) {
               accountSupport13.v1(var7, var11, var9, var6.v4, var13, var5, var1.v6, this.v21(), var19, var20, this.v20());
            } else if (var21 == visualSupport17.CIRCLE) {
               visualSupport19.v1(var7, var11, var9, var6.v4, var13, var5, var19, var20, v1(this.circleGlow));
            } else if (var21 == visualSupport17.SCAN) {
               InternalSupport47.v1(var1.v8, var3, var2, this.v99, var13, var5, var19, var20, v1(this.scanGlow));
            } else {
               int var22 = this.strands.getValue();
               double var23 = this.trail.getValue().floatValue();
               double var25 = v1(var16, var13, var23);
               int var27 = Math.clamp((long)((int)Math.ceil(var25 / 0.03)), 5, 47);
               int var28 = var27 + 1;
               double var29 = var25 / var27;
               float var31 = this.size.getValue() * (float)Math.sqrt(Math.min(3.0, var29 / 0.03));
               int var32 = Math.max(1, (int)Math.round(0.09 * this.size.getValue().floatValue() / var29));
               float var33 = 0.05F * var32;

               for (int var34 = 0; var34 < var22; var34++) {
                  for (int var35 = 0; var35 < var28; var35++) {
                     double var36 = (double)var35 / var27;
                     float var38 = 1.0F - (float)var36;
                     float var39 = (float)Math.sqrt(var38);
                     float var40 = var20 * var38 * var39;
                     if (!(var40 < 0.0019607844F)) {
                        v1(var34, var22, this.v82, var23, var36, this.v88);
                        if (var35 % var32 == 0) {
                           visualSupport9.v1(
                              var7 + this.v88[0] * var16,
                              var11 + var13 * (0.5 + (this.v88[1] - 0.5) * var15),
                              var9 + this.v88[2] * var16,
                              0.96F * var31 * v1(var36, var39),
                              0.0F,
                              var33,
                              uiSupport155.v1(var19, var40)
                           );
                        }

                        visualSupport9.v1(
                           var7 + this.v88[0] * var16,
                           var11 + var13 * (0.5 + (this.v88[1] - 0.5) * var15),
                           var9 + this.v88[2] * var16,
                           v1(var36, var38, var39, var31),
                           1.0F,
                           0.0F,
                           uiSupport155.v1(var19, var40)
                        );
                     }
                  }
               }
            }
         }
      }
   }

   private static float v1(double var0, float var2, float var3, float var4) {
      float var5 = 0.13F + 0.105000004F * var2;
      return 0.68F * var4 * v1(var0, var3) * var5;
   }

   private static float v1(double var0, float var2) {
      return 0.4F + 0.45F * var2 + 0.4F * (float)Math.exp(-var0 * var0 * 70.0);
   }

   private static void v1(int var0, int var1, double var2, double var4, double var6, double[] var8) {
      double var9 = var2 + (double)var0 / var1 - var6 * var4;
      double var11 = (Math.PI * 2) * var9;
      double var13 = Math.PI * (var0 + 0.5) / var1;
      double var15 = Math.sin(var11);
      double var17 = Math.cos(var11);
      double var19 = var15 * Math.cos(var13);
      double var21 = (Math.PI * 2) * var2 * 0.11;
      double var23 = Math.cos(var21);
      double var25 = Math.sin(var21);
      var8[0] = var17 * var23 - var19 * var25;
      var8[2] = var17 * var25 + var19 * var23;
      var8[1] = 0.5 + 0.46 * var15 * Math.sin(var13);
   }

   private static double v1(double var0, double var2, double var4) {
      return (Math.PI * 2) * var4 * (var0 + 0.46 * var2) * 0.5;
   }

   private void v17() {
      long var1 = System.nanoTime();
      double var3 = this.v120 == 0L ? 0.0 : Math.min((var1 - this.v120) / 1.0E9, 0.1);
      this.v120 = var1;
      this.v82 = this.v82 + var3 * this.speed.getValue().floatValue() * 0.16;
      this.v99 = this.v99 + var3 * this.scanSpeed.getValue().floatValue() / 2.2;
   }

   private accountSupport13.Part1 v20() {
      if (this.v44.getValue()) {
         return new accountSupport13.Part1(
            this.glowHaloWide.getValue(),
            this.glowHaloNarrow.getValue(),
            this.glowHaloAlpha.getValue(),
            this.glowShadeFloor.getValue(),
            this.glowShadeGamma.getValue()
         );
      } else {
         float var1 = (float)Math.pow(Math.max(this.glowStrength.getValue(), 0.0F), 0.8F);
         return new accountSupport13.Part1(
            1.05F * (0.8F + 0.2F * var1), 0.514F * (0.85F + 0.15F * var1), 0.22F * var1, Math.min(1.0F, 0.55F + 0.45F * var1), 0.2F
         );
      }
   }

   private accountSupport13.Part2 v21() {
      return !this.v60.getValue()
         ? new accountSupport13.Part2(this.v40.getValue(), 0.2F, 3.0, 2.7, 30.0, 720.0, 0.22F, 0.6F)
         : new accountSupport13.Part2(
            this.v40.getValue(),
            this.arrivalStagger.getValue(),
            this.arrivalDistance.getValue().floatValue(),
            this.arrivalSettle.getValue().floatValue(),
            this.arrivalSwing.getValue().floatValue(),
            this.arrivalSpin.getValue().floatValue(),
            this.arrivalLight.getValue(),
            this.arrivalGlowLead.getValue()
         );
   }

   private static float v1(FloatSetting var0) {
      return (float)Math.pow(Math.max(var0.getValue(), 0.0F), 0.8F);
   }

   private void v1(TargetMarker.Part1 var1, float var2, float var3) {
      visualSupport2 var4 = var1.v2;
      if (var4 == null || var4.v2()) {
         var1.v6 = var3 < var2;
      }

      var1.v4 = var2;
      var1.v5 = var3;
      var1.v3 = var2;
      visualSupport17 var5 = this.v36.getValue();
      boolean var6 = var5 == visualSupport17.CRYSTALS;
      boolean var7 = var5 == visualSupport17.SCAN;
      long var8 = var6 ? (this.v60.getValue() ? this.arrivalTime.getValue().intValue() : 450L) : (var7 ? 550L : 300L);
      visualSupport2.Part1 var10 = var6 ? v23 : (var7 ? hudSupport60::v1 : hudSupport60::v5);
      var1.v2 = new visualSupport2(Math.max(1L, (long)((float)var8 * Math.abs(var3 - var2))), var10);
   }

   public static final class Part1 {
      @Nullable
      public class_1309 v1;
      @Nullable
      public visualSupport2 v2;
      public float v3;
      public float v4;
      public float v5;
      public boolean v6;
      public final TargetMarker.Part2 v7 = new TargetMarker.Part2();
      public final InternalSupport31.Part1 v8 = new InternalSupport31.Part1();

      public Part1() {
      }

      public void v1(class_1309 var1) {
         this.v1 = var1;
         this.v2 = null;
         this.v3 = 0.0F;
         this.v4 = 0.0F;
         this.v5 = 0.0F;
         this.v7.v6 = false;
      }

      public void v1() {
         this.v1 = null;
         this.v2 = null;
         this.v3 = 0.0F;
         this.v5 = 0.0F;
         this.v7.v6 = false;
         this.v8.v1();
      }
   }

   public static final class Part2 {
      public double v1;
      public double v2;
      public double v3;
      public float v4;
      public float v5;
      public boolean v6;

      public Part2() {
      }

      public void v1(class_1309 var1, float var2) {
         class_243 var3 = var1.method_30950(var2);
         this.v1 = var3.field_1352;
         this.v2 = var3.field_1351;
         this.v3 = var3.field_1350;
         this.v4 = var1.method_17681();
         this.v5 = var1.method_17682();
         this.v6 = true;
      }
   }
}
