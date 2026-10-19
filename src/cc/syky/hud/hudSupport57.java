package cc.syky.hud;

import cc.syky.ui.uiSupport33;
import cc.syky.ui.uiSupport34;

public final class hudSupport57 {
   private static final float v1 = 100.0F;
   private static final float v2 = 0.001F;
   private final float v3;
   private final float v4;
   private float v5;
   private float v6;
   private long v7;
   private float v8;
   private boolean v9 = true;

   public hudSupport57(float var1, float var2) {
      this(var1, var2, var2);
   }

   public hudSupport57(float var1, float var2, float var3) {
      this.v5 = var1;
      this.v6 = var1;
      this.v3 = Math.max(1.0F, var2);
      this.v4 = Math.max(1.0F, var3);
   }

   public hudSupport57 v1(float var1) {
      this.v8 = Math.max(0.0F, var1);
      return this;
   }

   public void v2(float var1) {
      this.v6 = var1;
   }

   public boolean v1() {
      return this.v5 == this.v6;
   }

   public void v3(float var1) {
      this.v5 = this.v6 = var1;
   }

   public float v2() {
      long var1 = System.nanoTime();
      long var3 = this.v7;
      this.v7 = var1;
      if (this.v5 == this.v6) {
         this.v9 = true;
         return this.v5;
      } else {
         boolean var5 = this.v9;
         this.v9 = false;
         if (var3 == 0L) {
            uiSupport33.v1();
            return this.v5;
         } else {
            if (var5) {
               var3 = uiSupport34.v1(var3, var1);
            }

            float var6 = (float)(var1 - var3) / 1000000.0F;
            if (var6 > 100.0F) {
               var6 = 100.0F;
            }

            if (var6 <= 0.0F) {
               uiSupport33.v1();
               return this.v5;
            } else {
               float var7 = this.v6 > this.v5 ? this.v3 : this.v4;
               float var8 = this.v6 - this.v5;
               float var9 = var8 * (1.0F - (float)Math.exp(-var6 / var7));
               if (this.v8 > 0.0F) {
                  float var10 = this.v8 * var6;
                  if (Math.abs(var8) <= var10) {
                     this.v5 = this.v6;
                  } else {
                     this.v5 = this.v5 + (Math.abs(var9) < var10 ? Math.copySign(var10, var8) : var9);
                     uiSupport33.v1();
                  }

                  return this.v5;
               } else {
                  this.v5 += var9;
                  if (Math.abs(this.v6 - this.v5) < 0.001F) {
                     this.v5 = this.v6;
                  } else {
                     uiSupport33.v1();
                  }

                  return this.v5;
               }
            }
         }
      }
   }
}
