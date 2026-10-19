package cc.syky.ui;

import cc.syky.hud.hudSupport54;
import cc.syky.hud.hudSupport57;
import cc.syky.hud.hudSupport60;
import cc.syky.render.font.MsdfFont;
import java.util.function.Consumer;
import org.jetbrains.annotations.Nullable;

public final class SearchSupport extends uiSupport45 {
   private static final String v1 = "Search";
   private static final int v2 = 64;
   private final MsdfFont v3;
   private final Consumer<String> v4;
   private final hudSupport57 v5 = new hudSupport57(0.0F, 90.0F);
   private final hudSupport57 v6 = new hudSupport57(0.0F, 90.0F);
   private final hudSupport57 v7 = new hudSupport57(0.0F, 90.0F);
   private final hudSupport57 v8 = new hudSupport57(0.0F, 90.0F);
   private final hudSupport57 v13 = new hudSupport57(0.0F, 150.0F);
   private final hudSupport57 v14 = new hudSupport57(1.0F, 150.0F);
   private boolean v15 = true;

   public SearchSupport(float var1, Consumer<String> var2) {
      super(var1);
      this.v4 = var2;
      this.v3 = new MsdfFont("syky_sans", 64, var2);
      this.v3.v1("Search");
      this.v3.v1(1060L);
   }

   public void v1(String var1) {
      this.v3.v2(var1);
   }

   public boolean v1() {
      return this.v3.v3();
   }

   public void v1(boolean var1) {
      if (this.v15 != var1) {
         this.v15 = var1;
         this.v14.v2(var1 ? 1.0F : 0.0F);
         if (!var1) {
            this.v3.v3(false);
         }
      }
   }

   public float v4() {
      return hudSupport60.v1(this.v14.v2());
   }

   @Override
   public boolean v1(float var1, float var2) {
      return this.v15 && super.v1(var1, var2);
   }

   public void v2(boolean var1) {
      this.v8.v2(var1 ? 1.0F : 0.0F);
      this.v13.v2(var1 ? 1.0F : 0.0F);
   }

   @Override
   public float v12() {
      return hudSupport60.v1(this.v8.v2());
   }

   @Override
   public float v2(uiSupport35 var1) {
      this.v7.v2(this.v4(var1) ? 1.0F : 0.0F);
      return hudSupport60.v1(this.v7.v2());
   }

   public void v3(boolean var1) {
      this.v3.v3(var1);
   }

   public void v4(boolean var1) {
      this.v3.v2(var1);
   }

   public void v5() {
      if (this.v15) {
         this.v3.v3(true);
         this.v3.v4();
      }
   }

   private void v6() {
      this.v3.v2("");
      this.v3.v3(false);
      this.v4.accept("");
   }

   private float v7() {
      return this.v9 + this.v11 - 19.0F * this.v13();
   }

   private boolean v4(float var1, float var2) {
      if (this.v3.v2().isEmpty()) {
         return false;
      } else {
         float var3 = 20.0F * this.v13() / 2.0F;
         return Math.abs(var1 - this.v7()) <= var3 && Math.abs(var2 - (this.v10 + this.v12 / 2.0F)) <= var3;
      }
   }

   private void v8() {
      float var1 = this.v13();
      float var2 = this.v9 + 34.0F * var1;
      float var3 = 10.0F + 24.0F * hudSupport60.v1(this.v5.v2());
      float var4 = Math.max(0.0F, this.v9 + this.v11 - var3 * var1 - var2);
      this.v3.v1(var2, this.v10, var4, this.v12);
      float var5 = 16.0F * var1;
      this.v3.v1(var5, uiSupport169.v1(this.v12 / 2.0F, var5), 1.0F * var1);
      int var6 = uiSupport155.v1(SignInSupport.v33(), SignInSupport.v9(), this.v13.v2());
      this.v3.v1(var6, SignInSupport.v23(), SignInSupport.v31(), var6);
   }

   @Override
   public void v3(uiSupport35 var1) {
      float var2 = this.v13();
      float var3 = 16.0F * var2;
      uiSupport169.v1(
         uiSupport143.v2,
         this.v9 + 11.0F * var2,
         this.v10 + (this.v12 - var3) / 2.0F,
         var3,
         var3,
         uiSupport155.v1(SignInSupport.v28(), SignInSupport.v13(), this.v13.v2()),
         uiRecord7.ZERO
      );
      this.v5.v2(this.v3.v2().isEmpty() ? 0.0F : 1.0F);
      this.v6.v2(var1.v2() && this.v4(var1.v1, var1.v2) ? 1.0F : 0.0F);
      this.v8();
      this.v3.v1(var1);
      uiSupport112.v2(
         this.v7(),
         this.v10 + this.v12 / 2.0F,
         var2,
         hudSupport60.v1(this.v5.v2()),
         uiSupport155.v1(SignInSupport.v124(), SignInSupport.v117(), hudSupport60.v1(this.v6.v2()))
      );
   }

   @Override
   public boolean v1(float var1, float var2, int var3) {
      if (!this.v1(var1, var2)) {
         return false;
      } else if (this.v4(var1, var2)) {
         if (var3 == 0) {
            this.v6();
         }

         return true;
      } else {
         this.v8();
         return this.v3.v2(var1, var2, var3);
      }
   }

   @Override
   public void v3(float var1, float var2) {
      if (this.v4(var1, var2)) {
         this.v6();
      } else {
         this.v8();
         this.v3.v2(var1, var2, 0);
         this.v3.v4(var1, var2, 0);
      }
   }

   @Override
   public hudSupport54 v2(float var1, float var2) {
      return this.v4(var1, var2) ? hudSupport54.POINTER : hudSupport54.IBEAM;
   }

   @Nullable
   @Override
   public hudSupport54 v31() {
      return this.v3.v31();
   }

   @Override
   public boolean v1(float var1, float var2, int var3, float var4, float var5) {
      return this.v3.v1(var1, var2, var3, var4, var5);
   }

   @Override
   public boolean v4(float var1, float var2, int var3) {
      return this.v3.v4(var1, var2, var3);
   }

   @Override
   public boolean v2(int var1, int var2) {
      return this.v3.v2(var1, var2);
   }

   @Override
   public boolean v3(int var1, int var2) {
      return this.v3.v3(var1, var2);
   }
}
