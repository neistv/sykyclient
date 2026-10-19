package cc.syky.ui;

import cc.syky.FogSupport2;
import cc.syky.cloud.cloudSupport36;
import cc.syky.cloud.cloudSupport50;
import cc.syky.cloud.cloudSupport51;
import cc.syky.internal.InternalSupport40;
import cc.syky.internal.InternalSupport45;
import java.util.ArrayList;
import java.util.Arrays;
import net.minecraft.class_1011;
import net.minecraft.class_12249;
import net.minecraft.class_1921;
import org.jetbrains.annotations.Nullable;

public final class uiSupport168 {
   public final cloudSupport50 v1;
   private final InternalSupport45.Part1[] v9;
   public final InternalSupport45.Part1[] v2;
   public final InternalSupport45.Part1[] v3;
   public final int[] v4;
   public final class_1921[] v5;
   public final class_1921[] v6;
   public final boolean[] v7;
   public final uiSupport168.Part1[] v8;

   public uiSupport168(cloudSupport50 var1, class_1011[] var2, InternalSupport45 var3, InternalSupport40 var4) {
      this.v1 = var1;
      int var5 = var1.v6();
      this.v9 = new InternalSupport45.Part1[var5];
      int var6 = var1.v5();
      this.v2 = new InternalSupport45.Part1[var6];
      this.v3 = new InternalSupport45.Part1[var6];
      this.v4 = new int[var6];
      this.v5 = new class_1921[var6];
      this.v6 = new class_1921[var6];
      this.v7 = new boolean[var6];

      try {
         for (int var7 = 0; var7 < var5; var7++) {
            this.v9[var7] = var3.v1(var2[var7], var1.v2(var7).v6());
         }

         for (int var12 = 0; var12 < var6; var12++) {
            uiRecord12 var8 = var1.v1(var12);
            InternalSupport45.Part1 var9 = var8.v3() >= 0 ? this.v9[var8.v3()] : var3.v1(false);
            this.v2[var12] = var9;
            InternalSupport45.Part1 var10 = var8.v2() >= 0 ? this.v9[var8.v2()] : var3.v1(false);
            this.v3[var12] = var10;
            this.v5[var12] = v1(var8.v4(), var9);
            this.v7[var12] = var8.v4() == cloudSupport36.EMISSIVE;
            this.v4[var12] = var8.v5() != null ? var4.v1(var8.v5()) : -1;
            this.v6[var12] = this.v4[var12] >= 0 ? FogSupport2.v1(var10.v1().v1) : null;
         }
      } catch (RuntimeException var11) {
         this.v1(var3, var4);
         throw var11;
      }

      this.v8 = v1(var1);
   }

   @Nullable
   private static class_1921 v1(cloudSupport36 var0, InternalSupport45.Part1 var1) {
      return switch (var0) {
         case NONE -> null;
         case SOLID, CUTOUT -> class_12249.method_75994(var1.v1().v1);
         case TRANSLUCENT -> class_12249.method_76000(var1.v1().v1);
         case EMISSIVE -> class_12249.method_76014(var1.v1().v1);
      };
   }

   private static uiSupport168.Part1[] v1(cloudSupport50 var0) {
      uiSupport256 var1 = var0.v4();
      ArrayList var2 = new ArrayList();

      for (cloudSupport51 var6 : cloudSupport51.values()) {
         for (int var7 = 0; var7 < var0.v5(); var7++) {
            int var8 = 0;
            int[] var9 = new int[var1.v3()];

            for (int var10 = 0; var10 < var1.v3(); var10++) {
               if (var1.v2(var10) == var7 && var0.v3().v3(var1.v1(var10)) == var6) {
                  var9[var8++] = var10;
               }
            }

            if (var8 > 0) {
               var2.add(new uiSupport168.Part1(var6, var7, Arrays.copyOf(var9, var8)));
            }
         }
      }

      return var2.toArray(uiSupport168.Part1[]::new);
   }

   public void v1(InternalSupport45 var1, InternalSupport40 var2) {
      for (InternalSupport45.Part1 var6 : this.v9) {
         if (var6 != null) {
            var1.v1(var6);
         }
      }

      for (int var7 = 0; var7 < this.v4.length; var7++) {
         var2.v1(this.v4[var7]);
         this.v4[var7] = -1;
      }
   }

   public static final class Part1 {
      private final cloudSupport51 v1;
      private final int v2;
      private final int[] v3;

      public Part1(cloudSupport51 var1, int var2, int[] var3) {
         this.v1 = var1;
         this.v2 = var2;
         this.v3 = var3;
      }

      public cloudSupport51 v1() {
         return this.v1;
      }

      public int v2() {
         return this.v2;
      }

      public int[] v3() {
         return this.v3;
      }
   }
}
