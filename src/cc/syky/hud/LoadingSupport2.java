package cc.syky.hud;

public final class LoadingSupport2 {
   public static final float v1 = 244.0F;
   public static final float v2 = 117.0F;
   public static final float v3 = 244.0F;
   public static final float v4 = 13.0F;
   public static final float v5 = 20.0F;
   public static final float v6 = 7.0F;
   public static final int v7 = 855638016;
   public static final int v8 = 450484697;
   public static final float v9 = 16.0F;
   public static final int v10 = -2130706433;
   public static final String v11 = "Click here to add image";
   public static final String v12 = "Loading...";
   public static final float v13 = 12.0F;
   public static final float v14 = 40.0F;
   public static final float v15 = 8.0F;
   public static final int v16 = 3;
   public static final float v18 = 300.0F;
   public static final float v19 = 8.0F;

   private LoadingSupport2() {
   }

   public static float v1(int var0) {
      return 300.0F + var0 % 3 * 252.0F;
   }

   public static float v2(int var0) {
      return 8.0F + var0 / 3 * 125.0F;
   }

   public static float v1(int var0, int var1) {
      if (var0 > 0 && var1 > 0) {
         return var0 >= var1 ? 244.0F : 244.0F * var0 / var1;
      } else {
         return 244.0F;
      }
   }

   public static float v2(int var0, int var1) {
      if (var0 > 0 && var1 > 0) {
         return var1 >= var0 ? 244.0F : 244.0F * var1 / var0;
      } else {
         return 117.0F;
      }
   }
}
