package cc.syky.hud;

import cc.syky.cloud.cloudSupport101;
import cc.syky.cloud.cloudSupport2;
import net.minecraft.class_310;
import org.jetbrains.annotations.Nullable;

public final class BPSSupport extends CopiedSupport {
   public static final String v2 = "bps";
   private static final hudRecord2 v3 = new hudRecord2(27.0F, 27.0F, 7.0F, 4.0F, 42.0F, 8.0F);
   private final cloudSupport101 v4;
   private long v5 = Long.MIN_VALUE;
   @Nullable
   private String v6;

   public BPSSupport(cloudSupport101 var1, hudSupport52 var2, float var3, float var4) {
      super("bps", hudSupport49.v13, v3, var2, var3, var4);
      this.v4 = var1;
   }

   @Nullable
   @Override
   public String v1(cloudSupport2 var1) {
      class_310 var2 = this.v4.v1();
      if (var2 != null && var2.field_1724 != null) {
         double var3 = var1.v8();
         long var5 = Math.round(var3 * 10.0);
         if (var5 != this.v5 || this.v6 == null) {
            this.v5 = var5;
            this.v6 = hudSupport43.v1(var3) + " BPS";
         }

         return this.v6;
      } else {
         return null;
      }
   }
}
