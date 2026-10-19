package cc.syky.internal;

import cc.syky.FogSupport2;
import cc.syky.cloud.cloudRecord6;
import cc.syky.cloud.cloudSupport42;
import cc.syky.cloud.cloudSupport44;
import cc.syky.cloud.cloudSupport50;
import cc.syky.cloud.cloudSupport51;
import cc.syky.cloud.cloudSupport69;
import cc.syky.module.visual.visualSupport9;
import cc.syky.ui.uiSupport167;
import cc.syky.ui.uiSupport168;
import cc.syky.ui.uiSupport256;
import cc.syky.ui.uiSupport258;
import cc.syky.ui.uiSupport260;
import java.util.ArrayDeque;
import java.util.Iterator;
import java.util.Map;
import java.util.UUID;
import java.util.Map.Entry;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;
import net.minecraft.class_10055;
import net.minecraft.class_1011;
import net.minecraft.class_10192;
import net.minecraft.class_11659;
import net.minecraft.class_11890;
import net.minecraft.class_1304;
import net.minecraft.class_1799;
import net.minecraft.class_1921;
import net.minecraft.class_238;
import net.minecraft.class_243;
import net.minecraft.class_310;
import net.minecraft.class_3532;
import net.minecraft.class_4587;
import net.minecraft.class_4588;
import net.minecraft.class_4608;
import net.minecraft.class_591;
import net.minecraft.class_630;
import net.minecraft.class_638;
import net.minecraft.class_742;
import net.minecraft.class_9334;
import net.minecraft.class_4587.class_4665;
import org.jetbrains.annotations.Nullable;
import org.joml.Matrix3fc;
import org.joml.Matrix4f;
import org.joml.Matrix4fc;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public final class InternalSupport38 {
   private static final Logger v1 = LoggerFactory.getLogger("syky.cosmetics");
   private static final uiSupport260 v2 = new uiSupport260("cosmetics.draw");
   private static final uiSupport260 v3 = new uiSupport260("cosmetics.emit");
   private static final long v4 = 30000000000L;
   private static final long v5 = 60000000000L;
   private static final long v6 = 5000000000L;
   private static final double v7 = 16.0;
   private static final double v8 = 32.0;
   private static final double v9 = 64.0;
   private static final double v10 = 0.25;
   private static final double v11 = 0.5;
   private static final double v12 = 2.0;
   private static final float v13 = 0.9375F;
   @Nullable
   private static InternalSupport60 v14;
   @Nullable
   private static InternalSupport57 v15;
   @Nullable
   private static uiSupport258 v16;
   private static long v18;
   private static long v19;
   private static long v17;
   private static boolean v20;
   private static long v21;
   @Nullable
   private static InternalSupport45 v22;
   @Nullable
   private static InternalSupport40 v24;
   @Nullable
   private static InternalSupport33 v25;
   private static final Map<UUID, uiSupport167> v26 = new ConcurrentHashMap<>();
   private static final Map<cloudSupport50, InternalSupport38.Part1> v27 = new ConcurrentHashMap<>();
   private static final ConcurrentLinkedQueue<InternalSupport38.Part2> v28 = new ConcurrentLinkedQueue<>();
   private static final ArrayDeque<InternalSupport38.Part1> v29 = new ArrayDeque<>();
   private static long v30;
   private static boolean v32;
   private static double v23;
   private static final double v33 = 1.3;
   private static final double v31 = 2.5;
   private static final double v34 = 0.25;
   private static final double v36 = 10.0;
   private static long v38;
   private static final double v42 = 0.1;
   private static double v43;
   private static double v37;
   private static double v48;
   private static long v40;
   private static boolean v44 = true;
   private static boolean v47;
   private static final Matrix4f v49 = new Matrix4f();
   private static final Matrix4f v46 = new Matrix4f();
   private static final Matrix4f v51 = new Matrix4f();
   private static final float v50 = (float) (Math.PI / 180.0);

   private InternalSupport38() {
   }

   public static void v1(InternalSupport60 var0, InternalSupport57 var1, uiSupport258 var2) {
      v14 = var0;
      v15 = var1;
      v16 = var2;
   }

   public static void v1() {
      FogSupport2.v1();
      if (v25 == null) {
         v25 = new InternalSupport33();
         visualSupport9.v1(v25);
      }
   }

   public static void v1(boolean var0) {
      v44 = var0;
   }

   public static boolean v2() {
      return v44;
   }

   public static void v2(boolean var0) {
      v47 = var0;
   }

   public static boolean v3() {
      return v47;
   }

   public static void v4() {
      v30++;
      v32 = true;
      class_310 var0 = class_310.method_1551();
      v23 = v1(var0);
      class_243 var1 = var0.field_1773.method_19418().method_71156();
      v43 = var1.field_1352;
      v37 = var1.field_1351;
      v48 = var1.field_1350;
      InternalSupport33 var2 = v25;
      if (var2 != null) {
         var2.v1();
      }
   }

   public static void v5() {
      v32 = false;
   }

   private static double v1(class_310 var0) {
      long var1 = System.nanoTime();
      long var3 = v38;
      v38 = var1;
      return var3 != 0L && var0.field_1687 != null && !var0.method_1493() ? v23 + Math.min((var1 - var3) / 1.0E9, 0.1) : v23;
   }

   public static void v1(class_11890 var0, class_10055 var1) {
      if (var1 instanceof InternalSupport39 var2) {
         var2.syky$wearer(null);
         var2.syky$motion(cloudSupport44.IDLE);
         InternalSupport60 var3 = v14;
         if (v44 && var3 != null) {
            UUID var4 = var0.method_5667();
            InternalSupport60.Part5 var5 = var3.v3(var4);
            if (var5 == null) {
               v26.remove(var4);
               if (var3.v1(var4)) {
                  var3.v1(var4, var0.method_5477().getString());
               }
            } else {
               uiSupport167 var6 = v26.get(var4);
               if (var6 == null || var6.v2.v2() != var5.v2()) {
                  var6 = v26.compute(
                     var4, (var1x, var2x) -> (uiSupport167)(var2x != null && var2x.v2.v2() == var5.v2() ? var2x : new uiSupport167(var1x, var5))
                  );
               }

               synchronized (var6) {
                  var6.v5 = System.nanoTime();
                  v1(var6, var0);
                  if (!v2(var6)) {
                     return;
                  }
               }

               var2.syky$wearer(var6);
               var2.syky$motion(v2(var0, var1));
            }
         }
      }
   }

   private static cloudSupport44 v2(class_11890 var0, class_10055 var1) {
      if (var0.method_5765()) {
         return cloudSupport44.IDLE;
      } else if (var1.field_53411) {
         return cloudSupport44.GLIDE;
      } else if (var1.field_53412) {
         return cloudSupport44.SWIM;
      } else if (var1.field_53410) {
         return cloudSupport44.SNEAK;
      } else {
         boolean var2 = var1.field_53451 > 0.1F;
         if (!var0.method_24828() && !var0.method_5799()) {
            return var0.method_5624() ? cloudSupport44.SPRINT : (var2 ? cloudSupport44.WALK : cloudSupport44.AIR);
         } else if (var2) {
            return var0.method_5624() ? cloudSupport44.SPRINT : cloudSupport44.WALK;
         } else {
            return cloudSupport44.IDLE;
         }
      }
   }

   private static void v1(uiSupport167 var0, class_11890 var1) {
      int var2 = var1.field_6012;
      if (var2 != var0.v11) {
         double var3 = var1.method_23318();
         double var5 = var3 - var0.v6;
         boolean var7 = var1.method_24828() || var1.method_5799() || var1.method_6128() || var1.method_5765();
         boolean var8 = var2 == var0.v11 + 1 && Math.abs(var5) <= 4.0;
         var0.v8 = var8 ? var0.v7 : var3;
         var0.v7 = var8 ? var0.v6 : var3;
         if (var7 || !var8 || var5 == 0.0) {
            var0.v9 = var3;
            var0.v10 = var3;
         } else if (var5 > 0.0) {
            var0.v10 = var3;
         } else {
            var0.v9 = var3;
         }

         var0.v6 = var3;
         var0.v11 = var2;
      }
   }

   private static double v1(uiSupport167 var0, double var1) {
      double var3 = v1(var0) / 10.0;
      double var5 = 0.25 * Math.max(-1.0, Math.min(1.0, var3)) + v1(var1 - var0.v9) - v1(var0.v10 - var1);
      return Double.isNaN(var5) ? 0.0 : var5;
   }

   private static double v1(uiSupport167 var0) {
      double var1 = var0.v6 - var0.v7;
      double var3 = var0.v7 - var0.v8;
      class_310 var5 = class_310.method_1551();
      float var6 = var5.method_61966().method_60637(false);
      float var7 = var5.field_1687 == null ? 20.0F : var5.field_1687.method_54719().method_54748();
      return (var3 + (var1 - var3) * var6) * var7;
   }

   private static double v1(double var0) {
      return Math.max(0.0, Math.min(1.0, (var0 - 1.3) / 1.2));
   }

   public static boolean v1(class_10055 var0) {
      return !(var0 instanceof InternalSupport39 var1 && var1.syky$wearer() != null && var1.syky$wearer().v1());
   }

   public static void v1(class_10055 var0, class_591 var1, class_4587 var2, class_11659 var3, int var4) {
      if (v44 && !var0.field_53333 && var0 instanceof InternalSupport39 var5) {
         uiSupport167 var6 = var5.syky$wearer();
         if (var6 != null) {
            long var7 = System.nanoTime();
            v20 = true;

            try {
               boolean var9 = cloudSupport69.v2();
               boolean var10 = v32 && !var9;
               boolean var11 = var10 && var6.v4 != v30;
               InternalSupport44 var12 = null;
               double var13 = 0.0;
               if (var11) {
                  var6.v4 = v30;
                  var13 = v1(var6, var0.field_53326);
                  InternalSupport44.v1(v46, var0.field_53446, var0.field_53325 - v43, var0.field_53326 - v37, var0.field_53327 - v48);
                  var12 = var6.v12;
                  var12.v1();
               }

               for (uiSupport167.Part1 var18 : var6.v3) {
                  uiSupport168 var19 = var18.v8;
                  if (var19 != null) {
                     if (var11 && var18.v1.v9()) {
                        var18.v2.v1(v23, var5.syky$motion(), var13);
                     }

                     v1(var18, var19, var0, var1, var2, var3, var4, var11, var10, var9, var12);
                     v1(var18, var19, var1, var2, var3, var4, var10, var9, var12);
                  }
               }

               if (var12 != null) {
                  var12.v1(var0.field_53465, var7);
               }

               v2.v1();
            } catch (Throwable var26) {
               v2.v1(var26);
            } finally {
               v20 = false;
               long var21 = System.nanoTime() - var7;
               v18 += var21;
               uiSupport258 var23 = v16;
               if (var23 != null) {
                  var23.v1("cosmetics.draw", var23.v3() - var21);
               }
            }
         }
      }
   }

   private static void v1(
      uiSupport167.Part1 var0,
      uiSupport168 var1,
      class_591 var2,
      class_4587 var3,
      class_11659 var4,
      int var5,
      boolean var6,
      boolean var7,
      @Nullable InternalSupport44 var8
   ) {
      uiSupport168.Part1[] var9 = var1.v8;
      cloudSupport51 var10 = null;

      for (int var11 = 0; var11 < var9.length; var11++) {
         uiSupport168.Part1 var12 = var9[var11];
         if (var12.v1() != var10) {
            if (var10 != null) {
               var3.method_22909();
            }

            var3.method_22903();
            v1(var2, var12.v1()).method_22703(var3);
            var10 = var12.v1();
            if (var8 != null) {
               var8.v1(v51.set(v46).mul(var3.method_23760().method_23761()), var0.v1.v10(), var10);
            }
         }

         int var13 = var12.v2();
         class_1921 var14 = var1.v5[var13];
         if (var14 != null) {
            uiSupport167.Part2 var15 = var0.v9[var11];
            var15.v1 = var5;
            var15.v2 = v23;
            (var1.v7[var13] ? var4.method_73529(1) : var4).method_73483(var3, var14, var15);
         }

         class_1921 var17 = var1.v6[var13];
         if (var17 != null && !var7) {
            if (var6) {
               class_4665 var16 = var3.method_23760();
               v1(var0, var11, true, var16.method_23761(), var16.method_23762(), v14().v1(var17), var5, v23);
            } else {
               uiSupport167.Part2 var18 = var0.v10[var11];
               var18.v1 = var5;
               var18.v2 = v23;
               var4.method_73529(2).method_73483(var3, var17, var18);
            }
         }
      }

      if (var10 != null) {
         var3.method_22909();
      }
   }

   private static void v1(
      uiSupport167.Part1 var0,
      uiSupport168 var1,
      class_10055 var2,
      class_591 var3,
      class_4587 var4,
      class_11659 var5,
      int var6,
      boolean var7,
      boolean var8,
      boolean var9,
      @Nullable InternalSupport44 var10
   ) {
      cloudSupport50.Part1 var11 = var0.v1.v7();
      if (var11 != null && var0.v3 != null && !v1(var2.field_53418)) {
         var4.method_22903();

         try {
            var3.field_3391.method_22703(var4);
            if (v2(var2.field_53418)) {
               var4.method_46416(0.0F, -0.053125F, 0.06875F);
            }

            if (var10 != null) {
               cloudRecord6 var12 = var11.v2();
               var10.v1(v51.set(v46).mul(var4.method_23760().method_23761()), 0.0F, var12.v7(), var12.v8(), var11.v1());
            }

            if (!v47) {
               float var25 = 6.0F + var2.field_53537 / 2.0F + var2.field_53536;
               float var13 = var2.field_53538 / 2.0F;
               var0.v3.v1(var25 * (float) (Math.PI / 180.0), var13 * (float) (Math.PI / 180.0), -var13 * (float) (Math.PI / 180.0));
               var0.v6 = cloudSupport42.v1(var0.v3, var11.v4(), var0.v5, var0.v4, true);
               var0.v7 = cloudSupport42.v1(var11.v2(), true);
            } else if (var7) {
               double var26 = var2.field_53325 - v43;
               double var14 = var2.field_53326 - v37;
               double var16 = var2.field_53327 - v48;
               double var18 = Math.sqrt(var26 * var26 + var14 * var14 + var16 * var16);
               if (var18 < 64.0) {
                  Matrix4f var20 = v49.set(var4.method_23760().method_23761());
                  var20.m30((float)(var20.m30() - var26));
                  var20.m31((float)(var20.m31() - var14));
                  var20.m32((float)(var20.m32() - var16));
                  int var21 = var18 < 16.0 ? 6 : (var18 < 32.0 ? 3 : 2);
                  var0.v3.v1(v23, var2.field_53325, var2.field_53326, var2.field_53327, var20, var21);
                  var0.v6 = cloudSupport42.v1(var0.v3, var11.v4(), var0.v5, var0.v4, false);
                  var0.v7 = cloudSupport42.v1(var11.v2(), false);
               }
            }

            int var27 = var11.v3();
            class_1921 var28 = var1.v5[var27];
            if (var28 != null) {
               var0.v11.v1 = var6;
               var0.v11.v2 = v23;
               (var1.v7[var27] ? var5.method_73529(1) : var5).method_73483(var4, var28, var0.v11);
            }

            class_1921 var29 = var1.v6[var27];
            if (var29 != null && !var9) {
               if (var8) {
                  class_4665 var15 = var4.method_23760();
                  v1(var0, -1, true, var15.method_23761(), var15.method_23762(), v14().v1(var29), var6, v23);
               } else {
                  var0.v12.v1 = var6;
                  var0.v12.v2 = v23;
                  var5.method_73529(2).method_73483(var4, var29, var0.v12);
               }
            }
         } finally {
            var4.method_22909();
         }
      }
   }

   private static InternalSupport33 v14() {
      InternalSupport33 var0 = v25;
      if (var0 == null) {
         var0 = new InternalSupport33();
         v25 = var0;
         visualSupport9.v1(var0);
      }

      return var0;
   }

   private static boolean v1(class_1799 var0) {
      return !var0.method_7960() && var0.method_57826(class_9334.field_54197);
   }

   private static boolean v2(class_1799 var0) {
      if (var0.method_7960()) {
         return false;
      } else {
         class_10192 var1 = (class_10192)var0.method_58694(class_9334.field_54196);
         return var1 != null && var1.comp_3174() == class_1304.field_6174 && var1.comp_3176().isPresent();
      }
   }

   private static class_630 v1(class_591 var0, cloudSupport51 var1) {
      return switch (var1) {
         case HEAD -> var0.field_3398;
         case BODY -> var0.field_3391;
         case RIGHT_ARM -> var0.field_3401;
         case LEFT_ARM -> var0.field_27433;
         case RIGHT_LEG -> var0.field_3392;
         case LEFT_LEG -> var0.field_3397;
      };
   }

   public static void v1(uiSupport167.Part1 var0, int var1, boolean var2, Matrix4fc var3, Matrix3fc var4, class_4588 var5, int var6, double var7) {
      uiSupport168 var9 = var0.v8;
      if (var9 != null) {
         long var10 = System.nanoTime();

         try {
            cloudSupport50 var12 = var0.v1;
            if (var1 >= 0) {
               uiSupport168.Part1 var27 = var9.v8[var1];
               uiSupport256 var14 = var12.v4();
               InternalSupport63 var15 = var0.v2.v1();

               for (int var19 : var27.v3()) {
                  Matrix4fc var20 = var15.v1(var14.v1(var19));
                  boolean var21 = (var20.properties() & 4) != 0;
                  v1(var5, var9, var12, var27.v2(), var3, var4, var21 ? null : var20, var14.v1(), var14.v3(var19), var14.v4(var19), var6, var2, var7);
               }

               v3.v1();
               return;
            }

            cloudSupport50.Part1 var13 = var12.v7();
            if (var13 != null) {
               v1(var5, var9, var12, var13.v3(), var3, var4, null, var0.v4, 0, var2 ? var0.v7 : var0.v6, var6, var2, var7);
               return;
            }
         } catch (Throwable var25) {
            v3.v1(var25);
            return;
         } finally {
            if (!v20) {
               v19 = v19 + (System.nanoTime() - var10);
            }

            v17++;
         }
      }
   }

   private static void v1(
      class_4588 var0,
      uiSupport168 var1,
      cloudSupport50 var2,
      int var3,
      Matrix4fc var4,
      Matrix3fc var5,
      @Nullable Matrix4fc var6,
      float[] var7,
      int var8,
      int var9,
      int var10,
      boolean var11,
      double var12
   ) {
      int var14 = var11 ? var2.v1(var3).v2() : var2.v1(var3).v3();
      float var15 = 0.0F;
      float var16 = 1.0F;
      if (var14 >= 0) {
         InternalSupport62 var17 = var2.v2(var14);
         var15 = InternalSupport41.v1(var17, var17.v1(var12));
         var16 = InternalSupport41.v1(var17);
      }

      int var19 = var11 ? -1 : var2.v1(var3).v6();
      int var18 = var11 ? var1.v4[var3] & 65535 : class_4608.field_21444;
      v21 += var9;
      InternalSupport41.v1(var0, var4, var5, var6, var7, var8, var9, var11 ? var1.v3[var3] : var1.v2[var3], var15, var16, var19, var10, var18, var11);
   }

   private static InternalSupport38.Part1 v1(cloudSupport50 var0) {
      InternalSupport38.Part1 var1 = v27.get(var0);
      if (var1 == null) {
         InternalSupport38.Part1 var2 = new InternalSupport38.Part1(var0);
         var1 = v27.putIfAbsent(var0, var2);
         if (var1 == null) {
            var1 = var2;
            v1(var2);
         }
      }

      var1.v4 = System.nanoTime();
      return var1;
   }

   private static boolean v2(uiSupport167 var0) {
      boolean var1 = true;

      for (uiSupport167.Part1 var5 : var0.v3) {
         InternalSupport38.Part1 var6 = v1(var5.v1);
         if (var6.v3) {
            var5.v8 = null;
         } else if (var6.v2 == null) {
            var1 = false;
         } else if (var5.v8 != var6.v2) {
            var5.v1(var6.v2);
         }
      }

      return var1;
   }

   private static void v15() {
      InternalSupport60 var0 = v14;
      class_638 var1 = class_310.method_1551().field_1687;
      if (v44 && var0 != null && var1 != null) {
         for (class_742 var3 : var1.method_18456()) {
            UUID var4 = var3.method_5667();
            if (var0.v1(var4)) {
               var0.v1(var4, var3.method_5477().getString());
            }

            InternalSupport60.Part5 var5 = var0.v3(var4);
            if (var5 != null) {
               for (cloudSupport50 var7 : var5.v1()) {
                  v1(var7);
               }
            }
         }
      }
   }

   public static class_238 v1(class_11890 var0, class_238 var1) {
      InternalSupport60 var2 = v14;
      if (v44 && var2 != null) {
         UUID var3 = var0.method_5667();
         uiSupport167 var4 = v26.get(var3);
         InternalSupport60.Part5 var5 = var4 != null ? var4.v2 : var2.v3(var3);
         if (var5 == null) {
            return var1;
         } else {
            float var6 = class_310.method_1551().method_61966().method_60637(true);
            double var7 = class_3532.method_16436(var6, var0.field_6038, var0.method_23317());
            double var9 = class_3532.method_16436(var6, var0.field_5971, var0.method_23318());
            double var11 = class_3532.method_16436(var6, var0.field_5989, var0.method_23321());
            float var13 = var0.method_55693();
            if (var4 != null && var4.v12.v2(var0.method_18376(), System.nanoTime())) {
               float var17 = class_3532.method_17821(var6, var0.field_6220, var0.field_6283);
               return var1.method_991(var4.v12.v1(var7, var9, var11, var17, Math.max(0.0, 0.25 * var13 - 0.5)));
            } else {
               float var14 = 0.0F;

               for (cloudSupport50 var16 : var5.v1()) {
                  var14 = Math.max(var14, var16.v11());
               }

               double var18 = Math.max(0.0, var13 * (2.0 + 0.9375F * var14) - 0.5);
               return var1.method_991(new class_238(var7 - var18, var9 - var18, var11 - var18, var7 + var18, var9 + var18, var11 + var18));
            }
         }
      } else {
         return var1;
      }
   }

   private static void v1(InternalSupport38.Part1 var0) {
      InternalSupport57 var1 = v15;
      Runnable var2 = () -> {
         cloudSupport50 var1x = var0.v1;
         class_1011[] var2x = new class_1011[var1x.v6()];

         try {
            for (int var3 = 0; var3 < var2x.length; var3++) {
               var2x[var3] = class_1011.method_49277(var1x.v2(var3).v3());
            }

            v28.add(new InternalSupport38.Part2(var0, var2x, null));
         } catch (Throwable var8) {
            for (class_1011 var7 : var2x) {
               if (var7 != null) {
                  var7.close();
               }
            }

            v28.add(new InternalSupport38.Part2(var0, null, var8));
         }
      };
      if (var1 != null) {
         var1.v1(var2);
      } else {
         var2.run();
      }
   }

   public static void v6() {
      InternalSupport38.Part2 var0;
      while ((var0 = v28.poll()) != null) {
         v1(var0);
      }

      v15();
      long var1 = System.nanoTime();
      if (var1 - v40 >= 5000000000L) {
         v40 = var1;
         v26.values().removeIf(var2 -> var1 - var2.v5 > 30000000000L);
         Iterator var3 = v27.entrySet().iterator();

         while (var3.hasNext()) {
            InternalSupport38.Part1 var4 = (InternalSupport38.Part1)((Entry)var3.next()).getValue();
            if (var1 - var4.v4 > 60000000000L && !v2(var4.v1)) {
               v29.add(var4);
               var3.remove();
            }
         }

         InternalSupport38.Part1 var5;
         while ((var5 = v29.poll()) != null) {
            if (var5.v2 != null && v22 != null && v24 != null) {
               var5.v2.v1(v22, v24);
            }
         }
      }
   }

   private static boolean v2(cloudSupport50 var0) {
      for (uiSupport167 var2 : v26.values()) {
         for (uiSupport167.Part1 var6 : var2.v3) {
            if (var6.v1 == var0) {
               return true;
            }
         }
      }

      return false;
   }

   // $VF: Could not verify finally blocks. A semaphore variable has been added to preserve control flow.
   // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
   private static void v1(InternalSupport38.Part2 var0) {
      class_1011[] var1 = var0.v2;
      boolean var13 = false /* VF: Semaphore variable */;

      label179: {
         label192: {
            try {
               var13 = true;
               if (var1 != null && v27.get(var0.v1.v1) == var0.v1) {
                  if (v22 == null) {
                     v22 = new InternalSupport45();
                  }

                  if (v24 == null) {
                     v24 = new InternalSupport40();
                     v24.v1();
                  }

                  var0.v1.v2 = new uiSupport168(var0.v1.v1, var1, v22, v24);
                  var13 = false;
                  break label179;
               }

               if (var0.v3 != null) {
                  v1.warn("cosmetic {} has a texture that does not decode", var0.v1.v1.v1(), var0.v3);
                  var0.v1.v3 = true;
                  var13 = false;
               } else {
                  var13 = false;
               }
               break label192;
            } catch (Throwable var14) {
               var0.v1.v3 = true;
               v1.warn("cosmetic {} could not be uploaded", var0.v1.v1.v1(), var14);
               var13 = false;
            } finally {
               if (var13) {
                  if (var1 != null) {
                     for (class_1011 var10 : var1) {
                        if (var10 != null) {
                           var10.close();
                        }
                     }
                  }
               }
            }

            if (var1 != null) {
               for (class_1011 var5 : var1) {
                  if (var5 != null) {
                     var5.close();
                  }
               }
            }

            return;
         }

         if (var1 != null) {
            for (class_1011 var22 : var1) {
               if (var22 != null) {
                  var22.close();
               }
            }
         }

         return;
      }

      if (var1 != null) {
         for (class_1011 var23 : var1) {
            if (var23 != null) {
               var23.close();
            }
         }
      }
   }

   public static void v7() {
      for (InternalSupport38.Part1 var1 : v27.values()) {
         if (var1.v2 != null && v22 != null && v24 != null) {
            var1.v2.v1(v22, v24);
         }
      }

      v27.clear();
      v26.clear();
      if (v22 != null) {
         v22.close();
         v22 = null;
      }

      if (v25 != null) {
         v25.v1();
      }
   }

   public static long v8() {
      return v18;
   }

   public static long v9() {
      return v19;
   }

   public static boolean v1(UUID var0) {
      uiSupport167 var1 = v26.get(var0);
      return var1 != null && var1.v4 == v30;
   }

   public static long v10() {
      return v30;
   }

   public static void v11() {
      v18 = 0L;
      v19 = 0L;
      v17 = 0L;
      v21 = 0L;
   }

   public static String v12() {
      return v17 + " writes, " + v21 + " vertices";
   }

   public static String v13() {
      int var0 = 0;

      for (InternalSupport38.Part1 var2 : v27.values()) {
         if (var2.v2 != null) {
            var0++;
         }
      }

      return v26.size() + " wearers, " + var0 + "/" + v27.size() + " cosmetics on the GPU, " + (v22 == null ? 0 : v22.v1()) + " atlas pages";
   }

   public static final class Part1 {
      public final cloudSupport50 v1;
      @Nullable
      public uiSupport168 v2;
      public boolean v3;
      public volatile long v4 = System.nanoTime();

      public Part1(cloudSupport50 var1) {
         this.v1 = var1;
      }
   }

   public static final class Part2 {
      public final InternalSupport38.Part1 v1;
      @Nullable
      public final class_1011[] v2;
      @Nullable
      public final Throwable v3;

      public Part2(InternalSupport38.Part1 var1, @Nullable class_1011[] var2, @Nullable Throwable var3) {
         this.v1 = var1;
         this.v2 = var2;
         this.v3 = var3;
      }
   }
}
