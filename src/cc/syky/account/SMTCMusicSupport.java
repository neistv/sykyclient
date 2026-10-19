package cc.syky.account;

import cc.syky.sykyRecord7;
import cc.syky.sykyRecord8;
import cc.syky.internal.InternalSupport18;
import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.ProcessBuilder.Redirect;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.Map.Entry;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.ThreadPoolExecutor.AbortPolicy;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.Stream;
import java.util.zip.CRC32;
import net.minecraft.class_1011;
import net.minecraft.class_2960;
import net.minecraft.class_310;
import org.jetbrains.annotations.Nullable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public final class SMTCMusicSupport implements AutoCloseable, InternalSupport18 {
   private static final Logger v2 = LoggerFactory.getLogger("syky.music.winrt");
   private static final String v3 = "/cc/syky/ui/hud/elements/musicplayer/syky-media.exe";
   private static final int v4 = 10;
   private static final int v5 = 256;
   private static final long v6 = 3000L;
   private static final long v7 = 750L;
   private static final long v8 = 250000000L;
   private static final long v9 = 2500000000L;
   private static final int v10 = 500;
   private static final long v11 = 1000000000L;
   private static final long v12 = 15000000000L;
   private static final long v13 = 2500000000L;
   private static final long v14 = 6000000000L;
   private static final long v15 = 3000000000L;
   private static final long v16 = 5000000000L;
   private static final long v18 = 5000L;
   private static final int v19 = 5;
   private static final long v17 = TimeUnit.MINUTES.toNanos(10L);
   private static final long v20 = 250L;
   private static final long v21 = 8000L;
   private final Path v22;
   private final Thread v24;
   private final CountDownLatch v25 = new CountDownLatch(1);
   @Nullable
   private volatile Process v26;
   private final AtomicReference<SMTCMusicSupport.Part1> v27 = new AtomicReference<>();
   private final Map<Integer, class_2960> v28 = new LinkedHashMap<>(16, 0.75F, false);
   private final Set<Integer> v29 = ConcurrentHashMap.newKeySet();
   private final accountSupport2 v30 = new accountSupport2(() -> {
      SMTCMusicSupport.Part1 var1x = this.v27.get();
      return var1x == null ? null : var1x.v10;
   });
   private final ThreadPoolExecutor v32 = new ThreadPoolExecutor(1, 1, 0L, TimeUnit.MILLISECONDS, new ArrayBlockingQueue<>(8), var0 -> {
      Thread var1x = new Thread(var0, "syky-music-tx");
      var1x.setDaemon(true);
      return var1x;
   }, new AbortPolicy());
   private volatile boolean v23;
   private String v33 = "";
   private final AtomicReference<SMTCMusicSupport.Part2> v31 = new AtomicReference<>();
   private volatile long v34;
   private volatile long v36;
   private volatile long v38 = System.nanoTime();
   private final AtomicBoolean v42 = new AtomicBoolean();
   private volatile long v43 = System.nanoTime();
   private final AtomicBoolean v37 = new AtomicBoolean();
   private volatile boolean v48;
   private final Map<String, Long> v40 = new ConcurrentHashMap<>();
   private volatile long v44;
   private volatile float[] v47 = new float[6];
   private volatile long v49;

   @Nullable
   public static SMTCMusicSupport v1(Path var0) {
      String var1 = System.getProperty("os.name", "").toLowerCase(Locale.ROOT);
      if (!var1.startsWith("windows")) {
         v2.info("SMTC music bridge requires Windows; skipping (os={})", var1);
         return null;
      } else {
         SMTCMusicSupport var2;
         try {
            var2 = new SMTCMusicSupport(v2(var0));
            var2.v26 = var2.v7();
         } catch (IOException var6) {
            v2.warn("failed to start the SMTC music bridge", var6);
            return null;
         }

         var2.v24.start();

         boolean var3;
         try {
            var3 = var2.v25.await(5000L, TimeUnit.MILLISECONDS);
         } catch (InterruptedException var5) {
            Thread.currentThread().interrupt();
            var3 = false;
         }

         if (var3 && !var2.v48) {
            v2.info("SMTC music bridge started (helper pid {})", var2.v8());
            return var2;
         } else {
            v2.warn("SMTC music bridge did not answer; music card disabled for this session");
            var2.close();
            return null;
         }
      }
   }

   private SMTCMusicSupport(Path var1) {
      this.v22 = var1;
      this.v24 = new Thread(this::v9, "syky-music-reader");
      this.v24.setDaemon(true);
   }

   private Process v7() throws IOException {
      ProcessBuilder var1 = new ProcessBuilder(this.v22.toString());
      var1.redirectError(Redirect.DISCARD);
      Process var2 = var1.start();
      this.v43 = System.nanoTime();
      this.v42.set(false);
      this.v37.set(false);
      return var2;
   }

   private long v8() {
      Process var1 = this.v26;
      return var1 == null ? -1L : var1.pid();
   }

   private static Path v2(Path var0) throws IOException {
      byte[] var1;
      try (InputStream var2 = SMTCMusicSupport.class.getResourceAsStream("/cc/syky/ui/hud/elements/musicplayer/syky-media.exe")) {
         if (var2 == null) {
            throw new IOException("resource not found: /cc/syky/ui/hud/elements/musicplayer/syky-media.exe");
         }

         var1 = var2.readAllBytes();
      }

      CRC32 var9 = new CRC32();
      var9.update(var1);
      Files.createDirectories(var0);
      Path var3 = var0.resolve(String.format(Locale.ROOT, "syky-media-%08x.exe", var9.getValue()));
      if (!Files.isRegularFile(var3) || Files.size(var3) != var1.length) {
         Path var4 = Files.createTempFile(var0, "syky-media-", ".tmp");

         try {
            Files.write(var4, var1);
            Files.move(var4, var3, StandardCopyOption.ATOMIC_MOVE, StandardCopyOption.REPLACE_EXISTING);
         } catch (IOException var7) {
            Files.deleteIfExists(var4);
            if (!Files.isRegularFile(var3) || Files.size(var3) != var1.length) {
               throw var7;
            }
         }
      }

      v1(var0, var3);
      return var3;
   }

   private static void v1(Path var0, Path var1) {
      try (Stream var2 = Files.list(var0)) {
         var2.filter(var1x -> !var1x.equals(var1)).forEach(SMTCMusicSupport::v3);
      } catch (IOException var7) {
      }
   }

   private static void v3(Path var0) {
      if (Files.isDirectory(var0)) {
         try (Stream var1 = Files.list(var0)) {
            var1.forEach(SMTCMusicSupport::v3);
         } catch (IOException var7) {
         }
      }

      try {
         Files.deleteIfExists(var0);
      } catch (IOException var4) {
      }
   }

   private void v9() {
      ArrayDeque var1 = new ArrayDeque();
      long var2 = 250L;

      while (!this.v23) {
         Process var4 = this.v26;
         if (var4 != null) {
            this.v1(var4);
         }

         if (this.v23 || this.v48) {
            return;
         }

         Integer var5 = v2(var4);
         if (this.v25.getCount() > 0L) {
            v2.warn("syky-media exited before it was ready (code {})", var5);
            this.v48 = true;
            this.v25.countDown();
            return;
         }

         if (var5 != null && var5 == 2) {
            v2.info("syky-media found no system media controls; music card disabled for this session");
            this.v27.set(null);
            return;
         }

         long var6 = System.nanoTime();
         var1.addLast(var6);

         while (!var1.isEmpty() && var6 - var1.peekFirst() > v17) {
            var1.removeFirst();
         }

         if (var1.size() > 5) {
            v2.warn("syky-media keeps exiting (last code {}); music card disabled for this session", var5);
            this.v27.set(null);
            return;
         }

         v2.warn("syky-media exited (code {}); restarting in {} ms", var5, var2);
         if (var2 * 1000000L >= 2500000000L) {
            this.v27.set(null);
         }

         try {
            Thread.sleep(var2);
         } catch (InterruptedException var10) {
            return;
         }

         var2 = Math.min(var2 * 2L, 8000L);
         if (this.v23) {
            return;
         }

         try {
            this.v26 = this.v7();
         } catch (IOException var9) {
            v2.debug("syky-media restart failed", var9);
            this.v26 = null;
         }
      }
   }

   private void v1(Process var1) {
      try (DataInputStream var2 = new DataInputStream(new BufferedInputStream(var1.getInputStream(), 65536))) {
         Object var3;
         while (!this.v23 && (var3 = accountSupport.v1(var2)) != null) {
            this.v43 = System.nanoTime();
            switch (var3) {
               case accountSupport.Part1 var6:
                  if (var6.v1() != 3) {
                     v2.warn("syky-media speaks protocol {}, this client {}", var6.v1(), 3);
                     this.v48 = true;
                     var1.destroyForcibly();
                  }

                  this.v25.countDown();
                  if (!this.v48) {
                     break;
                  }

                  return;
               case accountSupport.Part5 var7:
                  this.v1(var7);
                  this.v10();
                  break;
               case accountSupport.Part4 var8:
                  this.v1(var8);
                  break;
               case accountSupport.Part3 var9:
                  this.v1(var9);
                  break;
               case accountSupport.Part8 var10:
                  this.v1(var10.v1());
                  break;
               case accountSupport.Part6 var11:
                  v2.debug("syky-media: {}", var11.v1());
                  break;
               case accountSupport.Part7 var12:
                  v2.debug("syky-media: skipped a frame of unknown kind {}", var12.v1());
                  break;
               default:
                  throw new MatchException(null, null);
            }
         }

         return;
      } catch (RuntimeException | IOException var15) {
         if (!this.v23) {
            v2.debug("syky-media stream ended", var15);
         }
      }
   }

   @Nullable
   private static Integer v2(@Nullable Process var0) {
      if (var0 == null) {
         return null;
      } else {
         try {
            if (var0.waitFor(1L, TimeUnit.SECONDS)) {
               return var0.exitValue();
            }
         } catch (InterruptedException var2) {
            Thread.currentThread().interrupt();
         }

         var0.destroyForcibly();
         return null;
      }
   }

   private void v10() {
      if (System.nanoTime() - this.v38 > 3000000000L && this.v42.compareAndSet(false, true)) {
         this.v2("idle");
      }
   }

   private void v1(accountSupport.Part5 var1) {
      SMTCMusicSupport.Part1 var2 = this.v27.get();
      if (var1.v1() && !var1.v10().isEmpty()) {
         String var3 = var1.v10();
         String var4 = var1.v11();
         String var5 = var3 + "||" + var4;
         boolean var6 = var2 != null && Objects.equals(var2.v1, var3) && Objects.equals(var2.v2, var4);
         if (var2 != null && !var6) {
            this.v31.set(null);
         }

         SMTCMusicSupport.Part1 var7 = new SMTCMusicSupport.Part1();
         var7.v1 = var3;
         var7.v2 = var4;
         var7.v7 = this.v1(!var1.v2());
         var7.v8 = var1.v4() && var1.v2() && !var1.v5();
         boolean var8 = false;
         if (var1.v8() == 2) {
            var7.v12 = var1.v9();
            var7.v11 = true;
            synchronized (this.v28) {
               var7.v10 = this.v28.get(var1.v9());
            }

            var8 = var7.v10 == null && !this.v29.contains(var1.v9());
         } else if (var1.v8() != 1) {
            var8 = true;
         }

         if (var7.v10 == null && var6 && var2 != null && var2.v10 != null) {
            var7.v10 = var2.v10;
         }

         if (var7.v10 == null && var8) {
            var7.v10 = this.v30.v1(var3, var4);
         }

         Long var15 = this.v40.get(var5);
         var7.v3 = var1.v6() > 0L ? var1.v6() : (var15 == null ? 0L : var15);
         if (var7.v3 > 0L) {
            this.v40.put(var5, var7.v3);
            if (this.v40.size() > 256) {
               this.v1(var5);
            }
         }

         var7.v9 = var1.v3();
         long var10 = var1.v7();
         var7.v4 = var10;
         long var12 = System.nanoTime();
         if (!var6 || var2 == null) {
            this.v36 = 0L;
            var7.v5 = var10;
            var7.v6 = var12;
         } else if (var2.v7 != var7.v7) {
            if (var7.v7) {
               var7.v5 = v1(var2, var12);
            } else {
               var7.v5 = var10;
            }

            var7.v6 = var12;
         } else if (var2.v8 != var7.v8) {
            var7.v5 = var1.v4() ? var10 : v1(var2, var12);
            var7.v6 = var12;
         } else if (Math.abs(var10 - var2.v4) > 3000L) {
            if (var2.v13 && Math.abs(var10 - var2.v14) <= 3000L) {
               var7.v5 = var10;
               var7.v6 = var12;
               this.v36 = 0L;
            } else {
               var7.v13 = true;
               var7.v14 = var10;
               var7.v5 = var2.v5;
               var7.v6 = var2.v6;
            }
         } else if (this.v1(var12, var10)) {
            var7.v5 = var10;
            var7.v6 = var12;
         } else if (var1.v4() && var7.v7 == !var1.v2() && (this.v36 == 0L || var12 >= this.v36) && Math.abs(var10 - v1(var2, var12)) > 750L) {
            var7.v5 = var10;
            var7.v6 = var12;
         } else {
            var7.v5 = var2.v5;
            var7.v6 = var2.v6;
         }

         this.v1(var7);
         this.v44 = System.nanoTime();
         if (!var5.equals(this.v33)) {
            this.v33 = var5;
            v2.info(
               "music: track changed: title='{}' artist='{}' duration={}s artwork={} owner='{}'",
               new Object[]{var3, var4, var7.v3 / 1000L, var7.v10 != null, var1.v12()}
            );
         }
      } else if (var2 == null || System.nanoTime() - this.v44 >= 2500000000L) {
         this.v27.set(null);
      }
   }

   private static long v1(SMTCMusicSupport.Part1 var0, long var1) {
      return !var0.v7 && !var0.v8 ? var0.v5 + (var1 - var0.v6) / 1000000L : var0.v5;
   }

   private void v1(SMTCMusicSupport.Part1 var1) {
      boolean var2 = var1.v7;
      this.v27.updateAndGet(var3 -> {
         SMTCMusicSupport.Part2 var4 = this.v1(System.nanoTime());
         var1.v7 = var4 != null ? var4.v1() : var2;
         return var1;
      });
   }

   private boolean v1(boolean var1) {
      SMTCMusicSupport.Part2 var2 = this.v1(System.nanoTime());
      if (var2 == null) {
         return var1;
      } else if (var1 == var2.v1()) {
         this.v31.compareAndSet(var2, null);
         return var1;
      } else {
         return var2.v1();
      }
   }

   @Nullable
   private SMTCMusicSupport.Part2 v1(long var1) {
      SMTCMusicSupport.Part2 var3 = this.v31.get();
      return var3 != null && var1 < var3.v2() ? var3 : null;
   }

   private boolean v1(long var1, long var3) {
      long var5 = this.v36;
      if (var5 != 0L && var1 >= var5) {
         this.v36 = 0L;
         return Math.abs(var3 - this.v34) > 3000L;
      } else {
         return false;
      }
   }

   private void v1(accountSupport.Part3 var1) {
      long var2 = System.nanoTime();
      if (var1.v1() == 3 && this.v36 != 0L) {
         if (var1.v2()) {
            this.v36 = var2 + 6000000000L;
         } else {
            this.v36 = 0L;
            this.v27.updateAndGet(var2x -> {
               if (var2x == null) {
                  return null;
               } else {
                  SMTCMusicSupport.Part1 var3 = var2x.v1();
                  var3.v5 = var2x.v4;
                  var3.v6 = var2;
                  return var3;
               }
            });
         }
      } else if (var1.v1() == 0) {
         if (var1.v2()) {
            this.v31.updateAndGet(var2x -> var2x == null ? null : new SMTCMusicSupport.Part2(var2x.v1(), Math.max(var2x.v2(), var2 + 15000000000L)));
         } else {
            this.v31.set(null);
         }
      }
   }

   private void v1(String var1) {
      Long var2 = this.v40.get(var1);
      this.v40.clear();
      if (var2 != null) {
         this.v40.put(var1, var2);
      }
   }

   private void v1(accountSupport.Part4 var1) {
      if (var1.v2().length >= 500) {
         boolean var2;
         synchronized (this.v28) {
            var2 = this.v28.containsKey(var1.v1());
         }

         if (!var2) {
            this.v1(var1.v2(), var1.v1());
         }
      }
   }

   private void v1(byte[] var1, int var2) {
      class_310 var3 = class_310.method_1551();
      if (var3 != null && this.v29.add(var2)) {
         List var4;
         try {
            var4 = accountSupport3.v1(class_1011.method_4309(new ByteArrayInputStream(var1)));
         } catch (Exception var7) {
            this.v29.remove(var2);
            v2.info("winrt music: NativeImage.read FAILED on {} bytes: {}", var1.length, var7.toString());
            return;
         }

         String var5 = Integer.toHexString(var2);
         class_2960 var6 = class_2960.method_60655("syky", "music_art/" + var5);
         var3.execute(() -> {
            try {
               accountSupport3.v1(var6, var4, "music_art_" + var5);
               this.v1(var2, var6);
            } catch (Throwable var9) {
               v2.debug("artwork texture registration failed", var9);
            } finally {
               this.v29.remove(var2);
            }
         });
      }
   }

   private void v1(int var1, class_2960 var2) {
      synchronized (this.v28) {
         if (this.v28.size() >= 10) {
            this.v11();
         }

         this.v28.put(var1, var2);
      }

      this.v27.updateAndGet(var2x -> {
         if (var2x != null && var2x.v11 && var2x.v12 == var1 && !var2.equals(var2x.v10)) {
            SMTCMusicSupport.Part1 var3 = var2x.v1();
            var3.v10 = var2;
            return var3;
         } else {
            return var2x;
         }
      });
   }

   private void v11() {
      SMTCMusicSupport.Part1 var1 = this.v27.get();
      class_2960 var2 = var1 == null ? null : var1.v10;

      for (Entry var4 : this.v28.entrySet()) {
         if (!((class_2960)var4.getValue()).equals(var2)) {
            this.v28.remove(var4.getKey());
            v1((class_2960)var4.getValue());
            return;
         }
      }
   }

   private static void v1(class_2960 var0) {
      if (var0 != null) {
         class_310 var1 = class_310.method_1551();
         if (var1 != null) {
            var1.execute(() -> {
               try {
                  accountSupport3.v1(var0);
               } catch (Throwable var2) {
                  v2.debug("artwork texture destroy failed", var2);
               }
            });
         }
      }
   }

   @Nullable
   @Override
   public sykyRecord8 v1() {
      long var1 = System.nanoTime();
      this.v38 = var1;
      if (this.v42.get() && this.v42.compareAndSet(true, false)) {
         this.v43 = var1;
         this.v2("active");
      } else if (var1 - this.v43 > 5000000000L && this.v37.compareAndSet(false, true)) {
         this.v12();
      }

      SMTCMusicSupport.Part1 var3 = this.v27.get();
      if (var3 == null) {
         return null;
      } else if (var3.v1 != null && !var3.v1.isEmpty()) {
         long var4 = var1 - var3.v6;
         double var6 = !var3.v7 && !var3.v8 ? var4 * 1.0E-9 : 0.0;
         float var8 = (float)(var3.v5 / 1000.0 + var6);
         int var9 = (int)Math.round(var3.v3 / 1000.0);
         sykyRecord7 var10 = new sykyRecord7(var3.v1, var3.v2, var9, var3.v10);
         return sykyRecord8.v1(var10, var8, var3.v7);
      } else {
         return null;
      }
   }

   private void v12() {
      Process var1 = this.v26;
      if (var1 != null && !this.v23) {
         v2.warn("syky-media stopped answering; replacing it");
         this.v1(var1::destroyForcibly);
      }
   }

   private void v1(byte[] var1) {
      if (var1.length != 0) {
         float[] var2 = new float[6];

         for (int var3 = 0; var3 < 6; var3++) {
            var2[var3] = Byte.toUnsignedInt(var1[var1.length == 6 ? var3 : 0]) / 255.0F;
         }

         this.v47 = var2;
         this.v49 = System.nanoTime();
      }
   }

   @Override
   public boolean v1(float[] var1) {
      if (System.nanoTime() - this.v49 >= 250000000L) {
         return false;
      } else {
         System.arraycopy(this.v47, 0, var1, 0, 6);
         return true;
      }
   }

   @Override
   public void v2() {
      if (this.v2("toggle")) {
         this.v13();
      }
   }

   @Override
   public void v3() {
      this.v31.set(null);
      this.v2("next");
   }

   @Override
   public void v4() {
      this.v31.set(null);
      this.v2("prev");
   }

   @Override
   public boolean v5() {
      SMTCMusicSupport.Part1 var1 = this.v27.get();
      return var1 != null && var1.v9 && var1.v3 > 0L;
   }

   @Override
   public void v1(float var1) {
      if (!this.v23) {
         SMTCMusicSupport.Part1 var2 = this.v27.get();
         if (var2 != null && var2.v3 > 0L) {
            long var3 = (long)(var1 * 1000.0F);
            if (var3 < 0L) {
               var3 = 0L;
            } else if (var3 > var2.v3) {
               var3 = var2.v3;
            }

            if (this.v2(accountSupport.v1(var3))) {
               this.v34 = var3;
               this.v36 = System.nanoTime() + 2500000000L;
               long var5 = var3;
               String var7 = var2.v1;
               String var8 = var2.v2;
               this.v27.updateAndGet(var4 -> {
                  if (var4 != null && Objects.equals(var4.v1, var7) && Objects.equals(var4.v2, var8)) {
                     SMTCMusicSupport.Part1 var5x = var4.v1();
                     var5x.v5 = var5;
                     var5x.v6 = System.nanoTime();
                     var5x.v13 = false;
                     return var5x;
                  } else {
                     return var4;
                  }
               });
            }
         }
      }
   }

   private boolean v2(String var1) {
      if (this.v23) {
         return false;
      } else {
         byte[] var2 = (var1 + "\n").getBytes(StandardCharsets.UTF_8);
         return this.v1((Runnable)(() -> {
            Process var3 = this.v26;
            if (var3 != null) {
               try {
                  OutputStream var4 = var3.getOutputStream();
                  var4.write(var2);
                  var4.flush();
               } catch (IOException var5) {
                  v2.debug("syky-media command '{}' not delivered", var1, var5);
               }
            }
         }));
      }
   }

   private boolean v1(Runnable var1) {
      try {
         this.v32.execute(var1);
         return true;
      } catch (RejectedExecutionException var3) {
         v2.debug("music transport queue full; command dropped");
         return false;
      }
   }

   private void v13() {
      SMTCMusicSupport.Part1 var1 = this.v27.updateAndGet(var0 -> {
         if (var0 == null) {
            return null;
         } else {
            SMTCMusicSupport.Part1 var1x = var0.v1();
            var1x.v7 = !var0.v7;
            long var2 = System.nanoTime();
            var1x.v5 = v1(var0, var2);
            var1x.v6 = var2;
            return var1x;
         }
      });
      if (var1 != null) {
         this.v31.set(new SMTCMusicSupport.Part2(var1.v7, System.nanoTime() + 1000000000L));
      }
   }

   @Override
   public void close() {
      if (!this.v23) {
         this.v23 = true;
         this.v32.shutdownNow();
         Process var1 = this.v26;
         if (var1 != null) {
            try {
               var1.getOutputStream().close();
            } catch (IOException var7) {
            }

            try {
               if (!var1.waitFor(1L, TimeUnit.SECONDS)) {
                  var1.destroyForcibly();
               }
            } catch (InterruptedException var6) {
               Thread.currentThread().interrupt();
               var1.destroyForcibly();
            }
         }

         this.v24.interrupt();
         ArrayList var2;
         synchronized (this.v28) {
            var2 = new ArrayList<>(this.v28.values());
            this.v28.clear();
         }

         for (class_2960 var4 : var2) {
            v1(var4);
         }

         this.v30.close();
         v2.info("SMTC music bridge stopped");
      }
   }

   public static final class Part1 {
      @Nullable
      public String v1;
      @Nullable
      public String v2;
      public long v3;
      public long v4;
      public long v5;
      public long v6;
      public boolean v7;
      public boolean v8;
      public boolean v9;
      @Nullable
      public class_2960 v10;
      public boolean v11;
      public int v12;
      public boolean v13;
      public long v14;

      public Part1() {
      }

      public SMTCMusicSupport.Part1 v1() {
         SMTCMusicSupport.Part1 var1 = new SMTCMusicSupport.Part1();
         var1.v1 = this.v1;
         var1.v2 = this.v2;
         var1.v3 = this.v3;
         var1.v4 = this.v4;
         var1.v5 = this.v5;
         var1.v6 = this.v6;
         var1.v7 = this.v7;
         var1.v8 = this.v8;
         var1.v9 = this.v9;
         var1.v10 = this.v10;
         var1.v11 = this.v11;
         var1.v12 = this.v12;
         var1.v13 = this.v13;
         var1.v14 = this.v14;
         return var1;
      }
   }

   public record Part2(boolean paused, long untilNanos) {
      public boolean v1() {
         return this.paused;
      }

      public long v2() {
         return this.untilNanos;
      }
   }
}
