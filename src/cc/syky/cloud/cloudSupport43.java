package cc.syky.cloud;

public final class cloudSupport43 {
   private static final int v2 = 0;
   private static final int v3 = 4;
   private static final int v4 = 8;
   private static final int v5 = 12;
   private static final int v6 = 16;
   private static final int v7 = 20;
   public static final cloudSupport43 v1 = new cloudSupport43(
      new float[]{
         0.171875F,
         0.03125F,
         0.015625F,
         0.53125F,
         0.1875F,
         0.03125F,
         0.34375F,
         0.53125F,
         0.171875F,
         0.03125F,
         0.1875F,
         0.53125F,
         0.0F,
         0.03125F,
         0.015625F,
         0.53125F,
         0.015625F,
         0.0F,
         0.171875F,
         0.03125F,
         0.171875F,
         0.0F,
         0.328125F,
         0.03125F
      }
   );
   private final float[] v8;

   private cloudSupport43(float[] var1) {
      this.v8 = var1;
   }

   public static cloudSupport43 v1(float[] var0) {
      if (var0.length != 24) {
         throw new IllegalArgumentException("a cape layout is 24 numbers");
      } else {
         for (float var4 : var0) {
            if (!(var4 >= 0.0F) || !(var4 <= 1.0F)) {
               throw new IllegalArgumentException("cape UV " + var4 + " is outside the texture");
            }
         }

         return new cloudSupport43((float[])var0.clone());
      }
   }

   public float[] v1() {
      return (float[])this.v8.clone();
   }

   public float v1(int var1) {
      return this.v8[var1];
   }

   public float v2(int var1) {
      return this.v8[var1 + 1];
   }

   public float v3(int var1) {
      return this.v8[var1 + 2];
   }

   public float v4(int var1) {
      return this.v8[var1 + 3];
   }

   public static int v2() {
      return 0;
   }

   public static int v3() {
      return 4;
   }

   public static int v4() {
      return 8;
   }

   public static int v5() {
      return 12;
   }

   public static int v6() {
      return 16;
   }

   public static int v7() {
      return 20;
   }
}
