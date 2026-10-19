package cc.syky.ui;

public final class uiSupport50 {
   private final uiSupport38 v1 = new uiSupport38();
   private boolean v2;

   public uiSupport50() {
   }

   public int v1(int var1, boolean var2) {
      if (!var2 && !this.v2) {
         this.v1.v1(var1);
         return var1;
      } else {
         this.v2 = true;
         int var3 = var2 ? SignInSupport.v13() : var1;
         int var4 = this.v1.v1(var3, 150.0F);
         if (!var2 && this.v1.v2(var3)) {
            this.v2 = false;
         }

         return var4;
      }
   }
}
