package cc.syky.module.visual;

import cc.syky.api.ModuleInfo;
import cc.syky.config.BooleanSetting;
import cc.syky.config.ColorSetting;
import cc.syky.config.FloatSetting;
import cc.syky.config.IntSetting;
import cc.syky.config.SettingCondition;
import cc.syky.hud.ArmorStandsSupport;
import cc.syky.module.Module;
import cc.syky.module.ModuleCategory;
import cc.syky.ui.uiRecord14;
import java.util.EnumSet;
import net.fabricmc.fabric.api.client.rendering.v1.world.WorldRenderContext;
import net.minecraft.class_1297;
import net.minecraft.class_1309;
import net.minecraft.class_1511;
import net.minecraft.class_1531;
import net.minecraft.class_1542;
import net.minecraft.class_1657;
import net.minecraft.class_1676;
import net.minecraft.class_238;
import net.minecraft.class_243;
import net.minecraft.class_310;
import net.minecraft.class_3532;
import net.minecraft.class_4184;
import org.jetbrains.annotations.Nullable;

@ModuleInfo(
   name = "customhitbox",
   displayName = "Custom Hitbox",
   category = ModuleCategory.VISUAL,
   group = "Hit Feedback",
   description = "module.customhitbox.description"
)
public final class CustomHitbox extends Module implements visualSupport53.Part1<class_1297> {
   private static final double v2 = 0.002;
   private final BooleanSetting outline = this.settings.add(new BooleanSetting("outline", true));
   private final ColorSetting outlineColor = this.settings.add(new ColorSetting("outlineColor", -1).setCondition(this.outline));
   private final FloatSetting thickness = this.settings.add(new FloatSetting("thickness", 0.5F, 0.5F, 6.0F).setCondition(this.outline));
   private final BooleanSetting fill = this.settings.add(new BooleanSetting("fill", true));
   private final ColorSetting fillColor = this.settings.add(new ColorSetting("fillColor", 175217407).setCondition(this.fill));
   private final BooleanSetting reachHighlight = this.settings.add(new BooleanSetting("reachHighlight", true));
   private final ColorSetting reachColor = this.settings.add(new ColorSetting("reachColor", -5456897).setCondition(this.reachHighlight));
   private final BooleanSetting shrink = this.settings.add(new BooleanSetting("shrink", false));
   private final IntSetting shrinkPercent = this.settings.add(new IntSetting("shrinkPercent", 30, 5, 80).v1("%").v1(this.shrink));
   private final BooleanSetting hideEdgeHits = this.settings.add(new BooleanSetting("hideEdgeHits", true), SettingCondition.v1(this.shrink));
   private final visualSupport6<ArmorStandsSupport> v13 = this.settings
      .add(
         new visualSupport6<>(
            "targets",
            ArmorStandsSupport.class,
            EnumSet.of(ArmorStandsSupport.PLAYERS, ArmorStandsSupport.MOBS, ArmorStandsSupport.ARMOR_STANDS, ArmorStandsSupport.SELF)
         )
      );
   private static final int v14 = 32;
   private final visualSupport53<class_1297> v15 = new visualSupport53<>(32);
   private final uiRecord14 v16;

   public CustomHitbox(uiRecord14 var1) {
      this.v16 = var1;
      this.setToggleActions(() -> visualSupport44.v1(this.shrink.getValue(), this.hideEdgeHits.getValue()), () -> visualSupport44.v1(false, false));
   }

   @Override
   public void onEnableHook() {
      this.addSubscription(this.v16.v1().v1(visualSupport64.class, this::v1, 0));
   }

   @Override
   public void onDisableHook() {
      this.v15.v1();
   }

   @Override
   public void onRenderHook() {
      this.v15.v1();
      visualSupport44.v2();
   }

   private void v1(visualSupport64 var1) {
      class_310 var2 = this.v16.v2().v1();
      class_1297 var3 = var1.v1();
      if (var2 != null && var2.field_1724 != null && var3 != null) {
         visualSupport44.v1(var3, var2.field_1724);
      }
   }

   @Override
   public void onResetHook() {
      this.v15.v1(this.v16.v2().v1(), this);
   }

   @Override
   public void onWorldRenderContext(WorldRenderContext var1) {
      visualSupport44.v1(-1, false);
      if (!this.v15.v3()) {
         class_310 var2 = this.v16.v2().v1();
         if (var2 != null && var2.field_1687 != null && var2.field_1724 != null) {
            float var3 = var2.method_61966().method_60637(false);
            if (var2.field_1773 != null) {
               class_4184 var4 = var2.field_1773.method_19418();
               class_243 var5 = var4.method_71156();
               class_1297 var6 = var4.method_19331();
               boolean var7 = var4.method_19333();

               for (int var8 = 0; var8 < this.v15.v2(); var8++) {
                  class_1297 var9 = this.v15.v1(var8);
                  if (!var9.method_31481() && var9.method_5727(var5.field_1352, var5.field_1351, var5.field_1350) && !v1(var9, var6, var2.field_1724, var7)) {
                     this.v1(var9, var3, var2.field_1692 == var9);
                  }
               }
            }
         }
      }
   }

   private static boolean v1(class_1297 var0, class_1297 var1, class_1297 var2, boolean var3) {
      return var0 == var1 ? !var3 : var0 == var2;
   }

   @Nullable
   @Override
   public class_1297 v2(class_1297 var1, class_1657 var2) {
      return this.v1(var1, var2) ? var1 : null;
   }

   private boolean v1(class_1297 var1, class_1657 var2) {
      if (var1 == var2) {
         return this.v13.v1(ArmorStandsSupport.SELF);
      } else if (var1 instanceof class_1511) {
         return var1.method_5805() && this.v13.v1(ArmorStandsSupport.CRYSTALS);
      } else if (var1 instanceof class_1542) {
         return var1.method_5805() && this.v13.v1(ArmorStandsSupport.ITEMS);
      } else if (!(var1 instanceof class_1676)) {
         if (var1 instanceof class_1531) {
            return this.v13.v1(ArmorStandsSupport.ARMOR_STANDS);
         } else if (var1 instanceof class_1309 var3) {
            if (!var3.method_5805()) {
               return false;
            } else if (var3.method_5756(var2)) {
               return false;
            } else {
               return var3 instanceof class_1657 ? this.v13.v1(ArmorStandsSupport.PLAYERS) : this.v13.v1(ArmorStandsSupport.MOBS);
            }
         } else {
            return false;
         }
      } else {
         return var1.method_5805() && this.v13.v1(ArmorStandsSupport.PROJECTILES);
      }
   }

   private void v1(class_1297 var1, float var2, boolean var3) {
      double var4 = 1.0 - var2;
      double var6 = (var1.field_6014 - var1.method_23317()) * var4;
      double var8 = (var1.field_6036 - var1.method_23318()) * var4;
      double var10 = (var1.field_5969 - var1.method_23321()) * var4;
      class_238 var12 = var1.method_5829();
      double var13 = this.shrink.getValue() ? visualSupport43.v1(this.shrinkPercent.getValue()) : 1.0;
      double var15 = (var12.field_1323 + var12.field_1320) * 0.5 + var6;
      double var17 = (var12.field_1321 + var12.field_1324) * 0.5 + var10;
      double var19 = var12.method_17939() * 0.5 * var13;
      double var21 = var12.method_17941() * 0.5 * var13;
      double var23 = var15 - var19;
      double var25 = var15 + var19;
      double var27 = var12.field_1322 + var8;
      double var29 = var12.field_1325 + var8;
      double var31 = var17 - var21;
      double var33 = var17 + var21;
      if (visualSupport9.v1(var23, var27, var31, var25, var29, var33)) {
         boolean var35 = var3;
         if (var3 && var13 < 1.0) {
            var35 = this.v1(var2, var23, var27, var31, var25, var29, var33);
            visualSupport44.v1(var1.method_5628(), var35);
         }

         boolean var36 = this.reachHighlight.getValue() && var35;
         if (this.fill.getValue()) {
            visualSupport9.v1(
               new class_238(var23 + 0.002, var27 + 0.002, var31 + 0.002, var25 - 0.002, var29 - 0.002, var33 - 0.002),
               var36 ? this.v17() : this.fillColor.getValue()
            );
         }

         if (this.outline.getValue()) {
            visualSupport9.v1(
               new class_238(var23, var27, var31, var25, var29, var33),
               var36 ? this.reachColor.getValue() : this.outlineColor.getValue(),
               this.thickness.getValue()
            );
         }
      }
   }

   private boolean v1(float var1, double var2, double var4, double var6, double var8, double var10, double var12) {
      class_310 var14 = this.v16.v2().v1();
      class_1297 var15 = var14 == null ? null : var14.method_1560();
      if (var15 == null) {
         return false;
      } else {
         double var16 = class_3532.method_16436(var1, var15.field_6014, var15.method_23317());
         double var18 = class_3532.method_16436(var1, var15.field_6036, var15.method_23318()) + var15.method_5751();
         double var20 = class_3532.method_16436(var1, var15.field_5969, var15.method_23321());
         float var22 = var15.method_5695(var1) * (float) (Math.PI / 180.0);
         float var23 = -var15.method_5705(var1) * (float) (Math.PI / 180.0);
         float var24 = class_3532.method_15362(var22);
         return visualSupport43.v1(
            var16,
            var18,
            var20,
            class_3532.method_15374(var23) * var24,
            -class_3532.method_15374(var22),
            class_3532.method_15362(var23) * var24,
            var2,
            var4,
            var6,
            var8,
            var10,
            var12
         );
      }
   }

   private int v17() {
      return this.reachColor.getValue() & 16777215 | this.fillColor.getValue() & 0xFF000000;
   }
}
