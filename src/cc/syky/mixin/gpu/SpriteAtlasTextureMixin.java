package cc.syky.mixin.gpu;

import cc.syky.ui.uiSupport259;
import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.textures.FilterMode;
import net.minecraft.class_1044;
import net.minecraft.class_1059;
import net.minecraft.class_12137;
import net.minecraft.class_7766.class_7767;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin({class_1059.class})
public abstract class SpriteAtlasTextureMixin extends class_1044 {
   public SpriteAtlasTextureMixin() {
   }

   @Inject(
      method = {"method_45848"},
      at = {@At("RETURN")}
   )
   private void syky$sampleTheMipChain(class_7767 var1, CallbackInfo var2) {
      if (var1.comp_1042() > 0) {
         class_12137 var3 = uiSupport259.v1("texture.atlas-mipmaps", () -> RenderSystem.getSamplerCache().method_76520(FilterMode.NEAREST, true), null);
         if (var3 != null) {
            this.field_63613 = var3;
         }
      }
   }
}
