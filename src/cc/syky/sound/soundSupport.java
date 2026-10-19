package cc.syky.sound;

import cc.syky.module.visual.visualRecord;
import java.util.Arrays;
import java.util.concurrent.ConcurrentLinkedQueue;
import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.SourceDataLine;
import org.jetbrains.annotations.Nullable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public final class soundSupport {
   private static final Logger v2 = LoggerFactory.getLogger("syky.sound");
   public static final int v1 = 48000;
   private static final int v3 = 24;
   private static final int v4 = 512;
   private static final long v5 = 250L;
   private final AudioFormat v6 = new AudioFormat(48000.0F, 16, 2, true, false);
   private final ConcurrentLinkedQueue<soundSupport.Part1> v7 = new ConcurrentLinkedQueue<>();
   private volatile boolean v8;
   @Nullable
   private volatile Thread v9;
   private final soundSupport.Part1[] v10 = new soundSupport.Part1[24];
   private final float[] v11 = new float[512];
   private final float[] v12 = new float[512];
   private final byte[] v13 = new byte[2048];
   private int v14;

   public soundSupport() {
   }

   public synchronized void v1() {
      if (!this.v8) {
         this.v8 = true;
         this.v9 = new Thread(this::v3, "syky-audio-mixer");
         this.v9.setDaemon(true);
         this.v9.start();
      }
   }

   public void v1(visualRecord var1, float var2, float var3) {
      if (this.v8 && var1 != null && !(var2 <= 0.0F) && var1.v1().length != 0) {
         if (this.v7.size() < 24) {
            double var4 = (Math.max(-1.0F, Math.min(1.0F, var3)) + 1.0) * (Math.PI / 4);
            float var6 = (float)Math.cos(var4) * var2;
            float var7 = (float)Math.sin(var4) * var2;
            this.v7.offer(new soundSupport.Part1(var1.v1(), var6, var7));
         }
      }
   }

   public void v2() {
      Thread var1;
      synchronized (this) {
         this.v8 = false;
         var1 = this.v9;
         this.v9 = null;
         this.v7.clear();
      }

      if (var1 != null) {
         var1.interrupt();

         try {
            var1.join(250L);
         } catch (InterruptedException var4) {
            Thread.currentThread().interrupt();
         }
      }
   }

   private void v3() {
      Thread var1 = Thread.currentThread();

      SourceDataLine var2;
      try {
         var2 = AudioSystem.getSourceDataLine(this.v6);
         var2.open(this.v6, this.v13.length * 4);
         var2.start();
      } catch (RuntimeException | LineUnavailableException var13) {
         v2.warn("audio output unavailable; syky's own sounds are disabled this session", var13);
         this.v1(var1);
         return;
      }

      try {
         while (this.v8 && this.v9 == var1) {
            this.v4();
            this.v5();
            var2.write(this.v13, 0, this.v13.length);
         }
      } catch (Throwable var14) {
         v2.warn("custom-sound mixer stopped", var14);
      } finally {
         this.v1(var1);

         try {
            var2.stop();
            var2.close();
         } catch (RuntimeException var12) {
         }
      }
   }

   private synchronized void v1(Thread var1) {
      if (this.v9 == var1) {
         this.v9 = null;
         this.v8 = false;
      }
   }

   private void v4() {
      soundSupport.Part1 var1;
      while (this.v14 < 24 && (var1 = this.v7.poll()) != null) {
         this.v10[this.v14++] = var1;
      }
   }

   private void v5() {
      Arrays.fill(this.v11, 0.0F);
      Arrays.fill(this.v12, 0.0F);
      int var1 = 0;

      for (int var2 = 0; var2 < this.v14; var2++) {
         soundSupport.Part1 var3 = this.v10[var2];
         int var4 = Math.min(512, var3.v1.length - var3.v4);

         for (int var5 = 0; var5 < var4; var5++) {
            short var6 = var3.v1[var3.v4 + var5];
            this.v11[var5] = this.v11[var5] + var6 * var3.v2;
            this.v12[var5] = this.v12[var5] + var6 * var3.v3;
         }

         var3.v4 += var4;
         if (var3.v4 < var3.v1.length) {
            this.v10[var1++] = var3;
         }
      }

      for (int var7 = var1; var7 < this.v14; var7++) {
         this.v10[var7] = null;
      }

      this.v14 = var1;
      int var8 = 0;

      for (int var12 = 0; var12 < 512; var12++) {
         int var13 = v1(Math.round(this.v11[var12]));
         int var14 = v1(Math.round(this.v12[var12]));
         this.v13[var8++] = (byte)var13;
         this.v13[var8++] = (byte)(var13 >> 8);
         this.v13[var8++] = (byte)var14;
         this.v13[var8++] = (byte)(var14 >> 8);
      }
   }

   private static int v1(int var0) {
      return var0 > 32767 ? 32767 : Math.max(var0, -32768);
   }

   public static final class Part1 {
      public final short[] v1;
      public final float v2;
      public final float v3;
      public int v4;

      public Part1(short[] var1, float var2, float var3) {
         this.v1 = var1;
         this.v2 = var2;
         this.v3 = var3;
      }
   }
}
