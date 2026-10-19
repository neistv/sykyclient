package cc.syky.hud;

public record hudRecord4(float x, float y, float width, float height) {
   public static final hudRecord4 EMPTY = new hudRecord4(0.0F, 0.0F, 0.0F, 0.0F);

   public boolean v1() {
      return this.width <= 0.0F || this.height <= 0.0F;
   }

   public boolean v1(float var1, float var2) {
      return var1 >= this.x && var2 >= this.y && var1 <= this.x + this.width && var2 <= this.y + this.height;
   }

   public float v2() {
      return this.x;
   }

   public float v3() {
      return this.y;
   }

   public float v4() {
      return this.width;
   }

   public float v5() {
      return this.height;
   }
}
