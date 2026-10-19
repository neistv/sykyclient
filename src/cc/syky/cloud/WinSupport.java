package cc.syky.cloud;

public enum WinSupport {
   WIN("Win", "Wn"),
   LOSE("Lose", "Ls"),
   DRAW("Draw", "Dr");

   public static final float TIE = 0.05F;
   private final String label;
   private final String shortLabel;
   public static final float FULL_LEAN = 0.5F;

   private WinSupport(String var3, String var4) {
      this.label = var3;
      this.shortLabel = var4;
   }

   public String v1() {
      return this.label;
   }

   public String v2() {
      return this.shortLabel;
   }

   public static float v1(float var0, float var1) {
      float var2 = Math.max(0.0F, var0);
      float var3 = Math.max(0.0F, var1);
      float var4 = Math.max(var2, var3);
      if (var4 <= 0.0F) {
         return 0.0F;
      } else {
         float var5 = (var2 - var3) / var4 / 0.5F;
         return var5 > 1.0F ? 1.0F : Math.max(var5, -1.0F);
      }
   }

   public static float v2(float var0, float var1) {
      return Math.max(0.0F, var0) + Math.max(0.0F, var1);
   }

   public static WinSupport v3(float var0, float var1) {
      float var2 = Math.max(0.0F, var0) - Math.max(0.0F, var1);
      if (var2 >= 0.05F) {
         return WIN;
      } else {
         return var2 <= -0.05F ? LOSE : DRAW;
      }
   }
}
