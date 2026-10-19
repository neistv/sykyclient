package cc.syky.module.visual;

import cc.syky.config.Setting;
import com.google.gson.JsonElement;
import com.google.gson.JsonPrimitive;
import java.util.function.Supplier;
import org.jetbrains.annotations.Nullable;

public final class visualSupport7 implements Setting<String> {
   private final String v1;
   private final String v2;
   private String v3 = "";
   @Nullable
   private Runnable v4;
   private Supplier<String> v5 = () -> null;
   @Nullable
   private Runnable v6;

   public visualSupport7(String var1, String var2) {
      this.v1 = var1;
      this.v2 = var2;
   }

   public visualSupport7 v2(Runnable var1) {
      this.v4 = var1;
      return this;
   }

   public visualSupport7 v1(Supplier<String> var1) {
      this.v5 = var1;
      return this;
   }

   public void v1() {
      Runnable var1 = this.v4;
      if (var1 != null) {
         var1.run();
      }
   }

   public String v8() {
      return this.v2;
   }

   @Nullable
   public String v9() {
      return this.v5.get();
   }

   public boolean v10() {
      return !this.v3.isEmpty();
   }

   public String v11() {
      int var1 = Math.max(this.v3.lastIndexOf(47), this.v3.lastIndexOf(92));
      return this.v3.substring(var1 + 1);
   }

   @Override
   public void onChange(Runnable var1) {
      this.v6 = var1;
   }

   @Override
   public String getName() {
      return this.v1;
   }

   public String v12() {
      return this.v3;
   }

   public void v1(String var1) {
      String var2 = var1 == null ? "" : var1.strip();
      if (!var2.equals(this.v3)) {
         this.v3 = var2;
         if (this.v6 != null) {
            this.v6.run();
         }
      }
   }

   @Override
   public Class<String> getType() {
      return String.class;
   }

   @Override
   public JsonElement toJson() {
      return new JsonPrimitive(this.v3);
   }

   @Override
   public void fromJson(JsonElement var1) {
      if (var1 != null && var1.isJsonPrimitive() && var1.getAsJsonPrimitive().isString()) {
         this.v3 = var1.getAsString().strip();
      }
   }

   @Override
   public void reset() {
      this.v3 = "";
   }

   @Override
   public boolean isModified() {
      return !this.v3.isEmpty();
   }
}
