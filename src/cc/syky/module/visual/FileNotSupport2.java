package cc.syky.module.visual;

import cc.syky.internal.InternalSupport56;
import cc.syky.internal.InternalSupport57;
import cc.syky.ui.uiSupport173;
import com.mojang.blaze3d.systems.CommandEncoder;
import com.mojang.blaze3d.systems.GpuDevice;
import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.textures.GpuTexture;
import com.mojang.blaze3d.textures.GpuTextureView;
import com.mojang.blaze3d.textures.TextureFormat;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.IntBuffer;
import java.nio.file.Files;
import java.nio.file.InvalidPathException;
import java.nio.file.Path;
import net.minecraft.class_1011.class_1012;
import org.jetbrains.annotations.Nullable;
import org.lwjgl.stb.STBImage;
import org.lwjgl.system.MemoryStack;
import org.lwjgl.system.MemoryUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public final class FileNotSupport2 implements AutoCloseable {
   private static final Logger v5 = LoggerFactory.getLogger("syky.sky");
   public static final int v1 = 8388608;
   public static final int v2 = 33554432;
   public static final int v3 = 2048;
   public static final int v4 = 256;
   private static final long v6 = 100663296L;
   private static final long v7 = 134217728L;
   private static final float v8 = 1.25F;
   private final InternalSupport57 v9;
   private final InternalSupport56 v10;
   private final Path v11;
   @Nullable
   private GpuTexture v12;
   @Nullable
   private GpuTextureView v13;
   private int v14 = -12366499;
   @Nullable
   private FileNotSupport2.Part2 v15;
   @Nullable
   private GpuTexture v16;
   private int v18;
   private int v19;
   private int v17;
   private String v20 = "";
   private String v21 = "";
   private int v22;
   private boolean v24;
   @Nullable
   private String v25;
   private int v26;
   private int v27;

   public FileNotSupport2(InternalSupport57 var1, InternalSupport56 var2, Path var3) {
      this.v9 = var1;
      this.v10 = var2;
      this.v11 = var3;
   }

   @Nullable
   public GpuTextureView v1() {
      return this.v13;
   }

   public int v2() {
      return this.v14;
   }

   @Nullable
   public String v3() {
      return (this.v24 || this.v15 != null) && this.v13 == null ? "Loading..." : this.v25;
   }

   public void v1(String var1, String var2, int var3) {
      if (!var2.equals(this.v20)) {
         this.v4();
         this.v20 = var2;
         this.v21 = var1;
         if (!var2.isEmpty()) {
            this.v1(var2, var3);
         }
      } else {
         if (!this.v24 && this.v15 == null && this.v13 != null && this.v25 == null && this.v26 < this.v27 && var3 > this.v26 * 1.25F) {
            this.v1(this.v20, var3);
         }
      }
   }

   public void v1(boolean var1) {
      FileNotSupport2.Part2 var2 = this.v15;
      GpuTexture var3 = this.v16;
      if (var2 != null && var3 != null) {
         try {
            CommandEncoder var4 = RenderSystem.getDevice().createCommandEncoder();
            int var5 = visualSupport38.v1(var2.v3());
            long var6 = var1 ? 8388608L : 33554432L;

            while (var6 > 0L && this.v18 < var5) {
               int var8 = visualSupport38.v1(var2.v3(), this.v18);
               int var9 = var8 * 4;
               int var10 = (int)Math.max(1L, Math.min((long)(var8 - this.v17), var6 / var9));
               int var11 = (int)visualSupport38.v1(var2.v3(), this.v18, this.v19) + this.v17 * var9;
               ByteBuffer var12 = var2.v2().slice(var11, var10 * var9);
               var4.writeToTexture(var3, var12, class_1012.field_4997, this.v18, this.v19, 0, this.v17, var8, var10);
               var6 -= (long)var10 * var9;
               this.v17 += var10;
               if (this.v17 >= var8) {
                  this.v17 = 0;
                  if (++this.v19 == 6) {
                     this.v19 = 0;
                     this.v18++;
                  }
               }
            }

            if (this.v18 >= var5) {
               this.v1(var2, var3);
            }
         } catch (Throwable var13) {
            v5.warn("could not upload the sky picture", var13);
            this.v5();
            if (this.v13 == null) {
               this.v25 = "Can't load picture";
            }
         }
      }
   }

   public void v4() {
      this.v22++;
      this.v20 = "";
      this.v21 = "";
      this.v24 = false;
      this.v25 = null;
      this.v26 = 0;
      this.v27 = 0;
      this.v5();
      this.v6();
   }

   @Override
   public void close() {
      this.v4();
   }

   public static int v1(int var0, double var1) {
      double var3 = Math.tan(Math.toRadians(Math.max(10.0, Math.min(170.0, var1)) / 2.0));
      int var5 = (int)Math.ceil(var0 / var3 / 64.0) * 64;
      return Math.max(256, Math.min(2048, var5));
   }

   private void v1(String var1, int var2) {
      this.v24 = true;
      int var3 = ++this.v22;
      int var4 = RenderSystem.getDevice().getMaxTextureSize();
      int var5 = Math.min(var2, var4);
      Path var6 = this.v11.resolve(this.v21 + ".cube");
      this.v9.v1(() -> {
         Path var5x = v1(var1);

         String var6x;
         try {
            var6x = var5x != null && Files.isRegularFile(var5x) ? visualSupport39.v1(var5x) : null;
         } catch (RuntimeException | IOException var9) {
            var6x = null;
         }

         if (var5x != null && var6x != null) {
            FileNotSupport2.Part1 var7 = v1(var5x, var6x, var6, var5);
            if (var7 == null) {
               var7 = v1(var5x, var5);
               FileNotSupport2.Part2 var8 = var7.v1();
               if (var8 != null && !visualSupport39.v1(var6, var6x, var8.v2(), var8.v3(), var8.v4(), var8.v5())) {
                  v5.warn("could not keep the baked sky picture in {}", var6);
               }
            }

            FileNotSupport2.Part1 var10 = var7;
            this.v10.v1(() -> this.v1(var3, var10));
         } else {
            this.v10.v1(() -> this.v1(var3, "File not found"));
         }
      });
   }

   @Nullable
   private static FileNotSupport2.Part1 v1(Path var0, String var1, Path var2, int var3) {
      long var4 = System.nanoTime();
      visualSupport39.Part1 var6 = visualSupport39.v1(var2, var1, var1x -> v1(var1x, var3), MemoryUtil::memAlloc, MemoryUtil::memFree);
      if (var6 == null) {
         return null;
      } else {
         v5.info("sky picture {} read from the cache as a {} cube in {} ms", new Object[]{var0.getFileName(), var6.v2(), (System.nanoTime() - var4) / 1000000L});
         return new FileNotSupport2.Part1(new FileNotSupport2.Part2(var6.v1(), var6.v2(), var6.v3(), var6.v4()), null);
      }
   }

   private static int v1(int var0, int var1) {
      return Math.max(1, Math.min(var0, var1));
   }

   private static FileNotSupport2.Part1 v1(Path var0, int var1) {
      ByteBuffer var2 = null;
      ByteBuffer var3 = null;

      FileNotSupport2.Part1 var16;
      try {
         long var4 = Files.size(var0);
         if (var4 <= 0L || var4 > 100663296L) {
            return new FileNotSupport2.Part1(null, "File too large");
         }

         byte[] var6 = Files.readAllBytes(var0);
         var2 = MemoryUtil.memAlloc(var6.length);
         var2.put(var6).flip();
         MemoryStack var9 = MemoryStack.stackPush();

         int var7;
         int var8;
         label267: {
            FileNotSupport2.Part1 var35;
            label268: {
               label269: {
                  try {
                     IntBuffer var10 = var9.mallocInt(1);
                     IntBuffer var11 = var9.mallocInt(1);
                     IntBuffer var12 = var9.mallocInt(1);
                     if (!STBImage.stbi_info_from_memory(var2, var10, var11, var12)) {
                        v5.warn("stb cannot read {}: {}", var0.getFileName(), STBImage.stbi_failure_reason());
                        var35 = new FileNotSupport2.Part1(null, "Can't read file");
                        break label268;
                     }

                     if ((long)var10.get(0) * var11.get(0) > 134217728L) {
                        var35 = new FileNotSupport2.Part1(null, "Picture too large");
                        break label269;
                     }

                     var3 = STBImage.stbi_load_from_memory(var2, var10, var11, var12, 4);
                     if (var3 != null) {
                        var7 = var10.get(0);
                        var8 = var11.get(0);
                        break label267;
                     }

                     v5.warn("stb could not decode {}: {}", var0.getFileName(), STBImage.stbi_failure_reason());
                     var35 = new FileNotSupport2.Part1(null, "Can't read file");
                  } catch (Throwable var25) {
                     if (var9 != null) {
                        try {
                           var9.close();
                        } catch (Throwable var23) {
                           var25.addSuppressed(var23);
                        }
                     }

                     throw var25;
                  }

                  if (var9 != null) {
                     var9.close();
                  }

                  return var35;
               }

               if (var9 != null) {
                  var9.close();
               }

               return var35;
            }

            if (var9 != null) {
               var9.close();
            }

            return var35;
         }

         if (var9 != null) {
            var9.close();
         }

         uiSupport173 var29 = uiSupport173.v1(var7, var8);
         int var30 = var29.v1(var7);
         int var31 = v1(var30, var1);
         ByteBuffer var32 = MemoryUtil.memAlloc((int)visualSupport38.v2(var31));

         try {
            long var33 = System.nanoTime();
            visualSupport38.v1(var3, var7, var8, var29, var31, var32);
            int var15 = visualSupport38.v1(var3, var7, var8, var29);
            v5.info(
               "sky picture {} ({}x{}, {}) baked to a {} cube in {} ms",
               new Object[]{var0.getFileName(), var7, var8, var29, var31, (System.nanoTime() - var33) / 1000000L}
            );
            var16 = new FileNotSupport2.Part1(new FileNotSupport2.Part2(var32, var31, var30, var15), null);
         } catch (Throwable var24) {
            MemoryUtil.memFree(var32);
            throw var24;
         }
      } catch (Throwable var26) {
         v5.warn("could not read {} as a sky picture", var0.getFileName(), var26);
         return new FileNotSupport2.Part1(null, "Can't read file");
      } finally {
         if (var3 != null) {
            STBImage.stbi_image_free(var3);
         }

         if (var2 != null) {
            MemoryUtil.memFree(var2);
         }
      }

      return var16;
   }

   @Nullable
   private static Path v1(String var0) {
      try {
         return Path.of(var0);
      } catch (InvalidPathException var2) {
         return null;
      }
   }

   private void v1(int var1, String var2) {
      if (var1 == this.v22) {
         this.v24 = false;
         this.v25 = var2;
      }
   }

   private void v1(int var1, FileNotSupport2.Part1 var2) {
      FileNotSupport2.Part2 var3 = var2.v1();
      if (var1 != this.v22) {
         if (var3 != null) {
            var3.v1();
         }
      } else {
         this.v24 = false;
         if (var3 == null) {
            if (this.v13 == null) {
               this.v25 = var2.v2();
            } else {
               this.v27 = this.v26;
            }
         } else {
            this.v5();

            try {
               GpuDevice var4 = RenderSystem.getDevice();
               this.v16 = var4.createTexture(() -> "syky:custom_sky_picture", 21, TextureFormat.RGBA8, var3.v3(), var3.v3(), 6, visualSupport38.v1(var3.v3()));
            } catch (Throwable var5) {
               v5.warn("could not create the sky texture", var5);
               var3.v1();
               if (this.v13 == null) {
                  this.v25 = "Can't load picture";
               }

               return;
            }

            this.v15 = var3;
            this.v18 = 0;
            this.v19 = 0;
            this.v17 = 0;
         }
      }
   }

   private void v1(FileNotSupport2.Part2 var1, GpuTexture var2) {
      GpuTextureView var3 = RenderSystem.getDevice().createTextureView(var2);
      this.v6();
      this.v12 = var2;
      this.v13 = var3;
      this.v14 = var1.v5();
      this.v26 = var1.v3();
      this.v27 = var1.v4();
      this.v25 = null;
      this.v16 = null;
      this.v15 = null;
      var1.v1();
   }

   private void v5() {
      FileNotSupport2.Part2 var1 = this.v15;
      if (var1 != null) {
         var1.v1();
         this.v15 = null;
      }

      GpuTexture var2 = this.v16;
      if (var2 != null) {
         var2.close();
         this.v16 = null;
      }
   }

   private void v6() {
      if (this.v13 != null) {
         this.v13.close();
         this.v13 = null;
      }

      if (this.v12 != null) {
         this.v12.close();
         this.v12 = null;
      }

      this.v14 = -12366499;
   }

   public record Part1(@Nullable FileNotSupport2.Part2 baked, @Nullable String problem) {
      @Nullable
      public FileNotSupport2.Part2 v1() {
         return this.baked;
      }

      @Nullable
      public String v2() {
         return this.problem;
      }
   }

   public record Part2(ByteBuffer data, int face, int sourceFace, int horizonColor) {
      public void v1() {
         MemoryUtil.memFree(this.data);
      }

      public ByteBuffer v2() {
         return this.data;
      }

      public int v3() {
         return this.face;
      }

      public int v4() {
         return this.sourceFace;
      }

      public int v5() {
         return this.horizonColor;
      }
   }
}
