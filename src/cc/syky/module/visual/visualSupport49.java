package cc.syky.module.visual;

public final class visualSupport49 {
   public static final float v1 = 0.1F;
   public static boolean v2;
   public static float v3 = 0.5F;
   public static boolean v4 = true;
   public static boolean v5 = true;

   private visualSupport49() {
   }

   public static int v1() {
      if (!v2) {
         return -1;
      } else {
         int var0 = Math.round(Math.max(0.1F, Math.min(1.0F, v3)) * 255.0F);
         return var0 >= 255 ? -1 : var0 << 24 | 16777215;
      }
   }
}
