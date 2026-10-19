package cc.syky.internal;

import cc.syky.sykyRecord7;
import cc.syky.sykyRecord8;
import org.jetbrains.annotations.Nullable;

public final class InternalSupport19 implements InternalSupport18 {
   private sykyRecord7 v2;
   private long v3;
   private float v4;
   private boolean v5;

   public InternalSupport19(sykyRecord7 var1) {
      this.v2 = var1;
      this.v3 = System.nanoTime();
      this.v4 = 0.0F;
      this.v5 = false;
   }

   public synchronized void v1(sykyRecord7 var1) {
      if (var1 != null) {
         this.v2 = var1;
         this.v3 = System.nanoTime();
         this.v4 = 0.0F;
      }
   }

   @Nullable
   @Override
   public synchronized sykyRecord8 v1() {
      if (this.v2 == null) {
         return null;
      } else {
         float var1 = this.v7();
         return sykyRecord8.v1(this.v2, var1, this.v5);
      }
   }

   @Override
   public synchronized void v2() {
      if (this.v5) {
         this.v5 = false;
         this.v3 = System.nanoTime();
      } else {
         this.v4 = this.v7();
         this.v5 = true;
      }
   }

   @Override
   public synchronized void v3() {
      this.v3 = System.nanoTime();
      this.v4 = 0.0F;
   }

   @Override
   public synchronized void v4() {
      this.v3 = System.nanoTime();
      this.v4 = 0.0F;
   }

   @Override
   public boolean v5() {
      return true;
   }

   @Override
   public synchronized void v1(float var1) {
      if (this.v2 != null) {
         float var2 = var1;
         if (var1 < 0.0F) {
            var2 = 0.0F;
         }

         int var3 = this.v2.v3();
         if (var3 > 0 && var2 > var3) {
            var2 = var3;
         }

         this.v4 = var2;
         this.v3 = System.nanoTime();
      }
   }

   private float v7() {
      if (this.v2 == null) {
         return 0.0F;
      } else {
         float var1 = this.v5 ? this.v4 : this.v4 + (float)(System.nanoTime() - this.v3) * 1.0E-9F;
         int var2 = this.v2.v3();
         if (var2 > 0 && var1 >= var2) {
            var1 %= var2;
            this.v4 = 0.0F;
            this.v3 = System.nanoTime() - (long)(var1 * 1.0E9F);
         }

         return var1;
      }
   }
}
