package cc.syky.mixin.world;

import cc.syky.module.visual.visualSupport35;
import cc.syky.module.visual.visualSupport46;
import cc.syky.module.visual.visualSupport51;
import cc.syky.ui.uiSupport175;
import com.llamalad7.mixinextras.sugar.Local;
import net.minecraft.class_4184;
import net.minecraft.class_5636;
import net.minecraft.class_638;
import net.minecraft.class_7285;
import net.minecraft.class_758;
import net.minecraft.class_9779;
import org.joml.Vector4f;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin({class_758.class})
public abstract class FogRendererMixin {
   @Unique
   private static final float SYKY_FAR_START = 1.0E7F;
   @Unique
   private static final float SYKY_FAR_END = 1.0E8F;
   @Unique
   private final Vector4f syky$fogColor = new Vector4f();

   public FogRendererMixin() {
   }

   @Inject(
      method = {"method_62185"},
      at = {@At("RETURN")},
      cancellable = true
   )
   private void syky$recolorFog(class_4184 var1, float var2, class_638 var3, int var4, float var5, CallbackInfoReturnable<Vector4f> var6) {
      class_5636 var7 = var1.method_19334();
      if (var7 == class_5636.field_27886) {
         if (visualSupport35.v1 && !visualSupport35.v3) {
            this.syky$setColor(var6, visualSupport35.v2);
         }
      } else if (var7 != class_5636.field_27885 && var7 != class_5636.field_27887) {
         if (visualSupport51.v4 && visualSupport51.v6 && visualSupport51.v5 != visualSupport46.OFF) {
            this.syky$setColor(var6, visualSupport51.v7);
         } else {
            if (visualSupport51.v10 && visualSupport51.v11) {
               this.syky$setColor(var6, uiSupport175.v2);
            }
         }
      }
   }

   @Unique
   private void syky$setColor(CallbackInfoReturnable<Vector4f> var1, int var2) {
      var1.setReturnValue(this.syky$fogColor.set((var2 >> 16 & 0xFF) / 255.0F, (var2 >> 8 & 0xFF) / 255.0F, (var2 & 0xFF) / 255.0F, 1.0F));
   }

   @Inject(
      method = {"method_3211"},
      require = 0,
      allow = 1,
      at = {@At(
         value = "INVOKE",
         target = "Lcom/mojang/blaze3d/systems/CommandEncoder;mapBuffer(Lcom/mojang/blaze3d/buffers/GpuBuffer;ZZ)Lcom/mojang/blaze3d/buffers/GpuBuffer$MappedView;"
      )}
   )
   private void syky$shapeFog(
      class_4184 var1, int var2, class_9779 var3, float var4, class_638 var5, CallbackInfoReturnable<Vector4f> var6, @Local class_7285 var7
   ) {
      class_5636 var8 = var1.method_19334();
      if (var8 == class_5636.field_27886) {
         if (visualSupport35.v1 && visualSupport35.v3) {
            syky$clearBand(var7);
         }
      } else if (var8 != class_5636.field_27885 && var8 != class_5636.field_27887) {
         if (visualSupport51.v4) {
            if (visualSupport51.v5 == visualSupport46.OFF) {
               var7.field_60582 = 1.0E7F;
               var7.field_60584 = 1.0E8F;
               var7.field_60583 = 1.0E7F;
               var7.field_60585 = 1.0E8F;
            } else {
               float var9 = visualSupport51.v8;
               float var10 = visualSupport51.v9;
               var7.field_60582 = var9;
               var7.field_60584 = var10;
               var7.field_60583 = 1.0E7F;
               var7.field_60585 = 1.0E8F;
               if (visualSupport51.v5 == visualSupport46.FULL) {
                  var7.field_60099 = var10;
                  var7.field_60100 = var10;
               }
            }
         }
      }
   }

   @Unique
   private static void syky$clearBand(class_7285 var0) {
      var0.field_60582 = 1.0E7F;
      var0.field_60584 = 1.0E8F;
   }
}
