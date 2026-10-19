package cc.syky.hud;

import cc.syky.cloud.cloudSupport101;
import cc.syky.ui.uiSupport27;
import cc.syky.ui.uiSupport28;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import net.minecraft.class_1934;
import net.minecraft.class_310;
import org.jetbrains.annotations.Nullable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public final class hudSupport34 {
   private static final Logger v2 = LoggerFactory.getLogger("syky.hud.edit");
   public static final float v1 = 24.0F;
   private static final long v3 = 1000000000L;
   private static final float v4 = 182.0F;
   private static final float v5 = 22.0F;
   private final HudManager v6;
   private final cloudSupport101 v7;
   private final hudSupport37 v8;
   private final uiSupport28 v9;
   private final hudSupport33 v10 = new hudSupport33();
   private final List<HudElement> v11 = new ArrayList<>();
   private final List<HudElement> v12 = new ArrayList<>();
   private final List<HudElement> v13 = new ArrayList<>();
   private float[] v14 = new float[16];
   private float[] v15 = new float[16];
   private float[] v16 = new float[8];
   private float[] v18 = new float[8];
   private float[] v19 = new float[8];
   private float[] v17 = new float[8];
   private long v20;
   private int v21 = -1;

   public hudSupport34(HudManager var1, cloudSupport101 var2, hudSupport37 var3, uiSupport28 var4) {
      this.v6 = var1;
      this.v7 = var2;
      this.v8 = var3;
      this.v9 = var4;
   }

   public List<HudElement> v1() {
      this.v11.clear();
      List var1 = this.v9.v1();

      for (int var2 = 0; var2 < var1.size(); var2++) {
         HudElement var3 = (HudElement)var1.get(var2);
         if (var3.v10() && var3.v42() && !var3.v27().v1()) {
            this.v11.add(var3);
         }
      }

      return this.v11;
   }

   public hudRecord4 v1(HudElement var1) {
      hudRecord4 var2 = this.v2(var1);
      if (!var2.v1() && var1.v11() == null) {
         float var3 = this.v8.v3;
         float var4 = uiSupport27.v1(var1.v3().v1(this.v8.v1, var2.v4(), var1.v5() * var3), var3);
         float var5 = uiSupport27.v1(var1.v3().v2(this.v8.v2, var2.v5(), var1.v6() * var3), var3);
         return new hudRecord4(var4, var5, var2.v4(), var2.v5());
      } else {
         return var2;
      }
   }

   private hudRecord4 v2(HudElement var1) {
      if (!var1.v12()) {
         return var1.v27();
      } else {
         hudSupport41 var2 = this.v6.v8();
         var2.v1(this.v8.v1, this.v8.v2, this.v8.v3, null);
         hudRecord4 var3 = var1.v11() == null ? var2.v9(var1) : var2.v8(var1);
         return var3 == null ? hudRecord4.EMPTY : var3;
      }
   }

   public void v1(List<hudRecord4> var1, List<HudElement> var2) {
      var1.clear();
      hudSupport41 var3 = this.v6.v8();
      var3.v1(this.v8.v1, this.v8.v2, this.v8.v3, null);

      for (HudElement var5 : this.v6.v9()) {
         if (var5.v10() && !var2.contains(var5) && !var5.v18().v2()) {
            hudRecord4 var6 = var5.v27();
            if (!var6.v1()) {
               hudRecord4 var7 = var5.v12() ? var3.v8(var5) : null;
               var1.add(var7 != null ? var7 : var6);
            }
         }
      }

      hudRecord4 var8 = this.v9();
      if (var8 != null) {
         var1.add(var8);
      }
   }

   @Nullable
   private hudRecord4 v9() {
      class_310 var1 = this.v7.v1();
      if (var1 != null && var1.field_1761 != null && !var1.field_1690.field_1842) {
         return var1.field_1761.method_2920() == class_1934.field_9219 ? null : new hudRecord4((int)this.v8.v1 / 2 - 91.0F, this.v8.v2 - 22.0F, 182.0F, 22.0F);
      } else {
         return null;
      }
   }

   public void v1(HudElement var1, float var2, float var3) {
      hudRecord4 var4 = this.v2(var1);
      float var5 = this.v8.v3;
      var1.v1(var1.v3().v3(this.v8.v1, var4.v4(), var2) / var5);
      var1.v2(var1.v3().v4(this.v8.v2, var4.v5(), var3) / var5);
   }

   public void v2(HudElement var1, float var2, float var3) {
      hudRecord4 var4 = this.v2(var1);
      if (!var4.v1()) {
         hudSupport52 var5 = var1.v2(hudSupport52.v1(this.v8.v1, this.v8.v2, var2, var3, var4.v4(), var4.v5(), 24.0F));
         var1.v1(var5);
         this.v1(var1, var2, var3);
      }
   }

   public List<HudElement> v1(List<HudElement> var1) {
      hudSupport41 var2 = this.v6.v8();
      List var3 = this.v13;
      var3.clear();

      for (int var4 = 0; var4 < var1.size(); var4++) {
         HudElement var5 = (HudElement)var1.get(var4);
         if (var5.v12() && var2.v1(var5, var1)) {
            var3.add(var2.v4(var5));
         }
      }

      this.v2();
      if (var2.v1(var1, this.v12)) {
         for (int var6 = 0; var6 < this.v12.size(); var6++) {
            HudElement var7 = this.v12.get(var6);
            if (var7.v12() && !var3.contains(var7)) {
               this.v3(var7);
            }
         }

         this.v2(var1);
         this.v1(var1);
      }

      return this.v12;
   }

   private void v2(List<HudElement> var1) {
      hudSupport41 var2 = this.v6.v8();
      List var3 = var2.v1();
      List var4 = var2.v5();

      for (int var5 = 0; var5 < var4.size(); var5++) {
         List var6 = (List)var4.get(var5);
         HudElement var7 = null;
         boolean var8 = false;

         for (int var9 = 0; var9 < var6.size(); var9++) {
            HudElement var10 = (HudElement)var6.get(var9);
            var8 |= var1.contains(var10);
            int var11 = var3.indexOf(var10);
            if (var7 == null && var11 >= 0 && var11 < this.v14.length && !Float.isNaN(this.v14[var11])) {
               var7 = var10;
            }
         }

         if (!var8 && var7 != null) {
            int var12 = var3.indexOf(var7);
            var2.v1(var7, this.v14[var12], this.v15[var12], this.v8.v1, this.v8.v2, this.v8.v3);
         }
      }
   }

   private void v3(HudElement var1) {
      List var2 = this.v6.v8().v6(var1);
      float var3 = Float.POSITIVE_INFINITY;
      float var4 = Float.POSITIVE_INFINITY;

      for (int var5 = 0; var5 < var2.size(); var5++) {
         hudRecord4 var6 = ((HudElement)var2.get(var5)).v27();
         if (!var6.v1()) {
            var3 = Math.min(var3, var6.v2());
            var4 = Math.min(var4, var6.v3());
         }
      }

      if (var3 != Float.POSITIVE_INFINITY) {
         for (int var7 = 0; var7 < var2.size(); var7++) {
            ((HudElement)var2.get(var7)).v26();
         }

         var1.v1(hudSupport52.TOP_LEFT);
         var1.v1(var3 / this.v8.v3, var4 / this.v8.v3);
      }
   }

   public void v2() {
      hudSupport41 var1 = this.v6.v8();
      List var2 = var1.v1();
      int var3 = var2.size();
      if (this.v14.length < var3) {
         this.v14 = new float[Math.max(var3, this.v14.length * 2)];
         this.v15 = new float[this.v14.length];
      }

      var1.v1(this.v8.v1, this.v8.v2, this.v8.v3, null);
      Arrays.fill(this.v14, 0, var3, Float.NaN);

      for (int var4 = 0; var4 < var3; var4++) {
         hudRecord4 var5 = var1.v8((HudElement)var2.get(var4));
         if (var5 != null) {
            this.v14[var4] = var5.v2();
            this.v15[var4] = var5.v3();
         }
      }
   }

   public void v1(@Nullable Collection<HudElement> var1) {
      hudSupport41 var2 = this.v6.v8();
      var2.v1(this.v8.v1, this.v8.v2, this.v8.v3, null);
      List var3 = var2.v1();
      int var4 = Math.min(var3.size(), this.v14.length);

      for (int var5 = 0; var5 < var4; var5++) {
         HudElement var6 = (HudElement)var3.get(var5);
         if (!Float.isNaN(this.v14[var5]) && (var1 == null || !var1.contains(var6))) {
            hudRecord4 var7 = var2.v8(var6);
            if (var7 != null && (Math.abs(this.v14[var5] - var7.v2()) >= 0.5F || Math.abs(this.v15[var5] - var7.v3()) >= 0.5F)) {
               var6.v1(this.v14[var5], this.v15[var5], var7.v2(), var7.v3());
            }
         }
      }
   }

   public boolean v1(int var1, int var2) {
      List var3 = this.v1();
      if (var3.isEmpty()) {
         return false;
      } else if (var3.size() == 1 && ((HudElement)var3.get(0)).v12() && !this.v6.v8().v1((HudElement)var3.get(0), var3)) {
         return this.v1((HudElement)var3.get(0), var1, var2);
      } else {
         long var4 = System.nanoTime();
         boolean var6 = this.v21 == this.v9.v4() && var4 - this.v20 < 1000000000L;
         hudSupport47 var7 = var6 ? null : hudSupport47.v1(this.v6, false);
         int var8 = this.v6.v8().v2();
         List var9 = this.v1(var3);
         boolean var10 = this.v6.v8().v2() != var8;
         float var11 = Float.POSITIVE_INFINITY;
         float var12 = Float.POSITIVE_INFINITY;
         float var13 = Float.NEGATIVE_INFINITY;
         float var14 = Float.NEGATIVE_INFINITY;
         this.v1(var9.size());

         for (int var15 = 0; var15 < var9.size(); var15++) {
            hudRecord4 var16 = this.v1((HudElement)var9.get(var15));
            this.v16[var15] = var16.v2();
            this.v18[var15] = var16.v3();
            var11 = Math.min(var11, var16.v2());
            var12 = Math.min(var12, var16.v3());
            var13 = Math.max(var13, var16.v2() + var16.v4());
            var14 = Math.max(var14, var16.v3() + var16.v5());
         }

         float var18 = v1(var11, var1 * this.v8.v3, var13 - var11, this.v8.v1);
         float var19 = v1(var12, var2 * this.v8.v3, var14 - var12, this.v8.v2);
         if (var18 == 0.0F && var19 == 0.0F && !var10) {
            return true;
         } else {
            for (int var17 = 0; var17 < var9.size(); var17++) {
               this.v2((HudElement)var9.get(var17), this.v16[var17] + var18, this.v18[var17] + var19);
            }

            if (var7 != null) {
               this.v1(var7);
            }

            this.v20 = var4;
            this.v21 = this.v9.v4();
            this.v8();
            return true;
         }
      }
   }

   private static float v1(float var0, float var1, float var2, float var3) {
      float var4 = Math.min(0.0F, var0);
      float var5 = Math.max(var3 - var2, var0);
      return Math.max(var4, Math.min(var0 + var1, var5)) - var0;
   }

   public boolean v1(HudElement var1, int var2, int var3) {
      hudRecord3.Part1 var4;
      if (var2 != 0) {
         var4 = var2 > 0 ? hudRecord3.Part1.RIGHT : hudRecord3.Part1.LEFT;
      } else {
         if (var3 == 0) {
            return true;
         }

         var4 = var3 > 0 ? hudRecord3.Part1.BELOW : hudRecord3.Part1.ABOVE;
      }

      hudSupport41 var5 = this.v6.v8();
      HudElement var6 = var5.v1(var1, var4);

      for (int var7 = 0; var6 != null && var6.v27().v1() && var7 < var5.v1().size(); var7++) {
         var6 = var5.v1(var6, var4);
      }

      if (var6 != null && var6 != var1) {
         hudSupport47 var8 = hudSupport47.v1(this.v6, false);
         this.v2();
         var5.v1(var1, var6);
         this.v1(null);
         this.v1(var8);
         this.v8();
         return true;
      } else {
         return true;
      }
   }

   public boolean v1(hudSupport36.Part1 var1) {
      List var2 = this.v1();
      if (!var1.v1(var2.size())) {
         return false;
      } else {
         hudSupport47 var3 = hudSupport47.v1(this.v6, false);
         List var4 = this.v1(var2);
         int var5 = var4.size();
         if (!var1.v1(var5)) {
            this.v2(var3);
            this.v8();
            return true;
         } else {
            this.v1(var5);

            for (int var6 = 0; var6 < var5; var6++) {
               hudRecord4 var7 = this.v1((HudElement)var4.get(var6));
               this.v16[var6] = var7.v2();
               this.v18[var6] = var7.v3();
               this.v19[var6] = var7.v4();
               this.v17[var6] = var7.v5();
            }

            hudSupport36.v1(var1, this.v16, this.v18, this.v19, this.v17, var5, this.v8.v1, this.v8.v2, 8.0F, this.v8.v3);

            for (int var8 = 0; var8 < var5; var8++) {
               this.v2((HudElement)var4.get(var8), this.v16[var8], this.v18[var8]);
            }

            this.v2(var3);
            this.v8();
            return true;
         }
      }
   }

   public boolean v3() {
      List var1 = this.v9.v1();
      if (var1.isEmpty()) {
         return false;
      } else {
         hudSupport47 var2 = hudSupport47.v1(this.v6, true);
         boolean var3 = false;

         for (int var4 = var1.size() - 1; var4 >= 0; var4--) {
            HudElement var5 = (HudElement)var1.get(var4);
            BossBarSupport2 var6 = this.v6.v3(var5);
            if (var6 != null && var6.v3().length == 1) {
               var3 |= this.v6.v5(var5);
            }
         }

         if (var3) {
            this.v1(var2);
            this.v9.v6();
            this.v8();
         }

         return true;
      }
   }

   public void v4() {
      this.v11.clear();

      for (HudElement var2 : this.v6.v9()) {
         if (var2.v10() && var2.v42() && !var2.v27().v1()) {
            this.v11.add(var2);
         }
      }

      this.v9.v1(this.v11, List.of());
   }

   public boolean v5() {
      this.v10();
      return this.v10.v1(this.v6);
   }

   public boolean v6() {
      this.v10();
      return this.v10.v2(this.v6);
   }

   public void v7() {
      this.v10.v1();
      this.v10();
   }

   public void v1(hudSupport47 var1) {
      this.v10.v1(var1);
      this.v10();
   }

   public void v2(hudSupport47 var1) {
      if (!var1.equals(hudSupport47.v1(this.v6, var1.v1()))) {
         this.v1(var1);
      }
   }

   private void v10() {
      this.v21 = -1;
      this.v20 = 0L;
   }

   public void v8() {
      try {
         this.v6.v13();
      } catch (RuntimeException var2) {
         v2.warn("failed to persist hud state after an edit", var2);
      }
   }

   private void v1(int var1) {
      if (this.v16.length < var1) {
         int var2 = Math.max(var1, this.v16.length * 2);
         this.v16 = new float[var2];
         this.v18 = new float[var2];
         this.v19 = new float[var2];
         this.v17 = new float[var2];
      }
   }
}
