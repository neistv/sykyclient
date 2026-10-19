package cc.syky.module.visual;

import cc.syky.api.ModuleInfo;
import cc.syky.module.Module;
import cc.syky.module.ModuleCategory;

@ModuleInfo(
   name = "itemphysic",
   displayName = "Item Physic",
   category = ModuleCategory.VISUAL,
   group = "Entities & Items",
   description = "module.itemphysic.description"
)
public final class ItemPhysic extends Module {
   public static boolean v2;

   public ItemPhysic() {
   }

   @Override
   public void onEnableHook() {
      v2 = true;
   }

   @Override
   public void onDisableHook() {
      v2 = false;
   }
}
