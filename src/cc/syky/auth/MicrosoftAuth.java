package cc.syky.auth;

import cc.syky.cloud.HttpTransport;
import cc.syky.ui.TheSignSupport;
import cc.syky.ui.uiSupport265;
import cc.syky.ui.uiSupport268;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.google.gson.JsonParser;
import java.io.IOException;
import java.net.URI;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.Map;
import java.util.Set;
import java.util.StringJoiner;
import java.util.UUID;
import java.util.function.LongSupplier;
import org.jetbrains.annotations.Nullable;

public final class MicrosoftAuth {
   public static final String v1 = "00000000402b5328";
   public static final String v2 = "XboxLive.signin offline_access";
   public static final String v3 = "urn:ietf:params:oauth:grant-type:device_code";
   private static final URI v4 = URI.create("https://login.live.com/oauth20_connect.srf");
   private static final URI v5 = URI.create("https://login.live.com/oauth20_token.srf");
   private static final URI v6 = URI.create("https://user.auth.xboxlive.com/user/authenticate");
   private static final URI v7 = URI.create("https://xsts.auth.xboxlive.com/xsts/authorize");
   private static final URI v8 = URI.create(uiSupport268.v1 + "/authentication/login_with_xbox");
   private static final URI v9 = URI.create(uiSupport268.v1 + "/minecraft/profile");
   private static final URI v10 = URI.create(uiSupport268.v1 + "/entitlements/mcstore");
   private static final String v11 = "application/x-www-form-urlencoded";
   private static final String v12 = "application/json";
   private static final long v13 = 900L;
   private static final long v14 = 5L;
   private static final long v15 = 86400L;
   private static final Set<String> v16 = Set.of("product_minecraft", "game_minecraft", "product_game_pass_pc", "product_game_pass_ultimate");
   private static final Map<Long, TheSignSupport> v18 = Map.of(
      2148916227L,
      TheSignSupport.XBOX_BANNED,
      2148916233L,
      TheSignSupport.NO_XBOX,
      2148916235L,
      TheSignSupport.XBOX_REGION,
      2148916236L,
      TheSignSupport.XBOX_AGE,
      2148916237L,
      TheSignSupport.XBOX_AGE,
      2148916238L,
      TheSignSupport.CHILD_ACCOUNT
   );
   private final HttpTransport v19;
   private final LongSupplier v17;

   public MicrosoftAuth(HttpTransport var1, LongSupplier var2) {
      this.v19 = var1;
      this.v17 = var2;
   }

   public MicrosoftAuth.Part4 v1() throws uiSupport265 {
      HttpTransport.Part1 var1 = this.v1(
         v1(
            v4,
            "application/x-www-form-urlencoded",
            v1("client_id", "00000000402b5328", "scope", "XboxLive.signin offline_access", "response_type", "device_code")
         ),
         "device code"
      );
      if (var1.v1() != 200) {
         throw v1(var1, "device code");
      } else {
         JsonObject var2 = v2(var1, "device code");
         String var3 = v2(var2, "user_code");
         String var4 = v2(var2, "device_code");
         String var5 = v2(var2, "verification_uri");
         if (var3 != null && var4 != null && var5 != null) {
            long var6 = v1(var2, "expires_in", 900L);
            long var8 = Math.max(1L, v1(var2, "interval", 5L));
            return new MicrosoftAuth.Part4(var3, var5, var4, this.v17.getAsLong() + var6 * 1000L, var8 * 1000L);
         } else {
            throw v6("device code");
         }
      }
   }

   public MicrosoftAuth.Part5 v1(MicrosoftAuth.Part4 var1) throws uiSupport265 {
      HttpTransport.Part1 var2 = this.v1(
         v1(
            v5,
            "application/x-www-form-urlencoded",
            v1("client_id", "00000000402b5328", "grant_type", "urn:ietf:params:oauth:grant-type:device_code", "device_code", var1.v4())
         ),
         "device code poll"
      );
      if (var2.v1() == 200) {
         return new MicrosoftAuth.Part2(this.v1(var2, null, "device code poll"));
      } else {
         String var3 = v1(var2);

         return switch (var3) {
            case "authorization_pending" -> new MicrosoftAuth.Part3(false);
            case "slow_down" -> new MicrosoftAuth.Part3(true);
            case "authorization_declined", "access_denied" -> throw new uiSupport265(TheSignSupport.DECLINED, var2.v1(), "the player declined the sign-in");
            case "expired_token", "bad_verification_code", "invalid_grant" -> throw new uiSupport265(
               TheSignSupport.CODE_EXPIRED, var2.v1(), "the device code expired: " + var3
            );
            default -> throw v1(var2, "device code poll (" + var3 + ")");
         };
      }
   }

   public MicrosoftAuth.Part6 v1(String var1) throws uiSupport265 {
      HttpTransport.Part1 var2 = this.v1(
         v1(
            v5,
            "application/x-www-form-urlencoded",
            v1("client_id", "00000000402b5328", "grant_type", "refresh_token", "refresh_token", var1, "scope", "XboxLive.signin offline_access")
         ),
         "token refresh"
      );
      if (var2.v1() == 200) {
         return this.v1(var2, var1, "token refresh");
      } else if ("invalid_grant".equals(v1(var2))) {
         throw new uiSupport265(TheSignSupport.SIGN_IN_AGAIN, var2.v1(), "Microsoft no longer accepts the refresh token");
      } else {
         throw v1(var2, "token refresh");
      }
   }

   public MicrosoftAuth.Part7 v2(String var1) throws uiSupport265 {
      JsonObject var2 = new JsonObject();
      var2.addProperty("AuthMethod", "RPS");
      var2.addProperty("SiteName", "user.auth.xboxlive.com");
      var2.addProperty("RpsTicket", "d=" + var1);
      JsonObject var3 = new JsonObject();
      var3.add("Properties", var2);
      var3.addProperty("RelyingParty", "http://auth.xboxlive.com");
      var3.addProperty("TokenType", "JWT");
      JsonObject var4 = this.v1(v6, var3, "Xbox Live");
      JsonObject var5 = new JsonObject();
      var5.addProperty("SandboxId", "RETAIL");
      JsonArray var6 = new JsonArray();
      var6.add(v1(var4, "Xbox Live"));
      var5.add("UserTokens", var6);
      JsonObject var7 = new JsonObject();
      var7.add("Properties", var5);
      var7.addProperty("RelyingParty", "rp://api.minecraftservices.com/");
      var7.addProperty("TokenType", "JWT");
      JsonObject var8 = this.v1(v7, var7, "XSTS");
      String var9 = v1(var8);
      JsonObject var10 = new JsonObject();
      var10.addProperty("identityToken", "XBL3.0 x=" + var9 + ";" + v1(var8, "XSTS"));
      HttpTransport.Part1 var11 = this.v1(v1(v8, "application/json", var10.toString()), "Minecraft sign-in");
      if (var11.v1() != 200) {
         throw v1(var11, "Minecraft sign-in");
      } else {
         JsonObject var12 = v2(var11, "Minecraft sign-in");
         String var13 = v2(var12, "access_token");
         if (var13 == null) {
            throw v6("Minecraft sign-in");
         } else {
            long var14 = v1(var12, "expires_in", 86400L);
            return new MicrosoftAuth.Part7(var13, this.v17.getAsLong() + var14 * 1000L);
         }
      }
   }

   public MicrosoftAuth.Part1 v3(String var1) throws uiSupport265 {
      HttpTransport.Part1 var2 = this.v1(v1(v9, var1), "profile");
      if (var2.v1() == 404) {
         boolean var14 = this.v5(var1);
         throw new uiSupport265(var14 ? TheSignSupport.NO_PROFILE : TheSignSupport.NO_MINECRAFT, 404, "the account has no Minecraft profile");
      } else if (var2.v1() == 401) {
         throw new uiSupport265(TheSignSupport.SIGN_IN_AGAIN, 401, "Minecraft refused the access token");
      } else if (var2.v1() != 200) {
         throw v1(var2, "profile");
      } else {
         JsonObject var3 = v2(var2, "profile");
         UUID var4 = v4(v2(var3, "id"));
         String var5 = v2(var3, "name");
         if (var4 != null && var5 != null && !var5.isEmpty()) {
            String var6 = null;
            boolean var7 = false;

            for (JsonElement var10 : var3.has("skins") && var3.get("skins").isJsonArray() ? var3.getAsJsonArray("skins") : new JsonArray()) {
               if (var10.isJsonObject()) {
                  JsonObject var11 = var10.getAsJsonObject();
                  String var12 = v2(var11, "url");
                  if (var12 != null) {
                     boolean var13 = "ACTIVE".equalsIgnoreCase(v2(var11, "state"));
                     if (var6 == null || var13) {
                        var6 = var12;
                        var7 = "SLIM".equalsIgnoreCase(v2(var11, "variant"));
                     }

                     if (var13) {
                        break;
                     }
                  }
               }
            }

            return new MicrosoftAuth.Part1(var4, var5, var6, var7);
         } else {
            throw v6("profile");
         }
      }
   }

   private boolean v5(String var1) {
      try {
         HttpTransport.Part1 var2 = this.v1(v1(v10, var1), "entitlements");
         if (var2.v1() != 200) {
            return false;
         } else {
            JsonObject var3 = v2(var2, "entitlements");

            for (JsonElement var6 : var3.has("items") && var3.get("items").isJsonArray() ? var3.getAsJsonArray("items") : new JsonArray()) {
               if (var6.isJsonObject() && v16.contains(v2(var6.getAsJsonObject(), "name"))) {
                  return true;
               }
            }

            return false;
         }
      } catch (uiSupport265 var7) {
         return false;
      }
   }

   private JsonObject v1(URI var1, JsonObject var2, String var3) throws uiSupport265 {
      HttpTransport.Part2 var4 = new HttpTransport.Part2(
         "POST", var1, Map.of("Accept", "application/json", "x-xbl-contract-version", "1"), "application/json", var2.toString()
      );
      HttpTransport.Part1 var5 = this.v1(var4, var3);
      if (var5.v1() == 200) {
         return v2(var5, var3);
      } else {
         JsonObject var6 = v7(var5.v2());
         if (var6 != null && var6.has("XErr") && var6.get("XErr").isJsonPrimitive()) {
            long var7;
            try {
               var7 = var6.get("XErr").getAsLong();
            } catch (NumberFormatException var10) {
               var7 = 0L;
            }

            TheSignSupport var9 = v18.get(var7);
            if (var9 != null) {
               throw new uiSupport265(var9, var5.v1(), var3 + " refused the account: XErr " + var7);
            } else {
               throw new uiSupport265(TheSignSupport.SERVICE, var5.v1(), var3 + " refused the account: XErr " + var7);
            }
         } else {
            throw v1(var5, var3);
         }
      }
   }

   private static String v1(JsonObject var0, String var1) throws uiSupport265 {
      String var2 = v2(var0, "Token");
      if (var2 == null) {
         throw v6(var1);
      } else {
         return var2;
      }
   }

   private static String v1(JsonObject var0) throws uiSupport265 {
      try {
         String var1 = var0.getAsJsonObject("DisplayClaims").getAsJsonArray("xui").get(0).getAsJsonObject().get("uhs").getAsString();
         if (!var1.isEmpty()) {
            return var1;
         }
      } catch (RuntimeException var2) {
      }

      throw v6("XSTS");
   }

   private MicrosoftAuth.Part6 v1(HttpTransport.Part1 var1, @Nullable String var2, String var3) throws uiSupport265 {
      JsonObject var4 = v2(var1, var3);
      String var5 = v2(var4, "access_token");
      String var6 = v2(var4, "refresh_token");
      if (var6 == null) {
         var6 = var2;
      }

      if (var5 != null && var6 != null) {
         return new MicrosoftAuth.Part6(var5, var6);
      } else {
         throw v6(var3);
      }
   }

   private HttpTransport.Part1 v1(HttpTransport.Part2 var1, String var2) throws uiSupport265 {
      try {
         return this.v19.v1(var1);
      } catch (IOException var4) {
         throw new uiSupport265(TheSignSupport.NETWORK, 0, var2 + ": " + var4.getMessage());
      }
   }

   private static HttpTransport.Part2 v1(URI var0, String var1, String var2) {
      return new HttpTransport.Part2("POST", var0, Map.of("Accept", "application/json"), var1, var2);
   }

   private static HttpTransport.Part2 v1(URI var0, String var1) {
      return new HttpTransport.Part2("GET", var0, Map.of("Accept", "application/json", "Authorization", "Bearer " + var1), null, null);
   }

   public static String v1(String... var0) {
      StringJoiner var1 = new StringJoiner("&");

      for (byte var2 = 0; var2 + 1 < var0.length; var2 += 2) {
         var1.add(URLEncoder.encode(var0[var2], StandardCharsets.UTF_8) + "=" + URLEncoder.encode(var0[var2 + 1], StandardCharsets.UTF_8));
      }

      return var1.toString();
   }

   private static uiSupport265 v1(HttpTransport.Part1 var0, String var1) {
      TheSignSupport var2 = var0.v1() == 429 ? TheSignSupport.RATE_LIMITED : TheSignSupport.SERVICE;
      return new uiSupport265(var2, var0.v1(), var1 + " answered HTTP " + var0.v1());
   }

   private static uiSupport265 v6(String var0) {
      return new uiSupport265(TheSignSupport.SERVICE, 200, var0 + " answered with something unexpected");
   }

   private static String v1(HttpTransport.Part1 var0) {
      JsonObject var1 = v7(var0.v2());
      String var2 = var1 == null ? null : v2(var1, "error");
      return var2 == null ? "" : var2;
   }

   private static JsonObject v2(HttpTransport.Part1 var0, String var1) throws uiSupport265 {
      JsonObject var2 = v7(var0.v2());
      if (var2 == null) {
         throw v6(var1);
      } else {
         return var2;
      }
   }

   @Nullable
   private static JsonObject v7(String var0) {
      if (var0.isBlank()) {
         return null;
      } else {
         try {
            JsonElement var1 = JsonParser.parseString(var0);
            return var1.isJsonObject() ? var1.getAsJsonObject() : null;
         } catch (JsonParseException var2) {
            return null;
         }
      }
   }

   @Nullable
   private static String v2(JsonObject var0, String var1) {
      JsonElement var2 = var0.get(var1);
      return var2 != null && var2.isJsonPrimitive() && var2.getAsJsonPrimitive().isString() ? var2.getAsString() : null;
   }

   private static long v1(JsonObject var0, String var1, long var2) {
      JsonElement var4 = var0.get(var1);
      if (var4 != null && var4.isJsonPrimitive() && var4.getAsJsonPrimitive().isNumber()) {
         try {
            return var4.getAsLong();
         } catch (NumberFormatException var6) {
            return var2;
         }
      } else {
         return var2;
      }
   }

   @Nullable
   public static UUID v4(@Nullable String var0) {
      if (var0 == null) {
         return null;
      } else {
         String var1 = var0.replace("-", "");
         if (var1.length() != 32) {
            return null;
         } else {
            try {
               return new UUID(Long.parseUnsignedLong(var1.substring(0, 16), 16), Long.parseUnsignedLong(var1.substring(16), 16));
            } catch (NumberFormatException var3) {
               return null;
            }
         }
      }
   }

   public record Part1(UUID id, String name, @Nullable String skinUrl, boolean slimSkin) {
      public UUID v1() {
         return this.id;
      }

      public String v2() {
         return this.name;
      }

      @Nullable
      public String v3() {
         return this.skinUrl;
      }

      public boolean v4() {
         return this.slimSkin;
      }
   }

   public record Part2(MicrosoftAuth.Part6 tokens) implements MicrosoftAuth.Part5 {
      public MicrosoftAuth.Part6 v1() {
         return this.tokens;
      }
   }

   public record Part3(boolean slowDown) implements MicrosoftAuth.Part5 {
      public boolean v1() {
         return this.slowDown;
      }
   }

   public record Part4(String userCode, String verificationUri, String deviceCode, long expiresAtMillis, long intervalMillis) {
      public String v1() {
         String var1 = this.verificationUri.indexOf(63) < 0 ? "?" : "&";
         return this.verificationUri + var1 + "otc=" + URLEncoder.encode(this.userCode, StandardCharsets.UTF_8);
      }

      @Override
      public String toString() {
         return "DeviceCode[" + this.userCode + " at " + this.verificationUri + "]";
      }

      public String v2() {
         return this.userCode;
      }

      public String v3() {
         return this.verificationUri;
      }

      public String v4() {
         return this.deviceCode;
      }

      public long v5() {
         return this.expiresAtMillis;
      }

      public long v6() {
         return this.intervalMillis;
      }
   }

   public sealed interface Part5 permits MicrosoftAuth.Part3, MicrosoftAuth.Part2 {
   }

   public record Part6(String accessToken, String refreshToken) {
      @Override
      public String toString() {
         return "MsTokens[redacted]";
      }

      public String v1() {
         return this.accessToken;
      }

      public String v2() {
         return this.refreshToken;
      }
   }

   public record Part7(String accessToken, long expiresAtMillis) {
      @Override
      public String toString() {
         return "McToken[expires " + this.expiresAtMillis + "]";
      }

      public String v1() {
         return this.accessToken;
      }

      public long v2() {
         return this.expiresAtMillis;
      }
   }
}
