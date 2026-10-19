package cc.syky.ui;

import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.textures.FilterMode;
import net.minecraft.class_1011;
import net.minecraft.class_1043;
import net.minecraft.class_2960;

public final class uiSupport121 extends class_1043 {
   public uiSupport121(class_2960 var1, class_1011 var2) {
      super(var1::toString, var2);
      this.field_63613 = RenderSystem.getSamplerCache().method_76520(FilterMode.LINEAR, false);
   }
}
