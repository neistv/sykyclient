package cc.syky.ui;

import cc.syky.module.utilities.utilitiesSupport8;
import net.minecraft.class_1657;
import net.minecraft.class_1922;
import net.minecraft.class_239;
import org.jetbrains.annotations.Nullable;

public final class uiSupport235 {
   private uiSupport235() {
   }

   public static boolean v1(class_1657 var0, @Nullable class_239 var1, @Nullable class_1922 var2) {
      return uiSupport188.v1(var0, var1, var2) ? true : utilitiesSupport8.v1(var0, var1);
   }
}
