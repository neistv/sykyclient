package cc.syky.config;

import cc.syky.render.renderSupport45;
import net.minecraft.class_310;

public final class configSupport14 {
   private configSupport14() {
   }

   public static void v1(int var0, float var1, float var2) {
      if (!(var1 <= 0.0F)) {
         class_310 var3 = class_310.method_1551();
         if (var3 != null && var3.field_1724 != null && var3.field_1687 != null && !var3.field_1690.field_1842) {
            float var4 = (var0 >>> 24 & 0xFF) / 255.0F;
            renderSupport45.v1(var0 & 16777215, var4 * var1, var2);
         }
      }
   }
}
