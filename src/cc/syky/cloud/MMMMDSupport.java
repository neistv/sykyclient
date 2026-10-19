package cc.syky.cloud;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.format.TextStyle;
import java.time.temporal.ChronoUnit;
import java.util.Locale;

public final class MMMMDSupport {
   private static final DateTimeFormatter v1 = DateTimeFormatter.ofPattern("HH:mm", Locale.ROOT);
   private static final DateTimeFormatter v2 = DateTimeFormatter.ofPattern("MMMM d", Locale.ENGLISH);
   private static final DateTimeFormatter v3 = DateTimeFormatter.ofPattern("MMMM d, yyyy", Locale.ENGLISH);
   private static final long v4 = 6L;

   private MMMMDSupport() {
   }

   public static String v1(Instant var0, ZoneId var1) {
      return v1.format(var0.atZone(var1));
   }

   public static String v1(Instant var0, ZoneId var1, LocalDate var2) {
      LocalDate var3 = v2(var0, var1);
      long var4 = ChronoUnit.DAYS.between(var3, var2);
      String var6 = var4 == 0L ? "today" : (var4 == 1L ? "yesterday" : (var3.getYear() == var2.getYear() ? v2 : v3).format(var3));
      return var6 + " at " + v1(var0, var1);
   }

   public static LocalDate v2(Instant var0, ZoneId var1) {
      return LocalDate.ofInstant(var0, var1);
   }

   public static String v1(LocalDate var0, LocalDate var1) {
      long var2 = ChronoUnit.DAYS.between(var0, var1);
      if (var2 == 0L) {
         return "Today";
      } else if (var2 == 1L) {
         return "Yesterday";
      } else {
         return var2 > 1L && var2 <= 6L
            ? var0.getDayOfWeek().getDisplayName(TextStyle.FULL, Locale.ENGLISH)
            : (var0.getYear() == var1.getYear() ? v2 : v3).format(var0);
      }
   }
}
