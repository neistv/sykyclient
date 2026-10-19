package cc.syky.module.visual;

import cc.syky.config.BooleanSetting;
import cc.syky.config.Setting;
import cc.syky.config.SettingOwner;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import java.util.EnumSet;
import org.jetbrains.annotations.Nullable;

public final class visualSupport6<E extends Enum<E>> implements SettingOwner, Setting<EnumSet<E>> {
   private final String v1;
   private final Class<E> v2;
   private final E[] v3;
   private final EnumSet<E> v4;
   private final EnumSet<E> v5;
   @Nullable
   private Runnable v6;
   @Nullable
   private BooleanSetting v7;

   public visualSupport6<E> v1(@Nullable BooleanSetting var1) {
      this.v7 = var1;
      return this;
   }

   @Nullable
   public BooleanSetting v8() {
      return this.v7;
   }

   @Override
   public void onChange(Runnable var1) {
      this.v6 = var1;
   }

   public visualSupport6(String var1, Class<E> var2, EnumSet<E> var3) {
      if (var3 == null) {
         throw new IllegalArgumentException("defaultValue must not be null");
      } else {
         this.v1 = var1;
         this.v2 = var2;
         this.v3 = (E[])var2.getEnumConstants();
         this.v4 = EnumSet.copyOf(var3);
         this.v5 = EnumSet.copyOf(var3);
      }
   }

   @Override
   public String getName() {
      return this.v1;
   }

   public EnumSet<E> v9() {
      return this.v5;
   }

   public void v1(EnumSet<E> var1) {
      EnumSet var2 = EnumSet.copyOf(this.v5);
      this.v5.clear();
      if (var1 != null) {
         this.v5.addAll(var1);
      }

      if (!var2.equals(this.v5) && this.v6 != null) {
         this.v6.run();
      }
   }

   public boolean v1(E var1) {
      return this.v5.contains(var1);
   }

   public void v2(E var1) {
      if (!this.v5.add((E)var1)) {
         this.v5.remove(var1);
      }

      if (this.v6 != null) {
         this.v6.run();
      }
   }

   @Override
   public Class<EnumSet<E>> getType() {
      return EnumSet.class;
   }

   public Class<E> v10() {
      return this.v2;
   }

   public E[] v11() {
      return this.v3;
   }

   @Override
   public JsonElement toJson() {
      JsonObject var1 = new JsonObject();

      for (Enum var5 : this.v3) {
         var1.addProperty(var5.name(), this.v5.contains(var5));
      }

      return var1;
   }

   @Override
   public void fromJson(JsonElement var1) {
      if (var1 != null) {
         if (var1.isJsonObject()) {
            JsonObject var10 = var1.getAsJsonObject();
            this.v5.clear();

            for (Enum var6 : this.v3) {
               JsonElement var7 = var10.get(var6.name());
               boolean var8 = v2(var7) ? var7.getAsBoolean() : this.v4.contains(var6);
               if (var8) {
                  this.v5.add((E)var6);
               }
            }
         } else if (var1.isJsonArray()) {
            this.v5.clear();

            for (JsonElement var3 : var1.getAsJsonArray()) {
               if (var3.isJsonPrimitive() && var3.getAsJsonPrimitive().isString()) {
                  try {
                     this.v5.add(Enum.valueOf(this.v2, var3.getAsString()));
                  } catch (IllegalArgumentException var9) {
                  }
               }
            }
         }
      }
   }

   private static boolean v2(JsonElement var0) {
      return var0 != null && var0.isJsonPrimitive() && var0.getAsJsonPrimitive().isBoolean();
   }

   @Override
   public void reset() {
      this.v5.clear();
      this.v5.addAll(this.v4);
   }

   @Override
   public boolean isModified() {
      return !this.v5.equals(this.v4);
   }
}
