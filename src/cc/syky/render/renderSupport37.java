package cc.syky.render;

import cc.syky.cloud.cloudSupport101;
import cc.syky.cloud.cloudSupport27;
import com.mojang.blaze3d.pipeline.RenderPipeline;
import com.mojang.blaze3d.textures.GpuTextureView;
import java.nio.ByteBuffer;
import net.minecraft.class_1041;
import net.minecraft.class_310;
import org.jetbrains.annotations.Nullable;
import org.lwjgl.system.MemoryUtil;

public abstract class renderSupport37 implements AutoCloseable {
   public final cloudSupport101 v1;
   public final renderSupport44 v2;
   private final int v10;
   @Nullable
   public ByteBuffer v3;
   public boolean v4;
   public float v5;
   public float v6;
   public float v7;
   public int v8;
   public int v9;

   public renderSupport37(cloudSupport101 var1, renderSupport44 var2, int var3) {
      this.v1 = var1;
      this.v2 = var2;
      this.v10 = var3;
   }

   public final void v1() {
      if (!this.v4) {
         try {
            this.v3 = MemoryUtil.memAlloc(this.v10);
            this.v4 = true;
         } catch (Throwable var2) {
            this.close();
            throw var2;
         }
      }
   }

   @Nullable
   public final class_310 v1(float var1, float var2, float var3, float var4, float var5) {
      class_310 var6 = this.v1.v1();
      if (var6 != null && var6.method_1522() != null) {
         if (var3 > 0.0F && var4 > 0.0F && Float.isFinite(var1 + var2 + var5)) {
            this.v1(var6);
            return var6;
         } else {
            return null;
         }
      } else {
         return null;
      }
   }

   public final void v1(class_310 var1) {
      class_1041 var2 = var1.method_22683();
      this.v5 = var2.method_4495();
      this.v8 = var2.method_4489();
      this.v9 = var2.method_4506();
      this.v6 = this.v8 / this.v5;
      this.v7 = this.v9 / this.v5;
   }

   public final void v1(RenderPipeline var1, String var2, @Nullable GpuTextureView var3, @Nullable GpuTextureView var4, int var5, int var6) {
      this.v2
         .v1(
            var1,
            var2,
            renderSupport47.v1(this.v3),
            var3,
            var4,
            cloudSupport27.v4(),
            cloudSupport27.v5(),
            cloudSupport27.v6(),
            cloudSupport27.v7(),
            cloudSupport27.v8(),
            0,
            6,
            var5,
            var6
         );
   }

   @Override
   public void close() {
      if (this.v3 != null) {
         MemoryUtil.memFree(this.v3);
         this.v3 = null;
      }

      this.v4 = false;
   }
}
