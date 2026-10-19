package cc.syky.cloud;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import net.minecraft.class_2561;
import net.minecraft.class_310;
import net.minecraft.class_327;
import net.minecraft.class_345;
import net.minecraft.class_5250;
import net.minecraft.class_1259.class_1260;
import net.minecraft.class_1259.class_1261;

public final class BossBarSupport {
   private static final String v1 = "Boss Bar";
   private static final float v2 = 0.65F;
   private static final UUID v3 = new UUID(0L, 0L);

   private BossBarSupport() {
   }

   public static cloudRecord3 v1(class_310 var0) {
      if (var0 != null && var0.field_1705 != null) {
         Map var1 = var0.field_1705.method_1740().field_2060;
         if (var1.isEmpty()) {
            return cloudRecord3.EMPTY;
         } else {
            class_327 var2 = var0.field_1772;
            int var3 = cloudSupport13.v5(var0.method_22683().method_4502());
            ArrayList var4 = new ArrayList(Math.min(var1.size(), var3));

            for (class_345 var6 : var1.values()) {
               if (var4.size() >= var3) {
                  break;
               }

               class_2561 var7 = var6.method_5414();
               var4.add(new cloudRecord3.Part1(var6, var7, var2.method_27525(var7)));
            }

            return new cloudRecord3(List.copyOf(var4));
         }
      } else {
         return cloudRecord3.EMPTY;
      }
   }

   public static cloudRecord3 v1(class_327 var0) {
      class_5250 var1 = class_2561.method_43470("Boss Bar");
      class_345 var2 = new class_345(v3, var1, 0.65F, class_1260.field_5783, class_1261.field_5795, false, false, false);
      return new cloudRecord3(List.of(new cloudRecord3.Part1(var2, var1, var0.method_27525(var1))));
   }
}
