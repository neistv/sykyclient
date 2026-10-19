package cc.syky.ui;

import cc.syky.mixin.accessor.HandledScreenAccessor;
import net.minecraft.class_2960;
import net.minecraft.class_310;
import net.minecraft.class_332;
import net.minecraft.class_437;
import net.minecraft.class_481;
import net.minecraft.class_490;

public final class uiSupport4 {
   private static final class_2960 v1 = class_2960.method_60655("syky", "textures/ui/watermark/logo.png");
   private static final String v2 = "syky client";
   private static final String v3 = "syky_sans_strong";
   private static final float v4 = 26.0F;
   private static final float v5 = 32.0F;
   private static final float v6 = 20.0F;
   private static final float v7 = 24.0F;
   private static final float v8 = 32.0F;
   private static final float v9 = 2.0F;
   private static final float v10 = 4.0F;
   private static final float v11 = 0.678223F;
   private static final float v12 = 0.0288F;

   private uiSupport4() {
   }

   public static void v1(class_332 var0) {
      class_310 var1 = class_310.method_1551();
      class_437 var2 = var1.field_1755;
      if (var2 instanceof class_490 || var2 instanceof class_481) {
         float var3 = ((HandledScreenAccessor)var2).syky$panelTop();
         if (var2 instanceof class_481) {
            var3 -= 32.0F;
         }

         uiSupport169.v1(var0);
         boolean var4 = false;
         int var5 = 0;
         int var6 = 0;
         int var7 = var2.field_22789;
         int var8 = var2.field_22790;

         try {
            var4 = uiSupport169.v18();
            if (!var4) {
               return;
            }

            float var9 = uiSupport169.v2("syky_sans_strong", "syky client", 20.0F);
            if (!(var9 <= 0.0F)) {
               float var10 = var9 - 0.576F;
               float var11 = Math.round(var2.field_22789 / 2.0F - (var10 - 32.0F) / 2.0F - 2.0F);
               float var12 = Math.round(Math.max(4.0F, var3 - 24.0F - 26.0F));
               int var13 = uiSupport2.v2;
               uiSupport169.v1(v1, var11 - 32.0F, var12, 26.0F, 26.0F, var13, uiRecord7.ZERO);
               float var14 = Math.round(var12 + 13.0F - 13.564461F);
               uiSupport169.v1("syky_sans_strong", "syky client", var11, var14, 20.0F, var13);
               var5 = Math.max(0, (int)Math.floor(var11 - 32.0F - 20.0F));
               var6 = Math.max(0, (int)Math.floor(Math.min(var12, var14) - 20.0F));
               var7 = Math.min(var2.field_22789, (int)Math.ceil(var11 + var9 + 20.0F));
               var8 = Math.min(var2.field_22790, (int)Math.ceil(Math.max(var12 + 26.0F, var14 + 20.0F) + 20.0F));
               return;
            }
         } finally {
            if (var4) {
               uiSupport169.v1(var0, var2.field_22789, var2.field_22790, var5, var6, var7, var8);
            }

            uiSupport169.v15();
         }
      }
   }
}
