package cc.syky.crash;

import cc.syky.cloud.cloudSupport60;
import cc.syky.cloud.cloudSupport66;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public final class crashSupport2 {
   public static final String v1 = "state.json";
   private static final int v2 = 32;
   private final Path v3;

   public crashSupport2(Path var1) {
      this.v3 = var1.resolve("state.json");
   }

   public synchronized crashSupport2.Part1 v1() {
      JsonObject var1 = this.v2();
      return new crashSupport2.Part1(cloudSupport60.v3(var1, "lastScan"), cloudSupport60.v1(var1, "captured", var0 -> !var0.isBlank()));
   }

   public synchronized void v1(long var1) {
      JsonObject var3 = this.v2();
      var3.addProperty("lastScan", var1);
      this.v1(var3);
   }

   public synchronized void v1(String var1) {
      JsonObject var2 = this.v2();
      ArrayList var3 = new ArrayList<>(cloudSupport60.v1(var2, "captured", var0 -> !var0.isBlank()));
      var3.remove(var1);
      var3.add(var1);

      while (var3.size() > 32) {
         var3.remove(0);
      }

      JsonArray var4 = new JsonArray();
      var3.forEach(var4::add);
      var2.add("captured", var4);
      this.v1(var2);
   }

   private JsonObject v2() {
      try {
         JsonElement var1 = JsonParser.parseString(Files.readString(this.v3, StandardCharsets.UTF_8));
         return var1.isJsonObject() ? var1.getAsJsonObject() : new JsonObject();
      } catch (RuntimeException | IOException var2) {
         return new JsonObject();
      }
   }

   private void v1(JsonObject var1) {
      try {
         cloudSupport66.v1(this.v3, var1.toString());
      } catch (IOException var3) {
      }
   }

   public record Part1(long lastScan, List<String> captured) {
      public long v1() {
         return this.lastScan;
      }

      public List<String> v2() {
         return this.captured;
      }
   }
}
