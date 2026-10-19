package cc.syky.mixin.gpu;

import cc.syky.internal.Support647;
import java.util.Set;
import net.minecraft.class_10866;
import org.jetbrains.annotations.Nullable;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Mutable;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.At.Shift;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin({class_10866.class})
public abstract class RenderPassImplMixin {
   @Shadow
   @Final
   @Mutable
   public Set<String> field_57875;
   @Unique
   @Nullable
   private static Support647 syky$spare;

   public RenderPassImplMixin() {
   }

   @Inject(
      method = {"<init>"},
      at = {@At("TAIL")}
   )
   private void syky$dirtySetWithoutNodes(CallbackInfo var1) {
      Support647 var2 = syky$spare;
      syky$spare = null;
      this.field_57875 = var2 != null ? var2 : new Support647();
   }

   @Inject(
      method = {"close"},
      at = {@At(
         value = "INVOKE",
         target = "Lnet/minecraft/class_10860;method_68346()V",
         shift = Shift.AFTER
      )}
   )
   private void syky$handBackDirtySet(CallbackInfo var1) {
      if (this.field_57875 instanceof Support647 var2) {
         var2.clear();
         syky$spare = var2;
      }
   }
}
