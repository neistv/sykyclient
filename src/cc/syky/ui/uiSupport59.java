package cc.syky.ui;

public final class uiSupport59 {
   private uiSupport59() {
   }

   public static uiSupport59.Part1 v1(float var0, float var1, float var2, float var3, float var4, float var5, float var6, float var7, float var8) {
      float var9 = var2 + var3 * var8;
      float var10 = var4 + var5 / 2.0F;
      if (Math.abs(var0 - var9) <= var6 * 0.75F && Math.abs(var1 - var10) <= var7 * 0.75F) {
         return uiSupport59.Part1.THUMB;
      } else {
         float var11 = var7 / 2.0F;
         return var0 >= var2 && var0 <= var2 + var3 && var1 >= var10 - var11 && var1 <= var10 + var11 ? uiSupport59.Part1.TRACK : uiSupport59.Part1.NONE;
      }
   }

   public static enum Part1 {
      NONE,
      THUMB,
      TRACK;

      private Part1() {
      }
   }
}
