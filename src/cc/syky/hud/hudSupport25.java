package cc.syky.hud;

public final class hudSupport25 extends HudElement {
   public static final String v2 = "watermark";
   private static final float v3 = 36.0F;
   private static final float v4 = 9.0F;
   private final hudSupport25.Part1 v5 = new hudSupport25.Part1();

   public hudSupport25(hudSupport52 var1, float var2, float var3) {
      super("watermark", 13, var1, var2, var3);
   }

   @Override
   public boolean v43() {
      return true;
   }

   @Override
   public boolean v37() {
      return true;
   }

   @Override
   public boolean v1(hudSupport40 var1, float[] var2) {
      float var3 = this.v6(36.0F, this.v5(var1));
      var2[0] = var3;
      var2[1] = var3;
      return true;
   }

   @Override
   public void v8(hudSupport40 var1) {
      hudSupport25.Part1 var2 = this.v14(var1);
      this.v1(var1, var2.v3, var2.v4, var2.v5, var2.v5, var2.v6);
      this.v2(var2.v1, var2.v2, var2.v5, var2.v5);
   }

   @Override
   public final boolean v33() {
      return true;
   }

   @Override
   public void v10(hudSupport40 var1) {
      hudSupport25.Part1 var2 = this.v14(var1);
      this.v2(var2.v1, var2.v2, var2.v5, var2.v5);
   }

   @Override
   public hudRecord4 v9(hudSupport40 var1) {
      hudSupport25.Part1 var2 = this.v14(var1);
      float var3 = 9.0F * var2.v7;
      this.v1(hudSupport49.v1, var2.v3 + var3, var2.v4 + var3, var2.v5 - var3 * 2.0F, var2.v5 - var3 * 2.0F);
      return this.v2(var2.v1, var2.v2, var2.v5, var2.v5);
   }

   private hudSupport25.Part1 v14(hudSupport40 var1) {
      float var2 = this.v5(var1);
      float var3 = this.v6(36.0F, var2);
      float var4 = 18.0F * var2;
      float var5 = this.v8(this.v1(var1, var3));
      float var6 = this.v8(this.v2(var1, var3));
      hudSupport25.Part1 var7 = this.v5;
      var7.v1 = var5;
      var7.v2 = var6;
      var7.v3 = var5 + this.v15();
      var7.v4 = var6 + this.v16();
      var7.v5 = var3;
      var7.v6 = var4;
      var7.v7 = var2;
      return var7;
   }

   public static final class Part1 {
      public float v1;
      public float v2;
      public float v3;
      public float v4;
      public float v5;
      public float v6;
      public float v7;

      public Part1() {
      }
   }
}
