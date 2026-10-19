package cc.syky.render;

import com.mojang.blaze3d.systems.GpuDevice;
import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.textures.GpuTexture;
import com.mojang.blaze3d.textures.GpuTextureView;
import net.minecraft.class_276;
import org.jetbrains.annotations.Nullable;

public final class renderSupport11 implements AutoCloseable {
   private final renderSupport34 v1 = new renderSupport34();
   @Nullable
   private GpuTexture v2;
   @Nullable
   private GpuTextureView v3;
   private int v4;
   private int v5;
   private boolean v6;
   private boolean v7;
   private long v8;
   private long v9;

   public renderSupport11() {
   }

   public void v1() {
      if (this.v6 && !this.v7) {
         this.v9++;
      }

      this.v6 = false;
   }

   public renderRecord v2() {
      return new renderRecord(this.v8, this.v9);
   }

   public void v1(class_276 var1) {
      GpuTexture var2 = var1.method_30278();
      GpuTextureView var3 = var1.method_71640();
      GpuTextureView var4 = var1.method_71639();
      int var5 = var1.field_1482;
      int var6 = var1.field_1481;
      if (var2 != null && var3 != null && var4 != null && var5 > 0 && var6 > 0) {
         GpuTexture var7 = this.v2;
         if (var7 == null || this.v4 != var5 || this.v5 != var6 || var7.getFormat() != var2.getFormat()) {
            this.v3();
            GpuDevice var8 = RenderSystem.getDevice();
            var7 = var8.createTexture(() -> "syky:solid_depth", 12, var2.getFormat(), var5, var6, 1, 1);
            this.v2 = var7;
            this.v3 = var8.createTextureView(var7);
            this.v4 = var5;
            this.v5 = var6;
         }

         this.v1.v1(var3, renderSupport47.v1(this.v3), var4);
         this.v6 = true;
         this.v7 = false;
         this.v8++;
      }
   }

   @Nullable
   public GpuTextureView v2(class_276 var1) {
      if (this.v6 && this.v4 == var1.field_1482 && this.v5 == var1.field_1481) {
         this.v7 = true;
         return this.v3;
      } else {
         return null;
      }
   }

   @Override
   public void close() {
      this.v3();
      this.v1.close();
   }

   private void v3() {
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
      this.v6 = false;
   }
}
