package cc.syky.mixin.item;

import cc.syky.compat.GlintHooks;
import cc.syky.module.visual.visualSupport50;
import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import com.mojang.blaze3d.buffers.GpuBufferSlice;
import com.mojang.blaze3d.pipeline.RenderPipeline;
import com.mojang.blaze3d.systems.RenderPass;
import com.mojang.blaze3d.textures.GpuTextureView;
import net.minecraft.class_10799;
import net.minecraft.class_11282;
import net.minecraft.class_12137;
import net.minecraft.class_1921;
import org.jetbrains.annotations.Nullable;
import org.joml.Matrix4fc;
import org.joml.Vector3fc;
import org.joml.Vector4f;
import org.joml.Vector4fc;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;

@Mixin({class_1921.class})
public abstract class RenderLayerGlintMixin {
   @Shadow
   @Final
   @Nullable
   public String field_64011;

   public RenderLayerGlintMixin() {
   }

   @Shadow
   public abstract RenderPipeline method_73243();

   @WrapOperation(
      method = {"method_60895"},
      at = {@At(
         value = "INVOKE",
         target = "Lnet/minecraft/class_11282;method_71106(Lorg/joml/Matrix4fc;Lorg/joml/Vector4fc;Lorg/joml/Vector3fc;Lorg/joml/Matrix4fc;)Lcom/mojang/blaze3d/buffers/GpuBufferSlice;"
      )}
   )
   private GpuBufferSlice syky$tintGlint(class_11282 var1, Matrix4fc var2, Vector4fc var3, Vector3fc var4, Matrix4fc var5, Operation<GpuBufferSlice> var6) {
      if (visualSupport50.v3 && this.method_73243() == class_10799.field_56816) {
         Vector4f var7 = GlintHooks.modulator("armor_entity_glint".equals(this.field_64011));
         return var7 == null
            ? (GpuBufferSlice)var6.call(new Object[]{var1, var2, var3, var4, var5})
            : (GpuBufferSlice)var6.call(new Object[]{var1, var2, var7, var4, var5});
      } else {
         return (GpuBufferSlice)var6.call(new Object[]{var1, var2, var3, var4, var5});
      }
   }

   @WrapOperation(
      method = {"method_60895"},
      at = {@At(
         value = "INVOKE",
         target = "Lcom/mojang/blaze3d/systems/RenderPass;bindTexture(Ljava/lang/String;Lcom/mojang/blaze3d/textures/GpuTextureView;Lnet/minecraft/class_12137;)V"
      )}
   )
   private void syky$swapGlintTexture(RenderPass var1, String var2, GpuTextureView var3, class_12137 var4, Operation<Void> var5) {
      if (visualSupport50.v3 && "Sampler0".equals(var2) && this.method_73243() == class_10799.field_56816) {
         GpuTextureView var6 = GlintHooks.texture("armor_entity_glint".equals(this.field_64011));
         var5.call(new Object[]{var1, var2, var6 != null ? var6 : var3, var4});
      } else {
         var5.call(new Object[]{var1, var2, var3, var4});
      }
   }
}
