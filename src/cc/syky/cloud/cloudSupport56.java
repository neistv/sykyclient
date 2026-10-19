package cc.syky.cloud;

public enum cloudSupport56 {
   NONE(0.2126F, 0.7152F, 0.0722F),
   RED(0.6F, 0.3F, 0.1F),
   ORANGE(0.45F, 0.42F, 0.13F),
   YELLOW(0.32F, 0.55F, 0.13F),
   GREEN(0.15F, 0.7F, 0.15F),
   BLUE(0.12F, 0.3F, 0.58F);

   private final float r;
   private final float g;
   private final float b;

   private cloudSupport56(float var3, float var4, float var5) {
      this.r = var3;
      this.g = var4;
      this.b = var5;
   }

   public float v1() {
      return this.r;
   }

   public float v2() {
      return this.g;
   }

   public float v3() {
      return this.b;
   }
}
