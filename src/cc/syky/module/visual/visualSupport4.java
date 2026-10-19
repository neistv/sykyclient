package cc.syky.module.visual;

public enum visualSupport4 {
   CRIT("crit", 16.0F),
   KNOCKBACK("knockback", 16.0F),
   SWEEP("sweep", 16.0F),
   HIT("hit", 16.0F),
   NO_DAMAGE("noDamage", 16.0F),
   MACE("mace", 16.0F),
   TOTEM_SELF("totemSelf", 16.0F),
   TOTEM_ENEMY("totemEnemy", 32.0F),
   EXPLOSION("explosion", 64.0F);

   private final String key;
   private final float rolloff;

   private visualSupport4(String var3, float var4) {
      this.key = var3;
      this.rolloff = var4;
   }

   public String v1() {
      return this.key;
   }

   public float v2() {
      return this.rolloff;
   }
}
