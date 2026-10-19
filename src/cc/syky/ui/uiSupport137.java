package cc.syky.ui;

import cc.syky.hud.hudSupport60;
import cc.syky.module.visual.visualSupport2;
import org.jetbrains.annotations.Nullable;

public final class uiSupport137 {
   @Nullable
   private visualSupport2 v1;
   private float v2;
   private float v3;
   private float v4;
   private float v5;
   private float v6;
   private float v7;

   public uiSupport137() {
   }

   public uiSupport137.Part1 v1(float var1, float var2, float var3, float var4, float var5, float var6, float var7, float var8, float var9, float var10) {
      uiRecord6 var11 = v1(var3, var4, var5, var6, var7, var8);
      float var12 = v1(var1, var3, var6);
      float var13 = v2(var2, var4, var7);
      float var14 = var11.v1(var12, var6 <= 0.0F ? 0.0F : var9 / var6) - var12;
      float var15 = var11.v2(var13, var7 <= 0.0F ? 0.0F : var10 / var7) - var13;
      return new uiSupport137.Part1(var14 * var6, var15 * var7);
   }

   public void v1(float var1, float var2, float var3, float var4, float var5, float var6, float var7, float var8) {
      uiRecord6 var9 = v1(var3, var4, var5, var6, var7, var8);
      float var10 = v1(var1, var3, var6);
      float var11 = v2(var2, var4, var7);
      float var12 = var9.v1(var10);
      float var13 = var9.v2(var11);
      if (var12 == var10 && var13 == var11) {
         this.v1 = null;
      } else {
         this.v2 = var1;
         this.v3 = var2;
         this.v4 = v3(var12, var3, var6);
         this.v5 = v4(var13, var4, var7);
         this.v6 = var1;
         this.v7 = var2;
         this.v1 = new visualSupport2(380L, hudSupport60::v3);
      }
   }

   public boolean v1() {
      visualSupport2 var1 = this.v1;
      if (var1 == null) {
         return false;
      } else {
         float var2 = var1.v1();
         this.v6 = this.v2 + (this.v4 - this.v2) * var2;
         this.v7 = this.v3 + (this.v5 - this.v3) * var2;
         if (var1.v2()) {
            this.v6 = this.v4;
            this.v7 = this.v5;
            this.v1 = null;
         }

         return true;
      }
   }

   public boolean v2() {
      return this.v1 != null;
   }

   public float v3() {
      return this.v6;
   }

   public float v4() {
      return this.v7;
   }

   public float v5() {
      return this.v1 == null ? 0.0F : this.v6 - this.v4;
   }

   public float v6() {
      return this.v1 == null ? 0.0F : this.v7 - this.v5;
   }

   public void v7() {
      this.v1 = null;
   }

   private static uiRecord6 v1(float var0, float var1, float var2, float var3, float var4, float var5) {
      return uiRecord6.v1(var3, var4, var0, var1, var2, 120.0F * var5, 160.0F * var5);
   }

   private static float v1(float var0, float var1, float var2) {
      return var2 <= 0.0F ? 0.5F : (var0 + var1 / 2.0F) / var2;
   }

   private static float v2(float var0, float var1, float var2) {
      return var2 <= 0.0F ? 0.5F : (var0 + var1 / 2.0F) / var2;
   }

   private static float v3(float var0, float var1, float var2) {
      return var0 * var2 - var1 / 2.0F;
   }

   private static float v4(float var0, float var1, float var2) {
      return var0 * var2 - var1 / 2.0F;
   }

   public record Part1(float dx, float dy) {
      public float v1() {
         return this.dx;
      }

      public float v2() {
         return this.dy;
      }
   }
}
