package cc.syky.ui;

import cc.syky.config.configSupport10;
import cc.syky.render.renderSupport46;
import net.minecraft.class_2960;
import net.minecraft.class_310;

public final class uiSupport140 {
   private static final float v1 = 1.0F;
   private static boolean v2;

   private uiSupport140() {
   }

   public static void v1(renderSupport46 var0, class_310 var1) {
      if (!v2 && var1.method_18506() == null) {
         v2 = true;
         var0.v33().v1();

         for (class_2960 var3 : uiSupport143.v1()) {
            var1.method_1531().method_4619(var3);
         }
      }
   }

   public static void v1(uiSupport226 var0, configSupport10 var1) {
      uiSupport259.v1("ui.clickgui.warmup", () -> {
         NothingFoundSupport var2 = new NothingFoundSupport(var0, null, var1, 1.0F, AltManagerSupport.VISUAL, null, null);
         new ModulesSupport(1.0F, AltManagerSupport.VISUAL, var0xx -> {});
         new uiSupport40(1.0F, var2::v1, () -> {}, () -> {}, () -> {}, () -> {}, () -> {}, () -> {});
      });
   }
}
