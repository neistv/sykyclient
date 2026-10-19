package cc.syky.config;

import com.google.gson.JsonElement;
import com.google.gson.JsonPrimitive;
import org.jetbrains.annotations.Nullable;

public final class FloatSetting implements SettingOwner, Setting<Float> {
   private final String v1;
   private final float v2;
   private final float v3;
   private final float v4;
   private float v5;
   @Nullable
   private Runnable v6;
   @Nullable
   private BooleanSetting v7;
   private boolean v8;
   private String v9 = "";
   @Nullable
   private String v10;
   private float v11;
   @Nullable
   private Float v12;

   @Override
   public void onChange(Runnable var1) {
      this.v6 = var1;
   }

   public FloatSetting(String var1, float var2, float var3, float var4) {
      if (var3 > var4) {
         throw new IllegalArgumentException("min > max for setting '" + var1 + "'");
      } else if (!(var2 < var3) && !(var2 > var4)) {
         this.v1 = var1;
         this.v2 = var2;
         this.v3 = var3;
         this.v4 = var4;
         this.v5 = var2;
      } else {
         throw new IllegalArgumentException("default outside [min,max] for setting '" + var1 + "'");
      }
   }

   @Override
   public String getName() {
      return this.v1;
   }

   public Float getValue() {
      Float var1 = this.v12;
      if (var1 == null || Float.floatToRawIntBits(var1) != Float.floatToRawIntBits(this.v5)) {
         var1 = this.v5;
         this.v12 = var1;
      }

      return var1;
   }

   public void setValue(Float var1) {
      float var2 = var1 == null ? this.v2 : Math.max(this.v3, Math.min(this.v4, var1));
      if (this.v10 != null && var2 > this.v3 && var2 < this.v11) {
         var2 = var2 - this.v3 < this.v11 - var2 ? this.v3 : this.v11;
      }

      if (Float.compare(var2, this.v5) != 0) {
         this.v5 = var2;
         if (this.v6 != null) {
            this.v6.run();
         }
      }
   }

   @Override
   public Class<Float> getType() {
      return Float.class;
   }

   public float getMin() {
      return this.v3;
   }

   public float getMax() {
      return this.v4;
   }

   public FloatSetting setCondition(@Nullable BooleanSetting var1) {
      this.v7 = var1;
      return this;
   }

   @Nullable
   public BooleanSetting getCondition() {
      return this.v7;
   }

   public FloatSetting setSuffix(String var1) {
      this.v9 = var1;
      return this;
   }

   public String getSuffix() {
      return this.v9;
   }

   public FloatSetting setDraggable() {
      this.v8 = true;
      return this;
   }

   public boolean isDraggable() {
      return this.v8;
   }

   public FloatSetting setSnapStop(String var1, float var2) {
      if (!(var2 <= this.v3) && !(var2 > this.v4)) {
         this.v10 = var1;
         this.v11 = var2;
         return this;
      } else {
         throw new IllegalArgumentException("floor stop outside (min,max] for setting '" + this.v1 + "'");
      }
   }

   @Nullable
   public String getSnapStop() {
      return this.v10;
   }

   @Override
   public JsonElement toJson() {
      return new JsonPrimitive(this.v5);
   }

   @Override
   public void fromJson(JsonElement var1) {
      if (var1 != null && var1.isJsonPrimitive() && var1.getAsJsonPrimitive().isNumber()) {
         this.setValue(var1.getAsFloat());
      }
   }

   @Override
   public void reset() {
      this.v5 = this.v2;
   }

   @Override
   public boolean isModified() {
      return Float.compare(this.v5, this.v2) != 0;
   }
}
