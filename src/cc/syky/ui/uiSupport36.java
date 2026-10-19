package cc.syky.ui;

import net.minecraft.class_11905;
import net.minecraft.class_11908;
import net.minecraft.class_11909;
import net.minecraft.class_2561;
import net.minecraft.class_332;
import net.minecraft.class_437;

public abstract class uiSupport36 extends class_437 {
   public final uiSupport39 v1 = new uiSupport39();

   public uiSupport36(class_2561 var1) {
      super(var1);
   }

   public uiSupport39 v4() {
      return this.v1;
   }

   public void method_25426() {
      super.method_25426();
      uiSupport259.v1("ui.screen.init", () -> {
         this.v1.v1(0.0F, 0.0F, this.field_22789, this.field_22790);
         this.v1.v1(this.field_22789, this.field_22790);
      });
   }

   public void method_25394(class_332 var1, int var2, int var3, float var4) {
      uiSupport259.v1("ui.screen.render", () -> {
         uiSupport169.v1(var1);

         try {
            uiSupport35 var5 = new uiSupport35(var2, var3, var4, this.field_22789, this.field_22790);
            this.v1.v1(var5);
         } finally {
            uiSupport169.v15();
         }
      });
   }

   public void method_25420(class_332 var1, int var2, int var3, float var4) {
   }

   public boolean method_25402(class_11909 var1, boolean var2) {
      return uiSupport259.v1("ui.screen.mouseClicked", () -> this.v1.v1((float)var1.comp_4798(), (float)var1.comp_4799(), var1.method_74245()), false)
         ? true
         : super.method_25402(var1, var2);
   }

   public boolean method_25406(class_11909 var1) {
      return uiSupport259.v1("ui.screen.mouseReleased", () -> this.v1.v4((float)var1.comp_4798(), (float)var1.comp_4799(), var1.method_74245()), false)
         ? true
         : super.method_25406(var1);
   }

   public boolean method_25403(class_11909 var1, double var2, double var4) {
      return uiSupport259.v1(
            "ui.screen.mouseDragged", () -> this.v1.v1((float)var1.comp_4798(), (float)var1.comp_4799(), var1.method_74245(), (float)var2, (float)var4), false
         )
         ? true
         : super.method_25403(var1, var2, var4);
   }

   public void method_16014(double var1, double var3) {
      uiSupport259.v1("ui.screen.mouseMoved", () -> this.v1.v11((float)var1, (float)var3));
      super.method_16014(var1, var3);
   }

   public boolean method_25401(double var1, double var3, double var5, double var7) {
      return uiSupport259.v1("ui.screen.mouseScrolled", () -> this.v1.v1((float)var1, (float)var3, var5, var7), false)
         ? true
         : super.method_25401(var1, var3, var5, var7);
   }

   public boolean method_25404(class_11908 var1) {
      return uiSupport259.v1("ui.screen.keyPressed", () -> this.v1.v2(var1.comp_4795(), var1.comp_4797()), false) ? true : super.method_25404(var1);
   }

   public boolean method_16803(class_11908 var1) {
      return uiSupport259.v1("ui.screen.keyReleased", () -> this.v1.v4(var1.comp_4795(), var1.comp_4797()), false) ? true : super.method_16803(var1);
   }

   public boolean method_25400(class_11905 var1) {
      return var1.method_74227() && uiSupport259.v1("ui.screen.charTyped", () -> this.v1.v3(var1.comp_4793(), var1.comp_4794()), false)
         ? true
         : super.method_25400(var1);
   }

   public boolean method_25421() {
      return false;
   }
}
