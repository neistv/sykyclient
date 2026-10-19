package cc.syky.ui;

import cc.syky.config.BooleanSetting;
import cc.syky.config.SettingRegistry;
import java.util.HashMap;
import java.util.Map;
import net.minecraft.class_1937;
import net.minecraft.class_2246;
import net.minecraft.class_2248;
import net.minecraft.class_2680;
import net.minecraft.class_310;
import net.minecraft.class_5321;

public final class uiSupport220 {
   private static final int v1 = 0;
   private static final int v2 = 1;
   private static final int v3 = 2;
   private final BooleanSetting v4;
   private final BooleanSetting v5;
   private final BooleanSetting v6;
   private final BooleanSetting v7;
   private final BooleanSetting v8;
   private final BooleanSetting v9;
   private final uiRecord14 v10;
   private int v11 = -1;

   public uiSupport220(SettingRegistry var1, uiRecord14 var2) {
      this.v10 = var2;
      this.v4 = var1.add(new BooleanSetting("hideBedrock", true));
      this.v5 = var1.add(new BooleanSetting("hideRotation", true));
      this.v6 = var1.add(new BooleanSetting("hideOres", true));
      this.v7 = var1.add(new BooleanSetting("hideStoneVariants", true));
      this.v8 = var1.add(new BooleanSetting("hideBiomeColors", true));
      this.v9 = var1.add(new BooleanSetting("hideClouds", true));
   }

   public void v1() {
      uiSupport219.v4 = this.v9.getValue();
      int var1 = this.v3();
      int var2 = (this.v4.getValue() ? 1 : 0)
         | (this.v5.getValue() ? 2 : 0)
         | (this.v6.getValue() ? 4 : 0)
         | (this.v7.getValue() ? 8 : 0)
         | (this.v8.getValue() ? 16 : 0);
      if (this.v4.getValue()) {
         var2 = var2 * 4 + var1;
      }

      if (var2 != this.v11) {
         this.v11 = var2;
         Map var3 = this.v1(var1);
         uiSupport219.v1 = var3.isEmpty() ? null : Map.copyOf(var3);
         uiSupport219.v2 = this.v5.getValue();
         uiSupport219.v3 = this.v8.getValue();
         this.v4();
      }
   }

   public void v2() {
      boolean var1 = this.v11 != -1;
      this.v11 = -1;
      uiSupport219.v1 = null;
      uiSupport219.v2 = false;
      uiSupport219.v3 = false;
      uiSupport219.v4 = false;
      if (var1) {
         this.v4();
      }
   }

   private Map<class_2248, class_2680> v1(int var1) {
      HashMap var2 = new HashMap();
      class_2680 var3 = class_2246.field_10340.method_9564();
      class_2680 var4 = class_2246.field_28888.method_9564();
      class_2680 var5 = class_2246.field_10515.method_9564();
      if (this.v4.getValue() && var1 != 0) {
         var2.put(class_2246.field_9987, var1 == 2 ? var5 : var4);
      }

      if (this.v6.getValue()) {
         v1(
            var2,
            var3,
            class_2246.field_10418,
            class_2246.field_10212,
            class_2246.field_27120,
            class_2246.field_10571,
            class_2246.field_10080,
            class_2246.field_10090,
            class_2246.field_10442,
            class_2246.field_10013
         );
         v1(
            var2,
            var4,
            class_2246.field_29219,
            class_2246.field_29027,
            class_2246.field_29221,
            class_2246.field_29026,
            class_2246.field_29030,
            class_2246.field_29028,
            class_2246.field_29029,
            class_2246.field_29220
         );
         v1(var2, var5, class_2246.field_23077, class_2246.field_10213, class_2246.field_22109);
      }

      if (this.v7.getValue()) {
         v1(var2, var3, class_2246.field_10115, class_2246.field_10474, class_2246.field_10508, class_2246.field_10255);
         v1(var2, var4, class_2246.field_27165);
      }

      return var2;
   }

   private static void v1(Map<class_2248, class_2680> var0, class_2680 var1, class_2248... var2) {
      for (class_2248 var6 : var2) {
         var0.put(var6, var1);
      }
   }

   private int v3() {
      class_310 var1 = this.v10.v2().v1();
      if (var1.field_1687 == null) {
         return 0;
      } else {
         class_5321 var2 = var1.field_1687.method_27983();
         if (var2 == class_1937.field_25180) {
            return 2;
         } else {
            return var2 == class_1937.field_25181 ? 0 : 1;
         }
      }
   }

   private void v4() {
      class_310 var1 = this.v10.v2().v1();
      if (var1.field_1687 != null) {
         var1.field_1769.method_3279();
      }
   }
}
