package cc.syky.cloud;

import java.security.GeneralSecurityException;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

public final class Attestation {
   private Attestation() {
   }

   public static byte[] v1(byte[] var0) {
      try {
         Mac var1 = Mac.getInstance("HmacSHA256");
         byte[] var2 = AttestationKey.v1();
         var1.init(new SecretKeySpec(var2, "HmacSHA256"));
         return var1.doFinal(var0);
      } catch (GeneralSecurityException var3) {
         throw new IllegalStateException("HMAC-SHA256 unavailable", var3);
      }
   }
}
