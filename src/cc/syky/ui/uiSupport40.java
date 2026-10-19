package cc.syky.ui;

import cc.syky.hud.hudSupport54;
import cc.syky.hud.hudSupport57;
import cc.syky.hud.hudSupport60;
import java.util.function.Consumer;
import net.minecraft.class_2960;
import org.jetbrains.annotations.Nullable;

public final class uiSupport40 extends uiSupport39 {
   private final uiSupport44 v1;
   private final SearchSupport v2;
   private final uiSupport43 v3;
   private final uiSupport42 v4;
   private final uiSupport42 v5;
   private final uiSupport41 v6;
   private float v7;
   private final hudSupport57 v8 = new hudSupport57(1.0F, 150.0F);
   private boolean v13;

   public uiSupport40(float var1, Consumer<String> var2, Runnable var3, Runnable var4, Runnable var5, Runnable var6, Runnable var7, Runnable var8) {
      this.v7 = var1;
      this.v1 = new uiSupport44(
         var1, new uiSupport44.Part1(uiSupport143.v3, 15.0F, 18.0F, 0.0F), var3, new uiSupport44.Part1(uiSupport143.v4, 17.0F, 17.0F), var4
      );
      this.v2 = new SearchSupport(var1, var2);
      this.v3 = new uiSupport43(var1, var5);
      this.v4 = new uiSupport42(var1, 20.0F, var6);
      this.v5 = new uiSupport42(var1, 16.0F, var7);
      this.v6 = new uiSupport41(var1, var8);
      this.v1(this.v1).v1(this.v2).v1(this.v3).v1(this.v4).v1(this.v5).v1(this.v6);

      for (uiSupport45 var12 : new uiSupport45[]{this.v1, this.v2, this.v3, this.v4, this.v5, this.v6}) {
         var12.v5(true);
      }
   }

   public void v1(@Nullable String var1, @Nullable class_2960 var2, boolean var3) {
      this.v4.v1(var1, var2, var3);
   }

   public void v1(boolean var1) {
      if (this.v13 != var1) {
         this.v13 = var1;
         this.v8.v2(var1 ? 0.0F : 1.0F);
         if (var1) {
            this.v2.v3(false);
         }
      }
   }

   public void v2(boolean var1) {
      this.v2.v1(var1);
   }

   public void v1(@Nullable String var1, boolean var2) {
      this.v5.v1(var1, null, var2);
   }

   public void v1(boolean var1, boolean var2) {
      this.v6.v1(var1, var2);
   }

   public void v3(boolean var1) {
      this.v1.v2(var1);
   }

   public void v1(float var1) {
      this.v7 = var1;
      this.v1.v1(var1);
      this.v2.v1(var1);
      this.v3.v1(var1);
      this.v4.v1(var1);
      this.v5.v1(var1);
      this.v6.v1(var1);
   }

   public void v4(boolean var1) {
      this.v3.v1(var1);
   }

   public void v5(boolean var1) {
      this.v1.v1(var1);
   }

   public void v6(boolean var1) {
      this.v2.v2(var1);
   }

   public SearchSupport v1() {
      return this.v2;
   }

   public boolean v2() {
      return this.v2.v1();
   }

   public void v3() {
      this.v2.v3(false);
   }

   public boolean v3(float var1, float var2) {
      return this.v1(var1, var2)
         && (
            this.v13
               || !this.v1.v1(var1, var2)
                  && !this.v2.v1(var1, var2)
                  && !this.v3.v1(var1, var2)
                  && !this.v4.v1(var1, var2)
                  && !this.v5.v1(var1, var2)
                  && !this.v6.v1(var1, var2)
         );
   }

   public boolean v4(float var1, float var2) {
      return this.v1(var1, var2) && !this.v3(var1, var2);
   }

   public boolean v5(float var1, float var2) {
      return this.v1(var1, var2) && (!this.v2.v1() || !this.v2.v1(var1, var2));
   }

   @Nullable
   public uiSupport45 v6(float var1, float var2) {
      if (this.v13) {
         return null;
      } else if (this.v1.v1(var1, var2)) {
         return this.v1;
      } else if (this.v2.v1(var1, var2)) {
         return this.v2;
      } else if (this.v4.v1(var1, var2)) {
         return this.v4;
      } else if (this.v5.v1(var1, var2)) {
         return this.v5;
      } else if (this.v6.v1(var1, var2)) {
         return this.v6;
      } else {
         return this.v3.v1(var1, var2) ? this.v3 : null;
      }
   }

   public boolean v7(float var1, float var2) {
      return !this.v13 && this.v2.v1(var1, var2);
   }

   @Override
   public boolean v1(float var1, float var2, int var3) {
      return !this.v13 && super.v1(var1, var2, var3);
   }

   @Override
   public hudSupport54 v2(float var1, float var2) {
      return this.v13 ? hudSupport54.ARROW : super.v2(var1, var2);
   }

   @Override
   public void v1(int var1, int var2) {
      this.v6();
   }

   private void v6() {
      float var1 = this.v10 + SignInSupport.v4(16.0F, this.v7);
      float var2 = this.v10 + SignInSupport.v4(54.0F, this.v7) - var1;
      float var3 = this.v1.v2(this.v7);
      float var4 = this.v9 + SignInSupport.v4(16.0F, this.v7);
      this.v1.v1(var4, var1, var3, var2);
      float var5 = var4 + var3 + SignInSupport.v4(15.0F, this.v7);
      this.v2.v1(var5, var1, this.v9 + SignInSupport.v4(368.0F, this.v7) - var5, var2);
      float var6 = this.v9 + this.v11 - SignInSupport.v4(54.0F, this.v7);
      this.v3.v1(var6, var1, this.v9 + this.v11 - SignInSupport.v4(16.0F, this.v7) - var6, var2);
      float var7 = 69.0F;
      float var8 = this.v9 + this.v11 - SignInSupport.v4(var7, this.v7);
      float var9 = this.v9 + this.v11 - SignInSupport.v4(var7 + 38.0F, this.v7);
      this.v6.v1(var9, var1, var8 - var9, var2);
      float var10 = !(this.v6.v4() > 0.0F) && !this.v6.v1() ? var7 : var7 + 38.0F + 15.0F;
      float var11 = this.v9 + this.v11 - SignInSupport.v4(var10, this.v7);
      float var12 = this.v9 + this.v11 - SignInSupport.v4(var10 + this.v4.v5(), this.v7);
      this.v4.v1(var12, var1, var11 - var12, var2);
      float var13 = !(this.v4.v4() > 0.0F) && !this.v4.v1() ? var10 : var10 + this.v4.v5() + 15.0F;
      float var14 = this.v9 + this.v11 - SignInSupport.v4(var13, this.v7);
      float var15 = this.v9 + this.v11 - SignInSupport.v4(var13 + this.v5.v5(), this.v7);
      this.v5.v1(var15, var1, var14 - var15, var2);
   }

   @Override
   public void v1(uiSupport35 var1) {
      this.v6();
      float var2 = hudSupport60.v1(this.v8.v2());
      if (!(var2 <= 0.0F)) {
         uiSupport35 var3 = this.v13 ? var1.v1() : var1;
         this.v1.v3(var3, var2);
         float var4 = this.v2.v4() * var2;
         if (var4 > 0.0F) {
            this.v2.v3(var3, var4);
         }

         this.v3.v3(var3, var2);
         float var5 = this.v4.v4() * var2;
         if (var5 > 0.0F) {
            this.v4.v3(var3, var5);
         }

         float var6 = this.v5.v4() * var2;
         if (var6 > 0.0F) {
            this.v5.v3(var3, var6);
         }

         float var7 = this.v6.v4() * var2;
         if (var7 > 0.0F) {
            this.v6.v3(var3, var7);
         }
      }
   }
}
