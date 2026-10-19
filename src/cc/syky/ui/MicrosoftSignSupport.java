package cc.syky.ui;

import cc.syky.account.AccountStore;
import cc.syky.account.MinecraftAccount;
import cc.syky.auth.MicrosoftAuth;
import cc.syky.cloud.cloudSupport58;
import cc.syky.cloud.cloudSupport63;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.google.gson.JsonParser;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Objects;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import java.util.function.Consumer;
import java.util.function.LongSupplier;
import java.util.function.UnaryOperator;
import org.jetbrains.annotations.Nullable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public final class MicrosoftSignSupport implements AutoCloseable {
   private static final Logger v4 = LoggerFactory.getLogger("syky.account");
   public static final long v1 = TimeUnit.HOURS.toMillis(6L);
   public static final long v2 = TimeUnit.MINUTES.toMillis(10L);
   public static final long v3 = TimeUnit.MINUTES.toMillis(30L);
   private static final long v5 = 5000L;
   private static final String v6 = "";
   private static final Gson v7 = new Gson();
   private final AccountStore v8;
   private final MicrosoftAuth v9;
   private final uiSupport270 v10;
   private final ScheduledExecutorService v11;
   private final Consumer<Runnable> v12;
   private final LongSupplier v13;
   private List<uiRecord16> v14 = List.of();
   private List<uiRecord16> v15 = List.of();
   private int v16;
   @Nullable
   private uiSupport270.Part3 v18;
   private String v19 = "launch";
   private int v17;
   private int v20;
   @Nullable
   private MicrosoftSignSupport.Part4 v21;
   private int v22;
   @Nullable
   private uiSupport269 v24;
   @Nullable
   private MicrosoftSignSupport.Part2 v25;
   @Nullable
   private TheSignSupport v26;
   private final uiSupport271 v27 = new uiSupport271();
   private boolean v28;
   private final AtomicReference<String> v29 = new AtomicReference<>();
   private boolean v30;
   private boolean v32;
   private long v23;
   @Nullable
   private String v33;
   @Nullable
   private String v31;
   private boolean v34;
   private boolean v36 = true;
   @Nullable
   private String v38;
   private boolean v42;
   private Set<String> v43 = Set.of();
   private volatile boolean v37;

   public MicrosoftSignSupport(AccountStore var1, MicrosoftAuth var2, uiSupport270 var3, Consumer<Runnable> var4, LongSupplier var5) {
      this(var1, var2, var3, var4, var5, v15());
   }

   public MicrosoftSignSupport(
      AccountStore var1, MicrosoftAuth var2, uiSupport270 var3, Consumer<Runnable> var4, LongSupplier var5, ScheduledExecutorService var6
   ) {
      this.v8 = var1;
      this.v9 = var2;
      this.v10 = var3;
      this.v12 = var4;
      this.v13 = var5;
      this.v11 = var6;
      this.v27.v1().setOnChange(this::v16);
   }

   private static ScheduledExecutorService v15() {
      ScheduledThreadPoolExecutor var0 = new ScheduledThreadPoolExecutor(1, var0x -> {
         Thread var1 = new Thread(var0x, "syky-accounts");
         var1.setDaemon(true);
         return var1;
      });
      var0.setExecuteExistingDelayedTasksAfterShutdownPolicy(false);
      return var0;
   }

   public void v1() {
      this.v17();
      this.v1(() -> {
         String var1 = null;

         try {
            var1 = this.v8.v1().orElse(null);
         } catch (IOException var6) {
            v4.warn("could not read the account page's options; keeping the defaults", var6);
         }

         String var2 = null;

         try {
            var2 = this.v8.v2().orElse(null);
         } catch (IOException var5) {
            v4.warn("could not read the remembered account; nothing is put back this start", var5);
         }

         String var3 = var1;
         String var4 = var2;
         this.v2(() -> {
            if (var3 != null) {
               this.v4(var3);
            }

            this.v31 = var4;
            this.v42 = this.v27.v5();
            this.v34 = true;
         });
      });
   }

   public uiSupport271 v2() {
      return this.v27;
   }

   private void v4(String var1) {
      if (!this.v37 && !this.v28) {
         try {
            if (JsonParser.parseString(var1) instanceof JsonObject var2) {
               this.v27.v1(var2);
               this.v22();
            }
         } catch (JsonParseException var4) {
            v4.warn("the account page's options cannot be read ({}); keeping the defaults", var4.getMessage());
         }
      }
   }

   private void v16() {
      this.v28 = true;
      if (this.v27.v5() != this.v42) {
         this.v42 = this.v27.v5();
         if (this.v42) {
            this.v18();
         } else {
            this.v7(null);
         }
      }

      this.v22();
      if (this.v29.getAndSet(v7.toJson(this.v27.v6())) == null) {
         this.v1(() -> {
            String var1 = this.v29.getAndSet(null);
            if (var1 != null) {
               try {
                  this.v8.v1(var1);
               } catch (IOException var3) {
                  v4.warn("could not save the account page's options", var3);
               }
            }
         });
      }
   }

   public int v3() {
      return this.v16;
   }

   public List<uiRecord16> v4() {
      return this.v15;
   }

   @Nullable
   public uiRecord16 v5() {
      for (uiRecord16 var2 : this.v15) {
         if (var2.v8()) {
            return var2;
         }
      }

      return null;
   }

   @Nullable
   public MicrosoftSignSupport.Part1 v6() {
      MicrosoftSignSupport.Part4 var1 = this.v21;
      return var1 == null ? null : var1.v6;
   }

   @Nullable
   public uiSupport269 v7() {
      return this.v24;
   }

   public boolean v8() {
      uiSupport270.Part3 var1 = this.v18;
      uiRecord16 var2 = this.v5();
      return var1 != null && var2 != null && (var2.v4() != var1.v3() || !var2.v6().equals(var1.v2()));
   }

   @Nullable
   public TheSignSupport v9() {
      return this.v26;
   }

   public void v10() {
      if (this.v26 != null) {
         this.v26 = null;
         this.v22();
      }
   }

   public void v1(String var1) {
      if (!this.v37) {
         uiRecord16 var2 = this.v9(var1);
         if (var2 == null) {
            this.v2(TheSignSupport.NOT_FOUND);
         } else {
            this.v26 = null;
            if (var2.v8()) {
               if (this.v21 != null) {
                  this.v21 = null;
                  this.v22++;
               }

               this.v22();
            } else if (var2.v10()) {
               this.v2(TheSignSupport.SIGN_IN_AGAIN);
            } else if (this.v21 != null && this.v21.v2.equals(var1)) {
               this.v22();
            } else {
               int var3 = ++this.v22;
               this.v21 = new MicrosoftSignSupport.Part4(var3, var1);
               this.v22();
               this.v1(var3, var1);
            }
         }
      }
   }

   public void v11() {
      uiSupport270.Part3 var1 = this.v18;

      for (uiRecord16 var3 : this.v15) {
         if (!var3.v7() || var1 != null && var3.v4() == var1.v3() && var3.v6().equals(var1.v2())) {
            this.v1(var3.v3());
            return;
         }
      }
   }

   public MicrosoftSignSupport.Part3 v2(String var1) {
      String var2 = uiSupport267.v1(var1);
      if (var2 == null) {
         return new MicrosoftSignSupport.Part3(null, TheSignSupport.INVALID_NAME);
      } else if (this.v5(var2, null)) {
         return new MicrosoftSignSupport.Part3(null, TheSignSupport.DUPLICATE);
      } else {
         String var3 = v21();
         long var4 = this.v13.getAsLong();
         MinecraftAccount var6 = MinecraftAccount.v1(var3, var2, uiSupport267.v2(var2), var4);
         uiRecord16 var7 = v2(var6);
         ArrayList var8 = new ArrayList<>(this.v14);
         var8.add(var7);
         int var9 = this.v1(var8);
         this.v1(var9, var2x -> {
            for (MinecraftAccount var4x : var2x) {
               if (var4x.v3() == uiSupport272.OFFLINE && var4x.v4().equalsIgnoreCase(var2)) {
                  return var2x;
               }
            }

            ArrayList var5 = new ArrayList(var2x);
            var5.add(var6);
            return var5;
         });
         return new MicrosoftSignSupport.Part3(var7, null);
      }
   }

   public uiSupport269 v12() {
      uiSupport269 var1 = this.v24;
      if (var1 != null && !var1.v2()) {
         return var1;
      } else {
         uiSupport269 var2 = new uiSupport269(this);
         MicrosoftSignSupport.Part2 var3 = new MicrosoftSignSupport.Part2(var2);
         this.v24 = var2;
         this.v25 = var3;
         this.v26 = null;
         this.v22();
         this.v1(() -> this.v1(var3));
         return var2;
      }
   }

   public void v3(String var1) {
      uiRecord16 var2 = this.v9(var1);
      if (var2 != null && var2.v1()) {
         if (this.v21 != null && this.v21.v2.equals(var1)) {
            this.v21 = null;
            this.v22++;
         }

         if (var1.equals(this.v31)) {
            this.v7(null);
         }

         ArrayList var3 = new ArrayList<>(this.v14);
         var3.removeIf(var1x -> var1x.v3().equals(var1));
         int var4 = this.v1(var3);
         this.v1(var4, var1x -> {
            ArrayList var2x = new ArrayList(var1x);
            var2x.removeIf(var1xx -> var1xx.v2().equals(var1));
            return var2x;
         });
      }
   }

   public void v1(String var1, int var2) {
      int var3 = v1(this.v14, var1);
      if (var3 >= 0) {
         ArrayList var4 = new ArrayList<>(this.v14);
         uiRecord16 var5 = (uiRecord16)var4.remove(var3);
         int var6 = Math.max(0, Math.min(var2, var4.size()));
         var4.add(var6, var5);
         if (!var4.equals(this.v14)) {
            ArrayList var7 = new ArrayList(var4.size());

            for (uiRecord16 var9 : var4) {
               var7.add(var9.v3());
            }

            int var10 = this.v1(var4);
            this.v1(var10, var1x -> v1(var1x, var7));
         }
      }
   }

   @Nullable
   public TheSignSupport v1(String var1, String var2) {
      uiRecord16 var3 = this.v9(var1);
      if (var3 == null) {
         return TheSignSupport.NOT_FOUND;
      } else if (!var3.v2()) {
         return TheSignSupport.FAILED;
      } else {
         String var4 = uiSupport267.v1(var2);
         if (var4 == null) {
            return TheSignSupport.INVALID_NAME;
         } else if (var4.equals(var3.v5())) {
            return null;
         } else if (this.v5(var4, var1)) {
            return TheSignSupport.DUPLICATE;
         } else {
            UUID var5 = uiSupport267.v2(var4);
            if (var1.equals(this.v19)) {
               this.v19 = "";
            }

            if (this.v21 != null && this.v21.v2.equals(var1)) {
               this.v21 = null;
               this.v22++;
            }

            ArrayList var6 = new ArrayList<>(this.v14);
            int var7 = v1(var6, var1);
            uiRecord16 var8 = (uiRecord16)var6.get(var7);
            var6.set(var7, var8.v1(var4, var5));
            int var9 = this.v1(var6);
            this.v1(var9, var3x -> {
               ArrayList var4x = new ArrayList(var3x);

               for (int var5x = 0; var5x < var4x.size(); var5x++) {
                  if (((MinecraftAccount)var4x.get(var5x)).v2().equals(var1)) {
                     var4x.set(var5x, ((MinecraftAccount)var4x.get(var5x)).v1(var4).v1(var5));
                  }
               }

               return var4x;
            });
            return null;
         }
      }
   }

   public void v1(String var1, boolean var2) {
      int var3 = v1(this.v14, var1);
      if (var3 >= 0 && this.v14.get(var3).v16() != var2) {
         ArrayList var4 = new ArrayList<>(this.v14);
         var4.set(var3, ((uiRecord16)var4.get(var3)).v1(var2));
         int var5 = this.v1(var4);
         this.v1(var5, var2x -> v1(var2x, var1, var1xx -> var1xx.v1(var2)));
      }
   }

   public void v2(String var1, @Nullable String var2) {
      int var3 = v1(this.v14, var1);
      String var4 = cloudSupport58.v1(var2);
      if (var3 >= 0 && !Objects.equals(this.v14.get(var3).v18(), var4)) {
         ArrayList var5 = new ArrayList<>(this.v14);
         var5.set(var3, ((uiRecord16)var5.get(var3)).v1(var4));
         int var6 = this.v1(var5);
         this.v1(var6, var2x -> v1(var2x, var1, var1xx -> var1xx.v2(var4)));
      }
   }

   public void v13() {
      this.v17();
   }

   public void v14() {
      if (this.v18 == null) {
         uiSupport270.Part3 var1 = this.v10.v1();
         if (var1 != null) {
            this.v18 = var1;
            this.v20();
         }
      }

      uiSupport270.Part2 var3 = this.v10.v2();
      if (this.v36) {
         this.v1(var3);
      }

      this.v2(var3);
      MicrosoftSignSupport.Part4 var2 = this.v21;
      if (var2 != null && var2.v3 != null && var3 == uiSupport270.Part2.MENU) {
         if (this.v13.getAsLong() - var2.v5 > v3) {
            var2.v1(null);
            this.v22();
            this.v1(var2.v1, var2.v2);
         } else {
            this.v1(var2);
         }
      }
   }

   @Override
   public void close() {
      this.v1(() -> this.v8.v3().v1(Set.of()));
      this.v37 = true;
      MicrosoftSignSupport.Part2 var1 = this.v25;
      if (var1 != null) {
         var1.v2 = true;
      }

      this.v11.shutdown();

      try {
         if (!this.v11.awaitTermination(2L, TimeUnit.SECONDS)) {
            this.v11.shutdownNow();
         }
      } catch (InterruptedException var3) {
         this.v11.shutdownNow();
         Thread.currentThread().interrupt();
      }
   }

   private void v1(int var1, String var2) {
      this.v1(() -> {
         try {
            uiRecord15 var3 = this.v5(var2);
            uiSupport270.Part1 var4 = this.v10.v1(var3);
            String var5 = var3.v2() == uiRecord15.Part1.MICROSOFT ? "mojang" : null;
            this.v2(() -> this.v1(var1, var4, var5));
         } catch (uiSupport265 var6) {
            v4.warn("switch to {} failed: {}", var2, var6.getMessage());
            if (var6.v1() == TheSignSupport.SIGN_IN_AGAIN) {
               this.v6(var2);
            }

            this.v2(() -> this.v1(var1, var6.v1()));
         } catch (IOException var7) {
            v4.warn("switch to {} failed: the account file could not be read", var2, var7);
            this.v2(() -> this.v1(var1, TheSignSupport.STORAGE));
         } catch (Throwable var8) {
            v4.warn("switch to {} failed", var2, var8);
            this.v2(() -> this.v1(var1, TheSignSupport.FAILED));
         }
      });
   }

   private uiRecord15 v5(String var1) throws uiSupport265, IOException {
      if ("launch".equals(var1)) {
         return uiRecord15.v1();
      } else {
         MinecraftAccount var2 = v2(this.v8.v4(), var1);
         if (var2 == null) {
            throw new uiSupport265(TheSignSupport.NOT_FOUND, 0, "account " + var1 + " is no longer saved");
         } else if (var2.v3() == uiSupport272.OFFLINE) {
            return uiRecord15.v1(var2.v4());
         } else {
            MinecraftAccount var3 = this.v1(var2);
            String var4 = var3.v14();
            if (var4 == null) {
               throw new uiSupport265(TheSignSupport.SIGN_IN_AGAIN, 0, "no Minecraft token after renewal");
            } else {
               return uiRecord15.v1(var3.v4(), var3.v5(), var4);
            }
         }
      }
   }

   private MinecraftAccount v1(MinecraftAccount var1) throws uiSupport265, IOException {
      String var2 = var1.v13();
      if (!var1.v16() && var2 != null) {
         long var3 = this.v13.getAsLong();
         String var5 = var1.v14();
         boolean var6 = var5 != null && var1.v15() - var3 > v2;
         if (var5 != null && var1.v15() - var3 > v1) {
            try {
               MicrosoftAuth.Part1 var12 = this.v9.v3(var5);
               return this.v1(var1, var12);
            } catch (uiSupport265 var11) {
               if (var11.v1() == TheSignSupport.NO_MINECRAFT || var11.v1() == TheSignSupport.NO_PROFILE) {
                  throw var11;
               }
            }

            if (!var11.v2()) {
               return var1;
            }
         }

         try {
            MicrosoftAuth.Part6 var7 = this.v9.v1(var2);
            MicrosoftAuth.Part7 var8 = this.v9.v2(var7.v1());
            MicrosoftAuth.Part1 var9 = this.v9.v3(var8.v1());
            return this.v1(var1.v2(), var7, var8, var9);
         } catch (uiSupport265 var10) {
            if (var6 && v1(var10.v1())) {
               v4.info("could not renew {}'s token ({}); its saved one still has time, using it", var1.v4(), var10.getMessage());
               return var1;
            } else {
               throw var10;
            }
         }
      } else {
         throw new uiSupport265(TheSignSupport.SIGN_IN_AGAIN, 0, "the account has to be signed in again");
      }
   }

   private static boolean v1(TheSignSupport var0) {
      return var0 == TheSignSupport.NETWORK || var0 == TheSignSupport.SERVICE || var0 == TheSignSupport.RATE_LIMITED;
   }

   private MinecraftAccount v1(MinecraftAccount var1, MicrosoftAuth.Part1 var2) throws IOException {
      if (var1.v4().equals(var2.v2()) && Objects.equals(var1.v11(), var2.v3()) && var1.v12() == var2.v4()) {
         return var1;
      } else {
         MinecraftAccount[] var3 = new MinecraftAccount[]{var1.v1(var2.v2(), var2.v3(), var2.v4())};
         List var4 = this.v8.v1(var3x -> v1(var3x, var1.v2(), var2xx -> {
            var3[0] = var2xx.v1(var2.v2(), var2.v3(), var2.v4());
            return var3[0];
         }));
         this.v1(var4, -1);
         return var3[0];
      }
   }

   private MinecraftAccount v1(String var1, MicrosoftAuth.Part6 var2, MicrosoftAuth.Part7 var3, MicrosoftAuth.Part1 var4) throws IOException, uiSupport265 {
      MinecraftAccount[] var5 = new MinecraftAccount[]{null};
      List var6 = this.v8.v1(var5x -> v1(var5x, var1, var4xx -> {
         var5[0] = var4xx.v1(var2.v2(), var3.v1(), var3.v2()).v1(var4.v2(), var4.v3(), var4.v4());
         return var5[0];
      }));
      this.v1(var6, -1);
      MinecraftAccount var7 = var5[0];
      if (var7 == null) {
         throw new uiSupport265(TheSignSupport.NOT_FOUND, 0, "account " + var1 + " was removed while signing in");
      } else {
         return var7;
      }
   }

   private void v6(String var1) {
      try {
         List var2 = this.v8.v1(var1x -> v1(var1x, var1, MinecraftAccount::v1));
         this.v1(var2, -1);
      } catch (IOException var3) {
         v4.warn("could not mark account {} as signed out", var1, var3);
      }
   }

   private void v1(int var1, uiSupport270.Part1 var2, @Nullable String var3) {
      MicrosoftSignSupport.Part4 var4 = this.v21;
      if (var4 != null && var4.v1 == var1 && !this.v37) {
         var4.v1(var2);
         var4.v4 = var3;
         var4.v5 = this.v13.getAsLong();
         if (this.v10.v2() == uiSupport270.Part2.MENU) {
            this.v1(var4);
         } else {
            this.v22();
         }
      }
   }

   private void v1(MicrosoftSignSupport.Part4 var1) {
      uiSupport270.Part1 var2 = var1.v3;
      if (var2 != null) {
         this.v21 = null;

         try {
            this.v10.v1(var2);
         } catch (Throwable var4) {
            v4.warn("installing the session for {} failed; the game keeps the previous one", var1.v2, var4);
            this.v2(TheSignSupport.FAILED);
            return;
         }

         uiSupport266.v1(var1.v4);
         this.v19 = var1.v2;
         this.v20();
         if (this.v27.v5()) {
            this.v18();
         }

         uiRecord16 var3 = this.v9(var1.v2);
         v4.info("signed in as {}", var3 == null ? var1.v2 : var3.v5());
      }
   }

   private void v1(uiSupport270.Part2 var1) {
      if (!this.v10.v3()) {
         if (var1 != uiSupport270.Part2.MENU || this.v21 != null || !"launch".equals(this.v19)) {
            this.v36 = false;
         } else if (this.v34 && this.v18 != null) {
            this.v36 = false;
            String var2 = this.v31;
            if (var2 != null && this.v27.v5()) {
               uiRecord16 var3 = this.v9(var2);
               if (var3 != null && var3.v7() && !var3.v8() && !var3.v10()) {
                  this.v38 = var2;
                  this.v19();
                  this.v1(() -> {
                     boolean var2x = this.v8.v3().v1(var2);
                     this.v2(() -> this.v2(var2, var2x));
                  });
               }
            }
         }
      }
   }

   private void v2(String var1, boolean var2) {
      this.v38 = null;
      if (!var2) {
         v4.info("not putting the remembered account back: another game on this folder is signed in as it");
      } else if (!this.v37 && this.v21 == null && "launch".equals(this.v19) && this.v10.v2() == uiSupport270.Part2.MENU) {
         this.v1(var1);
      }

      this.v19();
   }

   private void v18() {
      uiSupport270.Part3 var1 = this.v18;
      uiRecord16 var2 = this.v9(this.v19);
      if (var2 != null && var2.v7() && (var1 == null || var2.v4() != var1.v3() || !var2.v6().equals(var1.v2()))) {
         this.v7(var2.v3());
      } else {
         this.v7(null);
      }
   }

   private void v7(@Nullable String var1) {
      if (!Objects.equals(var1, this.v31)) {
         this.v31 = var1;
         this.v1(() -> {
            try {
               this.v8.v2(var1);
            } catch (IOException var3) {
               v4.warn("could not save the remembered account", var3);
            }
         });
      }
   }

   private void v19() {
      HashSet var1 = new HashSet(4);
      String var2 = this.v8(this.v19);
      if (var2 != null) {
         var1.add(var2);
      }

      MicrosoftSignSupport.Part4 var3 = this.v21;
      if (var3 != null) {
         String var4 = this.v8(var3.v2);
         if (var4 != null) {
            var1.add(var4);
         }
      }

      String var6 = this.v38;
      if (var6 != null) {
         var1.add(var6);
      }

      if (!var1.equals(this.v43)) {
         Set var5 = Set.copyOf(var1);
         this.v43 = var5;
         this.v1(() -> {
            this.v8.v3().v1(var5);

            for (String var3x : var5) {
               this.v8.v3().v1(var3x);
            }
         });
      }
   }

   private void v2(uiSupport270.Part2 var1) {
      if (var1 == uiSupport270.Part2.WORLD) {
         if (!this.v30) {
            this.v30 = true;
            this.v32 = false;
         }

         if (!this.v32) {
            String var2 = this.v10.v4();
            if (var2 != null) {
               this.v32 = true;
               this.v4(this.v19, var2.isBlank() ? null : var2);
            }
         }
      } else if (this.v30) {
         this.v30 = false;
         if (this.v32) {
            this.v4(this.v19, null);
         }
      }
   }

   private void v4(String var1, @Nullable String var2) {
      long var3 = this.v13.getAsLong();
      String var5 = this.v8(var1);
      if (var5 == null) {
         if ("launch".equals(var1)) {
            this.v23 = var3;
            if (var2 != null) {
               this.v33 = var2;
            }

            this.v20();
         }
      } else {
         int var6 = v1(this.v14, var5);
         if (var6 >= 0) {
            ArrayList var7 = new ArrayList<>(this.v14);
            var7.set(var6, ((uiRecord16)var7.get(var6)).v1(var3, var2));
            int var8 = this.v1(var7);
            this.v1(var8, var4 -> v1(var4, var5, var3xx -> var3xx.v1(var3, var2)));
         }
      }
   }

   @Nullable
   private String v8(String var1) {
      if ("".equals(var1)) {
         return null;
      } else if (!"launch".equals(var1)) {
         return var1;
      } else {
         uiSupport270.Part3 var2 = this.v18;
         if (var2 == null) {
            return null;
         } else {
            for (uiRecord16 var4 : this.v14) {
               if (var4.v4() == var2.v3() && var4.v6().equals(var2.v2())) {
                  return var4.v3();
               }
            }

            return null;
         }
      }
   }

   private void v1(int var1, TheSignSupport var2) {
      MicrosoftSignSupport.Part4 var3 = this.v21;
      if (var3 != null && var3.v1 == var1) {
         this.v21 = null;
         this.v2(var2);
      }
   }

   private void v1(MicrosoftSignSupport.Part2 var1) {
      if (!var1.v2) {
         try {
            MicrosoftAuth.Part4 var2 = this.v9.v1();
            this.v2(() -> {
               if (!var1.v2) {
                  var1.v1.v1(var2.v2(), var2.v1(), var2.v5());
                  this.v22();
               }
            });
            this.v1(var1, var2, var2.v6());
         } catch (uiSupport265 var3) {
            this.v1(var1, var3);
         } catch (Throwable var4) {
            v4.warn("Microsoft sign-in failed", var4);
            this.v1(var1, new uiSupport265(TheSignSupport.FAILED, 0, "unexpected"));
         }
      }
   }

   private void v1(MicrosoftSignSupport.Part2 var1, MicrosoftAuth.Part4 var2, long var3) {
      if (!var1.v2 && !this.v37) {
         try {
            var1.v3 = this.v11.schedule(() -> this.v2(var1, var2, var3), var3, TimeUnit.MILLISECONDS);
         } catch (RejectedExecutionException var6) {
            v4.debug("sign-in poll dropped: the switcher is shutting down");
         }
      }
   }

   private void v2(MicrosoftSignSupport.Part2 var1, MicrosoftAuth.Part4 var2, long var3) {
      if (!var1.v2) {
         try {
            if (this.v13.getAsLong() >= var2.v5()) {
               throw new uiSupport265(TheSignSupport.CODE_EXPIRED, 0, "the code expired before it was confirmed");
            }

            MicrosoftAuth.Part5 var5 = this.v9.v1(var2);
            if (var5 instanceof MicrosoftAuth.Part3 var14) {
               this.v1(var1, var2, var14.v1() ? var3 + 5000L : var3);
               return;
            }

            MicrosoftAuth.Part6 var6 = ((MicrosoftAuth.Part2)var5).v1();
            this.v2(() -> {
               if (!var1.v2) {
                  var1.v1.v10();
                  this.v22();
               }
            });
            MicrosoftAuth.Part7 var7 = this.v9.v2(var6.v1());
            MicrosoftAuth.Part1 var8 = this.v9.v3(var7.v1());
            if (var1.v2) {
               return;
            }

            MinecraftAccount var9 = this.v1(var6, var7, var8);
            uiRecord16 var10 = v2(var9);
            this.v2(() -> {
               if (!var1.v2) {
                  var1.v1.v1(var10);
                  this.v22();
               }
            });
            v4.info("signed in to Microsoft account {}", var8.v2());
         } catch (uiSupport265 var11) {
            this.v1(var1, var11);
         } catch (IOException var12) {
            v4.warn("the signed-in account could not be saved", var12);
            this.v1(var1, new uiSupport265(TheSignSupport.STORAGE, 0, "storage"));
         } catch (Throwable var13) {
            v4.warn("Microsoft sign-in failed", var13);
            this.v1(var1, new uiSupport265(TheSignSupport.FAILED, 0, "unexpected"));
         }
      }
   }

   private MinecraftAccount v1(MicrosoftAuth.Part6 var1, MicrosoftAuth.Part7 var2, MicrosoftAuth.Part1 var3) throws IOException {
      long var4 = this.v13.getAsLong();
      String var6 = v21();
      MinecraftAccount[] var7 = new MinecraftAccount[]{null};
      List var8 = this.v8.v1(var7x -> {
         ArrayList var8x = new ArrayList(var7x);

         for (int var9x = 0; var9x < var8x.size(); var9x++) {
            MinecraftAccount var10 = (MinecraftAccount)var8x.get(var9x);
            if (var10.v3() == uiSupport272.MICROSOFT && var10.v5().equals(var3.v1())) {
               var7[0] = var10.v1(var1.v2(), var2.v1(), var2.v2()).v1(var3.v2(), var3.v3(), var3.v4());
               var8x.set(var9x, var7[0]);
               return var8x;
            }
         }

         var7[0] = MinecraftAccount.v1(var6, var3.v2(), var3.v1(), var3.v3(), var3.v4(), var1.v2(), var2.v1(), var2.v2(), var4);
         var8x.add(var7[0]);
         return var8x;
      });
      this.v1(var8, -1);
      MinecraftAccount var9 = var7[0];
      if (var9 == null) {
         throw new IOException("the account was not written");
      } else {
         return var9;
      }
   }

   private void v1(MicrosoftSignSupport.Part2 var1, uiSupport265 var2) {
      if (!var1.v2) {
         v4.warn("Microsoft sign-in stopped: {}", var2.getMessage());
         this.v2(() -> {
            if (!var1.v2) {
               var1.v1.v1(var2.v1());
               this.v22();
            }
         });
      }
   }

   public void v1(uiSupport269 var1) {
      MicrosoftSignSupport.Part2 var2 = this.v25;
      if (var2 != null && var2.v1 == var1 && !var1.v2()) {
         var2.v2 = true;
         ScheduledFuture var3 = var2.v3;
         if (var3 != null) {
            var3.cancel(false);
         }

         var1.v11();
         this.v22();
      }
   }

   public void v3(String var1, String var2) {
      this.v10.v2(var2);
      this.v10.v1(var1);
   }

   private void v17() {
      int var1 = ++this.v17;
      this.v1(() -> {
         try {
            this.v1(this.v8.v4(), var1);
         } catch (IOException var3) {
            v4.warn("could not read the saved accounts", var3);
         }
      });
   }

   private int v1(List<uiRecord16> var1) {
      this.v14 = List.copyOf(var1);
      this.v20();
      return ++this.v17;
   }

   private void v1(int var1, UnaryOperator<List<MinecraftAccount>> var2) {
      this.v1(() -> {
         try {
            this.v1(this.v8.v1(var2), var1);
         } catch (IOException var4) {
            v4.warn("could not save the account list", var4);
            this.v2(() -> this.v2(TheSignSupport.STORAGE));
            this.v17();
         }
      });
   }

   private void v1(List<MinecraftAccount> var1, int var2) {
      ArrayList var3 = new ArrayList(var1.size());

      for (MinecraftAccount var5 : var1) {
         var3.add(v2(var5));
         cloudSupport63.v1(var5.v4());
      }

      List var6 = List.copyOf(var3);
      this.v2(() -> {
         if (var2 >= 0) {
            if (var2 < this.v17) {
               return;
            }

            this.v20 = var2;
         } else if (this.v20 < this.v17) {
            return;
         }

         this.v14 = var6;
         this.v20();
      });
   }

   private void v20() {
      ArrayList var1 = new ArrayList(this.v14.size() + 1);
      boolean var2 = this.v30 && this.v32;
      uiSupport270.Part3 var3 = this.v18;
      String var4 = null;
      if (var3 != null) {
         for (uiRecord16 var6 : this.v14) {
            if (var6.v4() == var3.v3() && var6.v6().equals(var3.v2())) {
               var4 = var6.v3();
               break;
            }
         }

         if (var4 == null) {
            boolean var8 = "launch".equals(this.v19);
            var1.add(
               new uiRecord16("launch", var3.v3(), var3.v1(), var3.v2(), false, var8, var8 && var2, false, null, false, 0L, this.v23, this.v33, false, null)
            );
         }
      }

      for (uiRecord16 var10 : this.v14) {
         boolean var7 = var10.v3().equals(this.v19) || var10.v3().equals(var4) && "launch".equals(this.v19);
         var1.add(var10.v1(var7, var7 && var2));
      }

      this.v15 = List.copyOf(var1);
      this.v22();
   }

   private static uiRecord16 v2(MinecraftAccount var0) {
      return new uiRecord16(
         var0.v2(),
         var0.v3(),
         var0.v4(),
         var0.v5(),
         true,
         false,
         false,
         var0.v16(),
         var0.v11(),
         var0.v12(),
         var0.v6(),
         var0.v7(),
         var0.v8(),
         var0.v9(),
         var0.v10()
      );
   }

   @Nullable
   private uiRecord16 v9(String var1) {
      for (uiRecord16 var3 : this.v15) {
         if (var3.v3().equals(var1)) {
            return var3;
         }
      }

      return null;
   }

   private boolean v5(String var1, @Nullable String var2) {
      for (uiRecord16 var4 : this.v14) {
         if (var4.v4() == uiSupport272.OFFLINE && var4.v5().equalsIgnoreCase(var1) && !var4.v3().equals(var2)) {
            return true;
         }
      }

      return false;
   }

   private static int v1(List<uiRecord16> var0, String var1) {
      for (int var2 = 0; var2 < var0.size(); var2++) {
         if (((uiRecord16)var0.get(var2)).v3().equals(var1)) {
            return var2;
         }
      }

      return -1;
   }

   @Nullable
   private static MinecraftAccount v2(List<MinecraftAccount> var0, String var1) {
      for (MinecraftAccount var3 : var0) {
         if (var3.v2().equals(var1)) {
            return var3;
         }
      }

      return null;
   }

   private static List<MinecraftAccount> v1(List<MinecraftAccount> var0, String var1, UnaryOperator<MinecraftAccount> var2) {
      ArrayList var3 = new ArrayList(var0);

      for (int var4 = 0; var4 < var3.size(); var4++) {
         if (((MinecraftAccount)var3.get(var4)).v2().equals(var1)) {
            var3.set(var4, (MinecraftAccount)var2.apply((MinecraftAccount)var3.get(var4)));
         }
      }

      return var3;
   }

   private static List<MinecraftAccount> v1(List<MinecraftAccount> var0, List<String> var1) {
      ArrayList var2 = new ArrayList(var0.size());

      for (String var4 : var1) {
         MinecraftAccount var5 = v2(var0, var4);
         if (var5 != null) {
            var2.add(var5);
         }
      }

      for (MinecraftAccount var7 : var0) {
         if (!var1.contains(var7.v2())) {
            var2.add(var7);
         }
      }

      return var2;
   }

   private static String v21() {
      return UUID.randomUUID().toString().replace("-", "").substring(0, 12).toLowerCase(Locale.ROOT);
   }

   private void v2(TheSignSupport var1) {
      this.v26 = var1;
      this.v22();
   }

   private void v22() {
      this.v16++;
      this.v19();
   }

   private void v1(Runnable var1) {
      if (!this.v37) {
         try {
            this.v11.execute(var1);
         } catch (RejectedExecutionException var3) {
            v4.debug("account task dropped: the switcher is shutting down");
         }
      }
   }

   private void v2(Runnable var1) {
      this.v12.accept(var1);
   }

   public record Part1(String accountId, boolean waitingToLeave) {
      public String v1() {
         return this.accountId;
      }

      public boolean v2() {
         return this.waitingToLeave;
      }
   }

   public static final class Part2 {
      public final uiSupport269 v1;
      public volatile boolean v2;
      @Nullable
      public volatile ScheduledFuture<?> v3;

      public Part2(uiSupport269 var1) {
         this.v1 = var1;
      }
   }

   public record Part3(@Nullable uiRecord16 account, @Nullable TheSignSupport problem) {
      public boolean v1() {
         return this.account != null;
      }

      @Nullable
      public uiRecord16 v2() {
         return this.account;
      }

      @Nullable
      public TheSignSupport v3() {
         return this.problem;
      }
   }

   public static final class Part4 {
      public final int v1;
      public final String v2;
      @Nullable
      public uiSupport270.Part1 v3;
      @Nullable
      public String v4;
      public long v5;
      public MicrosoftSignSupport.Part1 v6;

      public Part4(int var1, String var2) {
         this.v1 = var1;
         this.v2 = var2;
         this.v6 = new MicrosoftSignSupport.Part1(var2, false);
      }

      public void v1(@Nullable uiSupport270.Part1 var1) {
         this.v3 = var1;
         this.v6 = new MicrosoftSignSupport.Part1(this.v2, var1 != null);
      }
   }
}
