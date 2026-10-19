package cc.syky.ui;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Locale;
import org.jetbrains.annotations.Nullable;

public final class NowSupport {
   public static final String v1 = "Now";
   public static final String v2 = "Never";
   private static final String v3 = " · ";
   private static final long v4 = 60000L;
   private static final long v5 = 3600000L;
   private static final long v6 = 86400000L;
   private static final long v7 = 604800000L;
   private static final long v8 = 2592000000L;
   private static final long v9 = 31536000000L;

   private NowSupport() {
   }

   public static List<uiRecord16> v1(List<uiRecord16> var0, DateAddedSupport var1) {
      ArrayList var2 = new ArrayList(var0);
      var2.sort(v1(var1));
      return var2;
   }

   public static Comparator<uiRecord16> v1(DateAddedSupport var0) {
      return Comparator.<uiRecord16, Boolean>comparing(var0x -> !var0x.v16()).thenComparing(uiRecord16::v7).thenComparing(v2(var0));
   }

   public static Comparator<uiRecord16> v2(DateAddedSupport var0) {
      return switch (var0) {
         case LAST_USED -> Comparator.comparingLong(uiRecord16::v14).thenComparingLong(uiRecord16::v13).reversed();
         case ADDED -> Comparator.comparingLong(uiRecord16::v13).reversed();
         case NAME -> Comparator.comparing(var0x -> var0x.v5().toLowerCase(Locale.ROOT));
      };
   }

   public static String v1(uiRecord16 var0, LastSeenDisplay var1, long var2, @Nullable String var4) {
      String var5 = var0.v18();
      if (var5 != null) {
         return var5;
      } else {
         String var6 = var1.v2() ? v1(var0, var4) : null;
         String var7 = var1.v3() ? v1(var0, var2) : null;
         if (var6 == null) {
            return var7 == null ? "" : var7;
         } else {
            return var7 == null ? var6 : var6 + " · " + var7;
         }
      }
   }

   @Nullable
   private static String v1(uiRecord16 var0, @Nullable String var1) {
      String var2 = var0.v15();
      if (var2 != null && !var2.isBlank()) {
         return var1 != null && v1(var2) ? var1 : var2;
      } else {
         return null;
      }
   }

   public static boolean v1(String var0) {
      return var0.indexOf(32) < 0 && (var0.indexOf(46) >= 0 || var0.indexOf(58) >= 0);
   }

   @Nullable
   private static String v1(uiRecord16 var0, long var1) {
      if (var0.v9()) {
         return "Now";
      } else if (var0.v14() <= 0L) {
         return var0.v7() ? "Never" : null;
      } else {
         return v1(var1 - var0.v14());
      }
   }

   public static String v1(long var0) {
      if (var0 < 60000L) {
         return "Now";
      } else if (var0 < 3600000L) {
         return var0 / 60000L + "m";
      } else if (var0 < 86400000L) {
         return var0 / 3600000L + "h";
      } else if (var0 < 604800000L) {
         return var0 / 86400000L + "d";
      } else if (var0 < 2592000000L) {
         return var0 / 604800000L + "w";
      } else {
         return var0 < 31536000000L ? var0 / 2592000000L + "mo" : var0 / 31536000000L + "y";
      }
   }
}
