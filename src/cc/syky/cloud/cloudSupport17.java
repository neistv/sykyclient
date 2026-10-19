package cc.syky.cloud;

import com.google.common.net.InetAddresses;
import java.io.IOException;
import java.net.Inet6Address;
import java.net.InetAddress;
import java.util.Locale;
import net.minecraft.class_310;
import net.minecraft.class_412;
import net.minecraft.class_442;
import net.minecraft.class_500;
import net.minecraft.class_638;
import net.minecraft.class_639;
import net.minecraft.class_642;
import net.minecraft.class_8800;
import net.minecraft.class_642.class_8678;
import org.jetbrains.annotations.Nullable;

public final class cloudSupport17 {
   private static final int v1 = 64;
   private static final int v2 = 24576;

   private cloudSupport17() {
   }

   public static boolean v1(String var0) {
      String var1 = var0.trim();
      if (var1.startsWith("[")) {
         int var2 = var1.indexOf(93);
         var1 = var2 < 0 ? "" : var1.substring(1, var2);
      } else if (var1.indexOf(58) == var1.lastIndexOf(58) && var1.indexOf(58) >= 0) {
         var1 = var1.substring(0, var1.indexOf(58));
      }

      var1 = var1.toLowerCase(Locale.ROOT);

      while (var1.endsWith(".")) {
         var1 = var1.substring(0, var1.length() - 1);
      }

      if (var1.isEmpty()) {
         return false;
      } else if (InetAddresses.isInetAddress(var1)) {
         InetAddress var5 = InetAddresses.forString(var1);
         boolean var3 = var5 instanceof Inet6Address && (var5.getAddress()[0] & 254) == 252;
         return !var5.isLoopbackAddress()
            && !var5.isSiteLocalAddress()
            && !var5.isLinkLocalAddress()
            && !var5.isAnyLocalAddress()
            && !var5.isMulticastAddress()
            && !var3;
      } else {
         return var1.contains(".") && !var1.endsWith(".local") && !var1.endsWith(".lan");
      }
   }

   @Nullable
   public static byte[] v1() {
      class_310 var0 = class_310.method_1551();
      class_642 var1 = var0 == null ? null : var0.method_1558();
      byte[] var2 = var1 == null ? null : var1.method_49306();
      if (var2 != null && var2.length <= 24576) {
         try {
            class_8800 var3 = class_8800.method_53878(var2);
            return var3.comp_1965() == 64 && var3.comp_1966() == 64 ? var2 : null;
         } catch (IOException var4) {
            return null;
         }
      } else {
         return null;
      }
   }

   public static boolean v2() {
      class_310 var0 = class_310.method_1551();
      return var0 != null && var0.field_1687 != null;
   }

   public static boolean v1(String var0, String var1) {
      class_310 var2 = class_310.method_1551();
      if (var2 != null && class_639.method_36224(var0)) {
         var2.method_63588(() -> {
            if (var2.field_1687 != null) {
               var2.method_73360(class_638.field_61021);
            }

            class_642 var3 = new class_642(var1, var0, class_8678.field_45611);
            class_412.method_36877(new class_500(new class_442()), var2, class_639.method_2950(var0), var3, false, null);
         });
         return true;
      } else {
         return false;
      }
   }
}
