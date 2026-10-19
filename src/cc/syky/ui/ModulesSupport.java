package cc.syky.ui;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.IntSupplier;

public final class ModulesSupport extends uiSupport39 {
   private static final String v1 = "Modules";
   private final List<uiSupport138> v2 = new ArrayList<>();
   private final List<uiSupport138> v3 = new ArrayList<>();
   private final List<uiSupport138> v4 = new ArrayList<>();
   private float v5;
   private AltManagerSupport v6;
   private boolean v7;

   public ModulesSupport(float var1, AltManagerSupport var2, Consumer<AltManagerSupport> var3) {
      this.v5 = var1;
      this.v6 = var2;

      for (AltManagerSupport var7 : AltManagerSupport.values()) {
         Runnable var8 = () -> {
            this.v6 = var7;
            if (var3 != null) {
               var3.accept(var7);
            }
         };
         boolean var9 = var7 == var2;
         Object var10 = var7 == AltManagerSupport.ACCOUNT ? new SignInSupport4(var8, var1, var9) : new uiSupport138(var7, var8, var1, var9);
         this.v3.add((uiSupport138)var10);
         (var7.v3() == AltManagerSupport.Part1.FOOT ? this.v4 : this.v2).add((uiSupport138)var10);
         this.v1((UiNode)var10);
      }
   }

   public void v1(AltManagerSupport var1, IntSupplier var2) {
      for (uiSupport138 var4 : this.v3) {
         if (var4.v1() == var1) {
            var4.v1(var2);
         }
      }
   }

   public AltManagerSupport v1() {
      return this.v6;
   }

   public void v1(AltManagerSupport var1) {
      this.v6 = var1;
   }

   public void v1(boolean var1) {
      this.v7 = var1;
   }

   public void v1(float var1) {
      this.v5 = var1;

      for (uiSupport138 var3 : this.v3) {
         var3.v2(var1);
      }
   }

   @Override
   public void v1(int var1, int var2) {
      float var3 = this.v9 + SignInSupport.v4(16.0F, this.v5);
      float var4 = this.v9 + SignInSupport.v4(215.0F, this.v5) - var3;

      for (int var5 = 0; var5 < this.v2.size(); var5++) {
         float var6 = 109.0F + var5 * 48.0F;
         float var7 = this.v10 + SignInSupport.v4(var6, this.v5);
         this.v2.get(var5).v1(var3, var7, var4, this.v10 + SignInSupport.v4(var6 + 42.0F, this.v5) - var7);
      }

      float var9 = this.v10 + this.v12 - SignInSupport.v4(58.0F, this.v5);
      float var10 = this.v10 + this.v12 - SignInSupport.v4(16.0F, this.v5) - var9;

      for (uiSupport138 var8 : this.v4) {
         var8.v1(var3, var9, var4, var10);
      }

      super.v1(var1, var2);
   }

   @Override
   public void v1(uiSupport35 var1) {
      this.v2();
      this.v3();
      this.v2(SignInSupport.v4(67.0F, this.v5));
      this.v2(this.v12 - SignInSupport.v4(75.0F, this.v5));
      uiSupport169.v1("syky_sans", "Modules", this.v9 + 28.0F * this.v5, this.v10 + 82.0F * this.v5, 16.0F * this.v5, SignInSupport.v34());

      for (uiSupport138 var3 : this.v3) {
         var3.v1(!this.v7 && var3.v1() == this.v6);
      }

      super.v1(var1);
   }

   private void v2() {
      uiSupport169.v1(
         uiSupport143.v1, this.v9 + 96.5F * this.v5, this.v10 + 14.5F * this.v5, 38.0F * this.v5, 38.0F * this.v5, SignInSupport.v4(), uiRecord7.ZERO
      );
   }

   private void v3() {
      float var1 = SignInSupport.v4(16.0F, this.v5);
      float var2 = this.v9 + this.v11;
      float var3 = SignInSupport.v2(this.v5);
      uiSupport169.v6(var2, this.v10 + var3, var1, this.v12 - 2.0F * var3);

      try {
         uiSupport169.v1(var2, this.v10, this.v11 * 2.0F, this.v12, SignInSupport.v1(SignInSupport.v3(), this.v5), var3, var1);
      } finally {
         uiSupport169.v17();
      }
   }

   private void v2(float var1) {
      float var2 = this.v9 + SignInSupport.v4(16.0F, this.v5);
      float var3 = this.v9 + this.v11 - SignInSupport.v4(16.0F, this.v5);
      float var4 = SignInSupport.v2(this.v5);
      uiSupport169.v1(var2, this.v10 + var1, var3 - var2, var4, SignInSupport.v1(SignInSupport.v3(), this.v5), SignInSupport.v3(var4));
   }
}
