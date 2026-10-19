package cc.syky.ui;

import cc.syky.hud.hudSupport54;
import cc.syky.hud.hudSupport57;
import org.jetbrains.annotations.Nullable;

public final class uiSupport114 extends UiNode {
   private final uiSupport114.Part1 v1;
   private String v2;
   private String v3;
   private boolean v4;
   private final uiSupport109 v5;
   private final hudSupport57 v6;
   private final hudSupport57 v7;
   private float v8 = 1.0F;
   private final uiSupport99 v13;
   private final uiSupport134 v14 = new uiSupport134();
   private float v15 = 1.0F;

   public uiSupport114(uiSupport114.Part1 var1, uiRecord5 var2, float var3, boolean var4) {
      this.v1 = var1;
      this.v2 = var2.v1();
      this.v3 = uiSupport101.v1(var2.v1());
      this.v4 = var2.v2();
      this.v15 = var3;
      this.v5 = new uiSupport109(var2.v2());
      this.v6 = new hudSupport57(var2.v2() ? 1.0F : 0.0F, 90.0F);
      this.v7 = new hudSupport57(var2.v2() ? 1.0F : 0.0F, 150.0F);
      this.v13 = new uiSupport99(var4);
   }

   public String v1() {
      return this.v2;
   }

   public String v2() {
      return this.v3;
   }

   private void v1(String var1) {
      this.v2 = var1;
      this.v3 = uiSupport101.v1(var1);
   }

   public boolean v3() {
      return this.v4;
   }

   public void v1(float var1) {
      this.v15 = var1;
   }

   public void v1(uiRecord5 var1) {
      this.v1(var1.v1());
      this.v4 = var1.v2();
      this.v5.v1(var1.v2());
      this.v7.v2(var1.v2() ? 1.0F : 0.0F);
   }

   public uiSupport99 v4() {
      return this.v13;
   }

   private boolean v9() {
      return this.v13.v1() && this.v13.v5() > 0.0F;
   }

   public void v1(uiSupport35 var1, float var2) {
      if (var2 <= 0.0F) {
         this.v8 = var2;
      } else {
         boolean var3 = this.v12 < SignInSupport.v4(41.0F, this.v15) - 0.5F;
         if (var3) {
            uiSupport169.v6(this.v9, this.v10, this.v11, this.v12);
         }

         boolean var4 = uiSupport132.v1(uiSupport132.v1, var2, this.v9, this.v10, this.v11, this.v12, this.v15);
         this.v8 = var4 ? 1.0F : var2;

         try {
            this.v1(var1);
         } finally {
            if (var4) {
               uiSupport132.v2(uiSupport132.v1, var2, this.v9, this.v10, this.v11, this.v12, this.v15);
            }

            if (var3) {
               uiSupport169.v17();
            }
         }
      }
   }

   public boolean v5() {
      return this.v14.v1();
   }

   public void v6() {
      this.v14.v1(this.v2, 48);
   }

   public void v7() {
      String var1 = this.v14.v2();
      if (var1 != null) {
         String var2 = var1.trim();
         if (!var2.isEmpty() && !var2.equals(this.v2)) {
            this.v1(this.v1.v1(this.v2, var2));
         }
      }
   }

   public void v8() {
      this.v14.v3();
   }

   @Override
   public void v1(uiSupport35 var1) {
      float var2 = 12.0F * this.v15;
      uiRecord7 var3 = uiRecord7.v1(var2);
      this.v6.v2(this.v4 ? 1.0F : (this.v4(var1) ? 0.7F : 0.0F));
      float var4 = SignInSupport.v1(this.v6.v2()) * this.v8;
      float var5 = this.v7.v2();
      if (var4 > 0.0F) {
         uiSupport169.v1(
            this.v9,
            this.v10,
            this.v11,
            this.v12,
            uiSupport155.v1(uiSupport155.v1(SignInSupport.v7(), SignInSupport.v5(), var5), var4),
            uiSupport155.v1(SignInSupport.v1(uiSupport155.v1(SignInSupport.v8(), SignInSupport.v6(), var5), this.v15), var4),
            SignInSupport.v2(this.v15),
            1.0F,
            var3
         );
      }

      float var6 = SignInSupport.v4(21.0F, this.v15);
      float var7 = this.v9 + this.v11 - SignInSupport.v4(31.0F, this.v15);
      float var8 = uiSupport126.v1(this.v10, this.v12, var6, SignInSupport.v4(41.0F, this.v15));
      this.v5.v1(var7, var8, this.v15, this.v8);
      if (this.v14.v1()) {
         this.v10();
         this.v14.v1(var1);
      } else {
         float var9 = 18.0F * this.v15;
         uiSupport169.v1(
            "syky_sans_strong",
            this.v2,
            this.v9 + 10.0F * this.v15,
            uiSupport169.v1(this.v10 + this.v12 / 2.0F, var9),
            var9,
            uiSupport155.v1(uiSupport155.v1(uiSupport113.v2(), uiSupport113.v1(), var5), this.v8)
         );
      }
   }

   private void v10() {
      this.v14.v1(this.v9 + SignInSupport.v4(10.0F, this.v15), this.v11(), this.v10, this.v12, 18.0F, this.v15, this.v8);
   }

   private float v11() {
      return this.v9 + this.v11 - SignInSupport.v4(41.0F, this.v15);
   }

   @Override
   public boolean v1(float var1, float var2) {
      if (!this.v9()) {
         return false;
      } else {
         float var3 = 3.0F * this.v15;
         return var1 >= this.v9 && var2 >= this.v10 - var3 && var1 < this.v9 + this.v11 && var2 < this.v10 + this.v12 + var3;
      }
   }

   @Override
   public boolean v1(float var1, float var2, int var3) {
      if (!this.v1(var1, var2)) {
         return false;
      } else if (this.v14.v1()) {
         this.v10();
         if (this.v14.v1(var1, var2)) {
            return this.v14.v1(var1, var2, var3);
         } else {
            this.v7();
            return true;
         }
      } else if (var3 == 1) {
         this.v1.v1(this, var1, var2);
         return true;
      } else if (var3 != 0) {
         return false;
      } else {
         this.v1.v1(this.v2);
         return true;
      }
   }

   @Override
   public boolean v1(float var1, float var2, int var3, float var4, float var5) {
      return this.v14.v1(var1, var2, var3, var4, var5);
   }

   @Override
   public boolean v4(float var1, float var2, int var3) {
      return this.v14.v2(var1, var2, var3);
   }

   @Override
   public boolean v2(int var1, int var2) {
      return this.v14.v1(var1, var2);
   }

   @Override
   public boolean v3(int var1, int var2) {
      return this.v14.v2(var1, var2);
   }

   @Override
   public hudSupport54 v2(float var1, float var2) {
      if (!this.v14.v1()) {
         return hudSupport54.POINTER;
      } else {
         this.v10();
         return this.v14.v2(var1, var2);
      }
   }

   @Nullable
   @Override
   public hudSupport54 v31() {
      return this.v14.v4();
   }

   public interface Part1 {
      void v1(String var1);

      String v1(String var1, String var2);

      void v1(uiSupport114 var1, float var2, float var3);
   }
}
