package cc.syky.ui;

import cc.syky.config.configSupport2;
import com.mojang.blaze3d.systems.RenderSystem;
import net.minecraft.class_10799;
import net.minecraft.class_2960;
import net.minecraft.class_310;
import net.minecraft.class_332;
import net.minecraft.class_3532;
import net.minecraft.class_437;

public final class uiSupport3 {
   private static final uiSupport260 v1 = new uiSupport260("gui.loading-underlay");
   private static final class_2960 v2 = class_2960.method_60655("syky", "splash/mark");
   private static final class_2960 v3 = class_2960.method_60655("syky", "splash/wordmark");
   private static final class_2960 v4 = class_2960.method_60655("syky", "splash/pill");
   private static final String v5 = "cc/syky/ui/watermark/splash/mark.png";
   private static final String v6 = "cc/syky/ui/watermark/splash/wordmark.png";
   private static final String v7 = "cc/syky/ui/watermark/splash/pill.png";
   private static final int v8 = 320;
   private static final int v9 = 1216;
   private static final int v10 = 231;
   private static final int v11 = 64;
   private static final float v12 = 1.24764F;
   private static final float v13 = 3.89844F;
   private static final float v14 = 0.73918F;
   private static final float v15 = 5.14608F;
   private static final double v16 = 2.0;
   private static final double v18 = 3.0;
   private static final double v19 = 0.7;
   private static final int v17 = 8;
   private static final float v20 = 0.25F;

   private uiSupport3() {
   }

   public static void v1(class_310 var0) {
      configSupport2.v1(var0, v2);
      configSupport2.v1(var0, v3);
      configSupport2.v1(var0, v4);
   }

   public static boolean v1(class_310 var0, class_332 var1, int var2, int var3, float var4, boolean var5, float var6, float var7, float var8) {
      if (var1.method_51421() <= 0 || var1.method_51443() <= 0) {
         return true;
      } else if (configSupport2.v1(var0, v2, "cc/syky/ui/watermark/splash/mark.png")
         && configSupport2.v1(var0, v3, "cc/syky/ui/watermark/splash/wordmark.png")
         && configSupport2.v1(var0, v4, "cc/syky/ui/watermark/splash/pill.png")) {
         int var9 = var1.method_51421();
         int var10 = var1.method_51443();
         int var11 = uiSupport2.v4;
         float var12;
         if (var7 >= 1.0F) {
            class_437 var13 = var0.field_1755;
            if (var13 != null) {
               v1.v1(() -> var13.method_47413(var1, 0, 0, var4));
            } else {
               var0.field_1705.method_72738();
            }

            var12 = 1.0F - class_3532.method_15363(var7 - 1.0F, 0.0F, 1.0F);
            var1.method_71048();
            var1.method_25294(0, 0, var9, var10, v1(var11, var12));
         } else if (var5) {
            class_437 var29 = var0.field_1755;
            if (var29 != null && var6 < 1.0F) {
               v1.v1(() -> var29.method_47413(var1, var2, var3, var4));
            } else {
               var0.field_1705.method_72738();
            }

            var1.method_71048();
            var1.method_25294(0, 0, var9, var10, v1(var11, (float)class_3532.method_15350(var6, 0.15, 1.0)));
            var12 = class_3532.method_15363(var6, 0.0F, 1.0F);
         } else {
            RenderSystem.getDevice().createCommandEncoder().clearColorTexture(var0.method_1522().method_30277(), var11 | 0xFF000000);
            var12 = 1.0F;
         }

         double var30 = Math.min(var9 * 0.75, (double)var10) * 0.25;
         int var15 = (int)(var30 * 2.0);
         float var16 = var15 / 5.14608F;
         int var17 = var9 / 2 - var15 / 2;
         int var18 = var10 / 2;
         int var19 = v1(uiSupport2.v5, var12);
         int var20 = Math.round(var16);
         var1.method_25293(class_10799.field_56883, v2, var17, var18 - var20 / 2, 0.0F, 0.0F, var20, var20, 320, 320, 320, 320, var19);
         int var21 = Math.round(3.89844F * var16);
         int var22 = Math.round(0.73918F * var16);
         var1.method_25293(
            class_10799.field_56883, v3, var17 + Math.round(1.24764F * var16), var18 - var22 / 2, 0.0F, 0.0F, var21, var22, 1216, 231, 1216, 231, var19
         );
         if (var7 < 1.0F) {
            float var23 = 1.0F - class_3532.method_15363(var7, 0.0F, 1.0F);
            int var24 = (int)(var30 * 3.0);
            int var25 = var9 / 2 - var24 / 2;
            int var26 = (int)(var10 * 0.7) - 4;
            int var27 = uiSupport2.v5;
            v1(var1, var25, var26, var24, v1(var27, var23 * 0.25F));
            int var28 = Math.round(var24 * class_3532.method_15363(var8, 0.0F, 1.0F));
            if (var28 > 0) {
               v1(var1, var25, var26, Math.max(var28, 8), v1(var27, var23));
            }
         }

         return true;
      } else {
         return false;
      }
   }

   private static void v1(class_332 var0, int var1, int var2, int var3, int var4) {
      byte var5 = 4;
      byte var6 = 32;
      var0.method_25293(class_10799.field_56883, v4, var1, var2, 0.0F, 0.0F, var5, 8, var6, 64, 64, 64, var4);
      var0.method_25293(class_10799.field_56883, v4, var1 + var3 - var5, var2, var6, 0.0F, var5, 8, var6, 64, 64, 64, var4);
      if (var3 > 2 * var5) {
         var0.method_25294(var1 + var5, var2, var1 + var3 - var5, var2 + 8, var4);
      }
   }

   private static int v1(int var0, float var1) {
      int var2 = Math.round((var0 >>> 24 & 0xFF) * class_3532.method_15363(var1, 0.0F, 1.0F));
      return var0 & 16777215 | var2 << 24;
   }
}
