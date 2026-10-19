package cc.syky.ui;

public final class uiSupport126 {
   private uiSupport126() {
   }

   public static float v1(float var0, float var1, float var2) {
      return v1(var0, var1, var2, var1);
   }

   public static float v1(float var0, float var1, float var2, float var3) {
      float var4 = uiSupport169.v1((var3 - var2) * 0.5F);
      return var0 + (var1 - var3) * 0.5F + var4;
   }

   public static float v2(float var0, float var1, float var2) {
      return var0 + (var1 - 47.0F * var2) / 2.0F + 13.0F * var2;
   }
}
