package cc.syky.module.utilities;

import cc.syky.api.ModuleInfo;
import cc.syky.mixin.accessor.ChatHudAccessor;
import cc.syky.module.Module;
import cc.syky.module.ModuleCategory;
import cc.syky.ui.uiRecord14;
import java.util.ArrayList;
import java.util.List;
import net.minecraft.class_303;
import net.minecraft.class_310;
import net.minecraft.class_327;
import net.minecraft.class_338;
import net.minecraft.class_5481;
import net.minecraft.class_303.class_7590;

@ModuleInfo(
   name = "chathistory",
   displayName = "Infinite Chat History",
   category = ModuleCategory.UTILITIES,
   group = "Readouts",
   description = "module.chathistory.description"
)
public final class InfiniteChatHistory extends Module {
   private static final int name = 100;
   public static final int v2 = 20000;
   private final uiRecord14 displayName;

   public InfiniteChatHistory(uiRecord14 var1) {
      this.displayName = var1;
      this.setToggleActions(() -> utilitiesSupport10.v1 = 20000, () -> utilitiesSupport10.v1 = 0);
   }

   @Override
   public void onDisableHook() {
      this.v1(100);
   }

   private void v1(int var1) {
      class_310 var2 = this.displayName.v2().v1();
      if (var2 != null && var2.field_1705 != null) {
         class_338 var3 = var2.field_1705.method_1743();
         ChatHudAccessor var4 = (ChatHudAccessor)var3;
         boolean var5 = v1(var4.syky$messages(), var1);
         var5 |= v1(var4.syky$visibleMessages(), var1);
         if (var5) {
            var3.method_1802(0);
         }
      }
   }

   private static boolean v1(List<?> var0, int var1) {
      int var2 = var0.size();
      if (var2 <= var1) {
         return false;
      } else {
         var0.subList(var1, var2).clear();
         return true;
      }
   }

   public static boolean v1(List<class_7590> var0, int var1, class_303 var2, class_327 var3, int var4) {
      int var5 = utilitiesSupport11.v1(var0, var1, class_7590::comp_898);
      if (var5 == -1) {
         return false;
      } else if (var5 == -2) {
         return true;
      } else {
         int var6 = utilitiesSupport11.v2(var0, var5, class_7590::comp_898);
         int var7 = var2.comp_892();

         for (int var8 = var5; var8 < var6; var8++) {
            if (((class_7590)var0.get(var8)).comp_895() != var7) {
               return false;
            }
         }

         List var12 = var2.method_75757(var3, var4);
         int var9 = var12.size() - 1;
         ArrayList var10 = new ArrayList(var12.size());

         for (int var11 = var9; var11 >= 0; var11--) {
            var10.add(new class_7590(var7, (class_5481)var12.get(var11), var2.comp_894(), var11 == var9));
         }

         List var13 = var0.subList(var5, var6);
         var13.clear();
         var13.addAll(var10);
         return true;
      }
   }
}
