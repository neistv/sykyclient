package cc.syky.render;

import com.mojang.blaze3d.buffers.GpuBuffer;
import com.mojang.blaze3d.systems.CommandEncoder;
import com.mojang.blaze3d.systems.RenderPass;
import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.textures.GpuTextureView;
import java.nio.ByteBuffer;
import java.util.OptionalDouble;
import java.util.OptionalInt;
import java.util.function.Supplier;
import org.jetbrains.annotations.Nullable;
import org.lwjgl.system.MemoryUtil;

public abstract class renderSupport36 implements AutoCloseable {
   private final String v5;
   private final int v6;
   @Nullable
   public ByteBuffer v1;
   @Nullable
   public GpuBuffer v2;
   @Nullable
   public GpuBuffer v3;
   public boolean v4;
   private final renderSupport32 v7 = new renderSupport32();
   @Nullable
   private Supplier<String> v8;

   public renderSupport36(String var1, int var2) {
      this.v5 = var1;
      this.v6 = var2;
   }

   public String v1() {
      return this.v5;
   }

   public final void v2() {
      if (!this.v4) {
         try {
            this.v1 = MemoryUtil.memAlloc(this.v6);
            this.v3 = renderSupport31.v1("syky:" + this.v5 + "_dummy_vertex");
            this.v2 = RenderSystem.getDevice().createBuffer(() -> "syky:" + this.v5 + "_params_ubo", 136, this.v6);
            this.v4 = true;
         } catch (Throwable var2) {
            this.close();
            throw var2;
         }
      }
   }

   public final RenderPass v1(CommandEncoder var1, @Nullable GpuTextureView var2, @Nullable GpuTextureView var3) {
      Supplier var4 = this.v7();
      return var3 == null
         ? var1.createRenderPass(var4, var2, OptionalInt.empty())
         : var1.createRenderPass(var4, var2, OptionalInt.empty(), var3, OptionalDouble.empty());
   }

   private Supplier<String> v7() {
      Supplier var1 = this.v8;
      if (var1 == null) {
         String var2 = "syky:" + this.v1();
         var1 = () -> var2;
         this.v8 = var1;
      }

      return var1;
   }

   public final ByteBuffer v3() {
      ByteBuffer var1 = renderSupport47.v1(this.v1);
      var1.clear();
      return var1;
   }

   public static void v1(ByteBuffer var0, float var1, float var2, float var3, float var4) {
      var0.putFloat(var1).putFloat(var2).putFloat(var3).putFloat(var4);
   }

   public final void v1(CommandEncoder var1, ByteBuffer var2) {
      var2.flip();
      var1.writeToBuffer(renderSupport31.v1(renderSupport47.v1(this.v2)), var2);
   }

   public final void v4() {
      this.v7.v1();
   }

   public void v5() {
   }

   public final void v1(long var1) {
      if (this.v7.v1(var1)) {
         this.v5();
      }
   }

   public void v6() {
   }

   @Override
   public void close() {
      this.v6();
      if (this.v2 != null) {
         this.v2.close();
         this.v2 = null;
      }

      if (this.v3 != null) {
         this.v3.close();
         this.v3 = null;
      }

      if (this.v1 != null) {
         MemoryUtil.memFree(this.v1);
         this.v1 = null;
      }

      this.v4 = false;
   }
}
