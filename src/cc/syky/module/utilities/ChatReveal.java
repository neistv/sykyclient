package cc.syky.module.utilities;

import cc.syky.api.ModuleInfo;
import cc.syky.config.BooleanSetting;
import cc.syky.module.Module;
import cc.syky.module.ModuleCategory;
import cc.syky.ui.uiRecord14;
import cc.syky.ui.uiSupport201;
import net.minecraft.class_1659;
import net.minecraft.class_310;
import net.minecraft.class_338;
import net.minecraft.class_3532;
import org.jetbrains.annotations.Nullable;

@ModuleInfo(
   name = "chatreveal",
   displayName = "Chat Reveal",
   category = ModuleCategory.UTILITIES,
   group = "Readouts",
   description = "module.chatreveal.description"
)
public final class ChatReveal extends Module {
   private static final double v2 = 7.0;
   @Nullable
   private static ChatReveal name;
   private final uiRecord14 displayName;
   private final BooleanSetting scroll = this.settings.add(new BooleanSetting("scroll", true));

   public ChatReveal(uiRecord14 var1) {
      this.displayName = var1;
      name = this;
      this.setToggleActions(() -> uiSupport201.v1 = true, () -> uiSupport201.v1 = false);
   }

   @Override
   public void onDisableHook() {
      this.v17();
   }

   @Override
   public void onRenderHook() {
      this.v17();
   }

   private void v17() {
      class_310 var1 = this.displayName.v2().v1();
      if (var1 != null) {
         var1.field_1705.method_1743().method_1820();
      }
   }

   public static boolean v1(double var0) {
      ChatReveal var2 = name;
      if (var2 != null && var2.isEnabled() && var2.scroll.getValue() && var0 != 0.0) {
         class_310 var3 = var2.displayName.v2().v1();
         if (var3 != null && var3.field_1690.method_42539().method_41753() != class_1659.field_7536) {
            class_338 var4 = var3.field_1705.method_1743();
            double var5 = class_3532.method_15350(var0, -1.0, 1.0);
            if (!var3.method_74187()) {
               var5 *= 7.0;
            }

            var4.method_1802((int)var5);
            return true;
         } else {
            return false;
         }
      } else {
         return false;
      }
   }
}
