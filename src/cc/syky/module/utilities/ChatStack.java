package cc.syky.module.utilities;

import cc.syky.api.ModuleInfo;
import cc.syky.module.Module;
import cc.syky.module.ModuleCategory;
import cc.syky.ui.uiSupport199;
import cc.syky.ui.uiSupport200;
import java.util.List;
import net.minecraft.class_124;
import net.minecraft.class_2561;
import net.minecraft.class_303;
import net.minecraft.class_303.class_7590;
import org.jetbrains.annotations.Nullable;

@ModuleInfo(
   name = "chatstack",
   displayName = "Chat Stack",
   category = ModuleCategory.UTILITIES,
   group = "Readouts",
   description = "module.chatstack.description"
)
public final class ChatStack extends Module {
   @Nullable
   private static ChatStack v2;
   private final uiSupport200 name = new uiSupport200();

   public ChatStack() {
      v2 = this;
      this.setToggleActions(() -> uiSupport199.v1 = true, this::v17);
   }

   @Override
   public void onRenderHook() {
      this.name.v1();
   }

   private void v17() {
      uiSupport199.v1 = false;
      this.name.v1();
   }

   public static class_2561 v1(class_2561 var0, List<class_303> var1, List<class_7590> var2) {
      ChatStack var3 = v2;
      return var3 != null && var3.isEnabled() ? var3.v2(var0, var1, var2) : var0;
   }

   private class_2561 v2(class_2561 var1, List<class_303> var2, List<class_7590> var3) {
      if (var2.isEmpty()) {
         this.name.v1();
         return var1;
      } else {
         String var4 = var1.getString();
         if (var4.isBlank()) {
            this.name.v1();
            return var1;
         } else {
            int var5 = this.name.v1(var4, ((class_303)var2.get(0)).comp_893().getString());
            if (var5 == 0) {
               return var1;
            } else if (!v1(var2, var3)) {
               this.name.v1();
               return var1;
            } else {
               return class_2561.method_43473()
                  .method_10852(var1)
                  .method_10852(class_2561.method_43470(uiSupport200.v1(var5)).method_27692(class_124.field_1080));
            }
         }
      }
   }

   private static boolean v1(List<class_303> var0, List<class_7590> var1) {
      if (utilitiesSupport11.v1(var1, 0, class_7590::comp_898) != 0) {
         return false;
      } else {
         var1.subList(0, utilitiesSupport11.v2(var1, 0, class_7590::comp_898)).clear();
         var0.remove(0);
         return true;
      }
   }
}
