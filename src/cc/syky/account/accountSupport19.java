package cc.syky.account;

import cc.syky.cloud.WinSupport;
import cc.syky.cloud.cloudSupport101;
import cc.syky.cloud.cloudSupport22;
import cc.syky.module.visual.visualSupport9;
import it.unimi.dsi.fastutil.ints.Int2ObjectOpenHashMap;
import it.unimi.dsi.fastutil.ints.Int2ObjectMap.Entry;
import it.unimi.dsi.fastutil.objects.ObjectIterator;
import net.minecraft.class_1657;
import net.minecraft.class_310;
import net.minecraft.class_3532;
import net.minecraft.class_638;
import net.minecraft.class_742;
import net.minecraft.class_746;
import org.jetbrains.annotations.Nullable;
import org.joml.Matrix4f;

public final class accountSupport19 {
   private static final float v9 = 0.62F;
   private static final float v10 = 2.5F;
   private static final float v11 = 9.0F;
   private static final float v12 = 6.0F;
   private static final float v13 = 7.0F;
   private static final float v14 = 0.55F;
   private static final float v15 = 0.12F;
   private static final float v16 = 1.1F;
   private static final float v18 = 0.22F;
   private static final float v19 = 0.18F;
   private static final int v17 = 15922943;
   private static final float v20 = 10.0F;
   private static final float v21 = 0.04F;
   private static final float v22 = 0.1F;
   public static final int v1 = 24;
   public static boolean v2;
   public static boolean v3 = true;
   public static boolean v4;
   public static int v5 = -7667916;
   public static int v6 = -62435;
   public static int v7 = -1;
   @Nullable
   public static cloudSupport101 v8;
   private static boolean v24;
   private static final double[] v25 = new double[24];
   private static final double[] v26 = new double[24];
   private static final double[] v27 = new double[24];
   private static final float[] v28 = new float[24];
   private static final float[] v29 = new float[24];
   private static final accountSupport19.Part2[] v30 = new accountSupport19.Part2[24];
   private static final long[] v32;
   private static int v23;
   private static final Int2ObjectOpenHashMap<accountSupport19.Part1> v33;
   private static final cloudSupport22 v31;
   private static long v34;
   private static final float v36;

   private accountSupport19() {
   }

   public static boolean v1() {
      return v23 > 0 || v2 && v24;
   }

   public static boolean v2() {
      if (v23 > 0) {
         return true;
      } else if (v2 && v24) {
         cloudSupport101 var0 = v8;
         class_310 var1 = var0 == null ? null : var0.v1();
         if (var1 == null) {
            return false;
         } else {
            class_638 var2 = var1.field_1687;
            class_746 var3 = var1.field_1724;
            if (var2 != null && var3 != null) {
               float var4 = var1.method_61966().method_60637(false);
               if (v3) {
                  if ((v7 == -1 ? null : var2.method_8469(v7)) instanceof class_1657 var6 && v1(var6, var3) && v1(var6, var4)) {
                     return true;
                  }
               } else {
                  for (class_742 var11 : var2.method_18456()) {
                     if (v1(var11, var3) && v1(var11, var4)) {
                        return true;
                     }
                  }
               }

               ObjectIterator var10 = v33.int2ObjectEntrySet().iterator();

               while (var10.hasNext()) {
                  Entry var12 = (Entry)var10.next();
                  if (var2.method_8469(var12.getIntKey()) instanceof class_1657 var7 && v1(var7, var4)) {
                     return true;
                  }
               }

               return false;
            } else {
               return false;
            }
         }
      } else {
         return false;
      }
   }

   private static boolean v1(class_1657 var0, float var1) {
      double var2 = class_3532.method_16436(var1, var0.field_6014, var0.method_23317());
      double var4 = class_3532.method_16436(var1, var0.field_6036, var0.method_23318());
      double var6 = class_3532.method_16436(var1, var0.field_5969, var0.method_23321());
      float var8 = v1(var2, var4, var6);
      return !Float.isNaN(var8) && v1(var2, var8, var6, 0.62F * Math.max(1.0F, var0.method_17681() / 0.6F) * v36);
   }

   public static void v1(int var0, double var1, double var3, double var5, float var7) {
      v1(var0, var1, var3, var5, var7, 1.0F);
   }

   public static void v1(int var0, double var1, double var3, double var5, float var7, float var8) {
      if (var0 >= 0 && var0 < 24) {
         v25[var0] = var1;
         v26[var0] = var3;
         v27[var0] = var5;
         v28[var0] = Math.max(-1.0F, Math.min(var7, 1.0F));
         v29[var0] = var8;
         if (var0 >= v23) {
            v32[var0] = System.nanoTime();
            v30[var0].v1(v1(var8));
            v23 = var0 + 1;
         }
      }
   }

   public static void v3() {
      v23 = 0;
   }

   public static void v1(@Nullable class_638 var0, @Nullable class_746 var1) {
      if (v2 && var0 != null && var1 != null) {
         boolean var2 = v3 ? v7 != -1 : var0.method_18456().size() > 1;
         v24 = var2 || !v33.isEmpty();
      } else {
         v24 = !v33.isEmpty();
      }
   }

   public static void v4() {
      v33.clear();
      v24 = false;
      v34 = 0L;
   }

   public static void v5() {
      long var0 = System.nanoTime();
      float var2 = v34 == 0L ? 0.0F : Math.min((float)(var0 - v34) / 1.0E9F, 0.1F);
      v34 = var0;
      Matrix4f var3 = accountSupport22.v3();
      cloudSupport101 var4 = v8;
      class_310 var5 = var4 == null ? null : var4.v1();
      if (var3 != null && var5 != null) {
         v31.v1();
         class_638 var6 = var5.field_1687;
         class_746 var7 = var5.field_1724;
         if (v2 && var6 != null && var7 != null) {
            v1(var6, var7, var5.method_61966().method_60637(false), var2);
         } else if (!v33.isEmpty()) {
            v33.clear();
         }

         for (int var8 = 0; var8 < v23; var8++) {
            float var9 = (float)(var0 - v32[var8]) / 1.0E9F;
            float var10 = Math.min(1.0F, var9 / 0.55F);
            float var11 = 1.0F - (float)Math.exp(-9.0F * var9);
            v30[var8].v1(v1(v29[var8]), var2);
            v31.v1(
               v25[var8], v26[var8], v27[var8], 0.62F * v1(var10, var11), v2(v28[var8]), var11 * v3(v28[var8]), var8 * 0.37F, v2(var10, var11), v30[var8].v1
            );
         }

         v24 = v31.v2() > 0 || !v33.isEmpty();
         if (v6()) {
            visualSupport9.v1(var3, visualSupport9.v12(), v31);
         }
      }
   }

   private static void v1(class_638 var0, class_746 var1, float var2, float var3) {
      ObjectIterator var4 = v33.values().iterator();

      while (var4.hasNext()) {
         accountSupport19.Part1 var5 = (accountSupport19.Part1)var4.next();
         var5.v8 = false;
      }

      float var10 = WinSupport.v2(var1.method_6032(), var1.method_6067());
      if (v3) {
         if ((v7 == -1 ? null : var0.method_8469(v7)) instanceof class_1657 var6 && v1(var6, var1)) {
            v2(var6, var10);
         }
      } else {
         for (class_742 var14 : var0.method_18456()) {
            if (v1(var14, var1)) {
               v2(var14, var10);
            }
         }
      }

      ObjectIterator var13 = v33.int2ObjectEntrySet().fastIterator();

      while (var13.hasNext()) {
         Entry var15 = (Entry)var13.next();
         accountSupport19.Part1 var7 = (accountSupport19.Part1)var15.getValue();
         if (var0.method_8469(var15.getIntKey()) instanceof class_1657 var9 && var9.method_5805()) {
            if (!var7.v8) {
               var7.v6 = 0.0F;
            }

            v1(var7, var3);
            if (var7.v1 <= 0.002F && var7.v6 == 0.0F) {
               var13.remove();
            } else {
               v1(var9, var7, var2);
            }
         } else {
            var13.remove();
         }
      }
   }

   private static boolean v1(class_1657 var0, class_746 var1) {
      return var0.method_5628() != var1.method_5628() && var0.method_5805() && !var0.method_7325() && !var0.method_5756(var1);
   }

   private static void v2(class_1657 var0, float var1) {
      accountSupport19.Part1 var2 = (accountSupport19.Part1)v33.get(var0.method_5628());
      if (var2 == null) {
         var2 = new accountSupport19.Part1();
         v33.put(var0.method_5628(), var2);
      }

      var2.v8 = true;
      float var3 = WinSupport.v2(var0.method_6032(), var0.method_6067());
      float var4 = WinSupport.v1(var1, var3);
      float var5 = v1(var3 / Math.max(var0.method_6063(), 1.0F));
      if (var2.v1 <= 0.002F) {
         var2.v2 = var4;
         var2.v3 = 0.0F;
         var2.v4.v1(var5);
      }

      var2.v7 = var4;
      var2.v5 = var5;
      var2.v6 = 1.0F;
   }

   private static void v1(accountSupport19.Part1 var0, float var1) {
      if (var0.v6 > 0.0F) {
         var0.v3 = Math.min(1.0F, var0.v3 + var1 / 0.55F);
      }

      float var2 = var0.v6 > var0.v1 ? 9.0F : 6.0F;
      var0.v1 = var0.v1 + (var0.v6 - var0.v1) * (1.0F - (float)Math.exp(-var2 * var1));
      var0.v2 = var0.v2 + (var0.v7 - var0.v2) * (1.0F - (float)Math.exp(-7.0F * var1));
      var0.v4.v1(var0.v5, var1);
   }

   private static float v1(float var0) {
      return v4 ? class_3532.method_15363(var0, 0.04F, 1.0F) : 1.0F;
   }

   private static void v1(class_1657 var0, accountSupport19.Part1 var1, float var2) {
      double var3 = class_3532.method_16436(var2, var0.field_6014, var0.method_23317());
      double var5 = class_3532.method_16436(var2, var0.field_6036, var0.method_23318());
      double var7 = class_3532.method_16436(var2, var0.field_5969, var0.method_23321());
      float var9 = 0.62F * Math.max(1.0F, var0.method_17681() / 0.6F) * v1(var1.v3, var1.v1);
      float var10 = v1(var3, var5, var7);
      if (!Float.isNaN(var10)) {
         float var11 = 1.0F - class_3532.method_15363((float)(var5 - var10) / 2.5F, 0.0F, 1.0F);
         int var12 = v2(var1.v2);
         float var13 = v3(var1.v2);
         float var14 = var0.method_5628() * 0.61803F % 1.0F;
         v31.v1(var3, var10, var7, var9, var12, var1.v1 * var11 * var13, var14, v2(var1.v3, var1.v1), var1.v4.v1);
      }
   }

   private static boolean v6() {
      int var0 = 0;

      for (int var1 = v31.v2(); var0 < var1; var0++) {
         if (v1(v31.v1(var0), v31.v2(var0), v31.v3(var0), v31.v4(var0))) {
            return true;
         }
      }

      return false;
   }

   private static boolean v1(double var0, double var2, double var4, float var6) {
      float var7 = var6 * 2.1F;
      float var8 = var6 * 0.9F;
      return visualSupport9.v2(var0 - var7, var2 - var8, var4 - var7, var0 + var7, var2 + var8 + 0.05, var4 + var7);
   }

   private static float v1(double var0, double var2, double var4) {
      float var6 = visualSupport9.v1(var0, var2 + 0.05, var4);
      return !Float.isNaN(var6) && !(1.0F - class_3532.method_15363((float)(var2 - var6) / 2.5F, 0.0F, 1.0F) <= 0.0F) ? var6 : Float.NaN;
   }

   private static float v7() {
      float var0 = 1.0F;

      for (int var1 = 0; var1 <= 1024; var1++) {
         var0 = Math.max(var0, v1(var1 / 1024.0F, 1.0F));
      }

      return var0 * 1.01F;
   }

   private static float v1(float var0, float var1) {
      float var2 = var0 - 1.0F;
      float var3 = 2.1F;
      float var4 = 1.0F + var3 * var2 * var2 * var2 + 1.1F * var2 * var2;
      return (0.12F + 0.88F * var4) * (1.0F - 0.22F * (1.0F - var1));
   }

   private static float v2(float var0, float var1) {
      return v1(0.35F, 1.0F, var0) * var1 * var1;
   }

   private static float v1(float var0, float var1, float var2) {
      float var3 = class_3532.method_15363((var2 - var0) / (var1 - var0), 0.0F, 1.0F);
      return var3 * var3 * (3.0F - 2.0F * var3);
   }

   private static int v2(float var0) {
      int var1 = var0 >= 0.0F ? v5 : v6;
      return v1(15922943, var1, 0.18F + 0.82F * Math.abs(var0));
   }

   private static float v3(float var0) {
      return ((var0 >= 0.0F ? v5 : v6) >>> 24) / 255.0F;
   }

   private static int v1(int var0, int var1, float var2) {
      return v2(var0 >>> 16, var1 >>> 16, var2) << 16 | v2(var0 >>> 8, var1 >>> 8, var2) << 8 | v2(var0, var1, var2);
   }

   private static int v2(int var0, int var1, float var2) {
      float var3 = var0 & 0xFF;
      return Math.round(var3 + ((var1 & 0xFF) - var3) * var2);
   }

   static {
      for (int var0 = 0; var0 < 24; var0++) {
         v30[var0] = new accountSupport19.Part2();
      }

      v32 = new long[24];
      v33 = new Int2ObjectOpenHashMap();
      v31 = new cloudSupport22();
      v36 = v7();
   }

   public static final class Part1 {
      public float v1;
      public float v2;
      public float v3;
      public final accountSupport19.Part2 v4 = new accountSupport19.Part2();
      public float v5 = 1.0F;
      public float v6;
      public float v7;
      public boolean v8;

      public Part1() {
      }
   }

   public static final class Part2 {
      public float v1 = 1.0F;
      private float v2;

      public Part2() {
      }

      public void v1(float var1) {
         this.v1 = var1;
         this.v2 = 0.0F;
      }

      public void v1(float var1, float var2) {
         float var3 = this.v1 - var1;
         float var4 = (this.v2 + 10.0F * var3) * var2;
         float var5 = (float)Math.exp(-10.0F * var2);
         this.v2 = (this.v2 - 10.0F * var4) * var5;
         this.v1 = class_3532.method_15363(var1 + (var3 + var4) * var5, 0.0F, 1.0F);
      }
   }
}
