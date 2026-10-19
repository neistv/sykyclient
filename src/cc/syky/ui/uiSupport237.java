package cc.syky.ui;

public final class uiSupport237 {
   private uiSupport237() {
   }

   public static String v1(String var0) {
      if (var0 == null) {
         return "";
      } else {
         String var1 = var0.replace("(R)", "").replace("(TM)", "").replace("(tm)", "").replace("(C)", "");
         var1 = var1.replaceAll("(?i)\\s+with Radeon Graphics", "");
         var1 = var1.replaceAll("(?i)\\s+\\d+-Core Processor", "");
         var1 = var1.replaceAll("(?i)\\s+Processor", "");
         var1 = var1.replaceAll("(?i)\\s+CPU", "");
         var1 = var1.replaceAll("@.*$", "");
         var1 = var1.replace('-', ' ');
         return v3(var1);
      }
   }

   public static String v2(String var0) {
      if (var0 == null) {
         return "";
      } else {
         String var1 = var0.replace("(R)", "").replace("(TM)", "").replace("(tm)", "");
         var1 = var1.replaceAll("(?i)^NVIDIA\\s+", "");
         var1 = var1.replaceAll("(?i)^GeForce\\s+", "");
         var1 = var1.replaceAll("(?i)^AMD\\s+", "");
         return v3(var1);
      }
   }

   private static String v3(String var0) {
      return var0.replaceAll("[^\\x20-\\x7E]", "").replaceAll("\\s+", " ").trim();
   }
}
