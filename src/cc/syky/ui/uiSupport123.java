package cc.syky.ui;

import cc.syky.hud.hudSupport54;
import cc.syky.hud.hudSupport57;
import cc.syky.hud.hudSupport60;
import java.util.function.IntSupplier;
import org.jetbrains.annotations.Nullable;

public final class uiSupport123 extends uiSupport45 {
   private final uiSupport123.Part1 v1;
   private final hudSupport57 v2 = new hudSupport57(0.0F, 90.0F);
   private String v3 = "";
   @Nullable
   private String v4;
   private boolean v5;
   private Runnable v6 = () -> {};

   public uiSupport123(float var1, uiSupport123.Part1 var2) {
      super(var1);
      this.v1 = var2;
   }

   public void v1(String var1, boolean var2, Runnable var3) {
      this.v1(var1, null, var2, var3);
   }

   public void v1(String var1, @Nullable String var2, boolean var3, Runnable var4) {
      this.v3 = var1;
      this.v4 = var2;
      this.v5 = var3;
      this.v6 = var4;
   }

   public float v1() {
      return Math.max(v1(this.v3), this.v4 == null ? 0.0F : v1(this.v4));
   }

   public static float v1(String var0) {
      return uiSupport169.v2("syky_sans", var0, 16.0F) + 40.0F;
   }

   @Override
   public float v2() {
      return this.v1.corner;
   }

   @Override
   public int v3() {
      return this.v5 ? SignInSupport.v25() : super.v3();
   }

   @Override
   public float v2(uiSupport35 var1) {
      this.v2.v2(this.v4(var1) ? 1.0F : 0.0F);
      return hudSupport60.v1(this.v2.v2());
   }

   @Override
   public void v3(uiSupport35 var1) {
      float var2 = hudSupport60.v1(this.v2.v2());
      String var3 = this.v4 != null && this.v4(var1) ? this.v4 : this.v3;
      float var4 = this.v1.fontPx * this.v13();
      float var5 = uiSupport169.v2(this.v1.font, var3, var4);
      int var6 = this.v1 == uiSupport123.Part1.PAGE ? this.v1.ink.getAsInt() : uiSupport155.v1(this.v1.ink.getAsInt(), SignInSupport.v22(), var2);
      uiSupport169.v1(this.v1.font, var3, this.v9 + (this.v11 - var5) / 2.0F, uiSupport169.v1(this.v10 + this.v12 / 2.0F, var4), var4, var6);
   }

   @Override
   public boolean v1(float var1, float var2, int var3) {
      if (var3 == 0 && this.v1(var1, var2)) {
         this.v3(var1, var2);
         return true;
      } else {
         return false;
      }
   }

   @Override
   public void v3(float var1, float var2) {
      this.v6.run();
   }

   @Override
   public hudSupport54 v2(float var1, float var2) {
      return this.v1(var1, var2) ? hudSupport54.POINTER : hudSupport54.ARROW;
   }

   public static enum Part1 {
      PAGE(18.0F, 18.0F, "syky_sans_strong", SignInSupport::v22),
      ACTION(12.0F, 16.0F, "syky_sans", SignInSupport::v21);

      public final float corner;
      public final float fontPx;
      public final String font;
      public final IntSupplier ink;

      private Part1(float var3, float var4, String var5, IntSupplier var6) {
         this.corner = var3;
         this.fontPx = var4;
         this.font = var5;
         this.ink = var6;
      }
   }
}
