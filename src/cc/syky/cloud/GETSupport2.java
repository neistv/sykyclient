package cc.syky.cloud;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.time.Instant;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import org.jetbrains.annotations.Nullable;

public final class GETSupport2 {
   private final GETSupport2.Part4 v1;
   private List<GETSupport2.Part2> v2 = List.of();
   private List<GETSupport2.Part1> v3 = List.of();
   private List<GETSupport2.Part1> v4 = List.of();
   private GETSupport2.Part3 v5 = GETSupport2.Part3.LOADING;
   private String v6 = "";
   @Nullable
   private SykySession.Part1 v7;
   private boolean v8;
   private int v9;
   private int v10;

   public GETSupport2(GETSupport2.Part4 var1) {
      this.v1 = var1;
   }

   public List<GETSupport2.Part2> v1() {
      return this.v2;
   }

   public List<GETSupport2.Part1> v2() {
      return this.v3;
   }

   public List<GETSupport2.Part1> v3() {
      return this.v4;
   }

   public GETSupport2.Part3 v4() {
      return this.v5;
   }

   public String v5() {
      return this.v6;
   }

   public int v6() {
      return this.v10;
   }

   public GETSupport2.Part5 v1(long var1) {
      if (v1(this.v2, var2 -> var2.v1() == var1) != null) {
         return GETSupport2.Part5.FRIENDS;
      } else if (v1(this.v3, var2 -> var2.v1() == var1) != null) {
         return GETSupport2.Part5.REQUEST_RECEIVED;
      } else {
         return v1(this.v4, var2 -> var2.v1() == var1) != null ? GETSupport2.Part5.REQUEST_SENT : GETSupport2.Part5.NONE;
      }
   }

   public void v7() {
      if (!this.v8 || !Objects.equals(SykySession.v1(), this.v7)) {
         this.v8();
      }
   }

   public void v8() {
      this.v8 = true;
      int var1 = ++this.v9;
      SykySession.Part1 var2 = SykySession.v1();
      if (!Objects.equals(var2, this.v7)) {
         this.v2 = List.of();
         this.v3 = List.of();
         this.v4 = List.of();
      }

      this.v7 = var2;
      this.v6 = "";
      if (var2 == null) {
         this.v2 = List.of();
         this.v3 = List.of();
         this.v4 = List.of();
         this.v5 = GETSupport2.Part3.SIGNED_OUT;
         this.v9();
      } else {
         if (this.v5 != GETSupport2.Part3.READY) {
            this.v5 = GETSupport2.Part3.LOADING;
         }

         this.v9();
         this.v1.request("GET", "/v1/friends", null, var2x -> {
            if (var1 == this.v9) {
               this.v2 = v1(var2x, "friends", GETSupport2::v1);
               this.v3 = v1(var2x, "incoming", GETSupport2::v2);
               this.v4 = v1(var2x, "outgoing", GETSupport2::v2);
               this.v5 = GETSupport2.Part3.READY;
               this.v9();
            }
         }, var2x -> {
            if (var1 == this.v9) {
               this.v6 = var2x;
               if (this.v5 != GETSupport2.Part3.READY) {
                  this.v5 = GETSupport2.Part3.FAILED;
               }

               this.v9();
            }
         });
      }
   }

   public void v1(String var1, JsonObject var2) {
      if (this.v8 && SykySession.v1() != null && Objects.equals(SykySession.v1(), this.v7)) {
         if ("gateway_ready".equals(var1)) {
            this.v8();
         } else {
            long var3 = cloudSupport60.v3(var2, "uid");
            switch (var1) {
               case "friend_request":
                  this.v3 = v1(this.v3, v2(var2));
                  break;
               case "friend_request_removed":
                  this.v3 = v1(this.v3, var3);
                  this.v4 = v1(this.v4, var3);
                  break;
               case "friend_added":
                  this.v3 = v1(this.v3, var3);
                  this.v4 = v1(this.v4, var3);
                  this.v2 = v1(this.v2, v1(var2));
                  break;
               case "friend_removed":
                  this.v2 = v2(this.v2, var3);
                  break;
               case "friend_presence":
                  GETSupport2.Part2 var9 = v1(this.v2, var2x -> var2x.v1() == var3);
                  if (var9 == null) {
                     return;
                  }

                  boolean var8 = cloudSupport60.v1(var2, "online", false);
                  this.v2 = v1(
                     this.v2,
                     new GETSupport2.Part2(
                        var9.v1(),
                        var9.v2(),
                        var9.v3(),
                        var9.v4(),
                        var8,
                        var8 ? v1(var2, "server") : null,
                        var8 ? null : v1(var2, "last_seen", var9.v7()),
                        var9.v8()
                     )
                  );
                  break;
               case "friend_pinned":
                  GETSupport2.Part2 var7 = v1(this.v2, var2x -> var2x.v1() == var3);
                  if (var7 == null) {
                     return;
                  }

                  this.v2 = v1(this.v2, var7.v1(v1(var2, "pinned_at", null)));
                  break;
               default:
                  return;
            }

            this.v9();
         }
      }
   }

   public void v1(String var1, String var2, Consumer<GETSupport2.Part6> var3, Consumer<String> var4) {
      JsonObject var5 = new JsonObject();
      var5.addProperty("username", var1.strip());
      this.v1(var5, var2, var3, var4);
   }

   public void v1(long var1, Consumer<GETSupport2.Part6> var3, Consumer<String> var4) {
      this.v1(var1, "", var3, var4);
   }

   public void v1(String var1, Consumer<GETSupport2.Part6> var2) {
      this.v1.request("GET", "/v1/users/" + URLEncoder.encode(var1.strip(), StandardCharsets.UTF_8), null, var1x -> {
         long var2x = cloudSupport60.v3(var1x, "uid");
         String var4 = cloudSupport60.v2(var1x, "username");
         var2.accept(var2x > 0L && !var4.isEmpty() ? new GETSupport2.Part6(var2x, var4, false) : null);
      }, var1x -> var2.accept(null));
   }

   public void v1(long var1, String var3, Consumer<GETSupport2.Part6> var4, Consumer<String> var5) {
      JsonObject var6 = new JsonObject();
      var6.addProperty("uid", var1);
      this.v1(var6, var3, var4, var5);
   }

   private void v1(JsonObject var1, String var2, Consumer<GETSupport2.Part6> var3, Consumer<String> var4) {
      String var5 = cloudSupport86.v3(var2);
      if (!var5.isEmpty()) {
         var1.addProperty("message", var5);
      }

      int var6 = this.v9;
      this.v1
         .request(
            "POST",
            "/v1/friends/requests",
            var1,
            var4x -> {
               GETSupport2.Part6 var5x = new GETSupport2.Part6(
                  cloudSupport60.v3(var4x, "uid"), cloudSupport60.v2(var4x, "username"), "accepted".equals(cloudSupport60.v2(var4x, "status"))
               );
               if (var6 == this.v9 && !var5x.v3() && var5x.v1() != 0L && this.v1(var5x.v1()) == GETSupport2.Part5.NONE) {
                  this.v4 = v1(this.v4, new GETSupport2.Part1(var5x.v1(), var5x.v2(), 0L, Instant.now(), var5));
                  this.v9();
               }

               var3.accept(var5x);
            },
            var4
         );
   }

   public void v1(long var1, Runnable var3, Consumer<String> var4) {
      this.v1("POST", "/v1/friends/requests/" + var1 + "/accept", this::v8, var3, var4);
   }

   public void v2(long var1, Runnable var3, Consumer<String> var4) {
      this.v1("DELETE", "/v1/friends/requests/" + var1, () -> {
         this.v3 = v1(this.v3, var1);
         this.v4 = v1(this.v4, var1);
      }, var3, var4);
   }

   public void v3(long var1, Runnable var3, Consumer<String> var4) {
      this.v1("DELETE", "/v1/friends/" + var1, () -> this.v2 = v2(this.v2, var1), var3, var4);
   }

   public void v1(long var1, boolean var3, Consumer<String> var4) {
      GETSupport2.Part2 var5 = v1(this.v2, var2 -> var2.v1() == var1);
      if (var5 != null && var5.v8() != null != var3) {
         Instant var6 = var5.v8();
         this.v2 = v1(this.v2, var5.v1(var3 ? Instant.now() : null));
         this.v9();
         int var7 = this.v9;
         this.v1.request(var3 ? "PUT" : "DELETE", "/v1/friends/pins/" + var1, null, var0 -> {}, var6x -> {
            GETSupport2.Part2 var7x = v1(this.v2, var2 -> var2.v1() == var1);
            if (var7 == this.v9 && var7x != null) {
               this.v2 = v1(this.v2, var7x.v1(var6));
               this.v9();
            }

            var4.accept(var6x);
         });
      }
   }

   public void v4(long var1, Runnable var3, Consumer<String> var4) {
      this.v1("PUT", "/v1/blocks/" + var1, () -> {
         this.v2 = v2(this.v2, var1);
         this.v3 = v1(this.v3, var1);
         this.v4 = v1(this.v4, var1);
      }, var3, var4);
   }

   private void v1(String var1, String var2, Runnable var3, Runnable var4, Consumer<String> var5) {
      int var6 = this.v9;
      this.v1.request(var1, var2, null, var4x -> {
         if (var6 == this.v9) {
            var3.run();
            this.v9();
         }

         var4.run();
      }, var5);
   }

   private void v9() {
      this.v10++;
   }

   @Nullable
   private static <T> T v1(List<T> var0, Predicate<T> var1) {
      for (Object var3 : var0) {
         if (var1.test(var3)) {
            return (T)var3;
         }
      }

      return null;
   }

   private static List<GETSupport2.Part1> v1(List<GETSupport2.Part1> var0, GETSupport2.Part1 var1) {
      ArrayList var2 = new ArrayList(var0.size() + 1);
      var2.add(var1);

      for (GETSupport2.Part1 var4 : var0) {
         if (var4.v1() != var1.v1()) {
            var2.add(var4);
         }
      }

      return List.copyOf(var2);
   }

   private static List<GETSupport2.Part2> v1(List<GETSupport2.Part2> var0, GETSupport2.Part2 var1) {
      ArrayList var2 = new ArrayList(var0.size() + 1);
      boolean var3 = false;

      for (GETSupport2.Part2 var5 : var0) {
         if (var5.v1() == var1.v1()) {
            var2.add(var1);
            var3 = true;
         } else {
            var2.add(var5);
         }
      }

      if (!var3) {
         var2.add(var1);
      }

      return List.copyOf(var2);
   }

   private static List<GETSupport2.Part1> v1(List<GETSupport2.Part1> var0, long var1) {
      return v1(var0, var2 -> var2.v1() == var1) == null ? var0 : var0.stream().filter(var2 -> var2.v1() != var1).toList();
   }

   private static List<GETSupport2.Part2> v2(List<GETSupport2.Part2> var0, long var1) {
      return v1(var0, var2 -> var2.v1() == var1) == null ? var0 : var0.stream().filter(var2 -> var2.v1() != var1).toList();
   }

   private static <T> List<T> v1(JsonObject var0, String var1, Function<JsonObject, T> var2) {
      JsonElement var3 = var0.get(var1);
      if (var3 != null && var3.isJsonArray()) {
         JsonArray var4 = var3.getAsJsonArray();
         ArrayList var5 = new ArrayList(var4.size());

         for (JsonElement var7 : var4) {
            if (var7.isJsonObject()) {
               var5.add(var2.apply(var7.getAsJsonObject()));
            }
         }

         return List.copyOf(var5);
      } else {
         return List.of();
      }
   }

   private static GETSupport2.Part2 v1(JsonObject var0) {
      boolean var1 = cloudSupport60.v1(var0, "online", false);
      return new GETSupport2.Part2(
         cloudSupport60.v3(var0, "uid"),
         cloudSupport60.v2(var0, "username"),
         cloudSupport60.v3(var0, "avatar"),
         v2(var0, "since"),
         var1,
         v1(var0, "server"),
         var1 ? null : v1(var0, "last_seen", null),
         v1(var0, "pinned_at", null)
      );
   }

   private static GETSupport2.Part1 v2(JsonObject var0) {
      return new GETSupport2.Part1(
         cloudSupport60.v3(var0, "uid"),
         cloudSupport60.v2(var0, "username"),
         cloudSupport60.v3(var0, "avatar"),
         v2(var0, "sent"),
         cloudSupport60.v2(var0, "message")
      );
   }

   @Nullable
   private static String v1(JsonObject var0, String var1) {
      String var2 = cloudSupport60.v2(var0, var1);
      return var2.isEmpty() ? null : var2;
   }

   private static Instant v2(JsonObject var0, String var1) {
      Instant var2 = v1(var0, var1, null);
      return var2 == null ? Instant.EPOCH : var2;
   }

   @Nullable
   private static Instant v1(JsonObject var0, String var1, @Nullable Instant var2) {
      String var3 = cloudSupport60.v2(var0, var1);
      if (var3.isEmpty()) {
         return var2;
      } else {
         try {
            return Instant.parse(var3);
         } catch (DateTimeParseException var5) {
            return var2;
         }
      }
   }

   public record Part1(long uid, String username, long avatar, Instant sent, String message) {
      public long v1() {
         return this.uid;
      }

      public String v2() {
         return this.username;
      }

      public long v3() {
         return this.avatar;
      }

      public Instant v4() {
         return this.sent;
      }

      public String v5() {
         return this.message;
      }
   }

   public record Part2(
      long uid, String username, long avatar, Instant since, boolean online, @Nullable String server, @Nullable Instant lastSeen, @Nullable Instant pinnedAt
   ) {
      public GETSupport2.Part2 v1(@Nullable Instant var1) {
         return new GETSupport2.Part2(this.uid, this.username, this.avatar, this.since, this.online, this.server, this.lastSeen, var1);
      }

      public long v1() {
         return this.uid;
      }

      public String v2() {
         return this.username;
      }

      public long v3() {
         return this.avatar;
      }

      public Instant v4() {
         return this.since;
      }

      public boolean v5() {
         return this.online;
      }

      @Nullable
      public String v6() {
         return this.server;
      }

      @Nullable
      public Instant v7() {
         return this.lastSeen;
      }

      @Nullable
      public Instant v8() {
         return this.pinnedAt;
      }
   }

   public static enum Part3 {
      LOADING,
      READY,
      FAILED,
      SIGNED_OUT;

      private Part3() {
      }
   }

   @FunctionalInterface
   public interface Part4 {
      void request(String var1, String var2, @Nullable JsonObject var3, Consumer<JsonObject> var4, Consumer<String> var5);
   }

   public static enum Part5 {
      NONE,
      REQUEST_SENT,
      REQUEST_RECEIVED,
      FRIENDS;

      private Part5() {
      }
   }

   public record Part6(long uid, String username, boolean accepted) {
      public long v1() {
         return this.uid;
      }

      public String v2() {
         return this.username;
      }

      public boolean v3() {
         return this.accepted;
      }
   }
}
