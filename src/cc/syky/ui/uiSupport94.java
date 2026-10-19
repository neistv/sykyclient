package cc.syky.ui;

import cc.syky.hud.hudSupport57;
import cc.syky.hud.hudSupport60;

public final class uiSupport94 {
   public static final float v1 = 15.0F;
   public static final float v2 = 24.0F;
   public static final float v3 = 0.7F;
   public static final float v4 = 90.0F;
   private static final float v5 = 150.0F;
   private static final float v6 = 12.0F;
   private static final float v7 = 66.0F;
   private static final float v8 = 17.0F;
   private static final float v9 = 20.0F;
   private static final String v10 = "syky_sans_strong";
   private final String[] v11;
   private final float v12;
   private final hudSupport57[] v13;
   private final hudSupport57[] v14;

   public uiSupport94(String[] var1, int var2) {
      this.v11 = var1;
      float var3 = 0.0F;

      for (String var7 : var1) {
         var3 = Math.max(var3, uiSupport169.v2("syky_sans_strong", var7, 15.0F));
      }

      this.v12 = Math.max(66.0F, (float)Math.ceil(var3 + 24.0F));
      this.v13 = new hudSupport57[var1.length];
      this.v14 = new hudSupport57[var1.length];

      for (int var8 = 0; var8 < var1.length; var8++) {
         float var9 = var8 == var2 ? 1.0F : 0.0F;
         this.v13[var8] = new hudSupport57(var9, 90.0F);
         this.v14[var8] = new hudSupport57(var9, 150.0F);
      }
   }

   public float v1() {
      return this.v12 * this.v11.length + 17.0F * (this.v11.length - 1);
   }

   private float v1(float var1, float var2, int var3) {
      return var1 + var3 * (this.v12 + 17.0F) * var2;
   }

   public int v1(float var1, float var2, float var3, float var4, float var5) {
      float var6 = this.v1() * var3;
      return !(var4 < var1) && !(var4 >= var1 + var6) && !(var5 < var2) && !(var5 >= var2 + 24.0F * var3)
         ? Math.min((int)((var4 - var1) / (var6 / this.v11.length)), this.v11.length - 1)
         : -1;
   }

   public void v1(uiSupport35 var1, float var2, float var3, float var4, int var5, uiRecord7 var6) {
      float var7 = 24.0F * var4;
      int var8 = var1.v2() ? this.v1(var2, var3, var4, var1.v1, var1.v2) : -1;
      float var9 = this.v12 * var4;
      float var10 = 15.0F * var4;
      float var11 = uiSupport169.v1(var3 + var7 / 2.0F, var10);
      float var12 = SignInSupport.v2(var4);
      float var13 = 20.0F * var4;

      for (int var14 = 0; var14 < this.v11.length - 1; var14++) {
         uiSupport169.v1(
            this.v1(var2, var4, var14) + var9 + (17.0F * var4 - var12) / 2.0F,
            var3 + (var7 - var13) / 2.0F,
            var12,
            var13,
            SignInSupport.v1(SignInSupport.v101(), var4),
            SignInSupport.v3(var12)
         );
      }

      for (int var17 = 0; var17 < this.v11.length; var17++) {
         this.v14[var17].v2(var17 == var5 ? 1.0F : 0.0F);
         float var15 = this.v14[var17].v2();
         this.v13[var17].v2(var17 == var5 ? 1.0F : (var8 == var17 ? 0.7F : 0.0F));
         float var16 = hudSupport60.v1(this.v13[var17].v2());
         if (var16 > 0.0F) {
            uiSupport169.v1(
               this.v1(var2, var4, var17),
               var3,
               var9,
               var7,
               uiSupport155.v1(uiSupport155.v1(SignInSupport.v141(), SignInSupport.v104(), var15), var16),
               uiSupport155.v1(SignInSupport.v1(uiSupport155.v1(SignInSupport.v145(), SignInSupport.v125(), var15), var4), var16),
               SignInSupport.v2(var4),
               1.0F,
               var6
            );
         }
      }

      for (int var18 = 0; var18 < this.v11.length; var18++) {
         uiSupport169.v3(
            "syky_sans_strong",
            this.v11[var18],
            this.v1(var2, var4, var18) + var9 / 2.0F,
            var11,
            var10,
            uiSupport155.v1(SignInSupport.v40(), SignInSupport.v85(), this.v14[var18].v2())
         );
      }
   }
}
