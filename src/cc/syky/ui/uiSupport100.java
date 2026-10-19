package cc.syky.ui;

import cc.syky.hud.hudSupport57;
import cc.syky.internal.InternalSupport25;
import cc.syky.module.ModuleContract;
import cc.syky.render.renderSupport47;
import java.util.List;
import java.util.Objects;
import net.minecraft.class_310;
import org.jetbrains.annotations.Nullable;

public final class uiSupport100 extends UiNode {
   @Nullable
   private ModuleContract v1;
   @Nullable
   private ModuleContract v2;
   @Nullable
   private String v3;
   private String v4 = "";
   private List<String> v5 = List.of();
   private float v6;
   private float v7;
   private boolean v8;
   private final uiSupport37 v13 = new uiSupport37(3.0F);
   private boolean v14;
   private hudSupport57 v15 = new hudSupport57(0.0F, 45.0F);
   private float v16;
   private float v18;
   private float v19;
   private float v17 = 1.0F;

   public uiSupport100() {
   }

   public void v1(@Nullable NEWSupport var1, float var2, float var3, float var4, float var5, float var6, float var7) {
      this.v17 = var7;
      ModuleContract var8 = var1 == null ? null : var1.v3();
      String var9 = var1 == null ? null : var1.v1();
      if (var8 != this.v2 || !Objects.equals(var9, this.v3)) {
         this.v2 = var8;
         this.v3 = var9;
         this.v8 = var8 != null && !v2(var8, var9).isEmpty();
         this.v3();
         this.v13.v1(var2, var3);
      } else if (!this.v14) {
         this.v13.v2(var2, var3);
      }

      if (this.v8 && !this.v14 && this.v13.v3(var4, 400.0F)) {
         if (this.v1(renderSupport47.v1(var8), var9)) {
            this.v1(renderSupport47.v1(var1), var5, var6);
         } else {
            this.v8 = false;
         }
      }

      this.v16 = this.v15.v2();
      if (!this.v14 && this.v15.v1()) {
         this.v1 = null;
         this.v16 = 0.0F;
      }

      if (this.v1 != null) {
         this.v3(var5, var6);
      }
   }

   private void v3() {
      this.v13.v1();
      if (this.v14) {
         this.v14 = false;
         this.v15.v2(0.0F);
      }
   }

   public boolean v1() {
      return this.v1 != null && this.v16 > 0.002F;
   }

   public float v2() {
      return this.v16;
   }

   private boolean v1(ModuleContract var1, @Nullable String var2) {
      String var3 = v2(var1, var2);
      if (var3.isEmpty()) {
         return false;
      } else {
         InternalSupport25.Part1 var4 = var0 -> uiSupport169.v2("syky_sans", var0, 16.0F);
         List var5 = v1(var3, var4);
         if (var5.isEmpty()) {
            return false;
         } else {
            this.v4 = var1.getDisplayName();
            this.v5 = InternalSupport25.v1(var5);
            float var6 = Math.max(uiSupport169.v2("syky_sans", this.v4, 16.0F), InternalSupport25.v1(this.v5, var4));
            this.v6 = Math.round(Math.max(240.0F, Math.min(385.0F, var6 + 32.0F)));
            this.v7 = v4() + 19.0F + 8.0F + (this.v5.size() - 1) * 19.0F + 15.2265625F + 16.0F;
            return true;
         }
      }
   }

   private static String v2(ModuleContract var0, @Nullable String var1) {
      String var2 = uiSupport135.v2(var0.getName(), var0.getDescription());
      if (var1 == null) {
         return var2;
      } else {
         String var3 = var1 + " does not allow this module, so it is off here. It works on every other server.";
         return var2.isEmpty() ? var3 : var3 + " " + var2;
      }
   }

   private static List<String> v1(String var0, InternalSupport25.Part1 var1) {
      float var2 = 208.0F;
      float var3 = 353.0F;
      List var4 = InternalSupport25.v1(var0, var3, var1);
      if (var4.isEmpty()) {
         return var4;
      } else {
         int var5 = var4.size();

         for (int var6 = 0; var6 < 8; var6++) {
            float var7 = (var2 + var3) / 2.0F;
            List var8 = InternalSupport25.v1(var0, var7, var1);
            if (var8.size() <= var5) {
               var4 = var8;
               var3 = var7;
            } else {
               var2 = var7;
            }
         }

         return var4;
      }
   }

   private static float v4() {
      return 12.0234375F;
   }

   private void v1(NEWSupport var1, float var2, float var3) {
      float var4 = this.v6 * this.v17;
      float var5 = this.v7 * this.v17;
      float var6 = SignInSupport.v4(24.0F, this.v17);
      class_310 var7 = class_310.method_1551();
      float var8 = var7.method_22683().method_4486();
      float var9 = var7.method_22683().method_4502();
      float var10 = var1.v9 + var1.v11;
      float var11 = var10 + var6 + var4 <= var8 ? var10 + var6 : var1.v9 - var6 - var4;
      this.v18 = (uiSupport89.v1(var11, var4, 0.0F, var8) - var2) / this.v17;
      this.v19 = (uiSupport89.v1(var1.v10 + var1.v12 / 2.0F - var5 / 2.0F, var5, 0.0F, var9) - var3) / this.v17;
      this.v1 = this.v2;
      this.v14 = true;
      this.v15 = new hudSupport57(0.0F, 45.0F);
      this.v15.v2(1.0F);
   }

   private void v3(float var1, float var2) {
      float var3 = SignInSupport.v4(this.v18, this.v17);
      float var4 = SignInSupport.v4(this.v19, this.v17);
      this.v1(var1 + var3, var2 + var4, SignInSupport.v4(this.v18 + this.v6, this.v17) - var3, SignInSupport.v4(this.v19 + this.v7, this.v17) - var4);
   }

   @Override
   public void v1(uiSupport35 var1) {
      if (this.v1 != null) {
         float var2 = 18.0F * this.v17;
         uiSupport97.v1(this.v9, this.v10, this.v11, this.v12, var2, this.v17, SignInSupport.v138(), SignInSupport.v106());
         float var3 = this.v9 + 16.0F * this.v17;
         uiSupport169.v1("syky_sans", this.v4, var3, this.v10 + v4() * this.v17, 16.0F * this.v17, SignInSupport.v100());
         float var4 = this.v10 + (v4() + 19.0F + 8.0F) * this.v17;

         for (String var6 : this.v5) {
            uiSupport169.v1("syky_sans", var6, var3, var4, 16.0F * this.v17, SignInSupport.v191());
            var4 += 19.0F * this.v17;
         }
      }
   }
}
