package cc.syky.cloud;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Locale;

public final class cloudSupport74 implements cloudSupport82 {
   public static final String v1 = "syky optimization";
   private static final String v2 = "sykyopt.properties";
   private final Path v3;
   private final boolean v4;

   public cloudSupport74(Path var1) {
      this.v3 = var1;
      this.v4 = cloudSupport67.v2();
   }

   @Override
   public String v1() {
      return "opt";
   }

   @Override
   public String v2() {
      return "opt [on|off]";
   }

   @Override
   public void v1(cloudSupport81 var1, List<String> var2) {
      if (var2.isEmpty()) {
         boolean var6 = cloudSupport67.v1(this.v3);
         var1.v1("syky optimization: " + (this.v4 ? "on" : "off") + " now" + (var6 == this.v4 ? "" : ", " + (var6 ? "on" : "off") + " after a restart"));
      } else {
         String var3 = ((String)var2.get(0)).toLowerCase(Locale.ROOT);
         switch (var3) {
            case "on":
               this.v1(var1, true);
               break;
            case "off":
               this.v1(var1, false);
               break;
            default:
               var1.v2("usage: " + this.v2());
         }
      }
   }

   @Override
   public List<String> v1(List<String> var1, int var2, String var3) {
      return var2 == 0 ? List.of("on", "off").stream().filter(var1x -> var1x.startsWith(var3)).toList() : List.of();
   }

   private void v1(cloudSupport81 var1, boolean var2) {
      try {
         Files.createDirectories(this.v3);
         Files.writeString(
            this.v3.resolve("sykyopt.properties"),
            "# Written by syky client's .syky opt; read at the next start\nenabled=" + var2 + "\n",
            StandardCharsets.UTF_8
         );
      } catch (IOException var4) {
         var1.v2("couldn't write " + this.v3.resolve("sykyopt.properties") + ": " + var4.getMessage());
         return;
      }

      var1.v1(
         var2 == this.v4 ? "syky optimization is already " + (var2 ? "on" : "off") : "syky optimization will be " + (var2 ? "on" : "off") + " after a restart"
      );
   }
}
