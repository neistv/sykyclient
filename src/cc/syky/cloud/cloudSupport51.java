package cc.syky.cloud;

import org.jetbrains.annotations.Nullable;

public enum cloudSupport51 {
   HEAD("head", 0.0F, 0.0F, 0.0F),
   BODY("body", 0.0F, 0.0F, 0.0F),
   RIGHT_ARM("right_arm", -5.0F, 2.0F, 0.0F),
   LEFT_ARM("left_arm", 5.0F, 2.0F, 0.0F),
   RIGHT_LEG("right_leg", -1.9F, 12.0F, 0.0F),
   LEFT_LEG("left_leg", 1.9F, 12.0F, 0.0F);

   private static final cloudSupport51[] ALL = values();
   private final String id;
   private final float pivotX;
   private final float pivotY;
   private final float pivotZ;

   private cloudSupport51(String var3, float var4, float var5, float var6) {
      this.id = var3;
      this.pivotX = var4;
      this.pivotY = var5;
      this.pivotZ = var6;
   }

   public String v1() {
      return this.id;
   }

   public float v2() {
      return this.pivotX;
   }

   public float v3() {
      return this.pivotY;
   }

   public float v4() {
      return this.pivotZ;
   }

   @Nullable
   public static cloudSupport51 v1(String var0) {
      for (cloudSupport51 var4 : ALL) {
         if (var4.id.equalsIgnoreCase(var0)) {
            return var4;
         }
      }

      return null;
   }

   public static cloudSupport51 v1(int var0) {
      if (var0 >= 0 && var0 < ALL.length) {
         return ALL[var0];
      } else {
         throw new IllegalArgumentException("no anchor " + var0);
      }
   }
}
