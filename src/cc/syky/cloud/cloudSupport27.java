package cc.syky.cloud;

import cc.syky.render.renderSupport33;
import com.mojang.blaze3d.systems.RenderPass;
import net.minecraft.class_1041;
import org.jetbrains.annotations.Nullable;

public final class cloudSupport27 {
   private static final int v1 = 16;
   private static final int v2 = 16777216;
   private static final int[] v3 = new int[16];
   private static final int[] v4 = new int[16];
   private static final int[] v5 = new int[16];
   private static final int[] v6 = new int[16];
   private static int v7;

   private cloudSupport27() {
   }

   public static void v1(int var0, int var1, int var2, int var3) {
      v1(var0, var1, var2, var3, false);
   }

   public static void v2(int var0, int var1, int var2, int var3) {
      v1(var0, var1, var2, var3, true);
   }

   private static void v1(int var0, int var1, int var2, int var3, boolean var4) {
      int var5 = v7;
      if (var5 > 0 && !var4) {
         int var6 = Math.min(var5 - 1, 15);
         int var7 = Math.max(v3[var6], var0);
         int var8 = Math.max(v4[var6], var1);
         int var9 = Math.min(v3[var6] + v5[var6], var0 + var2);
         int var10 = Math.min(v4[var6] + v6[var6], var1 + var3);
         var0 = var7;
         var1 = var8;
         var2 = Math.max(0, var9 - var7);
         var3 = Math.max(0, var10 - var8);
      }

      if (var5 < 16) {
         v3[var5] = var0;
         v4[var5] = var1;
         v5[var5] = var2;
         v6[var5] = var3;
      }

      v7++;
   }

   public static void v1() {
      int var0 = v7;
      if (var0 < 16) {
         if (var0 > 0) {
            v3[var0] = v3[var0 - 1];
            v4[var0] = v4[var0 - 1];
            v5[var0] = v5[var0 - 1];
            v6[var0] = v6[var0 - 1];
         } else {
            v3[var0] = 0;
            v4[var0] = 0;
            v5[var0] = 16777216;
            v6[var0] = 16777216;
         }
      }

      v7++;
   }

   public static void v1(@Nullable class_1041 var0, float var1, float var2, float var3, float var4) {
      v1(var0, var1, var2, var3, var4, false);
   }

   public static void v2(@Nullable class_1041 var0, float var1, float var2, float var3, float var4) {
      v1(var0, var1, var2, var3, var4, true);
   }

   private static void v1(@Nullable class_1041 var0, float var1, float var2, float var3, float var4, boolean var5) {
      if (var0 == null) {
         v1();
      } else {
         var1 += renderSupport33.v2();
         var2 += renderSupport33.v3();
         double var6 = var0.method_4495();
         int var8 = (int)Math.floor(var1 * var6);
         int var9 = (int)Math.ceil((var1 + var3) * var6);
         int var10 = var0.method_4506();
         int var11 = var10 - (int)Math.floor(var2 * var6);
         int var12 = var10 - (int)Math.ceil((var2 + var4) * var6);
         int var13 = var8;
         int var14 = var9 - var8;
         int var15 = var12;
         int var16 = var11 - var12;
         if (var8 < 0) {
            var14 += var8;
            var13 = 0;
         }

         if (var12 < 0) {
            var16 += var12;
            var15 = 0;
         }

         if (var14 < 0) {
            var14 = 0;
         }

         if (var16 < 0) {
            var16 = 0;
         }

         v1(var13, var15, var14, var16, var5);
      }
   }

   public static void v2() {
      if (v7 > 0) {
         v7--;
      }
   }

   public static void v3() {
      v7 = 0;
   }

   public static boolean v4() {
      return v7 > 0;
   }

   public static void v1(RenderPass var0) {
      if (v7 > 0) {
         int var1 = Math.min(v7 - 1, 15);
         var0.enableScissor(v3[var1], v4[var1], v5[var1], v6[var1]);
      }
   }

   private static int v10() {
      return Math.min(v7 - 1, 15);
   }

   public static int v5() {
      return v7 == 0 ? 0 : v3[v10()];
   }

   public static int v6() {
      return v7 == 0 ? 0 : v4[v10()];
   }

   public static int v7() {
      return v7 == 0 ? 0 : v5[v10()];
   }

   public static int v8() {
      return v7 == 0 ? 0 : v6[v10()];
   }

   @Nullable
   public static int[] v9() {
      if (v7 == 0) {
         return null;
      } else {
         int var0 = Math.min(v7 - 1, 15);
         return new int[]{v3[var0], v4[var0], v5[var0], v6[var0]};
      }
   }
}
