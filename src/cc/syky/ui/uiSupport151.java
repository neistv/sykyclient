package cc.syky.ui;

import cc.syky.config.Setting;
import com.google.gson.JsonElement;
import com.google.gson.JsonNull;

public final class uiSupport151 implements Setting<String> {
   private final String v1;
   private final String v2;

   public uiSupport151(String var1, String var2) {
      this.v1 = var1;
      this.v2 = var2;
   }

   public String v1() {
      return this.v2;
   }

   @Override
   public String getName() {
      return this.v1;
   }

   public String v3() {
      return this.v2;
   }

   public void v1(String var1) {
   }

   @Override
   public Class<String> getType() {
      return String.class;
   }

   @Override
   public JsonElement toJson() {
      return JsonNull.INSTANCE;
   }

   @Override
   public void fromJson(JsonElement var1) {
   }

   @Override
   public void reset() {
   }
}
