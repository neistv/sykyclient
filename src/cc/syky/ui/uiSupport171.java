package cc.syky.ui;

import org.joml.Quaternionf;

public final class uiSupport171 {
   private static final float v12 = (float) Math.PI;
   private static final float v13 = (float) (Math.PI * 2);
   public static final float v1 = (float)Math.toRadians(15.0);
   public static final float v2 = 5.0F;
   public static final float v3 = 3.0F;
   public static final float v4 = (float) (-Math.PI / 2);
   public static final float v5 = (float) Math.PI;
   public static final float v6 = 0.0625F;
   public static final float v7 = 0.00390625F;
   public static final float v8 = 0.02F;
   public static final float v9 = 0.0625F;
   public static final float v10 = 1.5F;
   public static final float v11 = 0.15F;

   private uiSupport171() {
   }

   public static float v1(float var0, boolean var1) {
      float var2 = var1 ? 0.2F : -0.33333334F;
      return Math.clamp(var0 + var2, 0.0F, 1.0F);
   }

   public static float v1(float var0) {
      return v4(var0 + v1);
   }

   public static float v2(float var0) {
      float var1 = v4((float) (-Math.PI / 2) - var0);
      float var2 = (float) (Math.PI / 2);
      if (var1 >= var2) {
         return var1 - (float) Math.PI;
      } else {
         return var1 < -var2 ? var1 + (float) Math.PI : var1;
      }
   }

   public static float v3(float var0) {
      float var1 = 1.0F - Math.clamp(var0, 0.0F, 1.0F);
      return 1.0F - var1 * var1 * var1;
   }

   public static Quaternionf v1(Quaternionf var0, float var1, float var2) {
      float var3 = (float)Math.cos(var1 * 0.5);
      float var4 = (float)Math.sin(var1 * 0.5);
      float var5 = (float)Math.cos(var2 * 0.5);
      float var6 = (float)Math.sin(var2 * 0.5);
      return var0.set(var3 * var6, var4 * var5, -var4 * var6, var3 * var5);
   }

   public static float v4(float var0) {
      float var1 = var0 % (float) (Math.PI * 2);
      if (var1 >= (float) Math.PI) {
         return var1 - (float) (Math.PI * 2);
      } else {
         return var1 < (float) -Math.PI ? var1 + (float) (Math.PI * 2) : var1;
      }
   }

   public static float v1(float var0, float var1, float var2) {
      return var0 + v4(var1 - var0) * var2;
   }

   public static float v2(float var0, float var1, float var2) {
      return var0 + (var1 - var0) * var2;
   }

   public static float v1(float var0, float var1, float var2, float var3, float var4, int var5, float var6, float var7) {
      float var8 = v1(var0, var1, var2, var3, var4, var5);
      float var9 = 0.0625F - var1;
      return Math.max(var8, var9 + (var8 - var9) * var6) + v5(var7);
   }

   public static float v5(float var0) {
      float var1 = var0 / (float) (Math.PI * 2);
      return 0.02F * (var1 - (float)Math.floor(var1));
   }

   public static float v1(float var0, float var1, float var2, float var3, float var4, int var5) {
      float var6 = (float)Math.cos(var0);
      float var7 = (float)Math.sin(var0);
      float var8 = Math.abs(var6);
      float var9 = Math.abs(var7);
      float var10 = (var1 + var2) * 0.5F;
      float var11 = (var2 - var1) * 0.5F;
      float var12 = (var3 + var4) * 0.5F;
      float var13 = (var4 - var3) * 0.5F;
      float var14 = var10 * var6 - var12 * var7 - (var8 * var11 + var9 * var13);
      var14 -= var9 * v1(var3, var4, var5);
      return 0.00390625F - var14;
   }

   private static float v1(float var0, float var1, int var2) {
      float var3 = var1 - var0;
      return var2 > 1 && !(var3 > 0.0625F) ? var3 * 1.5F * (var2 - 1) * 0.5F : 0.0F;
   }
}
