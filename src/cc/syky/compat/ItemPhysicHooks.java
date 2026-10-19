package cc.syky.compat;

import cc.syky.internal.Support721;
import cc.syky.module.visual.ItemPhysic;
import cc.syky.ui.uiSupport171;
import cc.syky.ui.uiSupport259;
import net.minecraft.class_1542;
import org.joml.Quaternionf;

public final class ItemPhysicHooks {
   private static final Quaternionf v1 = new Quaternionf();

   private ItemPhysicHooks() {
   }

   public static boolean restingPose(class_1542 var0, float var1, float var2, float var3, float var4, int var5, float[] var6) {
      return ItemPhysic.v2 && var0 instanceof Support721 var7 && var7.syky$settled() ? uiSupport259.v1("item.physic-rest", () -> {
         float var8 = var7.syky$pitchAt(0.0F);
         float var9 = uiSupport171.v3(var7.syky$restAt(0.0F));
         var6[0] = uiSupport171.v1(var8, var1, var2, var3, var4, var5, var9, var0.field_7203);
         uiSupport171.v1(v1, var7.syky$yaw(), var8);
         var6[1] = v1.x;
         var6[2] = v1.y;
         var6[3] = v1.z;
         var6[4] = v1.w;
         return true;
      }, false) : false;
   }
}
