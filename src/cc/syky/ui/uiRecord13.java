package cc.syky.ui;

import cc.syky.cloud.cloudSupport37;

public record uiRecord13(cloudSupport37 type, int color, int secondary, float intensity, float speed, float scale) {
   public static final float MAX_INTENSITY = 4.0F;
   public static final float MAX_SPEED = 8.0F;
   public static final float MIN_SCALE = 0.125F;
   public static final float MAX_SCALE = 32.0F;

   public uiRecord13(cloudSupport37 type, int color, int secondary, float intensity, float speed, float scale) {
      if (!(intensity >= 0.0F) || !(intensity <= 4.0F)) {
         throw new IllegalArgumentException("fx intensity " + intensity + " is outside [0, 4.0]");
      } else if (!(speed >= -8.0F) || !(speed <= 8.0F)) {
         throw new IllegalArgumentException("fx speed " + speed + " is outside ±8.0");
      } else if (scale >= 0.125F && scale <= 32.0F) {
         color &= 16777215;
         secondary &= 16777215;
         this.type = type;
         this.color = color;
         this.secondary = secondary;
         this.intensity = intensity;
         this.speed = speed;
         this.scale = scale;
      } else {
         throw new IllegalArgumentException("fx scale " + scale + " is outside [0.125, 32.0]");
      }
   }

   public cloudSupport37 v1() {
      return this.type;
   }

   public int v2() {
      return this.color;
   }

   public int v3() {
      return this.secondary;
   }

   public float v4() {
      return this.intensity;
   }

   public float v5() {
      return this.speed;
   }

   public float v6() {
      return this.scale;
   }
}
