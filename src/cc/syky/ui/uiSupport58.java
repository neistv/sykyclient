package cc.syky.ui;

import cc.syky.hud.hudSupport54;
import org.jetbrains.annotations.Nullable;

public final class uiSupport58 extends uiSupport61 {
   private final String v1;
   private final uiSupport60 v2;

   public uiSupport58(String var1, uiSupport60 var2) {
      this.v1 = var1;
      this.v2 = var2;
   }

   @Override
   public String v1() {
      return this.v1;
   }

   @Override
   public float v2() {
      return this.v2.v3();
   }

   @Override
   public float v7() {
      return this.v2.v1();
   }

   @Override
   public float v14() {
      return this.v2.v2();
   }

   private float v18() {
      return this.v3(this.v2.v2(), this.v2.v1());
   }

   @Override
   public void v2(uiSupport35 var1) {
      this.v2.v1(var1, this.v16(), this.v18(), this.v10, this.v12, this.v9(), this.v10(), 1.0F);
   }

   @Override
   public boolean v1(float var1, float var2, int var3) {
      return var3 == 0 && this.v1(var1, var2) ? this.v2.v2(var1, var2, this.v16(), this.v18(), this.v10, this.v12, this.v9()) : false;
   }

   @Override
   public hudSupport54 v2(float var1, float var2) {
      return this.v1(var1, var2) && this.v2.v1(var1, var2, this.v16(), this.v18(), this.v10, this.v12, this.v9()) != uiSupport59.Part1.NONE
         ? hudSupport54.POINTER
         : hudSupport54.ARROW;
   }

   @Nullable
   @Override
   public hudSupport54 v31() {
      return this.v2.v5() ? hudSupport54.POINTER : null;
   }

   @Override
   public boolean v4(float var1, float var2, int var3) {
      return var3 == 0 && this.v2.v4();
   }

   @Override
   public boolean v1(float var1, float var2, int var3, float var4, float var5) {
      return var3 == 0 && this.v2.v1(var1, this.v16(), this.v18(), this.v9());
   }
}
