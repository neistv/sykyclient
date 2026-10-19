package cc.syky.hud;

import org.jetbrains.annotations.Nullable;

public enum hudSupport52 {
   TOP_LEFT(hudSupport52.Part2.LEFT, hudSupport52.Part1.TOP),
   TOP_CENTER(hudSupport52.Part2.CENTER, hudSupport52.Part1.TOP),
   TOP_RIGHT(hudSupport52.Part2.RIGHT, hudSupport52.Part1.TOP),
   MIDDLE_LEFT(hudSupport52.Part2.LEFT, hudSupport52.Part1.MIDDLE),
   CENTER(hudSupport52.Part2.CENTER, hudSupport52.Part1.MIDDLE),
   MIDDLE_RIGHT(hudSupport52.Part2.RIGHT, hudSupport52.Part1.MIDDLE),
   BOTTOM_LEFT(hudSupport52.Part2.LEFT, hudSupport52.Part1.BOTTOM),
   BOTTOM_CENTER(hudSupport52.Part2.CENTER, hudSupport52.Part1.BOTTOM),
   BOTTOM_RIGHT(hudSupport52.Part2.RIGHT, hudSupport52.Part1.BOTTOM);

   private final hudSupport52.Part2 h;
   private final hudSupport52.Part1 v;
   private static final hudSupport52[] VALUES = values();

   private hudSupport52(hudSupport52.Part2 var3, hudSupport52.Part1 var4) {
      this.h = var3;
      this.v = var4;
   }

   public hudSupport52.Part2 v1() {
      return this.h;
   }

   public hudSupport52.Part1 v2() {
      return this.v;
   }

   public float v3() {
      return switch (this.h) {
         case LEFT -> -1.0F;
         case CENTER -> 0.0F;
         case RIGHT -> 1.0F;
      };
   }

   public float v4() {
      return switch (this.v) {
         case TOP -> -1.0F;
         case MIDDLE -> 0.0F;
         case BOTTOM -> 1.0F;
      };
   }

   public hudSupport52 v1(hudSupport52.Part1 var1) {
      if (var1 != null && var1 != this.v) {
         for (hudSupport52 var5 : VALUES) {
            if (var5.h == this.h && var5.v == var1) {
               return var5;
            }
         }

         return this;
      } else {
         return this;
      }
   }

   public float v1(float var1, float var2, float var3) {
      return switch (this.h) {
         case LEFT -> var3;
         case CENTER -> (var1 - var2) * 0.5F + var3;
         case RIGHT -> var1 - var2 - var3;
      };
   }

   public float v2(float var1, float var2, float var3) {
      return switch (this.v) {
         case TOP -> var3;
         case MIDDLE -> (var1 - var2) * 0.5F + var3;
         case BOTTOM -> var1 - var2 - var3;
      };
   }

   public float v3(float var1, float var2, float var3) {
      return switch (this.h) {
         case LEFT -> var3;
         case CENTER -> var3 - (var1 - var2) * 0.5F;
         case RIGHT -> var1 - var2 - var3;
      };
   }

   public float v4(float var1, float var2, float var3) {
      return switch (this.v) {
         case TOP -> var3;
         case MIDDLE -> var3 - (var1 - var2) * 0.5F;
         case BOTTOM -> var1 - var2 - var3;
      };
   }

   public static hudSupport52 v1(float var0, float var1, float var2, float var3, float var4, float var5, float var6) {
      float var7 = var2 + var4 * 0.5F;
      float var8 = var3 + var5 * 0.5F;
      hudSupport52.Part2 var9;
      if (Math.abs(var7 - var0 * 0.5F) <= var6) {
         var9 = hudSupport52.Part2.CENTER;
      } else if (var7 < var0 * 0.5F) {
         var9 = hudSupport52.Part2.LEFT;
      } else {
         var9 = hudSupport52.Part2.RIGHT;
      }

      hudSupport52.Part1 var10;
      if (Math.abs(var8 - var1 * 0.5F) <= var6) {
         var10 = hudSupport52.Part1.MIDDLE;
      } else if (var8 < var1 * 0.5F) {
         var10 = hudSupport52.Part1.TOP;
      } else {
         var10 = hudSupport52.Part1.BOTTOM;
      }

      for (hudSupport52 var14 : VALUES) {
         if (var14.h == var9 && var14.v == var10) {
            return var14;
         }
      }

      return TOP_LEFT;
   }

   public static hudSupport52 v1(@Nullable String var0, hudSupport52 var1) {
      if (var0 == null) {
         return var1;
      } else {
         try {
            return valueOf(var0);
         } catch (IllegalArgumentException var3) {
            return var1;
         }
      }
   }

   public static enum Part1 {
      TOP,
      MIDDLE,
      BOTTOM;

      private Part1() {
      }
   }

   public static enum Part2 {
      LEFT,
      CENTER,
      RIGHT;

      private Part2() {
      }
   }
}
