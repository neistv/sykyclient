package cc.syky.internal;

import net.minecraft.class_4588;
import org.jetbrains.annotations.Nullable;
import org.joml.Matrix3f;
import org.joml.Matrix3fc;
import org.joml.Matrix4f;
import org.joml.Matrix4fc;

public final class InternalSupport41 {
   private static final Matrix4f v2 = new Matrix4f();
   private static final Matrix3f v3 = new Matrix3f();
   private static final Matrix3f v4 = new Matrix3f();
   public static final float v1 = 1024.0F;

   private InternalSupport41() {
   }

   public static void v1(
      class_4588 var0,
      Matrix4fc var1,
      Matrix3fc var2,
      @Nullable Matrix4fc var3,
      float[] var4,
      int var5,
      int var6,
      InternalSupport45.Part1 var7,
      float var8,
      float var9,
      int var10,
      int var11,
      int var12,
      boolean var13
   ) {
      Matrix4f var14 = v2.set(var1);
      Matrix3f var15 = v3.set(var2);
      if (var3 != null) {
         var14.mul(var3);
         var15.mul(var3.get3x3(v4));
      }

      float var16 = var7.v4() - var7.v2();
      float var17 = var7.v5() - var7.v3();
      float var18 = var7.v2();
      float var19 = var7.v3() + var8 * var17;
      float var20 = var9 * var17;
      int var21 = (var5 + var6) * 8;

      for (int var22 = var5 * 8; var22 < var21; var22 += 8) {
         float var23 = var4[var22];
         float var24 = var4[var22 + 1];
         float var25 = var4[var22 + 2];
         float var26 = var14.m00() * var23 + var14.m10() * var24 + var14.m20() * var25 + var14.m30();
         float var27 = var14.m01() * var23 + var14.m11() * var24 + var14.m21() * var25 + var14.m31();
         float var28 = var14.m02() * var23 + var14.m12() * var24 + var14.m22() * var25 + var14.m32();
         float var29 = var4[var22 + 5];
         float var30 = var4[var22 + 6];
         float var31 = var4[var22 + 7];
         float var32 = var15.m00() * var29 + var15.m10() * var30 + var15.m20() * var31;
         float var33 = var15.m01() * var29 + var15.m11() * var30 + var15.m21() * var31;
         float var34 = var15.m02() * var29 + var15.m12() * var30 + var15.m22() * var31;
         float var35 = var32 * var32 + var33 * var33 + var34 * var34;
         if (var35 > 1.0E-12F && Math.abs(var35 - 1.0F) > 1.0E-4F) {
            float var36 = 1.0F / (float)Math.sqrt(var35);
            var32 *= var36;
            var33 *= var36;
            var34 *= var36;
         }

         float var39 = var18 + var4[var22 + 3] * var16;
         float var37 = var19 + var4[var22 + 4] * var20;
         if (var13) {
            int var38 = Math.round(var23 * 1024.0F) & 65535 | Math.round(var24 * 1024.0F) << 16;
            var0.method_23919(var26, var27, var28, var10, var39, var37, var12, var38, var32, var33, var34);
         } else {
            var0.method_23919(var26, var27, var28, var10, var39, var37, var12, var11, var32, var33, var34);
         }
      }
   }

   public static float v1(InternalSupport62 var0, int var1) {
      return (float)var1 / var0.v4();
   }

   public static float v1(InternalSupport62 var0) {
      return 1.0F / var0.v4();
   }

   @Nullable
   public static Matrix4fc v1(@Nullable InternalSupport63 var0, int var1) {
      return var0 == null ? null : var0.v1(var1);
   }
}
