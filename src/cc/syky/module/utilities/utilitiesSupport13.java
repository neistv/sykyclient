package cc.syky.module.utilities;

import cc.syky.Syky;
import cc.syky.SykyRuntime;
import cc.syky.hud.HUDEditorSupport;
import cc.syky.hud.hudSupport32;
import cc.syky.ui.uiSupport229;
import net.minecraft.class_310;

public final class utilitiesSupport13 {
   private utilitiesSupport13() {
   }

   public static String v1(String var0) {
      String var1 = CapsFix.v1(CommandFix.v1(var0));
      ChatPing.v2(var1);
      return var1;
   }

   public static boolean v1(class_310 var0, String var1) {
      return PvPModeSupport.v1(var0, var1);
   }

   public static boolean v1(int var0, double var1, double var3) {
      SykyRuntime var5 = Syky.rootOrNull();
      if (var5 == null) {
         return false;
      } else if (v1(var5).v1(var0, (float)var1, (float)var3)) {
         return true;
      } else if (var5.v27().v1(var0, var1, var3)) {
         return true;
      } else {
         v2(var5).v1(var0, (float)var1, (float)var3);
         return false;
      }
   }

   public static void v1(boolean var0) {
      SykyRuntime var1 = Syky.rootOrNull();
      if (var1 != null && var0) {
         v2(var1).v4();
      }
   }

   public static boolean v1(int var0, int var1) {
      SykyRuntime var2 = Syky.rootOrNull();
      if (var2 == null) {
         return false;
      } else {
         return v1(var2).v1(var0, var1) ? true : v2(var2).v1(var0, var1, var2.v27().v1());
      }
   }

   public static boolean v2(int var0, int var1) {
      SykyRuntime var2 = Syky.rootOrNull();
      if (var2 == null) {
         return false;
      } else {
         return v1(var2).v2(var0, var1) ? true : v2(var2).v1(var0, var1);
      }
   }

   public static boolean v1(double var0, double var2, double var4) {
      SykyRuntime var6 = Syky.rootOrNull();
      if (var6 == null) {
         return false;
      } else if (v1(var6).v1((float)var0, (float)var2, 0.0, var4)) {
         return true;
      } else {
         return var6.v27().v1(var0, var2, var4) ? true : !uiSupport229.v1() && v2(var6).v1((float)var0, (float)var2, var4);
      }
   }

   private static HUDEditorSupport v1(SykyRuntime var0) {
      return var0.v3().v1();
   }

   private static hudSupport32 v2(SykyRuntime var0) {
      return var0.v3().v3();
   }
}
