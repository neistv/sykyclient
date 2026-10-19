package cc.syky.module.visual;

import cc.syky.config.HoldSupport;

public final class visualSupport34 {
   public static HoldSupport[] v1 = new HoldSupport[0];
   public static boolean v2;
   public static boolean v3;
   public static float v4 = 0.4F;

   private visualSupport34() {
   }

   public static void v1() {
      if (v2 || v3) {
         for (HoldSupport var3 : v1) {
            var3.v1(v4);
         }
      }
   }
}
