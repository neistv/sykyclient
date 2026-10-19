package cc.syky.ui;

public final class uiSupport217 {
   public static final int v1 = 20;
   public static final int v2 = 3;
   private int v3;
   private int v4;

   public uiSupport217() {
   }

   public boolean v1() {
      return this.v3 < 3 && this.v4 == 0;
   }

   public void v2() {
      this.v3++;
      this.v4 = 20;
   }

   public void v3() {
      if (this.v4 > 0) {
         this.v4--;
      }
   }

   public boolean v4() {
      return this.v3 >= 3 && this.v4 == 0;
   }

   public void v5() {
      this.v3 = 0;
      this.v4 = 0;
   }
}
