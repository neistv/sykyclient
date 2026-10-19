package cc.syky.ui;

import cc.syky.cloud.cloudSupport92;

public final class uiSupport243 {
   private static final uiSupport243 v1 = new uiSupport243();
   private int v2;
   private int v3;

   private uiSupport243() {
   }

   public int v1() {
      return this.v2;
   }

   public int v2() {
      return this.v3;
   }

   public static uiSupport243 v1(cloudSupport92 var0, int var1, int var2) {
      v1.v2 = var1;
      v1.v3 = var2;
      var0.v1(v1);
      return v1;
   }
}
