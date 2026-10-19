package cc.syky.module.utilities;

import cc.syky.api.ModuleInfo;
import cc.syky.config.BooleanSetting;
import cc.syky.config.ColorSetting;
import cc.syky.config.FloatSetting;
import cc.syky.module.Module;
import cc.syky.module.ModuleCategory;
import cc.syky.module.visual.visualSupport9;
import cc.syky.ui.uiRecord14;
import cc.syky.ui.uiSupport155;
import net.fabricmc.fabric.api.client.rendering.v1.world.WorldRenderContext;
import net.minecraft.class_310;
import net.minecraft.class_3532;
import net.minecraft.class_638;
import net.minecraft.class_746;

@ModuleInfo(
   name = "chunkborders",
   displayName = "Chunk Borders",
   category = ModuleCategory.UTILITIES,
   group = "Readouts",
   description = "module.chunkborders.description"
)
public final class ChunkBorders extends Module {
   private static final int v2 = 16;
   private static final float name = 0.45F;
   private static final float displayName = 0.35F;
   private final ColorSetting color = this.settings.add(new ColorSetting("color", -10827526));
   private final FloatSetting thickness = this.settings.add(new FloatSetting("thickness", 2.0F, 0.5F, 6.0F));
   private final BooleanSetting throughWalls = this.settings.add(new BooleanSetting("throughWalls", true));
   private final uiRecord14 defaultEnabled;
   private double subscriptions;
   private double enableAction;
   private double disableAction;
   private float enabled;
   private boolean v13;

   public ChunkBorders(uiRecord14 var1) {
      this.defaultEnabled = var1;
   }

   @Override
   public void onWorldRenderContext(WorldRenderContext var1) {
      class_310 var2 = this.defaultEnabled.v2().v1();
      class_746 var3 = var2.field_1724;
      class_638 var4 = var2.field_1687;
      if (var3 != null && var4 != null) {
         int var5 = var4.method_31607();
         int var6 = var5 + var4.method_31605();
         int var7 = Math.floorDiv(var3.method_31477(), 16) * 16;
         int var8 = Math.floorDiv(var3.method_31479(), 16) * 16;
         int var9 = class_3532.method_15340(Math.floorDiv(class_3532.method_15357(var3.method_23318()), 16) * 16, var5, var6 - 16);
         int var10 = var7 + 16;
         int var11 = var9 + 16;
         int var12 = var8 + 16;
         this.subscriptions = var7 + 8.0;
         this.enableAction = var9 + 8.0;
         this.disableAction = var8 + 8.0;
         this.enabled = this.thickness.getValue();
         this.v13 = this.throughWalls.getValue();
         int var13 = this.color.getValue();
         int var14 = uiSupport155.v1(var13, 0.35F);
         this.v1(var7, var8, var10, var12, var9, var13);
         this.v1(var7, var8, var10, var12, var11, var13);
         this.v1(var7, var8, var5, var9, var11, var6, var13, var14);
         this.v1(var10, var8, var5, var9, var11, var6, var13, var14);
         this.v1(var7, var12, var5, var9, var11, var6, var13, var14);
         this.v1(var10, var12, var5, var9, var11, var6, var13, var14);
      }
   }

   private void v1(int var1, int var2, int var3, int var4, int var5, int var6) {
      this.v1(var1, var5, var2, var3, var5, var2, var6);
      this.v1(var1, var5, var4, var3, var5, var4, var6);
      this.v1(var1, var5, var2, var1, var5, var4, var6);
      this.v1(var3, var5, var2, var3, var5, var4, var6);
   }

   private void v1(int var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8) {
      this.v1(var1, var4, var2, var1, var5, var2, var7);
      this.v1(var1, var3, var2, var1, var4, var2, var8);
      this.v1(var1, var5, var2, var1, var6, var2, var8);
   }

   private void v1(int var1, int var2, int var3, int var4, int var5, int var6, int var7) {
      if ((var1 != var4 || var2 != var5 || var3 != var6) && visualSupport9.v1(var1, var2, var3, var4, var5, var6)) {
         visualSupport9.v1(var1, var2, var3, var4, var5, var6, this.subscriptions, this.enableAction, this.disableAction, var7, this.enabled, false);
         if (this.v13) {
            visualSupport9.v1(
               var1, var2, var3, var4, var5, var6, this.subscriptions, this.enableAction, this.disableAction, uiSupport155.v1(var7, 0.45F), this.enabled, true
            );
         }
      }
   }
}
