package cc.syky.cloud;

public final class cloudSupport13 {
   public static final int v1 = 182;
   public static final int v2 = 5;
   public static final int v3 = 9;
   public static final int v4 = 19;
   public static final int v5 = 1;
   private static final int v6 = 3;
   private static final int v7 = 12;

   private cloudSupport13() {
   }

   public static float v1(int var0) {
      return Math.max(182, var0 + 1);
   }

   public static float v2(int var0) {
      return var0 <= 0 ? 0.0F : var0 * 19 - 5;
   }

   public static float v3(int var0) {
      return var0 * 19.0F;
   }

   public static float v4(int var0) {
      return var0 * 19.0F + 9.0F;
   }

   public static int v5(int var0) {
      double var1 = (var0 / 3.0 - 12.0) / 19.0;
      return Math.max(1, (int)Math.ceil(var1));
   }

   public static int v1(float var0) {
      if (!(var0 > 0.0F)) {
         return 0;
      } else {
         return var0 >= 1.0F ? 182 : (int)Math.floor(var0 * 181.0F) + 1;
      }
   }
}
