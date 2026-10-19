package cc.syky.cloud;

import java.util.Arrays;

public final class cloudSupport26 {
   private float[] v1 = new float[32];
   private float[] v2 = new float[32];
   private float[] v3 = new float[32];
   private float[] v4 = new float[32];
   private int v5;

   public cloudSupport26() {
   }

   public void v1() {
      this.v5 = 0;
   }

   public void v1(float var1, float var2, float var3, float var4) {
      if (this.v5 == this.v1.length) {
         int var5 = this.v5 * 2;
         this.v1 = Arrays.copyOf(this.v1, var5);
         this.v2 = Arrays.copyOf(this.v2, var5);
         this.v3 = Arrays.copyOf(this.v3, var5);
         this.v4 = Arrays.copyOf(this.v4, var5);
      }

      this.v1[this.v5] = var1;
      this.v2[this.v5] = var2;
      this.v3[this.v5] = var3;
      this.v4[this.v5] = var4;
      this.v5++;
   }

   public boolean v1(cloudSupport26 var1) {
      if (var1.v5 != this.v5) {
         return false;
      } else {
         for (int var2 = 0; var2 < this.v5; var2++) {
            if (this.v1[var2] != var1.v1[var2] || this.v2[var2] != var1.v2[var2] || this.v3[var2] != var1.v3[var2] || this.v4[var2] != var1.v4[var2]) {
               return false;
            }
         }

         return true;
      }
   }

   public void v2(cloudSupport26 var1) {
      this.v1();

      for (int var2 = 0; var2 < var1.v5; var2++) {
         this.v1(var1.v1[var2], var1.v2[var2], var1.v3[var2], var1.v4[var2]);
      }
   }

   public int v2() {
      return this.v5;
   }

   public float v1(int var1) {
      return this.v1[var1];
   }

   public float v2(int var1) {
      return this.v2[var1];
   }

   public float v3(int var1) {
      return this.v3[var1];
   }

   public float v4(int var1) {
      return this.v4[var1];
   }

   @FunctionalInterface
   public interface Part1 {
      void fill(cloudSupport26 var1);
   }
}
