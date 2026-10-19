package cc.syky.ui;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import java.time.Instant;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.util.Collection;
import java.util.UUID;
import org.jetbrains.annotations.Nullable;

public final class uiSupport247 {
   public static final String v1 = "crash";
   public static final String v2 = "native";
   public static final String v3 = "hang";
   public static final String v4 = "unclean_exit";
   public static final String v5 = "error";
   public static final int v6 = 262144;
   private static final DateTimeFormatter v7 = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'").withZone(ZoneOffset.UTC);
   private final JsonObject v8 = new JsonObject();
   private final String v9 = UUID.randomUUID().toString();
   private final String v10;
   private final boolean v11;

   private uiSupport247(String var1, boolean var2, Instant var3) {
      this.v10 = var1;
      this.v11 = var2;
      this.v8.addProperty("v", 1);
      this.v8.addProperty("id", this.v9);
      this.v8.addProperty("kind", var1);
      this.v8.addProperty("fatal", var2);
      this.v8.addProperty("occurred_at", v7.format(var3));
   }

   public static uiSupport247 v1(String var0, Instant var1) {
      return new uiSupport247(var0, "crash".equals(var0) || "native".equals(var0), var1);
   }

   public String v1() {
      return this.v9;
   }

   public String v2() {
      return this.v10;
   }

   public boolean v3() {
      return this.v11;
   }

   public JsonObject v4() {
      return this.v8;
   }

   public uiSupport247 v1(@Nullable String var1) {
      return this.v1("session", var1);
   }

   public uiSupport247 v1(long var1) {
      if (var1 >= 0L) {
         this.v8.addProperty("uptime_ms", var1);
      }

      return this;
   }

   public uiSupport247 v2(@Nullable String var1) {
      return this.v1("phase", var1);
   }

   public uiSupport247 v3(@Nullable String var1) {
      return this.v1("thread", var1);
   }

   public uiSupport247 v4(String var1) {
      return this.v1("guard", var1);
   }

   public uiSupport247 v1(int var1) {
      this.v8.addProperty("count", var1);
      return this;
   }

   public uiSupport247 v2(long var1) {
      this.v8.addProperty("stuck_ms", var1);
      return this;
   }

   public uiSupport247 v1(@Nullable JsonObject var1) {
      return this.v1("throwable", var1);
   }

   public uiSupport247 v2(@Nullable JsonObject var1) {
      return this.v1("native", var1);
   }

   public uiSupport247 v1(@Nullable JsonArray var1) {
      return this.v1("threads", var1);
   }

   public uiSupport247 v3(JsonObject var1) {
      return this.v1("env", var1);
   }

   public uiSupport247 v2(@Nullable JsonArray var1) {
      return this.v1("mods", var1);
   }

   public uiSupport247 v1(@Nullable Collection<String> var1) {
      if (var1 != null) {
         JsonArray var2 = new JsonArray();
         var1.forEach(var2::add);
         this.v8.add("modules", var2);
      }

      return this;
   }

   public uiSupport247 v5(@Nullable String var1) {
      return this.v1("screen", var1);
   }

   public uiSupport247 v6(@Nullable String var1) {
      return this.v1("server", var1);
   }

   public uiSupport247 v3(@Nullable JsonArray var1) {
      return this.v1("breadcrumbs", var1);
   }

   public uiSupport247 v2(@Nullable Collection<String> var1) {
      if (var1 != null && !var1.isEmpty()) {
         JsonArray var2 = new JsonArray();
         var1.forEach(var2::add);
         this.v8.add("log", var2);
      }

      return this;
   }

   public uiSupport247 v7(@Nullable String var1) {
      return this.v1("report", var1 == null ? null : NativeMethodSupport.v1(var1, 262144));
   }

   private uiSupport247 v1(String var1, @Nullable String var2) {
      if (var2 != null && !var2.isEmpty()) {
         this.v8.addProperty(var1, var2);
      }

      return this;
   }

   private uiSupport247 v1(String var1, @Nullable JsonElement var2) {
      if (var2 != null) {
         this.v8.add(var1, var2);
      }

      return this;
   }
}
