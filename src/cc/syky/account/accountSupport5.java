package cc.syky.account;

import cc.syky.mixin.accessor.ItemLayerRenderStateAccessor;
import cc.syky.mixin.accessor.ItemRenderStateAccessor;
import java.util.List;
import net.minecraft.class_1058;
import net.minecraft.class_5611;
import net.minecraft.class_7764;
import net.minecraft.class_777;
import net.minecraft.class_10444.class_10446;
import org.jetbrains.annotations.Nullable;
import org.joml.Matrix4f;
import org.joml.Vector3f;
import org.joml.Vector3fc;

public final class accountSupport5 {
   public static final float v1 = 0.05F;
   private static final float v2 = 6.0F;
   private final Matrix4f v3 = new Matrix4f();
   private final Matrix4f v4 = new Matrix4f();
   private final Matrix4f v5 = new Matrix4f();
   private final Vector3f v6 = new Vector3f();
   private final float[] v7 = new float[4];
   private final float[] v8 = new float[4];
   private float v9;
   private float v10;
   private float v11;
   private float v12;

   public accountSupport5() {
   }

   public void v1(float var1, float var2, float var3, float var4) {
      this.v9 = var1;
      this.v10 = var2;
      this.v11 = var3;
      this.v12 = var4;
   }

   public float v1() {
      return this.v9;
   }

   public float v2() {
      return this.v10;
   }

   public float v3() {
      return this.v11;
   }

   public float v4() {
      return this.v12;
   }

   public float v1(boolean var1, float var2, float var3, boolean var4) {
      accountSupport12.Part1 var5 = accountSupport12.v1(var1);
      if (var5 == null) {
         return Float.NaN;
      } else {
         var5.v1(this.v3);
         ItemRenderStateAccessor var6 = (ItemRenderStateAccessor)var5.v2();
         class_10446[] var7 = var6.syky$layers();
         boolean var8 = var6.syky$displayContext().method_67675();
         float var9 = Float.NaN;
         float var10 = Float.MAX_VALUE;
         float var11 = Float.MAX_VALUE;
         float var12 = -Float.MAX_VALUE;
         float var13 = -Float.MAX_VALUE;
         float var14 = Float.MAX_VALUE;
         int var15 = Math.min(var6.syky$layerCount(), var7.length);

         for (int var16 = 0; var16 < var15; var16++) {
            class_10446 var17 = var7[var16];
            this.v3.mul(this.v1(var17, var8), this.v5);
            List var18 = var17.method_67997();
            boolean var19 = var4 && !var18.isEmpty();

            for (class_777 var21 : var18) {
               boolean var22 = true;

               for (int var23 = 0; var23 < 4; var23++) {
                  float var24 = this.v1(var21.method_76648(var23), var23);
                  if (var24 < 0.05F) {
                     var22 = false;
                     break;
                  }

                  var10 = Math.min(var10, this.v7[var23]);
                  var11 = Math.min(var11, this.v8[var23]);
                  var12 = Math.max(var12, this.v7[var23]);
                  var13 = Math.max(var13, this.v8[var23]);
                  var14 = Math.min(var14, var24);
               }

               if (var22 && var19) {
                  float var32 = this.v1(var21, var2, var3);
                  if (!Float.isNaN(var32) && (Float.isNaN(var9) || var32 < var9)) {
                     var9 = var32;
                  }
               }
            }

            if (var18.isEmpty()) {
               for (Vector3fc var33 : ((ItemLayerRenderStateAccessor)var17).syky$vertices().get()) {
                  float var34 = this.v1(var33, 0);
                  if (!(var34 < 0.05F)) {
                     var10 = Math.min(var10, this.v7[0]);
                     var11 = Math.min(var11, this.v8[0]);
                     var12 = Math.max(var12, this.v7[0]);
                     var13 = Math.max(var13, this.v8[0]);
                     var14 = Math.min(var14, var34);
                  }
               }
            }
         }

         if (!Float.isNaN(var9)) {
            return var9;
         } else {
            boolean var25 = false;

            for (int var26 = 0; var26 < var15; var26++) {
               var25 |= !var7[var26].method_67997().isEmpty();
            }

            if (var4 && var25) {
               return Float.NaN;
            } else {
               float var27 = var4 ? 0.0F : 6.0F;
               boolean var28 = var10 <= var12 && var2 >= var10 - var27 && var2 <= var12 + var27 && var3 >= var11 - var27 && var3 <= var13 + var27;
               return var28 ? var14 : Float.NaN;
            }
         }
      }
   }

   @Nullable
   public Vector3f v1(boolean var1, boolean var2, Vector3f var3) {
      accountSupport12.Part1 var4 = accountSupport12.v1(var1);
      return var4 == null ? null : var4.v1(var2, var3);
   }

   @Nullable
   public Vector3f v1(boolean var1, Vector3f var2) {
      accountSupport12.Part1 var3 = accountSupport12.v1(var1);
      return var3 == null ? null : var3.v2(this.v5).getTranslation(var2);
   }

   public float v1(boolean var1) {
      accountSupport12.Part1 var2 = accountSupport12.v1(var1);
      return var2 == null ? 1.0F : var2.v1();
   }

   public float v1(Vector3fc var1) {
      return (this.v9 / this.v10 * var1.x() / -var1.z() + 1.0F) * 0.5F * this.v11;
   }

   private Matrix4f v1(class_10446 var1, boolean var2) {
      return accountSupport12.v1(var1, var2, this.v4);
   }

   private float v1(Vector3fc var1, int var2) {
      this.v5.transformPosition(var1, this.v6);
      float var3 = -this.v6.z;
      if (var3 < 0.05F) {
         return var3;
      } else {
         this.v7[var2] = (this.v9 / this.v10 * this.v6.x / var3 + 1.0F) * 0.5F * this.v11;
         this.v8[var2] = (1.0F - this.v9 * this.v6.y / var3) * 0.5F * this.v12;
         return var3;
      }
   }

   private float v1(class_777 var1, float var2, float var3) {
      float var4 = this.v1(var1, 0, 1, 2, var2, var3);
      return Float.isNaN(var4) ? this.v1(var1, 0, 2, 3, var2, var3) : var4;
   }

   private float v1(class_777 var1, int var2, int var3, int var4, float var5, float var6) {
      float var7 = this.v7[var2];
      float var8 = this.v8[var2];
      float var9 = this.v7[var3];
      float var10 = this.v8[var3];
      float var11 = this.v7[var4];
      float var12 = this.v8[var4];
      float var13 = (var10 - var12) * (var7 - var11) + (var11 - var9) * (var8 - var12);
      if (Math.abs(var13) < 1.0E-6F) {
         return Float.NaN;
      } else {
         float var14 = ((var10 - var12) * (var5 - var11) + (var11 - var9) * (var6 - var12)) / var13;
         float var15 = ((var12 - var8) * (var5 - var11) + (var7 - var11) * (var6 - var12)) / var13;
         float var16 = 1.0F - var14 - var15;
         if (!(var14 < 0.0F) && !(var15 < 0.0F) && !(var16 < 0.0F)) {
            long var17 = var1.method_76649(var2);
            long var19 = var1.method_76649(var3);
            long var21 = var1.method_76649(var4);
            float var23 = var14 * class_5611.method_76641(var17) + var15 * class_5611.method_76641(var19) + var16 * class_5611.method_76641(var21);
            float var24 = var14 * class_5611.method_76642(var17) + var15 * class_5611.method_76642(var19) + var16 * class_5611.method_76642(var21);
            if (!v1(var1.comp_3724(), var23, var24)) {
               return Float.NaN;
            } else {
               this.v5.transformPosition(var1.method_76648(var2), this.v6);
               float var25 = -this.v6.z;
               this.v5.transformPosition(var1.method_76648(var3), this.v6);
               float var26 = -this.v6.z;
               this.v5.transformPosition(var1.method_76648(var4), this.v6);
               return var14 * var25 + var15 * var26 + var16 * -this.v6.z;
            }
         } else {
            return Float.NaN;
         }
      }
   }

   private static boolean v1(class_1058 var0, float var1, float var2) {
      class_7764 var3 = var0.method_45851();
      int var4 = var3.method_45807();
      int var5 = var3.method_45815();
      float var6 = var0.method_4577() - var0.method_4594();
      float var7 = var0.method_4575() - var0.method_4593();
      if (var4 > 0 && var5 > 0 && var6 != 0.0F && var7 != 0.0F) {
         int var8 = Math.min(var4 - 1, Math.max(0, (int)((var1 - var0.method_4594()) / var6 * var4)));
         int var9 = Math.min(var5 - 1, Math.max(0, (int)((var2 - var0.method_4593()) / var7 * var5)));

         try {
            return !var3.method_45810(0, var8, var9);
         } catch (RuntimeException var11) {
            return true;
         }
      } else {
         return true;
      }
   }
}
