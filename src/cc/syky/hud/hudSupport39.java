package cc.syky.hud;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import java.util.Map;
import org.jetbrains.annotations.Nullable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public final class hudSupport39 {
   public static final String v1 = "_hudstyle";
   public static final String v2 = "_hudstyle_global";
   private static final Logger v3 = LoggerFactory.getLogger("syky.hud.style");
   private final MySettingsSupport v4;

   public hudSupport39(MySettingsSupport var1) {
      this.v4 = var1;
   }

   public int v1(Map<String, HudElement> var1, AutoSupport var2) {
      var2.v19();

      for (HudElement var4 : var1.values()) {
         var4.v2().v19();
      }

      JsonObject var11 = this.v4.v11("_hudstyle_global");
      if (var11 != null) {
         try {
            var2.v1(v2(var11));
         } catch (RuntimeException var10) {
            v3.warn("invalid global hud style, keeping defaults", var10);
         }
      }

      if (this.v1(var11)) {
         var2.v18();
      }

      JsonObject var12 = this.v4.v11("_hudstyle");
      if (var12 == null) {
         return 0;
      } else {
         int var5 = 0;

         for (HudElement var7 : var1.values()) {
            if (var12.has(var7.v1()) && var12.get(var7.v1()).isJsonObject()) {
               try {
                  var7.v2().v1(var12.getAsJsonObject(var7.v1()));
                  var5++;
               } catch (RuntimeException var9) {
                  v3.warn("invalid hud style for '{}', keeping defaults", var7.v1(), var9);
               }
            }
         }

         return var5;
      }
   }

   private boolean v1(@Nullable JsonObject var1) {
      return var1 != null ? !var1.has("scale") : this.v4.v11("_hud") != null;
   }

   private static JsonObject v2(JsonObject var0) {
      JsonElement var1 = var0.get("elements");
      if (var1 != null && var1.isJsonArray()) {
         JsonObject var2 = var0.deepCopy();
         var2.remove("elements");
         v3.info("hud element checklist was written by an older build; restoring the shipped set");
         return var2;
      } else {
         return var0;
      }
   }

   public void v2(Map<String, HudElement> var1, AutoSupport var2) {
      JsonObject var3 = new JsonObject();

      for (HudElement var5 : var1.values()) {
         if (var5.v2().v15()) {
            var3.add(var5.v1(), var5.v2().v16());
         }
      }

      this.v4.v2("_hudstyle", var3);
      this.v4.v2("_hudstyle_global", var2.v16());
   }
}
