package cc.syky.account;

import cc.syky.module.visual.visualSupport44;
import cc.syky.ui.uiSupport169;
import net.minecraft.class_1309;
import net.minecraft.class_1657;
import net.minecraft.class_1799;
import net.minecraft.class_1802;
import net.minecraft.class_310;
import net.minecraft.class_332;
import net.minecraft.class_3489;
import net.minecraft.class_3966;
import net.minecraft.class_9334;

public final class accountSupport21 {
   public static boolean v1 = false;
   public static boolean v2 = false;
   public static boolean v3 = true;
   public static boolean v4 = false;
   public static float v5 = 6.0F;
   public static float v6 = 2.0F;
   public static float v7 = 4.0F;
   public static boolean v8 = false;
   public static float v9 = 2.0F;
   public static boolean v10 = true;
   public static float v11 = 1.0F;
   public static int v12 = -16777216;
   public static int v13 = -16711936;
   public static boolean v14 = true;
   public static int v15 = -52429;
   public static boolean v16 = true;
   public static float v18 = 6.0F;
   public static boolean v19 = false;
   public static float v17 = 16.0F;
   public static float v20 = 2.0F;
   public static float v21 = 10.0F;
   public static int v22 = -1;
   public static int v24 = Integer.MIN_VALUE;
   public static boolean v25 = true;
   public static boolean v26 = true;
   private static final float v27 = 0.025F;
   private static final float v28 = 0.9F;
   private static final float v29 = 0.5F;
   private static float v30 = 0.0F;
   private static long v32 = 0L;
   private static final float[][] v23 = new float[5][4];

   private accountSupport21() {
   }

   public static void v1() {
      v30 = 0.0F;
      v32 = 0L;
   }

   private static void v1(int var0, float var1, float var2, float var3, float var4) {
      float[] var5 = v23[var0];
      var5[0] = var1;
      var5[1] = var2;
      var5[2] = var3;
      var5[3] = var4;
   }

   public static void v1(class_332 var0, float var1) {
      class_310 var2 = class_310.method_1551();
      float var3 = v2();
      float var4 = var2.field_1724 == null ? 1.0F : v1(var2.field_1724, var1);
      float var5 = var0.method_51421() / 2.0F;
      float var6 = var0.method_51443() / 2.0F;
      float var7 = v7 + v1(var4, var3);
      float var8 = v6 / 2.0F;
      int var9 = 0;
      if (v3 && v5 > 0.0F && v6 > 0.0F) {
         v1(var9++, var5 + var7, var6 - var8, v5, v6);
         v1(var9++, var5 - var7 - v5, var6 - var8, v5, v6);
         v1(var9++, var5 - var8, var6 + var7, v6, v5);
         if (!v4) {
            v1(var9++, var5 - var8, var6 - var7 - v5, v6, v5);
         }
      }

      if (v8 && v9 > 0.0F) {
         float var10 = v9;
         v1(var9++, var5 - var10 / 2.0F, var6 - var10 / 2.0F, var10, var10);
      }

      float[][] var21 = v23;
      int var11 = v1(var2);
      boolean var12 = v10 && v11 > 0.0F && v12 >>> 24 != 0;
      boolean var13 = var11 >>> 24 != 0;
      boolean var14 = var9 > 0 && (var12 || var13);
      boolean var15 = v19 && var2.field_1724 != null && v1(var2.field_1724) && (var4 < 1.0F || !v26) && v17 > 0.0F && v20 > 0.0F;
      if (var14 || var15) {
         uiSupport169.v1(var0);
         if (var14 && var12) {
            float var16 = v11;

            for (int var17 = 0; var17 < var9; var17++) {
               float[] var18 = var21[var17];
               uiSupport169.v1(var18[0] - var16, var18[1] - var16, var18[2] + 2.0F * var16, var18[3] + 2.0F * var16, v12);
            }
         }

         if (var14 && var13) {
            for (int var22 = 0; var22 < var9; var22++) {
               float[] var23 = var21[var22];
               uiSupport169.v1(var23[0], var23[1], var23[2], var23[3], var11);
            }
         }

         if (var15) {
            v1(var5, var6, var4, var12);
         }

         uiSupport169.v15();
      }
   }

   private static void v1(float var0, float var1, float var2, boolean var3) {
      float var4 = uiSupport169.v1(var0 - v17 / 2.0F);
      float var5 = uiSupport169.v1(var0 + v17 / 2.0F);
      float var6 = uiSupport169.v1(var1 + v21);
      float var7 = uiSupport169.v1(var1 + v21 + v20);
      float var8 = var5 - var4;
      float var9 = var7 - var6;
      if (!(var8 <= 0.0F) && !(var9 <= 0.0F)) {
         float var10 = v25 ? var9 / 2.0F : 0.0F;
         if (var3) {
            float var11 = v11;
            uiSupport169.v1(var4 - var11, var6 - var11, var8 + 2.0F * var11, var9 + 2.0F * var11, v12, v25 ? var10 + var11 : 0.0F);
         }

         if (v24 >>> 24 != 0) {
            uiSupport169.v1(var4, var6, var8, var9, v24, var10);
         }

         float var12 = var8 * var2;
         if (var12 > 0.0F && v22 >>> 24 != 0) {
            uiSupport169.v1(var4, var6, var12, var9, v22, Math.min(var10, var12 / 2.0F));
         }
      }
   }

   private static boolean v1(class_1657 var0) {
      class_1799 var1 = var0.method_6047();
      return var1.method_31573(class_3489.field_42611)
         || var1.method_31573(class_3489.field_42612)
         || var1.method_31573(class_3489.field_63257)
         || var1.method_31574(class_1802.field_49814)
         || var1.method_31574(class_1802.field_8547);
   }

   private static float v2() {
      long var0 = System.nanoTime();
      float var2 = v32 == 0L ? 0.0F : (float)(var0 - v32) / 1.0E9F;
      v32 = var0;
      return var2;
   }

   private static int v1(class_310 var0) {
      return v14 && var0.field_1765 instanceof class_3966 var1 && var1.method_17782() instanceof class_1309 var2 && !visualSupport44.v1(var2) ? v15 : v13;
   }

   private static float v1(float var0, float var1) {
      float var2 = 0.0F;
      if (v16 && v18 > 0.0F) {
         var2 = v18 * (1.0F - var0);
      }

      if (!(var2 <= v30) && !(var1 <= 0.0F)) {
         if (var1 > 0.1F) {
            var1 = 0.1F;
         }

         v30 = v30 + (var2 - v30) * (1.0F - (float)Math.exp(-var1 / 0.025F));
         return v30;
      } else {
         v30 = var2;
         return v30;
      }
   }

   private static float v1(class_1657 var0, float var1) {
      float var2 = var0.method_7279();
      if (var2 <= 0.0F) {
         return 1.0F;
      } else {
         float var3 = v2(var0, var2);
         if (var3 <= 0.0F) {
            return 1.0F;
         } else {
            float var4 = var0.method_7261(var1) * var2;
            return Math.min(var4 / var3, 1.0F);
         }
      }
   }

   private static float v2(class_1657 var0, float var1) {
      float var2 = (float)Math.floor(0.9F * var1 - 0.5F) + 1.0F;
      float var3 = (Float)var0.method_6047().method_58695(class_9334.field_63635, 0.0F);
      float var4 = var3 > 0.0F ? (float)Math.ceil(var3 * var1) : 0.0F;
      return Math.min(Math.max(var2, var4), var1);
   }
}
