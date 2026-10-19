package cc.syky.hud;

import cc.syky.cloud.cloudSupport101;
import cc.syky.cloud.cloudSupport2;
import net.minecraft.class_310;
import org.jetbrains.annotations.Nullable;

public final class TPSSupport extends CopiedSupport {
   public static final String v2 = "tps";
   private static final hudRecord2 v3 = new hudRecord2(18.0F, 20.0F, 11.0F, 8.0F, 40.0F, 8.0F);
   private static final String v4 = "— TPS";
   private final cloudSupport101 v5;
   private long v6 = Long.MIN_VALUE;
   @Nullable
   private String v7;

   public TPSSupport(cloudSupport101 var1, hudSupport52 var2, float var3, float var4) {
      super("tps", hudSupport49.v12, v3, var2, var3, var4);
      this.v5 = var1;
   }

   @Nullable
   @Override
   public String v1(cloudSupport2 var1) {
      class_310 var2 = this.v5.v1();
      if (var2 == null || var2.field_1724 == null) {
         return null;
      } else if (!var1.v17()) {
         return "— TPS";
      } else {
         double var3 = var1.v19();
         long var5 = Math.round(var3 * 10.0);
         if (var5 != this.v6 || this.v7 == null) {
            this.v6 = var5;
            this.v7 = hudSupport43.v1(var3) + " TPS";
         }

         return this.v7;
      }
   }
}
