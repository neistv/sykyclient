package cc.syky.ui;

import com.sun.jna.platform.win32.Crypt32Util;
import java.security.GeneralSecurityException;

public final class uiSupport262 implements uiSupport261 {
   public static final byte v1 = 1;

   public uiSupport262() {
   }

   @Override
   public byte[] v1(byte[] var1, byte[] var2) throws GeneralSecurityException {
      try {
         return Crypt32Util.cryptProtectData(var1, var2, 1, "syky accounts", null);
      } catch (LinkageError var4) {
         throw new uiSupport261.Part1("the Windows encryption API could not be loaded", var4);
      } catch (RuntimeException var5) {
         throw new GeneralSecurityException("Windows could not encrypt the account list", var5);
      }
   }

   @Override
   public byte[] v2(byte[] var1, byte[] var2) throws GeneralSecurityException {
      try {
         return Crypt32Util.cryptUnprotectData(var1, var2, 1, null);
      } catch (LinkageError var4) {
         throw new uiSupport261.Part1("the Windows encryption API could not be loaded", var4);
      } catch (RuntimeException var5) {
         throw new GeneralSecurityException("Windows could not decrypt the account list", var5);
      }
   }

   @Override
   public byte v1() {
      return 1;
   }
}
