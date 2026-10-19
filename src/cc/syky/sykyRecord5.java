package cc.syky;

public record sykyRecord5(int fill, float outline, float lift) {
   public static final int MAX_FILL = 100;
   public static final float MIN_OUTLINE = 0.25F;
   public static final float MAX_OUTLINE = 4.0F;
   public static final float MAX_LIFT = 10.0F;
   public static final sykyRecord5 DEFAULT = new sykyRecord5(28, 1.0F, 1.0F);

   public sykyRecord5(int fill, float outline, float lift) {
      fill = Math.max(0, Math.min(100, fill));
      outline = Float.isNaN(outline) ? 1.0F : Math.max(0.25F, Math.min(4.0F, outline));
      lift = Float.isNaN(lift) ? 1.0F : Math.max(0.0F, Math.min(10.0F, lift));
      this.fill = fill;
      this.outline = outline;
      this.lift = lift;
   }

   public int v1() {
      return this.fill;
   }

   public float v2() {
      return this.outline;
   }

   public float v3() {
      return this.lift;
   }
}
