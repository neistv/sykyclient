package cc.syky.ui;

public final class uiSupport19 {
   public static final long v1 = 1000000000L;
   private boolean v2;
   private long v3;
   private long v4;
   private int v5;

   public uiSupport19() {
   }

   public int v1(long var1, long var3, long var5, int var7) {
      if (!this.v2) {
         this.v1(var1, var3);
         return var7;
      } else {
         long var8 = var3 - this.v4;
         if (var8 > var5 + 1000000000L) {
            this.v1(var1, var3);
            this.v5 = 0;
         } else if (var8 >= var5) {
            this.v5 = (int)Math.round((var1 - this.v3) * 1.0E9 / var8);
            this.v1(var1, var3);
         }

         return this.v5 > 0 ? this.v5 : var7;
      }
   }

   private void v1(long var1, long var3) {
      this.v2 = true;
      this.v3 = var1;
      this.v4 = var3;
   }
}
