package cc.syky.ui;

import java.util.Arrays;
import net.minecraft.class_2477;
import net.minecraft.class_304;
import net.minecraft.class_315;
import net.minecraft.class_332;
import net.minecraft.class_3675;
import net.minecraft.class_3675.class_306;
import net.minecraft.class_3675.class_307;
import org.jetbrains.annotations.Nullable;

public final class uiSupport181 {
   private static final String v5 = "syky_sans";
   private static final int v6 = 9;
   private static final int v7 = 20;
   private static final int v8 = 16;
   private static final int v9 = 90;
   private static final int v10 = 2;
   private static final int v11 = 3;
   private static final float v12 = 1.0F;
   private static final float v13 = 14.0F;
   private static final float v14 = 0.96F;
   private static final float v15 = 0.8F;
   private static final float v16 = 1.0F;
   private static final float v18 = 0.75F;
   public static boolean v1 = false;
   public static uiSupport182 v2 = uiSupport182.TOP_LEFT;
   public static float v3 = 8.0F;
   public static int v4 = -1;
   private static final String[] v19 = new String[9];
   private static final String[] v17 = new String[9];
   private static boolean v20;
   private static int v21;
   private static int v22;
   @Nullable
   private static class_2477 v24;

   private uiSupport181() {
   }

   public static void v1(class_332 var0) {
      v21 = var0.method_51421() / 2;
      v22 = var0.method_51443() - 16 - 3;
      v20 = true;
   }

   public static void v1(class_315 var0) {
      if (v20) {
         v20 = false;
         if (v1 && var0 != null) {
            v1();
            class_304[] var1 = var0.field_1852;
            int var2 = Math.min(9, var1.length);
            int var3 = (int)((v4 >>> 24) * 0.75F) << 24;
            float var4 = v1(var1, var2);
            if (!(var4 <= 0.0F)) {
               uiSupport169.v1(null);

               try {
                  for (int var5 = 0; var5 < var2; var5++) {
                     String var6 = v1(var5, var1[var5]);
                     if (var6 != null) {
                        int var7 = v21 - 90 + var5 * 20 + 2;
                        float var8 = uiSupport169.v2("syky_sans", var6, var4);
                        float var9 = 0.8F * var4;

                        float var10 = switch (v2) {
                           case TOP_LEFT, BOTTOM_LEFT -> var7 + 1.0F;
                           case TOP_RIGHT, BOTTOM_RIGHT -> var7 + 16 - 1.0F - var8;
                           case CENTER -> var7 + (16.0F - var8) / 2.0F;
                        };

                        float var11 = switch (v2) {
                           case TOP_LEFT, TOP_RIGHT -> v22 + 1.0F;
                           case BOTTOM_LEFT, BOTTOM_RIGHT -> v22 + 16 - 1.0F - var9;
                           case CENTER -> v22 + (16.0F - var9) / 2.0F;
                        };
                        float var12 = var11 - 0.15999997F * var4;
                        uiSupport169.v1("syky_sans", var6, var10 + 1.0F, var12 + 1.0F, var4, var3);
                        uiSupport169.v1("syky_sans", var6, var10, var12, var4, v4);
                     }
                  }
               } finally {
                  uiSupport169.v15();
               }
            }
         }
      }
   }

   private static float v1(class_304[] var0, int var1) {
      float var2 = 0.0F;

      for (int var3 = 0; var3 < var1; var3++) {
         String var4 = v1(var3, var0[var3]);
         if (var4 != null) {
            var2 = Math.max(var2, uiSupport169.v2("syky_sans", var4, v3));
         }
      }

      if (var2 <= 0.0F) {
         return 0.0F;
      } else {
         return var2 > 14.0F ? v3 * (14.0F / var2) : v3;
      }
   }

   private static void v1() {
      class_2477 var0 = class_2477.method_10517();
      if (var0 != v24) {
         v24 = var0;
         Arrays.fill(v17, null);
      }
   }

   @Nullable
   private static String v1(int var0, class_304 var1) {
      if (var1.method_1415()) {
         v17[var0] = null;
         v19[var0] = null;
         return null;
      } else {
         String var2 = var1.method_1428();
         if (!var2.equals(v17[var0])) {
            v17[var0] = var2;
            v19[var0] = v1(class_3675.method_15981(var2));
         }

         return v19[var0];
      }
   }

   @Nullable
   private static String v1(class_306 var0) {
      class_307 var1 = var0.method_1442();
      if (var1 == class_307.field_1672) {
         return NENSupport.v2(var0.method_1444());
      } else {
         if (var1 == class_307.field_1668) {
            String var2 = NENSupport.v1(var0.method_1444());
            if (var2 != null) {
               return var2;
            }
         }

         return NENSupport.v1(var0.method_27445().getString());
      }
   }
}
