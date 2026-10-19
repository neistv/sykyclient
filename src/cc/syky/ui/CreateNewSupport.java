package cc.syky.ui;

import cc.syky.cloud.CloudClient;
import cc.syky.cloud.OnlyMeSupport2;
import cc.syky.cloud.SykySession;
import cc.syky.hud.hudSupport54;
import org.jetbrains.annotations.Nullable;

public final class CreateNewSupport extends UiNode {
   private static final String v1 = "Get your syky account";
   private static final String v2 = "Create new account";
   private static final String v3 = "Login";
   private static final String v4 = "Continue in your browser";
   private static boolean v5;
   @Nullable
   private final CloudClient v6;
   @Nullable
   private final SignOutSupport v7;
   private final uiSupport123 v8;
   private final uiSupport123 v13;
   private final Runnable v14 = this::v5;
   private final Runnable v15 = this::v6;
   private float v16;
   private float v18;
   private float v19;
   private float v17;

   public CreateNewSupport(@Nullable CloudClient var1, float var2, uiSupport120 var3, Runnable var4) {
      this.v6 = var1;
      this.v16 = var2;
      this.v7 = var1 == null ? null : new SignOutSupport(OnlyMeSupport2.v1(var1), var2, var3, var4);
      this.v8 = new uiSupport123(var2, uiSupport123.Part1.PAGE);
      this.v13 = new uiSupport123(var2, uiSupport123.Part1.PAGE);
   }

   public void v1(float var1) {
      this.v16 = var1;
      this.v8.v1(var1);
      this.v13.v1(var1);
      if (this.v7 != null) {
         this.v7.v1(var1);
      }
   }

   public float v1() {
      SignOutSupport var1 = this.v4();
      return var1 == null ? 0.0F : (var1.v2() - 82.0F) * this.v16;
   }

   public void v2() {
      if (this.v6 != null) {
         OnlyMeSupport2.v1(this.v6).v20();
      }
   }

   public boolean v1(String var1) {
      if (this.v6 == null) {
         return false;
      } else {
         OnlyMeSupport2.v1(this.v6).v1(var1);
         return true;
      }
   }

   @Nullable
   private SignOutSupport v4() {
      SignOutSupport var1 = this.v7;
      CloudClient var2 = this.v6;
      return var1 == null || var2 == null || SykySession.v1() == null && OnlyMeSupport2.v1(var2).v8() ? null : var1;
   }

   public void v1(float var1, float var2, float var3, float var4, float var5) {
      this.v1(var1, var2 + var5, var3, var4);
      SignOutSupport var6 = this.v4();
      if (var6 != null) {
         var6.v1(var1, var2, var3, var4, var5);
      } else {
         float var7 = this.v16;
         float var8 = var3 / var7 / 2.0F;
         float var9 = var8 - 176.0F;
         float var10 = var1 + SignInSupport.v4(var9, var7);
         float var11 = var1 + SignInSupport.v4(var9 + 352.0F, var7) - var10;
         float var12 = 285.0F;
         float var13 = var12 + 53.0F + 16.0F;
         this.v1(this.v8, var10, var11, var2 + var5, var12);
         this.v1(this.v13, var10, var11, var2 + var5, var13);
         this.v18 = var1 + SignInSupport.v4(var8 - 19.0F, var7);
         this.v19 = var2 + SignInSupport.v4(169.0F, var7) + var5;
         this.v17 = var2 + SignInSupport.v4(224.0F, var7) + var5;
      }
   }

   private void v1(uiSupport123 var1, float var2, float var3, float var4, float var5) {
      float var6 = var4 + SignInSupport.v4(var5, this.v16);
      var1.v1(var2, var6, var3, var4 + SignInSupport.v4(var5 + 53.0F, this.v16) - var6);
   }

   @Override
   public void v1(uiSupport35 var1) {
      SignOutSupport var2 = this.v4();
      if (var2 != null) {
         var2.v1(var1);
      } else {
         boolean var3 = this.v6 != null && this.v6.v18();
         this.v8.v1(var3 && v5 ? "Continue in your browser" : "Create new account", true, this.v14);
         this.v13.v1(var3 && !v5 ? "Continue in your browser" : "Login", false, this.v15);
         float var4 = 38.0F * this.v16;
         uiSupport169.v1(uiSupport143.v1, this.v18, this.v19, var4, var4, SignInSupport.v24(), uiRecord7.ZERO);
         float var5 = 24.0F * this.v16;
         float var6 = uiSupport169.v2("syky_sans_strong", "Get your syky account", var5);
         uiSupport169.v1(
            "syky_sans_strong",
            "Get your syky account",
            this.v9 + (this.v11 - var6) / 2.0F,
            uiSupport169.v1(this.v17 + 29.0F * this.v16 / 2.0F, var5),
            var5,
            SignInSupport.v22()
         );
         this.v8.v1(var1);
         this.v13.v1(var1);
      }
   }

   public int v3() {
      SignOutSupport var1 = this.v4();
      if (var1 != null) {
         return 31 * var1.v1() + 1;
      } else {
         byte var2 = 0;
         if (this.v6 != null && this.v6.v18()) {
            var2 |= 2;
         }

         if (v5) {
            var2 |= 4;
         }

         return var2;
      }
   }

   @Override
   public boolean v1(float var1, float var2, int var3) {
      SignOutSupport var4 = this.v4();
      return var4 != null ? var4.v1(var1, var2, var3) : this.v8.v1(var1, var2, var3) || this.v13.v1(var1, var2, var3);
   }

   @Override
   public hudSupport54 v2(float var1, float var2) {
      SignOutSupport var3 = this.v4();
      if (var3 != null) {
         return var3.v2(var1, var2);
      } else {
         return !this.v8.v1(var1, var2) && !this.v13.v1(var1, var2) ? hudSupport54.ARROW : hudSupport54.POINTER;
      }
   }

   private void v5() {
      if (this.v6 != null) {
         v5 = true;
         this.v6.v16();
      }
   }

   private void v6() {
      if (this.v6 != null) {
         v5 = false;
         this.v6.v15();
      }
   }
}
