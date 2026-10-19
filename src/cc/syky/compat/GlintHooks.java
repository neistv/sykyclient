package cc.syky.compat;

import cc.syky.internal.InternalSupport53;
import cc.syky.module.visual.visualSupport50;
import cc.syky.ui.uiSupport259;
import com.mojang.blaze3d.textures.GpuTextureView;
import org.jetbrains.annotations.Nullable;
import org.joml.Vector4f;

public final class GlintHooks {
   private GlintHooks() {
   }

   @Nullable
   public static Vector4f modulator(boolean var0) {
      return !visualSupport50.v3 ? null : uiSupport259.v1("glint.color", () -> {
         InternalSupport53.v1(var0);
         if (InternalSupport53.v2(var0) == null) {
            return null;
         } else {
            int var1 = visualSupport50.v4;
            float var2 = visualSupport50.v5;
            return new Vector4f((var1 >> 16 & 0xFF) / 255.0F * var2, (var1 >> 8 & 0xFF) / 255.0F * var2, (var1 & 0xFF) / 255.0F * var2, 1.0F);
         }
      }, null);
   }

   @Nullable
   public static GpuTextureView texture(boolean var0) {
      return !visualSupport50.v3 ? null : uiSupport259.v1("glint.texture", () -> InternalSupport53.v2(var0), null);
   }
}
