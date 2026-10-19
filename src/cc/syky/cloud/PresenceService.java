package cc.syky.cloud;

import cc.syky.internal.InternalSupport56;
import cc.syky.ui.uiSupport266;
import com.mojang.authlib.GameProfile;
import com.mojang.authlib.minecraft.MinecraftSessionService;
import com.mojang.authlib.properties.Property;
import java.net.URI;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.UUID;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;
import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.class_124;
import net.minecraft.class_156;
import net.minecraft.class_2561;
import net.minecraft.class_310;
import net.minecraft.class_320;
import net.minecraft.class_634;
import net.minecraft.class_638;
import net.minecraft.class_640;
import net.minecraft.class_642;
import net.minecraft.class_742;
import org.jetbrains.annotations.Nullable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public final class PresenceService implements cloudSupport89 {
   private static final Logger v1 = LoggerFactory.getLogger("syky.cloud");
   private static final long v2 = 5000L;
   private final cloudSupport101 v3;
   private final InternalSupport56 v4;
   private final CloudHttp.Part4 v5;
   private final CompletableFuture<String> v6;
   private volatile boolean v7;
   @Nullable
   private static volatile CloudHttp.Part4 v8;

   public PresenceService(cloudSupport101 var1, InternalSupport56 var2) {
      this.v3 = var1;
      this.v4 = var2;
      this.v5 = new CloudHttp.Part4(v1("syky"), v1("minecraft"), v7());
      this.v6 = HardwareId.v1();
   }

   @Override
   public void v1(Runnable var1) {
      this.v4.v1(var1);
   }

   @Override
   public void v1(cloudSupport89.Part4 var1) {
      class_310 var2 = this.v3.v1();
      class_638 var3 = var2 == null ? null : var2.field_1687;
      if (var3 != null) {
         for (class_742 var5 : var3.method_18456()) {
            if (var5 != var2.field_1724) {
               v1(var1, var5.method_5667(), var5.method_7334());
            }
         }
      }
   }

   @Override
   public void v2(cloudSupport89.Part4 var1) {
      class_310 var2 = this.v3.v1();
      class_634 var3 = var2 == null ? null : var2.method_1562();
      if (var3 != null) {
         UUID var4 = var2.field_1724 == null ? null : var2.field_1724.method_5667();

         for (class_640 var6 : var3.method_2880()) {
            GameProfile var7 = var6.method_2966();
            if (!var7.id().equals(var4)) {
               v1(var1, var7.id(), var7);
            }
         }
      }
   }

   @Override
   public int v1(cloudSupport89.Part1 var1) {
      class_310 var2 = this.v3.v1();
      class_634 var3 = var2 == null ? null : var2.method_1562();
      if (var3 == null) {
         return 0;
      } else {
         int var4 = 0;

         for (class_640 var6 : var3.method_2880()) {
            GameProfile var7 = var6.method_2966();
            var1.player(var7.id(), var7.name());
            var4++;
         }

         return var4;
      }
   }

   private static void v1(cloudSupport89.Part4 var0, UUID var1, GameProfile var2) {
      Property var3 = null;
      Iterator var4 = var2.properties().get("textures").iterator();
      if (var4.hasNext()) {
         Property var5 = (Property)var4.next();
         var3 = var5;
      }

      var0.player(var1, var2.name(), var3 == null ? null : var3.value(), var3 == null ? null : var3.signature());
   }

   @Override
   public String v1() {
      class_310 var1 = this.v3.v1();
      class_642 var2 = var1 == null ? null : var1.method_1558();
      return var1 != null && !var1.method_1542() && var2 != null && var2.field_3761 != null ? var2.field_3761 : "";
   }

   @Override
   public void v1(String var1, boolean var2) {
      this.v4.v1(() -> {
         class_310 var3 = this.v3.v1();
         if (var3 != null && var3.field_1705 != null) {
            var3.field_1705.method_1743().method_1812(class_2561.method_43470(var1).method_27692(var2 ? class_124.field_1061 : class_124.field_1080));
         }
      });
   }

   @Override
   public void v1(URI var1) {
      this.v4.v1(() -> class_156.method_668().method_673(var1));
   }

   @Override
   public List<String> v2() {
      return cloudSupport70.v1().stream().map(var0 -> var0.getMetadata().getId()).toList();
   }

   @Override
   public CloudHttp.Part4 v3() {
      String var1 = this.v6.getNow(null);
      if (var1 == null && !this.v7) {
         this.v7 = true;

         try {
            var1 = this.v6.get(5000L, TimeUnit.MILLISECONDS);
         } catch (Exception var3) {
            v1.debug("hardware id not ready; sending without it for now");
         }
      }

      CloudHttp.Part4 var2 = new CloudHttp.Part4(this.v5.v1(), this.v5.v2(), this.v5.v3(), var1 == null ? "" : var1, this.v5());
      v8 = var2;
      return var2;
   }

   public static CloudHttp.Part4 v4() {
      CloudHttp.Part4 var0 = v8;
      if (var0 != null) {
         return var0;
      } else {
         String var1;
         try {
            var1 = v1(class_310.method_1551());
         } catch (Throwable var3) {
            var1 = "";
         }

         return new CloudHttp.Part4(v1("syky"), v1("minecraft"), v7(), "", var1);
      }
   }

   private String v5() {
      return v1(this.v3.v1());
   }

   public static String v1(@Nullable class_310 var0) {
      class_320 var1 = var0 == null ? null : var0.method_1548();
      if (var1 == null) {
         return "";
      } else {
         UUID var2 = var1.method_44717();
         String var3 = var1.method_1674();
         if (var2 != null && var2.version() == 4 && var3 != null && !var3.isBlank()) {
            String var4 = v6();
            return var4 == null ? "other" : var4;
         } else {
            return "offline";
         }
      }
   }

   public static PresenceSnapshot v1(class_310 var0, class_634 var1) {
      class_642 var2 = var0.method_1558();
      String var3 = var2 != null && var2.field_3761 != null ? var2.field_3761 : "";
      GameProfile var4 = var1.method_2879();
      return new PresenceSnapshot(var3, var4.name(), var4.id(), PresenceSnapshot.v1(var1.method_48296().method_10755()), v1(var1.method_2890()));
   }

   public static long v1(@Nullable class_638 var0) {
      return var0 == null ? 0L : var0.method_22385().field_20641;
   }

   @Nullable
   public static cloudSupport89.Part2 v2(class_310 var0, class_634 var1) {
      class_320 var2 = var0.method_1548();
      UUID var3 = var2.method_44717();
      GameProfile var4 = var1.method_2879();
      String var5 = var2.method_1674();
      if (var3 != null && var3.version() == 4 && var3.equals(var4.id()) && var5 != null && !var5.isBlank()) {
         String var6 = v6();
         if (var6 == null) {
            return null;
         } else {
            MinecraftSessionService var7 = var0.method_73361().comp_837();
            return new cloudSupport89.Part2(var6, var3, var4.name(), var3x -> var7.joinServer(var3, var5, var3x));
         }
      } else {
         return null;
      }
   }

   @Nullable
   private static String v6() {
      return uiSupport266.v1();
   }

   private static String v1(String var0) {
      return FabricLoader.getInstance().getModContainer(var0).map(var0x -> var0x.getMetadata().getVersion().getFriendlyString()).orElse("");
   }

   private static String v7() {
      String var0 = System.getProperty("os.name", "").toLowerCase(Locale.ROOT);
      if (var0.contains("win")) {
         return "windows";
      } else if (var0.contains("mac")) {
         return "macos";
      } else {
         return var0.contains("linux") ? "linux" : "other";
      }
   }
}
