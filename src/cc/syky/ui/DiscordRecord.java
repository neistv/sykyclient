package cc.syky.ui;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import org.jetbrains.annotations.Nullable;

public record DiscordRecord(@Nullable String line) {
   public static final DiscordRecord PLAIN = new DiscordRecord(null);
   private static final String LARGE_IMAGE = "https://i.postimg.cc/yxgTWxcJ/syky-client-white-logo.png";
   private static final int TYPE_COMPETING = 5;
   private static final String TITLE = "syky client";
   private static final String DISCORD_LABEL = "Discord";
   private static final String SITE_LABEL = "Website";
   private static final String SITE_URL = "https://sykyclient.com";
   private static final long SESSION_START_SECONDS = System.currentTimeMillis() / 1000L;

   public JsonObject v1() {
      JsonObject var1 = new JsonObject();
      var1.addProperty("type", 5);
      var1.addProperty("details", "syky client");
      if (this.line != null && !this.line.isEmpty()) {
         var1.addProperty("state", this.line);
      }

      JsonObject var2 = new JsonObject();
      var2.addProperty("start", SESSION_START_SECONDS);
      var1.add("timestamps", var2);
      JsonObject var3 = new JsonObject();
      var3.addProperty("large_image", "https://i.postimg.cc/yxgTWxcJ/syky-client-white-logo.png");
      var1.add("assets", var3);
      JsonArray var4 = new JsonArray();
      var4.add(v1("Discord", "https://discord.gg/Gz3rZfQJvv"));
      var4.add(v1("Website", "https://sykyclient.com"));
      var1.add("buttons", var4);
      return var1;
   }

   private static JsonObject v1(String var0, String var1) {
      JsonObject var2 = new JsonObject();
      var2.addProperty("label", var0);
      var2.addProperty("url", var1);
      return var2;
   }

   @Nullable
   public String v2() {
      return this.line;
   }
}
