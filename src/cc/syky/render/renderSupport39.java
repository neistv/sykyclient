package cc.syky.render;

import cc.syky.cloud.cloudSupport101;
import com.mojang.blaze3d.buffers.GpuBuffer;
import com.mojang.blaze3d.buffers.GpuBufferSlice;
import com.mojang.blaze3d.pipeline.RenderPipeline;
import com.mojang.blaze3d.systems.CommandEncoder;
import com.mojang.blaze3d.systems.RenderPass;
import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.textures.FilterMode;
import com.mojang.blaze3d.textures.GpuTextureView;
import com.mojang.blaze3d.vertex.VertexFormat.class_5595;
import it.unimi.dsi.fastutil.longs.Long2ObjectOpenHashMap;
import java.nio.ByteBuffer;
import java.util.OptionalDouble;
import java.util.OptionalInt;
import net.minecraft.class_12137;
import net.minecraft.class_310;
import org.jetbrains.annotations.Nullable;
import org.lwjgl.system.MemoryUtil;

public final class renderSupport39 implements AutoCloseable, renderSupport44.Part1 {
   private static final int v2 = 6;
   private final cloudSupport101 v3;
   private final int v4;
   private final renderSupport42 v5;
   @Nullable
   private final renderSupport43 v6;
   private renderSupport40[] v7;
   private int v8;
   private int v9;
   private static final int v10 = 2;
   private final GpuBuffer[] v11 = new GpuBuffer[2];
   private final Long2ObjectOpenHashMap<GpuBufferSlice>[] v12 = new Long2ObjectOpenHashMap[2];
   private static final int v13 = 1024;
   private int v14;
   @Nullable
   private GpuBuffer v15;
   @Nullable
   private GpuBuffer v16;
   private boolean v18;

   public renderSupport39(cloudSupport101 var1, int var2) {
      this(var1, var2, null);
   }

   public renderSupport39(cloudSupport101 var1, int var2, @Nullable renderSupport43 var3) {
      this.v3 = var1;
      this.v4 = Math.max(1, var2);
      this.v6 = var3;
      this.v5 = new renderSupport42(65536);
      this.v7 = new renderSupport40[64];

      for (int var4 = 0; var4 < this.v7.length; var4++) {
         this.v7[var4] = new renderSupport40();
      }
   }

   private void v3() {
      if (!this.v18) {
         try {
            this.v15 = renderSupport31.v1("syky:batch2d_dummy_vertex");
            ByteBuffer var1 = MemoryUtil.memAlloc(12);

            try {
               for (short var2 = 0; var2 < 6; var2++) {
                  var1.putShort(var2);
               }

               var1.flip();
               this.v16 = RenderSystem.getDevice().createBuffer(() -> "syky:batch2d_index", 64, var1);
            } finally {
               MemoryUtil.memFree(var1);
            }

            this.v18 = true;
         } catch (Throwable var7) {
            this.v6();
            throw var7;
         }
      }
   }

   private static boolean v1(renderSupport41 var0, renderSupport41 var1, ByteBuffer var2) {
      if (var0.v1 != var1.v1 || var0.v5 != var1.v5 || var0.v6 != var1.v6 || var0.v14 != var1.v14) {
         return false;
      } else if (var0.v7 != var1.v7) {
         return false;
      } else {
         return !var0.v7 || var0.v8 == var1.v8 && var0.v9 == var1.v9 && var0.v10 == var1.v10 && var0.v11 == var1.v11
            ? var0.v16 <= 0 || v2(var0, var1, var2)
            : false;
      }
   }

   private static boolean v2(renderSupport41 var0, renderSupport41 var1, ByteBuffer var2) {
      int var3 = var0.v16;
      if (var3 != var1.v16) {
         return false;
      } else {
         int var4 = var0.v3;
         int var5 = var1.v3;

         for (byte var6 = 0; var6 < var3; var6 += 8) {
            if (var2.getLong(var4 + var6) != var2.getLong(var5 + var6)) {
               return false;
            }
         }

         return true;
      }
   }

   private renderSupport40 v4() {
      if (this.v8 == this.v7.length) {
         renderSupport40[] var1 = new renderSupport40[this.v7.length * 2];
         System.arraycopy(this.v7, 0, var1, 0, this.v7.length);

         for (int var2 = this.v7.length; var2 < var1.length; var2++) {
            var1[var2] = new renderSupport40();
         }

         this.v7 = var1;
      }

      return this.v7[this.v8++];
   }

   public int v1(renderSupport41[] var1, int var2, ByteBuffer var3) {
      this.v5.v3();
      this.v8 = 0;
      this.v9 = 0;
      int var4 = 0;

      while (var4 < var2) {
         renderSupport41 var5 = var1[var4];
         int var6 = var4;

         while (var6 + 1 < var2 && v1(var1[var6 + 1], var5, var3)) {
            var6++;
         }

         if (var5.v14 > 0) {
            int var12 = var5.v14;

            assert var12 % 16 == 0 : "instance stride must be a multiple of the record alignment";

            int var13 = Math.max(1, var5.v15 / var12);
            int var14 = var4;

            while (var14 <= var6) {
               int var10 = Math.min(var13, var6 - var14 + 1);
               int var11 = this.v5.v1(var3, var1[var14].v3, var10 * var12, this.v4);
               this.v4().v1(var5, var11, var5.v15, true, var10);
               this.v9 = Math.max(this.v9, var11 + var5.v15);
               var14 += var10;
            }
         } else if (var5.v16 > 0) {
            this.v1(var1, var4, var6, var3);
         } else {
            for (int var7 = var4; var7 <= var6; var7++) {
               renderSupport41 var8 = var1[var7];
               int var9 = this.v5.v1(var3, var8.v3, var8.v4, this.v4);
               this.v4().v1(var8, var9, var8.v15, false, 0);
               this.v9 = Math.max(this.v9, var9 + var8.v15);
            }
         }

         var4 = var6 + 1;
      }

      return this.v8;
   }

   private void v1(renderSupport41[] var1, int var2, int var3, ByteBuffer var4) {
      int var5 = var1[var2].v16;
      int var6 = var1[var2].v15;
      int var7 = var6 - var5;
      int var8 = var2;

      while (var8 <= var3) {
         int var9 = this.v5.v1(var4, var1[var8].v3, var5, this.v4);
         int var10 = 0;

         int var11;
         for (var11 = 0; var8 <= var3; var8++) {
            int var12 = var1[var8].v4 - var5;
            if (var10 > 0 && var10 + var12 > var7) {
               break;
            }

            this.v5.v1(var4, var1[var8].v3 + var5, var12, 1);
            var10 += var12;
            var11 += var1[var8].v13;
         }

         renderSupport40 var13 = this.v4();
         var13.v1(var1[var2], var9, var6, false, 0);
         var13.v15 = var11;
         var13.v14 = 0;
         this.v9 = Math.max(this.v9, var9 + var6);
      }
   }

   @Override
   public void v1(renderSupport42 var1, renderSupport41[] var2, int var3) {
      if (var3 != 0) {
         class_310 var4 = this.v3.v1();
         if (var4 != null && var4.method_1522() != null) {
            if (var4.method_1522().field_1482 > 0 && var4.method_1522().field_1481 > 0) {
               this.v3();
               this.v1(var2, var3, var1.v1());
               ByteBuffer var5 = this.v5.v1();
               int var6 = var5.remaining();
               if (var6 == 0) {
                  this.v5();
               } else {
                  int var7 = Math.max(var6, this.v9);

                  try {
                     this.v14 = (this.v14 + 1) % 2;
                     GpuBuffer var8 = this.v11[this.v14];
                     if (var8 == null || var8.size() < var7) {
                        if (var8 != null) {
                           var8.close();
                           this.v11[this.v14] = null;
                        }

                        var8 = RenderSystem.getDevice().createBuffer(() -> "syky:batch2d_ubo", 136, var7);
                        this.v11[this.v14] = var8;
                     }

                     CommandEncoder var9 = RenderSystem.getDevice().createCommandEncoder();
                     var9.writeToBuffer(this.v1(this.v14, var8, 0, var6), var5);
                     class_12137 var10 = RenderSystem.getSamplerCache().method_76520(FilterMode.LINEAR, false);
                     int var11 = 0;
                     int var12 = 0;
                     int var13 = 0;
                     int var14 = 0;
                     int var15 = 0;
                     long var16 = 0L;
                     RenderPass var18 = var9.createRenderPass(
                        () -> "syky:batch2d_pass", renderSupport30.v1(var4), OptionalInt.empty(), var4.method_1522().method_71640(), OptionalDouble.empty()
                     );

                     try {
                        RenderPipeline var19 = null;
                        GpuTextureView var20 = null;
                        GpuTextureView var21 = null;
                        boolean var22 = false;
                        boolean var23 = false;
                        int var24 = 0;
                        int var25 = 0;
                        int var26 = 0;
                        int var27 = 0;

                        for (int var28 = 0; var28 < this.v8; var28++) {
                           renderSupport40 var29 = this.v7[var28];
                           if (!var29.v7 || var29.v10 > 0 && var29.v11 > 0) {
                              if (var29.v1 != var19) {
                                 var18.setPipeline(var29.v1);
                                 var18.setVertexBuffer(0, this.v15);
                                 var18.setIndexBuffer(this.v16, class_5595.field_27372);
                                 var19 = var29.v1;
                                 var11++;
                              }

                              if (!var22
                                 || var29.v7 != var23
                                 || var29.v7 && (var29.v8 != var24 || var29.v9 != var25 || var29.v10 != var26 || var29.v11 != var27)) {
                                 if (var29.v7) {
                                    var18.enableScissor(var29.v8, var29.v9, var29.v10, var29.v11);
                                 } else {
                                    var18.disableScissor();
                                 }

                                 var22 = true;
                                 var23 = var29.v7;
                                 var24 = var29.v8;
                                 var25 = var29.v9;
                                 var26 = var29.v10;
                                 var27 = var29.v11;
                                 var12++;
                              }

                              if (var29.v5 != null && var29.v5 != var20) {
                                 var18.bindTexture("Sampler0", var29.v5, var10);
                                 var20 = var29.v5;
                                 var13++;
                              }

                              if (var29.v6 != null && var29.v6 != var21) {
                                 var18.bindTexture("Sampler1", var29.v6, var10);
                                 var21 = var29.v6;
                                 var13++;
                              }

                              var18.setUniform(var29.v2, this.v1(this.v14, var8, var29.v3, var29.v4));
                              var16 += var29.v4;
                              if (var29.v12) {
                                 var18.drawIndexed(0, 0, 6, var29.v13);
                                 var14++;
                                 var15++;
                              } else {
                                 var18.draw(var29.v14, var29.v15);
                                 var15++;
                              }
                           }
                        }

                        if (var22 && var23) {
                           var18.disableScissor();
                        }
                     } catch (Throwable var35) {
                        if (var18 != null) {
                           try {
                              var18.close();
                           } catch (Throwable var34) {
                              var35.addSuppressed(var34);
                           }
                        }

                        throw var35;
                     }

                     if (var18 != null) {
                        var18.close();
                     }

                     if (this.v6 != null) {
                        this.v6.v1(var3, var15, var14, var11, var12, var13, var6, var16);
                     }
                  } finally {
                     this.v5();
                  }
               }
            }
         }
      }
   }

   private void v5() {
      for (int var1 = 0; var1 < this.v8; var1++) {
         this.v7[var1].v1();
      }

      this.v8 = 0;
   }

   public renderSupport40 v1(int var1) {
      return this.v7[var1];
   }

   public renderSupport42 v1() {
      return this.v5;
   }

   public int v2() {
      return this.v9;
   }

   private GpuBufferSlice v1(int var1, GpuBuffer var2, int var3, int var4) {
      Long2ObjectOpenHashMap var5 = this.v12[var1];
      if (var5 == null) {
         var5 = new Long2ObjectOpenHashMap();
         this.v12[var1] = var5;
      }

      long var6 = (long)var3 << 32 | var4 & 4294967295L;
      GpuBufferSlice var8 = (GpuBufferSlice)var5.get(var6);
      if (var8 == null || var8.buffer() != var2) {
         if (var5.size() >= 1024) {
            var5.clear();
         }

         var8 = var2.slice(var3, var4);
         var5.put(var6, var8);
      }

      return var8;
   }

   private void v6() {
      for (int var1 = 0; var1 < this.v11.length; var1++) {
         if (this.v11[var1] != null) {
            this.v11[var1].close();
            this.v11[var1] = null;
         }

         this.v12[var1] = null;
      }

      if (this.v15 != null) {
         this.v15.close();
         this.v15 = null;
      }

      if (this.v16 != null) {
         this.v16.close();
         this.v16 = null;
      }

      this.v18 = false;
   }

   @Override
   public void close() {
      this.v6();
      this.v5.close();
   }
}
