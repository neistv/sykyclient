package cc.syky.module;

import cc.syky.config.SettingRegistry;
import org.jetbrains.annotations.Nullable;

public interface ModuleContract {
   String getName();

   default String getDisplayName() {
      return this.getName();
   }

   ModuleCategory getCategory();

   default String getGroup() {
      return "";
   }

   boolean isEnabled();

   default boolean isDefaultEnabled() {
      return false;
   }

   default String getDescription() {
      return "";
   }

   void enable();

   void disable();

   void reset();

   void onWorldRender(@Nullable Object var1);

   void onTick();

   void onRender();

   SettingRegistry getSettings();
}
