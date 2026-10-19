package cc.syky.ui;

import cc.syky.hud.hudSupport54;
import org.jetbrains.annotations.Nullable;

public abstract class UiNode {
   public float v9;
   public float v10;
   public float v11;
   public float v12;

   public UiNode() {
   }

   public UiNode v1(float var1, float var2, float var3, float var4) {
      this.v9 = var1;
      this.v10 = var2;
      this.v11 = var3;
      this.v12 = var4;
      return this;
   }

   public boolean v1(float var1, float var2) {
      return var1 >= this.v9 && var2 >= this.v10 && var1 < this.v9 + this.v11 && var2 < this.v10 + this.v12;
   }

   public boolean v4(uiSupport35 var1) {
      return this.v1(var1.v1, var1.v2);
   }

   public void v1(int var1, int var2) {
   }

   public void v5(uiSupport35 var1) {
   }

   public abstract void v1(uiSupport35 var1);

   public final void v3(uiSupport35 var1, float var2) {
      if (!(var2 >= 1.0F) && uiSupport169.v5()) {
         try {
            this.v1(var1);
         } finally {
            uiSupport169.v2(var2);
         }
      } else {
         this.v1(var1);
      }
   }

   public boolean v1(float var1, float var2, int var3) {
      return false;
   }

   public boolean v4(float var1, float var2, int var3) {
      return false;
   }

   public boolean v1(float var1, float var2, int var3, float var4, float var5) {
      return false;
   }

   public void v11(float var1, float var2) {
   }

   public hudSupport54 v2(float var1, float var2) {
      return hudSupport54.ARROW;
   }

   @Nullable
   public hudSupport54 v31() {
      return null;
   }

   public boolean v1(float var1, float var2, double var3, double var5) {
      return false;
   }

   public boolean v2(int var1, int var2) {
      return false;
   }

   public boolean v4(int var1, int var2) {
      return false;
   }

   public boolean v3(int var1, int var2) {
      return false;
   }
}
