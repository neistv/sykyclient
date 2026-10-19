package cc.syky.render;

public final class renderSupport32 {
   public static final long v1 = 10000000000L;
   private long v2;
   private boolean v3;

   public renderSupport32() {
   }

   public void v1() {
      this.v2 = System.nanoTime();
      this.v3 = true;
   }

   public boolean v1(long var1) {
      if (this.v3 && var1 - this.v2 >= 10000000000L) {
         this.v3 = false;
         return true;
      } else {
         return false;
      }
   }
}
