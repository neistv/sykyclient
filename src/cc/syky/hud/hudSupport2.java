package cc.syky.hud;

import cc.syky.ui.uiSupport169;
import org.jetbrains.annotations.Nullable;

public final class hudSupport2 {
   private static final float v1 = 4.0F;

   private hudSupport2() {
   }

   public static float v1(float var0) {
      return Math.max(4.0F, uiSupport169.v3(var0));
   }

   public static boolean v1(@Nullable hudSupport3 var0, float var1, float var2, float var3, float var4, float var5) {
      return v1(var0, var1, var2, var3, var4, var5, 0.0F, 0.0F, 0.0F, 0.0F);
   }

   public static boolean v1(
      @Nullable hudSupport3 var0, float var1, float var2, float var3, float var4, float var5, float var6, float var7, float var8, float var9
   ) {
      if (var0 != null && var0.v6() && !(var3 <= 0.0F) && !(var4 <= 0.0F)) {
         float var10 = v1(var5);
         float var11 = var1 - var10;
         float var12 = var2 - var10;
         float var13 = var1 + var3 + var10;
         float var14 = var2 + var4 + var10;
         if (var8 > 0.0F && var9 > 0.0F) {
            var11 = Math.min(var11, var6);
            var12 = Math.min(var12, var7);
            var13 = Math.max(var13, var6 + var8);
            var14 = Math.max(var14, var7 + var9);
         }

         return uiSupport169.v1(var1, var2, var3, var4, var11, var12, var13 - var11, var14 - var12, var0.v7());
      } else {
         return false;
      }
   }

   public static void v1() {
      uiSupport169.v6();
   }
}
