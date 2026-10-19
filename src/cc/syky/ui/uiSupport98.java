package cc.syky.ui;

import cc.syky.hud.hudSupport57;
import org.jetbrains.annotations.Nullable;

public final class uiSupport98 extends UiNode {
   private static final float v1 = 39.0F;
   private static final float v2 = 10.0F;
   private static final float v3 = 16.0F;
   private static final float v4 = 8.0F;
   @Nullable
   private String v5;
   @Nullable
   private Object v6;
   private final uiSupport37 v7 = new uiSupport37(3.0F);
   private hudSupport57 v8 = new hudSupport57(0.0F, 45.0F);
   private float v13;
   private float v14;
   private float v15 = 1.0F;
   private float v16;
   private float v18;
   private float v19;
   private float v17;

   public uiSupport98() {
   }

   public void v3(float var1, float var2) {
      this.v16 = var1;
      this.v18 = var2;
      this.v9 = uiSupport169.v1(this.v16 + this.v19);
      this.v10 = uiSupport169.v1(this.v18 + this.v17);
   }

   public void v1(
      @Nullable Object var1,
      String var2,
      float var3,
      float var4,
      float var5,
      float var6,
      uiSupport98.Part1 var7,
      float var8,
      float var9,
      float var10,
      float var11,
      float var12,
      float var13,
      float var14
   ) {
      this.v15 = var12;
      if (var1 != this.v6) {
         this.v6 = var1;
         this.v4();
         this.v7.v1(var9, var10);
      } else if (this.v5 == null) {
         this.v7.v2(var9, var10);
      }

      if (this.v6 != null && this.v5 == null && this.v7.v3(var11, var8)) {
         this.v1(var2, var3, var4, var5, var6, var7, var13, var14);
      }

      this.v13 = this.v8.v2();
      if (this.v5 == null && this.v8.v1()) {
         this.v13 = 0.0F;
      }
   }

   public void v1() {
      this.v1(null, "", 0.0F, 0.0F, 0.0F, 0.0F, uiSupport98.Part1.ABOVE, 0.0F, 0.0F, 0.0F, 0.0F, this.v15, 0.0F, 0.0F);
   }

   private void v4() {
      this.v7.v1();
      if (this.v5 != null) {
         this.v5 = null;
         this.v8.v2(0.0F);
      }
   }

   private void v1(String var1, float var2, float var3, float var4, float var5, uiSupport98.Part1 var6, float var7, float var8) {
      this.v14 = Math.round(uiSupport169.v2("syky_sans", var1, 16.0F) + 20.0F);
      float var9 = SignInSupport.v4(this.v14, this.v15);
      float var10 = SignInSupport.v4(39.0F, this.v15);
      float var11 = SignInSupport.v4(8.0F, this.v15);
      float var12;
      float var13;
      if (var6 == uiSupport98.Part1.ABOVE) {
         float var14 = var3 - var11 - var10;
         var13 = var14 >= 0.0F ? var14 : Math.min(var3 + var5 + var11, Math.max(0.0F, var8 - var10));
         var12 = var2 + (var4 - var9) * 0.5F;
      } else {
         float var15 = var2 + var4 + var11;
         var12 = var15 + var9 <= var7 ? var15 : Math.max(0.0F, var2 - var11 - var9);
         var13 = var3 + (var5 - var10) * 0.5F;
      }

      this.v19 = var12 - this.v16;
      this.v17 = var13 - this.v18;
      this.v1(uiSupport169.v1(var12), uiSupport169.v1(var13), var9, var10);
      this.v5 = var1;
      this.v8 = new hudSupport57(0.0F, 45.0F);
      this.v8.v2(1.0F);
   }

   public boolean v2() {
      return this.v5 != null || this.v13 > 0.002F;
   }

   public float v3() {
      return this.v13;
   }

   @Override
   public void v1(uiSupport35 var1) {
      String var2 = this.v5;
      if (var2 != null && !(this.v13 <= 0.002F)) {
         float var3 = 12.0F * this.v15;
         uiSupport97.v1(this.v9, this.v10, this.v11, this.v12, var3, this.v15, SignInSupport.v138(), SignInSupport.v106());
         float var4 = 16.0F * this.v15;
         uiSupport169.v1(
            "syky_sans", var2, this.v9 + 10.0F * this.v15, uiSupport169.v1(this.v10 + this.v12 / 2.0F, var4), var4, uiSupport49.v2(uiSupport47.TEXT_DIM)
         );
      }
   }

   public static enum Part1 {
      ABOVE,
      BESIDE;

      private Part1() {
      }
   }
}
