package cc.syky.hud;

import cc.syky.render.renderSupport47;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import net.minecraft.class_10017;
import net.minecraft.class_10444;
import net.minecraft.class_1058;
import net.minecraft.class_1087;
import net.minecraft.class_11659;
import net.minecraft.class_11785;
import net.minecraft.class_11791;
import net.minecraft.class_12075;
import net.minecraft.class_1799;
import net.minecraft.class_1921;
import net.minecraft.class_243;
import net.minecraft.class_2561;
import net.minecraft.class_2680;
import net.minecraft.class_310;
import net.minecraft.class_3879;
import net.minecraft.class_4587;
import net.minecraft.class_4608;
import net.minecraft.class_5481;
import net.minecraft.class_630;
import net.minecraft.class_757;
import net.minecraft.class_777;
import net.minecraft.class_811;
import net.minecraft.class_10017.class_10018;
import net.minecraft.class_10017.class_11680;
import net.minecraft.class_10444.class_10445;
import net.minecraft.class_11659.class_11660;
import net.minecraft.class_11659.class_11947;
import net.minecraft.class_11683.class_11792;
import net.minecraft.class_308.class_11274;
import net.minecraft.class_327.class_6415;
import org.jetbrains.annotations.Nullable;
import org.joml.Matrix4f;
import org.joml.Quaternionf;

public final class hudSupport67 {
   private static final class_4587 v3 = new class_4587();
   private static final int v4 = 15728880;
   public static final int v1 = 1;
   public static final int v2 = 2;
   private static class_10444[] v5 = new class_10444[0];
   private static final hudSupport67.Part1 v6 = new hudSupport67.Part1();
   private static float[] v7 = new float[0];
   private static float[] v8 = new float[0];
   private static float[] v9 = new float[0];
   private static int v10;
   private static int v11;
   private static int v12;
   public static long v13;
   public static long v14;

   private hudSupport67() {
   }

   public static int v1() {
      return v11;
   }

   public static int v2() {
      return v12;
   }

   public static long v3() {
      return v13;
   }

   public static long v4() {
      return v14;
   }

   public static void v5() {
      v11 = 0;
      v12 = 0;
      v13 = 0L;
      v14 = 0L;
   }

   public static int v1(class_310 var0, class_1799 var1, float var2, float var3, float var4) {
      if (var0 != null && !var1.method_7960()) {
         if (v10 == v5.length) {
            v7();
         }

         class_10444 var5 = v5[v10];
         var0.method_65386().method_65598(var5, var1, class_811.field_4317, var0.field_1687, var0.field_1724, 0);
         v11++;
         v7[v10] = var2;
         v8[v10] = var3;
         v9[v10] = var4;
         v10++;
         return (var5.method_70948() ? 1 : 0) | (var5.method_72174() ? 2 : 0);
      } else {
         return 0;
      }
   }

   public static void v1(class_310 var0) {
      if (v10 != 0) {
         try {
            class_757 var1 = var0.field_1773;
            v1(var0, var1, false);
            v1(var0, var1, true);
         } finally {
            v6();
         }
      }
   }

   public static void v6() {
      for (int var0 = 0; var0 < v10; var0++) {
         v5[var0].method_65605();
      }

      v10 = 0;
   }

   private static void v1(class_310 var0, class_757 var1, boolean var2) {
      class_4587 var3 = v3;
      boolean var4 = false;

      for (int var5 = 0; var5 < v10; var5++) {
         class_10444 var6 = v5[var5];
         if (var6.method_65608() == var2) {
            var4 = true;
            var3.method_22903();

            try {
               var3.method_46416(v7[var5], v8[var5], 0.0F);
               var3.method_22905(v9[var5], -v9[var5], v9[var5]);
               var6.method_65604(var3, v6.v1(var1.method_72910()), 15728880, class_4608.field_21444, 0);
            } finally {
               var3.method_22909();
            }
         }
      }

      if (var4) {
         var1.method_71114().method_71034(var2 ? class_11274.field_60027 : class_11274.field_60026);
         var1.method_72911().method_73002();
         var0.method_22940().method_23000().method_22993();
         v6.v1();
         v12++;
      }
   }

   public static void v1(boolean var0) {
      v6.v2 = var0;
   }

   private static void v7() {
      int var0 = Math.max(8, v5.length * 2);
      class_10444[] var1 = Arrays.copyOf(v5, var0);

      for (int var2 = v5.length; var2 < var0; var2++) {
         var1[var2] = new class_10444();
      }

      v5 = var1;
      v7 = Arrays.copyOf(v7, var0);
      v8 = Arrays.copyOf(v8, var0);
      v9 = Arrays.copyOf(v9, var0);
   }

   public static final class Part1 implements class_11659 {
      @Nullable
      private class_11659 v1;
      public boolean v2 = true;
      private final List<List<class_777>> v3 = new ArrayList<>();
      private int v4;

      public Part1() {
      }

      private class_11659 v2() {
         return renderSupport47.v1(this.v1);
      }

      public hudSupport67.Part1 v1(class_11659 var1) {
         this.v1 = var1;
         return this;
      }

      public void v1() {
         for (int var1 = 0; var1 < this.v4; var1++) {
            this.v3.get(var1).clear();
         }

         this.v4 = 0;
      }

      public void method_73480(
         class_4587 var1, class_811 var2, int var3, int var4, int var5, int[] var6, List<class_777> var7, class_1921 var8, class_10445 var9
      ) {
         this.v2().method_73480(var1, var2, var3, var4, var5, var6, this.v1(var1, var7), var8, var9);
      }

      private List<class_777> v1(class_4587 var1, List<class_777> var2) {
         if (!this.v2) {
            return var2;
         } else {
            Matrix4f var3 = var1.method_23760().method_23761();
            boolean var4 = var3.m10() == 0.0F && var3.m20() == 0.0F;
            boolean var5 = var3.m01() == 0.0F && var3.m21() == 0.0F;
            if (!var4 && !var5) {
               hudSupport67.v13 = hudSupport67.v13 + var2.size();
               return var2;
            } else {
               List var6 = null;
               hudSupport67.v13 = hudSupport67.v13 + var2.size();
               int var7 = 0;

               for (int var8 = var2.size(); var7 < var8; var7++) {
                  class_777 var9 = (class_777)var2.get(var7);
                  boolean var10 = var4 && v1(var9) || var5 && v2(var9);
                  if (var10) {
                     hudSupport67.v14++;
                     if (var6 == null) {
                        var6 = this.v3();
                        var6.addAll(var2.subList(0, var7));
                     }
                  } else if (var6 != null) {
                     var6.add(var9);
                  }
               }

               return var6 == null ? var2 : var6;
            }
         }
      }

      private List<class_777> v3() {
         if (this.v4 == this.v3.size()) {
            this.v3.add(new ArrayList<>());
         }

         return this.v3.get(this.v4++);
      }

      private static boolean v1(class_777 var0) {
         float var1 = var0.comp_5238().x();
         return var0.comp_5239().x() == var1 && var0.comp_5240().x() == var1 && var0.comp_5241().x() == var1;
      }

      private static boolean v2(class_777 var0) {
         float var1 = var0.comp_5238().y();
         return var0.comp_5239().y() == var1 && var0.comp_5240().y() == var1 && var0.comp_5241().y() == var1;
      }

      public class_11785 method_73529(int var1) {
         return this.v2().method_73529(var1);
      }

      public void method_73479(class_4587 var1, float var2, List<class_11680> var3) {
         this.v2().method_73479(var1, var2, var3);
      }

      public void method_73482(class_4587 var1, class_243 var2, int var3, class_2561 var4, boolean var5, int var6, double var7, class_12075 var9) {
         this.v2().method_73482(var1, var2, var3, var4, var5, var6, var7, var9);
      }

      public void method_73478(class_4587 var1, float var2, float var3, class_5481 var4, boolean var5, class_6415 var6, int var7, int var8, int var9, int var10) {
         this.v2().method_73478(var1, var2, var3, var4, var5, var6, var7, var8, var9, var10);
      }

      public void method_73488(class_4587 var1, class_10017 var2, Quaternionf var3) {
         this.v2().method_73488(var1, var2, var3);
      }

      public void method_73486(class_4587 var1, class_10018 var2) {
         this.v2().method_73486(var1, var2);
      }

      public <S> void method_73490(
         class_3879<? super S> var1, S var2, class_4587 var3, class_1921 var4, int var5, int var6, int var7, class_1058 var8, int var9, class_11792 var10
      ) {
         this.v2().method_73490(var1, var2, var3, var4, var5, var6, var7, var8, var9, var10);
      }

      public void method_73494(
         class_630 var1,
         class_4587 var2,
         class_1921 var3,
         int var4,
         int var5,
         class_1058 var6,
         boolean var7,
         boolean var8,
         int var9,
         class_11792 var10,
         int var11
      ) {
         this.v2().method_73494(var1, var2, var3, var4, var5, var6, var7, var8, var9, var10, var11);
      }

      public void method_73481(class_4587 var1, class_2680 var2, int var3, int var4, int var5) {
         this.v2().method_73481(var1, var2, var3, var4, var5);
      }

      public void method_73485(class_4587 var1, class_11791 var2) {
         this.v2().method_73485(var1, var2);
      }

      public void method_73484(class_4587 var1, class_1921 var2, class_1087 var3, float var4, float var5, float var6, int var7, int var8, int var9) {
         this.v2().method_73484(var1, var2, var3, var4, var5, var6, var7, var8, var9);
      }

      public void method_73483(class_4587 var1, class_1921 var2, class_11660 var3) {
         this.v2().method_73483(var1, var2, var3);
      }

      public void method_74315(class_11947 var1) {
         this.v2().method_74315(var1);
      }
   }
}
