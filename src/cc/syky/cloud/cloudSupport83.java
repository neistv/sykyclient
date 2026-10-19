package cc.syky.cloud;

import cc.syky.ui.uiSupport260;
import net.fabricmc.fabric.api.client.message.v1.ClientSendMessageEvents;
import net.fabricmc.fabric.api.client.message.v1.ClientSendMessageEvents.AllowChat;

public final class cloudSupport83 {
   public static final String v1 = ".syky";
   private static final uiSupport260 v2 = new uiSupport260("chat (.syky command)");

   private cloudSupport83() {
   }

   public static void v1(cloudSupport101 var0, cloudSupport80 var1) {
      ClientSendMessageEvents.ALLOW_CHAT.register((AllowChat)var2 -> {
         if (!var2.equals(".syky") && !var2.startsWith(".syky ")) {
            return true;
         } else {
            String var3 = var2.length() > ".syky".length() + 1 ? var2.substring(".syky".length() + 1) : "";
            v2.v1(() -> var1.v1(var3, new cloudSupport78(var0)));
            return false;
         }
      });
   }
}
