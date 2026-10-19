package cc.syky.cloud;

import cc.syky.ui.uiSupport169;

public final class cloudSupport11 {
   private String v1 = "";
   private float v2;
   private float v3;

   public cloudSupport11() {
   }

   public float v1(String var1, float var2) {
      if (var2 == this.v2 && this.v3 > 0.0F && var1.equals(this.v1)) {
         return this.v3;
      } else {
         this.v3 = uiSupport169.v2("syky_sans_strong", var1, var2);
         this.v1 = var1;
         this.v2 = var2;
         return this.v3;
      }
   }
}
