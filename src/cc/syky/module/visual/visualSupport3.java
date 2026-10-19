package cc.syky.module.visual;

import cc.syky.cloud.cloudSupport101;
import cc.syky.internal.InternalSupport28;
import cc.syky.internal.InternalSupport57;
import java.nio.file.Path;
import java.util.EnumMap;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import net.minecraft.class_1113;
import net.minecraft.class_1657;
import net.minecraft.class_2960;
import net.minecraft.class_310;
import net.minecraft.class_3414;
import net.minecraft.class_3417;
import net.minecraft.class_3419;
import net.minecraft.class_746;
import org.jetbrains.annotations.Nullable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public final class visualSupport3 {
   private static final Logger v1 = LoggerFactory.getLogger("syky.sound");
   private static final double v2 = 1.5;
   private static final Random v3 = new Random();
   private static final EnumMap<visualSupport4, Set<String>> v4 = new EnumMap<>(visualSupport4.class);
   @Nullable
   private static Map<class_2960, visualSupport4> v5;
   @Nullable
   private static class_2960 v6;
   private static boolean v7;
   private static float v8 = 1.0F;
   private static float v9 = 1.0F;
   private static boolean v10 = true;
   @Nullable
   private static cloudSupport101 v11;
   @Nullable
   private static READMETxtSupport v12;

   private visualSupport3() {
   }

   public static synchronized void v1(cloudSupport101 var0, InternalSupport57 var1, Path var2) {
      v11 = var0;
      if (v12 == null) {
         v12 = new READMETxtSupport(var2);
      }

      v6();
      v12.v1(var1);
   }

   public static synchronized void v1() {
      v7 = false;
      InternalSupport28.v1(InternalSupport28.Part1.CUSTOM_SOUNDS, false);
      v12 = null;
      v11 = null;
   }

   public static void v1(InternalSupport57 var0) {
      READMETxtSupport var1 = v12;
      if (var1 != null) {
         var1.v1(var0);
      }
   }

   @Nullable
   public static READMETxtSupport v2() {
      return v12;
   }

   public static List<String> v3() {
      READMETxtSupport var0 = v12;
      return var0 != null ? var0.v1() : List.of();
   }

   public static synchronized void v1(boolean var0) {
      v7 = var0;
      InternalSupport28.v1(InternalSupport28.Part1.CUSTOM_SOUNDS, var0);
   }

   public static void v1(float var0) {
      v8 = var0;
   }

   public static void v2(float var0) {
      v9 = var0;
   }

   public static void v2(boolean var0) {
      v10 = var0;
   }

   public static void v1(visualSupport4 var0, Set<String> var1) {
      v4.put(var0, var1);
   }

   public static boolean v4() {
      return v7;
   }

   public static void v5() {
      cloudSupport101 var0 = v11;
      class_746 var1 = var0 != null ? var0.v2() : null;
      if (var1 != null) {
         visualSupport5.v1(var1.method_23317(), var1.method_23318(), var1.method_23321());
      }
   }

   public static boolean v1(class_1113 var0) {
      try {
         return v2(var0);
      } catch (Throwable var2) {
         v1.warn("custom-sound intercept failed; playing vanilla", var2);
         return false;
      }
   }

   private static boolean v2(class_1113 var0) {
      if (v7 && var0 != null) {
         cloudSupport101 var1 = v11;
         READMETxtSupport var2 = v12;
         if (var1 != null && var2 != null && v5 != null) {
            class_310 var3 = var1.v1();
            if (var3 != null && var3.method_18854()) {
               class_2960 var4 = var0.method_4775();
               if (var4 == null) {
                  return false;
               } else {
                  class_746 var5 = var1.v2();
                  visualSupport4 var6;
                  if (var4.equals(v6)) {
                     var6 = v1(var5, var0) ? visualSupport4.TOTEM_SELF : visualSupport4.TOTEM_ENEMY;
                  } else {
                     var6 = v5.get(var4);
                     if (var6 == null) {
                        return false;
                     }

                     if (v1(var6) && !visualSupport5.v1(var6, var0.method_4784(), var0.method_4779(), var0.method_4778())) {
                        return false;
                     }
                  }

                  visualRecord var7 = var2.v1(v4.get(var6), v3);
                  if (var7 == null) {
                     return false;
                  } else {
                     v1(var3, var5, var0, var6, var7);
                     return v10;
                  }
               }
            } else {
               return false;
            }
         } else {
            return false;
         }
      } else {
         return false;
      }
   }

   private static void v1(class_310 var0, @Nullable class_1657 var1, class_1113 var2, visualSupport4 var3, visualRecord var4) {
      class_3419 var5 = var2.method_4774();
      float var6 = var0.field_1690 != null && var5 != null ? var0.field_1690.method_71978(var5) : 1.0F;
      double var7 = var2.method_4784();
      double var9 = var2.method_4779();
      double var11 = var2.method_4778();
      double var13 = var7;
      double var15 = var9;
      double var17 = var11;
      float var19 = 0.0F;
      boolean var20 = var1 != null;
      if (var1 != null) {
         var13 = var1.method_23317();
         var15 = var1.method_23320();
         var17 = var1.method_23321();
         var19 = var1.method_36454();
      }

      double var21 = var7 - var13;
      double var23 = var9 - var15;
      double var25 = var11 - var17;
      double var27 = Math.sqrt(var21 * var21 + var23 * var23 + var25 * var25);
      float var29 = (float)Math.max(0.0, 1.0 - var27 / var3.v2());
      float var30 = v8 * v9 * var6 * var29;
      if (!(var30 <= 0.0F)) {
         float var31 = 0.0F;
         double var32 = Math.sqrt(var21 * var21 + var25 * var25);
         if (var20 && var32 > 1.0E-4) {
            double var34 = Math.toRadians(var19);
            double var36 = -Math.cos(var34);
            double var38 = -Math.sin(var34);
            var31 = (float)Math.max(-1.0, Math.min(1.0, (var21 * var36 + var25 * var38) / var32));
         }

         InternalSupport28.v1().v1(var4, var30, var31);
      }
   }

   private static boolean v1(@Nullable class_1657 var0, class_1113 var1) {
      if (var0 == null) {
         return false;
      } else {
         double var2 = var0.method_23317() - var1.method_4784();
         double var4 = var0.method_23318() - var1.method_4779();
         double var6 = var0.method_23321() - var1.method_4778();
         return var2 * var2 + var4 * var4 + var6 * var6 < 2.25;
      }
   }

   private static boolean v1(visualSupport4 var0) {
      return var0 == visualSupport4.CRIT
         || var0 == visualSupport4.KNOCKBACK
         || var0 == visualSupport4.SWEEP
         || var0 == visualSupport4.HIT
         || var0 == visualSupport4.NO_DAMAGE
         || var0 == visualSupport4.MACE;
   }

   private static void v6() {
      if (v5 == null) {
         HashMap var0 = new HashMap();
         var0.put(class_3417.field_15016.comp_3319(), visualSupport4.CRIT);
         var0.put(class_3417.field_14999.comp_3319(), visualSupport4.KNOCKBACK);
         var0.put(class_3417.field_14706.comp_3319(), visualSupport4.SWEEP);
         var0.put(class_3417.field_14840.comp_3319(), visualSupport4.HIT);
         var0.put(class_3417.field_14625.comp_3319(), visualSupport4.HIT);
         var0.put(class_3417.field_14914.comp_3319(), visualSupport4.NO_DAMAGE);
         var0.put(class_3417.field_49784.comp_3319(), visualSupport4.MACE);
         var0.put(class_3417.field_49785.comp_3319(), visualSupport4.MACE);
         var0.put(class_3417.field_49924.comp_3319(), visualSupport4.MACE);
         var0.put(((class_3414)class_3417.field_15152.comp_349()).comp_3319(), visualSupport4.EXPLOSION);
         v6 = class_3417.field_14931.comp_3319();
         v5 = var0;
      }
   }
}
