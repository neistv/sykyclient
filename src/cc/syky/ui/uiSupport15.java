package cc.syky.ui;

import org.jetbrains.annotations.Nullable;

public final class uiSupport15 {
   public static final float v1 = 260.0F;
   public static final float v2 = 170.0F;
   private static final float v3 = 100.0F;
   private static final float v4 = 750.0F;
   private final int v5;
   private final Object[] v6;
   private final Object[] v7;
   private final Object[] v8;
   private final float[] v9;
   private final boolean[] v10;
   private final uiSupport16 v11 = new uiSupport16();
   private long v12;
   private boolean v13;

   public uiSupport15(int var1) {
      this.v5 = var1;
      this.v6 = new Object[var1];
      this.v7 = new Object[var1];
      this.v8 = new Object[var1];
      this.v9 = new float[var1];
      this.v10 = new boolean[var1];
   }

   public void v1(int var1, @Nullable Object var2) {
      this.v8[var1] = var2;
   }

   public void v1() {
      long var1 = System.nanoTime();
      long var3 = this.v12;
      this.v12 = var1;
      this.v1(var3 == 0L ? 0.0F : (float)(var1 - var3) / 1000000.0F);
   }

   public void v1(float var1) {
      boolean var2 = !this.v13;
      boolean var3 = var1 > 750.0F;
      this.v13 = true;

      for (int var4 = 0; var4 < this.v5; var4++) {
         if (this.v5(var4) && var3 || var2) {
            this.v9[var4] = this.v10[var4] ? 1.0F : 0.0F;
         }
      }

      if (var1 > 100.0F) {
         var1 = 100.0F;
      }

      for (int var5 = 0; var5 < this.v5; var5++) {
         this.v1(var5, var1);
      }
   }

   public void v2() {
      for (int var1 = 0; var1 < this.v5; var1++) {
         this.v5(var1);
         this.v9[var1] = this.v10[var1] ? 1.0F : 0.0F;
         if (!this.v10[var1]) {
            this.v7[var1] = null;
         }
      }

      this.v13 = true;
      this.v12 = 0L;
   }

   public boolean v1(int var1) {
      return this.v9[var1] != (this.v10[var1] ? 1.0F : 0.0F);
   }

   public boolean v2(int var1) {
      return !this.v10[var1] && this.v9[var1] > 0.0F;
   }

   public float v3(int var1) {
      return this.v9[var1];
   }

   public boolean v3() {
      for (int var1 = 0; var1 < this.v5; var1++) {
         if (this.v1(var1)) {
            return true;
         }
      }

      return false;
   }

   public uiSupport16 v4(int var1) {
      this.v11.v1(this.v9[var1]);
      return this.v11;
   }

   private boolean v5(int var1) {
      Object var2 = this.v8[var1];
      if (var2 == this.v6[var1]) {
         return false;
      } else {
         this.v6[var1] = var2;
         if (var2 == null) {
            this.v10[var1] = false;
            return true;
         } else {
            if (this.v10[var1] && this.v9[var1] >= 1.0F) {
               this.v9[var1] = 0.0F;
            }

            this.v7[var1] = var2;
            this.v10[var1] = true;
            return true;
         }
      }
   }

   private void v1(int var1, float var2) {
      float var3 = this.v10[var1] ? 1.0F : 0.0F;
      if (var2 > 0.0F && this.v9[var1] != var3) {
         float var4 = var2 / (this.v10[var1] ? 260.0F : 170.0F);
         this.v9[var1] = this.v10[var1] ? Math.min(1.0F, this.v9[var1] + var4) : Math.max(0.0F, this.v9[var1] - var4);
      }

      if (!this.v10[var1] && this.v9[var1] <= 0.0F) {
         this.v7[var1] = null;
      }
   }
}
