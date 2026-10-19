package cc.syky.ui;

import net.minecraft.class_2960;

public final class uiSupport68 {
   private static final class_2960 v1 = class_2960.method_60655("syky", "textures/ui/icons/chevron.png");
   private static final float v2 = 0.5833333F;

   private uiSupport68() {
   }

   public static void v1(float var0, float var1, float var2, float var3, float var4, String var5, float var6) {
      v1(var0, var1, var2, var3, var4, var5, var6, 1.0F);
   }

   public static void v1(float var0, float var1, float var2, float var3, float var4, String var5, float var6, float var7) {
      boolean var8 = var7 >= 1.0F;
      int var9 = var8 ? SignInSupport.v107() : uiSupport155.v1(SignInSupport.v121(), SignInSupport.v107(), var7);
      int var10 = var8 ? SignInSupport.v118() : uiSupport155.v1(SignInSupport.v137(), SignInSupport.v118(), var7);
      float var11 = 12.0F * var4;
      float var12 = var11 * 0.5833333F;
      float var13 = v1(var0, var2, var4);
      uiSupport169.v2(v1, var13, var1 + var3 / 2.0F - var11 / 2.0F, var12, var11, 0.0F, 0.0F, 1.0F, 1.0F, uiSupport155.v1(var10, var6), uiRecord7.ZERO);
      uiSupport169.v2(
         "syky_sans_strong", var5, v2(var0, var2, var4), uiSupport169.v1(var1 + var3 / 2.0F, 18.0F * var4), 18.0F * var4, uiSupport155.v1(var9, var6)
      );
   }

   public static float v1(float var0, float var1, float var2, String var3) {
      return v2(var0, var1, var2) - uiSupport169.v2("syky_sans_strong", var3, 18.0F * var2);
   }

   public static float v1(float var0) {
      return var0 + 10.0F + 7.0F + 0.0F;
   }

   private static float v1(float var0, float var1, float var2) {
      return var0 + var1 - 0.0F * var2 - 12.0F * var2 * 0.5833333F;
   }

   private static float v2(float var0, float var1, float var2) {
      return v1(var0, var1, var2) - 10.0F * var2;
   }

   public static boolean v1(float var0, float var1, float var2, float var3, float var4, float var5, float var6, String var7) {
      float var8 = 2.0F * var6;
      float var9 = v1(var2, var4, var6, var7) - 10.0F * var6;
      return var0 >= var9 && var0 <= var2 + var4 + var8 && var1 >= var3 - var8 && var1 <= var3 + var5 + var8;
   }
}
