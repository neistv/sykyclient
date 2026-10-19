package cc.syky.config;

import com.google.gson.JsonElement;
import com.google.gson.JsonPrimitive;
import org.jetbrains.annotations.Nullable;

public final class BooleanSetting implements Setting<Boolean> {
   private final String v1;
   private final boolean v2;
   private boolean v3;
   @Nullable
   private Runnable v4;

   public BooleanSetting(String var1, boolean var2) {
      this.v1 = var1;
      this.v2 = var2;
      this.v3 = var2;
   }

   @Override
   public void onChange(Runnable var1) {
      this.v4 = var1;
   }

   @Override
   public String getName() {
      return this.v1;
   }

   public Boolean getValue() {
      return this.v3;
   }

   public void setValue(Boolean var1) {
      boolean var2 = var1 != null ? var1 : this.v2;
      if (var2 != this.v3) {
         this.v3 = var2;
         if (this.v4 != null) {
            this.v4.run();
         }
      }
   }

   @Override
   public Class<Boolean> getType() {
      return Boolean.class;
   }

   @Override
   public JsonElement toJson() {
      return new JsonPrimitive(this.v3);
   }

   @Override
   public void fromJson(JsonElement var1) {
      if (var1 != null && var1.isJsonPrimitive() && var1.getAsJsonPrimitive().isBoolean()) {
         this.v3 = var1.getAsBoolean();
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
