package cc.syky.hud;

import cc.syky.ui.uiSupport169;
import com.mojang.blaze3d.textures.GpuTextureView;
import net.minecraft.class_1799;
import org.jetbrains.annotations.Nullable;

public final class hudSupport13 {
   private static final float v1 = 2.0F;
   private static final int v2 = 2048;
   private static final int v3 = 2;
   private static final float v4 = 0.05F;
   private final hudSupport14 v5;
   private int v6;
   private int v7;
   private float v8;
   private float v9;
   @Nullable
   private GpuTextureView v10;

   public hudSupport13(String var1, int var2) {
      this.v5 = new hudSupport14(var1, var2);
   }

   public static float v1(hudSupport40 var0, float var1) {
      float var2 = var0.v5() > 0.0F ? 1.0F / var0.v5() : 1.0F;
      return Math.max(0.05F, var1 * var2);
   }

   public void v1(int var1, float var2, float var3, int var4) {
      int var5 = Math.max(1, Math.round(var2 * var3));
      int var6 = Math.max(1, Math.round(2.0F * var3));
      int var7 = var5 + 2 * var6;
      int var8 = var7 * var1 * 2 <= 2048 ? 2 : 1;
      this.v6 = var7 * var8;
      this.v7 = this.v6 * var1;
      this.v8 = (float)var6 * var8;
      this.v9 = (float)var5 * var8;
      this.v10 = null;
      this.v5.v1(var1, this.v7, this.v6, var4);
   }

   public void v1(int var1, class_1799 var2) {
      this.v5.v1(var1, var2, (var1 + 0.5F) * this.v6, this.v6 * 0.5F, this.v9, var1 * this.v6, 0, this.v6, this.v6);
   }

   @Nullable
   public GpuTextureView v1() {
      this.v10 = this.v5.v1();
      return this.v10;
   }

   public void v1(int var1, float var2, float var3, float var4) {
      GpuTextureView var5 = this.v10;
      if (var5 != null) {
         uiSupport169.v1(var5, var2, var3, var4, var4, this.v1(var1), 1.0F - this.v2(), this.v2(var1), this.v2());
      }
   }

   public void v1(int var1, float var2, float var3, float var4, float var5) {
      GpuTextureView var6 = this.v10;
      if (var6 != null && !(var5 <= 0.0F)) {
         int var7 = Math.round(Math.min(1.0F, var5) * 255.0F);
         int var8 = var7 << 24 | var7 << 16 | var7 << 8 | var7;
         uiSupport169.v1(var6, var2, var3, var4, var4, this.v1(var1), 1.0F - this.v2(), this.v2(var1), this.v2(), var8);
      }
   }

   private float v1(int var1) {
      return (var1 * this.v6 + this.v8) / this.v7;
   }

   private float v2(int var1) {
      return ((var1 + 1) * this.v6 - this.v8) / this.v7;
   }

   private float v2() {
      return this.v8 / this.v6;
   }
}
