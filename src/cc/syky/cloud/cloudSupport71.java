package cc.syky.cloud;

import cc.syky.internal.InternalSupport57;
import cc.syky.module.visual.READMETxtSupport;
import cc.syky.module.visual.visualSupport3;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import net.minecraft.class_156;

public final class cloudSupport71 implements cloudSupport82 {
   private final Path v1;
   private final InternalSupport57 v2;

   public cloudSupport71(Path var1, InternalSupport57 var2) {
      this.v1 = var1;
      this.v2 = var2;
   }

   @Override
   public String v1() {
      return "sounds";
   }

   @Override
   public String v2() {
      return "sounds [open|reload|list] — custom PvP sound packs";
   }

   @Override
   public void v1(cloudSupport81 var1, List<String> var2) {
      String var3 = var2.isEmpty() ? "open" : ((String)var2.get(0)).toLowerCase(Locale.ROOT);
      switch (var3) {
         case "open":
            READMETxtSupport.v1(this.v1);
            class_156.method_668().method_672(this.v1.toFile());
            var1.v1("sounds folder: " + this.v1);
            break;
         case "reload":
            visualSupport3.v1(this.v2);
            var1.v1("reloading custom sounds…");
            break;
         case "list":
            this.v1(var1);
            break;
         default:
            var1.v2("usage: sounds [open|reload|list]");
      }
   }

   @Override
   public List<String> v1(List<String> var1, int var2, String var3) {
      if (var2 != 0) {
         return List.of();
      } else {
         String var4 = var3 == null ? "" : var3.toLowerCase(Locale.ROOT);
         ArrayList var5 = new ArrayList();

         for (String var9 : new String[]{"open", "reload", "list"}) {
            if (var9.startsWith(var4)) {
               var5.add(var9);
            }
         }

         return var5;
      }
   }

   private void v1(cloudSupport81 var1) {
      READMETxtSupport var2 = visualSupport3.v2();
      if (var2 == null) {
         var1.v1("custom sounds not loaded yet — enable the Custom Sounds module first");
      } else {
         List var3 = var2.v1();
         if (var3.isEmpty()) {
            var1.v1("no sound files — drop .wav/.ogg/.mp3 into the folder (.syky sounds open)");
         } else {
            var1.v1(var3.size() + " file(s): " + String.join(", ", var3));
         }
      }
   }
}
