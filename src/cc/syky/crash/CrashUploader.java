package cc.syky.crash;

import cc.syky.cloud.CloudConfig;
import cc.syky.cloud.CloudHttp;
import cc.syky.cloud.PresenceService;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.net.http.HttpClient;
import java.net.http.HttpClient.Redirect;
import java.nio.file.Path;
import java.time.Duration;
import java.util.List;
import java.util.zip.GZIPOutputStream;
import org.jetbrains.annotations.Nullable;

public final class CrashUploader {
   public static final String v1 = "/v1/crashes";
   public static final int v2 = 524288;
   public static final long v3 = 30000L;
   public static final long v4 = 1800000L;
   public static final int v5 = 10;
   public static final long v6 = 60000L;
   private static final Duration v7 = Duration.ofSeconds(15L);
   private long v8;
   private long v9;

   public CrashUploader() {
   }

   public static CrashUploader.Part1 v1(int var0) {
      if (var0 == 200 || var0 == 202) {
         return CrashUploader.Part1.SENT;
      } else if (var0 == 400 || var0 == 413) {
         return CrashUploader.Part1.REFUSED;
      } else {
         return var0 == 401 ? CrashUploader.Part1.UNAUTHORIZED : CrashUploader.Part1.RETRY;
      }
   }

   public boolean v1(long var1) {
      return var1 >= this.v9;
   }

   public int v1(CloudHttp var1, String var2, String var3, CrashUploader.Part2 var4, long var5) {
      if (!this.v1(var5)) {
         return 0;
      } else {
         int var7 = 0;

         for (Path var9 : var4.v1()) {
            if (var7 >= 10) {
               break;
            }

            byte[] var10 = var4.v1(var9);
            byte[] var11 = var10 == null ? null : v1(var10);
            if (var11 != null && var11.length <= 524288) {
               CloudHttp.Part3 var12 = var1.v1(var2, "/v1/crashes", var11, var3);
               switch (v1(var12.v1())) {
                  case SENT:
                  case REFUSED:
                     var4.v2(var9);
                     this.v8 = 0L;
                     var7++;
                     break;
                  case UNAUTHORIZED:
                  case RETRY:
                     this.v8 = this.v8 == 0L ? 30000L : Math.min(1800000L, this.v8 * 2L);
                     this.v9 = var5 + Math.max(this.v8, var12.v2() * 1000L);
                     return var7;
               }
            } else {
               var4.v2(var9);
               var7++;
            }
         }

         if (var7 > 0) {
            this.v9 = var5 + 60000L;
         }

         return var7;
      }
   }

   public long v1() {
      return this.v8;
   }

   public long v2() {
      return this.v9;
   }

   public static boolean v1(Path var0, byte[] var1, Duration var2) {
      long var3 = System.nanoTime() + var2.toNanos();
      CloudConfig var5 = CloudConfig.v1(var0);
      String var6 = var5.v3();
      if (var5.v1 && !var5.v3 && var6 != null) {
         byte[] var7 = v1(var1);
         if (var7 != null && var7.length <= 524288) {
            Duration var8 = Duration.ofNanos(var3 - System.nanoTime());
            if (var8.toMillis() <= 0L) {
               return false;
            } else {
               HttpClient var9 = HttpClient.newBuilder().connectTimeout(var8).followRedirects(Redirect.NEVER).build();

               boolean var12;
               try {
                  CloudHttp var10 = new CloudHttp(var9, PresenceService.v4(), var8);
                  CrashUploader.Part1 var11 = v1(var10.v1(var5.v1(), "/v1/crashes", var7, var6).v1());
                  var12 = var11 == CrashUploader.Part1.SENT || var11 == CrashUploader.Part1.REFUSED;
               } finally {
                  var9.shutdownNow();
               }

               return var12;
            }
         } else {
            return false;
         }
      } else {
         return false;
      }
   }

   public static void v1(Path var0, CrashUploader.Part2 var1) {
      CloudConfig var2 = CloudConfig.v1(var0);
      String var3 = var2.v3();
      if (var2.v1 && !var2.v3 && var3 != null && !var1.v1().isEmpty()) {
         HttpClient var4 = HttpClient.newBuilder().connectTimeout(v7).followRedirects(Redirect.NEVER).build();

         try {
            CloudHttp var5 = new CloudHttp(var4, PresenceService.v4(), v7);
            int var6 = new CrashUploader().v1(var5, var2.v1(), var3, var1, 0L);
         } finally {
            var4.shutdownNow();
         }
      }
   }

   @Nullable
   public static byte[] v1(byte[] var0) {
      ByteArrayOutputStream var1 = new ByteArrayOutputStream(Math.max(64, var0.length / 4));

      try (GZIPOutputStream var2 = new GZIPOutputStream(var1)) {
         var2.write(var0);
      } catch (IOException var7) {
         return null;
      }

      return var1.toByteArray();
   }

   public static enum Part1 {
      SENT,
      REFUSED,
      UNAUTHORIZED,
      RETRY;

      private Part1() {
      }
   }

   public interface Part2 {
      List<Path> v1();

      @Nullable
      byte[] v1(Path var1);

      void v2(Path var1);

      void v1(Runnable var1);
   }
}
