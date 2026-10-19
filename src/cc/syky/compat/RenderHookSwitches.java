package cc.syky.compat;

import cc.syky.cloud.cloudSupport35;
import cc.syky.module.visual.HideArmor;
import cc.syky.module.visual.ItemPhysic;
import cc.syky.module.visual.visualSupport21;
import cc.syky.module.visual.visualSupport40;
import cc.syky.module.visual.visualSupport42;
import cc.syky.module.visual.visualSupport47;
import cc.syky.module.visual.visualSupport50;

public final class RenderHookSwitches {
   private RenderHookSwitches() {
   }

   public static boolean enchantGlint() {
      return visualSupport50.v3;
   }

   public static boolean itemPhysic() {
      return ItemPhysic.v2;
   }

   public static boolean armorHurtTint() {
      return visualSupport42.v3 && visualSupport42.v6;
   }

   public static boolean shieldLook() {
      return visualSupport40.v1() || visualSupport40.v2() > 0.001F;
   }

   public static boolean hideArmor() {
      return HideArmor.v2;
   }

   public static boolean particleFilter() {
      return visualSupport21.v12;
   }

   public static boolean hideEntityFire() {
      return visualSupport47.v9;
   }

   public static boolean noEntityShadow() {
      return visualSupport21.v7;
   }

   public static boolean handBlur() {
      return cloudSupport35.v1 || cloudSupport35.v11;
   }
}
