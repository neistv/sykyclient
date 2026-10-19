package cc.syky.ui;

import java.util.regex.Pattern;

public final class uiSupport203 {
   public static final String v1 = "commands.message.display.incoming";
   private static final Pattern[] v2 = new Pattern[]{
      Pattern.compile("(?:->|→|➜|➡|»|>>)\\s*(?:me|you|я|мне|вам|тебе)\\s*[\\]):>|]", 66),
      Pattern.compile("^\\s*(?:\\[[^\\]]{1,20}]\\s*)?(?:from|от)\\s+[^:]{1,40}:\\s", 66),
      Pattern.compile("whispers to you|шепчет (?:вам|тебе)", 66)
   };

   private uiSupport203() {
   }

   public static boolean v1(String var0, String var1) {
      uiSupport193.Part1 var2 = uiSupport193.v1(var1);
      return uiSupport193.v1(var0, var2) != -1 || uiSupport193.v2(var0, var2) != -1;
   }

   public static boolean v1(String var0) {
      String var1 = var0.length() > 80 ? var0.substring(0, 80) : var0;

      for (Pattern var5 : v2) {
         if (var5.matcher(var1).find()) {
            return true;
         }
      }

      return false;
   }

   public static boolean v2(String var0) {
      return var0.startsWith("death.")
         || var0.startsWith("multiplayer.player.")
         || var0.startsWith("chat.type.advancement.")
         || var0.equals("chat.type.admin")
         || var0.startsWith("commands.") && !var0.equals("commands.message.display.incoming");
   }
}
