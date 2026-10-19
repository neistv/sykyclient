package cc.syky.cloud;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Properties;
import net.fabricmc.loader.api.FabricLoader;
import org.jetbrains.annotations.Nullable;

public final class cloudSupport67 {
   public static final String v1 = "sykyopt";
   public static final String v2 = "sykyopt.properties";
   @Nullable
   private static final String v3 = FabricLoader.getInstance()
      .getModContainer("sykyopt")
      .map(var0 -> var0.getMetadata().getVersion().getFriendlyString())
      .orElse(null);
   private static final boolean v4 = v3 != null && !Boolean.getBoolean("sykyopt.disable") && v1(FabricLoader.getInstance().getConfigDir());

   private cloudSupport67() {
   }

   @Nullable
   public static String v1() {
      return v3;
   }

   public static boolean v2() {
      return v4;
   }

   public static boolean v1(Path var0) {
      Path var1 = var0.resolve("sykyopt.properties");
      if (!Files.isRegularFile(var1)) {
         return true;
      } else {
         Properties var2 = new Properties();

         try (BufferedReader var3 = Files.newBufferedReader(var1, StandardCharsets.UTF_8)) {
            var2.load(var3);
         } catch (RuntimeException | IOException var8) {
            return true;
         }

         return !"false".equalsIgnoreCase(var2.getProperty("enabled", "true").trim());
      }
   }
}
