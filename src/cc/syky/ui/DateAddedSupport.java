package cc.syky.ui;

import cc.syky.hud.hudSupport64;

public enum DateAddedSupport implements hudSupport64 {
   LAST_USED("Last played"),
   ADDED("Date added"),
   NAME("Name");

   private final String label;

   private DateAddedSupport(String var3) {
      this.label = var3;
   }

   @Override
   public String v1() {
      return this.label;
   }
}
