package cc.syky.ui;

import cc.syky.hud.hudSupport54;
import cc.syky.hud.hudSupport57;
import java.util.function.BooleanSupplier;
import org.jetbrains.annotations.Nullable;

public final class uiSupport118 extends UiNode {
   private final hudSupport57 v1 = new hudSupport57(0.0F, 90.0F);
   private final hudSupport57 v2 = new hudSupport57(0.0F, 55.0F);
   private final hudSupport57 v3 = new hudSupport57(0.0F, 45.0F);
   private float v4;
   private String v5 = "";
   private String v6 = "";
   private boolean v7;
   @Nullable
   private BooleanSupplier v8;
   @Nullable
   private Runnable v13;
   @Nullable
   private Runnable v14;
   private boolean v15;
   private boolean v16;
   private boolean v18;

   public uiSupport118(float var1) {
      this.v4 = var1;
   }

   public void v1(float var1) {
      this.v4 = var1;
   }

   public void v1(float var1, float var2, float var3, float var4, boolean var5, boolean var6) {
      this.v1(var1, var2, var3, var4);
      this.v16 = var5;
      this.v18 = var6;
   }

   public void v1(String var1, String var2, boolean var3) {
      this.v5 = var1;
      this.v6 = var2;
      this.v7 = var3;
      this.v8 = null;
      this.v13 = null;
      this.v14 = null;
   }

   public void v1(String var1, BooleanSupplier var2, Runnable var3) {
      this.v5 = var1;
      this.v6 = "";
      this.v8 = var2;
      this.v13 = var3;
      this.v14 = null;
      if (!this.v15) {
         this.v2.v3(var2.getAsBoolean() ? 1.0F : 0.0F);
         this.v15 = true;
      }
   }

   public void v1(String var1, String var2, Runnable var3) {
      this.v5 = var1;
      this.v6 = var2;
      this.v8 = null;
      this.v13 = null;
      this.v14 = var3;
   }

   public void v2(String var1, String var2, Runnable var3) {
      this.v1(var1, var2, var3);
   }

   private boolean v1() {
      return this.v13 != null || this.v14 != null;
   }

   @Override
   public void v1(uiSupport35 var1) {
      this.v1.v2(this.v1() && var1.v2() && this.v1(var1.v1, var1.v2) ? 1.0F : 0.0F);
      float var2 = this.v1.v2();
      this.v2(var2);
      if (!this.v16) {
         float var3 = SignInSupport.v2(this.v4);
         uiSupport169.v1(
            this.v9 + 16.0F * this.v4, this.v10, this.v11 - 32.0F * this.v4, var3, SignInSupport.v1(SignInSupport.v46(), this.v4), uiRecord7.v1(var3 / 2.0F)
         );
      }

      BooleanSupplier var12 = this.v8;
      float var4;
      if (var12 != null) {
         this.v2.v2(var12.getAsBoolean() ? 1.0F : 0.0F);
         var4 = this.v2.v2();
      } else {
         var4 = 1.0F;
      }

      int var5 = uiSupport155.v1(SignInSupport.v49(), SignInSupport.v47(), var4);
      int var6 = uiSupport155.v1(var5, Math.min(255, uiSupport155.v1(var5) + Math.round(31.0F * var2)));
      float var7 = 18.0F * this.v4;
      float var8 = uiSupport169.v1(this.v10 + this.v12 / 2.0F, var7);
      uiSupport169.v1("syky_sans_strong", this.v5, this.v9 + 16.0F * this.v4, var8, var7, var12 != null ? var6 : SignInSupport.v49());
      float var9 = this.v9 + this.v11 - 16.0F * this.v4;
      if (var12 == null) {
         if (this.v14 != null) {
            float var14 = uiSupport68.v1(uiSupport169.v2("syky_sans_strong", this.v6, 18.0F)) * this.v4;
            float var15 = SignInSupport.v4(30.0F, this.v4);
            uiSupport68.v1(var9 - var14, uiSupport126.v1(this.v10, this.v12, var15, SignInSupport.v4(54.0F, this.v4)), var14, var15, this.v4, this.v6, 1.0F);
         } else {
            float var13 = uiSupport169.v2("syky_sans_strong", this.v6, var7);
            uiSupport169.v1("syky_sans_strong", this.v6, var9 - var13, var8, var7, this.v7 ? SignInSupport.v47() : SignInSupport.v49());
         }
      } else {
         float var10 = var9 - 39.0F * this.v4;
         float var11 = uiSupport126.v1(this.v10, this.v12, SignInSupport.v4(21.0F, this.v4), SignInSupport.v4(54.0F, this.v4));
         this.v3.v2(var1.v2() && uiSupport106.v2(uiSupport105.MODULE, var1.v1, var1.v2, var10, var11, this.v4) ? 1.0F : 0.0F);
         uiSupport106.v1(uiSupport105.MODULE, var10, var11, this.v4, var4, 1.0F, this.v3.v2());
      }
   }

   private void v2(float var1) {
      if (!(var1 <= 0.001F)) {
         float var2 = SignInSupport.v2(this.v4);
         float var3 = this.v10 + var2;
         float var4 = this.v10 + this.v12 - (this.v18 ? var2 : 0.0F);
         if (!(var4 <= var3)) {
            float var5 = Math.max(0.0F, 18.0F * this.v4 - var2);
            float var6 = this.v16 ? var5 : 0.0F;
            float var7 = this.v18 ? var5 : 0.0F;
            uiSupport169.v1(
               this.v9 + var2, var3, this.v11 - 2.0F * var2, var4 - var3, uiSupport155.v1(SignInSupport.v42(), var1), uiRecord7.v1(var6, var6, var7, var7)
            );
         }
      }
   }

   @Override
   public boolean v1(float var1, float var2, int var3) {
      if (var3 == 0 && this.v1(var1, var2)) {
         Runnable var4 = this.v13 != null ? this.v13 : this.v14;
         if (var4 == null) {
            return false;
         } else {
            var4.run();
            return true;
         }
      } else {
         return false;
      }
   }

   @Override
   public hudSupport54 v2(float var1, float var2) {
      return this.v1() && this.v1(var1, var2) ? hudSupport54.POINTER : hudSupport54.ARROW;
   }
}
