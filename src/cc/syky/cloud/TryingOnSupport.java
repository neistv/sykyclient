package cc.syky.cloud;

import cc.syky.internal.InternalSupport38;
import cc.syky.internal.InternalSupport60;
import cc.syky.internal.InternalSupport61;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.UUID;
import java.util.function.Supplier;

public final class TryingOnSupport implements cloudSupport82 {
   private static final List<String> v1 = List.of("hide", "list", "off", "physics", "reload", "show", "stats", "wear");
   private static final String v2 = "cosmetics: list | wear <id> | off <slot>|all | show|hide | physics on|off | reload | stats";
   private final CloudClient v3;
   private final InternalSupport60 v4;
   private final InternalSupport61 v5;
   private final Supplier<UUID> v6;

   public TryingOnSupport(CloudClient var1, InternalSupport60 var2, InternalSupport61 var3, Supplier<UUID> var4) {
      this.v3 = var1;
      this.v4 = var2;
      this.v5 = var3;
      this.v6 = var4;
   }

   @Override
   public String v1() {
      return "cosmetics";
   }

   @Override
   public String v2() {
      return "cosmetics [list|wear|off|...] — what you wear";
   }

   @Override
   public void v1(cloudSupport81 var1, List<String> var2) {
      String var3 = var2.isEmpty() ? "" : ((String)var2.get(0)).toLowerCase(Locale.ROOT);
      String var4 = var2.size() > 1 ? (String)var2.get(1) : "";
      switch (var3) {
         case "list":
            this.v1(var1);
            break;
         case "wear":
            this.v1(var1, var4.toLowerCase(Locale.ROOT));
            break;
         case "off":
            this.v2(var1, var4.toLowerCase(Locale.ROOT));
            break;
         case "show":
         case "hide":
            InternalSupport38.v1(var3.equals("show"));
            var1.v1("Cosmetics are " + (var3.equals("show") ? "shown." : "hidden."));
            break;
         case "physics":
            if (!var4.equals("on") && !var4.equals("off")) {
               var1.v2("Use: .syky cosmetics physics on|off");
               return;
            }

            InternalSupport38.v2(var4.equals("on"));
            var1.v1("Cape cloth physics " + (var4.equals("on") ? "on." : "off: capes swing like vanilla's."));
            break;
         case "reload":
            List var7 = this.v5.v2();
            var7.forEach(this.v4::v2);
            var1.v1(var7.isEmpty() ? "Nothing in " + this.v5.v1() : "Reloading " + String.join(", ", var7) + ".");
            break;
         case "stats":
            var1.v1(InternalSupport38.v13());
            break;
         default:
            var1.v1("cosmetics: list | wear <id> | off <slot>|all | show|hide | physics on|off | reload | stats");
      }
   }

   private void v1(cloudSupport81 var1) {
      List var2 = this.v5.v2();
      if (!var2.isEmpty()) {
         var1.v1("To try on (" + this.v5.v1().getFileName() + "): " + String.join(", ", var2));
      }

      this.v3.v1("GET", "/v1/me/cosmetics", null, var1x -> {
         JsonObject var2x = var1x.has("loadout") && var1x.get("loadout").isJsonObject() ? var1x.getAsJsonObject("loadout") : new JsonObject();
         ArrayList var3 = new ArrayList();
         JsonElement var5 = var1x.get("available");
         if (var5 instanceof JsonArray) {
            for (JsonElement var6 : (JsonArray)var5) {
               if (var6.isJsonObject()) {
                  JsonObject var7 = var6.getAsJsonObject();
                  String var8 = cloudSupport60.v2(var7, "id");
                  String var9 = cloudSupport60.v2(var7, "slot");
                  boolean var10 = var2x.has(var9) && var8.equals(var2x.get(var9).getAsString());
                  var3.add(var8 + " (" + var9 + ")" + (var10 ? " — worn" : ""));
               }
            }
         }

         var1.v1(var3.isEmpty() ? "You have no cosmetics yet." : "Yours: " + String.join(", ", var3));
      }, var1::v2);
   }

   private void v1(cloudSupport81 var1, String var2) {
      if (var2.isEmpty()) {
         var1.v2("Use: .syky cosmetics wear <id>");
      } else if (this.v5.v1(var2)) {
         UUID var3 = this.v6.get();
         if (var3 == null) {
            var1.v2("Join a world first.");
         } else {
            ArrayList var4 = new ArrayList();
            var4.add(var2);

            for (String var6 : this.v4.v2(var3)) {
               if (!InternalSupport60.v1(var6).equals(var2)) {
                  var4.add(var6);
               }
            }

            this.v4.v1(var3, var4);
            var1.v1("Trying on " + var2 + " from " + this.v5.v1().getFileName() + " (only you see it).");
         }
      } else {
         this.v3.v1("GET", "/v1/me/cosmetics", null, var3x -> {
            String var4x = null;
            JsonElement var6x = var3x.get("available");
            if (var6x instanceof JsonArray) {
               for (JsonElement var7 : (JsonArray)var6x) {
                  if (var7.isJsonObject() && var2.equals(cloudSupport60.v2(var7.getAsJsonObject(), "id"))) {
                     var4x = cloudSupport60.v2(var7.getAsJsonObject(), "slot");
                  }
               }
            }

            if (var4x == null) {
               var1.v2("You do not have " + var2 + ". See .syky cosmetics list");
            } else {
               this.v1(var1, var4x, var2, "Wearing " + var2 + ".");
            }
         }, var1::v2);
      }
   }

   private void v2(cloudSupport81 var1, String var2) {
      if (var2.isEmpty()) {
         var1.v2("Use: .syky cosmetics off <slot>|all");
      } else if (!var2.equals("all")) {
         this.v1(var1, var2, "", "Took off your " + var2 + ".");
      } else {
         this.v3.v1("GET", "/v1/me/cosmetics", null, var2x -> {
            if (var2x.has("loadout") && var2x.get("loadout").isJsonObject()) {
               for (String var4 : var2x.getAsJsonObject("loadout").keySet()) {
                  this.v1(var1, var4, "", "Took off your " + var4 + ".");
               }
            }
         }, var1::v2);
      }
   }

   private void v1(cloudSupport81 var1, String var2, String var3, String var4) {
      JsonObject var5 = new JsonObject();
      var5.addProperty("slot", var2);
      var5.addProperty("cosmetic", var3);
      this.v3.v1("PUT", "/v1/me/loadout", var5, var2x -> var1.v1(var4), var1::v2);
   }

   @Override
   public List<String> v1(List<String> var1, int var2, String var3) {
      if (var2 == 0) {
         return v1.stream().filter(var1x -> var1x.startsWith(var3.toLowerCase(Locale.ROOT))).toList();
      } else if (var2 == 1 && ((String)var1.get(0)).equalsIgnoreCase("wear")) {
         return this.v5.v2().stream().filter(var1x -> var1x.startsWith(var3.toLowerCase(Locale.ROOT))).toList();
      } else {
         return var2 == 1 && ((String)var1.get(0)).equalsIgnoreCase("physics") ? List.of("off", "on") : List.of();
      }
   }
}
