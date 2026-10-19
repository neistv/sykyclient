package cc.syky.ui;

public final class uiSupport72 {
   private static final float v1 = 0.065636F;
   private static final float v2 = 0.49018F;
   private static final float v3 = 0.359792F;
   private static final float v4 = 0.906936F;
   private static final float v5 = 0.934363F;
   private static final float v6 = 0.092977F;
   private static final float v7 = 0.134298F;

   private uiSupport72() {
   }

   public static void v1(float var0, float var1, float var2, float var3, float var4) {
      int var5 = uiSupport155.v1(uiSupport79.v1(), var4);
      float var6 = 0.134298F * var2;
      float var7 = var0 + 0.065636F * var2;
      float var8 = var1 + 0.49018F * var3;
      float var9 = var0 + 0.359792F * var2;
      float var10 = var1 + 0.906936F * var3;
      float var11 = var0 + 0.934363F * var2;
      float var12 = var1 + 0.092977F * var3;
      uiSupport169.v3(var7, var8, var9, var10, var5, var6);
      uiSupport169.v3(var9, var10, var11, var12, var5, var6);
   }
}
