package cc.syky.mixin.chat;

import cc.syky.ui.uiSupport222;
import cc.syky.ui.uiSupport223;
import cc.syky.ui.uiSupport259;
import com.llamalad7.mixinextras.injector.ModifyExpressionValue;
import com.mojang.brigadier.suggestion.Suggestions;
import java.util.concurrent.CompletableFuture;
import net.minecraft.class_4717;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

@Mixin({class_4717.class})
public abstract class ChatInputSuggestorStreamerMixin {
   public ChatInputSuggestorStreamerMixin() {
   }

   @ModifyExpressionValue(
      method = {"method_23934"},
      at = {@At(
         value = "INVOKE",
         target = "Lcom/mojang/brigadier/CommandDispatcher;getCompletionSuggestions(Lcom/mojang/brigadier/ParseResults;I)Ljava/util/concurrent/CompletableFuture;"
      ), @At(
         value = "INVOKE",
         target = "Lnet/minecraft/class_2172;method_9265(Ljava/lang/Iterable;Lcom/mojang/brigadier/suggestion/SuggestionsBuilder;)Ljava/util/concurrent/CompletableFuture;"
      )}
   )
   private CompletableFuture<Suggestions> syky$hideOwnName(CompletableFuture<Suggestions> var1) {
      if (!uiSupport223.v2) {
         return var1;
      } else {
         CompletableFuture var2 = uiSupport259.v1("chat.suggest-streamer", () -> uiSupport222.v1(var1), var1);
         return var2 != null ? var2 : var1;
      }
   }
}
