package cc.syky.render;

import com.mojang.blaze3d.buffers.GpuBuffer;
import com.mojang.blaze3d.buffers.GpuBufferSlice;
import com.mojang.blaze3d.systems.RenderSystem;
import java.nio.ByteBuffer;
import org.lwjgl.system.MemoryUtil;

public final class renderSupport31 {
   private static final GpuBufferSlice[] v1 = new GpuBufferSlice[64];

   private renderSupport31() {
   }

   public static GpuBufferSlice v1(GpuBuffer var0) {
      int var1 = System.identityHashCode(var0) & v1.length - 1;
      GpuBufferSlice var2 = v1[var1];
      if (var2 == null || var2.buffer() != var0 || var2.length() != var0.size()) {
         var2 = var0.slice();
         v1[var1] = var2;
      }

      return var2;
   }

   public static GpuBuffer v1(String var0) {
      ByteBuffer var1 = MemoryUtil.memAlloc(4);

      GpuBuffer var2;
      try {
         var1.putInt(0).flip();
         var2 = RenderSystem.getDevice().createBuffer(() -> var0, 32, var1);
      } finally {
         MemoryUtil.memFree(var1);
      }

      return var2;
   }
}
