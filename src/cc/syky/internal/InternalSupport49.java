package cc.syky.internal;

public enum InternalSupport49 {
   FAST(3, 5, 3),
   OPTIMIZED(4, 8, 2),
   ULTRA(12, 20, 0);

   private final int taps;
   private final int most;
   private final int lowRes;

   private InternalSupport49(int var3, int var4, int var5) {
      this.taps = var3;
      this.most = var4;
      this.lowRes = var5;
   }

   public int v1() {
      return this.lowRes;
   }

   public int v1(float var1) {
      return Math.clamp((long)Math.round(this.taps * var1), this.taps, this.most);
   }
}
