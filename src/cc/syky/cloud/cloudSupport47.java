package cc.syky.cloud;

import org.joml.Matrix4fc;

public final class cloudSupport47 {
   private cloudSupport47() {
   }

   public static void v1(Matrix4fc var0, float var1, float var2, float var3, float var4, float var5, float var6, float[] var7) {
      float var8 = (var1 + var4) * 0.5F;
      float var9 = (var2 + var5) * 0.5F;
      float var10 = (var3 + var6) * 0.5F;
      float var11 = (var4 - var1) * 0.5F;
      float var12 = (var5 - var2) * 0.5F;
      float var13 = (var6 - var3) * 0.5F;
      float var14 = var0.m00() * var8 + var0.m10() * var9 + var0.m20() * var10 + var0.m30();
      float var15 = var0.m01() * var8 + var0.m11() * var9 + var0.m21() * var10 + var0.m31();
      float var16 = var0.m02() * var8 + var0.m12() * var9 + var0.m22() * var10 + var0.m32();
      float var17 = Math.abs(var0.m00()) * var11 + Math.abs(var0.m10()) * var12 + Math.abs(var0.m20()) * var13;
      float var18 = Math.abs(var0.m01()) * var11 + Math.abs(var0.m11()) * var12 + Math.abs(var0.m21()) * var13;
      float var19 = Math.abs(var0.m02()) * var11 + Math.abs(var0.m12()) * var12 + Math.abs(var0.m22()) * var13;
      var7[0] = var14 - var17;
      var7[1] = var15 - var18;
      var7[2] = var16 - var19;
      var7[3] = var14 + var17;
      var7[4] = var15 + var18;
      var7[5] = var16 + var19;
   }
}
