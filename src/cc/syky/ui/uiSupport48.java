package cc.syky.ui;

public final class uiSupport48 {
   public static final int v1 = 0xFF000000 | uiSupport47.ACCENT.v1();
   public static final int v2 = 0xFF000000 | uiSupport47.ACCENT_SOFT.v1();
   public static final int v3 = -436207616 | uiSupport47.PANEL.v1();
   public static final int v4 = 0xFF000000 | uiSupport47.TEXT.v1();
   public static final int v5 = 301989888 | uiSupport47.EDGE.v1();
   private static final int v6 = 7;
   private static final int v7 = -1;
   private static final float v8 = 0.82F;
   private static final float v9 = 0.17F;

   private uiSupport48() {
   }

   public static void v1(boolean var0, uiSupport48.Part1 var1) {
      if (!var0) {
         uiSupport49.v2();
      } else {
         v1(uiSupport47.ACCENT, var1.v2(), 255);
         v1(uiSupport47.ACCENT_SOFT, var1.v3(), 255);
         v1(uiSupport47.ACCENT_TEXT, var1.v4(), 255);
         v1(uiSupport47.ACCENT_FILL, v3(var1.v2()), 255);
         v1(uiSupport47.ACCENT_FILL_INK, v1(uiSupport47.ACCENT_FILL_INK, uiSupport47.ACCENT_SOFT, var1.v3()), 255);
         v1(uiSupport47.PANEL, var1.v5(), 230);
         uiSupport49.v1(uiSupport47.SURFACE, v1(var1.v5() & 16777215, -1));
         uiSupport49.v1(var1.v6());
         v1(uiSupport47.CARD, var1.v7(), 56);
         v1(uiSupport47.TEXT, var1.v8(), 255);
         int var2 = var1.v8() & 0xFF000000;
         v1(uiSupport47.TEXT_BRIGHT, var2 | v1(uiSupport47.TEXT_BRIGHT, var1.v8()) & 16777215, 255);
         v1(uiSupport47.TEXT_DIM, var2 | v1(uiSupport47.TEXT_DIM, var1.v8()) & 16777215, 255);
         v1(uiSupport47.NAV_INK, var1.v9(), 255);
         v1(uiSupport47.ICON, var1.v10(), 255);
         v1(uiSupport47.EDGE, var1.v11(), 18);
         v1(uiSupport47.BUBBLE, v1(uiSupport47.BUBBLE, uiSupport47.CARD, var1.v7()), 255);
         v1(uiSupport47.BUBBLE_INK, var2 | v1(uiSupport47.BUBBLE_INK, var1.v8()) & 16777215, 255);
         v1(uiSupport47.BUBBLE_MINE, v1(uiSupport47.BUBBLE_MINE, uiSupport47.ACCENT, var1.v2()), 255);
         v1(uiSupport47.BUBBLE_MINE_INK, v1(uiSupport47.BUBBLE_MINE_INK, uiSupport47.ACCENT_SOFT, var1.v3()), 255);
      }
   }

   private static void v1(uiSupport47 var0, int var1, int var2) {
      uiSupport49.v1(var0, var1);
      uiSupport49.v1(var0, (float)(var1 >>> 24 & 0xFF) / var2);
   }

   public static int v1(int var0) {
      int var1 = var0 & 16777215;
      if (var1 == uiSupport47.ACCENT_SOFT.v1()) {
         return 0xFF000000 | uiSupport47.ACCENT_TEXT.v1();
      } else {
         float[] var2 = v4(var1);
         return 0xFF000000 | v1(var2[0], Math.min(var2[1], 0.17F), 0.82F);
      }
   }

   public static int v2(int var0) {
      return 939524096 | v1(var0 & 16777215, 7);
   }

   public static int v1(uiSupport47 var0, int var1) {
      return v1(var0, uiSupport47.TEXT, var1);
   }

   public static int v3(int var0) {
      return v1(uiSupport47.ACCENT_FILL, uiSupport47.ACCENT, var0);
   }

   private static int v1(uiSupport47 var0, uiSupport47 var1, int var2) {
      int var3 = var1.v1();
      int var4 = var0.v1();
      int var5 = -16777216;

      for (byte var6 = 16; var6 >= 0; var6 -= 8) {
         int var7 = var2 >> var6 & 0xFF;
         int var8 = var4 >> var6 & 0xFF;
         int var9 = var3 >> var6 & 0xFF;
         var5 |= Math.min(255, Math.round((float)var7 * var8 / var9)) << var6;
      }

      return var5;
   }

   private static int v1(int var0, int var1) {
      int var2 = 0;

      for (byte var3 = 16; var3 >= 0; var3 -= 8) {
         int var4 = Math.max(0, Math.min(255, (var0 >> var3 & 0xFF) + var1));
         var2 |= var4 << var3;
      }

      return var2;
   }

   public static float[] v4(int var0) {
      float var1 = (var0 >> 16 & 0xFF) / 255.0F;
      float var2 = (var0 >> 8 & 0xFF) / 255.0F;
      float var3 = (var0 & 0xFF) / 255.0F;
      float var4 = Math.max(var1, Math.max(var2, var3));
      float var5 = Math.min(var1, Math.min(var2, var3));
      float var6 = (var4 + var5) / 2.0F;
      float var7 = var4 - var5;
      if (var7 == 0.0F) {
         return new float[]{0.0F, 0.0F, var6};
      } else {
         float var8 = var7 / (1.0F - Math.abs(2.0F * var6 - 1.0F));
         float var9;
         if (var4 == var1) {
            var9 = 60.0F * ((var2 - var3) / var7 % 6.0F);
         } else if (var4 == var2) {
            var9 = 60.0F * ((var3 - var1) / var7 + 2.0F);
         } else {
            var9 = 60.0F * ((var1 - var2) / var7 + 4.0F);
         }

         return new float[]{var9 < 0.0F ? var9 + 360.0F : var9, Math.min(1.0F, var8), var6};
      }
   }

   public static int v1(float var0, float var1, float var2) {
      float var3 = (1.0F - Math.abs(2.0F * var2 - 1.0F)) * var1;
      float var4 = var3 * (1.0F - Math.abs(var0 / 60.0F % 2.0F - 1.0F));
      float var5 = var2 - var3 / 2.0F;

      float[] var6 = switch (Math.floorMod((int)(var0 / 60.0F), 6)) {
         case 0 -> new float[]{var3, var4, 0.0F};
         case 1 -> new float[]{var4, var3, 0.0F};
         case 2 -> new float[]{0.0F, var3, var4};
         case 3 -> new float[]{0.0F, var4, var3};
         case 4 -> new float[]{var4, 0.0F, var3};
         default -> new float[]{var3, 0.0F, var4};
      };
      return v1(var6[0] + var5) << 16 | v1(var6[1] + var5) << 8 | v1(var6[2] + var5);
   }

   private static int v1(float var0) {
      return Math.max(0, Math.min(255, Math.round(var0 * 255.0F)));
   }

   public record Part1(
      int accent, int highlight, int openPage, int background, boolean backgroundTint, int cards, int text, int sidebarText, int icons, int lines
   ) {
      public static uiSupport48.Part1 v1(int var0, int var1, int var2, boolean var3, int var4) {
         return new uiSupport48.Part1(
            var0,
            var1,
            uiSupport48.v1(var1),
            var2,
            var3,
            uiSupport48.v2(var2),
            var4,
            var4 & 0xFF000000 | uiSupport48.v1(uiSupport47.NAV_INK, var4) & 16777215,
            var4 & 0xFF000000 | uiSupport48.v1(uiSupport47.ICON, var4) & 16777215,
            uiSupport48.v5
         );
      }

      public static uiSupport48.Part1 v1() {
         return v1(uiSupport48.v1, uiSupport48.v2, uiSupport48.v3, false, uiSupport48.v4);
      }

      public int v2() {
         return this.accent;
      }

      public int v3() {
         return this.highlight;
      }

      public int v4() {
         return this.openPage;
      }

      public int v5() {
         return this.background;
      }

      public boolean v6() {
         return this.backgroundTint;
      }

      public int v7() {
         return this.cards;
      }

      public int v8() {
         return this.text;
      }

      public int v9() {
         return this.sidebarText;
      }

      public int v10() {
         return this.icons;
      }

      public int v11() {
         return this.lines;
      }
   }

   public static enum Part2 {
      SIMPLE,
      FULL;

      private Part2() {
      }
   }
}
