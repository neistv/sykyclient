package cc.syky.hud;

import org.jetbrains.annotations.Nullable;

public final class hudSupport53 {
   private static hudSupport54 v1 = hudSupport54.ARROW;
   private static boolean v2;

   private hudSupport53() {
   }

   public static void v1(@Nullable hudSupport54 var0, boolean var1, hudSupport54 var2) {
      v1 = hudSupport55.v1(var0, var1, var2);
      v2 = hudSupport55.v1(var0, var1);
   }

   public static hudSupport54 v1() {
      return v1;
   }

   public static boolean v2() {
      return v2;
   }

   public static void v3() {
      v1 = hudSupport54.ARROW;
      v2 = false;
   }
}
