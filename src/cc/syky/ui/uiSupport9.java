package cc.syky.ui;

import cc.syky.Syky;
import cc.syky.SykyRuntime;
import cc.syky.cloud.cloudSupport94;
import cc.syky.config.AltSupport;
import cc.syky.config.configSupport3;
import cc.syky.config.configSupport4;
import java.util.ArrayList;
import java.util.List;
import net.minecraft.class_156;
import net.minecraft.class_2561;
import net.minecraft.class_304;
import net.minecraft.class_310;
import net.minecraft.class_3675;
import net.minecraft.class_459;
import net.minecraft.class_5250;
import net.minecraft.class_6599;
import net.minecraft.class_3675.class_306;
import net.minecraft.class_459.class_461;
import org.jetbrains.annotations.Nullable;

public final class uiSupport9 {
   private uiSupport9() {
   }

   public static List<class_461> v1(class_459 var0, class_6599 var1, class_310 var2) {
      SykyRuntime var3 = Syky.rootOrNull();
      if (var3 == null) {
         return List.of();
      } else {
         List var4 = configSupport3.v1(var3.v14(), var3.v9(), var3.v10());
         if (var4.isEmpty()) {
            return List.of();
         } else {
            ArrayList var5 = new ArrayList(var4.size() + 1);
            var5.add(new uiSupport8(var0, var2));

            for (configSupport4 var7 : var4) {
               var5.add(new AltSupport(var7, var4, var1, var0, var2));
            }

            return var5;
         }
      }
   }

   public static boolean v1(class_6599 var0, class_459 var1, int var2, int var3) {
      AltSupport var4 = v1(var0, var1);
      if (var4 == null) {
         return false;
      } else {
         var4.v1(var2, var3);
         var1.method_49006();
         var0.field_34800 = class_156.method_658();
         return true;
      }
   }

   public static boolean v2(class_6599 var0, class_459 var1, int var2, int var3) {
      AltSupport var4 = v1(var0, var1);
      if (var4 == null) {
         return false;
      } else {
         var4.v1(cloudSupport94.v1(var2), var3);
         var1.method_49006();
         return true;
      }
   }

   private static int v1(class_306 var0) {
      return switch (var0.method_1442()) {
         case field_1668 -> var0.method_1444();
         case field_1672 -> cloudSupport94.v1(var0.method_1444());
         default -> -1;
      };
   }

   @Nullable
   private static AltSupport v1(class_6599 var0, class_459 var1) {
      if (var0.field_34799 != null) {
         return null;
      } else {
         for (class_461 var3 : var1.method_25396()) {
            if (var3 instanceof AltSupport var4 && var4.v1()) {
               return var4;
            }
         }

         return null;
      }
   }

   @Nullable
   public static class_2561 v1(class_304 var0) {
      SykyRuntime var1 = Syky.rootOrNull();
      if (var1 == null) {
         return null;
      } else {
         class_306 var2 = class_3675.method_15981(var0.method_1428());
         int var3 = v1(var2);
         if (var3 == -1) {
            return null;
         } else {
            List var4 = configSupport3.v1(var1.v14(), var1.v9(), var1.v10(), var3);
            if (var4.isEmpty()) {
               return null;
            } else {
               class_5250 var5 = class_2561.method_43473();

               for (int var6 = 0; var6 < var4.size(); var6++) {
                  if (var6 > 0) {
                     var5.method_27693(", ");
                  }

                  var5.method_27693((String)var4.get(var6));
               }

               return var5;
            }
         }
      }
   }
}
