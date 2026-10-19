package cc.syky.cloud;

import cc.syky.config.NewConfigSupport;
import cc.syky.hud.MySettingsSupport;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public final class cloudSupport76 implements cloudSupport82 {
   private static final String v1 = "save";
   private static final String v2 = "load";
   private static final String v3 = "dir";
   private static final String v4 = "list";
   private static final String v5 = "delete";
   private static final List<String> v6 = List.of("save", "load", "dir", "list", "delete");
   private final NewConfigSupport v7;
   private final Runnable v8;

   public cloudSupport76(NewConfigSupport var1, Runnable var2) {
      this.v7 = var1;
      this.v8 = var2;
   }

   @Override
   public String v1() {
      return "cfg";
   }

   @Override
   public String v2() {
      return "cfg save [name] | load <name> | dir | list | delete <name>";
   }

   @Override
   public void v1(cloudSupport81 var1, List<String> var2) {
      if (var2.isEmpty()) {
         var1.v2("usage: " + this.v2());
      } else {
         String var3 = ((String)var2.get(0)).toLowerCase(Locale.ROOT);
         List var4 = var2.subList(1, var2.size());
         switch (var3) {
            case "save":
               this.v2(var1, var4);
               break;
            case "load":
               this.v3(var1, var4);
               break;
            case "dir":
               this.v4(var1, var4);
               break;
            case "list":
               this.v5(var1, var4);
               break;
            case "delete":
               this.v6(var1, var4);
               break;
            default:
               var1.v2("unknown subcommand: " + var3 + " (use save|load|dir|list|delete)");
         }
      }
   }

   private void v2(cloudSupport81 var1, List<String> var2) {
      if (var2.isEmpty()) {
         String var4 = this.v7.v5();
         if (this.v1(var1, var4)) {
            var1.v1("saved (" + var4 + ")");
         }
      } else {
         String var3 = String.join(" ", var2);
         if (!MySettingsSupport.v12(var3)) {
            var1.v2(v1(var3));
         } else if (this.v1(var1, var3)) {
            var1.v1("saved as " + var3 + " (active)");
         }
      }
   }

   private boolean v1(cloudSupport81 var1, String var2) {
      MySettingsSupport.Part1 var3;
      try {
         var3 = this.v7.v7(var2);
      } catch (RuntimeException var5) {
         var1.v2("save failed: " + var5.getMessage());
         return false;
      }

      switch (var3) {
         case WRITTEN:
            return true;
         case REFUSED:
            var1.v2("refusing to save over " + var2 + " — this session could not load it cleanly");
            break;
         case FAILED:
            var1.v2("save failed: could not write " + var2 + " (see the log)");
      }

      return false;
   }

   private void v3(cloudSupport81 var1, List<String> var2) {
      if (var2.isEmpty()) {
         var1.v2("usage: cfg load <name>");
      } else {
         String var3 = String.join(" ", var2);
         if (!MySettingsSupport.v12(var3)) {
            var1.v2(v1(var3));
         } else if (!this.v7.v1(var3)) {
            var1.v2("no such config: " + var3);
         } else if (!this.v7.v4(var3)) {
            var1.v2("failed to load: " + var3);
         } else {
            var1.v1("loaded " + var3);
         }
      }
   }

   private void v4(cloudSupport81 var1, List<String> var2) {
      if (!var2.isEmpty()) {
         var1.v2("usage: cfg dir");
      } else if (this.v8 == null) {
         var1.v2("cannot open dir in this environment");
      } else {
         try {
            this.v8.run();
         } catch (RuntimeException var4) {
            var1.v2("failed to open dir: " + var4.getMessage());
            return;
         }

         var1.v1("opened config dir");
      }
   }

   private void v5(cloudSupport81 var1, List<String> var2) {
      if (!var2.isEmpty()) {
         var1.v2("usage: cfg list");
      } else {
         List var3 = this.v7.v4();
         if (var3.isEmpty()) {
            var1.v1("no configs");
         } else {
            String var4 = this.v7.v5();

            for (String var6 : var3) {
               var1.v1((var6.equals(var4) ? "* " : "  ") + var6);
            }
         }
      }
   }

   private void v6(cloudSupport81 var1, List<String> var2) {
      if (var2.isEmpty()) {
         var1.v2("usage: cfg delete <name>");
      } else {
         String var3 = String.join(" ", var2);
         if (!MySettingsSupport.v12(var3)) {
            var1.v2(v1(var3));
         } else if (var3.equals(this.v7.v5())) {
            var1.v2("cannot delete the active config; load another one first");
         } else if (!this.v7.v1(var3)) {
            var1.v2("no such config: " + var3);
         } else {
            try {
               this.v7.v6(var3);
            } catch (IOException var5) {
               var1.v2("io error: " + var5.getMessage());
               return;
            } catch (RuntimeException var6) {
               var1.v2("delete failed: " + var6.getMessage());
               return;
            }

            var1.v1("deleted " + var3);
         }
      }
   }

   private static String v1(String var0) {
      return "invalid name: " + var0 + " (letters, digits, spaces; 1..48 chars)";
   }

   @Override
   public List<String> v1(List<String> var1, int var2, String var3) {
      String var4 = var3 == null ? "" : var3.toLowerCase(Locale.ROOT);
      ArrayList var5 = new ArrayList();
      switch (var2) {
         case 0:
            for (String var10 : v6) {
               if (var10.startsWith(var4)) {
                  var5.add(var10);
               }
            }
            break;
         case 1:
            String var6 = var1.isEmpty() ? "" : ((String)var1.get(0)).toLowerCase(Locale.ROOT);
            if ("save".equals(var6) || "load".equals(var6) || "delete".equals(var6)) {
               for (String var8 : this.v7.v4()) {
                  if (var8.toLowerCase(Locale.ROOT).startsWith(var4)) {
                     var5.add(var8);
                  }
               }
            }
      }

      return var5;
   }
}
