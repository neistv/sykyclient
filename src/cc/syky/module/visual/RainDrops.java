package cc.syky.module.visual;

import cc.syky.account.accountSupport15;
import cc.syky.api.ModuleInfo;
import cc.syky.cloud.cloudSupport100;
import cc.syky.config.EnumSetting;
import cc.syky.config.FloatSetting;
import cc.syky.hud.WhenItSupport;
import cc.syky.module.Module;
import cc.syky.module.ModuleCategory;
import cc.syky.ui.uiRecord14;
import net.minecraft.class_1959;
import net.minecraft.class_2338;
import net.minecraft.class_310;
import net.minecraft.class_4184;
import net.minecraft.class_5636;
import net.minecraft.class_638;
import net.minecraft.class_1959.class_1963;
import net.minecraft.class_2902.class_2903;

@ModuleInfo(
   name = "raindrops",
   displayName = "Rain Drops",
   category = ModuleCategory.VISUAL,
   group = "Environment Overlays",
   description = "module.raindrops.description"
)
public final class RainDrops extends Module implements cloudSupport100 {
   private final uiRecord14 v2;
   private final EnumSetting<WhenItSupport> name = this.settings.add(new EnumSetting<>("mode", WhenItSupport.RAIN));
   private final FloatSetting amount = this.settings.add(new FloatSetting("amount", 70.0F, 0.0F, 100.0F));
   private final FloatSetting size = this.settings.add(new FloatSetting("size", 100.0F, 0.0F, 100.0F));
   private final FloatSetting refraction = this.settings.add(new FloatSetting("refraction", 40.0F, 0.0F, 100.0F));
   private final FloatSetting speed = this.settings.add(new FloatSetting("speed", 100.0F, 0.0F, 100.0F));
   private final FloatSetting trails = this.settings.add(new FloatSetting("trails", 50.0F, 0.0F, 100.0F));

   public RainDrops(uiRecord14 var1) {
      this.v2 = var1;
      this.setToggleActions(this::onEnable, this::onDisable);
   }

   private void onDisable() {
      accountSupport15.v1 = false;
      accountSupport15.v8 = 0.0F;
      accountSupport15.v2();
   }

   private void onEnable() {
      accountSupport15.v1 = true;
      this.v21();
      accountSupport15.v8 = this.v22();
   }

   private void v21() {
      accountSupport15.v3 = this.amount.getValue() / 100.0F;
      accountSupport15.v4 = this.size.getValue() / 100.0F;
      accountSupport15.v5 = this.refraction.getValue() / 100.0F;
      accountSupport15.v6 = this.speed.getValue() / 100.0F;
      accountSupport15.v7 = this.trails.getValue() / 100.0F;
   }

   private float v22() {
      if (this.name.getValue() == WhenItSupport.ALWAYS) {
         return 1.0F;
      } else {
         class_310 var1 = this.v2.v2().v1();
         if (var1 != null && var1.field_1687 != null && var1.field_1773 != null) {
            class_638 var2 = var1.field_1687;
            float var3 = var2.method_8430(1.0F);
            if (var3 <= 0.0F) {
               return 0.0F;
            } else {
               class_4184 var4 = var1.field_1773.method_19418();
               if (var4.method_19334() != class_5636.field_27888) {
                  return 0.0F;
               } else {
                  class_2338 var5 = var4.method_19328();
                  if (var2.method_8624(class_2903.field_13197, var5.method_10263(), var5.method_10260()) > var5.method_10264()) {
                     return 0.0F;
                  } else {
                     return ((class_1959)var2.method_23753(var5).comp_349()).method_48162(var5, var2.method_8615()) != class_1963.field_9382
                        ? 0.0F
                        : Math.min(var3, 1.0F);
                  }
               }
            }
         } else {
            return 0.0F;
         }
      }
   }

   @Override
   public void v1() {
      this.v21();
      accountSupport15.v2 = true;
   }

   @Override
   public void v2() {
      accountSupport15.v2 = false;
   }

   @Override
   public void onTickHook() {
      accountSupport15.v2();
   }

   @Override
   public void onRenderHook() {
      accountSupport15.v2();
   }
}
