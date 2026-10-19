package cc.syky.ui;

public final class uiSupport107 {
   private uiSupport107() {
   }

   public static void v1(float var0, float var1, float var2, int var3) {
      v1(var0, var1, var2, var3, 1.0F, 1.0F);
   }

   public static void v1(float var0, float var1, float var2, int var3, float var4) {
      v1(var0, var1, var2, var3, var4, 1.0F);
   }

   public static void v1(float var0, float var1, float var2, int var3, float var4, float var5) {
      float var6 = SignInSupport.v4(24.0F, var2);
      uiRecord7 var7 = uiRecord7.v1(7.0F * var2);
      int var8 = var5 >= 1.0F ? var3 : uiSupport155.v2(var3, 0.579F + 0.421F * var5);
      uiSupport169.v1(var0, var1, var6, var6, uiSupport155.v1(var8, var4), var7);
      uiSupport169.v1(var0, var1, var6, var6, uiSupport155.v1(SignInSupport.v1(452984831, var2), var4), SignInSupport.v2(var2), var7, 1.0F);
   }

   public static boolean v1(float var0, float var1, float var2, float var3, float var4) {
      float var5 = 2.0F * var4;
      float var6 = SignInSupport.v4(24.0F, var4);
      return var0 >= var2 - var5 && var0 <= var2 + var6 + var5 && var1 >= var3 - var5 && var1 <= var3 + var6 + var5;
   }
}
