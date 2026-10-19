package cc.syky.hud;

import cc.syky.cloud.cloudSupport2;
import cc.syky.config.EnumSetting;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import org.jetbrains.annotations.Nullable;

public final class HHMmSupport extends CopiedSupport {
   public static final String v2 = "time";
   public static final hudRecord2 v3 = new hudRecord2(25.0F, 26.0F, 7.0F, 5.0F, 40.0F, 8.0F);
   private static final DateTimeFormatter v4 = DateTimeFormatter.ofPattern("HH:mm", Locale.ENGLISH);
   private static final DateTimeFormatter v5 = DateTimeFormatter.ofPattern("h:mm a", Locale.ENGLISH);
   private final EnumSetting<HHMmSupport.Part1> v6;
   private int v7 = Integer.MIN_VALUE;
   @Nullable
   private String v8;

   public HHMmSupport(hudSupport52 var1, float var2, float var3) {
      super("time", hudSupport49.v4, v3, var1, var2, var3);
      this.v6 = this.v2().v1(new EnumSetting<>("format", HHMmSupport.Part1.TWENTY_FOUR_HOUR));
   }

   @Override
   public Object v40() {
      return this.v6.getValue();
   }

   private HHMmSupport.Part1 v49() {
      return this.v47() instanceof HHMmSupport.Part1 var1 ? var1 : this.v6.getValue();
   }

   @Nullable
   @Override
   public String v1(cloudSupport2 var1) {
      LocalTime var2 = var1.v31();
      HHMmSupport.Part1 var3 = this.v49();
      int var4 = (var2.getHour() * 60 + var2.getMinute()) * 2 + (var3 == HHMmSupport.Part1.TWELVE_HOUR ? 1 : 0);
      if (var4 != this.v7) {
         this.v7 = var4;
         this.v8 = v1(var2, var3);
      }

      return this.v8;
   }

   public static String v1(LocalTime var0, HHMmSupport.Part1 var1) {
      return (var1 == HHMmSupport.Part1.TWELVE_HOUR ? v5 : v4).format(var0);
   }

   public static enum Part1 implements hudSupport64 {
      TWENTY_FOUR_HOUR("24-hour"),
      TWELVE_HOUR("12-hour");

      private final String label;

      private Part1(String var3) {
         this.label = var3;
      }

      @Override
      public String v1() {
         return this.label;
      }
   }
}
