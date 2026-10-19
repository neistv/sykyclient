package cc.syky.account;

import cc.syky.cloud.cloudSupport101;
import cc.syky.module.visual.visualSupport53;
import cc.syky.module.visual.visualSupport9;
import cc.syky.render.renderSupport7;
import it.unimi.dsi.fastutil.ints.Int2ObjectOpenHashMap;
import it.unimi.dsi.fastutil.ints.Int2ObjectMap.Entry;
import it.unimi.dsi.fastutil.objects.ObjectIterator;
import java.util.Arrays;
import net.minecraft.class_1297;
import net.minecraft.class_1542;
import net.minecraft.class_1657;
import net.minecraft.class_1814;
import net.minecraft.class_310;
import net.minecraft.class_3532;
import net.minecraft.class_638;
import org.jetbrains.annotations.Nullable;
import org.joml.Matrix4f;

public final class accountSupport18 {
   private static final double v7 = 64.0;
   private static final double v8 = 52.0;
   private static final int v9 = 160;
   private static final double v10 = 0.8;
   private static final double v11 = 0.6;
   private static final float v12 = 4.0F;
   private static final float v13 = 8.0F;
   private static final float v14 = 6.0F;
   private static final float v15 = 0.7F;
   private static final int v16 = 16765803;
   private static final int v18 = 7332863;
   private static final int v19 = 11894015;
   private static final double v17 = 0.7;
   private static final float v20 = 0.1F;
   public static final int v1 = 64;
   public static boolean v2;
   public static int v3 = -1642753;
   public static boolean v4 = true;
   public static float v5 = 3.0F;
   @Nullable
   public static cloudSupport101 v6;
   private static final visualSupport53<class_1542> v21 = new visualSupport53(160);
   private static final visualSupport53.Part1<class_1542> v22 = new visualSupport53.Part1<class_1542>() {
      @Nullable
      public class_1542 v1(class_1297 var1, class_1657 var2) {
         return var1 instanceof class_1542 var3 ? var3 : null;
      }

      public boolean v1(class_1542 var1, double var2) {
         return var2 < 4096.0 && accountSupport18.v1(var1) && !var1.method_6983().method_7960();
      }
   };
   private static final class_1542[] v24 = new class_1542[64];
   private static final double[] v25 = new double[64];
   private static final double[] v26 = new double[64];
   private static final double[] v27 = new double[64];
   private static final int[] v28 = new int[64];
   private static final boolean[] v29 = new boolean[64];
   private static final double[] v30 = new double[64];
   private static final double[] v32 = new double[64];
   private static final double[] v23 = new double[64];
   private static final int[] v33 = new int[64];
   private static final long[] v31 = new long[64];
   private static int v34;
   private static final Int2ObjectOpenHashMap<accountSupport18.Part1> v36 = new Int2ObjectOpenHashMap();
   private static final renderSupport7 v38 = new renderSupport7();
   private static long v42;

   private accountSupport18() {
   }

   public static boolean v1() {
      return v34 > 0 || v2 && !v36.isEmpty();
   }

   public static boolean v2() {
      if (v34 > 0) {
         return true;
      } else if (v2 && !v36.isEmpty() && v3 >>> 24 != 0) {
         ObjectIterator var0 = v36.values().iterator();

         while (var0.hasNext()) {
            accountSupport18.Part1 var1 = (accountSupport18.Part1)var0.next();
            if (v1(var1.v1, var1.v2, var1.v3)) {
               return true;
            }
         }

         return false;
      } else {
         return false;
      }
   }

   public static void v1(int var0, double var1, double var3, double var5, int var7) {
      if (var0 >= 0 && var0 < 64) {
         v30[var0] = var1;
         v32[var0] = var3;
         v23[var0] = var5;
         v33[var0] = var7;
         if (var0 >= v34) {
            v31[var0] = System.nanoTime();
            v34 = var0 + 1;
         }
      }
   }

   public static void v3() {
      v34 = 0;
   }

   public static void v4() {
      v36.clear();
      v21.v1();
      Arrays.fill(v24, null);
      v42 = 0L;
   }

   public static void v1(@Nullable class_310 var0) {
      ObjectIterator var1 = v36.values().iterator();

      while (var1.hasNext()) {
         accountSupport18.Part1 var2 = (accountSupport18.Part1)var1.next();
         var2.v5 = 0.0F;
      }

      if (v2 && v21.v1(var0, v22)) {
         int var6 = v6();

         for (int var7 = 0; var7 < var6; var7++) {
            class_1542 var3 = v24[var7];
            accountSupport18.Part1 var4 = (accountSupport18.Part1)v36.get(var3.method_5628());
            if (var4 == null) {
               if (v36.isEmpty()) {
                  v42 = 0L;
               }

               var4 = new accountSupport18.Part1();
               var4.v1 = var3.method_23317();
               var4.v2 = var3.method_23318();
               var4.v3 = var3.method_23321();
               v36.put(var3.method_5628(), var4);
            }

            if (var4.v4 <= 0.002F) {
               int var5 = v1(v28[var7]);
               var4.v7 = var5 >>> 16 & 0xFF;
               var4.v8 = var5 >>> 8 & 0xFF;
               var4.v9 = var5 & 0xFF;
               var4.v6 = 0.0F;
            }

            var4.v10 = v28[var7];
            var4.v5 = 1.0F;
         }

         Arrays.fill(v24, 0, var6, null);
      }
   }

   private static int v6() {
      int var0 = 0;
      int var1 = 0;

      for (int var2 = v21.v2(); var1 < var2; var1++) {
         class_1542 var3 = (class_1542)v21.v1(var1);
         if (!var3.method_31481()) {
            int var4 = v2(var3);
            boolean var5 = v36.containsKey(var3.method_5628());
            int var6 = 0;

            while (
               var6 < var0
                  && (
                     !(Math.abs(var3.method_23317() - v25[var6]) < 0.8)
                        || !(Math.abs(var3.method_23321() - v27[var6]) < 0.8)
                        || !(Math.abs(var3.method_23318() - v26[var6]) < 0.6)
                  )
            ) {
               var6++;
            }

            if (var6 < var0) {
               v28[var6] = Math.max(v28[var6], var4);
               if (var5 && !v29[var6]) {
                  v24[var6] = var3;
                  v29[var6] = true;
               }
            } else if (var0 != 64) {
               v24[var0] = var3;
               v25[var0] = var3.method_23317();
               v26[var0] = var3.method_23318();
               v27[var0] = var3.method_23321();
               v28[var0] = var4;
               v29[var0] = var5;
               var0++;
            }
         }
      }

      return var0;
   }

   public static void v5() {
      long var0 = System.nanoTime();
      float var2 = v42 == 0L ? 0.0F : Math.min((float)(var0 - v42) / 1.0E9F, 0.1F);
      v42 = var0;
      Matrix4f var3 = accountSupport22.v3();
      cloudSupport101 var4 = v6;
      class_310 var5 = var4 == null ? null : var4.v1();
      if (var3 != null && var5 != null) {
         v38.v1();
         class_638 var6 = var5.field_1687;
         if (v2 && var6 != null) {
            v1(var6, var5.method_61966().method_60637(false), var2);
         } else if (!v36.isEmpty()) {
            v36.clear();
         }

         float var7 = (v3 >>> 24) / 255.0F;

         for (int var8 = 0; var8 < v34; var8++) {
            float var9 = (float)(var0 - v31[var8]) / 1.0E9F;
            float var10 = 1.0F - (float)Math.exp(-4.0F * var9);
            v38.v1(v30[var8], v32[var8], v23[var8], v5 * v1(var9 / 0.7F), v1(v33[var8]), var10 * var7, var8 * 0.61803F % 1.0F);
         }

         if (v38.v2() > 0) {
            visualSupport9.v1(var3, visualSupport9.v12(), v38);
         }
      }
   }

   private static void v1(class_638 var0, float var1, float var2) {
      double var3 = visualSupport9.v7();
      double var5 = visualSupport9.v8();
      double var7 = visualSupport9.v9();
      float var9 = (v3 >>> 24) / 255.0F;
      ObjectIterator var10 = v36.int2ObjectEntrySet().fastIterator();

      while (var10.hasNext()) {
         Entry var11 = (Entry)var10.next();
         accountSupport18.Part1 var12 = (accountSupport18.Part1)var11.getValue();
         if (var0.method_8469(var11.getIntKey()) instanceof class_1542 var13 && !var13.method_31481()) {
            var12.v1 = class_3532.method_16436(var1, var13.field_6014, var13.method_23317());
            var12.v2 = class_3532.method_16436(var1, var13.field_6036, var13.method_23318());
            var12.v3 = class_3532.method_16436(var1, var13.field_5969, var13.method_23321());
         } else {
            var12.v5 = 0.0F;
         }

         v1(var12, var2);
         if (var12.v4 <= 0.002F && var12.v5 == 0.0F) {
            var10.remove();
         } else if (v1(var12.v1, var12.v2, var12.v3)) {
            double var24 = var12.v1 - var3;
            double var15 = var12.v2 - var5;
            double var17 = var12.v3 - var7;
            double var19 = Math.sqrt(var24 * var24 + var15 * var15 + var17 * var17);
            float var21 = 1.0F - v1(52.0F, 64.0F, (float)var19);
            int var22 = Math.round(var12.v7) << 16 | Math.round(var12.v8) << 8 | Math.round(var12.v9);
            float var23 = var11.getIntKey() * 0.61803F % 1.0F;
            v38.v1(var12.v1, var12.v2, var12.v3, v5 * v1(var12.v6), var22, var12.v4 * var21 * var9, var23 < 0.0F ? var23 + 1.0F : var23);
         }
      }
   }

   private static void v1(accountSupport18.Part1 var0, float var1) {
      if (var0.v5 > 0.0F) {
         var0.v6 = Math.min(1.0F, var0.v6 + var1 / 0.7F);
      }

      float var2 = var0.v5 > var0.v4 ? 4.0F : 8.0F;
      var0.v4 = var0.v4 + (var0.v5 - var0.v4) * (1.0F - (float)Math.exp(-var2 * var1));
      int var3 = v1(var0.v10);
      float var4 = 1.0F - (float)Math.exp(-6.0F * var1);
      var0.v7 = var0.v7 + ((var3 >>> 16 & 0xFF) - var0.v7) * var4;
      var0.v8 = var0.v8 + ((var3 >>> 8 & 0xFF) - var0.v8) * var4;
      var0.v9 = var0.v9 + ((var3 & 0xFF) - var0.v9) * var4;
   }

   private static float v1(float var0) {
      float var1 = 1.0F - class_3532.method_15363(var0, 0.0F, 1.0F);
      return 1.0F - var1 * var1 * var1;
   }

   public static boolean v1(class_1542 var0) {
      return var0.method_24828() || var0.method_5799();
   }

   private static int v2(class_1542 var0) {
      return var0.method_6983().method_7932().ordinal();
   }

   private static int v1(int var0) {
      if (!v4 || var0 <= class_1814.field_8906.ordinal()) {
         return v3 & 16777215;
      } else if (var0 == class_1814.field_8907.ordinal()) {
         return 16765803;
      } else {
         return var0 == class_1814.field_8903.ordinal() ? 7332863 : 11894015;
      }
   }

   private static boolean v1(double var0, double var2, double var4) {
      return visualSupport9.v2(var0 - 0.7, var2 - 0.1, var4 - 0.7, var0 + 0.7, var2 + Math.max(v5, 1.0F), var4 + 0.7);
   }

   private static float v1(float var0, float var1, float var2) {
      float var3 = class_3532.method_15363((var2 - var0) / (var1 - var0), 0.0F, 1.0F);
      return var3 * var3 * (3.0F - 2.0F * var3);
   }

   public static final class Part1 {
      public double v1;
      public double v2;
      public double v3;
      public float v4;
      public float v5;
      public float v6;
      public float v7;
      public float v8;
      public float v9;
      public int v10;

      public Part1() {
      }
   }
}
