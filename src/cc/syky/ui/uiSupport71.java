package cc.syky.ui;

import cc.syky.hud.hudSupport57;

public final class uiSupport71 implements uiSupport81 {
   private static final float v1 = 0.002F;
   private final hudSupport57[] v2;
   private final boolean[] v3;

   public uiSupport71(int var1) {
      this.v2 = new hudSupport57[var1];
      this.v3 = new boolean[var1];
   }

   @Override
   public float v1() {
      return 36.0F;
   }

   @Override
   public boolean v2() {
      return true;
   }

   @Override
   public float v1(int var1, boolean var2, boolean var3) {
      hudSupport57 var4 = this.v1(var1, var2);
      float var5 = SignInSupport.v1(var4.v2());
      if (var5 <= 0.002F) {
         this.v3[var1] = !var3;
      }

      var4.v2(var2 ? 1.0F : 0.0F);
      return var5;
   }

   @Override
   public void v1(int var1, float var2, float var3, float var4, float var5) {
      hudSupport57 var6 = this.v2[var1];
      if (var6 != null) {
         float var7 = SignInSupport.v1(var6.v2());
         if (!(var7 <= 0.002F)) {
            uiSupport132.Part1 var8 = this.v3[var1] ? uiSupport132.v4 : uiSupport132.v3;
            float var9 = 16.0F * var5;
            float var10 = 11.5556F * var5;
            float var11 = var2 + SignInSupport.v4(10.0F, var5);
            float var12 = var3 + uiSupport169.v1(15.67F * var5);
            boolean var13 = uiSupport132.v1(var8, var7, var11, var12, var9, var10, var5);

            try {
               uiSupport72.v1(var11, var12, var9, var10, var13 ? 1.0F : var7);
            } finally {
               if (var13) {
                  uiSupport132.v2(var8, var7, var11, var12, var9, var10, var5);
               }
            }
         }
      }
   }

   private hudSupport57 v1(int var1, boolean var2) {
      hudSupport57 var3 = this.v2[var1];
      if (var3 == null) {
         var3 = new hudSupport57(var2 ? 1.0F : 0.0F, 150.0F);
         this.v2[var1] = var3;
      }

      return var3;
   }
}
