package cc.syky.config;

import cc.syky.module.visual.visualSupport57;
import org.jetbrains.annotations.Nullable;

public final class HoldSupport {
   private static final float v4 = 0.7F;
   private static final float v5 = 0.45F;
   private static final float v6 = 9.0F;
   public final String v1;
   public final BooleanSetting v2;
   public final ColorSetting v3;
   @Nullable
   private final BooleanSetting v7;
   private final configSupport15 v8 = new configSupport15(0.7F);
   private final visualSupport57 v9 = new visualSupport57(9.0F);
   private boolean v10;

   private HoldSupport(String var1, BooleanSetting var2, ColorSetting var3, @Nullable BooleanSetting var4) {
      this.v1 = var1;
      this.v2 = var2;
      this.v3 = var3;
      this.v7 = var4;
   }

   public static HoldSupport v1(SettingRegistry var0, String var1, boolean var2, int var3, boolean var4) {
      BooleanSetting var5 = var0.addHidden(new BooleanSetting(var1, var2));
      ColorSetting var6 = var0.add(new ColorSetting(var1 + "Color", var3), SettingCondition.v1(var5));
      BooleanSetting var7 = var0.add(new BooleanSetting(var1 + "Hold", var4), SettingCondition.v1(var5));
      return new HoldSupport(var1, var5, var6, var7);
   }

   public static HoldSupport v1(SettingRegistry var0, String var1, boolean var2, int var3) {
      BooleanSetting var4 = var0.addHidden(new BooleanSetting(var1, var2));
      ColorSetting var5 = var0.add(new ColorSetting(var1 + "Color", var3), SettingCondition.v1(var4));
      return new HoldSupport(var1, var4, var5, null);
   }

   public void v1(boolean var1, boolean var2) {
      if (var1 && !this.v10 && var2 && this.v2.getValue()) {
         this.v8.v1();
      }

      this.v10 = var1;
      this.v9.v1(var1 && this.v3());
   }

   public void v1() {
      if (this.v2.getValue()) {
         this.v8.v1();
      }
   }

   public void v1(boolean var1) {
      this.v9.v1(var1 && this.v3());
   }

   public void v2() {
      this.v8.v2();
      this.v9.v1(false);
      this.v9.v1();
      this.v10 = false;
   }

   public void v1(float var1) {
      float var2 = Math.max(this.v8.v3(), this.v9.v3() * 0.45F);
      configSupport14.v1(this.v3.getValue(), var2, var1);
   }

   private boolean v3() {
      return this.v2.getValue() && this.v7 != null && this.v7.getValue();
   }
}
