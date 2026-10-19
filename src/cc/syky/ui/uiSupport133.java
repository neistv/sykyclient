package cc.syky.ui;

import cc.syky.cloud.cloudRecord5;
import cc.syky.hud.hudSupport60;

public final class uiSupport133 {
   public static final float v1 = 1.0F;
   private uiSupport133.Part1 v3 = uiSupport133.Part1.IDLE;
   private float v4;
   private long v5;
   private float v6;
   private float v7;
   private long v8;
   private float v9;
   private boolean v10;
   public static final float v2 = 0.25F;

   public uiSupport133() {
   }

   public float v1(boolean var1, float var2, long var3) {
      if (!(var2 > 1.0F)) {
         this.v1();
         return 0.0F;
      } else {
         if (this.v3 == uiSupport133.Part1.MOVE) {
            this.v4 = this.v1(var3);
         }

         if (var1) {
            switch (this.v3) {
               case IDLE:
                  this.v3 = uiSupport133.Part1.WAIT;
                  this.v5 = var3 + v1(350.0F);
                  break;
               case WAIT:
                  if (var3 >= this.v5) {
                     this.v1(this.v4 < 0.5F ? 1.0F : 0.0F, var3, 40.0F, false, var2);
                  }
                  break;
               case MOVE:
                  if (this.v10) {
                     this.v1(1.0F, var3, 40.0F, false, var2);
                  } else if (var3 - this.v8 >= v1(this.v9)) {
                     this.v4 = this.v7;
                     this.v3 = uiSupport133.Part1.WAIT;
                     this.v5 = var3 + v1(1000.0F);
                  }
            }

            return this.v4 * var2;
         } else {
            if (this.v4 <= 0.0F) {
               this.v1();
            } else if (this.v3 != uiSupport133.Part1.MOVE || !this.v10) {
               this.v1(0.0F, var3, 160.0F, true, var2);
            }

            return this.v4 * var2;
         }
      }
   }

   public static cloudRecord5 v1(float var0, float var1, float var2, float var3, float var4) {
      float var5 = var3 > 0.0F ? Math.max(0.0F, Math.min(1.0F, var2 / var3)) : 0.0F;
      float var6 = var4 > 0.0F ? Math.max(0.0F, Math.min(1.0F, var3 / (var4 * 0.25F))) : 1.0F;
      float var7 = hudSupport60.v1(var6);
      return cloudRecord5.NONE.v1(var2 > 0.0F ? var0 : -1.0E9F, var1, var4 * var5 * var7, var4 * (1.0F - var5) * var7);
   }

   public void v1() {
      this.v3 = uiSupport133.Part1.IDLE;
      this.v4 = 0.0F;
      this.v10 = false;
   }

   private void v1(float var1, long var2, float var4, boolean var5, float var6) {
      float var7 = Math.abs(var1 - this.v4) * var6;
      if (var7 <= 0.0F) {
         this.v3 = var5 ? uiSupport133.Part1.IDLE : uiSupport133.Part1.WAIT;
         this.v5 = var2 + v1(1000.0F);
         this.v10 = false;
      } else {
         this.v3 = uiSupport133.Part1.MOVE;
         this.v6 = this.v4;
         this.v7 = var1;
         this.v8 = var2;
         this.v9 = var7 / var4 * 1000.0F;
         this.v10 = var5;
      }
   }

   private float v1(long var1) {
      float var3 = this.v9 <= 0.0F ? 1.0F : (float)(var1 - this.v8) / 1000000.0F / this.v9;
      if (var3 >= 1.0F) {
         return this.v7;
      } else if (var3 <= 0.0F) {
         return this.v6;
      } else {
         float var4 = 0.5F - 0.5F * (float)Math.cos(Math.PI * var3);
         return this.v6 + (this.v7 - this.v6) * var4;
      }
   }

   private static long v1(float var0) {
      return (long)(var0 * 1000000.0F);
   }

   public static enum Part1 {
      IDLE,
      WAIT,
      MOVE;

      private Part1() {
      }
   }
}
