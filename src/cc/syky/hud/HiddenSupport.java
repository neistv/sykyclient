package cc.syky.hud;

import cc.syky.config.BooleanSetting;
import cc.syky.ui.uiRecord7;
import cc.syky.ui.uiSupport155;
import cc.syky.ui.uiSupport169;
import com.mojang.blaze3d.textures.GpuTextureView;
import org.jetbrains.annotations.Nullable;

public abstract class HiddenSupport extends AbstractHudWidget {
   private static final boolean v2 = true;
   private static final String v3 = "Hidden";
   private static final float v4 = 13.0F;
   private static final float v5 = 5.0F;
   private static final float v6 = 9.0F;
   private static final float v7 = 2.0F;
   private static final float v8 = 2.0F;
   private static final long v9 = 250L;
   private final float v10;
   @Nullable
   private BooleanSetting v11;
   private final hudSupport57 v12 = new hudSupport57(0.0F, 130.0F, 85.0F);
   private long v13;

   public HiddenSupport(String var1, int var2, hudSupport52 var3, float var4, float var5, float var6) {
      super(var1, var2, var3, var4, var5);
      this.v10 = var6;
   }

   public final BooleanSetting v44() {
      BooleanSetting var1 = this.v2().v1(new BooleanSetting("hide", false));
      this.v11 = var1;
      return var1;
   }

   public final boolean v47() {
      BooleanSetting var1 = this.v11;
      return var1 != null && var1.getValue();
   }

   @Nullable
   public abstract GpuTextureView v15(hudSupport40 var1);

   @Override
   public final void v2(hudSupport40 var1, hudRecord4 var2, float var3) {
      float var4 = this.v40();
      float var5 = var4 <= 0.0F ? 1.0F : this.v5(var1, var3);
      float var6 = var4 <= 0.0F ? 1.0F : hudSupport15.v1(var4, var5);
      if (var6 > 0.0F) {
         GpuTextureView var7 = this.v15(var1);
         if (var7 != null) {
            this.v1(var1, var7, var2, var4, var3, var6, var5);
         }
      }

      this.v1(var1, var2, var3, var4);
      uiSupport169.v12();
   }

   private float v5(hudSupport40 var1, float var2) {
      if (!hudSupport70.v1()) {
         return 0.0F;
      } else {
         float var3 = 3.0F * var2;
         return var3 > 0.0F ? Math.min(1.0F, 14.0F * var1.v5() / var3) : 1.0F;
      }
   }

   private void v1(hudSupport40 var1, GpuTextureView var2, hudRecord4 var3, float var4, float var5, float var6, float var7) {
      if (var4 <= 0.0F) {
         float var10 = 1.0F;
         float var9 = 0.0F;
         uiSupport169.v1(var2, var3.v2(), var3.v3(), var3.v4(), var3.v5(), 0.0F, var10, 1.0F, var9);
      } else {
         float var8 = 0.0F;
         if (hudSupport15.v2(var7) > 0.0F) {
            var8 = Math.min(hudSupport15.v1(var4) * var5, 14.0F * var1.v5());
         }

         uiSupport169.v1(
            var2,
            var3.v2(),
            var3.v3(),
            var3.v4(),
            var3.v5(),
            var3.v2(),
            var3.v3(),
            var3.v4(),
            var3.v5(),
            var3.v2() + var3.v4() * 0.5F,
            var3.v3() + var3.v5() * 0.5F,
            1.0F,
            1.0F,
            var6,
            var8
         );
      }
   }

   private void v1(hudSupport40 var1, hudRecord4 var2, float var3, float var4) {
      float var5 = hudSupport15.v3(var4);
      if (!(var5 <= 0.0F)) {
         float var6 = 13.0F * var3 + 5.0F * var3 + uiSupport169.v2("syky_sans_strong", "Hidden", 9.0F * var3);
         float var7 = 2.0F * this.v10 * var3;
         float var8 = Math.min(1.0F, Math.min((var2.v4() - var7) / var6, (var2.v5() - var7) / (13.0F * var3)));
         if (var8 > 0.0F) {
            float var9 = var3 * var8;
            float var10 = 13.0F * var9;
            float var11 = 5.0F * var9;
            float var12 = 9.0F * var9;
            float var13 = var6 * var8;
            float var14 = var2.v2() + (var2.v4() - var13) * 0.5F - 2.0F * var9;
            float var15 = var2.v3() + (var2.v5() - var10) * 0.5F;
            float var16 = hudSupport15.v4(var4);
            float var17 = Math.min(hudSupport15.v5(var4) * var9, 14.0F * var1.v5());
            this.v1(var14, var15, var13, var10, 2.0F * var9, var5, var16, var16, var17, var6x -> {
               int var7x = uiSupport155.v1(-1, var6x);
               this.v1(hudSupport49.v20, var14, var15, var10, var10, var7x, uiRecord7.ZERO);
               this.v1("syky_sans_strong", "Hidden", var14 + var10 + var11, uiSupport169.v1(var15 + var10 * 0.5F, var12), var12, var7x);
            });
         }
      }
   }

   private float v40() {
      long var1 = System.nanoTime() / 1000000L;
      boolean var3 = var1 - this.v13 > 250L;
      this.v13 = var1;
      float var4 = this.v47() ? 1.0F : 0.0F;
      if (var3) {
         this.v12.v3(var4);
      } else {
         this.v12.v2(var4);
      }

      return this.v12.v2();
   }
}
