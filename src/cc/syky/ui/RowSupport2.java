package cc.syky.ui;

import cc.syky.hud.hudSupport64;

public final class RowSupport2 {
   public static final float v1 = 42.0F;
   public static final float v2 = 10.0F;
   public static final float v3 = 29.0F;
   public static final float v4 = 4.0F;
   public static final float v5 = 6.0F;
   public static final float v6 = 30.0F;
   public static final float v7 = 3.0F;
   public static final float v8 = 35.0F;
   public static final float v9 = 20.0F;
   public static final float v10 = 13.0F;
   public static final float v11 = 0.71875F;
   public static final float v12 = 9.34375F;
   public static final float v13 = 6.0F;
   public static final float v14 = 10.0F;
   public static final float v15 = 4.0F;
   public static final float v16 = 8.0F;
   public static final float v18 = 22.0F;
   public static final float v19 = 26.0F;
   public static final float v17 = 7.0F;
   public static final float v20 = 12.0F;
   public static final float v21 = 29.0F;
   public static final float v22 = 11.0F;
   public static final float v24 = 8.0F;
   public static final float v25 = 22.0F;
   public static final float v26 = 8.0F;

   public static float v1(RowSupport2.Part2 var0) {
      return switch (var0) {
         case SLOTS, COLUMN -> 1.0F;
         case LIST, ROW -> 1.3F;
      };
   }

   private RowSupport2() {
   }

   public static boolean v2(RowSupport2.Part2 var0) {
      return var0 != RowSupport2.Part2.SLOTS;
   }

   public static float v3(RowSupport2.Part2 var0) {
      return switch (var0) {
         case SLOTS -> 0.0F;
         case LIST, ROW -> 8.0F;
         case COLUMN -> 12.0F;
      };
   }

   public static float v4(RowSupport2.Part2 var0) {
      return switch (var0) {
         case SLOTS -> 29.0F;
         case LIST -> 22.0F;
         case COLUMN -> 29.0F;
         case ROW -> 22.0F;
      };
   }

   public static boolean v5(RowSupport2.Part2 var0) {
      return var0 == RowSupport2.Part2.LIST || var0 == RowSupport2.Part2.COLUMN;
   }

   public static float v1(RowSupport2.Part2 var0, float var1, float var2) {
      return switch (var0) {
         case SLOTS -> 42.0F * var2;
         case LIST -> 22.0F * var2;
         case COLUMN -> v2(var1, var2);
         case ROW -> v1(var1, var2);
      };
   }

   public static float v1(RowSupport2.Part2 var0, float var1) {
      return switch (var0) {
         case SLOTS -> 6.0F * var1;
         case LIST -> 4.0F * var1;
         case COLUMN -> 11.0F * var1;
         case ROW -> 8.0F * var1;
      };
   }

   public static float v2(RowSupport2.Part2 var0, float var1) {
      return v5(var0) ? 6.0F * var1 : v3(var0) * var1;
   }

   public static float v1(RowSupport2.Part2 var0, int var1, float var2, float var3) {
      return var1 <= 0 ? 0.0F : var1 * v1(var0, var2, var3) + v1(var1, v1(var0, var3));
   }

   public static float v1(RowSupport2.Part2 var0, float var1, float var2, float var3) {
      return switch (var0) {
         case SLOTS -> var1;
         case LIST -> 16.0F * var3 + 22.0F * var3 + v5(var2, 7.0F * var3);
         case COLUMN -> 24.0F * var3 + Math.max(29.0F * var3, var2);
         case ROW -> 16.0F * var3 + var1;
      };
   }

   public static float v2(RowSupport2.Part2 var0, float var1, float var2, float var3) {
      return switch (var0) {
         case SLOTS -> var1 <= 0.0F ? 0.0F : 42.0F * var3;
         case LIST -> 12.0F * var3 + var1;
         case COLUMN -> 6.0F * var3 + var1 + v4(var2, var3);
         case ROW -> 6.0F * var3 + 22.0F * var3 + v3(var2, var3) + v4(var2, var3);
      };
   }

   public static float v3(RowSupport2.Part2 var0, float var1, float var2, float var3) {
      return var0 == RowSupport2.Part2.SLOTS ? 10.0F * var3 : Math.min(20.0F * var3, Math.min(var1, var2) * 0.5F);
   }

   public static void v1(
      RowSupport2.Part2 var0,
      RowSupport2.Part1 var1,
      int var2,
      float var3,
      float[] var4,
      float[] var5,
      float var6,
      float[] var7,
      float[] var8,
      float[] var9,
      float[] var10
   ) {
      switch (var0) {
         case SLOTS:
            v1(var2, var5, var6, var7, var8);
            break;
         case LIST:
            v1(var1, var2, var3, var4, var5, var6, var7, var8, var9, var10);
            break;
         case COLUMN:
            v1(var2, var3, var4, var5, var6, var7, var8, var9, var10);
            break;
         case ROW:
            v2(var2, var3, var4, var5, var6, var7, var8, var9, var10);
      }
   }

   private static void v1(int var0, float[] var1, float var2, float[] var3, float[] var4) {
      for (int var5 = 0; var5 < var0; var5++) {
         var3[var5] = var1[var5] + 6.5F * var2;
         var4[var5] = 4.0F * var2;
      }
   }

   private static void v1(
      RowSupport2.Part1 var0, int var1, float var2, float[] var3, float[] var4, float var5, float[] var6, float[] var7, float[] var8, float[] var9
   ) {
      float var10 = 8.0F * var5;
      float var11 = v5(var2, 7.0F * var5);
      boolean var12 = var0 == RowSupport2.Part1.LEFT;
      float var13 = var12 ? var10 + var11 : var10;
      float var14 = var12 ? var10 : var10 + 22.0F * var5 + 7.0F * var5;

      for (int var15 = 0; var15 < var1; var15++) {
         var6[var15] = var13;
         var7[var15] = 6.0F * var5 + var4[var15];
         var8[var15] = var14 + (var2 - var3[var15]);
         var9[var15] = var7[var15] + (22.0F * var5 - 9.34375F * var5) * 0.5F;
      }
   }

   private static void v1(int var0, float var1, float[] var2, float[] var3, float var4, float[] var5, float[] var6, float[] var7, float[] var8) {
      float var9 = v1(RowSupport2.Part2.COLUMN, 0.0F, var1, var4) * 0.5F;

      for (int var10 = 0; var10 < var0; var10++) {
         var5[var10] = var9 - 29.0F * var4 * 0.5F;
         var6[var10] = 6.0F * var4 + var3[var10];
         var7[var10] = var9 - var2[var10] * 0.5F;
         var8[var10] = var6[var10] + 33.0F * var4;
      }
   }

   private static void v2(int var0, float var1, float[] var2, float[] var3, float var4, float[] var5, float[] var6, float[] var7, float[] var8) {
      float var9 = v1(var1, var4);
      float var10 = 6.0F * var4 + 26.0F * var4;

      for (int var11 = 0; var11 < var0; var11++) {
         float var12 = 8.0F * var4 + var3[var11] + var9 * 0.5F;
         var5[var11] = var12 - 22.0F * var4 * 0.5F;
         var6[var11] = 6.0F * var4;
         var7[var11] = var12 - var2[var11] * 0.5F;
         var8[var11] = var10;
      }
   }

   private static float v1(float var0, float var1) {
      return Math.max(22.0F * var1, var0);
   }

   private static float v2(float var0, float var1) {
      return 29.0F * var1 + v3(var0, var1);
   }

   private static float v3(float var0, float var1) {
      return var0 > 0.0F ? 13.34375F * var1 : 0.0F;
   }

   private static float v4(float var0, float var1) {
      return var0 > 0.0F ? 10.0F * var1 : 6.0F * var1;
   }

   private static float v5(float var0, float var1) {
      return var0 > 0.0F ? var0 + var1 : 0.0F;
   }

   private static float v1(int var0, float var1) {
      return Math.max(0, var0 - 1) * var1;
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
      SLOTS("Slots"),
      LIST("List"),
      COLUMN("Column"),
      ROW("Row");

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
