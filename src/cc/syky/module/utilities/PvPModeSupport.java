package cc.syky.module.utilities;

import cc.syky.ui.uiSupport176;
import java.util.Locale;
import java.util.Set;
import net.minecraft.class_124;
import net.minecraft.class_156;
import net.minecraft.class_2561;
import net.minecraft.class_310;
import net.minecraft.class_345;
import net.minecraft.class_410;
import net.minecraft.class_437;
import org.jetbrains.annotations.Nullable;

public final class PvPModeSupport {
   public static boolean v1;
   private static final int v2 = 10;
   private static final long v3 = 10000L;
   private static final Set<String> v4 = Set.of("hub", "lobby", "l", "leave", "server");
   @Nullable
   private static String v5;
   private static long v6;

   private PvPModeSupport() {
   }

   public static boolean v1(class_310 var0, class_437 var1, Runnable var2) {
      if (v1 && v1(var0)) {
         class_410 var3 = new class_410(
            var3x -> {
               if (var3x) {
                  var2.run();
               } else {
                  var0.method_1507(var1);
               }
            },
            v1("title", "PvP mode is active"),
            v1("message", "The server still has you in combat. Leaving now counts as combat logging, and many servers kill you for it and drop your items."),
            v1("leave", "Leave"),
            v1("cancel", "Cancel")
         );
         var0.method_1507(var3);
         var3.method_2125(10);
         return true;
      } else {
         return false;
      }
   }

   public static boolean v1(class_310 var0, String var1) {
      if (v1 && v1(var1) && v1(var0)) {
         String var2 = var1.strip().toLowerCase(Locale.ROOT);
         long var3 = class_156.method_658();
         if (var2.equals(v5) && var3 - v6 <= 10000L) {
            v5 = null;
            return false;
         } else {
            v5 = var2;
            v6 = var3;
            String var5 = FogBlurSupport.v1(
                  "module.pvpleaveconfirm.command.held", "Leaving now counts as combat logging. Send {command} again within 10 seconds to leave anyway."
               )
               .replace("{command}", "/" + var1.strip());
            var0.field_1705
               .method_1743()
               .method_1812(
                  v1("title", "PvP mode is active")
                     .method_27661()
                     .method_27692(class_124.field_1061)
                     .method_10852(class_2561.method_43470(" " + var5).method_27692(class_124.field_1080))
               );
            return true;
         }
      } else {
         return false;
      }
   }

   public static boolean v1(String var0) {
      String[] var1 = var0.strip().toLowerCase(Locale.ROOT).split("\\s+", 2);
      String var2 = var1[0].substring(var1[0].indexOf(58) + 1);
      return var2.equals("server") ? var1.length > 1 : v4.contains(var2);
   }

   private static boolean v1(class_310 var0) {
      if (var0.field_1705 == null) {
         return false;
      } else {
         for (class_345 var2 : var0.field_1705.method_1740().field_2060.values()) {
            if (uiSupport176.v1(var2.method_5414().getString())) {
               return true;
            }
         }

         return false;
      }
   }

   private static class_2561 v1(String var0, String var1) {
      return class_2561.method_43470(FogBlurSupport.v1("module.pvpleaveconfirm.dialog." + var0, var1));
   }
}
