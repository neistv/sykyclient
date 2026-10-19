package cc.syky.hud;

import org.jetbrains.annotations.Nullable;

public record hudRecord3(HudElement parent, hudRecord3.Part1 side, hudRecord3.Part2 align) {
   public HudElement v1() {
      return this.parent;
   }

   public hudRecord3.Part1 v2() {
      return this.side;
   }

   public hudRecord3.Part2 v3() {
      return this.align;
   }

   public static enum Part1 {
      LEFT(0),
      RIGHT(1),
      ABOVE(2),
      BELOW(3);

      private static final hudRecord3.Part1[] VALUES = values();
      public final int code;

      private Part1(int var3) {
         this.code = var3;
      }

      public boolean v1() {
         return this == LEFT || this == RIGHT;
      }

      public hudRecord3.Part1 v2() {
         return switch (this) {
            case LEFT -> RIGHT;
            case RIGHT -> LEFT;
            case ABOVE -> BELOW;
            case BELOW -> ABOVE;
         };
      }

      public static hudRecord3.Part1 v1(int var0) {
         for (hudRecord3.Part1 var4 : VALUES) {
            if (var4.code == var0) {
               return var4;
            }
         }

         throw new IllegalArgumentException("no side " + var0);
      }

      @Nullable
      public static hudRecord3.Part1 v1(@Nullable String var0) {
         for (hudRecord3.Part1 var4 : VALUES) {
            if (var4.name().equals(var0)) {
               return var4;
            }
         }

         return null;
      }
   }

   public static enum Part2 {
      START(0),
      CENTER(1),
      END(2);

      private static final hudRecord3.Part2[] VALUES = values();
      public final int code;

      private Part2(int var3) {
         this.code = var3;
      }

      public static hudRecord3.Part2 v1(int var0) {
         for (hudRecord3.Part2 var4 : VALUES) {
            if (var4.code == var0) {
               return var4;
            }
         }

         throw new IllegalArgumentException("no alignment " + var0);
      }

      @Nullable
      public static hudRecord3.Part2 v1(@Nullable String var0) {
         for (hudRecord3.Part2 var4 : VALUES) {
            if (var4.name().equals(var0)) {
               return var4;
            }
         }

         return null;
      }
   }
}
