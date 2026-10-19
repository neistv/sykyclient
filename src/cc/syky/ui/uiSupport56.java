package cc.syky.ui;

import java.time.Duration;
import java.time.Instant;

public final class uiSupport56 {
   private uiSupport56() {
   }

   public static String v1(Instant var0, Instant var1) {
      long var2 = Duration.between(var0, var1).toMinutes();
      if (var2 < 1L) {
         return "";
      } else if (var2 < 60L) {
         return var2 + "m";
      } else {
         long var4 = var2 / 60L;
         return var4 < 24L ? var4 + "h" : var4 / 24L + "d";
      }
   }
}
