package cc.syky.mixin.chat;

import cc.syky.ui.uiSupport204;
import net.minecraft.class_303;
import net.minecraft.class_303.class_7590;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;

@Mixin({class_303.class, class_7590.class})
public abstract class ChatPingLineMixin implements uiSupport204 {
   @Unique
   private boolean syky$mention;

   public ChatPingLineMixin() {
   }

   @Override
   public boolean syky$mention() {
      return this.syky$mention;
   }

   @Override
   public void syky$mention(boolean var1) {
      this.syky$mention = var1;
   }
}
