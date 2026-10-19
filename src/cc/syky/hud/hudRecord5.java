package cc.syky.hud;

import java.util.UUID;

public record hudRecord5(UUID player, boolean own, String name, float secondsLeft) {
   public UUID v1() {
      return this.player;
   }

   public boolean v2() {
      return this.own;
   }

   public String v3() {
      return this.name;
   }

   public float v4() {
      return this.secondsLeft;
   }
}
