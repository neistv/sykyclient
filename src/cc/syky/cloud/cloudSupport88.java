package cc.syky.cloud;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.google.gson.JsonParser;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;
import java.util.UUID;
import java.util.concurrent.Executor;
import org.jetbrains.annotations.Nullable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public final class cloudSupport88 {
   private static final Logger v3 = LoggerFactory.getLogger("syky.cloud");
   public static final long v1 = 86400000L;
   public static final int v2 = 300;
   private static final long v4 = 30000L;
   private final Path v5;
   private final Executor v6;
   private final Map<Long, cloudSupport88.Part1> v7 = new LinkedHashMap<>();
   private int v8;
   private boolean v9;
   private long v10;

   private cloudSupport88(Path var1, Executor var2) {
      this.v5 = var1;
      this.v6 = var2;
   }

   public static cloudSupport88 v1(Path var0, Executor var1) {
      cloudSupport88 var2 = new cloudSupport88(var0, var1);

      try {
         JsonElement var3 = JsonParser.parseString(Files.readString(var0, StandardCharsets.UTF_8));
         if (var3.isJsonObject() && var3.getAsJsonObject().get("met") instanceof JsonArray var4) {
            long var12 = System.currentTimeMillis();

            for (JsonElement var8 : var4) {
               cloudSupport88.Part1 var9 = var8.isJsonObject() ? v1(var8.getAsJsonObject()) : null;
               if (var9 != null && var12 - var9.v8() < 86400000L) {
                  var2.v7.put(var9.v1(), var9);
               }
            }
         }
      } catch (NoSuchFileException var10) {
      } catch (JsonParseException | IllegalStateException | IOException var11) {
         v3.warn("recently_met.json is unreadable; starting an empty list", var11);
      }

      return var2;
   }

   @Nullable
   private static cloudSupport88.Part1 v1(JsonObject var0) {
      long var1 = cloudSupport60.v3(var0, "uid");
      String var3 = cloudSupport60.v2(var0, "username");
      String var4 = cloudSupport60.v2(var0, "name");

      try {
         UUID var5 = UUID.fromString(cloudSupport60.v2(var0, "uuid"));
         if (var1 > 0L && !var3.isEmpty() && !var4.isEmpty()) {
            String var6 = cloudSupport60.v1(var0, "skin");
            String var7 = cloudSupport60.v1(var0, "skinSignature");
            return new cloudSupport88.Part1(
               var1, var3, var4, var5, cloudSupport60.v2(var0, "server"), var6, var7, cloudSupport60.v3(var0, "seenAt"), cloudSupport60.v3(var0, "nearAt")
            );
         } else {
            return null;
         }
      } catch (IllegalArgumentException var8) {
         return null;
      }
   }

   public int v1() {
      return this.v8;
   }

   public List<cloudSupport88.Part1> v1(long var1) {
      ArrayList var3 = new ArrayList();

      for (cloudSupport88.Part1 var5 : this.v3(var1)) {
         if (var5.v1(var1)) {
            var3.add(var5);
         }
      }

      return var3;
   }

   public List<cloudSupport88.Part1> v2(long var1) {
      ArrayList var3 = new ArrayList();

      for (cloudSupport88.Part1 var5 : this.v3(var1)) {
         if (!var5.v1(var1)) {
            var3.add(var5);
         }
      }

      return var3;
   }

   public List<cloudSupport88.Part1> v3(long var1) {
      ArrayList var3 = new ArrayList(this.v7.size());

      for (cloudSupport88.Part1 var5 : this.v7.values()) {
         if (var1 - var5.v8() < 86400000L) {
            var3.add(var5);
         }
      }

      var3.sort(Comparator.comparingLong(cloudSupport88.Part1::v8).reversed());
      return var3;
   }

   public List<cloudSupport88.Part1> v1(String var1, long var2) {
      String var4 = var1.strip().toLowerCase(Locale.ROOT);
      ArrayList var5 = new ArrayList(1);

      for (cloudSupport88.Part1 var7 : this.v3(var2)) {
         if (var7.v3().toLowerCase(Locale.ROOT).equals(var4)) {
            var5.add(var7);
         }
      }

      return var5;
   }

   public void v1(cloudSupport88.Part1 var1) {
      cloudSupport88.Part1 var2 = this.v7.remove(var1.v1());
      if (var2 != null && var1.v9() < var2.v9()) {
         var1 = new cloudSupport88.Part1(var1.v1(), var1.v2(), var1.v3(), var1.v4(), var1.v5(), var1.v6(), var1.v7(), var1.v8(), var2.v9());
      }

      this.v7.put(var1.v1(), var1);
      if (var2 == null
         || var2.v9() == 0L != (var1.v9() == 0L)
         || !var2.v3().equals(var1.v3())
         || !var2.v2().equals(var1.v2())
         || !var2.v5().equals(var1.v5())
         || !Objects.equals(var2.v6(), var1.v6())) {
         this.v8++;
      }

      while (this.v7.size() > 300) {
         cloudSupport88.Part1 var3 = null;

         for (cloudSupport88.Part1 var5 : this.v7.values()) {
            if (var3 == null || var5.v8() < var3.v8()) {
               var3 = var5;
            }
         }

         if (var3 == null) {
            break;
         }

         this.v7.remove(var3.v1());
         this.v8++;
      }

      this.v9 = true;
   }

   public void v4(long var1) {
      if (this.v9 && var1 - this.v10 >= 30000L) {
         this.v9 = false;
         this.v10 = var1;
         JsonArray var3 = new JsonArray();

         for (cloudSupport88.Part1 var5 : this.v7.values()) {
            JsonObject var6 = new JsonObject();
            var6.addProperty("uid", var5.v1());
            var6.addProperty("username", var5.v2());
            var6.addProperty("name", var5.v3());
            var6.addProperty("uuid", var5.v4().toString());
            if (!var5.v5().isEmpty()) {
               var6.addProperty("server", var5.v5());
            }

            if (var5.v6() != null) {
               var6.addProperty("skin", var5.v6());
            }

            if (var5.v7() != null) {
               var6.addProperty("skinSignature", var5.v7());
            }

            var6.addProperty("seenAt", var5.v8());
            if (var5.v9() > 0L) {
               var6.addProperty("nearAt", var5.v9());
            }

            var3.add(var6);
         }

         JsonObject var7 = new JsonObject();
         var7.add("met", var3);
         String var8 = var7.toString();
         this.v6.execute(() -> {
            try {
               cloudSupport66.v1(this.v5, var8);
            } catch (IOException var3x) {
               v3.warn("could not write recently_met.json", var3x);
            }
         });
      }
   }

   public record Part1(
      long uid, String username, String name, UUID uuid, String server, @Nullable String skin, @Nullable String skinSignature, long seenAt, long nearAt
   ) {
      public boolean v1(long var1) {
         return this.nearAt > 0L && var1 - this.nearAt < 86400000L;
      }

      public long v1() {
         return this.uid;
      }

      public String v2() {
         return this.username;
      }

      public String v3() {
         return this.name;
      }

      public UUID v4() {
         return this.uuid;
      }

      public String v5() {
         return this.server;
      }

      @Nullable
      public String v6() {
         return this.skin;
      }

      @Nullable
      public String v7() {
         return this.skinSignature;
      }

      public long v8() {
         return this.seenAt;
      }

      public long v9() {
         return this.nearAt;
      }
   }
}
