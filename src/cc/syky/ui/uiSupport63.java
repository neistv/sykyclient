package cc.syky.ui;

import cc.syky.hud.hudSupport54;
import org.jetbrains.annotations.Nullable;

public final class uiSupport63 extends uiSupport61 {
   private final String v1;
   private final uiSupport64 v2;

   public uiSupport63(String var1, uiSupport64 var2) {
      this.v1 = var1;
      this.v2 = var2;
   }

   @Override
   public String v1() {
      return this.v1;
   }

   @Override
   public float v2() {
      return this.v2.v1() + this.v11();
   }

   @Override
   public float v7() {
      return this.v2.v1();
   }

   @Override
   public float v8() {
      return this.v11();
   }

   private float v18() {
      return this.v3(0.0F, this.v2.v1());
   }

   private float v19() {
      return this.v16() - this.v18();
   }

   private float v17() {
      return this.v19() - 14.0F * this.v9();
   }

   @Override
   public void v2(uiSupport35 var1) {
      this.v1(var1, this.v17(), 1.0F);
      this.v2.v1(var1, this.v19(), this.v18(), this.v10, this.v12, this.v9(), this.v10(), 1.0F);
   }

   @Override
   public boolean v1(float var1, float var2, int var3) {
      if (var3 != 0 || !this.v1(var1, var2)) {
         return false;
      } else if (this.v2(var1, var2, this.v17())) {
         this.v2.v3();
         return true;
      } else if (this.v2.v1(var1, var2, this.v19(), this.v18(), this.v10, this.v12, this.v9(), var3)) {
         return true;
      } else {
         this.v2.v3();
         return false;
      }
   }

   @Override
   public hudSupport54 v2(float var1, float var2) {
      if (!this.v1(var1, var2)) {
         return hudSupport54.ARROW;
      } else {
         return this.v1(var1, var2, this.v17()) ? hudSupport54.POINTER : this.v2.v1(var1, var2, this.v19(), this.v18(), this.v10, this.v12, this.v9());
      }
   }

   @Nullable
   @Override
   public hudSupport54 v31() {
      return this.v2.v4();
   }

   @Override
   public boolean v1(float var1, float var2, int var3, float var4, float var5) {
      return this.v2.v1(var1, var2, var3, var4, var5);
   }

   @Override
   public boolean v4(float var1, float var2, int var3) {
      return this.v2.v1(var1, var2, var3);
   }

   @Override
   public boolean v2(int var1, int var2) {
      return this.v2.v1(var1, var2);
   }

   @Override
   public boolean v3(int var1, int var2) {
      return this.v2.v2(var1, var2);
   }

   @Override
   public boolean v5() {
      return this.v2.v2();
   }

   @Override
   public void v6() {
      this.v2.v3();
   }
}
