package cc.syky.module.visual;

import net.minecraft.class_1309;
import net.minecraft.class_310;

public final class visualSupport42 {
   public static final int v1 = -1291911168;
   public static final int v2 = 1308557312;
   private static final float v7 = 10.0F;
   private static final float v8 = 0.002F;
   private static final float v9 = 0.1F;
   public static boolean v3;
   public static int v4 = 1308557312;
   public static boolean v5;
   public static boolean v6;

   private visualSupport42() {
   }

   public static float v1(class_1309 var0) {
      boolean var1 = var0.field_6235 > 0 || var0.field_6213 > 0;
      visualSupport41 var2 = (visualSupport41)var0;
      if (!v5) {
         if (!var1 && var2.syky$hurtDecay() != null) {
            var2.syky$hurtDecay(null);
         }

         return var1 ? 1.0F : 0.0F;
      } else {
         visualSupport42.Part1 var3 = var2.syky$hurtDecay();
         if (var1) {
            if (var3 == null) {
               var3 = new visualSupport42.Part1();
               var2.syky$hurtDecay(var3);
            }

            var3.v1 = 1.0F;
            var3.v2 = System.nanoTime();
            return 1.0F;
         } else if (var3 == null) {
            return 0.0F;
         } else {
            long var4 = System.nanoTime();
            float var6 = Math.min((float)(var4 - var3.v2) / 1.0E9F, 0.1F);
            var3.v2 = var4;
            var3.v1 = var3.v1 * (float)Math.exp(-10.0F * var6);
            if (var3.v1 < 0.002F) {
               var2.syky$hurtDecay(null);
               return 0.0F;
            } else {
               return var3.v1;
            }
         }
      }
   }

   public static void v1() {
      class_310 var0 = class_310.method_1551();
      if (var0 != null && var0.field_1773 != null) {
         if (var0.field_1773.method_22975() instanceof visualSupport52 var2) {
            var2.syky$sync(v3, v4);
         }
      }
   }

   public static final class Part1 {
      public float v1;
      public long v2;

      public Part1() {
      }
   }
}
