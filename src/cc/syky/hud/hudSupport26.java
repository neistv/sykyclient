package cc.syky.hud;

import cc.syky.cloud.cloudSupport101;
import cc.syky.cloud.cloudSupport2;
import cc.syky.ui.uiSupport223;
import net.minecraft.class_310;
import org.jetbrains.annotations.Nullable;

public final class hudSupport26 extends CopiedSupport {
   public static final String v2 = "user";
   private static final hudRecord2 v3 = new hudRecord2(20.0F, 20.0F, 8.0F, 8.0F, 35.0F, 8.0F);
   private final cloudSupport101 v4;

   public hudSupport26(cloudSupport101 var1, hudSupport52 var2, float var3, float var4) {
      super("user", hudSupport49.v7, v3, var2, var3, var4);
      this.v4 = var1;
   }

   @Nullable
   @Override
   public String v1(cloudSupport2 var1) {
      class_310 var2 = this.v4.v1();
      if (var2 == null) {
         return null;
      } else {
         return uiSupport223.v2 ? "Protected" : var2.method_1548().method_1676();
      }
   }

   @Nullable
   @Override
   public String v44() {
      class_310 var1 = this.v4.v1();
      return var1 == null ? null : var1.method_1548().method_1676();
   }
}
