package cc.syky.module.utilities;

import cc.syky.api.ModuleInfo;
import cc.syky.cloud.cloudSupport100;
import cc.syky.cloud.cloudSupport57;
import cc.syky.config.BooleanSetting;
import cc.syky.config.ColorSetting;
import cc.syky.config.EnumSetting;
import cc.syky.config.FloatSetting;
import cc.syky.config.SettingCondition;
import cc.syky.hud.LevelUpSupport;
import cc.syky.module.Module;
import cc.syky.module.ModuleCategory;
import cc.syky.ui.BypassSupport;
import cc.syky.ui.uiRecord14;
import cc.syky.ui.uiSupport192;
import cc.syky.ui.uiSupport193;
import cc.syky.ui.uiSupport194;
import cc.syky.ui.uiSupport202;
import cc.syky.ui.uiSupport203;
import cc.syky.ui.uiSupport205;
import cc.syky.ui.uiSupport207;
import java.nio.file.Path;
import java.util.UUID;
import net.minecraft.class_1109;
import net.minecraft.class_1113;
import net.minecraft.class_2561;
import net.minecraft.class_2960;
import net.minecraft.class_310;
import net.minecraft.class_3419;
import net.minecraft.class_638;
import net.minecraft.class_1113.class_1114;
import org.jetbrains.annotations.Nullable;

@ModuleInfo(
   name = "chatping",
   displayName = "Chat Ping",
   category = ModuleCategory.UTILITIES,
   group = "Readouts",
   description = "module.chatping.description"
)
public final class ChatPing extends Module implements cloudSupport100 {
   public static final long v2 = 3000L;
   public static final long name = 750L;
   public static final long displayName = 3000L;
   private static final long category = 250L;
   @Nullable
   private static ChatPing group;
   private final BooleanSetting description = this.settings.addHidden(new BooleanSetting("sound", true));
   private final EnumSetting<LevelUpSupport> defaultEnabled = this.settings
      .add(new EnumSetting<>("tone", LevelUpSupport.PLING), SettingCondition.v1(this.description));
   private final FloatSetting volume = this.settings
      .add(new FloatSetting("volume", 100.0F, 5.0F, 100.0F).setSuffix("%"), SettingCondition.v1(this.description));
   private final FloatSetting pitch = this.settings.add(new FloatSetting("pitch", 1.0F, 0.5F, 2.0F), SettingCondition.v1(this.description));
   private final BooleanSetting highlight = this.settings.add(new BooleanSetting("highlight", true));
   private final ColorSetting highlightColor = this.settings.add(new ColorSetting("highlightColor", -1287498191).setCondition(this.highlight));
   private final BooleanSetting underline = this.settings.add(new BooleanSetting("underline", true));
   private final BooleanSetting recolor = this.settings.add(new BooleanSetting("recolor", false));
   private final ColorSetting color = this.settings.add(new ColorSetting("color", -14003).setCondition(this.recolor));
   private final BooleanSetting whispers = this.settings.add(new BooleanSetting("whispers", true));
   private final BooleanSetting flash = this.settings.add(new BooleanSetting("flash", true));
   private final BooleanSetting notify = this.settings.add(new BooleanSetting("notify", true));
   private final uiRecord14 v17;
   private final BypassSupport v20;
   private final uiSupport202 v21 = new uiSupport202();
   @Nullable
   private class_638 v22;
   private long v24;
   private long v25;
   private long v26;
   private boolean v27;
   private boolean v28;
   @Nullable
   private LevelUpSupport v29;
   private float v30;
   private float v32;
   private long v23;

   public ChatPing(uiRecord14 var1, Path var2) {
      this.v17 = var1;
      this.v20 = new BypassSupport(BypassSupport.Part2.v1(), var2);
      group = this;
      this.setToggleActions(this::v17, () -> {
         uiSupport207.v1 = false;
         uiSupport207.v4 = 0;
      });
   }

   private void v17() {
      uiSupport207.v1 = true;
      uiSupport207.v4 = this.highlight.getValue() ? this.highlightColor.getValue() : 0;
   }

   @Override
   public void onRenderHook() {
      this.v22 = null;
      this.v21.v1();
   }

   public static class_2561 v1(class_2561 var0) {
      uiSupport207.v3 = false;
      ChatPing var1 = group;
      return var1 != null && var1.isEnabled() && uiSupport194.v1 ? var1.v1(var0, uiSupport194.v2) : var0;
   }

   public static void v2(String var0) {
      ChatPing var1 = group;
      if (var1 != null && var1.isEnabled()) {
         var1.v21.v1(var0, System.currentTimeMillis());
      }
   }

   private class_2561 v1(class_2561 var1, @Nullable UUID var2) {
      class_310 var3 = this.v17.v2().v1();
      if (var3 == null) {
         return var1;
      } else {
         String var4 = var3.method_1548().method_1676();
         if (var4 != null && !var4.isEmpty() && (var2 == null || !var2.equals(var3.method_1548().method_44717()))) {
            String var5 = uiSupport205.v1(var1);
            if (var5 != null && uiSupport203.v2(var5)) {
               return var1;
            } else {
               String var6 = uiSupport192.v1(var1);
               long var7 = System.currentTimeMillis();
               int[] var9 = uiSupport193.v1(var6, var4);
               if (var9.length <= 0 || var2 != null || !uiSupport203.v1(var6, var4) && !this.v21.v1(var6, var9, var7)) {
                  boolean var10 = this.whispers.getValue() && ("commands.message.display.incoming".equals(var5) || var2 == null && uiSupport203.v1(var6));
                  if (var9.length == 0 && !var10) {
                     return var1;
                  } else {
                     this.v1(var3, var7, var10);
                     uiSupport207.v3 = true;
                     return var9.length != 0 && (this.underline.getValue() || this.recolor.getValue())
                        ? uiSupport205.v1(var1, var9, this.underline.getValue(), this.recolor.getValue() ? this.color.getValue() & 16777215 : -1)
                        : var1;
                  }
               } else {
                  return var1;
               }
            }
         } else {
            return var1;
         }
      }
   }

   private void v1(class_310 var1, long var2, boolean var4) {
      this.v1(var1, var2);
      if (var2 >= this.v24 && var2 - this.v25 >= 750L) {
         this.v25 = var2;
         if (this.description.getValue()) {
            this.v1(var1);
         }

         if (this.flash.getValue() && !var1.method_1569()) {
            cloudSupport57.v3(var1.method_22683());
         }

         if (this.notify.getValue() && !var1.method_1569() && var2 - this.v26 >= 3000L) {
            this.v26 = var2;
            this.v20.v1("Chat Ping", var4 ? "You got a private message" : "You were mentioned in chat");
         }
      }
   }

   @Override
   public void onResetHook() {
      class_310 var1 = this.v17.v2().v1();
      if (var1 != null) {
         this.v1(var1, System.currentTimeMillis());
      }
   }

   private void v1(class_310 var1, long var2) {
      if (var1.field_1687 != this.v22) {
         this.v22 = var1.field_1687;
         this.v24 = var2 + 3000L;
      }
   }

   private void v1(class_310 var1) {
      class_1109 var2 = new class_1109(
         class_2960.method_60656(this.defaultEnabled.getValue().v2()),
         class_3419.field_15250,
         this.volume.getValue() / 100.0F,
         this.pitch.getValue(),
         class_1113.method_43221(),
         false,
         0,
         class_1114.field_5478,
         0.0,
         0.0,
         0.0,
         true
      );
      uiSupport207.v2 = true;

      try {
         var1.method_1483().method_4873(var2);
      } finally {
         uiSupport207.v2 = false;
      }
   }

   @Override
   public void v1() {
      long var1 = System.currentTimeMillis();
      boolean var3 = this.description.getValue() != this.v28
         || this.defaultEnabled.getValue() != this.v29
         || this.volume.getValue() != this.v30
         || this.pitch.getValue() != this.v32;
      this.v28 = this.description.getValue();
      this.v29 = this.defaultEnabled.getValue();
      this.v30 = this.volume.getValue();
      this.v32 = this.pitch.getValue();
      if (!this.v27) {
         this.v27 = true;
      } else if (var3) {
         this.v23 = var1 + 250L;
      } else {
         if (this.v23 != 0L && var1 >= this.v23) {
            this.v23 = 0L;
            class_310 var4 = this.v17.v2().v1();
            if (var4 != null && this.description.getValue()) {
               this.v1(var4);
            }
         }
      }
   }

   @Override
   public void v2() {
      this.v27 = false;
      this.v23 = 0L;
   }
}
