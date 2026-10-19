package cc.syky.hud;

import java.util.function.Supplier;
import net.minecraft.class_11875;
import net.minecraft.class_11876;
import org.jetbrains.annotations.Nullable;

public final class hudSupport56 {
   public static final Supplier<class_11875> v1 = hudSupport56::v1;

   private hudSupport56() {
   }

   @Nullable
   private static class_11875 v1() {
      hudSupport54 var0 = hudSupport53.v1();
      hudSupport53.v3();
      if (hudSupport59.v1.v2()) {
         return class_11876.field_62456;
      } else {
         return switch (var0) {
            case ARROW -> null;
            case POINTER -> class_11876.field_62455;
            case IBEAM -> class_11876.field_62453;
         };
      }
   }
}
