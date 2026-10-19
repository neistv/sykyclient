package cc.syky.ui;

import cc.syky.hud.hudSupport64;

public enum LastSeenDisplay implements hudSupport64 {
   SERVER_AND_TIME("Server and time"),
   TIME("Last played"),
   SERVER("Server"),
   NOTHING("Nothing");

   private final String label;

   private LastSeenDisplay(String var3) {
      this.label = var3;
   }

   @Override
   public String v1() {
      return this.label;
   }

   public boolean v2() {
      return this == SERVER_AND_TIME || this == SERVER;
   }

   public boolean v3() {
      return this == SERVER_AND_TIME || this == TIME;
   }
}
