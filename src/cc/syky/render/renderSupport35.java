package cc.syky.render;

import com.mojang.blaze3d.systems.GpuDevice;
import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.textures.GpuTexture;
import com.mojang.blaze3d.textures.GpuTextureView;
import com.mojang.blaze3d.textures.TextureFormat;
import org.jetbrains.annotations.Nullable;

public final class renderSupport35 implements AutoCloseable {
   private final String v1;
   private final int v2;
   private final int v3;
   @Nullable
   private GpuTexture v4;
   @Nullable
   private GpuTextureView v5;
   @Nullable
   private GpuTexture v6;
   @Nullable
   private GpuTextureView v7;
   private int v8;
   private int v9;

   public renderSupport35(String var1, int var2, int var3) {
      this.v1 = var1;
      this.v2 = var2;
      this.v3 = var3;
   }

   public boolean v1(int var1, int var2) {
      return this.v4 != null && this.v8 == var1 && this.v9 == var2;
   }

   public boolean v2(int var1, int var2) {
      if (this.v1(var1, var2)) {
         return false;
      } else {
         this.v6();
         GpuDevice var3 = RenderSystem.getDevice();
         GpuTexture var4 = var3.createTexture(() -> this.v1, this.v2, TextureFormat.RGBA8, var1, var2, 1, 1);
         this.v4 = var4;
         this.v5 = var3.createTextureView(var4);
         GpuTexture var5 = var3.createTexture(() -> this.v1 + "_depth", this.v3, TextureFormat.DEPTH32, var1, var2, 1, 1);
         this.v6 = var5;
         this.v7 = var3.createTextureView(var5);
         this.v8 = var1;
         this.v9 = var2;
         return true;
      }
   }

   public void v1() {
      RenderSystem.getDevice().createCommandEncoder().clearColorAndDepthTextures(this.v2(), 0, this.v3(), 1.0);
   }

   public GpuTexture v2() {
      return renderSupport47.v1(this.v4);
   }

   public GpuTexture v3() {
      return renderSupport47.v1(this.v6);
   }

   @Nullable
   public GpuTextureView v4() {
      return this.v5;
   }

   @Nullable
   public GpuTextureView v5() {
      return this.v7;
   }

   public void v6() {
      if (this.v5 != null) {
         this.v5.close();
         this.v5 = null;
      }

      if (this.v4 != null) {
         this.v4.close();
         this.v4 = null;
      }

      if (this.v7 != null) {
         this.v7.close();
         this.v7 = null;
      }

      if (this.v6 != null) {
         this.v6.close();
         this.v6 = null;
      }

      this.v8 = 0;
      this.v9 = 0;
   }

   @Override
   public void close() {
      this.v6();
   }
}
