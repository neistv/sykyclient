package cc.syky.module.visual;

import cc.syky.render.renderSupport6;
import net.minecraft.class_1058;
import net.minecraft.class_12249;
import net.minecraft.class_2960;
import net.minecraft.class_4587;
import net.minecraft.class_4588;
import net.minecraft.class_4597;
import net.minecraft.class_7833;
import org.joml.Matrix4f;

public final class visualSupport47 {
   public static boolean v1;
   public static boolean v2;
   public static float v3 = 0.0F;
   public static final int v4 = -419461117;
   public static boolean v5;
   public static boolean v6;
   public static int v7 = -419461117;
   public static boolean v8 = true;
   public static boolean v9;
   private static float v10;
   private static long v11;
   private static final float v12 = 0.05F;
   private static final float v13 = 0.11F;

   private visualSupport47() {
   }

   public static float v1() {
      return v10;
   }

   public static void v2() {
      v10 = 0.0F;
      v11 = 0L;
   }

   public static void v1(boolean var0) {
      float var1 = var0 ? 1.0F : 0.0F;
      long var2 = System.nanoTime();
      float var4 = v11 == 0L ? 0.0F : (float)(var2 - v11) / 1.0E9F;
      v11 = var2;
      if (var4 <= 0.0F) {
         v10 = var1;
      } else {
         if (var4 > 0.1F) {
            var4 = 0.1F;
         }

         float var5 = var1 > v10 ? 0.05F : 0.11F;
         float var6 = 1.0F - (float)Math.exp(-var4 / var5);
         v10 = v10 + (var1 - v10) * var6;
         if (v10 < 0.001F) {
            v10 = 0.0F;
         } else if (v10 > 0.999F) {
            v10 = 1.0F;
         }
      }
   }

   public static void v1(class_4587 var0, class_4597 var1, class_1058 var2, float var3) {
      float var4 = (v7 >>> 24 & 0xFF) / 255.0F * var3;
      if (!(var4 <= 0.0F)) {
         boolean var5 = v5;
         float var6 = var5 ? (v7 >>> 16 & 0xFF) / 255.0F : 1.0F;
         float var7 = var5 ? (v7 >>> 8 & 0xFF) / 255.0F : 1.0F;
         float var8 = var5 ? (v7 & 0xFF) / 255.0F : 1.0F;
         class_2960 var9 = var2.method_45852();
         class_4588 var10 = var1.method_73477(var5 ? renderSupport6.v1(var9) : class_12249.method_75943(var9));
         float var11 = var2.method_4594();
         float var12 = var2.method_4577();
         float var13 = var2.method_4593();
         float var14 = var2.method_4575();
         float var15 = 0.5F;

         for (int var16 = 0; var16 < 2; var16++) {
            var0.method_22903();
            var0.method_46416(-(var16 * 2 - 1) * 0.24F, -0.3F - v3, 0.0F);
            var0.method_22907(class_7833.field_40716.rotationDegrees((var16 * 2 - 1) * 10.0F));
            Matrix4f var17 = var0.method_23760().method_23761();
            var10.method_22918(var17, -var15, -var15, -0.5F).method_22913(var12, var14).method_22915(var6, var7, var8, var4);
            var10.method_22918(var17, var15, -var15, -0.5F).method_22913(var11, var14).method_22915(var6, var7, var8, var4);
            var10.method_22918(var17, var15, var15, -0.5F).method_22913(var11, var13).method_22915(var6, var7, var8, var4);
            var10.method_22918(var17, -var15, var15, -0.5F).method_22913(var12, var13).method_22915(var6, var7, var8, var4);
            var0.method_22909();
         }
      }
   }
}
