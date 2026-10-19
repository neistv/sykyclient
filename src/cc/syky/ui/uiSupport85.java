package cc.syky.ui;

import java.util.function.Consumer;

public final class uiSupport85 {
   private uiSupport85() {
   }

   public static void v1(
      uiSupport35 var0,
      Consumer<uiSupport35> var1,
      boolean var2,
      float var3,
      float var4,
      float var5,
      float var6,
      uiRecord7 var7,
      float var8,
      float var9,
      float var10,
      float var11,
      float var12,
      float var13
   ) {
      boolean var14 = var2 && uiSupport169.v5();
      if (!var14) {
         uiSupport169.v6(var3, var12, var5, var13);

         try {
            var1.accept(var0);
         } finally {
            uiSupport169.v17();
         }
      } else {
         uiSupport169.v6(var3, var4, var5, var6);

         try {
            var1.accept(var0);
         } finally {
            int var17 = uiSupport169.v1("gpu.clickgui.veil");
            uiSupport169.v1(var3, var4, var5, var6, var7, var8, var9, var10, 0.0F, var8, var11, var4 + var6, 0.4F);
            uiSupport169.v1(var17);
            uiSupport169.v17();
         }
      }
   }
}
