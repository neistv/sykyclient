package cc.syky.ui;

import java.nio.charset.StandardCharsets;
import java.util.UUID;
import org.jetbrains.annotations.Nullable;

public final class uiSupport267 {
   public static final int v1 = 16;

   private uiSupport267() {
   }

   @Nullable
   public static String v1(@Nullable String var0) {
      if (var0 == null) {
         return null;
      } else {
         String var1 = var0.strip();
         if (!var1.isEmpty() && var1.length() <= 16) {
            for (int var2 = 0; var2 < var1.length(); var2++) {
               char var3 = var1.charAt(var2);
               if (var3 <= ' ' || var3 >= 127) {
                  return null;
               }
            }

            return var1;
         } else {
            return null;
         }
      }
   }

   public static UUID v2(String var0) {
      return UUID.nameUUIDFromBytes(("OfflinePlayer:" + var0).getBytes(StandardCharsets.UTF_8));
   }
}
