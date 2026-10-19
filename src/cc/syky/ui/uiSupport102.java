package cc.syky.ui;

import java.util.Arrays;
import org.jetbrains.annotations.Nullable;

public final class uiSupport102 {
   private int[] v1 = new int[256];
   private int v2;
   private Object[] v3 = new Object[64];
   private int v4;

   public uiSupport102() {
   }

   public void v1() {
      this.v2 = 0;
      this.v4 = 0;
   }

   public void v1(int var1) {
      if (this.v2 == this.v1.length) {
         this.v1 = Arrays.copyOf(this.v1, this.v1.length * 2);
      }

      this.v1[this.v2++] = var1;
   }

   public void v1(float var1) {
      this.v1(Float.floatToRawIntBits(var1));
   }

   public void v1(boolean var1) {
      this.v1(var1 ? 1 : 0);
   }

   public void v1(double var1) {
      long var3 = Double.doubleToRawLongBits(var1);
      this.v1((int)var3);
      this.v1((int)(var3 >>> 32));
   }

   public void v1(@Nullable Object var1) {
      if (this.v4 == this.v3.length) {
         this.v3 = Arrays.copyOf(this.v3, this.v3.length * 2);
      }

      this.v3[this.v4++] = var1;
   }

   public boolean v1(uiSupport102 var1) {
      if (this.v2 == var1.v2 && this.v4 == var1.v4) {
         if (!Arrays.equals(this.v1, 0, this.v2, var1.v1, 0, this.v2)) {
            return false;
         } else {
            for (int var2 = 0; var2 < this.v4; var2++) {
               if (this.v3[var2] != var1.v3[var2]) {
                  return false;
               }
            }

            return true;
         }
      } else {
         return false;
      }
   }

   public void v2(uiSupport102 var1) {
      if (this.v1.length < var1.v2) {
         this.v1 = new int[var1.v1.length];
      }

      System.arraycopy(var1.v1, 0, this.v1, 0, var1.v2);
      this.v2 = var1.v2;
      if (this.v3.length < var1.v4) {
         this.v3 = new Object[var1.v3.length];
      }

      System.arraycopy(var1.v3, 0, this.v3, 0, var1.v4);
      Arrays.fill(this.v3, var1.v4, Math.max(var1.v4, this.v4), null);
      this.v4 = var1.v4;
   }
}
