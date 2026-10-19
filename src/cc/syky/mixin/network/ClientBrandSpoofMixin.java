package cc.syky.mixin.network;

import net.minecraft.client.ClientBrandRetriever;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin({ClientBrandRetriever.class})
public abstract class ClientBrandSpoofMixin {
   public ClientBrandSpoofMixin() {
   }

   @Inject(
      method = {"getClientModName"},
      at = {@At("HEAD")},
      cancellable = true
   )
   private static void syky$forceVanillaBrand(CallbackInfoReturnable<String> var0) {
      var0.setReturnValue("vanilla");
   }
}
