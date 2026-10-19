package cc.syky.render;

import cc.syky.cloud.cloudSupport101;
import com.mojang.blaze3d.systems.CommandEncoder;
import com.mojang.blaze3d.systems.GpuDevice;
import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.textures.GpuTexture;
import com.mojang.blaze3d.textures.GpuTextureView;
import com.mojang.blaze3d.textures.TextureFormat;
import net.minecraft.class_310;
import org.jetbrains.annotations.Nullable;

public final class renderSupport22 implements AutoCloseable {
   private final cloudSupport101 v1;
   @Nullable
   private GpuTexture v2;
   @Nullable
   private GpuTextureView v3;
   private int v4;
   private int v5;
   private long v6;
   private long v7;
   private final renderSupport32 v8 = new renderSupport32();

   public renderSupport22(cloudSupport101 var1) {
      this.v1 = var1;
   }

   public boolean v1() {
      class_310 var1 = this.v1.v1();
      if (var1 != null && var1.method_1522() != null) {
         int var2 = var1.method_1522().field_1482;
         int var3 = var1.method_1522().field_1481;
         if (var2 > 0 && var3 > 0 && this.v1(var2, var3)) {
            CommandEncoder var4 = RenderSystem.getDevice().createCommandEncoder();
            var4.clearColorTexture(this.v2, 0);
            this.v6++;
            this.v8.v1();
            return renderSupport30.v1(this.v3);
         } else {
            return false;
         }
      } else {
         return false;
      }
   }

   public long v2() {
      return this.v6;
   }

   public void v1(long var1) {
      this.v7 += var1;
   }

   public long v3() {
      return this.v7;
   }

   @Nullable
   public GpuTextureView v4() {
      renderSupport30.v1();
      return this.v3;
   }

   private boolean v1(int var1, int var2) {
      if (this.v2 != null && var1 == this.v4 && var2 == this.v5) {
         return true;
      } else {
         this.v5();
         GpuDevice var3 = RenderSystem.getDevice();
         this.v2 = var3.createTexture(() -> "syky:hud_composite", 12, TextureFormat.RGBA8, var1, var2, 1, 1);
         this.v3 = var3.createTextureView(this.v2);
         this.v4 = var1;
         this.v5 = var2;
         return true;
      }
   }

   private void v5() {
      if (this.v3 != null) {
         this.v3.close();
         this.v3 = null;
      }

      if (this.v2 != null) {
         this.v2.close();
         this.v2 = null;
      }

      this.v4 = 0;
      this.v5 = 0;
   }

   public void v2(long var1) {
      if (this.v8.v1(var1)) {
         this.v5();
      }
   }

   @Override
   public void close() {
      this.v5();
   }
}
