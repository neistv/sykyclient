package cc.syky.ui;

import cc.syky.hud.hudSupport54;
import cc.syky.hud.hudSupport57;
import cc.syky.hud.hudSupport60;
import java.util.function.IntSupplier;
import net.minecraft.class_2960;

public class uiSupport138 extends UiNode {
   private final AltManagerSupport v1;
   private final Runnable v2;
   private final class_2960 v3;
   private final hudSupport57 v4;
   private final hudSupport57 v5;
   private float v6;
   private boolean v7;
   private IntSupplier v8 = () -> 0;
   private uiRecord7 v13;

   public uiSupport138(AltManagerSupport var1, Runnable var2, float var3, boolean var4) {
      this.v1 = var1;
      this.v2 = var2;
      this.v6 = var3;
      this.v7 = var4;
      this.v3 = uiSupport143.v1(var1.v2());
      this.v4 = new hudSupport57(var4 ? 1.0F : 0.0F, 90.0F);
      this.v5 = new hudSupport57(var4 ? 1.0F : 0.0F, 150.0F);
      this.v13 = v3(var3);
   }

   public AltManagerSupport v1() {
      return this.v1;
   }

   public void v1(boolean var1) {
      this.v7 = var1;
      this.v5.v2(var1 ? 1.0F : 0.0F);
   }

   public void v2(float var1) {
      this.v6 = var1;
      this.v13 = v3(var1);
   }

   public void v1(IntSupplier var1) {
      this.v8 = var1;
   }

   public final float v2() {
      return this.v6;
   }

   @Override
   public void v1(uiSupport35 var1) {
      this.v4.v2(this.v7 ? 1.0F : (this.v4(var1) ? 0.7F : 0.0F));
      float var2 = hudSupport60.v1(this.v4.v2());
      if (var2 > 0.0F) {
         float var3 = this.v5.v2();
         uiSupport169.v1(
            this.v9,
            this.v10,
            this.v11,
            this.v12,
            uiSupport155.v1(uiSupport155.v1(SignInSupport.v7(), SignInSupport.v5(), var3), var2),
            uiSupport155.v1(SignInSupport.v1(uiSupport155.v1(SignInSupport.v8(), SignInSupport.v6(), var3), this.v6), var2),
            SignInSupport.v2(this.v6),
            1.0F,
            this.v13
         );
      }

      this.v1(this.v5.v2());
   }

   public void v1(float var1) {
      float var2 = 20.0F * this.v6;
      uiSupport169.v1(
         this.v3,
         this.v9 + 12.0F * this.v6,
         this.v10 + (this.v12 - var2) / 2.0F,
         var2,
         var2,
         uiSupport155.v1(SignInSupport.v12(), SignInSupport.v13(), var1),
         uiRecord7.ZERO
      );
      float var3 = 18.0F * this.v6;
      uiSupport169.v1(
         "syky_sans_strong",
         this.v1.v1(),
         this.v9 + 44.0F * this.v6,
         uiSupport169.v1(this.v10 + this.v12 / 2.0F, var3),
         var3,
         uiSupport155.v1(SignInSupport.v11(), SignInSupport.v9(), var1)
      );
      int var4 = this.v8.getAsInt();
      if (var4 > 0) {
         uiSupport51.v1(
            this.v9 + this.v11 - SignInSupport.v4(12.0F, this.v6), this.v10 + uiSupport169.v1((this.v12 - uiSupport51.v1(this.v6)) / 2.0F), var4, this.v6, 1.0F
         );
      }
   }

   @Override
   public boolean v1(float var1, float var2) {
      float var3 = 3.0F * this.v6;
      return var1 >= this.v9 && var2 >= this.v10 - var3 && var1 < this.v9 + this.v11 && var2 < this.v10 + this.v12 + var3;
   }

   @Override
   public boolean v1(float var1, float var2, int var3) {
      if (var3 == 0 && this.v1(var1, var2)) {
         this.v2.run();
         return true;
      } else {
         return false;
      }
   }

   @Override
   public hudSupport54 v2(float var1, float var2) {
      return this.v1(var1, var2) ? hudSupport54.POINTER : hudSupport54.ARROW;
   }

   private static uiRecord7 v3(float var0) {
      return uiRecord7.v1(12.0F * var0);
   }
}
