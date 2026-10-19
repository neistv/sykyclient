package cc.syky.ui;

public enum uiSupport110 {
   MODULE(23.0F, 5.0F, 5.0F, 4.0F, 30.0F),
   SETTINGS(24.0F, 6.0F, 5.0F, 3.5F, 30.0F),
   FRIEND(4.0F, 18.0F, 4.0F, 3.0F, 30.0F);

   private final float width;
   private final float height;
   private final float diameter;
   private final float gap;
   private final float hit;

   private uiSupport110(float var3, float var4, float var5, float var6, float var7) {
      this.width = var3;
      this.height = var4;
      this.diameter = var5;
      this.gap = var6;
      this.hit = var7;
   }

   public float v1() {
      return this.width;
   }

   public float v2() {
      return this.height;
   }

   public float v3() {
      return this.diameter;
   }

   public float v4() {
      return this.gap;
   }

   public boolean v5() {
      return this == FRIEND;
   }

   public float v6() {
      return this.hit;
   }

   public int v7() {
      return switch (this) {
         case MODULE -> SignInSupport.v50();
         case SETTINGS -> -1711276033;
         case FRIEND -> SignInSupport.v28();
      };
   }

   public int v8() {
      return switch (this) {
         case MODULE -> SignInSupport.v51();
         case SETTINGS -> -419430401;
         case FRIEND -> SignInSupport.v28();
      };
   }

   public int v9() {
      return switch (this) {
         case MODULE -> SignInSupport.v60();
         case SETTINGS -> -1;
         case FRIEND -> SignInSupport.v30();
      };
   }
}
