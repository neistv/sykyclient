package cc.syky.module.utilities;

import cc.syky.ui.uiSupport183;

public final class utilitiesSupport12 {
   private utilitiesSupport12() {
   }

   public static boolean v1(double var0) {
      if (uiSupport183.v1(var0)) {
         return true;
      } else if (Zoom.v1(var0)) {
         return true;
      } else {
         return utilitiesSupport5.v1(var0) ? true : ChatReveal.v1(var0);
      }
   }
}
