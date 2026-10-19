package cc.syky.hud;

public final class hudSupport70 {
   public static final float v1 = 0.25F;
   public static final float v2 = 2.0F;
   public static final float v3 = 0.75F;
   public static final int v4 = 1;
   public static final float v5 = 1.0F;
   public static final float v6 = 2.0F;
   public static final float v7 = 1.25F;
   public static final float v8 = 1.0F;
   private static boolean v9 = true;
   private static float v10 = 0.75F;
   private static float v11 = 1.25F;
   private static boolean v12 = true;
   private static float v13 = 1.0F;
   private static boolean v14 = false;

   private hudSupport70() {
   }

   public static boolean v1() {
      return v9;
   }

   public static void v1(boolean var0) {
      v9 = var0;
   }

   public static float v2() {
      return v10;
   }

   public static void v1(float var0) {
      v10 = v1(var0, 0.25F, 2.0F);
   }

   public static float v3() {
      return v11;
   }

   public static void v2(float var0) {
      v11 = v1(var0, 1.0F, 2.0F);
   }

   public static boolean v4() {
      return v12;
   }

   public static void v2(boolean var0) {
      v12 = var0;
   }

   public static float v5() {
      return v13;
   }

   public static void v3(float var0) {
      v13 = v1(var0, 0.0F, 1.0F);
   }

   public static boolean v6() {
      return v14;
   }

   public static void v3(boolean var0) {
      v14 = var0;
   }

   private static float v1(float var0, float var1, float var2) {
      return var0 < var1 ? var1 : (var0 > var2 ? var2 : var0);
   }
}
