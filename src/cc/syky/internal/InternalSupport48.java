package cc.syky.internal;

import cc.syky.account.accountSupport22;
import cc.syky.cloud.cloudSupport69;
import cc.syky.module.visual.visualSupport51;
import cc.syky.render.renderSupport45;
import net.minecraft.class_1297;
import net.minecraft.class_243;
import net.minecraft.class_276;
import net.minecraft.class_310;
import net.minecraft.class_4184;
import net.minecraft.class_5498;
import org.jetbrains.annotations.Nullable;
import org.joml.Matrix4f;
import org.joml.Quaternionf;
import org.joml.Vector3f;

public final class InternalSupport48 {
   public static final float v1 = 0.016666668F;
   private static final long v4 = 16666666L;
   private static final float v5 = 0.001F;
   private static final float v6 = 0.06666667F;
   private static final long v7 = 250000000L;
   private static final int v8 = 64;
   private static final float v9 = 16.0F;
   private static final float v10 = 0.125F;
   private static final float v11 = 0.5625F;
   private static final float v12 = 0.25F;
   public static int v2 = -1;
   public static boolean v3;
   private static final float v13 = 1.0E-12F;
   private static final float v14 = 0.5F;
   private static final InternalSupport48.Part1[] v15 = new InternalSupport48.Part1[64];
   private static int v16;
   private static int v18;
   private static final Vector3f v19;
   @Nullable
   private static class_5498 v17;
   private static int v20;

   private InternalSupport48() {
   }

   public static boolean v1() {
      if (visualSupport51.v44 && !(visualSupport51.v47 <= 0.0F)) {
         class_310 var0 = class_310.method_1551();
         class_1297 var1 = var0.method_1560();
         return var0.field_1690.method_31044() != class_5498.field_26664 || var1 != null && var1.method_5765();
      } else {
         return false;
      }
   }

   public static void v2() {
      v18 = 0;
   }

   public static void v1(class_4184 var0) {
      class_243 var1 = var0.method_71156();
      Quaternionf var2 = var0.method_23767();
      long var3 = System.nanoTime();
      if (v1(var0, var1, var3)) {
         v18 = 0;
         v1(var1, var2, var3);
      } else {
         InternalSupport48.Part1 var5 = v1(var3);
         v19.set((float)(var1.field_1352 - var5.v4), (float)(var1.field_1351 - var5.v5), (float)(var1.field_1350 - var5.v6));
         float var6 = Math.clamp((float)(var3 - var5.v7) / 1.0E9F, 0.001F, 0.06666667F);
         float var7 = visualSupport51.v47 * (0.016666668F / var6);
         boolean var8 = !v3 && v19.lengthSquared() < 1.0E-12F && v1(var5.v3, var2) * var7 < 0.5F;
         if (!var8 && !(visualSupport51.v47 <= 0.0F)) {
            float var9 = Math.max(1.0F, visualSupport51.v47 / 0.25F);
            InternalSupport49 var10 = visualSupport51.v49;

            try {
               renderSupport45.v1(
                  accountSupport22.v5(),
                  var5.v1,
                  var5.v2,
                  v19,
                  var7,
                  var9,
                  var10.v1(var9),
                  v2 >= 0 ? v2 : var10.v1(),
                  cloudSupport69.v1() ? 0.5625F : 0.0F,
                  v1()
               );
            } finally {
               v1(var1, var2, var3);
            }
         } else {
            v1(var1, var2, var3);
         }
      }
   }

   private static InternalSupport48.Part1 v1(long var0) {
      for (int var2 = 0; var2 < v18; var2++) {
         InternalSupport48.Part1 var3 = v15[Math.floorMod(v16 - var2, 64)];
         if (var0 - var3.v7 >= 16666666L) {
            return var3;
         }
      }

      return v15[Math.floorMod(v16 - (v18 - 1), 64)];
   }

   private static float v1(Quaternionf var0, Quaternionf var1) {
      float var2 = Math.min(1.0F, Math.abs(var0.dot(var1)));
      float var3 = 2.0F * (float)Math.acos(var2);
      Matrix4f var4 = accountSupport22.v2();
      class_276 var5 = class_310.method_1551().method_1522();
      float var6 = Math.max(var4.m00() * var5.field_1482, var4.m11() * var5.field_1481) * 0.5F;
      float var7 = 1.0F + 1.0F / (var4.m00() * var4.m00()) + 1.0F / (var4.m11() * var4.m11());
      return var3 * var6 * var7;
   }

   private static boolean v1(class_4184 var0, class_243 var1, long var2) {
      class_5498 var4 = class_310.method_1551().field_1690.method_31044();
      class_1297 var5 = var0.method_19331();
      int var6 = var5 != null ? var5.method_5628() : -1;
      boolean var7 = var4 != v17 || var6 != v20;
      v17 = var4;
      v20 = var6;
      if (!var7 && v18 != 0) {
         InternalSupport48.Part1 var8 = v15[v16];
         if (var2 - var8.v7 > 250000000L) {
            return true;
         } else {
            double var9 = var1.field_1352 - var8.v4;
            double var11 = var1.field_1351 - var8.v5;
            double var13 = var1.field_1350 - var8.v6;
            return var9 * var9 + var11 * var11 + var13 * var13 > 256.0;
         }
      } else {
         return true;
      }
   }

   private static void v1(class_243 var0, Quaternionf var1, long var2) {
      v16 = (v16 + 1) % 64;
      v18 = Math.min(v18 + 1, 64);
      InternalSupport48.Part1 var4 = v15[v16];
      var4.v1.set(accountSupport22.v4());
      var4.v2.set(accountSupport22.v2());
      var4.v3.set(var1);
      var4.v4 = var0.field_1352;
      var4.v5 = var0.field_1351;
      var4.v6 = var0.field_1350;
      var4.v7 = var2;
   }

   static {
      for (int var0 = 0; var0 < 64; var0++) {
         v15[var0] = new InternalSupport48.Part1();
      }

      v19 = new Vector3f();
      v20 = -1;
   }

   public static final class Part1 {
      public final Matrix4f v1 = new Matrix4f();
      public final Matrix4f v2 = new Matrix4f();
      public final Quaternionf v3 = new Quaternionf();
      public double v4;
      public double v5;
      public double v6;
      public long v7;

      public Part1() {
      }
   }
}
