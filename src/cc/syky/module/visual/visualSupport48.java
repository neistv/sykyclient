package cc.syky.module.visual;

import net.minecraft.class_1011;
import net.minecraft.class_2960;
import net.minecraft.class_310;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public final class visualSupport48 {
   private static final class_2960 v1 = class_2960.method_60656("block/fire_0");
   private static final class_2960 v2 = class_2960.method_60656("block/fire_1");
   private static final int v3 = 0;
   private static final float v4 = 0.003921569F;
   private static final Logger v5 = LoggerFactory.getLogger("syky.fire");
   private static volatile int v6 = 0;
   private static volatile int v7 = 0;
   private static volatile boolean v8;
   private static volatile boolean v9;

   private visualSupport48() {
   }

   public static void v1(int var0) {
      if (var0 != v6) {
         v6 = var0;
         v9 = true;
      }
   }

   public static boolean v1() {
      return v7 != 0;
   }

   public static void v2() {
      if (v9 && !v8) {
         int var0 = v6;
         if (var0 == v7) {
            v9 = false;
         } else {
            class_310 var1 = class_310.method_1551();
            if (var1 != null && var1.method_1478() != null) {
               v9 = false;
               v8 = true;
               v5.info("fire atlas: reloading resources to bake {}", v2(var0));

               try {
                  var1.method_1521().handle((var0x, var1x) -> {
                     v8 = false;
                     return null;
                  });
               } catch (Throwable var3) {
                  v8 = false;
                  v5.warn("fire atlas: resource reload request failed", var3);
               }
            }
         }
      }
   }

   public static void v1(class_2960 var0, class_1011 var1) {
      if (v1.equals(var0) || v2.equals(var0)) {
         int var2 = v6;
         if (var2 != 0) {
            v1(var1, var2);
         }

         if (v7 != var2) {
            v7 = var2;
            v5.info("fire atlas: baked {}", v2(var2));
         }
      }
   }

   private static String v2(int var0) {
      return var0 == 0 ? "the pack's own fire" : String.format("#%06X", var0 & 16777215);
   }

   private static void v1(class_1011 var0, int var1) {
      float var2 = (var1 >>> 16 & 0xFF) / 255.0F;
      float var3 = (var1 >>> 8 & 0xFF) / 255.0F;
      float var4 = (var1 & 0xFF) / 255.0F;
      float var5 = (var2 + var3 + var4) / 3.0F;
      int var6 = var0.method_4307();
      int var7 = var0.method_4323();

      for (int var8 = 0; var8 < var7; var8++) {
         for (int var9 = 0; var9 < var6; var9++) {
            int var10 = var0.method_61940(var9, var8);
            int var11 = var10 >>> 24 & 0xFF;
            if (var11 != 0) {
               float var12 = ((var10 >>> 16 & 0xFF) + (var10 >>> 8 & 0xFF) + (var10 & 0xFF)) / 765.0F;
               float var13;
               float var14;
               float var15;
               if (var5 < 0.003921569F) {
                  var13 = var2 * var12;
                  var14 = var3 * var12;
                  var15 = var4 * var12;
               } else if (var12 <= var5) {
                  float var16 = var12 / var5;
                  var13 = var2 * var16;
                  var14 = var3 * var16;
                  var15 = var4 * var16;
               } else {
                  float var17 = (var12 - var5) / Math.max(1.0F - var5, 1.0E-5F);
                  var13 = var2 + (1.0F - var2) * var17;
                  var14 = var3 + (1.0F - var3) * var17;
                  var15 = var4 + (1.0F - var4) * var17;
               }

               var0.method_61941(var9, var8, var11 << 24 | v1(var13) << 16 | v1(var14) << 8 | v1(var15));
            }
         }
      }
   }

   private static int v1(float var0) {
      return Math.clamp((long)Math.round(var0 * 255.0F), 0, 255);
   }
}
