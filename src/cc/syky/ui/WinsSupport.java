package cc.syky.ui;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import net.minecraft.class_124;
import net.minecraft.class_2561;
import net.minecraft.class_266;
import net.minecraft.class_268;
import net.minecraft.class_269;
import net.minecraft.class_310;
import net.minecraft.class_327;
import net.minecraft.class_5250;
import net.minecraft.class_8646;
import net.minecraft.class_9011;
import net.minecraft.class_9022;
import net.minecraft.class_9025;

public final class WinsSupport {
   private static final Comparator<class_9011> v1 = Comparator.comparing(class_9011::comp_2128)
      .reversed()
      .thenComparing(class_9011::comp_2127, String.CASE_INSENSITIVE_ORDER);
   private static final int v2 = 15;
   private static final String v3 = "Scoreboard";
   private static final String[][] v4 = new String[][]{{"Kills", "128"}, {"Deaths", "37"}, {"K/D", "3.46"}, {"Wins", "42"}};

   private WinsSupport() {
   }

   public static uiRecord2 v1(class_310 var0) {
      if (var0 != null && var0.field_1687 != null && var0.field_1724 != null) {
         class_269 var1 = var0.field_1687.method_8428();
         class_266 var2 = v1(var1, var0);
         if (var2 == null) {
            return uiRecord2.EMPTY;
         } else {
            class_327 var3 = var0.field_1772;
            class_9022 var4 = var2.method_55380(class_9025.field_47567);
            String var5 = uiSupport223.v2 ? uiSupport223.v2() : null;
            List var6 = var1.method_1184(var2).stream().filter(var0x -> !var0x.method_55385()).sorted(v1).limit(15L).toList();
            ArrayList var7 = new ArrayList(var6.size());

            for (class_9011 var9 : var6) {
               class_268 var10 = var1.method_1164(var9.comp_2127());
               Object var11 = class_268.method_1142(var10, var9.method_55387());
               if (var5 != null) {
                  var11 = uiSupport221.v1((class_2561)var11, var5);
               }

               class_5250 var12 = var9.method_55386(var4);
               var7.add(new uiRecord2.Part1((class_2561)var11, var12, var3.method_27525(var12)));
            }

            class_2561 var13 = var2.method_1114();
            if (var5 != null) {
               var13 = uiSupport221.v1(var13, var5);
            }

            return v1(var3, var13, var7);
         }
      } else {
         return uiRecord2.EMPTY;
      }
   }

   public static uiRecord2 v1(class_327 var0) {
      ArrayList var1 = new ArrayList(v4.length);

      for (String[] var5 : v4) {
         class_5250 var6 = class_2561.method_43470(var5[1]).method_27692(class_124.field_1061);
         var1.add(new uiRecord2.Part1(class_2561.method_43470(var5[0]), var6, var0.method_27525(var6)));
      }

      return v1(var0, class_2561.method_43470("Scoreboard"), var1);
   }

   private static uiRecord2 v1(class_327 var0, class_2561 var1, List<uiRecord2.Part1> var2) {
      int var3 = var0.method_27525(var1);
      int var4 = var0.method_1727(": ");
      int var5 = var3;

      for (uiRecord2.Part1 var7 : var2) {
         int var8 = var0.method_27525(var7.v1()) + (var7.v3() > 0 ? var4 + var7.v3() : 0);
         if (var8 > var5) {
            var5 = var8;
         }
      }

      return new uiRecord2(var1, var3, var5, List.copyOf(var2));
   }

   private static class_266 v1(class_269 var0, class_310 var1) {
      class_266 var2 = null;
      class_268 var3 = var0.method_1164(var1.field_1724.method_5820());
      if (var3 != null) {
         class_8646 var4 = class_8646.method_52622(var3.method_1202());
         if (var4 != null) {
            var2 = var0.method_1189(var4);
         }
      }

      return var2 != null ? var2 : var0.method_1189(class_8646.field_45157);
   }
}
