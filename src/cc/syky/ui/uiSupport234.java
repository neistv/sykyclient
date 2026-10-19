package cc.syky.ui;

import cc.syky.internal.InternalSupport52;
import cc.syky.module.visual.visualSupport61;
import java.util.Map;
import net.minecraft.class_1087;
import net.minecraft.class_2680;
import org.jetbrains.annotations.Nullable;

public final class uiSupport234 {
   private uiSupport234() {
   }

   @Nullable
   public static class_1087 v1(class_2680 var0, Map<class_2680, class_1087> var1) {
      Map var2 = uiSupport219.v1;
      if (var2 != null) {
         class_2680 var3 = (class_2680)var2.get(var0.method_26204());
         if (var3 != null) {
            return (class_1087)var1.get(var3);
         }
      }

      Map var5 = InternalSupport52.v1;
      if (var5 != null) {
         class_1087 var4 = (class_1087)var5.get(var0);
         if (var4 != null) {
            return var4;
         }
      }

      Map var6 = visualSupport61.v1;
      return var6 == null ? null : (class_1087)var6.get(var0);
   }
}
