package cc.syky.config;

import com.google.gson.JsonObject;

public final class configSupport {
   public static final float v1 = 0.5F;
   public static final float v2 = 2.0F;
   private final SettingRegistry v3 = new SettingRegistry();
   private final BooleanSetting v4 = this.v3.add(new BooleanSetting("allWorlds", false));
   private final BooleanSetting v5 = this.v3.add(new BooleanSetting("deathPoints", false));
   private final BooleanSetting v6 = this.v3.add(new BooleanSetting("removeReachedDeaths", true), SettingCondition.v1(this.v5));
   private final FloatSetting v7 = this.v3.add(new FloatSetting("markerSize", 1.0F, 0.5F, 2.0F));

   public configSupport() {
   }

   public SettingRegistry v1() {
      return this.v3;
   }

   public boolean v2() {
      return this.v4.getValue();
   }

   public boolean v3() {
      return this.v5.getValue();
   }

   public boolean v4() {
      return this.v5.getValue() && this.v6.getValue();
   }

   public float v5() {
      return this.v7.getValue();
   }

   public JsonObject v6() {
      return this.v3.save();
   }

   public void v1(JsonObject var1) {
      this.v3.load(var1);
   }
}
