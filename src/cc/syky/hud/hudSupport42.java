package cc.syky.hud;

import cc.syky.ui.uiSupport169;

public final class hudSupport42 {
   private final hudSupport65 v1 = new hudSupport65();
   private final hudSupport65 v2 = new hudSupport65();
   private final int[] v3 = new int[32];

   public hudSupport42() {
   }

   public void v1() {
      this.v1.v1();
   }

   public boolean v1(hudRecord4 var1, float var2, float var3) {
      return this.v1.v1(var1.v2(), var1.v3(), var1.v4(), var1.v5(), var2, var3, 0.0F, 0.0F);
   }

   public void v1(int var1, hudSupport42.Part1 var2) {
      int var3 = this.v1.v2();
      int var4 = 0;

      while (var4 < var3) {
         this.v3[var4] = var4++;
      }

      for (int var7 = 0; var7 < var3; var7++) {
         for (int var5 = var7 + 1; var5 < var3; var5++) {
            if (this.v1(var7, var5)) {
               this.v2(var7, var5);
            }
         }
      }

      for (int var8 = 0; var8 < var3; var8++) {
         if (this.v2(var8) == var8) {
            this.v2.v1();
            boolean var9 = false;

            for (int var6 = var8; var6 < var3; var6++) {
               if (this.v2(var6) == var8) {
                  this.v2.v1(this.v1, var6);
                  var9 |= this.v1.v9(var6);
               }
            }

            if (var9) {
               var2.emit(this.v2, var1);
            }
         }
      }
   }

   public void v1(int var1) {
      this.v1(var1, uiSupport169::v1);
   }

   private boolean v1(int var1, int var2) {
      float var3 = Math.max(this.v1.v10(var1), this.v1.v10(var2));
      return this.v1.v1(var1) - var3 < this.v1.v1(var2) + this.v1.v3(var2)
         && this.v1.v1(var2) - var3 < this.v1.v1(var1) + this.v1.v3(var1)
         && this.v1.v2(var1) - var3 < this.v1.v2(var2) + this.v1.v4(var2)
         && this.v1.v2(var2) - var3 < this.v1.v2(var1) + this.v1.v4(var1);
   }

   private void v2(int var1, int var2) {
      int var3 = this.v2(var1);
      int var4 = this.v2(var2);
      if (var3 < var4) {
         this.v3[var4] = var3;
      } else {
         this.v3[var3] = var4;
      }
   }

   private int v2(int var1) {
      while (this.v3[var1] != var1) {
         this.v3[var1] = this.v3[this.v3[var1]];
         var1 = this.v3[var1];
      }

      return var1;
   }

   @FunctionalInterface
   public interface Part1 {
      void emit(hudSupport65 var1, int var2);
   }
}
