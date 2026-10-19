package cc.syky.ui;

public final class uiSupport132 {
   private static final float v6 = 0.78F;
   private static final float v7 = 0.62F;
   private static final float v8 = 0.5F;
   public static final uiSupport132.Part1 v1 = new uiSupport132.Part1(3.25F, 0.94F);
   public static final uiSupport132.Part1 v2 = new uiSupport132.Part1(6.5F, 0.7F);
   public static final uiSupport132.Part1 v3 = new uiSupport132.Part1(3.25F, 0.6F);
   public static final uiSupport132.Part1 v4 = v3.v1(0.5F);
   public static final uiSupport132.Part1 v5 = new uiSupport132.Part1(10.400001F, 0.7F, 0.62F);

   private uiSupport132() {
   }

   public static boolean v1(uiSupport132.Part1 var0, float var1, float var2, float var3, float var4, float var5, float var6) {
      if (!(var1 <= 0.0F) && !(var1 >= 1.0F)) {
         float var7 = v2(var0, var1, var6);
         return uiSupport169.v2(var2 - var7, var3 - var7, var4 + 2.0F * var7, var5 + 2.0F * var7);
      } else {
         return false;
      }
   }

   public static void v2(uiSupport132.Part1 var0, float var1, float var2, float var3, float var4, float var5, float var6) {
      float var7 = v2(var0, var1, var6);
      float var8 = 1.0F - (1.0F - var0.v2()) * (1.0F - v2(var0, var1));
      uiSupport169.v1(
         v1(var0, var1),
         var2 + var4 / 2.0F,
         var3 + var5 / 2.0F,
         var8,
         var8,
         v1(var0, var1, var6),
         var2 - var7,
         var3 - var7,
         var4 + 2.0F * var7,
         var5 + 2.0F * var7
      );
   }

   private static float v1(uiSupport132.Part1 var0, float var1) {
      float var2 = var0.v3();
      if (var2 >= 1.0F) {
         return var1;
      } else {
         float var3 = var1 / var2;
         float var4 = var3 >= 1.0F ? 0.0F : 1.0F - var3;
         return 1.0F - var4 * var4 * var4;
      }
   }

   private static float v2(uiSupport132.Part1 var0, float var1) {
      float var2 = var0.v4();
      return var2 >= 1.0F ? var1 : var1 * (var2 + (1.0F - var2) * var1);
   }

   private static float v1(uiSupport132.Part1 var0, float var1, float var2) {
      float var3 = var1 / 0.78F;
      float var4 = var3 >= 1.0F ? 0.0F : 1.0F - var3;
      return var0.v1() * var2 * var4 * (float)Math.sqrt(var4);
   }

   private static float v2(uiSupport132.Part1 var0, float var1, float var2) {
      return 2.0F * v1(var0, var1, var2) + 1.0F;
   }

   public record Part1(float blurDesignPx, float depthScale, float fadeInBy, float growthStartSpeed) {
      public Part1(float var1, float var2, float var3) {
         this(var1, var2, var3, 1.0F);
      }

      public Part1(float var1, float var2) {
         this(var1, var2, 1.0F);
      }

      public uiSupport132.Part1 v1(float var1) {
         return new uiSupport132.Part1(this.blurDesignPx, this.depthScale, this.fadeInBy, var1);
      }

      public float v1() {
         return this.blurDesignPx;
      }

      public float v2() {
         return this.depthScale;
      }

      public float v3() {
         return this.fadeInBy;
      }

      public float v4() {
         return this.growthStartSpeed;
      }
   }
}
