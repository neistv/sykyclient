package cc.syky.hud;

public enum ArmorStandsSupport implements hudSupport64 {
   PLAYERS("Players"),
   MOBS("Mobs"),
   ARMOR_STANDS("Armor Stands"),
   CRYSTALS("Crystals"),
   ITEMS("Items"),
   PROJECTILES("Projectiles"),
   SELF("Yourself");

   private final String label;

   private ArmorStandsSupport(String var3) {
      this.label = var3;
   }

   @Override
   public String v1() {
      return this.label;
   }
}
