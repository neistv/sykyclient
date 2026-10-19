package cc.syky.module.visual;

import cc.syky.api.ModuleInfo;
import cc.syky.config.BooleanSetting;
import cc.syky.config.ColorSetting;
import cc.syky.config.EnumSetting;
import cc.syky.hud.MobsSupport;
import cc.syky.module.Module;
import cc.syky.module.ModuleCategory;
import cc.syky.render.renderSupport47;
import cc.syky.ui.uiRecord14;
import java.util.EnumSet;
import net.fabricmc.fabric.api.client.rendering.v1.world.WorldRenderContext;
import net.minecraft.class_1297;
import net.minecraft.class_1309;
import net.minecraft.class_1531;
import net.minecraft.class_1657;
import net.minecraft.class_2960;
import net.minecraft.class_310;
import net.minecraft.class_3532;
import org.jetbrains.annotations.Nullable;
import org.joml.Vector3f;

@ModuleInfo(
   name = "healthindicator",
   displayName = "Health Indicator",
   category = ModuleCategory.VISUAL,
   group = "Player Info",
   description = "module.healthindicator.description"
)
public final class HealthIndicator extends Module implements visualSupport53.Part1<class_1309> {
   private static final String v2 = "textures/gui/sprites/hud/";
   private static final String name = "textures/gui/sprites/hud/heart/";
   private static final class_2960 displayName = class_2960.method_60656("textures/gui/sprites/hud/heart/container.png");
   private static final class_2960 category = class_2960.method_60656("textures/gui/sprites/hud/heart/full.png");
   private static final class_2960 group = class_2960.method_60656("textures/gui/sprites/hud/heart/half.png");
   private static final class_2960 description = class_2960.method_60656("textures/gui/sprites/hud/heart/absorbing_full.png");
   private static final class_2960 defaultEnabled = class_2960.method_60656("textures/gui/sprites/hud/heart/absorbing_half.png");
   private static final class_2960 subscriptions = class_2960.method_60656("textures/gui/sprites/hud/armor_full.png");
   private static final class_2960 enableAction = class_2960.method_60656("textures/gui/sprites/hud/armor_half.png");
   private static final visualSupport54 disableAction = visualSupport54.v1("indicator", "full", "half");
   private static final class_2960 enabled = class_2960.method_60656("textures/gui/sprites/hud/armor_empty.png");
   private static final double v13 = 48.0;
   private static final int v14 = 5;
   private static final float v15 = 0.2F;
   private static final float v16 = 0.21F;
   private static final float v18 = 0.23F;
   private static final double v19 = 0.45;
   private static final double v17 = 0.45;
   private static final double v20 = 6.0E-4;
   private static final float v21 = 0.20012F;
   private static final int v22 = -1;
   private final visualSupport6<MobsSupport> v24 = this.settings.add(new visualSupport6<>("targets", MobsSupport.class, EnumSet.allOf(MobsSupport.class)));
   private final BooleanSetting armorBar = this.settings.add(new BooleanSetting("armorBar", true));
   private final BooleanSetting goldFillsEmpty = this.settings.add(new BooleanSetting("goldFillsEmpty", false));
   private final EnumSetting<LeftSupport> v27 = this.settings.add(new EnumSetting<>("alignment", LeftSupport.LEFT));
   private final BooleanSetting customHeartColor = this.settings.add(new BooleanSetting("customHeartColor", false));
   private final ColorSetting heartColor = this.settings.add(new ColorSetting("heartColor", -60653).setCondition(this.customHeartColor));
   private static final int v30 = 32;
   private final visualSupport53<class_1309> v32 = new visualSupport53(32);
   private double v23;
   private double v33;
   private double v31;
   @Nullable
   private Vector3f v34;
   @Nullable
   private Vector3f v36;
   private class_2960 v38 = category;
   private class_2960 v42 = group;
   private final uiRecord14 v43;

   public HealthIndicator(uiRecord14 var1) {
      this.v43 = var1;
   }

   @Override
   public void onDisableHook() {
      this.v32.v1();
   }

   @Override
   public void onRenderHook() {
      this.v32.v1();
   }

   @Override
   public void onResetHook() {
      if (this.v32.v1(this.v43.v2().v1(), this) && this.customHeartColor.getValue()) {
         disableAction.v1(this.heartColor.getValue());
      }
   }

   @Nullable
   public class_1309 v1(class_1297 var1, class_1657 var2) {
      return var1 instanceof class_1309 var3 && var3 != var2 && var3 != var2.method_5854() && !(var3 instanceof class_1531) ? var3 : null;
   }

   public boolean v1(class_1309 var1, double var2) {
      return var2 <= 2304.0;
   }

   public boolean v1(class_1309 var1, class_1657 var2) {
      if (var1.method_5805() && !var1.method_5756(var2)) {
         return var1 instanceof class_1657 ? this.v24.v1(MobsSupport.PLAYERS) : this.v24.v1(MobsSupport.MOBS);
      } else {
         return false;
      }
   }

   @Override
   public void onWorldRenderContext(WorldRenderContext var1) {
      if (!this.v32.v3()) {
         class_310 var2 = this.v43.v2().v1();
         if (var2 != null && var2.field_1687 != null && var2.field_1724 != null) {
            this.v23 = visualSupport9.v7();
            this.v33 = visualSupport9.v8();
            this.v31 = visualSupport9.v9();
            this.v34 = visualSupport9.v10();
            this.v36 = visualSupport9.v11();
            this.v17();
            float var3 = var2.method_61966().method_60637(false);

            for (int var4 = 0; var4 < this.v32.v2(); var4++) {
               class_1309 var5 = (class_1309)this.v32.v1(var4);
               if (var5.method_5805()) {
                  this.v1(var5, var3);
               }
            }
         }
      }
   }

   private void v17() {
      this.v38 = category;
      this.v42 = group;
      if (this.customHeartColor.getValue()) {
         visualSupport54.Part3 var1 = disableAction.v1(visualSupport54.v1("full"));
         visualSupport54.Part3 var2 = disableAction.v1(visualSupport54.v1("half"));
         if (var1 != null && var2 != null) {
            this.v38 = var1.v1();
            this.v42 = var2.v1();
         }
      }
   }

   private void v1(class_1309 var1, float var2) {
      int var3 = Math.max(0, class_3532.method_15386(var1.method_6032()));
      int var4 = class_3532.method_15386(var1.method_6063());
      int var5 = Math.max(0, class_3532.method_15386(var1.method_6067()));
      if (var4 > 0) {
         byte var6 = 50;
         int var7 = visualSupport28.v1(var4, var5, var6);
         int var8 = visualSupport28.v1(var4, var7);
         int var9 = visualSupport28.v1(var5, var7);
         int var10 = var7 > 2 && var3 >= var4 ? var8 * 2 : visualSupport28.v2(var3, var7);
         int var11 = visualSupport28.v2(var5, var7);
         int var12 = var10 / 2;
         boolean var13 = (var10 & 1) == 1;
         int var14 = var11 / 2;
         boolean var15 = (var11 & 1) == 1;
         int var16 = visualSupport28.v1(this.goldFillsEmpty.getValue(), var8, var10);
         int var17 = visualSupport28.v1(var8, var16, var9, var6);
         int var18 = this.armorBar.getValue() ? var1.method_6096() : 0;
         boolean var19 = var18 > 0;
         int var20 = visualSupport28.v1(var17, var19);
         int var21 = visualSupport28.v1(var17);
         LeftSupport var22 = this.v27.getValue();
         double var23 = var2;
         double var25 = !(var1 instanceof class_1657) && !var1.method_16914() ? 0.45 : 0.9;
         double var27 = class_3532.method_16436(var23, var1.field_6014, var1.method_23317());
         double var29 = class_3532.method_16436(var23, var1.field_6036, var1.method_23318()) + var1.method_17682() + var25;
         double var31 = class_3532.method_16436(var23, var1.field_5969, var1.method_23321());
         int var33 = var21 - 1 + (var19 ? 1 : 0);
         visualSupport56.v1(var1.method_5628(), var29 + var33 * 0.23F + 0.1F);
         double var34 = 0.5 * var20 * 0.21F + var33 * 0.23F + 0.20012F;
         if (visualSupport9.v1(var27 - var34, var29 - var34, var31 - var34, var27 + var34, var29 + var34, var31 + var34)) {
            Vector3f var36 = renderSupport47.v1(this.v34);
            Vector3f var37 = renderSupport47.v1(this.v36);

            for (int var38 = 0; var38 < var17; var38++) {
               float var39 = visualSupport28.v3(var38, visualSupport28.v1(var22, var38, var17, var20)) * 0.21F;
               float var40 = visualSupport28.v2(var38) * 0.23F;
               this.v1(var27 + var36.x * var39 + var37.x * var40, var29 + var36.y * var39 + var37.y * var40, var31 + var36.z * var39 + var37.z * var40);
            }

            for (int var42 = 0; var42 < var17; var42++) {
               class_2960 var44 = this.v1(var42, var16, var12, var13, var14, var15);
               if (var44 != null) {
                  float var46 = visualSupport28.v3(var42, visualSupport28.v1(var22, var42, var17, var20)) * 0.21F;
                  float var41 = visualSupport28.v2(var42) * 0.23F;
                  visualSupport9.v1(
                     var44,
                     var27 + var36.x * var46 + var37.x * var41,
                     var29 + var36.y * var46 + var37.y * var41,
                     var31 + var36.z * var46 + var37.z * var41,
                     0.2F,
                     0.2F,
                     -1
                  );
               }
            }

            if (var19) {
               float var43 = var21 * 0.23F;

               for (int var45 = 0; var45 < 10; var45++) {
                  float var47 = visualSupport28.v3(var45, visualSupport28.v1(var22, var45, 10, var20)) * 0.21F;
                  visualSupport9.v1(
                     v1(visualSupport28.v4(var45, var18)),
                     var27 + var36.x * var47 + var37.x * var43,
                     var29 + var36.y * var47 + var37.y * var43,
                     var31 + var36.z * var47 + var37.z * var43,
                     0.2F,
                     0.2F,
                     -1
                  );
               }
            }
         }
      }
   }

   private void v1(double var1, double var3, double var5) {
      visualSupport9.v1(
         displayName, var1 + (var1 - this.v23) * 6.0E-4, var3 + (var3 - this.v33) * 6.0E-4, var5 + (var5 - this.v31) * 6.0E-4, 0.20012F, 0.20012F, -1
      );
   }

   @Nullable
   private class_2960 v1(int var1, int var2, int var3, boolean var4, int var5, boolean var6) {
      if (var1 < var3) {
         return this.v38;
      } else if (var1 == var3 && var4) {
         return this.v42;
      } else {
         int var7 = var1 - var2;
         if (var7 < 0) {
            return null;
         } else if (var7 < var5) {
            return description;
         } else {
            return var7 == var5 && var6 ? defaultEnabled : null;
         }
      }
   }

   private static class_2960 v1(visualSupport28.Part1 var0) {
      return switch (var0) {
         case FULL -> subscriptions;
         case HALF -> enableAction;
         case EMPTY -> enabled;
      };
   }
}
