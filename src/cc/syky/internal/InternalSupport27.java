package cc.syky.internal;

import cc.syky.cloud.cloudSupport101;
import cc.syky.cloud.cloudSupport80;
import cc.syky.ui.uiSupport144;
import cc.syky.ui.uiSupport145;
import net.minecraft.class_332;
import net.minecraft.class_342;
import org.jetbrains.annotations.Nullable;

public final class InternalSupport27 {
   private final cloudSupport101 v1;
   private final cloudSupport80 v2;
   @Nullable
   private uiSupport144 v3;
   @Nullable
   private uiSupport145 v4;
   @Nullable
   private class_342 v5;

   public InternalSupport27(cloudSupport101 var1, cloudSupport80 var2) {
      this.v1 = var1;
      this.v2 = var2;
   }

   public void v1(class_342 var1) {
      this.v5 = var1;
      if (var1 == null) {
         this.v3 = null;
         this.v4 = null;
      } else {
         this.v3 = new uiSupport144(var1, this.v2, this.v1);
         this.v3.v1();
         this.v4 = new uiSupport145(var1, this.v1.v1().field_1772);
         this.v4.v1();
      }
   }

   public void v1(class_332 var1) {
      uiSupport145 var2 = this.v4;
      if (var2 != null) {
         var2.v1();
         var2.v1(var1);
      }

      if (this.v3 != null) {
         this.v3.v1();
         this.v3.v1(var1);
      }
   }

   public boolean v1(int var1) {
      return this.v3 != null && this.v3.v1(var1);
   }

   public boolean v1() {
      class_342 var1 = this.v5;
      return var1 == null || var1.method_1882().isEmpty();
   }

   public boolean v1(double var1, double var3, double var5) {
      return this.v3 != null && this.v3.v1(var1, var3, var5);
   }

   public boolean v1(int var1, double var2, double var4) {
      return var1 == 0 && this.v3 != null && this.v3.v1(var2, var4);
   }
}
