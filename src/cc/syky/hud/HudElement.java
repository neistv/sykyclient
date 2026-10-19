package cc.syky.hud;

import cc.syky.cloud.cloudRecord5;
import cc.syky.ui.uiRecord7;
import cc.syky.ui.uiSupport169;
import net.minecraft.class_2960;
import org.jetbrains.annotations.Nullable;

public abstract class HudElement {
   private static final float v2 = 60.0F;
   private static final long v3 = 200000000L;
   private static final float v4 = 0.25F;
   private final String v5;
   private final AutoSupport v6;
   private hudSupport52 v7;
   private final hudSupport46 v8;
   private boolean v9;
   @Nullable
   private hudSupport41 v10;
   public int v1 = -1;
   @Nullable
   private hudRecord3 v11;
   private float v12;
   private float v13;
   private final hudSupport5 v14 = new hudSupport5();
   private final hudSupport6 v15 = new hudSupport6();
   private long v16 = System.nanoTime();
   @Nullable
   private Object v18;
   private float v19;
   private float v17;
   @Nullable
   private hudSupport57 v20;
   private float v21 = Float.NaN;
   private long v22;
   private float v24;
   private hudRecord4 v25 = hudRecord4.EMPTY;
   private final int[] v26 = new int[hudSupport50.v6.length];
   private final int[] v27 = new int[hudSupport50.v7.length];
   private final int[] v28 = new int[]{-1, -1};
   @Nullable
   private hudSupport3 v29;
   private hudRecord4 v30 = hudRecord4.EMPTY;
   private boolean v32;
   private float v23;
   private static final int v33 = 12105912;

   public HudElement(String var1, int var2, hudSupport52 var3, float var4, float var5) {
      if (var1 != null && !var1.isBlank()) {
         this.v5 = var1;
         this.v6 = new AutoSupport(var2);
         this.v7 = var3 != null ? var3 : hudSupport52.TOP_LEFT;
         this.v8 = new hudSupport46(var4, var5);
         this.v9 = true;
      } else {
         throw new IllegalArgumentException("HudElement id must not be blank");
      }
   }

   public final String v1() {
      return this.v5;
   }

   public final AutoSupport v2() {
      return this.v6;
   }

   public final hudSupport52 v3() {
      return this.v7;
   }

   public final void v1(hudSupport52 var1) {
      if (var1 != null) {
         hudSupport52 var2 = this.v2(var1);
         if (var2 != this.v7) {
            this.v8.v1(this.v8.v1(), this.v8.v2());
         }

         this.v7 = var2;
      }
   }

   public boolean v4() {
      return false;
   }

   public final hudSupport52 v2(hudSupport52 var1) {
      return this.v4() && var1.v2() == hudSupport52.Part1.MIDDLE ? var1.v1(hudSupport52.Part1.TOP) : var1;
   }

   public final float v5() {
      return this.v8.v1();
   }

   public final void v1(float var1) {
      this.v8.v1(var1);
   }

   public final float v6() {
      return this.v8.v2();
   }

   public final void v2(float var1) {
      this.v8.v2(var1);
   }

   public final void v1(float var1, float var2) {
      this.v8.v1(var1, var2);
   }

   public final float v7() {
      return this.v8.v3();
   }

   public final float v8() {
      return this.v8.v4();
   }

   public final void v2(float var1, float var2) {
      this.v8.v2(var1, var2);
   }

   public final float v9() {
      float var1 = this.v6.v5();
      hudSupport57 var2 = this.v20;
      if (var2 == null) {
         this.v20 = new hudSupport57(var1, 60.0F);
         return var1;
      } else {
         var2.v2(var1);
         return var2.v2();
      }
   }

   public final void v3(float var1) {
      this.v6.v1(var1);
   }

   public final boolean v10() {
      return this.v9;
   }

   public final void v1(boolean var1) {
      if (this.v9 != var1) {
         this.v9 = var1;
         this.v2(var1);
      }
   }

   public void v2(boolean var1) {
   }

   @Nullable
   public final hudRecord3 v11() {
      return this.v11;
   }

   public final void v1(@Nullable hudRecord3 var1) {
      this.v11 = var1;
   }

   public final boolean v12() {
      return this.v10 != null;
   }

   @Nullable
   public final hudSupport41 v13() {
      return this.v10;
   }

   public final void v1(hudSupport41 var1, int var2) {
      this.v10 = var1;
      this.v1 = var2;
      this.v11 = null;
   }

   public final void v14() {
      this.v10 = null;
      this.v1 = -1;
      this.v11 = null;
   }

   public final float v15() {
      return this.v12 + this.v19;
   }

   public final float v16() {
      return this.v13 + this.v17;
   }

   public final hudSupport5 v18() {
      return this.v14;
   }

   public final boolean v19() {
      return this.v14.v6();
   }

   public void v17() {
   }

   public final void v20() {
      this.v17();
   }

   public final hudSupport6 v21() {
      return this.v15;
   }

   @Nullable
   public Object v1(hudSupport40 var1) {
      return null;
   }

   @Nullable
   public final Object v22() {
      return this.v18;
   }

   public final long v24() {
      return this.v16;
   }

   public final void v1(@Nullable Object var1) {
      this.v18 = var1;
   }

   public final void v1(hudSupport40 var1, long var2, boolean var4) {
      this.v16 = var2;
      Object var5 = this.v1(var1);
      if (var4) {
         this.v15.v1(var5, var2);
      } else {
         this.v15.v1(var5, var2, false);
      }

      this.v18 = this.v15.v1();
   }

   public final void v4(float var1) {
      float var2 = this.v14.v11();
      if (var2 == 0.0F) {
         this.v19 = 0.0F;
         this.v17 = 0.0F;
      } else {
         hudSupport41 var3 = this.v10;
         hudSupport52 var4 = var3 != null ? var3.v5(this) : this.v7;
         float var5 = 6.0F * var2 * var1;
         this.v19 = var5 * var4.v3();
         this.v17 = var5 * var4.v4();
      }
   }

   public final boolean v25() {
      return this.v12 != 0.0F || this.v13 != 0.0F;
   }

   public final void v1(float var1, float var2, float var3, float var4) {
      this.v12 += var1 - var3;
      this.v13 += var2 - var4;
   }

   public final void v5(float var1) {
      this.v12 *= var1;
      this.v13 *= var1;
      if (Math.abs(this.v12) < 0.05F) {
         this.v12 = 0.0F;
      }

      if (Math.abs(this.v13) < 0.05F) {
         this.v13 = 0.0F;
      }
   }

   public final void v26() {
      this.v12 = 0.0F;
      this.v13 = 0.0F;
   }

   public final void v3(float var1, float var2) {
      this.v12 = var1;
      this.v13 = var2;
   }

   public final hudRecord4 v27() {
      return this.v25;
   }

   public final hudSupport3 v28() {
      if (this.v29 == null) {
         this.v29 = new hudSupport3();
      }

      return this.v29;
   }

   @Nullable
   public final hudSupport3 v29() {
      return this.v29;
   }

   public boolean v30() {
      return true;
   }

   public final hudRecord4 v2(hudSupport40 var1) {
      this.v30 = this.v3(var1);
      return this.v30;
   }

   public final hudRecord4 v3(hudSupport40 var1) {
      return this.v1(this.v4(var1));
   }

   public final hudRecord4 v32() {
      return this.v30;
   }

   public final hudRecord4 v23() {
      return this.v1(this.v25);
   }

   public hudRecord4 v4(hudSupport40 var1) {
      this.v10(var1);
      return this.v25;
   }

   public boolean v33() {
      return false;
   }

   public final hudRecord4 v1(hudRecord4 var1) {
      float var2 = this.v15();
      float var3 = this.v16();
      return !var1.v1() && (var2 != 0.0F || var3 != 0.0F) ? new hudRecord4(var1.v2() + var2, var1.v3() + var3, var1.v4(), var1.v5()) : var1;
   }

   public final void v2(hudRecord4 var1) {
      this.v25 = var1 == null ? hudRecord4.EMPTY : var1;
   }

   public final hudRecord4 v2(float var1, float var2, float var3, float var4) {
      hudRecord4 var5 = this.v25;
      if (var5.v2() != var1 || var5.v3() != var2 || var5.v4() != var3 || var5.v5() != var4) {
         var5 = new hudRecord4(var1, var2, var3, var4);
         this.v25 = var5;
      }

      return var5;
   }

   public final float v4(float var1, float var2) {
      return this.v7.v1(var1, var2, this.v8.v1());
   }

   public final float v5(float var1, float var2) {
      return this.v7.v2(var1, var2, this.v8.v2());
   }

   public final float v5(hudSupport40 var1) {
      return var1.v5() * this.v9();
   }

   public float v6(hudSupport40 var1) {
      return this.v5(var1);
   }

   public float v7(hudSupport40 var1) {
      return 18.0F * this.v5(var1);
   }

   public final void v3(boolean var1) {
      this.v32 = var1;
   }

   private static int v1(int var0, int var1) {
      if (var1 == -1) {
         return var0;
      } else {
         int var2 = (var0 >>> 24 & 0xFF) * (var1 >>> 24 & 0xFF) / 255;
         int var3 = (var0 >>> 16 & 0xFF) * (var1 >>> 16 & 0xFF) / 255;
         int var4 = (var0 >>> 8 & 0xFF) * (var1 >>> 8 & 0xFF) / 255;
         int var5 = (var0 & 0xFF) * (var1 & 0xFF) / 255;
         return var2 << 24 | var3 << 16 | var4 << 8 | var5;
      }
   }

   public final int v1(int var1) {
      return v1(var1, this.v6.v12());
   }

   public final int v2(int var1) {
      return v1(var1, this.v6.v13());
   }

   public boolean v31() {
      return this.v6.v6() || this.v6.v7();
   }

   public final void v1(hudSupport40 var1, float var2, float var3, float var4, float var5, float var6) {
      this.v1(var2, var3, var4, var5, var6, this.v5(var1));
   }

   public final void v1(float var1, float var2, float var3, float var4, float var5, float var6) {
      this.v1(var1, var2, var3, var4, var5, var6, 1.0F, 0.0F);
   }

   public final void v1(float var1, float var2, float var3, float var4, float var5, float var6, float var7, float var8) {
      if (var7 > 0.0F) {
         if (this.v6.v8() && !this.v32) {
            uiSupport169.v1(var1, var2, var3, var4, var5, CopiedSupport2.v1(hudSupport66.v5(), var7), hudSupport66.v4() * var6, 0.0F, 0.0F);
         }

         uiRecord7 var9 = uiRecord7.v1(var5);
         if (this.v6.v6() && hudSupport70.v1()) {
            uiSupport169.v1(var1, var2, var3, var4, var9, this.v6.v10(), var7, var8, this.v23, this.v6.v11());
         } else if (this.v6.v6()) {
            uiSupport169.v2(var1, var2, var3, var4, var9, v1(this.v6.v10(), this.v23), var7, var8);
         } else {
            uiSupport169.v1(var1, var2, var3, var4, CopiedSupport2.v1(v1(this.v6.v10(), this.v23), var7), var9);
         }
      }
   }

   public final void v1(float var1, float var2, float var3, float var4, float var5) {
      if (this.v23 > 0.0F) {
         int var6 = Math.min(255, Math.round(this.v23 * 255.0F));
         uiSupport169.v2(var1, var2, var3, var4, var6 << 24 | 12105912, uiRecord7.v1(var5));
      }
   }

   public final void v6(float var1) {
      this.v23 = var1;
   }

   public final float v34() {
      return this.v23;
   }

   public static int v1(int var0, float var1) {
      if (var1 <= 0.0F) {
         return var0;
      } else {
         float var2 = Math.min(1.0F, var1);
         float var3 = (var0 >>> 24) / 255.0F;
         float var4 = var2 + var3 * (1.0F - var2);
         float var5 = var3 * (1.0F - var2) / var4;
         float var6 = var2 / var4 * 255.0F;
         int var7 = Math.min(255, Math.round((var0 >> 16 & 0xFF) * var5 + var6));
         int var8 = Math.min(255, Math.round((var0 >> 8 & 0xFF) * var5 + var6));
         int var9 = Math.min(255, Math.round((var0 & 0xFF) * var5 + var6));
         return Math.min(255, Math.round(var4 * 255.0F)) << 24 | var7 << 16 | var8 << 8 | var9;
      }
   }

   public final float v1(String var1, String var2, float var3, float var4, float var5, int var6) {
      return this.v1(var1, var2, var3, var4, var5, var6, cloudRecord5.NONE);
   }

   public final float v1(String var1, String var2, float var3, float var4, float var5, int var6, cloudRecord5 var7) {
      int var8 = this.v1(var6);
      return this.v6.v7() ? uiSupport169.v2(var1, var2, var3, var4, var5, var8, var7) : uiSupport169.v1(var1, var2, var3, var4, var5, var8, var7);
   }

   public final void v1(CopiedSupport2.Part1 var1, String var2, String var3, float var4, float var5, float var6, float var7, int var8) {
      this.v1(var1, var2, var3, var4, var5, var6, var7, var8, cloudRecord5.NONE);
   }

   public final void v1(CopiedSupport2.Part1 var1, String var2, String var3, float var4, float var5, float var6, float var7, int var8, cloudRecord5 var9) {
      float var10 = var1.v3();
      float var11 = var1.v4();
      float var12 = var1.v1();
      float var13 = var1.v5() * var7;
      if (var10 == 1.0F && var11 == 1.0F && var13 <= 0.0F) {
         this.v1(var2, var3, var4, var5, var7, CopiedSupport2.v1(var8, var12), var9);
      } else {
         float var14 = 0.25F * var7;
         float var15 = var6 + 2.0F * var14;
         float var16 = uiSupport169.v2(var2) * var7 + 2.0F * var14;
         float var17 = var4 - var14 + var15 * 0.5F;
         float var18 = var5 - var14 + var16 * 0.5F;
         float var19 = 2.0F * var13 + 1.0F;
         float var20 = Math.max(var15, var15 * var10 + 2.0F * var19) * 0.5F;
         float var21 = Math.max(var16, var16 * var11 + 2.0F * var19) * 0.5F;
         uiSupport169.v6(var17 - var20, var18 - var21, var20 * 2.0F, var21 * 2.0F);
         boolean var22 = uiSupport169.v5();

         try {
            this.v1(var2, var3, var4, var5, var7, var22 ? var8 : CopiedSupport2.v1(var8, var12), var9);
         } finally {
            if (var22) {
               uiSupport169.v1(var12, var17, var18, var10, var11, var13);
            }

            uiSupport169.v17();
         }
      }
   }

   public final void v1(float var1, float var2, float var3, float var4, float var5, float var6, float var7, float var8, float var9, HudElement.Part1 var10) {
      float var11 = var1 - var5;
      float var12 = var2 - var5;
      float var13 = var3 + 2.0F * var5;
      float var14 = var4 + 2.0F * var5;
      float var15 = var11 + var13 * 0.5F;
      float var16 = var12 + var14 * 0.5F;
      if (var9 <= 0.0F && Math.abs(var7 - 1.0F) * var13 < 1.0F && Math.abs(var8 - 1.0F) * var14 < 1.0F) {
         var10.paint(var6);
      } else {
         float var17 = 2.0F * var9 + 1.0F;
         float var18 = Math.max(var13, var13 * var7 + 2.0F * var17) * 0.5F;
         float var19 = Math.max(var14, var14 * var8 + 2.0F * var17) * 0.5F;
         uiSupport169.v6(var15 - var18, var16 - var19, var18 * 2.0F, var19 * 2.0F);
         boolean var20 = uiSupport169.v5();

         try {
            var10.paint(var20 ? 1.0F : var6);
         } finally {
            if (var20) {
               uiSupport169.v1(var6, var15, var16, var7, var8, var9);
            }

            uiSupport169.v17();
         }
      }
   }

   public final void v1(
      float var1,
      float var2,
      float var3,
      float var4,
      float var5,
      float var6,
      float var7,
      float var8,
      float var9,
      float var10,
      float var11,
      uiRecord7 var12,
      float var13,
      float var14,
      float var15,
      float var16,
      float var17,
      HudElement.Part1 var18
   ) {
      if (!(var10 <= 0.0F) && !(var11 <= 0.0F)) {
         float var19 = var6;
         float var20 = var7;
         float var21 = Math.min(var1 - var5, var8);
         float var22 = Math.min(var2 - var5, var9);
         float var23 = Math.max(var1 + var3 + var5, var8 + var10) - var21;
         float var24 = Math.max(var2 + var4 + var5, var9 + var11) - var22;
         uiSupport169.v6(var21, var22, var23, var24);
         boolean var25 = uiSupport169.v5();

         try {
            var18.paint(var25 ? 1.0F : var13);
         } finally {
            if (var25) {
               uiSupport169.v17();
               float var29 = 2.0F * var16 + 1.0F;
               uiSupport169.v6(var8 - var29, var9 - var29, var10 + 2.0F * var29, var11 + 2.0F * var29);

               try {
                  uiSupport169.v1(var13, var19, var20, var14, var15, var16, 0.0F, 0.0F, 1.0F, var8, var9, var10, var11, var12, var17);
               } finally {
                  uiSupport169.v17();
               }
            } else {
               uiSupport169.v17();
            }
         }
      } else {
         var18.paint(var13);
      }
   }

   public final float v2(String var1, String var2, float var3, float var4, float var5, int var6) {
      int var7 = this.v1(var6);
      return this.v6.v7() ? uiSupport169.v6(var1, var2, var3, var4, var5, var7) : uiSupport169.v3(var1, var2, var3, var4, var5, var7);
   }

   public final void v1(class_2960 var1, float var2, float var3, float var4, float var5) {
      this.v1(var1, var2, var3, var4, var5, -1, uiRecord7.ZERO);
   }

   public final void v1(class_2960 var1, float var2, float var3, float var4, float var5, int var6, uiRecord7 var7) {
      this.v2(var1, var2, var3, var4, var5, this.v2(var6), var7);
   }

   public final void v1(
      class_2960 var1, float var2, float var3, float var4, float var5, float var6, float var7, float var8, float var9, int var10, uiRecord7 var11
   ) {
      int var12 = this.v2(var10);
      if (this.v6.v7()) {
         uiSupport169.v3(var1, var2, var3, var4, var5, var6, var7, var8, var9, var12, var11);
      } else {
         uiSupport169.v1(var1, var2, var3, var4, var5, var6, var7, var8, var9, var12, var11);
      }
   }

   public final void v2(class_2960 var1, float var2, float var3, float var4, float var5, int var6, uiRecord7 var7) {
      if (this.v6.v7()) {
         uiSupport169.v2(var1, var2, var3, var4, var5, var6, var7);
      } else {
         uiSupport169.v1(var1, var2, var3, var4, var5, var6, var7);
      }
   }

   public final void v1(float var1, float var2, float var3, float var4, int var5, uiRecord7 var6) {
      if (this.v6.v7()) {
         uiSupport169.v2(var1, var2, var3, var4, var5, var6);
      } else {
         uiSupport169.v1(var1, var2, var3, var4, var5, var6);
      }
   }

   public final void v1(float var1, float var2, float var3, float var4, int[] var5, uiRecord7 var6) {
      if (this.v6.v7()) {
         uiSupport169.v2(var1, var2, var3, var4, var5, var6);
      } else {
         uiSupport169.v1(var1, var2, var3, var4, var5, var6);
      }
   }

   public final void v1(float var1, float var2, float var3, float var4, int var5, float var6, uiRecord7 var7) {
      if (this.v6.v7()) {
         uiSupport169.v2(var1, var2, var3, var4, var5, var6, var7);
      } else {
         uiSupport169.v1(var1, var2, var3, var4, var5, var6, var7);
      }
   }

   public final void v1(float var1, float var2, float var3) {
      float var4 = this.v6(4.0F, var3);
      this.v3(var1, var2 + var4, this.v6(32.0F, var3) - var4, var3);
   }

   public final void v3(float var1, float var2, float var3, float var4) {
      this.v1(var1, var2, this.v7(var4), var3, this.v1(hudSupport50.v6, this.v26, 0), uiRecord7.ZERO);
   }

   public final float v7(float var1) {
      return Math.max(uiSupport169.v2(), this.v6(1.0F, var1));
   }

   public final float v6(float var1, float var2) {
      return this.v8(var1 * var2);
   }

   public final float v8(float var1) {
      return this.v36() ? uiSupport169.v1(var1) : var1;
   }

   public final float v9(float var1) {
      if (this.v24 <= 0.0F || this.v36()) {
         this.v24 = var1;
      }

      return this.v24;
   }

   public final boolean v36() {
      this.v9();
      float var1 = this.v6.v5();
      if (Float.isNaN(this.v21)) {
         this.v21 = var1;
      } else if (var1 != this.v21) {
         this.v21 = var1;
         this.v22 = this.v24();
      }

      hudSupport57 var2 = this.v20;
      return var2 != null && !var2.v1() ? false : this.v24() - this.v22 >= 200000000L;
   }

   public final void v4(float var1, float var2, float var3, float var4) {
      this.v1(var1, var2, var3, this.v7(var4), this.v1(hudSupport50.v7, this.v27, 1), uiRecord7.ZERO);
   }

   private int[] v1(int[] var1, int[] var2, int var3) {
      int var4 = this.v6.v13();
      if (var4 == -1) {
         return var1;
      } else {
         if (this.v28[var3] != var4) {
            for (int var5 = 0; var5 < var1.length; var5++) {
               var2[var5] = v1(var1[var5], var4);
            }

            this.v28[var3] = var4;
         }

         return var2;
      }
   }

   public void v8(hudSupport40 var1) {
   }

   public abstract hudRecord4 v9(hudSupport40 var1);

   public void v1(hudSupport40 var1, HudElement.Part2 var2) {
      if (var2 == HudElement.Part2.ICONS) {
         this.v9(var1);
      }
   }

   public void v10(hudSupport40 var1) {
   }

   public boolean v11(hudSupport40 var1) {
      return false;
   }

   @Nullable
   public class_2960 v38() {
      return null;
   }

   public boolean v12(hudSupport40 var1) {
      return false;
   }

   public boolean v42() {
      return this.v10 != null || this.v43();
   }

   public boolean v43() {
      return false;
   }

   public boolean v37() {
      return false;
   }

   public boolean v1(hudSupport40 var1, float[] var2) {
      return false;
   }

   public final float v1(hudSupport40 var1, float var2) {
      hudSupport41 var3 = this.v10;
      if (var3 != null) {
         float var4 = var3.v1(this, var1);
         if (!Float.isNaN(var4)) {
            return var4;
         }
      }

      return this.v7.v1(var1.v3(), var2, this.v8.v1() * var1.v5());
   }

   public final float v2(hudSupport40 var1, float var2) {
      hudSupport41 var3 = this.v10;
      if (var3 != null) {
         float var4 = var3.v2(this, var1);
         if (!Float.isNaN(var4)) {
            return var4;
         }
      }

      return this.v7.v2(var1.v4(), var2, this.v8.v2() * var1.v5());
   }

   public hudSupport44 v48() {
      return hudSupport44.DEFAULT;
   }

   public void v13(hudSupport40 var1) {
   }

   public boolean v7(float var1, float var2) {
      return false;
   }

   public boolean v8(float var1, float var2) {
      return false;
   }

   public void v9(float var1, float var2) {
   }

   public void v1(float var1, float var2, boolean var3) {
   }

   public void v10(float var1, float var2) {
   }

   public hudSupport54 v11(float var1, float var2) {
      return hudSupport54.ARROW;
   }

   @FunctionalInterface
   public interface Part1 {
      void paint(float var1);
   }

   public static enum Part2 {
      ICONS,
      TEXT;

      private Part2() {
      }
   }
}
