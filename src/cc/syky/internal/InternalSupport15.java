package cc.syky.internal;

import cc.syky.Syky;
import cc.syky.SykyRuntime;
import cc.syky.sykyRecord;
import cc.syky.cloud.cloudSupport57;
import cc.syky.hud.DiscordSupport;
import cc.syky.ui.uiSupport142;
import cc.syky.ui.uiSupport169;
import net.minecraft.class_1041;
import net.minecraft.class_310;
import net.minecraft.class_312;
import org.jetbrains.annotations.Nullable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public final class InternalSupport15 {
   private static final Logger v3 = LoggerFactory.getLogger("syky.whatsnew");
   @Nullable
   public static DiscordSupport v1;
   private static final long v4 = 250000000L;
   private static final long v5 = 120000000L;
   private static long v6;
   private static final long v7 = Long.MIN_VALUE;
   public static long v2;
   private static boolean v8;

   private InternalSupport15() {
   }

   public static void v1(class_310 var0) {
      DiscordSupport var1 = v1;
      if (var1 == null) {
         v2 = 0L;
         v2(var0);
      } else if (!v3(var0)) {
         v1 = null;
         v2 = 0L;
      } else {
         class_1041 var2 = var0.method_22683();
         float var3 = (float)v5(var0);
         float var4 = (float)v6(var0);
         uiSupport169.v9();

         boolean var5;
         try {
            var5 = var1.v1(var2.method_4486(), var2.method_4502(), var3, var4, v4(var0));
         } finally {
            uiSupport169.v10();
         }

         if (!var5) {
            v1 = null;
            v2 = 0L;
            v3();
         } else {
            v2 = var1.v2(var3, var4) ? System.nanoTime() + 120000000L : 0L;
            if (v6 == Long.MIN_VALUE) {
               v3.info("release notes on screen: {}", var1.v1());
            }

            v6 = System.nanoTime();
         }
      }
   }

   private static void v2(class_310 var0) {
      if (!v8 && v3(var0) && var0.method_18506() == null) {
         SykyRuntime var1 = Syky.rootOrNull();
         if (var1 != null) {
            v8 = true;
            sykyRecord var2 = var1.v29().v1();
            if (var2 != null) {
               v1 = new DiscordSupport(var2);
               v6 = Long.MIN_VALUE;
            }
         }
      }
   }

   private static boolean v3(class_310 var0) {
      return var0.field_1687 == null && var0.field_1755 != null;
   }

   private static void v3() {
      SykyRuntime var0 = Syky.rootOrNull();
      if (var0 != null) {
         var0.v29().v2();
      }
   }

   @Nullable
   private static DiscordSupport v4() {
      DiscordSupport var0 = v1;
      if (var0 == null) {
         return null;
      } else if (uiSupport142.v1 != null) {
         var0.v4();
         return null;
      } else {
         return v6 != Long.MIN_VALUE && System.nanoTime() - v6 >= 250000000L ? null : var0;
      }
   }

   public static boolean v1(double var0, double var2, int var4) {
      DiscordSupport var5 = v4();
      return var5 != null && var5.v1((float)var0, (float)var2, var4);
   }

   public static boolean v1() {
      DiscordSupport var0 = v4();
      return var0 != null && var0.v3();
   }

   public static boolean v1(class_310 var0, double var1, double var3) {
      DiscordSupport var5 = v4();
      if (var5 == null) {
         return false;
      } else {
         class_1041 var6 = var0.method_22683();
         return var5.v1(var6.method_4486(), var6.method_4502(), (float)var1, (float)var3);
      }
   }

   public static boolean v1(double var0, double var2, double var4) {
      DiscordSupport var6 = v4();
      return var6 != null && var6.v1((float)var0, (float)var2, var4);
   }

   public static boolean v2() {
      DiscordSupport var0 = v4();
      if (var0 == null) {
         return false;
      } else {
         var0.v2();
         return true;
      }
   }

   private static boolean v4(class_310 var0) {
      return cloudSupport57.v1(var0.method_22683(), 0);
   }

   private static double v5(class_310 var0) {
      return class_312.method_68880(var0.method_22683(), var0.field_1729.method_1603());
   }

   private static double v6(class_310 var0) {
      return class_312.method_68884(var0.method_22683(), var0.field_1729.method_1604());
   }
}
