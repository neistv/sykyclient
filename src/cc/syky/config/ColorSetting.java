package cc.syky.config;

import com.google.gson.JsonElement;
import com.google.gson.JsonPrimitive;
import java.util.function.BooleanSupplier;
import org.jetbrains.annotations.Nullable;

public final class ColorSetting implements SettingOwner, Setting<Integer> {
   private final String v1;
   private final int v2;
   private int v3;
   @Nullable
   private Runnable v4;
   @Nullable
   private Setting<?> v5;
   @Nullable
   private BooleanSupplier v6;
   @Nullable
   private EnumSetting<?> v7;
   @Nullable
   private BooleanSupplier v8;
   @Nullable
   private Integer v9;

   @Override
   public void onChange(Runnable var1) {
      this.v4 = var1;
   }

   public ColorSetting(String var1, int var2) {
      this.v1 = var1;
      this.v2 = var2;
      this.v3 = var2;
   }

   public ColorSetting setCondition(@Nullable BooleanSetting var1) {
      this.v5 = var1;
      return this;
   }

   public ColorSetting setConditionEnum(@Nullable EnumSetting<?> var1) {
      this.v5 = var1;
      return this;
   }

   @Nullable
   public Setting<?> getCondition() {
      return this.v5;
   }

   public ColorSetting setCondition(@Nullable BooleanSupplier var1) {
      this.v6 = var1;
      return this;
   }

   public ColorSetting setConditionEnum(EnumSetting<?> var1, BooleanSupplier var2) {
      this.v7 = var1;
      this.v8 = var2;
      return this;
   }

   @Nullable
   public EnumSetting<?> getConditionEnum() {
      return this.v7;
   }

   public boolean isVisibleViaEnum() {
      return this.v7 != null && this.v8 != null && this.v8.getAsBoolean();
   }

   public boolean isVisible() {
      return this.v6 != null && this.v6.getAsBoolean();
   }

   @Override
   public String getName() {
      return this.v1;
   }

   public Integer getValue() {
      Integer var1 = this.v9;
      if (var1 == null || var1 != this.v3) {
         var1 = this.v3;
         this.v9 = var1;
      }

      return var1;
   }

   public void setValue(Integer var1) {
      int var2 = var1 != null ? var1 : this.v2;
      if (var2 != this.v3) {
         this.v3 = var2;
         if (this.v4 != null) {
            this.v4.run();
         }
      }
   }

   @Override
   public Class<Integer> getType() {
      return Integer.class;
   }

   public int getAlpha() {
      return this.v3 >>> 24 & 0xFF;
   }

   public int getRed() {
      return this.v3 >>> 16 & 0xFF;
   }

   public int getGreen() {
      return this.v3 >>> 8 & 0xFF;
   }

   public int getBlue() {
      return this.v3 & 0xFF;
   }

   public int getRgb() {
      return this.v3 & 16777215;
   }

   @Override
   public JsonElement toJson() {
      return new JsonPrimitive(String.format("#%08X", this.v3));
   }

   @Override
   public void fromJson(JsonElement var1) {
      if (var1 != null && var1.isJsonPrimitive() && var1.getAsJsonPrimitive().isString()) {
         String var2 = var1.getAsString().trim();
         if (var2.startsWith("#")) {
            var2 = var2.substring(1);
         }

         try {
            if (var2.length() == 6) {
               int var3 = Integer.parseInt(var2, 16);
               this.v3 = 0xFF000000 | var3;
            } else if (var2.length() == 8) {
               this.v3 = (int)Long.parseUnsignedLong(var2, 16);
            }
         } catch (NumberFormatException var4) {
         }
      }
   }

   @Override
   public void reset() {
      this.v3 = this.v2;
   }

   @Override
   public boolean isModified() {
      return this.v3 != this.v2;
   }
}
