package cc.syky.config;

import cc.syky.cloud.OnlyMeSupport2;
import cc.syky.hud.hudSupport64;
import cc.syky.ui.AltManagerSupport;
import cc.syky.ui.uiSupport143;
import cc.syky.ui.uiSupport69;

public final class OnlyMeSupport {
   public static final String v1 = "_socials";
   private static final String v2 = "Socials";
   private final OnlyMeSupport2 v3;
   private final EnumSetting<OnlyMeSupport.Part1> v4;
   private final EnumSetting<OnlyMeSupport.Part2> v5;
   private final uiSupport69 v6;
   private boolean v7;

   public OnlyMeSupport(OnlyMeSupport2 var1, float var2) {
      this.v3 = var1;
      SettingRegistry var3 = new SettingRegistry();
      this.v4 = var3.add(new EnumSetting<>("showServerTo", OnlyMeSupport.Part1.FRIENDS), SettingCondition.v1(var1::v14));
      this.v5 = var3.add(new EnumSetting<>("friendRequestsFrom", OnlyMeSupport.Part2.EVERYONE), SettingCondition.v1(() -> var1.v14() && var1.v13()));
      this.v3();
      var3.setOnChange(this::v4);
      var1.v15();
      configRecord var4 = configRecord.v1("Socials", uiSupport143.v1(AltManagerSupport.SOCIALS.v2()));
      this.v6 = new uiSupport69("_socials", var3, var4, var2);
   }

   public uiSupport69 v1() {
      return this.v6;
   }

   public void v2() {
      if (!this.v7) {
         this.v3();
      }
   }

   private void v3() {
      if (this.v3.v14()) {
         this.v7 = true;
         this.v4.setValue(this.v3.v11() ? OnlyMeSupport.Part1.FRIENDS : OnlyMeSupport.Part1.NOBODY);
         this.v5.setValue(this.v3.v12() ? OnlyMeSupport.Part2.EVERYONE : OnlyMeSupport.Part2.NOBODY);
      }
   }

   private void v4() {
      if (this.v7) {
         boolean var1 = this.v4.getValue() == OnlyMeSupport.Part1.FRIENDS;
         if (var1 != this.v3.v11()) {
            this.v3.v2(var1);
         }

         boolean var2 = this.v5.getValue() == OnlyMeSupport.Part2.EVERYONE;
         if (var2 != this.v3.v12()) {
            this.v3.v1(var2);
         }
      }
   }

   public static enum Part1 implements hudSupport64 {
      FRIENDS("Friends"),
      NOBODY("Only me");

      private final String label;

      private Part1(String var3) {
         this.label = var3;
      }

      @Override
      public String v1() {
         return this.label;
      }
   }

   public static enum Part2 implements hudSupport64 {
      EVERYONE("Everyone"),
      NOBODY("Nobody");

      private final String label;

      private Part2(String var3) {
         this.label = var3;
      }

      @Override
      public String v1() {
         return this.label;
      }
   }
}
