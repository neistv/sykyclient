package cc.syky.hud;

import cc.syky.cloud.cloudSupport2;
import cc.syky.config.BooleanSetting;
import cc.syky.config.EnumSetting;
import cc.syky.config.SettingCondition;
import java.time.LocalDate;
import java.time.format.TextStyle;
import java.util.Locale;
import org.jetbrains.annotations.Nullable;

public final class WrittenSupport extends CopiedSupport {
   public static final String v2 = "date";
   private static final hudRecord2 v3 = new hudRecord2(22.0F, 22.0F, 8.0F, 7.0F, 36.0F, 8.0F);
   private final EnumSetting<WrittenSupport.Part2> v4;
   private final BooleanSetting v5;
   private final BooleanSetting v6;
   private final BooleanSetting v7;
   private long v8 = Long.MIN_VALUE;
   @Nullable
   private String v9;
   private WrittenSupport.Part1 v10 = new WrittenSupport.Part1(WrittenSupport.Part2.WRITTEN, true, true, true);

   public WrittenSupport(hudSupport52 var1, float var2, float var3) {
      super("date", hudSupport49.v6, v3, var1, var2, var3);
      AutoSupport var4 = this.v2();
      this.v4 = var4.v1(new EnumSetting<>("format", WrittenSupport.Part2.WRITTEN));
      this.v5 = var4.v1(new BooleanSetting("weekday", true), SettingCondition.v1(this.v4, WrittenSupport.Part2.WRITTEN));
      this.v6 = var4.v1(new BooleanSetting("dayAndMonth", true));
      this.v7 = var4.v1(new BooleanSetting("year", true));
   }

   @Override
   public Object v40() {
      WrittenSupport.Part1 var1 = this.v10;
      if (var1.v1() != this.v4.getValue() || var1.v2() != this.v5.getValue() || var1.v3() != this.v6.getValue() || var1.v4() != this.v7.getValue()) {
         var1 = new WrittenSupport.Part1(this.v4.getValue(), this.v5.getValue(), this.v6.getValue(), this.v7.getValue());
         this.v10 = var1;
      }

      return var1;
   }

   private WrittenSupport.Part1 v49() {
      return this.v47() instanceof WrittenSupport.Part1 var1 ? var1 : this.v10;
   }

   @Nullable
   @Override
   public String v1(cloudSupport2 var1) {
      LocalDate var2 = var1.v34();
      WrittenSupport.Part1 var3 = this.v49();
      WrittenSupport.Part2 var4 = var3.v1();
      boolean var5 = var3.v2();
      boolean var6 = var3.v3();
      boolean var7 = var3.v4();
      long var8 = v2(var2, var4, var5, var6, var7);
      if (var8 != this.v8) {
         this.v8 = var8;
         this.v9 = v1(var2, var4, var5, var6, var7);
      }

      return this.v9;
   }

   private static long v2(LocalDate var0, WrittenSupport.Part2 var1, boolean var2, boolean var3, boolean var4) {
      long var5 = (var1 == WrittenSupport.Part2.WRITTEN ? 8L : 0L) | (var2 ? 4L : 0L) | (var3 ? 2L : 0L) | (var4 ? 1L : 0L);
      return var0.toEpochDay() * 16L + var5;
   }

   public static String v1(LocalDate var0, WrittenSupport.Part2 var1, boolean var2, boolean var3, boolean var4) {
      StringBuilder var5 = new StringBuilder(24);
      if (var1 == WrittenSupport.Part2.NUMERIC) {
         if (var3) {
            v1(var5, var0.getDayOfMonth());
            var5.append('.');
            v1(var5, var0.getMonthValue());
         }

         if (var4) {
            if (var3) {
               var5.append('.');
            }

            var5.append(var0.getYear());
         }

         return var5.toString();
      } else {
         if (var2) {
            var5.append(var0.getDayOfWeek().getDisplayName(TextStyle.FULL, Locale.ENGLISH));
         }

         if (var3) {
            v1(var5);
            var5.append(var0.getDayOfMonth()).append(' ').append(var0.getMonth().getDisplayName(TextStyle.FULL, Locale.ENGLISH));
         }

         if (var4) {
            v1(var5);
            var5.append(var0.getYear());
         }

         return var5.toString();
      }
   }

   private static void v1(StringBuilder var0) {
      if (var0.length() > 0) {
         var0.append(' ');
      }
   }

   private static void v1(StringBuilder var0, int var1) {
      if (var1 < 10) {
         var0.append('0');
      }

      var0.append(var1);
   }

   public record Part1(WrittenSupport.Part2 style, boolean weekday, boolean dayAndMonth, boolean year) {
      public WrittenSupport.Part2 v1() {
         return this.style;
      }

      public boolean v2() {
         return this.weekday;
      }

      public boolean v3() {
         return this.dayAndMonth;
      }

      public boolean v4() {
         return this.year;
      }
   }

   public static enum Part2 implements hudSupport64 {
      WRITTEN("Written"),
      NUMERIC("Numeric");

      private final String label;

      private Part2(String var3) {
         this.label = var3;
      }

      @Override
      public String v1() {
         return this.label;
      }
   }
}
