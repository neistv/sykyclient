package cc.syky.module.visual;

import cc.syky.hud.hudSupport64;

public enum LeftSupport implements hudSupport64 {
   LEFT("Left"),
   CENTER("Center");

   private final String label;

   private LeftSupport(String var3) {
      this.label = var3;
   }

   @Override
   public String v1() {
      return this.label;
   }
}
