package cc.syky.account;

import cc.syky.ui.uiSupport261;
import java.io.IOException;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.attribute.PosixFilePermissions;
import java.security.GeneralSecurityException;
import java.security.SecureRandom;
import java.util.Arrays;
import javax.crypto.Cipher;
import javax.crypto.spec.GCMParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import org.jetbrains.annotations.Nullable;

public final class AccountCipher implements uiSupport261 {
   public static final byte v1 = 2;
   private static final int v2 = 32;
   private static final int v3 = 12;
   private static final int v4 = 128;
   private final Path v5;
   private final SecureRandom v6 = new SecureRandom();
   @Nullable
   private byte[] v7;

   public AccountCipher(Path var1) {
      this.v5 = var1;
   }

   public static AccountCipher v2() {
      return new AccountCipher(Path.of(System.getProperty("user.home"), ".syky", "accounts.key"));
   }

   @Override
   public byte[] v1(byte[] var1, byte[] var2) throws GeneralSecurityException {
      byte[] var3 = new byte[12];
      this.v6.nextBytes(var3);
      Cipher var4 = this.v1(1, var3, var2);
      byte[] var5 = var4.doFinal(var1);
      byte[] var6 = Arrays.copyOf(var3, 12 + var5.length);
      System.arraycopy(var5, 0, var6, 12, var5.length);
      return var6;
   }

   @Override
   public byte[] v2(byte[] var1, byte[] var2) throws GeneralSecurityException {
      if (var1.length < 12) {
         throw new GeneralSecurityException("the account list is truncated");
      } else {
         Cipher var3 = this.v1(2, Arrays.copyOf(var1, 12), var2);
         return var3.doFinal(var1, 12, var1.length - 12);
      }
   }

   @Override
   public byte v1() {
      return 2;
   }

   private Cipher v1(int var1, byte[] var2, byte[] var3) throws GeneralSecurityException {
      Cipher var4 = Cipher.getInstance("AES/GCM/NoPadding");
      var4.init(var1, new SecretKeySpec(this.v4(), "AES"), new GCMParameterSpec(128, var2));
      var4.updateAAD(var3);
      return var4;
   }

   private synchronized byte[] v4() throws GeneralSecurityException {
      byte[] var1 = this.v7;
      if (var1 != null) {
         return var1;
      } else {
         try {
            if (Files.exists(this.v5)) {
               v1(this.v5, "rw-------");
               var1 = Files.readAllBytes(this.v5);
            } else {
               var1 = this.v5();
            }
         } catch (IOException var3) {
            throw new uiSupport261.Part1("could not read or create " + this.v5, var3);
         }

         if (var1.length != 32) {
            throw new GeneralSecurityException(this.v5 + " is not a key");
         } else {
            this.v7 = var1;
            return var1;
         }
      }
   }

   private byte[] v5() throws IOException {
      Path var1 = this.v5.toAbsolutePath().getParent();
      if (var1 == null) {
         throw new IOException(this.v5 + " has no folder to live in");
      } else {
         Files.createDirectories(var1);
         v1(var1, "rwx------");
         byte[] var2 = new byte[32];
         this.v6.nextBytes(var2);
         Path var3 = Files.createTempFile(var1, "accounts", ".key.tmp");

         try {
            v1(var3, "rw-------");
            Files.write(var3, var2);

            try {
               Files.createLink(this.v5, var3);
            } catch (FileAlreadyExistsException var10) {
               return Files.readAllBytes(this.v5);
            } catch (IOException | UnsupportedOperationException var11) {
               if (Files.exists(this.v5)) {
                  return Files.readAllBytes(this.v5);
               }

               Files.copy(var3, this.v5);
               v1(this.v5, "rw-------");
            }

            return var2;
         } finally {
            Files.deleteIfExists(var3);
         }
      }
   }

   private static void v1(Path var0, String var1) {
      try {
         Files.setPosixFilePermissions(var0, PosixFilePermissions.fromString(var1));
      } catch (IOException | UnsupportedOperationException var3) {
      }
   }
}
