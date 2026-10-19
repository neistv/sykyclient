package cc.syky.mixin.hud;

import cc.syky.Syky;
import cc.syky.SykyRuntime;
import cc.syky.internal.InternalSupport15;
import cc.syky.module.visual.visualSupport34;
import cc.syky.module.visual.visualSupport36;
import cc.syky.ui.uiSupport140;
import cc.syky.ui.uiSupport142;
import cc.syky.ui.uiSupport181;
import cc.syky.ui.uiSupport259;
import com.mojang.blaze3d.buffers.GpuBufferSlice;
import com.mojang.blaze3d.pipeline.RenderPipeline;
import com.mojang.blaze3d.vertex.VertexFormat;
import java.util.List;
import java.util.Map;
import net.minecraft.class_1041;
import net.minecraft.class_11228;
import net.minecraft.class_11231;
import net.minecraft.class_11246;
import net.minecraft.class_11285;
import net.minecraft.class_155;
import net.minecraft.class_266;
import net.minecraft.class_269;
import net.minecraft.class_310;
import net.minecraft.class_332;
import net.minecraft.class_355;
import net.minecraft.class_8646;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin({class_11228.class})
public abstract class GuiRendererMixin {
   @Shadow
   @Final
   private class_11246 field_59914;
   @Shadow
   @Final
   private List<?> field_59915;
   @Shadow
   @Final
   private List<?> field_60310;
   @Shadow
   @Final
   private Map<VertexFormat, class_11285> field_60311;
   @Shadow
   private int field_60312;

   public GuiRendererMixin() {
   }

   @Shadow
   public abstract void method_71290();

   @Shadow
   public abstract void method_71291(GpuBufferSlice var1);

   @Shadow
   public abstract void method_72109();

   @Inject(
      method = {"method_70890"},
      at = {@At("TAIL")}
   )
   private void syky$compositeTailOverlays(GpuBufferSlice var1, CallbackInfo var2) {
      class_310 var3 = class_310.method_1551();
      SykyRuntime var4 = Syky.rootOrNull();
      if (var4 != null) {
         uiSupport259.v1("gui.clickgui-warmup", () -> uiSupport140.v1(var4.v2(), var3));
         uiSupport259.v1("gui.overvanilla-hud", () -> var4.v3().v18());
      }

      uiSupport259.v1("gui.hotbarkeys", () -> uiSupport181.v1(var3.field_1690));
      uiSupport259.v1("gui.totem-flash", visualSupport36::v5);
      uiSupport259.v1("gui.effect-alerts", visualSupport34::v1);
      if (var4 != null) {
         uiSupport259.v1("gui.hud-editor", () -> var4.v3().v3().v6());
         uiSupport259.v1("gui.hud-style-popup", () -> var4.v3().v1().v9());
      }

      uiSupport259.v1("gui.whatsnew", () -> InternalSupport15.v1(var3));
      if (uiSupport142.v1 != null) {
         long var5 = var4 == null ? 0L : var4.v24().v3();
         uiSupport259.v1("gui.clickgui-panel", () -> uiSupport142.v1(var3, var3.method_61966().method_60636()));
         if (var4 != null) {
            var4.v24().v1("clickgui.render", var5);
         }
      }

      boolean var7 = var4 != null && uiSupport259.v1("gui.overvanilla-gate", () -> var4.v3().v15(), false);
      if (var7) {
         uiSupport259.v1("gui.playerlist-ontop", () -> this.syky$reRenderPlayerList(var3, var1));
      }

      if (var7) {
         uiSupport259.v1("gui.debughud-ontop", () -> this.syky$reRenderDebugHud(var3, var1));
      }
   }

   private void syky$reRenderPlayerList(class_310 var1, GpuBufferSlice var2) {
      if (var1.field_1687 != null && var1.field_1724 != null) {
         class_269 var3 = var1.field_1687.method_8428();
         class_266 var4 = var3.method_1189(class_8646.field_45156);
         class_355 var5 = var1.field_1705.method_1750();
         boolean var6 = var1.field_1690.field_1907.method_1434()
            && (!var1.method_1542() || var1.field_1724.field_3944.method_45732().size() > 1 || var4 != null);
         if (!var6) {
            var5.method_1921(false);
         } else {
            var5.method_1921(true);
            class_1041 var7 = var1.method_22683();
            class_332 var8 = this.syky$overlayContext(var1, var7);

            try {
               var5.method_1919(var8, var7.method_4486(), var3, var4);
            } finally {
               this.syky$flushOverlayLayer(var2);
            }
         }
      }
   }

   private void syky$reRenderDebugHud(class_310 var1, GpuBufferSlice var2) {
      if (var1.field_1687 != null && var1.field_1724 != null && var1.method_53526().method_53536()) {
         class_332 var3 = this.syky$overlayContext(var1, var1.method_22683());

         try {
            var1.method_53526().method_1846(var3);
         } finally {
            this.syky$flushOverlayLayer(var2);
         }
      }
   }

   private class_332 syky$overlayContext(class_310 var1, class_1041 var2) {
      return new class_332(var1, this.field_59914, (int)var1.field_1729.method_68879(var2), (int)var1.field_1729.method_68883(var2));
   }

   private void syky$flushOverlayLayer(GpuBufferSlice var1) {
      this.method_71290();
      this.method_71291(var1);

      for (class_11285 var3 : this.field_60311.values()) {
         var3.method_71121();
      }

      this.field_59915.clear();
      this.field_60310.clear();
      this.field_59914.method_70926();
      this.field_60312 = Integer.MAX_VALUE;
      this.method_72109();
      if (class_155.field_59991) {
         RenderPipeline.updateSortKeySeed();
         class_11231.method_71298();
      }
   }
}
