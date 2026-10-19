package cc.syky.ui;

import cc.syky.sykyRecord4;
import com.mojang.brigadier.ParseResults;
import net.minecraft.class_310;
import net.minecraft.class_634;
import net.minecraft.class_746;
import org.jetbrains.annotations.Nullable;

public final class NotInSupport {
   public static final String v1 = "No permission on this server";
   public static final String v2 = "You do not have permission to use the /tp command";
   public static final String v3 = "No permission to teleport to another dimension";
   public static final String v4 = "Unknown dimension";
   public static final String v5 = "Not in a world";

   private NotInSupport() {
   }

   public static boolean v1(sykyRecord4 var0, String var1) {
      return v2(var0, var1) == null;
   }

   @Nullable
   public static String v2(sykyRecord4 var0, String var1) {
      class_634 var2 = v1();
      if (var2 == null) {
         return "Not in a world";
      } else {
         String var3 = uiSupport.v1(var0, var1);
         if (var3 == null) {
            return "Unknown dimension";
         } else if (v1(var2, var3)) {
            return null;
         } else {
            class_310 var4 = class_310.method_1551();
            if (var4 != null && var4.method_1542()) {
               return "You do not have permission to use the /tp command";
            } else {
               String var5 = uiSupport.v1(var0, var0.v9());
               return !var0.v9().equals(var1) && var5 != null && v1(var2, var5)
                  ? "No permission to teleport to another dimension"
                  : "No permission on this server";
            }
         }
      }
   }

   private static boolean v1(class_634 var0, String var1) {
      ParseResults var2 = var0.method_2886().parse(var1, var0.method_2875());
      return !var2.getReader().canRead() && var2.getExceptions().isEmpty() && var2.getContext().getLastChild().getCommand() != null;
   }

   public static void v3(sykyRecord4 var0, String var1) {
      class_634 var2 = v1();
      String var3 = uiSupport.v1(var0, var1);
      if (var2 != null && var3 != null && v1(var0, var1)) {
         var2.method_45730(var3);
      }
   }

   @Nullable
   private static class_634 v1() {
      class_310 var0 = class_310.method_1551();
      class_746 var1 = var0 == null ? null : var0.field_1724;
      return var1 == null ? null : var1.field_3944;
   }
}
