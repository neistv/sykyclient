package cc.syky.ui;

public record uiRecord6(float loX, float hiX, float loY, float hiY, float spanX, float spanY) {
   public static final float GRAB_MIN_DESIGN_WIDTH = 120.0F;
   public static final float DRAG_RESIST_DESIGN = 160.0F;
   public static final long RETURN_DURATION_MS = 380L;
   public static final uiRecord6 CENTRED = new uiRecord6(0.5F, 0.5F, 0.5F, 0.5F, 0.0F, 0.0F);

   public static uiRecord6 v1(float var0, float var1, float var2, float var3, float var4, float var5, float var6) {
      if (!(var0 <= 0.0F) && !(var1 <= 0.0F)) {
         float var7 = Math.min(var5, var2);
         return new uiRecord6(
            (var7 - var2 / 2.0F) / var0, (var0 - var7 + var2 / 2.0F) / var0, var3 / 2.0F / var1, (var1 - var4 + var3 / 2.0F) / var1, var6 / var0, var6 / var1
         );
      } else {
         return CENTRED;
      }
   }

   public float v1(float var1) {
      return v1(var1, this.loX, this.hiX);
   }

   public float v2(float var1) {
      return v1(var1, this.loY, this.hiY);
   }

   public float v1(float var1, float var2) {
      return v1(var1, var2, this.loX, this.hiX, this.spanX);
   }

   public float v2(float var1, float var2) {
      return v1(var1, var2, this.loY, this.hiY, this.spanY);
   }

   private static float v1(float var0, float var1, float var2) {
      if (var1 >= var2) {
         return (var1 + var2) * 0.5F;
      } else {
         return var0 < var1 ? var1 : (var0 > var2 ? var2 : var0);
      }
   }

   private static float v1(float var0, float var1, float var2, float var3, float var4) {
      if (!(var2 >= var3) && !(var4 <= 0.0F)) {
         float var5 = var0 < var2 ? var2 - var0 : (var0 > var3 ? var0 - var3 : 0.0F);
         if (var5 <= 0.0F) {
            return var0 + var1;
         } else {
            boolean var6 = var0 > var3 ? var1 > 0.0F : var1 < 0.0F;
            return var6 ? var0 + var1 / (1.0F + var5 / var4) : var0 + var1;
         }
      } else {
         return var0 + var1;
      }
   }

   public float v1() {
      return this.loX;
   }

   public float v2() {
      return this.hiX;
   }

   public float v3() {
      return this.loY;
   }

   public float v4() {
      return this.hiY;
   }

   public float v5() {
      return this.spanX;
   }

   public float v6() {
      return this.spanY;
   }
}
