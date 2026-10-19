package cc.syky.cloud;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Optional;
import net.fabricmc.loader.api.FabricLoader;
import net.fabricmc.loader.api.ModContainer;
import org.jetbrains.annotations.Nullable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public final class cloudSupport61 {
   private static final Logger v1 = LoggerFactory.getLogger("syky.jar");

   private cloudSupport61() {
   }

   @Nullable
   public static String v1(String var0, long var1) {
      Optional var3 = FabricLoader.getInstance().getModContainer("syky");
      if (var3.isPresent()) {
         Optional var4 = ((ModContainer)var3.get()).findPath(var0);
         if (var4.isPresent()) {
            try {
               Path var13 = (Path)var4.get();
               if (Files.size(var13) > var1) {
                  v1.warn("{} in the jar is implausibly large and was ignored", var0);
                  return null;
               }

               return Files.readString(var13, StandardCharsets.UTF_8);
            } catch (RuntimeException | IOException var10) {
               v1.debug("{} could not be read from the mod container", var0, var10);
            }
         }
      }

      try {
         String var6;
         try (InputStream var11 = cloudSupport61.class.getClassLoader().getResourceAsStream(var0)) {
            if (var11 == null) {
               v1.debug("no {} on the classpath", var0);
               return null;
            }

            byte[] var5 = var11.readNBytes((int)var1 + 1);
            if (var5.length > var1) {
               v1.warn("{} on the classpath is implausibly large and was ignored", var0);
               return null;
            }

            var6 = new String(var5, StandardCharsets.UTF_8);
         }

         return var6;
      } catch (RuntimeException | IOException var9) {
         v1.debug("{} could not be read from the classpath", var0, var9);
         return null;
      }
   }
}
