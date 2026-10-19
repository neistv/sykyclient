package cc.syky.ui;

import cc.syky.hud.hudSupport54;
import cc.syky.render.font.MsdfFont;
import org.jetbrains.annotations.Nullable;

public final class uiSupport134 {
   @Nullable
   private MsdfFont v1;
   private float v2;
   private float v3;
   private float v4;
   private float v5;

   public uiSupport134() {
   }

   public boolean v1() {
      return this.v1 != null;
   }

   public void v1(String var1, int var2) {
      this.v1(var1, var2, "syky_sans_strong", null);
   }

   public void v1(String var1, int var2, String var3, @Nullable String var4) {
      MsdfFont var5 = new MsdfFont(var3, var2, var0 -> {});
      if (var4 != null) {
         var5.v1(var4);
      }

      var5.v2(var1);
      var5.v3(true);
      var5.v4();
      var5.v1(1060L);
      this.v1 = var5;
   }

   @Nullable
   public String v2() {
      MsdfFont var1 = this.v1;
      this.v1 = null;
      return var1 == null ? null : var1.v2();
   }

   public void v3() {
      this.v1 = null;
   }

   public void v1(float var1, float var2, float var3, float var4, float var5, float var6, float var7) {
      this.v2 = var1;
      this.v3 = var2;
      this.v4 = var3;
      this.v5 = var3 + var4;
      MsdfFont var8 = this.v1;
      if (var8 != null) {
         var8.v1(var1, var3, Math.max(0.0F, var2 - var1), var4);
         float var9 = var5 * var6;
         var8.v1(var9, uiSupport169.v1(var4 / 2.0F, var9), 1.0F * var6);
         int var10 = uiSupport155.v1(SignInSupport.v33(), var7);
         var8.v1(var10, uiSupport155.v1(SignInSupport.v23(), var7), SignInSupport.v31(), var10);
      }
   }

   public boolean v1(float var1, float var2) {
      return this.v1 != null && var1 >= this.v2 && var1 < this.v3 && var2 >= this.v4 && var2 < this.v5;
   }

   public void v1(uiSupport35 var1) {
      MsdfFont var2 = this.v1;
      if (var2 != null) {
         uiSupport33.v1();
         var2.v1(var1);
      }
   }

   public boolean v1(float var1, float var2, int var3) {
      MsdfFont var4 = this.v1;
      return var4 != null && var4.v2(var1, var2, var3);
   }

   public boolean v1(float var1, float var2, int var3, float var4, float var5) {
      MsdfFont var6 = this.v1;
      return var6 != null && var6.v1(var1, var2, var3, var4, var5);
   }

   public boolean v2(float var1, float var2, int var3) {
      MsdfFont var4 = this.v1;
      return var4 != null && var4.v4(var1, var2, var3);
   }

   public boolean v1(int var1, int var2) {
      MsdfFont var3 = this.v1;
      return var3 != null && var3.v2(var1, var2);
   }

   public boolean v2(int var1, int var2) {
      MsdfFont var3 = this.v1;
      return var3 != null && var3.v3(var1, var2);
   }

   public hudSupport54 v2(float var1, float var2) {
      return this.v1(var1, var2) ? hudSupport54.IBEAM : hudSupport54.ARROW;
   }

   @Nullable
   public hudSupport54 v4() {
      MsdfFont var1 = this.v1;
      return var1 == null ? null : var1.v31();
   }
}
