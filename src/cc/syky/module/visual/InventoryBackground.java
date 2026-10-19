package cc.syky.module.visual;

import cc.syky.FileNotSupport;
import cc.syky.api.ModuleInfo;
import cc.syky.config.BooleanSetting;
import cc.syky.config.EnumSetting;
import cc.syky.config.IntSetting;
import cc.syky.hud.FitSupport;
import cc.syky.internal.InternalSupport50;
import cc.syky.internal.InternalSupport51;
import cc.syky.module.Module;
import cc.syky.module.ModuleCategory;
import cc.syky.ui.uiRecord14;
import net.minecraft.class_310;
import org.jetbrains.annotations.Nullable;

@ModuleInfo(
   name = "inventorybackground",
   displayName = "Inventory Background",
   category = ModuleCategory.VISUAL,
   group = "Interface",
   description = "module.inventorybackground.description"
)
public final class InventoryBackground extends Module {
   private static final String v2 = "Inventory Background: choose a GIF or a photo";
   private final uiRecord14 name;
   private final FileNotSupport displayName;
   private final InternalSupport50 category = new InternalSupport50();
   private final visualSupport group;
   private final visualSupport7 description = this.settings.add(new visualSupport7("picture", "Select GIF / photo").v2(this::v22).v1(this::v21));
   private final EnumSetting<FitSupport> defaultEnabled = this.settings.add(new EnumSetting<>("fit", FitSupport.FILL));
   private final IntSetting subscriptions = this.settings.add(new IntSetting("opacity", 100, 10, 100).v1("%"));
   private final IntSetting enableAction = this.settings.add(new IntSetting("slotOpacity", 30, 0, 100).v1("%"));
   private final IntSetting disableAction = this.settings.add(new IntSetting("speed", 100, 25, 300).v1("%"));
   private final BooleanSetting enabled = this.settings.add(new BooleanSetting("fillPlayerBox", true));

   public InventoryBackground(uiRecord14 var1) {
      this.name = var1;
      this.displayName = new FileNotSupport(var1.v3(), var1.v4());
      this.group = new visualSupport(var1.v3(), var1.v4(), "Inventory Background: choose a GIF or a photo", this.displayName::v3);
      this.setToggleActions(this::onEnable, this::onDisable);
   }

   private void onEnable() {
      class_310 var1 = this.name.v2().v1();
      if (var1 != null && var1.field_1773 != null) {
         int var2 = var1.method_22683().method_4495();
         this.displayName.v1(this.description.v12(), 176 * var2 * 2);
         this.displayName.v1(InternalSupport51.v8);
         if (this.description.v10()) {
            this.category.v1(var1, this.name.v3(), this.name.v4(), this.enabled.getValue());
         }

         InternalSupport51.v1(
            this.displayName.v1(),
            this.category.v2(),
            this.defaultEnabled.getValue(),
            this.subscriptions.getValue().intValue() / 100.0F,
            this.enableAction.getValue().intValue() / 100.0F,
            this.disableAction.getValue().intValue() / 100.0F
         );
      }
   }

   private void onDisable() {
      InternalSupport51.v2();
      this.displayName.v3();
      this.category.v4();
   }

   @Nullable
   private String v21() {
      if (this.group.v1()) {
         return "Choosing...";
      } else {
         return this.isEnabled() ? this.displayName.v2() : null;
      }
   }

   private void v22() {
      this.group.v1(this.description);
   }
}
