package cc.syky.ui;

import cc.syky.config.BooleanSetting;
import cc.syky.config.EnumSetting;
import cc.syky.config.SettingRegistry;
import com.google.gson.JsonObject;

public final class uiSupport271 {
   private final SettingRegistry v1 = new SettingRegistry();
   private final EnumSetting<DateAddedSupport> v2 = this.v1.add(new EnumSetting<>("sortBy", DateAddedSupport.LAST_USED));
   private final EnumSetting<LastSeenDisplay> v3 = this.v1.add(new EnumSetting<>("besideName", LastSeenDisplay.SERVER_AND_TIME));
   private final BooleanSetting v4 = this.v1.add(new BooleanSetting("splitByType", true));
   private final BooleanSetting v5 = this.v1.add(new BooleanSetting("rememberAccount", true));

   public uiSupport271() {
   }

   public SettingRegistry v1() {
      return this.v1;
   }

   public DateAddedSupport v2() {
      return this.v2.getValue();
   }

   public LastSeenDisplay v3() {
      return this.v3.getValue();
   }

   public boolean v4() {
      return this.v4.getValue();
   }

   public boolean v5() {
      return this.v5.getValue();
   }

   public JsonObject v6() {
      return this.v1.save();
   }

   public void v1(JsonObject var1) {
      this.v1.load(var1);
   }
}
