package cc.syky.hud;

import cc.syky.render.renderSupport47;
import org.jetbrains.annotations.Nullable;

public final class hudSupport55 {
   private hudSupport55() {
   }

   public static hudSupport54 v1(@Nullable hudSupport54 var0, boolean var1, hudSupport54 var2) {
      if (v1(var0, var1)) {
         return renderSupport47.v1(var0);
      } else {
         return var2 == null ? hudSupport54.ARROW : var2;
      }
   }

   public static boolean v1(@Nullable hudSupport54 var0, boolean var1) {
      return var1 && var0 != null && var0 != hudSupport54.ARROW;
   }
}
