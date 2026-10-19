package cc.syky.ui;

import java.util.UUID;
import net.minecraft.class_634;
import net.minecraft.class_640;
import org.jetbrains.annotations.Nullable;

public final class uiSupport214 {
   @Nullable
   private final UUID v1;
   @Nullable
   private class_640 v2;

   private uiSupport214(@Nullable UUID var1, @Nullable class_640 var2) {
      this.v1 = var1;
      this.v2 = var2;
   }

   public static uiSupport214 v1(class_640 var0) {
      return new uiSupport214(null, var0);
   }

   public static uiSupport214 v1(UUID var0, class_634 var1) {
      return new uiSupport214(var0, v1(var1, var0));
   }

   @Nullable
   public UUID v1() {
      class_640 var1 = this.v2;
      return var1 != null ? var1.method_2966().id() : this.v1;
   }

   @Nullable
   public String v2() {
      class_640 var1 = this.v2;
      return var1 != null ? var1.method_2966().name() : null;
   }

   @Nullable
   public class_640 v1(@Nullable class_634 var1) {
      class_640 var2 = this.v2;
      if (var2 == null && this.v1 != null && var1 != null) {
         var2 = v1(var1, this.v1);
         this.v2 = var2;
      }

      return var2;
   }

   @Nullable
   private static class_640 v1(class_634 var0, UUID var1) {
      class_640 var2 = var0.method_2871(var1);
      return var2 != null ? var2 : (class_640)var0.method_73234().get(var1);
   }
}
