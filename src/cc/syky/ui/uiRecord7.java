package cc.syky.ui;

import org.jetbrains.annotations.Nullable;

public record uiRecord7(float topLeft, float topRight, float bottomRight, float bottomLeft) {
   public static final uiRecord7 ZERO = new uiRecord7(0.0F, 0.0F, 0.0F, 0.0F);
   private static final int ALL_SLOTS = 256;
   private static final int ALL_SHIFT = 32 - Integer.numberOfTrailingZeros(256);
   private static final uiRecord7[] ALL = new uiRecord7[256];
   @Nullable
   private static uiRecord7 lastTop;
   @Nullable
   private static uiRecord7 lastBottom;

   public static uiRecord7 v1(float var0) {
      int var1 = Float.floatToRawIntBits(var0);
      int var2 = var1 * -1640531527 >>> ALL_SHIFT;
      uiRecord7 var3 = ALL[var2];
      if (var3 != null && Float.floatToRawIntBits(var3.topLeft) == var1) {
         return var3;
      } else {
         uiRecord7 var4 = new uiRecord7(var0, var0, var0, var0);
         ALL[var2] = var4;
         return var4;
      }
   }

   public static uiRecord7 v2(float var0) {
      uiRecord7 var1 = lastTop;
      if (var1 != null && Float.floatToRawIntBits(var1.topLeft) == Float.floatToRawIntBits(var0)) {
         return var1;
      } else {
         uiRecord7 var2 = new uiRecord7(var0, var0, 0.0F, 0.0F);
         lastTop = var2;
         return var2;
      }
   }

   public static uiRecord7 v3(float var0) {
      uiRecord7 var1 = lastBottom;
      if (var1 != null && Float.floatToRawIntBits(var1.bottomLeft) == Float.floatToRawIntBits(var0)) {
         return var1;
      } else {
         uiRecord7 var2 = new uiRecord7(0.0F, 0.0F, var0, var0);
         lastBottom = var2;
         return var2;
      }
   }

   public static uiRecord7 v4(float var0) {
      return new uiRecord7(var0, 0.0F, 0.0F, var0);
   }

   public static uiRecord7 v5(float var0) {
      return new uiRecord7(0.0F, var0, var0, 0.0F);
   }

   public static uiRecord7 v1(float var0, float var1, float var2, float var3) {
      return new uiRecord7(var0, var1, var2, var3);
   }

   public float v1() {
      return this.topLeft;
   }

   public float v2() {
      return this.topRight;
   }

   public float v3() {
      return this.bottomRight;
   }

   public float v4() {
      return this.bottomLeft;
   }
}
