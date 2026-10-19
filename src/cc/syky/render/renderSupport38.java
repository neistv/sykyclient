package cc.syky.render;

import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.textures.GpuTextureView;
import org.jetbrains.annotations.Nullable;

public final class renderSupport38 {
   private renderSupport38() {
   }

   @Nullable
   public static GpuTextureView v1() {
      return RenderSystem.outputColorTextureOverride;
   }

   @Nullable
   public static GpuTextureView v2() {
      return RenderSystem.outputDepthTextureOverride;
   }

   public static void v1(@Nullable GpuTextureView var0) {
      RenderSystem.outputColorTextureOverride = var0;
   }

   public static void v2(@Nullable GpuTextureView var0) {
      RenderSystem.outputDepthTextureOverride = var0;
   }
}
