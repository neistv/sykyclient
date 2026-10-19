package cc.syky.ui;

import cc.syky.cloud.cloudSupport92;

public final class uiSupport242 {
   private static final uiSupport242 v4 = new uiSupport242();
   public int v1;
   public int v2;
   public int v3;

   private uiSupport242() {
   }

   public static uiSupport242 v1(cloudSupport92 var0, int var1, int var2, int var3) {
      v4.v1 = var1;
      v4.v2 = var2;
      v4.v3 = var3;
      var0.v1(v4);
      return v4;
   }
}
