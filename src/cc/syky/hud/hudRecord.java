package cc.syky.hud;

public record hudRecord(
   float stiffness,
   float drag,
   float moveFactor,
   float maxVelocity,
   float maxAcceleration,
   float stopVelocity,
   float stopAcceleration,
   float maxDispFrac,
   float maxDispPx
) {
   public float v1(float var1, float var2) {
      float var3 = Math.min(Math.abs(var1), Math.abs(var2));
      return Math.min(this.maxDispFrac * var3, this.maxDispPx);
   }

   public float v1() {
      return this.stiffness;
   }

   public float v2() {
      return this.drag;
   }

   public float v3() {
      return this.moveFactor;
   }

   public float v4() {
      return this.maxVelocity;
   }

   public float v5() {
      return this.maxAcceleration;
   }

   public float v6() {
      return this.stopVelocity;
   }

   public float v7() {
      return this.stopAcceleration;
   }

   public float v8() {
      return this.maxDispFrac;
   }

   public float v9() {
      return this.maxDispPx;
   }
}
