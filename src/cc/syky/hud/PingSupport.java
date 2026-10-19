package cc.syky.hud;

import cc.syky.cloud.cloudSupport101;
import cc.syky.cloud.cloudSupport2;
import net.minecraft.class_310;
import org.jetbrains.annotations.Nullable;

public final class PingSupport extends CopiedSupport {
   public static final String v2 = "ping";
   private static final hudRecord2 v3 = new hudRecord2(24.0F, 19.0F, 11.0F, 6.0F, 41.0F, 8.0F);
   private static final String v4 = "— Ping";
   private final cloudSupport101 v5;
   private int v6 = Integer.MIN_VALUE;
   @Nullable
   private String v7;

   public PingSupport(cloudSupport101 var1, hudSupport52 var2, float var3, float var4) {
      super("ping", hudSupport49.v3, v3, var2, var3, var4);
      this.v5 = var1;
   }

   @Nullable
   @Override
   public String v1(cloudSupport2 var1) {
      class_310 var2 = this.v5.v1();
      if (var2 != null && var2.field_1724 != null) {
         var1.v11();
         if (!var1.v10()) {
            return "— Ping";
         } else {
            int var3 = var1.v9();
            if (var3 != this.v6 || this.v7 == null) {
               this.v6 = var3;
               this.v7 = var3 + " Ping";
            }

            return this.v7;
         }
      } else {
         return null;
      }
   }
}
