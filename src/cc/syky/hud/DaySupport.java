package cc.syky.hud;

import cc.syky.cloud.cloudSupport2;
import org.jetbrains.annotations.Nullable;

public final class DaySupport extends CopiedSupport {
   public static final String v2 = "day_counter";
   private static final hudRecord2 v3 = new hudRecord2(22.0F, 22.0F, 8.0F, 7.0F, 36.0F, 8.0F);
   private long v4 = Long.MIN_VALUE;
   @Nullable
   private String v5;

   public DaySupport(hudSupport52 var1, float var2, float var3) {
      super("day_counter", hudSupport49.v6, v3, var1, var2, var3);
   }

   @Nullable
   @Override
   public String v1(cloudSupport2 var1) {
      long var2 = var1.v38();
      if (var2 < 0L) {
         return null;
      } else {
         if (var2 != this.v4) {
            this.v4 = var2;
            this.v5 = "Day " + var2;
         }

         return this.v5;
      }
   }
}
