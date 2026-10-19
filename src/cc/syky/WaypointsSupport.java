package cc.syky;

import cc.syky.config.BooleanSetting;
import cc.syky.config.ColorSetting;
import cc.syky.config.FloatSetting;
import cc.syky.config.IntSetting;
import cc.syky.config.SettingRegistry;
import cc.syky.config.configRecord;
import cc.syky.hud.hudSupport75;
import cc.syky.internal.InternalSupport7;
import cc.syky.ui.AltManagerSupport;
import cc.syky.ui.uiSupport143;
import cc.syky.ui.uiSupport69;
import java.util.List;
import net.minecraft.class_2960;
import org.jetbrains.annotations.Nullable;

public final class WaypointsSupport {
   public static final String v1 = "_waypoint";
   public static final String v2 = "_waypoints";
   private static final String v3 = "Waypoints";

   private WaypointsSupport() {
   }

   public static uiSupport69 v1(InternalSupport7 var0, sykyRecord4 var1, @Nullable hudSupport75 var2, String var3, float var4) {
      SettingRegistry var5 = new SettingRegistry();
      ColorSetting var6 = var5.add(new ColorSetting("color", var1.v12()));
      float var7 = var0.v3().v5();
      BooleanSetting var8 = var5.add(new BooleanSetting("customSize", var1.v17() != 0.0F));
      FloatSetting var9 = var5.add(new FloatSetting("markerSize", var7, 0.5F, 2.0F).setCondition(var8));
      var9.setValue(var1.v2(var7));
      String var10 = var1.v3() ? null : EndSupport.v1(var1.v9());
      BooleanSetting var11 = var10 == null ? null : var5.add(new BooleanSetting(v1(var10), var1.v11()));
      boolean var12 = var1.v3();
      sykyRecord5 var13 = var1.v19();
      IntSetting var14 = var12 ? var5.add(new IntSetting("fillOpacity", var13.v1(), 0, 100)) : null;
      FloatSetting var15 = var12 ? var5.add(new FloatSetting("outlineThickness", var13.v2(), 0.25F, 4.0F)) : null;
      FloatSetting var16 = var12 ? var5.add(new FloatSetting("markerHeight", var13.v3(), 0.0F, 10.0F)) : null;
      BooleanSetting var17 = var5.add(new BooleanSetting("alwaysLabel", var1.v13()));
      String var18 = var1.v4();
      var5.setOnChange(() -> {
         sykyRecord4 var10x = var0.v1(var18);
         if (var10x != null) {
            int var11x = var6.getValue();
            if (var11x != var10x.v12()) {
               var0.v1(var18, var11x);
            }

            if (var11 != null && var11.getValue() != var10x.v11()) {
               var0.v2(var18, var11.getValue());
            }

            if (var17.getValue() != var10x.v13()) {
               var0.v3(var18, var17.getValue());
            }

            float var12x = var8.getValue() ? var9.getValue() : 0.0F;
            if (Float.compare(var12x, var10x.v17()) != 0) {
               var0.v1(var18, var12x);
            }

            if (var14 != null && var15 != null && var16 != null) {
               sykyRecord5 var13x = new sykyRecord5(var14.getValue(), var15.getValue(), var16.getValue());
               if (!var13x.equals(var10x.v19())) {
                  var0.v1(var18, var13x);
               }
            }
         }
      });
      BooleanSetting var19 = new BooleanSetting("visible", var1.v10());
      var19.onChange(() -> var0.v1(var18, var19.getValue()));
      class_2960 var20 = uiSupport143.v1(AltManagerSupport.WAYPOINTS.v2());
      configRecord var21 = new configRecord(var1.v5(), var20, null, null, var2, var19, false, List.of(), var2 == null ? null : var3);
      return new uiSupport69("_waypoint", var5, var21, var4);
   }

   public static uiSupport69 v1(InternalSupport7 var0, float var1) {
      configRecord var2 = configRecord.v1("Waypoints", uiSupport143.v1(AltManagerSupport.WAYPOINTS.v2()));
      return new uiSupport69("_waypoints", var0.v3().v1(), var2, var1);
   }

   public static String v1(String var0) {
      return "showIn" + EndSupport.v2(var0).replace(" ", "");
   }
}
