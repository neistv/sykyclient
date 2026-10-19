package cc.syky.mixin.chat;

import cc.syky.ui.uiSupport209;
import cc.syky.ui.uiSupport214;
import net.minecraft.class_303;
import net.minecraft.class_303.class_7590;
import org.jetbrains.annotations.Nullable;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;

@Mixin({class_303.class, class_7590.class})
public abstract class ChatHeadsLineMixin implements uiSupport209 {
   @Unique
   @Nullable
   private uiSupport214[] syky$heads;
   @Unique
   @Nullable
   private int[] syky$headXs;

   public ChatHeadsLineMixin() {
   }

   @Nullable
   @Override
   public uiSupport214[] syky$heads() {
      return this.syky$heads;
   }

   @Override
   public void syky$heads(@Nullable uiSupport214[] var1) {
      this.syky$heads = var1;
   }

   @Nullable
   @Override
   public int[] syky$headXs() {
      return this.syky$headXs;
   }

   @Override
   public void syky$headXs(@Nullable int[] var1) {
      this.syky$headXs = var1;
   }
}
