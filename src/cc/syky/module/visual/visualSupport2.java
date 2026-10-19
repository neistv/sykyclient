package cc.syky.module.visual;

import cc.syky.ui.uiSupport33;

public final class visualSupport2 {
   private final long v1 = v3();
   private final long v2;
   private final visualSupport2.Part1 v3;

   public visualSupport2(long var1, visualSupport2.Part1 var3) {
      this.v2 = var1;
      this.v3 = var3;
   }

   public float v1() {
      long var1 = v3() - this.v1;
      if (var1 <= 0L) {
         uiSupport33.v1();
         return this.v3.apply(0.0F);
      } else if (var1 >= this.v2) {
         return this.v3.apply(1.0F);
      } else {
         uiSupport33.v1();
         return this.v3.apply((float)var1 / (float)this.v2);
      }
   }

   public boolean v2() {
      return v3() - this.v1 >= this.v2;
   }

   private static long v3() {
      return System.nanoTime() / 1000000L;
   }

   @FunctionalInterface
   public interface Part1 {
      float apply(float var1);
   }
}
