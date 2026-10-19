package cc.syky;

import cc.syky.internal.InternalSupport21;
import cc.syky.internal.InternalSupport22;
import cc.syky.ui.uiSupport17;
import java.nio.ByteBuffer;
import java.nio.IntBuffer;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.Locale;
import net.minecraft.class_1011;
import net.minecraft.class_1011.class_1012;
import org.jetbrains.annotations.Nullable;
import org.lwjgl.PointerBuffer;
import org.lwjgl.stb.STBImage;
import org.lwjgl.system.MemoryStack;
import org.lwjgl.system.MemoryUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public final class DecompilationFailedSupport {
   private static final Logger v2 = LoggerFactory.getLogger("syky.hud.image");
   public static final String[] v1 = new String[]{".png", ".jpg", ".jpeg", ".gif"};

   private DecompilationFailedSupport() {
   }

   public static boolean v1(Path var0) {
      String var1 = var0.getFileName().toString().toLowerCase(Locale.ROOT);

      for (String var5 : v1) {
         if (var1.endsWith(var5)) {
            return true;
         }
      }

      return false;
   }

   @Nullable
   public static DecompilationFailedSupport.Part2 v1(Path var0, long var1, int var3) {
      try {
         long var4 = Files.size(var0);
         if (var4 > 0L && var4 <= 25165824L) {
            byte[] var6 = Files.readAllBytes(var0);
            return v1(var6) ? v2(var6, var1, Math.min(var3, 1024)) : v1(var6, var1, Math.min(var3, 2048));
         } else {
            v2.warn("{} is {} bytes — outside what a HUD picture may be", var0.getFileName(), var4);
            return null;
         }
      } catch (Throwable var7) {
         v2.warn("could not read {} as a picture", var0.getFileName(), var7);
         return null;
      }
   }

   private static boolean v1(byte[] var0) {
      return var0.length > 6 && var0[0] == 71 && var0[1] == 73 && var0[2] == 70;
   }

   @Nullable
   public static DecompilationFailedSupport.Part1 v1(byte[] var0, int var1) {
      DecompilationFailedSupport.Part1 var2 = v2(var0);
      return var2 == null ? null : v1(var2, Math.min(var1, Math.max(var2.v2(), var2.v3())));
   }

   public static class_1011 v1(DecompilationFailedSupport.Part1 var0) {
      return v1(var0.v1(), var0.v2(), var0.v3());
   }

   @Nullable
   private static DecompilationFailedSupport.Part2 v1(byte[] var0, long var1, int var3) {
      DecompilationFailedSupport.Part1 var4 = v2(var0);
      if (var4 == null) {
         return null;
      } else {
         int var5 = var4.v2();
         int var6 = var4.v3();
         int var7 = Math.max(var5, var6);
         DecompilationFailedSupport.Part1 var8 = v1(var4, v1(Math.min(var3, var7), var5, var6, 1, var1));
         return new DecompilationFailedSupport.Part2(v1(var8.v1(), var8.v2(), var8.v3()), var8.v2(), var8.v3(), 1, 1, null, var5, var6);
      }
   }

   @Nullable
   private static DecompilationFailedSupport.Part1 v2(byte[] var0) {
      ByteBuffer var1 = MemoryUtil.memAlloc(var0.length);

      try {
         var1.put(var0).flip();
         MemoryStack var2 = MemoryStack.stackPush();

         Object var24;
         label189: {
            DecompilationFailedSupport.Part1 var25;
            label190: {
               try {
                  IntBuffer var3 = var2.mallocInt(1);
                  IntBuffer var4 = var2.mallocInt(1);
                  IntBuffer var5 = var2.mallocInt(1);
                  ByteBuffer var6 = STBImage.stbi_load_from_memory(var1, var3, var4, var5, 4);
                  if (var6 == null) {
                     v2.warn(
                        "stb could not decode this picture ({}). A progressive JPEG is the usual reason — re-save it as a PNG or a baseline JPEG.",
                        STBImage.stbi_failure_reason()
                     );
                     var24 = null;
                     break label189;
                  }

                  int var7 = var3.get(0);
                  int var8 = var4.get(0);
                  if (var7 > 0 && var8 > 0) {
                     try {
                        var25 = new DecompilationFailedSupport.Part1(v1(var6, 0, var7, var8), var7, var8);
                        break label190;
                     } finally {
                        STBImage.stbi_image_free(var6);
                     }
                  }

                  STBImage.stbi_image_free(var6);
                  var25 = null;
               } catch (Throwable var22) {
                  if (var2 != null) {
                     try {
                        var2.close();
                     } catch (Throwable var20) {
                        var22.addSuppressed(var20);
                     }
                  }

                  throw var22;
               }

               if (var2 != null) {
                  var2.close();
               }

               return var25;
            }

            if (var2 != null) {
               var2.close();
            }

            return var25;
         }

         if (var2 != null) {
            var2.close();
         }

         return (DecompilationFailedSupport.Part1)var24;
      } finally {
         MemoryUtil.memFree(var1);
      }
   }

   private static DecompilationFailedSupport.Part1 v1(DecompilationFailedSupport.Part1 var0, int var1) {
      int var2 = var0.v2();
      int var3 = var0.v3();
      int var4 = InternalSupport22.v1(var2, var3, var1);
      int[] var5 = InternalSupport21.v1(var0.v1(), var2, var3, var4);
      int var6 = Math.max(1, var2 >> var4);
      int var7 = Math.max(1, var3 >> var4);
      int var8 = Math.max(var6, var7);
      if (var8 > var1) {
         int var9 = Math.max(1, Math.round((float)var6 * var1 / var8));
         int var10 = Math.max(1, Math.round((float)var7 * var1 / var8));
         var5 = InternalSupport21.v1(var5, var6, var7, var9, var10);
         var6 = var9;
         var7 = var10;
      }

      return new DecompilationFailedSupport.Part1(var5, var6, var7);
   }

   @Nullable
   private static DecompilationFailedSupport.Part2 v2(byte[] var0, long var1, int var3) {
      uiSupport17.Part1 var4 = uiSupport17.v1(var0);
      if (var4 != null && var4.v1() > 268435456L) {
         v2.warn(
            "this animation would want {} MiB of native memory to unpack ({}x{}, {} frames{}) — drawing its first frame as a still picture instead",
            new Object[]{var4.v1() / 1048576L, var4.v2(), var4.v3(), var4.v4(), var4.v5() ? "+" : ""}
         );
         return v1(var0, var1, var3);
      } else {
         ByteBuffer var5 = MemoryUtil.memAlloc(var0.length);

         try {
            var5.put(var0).flip();
            MemoryStack var6 = MemoryStack.stackPush();

            DecompilationFailedSupport.Part2 var31;
            label191: {
               DecompilationFailedSupport.Part2 var16;
               try {
                  PointerBuffer var7 = var6.mallocPointer(1);
                  IntBuffer var8 = var6.mallocInt(1);
                  IntBuffer var9 = var6.mallocInt(1);
                  IntBuffer var10 = var6.mallocInt(1);
                  IntBuffer var11 = var6.mallocInt(1);
                  ByteBuffer var12 = STBImage.stbi_load_gif_from_memory(var5, var7, var8, var9, var10, var11, 4);
                  if (var12 == null) {
                     v2.debug("stb declined the animation path: {}", STBImage.stbi_failure_reason());
                     var31 = v1(var0, var1, var3);
                     break label191;
                  }

                  long var13 = var7.get(0);

                  try {
                     ByteBuffer var15 = MemoryUtil.memByteBuffer(
                        MemoryUtil.memAddress(var12), Math.max(1, var8.get(0)) * Math.max(1, var9.get(0)) * 4 * Math.max(1, var10.get(0))
                     );
                     var16 = v1(var15, var13, var8.get(0), var9.get(0), var10.get(0), var1, var3);
                  } finally {
                     STBImage.stbi_image_free(var12);
                     if (var13 != 0L) {
                        STBImage.nstbi_image_free(var13);
                     }
                  }
               } catch (Throwable var29) {
                  if (var6 != null) {
                     try {
                        var6.close();
                     } catch (Throwable var27) {
                        var29.addSuppressed(var27);
                     }
                  }

                  throw var29;
               }

               if (var6 != null) {
                  var6.close();
               }

               return var16;
            }

            if (var6 != null) {
               var6.close();
            }

            return var31;
         } finally {
            MemoryUtil.memFree(var5);
         }
      }
   }

   @Nullable
   private static DecompilationFailedSupport.Part2 v1(ByteBuffer var0, long var1, int var3, int var4, int var5, long var6, int var8) {
      if (var3 > 0 && var4 > 0 && var5 > 0) {
         int var9 = InternalSupport22.v1(var5);
         int var10 = Math.max(var3, var4);
         int var11 = v1(Math.min(var8, var10), var3, var4, var9, var6);
         int var12 = InternalSupport22.v1(var9, var3, var4, var6, var11);
         int var13 = Math.max(1, var3 >> var12);
         int var14 = Math.max(1, var4 >> var12);
         int var15 = var13;
         int var16 = var14;
         int var17 = Math.max(var13, var14);
         if (var17 > var11) {
            var15 = Math.max(1, Math.round((float)var13 * var11 / var17));
            var16 = Math.max(1, Math.round((float)var14 * var11 / var17));
         }

         int var18 = InternalSupport22.v2(var9, var15, var16);

         int var19;
         for (var19 = InternalSupport22.v1(var9, var18);
            var9 > 1 && !InternalSupport22.v1(var18, var19, var15, var16);
            var19 = InternalSupport22.v1(var9, var18)
         ) {
            var18 = InternalSupport22.v2(--var9, var15, var16);
         }

         if (var9 < var5) {
            v2.info("keeping {} of {} animation frames — the rest is past the budget", var9, var5);
         }

         int[] var20 = v1(var1, var9);
         class_1011 var21 = new class_1011(class_1012.field_4997, var18 * var15, var19 * var16, false);

         try {
            int[] var22 = new int[var3 * var4];

            for (int var23 = 0; var23 < var9; var23++) {
               v1(var0, var23 * var3 * var4 * 4, var3, var4, var22);
               int[] var24 = var12 > 0 ? InternalSupport21.v1(var22, var3, var4, var12) : var22;
               if (var15 != var13 || var16 != var14) {
                  var24 = InternalSupport21.v1(var24, var13, var14, var15, var16);
               }

               int var25 = var23 % var18 * var15;
               int var26 = var23 / var18 * var16;

               for (int var27 = 0; var27 < var16; var27++) {
                  for (int var28 = 0; var28 < var15; var28++) {
                     var21.method_61941(var25 + var28, var26 + var27, var24[var27 * var15 + var28]);
                  }
               }
            }
         } catch (Throwable var29) {
            var21.close();
            throw var29;
         }

         int[] var30 = var9 > 1 ? InternalSupport22.v1(var20) : null;
         return new DecompilationFailedSupport.Part2(var21, var15, var16, var18, var9, var30, var3, var4);
      } else {
         return null;
      }
   }

   private static int v1(int var0, int var1, int var2, int var3, long var4) {
      int var6 = Math.max(1, Math.max(var1, var2));
      int var7 = Math.max(1, Math.min(var1, var2));

      long var8;
      for (var8 = Math.max(128, var0); var8 > 128L; var8 = var8 * 3L / 4L) {
         long var10 = Math.max(1L, var7 * var8 / var6);
         if (var3 * var8 * var10 <= var4) {
            break;
         }
      }

      return (int)Math.max(128L, Math.min((long)var0, var8));
   }

   private static int[] v1(ByteBuffer var0, int var1, int var2, int var3) {
      int[] var4 = new int[var2 * var3];
      v1(var0, var1, var2, var3, var4);
      return var4;
   }

   private static void v1(ByteBuffer var0, int var1, int var2, int var3, int[] var4) {
      for (int var5 = 0; var5 < var2 * var3; var5++) {
         int var6 = var1 + var5 * 4;
         var4[var5] = (var0.get(var6 + 3) & 255) << 24 | (var0.get(var6) & 255) << 16 | (var0.get(var6 + 1) & 255) << 8 | var0.get(var6 + 2) & 255;
      }
   }

   private static int[] v1(long var0, int var2) {
      int[] var3 = new int[var2];
      if (var0 == 0L) {
         Arrays.fill(var3, 100);
         return var3;
      } else {
         IntBuffer var4 = MemoryUtil.memIntBuffer(var0, var2);

         for (int var5 = 0; var5 < var2; var5++) {
            var3[var5] = var4.get(var5);
         }

         return var3;
      }
   }

   private static class_1011 v1(int[] var0, int var1, int var2) {
      class_1011 var3 = new class_1011(class_1012.field_4997, var1, var2, false);

      try {
         for (int var4 = 0; var4 < var2; var4++) {
            for (int var5 = 0; var5 < var1; var5++) {
               var3.method_61941(var5, var4, var0[var4 * var1 + var5]);
            }
         }

         return var3;
      } catch (Throwable var6) {
         var3.close();
         throw var6;
      }
   }

   public record Part1(int[] argb, int width, int height) {
      public int[] v1() {
         return this.argb;
      }

      public int v2() {
         return this.width;
      }

      public int v3() {
         return this.height;
      }
   }

   public record Part2(
      class_1011 atlas, int frameWidth, int frameHeight, int columns, int frames, @Nullable int[] cumulativeDelays, int sourceWidth, int sourceHeight
   ) {
      public class_1011 v1() {
         return this.atlas;
      }

      public int v2() {
         return this.frameWidth;
      }

      public int v3() {
         return this.frameHeight;
      }

      public int v4() {
         return this.columns;
      }

      public int v5() {
         return this.frames;
      }

      @Nullable
      public int[] v6() {
         return this.cumulativeDelays;
      }

      public int v7() {
         return this.sourceWidth;
      }

      public int v8() {
         return this.sourceHeight;
      }
   }
}
