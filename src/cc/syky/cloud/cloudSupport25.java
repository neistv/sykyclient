package cc.syky.cloud;

public final class cloudSupport25 {
   private cloudSupport25() {
   }

   public static void v1(float var0, float var1, float var2, float var3, float var4, float var5, float var6, int var7, int var8, int[] var9) {
      float var10 = (var0 - var4) / var5 * var7;
      float var11 = (var0 + var2 + var4) / var5 * var7;
      float var12 = (1.0F - (var1 + var3 + var4) / var6) * var8;
      float var13 = (1.0F - (var1 - var4) / var6) * var8;
      int var14 = v2(var10 - 0.5F) - 1;
      int var15 = v2(var11 - 0.5F) + 2;
      int var16 = v2(var12 - 0.5F) - 1;
      int var17 = v2(var13 - 0.5F) + 2;
      var9[0] = var14;
      var9[1] = var16;
      var9[2] = var15 - var14 + 1;
      var9[3] = var17 - var16 + 1;
   }

   public static float v1(float var0) {
      return Math.max(2.0F, 1.26F * var0 + 1.0F);
   }

   private static int v2(float var0) {
      return (int)Math.floor(var0);
   }

   public static final class Part1 {
      private int v1;
      private int v2;
      private int v3;
      private int v4;
      private int v5;

      public Part1() {
      }

      public void v1(int var1, int var2) {
         this.v1 = var1;
         this.v2 = var2;
         this.v3 = 0;
         this.v4 = 0;
         this.v5 = 0;
      }

      public boolean v1(int var1, int var2, int[] var3) {
         if (var1 <= this.v1 && var2 <= this.v2) {
            if (this.v3 + var1 > this.v1) {
               this.v4 = this.v4 + this.v5 + 1;
               this.v3 = 0;
               this.v5 = 0;
            }

            if (this.v4 + var2 > this.v2) {
               return false;
            } else {
               var3[0] = this.v3;
               var3[1] = this.v4;
               this.v3 += var1 + 1;
               this.v5 = Math.max(this.v5, var2);
               return true;
            }
         } else {
            return false;
         }
      }
   }

   public static final class Part2 {
      private static final int v1 = 64;
      private final int[] v2 = new int[64];
      private final int[] v3 = new int[64];
      private final int[] v4 = new int[64];
      private final int[] v5 = new int[64];
      private int v6;
      private boolean v7;

      public Part2() {
      }

      public void v1() {
         this.v6 = 0;
         this.v7 = false;
      }

      public void v1(cloudSupport25.Part2 var1) {
         this.v6 = var1.v6;
         this.v7 = var1.v7;
         System.arraycopy(var1.v2, 0, this.v2, 0, this.v6);
         System.arraycopy(var1.v3, 0, this.v3, 0, this.v6);
         System.arraycopy(var1.v4, 0, this.v4, 0, this.v6);
         System.arraycopy(var1.v5, 0, this.v5, 0, this.v6);
      }

      public void v2() {
         this.v6 = 0;
         this.v7 = true;
      }

      public boolean v3() {
         return this.v7;
      }

      public int v4() {
         return this.v6;
      }

      public int v1(int var1) {
         return this.v2[var1];
      }

      public int v2(int var1) {
         return this.v3[var1];
      }

      public int v3(int var1) {
         return this.v4[var1];
      }

      public int v4(int var1) {
         return this.v5[var1];
      }

      public boolean v1(int var1, int var2, int var3, int var4, int var5, int var6) {
         if (this.v7) {
            return true;
         } else {
            var1 = Math.max(var1, 0);
            var2 = Math.max(var2, 0);
            var3 = Math.min(var3, var5 - 1);
            var4 = Math.min(var4, var6 - 1);
            if (var1 <= var3 && var2 <= var4) {
               boolean var7 = true;

               while (var7) {
                  var7 = false;

                  for (int var8 = 0; var8 < this.v6; var8++) {
                     if (var1 <= this.v4[var8] + 1 && this.v2[var8] <= var3 + 1 && var2 <= this.v5[var8] + 1 && this.v3[var8] <= var4 + 1) {
                        var1 = Math.min(var1, this.v2[var8]);
                        var2 = Math.min(var2, this.v3[var8]);
                        var3 = Math.max(var3, this.v4[var8]);
                        var4 = Math.max(var4, this.v5[var8]);
                        this.v5(var8);
                        var7 = true;
                        break;
                     }
                  }
               }

               if (this.v6 == 64) {
                  return false;
               } else {
                  this.v2[this.v6] = var1;
                  this.v3[this.v6] = var2;
                  this.v4[this.v6] = var3;
                  this.v5[this.v6] = var4;
                  this.v6++;
                  return true;
               }
            } else {
               return true;
            }
         }
      }

      public boolean v2(int var1, int var2, int var3, int var4, int var5, int var6) {
         if (this.v7) {
            return true;
         } else {
            var1 = Math.max(var1, 0);
            var2 = Math.max(var2, 0);
            var3 = Math.min(var3, var5 - 1);
            var4 = Math.min(var4, var6 - 1);
            if (var1 <= var3 && var2 <= var4) {
               for (int var7 = 0; var7 < this.v6; var7++) {
                  if (var1 >= this.v2[var7] && var2 >= this.v3[var7] && var3 <= this.v4[var7] && var4 <= this.v5[var7]) {
                     return true;
                  }
               }

               return false;
            } else {
               return true;
            }
         }
      }

      public long v5() {
         long var1 = 0L;

         for (int var3 = 0; var3 < this.v6; var3++) {
            var1 += (long)(this.v4[var3] - this.v2[var3] + 1) * (this.v5[var3] - this.v3[var3] + 1);
         }

         return var1;
      }

      private void v5(int var1) {
         this.v6--;
         this.v2[var1] = this.v2[this.v6];
         this.v3[var1] = this.v3[this.v6];
         this.v4[var1] = this.v4[this.v6];
         this.v5[var1] = this.v5[this.v6];
      }
   }

   public static final class Part3 {
      private static final int v1 = 256;
      private final int[] v2 = new int[256];
      private final int[] v3 = new int[256];
      private final int[] v4 = new int[256];
      private final int[] v5 = new int[256];
      private int v6;
      private int v7;
      private int v8;
      private int v9;
      private int v10;
      private int v11;

      public Part3() {
      }

      public void v1(int var1, int var2) {
         this.v7 = var1;
         this.v8 = var2;
         this.v6 = 0;
         this.v9 = 0;
         this.v10 = 0;
         this.v11 = 0;
      }

      public boolean v1(int var1, int var2, int var3, int var4) {
         if (this.v6 == 256) {
            return false;
         } else {
            this.v2[this.v6] = var1;
            this.v3[this.v6] = var2;
            this.v4[this.v6] = var3;
            this.v5[this.v6] = var4;
            this.v6++;
            return true;
         }
      }

      public boolean v1(int var1, int var2, int[] var3) {
         if (var1 <= this.v7 && var2 <= this.v8 && this.v6 != 256) {
            while (true) {
               if (this.v9 + var1 > this.v7) {
                  this.v10 = this.v10 + this.v11 + 1;
                  this.v9 = 0;
                  this.v11 = 0;
               }

               if (this.v10 + var2 > this.v8) {
                  return false;
               }

               int var4 = this.v2(this.v9, this.v10, this.v9 + var1 - 1, this.v10 + var2 - 1);
               if (var4 < 0) {
                  var3[0] = this.v9;
                  var3[1] = this.v10;
                  this.v1(this.v9, this.v10, this.v9 + var1 - 1, this.v10 + var2 - 1);
                  this.v9 += var1 + 1;
                  this.v11 = Math.max(this.v11, var2);
                  return true;
               }

               this.v9 = this.v4[var4] + 2;
            }
         } else {
            return false;
         }
      }

      private int v2(int var1, int var2, int var3, int var4) {
         for (int var5 = 0; var5 < this.v6; var5++) {
            if (var1 <= this.v4[var5] + 1 && this.v2[var5] - 1 <= var3 && var2 <= this.v5[var5] + 1 && this.v3[var5] - 1 <= var4) {
               return var5;
            }
         }

         return -1;
      }
   }
}
