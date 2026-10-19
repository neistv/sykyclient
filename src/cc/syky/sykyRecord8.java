package cc.syky;

import org.jetbrains.annotations.Nullable;

public record sykyRecord8(sykyRecord7 track, float elapsedSeconds, boolean paused) {
   @Nullable
   public static sykyRecord8 v1(sykyRecord7 var0, float var1, boolean var2) {
      if (var0 == null) {
         return null;
      } else {
         float var3 = var1;
         if (var1 < 0.0F) {
            var3 = 0.0F;
         } else if (var0.v3() > 0 && var1 > var0.v3()) {
            var3 = var0.v3();
         }

         return new sykyRecord8(var0, var3, var2);
      }
   }

   public float v1() {
      if (this.track != null && this.track.v3() > 0) {
         float var1 = this.elapsedSeconds / this.track.v3();
         if (var1 < 0.0F) {
            return 0.0F;
         } else {
            return var1 > 1.0F ? 1.0F : var1;
         }
      } else {
         return 0.0F;
      }
   }

   public sykyRecord7 v2() {
      return this.track;
   }

   public float v3() {
      return this.elapsedSeconds;
   }

   public boolean v4() {
      return this.paused;
   }
}
