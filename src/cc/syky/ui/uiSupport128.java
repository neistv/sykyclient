package cc.syky.ui;

public final class uiSupport128 {
   public static final float v1 = 40.0F;
   private final uiSupport129 v2 = new uiSupport129();
   private final uiSupport129 v3 = new uiSupport129();
   private float v4 = -1.0F;
   private float v5 = 1.0F;
   private float v6 = 1.0F;
   private float v7;

   public uiSupport128() {
   }

   public void v1(int var1) {
      if (!this.v2()) {
         this.v6 = this.v1() ? this.v2.v1() : 1.0F;
         this.v7 = this.v1() ? this.v2.v5() : 0.0F;
         this.v5 = var1 >= 0 ? 1.0F : -1.0F;
         this.v4 = 0.0F;
         this.v2(0.0F);
      }
   }

   public boolean v1() {
      return this.v4 >= 0.0F;
   }

   public boolean v2() {
      return this.v1() && this.v2.v7();
   }

   public void v1(float var1) {
      if (!(this.v4 < 0.0F)) {
         this.v4 += var1;
         if (this.v4 >= 280.0F) {
            this.v4 = -1.0F;
            this.v2.v6();
            this.v3.v6();
         } else {
            this.v2(this.v4 / 280.0F);
         }
      }
   }

   public uiSupport129 v3() {
      return this.v2;
   }

   public uiSupport129 v4() {
      return this.v3;
   }

   private void v2(float var1) {
      this.v2.v1(var1, this.v5);
      this.v3.v2(var1, this.v5);
      this.v3.v3(this.v6, this.v7 * (1.0F - var1));
   }
}
