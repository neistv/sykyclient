package cc.syky.ui;

import cc.syky.internal.InternalSupport15;
import net.minecraft.class_11909;
import net.minecraft.class_437;
import org.jetbrains.annotations.Nullable;

public final class uiSupport230 {
   private uiSupport230() {
   }

   @Nullable
   public static Boolean v1(class_437 var0, class_11909 var1, boolean var2) {
      uiSupport141 var3 = uiSupport142.v1;
      if (var3 != null) {
         return var3 == var0 ? null : uiSupport259.v1("clickgui.overlay.mouseClicked", () -> var3.method_25402(var1, var2), false);
      } else {
         boolean var4 = InternalSupport15.v1 != null
            && uiSupport259.v1("whatsnew.mouseClicked", () -> InternalSupport15.v1(var1.comp_4798(), var1.comp_4799(), var1.method_74245()), false);
         return var4 ? Boolean.TRUE : null;
      }
   }

   @Nullable
   public static Boolean v1(class_437 var0, double var1, double var3, double var5, double var7) {
      uiSupport141 var9 = uiSupport142.v1;
      if (var9 != null) {
         return var9 == var0 ? null : uiSupport259.v1("clickgui.overlay.mouseScrolled", () -> var9.method_25401(var1, var3, var5, var7), false);
      } else {
         boolean var10 = InternalSupport15.v1 != null && uiSupport259.v1("whatsnew.mouseScrolled", () -> InternalSupport15.v1(var1, var3, var7), false);
         return var10 ? Boolean.TRUE : null;
      }
   }
}
