package cc.syky.ui;

import cc.syky.module.ModuleCategory;

public enum AltManagerSupport {
   VISUAL("Visuals", "visual", AltManagerSupport.Part1.COLUMN, ModuleCategory.VISUAL),
   UTILITIES("Utilities", "utilities", AltManagerSupport.Part1.COLUMN, ModuleCategory.UTILITIES),
   ADVANCED("Advanced", "advanced", AltManagerSupport.Part1.COLUMN, ModuleCategory.ADVANCED),
   WAYPOINTS("Waypoints", "waypoints", AltManagerSupport.Part1.COLUMN),
   ALTS("Alt manager", "alts", AltManagerSupport.Part1.COLUMN),
   SOCIALS("Socials", "socials", AltManagerSupport.Part1.COLUMN),
   ACCOUNT("Account", "account", AltManagerSupport.Part1.FOOT);

   private final String label;
   private final String iconKey;
   private final AltManagerSupport.Part1 slot;
   private final ModuleCategory[] categories;

   private AltManagerSupport(String var3, String var4, AltManagerSupport.Part1 var5, ModuleCategory... var6) {
      this.label = var3;
      this.iconKey = var4;
      this.slot = var5;
      this.categories = var6;
   }

   public String v1() {
      return this.label;
   }

   public String v2() {
      return this.iconKey;
   }

   public AltManagerSupport.Part1 v3() {
      return this.slot;
   }

   public ModuleCategory[] v4() {
      return this.categories;
   }

   public static enum Part1 {
      COLUMN,
      FOOT;

      private Part1() {
      }
   }
}
