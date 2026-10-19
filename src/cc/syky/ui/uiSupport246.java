package cc.syky.ui;

import java.io.IOException;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import org.jetbrains.annotations.Nullable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public final class uiSupport246 implements AutoCloseable {
   private static final Logger v2 = LoggerFactory.getLogger("syky.discord");
   public static final String v1 = "1537886217582940180";
   private static final String v3 = "syky.discordAppId";
   private static final long v4 = 1L;
   private static final long v5 = 5000L;
   private static final long v6 = 60000L;
   private static final long v7 = 4000L;
   private static final long v8 = 15000L;
   private static final long v9 = 1L;
   private final ScheduledExecutorService v10;
   private volatile DiscordRecord v11 = DiscordRecord.PLAIN;
   @Nullable
   private READYSupport v12;
   @Nullable
   private DiscordRecord v13;
   private long v14;
   private long v15;
   private long v16 = 5000L;
   private boolean v18;
   private boolean v19;
   private boolean v17;
   private volatile boolean v20;

   public uiSupport246() {
      this.v10 = Executors.newSingleThreadScheduledExecutor(var0 -> {
         Thread var1 = new Thread(var0, "syky-discord");
         var1.setDaemon(true);
         return var1;
      });
   }

   public void v1() {
      this.v10.scheduleWithFixedDelay(this::v2, 0L, 1L, TimeUnit.SECONDS);
   }

   public void v1(@Nullable String var1) {
      this.v11 = new DiscordRecord(var1);
   }

   private void v2() {
      try {
         this.v3();
      } catch (Throwable var2) {
         v2.debug("discord pump failed", var2);
      }
   }

   private void v3() {
      if (!this.v20) {
         boolean var1 = uiSupport245.v1();
         if (var1 != this.v17) {
            this.v17 = var1;
            if (var1) {
               this.v15 = 0L;
               this.v16 = 5000L;
            }
         }

         if (!var1) {
            this.v1(true);
         } else if (!this.v18) {
            long var2 = System.currentTimeMillis();
            if (this.v12 != null || this.v1(var2)) {
               this.v2(var2);
            }
         }
      }
   }

   private boolean v1(long var1) {
      if (var1 < this.v15) {
         return false;
      } else {
         try {
            READYSupport var3 = READYSupport.v1(v4());
            if (var3 == null) {
               if (!this.v19) {
                  this.v19 = true;
                  v2.debug("no Discord client is running; Rich Presence will connect when one is");
               }

               this.v3(var1);
               return false;
            } else {
               this.v12 = var3;
               this.v13 = null;
               this.v14 = 0L;
               this.v16 = 5000L;
               this.v19 = false;
               v2.info("Discord Rich Presence connected");
               return true;
            }
         } catch (READYSupport.Part1 var4) {
            this.v18 = true;
            v2.warn("Discord refused application id {} — Rich Presence is off for this session: {}", v4(), var4.getMessage());
            return false;
         } catch (RuntimeException | IOException var5) {
            v2.debug("connecting to Discord failed", var5);
            this.v3(var1);
            return false;
         }
      }
   }

   private void v2(long var1) {
      READYSupport var3 = this.v12;
      if (var3 != null) {
         DiscordRecord var4 = this.v11;
         boolean var5 = !var4.equals(this.v13);
         long var6 = var5 ? 4000L : 15000L;
         if (var1 - this.v14 >= var6) {
            try {
               var3.v1(var4);
               this.v13 = var4;
               this.v14 = var1;
            } catch (RuntimeException | IOException var9) {
               v2.debug("publishing the Discord presence failed", var9);
               this.v1(false);
               this.v3(var1);
            }
         }
      }
   }

   private void v3(long var1) {
      this.v15 = var1 + this.v16;
      this.v16 = Math.min(this.v16 * 2L, 60000L);
   }

   private void v1(boolean var1) {
      READYSupport var2 = this.v12;
      if (var2 != null) {
         this.v12 = null;
         this.v13 = null;
         if (var1) {
            try {
               var2.v1(null);
            } catch (RuntimeException | IOException var4) {
               v2.debug("clearing the Discord presence failed", var4);
            }
         }

         var2.close();
      }
   }

   private static String v4() {
      String var0 = System.getProperty("syky.discordAppId", "").trim();
      return var0.isEmpty() ? "1537886217582940180" : var0;
   }

   @Override
   public void close() {
      if (!this.v20) {
         this.v20 = true;
         this.v10.shutdownNow();
         boolean var1 = false;

         try {
            var1 = this.v10.awaitTermination(1L, TimeUnit.SECONDS);
         } catch (InterruptedException var3) {
            Thread.currentThread().interrupt();
         }

         if (var1) {
            this.v1(true);
         } else {
            v2.debug("discord pump did not stop in time — leaving the pipe to process exit");
         }
      }
   }
}
