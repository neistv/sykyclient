package cc.syky.render;

import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.textures.GpuTexture;
import com.mojang.blaze3d.textures.GpuTextureView;
import com.mojang.blaze3d.textures.TextureFormat;
import org.jetbrains.annotations.Nullable;

public final class renderSupport20 implements AutoCloseable {
   private static final int v1 = 128;
   private static final int v2 = 4096;
   private final String v3;
   private final boolean v4;
   @Nullable
   private GpuTexture v5;
   @Nullable
   private GpuTextureView v6;
   private int v7;
   private int v8;

   public renderSupport20(String var1, boolean var2) {
      this.v3 = var1;
      this.v4 = var2;
   }

   public boolean v1(int var1, int var2) {
      if (var1 > 4096 || var2 > 4096) {
         return false;
      } else if (this.v6 != null && this.v7 >= var1 && this.v8 >= var2) {
         return true;
      } else {
         int var3 = this.v4 ? 2 : 1;
         int var4 = Math.min(4096, v1(Math.max(var1, var3 * this.v7)));
         int var5 = Math.min(4096, v1(Math.max(var2, var3 * this.v8)));
         this.close();

         try {
            this.v5 = RenderSystem.getDevice().createTexture(() -> this.v3, 12, TextureFormat.RGBA8, var4, var5, 1, 1);
            this.v6 = RenderSystem.getDevice().createTextureView(this.v5);
         } catch (Throwable var7) {
            this.close();
            return false;
         }

         this.v7 = var4;
         this.v8 = var5;
         return true;
      }
   }

   @Nullable
   public GpuTextureView v1() {
      return this.v6;
   }

   public int v2() {
      return this.v7;
   }

   public int v3() {
      return this.v8;
   }

   private static int v1(int var0) {
      int var1 = (var0 + 128 - 1) / 128;
      return Math.max(128, var1 * 128);
   }

   @Override
   public void close() {
      if (this.v6 != null) {
         this.v6.close();
         this.v6 = null;
      }

      if (this.v5 != null) {
         this.v5.close();
         this.v5 = null;
      }

      this.v7 = 0;
      this.v8 = 0;
   }
}
