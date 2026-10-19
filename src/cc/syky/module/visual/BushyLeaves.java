package cc.syky.module.visual;

import cc.syky.api.ModuleInfo;
import cc.syky.cloud.cloudSupport57;
import cc.syky.config.FloatSetting;
import cc.syky.mixin.accessor.SpriteAtlasTextureAccessor;
import cc.syky.module.Module;
import cc.syky.module.ModuleCategory;
import cc.syky.ui.uiRecord14;
import java.util.Map;
import net.minecraft.class_1059;
import net.minecraft.class_10725;
import net.minecraft.class_310;
import net.minecraft.class_776;

@ModuleInfo(
   name = "bushyleaves",
   displayName = "Bushy Leaves",
   category = ModuleCategory.VISUAL,
   group = "World & Atmosphere",
   description = "module.bushyleaves.description"
)
public final class BushyLeaves extends Module {
   private final uiRecord14 v2;
   private final FloatSetting size = this.settings.add(new FloatSetting("size", 2.0F, 1.5F, 3.0F));

   public BushyLeaves(uiRecord14 var1) {
      this.v2 = var1;
      this.setToggleActions(this::onEnable, this::onDisable);
   }

   private void onEnable() {
      class_310 var1 = this.v2.v2().v1();
      if (var1 != null) {
         if (visualSupport61.v1 != null) {
            this.v1(var1);
         } else {
            class_776 var2 = var1.method_1541();
            if (var2 != null) {
               Map var3 = visualRecord2.v1(var2.method_3351(), var1::method_72703);
               if (var3 != null) {
                  visualSupport61.v3 = this.size.getValue();
                  v2(var1);
                  visualSupport61.v1 = var3;
                  this.v21();
               }
            }
         }
      }
   }

   private void v1(class_310 var1) {
      float var2 = this.size.getValue();
      if (Float.compare(var2, visualSupport61.v3) != 0 && !cloudSupport57.v1(var1.method_22683(), 0)) {
         visualSupport61.v3 = var2;
         v2(var1);
         this.v21();
      }
   }

   private static void v2(class_310 var0) {
      class_1059 var1 = var0.method_72703().method_73025(class_10725.field_56382);
      visualSupport60.v1(var1, ((SpriteAtlasTextureAccessor)var1).syky$mipLevel(), visualSupport61.v3);
   }

   private void onDisable() {
      if (visualSupport61.v1 != null) {
         visualSupport61.v1 = null;
         this.v21();
      }
   }

   private void v21() {
      class_310 var1 = this.v2.v2().v1();
      if (var1.field_1687 != null) {
         var1.field_1769.method_3279();
      }
   }
}
