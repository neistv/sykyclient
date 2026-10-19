package cc.syky.hud;

public final class hudSupport {
   public static final GooSupport v1 = GooSupport.SUBTLE;
   private static boolean v2 = true;
   private static GooSupport v3 = v1;

   private hudSupport() {
   }

   public static boolean v1() {
      return v2;
   }

   public static void v1(boolean var0) {
      v2 = var0;
   }

   public static GooSupport v2() {
      return v3;
   }

   public static void v1(GooSupport var0) {
      v3 = var0 != null ? var0 : v1;
   }

   public static hudRecord v3() {
      return v3.v2();
   }
}
