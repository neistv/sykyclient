package cc.syky.hud;

import cc.syky.render.renderSupport47;
import cc.syky.ui.UiScreen;
import org.jetbrains.annotations.Nullable;

public final class hudSupport35 {
   private hudSupport35() {
   }

   @Nullable
   public static hudSupport54 v1(hudSupport32 var0, HUDEditorSupport var1) {
      hudSupport54 var2 = var0.v11();
      if (var2 != null) {
         return var2;
      } else {
         UiScreen var3 = var1.v3();
         return var3 == null ? null : var3.v31();
      }
   }

   public static hudSupport54 v1(HudManager var0, HUDEditorSupport var1, float var2, float var3) {
      if (var1.v1(var2, var3)) {
         return var1.v1() ? renderSupport47.v1(var1.v3()).v2(var2, var3) : hudSupport54.ARROW;
      } else if (var1.v1()) {
         return hudSupport54.ARROW;
      } else {
         HudElement var4 = hudSupport31.v1(var0, var2, var3, hudSupport31.v1);
         return var4 == null ? hudSupport54.ARROW : var4.v11(var2, var3);
      }
   }
}
