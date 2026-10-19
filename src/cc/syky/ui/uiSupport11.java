package cc.syky.ui;

public final class uiSupport11 {
   public static final int v1 = 100;
   private final float[] v2 = new float[100];
   private int v3;
   private int v4;
   private float v5;
   private long v6;
   private int v7;
   private int v8 = -1;
   private int v9 = -1;
   private float v10;

   public uiSupport11() {
   }

   public void v1(float var1, long var2) {
      if (var1 >= 0.0F) {
         this.v2[this.v3] = var1;
         this.v3 = (this.v3 + 1) % 100;
         if (this.v4 < 100) {
            this.v4++;
         }

         this.v5 = var1;
         this.v6 = var2;
         this.v7++;
      }
   }

   public void v1() {
      this.v3 = 0;
      this.v4 = 0;
      this.v5 = 0.0F;
      this.v6 = 0L;
      this.v7++;
   }

   public boolean v2() {
      return this.v4 > 0;
   }

   public float v3() {
      return this.v5;
   }

   public int v4() {
      return this.v4;
   }

   public long v5() {
      return this.v6;
   }

   public float v1(int var1) {
      if (this.v4 == 0) {
         return 0.0F;
      } else {
         int var2 = Math.min(Math.max(var1, 1), this.v4);
         if (this.v9 == this.v7 && this.v8 == var2) {
            return this.v10;
         } else {
            double var3 = 0.0;
            int var5 = this.v3;

            for (int var6 = 0; var6 < var2; var6++) {
               var5 = (var5 == 0 ? 100 : var5) - 1;
               var3 += this.v2[var5];
            }

            this.v8 = var2;
            this.v9 = this.v7;
            this.v10 = (float)(var3 / var2);
            return this.v10;
         }
      }
   }
}
