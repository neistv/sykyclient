package cc.syky.cloud;

import cc.syky.hud.HudManager;
import cc.syky.hud.hudSupport75;
import cc.syky.ui.uiSupport226;
import java.util.List;

public final class cloudSupport72 implements cloudSupport82 {
   private final uiSupport226 v1;
   private final hudSupport75 v2;
   private final cloudSupport99 v3;
   private final HudManager v4;
   private final Runnable v5;

   public cloudSupport72(uiSupport226 var1, hudSupport75 var2, cloudSupport99 var3, HudManager var4, Runnable var5) {
      this.v1 = var1;
      this.v2 = var2;
      this.v3 = var3;
      this.v4 = var4;
      this.v5 = var5;
   }

   @Override
   public String v1() {
      return "resetSettings";
   }

   @Override
   public String v2() {
      return "reset client to defaults: modules, settings, binds, HUD layout (with auto-save on, this is written over the active config)";
   }

   @Override
   public void v1(cloudSupport81 var1, List<String> var2) {
      if (!var2.isEmpty()) {
         var1.v2("usage: resetSettings");
      } else {
         this.v1.v5();
         this.v1.v4();
         this.v2.v5();
         this.v3.v2();
         this.v4.v10();
         this.v5.run();
         var1.v1("reset to defaults - with auto-save on this is written over the active config in a moment, and relaunching will not undo it");
      }
   }
}
