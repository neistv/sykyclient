package cc.syky.config;

import cc.syky.hud.AutoSupport;
import cc.syky.hud.GooSupport;
import cc.syky.hud.MySettingsSupport;
import cc.syky.hud.hudSupport;
import cc.syky.hud.hudSupport62;
import cc.syky.hud.hudSupport66;
import cc.syky.hud.hudSupport70;
import cc.syky.ui.uiSupport148;
import cc.syky.ui.uiSupport2;
import cc.syky.ui.uiSupport245;
import cc.syky.ui.uiSupport47;
import cc.syky.ui.uiSupport48;
import com.google.gson.JsonObject;
import org.jetbrains.annotations.Nullable;

public final class configSupport10 {
   public static final String v1 = "_gui";
   private static final String v2 = "_gui";
   private static final String v3 = "settings";
   private static final uiSupport48.Part1 v4 = uiSupport48.Part1.v1();
   @Nullable
   private final MySettingsSupport v5;
   private final SettingRegistry v6 = new SettingRegistry();
   private final BooleanSetting v7 = this.v6.add(new BooleanSetting("tooltips", true));
   private final BooleanSetting v8 = this.v6.addHidden(new BooleanSetting("sounds", true));
   private final BooleanSetting v9 = this.v6.add(new BooleanSetting("toggleSounds", true), SettingCondition.v1(this.v8));
   private final BooleanSetting v10 = this.v6.add(new BooleanSetting("bindSounds", true), SettingCondition.v1(this.v8));
   private final BooleanSetting v11 = this.v6.add(new BooleanSetting("selectionSounds", true), SettingCondition.v1(this.v8));
   private final IntSetting v12 = this.v6.add(new IntSetting("uiScale", 100, 50, 140).v1("%"));
   private final BooleanSetting v13 = this.v6.addHidden(new BooleanSetting("theme", true));
   private final EnumSetting<uiSupport48.Part2> v14 = this.v6.add(new EnumSetting<>("themeMode", uiSupport48.Part2.SIMPLE), SettingCondition.v1(this.v13));
   private final ColorSetting v15 = this.v1("themeAccent", uiSupport48.v1);
   private final ColorSetting v16 = this.v1("themeHighlight", uiSupport48.v2);
   private final ColorSetting v18 = this.v2("themeOpenPage", v4.v4());
   private final EnumSetting<AutoSupport.Part2> v19 = this.v6
      .add(new EnumSetting<>("themeBackgroundMode", AutoSupport.Part2.FLAT), SettingCondition.v1(this.v13));
   private final ColorSetting v17 = this.v6
      .add(new ColorSetting("themeBackground", uiSupport48.v3).setConditionEnum(this.v19, hudSupport70::v1), SettingCondition.v1(this.v13));
   private final ColorSetting v20 = this.v2("themeCard", v4.v7());
   private final ColorSetting v21 = this.v1("themeText", uiSupport48.v4);
   private final ColorSetting v22 = this.v2("themeSidebarText", v4.v9());
   private final ColorSetting v24 = this.v2("themeIcons", v4.v10());
   private final ColorSetting v25 = this.v2("themeLine", uiSupport48.v5);
   private int v26 = uiSupport48.v2;
   private int v27 = uiSupport48.v3;
   private int v28 = uiSupport48.v4;
   private boolean v29;
   private final BooleanSetting v30 = this.v6.addHidden(new BooleanSetting("blur", true));
   private final FloatSetting v32 = this.v6.add(new FloatSetting("blurStrength", 0.75F, 0.25F, 2.0F), SettingCondition.v1(this.v30));
   private final FloatSetting v23 = this.v6.add(new FloatSetting("blurSaturation", 1.25F, 1.0F, 2.0F), SettingCondition.v1(this.v30));
   private final BooleanSetting v33 = this.v6.add(new BooleanSetting("blurBleed", false), SettingCondition.v1(this.v30));
   private final BooleanSetting v31 = this.v6.add(new BooleanSetting("vibrancy", true), SettingCondition.v1(this.v30));
   private final FloatSetting v34 = this.v6.add(new FloatSetting("vibrancyAmount", 1.0F, 0.0F, 1.0F).setCondition(this.v31));
   private final BooleanSetting v36 = this.v6.addHidden(new BooleanSetting("shadow", true));
   private final IntSetting v38 = this.v6.add(new IntSetting("shadowSize", 44, 4, 64), SettingCondition.v1(this.v36));
   private final IntSetting v42 = this.v6.add(new IntSetting("shadowOpacity", 40, 0, 100), SettingCondition.v1(this.v36));
   private final BooleanSetting v43 = this.v6.add(new BooleanSetting("wobble", true));
   private final EnumSetting<GooSupport> v37 = this.v6.add(new EnumSetting<>("wobblePreset", hudSupport.v1).setCondition(this.v43));
   private final BooleanSetting v48 = this.v6.addHidden(new BooleanSetting("watermarks", true));
   private final BooleanSetting v40 = this.v6.add(new BooleanSetting("inventory", true), SettingCondition.v1(this.v48));
   private final ColorSetting v44 = this.v6.add(new ColorSetting("inventoryColor", -1).setCondition(this.v40));
   private final BooleanSetting v47 = this.v6.add(new BooleanSetting("loading", true), SettingCondition.v1(this.v48));
   private final ColorSetting v49 = this.v6.add(new ColorSetting("loadingBackground", -15856112), SettingCondition.v1(this.v47));
   private final ColorSetting v46 = this.v6.add(new ColorSetting("loadingText", -1), SettingCondition.v1(this.v47));
   private final BooleanSetting v51 = this.v6.add(new BooleanSetting("modulePreviews", true));
   private final BooleanSetting v50 = this.v6.addHidden(new BooleanSetting("discord", true));
   private final BooleanSetting v60 = this.v6.add(new BooleanSetting("showServer", true), SettingCondition.v1(this.v50));
   private final BooleanSetting v59 = this.v6.add(new BooleanSetting("showVersion", true), SettingCondition.v1(this.v50));
   @Nullable
   private String v53;

   public configSupport10(@Nullable MySettingsSupport var1) {
      this.v5 = var1;
      this.v6.setOnChange(() -> {
         this.v4();
         this.v3();
         this.v6();
      });
   }

   public SettingRegistry v1() {
      this.v5();
      return this.v6;
   }

   public boolean v2() {
      this.v5();
      return this.v7.getValue();
   }

   private void v3() {
      hudSupport62.v1(this.v12.getValue());
      boolean var1 = this.v19.getValue() == AutoSupport.Part2.TINT;
      uiSupport48.v1(
         this.v13.getValue(),
         this.v14.getValue() == uiSupport48.Part2.FULL
            ? new uiSupport48.Part1(
               this.v15.getValue(),
               this.v16.getValue(),
               this.v18.getValue(),
               this.v17.getValue(),
               var1,
               this.v20.getValue(),
               this.v21.getValue(),
               this.v22.getValue(),
               this.v24.getValue(),
               this.v25.getValue()
            )
            : uiSupport48.Part1.v1(this.v15.getValue(), this.v16.getValue(), this.v17.getValue(), var1, this.v21.getValue())
      );
      hudSupport70.v1(this.v30.getValue());
      hudSupport70.v1(this.v32.getValue());
      hudSupport70.v2(this.v23.getValue());
      hudSupport70.v3(this.v33.getValue());
      hudSupport70.v2(this.v31.getValue());
      hudSupport70.v3(this.v34.getValue());
      hudSupport66.v1(this.v36.getValue());
      hudSupport66.v1(this.v38.getValue());
      hudSupport66.v2(this.v42.getValue());
      hudSupport.v1(this.v43.getValue());
      hudSupport.v1(this.v37.getValue());
      uiSupport2.v1 = this.v48.getValue() && this.v40.getValue();
      uiSupport2.v2 = this.v44.getValue();
      uiSupport2.v3 = this.v48.getValue() && this.v47.getValue();
      uiSupport2.v4 = this.v49.getValue();
      uiSupport2.v5 = this.v46.getValue();
      configSupport9.v1(this.v51.getValue());
      uiSupport245.v1(this.v50.getValue());
      uiSupport245.v2(this.v60.getValue());
      uiSupport245.v3(this.v59.getValue());
      uiSupport148.v1(configSupport11.TOGGLES, this.v8.getValue() && this.v9.getValue());
      uiSupport148.v1(configSupport11.BINDS, this.v8.getValue() && this.v10.getValue());
      uiSupport148.v1(configSupport11.SELECTION, this.v8.getValue() && this.v11.getValue());
   }

   private ColorSetting v1(String var1, int var2) {
      return this.v6.add(new ColorSetting(var1, var2), SettingCondition.v1(this.v13));
   }

   private ColorSetting v2(String var1, int var2) {
      return this.v6.add(new ColorSetting(var1, var2), SettingCondition.v1(this.v14, uiSupport48.Part2.FULL));
   }

   private void v4() {
      if (!this.v29) {
         this.v29 = true;

         try {
            int var1 = this.v26;
            int var2 = this.v27;
            int var3 = this.v28;
            int var4 = this.v16.getValue();
            int var5 = this.v17.getValue();
            int var6 = this.v21.getValue();
            v1(this.v18, uiSupport48.v1(var1), uiSupport48.v1(var4));
            v1(this.v20, uiSupport48.v2(var2), uiSupport48.v2(var5));
            v1(this.v22, uiSupport48.v1(uiSupport47.NAV_INK, var3), uiSupport48.v1(uiSupport47.NAV_INK, var6));
            v1(this.v24, uiSupport48.v1(uiSupport47.ICON, var3), uiSupport48.v1(uiSupport47.ICON, var6));
            this.v26 = var4;
            this.v27 = var5;
            this.v28 = var6;
         } finally {
            this.v29 = false;
         }
      }
   }

   private static void v1(ColorSetting var0, int var1, int var2) {
      int var3 = var0.getValue() & 16777215;
      if (var3 == (var1 & 16777215) && var3 != (var2 & 16777215)) {
         var0.setValue(var0.getValue() & 0xFF000000 | var2 & 16777215);
      }
   }

   private void v5() {
      String var1 = this.v5 == null ? "" : this.v5.v3();
      if (!var1.equals(this.v53)) {
         this.v53 = var1;
         this.v6.v8();
         JsonObject var2 = this.v5 == null ? null : this.v5.v11("_gui");
         if (var2 != null && var2.has("settings") && var2.get("settings").isJsonObject()) {
            this.v6.load(var2.getAsJsonObject("settings"));
         }

         this.v26 = uiSupport48.v2;
         this.v27 = uiSupport48.v3;
         this.v28 = uiSupport48.v4;
         this.v4();
         this.v3();
      }
   }

   private void v6() {
      if (this.v5 != null) {
         JsonObject var1 = new JsonObject();
         var1.add("settings", this.v6.save());
         this.v5.v2("_gui", var1);
      }
   }
}
