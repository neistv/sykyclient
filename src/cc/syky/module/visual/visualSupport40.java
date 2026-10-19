package cc.syky.module.visual;

import it.unimi.dsi.fastutil.ints.Int2LongOpenHashMap;

public final class visualSupport40 {
   public static boolean v1;
   public static boolean v2;
   public static float v3 = 1.0F;
   public static float v4;
   public static float v5 = 1.0F;
   public static boolean v6;
   public static int v7 = -1711325120;
   public static boolean v8 = true;
   public static final int v9 = 14;
   public static final int v10 = -1;
   public static final Int2LongOpenHashMap v11 = new Int2LongOpenHashMap();
   public static boolean v12;
   public static int v13 = -1;
   public static boolean v14;
   public static float v15;
   private static final long v16 = 1600000000L;

   private visualSupport40() {
   }

   public static boolean v1() {
      return v1 || v2;
   }

   public static float v2() {
      return v2 ? 1.0F : v15;
   }

   private static float v5() {
      float var0 = (float)(System.nanoTime() % 1600000000L) / 1.6E9F;
      return var0 < 0.5F ? 1.0F : 0.0F;
   }

   public static int v3() {
      float var0 = v2();
      if (!v1() && var0 <= 0.001F) {
         return -1;
      } else if (!v12) {
         return -1;
      } else {
         float var1 = 1.0F + (v3 - 1.0F) * var0;
         int var2 = Math.round(var1 * 255.0F);
         if (var2 < 0) {
            var2 = 0;
         } else if (var2 >= 255) {
            return -1;
         }

         return var2 << 24 | 16777215;
      }
   }

   public static int v4() {
      float var0 = v2();
      if (!v1() && var0 <= 0.001F) {
         return -1;
      } else if (!v8) {
         return -1;
      } else if (v12) {
         if (v2) {
            return v1(v5(), 14);
         } else {
            return v1 && v6 ? v1(var0, 14) : -1;
         }
      } else {
         return v13 == -1 ? -1 : v1(1.0F, v13);
      }
   }

   private static int v1(float var0, int var1) {
      int var2 = (int)(Math.max(0.0F, Math.min(1.0F, var0)) * 15.0F);
      return var2 <= 0 ? -1 : var2 | var1 << 16;
   }

   public static int v1(int var0, int var1) {
      if (!v8) {
         return -1;
      } else if (var0 == var1) {
         return v6 ? 14 : -1;
      } else {
         return !v11.isEmpty() && v11.containsKey(var0) ? 14 : -1;
      }
   }
}
