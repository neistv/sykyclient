package cc.syky.update;

import cc.syky.sykyRecord6;
import cc.syky.cloud.cloudSupport66;
import cc.syky.internal.InternalSupport12;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpClient.Redirect;
import java.net.http.HttpRequest.Builder;
import java.net.http.HttpResponse.BodyHandlers;
import java.nio.channels.FileChannel;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.nio.file.StandardOpenOption;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Base64;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Locale;
import org.jetbrains.annotations.Nullable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public final class UpdateManager {
   private static final Logger v3 = LoggerFactory.getLogger("syky.update.net");
   private static final HttpClient v4 = HttpClient.newBuilder().connectTimeout(UpdateKeys.v6).followRedirects(Redirect.NORMAL).build();
   private static final int v5 = 65536;
   private static final long v6 = 4096L;
   private final Path v7;
   private final List<String> v8;
   public static final String v1 = "manifest.json";
   public static final String v2 = "manifest.json.sig";

   public UpdateManager(Path var1) {
      this(var1, UpdateKeys.v3);
   }

   public UpdateManager(Path var1, List<String> var2) {
      this.v7 = var1;
      this.v8 = List.copyOf(var2);
   }

   @Nullable
   public UpdateManager.Part2 v1(List<String> var1, @Nullable InternalSupport12.Part2 var2) {
      sykyRecord6 var3 = var2 == null ? null : this.v1();
      InternalSupport12.Part2 var4 = var3 == null ? null : var2;

      for (String var6 : v1(var1)) {
         UpdateManager.Part1 var7 = this.v1(var6, 524288L, v1(var4, var6));
         if (var7 != null) {
            if (var7.v1 && var3 != null) {
               v3.debug("{} reports the cached manifest is current", var6);
               return new UpdateManager.Part2(var3, false, var4);
            }

            byte[] var8 = var7.v2;
            if (var8 != null) {
               byte[] var9 = this.v2(var6);
               if (var9 == null) {
                  v3.debug("no signature alongside {}", var6);
               } else if (!Ed25519Verifier.v1(var8, var9, this.v8)) {
                  v3.warn("manifest at {} is not signed by a trusted key — ignored", var6);
               } else {
                  sykyRecord6 var10 = sykyRecord6.v1(new String(var8, StandardCharsets.UTF_8));
                  if (var10 != null) {
                     this.v1(var8, var9);
                     return new UpdateManager.Part2(var10, true, var7.v1(var6));
                  }
               }
            }
         }
      }

      return null;
   }

   @Nullable
   private static InternalSupport12.Part2 v1(@Nullable InternalSupport12.Part2 var0, String var1) {
      return var0 != null && var0.v1().equals(var1) ? var0 : null;
   }

   @Nullable
   private sykyRecord6 v1() {
      try {
         Path var1 = this.v7.resolve("manifest.json");
         Path var2 = this.v7.resolve("manifest.json.sig");
         if (Files.isRegularFile(var1) && Files.isRegularFile(var2)) {
            if (Files.size(var1) <= 524288L && Files.size(var2) <= 4096L) {
               byte[] var3 = Files.readAllBytes(var1);
               if (!Ed25519Verifier.v1(var3, Files.readAllBytes(var2), this.v8)) {
                  v3.warn("the cached manifest is no longer signed by a trusted key — refetching");
                  return null;
               } else {
                  return sykyRecord6.v1(new String(var3, StandardCharsets.UTF_8));
               }
            } else {
               v3.debug("the cached manifest is not a plausible size — refetching");
               return null;
            }
         } else {
            return null;
         }
      } catch (IOException var4) {
         v3.debug("could not read the cached manifest", var4);
         return null;
      }
   }

   private void v1(byte[] var1, byte[] var2) {
      try {
         cloudSupport66.v1(this.v7.resolve("manifest.json"), var1);
         cloudSupport66.v1(this.v7.resolve("manifest.json.sig"), var2);
      } catch (IOException var4) {
         v3.debug("could not cache the manifest", var4);
      }
   }

   @Nullable
   public String v1(sykyRecord6.Part1 var1) {
      String var2 = v1(var1.v1());
      Path var3 = this.v7.resolve(var2);
      Path var4 = this.v7.resolve(var2 + "." + ProcessHandle.current().pid() + ".part");

      for (String var6 : v1(var1.v6())) {
         String var8;
         try {
            Files.createDirectories(this.v7);
            String var7 = this.v1(var6, var4, var1.v3());
            if (var7 == null) {
               continue;
            }

            if (!var7.equals(var1.v2())) {
               v3.warn("{} served a body whose digest does not match the signed manifest", var6);
               continue;
            }

            Files.move(var4, var3, StandardCopyOption.REPLACE_EXISTING);
            v3.info("staged {} from {}", var2, var6);
            var8 = var2;
         } catch (IOException var12) {
            v3.debug("download from {} failed", var6, var12);
            continue;
         } finally {
            v2(var4);
         }

         return var8;
      }

      return null;
   }

   public static String v1(String var0) {
      return "syky-" + var0.replaceAll("[^A-Za-z0-9._+-]", "_") + ".jar";
   }

   @Nullable
   private String v1(String var1, Path var2, long var3) throws IOException {
      if (var3 > 67108864L) {
         v3.warn("manifest declares {} bytes, above the {} byte ceiling", var3, 67108864L);
         return null;
      } else {
         HttpRequest var5 = HttpRequest.newBuilder(URI.create(var1)).timeout(UpdateKeys.v8).GET().build();

         HttpResponse var6;
         try {
            var6 = v4.send(var5, BodyHandlers.ofInputStream());
         } catch (InterruptedException var17) {
            Thread.currentThread().interrupt();
            return null;
         } catch (RuntimeException | IOException var18) {
            v3.debug("request to {} failed", var1, var18);
            return null;
         }

         if (var6.statusCode() != 200) {
            v3.debug("{} answered {}", var1, var6.statusCode());
            ((InputStream)var6.body()).close();
            return null;
         } else {
            MessageDigest var7 = v2();
            long var8 = 0L;

            try (
               InputStream var10 = (InputStream)var6.body();
               OutputStream var11 = Files.newOutputStream(var2, StandardOpenOption.CREATE, StandardOpenOption.WRITE, StandardOpenOption.TRUNCATE_EXISTING);
            ) {
               byte[] var12 = new byte[65536];

               int var13;
               while ((var13 = var10.read(var12)) > 0) {
                  var8 += var13;
                  if (var8 > 67108864L) {
                     v3.warn("{} exceeded the size ceiling mid-transfer", var1);
                     return null;
                  }

                  var7.update(var12, 0, var13);
                  var11.write(var12, 0, var13);
               }
            }

            if (var3 > 0L && var8 != var3) {
               v3.warn("{} delivered {} bytes, manifest declared {}", new Object[]{var1, var8, var3});
               return null;
            } else {
               v1(var2);
               return v2(var7.digest());
            }
         }
      }
   }

   @Nullable
   private byte[] v2(String var1) {
      UpdateManager.Part1 var2 = this.v1(var1 + ".sig", 4096L, null);
      byte[] var3 = var2 == null ? null : var2.v2;
      return var3 == null ? null : v1(var3);
   }

   @Nullable
   private UpdateManager.Part1 v1(String var1, long var2, @Nullable InternalSupport12.Part2 var4) {
      Builder var5 = HttpRequest.newBuilder(URI.create(var1)).timeout(UpdateKeys.v7).GET();
      if (var4 != null) {
         if (var4.v2() != null) {
            var5.header("If-None-Match", var4.v2());
         }

         if (var4.v3() != null) {
            var5.header("If-Modified-Since", var4.v3());
         }
      }

      try {
         HttpResponse var6 = v4.send(var5.build(), BodyHandlers.ofByteArray());
         int var7 = var6.statusCode();
         if (var7 == 304) {
            return new UpdateManager.Part1(true, null, null, null);
         } else if (var7 != 200) {
            v3.debug("{} answered {}", var1, var7);
            return null;
         } else {
            byte[] var8 = (byte[])var6.body();
            if (var8.length > var2) {
               v3.warn("{} returned {} bytes, past the {} byte ceiling", new Object[]{var1, var8.length, var2});
               return null;
            } else {
               return new UpdateManager.Part1(false, var8, v1(var6, "ETag"), v1(var6, "Last-Modified"));
            }
         }
      } catch (InterruptedException var9) {
         Thread.currentThread().interrupt();
         return null;
      } catch (RuntimeException | IOException var10) {
         v3.debug("request to {} failed", var1, var10);
         return null;
      }
   }

   @Nullable
   private static String v1(HttpResponse<byte[]> var0, String var1) {
      return var0.headers().firstValue(var1).filter(var0x -> !var0x.isBlank()).orElse(null);
   }

   private static byte[] v1(byte[] var0) {
      if (var0.length == 64) {
         return var0;
      } else {
         try {
            String var1 = new String(var0, StandardCharsets.US_ASCII).trim();
            byte[] var2 = Base64.getMimeDecoder().decode(var1);
            return var2.length == 64 ? var2 : var0;
         } catch (IllegalArgumentException var3) {
            return var0;
         }
      }
   }

   private static void v1(Path var0) throws IOException {
      try (FileChannel var1 = FileChannel.open(var0, StandardOpenOption.WRITE)) {
         var1.force(true);
      }
   }

   private static MessageDigest v2() {
      try {
         return MessageDigest.getInstance("SHA-256");
      } catch (NoSuchAlgorithmException var1) {
         throw new IllegalStateException("SHA-256 is mandated by the platform", var1);
      }
   }

   private static String v2(byte[] var0) {
      StringBuilder var1 = new StringBuilder(var0.length * 2);

      for (byte var5 : var0) {
         var1.append(Character.forDigit(var5 >> 4 & 15, 16)).append(Character.forDigit(var5 & 15, 16));
      }

      return var1.toString().toLowerCase(Locale.ROOT);
   }

   private static List<String> v1(List<String> var0) {
      LinkedHashSet var1 = new LinkedHashSet(var0);
      return new ArrayList<>(var1);
   }

   private static void v2(Path var0) {
      try {
         Files.deleteIfExists(var0);
      } catch (IOException var2) {
         v3.debug("could not remove {}", var0, var2);
      }
   }

   public static final class Part1 {
      public final boolean v1;
      @Nullable
      public final byte[] v2;
      @Nullable
      private final String v3;
      @Nullable
      private final String v4;

      public Part1(boolean var1, @Nullable byte[] var2, @Nullable String var3, @Nullable String var4) {
         this.v1 = var1;
         this.v2 = var2;
         this.v3 = var3;
         this.v4 = var4;
      }

      @Nullable
      public InternalSupport12.Part2 v1(String var1) {
         return this.v3 == null && this.v4 == null ? null : new InternalSupport12.Part2(var1, this.v3, this.v4);
      }
   }

   public record Part2(sykyRecord6 manifest, boolean changed, @Nullable InternalSupport12.Part2 validators) {
      public sykyRecord6 v1() {
         return this.manifest;
      }

      public boolean v2() {
         return this.changed;
      }

      @Nullable
      public InternalSupport12.Part2 v3() {
         return this.validators;
      }
   }
}
