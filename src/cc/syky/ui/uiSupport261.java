package cc.syky.ui;

import cc.syky.account.AccountCipher;
import java.security.GeneralSecurityException;
import java.util.Locale;

public interface uiSupport261 {
   byte[] v1(byte[] var1, byte[] var2) throws GeneralSecurityException;

   byte[] v2(byte[] var1, byte[] var2) throws GeneralSecurityException;

   byte v1();

   static uiSupport261 v3() {
      String var0 = System.getProperty("os.name", "").toLowerCase(Locale.ROOT);
      return (uiSupport261)(var0.contains("win") ? new uiSupport262() : AccountCipher.v2());
   }

   public static final class Part1 extends GeneralSecurityException {
      public Part1(String var1, Throwable var2) {
         super(var1, var2);
      }
   }
}
