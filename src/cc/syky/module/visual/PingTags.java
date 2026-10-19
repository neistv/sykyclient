package cc.syky.module.visual;

import cc.syky.api.ModuleInfo;
import cc.syky.config.ColorSetting;
import cc.syky.config.IntSetting;
import cc.syky.internal.InternalSupport32;
import cc.syky.module.Module;
import cc.syky.module.ModuleCategory;
import cc.syky.ui.uiRecord14;
import net.fabricmc.fabric.api.client.rendering.v1.world.WorldRenderContext;
import net.minecraft.class_1297;
import net.minecraft.class_1657;
import net.minecraft.class_268;
import net.minecraft.class_310;
import net.minecraft.class_3532;
import net.minecraft.class_634;
import net.minecraft.class_640;
import org.jetbrains.annotations.Nullable;

@ModuleInfo(
   name = "pingtags",
   displayName = "Ping Tags",
   category = ModuleCategory.VISUAL,
   group = "Player Info",
   description = "module.pingtags.description"
)
public final class PingTags extends Module implements visualSupport53.Part1<class_1657> {
   private static final double v2 = 0.25;
   private static final double name = 0.38;
   private static final double displayName = 4096.0;
   private static final double category = 1024.0;
   private static final int group = 32;
   private final ColorSetting goodColor = this.settings.add(new ColorSetting("goodColor", -1));
   private final ColorSetting badColor = this.settings.add(new ColorSetting("badColor", -2359296));
   private final IntSetting badPing = this.settings.add(new IntSetting("badPing", 100, 50, 250));
   private final uiRecord14 enableAction;
   private final visualSupport53<class_1657> disableAction = new visualSupport53(32);

   public PingTags(uiRecord14 var1) {
      this.enableAction = var1;
   }

   @Override
   public void onDisableHook() {
      this.disableAction.v1();
   }

   @Override
   public void onRenderHook() {
      this.disableAction.v1();
   }

   @Override
   public void onResetHook() {
      this.disableAction.v1(this.enableAction.v2().v1(), this);
   }

   @Nullable
   public class_1657 v1(class_1297 var1, class_1657 var2) {
      return var1 instanceof class_1657 var3 && var3 != var2 ? var3 : null;
   }

   public boolean v1(class_1657 var1, double var2) {
      return var2 <= 4096.0 && (!var1.method_21751() || !(var2 > 1024.0));
   }

   public boolean v1(class_1657 var1, class_1657 var2) {
      return var1.method_5805() && !var1.method_5756(var2) && !v2(var1, var2);
   }

   @Override
   public void onWorldRenderContext(WorldRenderContext var1) {
      if (!this.disableAction.v3()) {
         class_310 var2 = this.enableAction.v2().v1();
         if (var2 != null && var2.field_1687 != null && var2.field_1724 != null) {
            class_634 var3 = this.enableAction.v2().v4();
            if (var3 != null) {
               float var4 = var2.method_61966().method_60637(false);
               int var5 = this.goodColor.getValue();
               int var6 = this.badColor.getValue();
               int var7 = this.badPing.getValue();

               for (int var8 = 0; var8 < this.disableAction.v2(); var8++) {
                  class_1657 var9 = (class_1657)this.disableAction.v1(var8);
                  if (var9.method_5805()) {
                     class_640 var10 = var3.method_2871(var9.method_5667());
                     if (var10 != null) {
                        int var11 = var10.method_2959();
                        if (var11 >= 0) {
                           double var12 = var4;
                           double var14 = class_3532.method_16436(var12, var9.field_6014, var9.method_23317());
                           double var16 = class_3532.method_16436(var12, var9.field_5969, var9.method_23321());
                           double var18 = class_3532.method_16436(var12, var9.field_6036, var9.method_23318()) + var9.method_17682();
                           double var20 = visualSupport56.v2(var9.method_5628(), var18 + 0.25) + 0.38;
                           InternalSupport32.v1(
                              PingSupport2.v1(var11), var14, var20, var16, 1.0F, PingSupport2.v1(var11, var5, var6, var7), !var9.method_21751()
                           );
                        }
                     }
                  }
               }
            }
         }
      }
   }

   private static boolean v2(class_1657 var0, class_1657 var1) {
      class_268 var2 = var0.method_5781();
      if (var2 == null) {
         return false;
      } else {
         class_268 var3 = var1.method_5781();

         return switch (var2.method_1201()) {
            case field_1443 -> true;
            case field_1444 -> var3 != null && !var2.method_1206(var3);
            case field_1446 -> var3 != null && var2.method_1206(var3);
            default -> false;
         };
      }
   }
}
