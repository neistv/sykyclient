package cc.syky.cloud;

import cc.syky.account.accountSupport22;
import cc.syky.module.moduleSupport;
import cc.syky.module.visual.visualSupport13;
import cc.syky.module.visual.visualSupport51;
import cc.syky.module.visual.visualSupport9;
import cc.syky.render.renderSupport45;
import cc.syky.ui.uiSupport170;
import com.mojang.blaze3d.textures.GpuTextureView;
import net.minecraft.class_12076;
import net.minecraft.class_243;
import net.minecraft.class_310;
import net.minecraft.class_4184;
import net.minecraft.class_638;

public final class cloudSupport29 {
   private static final double v1 = 2048.0;
   private static final int v2 = 15;
   private static final double v3 = 3600.0;
   private static final moduleSupport v4 = new moduleSupport();
   private static final uiSupport170 v5 = new uiSupport170();
   private static boolean v6 = true;
   private static int v7 = 7907327;
   private static int v8;
   private static float v9;

   private cloudSupport29() {
   }

   public static void v1(class_12076 var0) {
      v7 = var0.field_63097;
      v8 = var0.field_63095;
      v9 = var0.field_63091;
   }

   public static void v1(class_4184 var0) {
      if (!cloudSupport69.v1()) {
         class_638 var1 = class_310.method_1551().field_1687;
         if (var1 != null) {
            if (v6) {
               renderSupport45.v2();
               v6 = false;
            }

            class_243 var2 = var0.method_71156();
            int var3 = (int)Math.floor(var2.field_1352);
            int var4 = (int)Math.floor(var2.field_1350);
            v4.v1(v5.v1(var1), var3 >> 4, var4 >> 4, System.nanoTime(), renderSupport45::v1);
            renderSupport45.v1(v1(var2, var1, false));
         }
      }
   }

   public static void v2(class_4184 var0) {
      if (!cloudSupport69.v1()) {
         class_638 var1 = class_310.method_1551().field_1687;
         if (var1 != null) {
            class_243 var2 = var0.method_71156();
            if (v4.v1((int)Math.floor(var2.field_1352) >> 4, (int)Math.floor(var2.field_1350) >> 4, 15)) {
               renderSupport45.v2(v1(var2, var1, true));
            }
         }
      }
   }

   public static void v3(class_4184 var0) {
      if (!cloudSupport69.v1()) {
         class_638 var1 = class_310.method_1551().field_1687;
         GpuTextureView var2 = visualSupport9.v13();
         if (var1 != null && var2 != null) {
            renderSupport45.v1(v1(var0.method_71156(), var1, false), var2);
         }
      }
   }

   private static cloudRecord4 v1(class_243 var0, class_638 var1, boolean var2) {
      int var3 = (int)Math.floor(var0.field_1352);
      int var4 = (int)Math.floor(var0.field_1350);
      visualSupport13 var5 = visualSupport51.v75;
      return new cloudRecord4(
         accountSupport22.v5(),
         accountSupport22.v6(),
         v1(var0.field_1352, 2048.0),
         v1(var0.field_1350, 2048.0),
         (float)(var0.field_1351 - var1.method_31607()),
         v1(System.nanoTime() / 1.0E9, 3600.0),
         Math.floorMod(var3, 512),
         Math.floorMod(var4, 512),
         (float)(var0.field_1352 - var3),
         (float)(var0.field_1350 - var4),
         visualSupport51.v61,
         visualSupport51.v66,
         visualSupport51.v68,
         visualSupport51.v63,
         visualSupport51.v64,
         visualSupport51.v52,
         visualSupport51.v73,
         var5.v3(),
         var5.v4(),
         var5.v2(),
         accountSupport22.v2().m11(),
         v7,
         v8,
         (float)(-Math.sin(v9)),
         (float)Math.cos(v9),
         0.0F,
         var5.v1(),
         var2
      );
   }

   public static void v1() {
      v4.v1();
      v6 = true;
   }

   private static float v1(double var0, double var2) {
      double var4 = var0 % var2;
      return (float)(var4 < 0.0 ? var4 + var2 : var4);
   }
}
