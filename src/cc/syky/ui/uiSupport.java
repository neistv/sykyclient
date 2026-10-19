package cc.syky.ui;

import cc.syky.sykyRecord4;
import java.util.regex.Pattern;
import org.jetbrains.annotations.Nullable;

public final class uiSupport {
   private static final Pattern v1 = Pattern.compile("[a-z0-9_.-]+:[a-z0-9_./-]+");

   private uiSupport() {
   }

   @Nullable
   public static String v1(sykyRecord4 var0, String var1) {
      String var2 = var0.v6() + " " + (var0.v3() ? var0.v7() + 1 : var0.v7()) + " " + var0.v8();
      if (var0.v9().equals(var1)) {
         return "tp " + var2;
      } else {
         return !v1.matcher(var0.v9()).matches() ? null : "execute in " + var0.v9() + " run tp @s " + var2;
      }
   }
}
