package cc.syky.account;

import cc.syky.cloud.cloudSupport66;
import cc.syky.ui.uiSupport261;
import cc.syky.ui.uiSupport263;
import cc.syky.ui.uiSupport264;
import java.io.IOException;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.nio.file.StandardOpenOption;
import java.security.GeneralSecurityException;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.UnaryOperator;
import org.jetbrains.annotations.Nullable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public final class AccountStore {
   private static final Logger v1 = LoggerFactory.getLogger("syky.account");
   private static final ConcurrentHashMap<Path, Object> v2 = new ConcurrentHashMap<>();
   private static final byte[] v3 = "SYKYACC".getBytes(StandardCharsets.US_ASCII);
   private static final byte v4 = 1;
   private static final int v5 = v3.length + 2;
   private static final String v6 = "account_options.json";
   private static final String v7 = "account_remembered.txt";
   private static final String v8 = "account_locks";
   private final Path v9;
   private final Path v10;
   private final Path v11;
   private final Path v12;
   private final Path v13;
   private final uiSupport263 v14;
   private final uiSupport261 v15;
   private final Object v16;

   public AccountStore(Path var1, uiSupport261 var2) {
      this.v9 = var1;
      this.v10 = var1.resolveSibling(var1.getFileName() + ".lock");
      this.v11 = var1.resolveSibling(var1.getFileName() + ".unreadable");
      this.v12 = var1.resolveSibling("account_options.json");
      this.v13 = var1.resolveSibling("account_remembered.txt");
      this.v14 = new uiSupport263(var1.resolveSibling("account_locks"));
      this.v15 = var2;
      this.v16 = v2.computeIfAbsent(this.v10.toAbsolutePath().normalize(), var0 -> new Object());
   }

   public Optional<String> v1() throws IOException {
      return Files.isRegularFile(this.v12) ? Optional.of(Files.readString(this.v12, StandardCharsets.UTF_8)) : Optional.empty();
   }

   public void v1(String var1) throws IOException {
      cloudSupport66.v1(this.v12, var1);
   }

   public Optional<String> v2() throws IOException {
      if (!Files.isRegularFile(this.v13)) {
         return Optional.empty();
      } else {
         String var1 = Files.readString(this.v13, StandardCharsets.UTF_8).strip();
         return var1.isEmpty() ? Optional.empty() : Optional.of(var1);
      }
   }

   public void v2(@Nullable String var1) throws IOException {
      if (var1 == null) {
         Files.deleteIfExists(this.v13);
      } else {
         cloudSupport66.v1(this.v13, var1);
      }
   }

   public uiSupport263 v3() {
      return this.v14;
   }

   public List<MinecraftAccount> v4() throws IOException {
      return this.v1(this::v5);
   }

   public List<MinecraftAccount> v1(UnaryOperator<List<MinecraftAccount>> var1) throws IOException {
      return this.v1(() -> {
         List var2 = this.v5();
         List var3 = List.copyOf(var1.apply(var2));
         if (!var3.equals(var2)) {
            this.v1(var3);
         }

         return var3;
      });
   }

   private List<MinecraftAccount> v5() throws IOException {
      if (!Files.exists(this.v9)) {
         return List.of();
      } else {
         byte[] var1 = Files.readAllBytes(this.v9);

         try {
            if (var1.length < v5 || !Arrays.equals(var1, 0, v3.length, v3, 0, v3.length) || var1[v3.length] != 1) {
               throw new uiSupport264.Part1("not a syky account file");
            } else if (var1[v3.length + 1] != this.v15.v1()) {
               throw new uiSupport264.Part1("sealed by another encryption scheme (" + var1[v3.length + 1] + ")");
            } else {
               byte[] var2 = Arrays.copyOf(var1, v5);
               byte[] var3 = this.v15.v2(Arrays.copyOfRange(var1, v5, var1.length), var2);
               return List.copyOf(uiSupport264.v1(var3));
            }
         } catch (uiSupport261.Part1 var4) {
            throw new IOException("the account list cannot be opened right now; it is left as it is", var4);
         } catch (GeneralSecurityException | uiSupport264.Part1 var5) {
            v1.warn("the saved accounts cannot be opened here ({}); moved to {} and starting an empty list", var5.getMessage(), this.v11.getFileName());
            Files.move(this.v9, this.v11, StandardCopyOption.REPLACE_EXISTING);
            return List.of();
         }
      }
   }

   private void v1(List<MinecraftAccount> var1) throws IOException {
      byte[] var2 = Arrays.copyOf(v3, v5);
      var2[v3.length] = 1;
      var2[v3.length + 1] = this.v15.v1();

      byte[] var3;
      try {
         var3 = this.v15.v1(uiSupport264.v1(var1), var2);
      } catch (GeneralSecurityException var5) {
         throw new IOException("could not encrypt the account list", var5);
      }

      byte[] var4 = Arrays.copyOf(var2, v5 + var3.length);
      System.arraycopy(var3, 0, var4, v5, var3.length);
      cloudSupport66.v1(this.v9, var4);
   }

   private <T> T v1(AccountStore.Part1<T> var1) throws IOException {
      Path var2 = this.v9.getParent();
      if (var2 != null) {
         Files.createDirectories(var2);
      }

      synchronized (this.v16) {
         Object var6;
         try (FileChannel var4 = FileChannel.open(this.v10, StandardOpenOption.CREATE, StandardOpenOption.WRITE)) {
            FileLock var5 = var4.lock();

            try {
               var6 = var1.call();
            } finally {
               var5.release();
            }
         }

         return (T)var6;
      }
   }

   @FunctionalInterface
   public interface Part1<T> {
      T call() throws IOException;
   }
}
