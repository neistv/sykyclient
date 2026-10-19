package cc.syky.ui;

import java.io.IOException;
import java.util.Base64;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map.Entry;
import net.minecraft.class_1011;
import net.minecraft.class_2960;
import net.minecraft.class_310;
import org.jetbrains.annotations.Nullable;

public final class uiSupport52 {
   private static final int v1 = 16;
   private static final LinkedHashMap<String, class_2960> v2 = new LinkedHashMap<>(16, 0.75F, true);
   private static int v3;

   private uiSupport52() {
   }

   @Nullable
   public static class_2960 v1(String var0) {
      if (v2.containsKey(var0)) {
         return v2.get(var0);
      } else {
         class_2960 var1 = v2(var0);
         v2.put(var0, var1);

         for (Iterator var2 = v2.entrySet().iterator(); v2.size() > 16 && var2.hasNext(); var2.remove()) {
            class_2960 var3 = (class_2960)((Entry)var2.next()).getValue();
            if (var3 != null) {
               class_310.method_1551().method_1531().method_4615(var3);
            }
         }

         return var1;
      }
   }

   @Nullable
   private static class_2960 v2(String var0) {
      class_1011 var1;
      try {
         var1 = class_1011.method_49277(Base64.getDecoder().decode(var0));
      } catch (IllegalArgumentException | IOException var5) {
         return null;
      }

      class_2960 var2 = class_2960.method_60655("syky", "socials/server_icon_" + v3++);

      try {
         class_310.method_1551().method_1531().method_4616(var2, new uiSupport121(var2, var1));
         return var2;
      } catch (RuntimeException var4) {
         var1.close();
         throw var4;
      }
   }
}
