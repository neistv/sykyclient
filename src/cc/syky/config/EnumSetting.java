package cc.syky.config;

import com.google.gson.JsonElement;
import com.google.gson.JsonPrimitive;
import org.jetbrains.annotations.Nullable;

public final class EnumSetting<E extends Enum<E>> implements SettingOwner, Setting<E> {
   private final String v1;
   private final Class<E> v2;
   private final E v3;
   private E v4;
   @Nullable
   private Runnable v5;
   @Nullable
   private BooleanSetting v6;

   public EnumSetting<E> setCondition(@Nullable BooleanSetting var1) {
      this.v6 = var1;
      return this;
   }

   @Nullable
   public BooleanSetting getCondition() {
      return this.v6;
   }

   @Override
   public void onChange(Runnable var1) {
      this.v5 = var1;
   }

   public EnumSetting(String var1, E var2) {
      if (var2 == null) {
         throw new IllegalArgumentException("defaultValue must not be null for enum setting");
      } else {
         this.v1 = var1;
         this.v2 = var2.getDeclaringClass();
         this.v3 = (E)var2;
         this.v4 = (E)var2;
      }
   }

   @Override
   public String getName() {
      return this.v1;
   }

   public E getValue() {
      return this.v4;
   }

   public void setValue(E var1) {
      Enum var2 = var1 != null ? var1 : this.v3;
      if (var2 != this.v4) {
         this.v4 = (E)var2;
         if (this.v5 != null) {
            this.v5.run();
         }
      }
   }

   @Override
   public Class<E> getType() {
      return this.v2;
   }

   public E[] getValues() {
      return this.v2.getEnumConstants();
   }

   @Override
   public JsonElement toJson() {
      return new JsonPrimitive(this.v4.name());
   }

   @Override
   public void fromJson(JsonElement var1) {
      if (var1 != null && var1.isJsonPrimitive() && var1.getAsJsonPrimitive().isString()) {
         try {
            this.v4 = Enum.valueOf(this.v2, var1.getAsString());
         } catch (IllegalArgumentException var3) {
         }
      }
   }

   @Override
   public void reset() {
      this.v4 = this.v3;
   }

   @Override
   public boolean isModified() {
      return this.v4 != this.v3;
   }
}
