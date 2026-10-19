package cc.syky.ui;

import java.util.Locale;
import net.minecraft.class_2960;
import org.jetbrains.annotations.Nullable;

public final class uiSupport122 {
   private uiSupport122() {
   }

   public static String v1(String var0) {
      return var0.isEmpty() ? "" : var0.substring(0, 1).toUpperCase(Locale.ROOT);
   }

   public static void v1(@Nullable class_2960 var0, String var1, float var2, float var3, float var4, uiRecord7 var5, int var6, float var7, float var8) {
      if (var0 != null) {
         uiSupport169.v1(var0, var2, var3, var4, var4, uiSupport155.v1(-1, var8), var5);
      } else {
         uiSupport169.v1(var2, var3, var4, var4, uiSupport155.v1(var6, var8), var5);
         if (!var1.isEmpty()) {
            float var9 = uiSupport169.v2("syky_sans_strong", var1, var7);
            uiSupport169.v1(
               "syky_sans_strong",
               var1,
               var2 + (var4 - var9) / 2.0F,
               uiSupport169.v1(var3 + var4 / 2.0F, var7),
               var7,
               uiSupport155.v1(SignInSupport.v20(), var8)
            );
         }
      }
   }
}
