package cc.syky.internal;

import cc.syky.hud.FitSupport;
import cc.syky.mixin.accessor.DrawContextInvoker;
import net.minecraft.class_10799;
import net.minecraft.class_156;
import net.minecraft.class_2960;
import net.minecraft.class_310;
import net.minecraft.class_332;
import org.jetbrains.annotations.Nullable;

public final class InternalSupport51 {
   public static boolean v1;
   @Nullable
   public static InternalSupport23 v2;
   @Nullable
   public static InternalSupport50.Part1 v3;
   public static FitSupport v4 = FitSupport.FILL;
   public static float v5 = 1.0F;
   public static float v6 = 1.0F;
   public static float v7 = 0.3F;
   public static int v8;
   private static final long v9 = 250L;
   private static long v10;
   private static long v11 = -4611686018427387904L;
   private static final float[] v12 = new float[8];

   private InternalSupport51() {
   }

   public static void v1(class_332 var0, int var1, int var2) {
      InternalSupport23 var3 = v2;
      InternalSupport50.Part1 var4 = v3;
      if (var3 != null && var4 != null) {
         long var5 = class_156.method_658();
         if (var5 - v11 > 250L) {
            v10 = var5;
         }

         v11 = var5;
         int var7 = var3.v1((long)((float)(var5 - v10) * v6));
         float var8 = var1 + var4.v3();
         float var9 = var2 + var4.v4();
         float var10 = var4.v5() - var4.v3();
         float var11 = var4.v6() - var4.v4();
         int var12 = var3.v4();
         int var13 = var3.v5();
         v4.v1(var8, var9, var10, var11, var12, var13, v12);
         float var14 = var3.v1(var7);
         float var15 = var3.v2(var7);
         float var16 = var3.v3(var7) - var14;
         float var17 = var3.v4(var7) - var15;
         int var18 = Math.round(Math.clamp(v5, 0.0F, 1.0F) * 255.0F);
         DrawContextInvoker var19 = (DrawContextInvoker)var0;
         var19.syky$drawTexturedQuad(
            class_10799.field_56883,
            var3.v1(),
            Math.round(v12[0]),
            Math.round(v12[2]),
            Math.round(v12[1]),
            Math.round(v12[3]),
            var14 + var16 * v12[4],
            var14 + var16 * v12[6],
            var15 + var17 * v12[5],
            var15 + var17 * v12[7],
            var18 << 24 | 16777215
         );
         class_2960 var20 = var4.v2();
         int var21 = Math.round(Math.clamp(v7, 0.0F, 1.0F) * 255.0F);
         if (var20 != null && var21 > 0) {
            var19.syky$drawTexturedQuad(class_10799.field_56883, var20, var1, var1 + 176, var2, var2 + 166, 0.0F, 1.0F, 0.0F, 1.0F, var21 << 24 | 16777215);
         }

         var19.syky$drawTexturedQuad(class_10799.field_56883, var4.v1(), var1, var1 + 176, var2, var2 + 166, 0.0F, 1.0F, 0.0F, 1.0F, -1);
         int var22 = class_310.method_1551().method_22683().method_4495();
         v8 = v4.v1(var10, var11, var12, var13, var22);
      }
   }

   public static void v1() {
      InternalSupport50.v1();
   }

   public static void v1(@Nullable InternalSupport23 var0, @Nullable InternalSupport50.Part1 var1, FitSupport var2, float var3, float var4, float var5) {
      v2 = var0;
      v3 = var1;
      v4 = var2;
      v5 = var3;
      v7 = var4;
      v6 = var5;
      v1 = var0 != null && var1 != null;
   }

   public static void v2() {
      v1 = false;
      v2 = null;
      v3 = null;
      v8 = 0;
   }
}
