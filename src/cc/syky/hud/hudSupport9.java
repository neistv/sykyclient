package cc.syky.hud;

public final class hudSupport9 {
   private hudSupport9() {
   }

   public static String v1(String var0) {
      StringBuilder var1 = new StringBuilder(var0.length());
      boolean var2 = true;

      for (int var3 = 0; var3 < var0.length(); var3++) {
         char var4 = var0.charAt(var3);
         if (var4 != '_' && var4 != '/') {
            if (var2 && var1.length() > 0) {
               var1.append(' ');
            }

            var1.append(var2 ? Character.toUpperCase(var4) : var4);
            var2 = false;
         } else {
            var2 = true;
         }
      }

      return var1.toString();
   }
}
