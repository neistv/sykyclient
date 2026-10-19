package cc.syky.ui;

public final class uiSupport74 implements uiSupport81 {
   private final uiSupport109[] v1;

   public uiSupport74(int var1) {
      this.v1 = new uiSupport109[var1];
   }

   @Override
   public float v1() {
      return 44.0F;
   }

   @Override
   public boolean v2() {
      return false;
   }

   @Override
   public float v1(int var1, boolean var2, boolean var3) {
      uiSupport109 var4 = this.v1(var1, var2);
      var4.v1(var2);
      return var4.v1();
   }

   @Override
   public void v1(int var1, float var2, float var3, float var4, float var5) {
      uiSupport109 var6 = this.v1[var1];
      if (var6 != null) {
         float var7 = SignInSupport.v4(21.0F, var5);
         float var8 = var2 + SignInSupport.v4(10.0F, var5);
         float var9 = var3 + uiSupport169.v1((var4 - var7) * 0.5F);
         var6.v1(var8, var9, var5, 1.0F);
      }
   }

   private uiSupport109 v1(int var1, boolean var2) {
      uiSupport109 var3 = this.v1[var1];
      if (var3 == null) {
         var3 = new uiSupport109(var2);
         this.v1[var1] = var3;
      }

      return var3;
   }
}
