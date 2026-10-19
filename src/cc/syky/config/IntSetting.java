package cc.syky.config;

import com.google.gson.JsonElement;
import com.google.gson.JsonPrimitive;
import org.jetbrains.annotations.Nullable;

public final class IntSetting implements SettingOwner, Setting<Integer> {
   private final String v1;
   private final int v2;
   private final int v3;
   private final int v4;
   private int v5;
   @Nullable
   private Runnable v6;
   @Nullable
   private BooleanSetting v7;
   private boolean v8;
   private String v9 = "";
   @Nullable
   private Integer v10;

   @Override
   public void onChange(Runnable var1) {
      this.v6 = var1;
   }

   public IntSetting(String var1, int var2, int var3, int var4) {
      if (var3 > var4) {
         throw new IllegalArgumentException("min > max for setting '" + var1 + "'");
      } else if (var2 >= var3 && var2 <= var4) {
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

   public Integer getValue() {
      Integer var1 = this.v10;
      if (var1 == null || var1 != this.v5) {
         var1 = this.v5;
         this.v10 = var1;
      }

      return var1;
   }

   public void setValue(Integer var1) {
      int var2 = var1 == null ? this.v2 : Math.max(this.v3, Math.min(this.v4, var1));
      if (var2 != this.v5) {
         this.v5 = var2;
         if (this.v6 != null) {
            this.v6.run();
         }
      }
   }

   @Override
   public Class<Integer> getType() {
      return Integer.class;
   }

   public int getMin() {
      return this.v3;
   }

   public int getMax() {
      return this.v4;
   }

   public IntSetting v1(@Nullable BooleanSetting var1) {
      this.v7 = var1;
      return this;
   }

   @Nullable
   public BooleanSetting v11() {
      return this.v7;
   }

   public IntSetting v1(String var1) {
      this.v9 = var1;
      return this;
   }

   public String v12() {
      return this.v9;
   }

   public IntSetting v13() {
      this.v8 = true;
      return this;
   }

   public boolean v14() {
      return this.v8;
   }

   @Override
   public JsonElement toJson() {
      return new JsonPrimitive(this.v5);
   }

   @Override
   public void fromJson(JsonElement var1) {
      if (var1 != null && var1.isJsonPrimitive() && var1.getAsJsonPrimitive().isNumber()) {
         this.setValue(var1.getAsInt());
      }
   }

   @Override
   public void reset() {
      this.v5 = this.v2;
   }

   @Override
   public boolean isModified() {
      return this.v5 != this.v2;
   }
}
