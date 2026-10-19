package cc.syky.module.utilities;

import cc.syky.api.ModuleInfo;
import cc.syky.config.ColorSetting;
import cc.syky.config.FloatSetting;
import cc.syky.internal.InternalSupport32;
import cc.syky.module.Module;
import cc.syky.module.ModuleCategory;
import cc.syky.module.visual.visualSupport53;
import cc.syky.ui.uiRecord14;
import net.fabricmc.fabric.api.client.rendering.v1.world.WorldRenderContext;
import net.minecraft.class_1297;
import net.minecraft.class_1541;
import net.minecraft.class_1657;
import net.minecraft.class_310;
import net.minecraft.class_3532;
import org.jetbrains.annotations.Nullable;

@ModuleInfo(
   name = "tnttimer",
   displayName = "TNT Timer",
   category = ModuleCategory.UTILITIES,
   group = "Readouts",
   description = "module.tnttimer.description"
)
public final class TNTTimer extends Module implements visualSupport53.Part1<class_1541> {
   private static final float v2 = 20.0F;
   private static final double name = 0.5;
   private final FloatSetting scale = this.settings.add(new FloatSetting("scale", 1.0F, 0.5F, 3.0F));
   private final ColorSetting color = this.settings.add(new ColorSetting("color", -1));
   private final FloatSetting warnTime = this.settings.add(new FloatSetting("warnTime", 1.5F, 0.0F, 5.0F));
   private final ColorSetting warnColor = this.settings.add(new ColorSetting("warnColor", -50384));
   private static final int defaultEnabled = 32;
   private final uiRecord14 subscriptions;
   private final visualSupport53<class_1541> enableAction = new visualSupport53(32);
   private final utilitiesSupport4 disableAction = new utilitiesSupport4();

   public TNTTimer(uiRecord14 var1) {
      this.subscriptions = var1;
   }

   @Override
   public void onDisableHook() {
      this.enableAction.v1();
   }

   @Override
   public void onRenderHook() {
      this.enableAction.v1();
   }

   @Override
   public void onResetHook() {
      this.enableAction.v1(this.subscriptions.v2().v1(), this);
   }

   @Nullable
   public class_1541 v1(class_1297 var1, class_1657 var2) {
      return var1 instanceof class_1541 var3 && !var3.method_31481() && var3.method_6969() > 0 ? var3 : null;
   }

   @Override
   public void onWorldRenderContext(WorldRenderContext var1) {
      if (!this.enableAction.v3()) {
         class_310 var2 = this.subscriptions.v2().v1();
         if (var2 != null && !var2.field_1690.field_1842) {
            float var3 = var2.method_61966().method_60637(false);
            float var4 = this.scale.getValue();
            int var5 = this.color.getValue();
            int var6 = this.warnColor.getValue();
            float var7 = this.warnTime.getValue();

            for (int var8 = 0; var8 < this.enableAction.v2(); var8++) {
               class_1541 var9 = (class_1541)this.enableAction.v1(var8);
               if (!var9.method_31481()) {
                  int var10 = var9.method_6969();
                  if (var10 > 0) {
                     float var11 = Math.max(0.0F, (var10 - var3) / 20.0F);
                     double var12 = var3;
                     double var14 = class_3532.method_16436(var12, var9.field_6038, var9.method_23317());
                     double var16 = class_3532.method_16436(var12, var9.field_5971, var9.method_23318()) + var9.method_17682() + 0.5;
                     double var18 = class_3532.method_16436(var12, var9.field_5989, var9.method_23321());
                     InternalSupport32.v1(this.disableAction.v1(var11), var14, var16, var18, var4, utilitiesSupport4.v1(var11, var5, var6, var7));
                  }
               }
            }
         }
      }
   }
}
