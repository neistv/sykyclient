package cc.syky.config;

import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.textures.FilterMode;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;
import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.class_1011;
import net.minecraft.class_1043;
import net.minecraft.class_2960;
import net.minecraft.class_310;
import org.jetbrains.annotations.Nullable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public final class configSupport2 {
   private static final Logger v1 = LoggerFactory.getLogger("syky.watermark");
   private static final String v2 = "syky";
   private static final Set<class_2960> v3 = new HashSet<>();
   private static final Set<class_2960> v4 = new HashSet<>();

   private configSupport2() {
   }

   public static boolean v1(class_310 var0, class_2960 var1, String var2) {
      if (v3.contains(var1)) {
         return true;
      } else if (v4.contains(var1)) {
         return false;
      } else {
         class_1011 var3 = null;

         try {
            boolean var5;
            try (InputStream var4 = v1(var2)) {
               if (var4 == null) {
                  throw new IOException("not in the jar");
               }

               var3 = class_1011.method_4309(var4);
               var0.method_1531().method_4616(var1, new configSupport2.Part1(var1, var3));
               v3.add(var1);
               var5 = true;
            }

            return var5;
         } catch (Throwable var9) {
            if (var3 != null) {
               var3.close();
            }

            v4.add(var1);
            v1.error("could not load {} from the jar — the surface using it stays off", var2, var9);
            return false;
         }
      }
   }

   public static void v1(class_310 var0, class_2960 var1) {
      if (v3.remove(var1)) {
         var0.method_1531().method_4615(var1);
      }
   }

   @Nullable
   private static InputStream v1(String var0) throws IOException {
      Optional var1 = FabricLoader.getInstance().getModContainer("syky").flatMap(var1x -> var1x.findPath(var0));
      return var1.isPresent() ? Files.newInputStream((Path)var1.get()) : configSupport2.class.getClassLoader().getResourceAsStream(var0);
   }

   public static final class Part1 extends class_1043 {
      public Part1(class_2960 var1, class_1011 var2) {
         super(var1::toString, var2);
         this.field_63613 = RenderSystem.getSamplerCache().method_76520(FilterMode.LINEAR, false);
      }
   }
}
