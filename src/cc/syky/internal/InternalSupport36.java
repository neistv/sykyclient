package cc.syky.internal;

import com.mojang.blaze3d.buffers.GpuBuffer;
import com.mojang.blaze3d.buffers.GpuBufferSlice;
import com.mojang.blaze3d.systems.RenderSystem;
import java.nio.ByteBuffer;
import org.jetbrains.annotations.Nullable;
import org.lwjgl.system.MemoryUtil;

public final class InternalSupport36 implements AutoCloseable {
   private static final long v1 = 16384L;
   @Nullable
   private final GpuBuffer v2;
   @Nullable
   private final GpuBuffer v3;
   private final int[] v4;
   private final int[] v5;
   private final GpuBufferSlice[] v6;
   private final GpuBufferSlice[] v7;
   private boolean v8;

   private InternalSupport36(InternalSupport35 var1) {
      this.v4 = var1.v2();
      this.v5 = var1.v4();
      this.v2 = v1("syky:area_faces", var1.v1());
      this.v3 = v1("syky:area_edges", var1.v3());
      this.v6 = v1(this.v2, this.v4.length / 7);
      this.v7 = v1(this.v3, this.v5.length / 7);
   }

   public static InternalSupport36 v1(InternalSupport35 var0) {
      return new InternalSupport36(var0);
   }

   @Nullable
   private static GpuBuffer v1(String var0, int[] var1) {
      if (var1.length == 0) {
         return null;
      } else {
         ByteBuffer var2 = MemoryUtil.memAlloc(var1.length * 4);

         GpuBuffer var3;
         try {
            var2.asIntBuffer().put(var1);
            var3 = RenderSystem.getDevice().createBuffer(() -> var0, 128, var2);
         } finally {
            MemoryUtil.memFree(var2);
         }

         return var3;
      }
   }

   private static GpuBufferSlice[] v1(@Nullable GpuBuffer var0, int var1) {
      GpuBufferSlice[] var2 = new GpuBufferSlice[var1];

      for (int var3 = 0; var3 < var1 && var0 != null; var3++) {
         var2[var3] = var0.slice(var3 * 16384L, 16384L);
      }

      return var2;
   }

   public int[] v1() {
      return this.v4;
   }

   public int[] v2() {
      return this.v5;
   }

   public GpuBufferSlice v1(int var1) {
      return this.v6[var1];
   }

   public GpuBufferSlice v2(int var1) {
      return this.v7[var1];
   }

   public boolean v3() {
      return this.v8;
   }

   @Override
   public void close() {
      if (!this.v8) {
         this.v8 = true;
         if (this.v2 != null) {
            this.v2.close();
         }

         if (this.v3 != null) {
            this.v3.close();
         }
      }
   }
}
