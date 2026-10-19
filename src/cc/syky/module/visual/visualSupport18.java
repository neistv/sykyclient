package cc.syky.module.visual;

import cc.syky.cloud.cloudSupport101;
import cc.syky.cloud.cloudSupport92;
import net.minecraft.class_1309;
import net.minecraft.class_310;
import org.jetbrains.annotations.Nullable;

public final class visualSupport18 {
   private static final long v1 = 2000L;
   private static final double v2 = 400.0;
   private static final long v3 = 3000L;
   private final cloudSupport101 v4;
   @Nullable
   private class_1309 v5;
   private long v6;
   @Nullable
   private class_1309 v7;
   private long v8;

   public visualSupport18(cloudSupport101 var1, cloudSupport92 var2) {
      this.v4 = var1;
      var2.v1(visualSupport64.class, this::v1, 0);
   }

   @Nullable
   public class_1309 v1() {
      class_310 var1 = this.v4.v1();
      if (var1 != null && var1.field_1724 != null && var1.field_1687 != null) {
         long var2 = System.currentTimeMillis();
         class_1309 var4 = this.v1(var1, var2);
         class_1309 var5 = visualSupport20.v1(var1);
         if (var4 != null && var4 != var5) {
            this.v5 = var4;
            this.v6 = var2 + 2000L;
            return var4;
         } else if (var5 != null && var5.method_5805()) {
            this.v5 = var5;
            this.v6 = var2 + 2000L;
            return var5;
         } else if (this.v5 != null && var2 < this.v6 && v1(var1, this.v5)) {
            return this.v5;
         } else {
            this.v5 = null;
            return null;
         }
      } else {
         return null;
      }
   }

   @Nullable
   private class_1309 v1(class_310 var1, long var2) {
      if (this.v7 == null) {
         return null;
      } else if (var2 < this.v8 && v1(var1, this.v7)) {
         return this.v7;
      } else {
         this.v7 = null;
         return null;
      }
   }

   private void v1(visualSupport64 var1) {
      class_310 var2 = this.v4.v1();
      if (var2 != null
         && var2.field_1724 != null
         && var1.v1() instanceof class_1309 var3
         && visualSupport20.v1(var3, var2.field_1724)
         && !visualSupport44.v2(var3)) {
         this.v7 = var3;
         this.v8 = System.currentTimeMillis() + 3000L;
      }
   }

   private static boolean v1(class_310 var0, class_1309 var1) {
      return var0.field_1724 != null && visualSupport20.v1(var1, var0.field_1724) && var1.method_5858(var0.field_1724) <= 400.0;
   }
}
