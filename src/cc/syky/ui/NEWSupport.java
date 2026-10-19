package cc.syky.ui;

import cc.syky.cloud.cloudRecord11;
import cc.syky.cloud.cloudSupport94;
import cc.syky.hud.hudSupport54;
import cc.syky.hud.hudSupport57;
import cc.syky.hud.hudSupport75;
import cc.syky.internal.InternalSupport2;
import cc.syky.module.ModuleContract;
import org.jetbrains.annotations.Nullable;

public final class NEWSupport extends UiWidget {
   private final ModuleContract v1;
   private final uiSupport226 v7;
   @Nullable
   private final hudSupport75 v8;
   @Nullable
   private final uiSupport124 v13;
   private final uiSupport124 v14;
   private final uiSupport136 v15;
   private final uiSupport130 v16;
   private final hudSupport57 v18;
   private final hudSupport57 v19;
   private final uiSupport50 v17 = new uiSupport50();
   private final hudSupport57 v20;
   private int v21 = -1;
   @Nullable
   private String v22;
   private final hudSupport57 v24;
   @Nullable
   private String v25;
   private float v26;
   private float v27 = -1.0F;
   @Nullable
   private String v28;
   private static final String v29 = "NEW";
   private final hudSupport57 v30;
   private float v32;
   private float v23 = -1.0F;
   @Nullable
   private String v33;
   @Nullable
   private hudSupport57 v31;

   public NEWSupport(
      ModuleContract var1, uiSupport226 var2, @Nullable hudSupport75 var3, float var4, uiSupport124 var5, uiSupport136 var6, uiSupport130 var7, boolean var8
   ) {
      super(var4, var8);
      this.v1 = var1;
      this.v7 = var2;
      this.v8 = var3;
      this.v13 = var1.getSettings().all().isEmpty() ? null : var5;
      this.v14 = var5;
      this.v15 = var6;
      this.v16 = var7;
      this.v18 = new hudSupport57(this.v4() ? 1.0F : 0.0F, 55.0F);
      this.v30 = new hudSupport57(InternalSupport2.v1(var1.getName()) ? 1.0F : 0.0F, 150.0F);
      this.v19 = new hudSupport57(0.0F, 45.0F);
      this.v20 = new hudSupport57(0.0F, 45.0F);
      this.v25 = this.v8();
      this.v24 = new hudSupport57(this.v25 != null ? 1.0F : 0.0F, 150.0F);
   }

   @Override
   public void v1(uiSupport102 var1) {
      super.v1(var1);
      var1.v1(this.v4());
      var1.v1(this.v1() != null);
      var1.v1(this.v13 != null && this.v13.v1(this.v1));
      var1.v1(this.v14.v13());
   }

   @Nullable
   public String v1() {
      return this.v7.v8(this.v1.getName());
   }

   private boolean v4() {
      return this.v1() != null ? this.v7.v9(this.v1.getName()) : this.v1.isEnabled();
   }

   public ModuleContract v3() {
      return this.v1;
   }

   @Override
   public String v2() {
      return this.v1.getName();
   }

   public boolean v3(float var1, float var2) {
      return this.v1() == null && uiSupport106.v2(uiSupport105.MODULE, var1, var2, this.v5(), this.v6(21.0F), this.v4)
         ? true
         : this.v13 != null && uiSupport111.v1(uiSupport110.MODULE, var1, var2, this.v6(), this.v6(5.0F), this.v4);
   }

   private float v5() {
      return this.v9 + this.v11 - 55.0F * this.v4;
   }

   private float v6(float var1) {
      return uiSupport126.v1(this.v10, this.v12, SignInSupport.v4(var1, this.v4), SignInSupport.v4(54.0F, this.v4));
   }

   private float v6() {
      return this.v5() - 35.0F * this.v4;
   }

   private float v7() {
      return this.v13 != null ? this.v6() : this.v5();
   }

   @Nullable
   private String v8() {
      hudSupport75 var1 = this.v8;
      if (var1 == null) {
         return null;
      } else {
         int var2 = var1.v2();
         if (var2 != this.v21) {
            this.v21 = var2;
            cloudRecord11 var3 = var1.v3(this.v1.getName()).orElse(null);
            this.v22 = var3 != null && var3.v3() != -1 ? cloudSupport94.v2(var3.v1()) : null;
         }

         return this.v22;
      }
   }

   private void v1(float var1, int var2) {
      String var3 = this.v8();
      this.v24.v2(var3 != null ? 1.0F : 0.0F);
      String var4 = this.v25;
      if (var3 != null && var4 != null && !var3.equals(var4)) {
         this.v33 = var4;
         hudSupport57 var5 = new hudSupport57(0.0F, 150.0F);
         var5.v2(1.0F);
         this.v31 = var5;
      }

      if (var3 != null) {
         this.v25 = var3;
      }

      float var11 = this.v24.v2();
      if (var3 == null && this.v24.v1()) {
         this.v25 = null;
      }

      float var6 = 1.0F;
      hudSupport57 var7 = this.v31;
      if (var7 != null) {
         float var8 = var7.v2();
         var6 = SignInSupport.v1(var8);
         if (var7.v1()) {
            this.v31 = null;
            this.v33 = null;
         }
      }

      String var12 = this.v25;
      if (var12 != null && !(var11 <= 0.0F)) {
         float var9 = SignInSupport.v1(var11);
         String var10 = this.v33;
         if (var10 != null) {
            this.v1(var10, var9 * (1.0F - var6), var1, var2, false);
         }

         this.v1(var12, var9 * var6, var1, var2, true);
      }
   }

   private void v1(String var1, float var2, float var3, int var4, boolean var5) {
      if (!(var2 <= 0.0F)) {
         float var6 = 14.0F * this.v4;
         float var7 = this.v7() - 10.0F * this.v4;
         float var8 = var5 ? this.v1(var1, var6) : uiSupport169.v2("syky_sans_strong", var1, var6);
         float var9 = var7 - var8;
         if (!(var9 < var3 + 12.0F * this.v4)) {
            float var10 = this.v4(14.0F);
            float var11 = var6 * 1.25F;
            int var12 = uiSupport155.v1(var4, this.v5);
            boolean var13 = uiSupport132.v1(uiSupport132.v1, var2, var9, var10, var8, var11, this.v4);

            try {
               uiSupport169.v2("syky_sans_strong", var1, var7, var10, var6, var13 ? var12 : uiSupport155.v1(var12, var2));
            } finally {
               if (var13) {
                  uiSupport132.v2(uiSupport132.v1, var2, var9, var10, var8, var11, this.v4);
               }
            }
         }
      }
   }

   private float v7(float var1) {
      this.v30.v2(InternalSupport2.v1(this.v1.getName()) ? 1.0F : 0.0F);
      float var2 = this.v30.v2();
      if (var2 <= 0.0F) {
         return var1;
      } else {
         float var3 = 14.0F * this.v4;
         float var4 = var1 + 8.0F * this.v4;
         float var5 = this.v8(var3);
         if (var4 + var5 > this.v7() - 10.0F * this.v4) {
            return var1;
         } else {
            float var6 = this.v4(14.0F);
            float var7 = var3 * 1.25F;
            int var8 = uiSupport155.v1(SignInSupport.v10(), this.v5);
            boolean var9 = uiSupport132.v1(uiSupport132.v1, var2, var4, var6, var5, var7, this.v4);

            try {
               int var10 = var9 ? var8 : uiSupport155.v1(var8, var2);
               uiSupport169.v1("syky_sans_quiet", "NEW", var4, var6, var3, var10);
            } finally {
               if (var9) {
                  uiSupport132.v2(uiSupport132.v1, var2, var4, var6, var5, var7, this.v4);
               }
            }

            return var4 + var5;
         }
      }
   }

   private float v8(float var1) {
      if (var1 != this.v23 || this.v32 <= 0.0F) {
         this.v32 = uiSupport169.v2("syky_sans_quiet", "NEW", var1);
         this.v23 = var1;
      }

      return this.v32;
   }

   private float v1(String var1, float var2) {
      if (!var1.equals(this.v28) || var2 != this.v27 || this.v26 <= 0.0F) {
         this.v28 = var1;
         this.v27 = var2;
         this.v26 = uiSupport169.v2("syky_sans_strong", var1, var2);
      }

      return this.v26;
   }

   @Override
   public void v1(uiSupport35 var1) {
      boolean var2 = this.v19().v1() && !this.v14.v13() && var1.v2();
      if (this.v22()) {
         this.v6.v2(var2 && this.v1(var1.v1, var1.v2) ? 1.0F : 0.0F);
         this.v5(this.v6.v2());
         this.v26();
      }

      if (this.v24()) {
         float var3 = this.v5;
         if (this.v25()) {
            this.v5 = this.v5 * this.v21();
         }

         try {
            this.v1(var1, this.v6.v2(), var2 && this.v1() == null);
         } finally {
            this.v5 = var3;
         }
      }
   }

   @Override
   public float v21() {
      return this.v1() != null ? 0.4F : 1.0F;
   }

   private void v1(uiSupport35 var1, float var2, boolean var3) {
      this.v18.v2(this.v4() ? 1.0F : 0.0F);
      float var4 = this.v18.v2();
      int var5 = SignInSupport.v3(var4, var2);
      float var6 = this.v9 + 16.0F * this.v4;
      float var7 = var6 + uiSupport169.v1("syky_sans_strong", this.v1.getDisplayName(), var6, this.v4(18.0F), 18.0F * this.v4, uiSupport155.v1(var5, this.v5));
      this.v1(this.v7(var7), var5);
      if (this.v13 != null) {
         float var8 = this.v6(5.0F);
         boolean var9 = this.v19().v1() && uiSupport111.v1(uiSupport110.MODULE, var1.v1, var1.v2, this.v6(), var8, this.v4);
         this.v19.v2(var9 ? 1.0F : 0.0F);
         int var10 = this.v17.v1(uiSupport111.v1(uiSupport110.MODULE, var4, this.v19.v2()), this.v19().v1() && this.v13.v1(this.v1));
         uiSupport111.v1(uiSupport110.MODULE, this.v6(), var8, this.v4, var10, this.v5);
      }

      float var11 = this.v6(21.0F);
      this.v20.v2(var3 && uiSupport106.v2(uiSupport105.MODULE, var1.v1, var1.v2, this.v5(), var11, this.v4) ? 1.0F : 0.0F);
      uiSupport106.v1(uiSupport105.MODULE, this.v5(), var11, this.v4, var4, this.v5, this.v20.v2());
   }

   @Override
   public hudSupport54 v2(float var1, float var2) {
      return this.v17() && this.v1(var1, var2) && this.v3(var1, var2) ? hudSupport54.POINTER : hudSupport54.ARROW;
   }

   @Override
   public boolean v2(float var1, float var2, int var3) {
      if (!this.v17() || !this.v1(var1, var2)) {
         return false;
      } else {
         return var3 != 2 && var3 != 1
            ? var3 == 0 && this.v13 != null && uiSupport111.v1(uiSupport110.MODULE, var1, var2, this.v6(), this.v6(5.0F), this.v4)
            : true;
      }
   }

   @Override
   public boolean v1(float var1, float var2, int var3) {
      if (!this.v17() || !this.v1(var1, var2)) {
         return false;
      } else if (var3 == 2) {
         this.v15.v1(this.v1, var1, var2);
         return true;
      } else if (var3 == 1) {
         this.v16.v3(this.v1, var1, var2);
         return true;
      } else if (var3 != 0) {
         return false;
      } else {
         if (this.v13 != null) {
            float var4 = this.v6(5.0F);
            if (uiSupport111.v1(uiSupport110.MODULE, var1, var2, this.v6(), var4, this.v4)) {
               this.v13.v2(this.v1, var1, var2);
               return true;
            }
         }

         if (this.v1() == null && uiSupport106.v2(uiSupport105.MODULE, var1, var2, this.v5(), this.v6(21.0F), this.v4)) {
            v1(this.v7, this.v1);
            return true;
         } else {
            return false;
         }
      }
   }

   public static void v1(uiSupport226 var0, ModuleContract var1) {
      if (var0.v8(var1.getName()) == null) {
         var0.v5(var1.getName());
         uiSupport148.v1(uiSupport146.v1(var1.isEnabled()));
         if (var1.isEnabled()) {
            InternalSupport2.v2(var1.getName());
         }
      }
   }
}
