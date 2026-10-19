package cc.syky.internal;

import cc.syky.ui.uiSupport260;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents.EndTick;
import net.fabricmc.fabric.api.client.rendering.v1.LivingEntityFeatureRenderEvents;
import net.fabricmc.fabric.api.client.rendering.v1.LivingEntityFeatureRendererRegistrationCallback;
import net.fabricmc.fabric.api.client.rendering.v1.LivingEntityFeatureRenderEvents.AllowCapeRender;
import net.fabricmc.fabric.api.client.rendering.v1.world.WorldRenderEvents;
import net.fabricmc.fabric.api.client.rendering.v1.world.WorldRenderEvents.AfterEntities;
import net.fabricmc.fabric.api.client.rendering.v1.world.WorldRenderEvents.BeforeEntities;
import net.minecraft.class_1007;

public final class InternalSupport43 {
   private static final uiSupport260 v1 = new uiSupport260("cosmetics (feature registration)");
   private static final uiSupport260 v2 = new uiSupport260("cosmetics (vanilla cape)");
   private static final uiSupport260 v3 = new uiSupport260("cosmetics (frame)");
   private static final uiSupport260 v4 = new uiSupport260("cosmetics (tick)");

   private InternalSupport43() {
   }

   public static void v1() {
      LivingEntityFeatureRendererRegistrationCallback.EVENT.register((LivingEntityFeatureRendererRegistrationCallback)(var0, var1, var2, var3) -> v1.v1(() -> {
         if (var1 instanceof class_1007 var2x) {
            var2.register(new InternalSupport42(var2x));
         }
      }));
      LivingEntityFeatureRenderEvents.ALLOW_CAPE_RENDER.register((AllowCapeRender)var0 -> v2.v1(() -> InternalSupport38.v1(var0), true));
      WorldRenderEvents.BEFORE_ENTITIES.register((BeforeEntities)var0 -> v3.v1(InternalSupport38::v4));
      WorldRenderEvents.AFTER_ENTITIES.register((AfterEntities)var0 -> v3.v1(InternalSupport38::v5));
      ClientTickEvents.END_CLIENT_TICK.register((EndTick)var0 -> v4.v1(InternalSupport38::v6));
   }
}
