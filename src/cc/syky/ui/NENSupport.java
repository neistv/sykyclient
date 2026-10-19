package cc.syky.ui;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import org.jetbrains.annotations.Nullable;

public final class NENSupport {
   private static final int v1 = 3;
   private static final Map<Integer, String> v2 = v1();

   private NENSupport() {
   }

   @Nullable
   public static String v1(int var0) {
      return v2.get(var0);
   }

   public static String v2(int var0) {
      return "M" + (var0 + 1);
   }

   @Nullable
   public static String v1(String var0) {
      if (var0 == null) {
         return null;
      } else {
         String var1 = var0.trim();
         if (var1.isEmpty()) {
            return null;
         } else if (var1.length() <= 3) {
            return var1.toUpperCase(Locale.ROOT);
         } else {
            StringBuilder var2 = new StringBuilder(3);
            boolean var3 = true;

            for (int var4 = 0; var4 < var1.length() && var2.length() < 3; var4++) {
               char var5 = var1.charAt(var4);
               if (var5 == ' ' || var5 == '_' || var5 == '-') {
                  var3 = true;
               } else if (var3) {
                  var2.append(var5);
                  var3 = false;
               }
            }

            String var6 = var2.length() > 1 ? var2.toString() : var1.substring(0, 3);
            return var6.toUpperCase(Locale.ROOT);
         }
      }
   }

   private static Map<Integer, String> v1() {
      HashMap var0 = new HashMap();

      for (int var1 = 65; var1 <= 90; var1++) {
         var0.put(var1, String.valueOf((char)var1));
      }

      for (int var2 = 48; var2 <= 57; var2++) {
         var0.put(var2, String.valueOf((char)var2));
      }

      for (int var3 = 1; var3 <= 12; var3++) {
         var0.put(290 + var3 - 1, "F" + var3);
      }

      for (int var4 = 0; var4 <= 9; var4++) {
         var0.put(320 + var4, "N" + var4);
      }

      var0.put(330, "N.");
      var0.put(331, "N/");
      var0.put(332, "N*");
      var0.put(333, "N-");
      var0.put(334, "N+");
      var0.put(335, "NEN");
      var0.put(39, "'");
      var0.put(44, ",");
      var0.put(45, "-");
      var0.put(46, ".");
      var0.put(47, "/");
      var0.put(59, ";");
      var0.put(61, "=");
      var0.put(91, "[");
      var0.put(92, "\\");
      var0.put(93, "]");
      var0.put(96, "`");
      var0.put(32, "SPC");
      var0.put(258, "TAB");
      var0.put(280, "CAP");
      var0.put(257, "ENT");
      var0.put(259, "BSP");
      var0.put(260, "INS");
      var0.put(261, "DEL");
      var0.put(268, "HOM");
      var0.put(269, "END");
      var0.put(266, "PGU");
      var0.put(267, "PGD");
      var0.put(265, "UP");
      var0.put(264, "DN");
      var0.put(263, "LT");
      var0.put(262, "RT");
      var0.put(340, "LSH");
      var0.put(344, "RSH");
      var0.put(341, "LCT");
      var0.put(345, "RCT");
      var0.put(342, "LAL");
      var0.put(346, "RAL");
      return Map.copyOf(var0);
   }
}
