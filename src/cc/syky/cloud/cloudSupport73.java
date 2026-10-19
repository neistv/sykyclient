package cc.syky.cloud;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Map.Entry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public final class cloudSupport73 implements cloudSupport82 {
   private static final Logger v1 = LoggerFactory.getLogger("syky.commands.perf");
   private static final Gson v2 = new GsonBuilder().setPrettyPrinting().create();
   private final cloudSupport53 v3;
   private final cloudSupport54 v4;
   private final Path v5;
   private final cloudSupport73.Part1 v6;

   public cloudSupport73(cloudSupport53 var1, cloudSupport54 var2, Path var3, cloudSupport73.Part1 var4) {
      this.v3 = var1;
      this.v4 = var2;
      this.v5 = var3;
      this.v6 = var4;
   }

   @Override
   public String v1() {
      return "perf";
   }

   @Override
   public String v2() {
      return "perf [show|hide|reset|dump] — debug profiler overlay";
   }

   @Override
   public void v1(cloudSupport81 var1, List<String> var2) {
      if (var2.isEmpty()) {
         var1.v1("perf: overlay " + (this.v4.v1() ? "ON" : "OFF") + ", " + this.v3.v5() + " section(s)");
      } else {
         String var3 = ((String)var2.get(0)).toLowerCase(Locale.ROOT);
         switch (var3) {
            case "show":
               this.v3.v1(true);
               this.v4.v1(true);
               boolean var6 = this.v6.arm(true);
               var1.v1("perf overlay: ON" + (var6 ? "" : " (GPU timing unavailable: no timestamp queries)"));
               break;
            case "hide":
               this.v4.v1(false);
               this.v3.v1(false);
               this.v6.arm(false);
               var1.v1("perf overlay: OFF");
               break;
            case "reset":
               this.v3.v4();
               var1.v1("perf stats reset");
               break;
            case "dump":
               if (this.v3.v5() == 0) {
                  var1.v2("nothing to dump — no measurements yet; run `.syky perf show` first");
                  return;
               }

               this.v1(var1);
               break;
            default:
               var1.v2("usage: perf [show|hide|reset|dump]");
         }
      }
   }

   @Override
   public List<String> v1(List<String> var1, int var2, String var3) {
      if (var2 != 0) {
         return List.of();
      } else {
         String var4 = var3 == null ? "" : var3.toLowerCase(Locale.ROOT);
         ArrayList var5 = new ArrayList();

         for (String var9 : new String[]{"show", "hide", "reset", "dump"}) {
            if (var9.startsWith(var4)) {
               var5.add(var9);
            }
         }

         return var5;
      }
   }

   private void v1(cloudSupport81 var1) {
      Path var2 = this.v5.resolve("perfstats-" + Instant.now().toEpochMilli() + ".json");
      JsonObject var3 = new JsonObject();
      var3.addProperty("capturedAtMillis", System.currentTimeMillis());
      var3.addProperty("windowSize", this.v3.v1());
      JsonObject var4 = new JsonObject();

      for (Entry var6 : this.v3.v3().entrySet()) {
         cloudRecord7 var7 = (cloudRecord7)var6.getValue();
         JsonObject var8 = new JsonObject();
         var8.addProperty("count", var7.v5());
         var8.addProperty("minMs", var7.v6() / 1000000.0);
         var8.addProperty("maxMs", var7.v7() / 1000000.0);
         var8.addProperty("meanMs", var7.v3());
         var8.addProperty("p50Ms", var7.v9() / 1000000.0);
         var8.addProperty("p95Ms", var7.v10() / 1000000.0);
         var8.addProperty("p99Ms", var7.v4());
         var4.add((String)var6.getKey(), var8);
      }

      var3.add("sections", var4);

      try {
         Files.createDirectories(this.v5);
         Files.writeString(var2, v2.toJson(var3));
         var1.v1("perf dump → syky/debug/" + var2.getFileName());
         v1.info("perf dump written to {}", var2);
      } catch (IOException var9) {
         var1.v2("perf dump failed: " + var9.getMessage());
         v1.error("perf dump failed", var9);
      }
   }

   @FunctionalInterface
   public interface Part1 {
      boolean arm(boolean var1);
   }
}
