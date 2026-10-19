package cc.syky.hud;

import cc.syky.cloud.cloudSupport101;
import cc.syky.config.BooleanSetting;
import cc.syky.config.IntSetting;
import cc.syky.ui.uiRecord7;
import cc.syky.ui.uiSupport15;
import cc.syky.ui.uiSupport155;
import cc.syky.ui.uiSupport16;
import cc.syky.ui.uiSupport169;
import com.mojang.blaze3d.textures.GpuTextureView;
import java.util.concurrent.atomic.AtomicInteger;
import net.minecraft.class_1661;
import net.minecraft.class_1799;
import net.minecraft.class_310;
import net.minecraft.class_3532;
import net.minecraft.class_746;

public final class hudSupport7 extends AbstractHudWidget {
   public static final String v2 = "inventory_hud";
   private static final float v3 = 276.0F;
   private static final float v4 = 108.0F;
   private static final float v5 = 20.0F;
   private static final float v6 = 1.0F;
   private static final int v7 = 654311423;
   private static final int v8 = -1;
   private static final float[] v9 = new float[]{8.0F, 43.0F, 78.0F};
   private static final float v10 = 22.0F;
   private static final float[] v11 = new float[]{29.0F, 60.0F, 91.0F, 122.0F, 153.0F, 184.0F, 215.0F, 246.0F};
   private static final float[] v12 = new float[]{36.0F, 71.0F};
   private static final float v13 = 260.0F;
   private static final float v14 = 8.0F;
   private static final float[] v15 = new float[]{0.0F, 29.0F, 60.0F, 91.0F, 122.0F, 153.0F, 184.0F, 215.0F, 246.0F, 276.0F};
   private static final float v16 = 16.0F;
   private static final float v18 = 10.0F;
   private static final float v19 = 1.12F;
   private static final float v17 = 1.4F;
   private static final float v20 = 20.0F;
   private static final int v21 = 2048;
   private static final float v22 = 0.05F;
   private static final int v24 = 9;
   private static final int v25 = 9;
   private static final int v26 = 3;
   private static final int v27 = 27;
   private static final String v28 = "inventory_hud_pop";
   private static final float v29 = 14.0F;
   private static final float v30 = 16.0F;
   private final cloudSupport101 v32;
   private final BooleanSetting v23;
   private final IntSetting v33;
   private final hudSupport14 v31 = new hudSupport14("inventory_hud", 27);
   private final uiSupport15 v34 = new uiSupport15(27);
   private final class_1799[] v36 = new class_1799[27];
   private int v38;
   private int v42;
   private static final AtomicInteger v43 = new AtomicInteger();
   private static final int v37 = 2;

   public static void v40() {
      v43.incrementAndGet();
   }

   public hudSupport7(cloudSupport101 var1, hudSupport52 var2, float var3, float var4) {
      super("inventory_hud", 43, var2, var3, var4);
      this.v32 = var1;
      this.v23 = this.v2().v1(new BooleanSetting("hideWhenEmpty", true));
      this.v33 = this.v2().v1(new IntSetting("countSize", 100, 50, 140));
   }

   @Override
   public boolean v11(hudSupport40 var1) {
      class_310 var2 = this.v32.v1();
      class_746 var3 = var2 == null ? null : var2.field_1724;
      return var3 == null ? true : this.v23.getValue() && v1(var3.method_31548());
   }

   private static boolean v1(class_1661 var0) {
      for (int var1 = 0; var1 < 27; var1++) {
         if (!var0.method_5438(9 + var1).method_7960()) {
            return false;
         }
      }

      return true;
   }

   @Override
   public float a_(hudSupport40 var1) {
      return this.v5(var1) * 1.12F;
   }

   @Override
   public AbstractHudWidget.Part1 v3(hudSupport40 var1, float var2) {
      return this.v12(this.v6(276.0F, var2), this.v6(108.0F, var2));
   }

   @Override
   public float v3(hudSupport40 var1, hudRecord4 var2, float var3) {
      return 20.0F * var3;
   }

   @Override
   public boolean v30() {
      return true;
   }

   @Override
   public void v2(hudSupport40 var1, hudRecord4 var2, float var3) {
      this.v2(var2.v2(), var2.v3(), var3);
      class_310 var4 = this.v32.v1();
      class_746 var5 = var4 == null ? null : var4.field_1724;
      if (var5 != null) {
         class_1661 var6 = var5.method_31548();
         float var7 = this.v5(var1) * 1.4F;
         hudSupport7.Part1 var8 = this.v5(var1, var3);
         boolean var9 = this.v1(var6, var8);
         if (var9) {
            this.v38 = 0;
         } else {
            this.v2(var6);
         }

         this.v1(var2, var6, var8, var9);
         this.v1(var1, var2, var3, var8);
         this.v1(var2, var3, var7, var6, var9);
      }
   }

   private boolean v1(class_1661 var1, hudSupport7.Part1 var2) {
      return this.v23.getValue() && this.v19() && v1(var1) ? !this.v31.v2() && this.v42 == 0 && this.v31.v1(var2.v2(), var2.v3(), v43.get()) : false;
   }

   private void v2(class_1661 var1) {
      for (int var2 = 0; var2 < 27; var2++) {
         class_1799 var3 = var1.method_5438(9 + var2);
         this.v34.v1(var2, var3.method_7960() ? null : var3.method_7909());
      }

      if (this.v18().v3()) {
         this.v34.v2();
      } else {
         this.v34.v1();
      }

      int var6 = 0;

      for (int var7 = 0; var7 < 27; var7++) {
         if (this.v34.v1(var7)) {
            var6 |= 1 << var7;
         }

         if (!this.v34.v2(var7)) {
            class_1799 var4 = var1.method_5438(9 + var7);
            class_1799 var5 = this.v36[var7];
            if (var5 == null || var4.method_7947() != var5.method_7947() || !class_1799.method_31577(var4, var5)) {
               this.v36[var7] = var4.method_7972();
            }
         }
      }

      this.v38 = var6;
   }

   private void v2(float var1, float var2, float var3) {
      float var4 = this.v7(var3);
      int var5 = this.v2(654311423);
      float var6 = this.v6(8.0F, var3);
      float var7 = this.v6(268.0F, var3) - var6;

      for (float var11 : v12) {
         this.v1(var1 + var6, var2 + this.v6(var11, var3), var7, var4, var5, uiRecord7.ZERO);
      }

      for (float var22 : v9) {
         float var12 = this.v6(var22, var3);
         float var13 = this.v6(var22 + 22.0F, var3) - var12;
         float var14 = var2 + var12;

         for (float var18 : v11) {
            this.v1(var1 + this.v6(var18, var3), var14, var4, var13, var5, uiRecord7.ZERO);
         }
      }
   }

   private hudSupport7.Part1 v5(hudSupport40 var1, float var2) {
      float var3 = var1.v5() > 0.0F ? 1.0F / var1.v5() : 1.0F;
      float var4 = this.v9(Math.max(0.05F, var2 * var3));
      int var5 = Math.max(1, Math.round(276.0F * var4));
      int var6 = Math.max(1, Math.round(108.0F * var4));
      int var7 = var5 * 2 <= 2048 && var6 * 2 <= 2048 ? 2 : 1;
      float var8 = var4 * var7;
      return new hudSupport7.Part1(var8, var5 * var7, var6 * var7, 20.0F * var8);
   }

   private void v1(hudRecord4 var1, class_1661 var2, hudSupport7.Part1 var3, boolean var4) {
      GpuTextureView var5;
      if (var4) {
         var5 = this.v31.v2(var3.v2(), var3.v3(), v43.get());
      } else {
         this.v2(var2, var3);
         var5 = this.v31.v1();
         this.v42 = this.v38;
      }

      if (var5 != null) {
         uiSupport169.v1(var5, var1.v2(), var1.v3(), var1.v4(), var1.v5(), 0.0F, 1.0F, 1.0F, 0.0F);
         uiSupport169.v12();
      }
   }

   private void v2(class_1661 var1, hudSupport7.Part1 var2) {
      float var3 = var2.v1();
      int var4 = this.v38;
      this.v31.v1(27, var2.v2(), var2.v3(), v43.get());

      for (int var5 = 0; var5 < 3; var5++) {
         float var6 = v9[var5];
         float var7 = (var6 + 11.0F) * var3;
         int var8 = (int)Math.floor(var6 * var3);
         int var9 = (int)Math.ceil((var6 + 22.0F) * var3);

         for (int var10 = 0; var10 < 9; var10++) {
            int var11 = var5 * 9 + var10;
            class_1799 var12 = (var4 & 1 << var11) != 0 ? class_1799.field_8037 : var1.method_5438(9 + var11);
            float var13 = v15[var10] + (var10 == 0 ? 0.0F : 1.0F);
            int var14 = (int)Math.floor(var13 * var3);
            int var15 = (int)Math.ceil(v15[var10 + 1] * var3);
            this.v31.v1(var11, var12, v3(var10) * var3, var7, var2.v4(), var14, var8, var15 - var14, var9 - var8);
         }
      }
   }

   private void v1(hudSupport40 var1, hudRecord4 var2, float var3, hudSupport7.Part1 var4) {
      if (this.v38 != 0) {
         float var5 = var4.v1();
         int var6 = this.v38;
         GpuTextureView var7 = uiSupport169.v1("inventory_hud_pop", var4.v2(), var4.v3(), true, (var4x, var5x) -> {
            for (int var6x = 0; var6x < 27; var6x++) {
               if ((var6 & 1 << var6x) != 0) {
                  class_1799 var7x = this.v36[var6x];
                  if (var7x != null && !var7x.method_7960()) {
                     float var8x = v3(var6x % 9) * var5;
                     float var9x = (v9[var6x / 9] + 11.0F) * var5;
                     hudSupport67.v1(var5x, var7x, var8x, var9x, var4.v4());
                  }
               }
            }
         });
         if (var7 != null) {
            for (int var8 = 0; var8 < 27; var8++) {
               if ((var6 & 1 << var8) != 0) {
                  uiSupport16 var9 = this.v34.v4(var8);
                  float var10 = var9.v1();
                  float var11 = var9.v2();
                  float var12 = var9.v3();
                  float var13 = var9.v4() * var1.v5();
                  float var14 = var2.v2() + v3(var8 % 9) * var3;
                  float var15 = var2.v3() + (v9[var8 / 9] + 11.0F) * var3;
                  float var16 = 14.0F * var3;
                  float var17 = 16.0F * var3;
                  boolean var18 = uiSupport169.v1(
                     var7,
                     var2.v2(),
                     var2.v3(),
                     var2.v4(),
                     var2.v5(),
                     var14 - var16,
                     var15 - var17,
                     var16 * 2.0F,
                     var17 * 2.0F,
                     var14,
                     var15,
                     var11,
                     var12,
                     var10,
                     var13
                  );
                  if (!var18) {
                     v1(var7, var2, var14, var15, var16, var17);
                  }
               }
            }
         }
      }
   }

   private static void v1(GpuTextureView var0, hudRecord4 var1, float var2, float var3, float var4, float var5) {
      float var6 = (var2 - var4 - var1.v2()) / var1.v4();
      float var7 = (var2 + var4 - var1.v2()) / var1.v4();
      float var8 = 1.0F - (var3 - var5 - var1.v3()) / var1.v5();
      float var9 = 1.0F - (var3 + var5 - var1.v3()) / var1.v5();
      uiSupport169.v1(var0, var2 - var4, var3 - var5, var4 * 2.0F, var5 * 2.0F, var6, var8, var7, var9);
   }

   private void v1(hudRecord4 var1, float var2, float var3, class_1661 var4, boolean var5) {
      for (int var6 = 0; var6 < 27; var6++) {
         class_1799 var7;
         if (var5) {
            var7 = this.v31.v1(var6);
         } else {
            var7 = this.v34.v2(var6) ? this.v36[var6] : var4.method_5438(9 + var6);
         }

         if (var7 != null && !var7.method_7960() && (var7.method_7947() > 1 || var7.method_7986())) {
            float var8 = var1.v2() + v3(var6 % 9) * var2;
            float var9 = var1.v3() + (v9[var6 / 9] + 11.0F) * var2;
            float var10 = var3;
            float var11 = var3;
            float var12 = 1.0F;
            if (!var5 && this.v34.v1(var6)) {
               uiSupport16 var13 = this.v34.v4(var6);
               var10 = var3 * var13.v2();
               var11 = var3 * var13.v3();
               var12 = var13.v1();
            }

            this.v1(var7, var8 - 16.0F * var10 * 0.5F, var9 - 16.0F * var11 * 0.5F, var10, var11, var12);
         }
      }
   }

   private void v1(class_1799 var1, float var2, float var3, float var4, float var5, float var6) {
      if (var1.method_7986() && var1.method_7936() > 0) {
         float var7 = Math.clamp((float)(var1.method_7936() - var1.method_7919()) / var1.method_7936(), 0.0F, 1.0F);
         float var8 = var2 + 2.0F * var4;
         float var9 = var3 + 13.0F * var5;
         float var10 = 13.0F * var4;
         float var11 = 2.0F * var5;
         uiSupport169.v1(var8, var9, var10, var11, uiSupport155.v1(-16777216, var6));
         uiSupport169.v1(var8, var9, var10 * var7, var11, uiSupport155.v1(0xFF000000 | class_3532.method_15369(var7 / 3.0F, 1.0F, 1.0F), var6));
      }

      int var13 = var1.method_7947();
      if (var13 > 1) {
         String var14 = Integer.toString(var13);
         float var15 = 10.0F * var5 * this.v33.getValue().intValue() / 100.0F;
         float var16 = var2 + 16.0F * var4;
         float var17 = var3 + 16.0F * var5 - var15;
         float var12 = Math.max(1.0F, var5);
         uiSupport169.v2("syky_sans_strong", var14, var16 + var12, var17 + var12, var15, uiSupport155.v1(-12632257, var6));
         uiSupport169.v2("syky_sans_strong", var14, var16, var17, var15, uiSupport155.v1(this.v1(-1), var6));
      }
   }

   private static float v3(int var0) {
      float var1 = v15[var0] + (var0 == 0 ? 0.0F : 1.0F);
      return (var1 + v15[var0 + 1]) * 0.5F;
   }

   public record Part1(float factor, int texW, int texH, float itemSize) {
      public float v1() {
         return this.factor;
      }

      public int v2() {
         return this.texW;
      }

      public int v3() {
         return this.texH;
      }

      public float v4() {
         return this.itemSize;
      }
   }
}
