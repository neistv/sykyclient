package cc.syky.ui;

import cc.syky.cloud.cloudSupport101;
import com.google.common.collect.ImmutableMultimap;
import com.google.gson.JsonObject;
import com.mojang.authlib.GameProfile;
import com.mojang.authlib.properties.Property;
import com.mojang.authlib.properties.PropertyMap;
import com.mojang.authlib.yggdrasil.ProfileResult;
import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;
import java.util.UUID;
import java.util.Map.Entry;
import java.util.concurrent.CompletableFuture;
import java.util.function.Supplier;
import net.minecraft.class_1068;
import net.minecraft.class_2960;
import net.minecraft.class_310;
import net.minecraft.class_8685;
import org.jetbrains.annotations.Nullable;

public final class SKINSupport {
   private static final int v1 = 64;
   private final cloudSupport101 v2;
   private final PRODSupport v3;
   private final Map<String, SKINSupport.Part1> v4 = new LinkedHashMap<String, SKINSupport.Part1>(16, 0.75F, true) {
      @Override
      public boolean removeEldestEntry(Entry<String, SKINSupport.Part1> var1) {
         return this.size() > 64;
      }
   };

   public SKINSupport(cloudSupport101 var1, PRODSupport var2) {
      this.v2 = var1;
      this.v3 = var2;
   }

   public class_2960 v1(uiRecord16 var1) {
      return this.v2(var1).comp_1626().comp_3627();
   }

   public class_8685 v2(uiRecord16 var1) {
      SKINSupport.Part1 var2 = this.v4.get(var1.v3());
      if (var2 != null && var2.v1(var1)) {
         return var2.v4().get();
      } else {
         class_310 var3 = this.v2.v1();
         if (var3 != null && var1.v4() != uiSupport272.OFFLINE) {
            GameProfile var4 = this.v3(var1);
            if (var4 == null) {
               return class_1068.method_4648(var1.v6());
            } else {
               Supplier var5 = var3.method_1582().method_73544(var4, false);
               this.v4.put(var1.v3(), new SKINSupport.Part1(var1.v6(), var1.v11(), var1.v12(), var5));
               return (class_8685)var5.get();
            }
         } else {
            return class_1068.method_4648(var1.v6());
         }
      }
   }

   @Nullable
   private GameProfile v3(uiRecord16 var1) {
      String var2 = var1.v11();
      if (var2 != null) {
         JsonObject var7 = new JsonObject();
         var7.addProperty("url", var2);
         if (var1.v12()) {
            JsonObject var8 = new JsonObject();
            var8.addProperty("model", "slim");
            var7.add("metadata", var8);
         }

         JsonObject var9 = new JsonObject();
         var9.add("SKIN", var7);
         JsonObject var5 = new JsonObject();
         var5.addProperty("profileId", var1.v6().toString().replace("-", ""));
         var5.addProperty("profileName", var1.v5());
         var5.add("textures", var9);
         String var6 = Base64.getEncoder().encodeToString(var5.toString().getBytes(StandardCharsets.UTF_8));
         return new GameProfile(var1.v6(), var1.v5(), new PropertyMap(ImmutableMultimap.of("textures", new Property("textures", var6))));
      } else {
         if (!var1.v7()) {
            CompletableFuture var3 = this.v3.v5();
            ProfileResult var4 = var3 == null ? null : (ProfileResult)var3.getNow(null);
            if (var4 != null && var4.profile().id().equals(var1.v6())) {
               return var4.profile();
            }
         }

         return null;
      }
   }

   public record Part1(UUID uuid, @Nullable String url, boolean slim, Supplier<class_8685> supplier) {
      public boolean v1(uiRecord16 var1) {
         return this.uuid.equals(var1.v6()) && Objects.equals(this.url, var1.v11()) && this.slim == var1.v12();
      }

      public UUID v1() {
         return this.uuid;
      }

      @Nullable
      public String v2() {
         return this.url;
      }

      public boolean v3() {
         return this.slim;
      }

      public Supplier<class_8685> v4() {
         return this.supplier;
      }
   }
}
