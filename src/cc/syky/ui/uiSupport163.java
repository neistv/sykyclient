package cc.syky.ui;

import com.mojang.blaze3d.opengl.GlStateManager;

public final class uiSupport163 {
   public static boolean v1;
   public static long v2;
   private static int v3;
   private static boolean v4 = true;

   private uiSupport163() {
   }

   public static void v1() {
      v3++;
      v1 = v4;
   }

   public static void v2() {
      if (v3 != 0) {
         if (--v3 == 0) {
            v1 = false;
            GlStateManager._glBindFramebuffer(36160, 0);
         }
      }
   }

   public static void v1(boolean var0) {
      v4 = var0;
   }
}
