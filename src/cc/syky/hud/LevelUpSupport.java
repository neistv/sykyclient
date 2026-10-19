package cc.syky.hud;

public enum LevelUpSupport implements hudSupport64 {
   PLING("Pling", "block.note_block.pling"),
   BELL("Bell", "block.note_block.bell"),
   CHIME("Chime", "block.note_block.chime"),
   XYLOPHONE("Xylophone", "block.note_block.xylophone"),
   HARP("Harp", "block.note_block.harp"),
   FLUTE("Flute", "block.note_block.flute"),
   BIT("Bit", "block.note_block.bit"),
   AMETHYST("Amethyst", "block.amethyst_block.chime"),
   ORB("Experience orb", "entity.experience_orb.pickup"),
   LEVEL_UP("Level up", "entity.player.levelup"),
   VILLAGE_BELL("Village bell", "block.bell.use"),
   TOAST("Toast", "ui.toast.in");

   private final String label;
   private final String id;

   private LevelUpSupport(String var3, String var4) {
      this.label = var3;
      this.id = var4;
   }

   @Override
   public String v1() {
      return this.label;
   }

   public String v2() {
      return this.id;
   }
}
