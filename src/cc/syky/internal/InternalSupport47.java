package cc.syky.internal;

import net.minecraft.class_1309;

public final class InternalSupport47 {
   private static final double v2 = Math.PI * 2;
   public static final double v1 = 2.2;

   private InternalSupport47() {
   }

   public static void v1(InternalSupport31.Part1 var0, class_1309 var1, float var2, double var3, double var5, float var7, int var8, float var9, float var10) {
      if (!var1.method_31481()) {
         double var11 = (Math.PI * 2) * (var3 - Math.floor(var3));
         int var13 = Math.round(Math.min(1.0F, var9 * var10 * 0.5F) * 255.0F);
         int var14 = var13 << 24 | var8 & 16777215;
         InternalSupport31.v1(var0, var1, var2, var14, (float)var5, (float)var11, var7);
      }
   }
}
