package cc.syky.ui;

import cc.syky.hud.hudSupport60;

public final class uiSupport6 {
   private static final float v3 = 0.02F;
   public static final float v1 = 6.0F;
   public static final float v2 = 5.0F;
   private static final float v4 = 0.45F;
   private static final float v5 = 0.65F;
   private static final float v6 = 4.0F;
   private final float v7;
   private static final int v8 = 8;
   private static final float v9 = 0.2F;
   private final uiSupport5 v10;
   private float v11 = 1.0F;
   private float v12 = 1.0F;
   private float v13 = 1.0F;
   private float v14;
   private float v15;

   public uiSupport6() {
      this(uiSupport6.Part1.HUD);
   }

   public uiSupport6(uiSupport6.Part1 var1) {
      this.v7 = var1.v2();
      this.v10 = new uiSupport5(var1.v1(), 4.0F, 8, false);
   }

   public float v1() {
      return this.v11;
   }

   public float v2() {
      return this.v12;
   }

   public float v3() {
      return this.v13;
   }

   public float v4() {
      return this.v14;
   }

   public float v5() {
      return this.v15;
   }

   public void v6() {
      this.v11 = 1.0F;
      this.v12 = 1.0F;
      this.v13 = 1.0F;
      this.v14 = 0.0F;
      this.v15 = 0.0F;
   }

   public void v1(float var1) {
      float var2 = var1 <= 0.0F ? 0.0F : (var1 >= 1.0F ? 1.0F : var1);
      if (var2 >= 1.0F) {
         this.v6();
      } else {
         this.v10.v1(var2);
         float var3 = this.v10.v1();
         float var4 = this.v10.v2();
         float var5 = 1.0F - 0.98F * var3;
         float var6 = Math.max(0.2F, 1.0F + this.v7 * var4);
         this.v12 = var5 * var6;
         this.v13 = var5 / var6;
         this.v15 = var3;
         this.v11 = hudSupport60.v2(uiSupport5.v2(var2, 0.45F));
         float var7 = 1.0F - uiSupport5.v2(var2, 0.65F);
         this.v14 = 5.0F * var7 * (float)Math.sqrt(var7);
      }
   }

   public record Part1(float damping, float stretch) {
      public static final uiSupport6.Part1 HUD = new uiSupport6.Part1(4.8F, 0.15F);
      public static final uiSupport6.Part1 PANEL = new uiSupport6.Part1(5.725F, 0.09F);

      public float v1() {
         return this.damping;
      }

      public float v2() {
         return this.stretch;
      }
   }
}
