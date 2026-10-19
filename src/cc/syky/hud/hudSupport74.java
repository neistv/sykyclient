package cc.syky.hud;

public enum hudSupport74 implements hudSupport64 {
   SLOT_1(0, "1"),
   SLOT_2(1, "2"),
   SLOT_3(2, "3"),
   SLOT_4(3, "4"),
   SLOT_5(4, "5"),
   SLOT_6(5, "6"),
   SLOT_7(6, "7"),
   SLOT_8(7, "8"),
   SLOT_9(8, "9");

   private final int index;
   private final String label;

   private hudSupport74(int var3, String var4) {
      this.index = var3;
      this.label = var4;
   }

   @Override
   public String v1() {
      return this.label;
   }

   public int v2() {
      return this.index;
   }

   public int v3() {
      return 1 << this.index;
   }
}
