package cc.syky.ui;

import cc.syky.hud.hudSupport57;
import cc.syky.hud.hudSupport58;
import cc.syky.hud.hudSupport60;

public final class uiSupport125 {
   private static final float v1 = 600.0F;
   private static final float v2 = 350.0F;
   private static final float v3 = 6.0F;
   private long v4;
   private final hudSupport57 v5 = new hudSupport57(0.0F, 90.0F);
   private boolean v6;
   private float v7;
   private float v8;
   private float v9;
   private float v10;
   private float v11;
   private float v12;
   private boolean v13;
   private float v14;

   public uiSupport125() {
   }

   public void v1() {
      this.v4 = System.nanoTime() / 1000000L;
   }

   public void v2() {
      this.v4 = 0L;
      this.v13 = false;
   }

   public void v1(hudSupport58 var1, float var2, float var3, float var4, float var5, float var6, float var7, float var8, float var9) {
      if (!(var1.v3() <= 0.0F) && !(var5 <= 0.0F) && !(var6 <= 0.0F)) {
         float var10 = SignInSupport.v4(4.0F, var7);
         float var11 = SignInSupport.v4(7.0F, var7);
         this.v6 = true;
         this.v8 = var11 - var10;
         this.v7 = var2 + var4 - var11;
         this.v9 = var3;
         this.v10 = var5;
         this.v12 = 6.0F * var7;
         this.v11 = Math.min(var5, Math.max(28.0F * var7, var5 * (var5 / var6)));
         this.v5.v2(!this.v13 && !this.v1(var8, var9) ? 0.0F : 1.0F);
         float var12 = this.v5.v2();
         float var13 = Math.max(hudSupport60.v1(var12), this.v5());
         if (!(var13 <= 0.002F)) {
            uiRecord7 var14 = uiRecord7.v1(this.v8 / 2.0F);
            float var15 = var1.v1() / var1.v3();
            uiSupport169.v1(this.v7, var3 + (var5 - this.v11) * var15, this.v8, this.v11, v1(1308622847, var13), var14);
         }
      } else {
         this.v6 = false;
         this.v13 = false;
         this.v5.v3(0.0F);
      }
   }

   public boolean v1(float var1, float var2) {
      return this.v6 && var1 >= this.v7 - this.v12 && var1 <= this.v7 + this.v8 + this.v12 && var2 >= this.v9 && var2 <= this.v9 + this.v10;
   }

   public boolean v1(hudSupport58 var1, float var2, float var3) {
      if (this.v1(var2, var3) && !(var1.v3() <= 0.0F)) {
         float var4 = this.v1(var1);
         this.v14 = var3 >= var4 && var3 <= var4 + this.v11 ? var3 - var4 : this.v11 / 2.0F;
         this.v13 = true;
         this.v1(var1, var3);
         return true;
      } else {
         return false;
      }
   }

   public boolean v1(hudSupport58 var1, float var2) {
      if (!this.v13) {
         return false;
      } else {
         float var3 = this.v10 - this.v11;
         if (var3 > 0.0F && var1.v3() > 0.0F) {
            float var4 = (var2 - this.v14 - this.v9) / var3;
            var1.v5((var4 <= 0.0F ? 0.0F : (var4 >= 1.0F ? 1.0F : var4)) * var1.v3());
         }

         this.v1();
         return true;
      }
   }

   public boolean v3() {
      if (!this.v13) {
         return false;
      } else {
         this.v13 = false;
         this.v1();
         return true;
      }
   }

   public boolean v4() {
      return this.v13;
   }

   private float v1(hudSupport58 var1) {
      return this.v9 + (this.v10 - this.v11) * (var1.v1() / var1.v3());
   }

   private float v5() {
      if (this.v4 == 0L) {
         return 0.0F;
      } else {
         float var1 = (float)(System.nanoTime() / 1000000L - this.v4);
         if (var1 <= 600.0F) {
            return 1.0F;
         } else {
            float var2 = (var1 - 600.0F) / 350.0F;
            return var2 >= 1.0F ? 0.0F : 1.0F - var2;
         }
      }
   }

   private static int v1(int var0, float var1) {
      int var2 = Math.round((var0 >>> 24 & 0xFF) * Math.max(0.0F, Math.min(1.0F, var1)));
      return var2 << 24 | var0 & 16777215;
   }
}
