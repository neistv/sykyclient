package cc.syky.hud;

import java.util.function.LongSupplier;

public final class hudSupport3 {
   private static final int v1 = 5;
   private static final float v2 = 50.0F;
   private static final float v3 = 100.0F;
   private final hudSupport4 v4 = new hudSupport4();
   private final float[] v5 = new float[32];
   private final LongSupplier v6;
   private hudSupport3.Part1 v7 = hudSupport3.Part1.IDLE;
   private boolean v8;
   private int v9 = -1;
   private long v10;
   private float v11;
   private float v12;
   private float v13;
   private float v14;
   private float v15;
   private float v16;
   private float v18;
   private boolean v19;

   public hudSupport3() {
      this(System::nanoTime);
   }

   public hudSupport3(LongSupplier var1) {
      this.v6 = var1;
   }

   public void v1(float var1, float var2, float var3, float var4, float var5, float var6) {
      if (!(var3 <= 0.0F) && !(var4 <= 0.0F)) {
         if (this.v7 == hudSupport3.Part1.IDLE && !this.v8) {
            this.v4.v1(var1, var2, var3, var4);
            this.v11 = 0.0F;
            this.v12 = 0.0F;
         }

         if (this.v7 == hudSupport3.Part1.GLIDING) {
            this.v7 = hudSupport3.Part1.SIMULATING;
         }

         this.v9 = this.v4.v1(var1, var2, var3, var4, var5, var6);
         this.v8 = true;
         this.v19 = false;
         this.v18 = 0.0F;
         this.v10 = this.v6.getAsLong();
         this.v2(var1, var2, var3, var4);
      } else {
         this.v3();
      }
   }

   public void v1() {
      this.v8 = false;
      this.v9 = -1;
   }

   public void v2() {
      if (this.v4()) {
         this.v8 = false;
         this.v9 = -1;
         this.v19 = true;
         if (this.v7 == hudSupport3.Part1.SIMULATING) {
            this.v7 = hudSupport3.Part1.GLIDING;
         }
      }
   }

   public void v3() {
      this.v7 = hudSupport3.Part1.IDLE;
      this.v8 = false;
      this.v9 = -1;
      this.v19 = false;
      this.v11 = 0.0F;
      this.v12 = 0.0F;
      this.v18 = 0.0F;
   }

   public boolean v4() {
      return this.v8 || this.v7 != hudSupport3.Part1.IDLE;
   }

   public boolean v5() {
      return this.v7 == hudSupport3.Part1.GLIDING;
   }

   public boolean v6() {
      return this.v7 != hudSupport3.Part1.IDLE && this.v4.v1() >= 0.05F;
   }

   public void v1(float var1, float var2, float var3, float var4, hudRecord var5) {
      if (this.v4()) {
         if (!(var3 <= 0.0F) && !(var4 <= 0.0F)) {
            long var6 = this.v6.getAsLong();
            boolean var8 = var1 != this.v13 || var2 != this.v14 || var3 != this.v15 || var4 != this.v16;
            if (this.v7 == hudSupport3.Part1.IDLE) {
               if (!var8) {
                  this.v10 = var6;
                  return;
               }

               this.v7 = hudSupport3.Part1.SIMULATING;
            } else if (this.v7 == hudSupport3.Part1.GLIDING && var8 && !this.v19) {
               this.v7 = hudSupport3.Part1.SIMULATING;
            }

            float var9 = (float)(var6 - this.v10) / 1000000.0F;
            this.v10 = var6;
            if (var9 < 0.0F) {
               var9 = 0.0F;
            } else if (var9 > 50.0F) {
               var9 = 50.0F;
            }

            this.v18 = var8 ? 0.0F : this.v18 + var9;
            float var10 = this.v11;
            this.v11 += var9;
            int var11 = 0;

            while (this.v11 >= 10.0F && var11 < 5) {
               float var12 = var9 > 0.0F ? ((var11 + 1) * 10.0F - var10) / var9 : 1.0F;
               var12 = var12 < 0.0F ? 0.0F : (var12 > 1.0F ? 1.0F : var12);
               this.v2(
                  this.v13 + (var1 - this.v13) * var12,
                  this.v14 + (var2 - this.v14) * var12,
                  this.v15 + (var3 - this.v15) * var12,
                  this.v16 + (var4 - this.v16) * var12,
                  var5
               );
               this.v11 -= 10.0F;
               var11++;
               if (this.v7 == hudSupport3.Part1.IDLE) {
                  this.v11 = 0.0F;
                  break;
               }
            }

            if (this.v11 >= 10.0F) {
               this.v11 = 0.0F;
            }

            this.v12 = this.v11 / 10.0F;
            if (this.v7 != hudSupport3.Part1.IDLE) {
               this.v4.v4(var1, var2, var3, var4);
            }

            this.v2(var1, var2, var3, var4);
         } else {
            this.v3();
         }
      }
   }

   public float[] v7() {
      this.v4.v1(this.v5, this.v12);
      return this.v5;
   }

   private void v2(float var1, float var2, float var3, float var4, hudRecord var5) {
      if (this.v7 == hudSupport3.Part1.GLIDING) {
         if (this.v4.v3(var1, var2, var3, var4)) {
            this.v1(var1, var2, var3, var4);
         }
      } else {
         boolean var6 = this.v4.v1(var1, var2, var3, var4, var5);
         if (!this.v4.v2()) {
            this.v1(var1, var2, var3, var4);
         } else {
            if (var6 && this.v8()) {
               this.v7 = hudSupport3.Part1.GLIDING;
            }
         }
      }
   }

   private boolean v8() {
      return !this.v8 || this.v18 >= 100.0F;
   }

   private void v1(float var1, float var2, float var3, float var4) {
      this.v4.v2(var1, var2, var3, var4);
      if (this.v8) {
         this.v4.v1(this.v9);
      }

      this.v7 = hudSupport3.Part1.IDLE;
      this.v11 = 0.0F;
      this.v12 = 0.0F;
      this.v18 = 0.0F;
   }

   private void v2(float var1, float var2, float var3, float var4) {
      this.v13 = var1;
      this.v14 = var2;
      this.v15 = var3;
      this.v16 = var4;
   }

   public static enum Part1 {
      IDLE,
      SIMULATING,
      GLIDING;

      private Part1() {
      }
   }
}
