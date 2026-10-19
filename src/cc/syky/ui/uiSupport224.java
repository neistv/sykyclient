package cc.syky.ui;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import net.minecraft.class_2561;
import org.jetbrains.annotations.Nullable;

public final class uiSupport224 {
   private static final String v1 = "[0-9A-Fa-f]{1,4}";
   private static final String v2 = "(?:(?:[0-9A-Fa-f]{1,4}:){7}[0-9A-Fa-f]{1,4}|[0-9A-Fa-f]{1,4}(?::[0-9A-Fa-f]{1,4})*::(?:[0-9A-Fa-f]{1,4}(?::[0-9A-Fa-f]{1,4})*)?|::[0-9A-Fa-f]{1,4}(?::[0-9A-Fa-f]{1,4})*)";
   private static final String v3 = "(?::\\d{1,5})?";
   private static final String v4 = "(?:[\\w.-]+/)?";
   private static final Pattern v5 = Pattern.compile(
      "(?<![\\w.])(?:[\\w.-]+/)?(?:\\d{1,3}\\.){3}\\d{1,3}(?::\\d{1,5})?(?!\\.?\\w)|(?<![\\w.])(?:[\\w.-]+/)?\\[(?:(?:[0-9A-Fa-f]{1,4}:){7}[0-9A-Fa-f]{1,4}|[0-9A-Fa-f]{1,4}(?::[0-9A-Fa-f]{1,4})*::(?:[0-9A-Fa-f]{1,4}(?::[0-9A-Fa-f]{1,4})*)?|::[0-9A-Fa-f]{1,4}(?::[0-9A-Fa-f]{1,4})*)(?:%[\\w.]+)?\\](?::\\d{1,5})?|(?<![\\w:/])(?:(?:[0-9A-Fa-f]{1,4}:){7}[0-9A-Fa-f]{1,4}|[0-9A-Fa-f]{1,4}(?::[0-9A-Fa-f]{1,4})*::(?:[0-9A-Fa-f]{1,4}(?::[0-9A-Fa-f]{1,4})*)?|::[0-9A-Fa-f]{1,4}(?::[0-9A-Fa-f]{1,4})*)(?![\\w:])"
   );
   @Nullable
   private static String v6;
   @Nullable
   private static Pattern v7;

   private uiSupport224() {
   }

   public static class_2561 v1(class_2561 var0, @Nullable String var1) {
      String var2 = uiSupport192.v1(var0);
      int[] var3 = v1(var2, var1);
      return var3.length == 0 ? var0 : uiSupport192.v1(var0, var3, "Protected", (var0x, var1x) -> var1x);
   }

   public static int[] v1(String var0, @Nullable String var1) {
      int[] var2 = new int[0];
      int var3 = 0;
      Pattern var4 = v1(var1);

      for (Pattern var8 : var4 == null ? new Pattern[]{v5} : new Pattern[]{v5, var4}) {
         for (Matcher var9 = var8.matcher(var0); var9.find(); var2[var3++] = var9.end()) {
            if (var3 + 2 > var2.length) {
               var2 = Arrays.copyOf(var2, Math.max(4, var2.length * 2));
            }

            var2[var3++] = var9.start();
         }
      }

      return v1(Arrays.copyOf(var2, var3));
   }

   private static int[] v1(int[] var0) {
      int var1 = var0.length / 2;
      if (var1 < 2) {
         return var0;
      } else {
         long[] var2 = new long[var1];

         for (int var3 = 0; var3 < var1; var3++) {
            var2[var3] = (long)var0[2 * var3] << 32 | var0[2 * var3 + 1];
         }

         Arrays.sort(var2);
         int[] var12 = new int[var0.length];
         int var4 = 0;

         for (long var8 : var2) {
            int var10 = (int)(var8 >>> 32);
            int var11 = (int)var8;
            if (var4 > 0 && var10 <= var12[var4 - 1]) {
               var12[var4 - 1] = Math.max(var12[var4 - 1], var11);
            } else {
               var12[var4++] = var10;
               var12[var4++] = var11;
            }
         }

         return Arrays.copyOf(var12, var4);
      }
   }

   @Nullable
   private static Pattern v1(@Nullable String var0) {
      if (var0 != null && !var0.isBlank()) {
         if (!var0.equals(v6)) {
            v7 = Pattern.compile("(?<![\\w.-])" + Pattern.quote(var0) + "(?::\\d{1,5})?(?![\\w-])", 2);
            v6 = var0;
         }

         return v7;
      } else {
         return null;
      }
   }
}
