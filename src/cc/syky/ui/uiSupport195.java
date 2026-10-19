package cc.syky.ui;

import net.minecraft.class_3532;

public final class uiSupport195 {
   public static final double v1 = 1.0;
   public static final double v2 = 0.35;
   private static final double v3 = 10.0;
   private static final float v4 = 0.1F;
   private static final double v5 = 0.25;
   private static final double v6 = 1.0;
   private static final double v7 = 1.12;
   private double v8 = 1.0;
   private double v9;
   private long v10;

   public uiSupport195() {
   }

   public void v1(boolean var1) {
      this.v8 = 1.0;
      this.v9 = var1 ? 0.35 : this.v8;
      this.v10 = 0L;
   }

   public void v1() {
      this.v9 = 0.0;
      this.v10 = 0L;
   }

   public double v2(boolean var1) {
      long var2 = System.nanoTime();
      float var4 = this.v10 == 0L ? 0.0F : Math.min((float)(var2 - this.v10) / 1.0E9F, 0.1F);
      this.v10 = var2;
      if (!var1) {
         this.v9 = this.v8;
      } else if (var4 > 0.0F) {
         this.v9 = this.v9 + (this.v8 - this.v9) * (1.0 - Math.exp(-10.0 * var4));
      }

      return this.v9;
   }

   public void v1(double var1) {
      this.v8 = class_3532.method_15350(this.v8 * Math.pow(1.12, -var1), 0.25, 1.0);
   }
}
