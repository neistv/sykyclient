package cc.syky.mixin.accessor;

import com.mojang.authlib.minecraft.UserApiService;
import com.mojang.authlib.minecraft.UserApiService.UserProperties;
import com.mojang.authlib.yggdrasil.ProfileResult;
import java.util.concurrent.CompletableFuture;
import net.minecraft.class_310;
import net.minecraft.class_320;
import net.minecraft.class_5520;
import net.minecraft.class_6628;
import net.minecraft.class_7497;
import net.minecraft.class_7574;
import net.minecraft.class_7578;
import net.minecraft.class_7853;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Mutable;
import org.spongepowered.asm.mixin.gen.Accessor;

@Mixin({class_310.class})
public interface MinecraftAccessor {
   @Accessor("field_1726")
   @Mutable
   void syky$setSession(class_320 var1);

   @Accessor("field_62106")
   @Mutable
   void syky$setApiServices(class_7497 var1);

   @Accessor("field_45899")
   CompletableFuture<ProfileResult> syky$getGameProfileFuture();

   @Accessor("field_45899")
   @Mutable
   void syky$setGameProfileFuture(CompletableFuture<ProfileResult> var1);

   @Accessor("field_26902")
   UserApiService syky$getUserApiService();

   @Accessor("field_26902")
   @Mutable
   void syky$setUserApiService(UserApiService var1);

   @Accessor("field_47680")
   CompletableFuture<UserProperties> syky$getUserPropertiesFuture();

   @Accessor("field_47680")
   @Mutable
   void syky$setUserPropertiesFuture(CompletableFuture<UserProperties> var1);

   @Accessor("field_26842")
   @Mutable
   void syky$setSocialInteractionsManager(class_5520 var1);

   @Accessor("field_41331")
   @Mutable
   void syky$setTelemetryManager(class_6628 var1);

   @Accessor("field_39068")
   @Mutable
   void syky$setProfileKeys(class_7853 var1);

   @Accessor("field_39492")
   void syky$setAbuseReportContext(class_7574 var1);

   @Accessor("field_39718")
   @Mutable
   void syky$setRealmsPeriodicCheckers(class_7578 var1);
}
