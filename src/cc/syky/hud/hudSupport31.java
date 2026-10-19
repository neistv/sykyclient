package cc.syky.hud;

import java.util.List;
import java.util.function.Predicate;
import org.jetbrains.annotations.Nullable;

public final class hudSupport31 {
   public static final Predicate<HudElement> v1 = var0 -> var0.v42() && var0.v10();
   public static final Predicate<HudElement> v2 = HudElement::v10;

   private hudSupport31() {
   }

   @Nullable
   public static HudElement v1(HudManager var0, float var1, float var2, Predicate<HudElement> var3) {
      List var4 = var0.v4();

      for (int var5 = var4.size() - 1; var5 >= 0; var5--) {
         HudElement var6 = (HudElement)var4.get(var5);
         if (v1(var6, var1, var2, var3)) {
            return var6;
         }
      }

      HudElement var8 = null;

      for (HudElement var7 : var0.v9()) {
         if (!var4.contains(var7) && v1(var7, var1, var2, var3)) {
            var8 = var7;
         }
      }

      return var8;
   }

   private static boolean v1(HudElement var0, float var1, float var2, Predicate<HudElement> var3) {
      if (!var3.test(var0)) {
         return false;
      } else {
         hudRecord4 var4 = var0.v27();
         return !var4.v1() && var4.v1(var1, var2);
      }
   }
}
