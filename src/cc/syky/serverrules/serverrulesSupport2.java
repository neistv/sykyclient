package cc.syky.serverrules;

import com.google.common.net.InetAddresses;
import java.net.IDN;
import java.util.Locale;
import org.jetbrains.annotations.Nullable;

public final class serverrulesSupport2 {
   private static final int v1 = 253;
   private static final int v2 = 63;

   private serverrulesSupport2() {
   }

   @Nullable
   public static String v1(@Nullable String var0) {
      if (var0 == null) {
         return null;
      } else {
         String var1 = var0.strip();
         if (var1.startsWith("[")) {
            int var2 = var1.indexOf(93);
            if (var2 < 0) {
               return null;
            }

            var1 = var1.substring(1, var2);
         } else if (var1.indexOf(58) >= 0 && var1.indexOf(58) == var1.lastIndexOf(58)) {
            var1 = var1.substring(0, var1.indexOf(58));
         }

         int var7 = var1.length();

         while (var7 > 0 && var1.charAt(var7 - 1) == '.') {
            var7--;
         }

         var1 = var1.substring(0, var7).toLowerCase(Locale.ROOT);
         if (var1.isEmpty()) {
            return null;
         } else if (InetAddresses.isInetAddress(var1)) {
            return InetAddresses.toAddrString(InetAddresses.forString(var1));
         } else {
            String var3;
            try {
               var3 = IDN.toASCII(var1, 1).toLowerCase(Locale.ROOT);
            } catch (IllegalArgumentException var5) {
               return null;
            }

            return v4(var3) ? var3 : null;
         }
      }
   }

   public static boolean v2(String var0) {
      return InetAddresses.isInetAddress(var0);
   }

   public static boolean v3(String var0) {
      return v2(var0) || var0.indexOf(46) > 0;
   }

   private static boolean v4(String var0) {
      if (!var0.isEmpty() && var0.length() <= 253) {
         int var1 = 0;

         while (var1 <= var0.length()) {
            int var2 = var0.indexOf(46, var1);
            if (var2 < 0) {
               var2 = var0.length();
            }

            if (!v1(var0, var1, var2)) {
               return false;
            }

            var1 = var2 + 1;
         }

         return true;
      } else {
         return false;
      }
   }

   private static boolean v1(String var0, int var1, int var2) {
      int var3 = var2 - var1;
      if (var3 != 0 && var3 <= 63 && var0.charAt(var1) != '-' && var0.charAt(var2 - 1) != '-') {
         if (var3 >= 4 && var0.startsWith("--", var1 + 2) && !var0.startsWith("xn--", var1)) {
            return false;
         } else {
            for (int var4 = var1; var4 < var2; var4++) {
               char var5 = var0.charAt(var4);
               if ((var5 < 'a' || var5 > 'z') && (var5 < '0' || var5 > '9') && var5 != '-' && var5 != '_') {
                  return false;
               }
            }

            return true;
         }
      } else {
         return false;
      }
   }
}
