package cc.syky.ui;

import cc.syky.module.visual.visualRecord;
import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.IntBuffer;
import java.nio.ShortBuffer;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.Locale;
import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.AudioFormat.Encoding;
import javazoom.jl.decoder.Bitstream;
import javazoom.jl.decoder.Decoder;
import javazoom.jl.decoder.Header;
import javazoom.jl.decoder.SampleBuffer;
import org.jetbrains.annotations.Nullable;
import org.lwjgl.stb.STBVorbis;
import org.lwjgl.stb.STBVorbisInfo;
import org.lwjgl.system.MemoryStack;
import org.lwjgl.system.MemoryUtil;
import org.lwjgl.system.libc.LibCStdlib;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public final class DecompilationFailedSupport2 {
   private static final Logger v1 = LoggerFactory.getLogger("syky.sound");
   private static final int v2 = 30;
   private static final int v3 = 1440000;
   private static final long v4 = 33554432L;

   private DecompilationFailedSupport2() {
   }

   @Nullable
   public static visualRecord v1(Path var0) {
      String var1 = var0.getFileName().toString().toLowerCase(Locale.ROOT);

      try {
         long var2 = Files.size(var0);
         if (var2 > 33554432L) {
            v1.warn("sound {} is {} bytes — over the {} byte cap, skipped", new Object[]{var0.getFileName(), var2, 33554432L});
            return null;
         } else if (var1.endsWith(".wav")) {
            return v1(new BufferedInputStream(Files.newInputStream(var0)));
         } else if (var1.endsWith(".ogg")) {
            return v2(Files.readAllBytes(var0), var1);
         } else {
            return var1.endsWith(".mp3") ? v2(new BufferedInputStream(Files.newInputStream(var0))) : null;
         }
      } catch (Throwable var4) {
         v1.warn("failed to decode sound {}", var0.getFileName(), var4);
         return null;
      }
   }

   @Nullable
   public static visualRecord v1(byte[] var0, String var1) {
      String var2 = var1.toLowerCase(Locale.ROOT);

      try {
         if (var2.endsWith(".wav")) {
            return v1(new BufferedInputStream(new ByteArrayInputStream(var0)));
         } else if (var2.endsWith(".ogg")) {
            return v2(var0, var2);
         } else {
            return var2.endsWith(".mp3") ? v2(new BufferedInputStream(new ByteArrayInputStream(var0))) : null;
         }
      } catch (Throwable var4) {
         v1.warn("failed to decode sound {}", var1, var4);
         return null;
      }
   }

   @Nullable
   private static visualRecord v1(InputStream var0) throws Exception {
      InputStream var1 = var0;

      visualRecord var22;
      label111: {
         Object var21;
         try (AudioInputStream var2 = AudioSystem.getAudioInputStream(var0)) {
            AudioFormat var3 = var2.getFormat();
            int var4 = var3.getChannels();
            float var5 = var3.getSampleRate();
            if (var4 >= 1 && !(var5 <= 0.0F)) {
               AudioFormat var6 = new AudioFormat(Encoding.PCM_SIGNED, var5, 16, var4, var4 * 2, var5, false);

               try (AudioInputStream var7 = AudioSystem.getAudioInputStream(var6, var2)) {
                  byte[] var8 = var7.readAllBytes();
                  int var9 = var8.length / (2 * var4);
                  short[] var10 = new short[var9];

                  for (int var11 = 0; var11 < var9; var11++) {
                     short var12 = 0;

                     for (int var13 = 0; var13 < var4; var13++) {
                        int var14 = (var11 * var4 + var13) * 2;
                        var12 += (short)(var8[var14] & 255 | var8[var14 + 1] << 8);
                     }

                     var10[var11] = (short)(var12 / var4);
                  }

                  var22 = v1(var10, Math.round(var5));
                  break label111;
               }
            }

            var21 = null;
         } catch (Throwable var20) {
            if (var0 != null) {
               try {
                  var1.close();
               } catch (Throwable var15) {
                  var20.addSuppressed(var15);
               }
            }

            throw var20;
         }

         if (var0 != null) {
            var0.close();
         }

         return (visualRecord)var21;
      }

      if (var0 != null) {
         var0.close();
      }

      return var22;
   }

   @Nullable
   private static visualRecord v2(byte[] var0, String var1) throws Exception {
      ByteBuffer var2 = MemoryUtil.memAlloc(var0.length);

      try {
         var2.put(var0).flip();
         if (!v1(var2)) {
            v1.warn("sound {} decodes to more than {}s — skipped", var1, 30);
            return null;
         } else {
            MemoryStack var3 = MemoryStack.stackPush();

            Object var30;
            label263: {
               visualRecord var32;
               label264: {
                  Object var9;
                  try {
                     IntBuffer var4 = var3.mallocInt(1);
                     IntBuffer var5 = var3.mallocInt(1);
                     ShortBuffer var6 = STBVorbis.stb_vorbis_decode_memory(var2, var4, var5);
                     if (var6 == null) {
                        var30 = null;
                        break label263;
                     }

                     try {
                        int var7 = var4.get(0);
                        int var8 = var5.get(0);
                        if (var7 >= 1 && var8 > 0) {
                           int var31 = var6.remaining() / var7;
                           short[] var10 = new short[var31];
                           int var11 = var6.position();

                           for (int var12 = 0; var12 < var31; var12++) {
                              short var13 = 0;

                              for (int var14 = 0; var14 < var7; var14++) {
                                 var13 += var6.get(var11 + var12 * var7 + var14);
                              }

                              var10[var12] = (short)(var13 / var7);
                           }

                           var32 = v1(var10, var8);
                           break label264;
                        }

                        var9 = null;
                     } finally {
                        LibCStdlib.free(var6);
                     }
                  } catch (Throwable var27) {
                     if (var3 != null) {
                        try {
                           var3.close();
                        } catch (Throwable var25) {
                           var27.addSuppressed(var25);
                        }
                     }

                     throw var27;
                  }

                  if (var3 != null) {
                     var3.close();
                  }

                  return (visualRecord)var9;
               }

               if (var3 != null) {
                  var3.close();
               }

               return var32;
            }

            if (var3 != null) {
               var3.close();
            }

            return (visualRecord)var30;
         }
      } finally {
         MemoryUtil.memFree(var2);
      }
   }

   private static boolean v1(ByteBuffer var0) {
      MemoryStack var1 = MemoryStack.stackPush();

      boolean var16;
      label108: {
         boolean var17;
         label109: {
            try {
               IntBuffer var2 = var1.mallocInt(1);
               long var3 = STBVorbis.stb_vorbis_open_memory(var0, var2, null);
               if (var3 == 0L) {
                  var16 = true;
                  break label108;
               }

               try {
                  STBVorbisInfo var5 = STBVorbisInfo.malloc(var1);
                  STBVorbis.stb_vorbis_get_info(var3, var5);
                  int var6 = var5.sample_rate();
                  int var7 = STBVorbis.stb_vorbis_stream_length_in_samples(var3);
                  if (var6 > 0 && var7 > 0) {
                     var17 = var7 <= 30L * var6;
                     break label109;
                  }

                  var17 = true;
               } finally {
                  STBVorbis.stb_vorbis_close(var3);
               }
            } catch (Throwable var15) {
               if (var1 != null) {
                  try {
                     var1.close();
                  } catch (Throwable var13) {
                     var15.addSuppressed(var13);
                  }
               }

               throw var15;
            }

            if (var1 != null) {
               var1.close();
            }

            return var17;
         }

         if (var1 != null) {
            var1.close();
         }

         return var17;
      }

      if (var1 != null) {
         var1.close();
      }

      return var16;
   }

   @Nullable
   private static visualRecord v2(InputStream var0) throws Exception {
      InputStream var1 = var0;

      visualRecord var26;
      label153: {
         Object var22;
         try {
            Bitstream var2 = new Bitstream(var1);

            try {
               Decoder var3 = new Decoder();
               short[] var4 = new short[65536];
               int var5 = 0;
               int var6 = -1;
               int var7 = -1;
               int var8 = Integer.MAX_VALUE;

               Header var9;
               while ((var9 = var2.readFrame()) != null && var5 < var8) {
                  SampleBuffer var10 = (SampleBuffer)var3.decodeFrame(var9, var2);
                  if (var6 < 0) {
                     var6 = var10.getSampleFrequency();
                     var7 = var10.getChannelCount();
                     if (var6 > 0 && var7 > 0) {
                        var8 = 30 * var6 * var7;
                     }
                  }

                  short[] var11 = var10.getBuffer();
                  int var12 = var10.getBufferLength();
                  if (var5 + var12 > var4.length) {
                     var4 = Arrays.copyOf(var4, Math.max(var4.length * 2, var5 + var12));
                  }

                  System.arraycopy(var11, 0, var4, var5, var12);
                  var5 += var12;
                  var2.closeFrame();
               }

               if (var6 >= 0 && var7 >= 1 && var5 != 0) {
                  int var23 = var5 / var7;
                  short[] var24 = new short[var23];

                  for (int var25 = 0; var25 < var23; var25++) {
                     short var13 = 0;

                     for (int var14 = 0; var14 < var7; var14++) {
                        var13 += var4[var25 * var7 + var14];
                     }

                     var24[var25] = (short)(var13 / var7);
                  }

                  var26 = v1(var24, var6);
                  break label153;
               }

               var22 = null;
            } finally {
               var2.close();
            }
         } catch (Throwable var21) {
            if (var0 != null) {
               try {
                  var1.close();
               } catch (Throwable var19) {
                  var21.addSuppressed(var19);
               }
            }

            throw var21;
         }

         if (var0 != null) {
            var0.close();
         }

         return (visualRecord)var22;
      }

      if (var0 != null) {
         var0.close();
      }

      return var26;
   }

   @Nullable
   private static visualRecord v1(short[] var0, int var1) {
      if (var0.length != 0 && var1 > 0) {
         short[] var2 = var1 == 48000 ? var0 : v2(var0, var1);
         if (var2.length > 1440000) {
            var2 = Arrays.copyOf(var2, 1440000);
         }

         return new visualRecord(var2);
      } else {
         return null;
      }
   }

   private static short[] v2(short[] var0, int var1) {
      long var2 = var0.length * 48000L / var1;
      int var4 = (int)Math.min(var2, 1440000L);
      short[] var5 = new short[var4];
      double var6 = var1 / 48000.0;

      for (int var8 = 0; var8 < var4; var8++) {
         double var9 = var8 * var6;
         int var11 = (int)var9;
         int var12 = Math.min(var11 + 1, var0.length - 1);
         double var13 = var9 - var11;
         var5[var8] = (short)Math.round(var0[var11] + (var0[var12] - var0[var11]) * var13);
      }

      return var5;
   }
}
