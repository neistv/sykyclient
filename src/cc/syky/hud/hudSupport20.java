package cc.syky.hud;

public final class hudSupport20 {
   public static final float v1 = 5000.0F;
   private static final float v2 = 0.24F;
   private static final float v3 = 0.44F;
   private static final float v4 = 1.0F;
   private static final float v5 = 1.7F;
   private static final float v6 = (float) (Math.PI * 2);

   private hudSupport20() {
   }

   public static float v1(float var0) {
      if (var0 >= 5000.0F) {
         return 1.0F;
      } else {
         float var1 = Math.max(0.0F, var0);
         float var2 = 1.0F - var1 / 5000.0F;
         float var3 = 0.24F + 0.2F * var2;
         float var4 = 0.5F - 0.5F * (float)Math.cos(v2(var1));
         return 1.0F - var3 * var4;
      }
   }

   private static float v2(float var0) {
      float var1 = -1.4E-4F;
      float var2 = (1.7F * (5000.0F - var0) + var1 * (2.5E7F - var0 * var0) * 0.5F) / 1000.0F;
      return (float) (Math.PI * 2) * var2;
   }
}
