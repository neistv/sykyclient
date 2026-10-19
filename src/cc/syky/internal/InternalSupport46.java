package cc.syky.internal;

import cc.syky.cloud.cloudSupport101;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;
import net.minecraft.class_2338;
import net.minecraft.class_243;
import net.minecraft.class_2478;
import net.minecraft.class_2561;
import net.minecraft.class_2625;
import net.minecraft.class_2680;
import net.minecraft.class_2693;
import net.minecraft.class_2877;
import net.minecraft.class_310;
import net.minecraft.class_634;
import net.minecraft.class_638;
import net.minecraft.class_746;
import net.minecraft.class_8242;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

public final class InternalSupport46 {
   private static final double v1 = 3.5;
   private static final long v2 = 200L;
   private static final long v3 = 1500L;
   private final cloudSupport101 v4;
   private final InternalSupport57 v5;
   private final InternalSupport56 v6;

   public InternalSupport46(cloudSupport101 var1, InternalSupport57 var2, InternalSupport56 var3) {
      this.v4 = var1;
      this.v5 = var2;
      this.v6 = var3;
   }

   public void v1(class_634 var1, class_2693 var2, CallbackInfo var3) {
      class_2338 var4 = var2.method_11677();
      class_310 var5 = this.v4.v1();
      if (v1(var5, var4)) {
         if (v2(var5, var4)) {
            this.v1(var1, var4, var2.method_49995());
         }

         var3.cancel();
      }
   }

   private static boolean v2(class_310 var0, class_2338 var1) {
      if (var0 != null && var1 != null) {
         class_638 var2 = var0.field_1687;
         return var2 != null && var2.method_8321(var1) instanceof class_2625;
      } else {
         return false;
      }
   }

   public static boolean v1(class_310 var0, class_2338 var1) {
      if (var0 != null && var1 != null) {
         class_638 var2 = var0.field_1687;
         class_746 var3 = var0.field_1724;
         if (var2 != null && var3 != null) {
            if (!var2.method_8393(var1.method_10263() >> 4, var1.method_10260() >> 4)) {
               return true;
            } else {
               class_2680 var4 = var2.method_8320(var1);
               if (!(var4.method_26204() instanceof class_2478)) {
                  return true;
               } else {
                  class_243 var5 = var3.method_33571();
                  double var6 = var1.method_10263() + 0.5 - var5.field_1352;
                  double var8 = var1.method_10264() + 0.5 - var5.field_1351;
                  double var10 = var1.method_10260() + 0.5 - var5.field_1350;
                  double var12 = var3.method_55754() + 3.5;
                  return var6 * var6 + var8 * var8 + var10 * var10 > var12 * var12;
               }
            }
         } else {
            return true;
         }
      } else {
         return true;
      }
   }

   private void v1(class_634 var1, class_2338 var2, boolean var3) {
      long var4 = 200L + ThreadLocalRandom.current().nextLong(1300L);
      this.v5.v1(() -> this.v6.v1(() -> this.v2(var1, var2, var3)), var4, TimeUnit.MILLISECONDS);
   }

   private void v2(class_634 var1, class_2338 var2, boolean var3) {
      class_310 var4 = this.v4.v1();
      if (var4 != null && var4.method_1562() == var1) {
         String[] var5 = v1(var4, var2, var3);
         var1.method_52787(new class_2877(var2, var3, var5[0], var5[1], var5[2], var5[3]));
      }
   }

   private static String[] v1(class_310 var0, class_2338 var1, boolean var2) {
      String[] var3 = new String[]{"", "", "", ""};
      class_638 var4 = var0.field_1687;
      if (var4 == null) {
         return var3;
      } else if (!(var4.method_8321(var1) instanceof class_2625 var6)) {
         return var3;
      } else {
         class_8242 var7 = var2 ? var6.method_49853() : var6.method_49854();
         class_2561[] var8 = var7.method_49877(false);

         for (int var9 = 0; var9 < 4 && var9 < var8.length; var9++) {
            if (var8[var9] != null) {
               var3[var9] = var8[var9].getString();
            }
         }

         return var3;
      }
   }
}
