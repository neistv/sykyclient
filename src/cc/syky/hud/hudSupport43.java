package cc.syky.hud;

public final class hudSupport43 {
   public static final float v1 = 36.0F;
   public static final float v2 = 18.0F;
   public static final float v3 = 24.0F;
   public static final float v4 = 16.0F;
   public static final float v5 = 0.71875F;
   public static final float v6 = 10.0F;
   public static final float v7 = 10.0F;
   public static final float v8 = 10.0F;
   public static final int v9 = 855638016;
   public static final int v10 = -1;
   public static final String v11 = "syky_sans_strong";

   private hudSupport43() {
   }

   public static String v1(double var0) {
      long var2 = Math.round(var0 * 10.0);
      long var4 = var2 / 10L;
      int var6 = (int)Math.abs(var2 - var4 * 10L);
      if (var6 == 0) {
         return Long.toString(var4);
      } else {
         StringBuilder var7 = new StringBuilder(8);
         if (var2 < 0L && var4 == 0L) {
            var7.append('-');
         }

         var7.append(var4).append('.').append(var6);
         return var7.toString();
      }
   }
}
