package cc.syky.internal;

import cc.syky.sykyRecord9;
import cc.syky.cloud.CloudClient;
import cc.syky.cloud.OnlyMeSupport2;
import cc.syky.cloud.cloudSupport101;
import cc.syky.cloud.cloudSupport92;
import cc.syky.cloud.cloudSupport99;
import cc.syky.config.ConfigUi;
import cc.syky.config.configSupport10;
import cc.syky.hud.hudSupport75;
import cc.syky.ui.AltManagerSupport;
import cc.syky.ui.uiSupport141;
import cc.syky.ui.uiSupport142;
import cc.syky.ui.uiSupport226;
import net.minecraft.class_310;
import net.minecraft.class_342;
import net.minecraft.class_364;
import net.minecraft.class_4069;
import net.minecraft.class_437;
import net.minecraft.class_6599;
import org.jetbrains.annotations.Nullable;

public final class InternalSupport26 {
   public static final int v1 = 344;
   public static final int v2 = 50;
   @Nullable
   private static String v3;

   private InternalSupport26() {
   }

   public static void v1(String var0) {
      v3 = var0;
   }

   public static void v1(
      cloudSupport92 var0,
      cloudSupport101 var1,
      uiSupport226 var2,
      hudSupport75 var3,
      cloudSupport99 var4,
      configSupport10 var5,
      ConfigUi var6,
      CloudClient var7,
      sykyRecord9 var8
   ) {
      var0.v1(InternalSupport59.class, var8x -> v1(var8x.v1, var8x.v3, var1, var2, var3, var4, var5, var6, var7, var8), 50);
      var0.v1(InternalSupport58.class, var7x -> v1(var1, var2, var3, var5, var6, var7, var8), 0);
   }

   private static void v1(cloudSupport101 var0, uiSupport226 var1, hudSupport75 var2, configSupport10 var3, ConfigUi var4, CloudClient var5, sykyRecord9 var6) {
      String var7 = v3;
      class_310 var8 = var0.v1();
      if (var7 != null && var8 != null && var8.field_1687 != null && var8.field_1755 == null && uiSupport142.v1 == null) {
         v3 = null;
         OnlyMeSupport2.v1(var5).v1(var7);
         uiSupport141.v1(AltManagerSupport.ACCOUNT);
         uiSupport142.v1(var8, new uiSupport141(var1, var2, var0, var3, var4, var5, var6));
      }
   }

   private static void v1(
      int var0,
      int var1,
      cloudSupport101 var2,
      uiSupport226 var3,
      hudSupport75 var4,
      cloudSupport99 var5,
      configSupport10 var6,
      ConfigUi var7,
      CloudClient var8,
      sykyRecord9 var9
   ) {
      if (var5.v1("clickgui", var0, var1)) {
         class_310 var10 = var2.v1();
         if (var10 != null) {
            if (!(var10.field_1755 instanceof class_6599)) {
               uiSupport141 var11 = uiSupport142.v1;
               if (var11 != null) {
                  if (!var11.v2()) {
                     if (!var11.v3()) {
                        var11.method_25419();
                     }
                  }
               } else {
                  class_437 var12 = var10.field_1755;
                  if (var12 == null) {
                     if (var10.field_1687 != null) {
                        uiSupport142.v1(var10, new uiSupport141(var3, var4, var2, var6, var7, var8, var9));
                     }
                  } else if (var10.field_1687 == null && v1(var12) && !v2(var12)) {
                     uiSupport142.v1(var10, new uiSupport141(var3, var4, var2, var6, var7, var8, var9));
                  }
               }
            }
         }
      }
   }

   private static boolean v1(class_437 var0) {
      return var0.getClass().getName().startsWith("net.minecraft.");
   }

   private static boolean v2(class_437 var0) {
      class_364 var1 = var0.method_25399();

      while (var1 != null) {
         if (var1 instanceof class_342 var3) {
            return !var3.method_1882().isEmpty();
         }

         var1 = var1 instanceof class_4069 var2 ? var2.method_25399() : null;
      }

      return false;
   }
}
