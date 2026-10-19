package cc.syky.hud;

public final class hudSupport15 {
   public static final float v1 = 130.0F;
   public static final float v2 = 85.0F;
   public static final float v3 = 3.0F;
   public static final float v4 = 14.0F;
   public static final float v5 = 0.75F;
   private static final float v6 = 0.5F;
   private static final float v7 = 0.42F;
   private static final float v8 = 0.72F;
   private static final float v9 = 3.0F;
   private static final float v10 = 0.35F;
   private static final float v11 = 0.35F;
   private static final float v12 = 0.9F;

   private hudSupport15() {
   }

   public static float v1(float var0) {
      return 3.0F * hudSupport60.v2(Math.clamp(var0, 0.0F, 1.0F));
   }

   public static float v1(float var0, float var1) {
      float var2 = hudSupport60.v2(Math.clamp(var0, 0.0F, 1.0F));
      float var3 = 0.5F * v2(var1);
      return 1.0F - (1.0F - var3) * var2;
   }

   public static float v2(float var0) {
      float var1 = Math.clamp(var0, 0.0F, 1.0F);
      return var1 <= 0.75F ? 0.0F : hudSupport60.v1((var1 - 0.75F) / 0.25F);
   }

   public static float v3(float var0) {
      return hudSupport60.v2(v2(v6(var0), 0.35F));
   }

   public static float v4(float var0) {
      return 0.72F + 0.27999997F * hudSupport60.v1(v6(var0));
   }

   public static float v5(float var0) {
      float var1 = v1(v6(var0), 0.35F, 0.9F);
      float var2 = 1.0F - var1;
      return 3.0F * var2 * (float)Math.sqrt(var2);
   }

   private static float v6(float var0) {
      float var1 = Math.clamp(var0, 0.0F, 1.0F);
      return var1 <= 0.42F ? 0.0F : (var1 - 0.42F) / 0.58000004F;
   }

   private static float v2(float var0, float var1) {
      return var0 >= var1 ? 1.0F : var0 / var1;
   }

   private static float v1(float var0, float var1, float var2) {
      return var0 <= var1 ? 0.0F : (var0 >= var2 ? 1.0F : (var0 - var1) / (var2 - var1));
   }
}
