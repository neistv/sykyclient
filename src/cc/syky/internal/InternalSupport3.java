package cc.syky.internal;

import cc.syky.sykyRecord3;
import cc.syky.cloud.cloudSupport61;
import org.jetbrains.annotations.Nullable;

public final class InternalSupport3 {
   private static final String v1 = "cc/syky/whatsnew/changelog.json";
   private static final long v2 = 524288L;

   private InternalSupport3() {
   }

   @Nullable
   public static sykyRecord3 v1() {
      String var0 = cloudSupport61.v1("cc/syky/whatsnew/changelog.json", 524288L);
      return var0 == null ? null : sykyRecord3.v1(var0);
   }
}
