package cc.syky.ui;

import cc.syky.render.renderSupport44;
import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.textures.GpuTexture;
import com.mojang.blaze3d.textures.GpuTextureView;
import com.mojang.blaze3d.textures.TextureFormat;
import org.jetbrains.annotations.Nullable;

public final class uiSupport158 implements AutoCloseable {
   @Nullable
   private GpuTexture v1;
   @Nullable
   private GpuTextureView v2;
   private int v3;
   private int v4;
   private boolean v5;
   private static long v6 = 1L;
   private long v7;
   private final renderSupport44.Part2 v8 = new renderSupport44.Part2();
   private long v9;
   private long v10;

   public uiSupport158() {
   }

   public boolean v1(int var1, int var2) {
      return this.v5 && this.v2 != null && this.v3 == var1 && this.v4 == var2;
   }

   public void v1() {
      this.v5 = false;
      this.v8.v2();
   }

   public long v2() {
      return this.v9;
   }

   public long v3() {
      return this.v10;
   }

   public boolean v2(int var1, int var2) {
      return this.v1(var1, var2) && this.v8.v1();
   }

   public renderSupport44.Part2 v4() {
      return this.v8;
   }

   public void v5() {
      this.v10++;
   }

   public void v6() {
      this.v5 = false;
      this.v7 = v6++;
   }

   @Nullable
   public GpuTextureView v3(int var1, int var2) {
      this.v5 = false;
      this.v8.v2();
      this.v7 = v6++;
      if (this.v2 != null && this.v3 == var1 && this.v4 == var2) {
         return this.v2;
      } else {
         this.v14();

         try {
            this.v1 = RenderSystem.getDevice().createTexture(() -> "syky:ui_retained_layer", 12, TextureFormat.RGBA8, var1, var2, 1, 1);
            this.v2 = RenderSystem.getDevice().createTextureView(this.v1);
         } catch (Throwable var4) {
            this.v14();
            return null;
         }

         this.v3 = var1;
         this.v4 = var2;
         return this.v2;
      }
   }

   @Nullable
   public GpuTexture v7() {
      return this.v1;
   }

   @Nullable
   public GpuTextureView v8() {
      return this.v2;
   }

   public long v9() {
      return this.v7;
   }

   public int v10() {
      return this.v3;
   }

   public int v11() {
      return this.v4;
   }

   public void v12() {
      this.v5 = this.v2 != null;
   }

   public void v13() {
      this.v9++;
   }

   private void v14() {
      this.v5 = false;
      this.v8.v2();
      if (this.v2 != null) {
         this.v2.close();
         this.v2 = null;
      }

      if (this.v1 != null) {
         this.v1.close();
         this.v1 = null;
      }

      this.v3 = 0;
      this.v4 = 0;
   }

   @Override
   public void close() {
      this.v14();
      this.v8.close();
   }
}
