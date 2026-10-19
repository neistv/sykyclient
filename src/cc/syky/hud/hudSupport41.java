package cc.syky.hud;

import cc.syky.account.accountSupport6;
import cc.syky.ui.uiSupport169;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.function.DoubleUnaryOperator;
import java.util.function.Predicate;
import org.jetbrains.annotations.Nullable;

public final class hudSupport41 {
   private static final DoubleUnaryOperator v1 = hudSupport41::v1;
   private static final DoubleUnaryOperator v2 = hudSupport41::v2;
   private final List<HudElement> v3 = new ArrayList<>();
   private final List<HudElement> v4 = Collections.unmodifiableList(this.v3);
   private final accountSupport6 v5 = new accountSupport6();
   private final accountSupport6 v6 = new accountSupport6();
   private final Predicate<HudElement> v7;
   private int v8;
   private long v9 = Long.MIN_VALUE;
   private int v10 = -1;
   private final float[] v11 = new float[2];
   private float[] v12 = new float[0];
   private float[] v13 = new float[0];
   private int v14;
   private int v15;
   private final List<List<HudElement>> v16 = new ArrayList<>();
   private final List<List<HudElement>> v18 = Collections.unmodifiableList(this.v16);
   private int v19 = -1;
   private static final hudRecord3.Part1[] v17 = new hudRecord3.Part1[]{
      hudRecord3.Part1.RIGHT, hudRecord3.Part1.BELOW, hudRecord3.Part1.LEFT, hudRecord3.Part1.ABOVE
   };

   public hudSupport41(Predicate<HudElement> var1) {
      this.v7 = var1;
   }

   public List<HudElement> v1() {
      return this.v4;
   }

   public boolean v1(@Nullable HudElement var1) {
      return var1 != null && var1.v13() == this;
   }

   public int v2() {
      return this.v8;
   }

   public void v2(HudElement var1) {
      if (var1.v13() != this) {
         var1.v1(this, this.v3.size());
         this.v3.add(var1);
         this.v8++;
      }
   }

   public void v3(HudElement var1) {
      if (this.v1(var1)) {
         this.v7(var1);
         this.v3.remove(var1.v1);
         var1.v14();
         int var2 = 0;

         while (var2 < this.v3.size()) {
            this.v3.get(var2).v1 = var2++;
         }

         this.v8++;
      }
   }

   public void v3() {
      for (int var1 = 0; var1 < this.v3.size(); var1++) {
         this.v3.get(var1).v14();
      }

      this.v3.clear();
      this.v8++;
   }

   public void v4() {
      for (int var1 = 0; var1 < this.v3.size(); var1++) {
         this.v3.get(var1).v1(null);
      }

      this.v8++;
   }

   @Nullable
   public HudElement v1(HudElement var1, hudRecord3.Part1 var2) {
      hudRecord3 var3 = var1.v11();
      return var3 != null && var3.v2() == var2.v2() ? var3.v1() : this.v2(var1, var2);
   }

   @Nullable
   public HudElement v2(HudElement var1, hudRecord3.Part1 var2) {
      for (int var3 = 0; var3 < this.v3.size(); var3++) {
         hudRecord3 var4 = this.v3.get(var3).v11();
         if (var4 != null && var4.v1() == var1 && var4.v2() == var2) {
            return this.v3.get(var3);
         }
      }

      return null;
   }

   public HudElement v4(HudElement var1) {
      HudElement var2 = var1;

      for (int var3 = 0; var3 <= this.v3.size(); var3++) {
         hudRecord3 var4 = var2.v11();
         if (var4 == null) {
            return var2;
         }

         var2 = var4.v1();
      }

      return var2;
   }

   public hudSupport52 v5(HudElement var1) {
      return this.v4(var1).v3();
   }

   public List<List<HudElement>> v5() {
      if (this.v19 == this.v8) {
         return this.v18;
      } else {
         this.v19 = this.v8;
         this.v16.clear();

         for (int var1 = 0; var1 < this.v3.size(); var1++) {
            HudElement var2 = this.v3.get(var1);
            if (var2.v11() == null) {
               ArrayList var3 = new ArrayList(4);
               var3.add(var2);

               for (int var4 = 0; var4 < var3.size() && var3.size() <= this.v3.size(); var4++) {
                  HudElement var5 = (HudElement)var3.get(var4);

                  for (int var6 = 0; var6 < this.v3.size(); var6++) {
                     hudRecord3 var7 = this.v3.get(var6).v11();
                     if (var7 != null && var7.v1() == var5) {
                        var3.add(this.v3.get(var6));
                     }
                  }
               }

               this.v16.add(Collections.unmodifiableList(var3));
            }
         }

         return this.v18;
      }
   }

   public boolean v1(HudElement var1, Collection<HudElement> var2) {
      if (!this.v1(var1)) {
         return var2.contains(var1);
      } else {
         List var3 = this.v6(var1);

         for (int var4 = 0; var4 < var3.size(); var4++) {
            HudElement var5 = (HudElement)var3.get(var4);
            if (v10(var5) && !var2.contains(var5)) {
               return false;
            }
         }

         return true;
      }
   }

   private static boolean v10(HudElement var0) {
      return !var0.v27().v1() && !var0.v18().v2();
   }

   public List<HudElement> v6(HudElement var1) {
      if (!this.v1(var1)) {
         return List.of(var1);
      } else {
         HudElement var2 = this.v4(var1);
         List var3 = this.v5();

         for (int var4 = 0; var4 < var3.size(); var4++) {
            List var5 = (List)var3.get(var4);
            if (var5.get(0) == var2) {
               return var5;
            }
         }

         return List.of(var1);
      }
   }

   public void v7(HudElement var1) {
      if (this.v1(var1)) {
         this.v1(this.v6);
         this.v6.v5(var1.v1);
         this.v2(this.v6);
      }
   }

   public boolean v1(HudElement var1, HudElement var2, hudRecord3.Part1 var3, hudRecord3.Part2 var4) {
      if (this.v1(var1) && this.v1(var2)) {
         this.v1(this.v6);
         if (!this.v6.v2(var1.v1, var2.v1, var3.code, var4.code)) {
            return false;
         } else {
            this.v2(this.v6);
            return true;
         }
      } else {
         return false;
      }
   }

   public boolean v2(HudElement var1, HudElement var2, hudRecord3.Part1 var3, hudRecord3.Part2 var4) {
      if (this.v1(var1) && this.v1(var2)) {
         this.v1(this.v6);
         if (!this.v6.v1(var1.v1, var2.v1, var3.code, var4.code)) {
            return false;
         } else {
            this.v2(this.v6);
            return true;
         }
      } else {
         return false;
      }
   }

   public boolean v3(HudElement var1, HudElement var2, hudRecord3.Part1 var3, hudRecord3.Part2 var4) {
      HudElement var5 = var2;

      for (int var6 = 0; var6 <= this.v3.size(); var6++) {
         HudElement var7 = this.v2(var5, var3);
         if (var7 == null || var7 == var1) {
            break;
         }

         var5 = var7;
      }

      return this.v2(var1, var5, var3, var4);
   }

   public void v1(HudElement var1, HudElement var2) {
      if (this.v1(var1) && this.v1(var2) && var1 != var2) {
         this.v1(this.v6);
         this.v6.v4(var1.v1, var2.v1);
         this.v2(this.v6);
      }
   }

   public boolean v1(Collection<HudElement> var1, List<HudElement> var2) {
      var2.clear();
      this.v1(this.v6);
      int var3 = this.v3.size();
      boolean[] var4 = new boolean[var3];

      for (HudElement var6 : var1) {
         if (this.v1(var6)) {
            var4[var6.v1] = true;
         }
      }

      int[] var17 = new int[var3];

      for (int var18 = 0; var18 < var3; var18++) {
         var17[var18] = v1(this.v6, var18);
      }

      boolean[] var19 = new boolean[var3];

      for (int var7 = 0; var7 < var3; var7++) {
         if (!var4[var7] && v10(this.v3.get(var7))) {
            var19[var17[var7]] = true;
         }
      }

      boolean[] var20 = new boolean[var3];
      int[] var8 = new int[var3];
      int var9 = 0;

      for (int var10 = 0; var10 < var3; var10++) {
         if (var4[var10] && var19[var17[var10]]) {
            var20[var10] = true;
            var8[var9++] = var10;
         }
      }

      for (int var21 = 0; var21 < var9; var21++) {
         int var11 = var8[var21];

         for (hudRecord3.Part1 var15 : hudRecord3.Part1.values()) {
            int var16 = this.v6.v1(var11, var15.code);
            if (var16 != -1 && !var20[var16] && !var4[var16] && !v10(this.v3.get(var16))) {
               var20[var16] = true;
               var8[var9++] = var16;
            }
         }
      }

      boolean var22 = false;

      for (int var23 = 0; var23 < var3; var23++) {
         int var25 = this.v6.v10[var23];
         if (var25 != -1 && var20[var23] != var20[var25]) {
            this.v6.v2(var23);
            var22 = true;
         }
      }

      if (var22) {
         this.v2(this.v6);
      }

      for (HudElement var26 : var1) {
         HudElement var27;
         if (!this.v1(var26)) {
            var27 = var26;
         } else if (!var19[var17[var26.v1]]) {
            var27 = this.v3.get(var17[var26.v1]);
         } else {
            hudRecord3 var28 = var26.v11();
            var27 = var28 != null && var1.contains(var28.v1()) ? null : var26;
         }

         if (var27 != null && !var2.contains(var27)) {
            var2.add(var27);
         }
      }

      return var22;
   }

   private static int v1(accountSupport6 var0, int var1) {
      int var2 = var1;

      for (int var3 = 0; var0.v10[var2] != -1 && var3 <= var0.v9; var3++) {
         var2 = var0.v10[var2];
      }

      return var2;
   }

   private void v1(accountSupport6 var1) {
      int var2 = this.v3.size();
      var1.v1(var2);

      for (int var3 = 0; var3 < var2; var3++) {
         HudElement var4 = this.v3.get(var3);
         hudRecord3 var5 = var4.v11();
         if (var5 != null) {
            HudElement var6 = var5.v1();
            if (var6.v13() != this || !var1.v1(var3, var6.v1, var5.v2().code, var5.v3().code)) {
               var4.v1(null);
               this.v8++;
            }
         }
      }
   }

   private void v2(accountSupport6 var1) {
      int var2 = this.v3.size();
      boolean var3 = false;
      boolean var4 = false;

      for (int var5 = 0; var5 < var2; var5++) {
         var4 |= var1.v10[var5] == -1 && var1.v14[var5] != var5;
      }

      hudSupport52[] var12 = new hudSupport52[var4 ? var2 : 0];
      float[] var6 = new float[var12.length];
      float[] var7 = new float[var12.length];

      for (int var8 = 0; var4 && var8 < var2; var8++) {
         int var9 = var1.v14[var8];
         if (var1.v10[var8] == -1 && var9 != var8) {
            HudElement var10 = this.v3.get(var9);
            var12[var8] = var10.v3();
            var6[var8] = var10.v7();
            var7[var8] = var10.v8();
         }
      }

      for (int var13 = 0; var13 < var2; var13++) {
         HudElement var14 = this.v3.get(var13);
         int var15 = var1.v10[var13];
         hudRecord3 var11 = var15 == -1 ? null : new hudRecord3(this.v3.get(var15), hudRecord3.Part1.v1(var1.v11[var13]), hudRecord3.Part2.v1(var1.v12[var13]));
         if (!Objects.equals(var14.v11(), var11)) {
            var14.v1(var11);
            var3 = true;
         }

         if (var4 && var12[var13] != null) {
            var14.v1(var12[var13]);
            var14.v1(var6[var13], var7[var13]);
            var3 = true;
         }
      }

      if (var3) {
         this.v8++;
      }
   }

   public void v1(hudSupport40 var1) {
      if (var1.v1() != this.v9 || this.v8 != this.v10) {
         this.v9 = var1.v1();
         this.v10 = this.v8;
         accountSupport6 var2 = this.v5;
         this.v1(var2);
         float[] var3 = this.v11;

         for (int var4 = 0; var4 < this.v3.size(); var4++) {
            HudElement var5 = this.v3.get(var4);

            boolean var6;
            try {
               var6 = this.v7.test(var5) && var5.v1(var1, var3);
            } catch (Throwable var8) {
               var6 = false;
            }

            var2.v18[var4] = var6;
            var2.v15[var4] = var6 ? var3[0] : 0.0F;
            var2.v16[var4] = var6 ? var3[1] : 0.0F;
            var2.v19[var4] = var5.v36();
            var2.v17[var4] = var5.v3();
            var2.v20[var4] = var5.v5();
            var2.v21[var4] = var5.v6();
         }

         float var9 = var1.v5();
         var2.v1(var1.v3(), var1.v4(), var9, 10.0F * var9, v1);
      }
   }

   private static double v1(double var0) {
      return uiSupport169.v1((float)var0);
   }

   public float v1(HudElement var1, hudSupport40 var2) {
      this.v1(var2);
      return this.v5.v22[var1.v1];
   }

   public float v2(HudElement var1, hudSupport40 var2) {
      this.v1(var2);
      return this.v5.v24[var1.v1];
   }

   public static float v1(hudRecord4 var0, hudRecord3.Part1 var1, hudRecord3.Part2 var2, float var3, float var4) {
      return accountSupport6.v1(var0.v2(), var0.v4(), var1.code, var2.code, var3, 10.0F * var4);
   }

   public static float v2(hudRecord4 var0, hudRecord3.Part1 var1, hudRecord3.Part2 var2, float var3, float var4) {
      return accountSupport6.v2(var0.v3(), var0.v5(), var1.code, var2.code, var3, 10.0F * var4);
   }

   public void v1(float var1, float var2, float var3, @Nullable HudElement var4) {
      this.v1(this.v6);
      this.v1(this.v6, var4);
      this.v6.v1(var1, var2, var3, 10.0F * var3, v1);
   }

   private void v1(accountSupport6 var1, @Nullable HudElement var2) {
      for (int var3 = 0; var3 < this.v3.size(); var3++) {
         HudElement var4 = this.v3.get(var3);
         hudRecord4 var5 = var4.v27();
         boolean var6 = var4 != var2 && !var5.v1() && !var4.v18().v2();
         var1.v18[var3] = var6;
         var1.v15[var3] = var6 ? var5.v4() : 0.0F;
         var1.v16[var3] = var6 ? var5.v5() : 0.0F;
         var1.v19[var3] = false;
         var1.v17[var3] = var4.v3();
         var1.v20[var3] = var4.v5();
         var1.v21[var3] = var4.v6();
      }
   }

   @Nullable
   public hudRecord4 v8(HudElement var1) {
      if (this.v1(var1) && var1.v1 < this.v6.v9) {
         float var2 = this.v6.v22[var1.v1];
         if (Float.isNaN(var2)) {
            return null;
         } else {
            int var3 = var1.v1;
            return new hudRecord4(var2, this.v6.v24[var3], this.v6.v15[var3], this.v6.v16[var3]);
         }
      } else {
         return null;
      }
   }

   @Nullable
   public hudRecord4 v9(HudElement var1) {
      if (this.v1(var1) && var1.v1 < this.v6.v9) {
         int var2 = this.v6.v25[var1.v1];
         if (var2 == -1) {
            HudElement var3 = this.v4(var1);

            for (int var4 = 0; var4 < this.v3.size() && var4 < this.v6.v9; var4++) {
               if (this.v6.v25[var4] != -1 && this.v4(this.v3.get(var4)) == var3) {
                  var2 = this.v6.v25[var4];
                  break;
               }
            }
         }

         return var2 == -1 ? null : new hudRecord4(this.v6.v26[var2], this.v6.v27[var2], this.v6.v28[var2], this.v6.v29[var2]);
      } else {
         return null;
      }
   }

   public boolean v1(float var1, float var2, float var3) {
      boolean var4 = false;
      float var5 = 10.0F * var3;
      ArrayList var6 = new ArrayList();

      for (int var7 = 0; var7 < this.v3.size() * 4; var7++) {
         this.v1(var1, var2, var3, null);
         accountSupport6 var8 = this.v6;
         int var9 = var8.v9;
         int var10 = -1;
         int var11 = -1;
         int var12 = 0;
         int var13 = 0;

         label89:
         for (int var14 = 0; var14 < var9; var14++) {
            if (!Float.isNaN(var8.v22[var14])) {
               for (int var15 = 0; var15 < var9; var15++) {
                  if (var15 != var14 && !Float.isNaN(var8.v22[var15]) && var8.v7(var14) != var8.v7(var15)) {
                     for (int var16 = 0; var16 < 4; var16++) {
                        if (v1(var8, var14, var16)) {
                           int var17 = v1(var8, var14, var15, var16, var5);
                           if (var17 >= 0 && !v1(var6, var14, var15, var16)) {
                              var10 = var15;
                              var11 = var14;
                              var12 = var16;
                              var13 = var17;
                              break label89;
                           }
                        }
                     }
                  }
               }
            }
         }

         if (var10 < 0) {
            break;
         }

         if (this.v12.length < var9) {
            this.v12 = new float[Math.max(var9, this.v12.length * 2)];
            this.v13 = new float[this.v12.length];
         }

         System.arraycopy(var8.v22, 0, this.v12, 0, var9);
         System.arraycopy(var8.v24, 0, this.v13, 0, var9);
         this.v1(var8);
         this.v1(var8, null);
         var8.v30 = false;
         var8.v2(var1, var2, var3, var5, v2);
         float var18 = var8.v22[var11];
         float var19 = var8.v24[var11];
         var8.v4(var10);
         boolean var20 = var8.v1(var10, accountSupport6.v6(var12)) == -1 && var8.v1(var10, var11, var12, var13);
         if (var20) {
            var8.v2(var1, var2, var3, var5, v2);
            v1(var8, var11, var18, var19, var1, var2, var3);
         }

         var8.v30 = true;
         var8.v2(var1, var2, var3, var5, v2);
         if (var20 && !this.v2(var8, var9) && !this.v1(var8, var8.v25[var11], List.of(), -1)) {
            this.v3(var8);
            var4 = true;
         } else {
            var6.add(new long[]{var11, var10, var12});
         }
      }

      return var4;
   }

   private boolean v2(accountSupport6 var1, int var2) {
      for (int var3 = 0; var3 < var2; var3++) {
         if (!Float.isNaN(this.v12[var3])
            && !Float.isNaN(var1.v22[var3])
            && (Math.abs(this.v12[var3] - var1.v22[var3]) > 0.51F || Math.abs(this.v13[var3] - var1.v24[var3]) > 0.51F)) {
            return true;
         }
      }

      return false;
   }

   private static boolean v1(List<long[]> var0, int var1, int var2, int var3) {
      for (int var4 = 0; var4 < var0.size(); var4++) {
         long[] var5 = (long[])var0.get(var4);
         if (var5[0] == var1 && var5[1] == var2 && var5[2] == var3) {
            return true;
         }
      }

      return false;
   }

   private static boolean v1(accountSupport6 var0, int var1, int var2) {
      return var0.v1(var1, var2) == -1 && (var0.v10[var1] == -1 || accountSupport6.v6(var0.v11[var1]) != var2);
   }

   private static int v1(accountSupport6 var0, int var1, int var2, int var3, float var4) {
      float var5 = 0.5F;
      boolean var6 = accountSupport6.v3(var3);

      float var7 = switch (var3) {
         case 0 -> var0.v22[var1] - (var0.v22[var2] + var0.v15[var2]);
         case 1 -> var0.v22[var2] - (var0.v22[var1] + var0.v15[var1]);
         default -> var0.v24[var1] - (var0.v24[var2] + var0.v16[var2]);
         case 3 -> var0.v24[var2] - (var0.v24[var1] + var0.v16[var1]);
      };
      if (Math.abs(var7 - var4) > var5) {
         return -1;
      } else {
         float var8 = var6 ? var0.v24[var1] : var0.v22[var1];
         float var9 = var6 ? var0.v16[var1] : var0.v15[var1];
         float var10 = var6 ? var0.v24[var2] : var0.v22[var2];
         float var11 = var6 ? var0.v16[var2] : var0.v15[var2];
         if (!(Math.abs(var8 + var9 * 0.5F - var10 - var11 * 0.5F) <= var5) || !var6 && !(Math.abs(var8 - var10) > var5)) {
            if (Math.abs(var8 - var10) <= var5) {
               return 0;
            } else {
               return Math.abs(var8 + var9 - var10 - var11) <= var5 ? 2 : -1;
            }
         } else {
            return 1;
         }
      }
   }

   public boolean v1(HudElement var1, float var2, float var3, float var4, List<hudRecord4> var5) {
      if (!this.v1(var1)) {
         return false;
      } else {
         this.v1(var2, var3, var4, null);
         hudRecord4 var6 = this.v8(var1);
         if (var6 == null) {
            return false;
         } else {
            List var7 = this.v6(var1);
            boolean var8 = var7.size() > 1;

            for (int var9 = 0; var9 < var7.size() && var8; var9++) {
               var8 = var7.get(var9) == var1 || this.v8((HudElement)var7.get(var9)) == null;
            }

            boolean var17 = false;

            for (int var10 = 0; var10 < this.v3.size() && !var17; var10++) {
               HudElement var11 = this.v3.get(var10);
               hudRecord4 var12 = var11 == var1 ? null : this.v8(var11);
               var17 = var12 != null && v1(var6.v2(), var6.v3(), var6.v4(), var6.v5(), var12.v2(), var12.v3(), var12.v4(), var12.v5());
            }

            for (int var18 = 0; var18 < var5.size() && !var17; var18++) {
               hudRecord4 var20 = (hudRecord4)var5.get(var18);
               var17 = v1(var6.v2(), var6.v3(), var6.v4(), var6.v5(), var20.v2(), var20.v3(), var20.v4(), var20.v5());
            }

            if (!var8 && !var17) {
               return false;
            } else {
               List var19 = this.v5();
               ArrayList var21 = new ArrayList();
               ArrayList var22 = new ArrayList();

               for (int var13 = 0; var13 < var19.size(); var13++) {
                  List var14 = (List)var19.get(var13);
                  int var15 = 0;

                  for (int var16 = 0; var16 < var14.size(); var16++) {
                     if (var14.get(var16) != var1 && this.v8((HudElement)var14.get(var16)) != null) {
                        var15++;
                     }
                  }

                  if (var15 != 0) {
                     int var24 = 0;

                     while (var24 < var22.size() && var22.get(var24) >= var15) {
                        var24++;
                     }

                     var21.add(var24, var14);
                     var22.add(var24, var15);
                  }
               }

               for (int var23 = 0; var23 < var21.size(); var23++) {
                  if (this.v1(var1, (List<HudElement>)var21.get(var23), var2, var3, var4, var5)) {
                     return true;
                  }
               }

               return false;
            }
         }
      }
   }

   private boolean v1(HudElement var1, List<HudElement> var2, float var3, float var4, float var5, List<hudRecord4> var6) {
      this.v1(var3, var4, var5, null);
      ArrayList var7 = new ArrayList();

      for (int var8 = 0; var8 < var2.size(); var8++) {
         if (var2.get(var8) != var1 && this.v8((HudElement)var2.get(var8)) != null) {
            var7.add((HudElement)var2.get(var8));
         }
      }

      HudElement var18 = null;
      hudRecord3.Part1 var9 = hudRecord3.Part1.RIGHT;
      int var10 = -1;
      int var11 = Integer.MAX_VALUE;

      for (int var12 = 0; var12 < var7.size(); var12++) {
         HudElement var13 = (HudElement)var7.get(var12);

         for (int var14 = 0; var14 < v17.length; var14++) {
            hudRecord3.Part1 var15 = v17[var14];
            if (this.v1(var13, var15) == null) {
               int var16 = this.v1(var13, var15.v1());
               if (var16 >= var10 && (var16 != var10 || var14 < var11)) {
                  hudRecord3.Part2 var17 = var15.v1() ? hudRecord3.Part2.CENTER : hudRecord3.Part2.START;
                  if (this.v1(var1, var13, var15, var17, false, var3, var4, var5, var6) != null && this.v14 <= 0) {
                     var18 = var13;
                     var9 = var15;
                     var10 = var16;
                     var11 = var14;
                  }
               }
            }
         }
      }

      return var18 == null ? false : this.v1(var1, var18, var9, var9.v1() ? hudRecord3.Part2.CENTER : hudRecord3.Part2.START, false, var3, var4, var5);
   }

   private int v1(HudElement var1, boolean var2) {
      int var3 = 1;
      hudRecord3.Part1[] var4 = var2
         ? new hudRecord3.Part1[]{hudRecord3.Part1.LEFT, hudRecord3.Part1.RIGHT}
         : new hudRecord3.Part1[]{hudRecord3.Part1.ABOVE, hudRecord3.Part1.BELOW};

      for (hudRecord3.Part1 var8 : var4) {
         HudElement var9 = this.v1(var1, var8);

         for (int var10 = 0; var9 != null && var10 <= this.v3.size(); var10++) {
            if (!var9.v27().v1()) {
               var3++;
            }

            var9 = this.v1(var9, var8);
         }
      }

      return var3;
   }

   public boolean v1(HudElement var1, @Nullable HudElement var2, hudRecord3.Part1 var3, hudRecord3.Part2 var4, boolean var5, float var6, float var7, float var8) {
      if (this.v1(var1) && (var2 == null || this.v1(var2))) {
         accountSupport6 var9 = this.v6;
         if (!this.v1(var9, var1, var2, var3, var4, var5, var6, var7, var8)) {
            return false;
         } else {
            this.v3(var9);
            return true;
         }
      } else {
         return false;
      }
   }

   private void v3(accountSupport6 var1) {
      this.v2(var1);

      for (int var2 = 0; var2 < this.v3.size(); var2++) {
         if (var1.v10[var2] == -1) {
            int var3 = var1.v14[var2];
            HudElement var4 = this.v3.get(var2);
            if (var4.v3() != var1.v17[var3] || var4.v5() != var1.v20[var3] || var4.v6() != var1.v21[var3]) {
               var4.v1(var1.v17[var3]);
               var4.v1(var1.v20[var3], var1.v21[var3]);
            }
         }
      }
   }

   public boolean v1(HudElement var1, HudElement var2, float var3, float var4, float var5) {
      if (this.v1(var1) && this.v1(var2) && this.v1(this.v6, var1, var2, var3, var4, var5)) {
         this.v3(this.v6);
         return true;
      } else {
         return false;
      }
   }

   @Nullable
   public hudRecord4 v1(HudElement var1, HudElement var2, float var3, float var4, float var5, List<hudRecord4> var6) {
      if (this.v1(var1) && this.v1(var2) && this.v1(this.v6, var1, var2, var3, var4, var5)) {
         return this.v6.v32 <= this.v15 && !this.v1(this.v6, this.v6.v25[var1.v1], var6, var1.v1) ? this.v8(var1) : null;
      } else {
         return null;
      }
   }

   private boolean v1(accountSupport6 var1, HudElement var2, HudElement var3, float var4, float var5, float var6) {
      int var7 = var2.v1;
      int var8 = var3.v1;
      float var9 = 10.0F * var6;
      this.v1(var1);
      int var10 = var1.v10[var7] == var8 ? var8 : (var1.v10[var8] == var7 ? var7 : -1);
      if (var10 == -1) {
         return false;
      } else {
         this.v1(var1, null);
         var1.v30 = false;
         var1.v2(var4, var5, var6, var9, v2);
         this.v15 = var1.v32;
         int var11 = var1.v9;
         if (this.v12.length < var11) {
            this.v12 = new float[Math.max(var11, this.v12.length * 2)];
            this.v13 = new float[this.v12.length];
         }

         System.arraycopy(var1.v22, 0, this.v12, 0, var11);
         System.arraycopy(var1.v24, 0, this.v13, 0, var11);
         int var12 = var1.v10[var10];
         int var13 = var12 != -1 ? var12 : var7;
         float var14;
         float var15;
         if (var12 != -1) {
            var14 = var1.v22[var12];
            var15 = var1.v24[var12];
         } else {
            int var16 = var10 == var7 ? var8 : var7;
            int var17 = var1.v11[var16];
            boolean var18 = accountSupport6.v3(var17);
            boolean var19 = var17 == 1 || var17 == 3;
            int var20 = var19 ? var10 : var16;
            float var21 = var18 ? var1.v22[var20] : var1.v24[var20];
            boolean var22 = var20 == var8;
            float var23 = var18 ? var1.v15[var8] : var1.v16[var8];
            float var24 = var22 ? var21 : var21 + var23 + var9;
            var14 = var18 ? var24 : var1.v22[var8];
            var15 = var18 ? var1.v24[var8] : var24;
         }

         var1.v4(var7, var8);
         var1.v2(var4, var5, var6, var9, v2);
         v1(var1, var13, var14, var15, var4, var5, var6);
         var1.v2(var4, var5, var6, var9, v2);
         int var25 = 0;

         for (int var26 = 0; var26 < var11; var26++) {
            if (var26 != var7
               && var26 != var8
               && !Float.isNaN(this.v12[var26])
               && !Float.isNaN(var1.v22[var26])
               && (Math.abs(this.v12[var26] - var1.v22[var26]) > 0.5F || Math.abs(this.v13[var26] - var1.v24[var26]) > 0.5F)) {
               var25++;
            }
         }

         this.v14 = var25;
         var1.v30 = true;
         var1.v2(var4, var5, var6, var9, v2);
         return true;
      }
   }

   @Nullable
   public hudRecord4 v1(
      HudElement var1, HudElement var2, hudRecord3.Part1 var3, hudRecord3.Part2 var4, boolean var5, float var6, float var7, float var8, List<hudRecord4> var9
   ) {
      if (this.v1(var1) && this.v1(var2) && this.v1(this.v6, var1, var2, var3, var4, var5, var6, var7, var8)) {
         return this.v6.v32 <= this.v15 && !this.v1(this.v6, this.v6.v25[var1.v1], var9, var1.v1) ? this.v8(var1) : null;
      } else {
         return null;
      }
   }

   public void v1(HudElement var1, float var2, float var3, float var4, float var5, float var6) {
      if (this.v1(var1)) {
         accountSupport6 var7 = this.v6;
         this.v1(var7);
         this.v1(var7, null);
         var7.v30 = false;
         var7.v2(var4, var5, var6, 10.0F * var6, v2);
         var7.v30 = true;
         int var8 = var1.v1;
         v1(var7, var8, var2, var3, var4, var5, var6);
         int var9 = var7.v7(var8);
         HudElement var10 = this.v3.get(var9);
         if (var10.v5() != var7.v20[var9] || var10.v6() != var7.v21[var9]) {
            var10.v1(var7.v20[var9], var7.v21[var9]);
         }
      }
   }

   public int v6() {
      return this.v14;
   }

   private boolean v1(accountSupport6 var1, int var2, List<hudRecord4> var3, int var4) {
      for (int var5 = 0; var5 < var1.v9; var5++) {
         if (var1.v25[var5] == var2 && (var5 == var4 || this.v3(var1, var5))) {
            for (int var6 = 0; var6 < var1.v9; var6++) {
               if (var6 != var5
                  && var1.v25[var6] != -1
                  && v1(var1.v22[var5], var1.v24[var5], var1.v15[var5], var1.v16[var5], var1.v22[var6], var1.v24[var6], var1.v15[var6], var1.v16[var6])) {
                  return true;
               }
            }

            for (int var8 = 0; var8 < var3.size(); var8++) {
               hudRecord4 var7 = (hudRecord4)var3.get(var8);
               if (v1(var1.v22[var5], var1.v24[var5], var1.v15[var5], var1.v16[var5], var7.v2(), var7.v3(), var7.v4(), var7.v5())) {
                  return true;
               }
            }
         }
      }

      return false;
   }

   private boolean v3(accountSupport6 var1, int var2) {
      return var2 >= this.v12.length
         || Float.isNaN(this.v12[var2])
         || Math.abs(this.v12[var2] - var1.v22[var2]) > 0.5F
         || Math.abs(this.v13[var2] - var1.v24[var2]) > 0.5F;
   }

   private static boolean v1(float var0, float var1, float var2, float var3, float var4, float var5, float var6, float var7) {
      return var0 < var4 + var6 - 0.01F && var4 < var0 + var2 - 0.01F && var1 < var5 + var7 - 0.01F && var5 < var1 + var3 - 0.01F;
   }

   private boolean v1(
      accountSupport6 var1,
      HudElement var2,
      @Nullable HudElement var3,
      hudRecord3.Part1 var4,
      hudRecord3.Part2 var5,
      boolean var6,
      float var7,
      float var8,
      float var9
   ) {
      int var10 = var2.v1;
      float var11 = 10.0F * var9;
      this.v1(var1);
      this.v1(var1, null);
      var1.v30 = false;
      var1.v2(var7, var8, var9, var11, v2);
      int var12 = var1.v9;
      int var13 = var1.v10[var10];
      float var14 = Float.NaN;
      float var15 = Float.NaN;
      if (var13 != -1) {
         var14 = var1.v22[var13];
         var15 = var1.v24[var13];
      } else {
         var13 = var1.v8(var10);
         if (var13 != -1) {
            var14 = var1.v22[var13];
            var15 = var1.v24[var13];
            switch (var1.v11[var13]) {
               case 0:
                  var14 = var1.v22[var10] + var1.v15[var10] - var1.v15[var13];
                  break;
               case 1:
                  var14 = var1.v22[var10];
                  break;
               case 2:
               default:
                  var15 = var1.v24[var10] + var1.v16[var10] - var1.v16[var13];
                  break;
               case 3:
                  var15 = var1.v24[var10];
            }
         }
      }

      var1.v5(var10);
      if (var13 != -1) {
         var1.v2(var7, var8, var9, var11, v2);
         v1(var1, var13, var14, var15, var7, var8, var9);
      }

      var1.v2(var7, var8, var9, var11, v2);
      this.v15 = var1.v32;
      if (this.v12.length < var12) {
         this.v12 = new float[Math.max(var12, this.v12.length * 2)];
         this.v13 = new float[this.v12.length];
      }

      System.arraycopy(var1.v22, 0, this.v12, 0, var12);
      System.arraycopy(var1.v24, 0, this.v13, 0, var12);
      if (var3 == null
         || (var6 ? v2(var1, var10, var3.v1, var4.code, var5.code, var7, var8, var9) : v1(var1, var10, var3.v1, var4.code, var5.code, var7, var8, var9))) {
         var1.v2(var7, var8, var9, var11, v2);
         int var16 = 0;

         for (int var17 = 0; var17 < var12; var17++) {
            if (var17 != var10
               && !Float.isNaN(this.v12[var17])
               && !Float.isNaN(var1.v22[var17])
               && (Math.abs(this.v12[var17] - var1.v22[var17]) > 0.5F || Math.abs(this.v13[var17] - var1.v24[var17]) > 0.5F)) {
               var16++;
            }
         }

         this.v14 = var16;
         var1.v30 = true;
         var1.v2(var7, var8, var9, var11, v2);
         return true;
      } else {
         var1.v30 = true;
         return false;
      }
   }

   private static boolean v1(accountSupport6 var0, int var1, int var2, int var3, int var4, float var5, float var6, float var7) {
      if (var0.v10[var2] != -1 && accountSupport6.v6(var0.v11[var2]) == var3) {
         var3 = var0.v11[var2];
         var2 = var0.v10[var2];
      }

      float var8 = 10.0F * var7;
      var0.v2(var5, var6, var7, var8, v2);
      float var9 = var0.v22[var2];
      float var10 = var0.v24[var2];
      if (!var0.v2(var1, var2, var3, var4)) {
         return false;
      } else {
         var0.v2(var5, var6, var7, var8, v2);
         v1(var0, var2, var9, var10, var5, var6, var7);
         return true;
      }
   }

   private static boolean v2(accountSupport6 var0, int var1, int var2, int var3, int var4, float var5, float var6, float var7) {
      if (!var0.v3(var2, var3)) {
         return false;
      } else {
         float var8 = 10.0F * var7;
         var0.v2(var5, var6, var7, var8, v2);
         int var9 = var0.v10[var2];
         if (var9 != -1) {
            float var16 = var0.v22[var9];
            float var17 = var0.v24[var9];
            if (!var0.v3(var1, var2, var3, var4)) {
               return false;
            } else {
               var0.v2(var5, var6, var7, var8, v2);
               v1(var0, var9, var16, var17, var5, var6, var7);
               return true;
            }
         } else {
            float var10 = var0.v22[var2];
            float var11 = var0.v24[var2];
            float var12 = var0.v15[var2];
            float var13 = var0.v16[var2];
            if (!var0.v4(var1, var2, var3, var4)) {
               return false;
            } else {
               var0.v2(var5, var6, var7, var8, v2);
               if (!Float.isNaN(var10) && !Float.isNaN(var0.v22[var2])) {
                  float var14 = var0.v22[var1] + var10 - var0.v22[var2];
                  float var15 = var0.v24[var1] + var11 - var0.v24[var2];
                  switch (var3) {
                     case 0:
                        var14 = var10;
                        break;
                     case 1:
                        var14 = var10 + var12 - var0.v15[var1];
                        break;
                     case 2:
                        var15 = var11;
                        break;
                     default:
                        var15 = var11 + var13 - var0.v16[var1];
                  }

                  v1(var0, var1, var14, var15, var5, var6, var7);
                  return true;
               } else {
                  return true;
               }
            }
         }
      }
   }

   private static void v1(accountSupport6 var0, int var1, float var2, float var3, float var4, float var5, float var6) {
      if (!Float.isNaN(var0.v22[var1]) && !Float.isNaN(var2)) {
         int var7 = var0.v25[var1];
         int var8 = var0.v14[var0.v7(var1)];
         hudSupport52 var9 = var0.v17[var8];
         if (Math.abs(var2 - var0.v22[var1]) > 0.001F) {
            var0.v20[var8] = var9.v3(var4, var0.v28[var7], var0.v26[var7] + var2 - var0.v22[var1]) / var6;
         }

         if (Math.abs(var3 - var0.v24[var1]) > 0.001F) {
            var0.v21[var8] = var9.v4(var5, var0.v29[var7], var0.v27[var7] + var3 - var0.v24[var1]) / var6;
         }
      }
   }

   private static double v2(double var0) {
      return var0;
   }
}
