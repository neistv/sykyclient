package cc.syky.module.utilities;

import cc.syky.api.ModuleInfo;
import cc.syky.module.Module;
import cc.syky.module.ModuleCategory;

@ModuleInfo(
   name = "pvpleaveconfirm",
   displayName = "PvP Leave Confirm",
   category = ModuleCategory.UTILITIES,
   group = "Quality of Life",
   description = "module.pvpleaveconfirm.description"
)
public final class PvPLeaveConfirm extends Module {
   public PvPLeaveConfirm() {
      this.setToggleActions(PvPLeaveConfirm::v17, PvPLeaveConfirm::v20);
   }

   private static void v17() {
      PvPModeSupport.v1 = true;
   }

   private static void v20() {
      PvPModeSupport.v1 = false;
   }
}
