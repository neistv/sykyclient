package cc.syky.config;

import cc.syky.cloud.cloudSupport4;
import java.util.List;
import java.util.Optional;
import net.minecraft.class_10691;
import net.minecraft.class_1291;
import net.minecraft.class_1293;
import net.minecraft.class_1657;
import net.minecraft.class_1799;
import net.minecraft.class_1844;
import net.minecraft.class_2561;
import net.minecraft.class_2960;
import net.minecraft.class_5321;
import net.minecraft.class_638;
import net.minecraft.class_6880;
import net.minecraft.class_9334;

public final class configSupport5 {
   private static final double v1 = 6.0;
   private static final int v2 = 24;
   private final configSupport6 v3;
   private final cloudSupport4 v4;

   public configSupport5(configSupport6 var1, cloudSupport4 var2) {
      this.v3 = var1;
      this.v4 = var2;
   }

   public void v1(class_1657 var1, class_638 var2, class_6880<class_1291> var3, int var4, int var5) {
      Optional var6 = var3.method_40230();
      if (!var6.isEmpty()) {
         class_2960 var7 = ((class_5321)var6.get()).method_29177();
         List var8 = var2.method_18467(class_10691.class, var1.method_5829().method_1014(6.0));
         class_10691 var9 = null;
         int var10 = -1;
         double var11 = 0.0;

         for (int var13 = 0; var13 < var8.size(); var13++) {
            class_10691 var14 = (class_10691)var8.get(var13);
            int var15 = v1(var14.method_7495(), var7, var4, var5);
            if (var15 != -1) {
               double var16 = var14.method_5858(var1);
               if (var9 == null || var16 < var11) {
                  var9 = var14;
                  var10 = var15;
                  var11 = var16;
               }
            }
         }

         if (var9 != null) {
            this.v3.v1(var9.method_5628(), v1(var9.method_7495(), var3, var4), this.v4.v1(var7), var10, System.nanoTime());
         }
      }
   }

   private static int v1(class_1799 var0, class_2960 var1, int var2, int var3) {
      class_1844 var4 = (class_1844)var0.method_58695(class_9334.field_49651, class_1844.field_49274);
      float var5 = (Float)var0.method_58695(class_9334.field_55879, 1.0F);

      for (class_1293 var7 : var4.method_57397()) {
         if (var7.method_5578() == var2) {
            Optional var8 = var7.method_5579().method_40230();
            if (!var8.isEmpty() && ((class_5321)var8.get()).method_29177().equals(var1)) {
               return configSupport7.v1(var3, var7.method_5584(), var5);
            }
         }
      }

      return -1;
   }

   private static String v1(class_1799 var0, class_6880<class_1291> var1, int var2) {
      String var3 = configSupport8.v1((class_2561)var0.method_58694(class_9334.field_49631), 24);
      if (var3 == null) {
         var3 = configSupport8.v1((class_2561)var0.method_58694(class_9334.field_50239), 24);
      }

      return var3 != null ? var3 : cloudSupport4.v1(((class_1291)var1.comp_349()).method_5560().getString(), var2);
   }
}
