package cc.syky.module.visual;

import org.joml.Vector3f;

public final class visualSupport12 {
   public static boolean v1;
   public static int v2 = 8026879;
   public static float v3 = 1.0F;
   public static float v4 = 1.0F;

   private visualSupport12() {
   }

   public static float v1(float var0, int var1) {
      if (!v1) {
         return var0;
      } else {
         float var2 = var0 * (var1 / 255.0F);
         return var0 + (var2 - var0) * Math.clamp(v3, 0.0F, 1.0F);
      }
   }

   public static Vector3f v1(Vector3f var0) {
      return !v1 ? var0 : var0.set(v1(var0.x, v2 >> 16 & 0xFF), v1(var0.y, v2 >> 8 & 0xFF), v1(var0.z, v2 & 0xFF));
   }

   public static float v1(float var0) {
      return v1 ? var0 * Math.max(v4, 0.0F) : var0;
   }
}
