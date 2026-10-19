package cc.syky.hud;

import cc.syky.cloud.cloudRecord2;
import cc.syky.config.BooleanSetting;
import cc.syky.config.ColorSetting;
import cc.syky.module.visual.visualSupport6;
import cc.syky.ui.uiRecord7;
import cc.syky.ui.uiSupport169;
import java.util.ArrayList;
import java.util.EnumSet;
import java.util.List;
import java.util.Set;
import net.minecraft.class_2960;
import org.jetbrains.annotations.Nullable;

public final class ActivePotionSupport extends hudSupport11<cloudRecord2> {
   public static final String v2 = "active_potion";
   private static final float v8 = 12.0F;
   private static final float v9 = 15.0F;
   private static final float v10 = 12.0F;
   private static final float v11 = 15.0F;
   private static final float v12 = 21.0F;
   private static final float v13 = 11.0F;
   private static final float v14 = 1.0F;
   private static final int v15 = -857716154;
   private static final float v16 = 11.0F;
   private static final float v18 = 18.0F;
   private static final float v19 = 0.5F;
   private static final float v17 = 5.0F;
   private static final float v20 = 24.0F;
   private static final float v21 = 254.0F;
   private static final hudSupport11.Part1 v22 = new hudSupport11.Part1("Active Potion", 12.0F, 1.0F, 21.0F, 11.0F, 15.0F, 254.0F);
   private final BooleanSetting v24;
   private final ColorSetting v25;
   private final visualSupport6<BadLuckSupport> v26;
   @Nullable
   private List<cloudRecord2> v27;
   private final EnumSet<BadLuckSupport> v28 = EnumSet.noneOf(BadLuckSupport.class);
   private List<cloudRecord2> v29 = List.of();
   private final List<cloudRecord2> v30 = new ArrayList<>(8);

   public ActivePotionSupport(hudSupport52 var1, float var2, float var3) {
      super("active_potion", 31, var1, var2, var3, v22, cloudRecord2::v7);
      this.v24 = this.v2().v1(new BooleanSetting("harmfulNames", false));
      this.v25 = this.v2().v1(new ColorSetting("harmfulNamesColor", -857716154).setCondition(this.v24));
      this.v26 = this.v2().v1(new visualSupport6<>("hiddenEffects", BadLuckSupport.class, EnumSet.noneOf(BadLuckSupport.class)));
   }

   @Override
   public float v40() {
      return this.v2().v14() ? 44.0F : 15.0F;
   }

   @Override
   public class_2960 v38() {
      return hudSupport49.v14;
   }

   @Override
   public List<cloudRecord2> v14(hudSupport40 var1) {
      List var2 = var1.v6().v42();
      EnumSet var3 = this.v26.v9();
      if (var3.isEmpty()) {
         return var2;
      } else {
         if (var2 != this.v27 || !this.v28.equals(var3)) {
            this.v27 = var2;
            this.v28.clear();
            this.v28.addAll(var3);
            this.v29 = v1(var2, var3, this.v30);
         }

         return this.v29;
      }
   }

   public static List<cloudRecord2> v1(List<cloudRecord2> var0, Set<BadLuckSupport> var1, List<cloudRecord2> var2) {
      var2.clear();

      for (int var3 = 0; var3 < var0.size(); var3++) {
         cloudRecord2 var4 = (cloudRecord2)var0.get(var3);
         BadLuckSupport var5 = var4.v6();
         if (var5 == null || !var1.contains(var5)) {
            var2.add(var4);
         }
      }

      return var2.size() == var0.size() ? var0 : List.copyOf(var2);
   }

   @Override
   public void v2(float var1, float var2, float var3) {
      this.v1(hudSupport49.v14, var1 + 12.0F * var3, var2, 21.0F * var3, 21.0F * var3, -1, uiRecord7.ZERO);
   }

   public float v1(cloudRecord2 var1, long var2) {
      return hudSupport20.v1(var1.v1(var2));
   }

   public float v1(cloudRecord2 var1, float var2) {
      float var3 = uiSupport169.v2("syky_sans_strong", var1.v1(), 16.0F * var2);
      float var4 = uiSupport169.v2("syky_sans_strong", var1.v2(), 16.0F * var2);
      return 15.0F * var2 + var3 + 24.0F * var2 + var4 + 5.0F * var2 + 18.0F * var2 + 15.0F * var2;
   }

   public void v1(cloudRecord2 var1, float var2, float var3, float var4, float var5, float var6) {
      float var7 = var2 + var4 - 15.0F * var5;
      float var8 = var7 - 18.0F * var5;
      float var9 = var3 + 0.5F * var5;
      float var10 = var3 + -0.10999966F * var5;
      float var11 = uiSupport169.v2("syky_sans_strong", var1.v2(), 16.0F * var5);
      float var12 = var8 - 5.0F * var5 - var11;
      int var13 = CopiedSupport2.v1(-855638017, var6);
      this.v1(var1, var2 + 15.0F * var5, var10, 16.0F * var5, var6, var13);
      this.v1("syky_sans_strong", var1.v2(), var12, var10, 16.0F * var5, var13);
      uiSupport169.v1(var1.v7(), var8, var9, 18.0F * var5, 18.0F * var5, CopiedSupport2.v1(-1, var6), uiRecord7.ZERO);
   }

   private void v1(cloudRecord2 var1, float var2, float var3, float var4, float var5, int var6) {
      if (this.v24.getValue() && var1.v5()) {
         uiSupport169.v1("syky_sans_strong", var1.v1(), var2, var3, var4, CopiedSupport2.v1(this.v25.getValue(), var5));
      } else {
         this.v1("syky_sans_strong", var1.v1(), var2, var3, var4, var6);
      }
   }
}
