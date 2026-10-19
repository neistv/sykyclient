package cc.syky.ui;

public final class uiSupport268 {
   public static final String v1 = v1("api", "minecraftservices", "com");
   public static final String v2 = v1("sessionserver", "mojang", "com");
   public static final String v3 = v1("api", "mojang", "com");

   private uiSupport268() {
   }

   private static String v1(String... var0) {
      return "https://" + String.join(".", var0);
   }
}
