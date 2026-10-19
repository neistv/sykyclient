package cc.syky.module.visual;

import cc.syky.account.accountSupport12;
import net.minecraft.class_1268;
import net.minecraft.class_1799;
import net.minecraft.class_1819;
import net.minecraft.class_310;
import net.minecraft.class_4587;
import net.minecraft.class_7833;

public final class visualSupport63 {
   private static final float v1 = 0.001F;

   private visualSupport63() {
   }

   public static void v1(class_1268 var0, class_1799 var1, class_4587 var2) {
      v2(var0, var1, var2);
      v1(var1, var2);
   }

   private static void v2(class_1268 var0, class_1799 var1, class_4587 var2) {
      float var3 = ViewModel.v2.v3();
      if (!(var3 <= 0.001F)) {
         boolean var4 = var0 == class_1268.field_5808;
         if (var1.method_7960()) {
            var2.method_46416(
               (var4 ? visualSupport51.v34 : visualSupport51.v42) * var3,
               (var4 ? visualSupport51.v36 : visualSupport51.v43) * var3,
               (var4 ? visualSupport51.v38 : visualSupport51.v37) * var3
            );
         } else {
            float var5 = (var4 ? visualSupport51.v17 : visualSupport51.v27) * var3;
            float var6 = (var4 ? visualSupport51.v20 : visualSupport51.v28) * var3;
            float var7 = (var4 ? visualSupport51.v21 : visualSupport51.v29) * var3;
            float var8 = (var4 ? visualSupport51.v22 : visualSupport51.v30) * var3;
            float var9 = (var4 ? visualSupport51.v24 : visualSupport51.v32) * var3;
            float var10 = (var4 ? visualSupport51.v25 : visualSupport51.v23) * var3;
            var2.method_46416(var5, var6, var7);
            if (var8 != 0.0F) {
               var2.method_22907(class_7833.field_40714.rotationDegrees(var8));
            }

            if (var9 != 0.0F) {
               var2.method_22907(class_7833.field_40716.rotationDegrees(var9));
            }

            if (var10 != 0.0F) {
               var2.method_22907(class_7833.field_40718.rotationDegrees(var10));
            }

            accountSupport12.v1(var4, var2.method_23760().method_23761());
         }
      }
   }

   public static void v1(class_1268 var0, class_4587 var1, float var2) {
      class_310 var3 = class_310.method_1551();
      accountSupport12.v1(var0 == class_1268.field_5808, var1.method_23760().method_23761(), var2, var3.field_1773.method_19418().method_23767());
   }

   private static void v1(class_1799 var0, class_4587 var1) {
      if (var0.method_7909() instanceof class_1819) {
         float var2 = visualSupport40.v2();
         if (!(var2 <= 0.001F) && visualSupport40.v4 != 0.0F) {
            var1.method_46416(0.0F, -visualSupport40.v4 * var2, 0.0F);
         }
      }
   }
}
