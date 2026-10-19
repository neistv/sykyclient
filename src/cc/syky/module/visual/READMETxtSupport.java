package cc.syky.module.visual;

import cc.syky.internal.InternalSupport57;
import cc.syky.ui.DecompilationFailedSupport2;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import org.jetbrains.annotations.Nullable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public final class READMETxtSupport {
   private static final Logger v1 = LoggerFactory.getLogger("syky.sound");
   private static final String v2 = "syky custom sounds\n==================\nDrop your .wav / .ogg / .mp3 files straight into THIS folder — no sub-folders.\n\nThen open the client's ClickGUI → Misc → Custom Sounds and, for each event\n(crit, knockback, sweep, hit, no-damage, mace, your/enemy totem, explosion), tick\nwhich files it should use in the dropdown. Tick several and a random one plays each\ntime; the same file can be used for as many events as you like.\n\nAfter adding or removing files run \".syky sounds reload\" in chat — no game restart.\n";
   private final Path v3;
   private volatile READMETxtSupport.Part1 v4 = new READMETxtSupport.Part1(Map.of(), List.of());

   public READMETxtSupport(Path var1) {
      this.v3 = var1;
   }

   public void v1(InternalSupport57 var1) {
      var1.v1(() -> {
         try {
            v1(this.v3);
            this.v4 = this.v3();
         } catch (RuntimeException var2) {
            v1.warn("sound reload failed", var2);
         }
      });
   }

   public List<String> v1() {
      return this.v4.names;
   }

   public int v2() {
      return this.v4.names.size();
   }

   @Nullable
   public visualRecord v1(@Nullable Set<String> var1, Random var2) {
      if (var1 != null && !var1.isEmpty()) {
         Map var3 = this.v4.sounds;
         int var4 = 0;

         for (String var6 : var1) {
            if (var3.containsKey(var6)) {
               var4++;
            }
         }

         if (var4 == 0) {
            return null;
         } else {
            int var10 = var4 == 1 ? 0 : var2.nextInt(var4);
            int var11 = 0;

            for (String var8 : var1) {
               visualRecord var9 = (visualRecord)var3.get(var8);
               if (var9 != null && var11++ == var10) {
                  return var9;
               }
            }

            return null;
         }
      } else {
         return null;
      }
   }

   private READMETxtSupport.Part1 v3() {
      LinkedHashMap var1 = new LinkedHashMap();
      ArrayList var2 = new ArrayList();

      for (Path var4 : v2(this.v3)) {
         visualRecord var5 = DecompilationFailedSupport2.v1(var4);
         if (var5 != null) {
            String var6 = var4.getFileName().toString();
            var1.put(var6, var5);
            var2.add(var6);
         }
      }

      v1.info("loaded {} custom sound(s) from {}", var2.size(), this.v3);
      return new READMETxtSupport.Part1(Map.copyOf(var1), List.copyOf(var2));
   }

   private static List<Path> v2(Path var0) {
      ArrayList var1 = new ArrayList();
      if (!Files.isDirectory(var0)) {
         return var1;
      } else {
         try (DirectoryStream var2 = Files.newDirectoryStream(var0)) {
            for (Path var4 : var2) {
               if (Files.isRegularFile(var4) && v1(var4.getFileName().toString())) {
                  var1.add(var4);
               }
            }
         } catch (IOException var7) {
            v1.warn("failed to list {}", var0, var7);
         }

         var1.sort((var0x, var1x) -> var0x.getFileName().toString().compareToIgnoreCase(var1x.getFileName().toString()));
         return var1;
      }
   }

   private static boolean v1(String var0) {
      String var1 = var0.toLowerCase(Locale.ROOT);
      return var1.endsWith(".wav") || var1.endsWith(".ogg") || var1.endsWith(".mp3");
   }

   public static void v1(Path var0) {
      try {
         Files.createDirectories(var0);
         Path var1 = var0.resolve("README.txt");
         if (!Files.exists(var1)) {
            Files.write(
               var1,
               "syky custom sounds\n==================\nDrop your .wav / .ogg / .mp3 files straight into THIS folder — no sub-folders.\n\nThen open the client's ClickGUI → Misc → Custom Sounds and, for each event\n(crit, knockback, sweep, hit, no-damage, mace, your/enemy totem, explosion), tick\nwhich files it should use in the dropdown. Tick several and a random one plays each\ntime; the same file can be used for as many events as you like.\n\nAfter adding or removing files run \".syky sounds reload\" in chat — no game restart.\n"
                  .getBytes(StandardCharsets.UTF_8)
            );
         }
      } catch (IOException var2) {
         v1.warn("failed to create sounds folder at {}", var0, var2);
      }
   }

   public record Part1(Map<String, visualRecord> sounds, List<String> names) {

      public Map<String, visualRecord> v1() {
         return this.sounds;
      }

      public List<String> v2() {
         return this.names;
      }
   }
}
