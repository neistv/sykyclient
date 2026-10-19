package cc.syky.update;

import java.security.GeneralSecurityException;
import java.security.KeyFactory;
import java.security.PublicKey;
import java.security.Signature;
import java.security.spec.X509EncodedKeySpec;
import java.util.Base64;
import java.util.List;
import org.jetbrains.annotations.Nullable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public final class Ed25519Verifier {
   private static final Logger v1 = LoggerFactory.getLogger("syky.update.sig");
   private static final String v2 = "Ed25519";

   private Ed25519Verifier() {
   }

   public static boolean v1(byte[] var0, byte[] var1, List<String> var2) {
      if (var2.isEmpty()) {
         v1.warn("no trusted keys are baked into this build — refusing to trust any release");
         return false;
      } else {
         for (String var4 : var2) {
            PublicKey var5 = v1(var4);
            if (var5 != null && v1(var0, var1, var5)) {
               return true;
            }
         }

         return false;
      }
   }

   private static boolean v1(byte[] var0, byte[] var1, PublicKey var2) {
      try {
         Signature var3 = Signature.getInstance("Ed25519");
         var3.initVerify(var2);
         var3.update(var0);
         return var3.verify(var1);
      } catch (GeneralSecurityException var4) {
         v1.debug("signature check failed against one key", var4);
         return false;
      }
   }

   @Nullable
   private static PublicKey v1(String var0) {
      try {
         byte[] var1 = Base64.getDecoder().decode(var0.trim());
         return KeyFactory.getInstance("Ed25519").generatePublic(new X509EncodedKeySpec(var1));
      } catch (IllegalArgumentException | GeneralSecurityException var2) {
         v1.warn("a baked-in update key could not be decoded and is ignored", var2);
         return null;
      }
   }
}
