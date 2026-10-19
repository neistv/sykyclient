package cc.syky.ui;

import cc.syky.cloud.cloudSupport92;
import net.minecraft.class_2960;
import net.minecraft.class_3414;
import net.minecraft.class_3419;
import net.minecraft.class_6880;

public final class uiSupport239 {
   private static final uiSupport239 v1 = new uiSupport239();
   private class_6880<class_3414> v2 = class_6880.method_40223(class_3414.method_47908(class_2960.method_60656("intentionally_empty")));
   private class_3419 v3 = class_3419.field_15250;
   private double v4;
   private double v5;
   private double v6;

   private uiSupport239() {
   }

   public class_6880<class_3414> v1() {
      return this.v2;
   }

   public class_3419 v2() {
      return this.v3;
   }

   public double v3() {
      return this.v4;
   }

   public double v4() {
      return this.v5;
   }

   public double v5() {
      return this.v6;
   }

   public static uiSupport239 v1(cloudSupport92 var0, class_6880<class_3414> var1, class_3419 var2, double var3, double var5, double var7) {
      uiSupport239 var9 = v1;
      var9.v2 = var1;
      var9.v3 = var2;
      var9.v4 = var3;
      var9.v5 = var5;
      var9.v6 = var7;
      var0.v1(var9);
      return var9;
   }
}
