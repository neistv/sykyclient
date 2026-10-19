package cc.syky.module;

import cc.syky.api.ModuleInfo;
import cc.syky.config.SettingRegistry;
import cc.syky.render.renderSupport47;
import java.util.ArrayList;
import java.util.List;
import net.fabricmc.fabric.api.client.rendering.v1.world.WorldRenderContext;
import org.jetbrains.annotations.Nullable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public abstract class Module implements ModuleContract {
   private static final Logger v2 = LoggerFactory.getLogger("syky.modules");
   private final String name;
   private final String displayName;
   private final ModuleCategory category;
   private final String group;
   private final String description;
   private final boolean defaultEnabled;
   public final SettingRegistry settings = new SettingRegistry();
   private final List<ModuleSubscription> subscriptions = new ArrayList<>();
   @Nullable
   private Runnable enableAction;
   @Nullable
   private Runnable disableAction;
   private boolean enabled;

   public Module() {
      ModuleInfo var1 = this.getClass().getAnnotation(ModuleInfo.class);
      if (var1 == null) {
         throw new IllegalStateException(this.getClass().getName() + " missing @ModuleInfo");
      } else {
         this.name = var1.name();
         this.displayName = var1.displayName().isEmpty() ? var1.name() : var1.displayName();
         this.category = var1.category();
         this.group = var1.group();
         this.description = var1.description();
         this.defaultEnabled = var1.defaultEnabled();
      }
   }

   @Override
   public final String getName() {
      return this.name;
   }

   @Override
   public final String getDisplayName() {
      return this.displayName;
   }

   @Override
   public final ModuleCategory getCategory() {
      return this.category;
   }

   @Override
   public final String getGroup() {
      return this.group;
   }

   @Override
   public final boolean isEnabled() {
      return this.enabled;
   }

   @Override
   public final boolean isDefaultEnabled() {
      return this.defaultEnabled;
   }

   @Override
   public final String getDescription() {
      return this.description;
   }

   @Override
   public final SettingRegistry getSettings() {
      return this.settings;
   }

   @Override
   public final void enable() {
      if (!this.enabled) {
         this.enabled = true;

         try {
            if (this.enableAction != null) {
               this.enableAction.run();
            }

            this.onEnableHook();
         } catch (Throwable var2) {
            this.enabled = false;
            this.v17();
            throw var2;
         }
      }
   }

   @Override
   public final void disable() {
      if (this.enabled) {
         this.enabled = false;

         try {
            this.onDisableHook();
         } finally {
            this.v17();
         }
      }
   }

   public final void addSubscription(ModuleSubscription var1) {
      this.subscriptions.add(var1);
   }

   private void v17() {
      if (this.disableAction != null) {
         try {
            this.disableAction.run();
         } catch (Throwable var5) {
            v2.error("module {} failed to clear its mirror", this.name, var5);
         }
      }

      for (ModuleSubscription var2 : this.subscriptions) {
         try {
            var2.close();
         } catch (Throwable var4) {
            v2.error("module {} failed to close a subscription", this.name, var4);
         }
      }

      this.subscriptions.clear();
   }

   @Override
   public final void reset() {
      if (this.enableAction != null) {
         this.enableAction.run();
      }

      this.onResetHook();
   }

   public final void setToggleActions(Runnable var1, Runnable var2) {
      if (this.enableAction != null) {
         throw new IllegalStateException(this.name + " declared a mirror twice");
      } else {
         this.enableAction = var1;
         this.disableAction = var2;
      }
   }

   @Override
   public final void onWorldRender(@Nullable Object var1) {
      this.onWorldRenderContext(renderSupport47.v1((WorldRenderContext)var1));
   }

   @Override
   public final void onTick() {
      this.onTickHook();
   }

   @Override
   public final void onRender() {
      this.onRenderHook();
   }

   public void onEnableHook() {
   }

   public void onDisableHook() {
   }

   public void onTickHook() {
   }

   public void onRenderHook() {
   }

   public void onResetHook() {
   }

   public void onWorldRenderContext(WorldRenderContext var1) {
   }
}
