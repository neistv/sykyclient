package cc.syky.ui;

import cc.syky.account.accountSupport10;
import cc.syky.cloud.BlurDataSupport;
import cc.syky.cloud.InvalidMSDFSupport;
import cc.syky.cloud.cloudRecord5;
import cc.syky.cloud.cloudSupport26;
import cc.syky.cloud.cloudSupport27;
import cc.syky.hud.hudSupport65;
import cc.syky.hud.hudSupport66;
import cc.syky.hud.hudSupport69;
import cc.syky.hud.hudSupport70;
import cc.syky.render.renderSupport21;
import cc.syky.render.renderSupport22;
import cc.syky.render.renderSupport30;
import cc.syky.render.renderSupport33;
import cc.syky.render.renderSupport44;
import cc.syky.render.renderSupport46;
import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.textures.FilterMode;
import com.mojang.blaze3d.textures.GpuTextureView;
import java.util.Arrays;
import net.minecraft.class_1041;
import net.minecraft.class_10799;
import net.minecraft.class_11231;
import net.minecraft.class_11241;
import net.minecraft.class_12137;
import net.minecraft.class_2960;
import net.minecraft.class_310;
import net.minecraft.class_332;
import org.jetbrains.annotations.Nullable;
import org.joml.Matrix3x2f;

public final class uiSupport169 {
   public static final float v1 = 0.600625F;
   public static final float v2 = 0.96F;
   @Nullable
   private static renderSupport46 v4;
   @Nullable
   private static class_332 v5;
   private static int v6;
   private static final uiSupport157 v7 = new uiSupport157();
   public static boolean v3;

   @Nullable
   public static renderSupport46 v1() {
      return v4;
   }

   private uiSupport169() {
   }

   public static float v2() {
      renderSupport46 var0 = v4;
      class_310 var1 = var0 == null ? null : var0.v2().v1();
      class_1041 var2 = var1 == null ? null : var1.method_22683();
      return var2 == null ? 1.0F : 1.0F / var2.method_4495();
   }

   public static float v1(float var0) {
      float var1 = 1.0F / v2();
      return Math.round(var0 * var1) / var1;
   }

   public static void v3() {
      v1(1, 6.0F * hudSupport70.v2());
   }

   public static void v1(int var0, float var1) {
      renderSupport46 var2 = v4;
      if (var2 != null) {
         var2.v7();
         var2.v14().v1(var2.v25(), var2.v22(), var0, var1);
      }
   }

   public static void v1(float var0, float var1, float var2, float var3) {
      renderSupport46 var4 = v4;
      if (var4 != null) {
         var4.v7();
         var4.v14().v1(var4.v25(), var4.v22(), 1, 6.0F * hudSupport70.v2(), var0, var1, var2, var3);
      }
   }

   public static void v4() {
      renderSupport46 var0 = v4;
      if (var0 != null) {
         var0.v7();
         var0.v14().v7();
      }
   }

   public static boolean v5() {
      renderSupport46 var0 = v4;
      if (var0 == null) {
         return false;
      } else if (var0.v22() == null) {
         return false;
      } else {
         var0.v7();
         return var0.v22().v7();
      }
   }

   public static boolean v2(float var0, float var1, float var2, float var3) {
      renderSupport46 var4 = v4;
      if (var4 != null && var4.v22() != null) {
         var4.v7();
         class_310 var5 = var4.v2().v1();
         class_1041 var6 = var5 == null ? null : var5.method_22683();
         float var7 = 0.0F;
         float var8 = 0.0F;
         if (var6 != null && renderSupport33.v2() == 0.0F && renderSupport33.v3() == 0.0F) {
            float var9 = var6.method_4495();
            if (var9 > 0.0F) {
               var7 = accountSupport10.v1(var0, var2, var6.method_4489() / var9, var9);
               var8 = accountSupport10.v1(var1, var3, var6.method_4506() / var9, var9);
            }
         }

         if (!var4.v22().v1(var7, var8)) {
            return false;
         } else {
            if (var7 != 0.0F || var8 != 0.0F) {
               var4.v14().v1(var7, var8);
            }

            v1(var0, var1, var2, var3, var7 != 0.0F || var8 != 0.0F);
            return true;
         }
      } else {
         return false;
      }
   }

   public static void v1(float var0, float var1, float var2, float var3, float var4, float var5, float var6, float var7, float var8, float var9) {
      v1(var0, var1, var2, var3, var4, var5, 0.0F, 0.0F, 1.0F, var6, var7, var8, var9);
   }

   public static void v1(
      float var0,
      float var1,
      float var2,
      float var3,
      float var4,
      float var5,
      float var6,
      float var7,
      float var8,
      float var9,
      float var10,
      float var11,
      float var12
   ) {
      renderSupport46 var13 = v4;
      if (var13 != null && var13.v22() != null) {
         var13.v7();
         v17();
         boolean var14 = var13.v22().v8() != 0.0F || var13.v22().v9() != 0.0F;
         var13.v22().v10();
         if (var14) {
            var13.v14().v12();
         }

         v6(var9, var10, var11, var12);

         try {
            v1(var0, var1, var2, var3, var4, var5, var6, var7, var8);
         } finally {
            v17();
         }
      }
   }

   public static void v2(float var0) {
      v1(var0, 0.0F, 0.0F, 1.0F, 1.0F, 0.0F);
   }

   public static void v1(float var0, float var1, float var2, float var3, float var4, float var5) {
      v1(var0, var1, var2, var3, var4, var5, 0.0F, 0.0F, 1.0F);
   }

   public static void v1(float var0, float var1, float var2, float var3, float var4, float var5, float var6, float var7, float var8) {
      v1(var0, var1, var2, var3, var4, var5, var6, var7, var8, 0.0F, 0.0F, 0.0F, 0.0F, uiRecord7.ZERO, 0.0F);
   }

   public static void v1(
      float var0,
      float var1,
      float var2,
      float var3,
      float var4,
      float var5,
      float var6,
      float var7,
      float var8,
      float var9,
      float var10,
      float var11,
      float var12,
      uiRecord7 var13,
      float var14
   ) {
      v1(var0, var1, var2, var3, var4, var5, var6, var7, var8, var9, var10, var11, var12, var13, var14, 0.0F, 0.0F, 0.0F);
   }

   public static void v1(
      float var0,
      float var1,
      float var2,
      float var3,
      float var4,
      float var5,
      float var6,
      float var7,
      float var8,
      float var9,
      float var10,
      float var11,
      float var12,
      uiRecord7 var13,
      float var14,
      float var15,
      float var16,
      float var17
   ) {
      renderSupport46 var18 = v4;
      if (var18 != null) {
         if (var18.v22() != null) {
            if (!hudSupport70.v1()) {
               var5 = 0.0F;
            }

            var18.v7();
            class_310 var19 = var18.v2().v1();
            class_1041 var20 = var19 == null ? null : var19.method_22683();
            if (var20 == null) {
               var18.v22().v1(var0);
            } else {
               float var21 = var20.method_4495();
               float var22 = var20.method_4506();
               float var23 = (var1 + renderSupport33.v2()) * var21;
               float var24 = var22 - (var2 + renderSupport33.v3()) * var21;
               boolean var25 = var6 != var7;
               float var26 = var25 ? var22 - (var6 + renderSupport33.v3()) * var21 : 0.0F;
               float var27 = var25 ? var22 - (var7 + renderSupport33.v3()) * var21 : 0.0F;
               boolean var28 = var11 > 0.0F && var12 > 0.0F;
               float var29 = var28 ? var11 * 0.5F * var21 : 0.0F;
               float var30 = var28 ? var12 * 0.5F * var21 : 0.0F;
               float var31 = var28 ? (var9 + var11 * 0.5F + renderSupport33.v2()) * var21 : 0.0F;
               float var32 = var28 ? var22 - (var10 + var12 * 0.5F + renderSupport33.v3()) * var21 : 0.0F;
               boolean var33 = var17 > 0.0F;
               float var34 = var33 ? (var15 + renderSupport33.v2()) * var21 : 0.0F;
               float var35 = var33 ? var22 - (var16 + renderSupport33.v3()) * var21 : 0.0F;
               var18.v22()
                  .v1(
                     var0,
                     var23,
                     var24,
                     var3,
                     var4,
                     var5 * var21,
                     var26,
                     var27,
                     var8,
                     var31,
                     var32,
                     var29,
                     var30,
                     var13.v1() * var21,
                     var13.v2() * var21,
                     var13.v3() * var21,
                     var13.v4() * var21,
                     var14 * var21,
                     var34,
                     var35,
                     var33 ? var17 * var21 : 0.0F
                  );
            }
         }
      }
   }

   public static void v1(
      float var0,
      float var1,
      float var2,
      float var3,
      uiRecord7 var4,
      float var5,
      float var6,
      float var7,
      float var8,
      float var9,
      float var10,
      float var11,
      float var12
   ) {
      v2(null, var0, var1, var2, var3, var4, var5, var6, var7, var8, var9, var10, var11, var12);
   }

   public static boolean v1(uiSupport158 var0) {
      return v1(var0, false);
   }

   public static boolean v1(uiSupport158 var0, boolean var1) {
      renderSupport46 var2 = v4;
      if (var2 != null && var2.v22() != null) {
         var2.v7();
         return var2.v22().v1(var0, var1);
      } else {
         var0.v1();
         return false;
      }
   }

   public static boolean v1(
      uiSupport158 var0,
      float var1,
      float var2,
      float var3,
      float var4,
      uiRecord7 var5,
      float var6,
      float var7,
      float var8,
      float var9,
      float var10,
      float var11,
      float var12,
      float var13
   ) {
      return v2(var0, var1, var2, var3, var4, var5, var6, var7, var8, var9, var10, var11, var12, var13);
   }

   private static boolean v2(
      @Nullable uiSupport158 var0,
      float var1,
      float var2,
      float var3,
      float var4,
      uiRecord7 var5,
      float var6,
      float var7,
      float var8,
      float var9,
      float var10,
      float var11,
      float var12,
      float var13
   ) {
      renderSupport46 var14 = v4;
      if (var14 != null && var14.v22() != null) {
         if (!hudSupport70.v1()) {
            var8 = 0.0F;
         }

         renderSupport44 var15 = var14.v5();
         if (var0 != null || var15 == null || !var14.v22().v1(var15)) {
            var14.v7();
         }

         class_310 var16 = var14.v2().v1();
         class_1041 var17 = var16 == null ? null : var16.method_22683();
         if (var17 != null) {
            float var18 = var17.method_4495();
            float var19 = var17.method_4506();
            float var20 = (var1 + var3 / 2.0F + renderSupport33.v2()) * var18;
            float var21 = var19 - (var2 + var4 / 2.0F + renderSupport33.v3()) * var18;
            uiSupport157 var22 = v7;
            var22.v1 = var8 * var18;
            var22.v2 = var20;
            var22.v3 = var21;
            var22.v4 = var3 / 2.0F * var18;
            var22.v5 = var4 / 2.0F * var18;
            var22.v6 = var5.v1() * var18;
            var22.v7 = var5.v2() * var18;
            var22.v8 = var5.v3() * var18;
            var22.v9 = var5.v4() * var18;
            var22.v10 = var19 - (var7 + renderSupport33.v3()) * var18;
            var22.v11 = var19 - (var6 + renderSupport33.v3()) * var18;
            var22.v12 = var9;
            var22.v13 = var19 - (var10 + renderSupport33.v3()) * var18;
            var22.v14 = var19 - (var11 + renderSupport33.v3()) * var18;
            var22.v15 = var19 - (var12 + renderSupport33.v3()) * var18;
            var22.v16 = var13;
            if (var0 != null) {
               return var14.v22().v1(var0, 1.0F, var22);
            } else {
               var14.v22().v1(1.0F, var22);
               return true;
            }
         } else if (var0 == null) {
            var14.v22().v1(1.0F);
            return true;
         } else {
            return false;
         }
      } else {
         return false;
      }
   }

   public static boolean v1(float var0, float var1, float var2, float var3, float var4, float var5, float var6, float var7, float[] var8) {
      renderSupport46 var9 = v4;
      if (var9 != null && var9.v25() != null) {
         var9.v7();
         return var9.v25().v1(var9.v14(), var0, var1, var2, var3, var4, var5, var6, var7, var8);
      } else {
         return false;
      }
   }

   public static void v6() {
      renderSupport46 var0 = v4;
      if (var0 != null && var0.v25() != null) {
         var0.v7();
         var0.v25().v1();
      }
   }

   public static float v3(float var0) {
      return var0 <= 0.0F ? 0.0F : 3.0F * hudSupport66.v4() * var0 + 1.0F;
   }

   public static void v1(renderSupport46 var0) {
      v4 = var0;
   }

   public static void v7() {
      v21();
      v4 = null;
      v5 = null;
      renderSupport30.v5();
      cloudSupport27.v3();
      renderSupport33.v1();
   }

   private static void v2(@Nullable renderSupport46 var0) {
      if (var0 != null) {
         if (var0.v22() != null) {
            var0.v22().v14();
         }

         if (var0.v25() != null) {
            var0.v25().v2();
         }
      }
   }

   @Nullable
   private static class_310 v20() {
      renderSupport46 var0 = v4;
      return var0 == null ? null : var0.v2().v1();
   }

   public static void v1(@Nullable class_332 var0) {
      renderSupport46 var1 = v4;
      if (var1 != null) {
         var1.v7();
      }

      v5 = var0;
      v6 = 0;
      v2(var1);
      renderSupport30.v5();
      cloudSupport27.v3();
   }

   public static void v2(@Nullable class_332 var0) {
      v3(var0);
      renderSupport46 var1 = v4;
      if (var1 != null) {
         var1.v14().v2();
      }
   }

   public static void v3(@Nullable class_332 var0) {
      renderSupport46 var1 = v4;
      if (var1 != null) {
         var1.v7();
         var1.v6().v1();
         var1.v14().v3().v3();
      }

      v5 = var0;
      v6 = 0;
      v2(var1);
      renderSupport30.v5();
      cloudSupport27.v3();
      if (var1 != null) {
         var1.v14().v1();
      }
   }

   public static void v1(cloudSupport26.Part1 var0, boolean var1, boolean var2) {
      renderSupport46 var3 = v4;
      if (var3 != null) {
         var3.v7();
         var3.v14().v1(var0, var1, var2);
      }
   }

   public static void v8() {
      renderSupport46 var0 = v4;
      if (var0 != null) {
         var0.v14().v5();
      }
   }

   public static void v9() {
      v2(null);
      renderSupport46 var0 = v4;
      if (var0 != null) {
         var0.v14().v4();
      }
   }

   public static void v3(float var0, float var1, float var2, float var3) {
      v3(null);
      renderSupport46 var4 = v4;
      if (var4 != null) {
         var4.v14().v1(var0, var1, var2, var3);
         var4.v14().v4();
      }
   }

   public static void v10() {
      v11();
   }

   public static void v11() {
      renderSupport46 var0 = v4;
      if (var0 != null) {
         var0.v14().v6();
      }
   }

   public static int v1(String var0) {
      renderSupport46 var1 = v4;
      return var1 == null ? 0 : var1.v1().v1(var0);
   }

   public static void v1(int var0) {
      renderSupport46 var1 = v4;
      if (var1 != null) {
         var1.v1().v1(var0);
      }
   }

   public static void v12() {
      renderSupport46 var0 = v4;
      if (var0 != null) {
         var0.v7();
      }
   }

   public static long v13() {
      renderSupport46 var0 = v4;
      renderSupport44 var1 = var0 == null ? null : var0.v5();
      return var1 == null ? 0L : var1.v4();
   }

   public static long v14() {
      renderSupport46 var0 = v4;
      renderSupport44 var1 = var0 == null ? null : var0.v5();
      return var1 == null ? 0L : var1.v3();
   }

   public static void v15() {
      v21();
      renderSupport46 var0 = v4;
      if (var0 != null) {
         var0.v7();
      }

      v5 = null;
      v2(var0);
      renderSupport30.v5();
      cloudSupport27.v3();
   }

   public static boolean v16() {
      renderSupport46 var0 = v4;
      return var0 != null && v1(var0.v30());
   }

   public static boolean v18() {
      renderSupport46 var0 = v4;
      return var0 != null && v1(var0.v32());
   }

   private static boolean v1(@Nullable renderSupport22 var0) {
      renderSupport46 var1 = v4;
      if (var1 != null && var0 != null) {
         var1.v7();
         return var0.v1();
      } else {
         return false;
      }
   }

   public static void v1(class_332 var0, int var1, int var2) {
      renderSupport46 var3 = v4;
      if (var3 != null) {
         v1(var3.v30(), var0, var1, var2, 0, 0, var1, var2);
      }
   }

   public static void v1(class_332 var0, int var1, int var2, int var3, int var4, int var5, int var6) {
      renderSupport46 var7 = v4;
      if (var7 != null) {
         v1(var7.v32(), var0, var1, var2, var3, var4, var5, var6);
      }
   }

   private static void v1(@Nullable renderSupport22 var0, class_332 var1, int var2, int var3, int var4, int var5, int var6, int var7) {
      renderSupport46 var8 = v4;
      if (var8 != null && var0 != null) {
         var8.v7();
         GpuTextureView var9 = var0.v4();
         if (var9 != null && var1 != null) {
            class_12137 var10 = RenderSystem.getSamplerCache().method_76520(FilterMode.NEAREST, false);
            float var11 = 1.0F;
            float var12 = 1.0F;
            float var13 = 0.0F;
            int var14 = 1;
            class_310 var15 = v20();
            class_1041 var16 = var15 == null ? null : var15.method_22683();
            if (var16 != null) {
               int var17 = var16.method_4489();
               int var18 = var16.method_4506();
               if (var16.method_4495() > 0 && var17 > 0 && var18 > 0) {
                  var14 = var16.method_4495();
                  var12 = (float)var2 * var14 / var17;
                  var13 = 1.0F - (float)var3 * var14 / var18;
               }
            }

            if (v3) {
               var4 = 0;
               var5 = 0;
               var6 = var2;
               var7 = var3;
            }

            if (var6 > var4 && var7 > var5 && var2 > 0 && var3 > 0) {
               float var21 = var12 * var4 / var2;
               float var22 = var12 * var6 / var2;
               float var19 = var11 + (var13 - var11) * var5 / var3;
               float var20 = var11 + (var13 - var11) * var7 / var3;
               var0.v1((long)(var6 - var4) * (var7 - var5) * var14 * var14);
               var1.field_59826
                  .method_70919(
                     new class_11241(
                        class_10799.field_59968,
                        class_11231.method_70900(var9, var10),
                        new Matrix3x2f(var1.method_51448()),
                        var4,
                        var5,
                        var6,
                        var7,
                        var21,
                        var22,
                        var19,
                        var20,
                        -1,
                        null
                     )
                  );
            }
         }
      }
   }

   public static void v1(float var0, float var1, float var2, float var3, int var4) {
      renderSupport46 var5 = v4;
      if (var5 != null) {
         var5.v8().v1(var0, var1, var2, var3, var4, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
      }
   }

   public static void v1(float var0, float var1, float var2, float var3, int var4, float var5) {
      renderSupport46 var6 = v4;
      if (var6 != null) {
         var6.v8().v1(var0, var1, var2, var3, var4, var5, var5, var5, var5, 0.0F);
      }
   }

   public static void v1(float var0, float var1, float var2, float var3, int var4, uiRecord7 var5) {
      renderSupport46 var6 = v4;
      if (var6 != null) {
         var6.v8().v1(var0, var1, var2, var3, var4, var5.v1(), var5.v2(), var5.v3(), var5.v4(), 0.0F);
      }
   }

   public static void v1(float var0, float var1, float var2, float var3, int[] var4, uiRecord7 var5) {
      renderSupport46 var6 = v4;
      if (var6 != null) {
         var6.v8().v1(var0, var1, var2, var3, var4, var5.v1(), var5.v2(), var5.v3(), var5.v4());
      }
   }

   public static void v1(float var0, float var1, float var2, float var3, int[] var4, uiRecord7 var5, float var6) {
      renderSupport46 var7 = v4;
      if (var7 != null) {
         var7.v8().v1(var0, var1, var2, var3, var4, var5.v1(), var5.v2(), var5.v3(), var5.v4(), var6);
      }
   }

   public static void v2(float var0, float var1, float var2, float var3, int var4, float var5) {
      v1(var0, var1, var2, var3, var4, var5, uiRecord7.ZERO);
   }

   public static void v1(float var0, float var1, float var2, float var3, int var4, float var5, float var6) {
      renderSupport46 var7 = v4;
      if (var7 != null) {
         var7.v10().v1(var0, var1, var2, var3, var4, var5, var6, var6, var6, var6, 1.0F);
      }
   }

   public static void v1(float var0, float var1, float var2, float var3, int var4, float var5, uiRecord7 var6) {
      v1(var0, var1, var2, var3, var4, var5, var6, 1.0F);
   }

   public static void v1(float var0, float var1, float var2, float var3, int var4, float var5, uiRecord7 var6, float var7) {
      renderSupport46 var8 = v4;
      if (var8 != null) {
         var8.v10().v1(var0, var1, var2, var3, var4, var5, var6.v1(), var6.v2(), var6.v3(), var6.v4(), var7);
      }
   }

   public static void v1(float var0, float var1, float var2, float var3, int var4, int var5, float var6, uiRecord7 var7) {
      v1(var0, var1, var2, var3, var4, var5, var6, 1.0F, var7);
   }

   public static void v1(float var0, float var1, float var2, float var3, int var4, int var5, float var6, float var7, uiRecord7 var8) {
      renderSupport46 var9 = v4;
      if (var9 != null) {
         var9.v9().v1(var0, var1, var2, var3, var4, var5, var6, var7, var8.v1(), var8.v2(), var8.v3(), var8.v4());
      }
   }

   @Nullable
   private static GpuTextureView v3(renderSupport46 var0) {
      BlurDataSupport var1 = var0.v14();
      return var1.v8() ? var1.v9() : null;
   }

   public static void v2(float var0, float var1, float var2, float var3, int var4, int var5, float var6, uiRecord7 var7) {
      v2(var0, var1, var2, var3, var4, var5, var6, 1.0F, var7);
   }

   public static void v2(float var0, float var1, float var2, float var3, int var4, int var5, float var6, float var7, uiRecord7 var8) {
      renderSupport46 var9 = v4;
      if (var9 != null) {
         GpuTextureView var10 = v3(var9);
         if (var10 == null) {
            var9.v9().v1(var0, var1, var2, var3, var4, var5, var6, var7, var8.v1(), var8.v2(), var8.v3(), var8.v4());
         } else {
            var9.v9().v1(var0, var1, var2, var3, var4, var5, var6, var7, var8.v1(), var8.v2(), var8.v3(), var8.v4(), var10);
         }
      }
   }

   public static void v3(float var0, float var1, float var2, float var3, int var4, float var5) {
      renderSupport46 var6 = v4;
      if (var6 != null) {
         var6.v11().v1(var0, var1, var2, var3, var4, var5);
      }
   }

   public static void v1(float var0, float var1, float var2, float var3, float var4, int var5, float var6, float var7, float var8) {
      renderSupport46 var9 = v4;
      if (var9 != null) {
         var9.v12().v1(var0, var1, var2, var3, var4, var5, var6, var7, var8);
      }
   }

   public static void v1(hudSupport65 var0, int var1) {
      renderSupport46 var2 = v4;
      if (var2 != null) {
         var2.v13().v1(var0, var1);
      }
   }

   public static void v2(float var0, float var1, float var2, float var3, float var4, float var5) {
      v1(var0, var1, var2, var3, var4, var5, 1.0F, 0.0F);
   }

   public static void v1(float var0, float var1, float var2, float var3, float var4, float var5, float var6, float var7) {
      if (hudSupport66.v1() && !(var6 <= 0.0F)) {
         renderSupport46 var8 = v4;
         if (var8 != null) {
            int var9 = hudSupport66.v5();
            if (var6 < 1.0F) {
               var9 = uiSupport155.v1(var9, var6);
            }

            var8.v12().v1(var0, var1, var2, var3, var4, var9, hudSupport66.v4() * var5, 0.0F, 0.0F, var7);
         }
      }
   }

   public static void v4(float var0, float var1, float var2, float var3) {
      v1(var0, var1, var2, var3, uiRecord7.ZERO, 0);
   }

   public static void v1(float var0, float var1, float var2, float var3, uiRecord7 var4, int var5, float var6, float var7) {
      renderSupport46 var8 = v4;
      if (var8 != null && hudSupport70.v1()) {
         var8.v14().v5();
         var8.v7();
         var8.v14().v1(var0, var1, var2, var3, var4.v1(), var4.v2(), var4.v3(), var4.v4(), var5, var6, 0.0F, Math.max(0.0F, Math.min(1.0F, var7)), false);
      }
   }

   public static void v1(float var0, float var1, float var2, float var3, uiRecord7 var4, int var5, boolean var6) {
      renderSupport46 var7 = v4;
      if (var6 && var7 != null && hudSupport70.v1()) {
         var7.v14().v5();
         var7.v7();
         var7.v14().v1(var0, var1, var2, var3, var4.v1(), var4.v2(), var4.v3(), var4.v4(), var5, 1.0F, 0.0F, 0.0F, true);
      } else {
         v1(var0, var1, var2, var3, var4, var5);
      }
   }

   public static void v1(float var0, float var1, float var2, float var3, uiRecord7 var4) {
      v1(var0, var1, var2, var3, var4, 0);
   }

   public static void v1(float var0, float var1, float var2, float var3, uiRecord7 var4, int var5) {
      renderSupport46 var6 = v4;
      if (var6 != null) {
         if (!hudSupport70.v1()) {
            v1(var0, var1, var2, var3, var5, var4);
         } else {
            var6.v14().v5();
            var6.v7();
            var6.v14().v1(var0, var1, var2, var3, var4.v1(), var4.v2(), var4.v3(), var4.v4(), var5);
         }
      }
   }

   public static void v2(float var0, float var1, float var2, float var3, uiRecord7 var4, int var5) {
      v2(var0, var1, var2, var3, var4, var5, 1.0F, 0.0F);
   }

   public static void v2(float var0, float var1, float var2, float var3, uiRecord7 var4, int var5, float var6, float var7) {
      v1(var0, var1, var2, var3, var4, var5, var6, var7, 0.0F);
   }

   public static void v1(float var0, float var1, float var2, float var3, uiRecord7 var4, int var5, float var6, float var7, float var8) {
      v1(var0, var1, var2, var3, var4, var5, var6, var7, var8, false);
   }

   public static void v1(float var0, float var1, float var2, float var3, uiRecord7 var4, int var5, float var6, float var7, float var8, boolean var9) {
      renderSupport46 var10 = v4;
      if (var10 != null) {
         if (!hudSupport70.v1()) {
            if (var6 < 1.0F) {
               var5 = uiSupport155.v1(var5, var6);
            }

            v1(var0, var1, var2, var3, var5, var4);
         } else {
            if (!var10.v14().v18()) {
               var10.v7();
            }

            var10.v14().v2(var0, var1, var2, var3, var4.v1(), var4.v2(), var4.v3(), var4.v4(), var5, var6, var7, Math.max(0.0F, Math.min(1.0F, var8)), var9);
         }
      }
   }

   public static void v5(float var0, float var1, float var2, float var3) {
      v2(var0, var1, var2, var3, uiRecord7.ZERO, 0);
   }

   public static void v2(float var0, float var1, float var2, float var3, uiRecord7 var4) {
      v2(var0, var1, var2, var3, var4, 0);
   }

   public static void v19() {
      renderSupport46 var0 = v4;
      if (var0 != null && var0.v14().v19()) {
         var0.v14().v5();
         var0.v7();
         var0.v14().v17();
      }
   }

   public static void v1(class_2960 var0, float var1, float var2, float var3, float var4) {
      v1(var0, var1, var2, var3, var4, -1, uiRecord7.ZERO);
   }

   public static void v1(class_2960 var0, float var1, float var2, float var3, float var4, uiRecord7 var5) {
      v1(var0, var1, var2, var3, var4, -1, var5);
   }

   public static void v1(class_2960 var0, float var1, float var2, float var3, float var4, int var5, uiRecord7 var6) {
      v1(var0, var1, var2, var3, var4, 0.0F, 0.0F, 1.0F, 1.0F, var5, var6);
   }

   public static void v1(
      class_2960 var0, float var1, float var2, float var3, float var4, float var5, float var6, float var7, float var8, int var9, uiRecord7 var10
   ) {
      renderSupport46 var11 = v4;
      if (var11 != null) {
         var11.v27().v1(var0, var1, var2, var3, var4, var5, var6, var7, var8, var9, var10.v1(), var10.v2(), var10.v3(), var10.v4());
      }
   }

   @Nullable
   public static GpuTextureView v1(String var0, int var1, int var2, hudSupport69.Part1 var3) {
      return v1(var0, var1, var2, true, var3);
   }

   @Nullable
   public static GpuTextureView v1(String var0, int var1, int var2, boolean var3, hudSupport69.Part1 var4) {
      renderSupport46 var5 = v4;
      return var5 != null && var5.v29() != null ? var5.v29().v1(var0, var1, var2, var3, var4) : null;
   }

   public static boolean v1(String var0, int var1, int var2) {
      renderSupport46 var3 = v4;
      return var3 != null && var3.v29() != null && var3.v29().v1(var0, var1, var2);
   }

   @Nullable
   public static GpuTextureView v1(String var0, int var1, int var2, int[] var3, int var4, hudSupport69.Part1 var5) {
      renderSupport46 var6 = v4;
      return var6 != null && var6.v29() != null ? var6.v29().v1(var0, var1, var2, var3, var4, var5) : null;
   }

   public static void v1(GpuTextureView var0, float var1, float var2, float var3, float var4, float var5, float var6, float var7, float var8) {
      renderSupport46 var9 = v4;
      if (var9 != null) {
         var9.v27().v1(var0, var1, var2, var3, var4, var5, var6, var7, var8);
      }
   }

   public static void v1(GpuTextureView var0, float var1, float var2, float var3, float var4, float var5, float var6, float var7, float var8, int var9) {
      renderSupport46 var10 = v4;
      if (var10 != null) {
         var10.v27().v1(var0, var1, var2, var3, var4, var5, var6, var7, var8, var9);
      }
   }

   public static boolean v1(
      @Nullable GpuTextureView var0,
      float var1,
      float var2,
      float var3,
      float var4,
      float var5,
      float var6,
      float var7,
      float var8,
      float var9,
      float var10,
      float var11,
      float var12,
      float var13,
      float var14
   ) {
      renderSupport46 var15 = v4;
      if (var15 != null && var0 != null) {
         renderSupport21 var16 = var15.v24();
         if (var16 != null && var11 > 0.0F && var12 > 0.0F && var7 > 0.0F && var8 > 0.0F) {
            if (!hudSupport70.v1()) {
               var14 = 0.0F;
            }

            class_310 var17 = var15.v2().v1();
            class_1041 var18 = var17 == null ? null : var17.method_22683();
            if (var18 == null) {
               return false;
            } else {
               float var19 = 2.0F * var14 + 1.0F;
               float var20 = var9 + (var5 - var9) * var11 - var19;
               float var21 = var9 + (var5 + var7 - var9) * var11 + var19;
               float var22 = var10 + (var6 - var10) * var12 - var19;
               float var23 = var10 + (var6 + var8 - var10) * var12 + var19;
               var15.v7();
               float var24 = var18.method_4495();
               float var25 = renderSupport33.v2();
               float var26 = renderSupport33.v3();
               float var27 = var18.method_4506();
               v6(var20, var22, var21 - var20, var23 - var22);

               boolean var28;
               try {
                  var28 = var16.v1(
                     var17,
                     var0,
                     (var1 + var25) * var24,
                     var27 - (var2 + var4 + var26) * var24,
                     var3 * var24,
                     var4 * var24,
                     (var5 + var25) * var24,
                     var27 - (var6 + var8 + var26) * var24,
                     (var5 + var7 + var25) * var24,
                     var27 - (var6 + var26) * var24,
                     var13,
                     (var9 + var25) * var24,
                     var27 - (var10 + var26) * var24,
                     var11,
                     var12,
                     var14 * var24,
                     0.0F,
                     0.0F,
                     1.0F
                  );
               } finally {
                  v17();
               }

               return var28;
            }
         } else {
            return false;
         }
      } else {
         return false;
      }
   }

   public static void v2(
      class_2960 var0, float var1, float var2, float var3, float var4, float var5, float var6, float var7, float var8, int var9, uiRecord7 var10
   ) {
      renderSupport46 var11 = v4;
      if (var11 != null) {
         var11.v27().v2(var0, var1, var2, var3, var4, var5, var6, var7, var8, var9, var10.v1(), var10.v2(), var10.v3(), var10.v4());
      }
   }

   public static float v1(float var0, float var1) {
      return var0 - 0.600625F * var1;
   }

   public static float v2(float var0, float var1) {
      return var0 - 0.96F * var1;
   }

   public static void v1(class_2960 var0, float var1, float var2, float var3, int var4, uiRecord7 var5) {
      v2(var0, var1, var2, var3, var3, 0.125F, 0.125F, 0.25F, 0.25F, var4, var5);
      v2(var0, var1, var2, var3, var3, 0.625F, 0.125F, 0.75F, 0.25F, var4, var5);
   }

   public static void v2(float var0, float var1, float var2, float var3, int var4, uiRecord7 var5) {
      renderSupport46 var6 = v4;
      if (var6 != null) {
         GpuTextureView var7 = v3(var6);
         if (var7 == null) {
            var6.v8().v1(var0, var1, var2, var3, var4, var5.v1(), var5.v2(), var5.v3(), var5.v4(), 0.0F);
         } else {
            var6.v8().v1(var0, var1, var2, var3, var4, var5.v1(), var5.v2(), var5.v3(), var5.v4(), 0.0F, var7);
         }
      }
   }

   public static void v2(float var0, float var1, float var2, float var3, int var4) {
      v2(var0, var1, var2, var3, var4, uiRecord7.ZERO);
   }

   public static void v2(float var0, float var1, float var2, float var3, int[] var4, uiRecord7 var5) {
      renderSupport46 var6 = v4;
      if (var6 != null) {
         GpuTextureView var7 = v3(var6);
         if (var7 == null) {
            var6.v8().v1(var0, var1, var2, var3, var4, var5.v1(), var5.v2(), var5.v3(), var5.v4());
         } else {
            var6.v8().v1(var0, var1, var2, var3, var4, var5.v1(), var5.v2(), var5.v3(), var5.v4(), 0.0F, var7);
         }
      }
   }

   public static void v2(float var0, float var1, float var2, float var3, int var4, float var5, uiRecord7 var6) {
      v2(var0, var1, var2, var3, var4, var5, var6, 1.0F);
   }

   public static void v2(float var0, float var1, float var2, float var3, int var4, float var5, uiRecord7 var6, float var7) {
      renderSupport46 var8 = v4;
      if (var8 != null) {
         GpuTextureView var9 = v3(var8);
         if (var9 == null) {
            var8.v10().v1(var0, var1, var2, var3, var4, var5, var6.v1(), var6.v2(), var6.v3(), var6.v4(), var7);
         } else {
            var8.v10().v1(var0, var1, var2, var3, var4, var5, var6.v1(), var6.v2(), var6.v3(), var6.v4(), var7, var9);
         }
      }
   }

   public static void v2(class_2960 var0, float var1, float var2, float var3, float var4, int var5, uiRecord7 var6) {
      renderSupport46 var7 = v4;
      if (var7 != null) {
         GpuTextureView var8 = v3(var7);
         if (var8 == null) {
            v1(var0, var1, var2, var3, var4, 0.0F, 0.0F, 1.0F, 1.0F, var5, var6);
         } else {
            var7.v27().v1(var0, var1, var2, var3, var4, 0.0F, 0.0F, 1.0F, 1.0F, var5, var6.v1(), var6.v2(), var6.v3(), var6.v4(), var8);
         }
      }
   }

   public static void v3(
      class_2960 var0, float var1, float var2, float var3, float var4, float var5, float var6, float var7, float var8, int var9, uiRecord7 var10
   ) {
      renderSupport46 var11 = v4;
      if (var11 != null) {
         GpuTextureView var12 = v3(var11);
         if (var12 == null) {
            v1(var0, var1, var2, var3, var4, var5, var6, var7, var8, var9, var10);
         } else {
            var11.v27().v1(var0, var1, var2, var3, var4, var5, var6, var7, var8, var9, var10.v1(), var10.v2(), var10.v3(), var10.v4(), var12);
         }
      }
   }

   public static void v1(class_2960 var0, float var1, float var2, float var3, float var4, int var5, float var6) {
      renderSupport46 var7 = v4;
      if (var7 != null) {
         GpuTextureView var8 = v3(var7);
         if (var8 == null) {
            var7.v27().v1(var0, var1, var2, var3, var4, 0.0F, 0.0F, 1.0F, 1.0F, var5, 0.0F, 0.0F, 0.0F, 0.0F, var6);
         } else {
            var7.v27().v1(var0, var1, var2, var3, var4, 0.0F, 0.0F, 1.0F, 1.0F, var5, 0.0F, 0.0F, 0.0F, 0.0F, var6, var8);
         }
      }
   }

   public static void v2(class_2960 var0, float var1, float var2, float var3, float var4) {
      v2(var0, var1, var2, var3, var4, -1, uiRecord7.ZERO);
   }

   public static void v2(class_2960 var0, float var1, float var2, float var3, float var4, uiRecord7 var5) {
      v2(var0, var1, var2, var3, var4, -1, var5);
   }

   public static void v6(float var0, float var1, float var2, float var3) {
      v1(var0, var1, var2, var3, false);
   }

   private static void v1(float var0, float var1, float var2, float var3, boolean var4) {
      class_332 var5 = v5;
      class_310 var6 = v20();
      if (var5 != null) {
         var5.method_44379((int)Math.floor(var0), (int)Math.floor(var1), (int)Math.ceil(var0 + var2), (int)Math.ceil(var1 + var3));
         v6++;
      }

      class_1041 var7 = var6 == null ? null : var6.method_22683();
      if (var4) {
         cloudSupport27.v2(var7, var0, var1, var2, var3);
      } else {
         cloudSupport27.v1(var7, var0, var1, var2, var3);
      }
   }

   public static void v17() {
      class_332 var0 = v5;
      if (var0 != null && v6 > 0) {
         var0.method_44380();
         v6--;
      }

      cloudSupport27.v2();
   }

   private static void v21() {
      class_332 var0 = v5;
      if (var0 != null) {
         while (v6 > 0) {
            var0.method_44380();
            v6--;
         }
      }

      v6 = 0;
   }

   public static float v1(String var0, String var1, float var2, float var3, float var4, int var5) {
      renderSupport46 var6 = v4;
      if (var6 == null) {
         return 0.0F;
      } else {
         InvalidMSDFSupport var7 = var6.v33().v1(var0);
         return var7 == null ? 0.0F : var6.v28().v1(var7, var1, var2, var3, var4, var5);
      }
   }

   public static float v1(String var0, String var1, float var2, float var3, float var4, int var5, cloudRecord5 var6) {
      renderSupport46 var7 = v4;
      if (var7 == null) {
         return 0.0F;
      } else {
         InvalidMSDFSupport var8 = var7.v33().v1(var0);
         return var8 == null ? 0.0F : var7.v28().v1(var8, var1, var2, var3, var4, var5, var6);
      }
   }

   public static float v1(String var0, String var1, float var2) {
      renderSupport46 var3 = v4;
      if (var3 == null) {
         return 0.0F;
      } else {
         InvalidMSDFSupport var4 = var3.v33().v1(var0);
         return var4 == null ? 0.0F : var4.v2(var1, var2);
      }
   }

   public static float v2(String var0, String var1, float var2) {
      renderSupport46 var3 = v4;
      if (var3 == null) {
         return 0.0F;
      } else {
         InvalidMSDFSupport var4 = var3.v33().v1(var0);
         return var4 == null ? 0.0F : var4.v1(var1, var2);
      }
   }

   public static float v2(String var0) {
      renderSupport46 var1 = v4;
      InvalidMSDFSupport var2 = var1 == null ? null : var1.v33().v1(var0);
      return var2 == null ? 1.213F : var2.v8();
   }

   public static boolean v1(String var0, String var1, float var2, float[] var3) {
      renderSupport46 var4 = v4;
      InvalidMSDFSupport var5 = var4 == null ? null : var4.v33().v1(var0);
      if (var5 == null) {
         Arrays.fill(var3, 0, Math.min(var3.length, var1.length() + 1), 0.0F);
         return false;
      } else {
         var5.v1(var1, var2, var3);
         return true;
      }
   }

   public static float v2(String var0, String var1, float var2, float var3, float var4, int var5) {
      renderSupport46 var6 = v4;
      if (var6 == null) {
         return 0.0F;
      } else {
         InvalidMSDFSupport var7 = var6.v33().v1(var0);
         if (var7 == null) {
            return 0.0F;
         } else {
            float var8 = var7.v1(var1, var4);
            return var6.v28().v1(var7, var1, var2 - var8, var3, var4, var5);
         }
      }
   }

   public static float v3(String var0, String var1, float var2, float var3, float var4, int var5) {
      renderSupport46 var6 = v4;
      if (var6 == null) {
         return 0.0F;
      } else {
         InvalidMSDFSupport var7 = var6.v33().v1(var0);
         if (var7 == null) {
            return 0.0F;
         } else {
            float var8 = var7.v1(var1, var4);
            return var6.v28().v1(var7, var1, var2 - var8 / 2.0F, var3, var4, var5);
         }
      }
   }

   public static float v4(String var0, String var1, float var2, float var3, float var4, int var5) {
      renderSupport46 var6 = v4;
      if (var6 == null) {
         return 0.0F;
      } else {
         InvalidMSDFSupport var7 = var6.v33().v1(var0);
         if (var7 == null) {
            return 0.0F;
         } else {
            GpuTextureView var8 = v3(var6);
            return var8 == null ? var6.v28().v1(var7, var1, var2, var3, var4, var5) : var6.v28().v1(var7, var1, var2, var3, var4, var5, var8);
         }
      }
   }

   public static float v2(String var0, String var1, float var2, float var3, float var4, int var5, cloudRecord5 var6) {
      renderSupport46 var7 = v4;
      if (var7 == null) {
         return 0.0F;
      } else {
         InvalidMSDFSupport var8 = var7.v33().v1(var0);
         if (var8 == null) {
            return 0.0F;
         } else {
            GpuTextureView var9 = v3(var7);
            return var9 == null ? var7.v28().v1(var8, var1, var2, var3, var4, var5, var6) : var7.v28().v1(var8, var1, var2, var3, var4, var5, var6, var9);
         }
      }
   }

   public static float v5(String var0, String var1, float var2, float var3, float var4, int var5) {
      float var6 = v2(var0, var1, var4);
      return v4(var0, var1, var2 - var6, var3, var4, var5);
   }

   public static float v6(String var0, String var1, float var2, float var3, float var4, int var5) {
      float var6 = v2(var0, var1, var4);
      return v4(var0, var1, var2 - var6 / 2.0F, var3, var4, var5);
   }
}
