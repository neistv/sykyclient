package cc.syky.ui;

import cc.syky.hud.hudSupport54;
import cc.syky.hud.hudSupport57;
import cc.syky.hud.hudSupport60;
import net.minecraft.class_2960;

public final class uiSupport44 extends uiSupport45 {
   private final uiSupport44.Part1 v1;
   private final uiSupport44.Part1 v2;
   private final Runnable v3;
   private final Runnable v4;
   private final hudSupport57 v5 = new hudSupport57(0.0F, 90.0F);
   private final hudSupport57 v6 = new hudSupport57(0.0F, 90.0F);
   private final uiSupport50 v7 = new uiSupport50();
   private boolean v8;
   private final hudSupport57 v13 = new hudSupport57(0.0F, 150.0F);
   private boolean v14;
   private boolean v15;

   public uiSupport44(float var1, uiSupport44.Part1 var2, Runnable var3, uiSupport44.Part1 var4, Runnable var5) {
      super(var1);
      this.v1 = var2;
      this.v2 = var4;
      this.v3 = var3;
      this.v4 = var5;
   }

   public void v1(boolean var1) {
      this.v8 = var1;
   }

   public void v2(boolean var1) {
      this.v15 = var1;
      if (!this.v14) {
         this.v14 = true;
         this.v13.v3(var1 ? 1.0F : 0.0F);
      } else {
         this.v13.v2(var1 ? 1.0F : 0.0F);
      }
   }

   private float v1() {
      return hudSupport60.v1(this.v13.v2());
   }

   public float v2(float var1) {
      return SignInSupport.v4(37.5F, var1) * (1.0F + this.v1());
   }

   private float v4() {
      return this.v9 + SignInSupport.v4(37.5F, this.v13());
   }

   @Override
   public void v3(uiSupport35 var1) {
      float var2 = this.v13();
      float var3 = this.v4();
      float var4 = 37.5F * var2;
      boolean var5 = this.v4(var1);
      this.v6.v2(var5 && var1.v1 < var3 ? 1.0F : 0.0F);
      this.v5.v2(var5 && var1.v1 >= var3 ? 1.0F : 0.0F);
      this.v1(this.v9, var3, hudSupport60.v1(this.v6.v2()));
      this.v1(var3, this.v9 + this.v11, hudSupport60.v1(this.v5.v2()));
      float var6 = this.v1.v2() * var2;
      float var7 = this.v1.v3() * var2;
      uiSupport169.v1(
         this.v1.v1(),
         this.v9 + (var4 - var6) / 2.0F + this.v1.v4() * var2,
         this.v10 + (this.v12 - var7) / 2.0F,
         var6,
         var7,
         this.v7.v1(v1(this.v6), this.v8),
         uiRecord7.ZERO
      );
      float var8 = this.v1();
      if (!(var8 <= 0.0F)) {
         boolean var9 = var8 < 1.0F;
         if (var9) {
            uiSupport169.v6(this.v9, this.v10, this.v11, this.v12);
         }

         try {
            float var10 = this.v2.v2() * var2;
            float var11 = this.v2.v3() * var2;
            float var12 = var3 + (var4 - var10) / 2.0F + this.v2.v4() * var2;
            float var13 = this.v10 + (this.v12 - var11) / 2.0F;
            boolean var14 = uiSupport132.v1(uiSupport132.v5, var8, var12, var13, var10, var11, var2);

            try {
               uiSupport169.v1(this.v2.v1(), var12, var13, var10, var11, var14 ? v1(this.v5) : uiSupport155.v1(v1(this.v5), var8), uiRecord7.ZERO);
            } finally {
               if (var14) {
                  uiSupport132.v2(uiSupport132.v5, var8, var12, var13, var10, var11, var2);
               }
            }

            float var15 = SignInSupport.v2(var2);
            float var16 = 26.0F * var2 * var8;
            uiSupport169.v1(
               var3 - var15 / 2.0F,
               this.v10 + (this.v12 - var16) / 2.0F,
               var15,
               var16,
               uiSupport155.v1(SignInSupport.v1(SignInSupport.v32(), var2), var8),
               uiRecord7.ZERO
            );
         } finally {
            if (var9) {
               uiSupport169.v17();
            }
         }
      }
   }

   private static int v1(hudSupport57 var0) {
      return uiSupport155.v1(SignInSupport.v28(), SignInSupport.v30(), hudSupport60.v1(var0.v2()));
   }

   @Override
   public boolean v1(float var1, float var2, int var3) {
      if (!this.v1(var1, var2)) {
         return false;
      } else if (var3 == 1) {
         this.v3.run();
         return true;
      } else if (var3 != 0) {
         return false;
      } else {
         this.v3(var1, var2);
         return true;
      }
   }

   @Override
   public void v3(float var1, float var2) {
      if (var1 < this.v4()) {
         this.v3.run();
      } else if (this.v15) {
         this.v4.run();
      }
   }

   @Override
   public hudSupport54 v2(float var1, float var2) {
      return hudSupport54.POINTER;
   }

   public record Part1(class_2960 id, float designW, float designH, float nudgeX) {
      public Part1(class_2960 var1, float var2, float var3) {
         this(var1, var2, var3, 0.0F);
      }

      public class_2960 v1() {
         return this.id;
      }

      public float v2() {
         return this.designW;
      }

      public float v3() {
         return this.designH;
      }

      public float v4() {
         return this.nudgeX;
      }
   }
}
