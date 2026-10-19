package cc.syky.hud;

import cc.syky.ui.uiRecord7;
import org.jetbrains.annotations.Nullable;

public abstract class AbstractHudWidget extends HudElement {
   private hudRecord4 v2 = hudRecord4.EMPTY;
   private AbstractHudWidget.Part1 v3 = new AbstractHudWidget.Part1(0.0F, 0.0F);
   private float v4 = 1.0F;
   private static final float v5 = 6.0F;
   private float v6;
   private float v7;
   private float v8;
   private float v9 = 1.0F;
   private float v10;
   private float v11;
   private float v12;
   private float v13 = 1.0F;
   private float v14;
   private float v15;
   private float v16;
   private float v18 = 1.0F;
   private boolean v19;
   private float v17;
   private float v20;
   private float v21;
   private float v22 = 1.0F;
   private float v24 = 1.0F;
   private float v25;
   private float v26;
   private float v27;
   private float v28;
   private float v29;
   private float v30;
   private boolean v32;
   private hudRecord4 v23 = hudRecord4.EMPTY;
   private long v33;

   public final AbstractHudWidget.Part1 v12(float var1, float var2) {
      AbstractHudWidget.Part1 var3 = this.v3;
      if (var3.v1() != var1 || var3.v2() != var2) {
         var3 = new AbstractHudWidget.Part1(var1, var2);
         this.v3 = var3;
      }

      return var3;
   }

   public AbstractHudWidget(String var1, int var2, hudSupport52 var3, float var4, float var5) {
      super(var1, var2, var3, var4, var5);
   }

   public abstract AbstractHudWidget.Part1 v3(hudSupport40 var1, float var2);

   public abstract void v2(hudSupport40 var1, hudRecord4 var2, float var3);

   public void v4(hudSupport40 var1, float var2) {
   }

   public void v4(hudSupport40 var1, hudRecord4 var2, float var3) {
   }

   public final boolean v51() {
      return this.v32;
   }

   public float a_(hudSupport40 var1) {
      return this.v5(var1);
   }

   public float v3(hudSupport40 var1, hudRecord4 var2, float var3) {
      return 0.0F;
   }

   public void v1(hudSupport40 var1, hudRecord4 var2, float var3) {
      this.v1(var2.v2(), var2.v3(), var2.v4(), var2.v5(), this.v50(), var3);
   }

   public final float v50() {
      return this.v21;
   }

   @Override
   public final void v8(hudSupport40 var1) {
      this.v15(var1);
      this.v1(var1, this.v1(this.v40()), this.v22);
   }

   @Override
   public final hudRecord4 v9(hudSupport40 var1) {
      this.v15(var1);
      hudRecord4 var2 = this.v40();
      hudRecord4 var3 = this.v1(var2);
      hudSupport6 var4 = this.v21();
      this.v4(var1, this.v9);
      if (var4.v3()) {
         this.v1(var1, var3, var4);
      } else {
         this.v2(var1, var3, this.v9);
      }

      this.v4 = this.v22;
      this.v2(var2);
      return var2;
   }

   private void v1(hudSupport40 var1, hudRecord4 var2, hudSupport6 var3) {
      this.v4(var1, var2, var3.v7());
      float var4 = var1.v5();
      uiRecord7 var5 = uiRecord7.v1(this.v21);
      float var6 = 7.0F * var4;
      float var7 = 6.0F * var4;
      if (var3.v14()) {
         this.v1(var1, var2, var3.v2(), this.v10, this.v11, this.v13, var5, var6, var7, var3.v8(), var3.v9(), var3.v10() * var4);
      }

      if (var3.v15()) {
         this.v1(var1, var2, var3.v1(), this.v6, this.v7, this.v9, var5, var6, var7, var3.v11(), var3.v12(), var3.v13() * var4);
      }
   }

   private void v1(
      hudSupport40 var1,
      hudRecord4 var2,
      @Nullable Object var3,
      float var4,
      float var5,
      float var6,
      uiRecord7 var7,
      float var8,
      float var9,
      float var10,
      float var11,
      float var12
   ) {
      if (var4 > 0.0F && var5 > 0.0F && !var2.v1()) {
         float var13 = var2.v2() + (var2.v4() - var4) * 0.5F;
         float var14 = var2.v3() + (var2.v5() - var5) * 0.5F;
         hudRecord4 var15 = new hudRecord4(var13, var14, var4, var5);
         this.v1(var3);
         this.v32 = true;

         try {
            this.v1(
               var13,
               var14,
               var4,
               var5,
               var9,
               var2.v2() + var2.v4() * 0.5F,
               var2.v3() + var2.v5() * 0.5F,
               var2.v2(),
               var2.v3(),
               var2.v4(),
               var2.v5(),
               var7,
               var10,
               var2.v4() / var4 * var11,
               var2.v5() / var5 * var11,
               var12,
               var8,
               var4x -> this.v2(var1, var15, var6)
            );
         } finally {
            this.v32 = false;
            this.v1(this.v21().v1());
         }
      }
   }

   public final float v1(hudRecord4 var1, float var2, boolean var3) {
      float var4 = var3 ? this.v10 : this.v6;
      return var4 > 0.0F ? var1.v2() + var2 * var1.v4() / var4 : var1.v2() + var2;
   }

   public final float v2(hudRecord4 var1, float var2, boolean var3) {
      float var4 = var3 ? this.v11 : this.v7;
      return var4 > 0.0F ? var1.v3() + var2 * var1.v5() / var4 : var1.v3() + var2;
   }

   public final hudRecord4 v16(hudSupport40 var1) {
      this.v15(var1);
      return this.v1(this.v40());
   }

   @Override
   public final hudRecord4 v4(hudSupport40 var1) {
      this.v15(var1);
      return this.v40();
   }

   @Override
   public final float v6(hudSupport40 var1) {
      this.v15(var1);
      return this.v22;
   }

   @Override
   public final boolean v33() {
      return true;
   }

   @Override
   public final boolean v37() {
      return false;
   }

   @Override
   public final boolean v43() {
      return true;
   }

   public final float v60() {
      return this.v4;
   }

   private hudRecord4 v40() {
      float var1 = this.v24;
      float var2 = this.v5() * var1;
      float var3 = this.v6() * var1;
      float var4 = this.v3().v1(this.v25, this.v6, var2);
      float var5 = this.v3().v2(this.v26, this.v7, var3);
      float var6 = this.v8(var4) + (this.v3().v1(this.v25, this.v17, var2) - var4);
      float var7 = this.v8(var5) + (this.v3().v2(this.v26, this.v20, var3) - var5);
      hudRecord4 var8 = this.v23;
      if (var8.v2() != var6 || var8.v3() != var7 || var8.v4() != this.v17 || var8.v5() != this.v20) {
         var8 = new hudRecord4(var6, var7, this.v17, this.v20);
         this.v23 = var8;
      }

      return var8;
   }

   private void v15(hudSupport40 var1) {
      if (var1.v1() != this.v33) {
         this.v18(var1);
         this.v33 = var1.v1();
      }
   }

   private void v18(hudSupport40 var1) {
      this.v24 = var1.v5();
      this.v25 = var1.v3();
      this.v26 = var1.v4();
      hudSupport6 var2 = this.v21();
      this.v1(var2);
      this.v1(var1, var2.v1());
      this.v6 = this.v27;
      this.v7 = this.v28;
      this.v8 = this.v29;
      this.v9 = this.v30;
      if (!var2.v3()) {
         this.v17 = this.v6;
         this.v20 = this.v7;
         this.v21 = this.v8;
         this.v22 = this.v9;
         this.v1(var2.v1());
      } else {
         this.v1(var1, var2.v2());
         this.v10 = this.v27;
         this.v11 = this.v28;
         this.v12 = this.v29;
         this.v13 = this.v30;
         this.v1(var2.v1());
         if (!this.v19) {
            this.v14 = this.v10;
            this.v15 = this.v11;
            this.v16 = this.v12;
            this.v18 = this.v13;
         }

         float var3 = var2.v6();
         this.v17 = v2(this.v14, this.v6, var3);
         this.v20 = v2(this.v15, this.v7, var3);
         this.v21 = v2(this.v16, this.v8, var3);
         this.v22 = v2(this.v18, this.v9, var3);
      }
   }

   private void v1(hudSupport6 var1) {
      if (!var1.v3()) {
         this.v19 = false;
      } else if (var1.v5()) {
         this.v19 = this.v17 > 0.0F && this.v20 > 0.0F;
         this.v14 = this.v17;
         this.v15 = this.v20;
         this.v16 = this.v21;
         this.v18 = this.v22;
      }
   }

   private void v1(hudSupport40 var1, @Nullable Object var2) {
      this.v1(var2);
      float var3 = this.a_(var1);
      AbstractHudWidget.Part1 var4 = this.v3(var1, var3);
      this.v27 = var4.v1();
      this.v28 = var4.v2();
      this.v30 = var3;
      hudRecord4 var5 = this.v2;
      if (var5.v4() != this.v27 || var5.v5() != this.v28) {
         var5 = new hudRecord4(0.0F, 0.0F, this.v27, this.v28);
         this.v2 = var5;
      }

      this.v29 = this.v3(var1, var5, var3);
   }

   private static float v2(float var0, float var1, float var2) {
      return var0 + (var1 - var0) * var2;
   }

   public record Part1(float width, float height) {
      public float v1() {
         return this.width;
      }

      public float v2() {
         return this.height;
      }
   }
}
