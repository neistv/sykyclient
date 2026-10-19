package cc.syky.ui;

import cc.syky.cloud.ReplyToSupport;
import cc.syky.cloud.cloudSupport19;
import cc.syky.hud.hudSupport57;
import cc.syky.hud.hudSupport60;

public final class UndoSupport {
   private static final float v1 = 46.0F;
   private static final float v2 = 14.0F;
   private static final float v3 = 24.0F;
   private static final float v4 = 2.2F;
   private static final float v5 = 11.0F;
   private static final float v6 = 12.0F;
   private static final float v7 = 15.0F;
   private static final int v8 = 48;
   private final hudSupport57 v9 = new hudSupport57(0.0F, 150.0F);
   private float v10;
   private float v11;
   private float v12;
   private float v13;

   public UndoSupport() {
   }

   public void v1(boolean var1) {
      this.v9.v2(var1 ? 1.0F : 0.0F);
   }

   public boolean v1() {
      return this.v9.v2() > 0.01F;
   }

   public void v1(String var1, long var2, long var4, float var6, float var7, float var8, float var9) {
      float var10 = hudSupport60.v1(this.v9.v2());
      if (!(var10 <= 0.0F)) {
         float var11 = 15.0F * var9;
         float var12 = uiSupport169.v2("syky_sans", var1, var11);
         float var13 = uiSupport169.v2("syky_sans_strong", "Undo", var11);
         this.v13 = SignInSupport.v4(46.0F, var9);
         this.v12 = uiSupport169.v1(50.0F * var9 + var12 + 24.0F * var9 + var13 + 14.0F * var9);
         this.v10 = var6 + uiSupport169.v1((var7 - this.v12) / 2.0F);
         this.v11 = uiSupport169.v1(var8 - this.v13);
         boolean var14 = var10 < 1.0F && uiSupport169.v5();

         try {
            uiRecord7 var15 = uiRecord7.v1(this.v13 / 2.0F);
            ReplyToSupport.v1(this.v10, this.v11, this.v12, this.v13, var15, var9);
            float var16 = 24.0F * var9;
            float var17 = this.v10 + 26.0F * var9;
            float var18 = this.v11 + this.v13 / 2.0F;
            float var19 = (var16 - 2.2F * var9) / 2.0F;
            float var20 = 2.2F * var9;
            float var21 = var4 <= 0L ? 0.0F : Math.max(0.0F, Math.min(1.0F, (float)var2 / (float)var4));
            uiSupport169.v1(
               var17 - var19 - var20 / 2.0F,
               var18 - var19 - var20 / 2.0F,
               2.0F * var19 + var20,
               2.0F * var19 + var20,
               uiSupport155.v1(cloudSupport19.v4(), 0.2F),
               var20,
               uiRecord7.v1(var19 + var20 / 2.0F),
               1.0F
            );
            v1(var17, var18, var19, var21, var20, cloudSupport19.v4());
            String var22 = Long.toString((var2 + 999L) / 1000L);
            float var23 = 11.0F * var9;
            float var24 = uiSupport169.v2("syky_sans_strong", var22, var23);
            uiSupport169.v1("syky_sans_strong", var22, var17 - var24 / 2.0F, uiSupport169.v1(var18, var23), var23, cloudSupport19.v8());
            float var25 = this.v10 + 50.0F * var9;
            uiSupport169.v1("syky_sans", var1, var25, uiSupport169.v1(var18, var11), var11, cloudSupport19.v8());
            uiSupport169.v1("syky_sans_strong", "Undo", var25 + var12 + 24.0F * var9, uiSupport169.v1(var18, var11), var11, cloudSupport19.v4());
         } finally {
            if (var14) {
               uiSupport169.v2(var10);
            }
         }
      }
   }

   public boolean v1(float var1, float var2) {
      return this.v1() && this.v9.v2() > 0.5F && var1 >= this.v10 && var1 <= this.v10 + this.v12 && var2 >= this.v11 && var2 <= this.v11 + this.v13;
   }

   private static void v1(float var0, float var1, float var2, float var3, float var4, int var5) {
      int var6 = Math.max(1, Math.round(48.0F * var3));
      if (!(var3 <= 0.0F)) {
         double var7 = -Math.PI / 2;
         double var9 = (Math.PI * 2) * var3;
         float var11 = var0 + var2 * (float)Math.cos(var7);
         float var12 = var1 + var2 * (float)Math.sin(var7);

         for (int var13 = 1; var13 <= var6; var13++) {
            double var14 = var7 + var9 * var13 / var6;
            float var16 = var0 + var2 * (float)Math.cos(var14);
            float var17 = var1 + var2 * (float)Math.sin(var14);
            uiSupport169.v3(var11, var12, var16, var17, var5, var4);
            var11 = var16;
            var12 = var17;
         }
      }
   }
}
