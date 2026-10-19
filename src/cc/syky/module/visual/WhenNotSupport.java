package cc.syky.module.visual;

import cc.syky.hud.hudSupport64;

public enum WhenNotSupport implements hudSupport64 {
   NEVER("Never"),
   NOT_FOUND("When not found"),
   ALWAYS("Always");

   private final String label;

   private WhenNotSupport(String var3) {
      this.label = var3;
   }

   @Override
   public String v1() {
      return this.label;
   }
}
