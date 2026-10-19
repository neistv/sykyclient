package cc.syky.hud;

import java.util.Random;

public final class hudSupport8 {
   public static final int v1 = 1000000;
   public static final double v2 = 0.45;
   public static final double v3 = 0.25;
   public static final double v4 = 4.0;
   public static final long v5 = 3L;
   private static final double v6 = 40.0;
   private static final double v7 = 4.0;
   private static final double v8 = 0.012;
   private static final double v9 = 0.036000000000000004;
   private final Random v10;
   private boolean v11;
   private long v12;
   private double v13;
   private double v14;
   private int v15;

   public hudSupport8() {
      this(new Random());
   }

   public hudSupport8(Random var1) {
      this.v10 = var1;
   }

   public int v1(long var1, int var3, int var4) {
      if (var3 <= 0) {
         return var4;
      } else if (!this.v11 || var1 - this.v12 >= 3L || var1 < this.v12) {
         this.v11 = true;
         this.v12 = var1;
         this.v13 = var3;
         this.v14 = 0.0;
         this.v15 = v1(var4);
         return this.v15;
      } else if (var1 == this.v12) {
         return this.v15;
      } else {
         double var5 = var1 - this.v12;
         this.v12 = var1;
         double var7 = v1(var3 / this.v13, 0.25, 4.0);
         this.v14 = this.v1(var5);
         this.v15 = v1((int)Math.round(var4 * Math.pow(var7, 0.45) * (1.0 + this.v14)));
         this.v13 = this.v13 + (var3 - this.v13) * (1.0 - Math.exp(-var5 / 40.0));
         return this.v15;
      }
   }

   private double v1(double var1) {
      double var3 = Math.exp(-var1 / 4.0);
      double var5 = this.v14 * var3 + this.v10.nextGaussian() * 0.012 * Math.sqrt(1.0 - var3 * var3);
      return v1(var5, -0.036000000000000004, 0.036000000000000004);
   }

   private static int v1(int var0) {
      return Math.max(1, Math.min(1000000, var0));
   }

   private static double v1(double var0, double var2, double var4) {
      return Math.max(var2, Math.min(var4, var0));
   }
}
