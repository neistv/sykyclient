package cc.syky.ui;

import cc.syky.module.utilities.ChatCamera;
import cc.syky.module.utilities.utilitiesSupport5;

public final class uiSupport228 {
   private uiSupport228() {
   }

   public static float v1(float var0) {
      if (uiSupport183.v2()) {
         return (float)(var0 * uiSupport183.v3());
      } else {
         return utilitiesSupport5.v1() ? (float)(var0 * utilitiesSupport5.v2()) : var0 * ChatCamera.v17();
      }
   }
}
