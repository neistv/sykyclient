package cc.syky.ui;

import java.util.List;
import net.minecraft.class_2561;
import net.minecraft.class_310;
import net.minecraft.class_332;
import net.minecraft.class_364;
import net.minecraft.class_459;
import net.minecraft.class_6379;
import net.minecraft.class_459.class_461;

public final class uiSupport8 extends class_461 {
   private static final class_2561 v1 = class_2561.method_43470("syky client");
   private static final int v2 = 9;
   private final class_459 v3;
   private final class_310 v4;

   public uiSupport8(class_459 var1, class_310 var2) {
      this.v3 = var1;
      this.v4 = var2;
   }

   public void method_25343(class_332 var1, int var2, int var3, boolean var4, float var5) {
      uiSupport259.v1("keybinds.header-render", () -> this.v1(var1));
   }

   private void v1(class_332 var1) {
      int var2 = this.v3.method_46426() + this.v3.method_25368() / 2;
      var1.method_27535(this.v4.field_1772, v1, var2 - this.v4.field_1772.method_27525(v1) / 2, this.method_73386() - 9, -1);
   }

   public void method_48269() {
   }

   public List<? extends class_364> method_25396() {
      return List.of();
   }

   public List<? extends class_6379> method_37025() {
      return List.of();
   }
}
