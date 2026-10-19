package cc.syky.cloud;

import com.google.common.collect.ImmutableMultimap;
import com.mojang.authlib.GameProfile;
import com.mojang.authlib.properties.Property;
import com.mojang.authlib.properties.PropertyMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Map.Entry;
import java.util.function.Supplier;
import net.minecraft.class_1068;
import net.minecraft.class_2960;
import net.minecraft.class_310;
import net.minecraft.class_8685;
import org.jetbrains.annotations.Nullable;

public final class cloudSupport18 {
   private static final int v1 = 64;
   private final Map<Long, cloudSupport18.Part1> v2 = new LinkedHashMap<Long, cloudSupport18.Part1>(16, 0.75F, true) {
      @Override
      public boolean removeEldestEntry(Entry<Long, cloudSupport18.Part1> var1) {
         return this.size() > 64;
      }
   };

   public cloudSupport18() {
   }

   public class_2960 v1(cloudSupport88.Part1 var1) {
      cloudSupport18.Part1 var2 = this.v2.get(var1.v1());
      if (var2 != null && Objects.equals(var2.v1(), var1.v6())) {
         return var2.v2().get().comp_1626().comp_3627();
      } else {
         class_310 var3 = class_310.method_1551();
         String var4 = var1.v6();
         if (var3 != null && var4 != null) {
            GameProfile var5 = new GameProfile(
               var1.v4(), var1.v3(), new PropertyMap(ImmutableMultimap.of("textures", new Property("textures", var4, var1.v7())))
            );
            Supplier var6 = var3.method_1582().method_73544(var5, false);
            this.v2.put(var1.v1(), new cloudSupport18.Part1(var4, var6));
            return ((class_8685)var6.get()).comp_1626().comp_3627();
         } else {
            return class_1068.method_4648(var1.v4()).comp_1626().comp_3627();
         }
      }
   }

   public record Part1(@Nullable String skin, Supplier<class_8685> supplier) {
      @Nullable
      public String v1() {
         return this.skin;
      }

      public Supplier<class_8685> v2() {
         return this.supplier;
      }
   }
}
