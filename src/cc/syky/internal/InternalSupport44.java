package cc.syky.internal;

import cc.syky.cloud.cloudSupport47;
import cc.syky.cloud.cloudSupport51;
import cc.syky.ui.uiSupport257;
import net.minecraft.class_238;
import net.minecraft.class_4050;
import org.jetbrains.annotations.Nullable;
import org.joml.Matrix4f;
import org.joml.Matrix4fc;

public final class InternalSupport44 {
   public static final long v1 = 1000L;
   private static final long v2 = 1000000000L;
   private static final float v3 = (float) (Math.PI / 180.0);
   private final float[] v4 = new float[6];
   private float v5;
   private float v6;
   private float v7;
   private float v8;
   private float v9;
   private float v10;
   private long v11;
   @Nullable
   private class_4050 v12;

   public InternalSupport44() {
   }

   public static Matrix4f v1(Matrix4f var0, float var1, double var2, double var4, double var6) {
      return var0.rotationY(var1 * (float) (Math.PI / 180.0)).translate((float)(-var2), (float)(-var4), (float)(-var6));
   }

   public void v1() {
      this.v5 = this.v6 = this.v7 = Float.POSITIVE_INFINITY;
      this.v8 = this.v9 = this.v10 = Float.NEGATIVE_INFINITY;
      this.v12 = null;
   }

   public void v1(Matrix4fc var1, uiSupport257 var2, cloudSupport51 var3) {
      if (var2.v1(var3)) {
         if (var3 == cloudSupport51.BODY) {
            this.v1(var1, var2.v1(var3, 0), var2.v1(var3, 1), var2.v1(var3, 2), var2.v1(var3, 3), var2.v1(var3, 4), var2.v1(var3, 5));
         } else {
            this.v1(var1, 0.0F, 0.0F, 0.0F, var2.v2(var3));
         }
      }
   }

   public void v1(Matrix4fc var1, float var2, float var3, float var4, float var5) {
      float var6 = var1.m00() * var2 + var1.m10() * var3 + var1.m20() * var4 + var1.m30();
      float var7 = var1.m01() * var2 + var1.m11() * var3 + var1.m21() * var4 + var1.m31();
      float var8 = var1.m02() * var2 + var1.m12() * var3 + var1.m22() * var4 + var1.m32();
      float var9 = var1.m00() * var1.m00() + var1.m01() * var1.m01() + var1.m02() * var1.m02();
      float var10 = var1.m10() * var1.m10() + var1.m11() * var1.m11() + var1.m12() * var1.m12();
      float var11 = var1.m20() * var1.m20() + var1.m21() * var1.m21() + var1.m22() * var1.m22();
      float var12 = var5 * (float)Math.sqrt(Math.max(var9, Math.max(var10, var11)));
      this.v1(var6 - var12, var7 - var12, var8 - var12, var6 + var12, var7 + var12, var8 + var12);
   }

   private void v1(Matrix4fc var1, float var2, float var3, float var4, float var5, float var6, float var7) {
      cloudSupport47.v1(var1, var2, var3, var4, var5, var6, var7, this.v4);
      this.v1(this.v4[0], this.v4[1], this.v4[2], this.v4[3], this.v4[4], this.v4[5]);
   }

   private void v1(float var1, float var2, float var3, float var4, float var5, float var6) {
      this.v5 = Math.min(this.v5, var1);
      this.v6 = Math.min(this.v6, var2);
      this.v7 = Math.min(this.v7, var3);
      this.v8 = Math.max(this.v8, var4);
      this.v9 = Math.max(this.v9, var5);
      this.v10 = Math.max(this.v10, var6);
   }

   public void v1(class_4050 var1, long var2) {
      if (this.v5 <= this.v8) {
         this.v12 = var1;
         this.v11 = var2;
      }
   }

   public boolean v2(class_4050 var1, long var2) {
      return this.v12 == var1 && var2 - this.v11 < 1000000000L;
   }

   public class_238 v1(double var1, double var3, double var5, float var7, double var8) {
      float var10 = (float)Math.cos(var7 * (float) (Math.PI / 180.0));
      float var11 = (float)Math.sin(var7 * (float) (Math.PI / 180.0));
      float var12 = Float.POSITIVE_INFINITY;
      float var13 = Float.POSITIVE_INFINITY;
      float var14 = Float.NEGATIVE_INFINITY;
      float var15 = Float.NEGATIVE_INFINITY;

      for (int var16 = 0; var16 < 4; var16++) {
         float var17 = (var16 & 1) == 0 ? this.v5 : this.v8;
         float var18 = (var16 & 2) == 0 ? this.v7 : this.v10;
         float var19 = var10 * var17 - var11 * var18;
         float var20 = var11 * var17 + var10 * var18;
         var12 = Math.min(var12, var19);
         var13 = Math.min(var13, var20);
         var14 = Math.max(var14, var19);
         var15 = Math.max(var15, var20);
      }

      return new class_238(var1 + var12 - var8, var3 + this.v6 - var8, var5 + var13 - var8, var1 + var14 + var8, var3 + this.v9 + var8, var5 + var15 + var8);
   }
}
