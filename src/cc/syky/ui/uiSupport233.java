package cc.syky.ui;

import cc.syky.module.utilities.ChatHeads;
import cc.syky.module.utilities.ChatPing;
import cc.syky.module.utilities.ChatStack;
import java.util.List;
import net.minecraft.class_2561;
import net.minecraft.class_303;
import net.minecraft.class_303.class_7590;

public final class uiSupport233 {
   private uiSupport233() {
   }

   public static class_2561 v1(class_2561 var0, List<class_303> var1, List<class_7590> var2) {
      ChatHeads.v1(var0);
      return ChatStack.v1(v1(ChatPing.v1(var0)), var1, var2);
   }

   private static class_2561 v1(class_2561 var0) {
      if (!uiSupport223.v2) {
         return var0;
      } else {
         String var1 = uiSupport223.v2();
         return var1 == null ? var0 : uiSupport221.v1(var0, var1);
      }
   }
}
