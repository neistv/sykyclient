package cc.syky.config;

import com.google.gson.JsonElement;

public interface Setting<T> {
   String getName();

   T getValue();

   void setValue(T var1);

   Class<T> getType();

   JsonElement toJson();

   void fromJson(JsonElement var1);

   void reset();

   default boolean isModified() {
      return false;
   }

   default void onChange(Runnable var1) {
   }
}
