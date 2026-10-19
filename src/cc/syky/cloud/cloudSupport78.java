package cc.syky.cloud;

import net.minecraft.class_124;
import net.minecraft.class_2561;
import net.minecraft.class_310;

public final class cloudSupport78 implements cloudSupport81 {
   private final cloudSupport101 v1;

   public cloudSupport78(cloudSupport101 var1) {
      this.v1 = var1;
   }

   @Override
   public void v1(String var1) {
      this.v1(var1, class_124.field_1080);
   }

   @Override
   public void v2(String var1) {
      this.v1(var1, class_124.field_1061);
   }

   private void v1(String var1, class_124 var2) {
      class_310 var3 = this.v1.v1();
      if (var3 != null && var3.field_1705 != null) {
         var3.field_1705.method_1743().method_1812(class_2561.method_43470(var1).method_27692(var2));
      }
   }
}
