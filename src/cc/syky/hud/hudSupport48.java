package cc.syky.hud;

import cc.syky.cloud.HealthSupport;
import cc.syky.cloud.LMBSupport;
import cc.syky.cloud.MusicPlayerSupport;
import cc.syky.cloud.cloudSupport101;
import cc.syky.internal.InternalSupport18;
import cc.syky.internal.InternalSupport20;
import cc.syky.ui.uiSupport150;
import java.util.List;
import java.util.function.Supplier;
import net.minecraft.class_1309;

public final class hudSupport48 {
   public static final float v1 = 8.0F;
   public static final float v2 = 9.0F;
   public static final float v3 = 586.0F;
   public static final float v4 = 670.0F;
   public static final float v5 = -72.0F;
   public static final float v6 = 522.0F;
   public static final float v7 = -200.0F;
   public static final float v8 = 200.0F;
   public static final float v9 = 46.0F;

   private hudSupport48() {
   }

   public static void v1(
      HudManager var0,
      cloudSupport101 var1,
      Supplier<class_1309> var2,
      InternalSupport18 var3,
      MicrosoftBasicSupport var4,
      Supplier<List<uiSupport150.Part1>> var5,
      InternalSupport20 var6,
      hudSupport71 var7
   ) {
      float var8 = 8.0F;
      float var9 = 54.0F;
      float var10 = 100.0F;
      hudSupport41 var11 = var0.v8();
      hudSupport25 var12 = new hudSupport25(hudSupport52.TOP_LEFT, 8.0F, var8);
      FPSSupport var13 = new FPSSupport(hudSupport52.TOP_LEFT, 8.0F, var8);
      PingSupport var14 = new PingSupport(var1, hudSupport52.TOP_LEFT, 8.0F, var8);
      hudSupport26 var15 = new hudSupport26(var1, hudSupport52.TOP_LEFT, 8.0F, var8);
      HHMmSupport var16 = new HHMmSupport(hudSupport52.TOP_LEFT, 8.0F, var8);
      hudSupport28 var17 = new hudSupport28(hudSupport52.TOP_LEFT, 8.0F, var8);
      UIDSupport var18 = new UIDSupport(hudSupport52.TOP_LEFT, 8.0F, var8);
      BPSSupport var19 = new BPSSupport(var1, hudSupport52.TOP_LEFT, 8.0F, var8);
      var0.v2(var12);
      var0.v2(var13);
      var0.v2(var14);
      var0.v2(var15);
      var0.v2(var16);
      var0.v2(var17);
      var0.v2(var18);
      var0.v2(var19);
      v1(var11, var12, var13, var14, var15, var16, var17, var18, var19);
      WrittenSupport var20 = new WrittenSupport(hudSupport52.TOP_LEFT, 8.0F, var9);
      DaySupport var21 = new DaySupport(hudSupport52.TOP_LEFT, 8.0F, var9);
      SleepNowSupport var22 = new SleepNowSupport(var1, hudSupport52.TOP_LEFT, 8.0F, var9);
      SingleplayerSupport var23 = new SingleplayerSupport(var1, hudSupport52.TOP_LEFT, 8.0F, var9);
      TPSSupport var24 = new TPSSupport(var1, hudSupport52.TOP_LEFT, 8.0F, var9);
      NetherSupport var25 = new NetherSupport(var1, hudSupport52.TOP_LEFT, 8.0F, var9);
      var0.v2(var20);
      var0.v2(var21);
      var0.v2(var22);
      var0.v2(var23);
      var0.v2(var24);
      var0.v2(var25);
      var11.v2(var20, var12, hudRecord3.Part1.BELOW, hudRecord3.Part2.START);
      v1(var11, var20, var21, var22, var23, var24, var25);
      hudSupport30 var26 = new hudSupport30(var4, hudSupport52.TOP_LEFT, 8.0F, var10);
      hudSupport29 var27 = new hudSupport29(var4, hudSupport52.TOP_LEFT, 8.0F, var10);
      var0.v2(var26);
      var0.v2(var27);
      var11.v2(var26, var20, hudRecord3.Part1.BELOW, hudRecord3.Part2.START);
      v1(var11, var26, var27);
      float var28 = 146.0F;
      hudSupport23 var29 = new hudSupport23(var1, hudSupport52.TOP_LEFT, 8.0F, var28);
      var0.v2(var29);
      hudSupport7 var30 = new hudSupport7(var1, hudSupport52.TOP_LEFT, 133.0F, var28);
      var0.v2(var30);
      MusicPlayerSupport var31 = new MusicPlayerSupport(var3, hudSupport52.TOP_LEFT, 8.0F, 302.0F);
      var0.v2(var31);
      ActivePotionSupport var32 = new ActivePotionSupport(hudSupport52.MIDDLE_LEFT, 8.0F, 0.0F);
      var0.v2(var32);
      HotkeysSupport var33 = new HotkeysSupport(var5, hudSupport52.MIDDLE_LEFT, 328.0F, 0.0F);
      var0.v2(var33);
      ExpiringPotionsSupport var34 = new ExpiringPotionsSupport(hudSupport52.TOP_CENTER, 0.0F, 586.0F);
      var0.v2(var34);
      SplashAccuracySupport var35 = new SplashAccuracySupport(hudSupport52.TOP_CENTER, 0.0F, 670.0F);
      var0.v2(var35);
      NoItemsSupport var36 = new NoItemsSupport(hudSupport52.BOTTOM_CENTER, 0.0F, 138.0F);
      var0.v2(var36);
      LastHitSupport var37 = new LastHitSupport(hudSupport52.BOTTOM_CENTER, 0.0F, 193.0F);
      var0.v2(var37);
      HealthSupport var38 = new HealthSupport(var2, var1, hudSupport52.BOTTOM_CENTER, 0.0F, 273.0F);
      var0.v2(var38);
      MyComboSupport var39 = new MyComboSupport(hudSupport52.BOTTOM_CENTER, 0.0F, 356.0F);
      var0.v2(var39);
      BreakSupport var40 = new BreakSupport(hudSupport52.CENTER, 0.0F, -72.0F);
      var0.v2(var40);
      ShieldTimerSupport var41 = new ShieldTimerSupport(var7, hudSupport52.TOP_CENTER, -200.0F, 522.0F);
      var7.v1(var41::v10);
      var0.v2(var41);
      DurabilityAlertSupport var42 = new DurabilityAlertSupport(var1, hudSupport52.TOP_CENTER, 200.0F, 522.0F);
      var0.v2(var42);
      ItemPickupsSupport var43 = new ItemPickupsSupport(hudSupport52.BOTTOM_RIGHT, 8.0F, 8.0F);
      var0.v11().v26().v1(var43::v10);
      var0.v2(var43);
      var0.v2(new hudSupport24(hudSupport52.CENTER, 0.0F, 150.0F));
      LMBSupport var44 = new LMBSupport(var1, hudSupport52.TOP_RIGHT, 8.0F, 8.0F);
      var0.v2(var44);
      hudSupport27 var45 = new hudSupport27(var1, hudSupport52.MIDDLE_RIGHT, 8.0F, 0.0F);
      var0.v2(var45);
      hudSupport22 var46 = new hudSupport22(var1, hudSupport52.TOP_CENTER, 0.0F, 9.0F);
      var0.v2(var46);

      for (int var47 = 0; var47 < 12; var47++) {
         var0.v2(new LoadingSupport(var6, var47, LoadingSupport.v40(), LoadingSupport.v3(var47), LoadingSupport.v4(var47)));
      }
   }

   private static void v1(hudSupport41 var0, HudElement... var1) {
      for (int var2 = 1; var2 < var1.length; var2++) {
         var0.v2(var1[var2], var1[var2 - 1], hudRecord3.Part1.RIGHT, hudRecord3.Part2.CENTER);
      }
   }
}
