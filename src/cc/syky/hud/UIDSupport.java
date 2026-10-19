package cc.syky.hud;

import cc.syky.cloud.SykySession;
import cc.syky.cloud.cloudSupport2;
import java.util.Objects;
import org.jetbrains.annotations.Nullable;

public final class UIDSupport extends CopiedSupport {
   public static final String v2 = "uid";
   private static final hudRecord2 v3 = new hudRecord2(24.0F, 24.0F, 8.0F, 6.0F, 42.0F, 8.0F);
   @Nullable
   private SykySession.Part1 v4;
   @Nullable
   private String v5;

   public UIDSupport(hudSupport52 var1, float var2, float var3) {
      super("uid", hudSupport49.v8, v3, var1, var2, var3);
   }

   @Nullable
   @Override
   public String v1(cloudSupport2 var1) {
      SykySession.Part1 var2 = SykySession.v1();
      if (!Objects.equals(var2, this.v4)) {
         this.v4 = var2;
         this.v5 = var2 == null ? null : var2.v1() + " UID";
      }

      return this.v5;
   }
}
