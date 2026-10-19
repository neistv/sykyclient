package cc.syky.cloud;

import java.util.Locale;

public enum AltManagerSupport2 {
   WAYPOINTS("Waypoints"),
   ALT_MANAGER("Alt manager");

   private final String label;
   private final String usageKey;

   private AltManagerSupport2(String var3) {
      this.label = var3;
      this.usageKey = "feature:" + this.name().toLowerCase(Locale.ROOT);
   }

   public String v1() {
      return this.label;
   }

   public String v2() {
      return this.usageKey;
   }
}
