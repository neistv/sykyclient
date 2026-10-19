package cc.syky.cloud;

import cc.syky.hud.hudSupport64;
import cc.syky.ui.uiSupport119;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.time.Instant;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.EnumMap;
import java.util.List;
import java.util.Locale;
import java.util.Objects;
import java.util.function.Consumer;
import net.minecraft.class_124;
import net.minecraft.class_2561;
import net.minecraft.class_310;
import org.jetbrains.annotations.Nullable;

public final class OnlyMeSupport2 {
   @Nullable
   private static OnlyMeSupport2 v1;
   private final CloudClient v2;
   private final uiSupport119 v3;
   @Nullable
   private String v4;
   private OnlyMeSupport2.Part5 v5 = OnlyMeSupport2.Part5.LOADING;
   private String v6 = "";
   @Nullable
   private OnlyMeSupport2.Part7 v7;
   private OnlyMeSupport2.Part6 v8 = OnlyMeSupport2.Part6.SIGNED_OUT;
   private boolean v9 = true;
   private List<OnlyMeSupport2.Part3> v10 = List.of();
   private int v11 = -1;
   private final EnumMap<OnlyMeSupport2.Part1, OnlyMeSupport2.Part4> v12 = v32();
   private boolean v13;
   private boolean v14;
   @Nullable
   private SykySession.Part1 v15;
   private boolean v16;
   private boolean v18;
   private boolean v19;
   private boolean v17;
   @Nullable
   private SykySession.Part1 v20;
   private boolean v21;
   private int v22;
   private int v24;
   private int v25 = -1;

   public static OnlyMeSupport2 v1(CloudClient var0) {
      OnlyMeSupport2 var1 = v1;
      if (var1 == null || var1.v2 != var0) {
         var1 = new OnlyMeSupport2(var0);
         v1 = var1;
      }

      return var1;
   }

   @Nullable
   public static OnlyMeSupport2 v1() {
      return v1;
   }

   private OnlyMeSupport2(CloudClient var1) {
      this.v2 = var1;
      this.v3 = new uiSupport119(var1);
   }

   public uiSupport119 v2() {
      return this.v3;
   }

   public int v3() {
      int var1 = this.v2.v3().v6();
      if (var1 != this.v25) {
         this.v25 = var1;
         this.v24++;
      }

      return this.v24;
   }

   public OnlyMeSupport2.Part5 v4() {
      return this.v5;
   }

   public String v5() {
      return this.v6;
   }

   @Nullable
   public OnlyMeSupport2.Part7 v6() {
      return this.v7;
   }

   public OnlyMeSupport2.Part6 v7() {
      OnlyMeSupport2.Part7 var1 = this.v7;
      if (this.v8 == OnlyMeSupport2.Part6.NONE && var1 != null) {
         return switch (this.v2.v3().v1(var1.v1())) {
            case NONE -> OnlyMeSupport2.Part6.NONE;
            case REQUEST_SENT -> OnlyMeSupport2.Part6.REQUEST_SENT;
            case REQUEST_RECEIVED -> OnlyMeSupport2.Part6.REQUEST_RECEIVED;
            case FRIENDS -> OnlyMeSupport2.Part6.FRIENDS;
         };
      } else {
         return this.v8;
      }
   }

   public boolean v8() {
      return this.v4 == null;
   }

   @Nullable
   public String v9() {
      return this.v4;
   }

   public boolean v10() {
      return this.v17;
   }

   public boolean v11() {
      return this.v9;
   }

   public OnlyMeSupport2.Part4 v1(OnlyMeSupport2.Part1 var1) {
      OnlyMeSupport2.Part4 var2 = this.v12.get(var1);
      return var2 == null ? var1.byDefault : var2;
   }

   public boolean v12() {
      return !this.v13;
   }

   public void v1(boolean var1) {
      if (this.v14 && this.v13 != !var1) {
         this.v13 = !var1;
         this.v19 = true;
         this.v23();
         this.v30();
      }
   }

   public boolean v13() {
      return this.v14;
   }

   public boolean v14() {
      SykySession.Part1 var1 = SykySession.v1();
      return var1 != null && var1.equals(this.v15);
   }

   public void v15() {
      SykySession.Part1 var1 = SykySession.v1();
      if (var1 != null && !this.v14() && !this.v16) {
         this.v16 = true;
         this.v2.v1("GET", "/v1/me", null, var2 -> {
            this.v16 = false;
            JsonObject var3 = v1(var2, "account");
            if (var3 != null && var1.equals(SykySession.v1()) && !this.v18 && !this.v19) {
               this.v1(var3, var1);
               this.v23();
            }
         }, var1x -> this.v16 = false);
      }
   }

   private void v1(JsonObject var1, @Nullable SykySession.Part1 var2) {
      this.v9 = cloudSupport60.v1(var1, "share_server", true);
      this.v2(v1(var1, "privacy"));
      this.v15 = var2;
   }

   public int v16() {
      GETSupport2 var1 = this.v2.v3();
      return this.v4 == null && var1.v4() == GETSupport2.Part3.READY ? var1.v1().size() : -1;
   }

   public int v18() {
      return this.v11;
   }

   public List<OnlyMeSupport2.Part3> v19() {
      return this.v10;
   }

   public CloudClient v17() {
      return this.v2;
   }

   public void v20() {
      if (this.v4 != null || !this.v21) {
         this.v4 = null;
         this.v22();
      }
   }

   public void v1(String var1) {
      SykySession.Part1 var2 = SykySession.v1();
      if (var2 != null && var2.v2().equalsIgnoreCase(var1)) {
         this.v20();
      } else {
         this.v4 = var1;
         this.v22();
      }
   }

   public void v21() {
      if (!this.v21 || this.v4 == null && !Objects.equals(SykySession.v1(), this.v20)) {
         this.v22();
      }
   }

   public void v22() {
      this.v21 = true;
      int var1 = ++this.v22;
      this.v17 = false;
      this.v5 = OnlyMeSupport2.Part5.LOADING;
      this.v6 = "";
      this.v11 = -1;
      this.v10 = List.of();
      SykySession.Part1 var2 = SykySession.v1();
      this.v20 = var2;
      this.v23();
      if (this.v4 == null) {
         if (var2 == null) {
            this.v7 = null;
            this.v8 = OnlyMeSupport2.Part6.SIGNED_OUT;
            this.v5 = OnlyMeSupport2.Part5.READY;
            this.v23();
         } else {
            this.v2.v1("GET", "/v1/me", null, var3 -> {
               if (var1 == this.v22) {
                  JsonObject var4 = v1(var3, "account");
                  if (var4 == null) {
                     this.v1(var1, "This install is not signed in.");
                  } else {
                     this.v7 = v1(var4, true);
                     this.v1(var4, var2);
                     this.v8 = OnlyMeSupport2.Part6.SELF;
                     this.v5 = OnlyMeSupport2.Part5.READY;
                     this.v23();
                     this.v2.v3().v8();
                     this.v1(var1);
                  }
               }
            }, var2x -> this.v1(var1, var2x));
         }
      } else {
         this.v7 = null;
         this.v2.v1("GET", "/v1/users/" + URLEncoder.encode(this.v4, StandardCharsets.UTF_8), null, var3 -> {
            if (var1 == this.v22) {
               this.v7 = v1(var3, false);
               this.v8 = var2 == null ? OnlyMeSupport2.Part6.SIGNED_OUT : OnlyMeSupport2.Part6.NONE;
               this.v5 = OnlyMeSupport2.Part5.READY;
               this.v23();
               if (var2 != null) {
                  this.v2.v3().v8();
               }
            }
         }, var2x -> this.v1(var1, var2x));
      }
   }

   private void v1(int var1, String var2) {
      if (var1 == this.v22) {
         this.v5 = OnlyMeSupport2.Part5.FAILED;
         this.v6 = var2;
         this.v23();
      }
   }

   private void v1(int var1) {
      this.v2.v1("GET", "/v1/me/cosmetics", null, var2 -> {
         if (var1 == this.v22) {
            this.v1(var2);
         }
      }, var0 -> {});
   }

   private void v1(JsonObject var1) {
      JsonArray var2 = v2(var1, "available");
      JsonObject var3 = v1(var1, "loadout");
      ArrayList var4 = new ArrayList();

      for (cloudSupport49 var8 : cloudSupport49.values()) {
         ArrayList var9 = new ArrayList();

         for (JsonElement var11 : var2) {
            if (var11.isJsonObject() && var8.v1().equals(cloudSupport60.v2(var11.getAsJsonObject(), "slot"))) {
               JsonObject var12 = var11.getAsJsonObject();
               var9.add(new OnlyMeSupport2.Part2(cloudSupport60.v2(var12, "id"), cloudSupport60.v2(var12, "name")));
            }
         }

         String var13 = var3 == null ? "" : cloudSupport60.v2(var3, var8.v1());
         var4.add(new OnlyMeSupport2.Part3(var8, List.copyOf(var9), var13.isEmpty() ? null : var13));
      }

      this.v10 = List.copyOf(var4);
      this.v11 = var2.size();
      this.v23();
   }

   public void v24() {
      OnlyMeSupport2.Part7 var1 = this.v7;
      if (var1 != null && this.v28()) {
         this.v2.v3().v1(var1.v1(), var1x -> this.v29(), this::v4);
      }
   }

   public void v25() {
      OnlyMeSupport2.Part7 var1 = this.v7;
      if (var1 != null && this.v28()) {
         this.v2.v3().v1(var1.v1(), this::v29, this::v4);
      }
   }

   public void v26() {
      OnlyMeSupport2.Part7 var1 = this.v7;
      if (var1 != null && this.v28()) {
         this.v2.v3().v2(var1.v1(), this::v29, this::v4);
      }
   }

   public void v27() {
      OnlyMeSupport2.Part7 var1 = this.v7;
      if (var1 != null && this.v28()) {
         this.v2.v3().v3(var1.v1(), this::v29, this::v4);
      }
   }

   private boolean v28() {
      if (this.v17) {
         return false;
      } else {
         this.v17 = true;
         this.v23();
         return true;
      }
   }

   private void v29() {
      this.v17 = false;
      this.v23();
   }

   private void v4(String var1) {
      this.v29();
      v2(var1);
   }

   public void v1(cloudSupport49 var1, @Nullable OnlyMeSupport2.Part2 var2) {
      if (!this.v17) {
         JsonObject var3 = new JsonObject();
         var3.addProperty("slot", var1.v1());
         var3.addProperty("cosmetic", var2 == null ? "" : var2.v1());
         this.v1("PUT", "/v1/me/loadout", var3, this::v1);
      }
   }

   public void v1(OnlyMeSupport2.Part1 var1, OnlyMeSupport2.Part4 var2) {
      if (this.v12.get(var1) != var2) {
         this.v12.put(var1, var2);
         this.v19 = true;
         this.v23();
         this.v30();
      }
   }

   private void v30() {
      if (!this.v18 && this.v19) {
         if (!this.v14()) {
            this.v19 = false;
         } else {
            this.v19 = false;
            this.v18 = true;
            JsonObject var1 = new JsonObject();
            this.v12.forEach((var1x, var2x) -> var1.addProperty(var1x.key, var2x.key));
            if (this.v14) {
               var1.addProperty("requests", this.v13 ? "nobody" : "everyone");
            }

            JsonObject var2 = new JsonObject();
            var2.add("privacy", var1);
            this.v2.v1("PATCH", "/v1/me", var2, var1x -> {
               this.v18 = false;
               this.v30();
            }, var1x -> {
               this.v18 = false;
               this.v19 = false;
               v2(var1x);
               this.v15 = null;
               this.v15();
            });
         }
      }
   }

   private void v2(@Nullable JsonObject var1) {
      this.v12.putAll(v32());
      this.v14 = false;
      this.v13 = false;
      if (var1 != null) {
         this.v14 = var1.has("requests");
         this.v13 = "nobody".equals(cloudSupport60.v2(var1, "requests"));

         for (OnlyMeSupport2.Part1 var5 : OnlyMeSupport2.Part1.values()) {
            OnlyMeSupport2.Part4 var6 = OnlyMeSupport2.Part4.v1(cloudSupport60.v2(var1, var5.key));
            if (var6 != null) {
               this.v12.put(var5, var6);
            }
         }
      }
   }

   private static EnumMap<OnlyMeSupport2.Part1, OnlyMeSupport2.Part4> v32() {
      EnumMap var0 = new EnumMap<>(OnlyMeSupport2.Part1.class);

      for (OnlyMeSupport2.Part1 var4 : OnlyMeSupport2.Part1.values()) {
         var0.put(var4, var4.byDefault);
      }

      return var0;
   }

   public void v2(boolean var1) {
      if (!this.v17) {
         JsonObject var2 = new JsonObject();
         var2.addProperty("share_server", var1);
         this.v1("PATCH", "/v1/me", var2, var2x -> {
            JsonObject var3 = v1(var2x, "account");
            this.v9 = var3 == null ? var1 : cloudSupport60.v1(var3, "share_server", var1);
         });
      }
   }

   private void v1(String var1, String var2, @Nullable JsonObject var3, Consumer<JsonObject> var4) {
      int var5 = this.v22;
      this.v17 = true;
      this.v23();
      this.v2.v1(var1, var2, var3, var3x -> {
         this.v17 = false;
         if (var5 == this.v22) {
            var4.accept(var3x);
         }

         this.v23();
      }, var1x -> {
         this.v17 = false;
         this.v23();
         v2(var1x);
      });
   }

   public static void v2(String var0) {
      class_310 var1 = class_310.method_1551();
      if (var1 != null && var1.field_1705 != null) {
         var1.field_1705.method_1743().method_1812(class_2561.method_43470(var0).method_27692(class_124.field_1061));
      }
   }

   private void v23() {
      this.v24++;
   }

   private static OnlyMeSupport2.Part7 v1(JsonObject var0, boolean var1) {
      Instant var2 = null;

      try {
         String var3 = cloudSupport60.v2(var0, "created_at");
         var2 = var3.isEmpty() ? null : Instant.parse(var3);
      } catch (DateTimeParseException var4) {
      }

      return new OnlyMeSupport2.Part7(
         cloudSupport60.v3(var0, "uid"),
         cloudSupport60.v2(var0, "username"),
         var2,
         var0.has("bio") ? cloudSupport60.v2(var0, "bio") : null,
         cloudSupport60.v3(var0, "avatar"),
         cloudSupport60.v3(var0, "banner"),
         var0.has("play_seconds") ? cloudSupport60.v3(var0, "play_seconds") : -1L,
         !var1 && var0.has("friends") ? (int)cloudSupport60.v3(var0, "friends") : -1,
         !var1 && var0.has("cosmetics") ? (int)cloudSupport60.v3(var0, "cosmetics") : -1
      );
   }

   @Nullable
   private static JsonObject v1(JsonObject var0, String var1) {
      JsonElement var2 = var0.get(var1);
      return var2 != null && var2.isJsonObject() ? var2.getAsJsonObject() : null;
   }

   private static JsonArray v2(JsonObject var0, String var1) {
      JsonElement var2 = var0.get(var1);
      return var2 != null && var2.isJsonArray() ? var2.getAsJsonArray() : new JsonArray();
   }

   public static String v3(String var0) {
      return var0.isEmpty() ? var0 : var0.substring(0, 1).toUpperCase(Locale.ROOT) + var0.substring(1);
   }

   public static enum Part1 {
      BIO("bio", "About", OnlyMeSupport2.Part4.EVERYONE),
      JOINED("joined", "Member since", OnlyMeSupport2.Part4.EVERYONE),
      PLAYED("played", "Time played", OnlyMeSupport2.Part4.NOBODY),
      FRIENDS("friends", "Friend count", OnlyMeSupport2.Part4.NOBODY),
      COSMETICS("cosmetics", "Cosmetics owned", OnlyMeSupport2.Part4.NOBODY);

      public final String key;
      public final String label;
      public final OnlyMeSupport2.Part4 byDefault;

      private Part1(String var3, String var4, OnlyMeSupport2.Part4 var5) {
         this.key = var3;
         this.label = var4;
         this.byDefault = var5;
      }
   }

   public record Part2(String id, String name) {
      public String v1() {
         return this.id;
      }

      public String v2() {
         return this.name;
      }
   }

   public record Part3(cloudSupport49 slot, List<OnlyMeSupport2.Part2> owned, @Nullable String worn) {
      @Nullable
      public OnlyMeSupport2.Part2 v1() {
         for (OnlyMeSupport2.Part2 var2 : this.owned) {
            if (var2.v1().equals(this.worn)) {
               return var2;
            }
         }

         return null;
      }

      public cloudSupport49 v2() {
         return this.slot;
      }

      public List<OnlyMeSupport2.Part2> v3() {
         return this.owned;
      }

      @Nullable
      public String v4() {
         return this.worn;
      }
   }

   public static enum Part4 implements hudSupport64 {
      EVERYONE("everyone", "Everyone"),
      FRIENDS("friends", "Friends"),
      NOBODY("nobody", "Only me");

      public final String key;
      public final String label;

      private Part4(String var3, String var4) {
         this.key = var3;
         this.label = var4;
      }

      @Override
      public String v1() {
         return this.label;
      }

      @Nullable
      public static OnlyMeSupport2.Part4 v1(String var0) {
         for (OnlyMeSupport2.Part4 var4 : values()) {
            if (var4.key.equals(var0)) {
               return var4;
            }
         }

         return null;
      }
   }

   public static enum Part5 {
      LOADING,
      READY,
      FAILED;

      private Part5() {
      }
   }

   public static enum Part6 {
      SELF,
      SIGNED_OUT,
      NONE,
      REQUEST_SENT,
      REQUEST_RECEIVED,
      FRIENDS;

      private Part6() {
      }
   }

   public record Part7(
      long uid, String username, @Nullable Instant createdAt, @Nullable String bio, long avatar, long banner, long playSeconds, int friends, int cosmetics
   ) {
      public long v1() {
         return this.uid;
      }

      public String v2() {
         return this.username;
      }

      @Nullable
      public Instant v3() {
         return this.createdAt;
      }

      @Nullable
      public String v4() {
         return this.bio;
      }

      public long v5() {
         return this.avatar;
      }

      public long v6() {
         return this.banner;
      }

      public long v7() {
         return this.playSeconds;
      }

      public int v8() {
         return this.friends;
      }

      public int v9() {
         return this.cosmetics;
      }
   }
}
