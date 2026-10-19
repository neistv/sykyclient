package cc.syky.module.visual;

import cc.syky.cloud.cloudSupport92;
import net.minecraft.class_1297;
import org.jetbrains.annotations.Nullable;

public final class visualSupport64 {
   private static final visualSupport64 v1 = new visualSupport64();
   @Nullable
   private class_1297 v2;

   private visualSupport64() {
   }

   @Nullable
   public class_1297 v1() {
      return this.v2;
   }

   public static visualSupport64 v1(cloudSupport92 var0, class_1297 var1) {
      v1.v2 = var1;
      var0.v1(v1);
      return v1;
   }
}
