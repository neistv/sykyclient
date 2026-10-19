package cc.syky.cloud;

import net.minecraft.class_310;
import net.minecraft.class_634;
import net.minecraft.class_636;
import net.minecraft.class_638;
import net.minecraft.class_746;
import org.jetbrains.annotations.Nullable;

public interface cloudSupport101 {
   class_310 v1();

   @Nullable
   default class_746 v2() {
      class_310 var1 = this.v1();
      return var1 == null ? null : var1.field_1724;
   }

   @Nullable
   default class_638 v3() {
      class_310 var1 = this.v1();
      return var1 == null ? null : var1.field_1687;
   }

   @Nullable
   default class_634 v4() {
      class_310 var1 = this.v1();
      return var1 == null ? null : var1.method_1562();
   }

   @Nullable
   default class_636 v5() {
      class_310 var1 = this.v1();
      return var1 == null ? null : var1.field_1761;
   }
}
