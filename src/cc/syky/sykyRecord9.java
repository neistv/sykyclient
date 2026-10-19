package cc.syky;

import cc.syky.internal.InternalSupport7;
import cc.syky.ui.MicrosoftSignSupport;
import cc.syky.ui.SKINSupport;

public record sykyRecord9(InternalSupport7 waypoints, MicrosoftSignSupport accounts, SKINSupport skins) {
   public InternalSupport7 v1() {
      return this.waypoints;
   }

   public MicrosoftSignSupport v2() {
      return this.accounts;
   }

   public SKINSupport v3() {
      return this.skins;
   }
}
