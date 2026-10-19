package cc.syky.internal;

import cc.syky.cloud.cloudSupport92;

public final class InternalSupport59 {
   private static final InternalSupport59 v4 = new InternalSupport59();
   public int v1;
   public int v2;
   public int v3;

   private InternalSupport59() {
   }

   public static InternalSupport59 v1(cloudSupport92 var0, int var1, int var2, int var3) {
      v4.v1 = var1;
      v4.v2 = var2;
      v4.v3 = var3;
      var0.v1(v4);
      return v4;
   }
}
