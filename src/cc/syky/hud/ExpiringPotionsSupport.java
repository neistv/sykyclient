package cc.syky.hud;

import cc.syky.cloud.cloudRecord2;
import cc.syky.config.BooleanSetting;
import cc.syky.config.IntSetting;
import cc.syky.module.visual.visualSupport6;
import cc.syky.ui.uiSupport20;
import java.util.ArrayList;
import java.util.EnumSet;
import java.util.List;
import java.util.Set;
import net.minecraft.class_2960;
import org.jetbrains.annotations.Nullable;

public final class ExpiringPotionsSupport extends hudSupport21<cloudRecord2> {
   public static final String v2 = "expiring_potion";
   private static final cloudRecord2 v6 = new cloudRecord2(
      "Expiring Potions", "", Float.MAX_VALUE, 0L, false, null, class_2960.method_60655("syky", "expiring_potion_placeholder"), 0
   );
   private final visualSupport6<BadLuckSupport> v7;
   private final IntSetting v8;
   private final BooleanSetting v9;
   private final float[] v10 = new float[2];
   private float v11 = -1.0F;
   @Nullable
   private List<cloudRecord2> v12;
   private int v13 = -1;
   private final EnumSet<BadLuckSupport> v14 = EnumSet.noneOf(BadLuckSupport.class);
   private List<cloudRecord2> v15 = List.of();
   private final List<cloudRecord2> v16 = new ArrayList<>(8);

   public ExpiringPotionsSupport(hudSupport52 var1, float var2, float var3) {
      super("expiring_potion", 11, var1, var2, var3, cloudRecord2::v7);
      this.v7 = this.v2().v1(new visualSupport6<>("effects", BadLuckSupport.class, EnumSet.of(BadLuckSupport.STRENGTH)));
      this.v8 = this.v2().v1(new IntSetting("warnAt", 10, 3, 30).v1("s"));
      this.v9 = this.v2().v1(new BooleanSetting("blink", true));
   }

   @Override
   public List<cloudRecord2> v15(hudSupport40 var1) {
      return this.v18(var1);
   }

   private List<cloudRecord2> v18(hudSupport40 var1) {
      List var2 = var1.v6().v42();
      int var3 = this.v8.getValue();
      EnumSet var4 = this.v7.v9();
      if (var2 == this.v12 && var3 == this.v13 && this.v14.equals(var4)) {
         return this.v15;
      } else {
         this.v12 = var2;
         this.v13 = var3;
         this.v14.clear();
         this.v14.addAll(var4);
         this.v15 = v1(var2, var3, var4, this.v16);
         return this.v15;
      }
   }

   public static List<cloudRecord2> v1(List<cloudRecord2> var0, int var1, Set<BadLuckSupport> var2, List<cloudRecord2> var3) {
      var3.clear();

      for (int var4 = 0; var4 < var0.size(); var4++) {
         cloudRecord2 var5 = (cloudRecord2)var0.get(var4);
         BadLuckSupport var6 = var5.v6();
         if (var6 != null && var2.contains(var6) && uiSupport20.v1(var5.v3(), var1)) {
            int var7 = var3.size();

            while (var7 > 0 && ((cloudRecord2)var3.get(var7 - 1)).v3() > var5.v3()) {
               var7--;
            }

            var3.add(var7, var5);
         }
      }

      return var3.isEmpty() ? List.of() : List.copyOf(var3);
   }

   public cloudRecord2 v40() {
      return v6;
   }

   public boolean v1(cloudRecord2 var1, cloudRecord2 var2) {
      return var1.v3() < var2.v3();
   }

   public String v1(cloudRecord2 var1) {
      return var1.v1();
   }

   public class_2960 v2(cloudRecord2 var1) {
      return var1.v7();
   }

   public String v3(cloudRecord2 var1) {
      return v5(var1);
   }

   private static String v5(cloudRecord2 var0) {
      return uiSupport20.v2(var0.v3());
   }

   public float v1(cloudRecord2 var1, float var2) {
      if (var2 != this.v11 || !(this.v10[0] > 0.0F)) {
         this.v11 = var2;
         this.v10[0] = v1(1, 9, uiSupport20::v1, var2);
         this.v10[1] = v1(10, 30, uiSupport20::v1, var2);
      }

      return this.v10[uiSupport20.v1(var1.v3()) < 10 ? 0 : 1];
   }

   public float v4(cloudRecord2 var1) {
      return !this.v9.getValue() ? 1.0F : hudSupport20.v1(var1.v3());
   }

   @Override
   public void v49() {
      this.v12 = null;
      this.v13 = -1;
      this.v15 = List.of();
      this.v16.clear();
   }
}
