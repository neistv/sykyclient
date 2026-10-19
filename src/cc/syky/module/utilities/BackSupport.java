package cc.syky.module.utilities;

import cc.syky.hud.hudSupport64;
import net.minecraft.class_5498;

public enum BackSupport implements hudSupport64 {
   BACK("Back", class_5498.field_26665),
   FRONT("Front", class_5498.field_26666);

   private final String label;
   private final class_5498 perspective;

   private BackSupport(String var3, class_5498 var4) {
      this.label = var3;
      this.perspective = var4;
   }

   @Override
   public String v1() {
      return this.label;
   }

   public class_5498 v2() {
      return this.perspective;
   }
}
