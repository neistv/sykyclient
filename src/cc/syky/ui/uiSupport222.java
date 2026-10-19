package cc.syky.ui;

import com.mojang.brigadier.Message;
import com.mojang.brigadier.suggestion.Suggestion;
import com.mojang.brigadier.suggestion.Suggestions;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import org.jetbrains.annotations.Nullable;

public final class uiSupport222 {
   private uiSupport222() {
   }

   public static CompletableFuture<Suggestions> v1(CompletableFuture<Suggestions> var0) {
      return var0.thenApply(uiSupport222::v1);
   }

   private static Suggestions v1(Suggestions var0) {
      try {
         return uiSupport223.v2 ? v1(var0, uiSupport223.v2()) : var0;
      } catch (Throwable var2) {
         return (Suggestions)var0;
      }
   }

   public static Suggestions v1(Suggestions var0, @Nullable String var1) {
      if (var1 != null && !var1.isEmpty() && !var0.isEmpty()) {
         List var2 = var0.getList();
         ArrayList var3 = null;

         for (int var4 = 0; var4 < var2.size(); var4++) {
            Suggestion var5 = (Suggestion)var2.get(var4);
            Message var6 = var5.getTooltip();
            boolean var7 = uiSupport221.v2(var5.getText(), var1) || var6 != null && uiSupport221.v2(var6.getString(), var1);
            if (var7 && var3 == null) {
               var3 = new ArrayList(var2.subList(0, var4));
            } else if (!var7 && var3 != null) {
               var3.add(var5);
            }
         }

         return var3 == null ? var0 : new Suggestions(var0.getRange(), var3);
      } else {
         return var0;
      }
   }
}
