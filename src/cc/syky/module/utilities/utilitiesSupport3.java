package cc.syky.module.utilities;

public final class utilitiesSupport3 {
   private boolean v1;
   private boolean v2;
   private boolean v3;

   public utilitiesSupport3() {
   }

   public boolean v1(boolean var1, boolean var2) {
      if (var2) {
         this.v3 = true;
         return false;
      } else if (this.v3) {
         this.v3 = false;
         this.v2 = var1;
         return this.v1;
      } else {
         if (var1 && !this.v2) {
            this.v1 = !this.v1;
         }

         this.v2 = var1;
         return this.v1;
      }
   }

   public void v1() {
      this.v1 = false;
      this.v2 = false;
      this.v3 = false;
   }
}
