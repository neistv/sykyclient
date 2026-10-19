package cc.syky.module.visual;

import cc.syky.render.renderSupport13;
import net.minecraft.class_290;
import net.minecraft.class_4588;
import org.jetbrains.annotations.Nullable;

public final class visualSupport11 {
   public static final int v1 = 0;
   public static final int v2 = 1;
   public static final int v3 = 2;
   private static final float v4 = 1.2F;
   private static final float v5 = 131068.0F;
   private static final float v6 = 512.0F;
   private static final float v7 = 63.998047F;
   private static long v8;
   private static int v9;
   private static short v10;
   private static byte v11;

   private visualSupport11() {
   }

   public static void v1(
      renderSupport13 var0,
      class_4588 var1,
      @Nullable class_4588 var2,
      int var3,
      float var4,
      float var5,
      float var6,
      float var7,
      float var8,
      float var9,
      float var10,
      float var11,
      int var12
   ) {
      float var13 = var3 == 0 ? 1.0F : 0.0F;
      float var14 = var3 == 1 ? 1.0F : 0.0F;
      float var15 = var3 == 2 ? 1.0F : 0.0F;
      float var16 = var0.v1(var4, var5, var6);
      float var17 = var0.v1(var7, var8, var9);
      float var18 = Math.max(var16, var17);
      float var19 = var18 > 0.0F ? 1.2F * var18 : (var10 + var11) * 0.5F;
      float var20 = var10 + var19;
      float var21 = var11 + var19;
      float var22;
      float var23;
      float var24;
      float var25;
      float var26;
      float var27;
      if (var3 == 0) {
         var22 = Math.min(var4, var7);
         var23 = Math.max(var4, var7);
         var24 = var5 - var20;
         var25 = var5 + var20;
         var26 = var6 - var21;
         var27 = var6 + var21;
      } else if (var3 == 1) {
         var24 = Math.min(var5, var8);
         var25 = Math.max(var5, var8);
         var26 = var6 - var20;
         var27 = var6 + var20;
         var22 = var4 - var21;
         var23 = var4 + var21;
      } else {
         var26 = Math.min(var6, var9);
         var27 = Math.max(var6, var9);
         var22 = var4 - var20;
         var23 = var4 + var20;
         var24 = var5 - var21;
         var25 = var5 + var21;
      }

      float var28 = var3 == 0 ? var4 : (var3 == 1 ? var5 : var6);
      float var29 = var3 == 0 ? var7 : (var3 == 1 ? var8 : var9);
      int var30 = v1(var10) | v1(var11) << 16;
      v1(var1, var3, var22, var23, var24, var25, var26, var27, var4, var5, var6, var28, var29, var13, var14, var15, var30, var12);
      if (var2 != null) {
         v1(var2, var3, var22, var23, var24, var25, var26, var27, var4, var5, var6, var28, var29, var13, var14, var15, var30, var12);
      }
   }

   private static void v1(
      class_4588 var0,
      int var1,
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
      float var14,
      float var15,
      int var16,
      int var17
   ) {
      boolean var18 = var2 <= 0.0F && var3 >= 0.0F && var4 <= 0.0F && var5 >= 0.0F && var6 <= 0.0F && var7 >= 0.0F;
      boolean var19 = var4 > 0.0F || var18;
      boolean var20 = var5 < 0.0F || var18;
      boolean var21 = var6 > 0.0F || var18;
      boolean var22 = var7 < 0.0F || var18;
      boolean var23 = var2 > 0.0F || var18;
      boolean var24 = var3 < 0.0F || var18;
      int var25 = (var19 ? 1 : 0) + (var20 ? 1 : 0) + (var21 ? 1 : 0) + (var22 ? 1 : 0) + (var23 ? 1 : 0) + (var24 ? 1 : 0);
      v8 = visualSupport10.v1(var0, class_290.field_1580, var25 * 4);

      try {
         if (v8 != 0L) {
            v9 = visualSupport10.v1(var17);
            v10 = visualSupport10.v1(var13, var14);
            v11 = visualSupport10.v1(var15);
         }

         if (var19) {
            v1(var0, var1, var8, var9, var10, var11, var12, var13, var14, var15, var16, var17, 1, var4, var2, var3, var6, var7);
         }

         if (var20) {
            v1(var0, var1, var8, var9, var10, var11, var12, var13, var14, var15, var16, var17, 1, var5, var2, var3, var6, var7);
         }

         if (var21) {
            v1(var0, var1, var8, var9, var10, var11, var12, var13, var14, var15, var16, var17, 2, var6, var2, var3, var4, var5);
         }

         if (var22) {
            v1(var0, var1, var8, var9, var10, var11, var12, var13, var14, var15, var16, var17, 2, var7, var2, var3, var4, var5);
         }

         if (var23) {
            v1(var0, var1, var8, var9, var10, var11, var12, var13, var14, var15, var16, var17, 0, var2, var4, var5, var6, var7);
         }

         if (var24) {
            v1(var0, var1, var8, var9, var10, var11, var12, var13, var14, var15, var16, var17, 0, var3, var4, var5, var6, var7);
         }
      } finally {
         v8 = 0L;
      }
   }

   private static void v1(
      class_4588 var0,
      int var1,
      float var2,
      float var3,
      float var4,
      float var5,
      float var6,
      float var7,
      float var8,
      float var9,
      int var10,
      int var11,
      int var12,
      float var13,
      float var14,
      float var15,
      float var16,
      float var17
   ) {
      v1(var0, var1, var2, var3, var4, var5, var6, var7, var8, var9, var10, var11, var12, var13, var14, var16);
      v1(var0, var1, var2, var3, var4, var5, var6, var7, var8, var9, var10, var11, var12, var13, var15, var16);
      v1(var0, var1, var2, var3, var4, var5, var6, var7, var8, var9, var10, var11, var12, var13, var15, var17);
      v1(var0, var1, var2, var3, var4, var5, var6, var7, var8, var9, var10, var11, var12, var13, var14, var17);
   }

   private static void v1(
      class_4588 var0,
      int var1,
      float var2,
      float var3,
      float var4,
      float var5,
      float var6,
      float var7,
      float var8,
      float var9,
      int var10,
      int var11,
      int var12,
      float var13,
      float var14,
      float var15
   ) {
      float var16;
      float var17;
      float var18;
      if (var12 == 0) {
         var16 = var13;
         var17 = var14;
         var18 = var15;
      } else if (var12 == 1) {
         var17 = var13;
         var16 = var14;
         var18 = var15;
      } else {
         var18 = var13;
         var16 = var14;
         var17 = var15;
      }

      float var19;
      float var20;
      float var21;
      if (var1 == 0) {
         var19 = var17 - var3;
         var20 = var18 - var4;
         var21 = var16;
      } else if (var1 == 1) {
         var19 = var18 - var4;
         var20 = var16 - var2;
         var21 = var17;
      } else {
         var19 = var16 - var2;
         var20 = var17 - var3;
         var21 = var18;
      }

      int var22 = v2(var21 - var5) & 65535 | v2(var6 - var21) << 16;
      if (v8 != 0L) {
         visualSupport10.v1(v8, var16, var17, var18, v9, var19, var20, var22, var10, v10, v11);
         v8 += 36L;
      } else if (visualSupport9.v6) {
         var0.method_22912(var16, var17, var18)
            .method_39415(var11)
            .method_22913(var19, var20)
            .method_60796(v2(var21 - var5), v2(var6 - var21))
            .method_60803(var10)
            .method_22914(var7, var8, var9);
      } else {
         var0.method_23919(var16, var17, var18, var11, var19, var20, var22, var10, var7, var8, var9);
      }
   }

   private static int v1(float var0) {
      return Math.max(0, Math.min(32767, Math.round(var0 * 131068.0F)));
   }

   private static int v2(float var0) {
      return Math.round(Math.max(-63.998047F, Math.min(63.998047F, var0)) * 512.0F);
   }
}
