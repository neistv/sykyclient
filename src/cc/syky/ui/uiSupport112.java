package cc.syky.ui;

public final class uiSupport112 {
   public static final float v1 = 9.0F;
   public static final float v2 = 2.0F;
   public static final float v3 = 20.0F;

   private uiSupport112() {
   }

   public static void v1(float var0, float var1, float var2, float var3, int var4) {
      float var5 = var2 / 2.0F;
      uiSupport169.v3(var0 - var5, var1 - var5, var0 + var5, var1 + var5, var4, var3);
      uiSupport169.v3(var0 - var5, var1 + var5, var0 + var5, var1 - var5, var4, var3);
   }

   public static void v2(float var0, float var1, float var2, float var3, int var4) {
      if (!(var3 <= 0.0F)) {
         float var5 = 9.0F * var2;
         boolean var6 = uiSupport132.v1(uiSupport132.v3, var3, var0 - var5 / 2.0F, var1 - var5 / 2.0F, var5, var5, var2);

         try {
            v1(var0, var1, var5, 2.0F * var2, var6 ? var4 : uiSupport155.v1(var4, var3));
         } finally {
            if (var6) {
               uiSupport132.v2(uiSupport132.v3, var3, var0 - var5 / 2.0F, var1 - var5 / 2.0F, var5, var5, var2);
            }
         }
      }
   }
}
