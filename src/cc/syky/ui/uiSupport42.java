package cc.syky.ui;

import cc.syky.hud.hudSupport54;
import cc.syky.hud.hudSupport57;
import cc.syky.hud.hudSupport60;
import net.minecraft.class_2960;
import org.jetbrains.annotations.Nullable;

public final class uiSupport42 extends uiSupport45 {
   private final Runnable v1;
   private final float v2;
   private final hudSupport57 v3 = new hudSupport57(0.0F, 90.0F);
   private final hudSupport57 v4 = new hudSupport57(0.0F, 150.0F);
   private String v5 = "";
   @Nullable
   private class_2960 v6;
   private boolean v7;
   private final hudSupport57 v8 = new hudSupport57(0.0F, 150.0F);
   private float v13;
   private String v14 = "";

   public uiSupport42(float var1, float var2, Runnable var3) {
      super(var1);
      this.v2 = var2;
      this.v1 = var3;
   }

   public boolean v1() {
      return this.v7;
   }

   public void v1(@Nullable String var1, @Nullable class_2960 var2, boolean var3) {
      this.v7 = var1 != null;
      if (var1 != null) {
         this.v5 = var1;
         this.v6 = var2;
      }

      this.v4.v2(this.v7 ? 1.0F : 0.0F);
      this.v8.v2(this.v7 && var3 ? 1.0F : 0.0F);
   }

   @Override
   public float v12() {
      return hudSupport60.v1(this.v8.v2());
   }

   public float v4() {
      return hudSupport60.v1(this.v4.v2());
   }

   public float v5() {
      if (!this.v5.equals(this.v14)) {
         this.v14 = this.v5;
         this.v13 = uiSupport169.v2("syky_sans", this.v5, 16.0F);
      }

      return this.v6 == null ? (float)Math.ceil(this.v13 + 2.0F * this.v2) : (float)Math.ceil(34.0F + this.v13 + 16.0F);
   }

   @Override
   public boolean v1(float var1, float var2) {
      return this.v7 && super.v1(var1, var2);
   }

   @Override
   public float v2(uiSupport35 var1) {
      this.v3.v2(this.v7 && this.v4(var1) ? 1.0F : 0.0F);
      return hudSupport60.v1(this.v3.v2());
   }

   @Override
   public void v3(uiSupport35 var1) {
      float var2 = 16.0F * this.v13();
      float var3 = hudSupport60.v1(this.v3.v2());
      class_2960 var4 = this.v6;
      float var5;
      if (var4 == null) {
         var5 = this.v9 + (this.v11 - uiSupport169.v2("syky_sans", this.v5, var2)) / 2.0F;
      } else {
         float var6 = SignInSupport.v4(13.0F, this.v13());
         uiSupport169.v1(
            var4,
            this.v9 + SignInSupport.v4(14.0F, this.v13()),
            this.v10 + uiSupport169.v1((this.v12 - var6) / 2.0F),
            var6,
            var6,
            uiSupport155.v1(uiSupport155.v1(SignInSupport.v28(), SignInSupport.v30(), var3), SignInSupport.v13(), this.v12()),
            uiRecord7.ZERO
         );
         var5 = this.v9 + SignInSupport.v4(34.0F, this.v13());
      }

      uiSupport169.v1(
         "syky_sans",
         this.v5,
         var5,
         uiSupport169.v1(this.v10 + this.v12 / 2.0F, var2),
         var2,
         uiSupport155.v1(uiSupport155.v1(SignInSupport.v23(), SignInSupport.v33(), var3), SignInSupport.v9(), this.v12())
      );
   }

   @Override
   public boolean v1(float var1, float var2, int var3) {
      if ((var3 == 0 || var3 == 1) && this.v1(var1, var2)) {
         this.v3(var1, var2);
         return true;
      } else {
         return false;
      }
   }

   @Override
   public void v3(float var1, float var2) {
      if (this.v7) {
         this.v1.run();
      }
   }

   @Override
   public hudSupport54 v2(float var1, float var2) {
      return this.v1(var1, var2) ? hudSupport54.POINTER : hudSupport54.ARROW;
   }
}
