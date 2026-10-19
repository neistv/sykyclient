package cc.syky.ui;

import java.util.Arrays;

public final class uiSupport49 {
   private static final int[] v1 = v5();
   private static int v2;
   private static final float[] v3 = v4();
   private static boolean v4;

   private uiSupport49() {
   }

   private static float[] v4() {
      float[] var0 = new float[uiSupport47.values().length];
      Arrays.fill(var0, 1.0F);
      return var0;
   }

   private static int[] v5() {
      uiSupport47[] var0 = uiSupport47.values();
      int[] var1 = new int[var0.length];

      for (int var2 = 0; var2 < var0.length; var2++) {
         var1[var2] = var0[var2].v1();
      }

      return var1;
   }

   public static int v1(uiSupport47 var0) {
      return v1[var0.ordinal()];
   }

   public static void v1(uiSupport47 var0, int var1) {
      int var2 = var1 & 16777215;
      if (v1[var0.ordinal()] != var2) {
         v1[var0.ordinal()] = var2;
         v2++;
      }
   }

   public static int v1() {
      return v2;
   }

   public static void v2() {
      System.arraycopy(v5(), 0, v1, 0, v1.length);
      Arrays.fill(v3, 1.0F);
      v4 = false;
      v2++;
   }

   public static void v1(uiSupport47 var0, float var1) {
      float var2 = Math.max(0.0F, var1);
      if (v3[var0.ordinal()] != var2) {
         v3[var0.ordinal()] = var2;
         v2++;
      }
   }

   public static boolean v3() {
      return v4;
   }

   public static void v1(boolean var0) {
      if (var0 != v4) {
         v4 = var0;
         v2++;
      }
   }

   public static int v2(uiSupport47 var0, int var1) {
      float var2 = v3[var0.ordinal()];
      int var3 = var2 == 1.0F ? var1 : Math.min(255, Math.round(var1 * var2));
      return var3 << 24 | v1(var0);
   }

   public static int v2(uiSupport47 var0, float var1) {
      return v2(var0, Math.round(Math.max(0.0F, Math.min(1.0F, var1)) * 255.0F));
   }

   public static int v2(uiSupport47 var0) {
      return v2(var0, 255);
   }
}
