package cc.syky.ui;

import cc.syky.cloud.cloudSupport101;
import cc.syky.mixin.accessor.MinecraftAccessor;
import cc.syky.mixin.accessor.RealmsAvailabilityAccessor;
import cc.syky.mixin.accessor.RealmsClientAccessor;
import cc.syky.render.renderSupport47;
import com.mojang.authlib.Environment;
import com.mojang.authlib.exceptions.AuthenticationException;
import com.mojang.authlib.minecraft.UserApiService;
import com.mojang.authlib.minecraft.UserApiService.UserProperties;
import com.mojang.authlib.yggdrasil.ProfileResult;
import com.mojang.authlib.yggdrasil.YggdrasilAuthenticationService;
import java.util.Optional;
import java.util.UUID;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import net.minecraft.class_1132;
import net.minecraft.class_156;
import net.minecraft.class_310;
import net.minecraft.class_320;
import net.minecraft.class_3928;
import net.minecraft.class_412;
import net.minecraft.class_424;
import net.minecraft.class_4341;
import net.minecraft.class_435;
import net.minecraft.class_437;
import net.minecraft.class_5520;
import net.minecraft.class_642;
import net.minecraft.class_6628;
import net.minecraft.class_7497;
import net.minecraft.class_7569;
import net.minecraft.class_7574;
import net.minecraft.class_7578;
import net.minecraft.class_7853;
import net.minecraft.class_8671;
import net.minecraft.class_642.class_8678;
import org.jetbrains.annotations.Nullable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public final class PRODSupport implements uiSupport270 {
   private static final Logger v1 = LoggerFactory.getLogger("syky.account");
   private static final Environment v2 = new Environment(uiSupport268.v2, uiSupport268.v1, uiSupport268.v3, "PROD");
   private static final long v3 = 10L;
   private static final String v4 = ":25565";
   private final cloudSupport101 v5;
   @Nullable
   private volatile PRODSupport.Part2 v6;
   @Nullable
   private YggdrasilAuthenticationService v7;
   @Nullable
   private class_7497 v8;

   public PRODSupport(cloudSupport101 var1) {
      this.v5 = var1;
   }

   @Nullable
   @Override
   public uiSupport270.Part3 v1() {
      class_310 var1 = this.v5.v1();
      if (var1 != null) {
         this.v1(var1);
      }

      PRODSupport.Part2 var2 = this.v6;
      return var2 == null ? null : var2.v2();
   }

   @Nullable
   public CompletableFuture<ProfileResult> v5() {
      PRODSupport.Part2 var1 = this.v6;
      return var1 == null ? null : var1.v5();
   }

   @Override
   public uiSupport270.Part2 v2() {
      class_310 var1 = this.v5.v1();
      if (var1 != null
         && var1.field_1687 == null
         && var1.field_1724 == null
         && var1.method_1562() == null
         && var1.method_1576() == null
         && var1.field_1761 == null) {
         class_437 var2 = var1.field_1755;
         return !(var2 instanceof class_412)
               && !(var2 instanceof class_8671)
               && !(var2 instanceof class_3928)
               && !(var2 instanceof class_435)
               && !(var2 instanceof class_424)
            ? uiSupport270.Part2.MENU
            : uiSupport270.Part2.WORLD;
      } else {
         return uiSupport270.Part2.WORLD;
      }
   }

   @Override
   public boolean v3() {
      class_310 var1 = this.v5.v1();
      return var1 == null || var1.method_18506() != null || var1.field_1755 == null && var1.field_1687 == null;
   }

   @Nullable
   @Override
   public String v4() {
      class_310 var1 = this.v5.v1();
      if (var1 != null && var1.field_1687 != null && var1.field_1724 != null) {
         class_1132 var2 = var1.method_1576();
         if (var2 != null) {
            String var5 = var2.method_27728().method_150();
            return var5 == null ? "" : var5.strip();
         } else {
            class_642 var3 = var1.method_1558();
            if (var3 == null) {
               return "";
            } else if (!var3.method_52811() && var3.method_55616() != class_8678.field_45609) {
               String var6 = var3.field_3761 == null ? "" : var3.field_3761.strip();
               return var6.endsWith(":25565") ? var6.substring(0, var6.length() - ":25565".length()) : var6;
            } else {
               String var4 = var3.field_3752 != null && !var3.field_3752.isBlank() ? var3.field_3752 : var3.field_3761;
               return var4 == null ? "" : var4.strip();
            }
         }
      } else {
         return null;
      }
   }

   @Override
   public uiSupport270.Part1 v1(uiRecord15 var1) throws Exception {
      class_310 var2 = this.v5.v1();
      PRODSupport.Part2 var3 = this.v6;
      if (var2 != null && var3 != null) {
         return switch (var1.v2()) {
            case LAUNCH -> new PRODSupport.Part1(
               var3.v1(), var3.v3(), var3.v4(), v1(var3.v5(), null), renderSupport47.v1(v1(var3.v6(), UserApiService.OFFLINE_PROPERTIES))
            );
            case OFFLINE -> new PRODSupport.Part1(
               new class_320(var1.v3(), var1.v4(), var1.v5(), Optional.empty(), Optional.empty()),
               var3.v3(),
               UserApiService.OFFLINE,
               null,
               UserApiService.OFFLINE_PROPERTIES
            );
            case MICROSOFT -> this.v1(var2, var1);
         };
      } else {
         throw new IllegalStateException("the game has no session yet");
      }
   }

   @Nullable
   private static <T> T v1(CompletableFuture<T> var0, @Nullable T var1) {
      try {
         Object var2 = var0.get(10L, TimeUnit.SECONDS);
         return (T)(var2 == null ? var1 : var2);
      } catch (InterruptedException var3) {
         Thread.currentThread().interrupt();
         return (T)var1;
      } catch (TimeoutException | ExecutionException var4) {
         return (T)var1;
      }
   }

   private PRODSupport.Part1 v1(class_310 var1, uiRecord15 var2) {
      YggdrasilAuthenticationService var3 = this.v7;
      class_7497 var4 = this.v8;
      if (var3 == null || var4 == null) {
         var3 = new YggdrasilAuthenticationService(var1.method_1487(), v2);
         var4 = class_7497.method_44143(var3, var1.field_1697);
         this.v7 = var3;
         this.v8 = var4;
      }

      class_320 var5 = new class_320(var2.v3(), var2.v4(), var2.v5(), Optional.empty(), Optional.empty());
      UserApiService var6 = var3.createUserApiService(var2.v5());
      ProfileResult var7 = null;

      try {
         var7 = var4.comp_837().fetchProfile(var2.v4(), true);
      } catch (RuntimeException var11) {
         v1.debug("profile lookup for {} failed; the game uses the bare name", var2.v3(), var11);
      }

      UserProperties var8 = UserApiService.OFFLINE_PROPERTIES;

      try {
         var8 = var6.fetchProperties();
      } catch (RuntimeException | AuthenticationException var10) {
         v1.warn("could not fetch the account's user properties; using the offline defaults");
      }

      return new PRODSupport.Part1(var5, var4, var6, var7, var8);
   }

   @Override
   public void v1(uiSupport270.Part1 var1) {
      class_310 var2 = this.v5.v1();
      if (var2 != null && var1 instanceof PRODSupport.Part1 var3) {
         this.v1(var2);
         UserApiService var4 = var3.v3();
         class_5520 var5 = new class_5520(var2, var4);
         class_6628 var6 = new class_6628(var2, var4, var3.v1());
         class_7853 var7 = class_7853.method_46532(var4, var3.v1(), var2.field_1697.toPath());
         class_7574 var8 = class_7574.method_44599(class_7569.method_44586(), var4);
         class_6628 var9 = var2.method_47601();
         MinecraftAccessor var10 = (MinecraftAccessor)var2;
         var10.syky$setSession(var3.v1());
         var10.syky$setApiServices(var3.v2());
         var10.syky$setGameProfileFuture(CompletableFuture.completedFuture(var3.v4()));
         var10.syky$setUserApiService(var4);
         var10.syky$setUserPropertiesFuture(CompletableFuture.completedFuture(var3.v5()));
         var10.syky$setSocialInteractionsManager(var5);
         var10.syky$setTelemetryManager(var6);
         var10.syky$setProfileKeys(var7);
         var10.syky$setAbuseReportContext(var8);
         RealmsClientAccessor.syky$setInstance(null);
         RealmsAvailabilityAccessor.syky$setCurrentFuture(null);
         var10.syky$setRealmsPeriodicCheckers(new class_7578(class_4341.method_20989(var2)));

         try {
            var9.close();
         } catch (RuntimeException var12) {
            v1.debug("closing the previous telemetry manager failed", var12);
         }

         var2.method_24288();
      } else {
         throw new IllegalStateException("nothing to install into");
      }
   }

   @Override
   public void v1(String var1) {
      try {
         class_156.method_668().method_670(var1);
      } catch (RuntimeException var3) {
         v1.warn("could not open the browser", var3);
      }
   }

   @Override
   public void v2(String var1) {
      class_310 var2 = this.v5.v1();
      if (var2 != null) {
         var2.field_1774.method_1455(var1);
      }
   }

   private void v1(class_310 var1) {
      if (this.v6 == null) {
         class_320 var2 = var1.method_1548();
         if (var2 != null) {
            MinecraftAccessor var3 = (MinecraftAccessor)var1;
            String var4 = var2.method_1676();
            UUID var5 = var2.method_44717();
            String var6 = var2.method_1674();
            uiSupport272 var7;
            if (var5 != null && var5.version() == 4 && var6 != null && !var6.isBlank()) {
               var7 = uiSupport266.v3() ? uiSupport272.EXTERNAL : uiSupport272.MICROSOFT;
            } else {
               var7 = uiSupport272.OFFLINE;
            }

            this.v6 = new PRODSupport.Part2(
               var2,
               new uiSupport270.Part3(var4, var5 != null ? var5 : uiSupport267.v2(var4), var7),
               var1.method_73361(),
               var3.syky$getUserApiService(),
               var3.syky$getGameProfileFuture(),
               var3.syky$getUserPropertiesFuture()
            );
         }
      }
   }

   public record Part1(class_320 session, class_7497 services, UserApiService userApi, @Nullable ProfileResult profile, UserProperties properties)
      implements uiSupport270.Part1 {
      public class_320 v1() {
         return this.session;
      }

      public class_7497 v2() {
         return this.services;
      }

      public UserApiService v3() {
         return this.userApi;
      }

      @Nullable
      public ProfileResult v4() {
         return this.profile;
      }

      public UserProperties v5() {
         return this.properties;
      }
   }

   public record Part2(
      class_320 session,
      uiSupport270.Part3 identity,
      class_7497 services,
      UserApiService userApi,
      CompletableFuture<ProfileResult> profile,
      CompletableFuture<UserProperties> properties
   ) {
      public class_320 v1() {
         return this.session;
      }

      public uiSupport270.Part3 v2() {
         return this.identity;
      }

      public class_7497 v3() {
         return this.services;
      }

      public UserApiService v4() {
         return this.userApi;
      }

      public CompletableFuture<ProfileResult> v5() {
         return this.profile;
      }

      public CompletableFuture<UserProperties> v6() {
         return this.properties;
      }
   }
}
