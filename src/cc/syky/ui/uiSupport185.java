package cc.syky.ui;

public final class uiSupport185 {
   private static final float v1 = 12.0F;
   private static final float v2 = 0.1F;
   private static final float v3 = 0.01F;
   private static float v4;
   private static boolean v5;
   private static long v6;

   private uiSupport185() {
   }

   public static float v1(int var0) {
      boolean var1 = uiSupport184.v1 || uiSupport184.v2;
      if (!v5) {
         v4 = var0;
         if (!var1) {
            return var0;
         }

         v5 = true;
         v6 = 0L;
      }

      float var2 = var1 ? uiSupport184.v3 : var0;
      long var3 = System.nanoTime();
      float var5 = v6 == 0L ? 0.0F : Math.min((float)(var3 - v6) / 1.0E9F, 0.1F);
      v6 = var3;
      if (var5 > 0.0F) {
         v4 = v4 + (var2 - v4) * (1.0F - (float)Math.exp(-12.0F * var5));
      }

      if (!var1 && Math.abs(var2 - v4) < 0.01F) {
         v4 = var2;
         v5 = false;
      }

      return v4;
   }

   public static boolean v1() {
      return v5;
   }

   public static float v2() {
      return v5 && v4 >= 1.0F ? v4 / (int)v4 : 1.0F;
   }
}
