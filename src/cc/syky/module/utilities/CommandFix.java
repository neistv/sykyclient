package cc.syky.module.utilities;

import cc.syky.api.ModuleInfo;
import cc.syky.module.Module;
import cc.syky.module.ModuleCategory;
import cc.syky.ui.uiRecord14;
import cc.syky.ui.uiSupport196;
import cc.syky.ui.uiSupport198;
import com.mojang.brigadier.CommandDispatcher;
import java.util.Locale;
import net.minecraft.class_634;
import net.minecraft.class_637;
import org.jetbrains.annotations.Nullable;

@ModuleInfo(
   name = "commandfix",
   displayName = "Command Fix",
   category = ModuleCategory.UTILITIES,
   group = "Quality of Life",
   description = "module.commandfix.description"
)
public final class CommandFix extends Module {
   @Nullable
   private static CommandFix v2;
   private final uiRecord14 name;

   public CommandFix(uiRecord14 var1) {
      this.name = var1;
      v2 = this;
   }

   public static String v1(String var0) {
      String var1 = v2(var0);
      return var1 == null ? var0 : var1;
   }

   @Nullable
   public static String v2(String var0) {
      CommandFix var1 = v2;
      return var1 != null && var1.isEnabled() ? var1.v3(var0) : null;
   }

   @Nullable
   private String v3(String var1) {
      class_634 var2 = this.name.v2().v4();
      if (var2 == null) {
         return null;
      } else {
         CommandDispatcher var3 = var2.method_2886();
         return uiSupport198.v1(var1, uiSupport196.v1(), ".syky", var1x -> v1(var3, var1x));
      }
   }

   private static boolean v1(CommandDispatcher<class_637> var0, String var1) {
      if (var0.getRoot().getChild(var1) != null) {
         return true;
      } else {
         String var2 = var1.toLowerCase(Locale.ROOT);
         return !var2.equals(var1) && var0.getRoot().getChild(var2) != null;
      }
   }
}
