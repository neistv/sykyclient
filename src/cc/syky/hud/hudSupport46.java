package cc.syky.hud;

public final class hudSupport46 {
   private float v1;
   private float v2;
   private float v3 = Float.NaN;
   private float v4 = Float.NaN;

   public hudSupport46(float var1, float var2) {
      this.v1 = var1;
      this.v2 = var2;
   }

   public float v1() {
      return this.v1;
   }

   public float v2() {
      return this.v2;
   }

   public void v1(float var1) {
      this.v1 = var1;
      this.v3 = Float.NaN;
   }

   public void v2(float var1) {
      this.v2 = var1;
      this.v4 = Float.NaN;
   }

   public void v1(float var1, float var2) {
      this.v1(var1);
      this.v2(var2);
   }

   public float v3() {
      return Float.isNaN(this.v3) ? this.v1 : this.v3;
   }

   public float v4() {
      return Float.isNaN(this.v4) ? this.v2 : this.v4;
   }

   public void v2(float var1, float var2) {
      if (var1 != this.v1 && Float.isNaN(this.v3)) {
         this.v3 = this.v1;
      }

      this.v1 = var1;
      if (var1 == this.v3) {
         this.v3 = Float.NaN;
      }

      if (var2 != this.v2 && Float.isNaN(this.v4)) {
         this.v4 = this.v2;
      }

      this.v2 = var2;
      if (var2 == this.v4) {
         this.v4 = Float.NaN;
      }
   }
}
