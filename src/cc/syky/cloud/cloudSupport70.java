package cc.syky.cloud;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Set;
import net.fabricmc.loader.api.FabricLoader;
import net.fabricmc.loader.api.ModContainer;
import org.jetbrains.annotations.Nullable;

public final class cloudSupport70 {
   private static final Set<String> v1 = Set.of("java", "minecraft", "fabricloader", "syky");
   @Nullable
   private static volatile List<ModContainer> v2;

   private cloudSupport70() {
   }

   public static List<ModContainer> v1() {
      List var0 = v2;
      if (var0 == null) {
         ArrayList var1 = new ArrayList();

         for (ModContainer var3 : FabricLoader.getInstance().getAllMods()) {
            if (var3.getContainingMod().isEmpty() && !v1.contains(var3.getMetadata().getId())) {
               var1.add(var3);
            }
         }

         var1.sort(Comparator.comparing(var0x -> var0x.getMetadata().getId()));
         v2 = var0 = List.copyOf(var1);
      }

      return var0;
   }
}
