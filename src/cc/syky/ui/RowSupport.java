package cc.syky.ui;

import cc.syky.hud.hudSupport64;

public final class RowSupport {
   public static final float v1 = 10.0F;
   public static final float v2 = 24.0F;
   public static final float v3 = 5.0F;
   public static final float v4 = 6.0F;
   public static final float v5 = 1.0F;
   public static final float v6 = 28.0F;
   public static final float v7 = 6.0F;
   public static final float v8 = 4.0F;
   public static final float v9 = 8.0F;
   public static final float v10 = 6.0F;
   public static final float v11 = 2.0F;
   public static final float v12 = 11.5F;
   private static final float v14 = 3.8599997F;
   public static final float v13 = 40.5F;
   private static final float v15 = 13.0F;

   private RowSupport() {
   }

   public static boolean v1(RowSupport.Part2 var0) {
      return var0 != RowSupport.Part2.ROW;
   }

   public static int v1(int[] var0, boolean[] var1, boolean var2, int[] var3) {
      int var4 = 0;

      for (int var5 = 0; var5 < var0.length && var4 < var3.length; var5++) {
         if (var1[var5] && (var2 || var0[var5] > 0)) {
            var3[var4++] = var5;
         }
      }

      return var4;
   }

   public static float v1(
      RowSupport.Part2 var0, RowSupport.Part1 var1, int var2, float[] var3, float var4, float[] var5, float[] var6, float[] var7, float[] var8
   ) {
      return switch (var0) {
         case ROW -> v1(var2, var3, var4, var5, var6, var7, var8);
         case LIST -> v1(var1, var2, var3, var4, var5, var6, var7, var8);
         case COLUMN -> v2(var2, var3, var4, var5, var6, var7, var8);
      };
   }

   private static float v1(int var0, float[] var1, float var2, float[] var3, float[] var4, float[] var5, float[] var6) {
      float var7 = 10.0F * var2;

      for (int var8 = 0; var8 < var0; var8++) {
         if (var8 > 0) {
            var7 += 13.0F * var2;
         }

         var3[var8] = var7;
         var4[var8] = 6.0F * var2;
         var5[var8] = var7 + 29.0F * var2;
         var6[var8] = 8.0F * var2;
         var7 = var5[var8] + var1[var8];
      }

      return var7 + 10.0F * var2;
   }

   private static float v1(RowSupport.Part1 var0, int var1, float[] var2, float var3, float[] var4, float[] var5, float[] var6, float[] var7) {
      float var8 = v1(var1, var2);
      boolean var9 = var0 == RowSupport.Part1.LEFT;
      float var10 = var9 ? 10.0F * var3 + var8 + 5.0F * var3 : 6.0F * var3;
      float var11 = var9 ? 10.0F * var3 : var10 + 29.0F * var3;

      for (int var12 = 0; var12 < var1; var12++) {
         float var13 = 10.0F * var3 + var12 * 37.0F * var3;
         var4[var12] = var10;
         var5[var12] = var13;
         var6[var12] = var9 ? var11 + (var8 - var2[var12]) : var11;
         var7[var12] = var13 + 2.0F * var3;
      }

      return 16.0F * var3 + var8 + 29.0F * var3;
   }

   private static float v2(int var0, float[] var1, float var2, float[] var3, float[] var4, float[] var5, float[] var6) {
      float var7 = 12.0F * var2 + Math.max(24.0F * var2, v1(var0, var1));
      float var8 = var7 * 0.5F;
      float var9 = var8 - 24.0F * var2 * 0.5F;

      for (int var10 = 0; var10 < var0; var10++) {
         float var11 = 10.0F * var2 + var10 * 53.5F * var2;
         var3[var10] = var9;
         var4[var10] = var11;
         var5[var10] = var8 - var1[var10] * 0.5F;
         var6[var10] = var11 + 25.14F * var2;
      }

      return var7;
   }

   public static float v1(RowSupport.Part2 var0, int var1, float var2) {
      if (var1 > 0 && var0 != RowSupport.Part2.ROW) {
         float var3 = var0 == RowSupport.Part2.COLUMN ? 40.5F : 24.0F;
         return (20.0F + var1 * var3 + (var1 - 1) * 13.0F) * var2;
      } else {
         return 36.0F * var2;
      }
   }

   public static float v1(float var0, float var1) {
      return 20.0F * var1 + var0;
   }

   public static float v1(int var0, float[] var1, float var2) {
      return var1[var0] - 7.0F * var2;
   }

   public static float v1(float var0, float var1, float var2) {
      return Math.min(Math.min(var0, var1) * 0.5F, 18.0F * var2);
   }

   private static float v1(int var0, float[] var1) {
      float var2 = 0.0F;

      for (int var3 = 0; var3 < var0; var3++) {
         var2 = Math.max(var2, var1[var3]);
      }

      return var2;
   }

   public static enum Part1 implements hudSupport64 {
      LEFT("Left"),
      RIGHT("Right");

      private final String label;

      private Part1(String var3) {
         this.label = var3;
      }

      @Override
      public String v1() {
         return this.label;
      }
   }

   public static enum Part2 implements hudSupport64 {
      ROW("Row"),
      LIST("List"),
      COLUMN("Column");

      private final String label;

      private Part2(String var3) {
         this.label = var3;
      }

      @Override
      public String v1() {
         return this.label;
      }
   }
}
