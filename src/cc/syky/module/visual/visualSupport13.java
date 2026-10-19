package cc.syky.module.visual;

public enum visualSupport13 {
   OPTIMIZED(0.5F, 20, 32.0F, false),
   BALANCED(0.5F, 32, 48.0F, true),
   ULTRA(1.0F, 48, 64.0F, true);

   private final float scale;
   private final int steps;
   private final float reach;
   private final boolean sharpMirrors;

   private visualSupport13(float var3, int var4, float var5, boolean var6) {
      this.scale = var3;
      this.steps = var4;
      this.reach = var5;
      this.sharpMirrors = var6;
   }

   public boolean v1() {
      return this.sharpMirrors;
   }

   public float v2() {
      return this.scale;
   }

   public int v3() {
      return this.steps;
   }

   public float v4() {
      return this.reach;
   }
}
