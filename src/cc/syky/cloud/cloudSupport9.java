package cc.syky.cloud;

import cc.syky.hud.hudSupport57;
import java.util.UUID;
import org.jetbrains.annotations.Nullable;

public final class cloudSupport9 {
   private final hudSupport57 v1;
   private final long v2;
   @Nullable
   private UUID v3;
   private long v4;

   public cloudSupport9(float var1, long var2) {
      this.v1 = new hudSupport57(0.0F, var1);
      this.v2 = var2;
   }

   public float v1(UUID var1, float var2) {
      long var3 = System.nanoTime() / 1000000L;
      boolean var5 = !var1.equals(this.v3) || var3 - this.v4 > this.v2;
      this.v3 = var1;
      this.v4 = var3;
      if (var5) {
         this.v1.v3(var2);
      } else {
         this.v1.v2(var2);
      }

      return this.v1.v2();
   }

   public static float v1(float var0, float var1) {
      float var2 = var0 > 0.0F ? var0 : 0.0F;
      return var1 > 0.0F ? var2 + var1 : var2;
   }

   public static float v2(float var0, float var1) {
      if (var1 <= 0.0F) {
         return 0.0F;
      } else {
         float var2 = var0 / var1;
         if (var2 < 0.0F) {
            return 0.0F;
         } else {
            return var2 > 1.0F ? 1.0F : var2;
         }
      }
   }
}
