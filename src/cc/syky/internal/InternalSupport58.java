package cc.syky.internal;

import cc.syky.cloud.cloudSupport92;

public final class InternalSupport58 {
   private static final InternalSupport58 v2 = new InternalSupport58();
   public long v1;

   private InternalSupport58() {
   }

   public static InternalSupport58 v1(cloudSupport92 var0, long var1) {
      v2.v1 = var1;
      var0.v1(v2);
      return v2;
   }
}
