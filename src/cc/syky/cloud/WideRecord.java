package cc.syky.cloud;

import cc.syky.hud.hudSupport64;
import org.jetbrains.annotations.Nullable;

public record WideRecord(
   float width, float height, WideRecord.Part4 art, WideRecord.Part6 text, WideRecord.Part3 wave, @Nullable WideRecord.Part2 bar, WideRecord.Part5 transport
) {
   public static final float RADIUS = 25.0F;
   public static final float WAVE_W = 22.0F;
   public static final float WAVE_H = 14.0F;
   public static final float BAR_H = 7.0F;
   private static final float SKIP_ASPECT = 1.625F;
   private static final float PLAY_ASPECT = 0.85F;
   public static final float TILE_H = 150.0F;
   public static final float PAD = 14.0F;
   public static final float TILE_TITLE = 14.0F;
   public static final float TILE_ARTIST = 11.5F;
   public static final float TILE_TIME = 10.0F;
   public static final float TILE_PLAY_H = 20.0F;
   public static final float TILE_SKIP_H = 12.0F;
   private static final float LINE_GAP = 7.5F;
   private static final float WIDE_TEXT_CENTER = 0.22F;
   private static final float TIME_BELOW_BAR = 15.0F;
   public static final float WIDE_BAR_BIAS = 0.7F;
   private static final float SQUARE_WAVE_INSET = 5.0F;
   private static final float TEXT_TO_WAVE = 10.0F;
   public static final float CONTROL_HIT_PAD = 6.0F;
   public static final float BAR_HIT_PAD = 9.0F;
   public static final WideRecord DEFAULT = new WideRecord(
      315.0F,
      137.0F,
      new WideRecord.Part4(10.0F, 10.0F, 54.0F, 15.0F),
      new WideRecord.Part6(75.0F, 265.0F, 21.0F, 16.0F, 40.0F, 12.0F, 40.0F, 58.0F),
      new WideRecord.Part3(275.0F, 27.0F),
      new WideRecord.Part2(40.0F, 76.0F, 235.0F, 73.0F, 10.0F, 10.0F, 303.0F),
      new WideRecord.Part5(73.0F, 216.0F, 102.0F, 26.0F, 16.0F, 149.0F, 100.0F, 17.0F, 20.0F)
   );
   public static final WideRecord SQUARE = v8();
   public static final WideRecord WIDE = v9();

   public static WideRecord v1(WideRecord.Part1 var0) {
      return switch (var0) {
         case DEFAULT -> DEFAULT;
         case SQUARE -> SQUARE;
         case WIDE -> WIDE;
      };
   }

   public static float v1(float var0) {
      return 0.71875F * var0;
   }

   public static float v1(float var0, float var1) {
      return var0 - 0.24124998F * var1;
   }

   private static WideRecord v8() {
      float var0 = 156.0F;
      float var1 = 150.0F;
      float var2 = 52.0F;
      WideRecord.Part5 var3 = v1(var0 * 0.5F, 43.0F, var1 - 14.0F - 10.0F);
      float var4 = 14.0F + var2;
      float var5 = v1(14.0F) + 7.5F + v1(11.5F);
      float var6 = var4 + (var3.v7() - var4 - var5) * 0.5F;
      return new WideRecord(
         var0,
         var1,
         new WideRecord.Part4(14.0F, 14.0F, var2, 11.0F),
         v1(14.0F, var0 - 14.0F, var6, var3.v7() - 6.0F),
         new WideRecord.Part3(var0 - 14.0F - 5.0F - 22.0F, 26.0F),
         null,
         var3
      );
   }

   private static WideRecord v9() {
      float var0 = 318.0F;
      float var1 = 150.0F;
      float var2 = var1 - 28.0F;
      float var3 = 14.0F + var2 + 14.0F;
      float var4 = var0 - 14.0F;
      float var5 = v1(14.0F) + 7.5F + v1(11.5F);
      float var6 = 0.22F * var1;
      float var7 = var6 - var5 * 0.5F;
      float var8 = var7 - 14.0F;
      WideRecord.Part5 var9 = v1((var3 + var4) * 0.5F, 50.5F, var1 - 14.0F - var8 - 10.0F);
      float var10 = var7 + var5;
      float var11 = 18.5F + v1(10.0F) * 0.5F;
      float var12 = var10 + (var9.v7() - var10 - var11) * 0.7F;
      float var13 = var12 + 3.5F + 15.0F - v1(10.0F) * 0.5F;
      float var14 = var4 - 22.0F;
      return new WideRecord(
         var0,
         var1,
         new WideRecord.Part4(14.0F, 14.0F, var2, 11.0F),
         v1(var3, var14 - 10.0F, var7, var12 - 9.0F),
         new WideRecord.Part3(var14, var6),
         new WideRecord.Part2(var3, var12, var4 - var3, v1(var13, 10.0F), 10.0F, var3, var4),
         var9
      );
   }

   private static WideRecord.Part6 v1(float var0, float var1, float var2, float var3) {
      float var4 = var2 + v1(14.0F) + 7.5F;
      float var5 = v1(var4, 11.5F);
      return new WideRecord.Part6(var0, var1, v1(var2, 14.0F), 14.0F, var5, 11.5F, var5, var3);
   }

   private static WideRecord.Part5 v1(float var0, float var1, float var2) {
      float var3 = 19.5F;
      float var4 = 17.0F;
      return new WideRecord.Part5(var0 - var1 - var3 * 0.5F, var0 + var1 - var3 * 0.5F, var2 - 6.0F, var3, 12.0F, var0 - var4 * 0.5F, var2 - 10.0F, var4, 20.0F);
   }

   public float v1() {
      return this.width;
   }

   public float v2() {
      return this.height;
   }

   public WideRecord.Part4 v3() {
      return this.art;
   }

   public WideRecord.Part6 v4() {
      return this.text;
   }

   public WideRecord.Part3 v5() {
      return this.wave;
   }

   @Nullable
   public WideRecord.Part2 v6() {
      return this.bar;
   }

   public WideRecord.Part5 v7() {
      return this.transport;
   }

   public static enum Part1 implements hudSupport64 {
      DEFAULT("Default"),
      SQUARE("Square"),
      WIDE("Wide");

      private final String label;

      private Part1(String var3) {
         this.label = var3;
      }

      @Override
      public String v1() {
         return this.label;
      }
   }

   public record Part2(float x, float y, float width, float timeY, float timeSize, float timeLeft, float timeRight) {
      public float v1() {
         return this.x;
      }

      public float v2() {
         return this.y;
      }

      public float v3() {
         return this.width;
      }

      public float v4() {
         return this.timeY;
      }

      public float v5() {
         return this.timeSize;
      }

      public float v6() {
         return this.timeLeft;
      }

      public float v7() {
         return this.timeRight;
      }
   }

   public record Part3(float x, float centerY) {
      public float v1() {
         return this.x;
      }

      public float v2() {
         return this.centerY;
      }
   }

   public record Part4(float x, float y, float size, float radius) {
      public float v1() {
         return this.x;
      }

      public float v2() {
         return this.y;
      }

      public float v3() {
         return this.size;
      }

      public float v4() {
         return this.radius;
      }
   }

   public record Part5(float prevX, float nextX, float skipY, float skipW, float skipH, float playX, float playY, float playW, float playH) {
      public float v1() {
         return this.prevX;
      }

      public float v2() {
         return this.nextX;
      }

      public float v3() {
         return this.skipY;
      }

      public float v4() {
         return this.skipW;
      }

      public float v5() {
         return this.skipH;
      }

      public float v6() {
         return this.playX;
      }

      public float v7() {
         return this.playY;
      }

      public float v8() {
         return this.playW;
      }

      public float v9() {
         return this.playH;
      }
   }

   public record Part6(float x, float right, float titleY, float titleSize, float artistY, float artistSize, float titleZoneBottom, float artistZoneBottom) {
      public float v1() {
         return this.x;
      }

      public float v2() {
         return this.right;
      }

      public float v3() {
         return this.titleY;
      }

      public float v4() {
         return this.titleSize;
      }

      public float v5() {
         return this.artistY;
      }

      public float v6() {
         return this.artistSize;
      }

      public float v7() {
         return this.titleZoneBottom;
      }

      public float v8() {
         return this.artistZoneBottom;
      }
   }
}
