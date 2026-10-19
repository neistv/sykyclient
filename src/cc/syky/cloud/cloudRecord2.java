package cc.syky.cloud;

import cc.syky.hud.BadLuckSupport;
import net.minecraft.class_2960;
import org.jetbrains.annotations.Nullable;

public record cloudRecord2(
   String name, String duration, float remainingMs, long sampledNanos, boolean harmful, @Nullable BadLuckSupport kind, class_2960 icon, int amplifier
) {
   private static final float AGE_CAP_MS = 100.0F;

   public float v1(long var1) {
      long var3 = var1 - this.sampledNanos;
      if (var3 <= 0L) {
         return this.remainingMs;
      } else {
         float var5 = (float)var3 / 1000000.0F;
         return Math.max(0.0F, this.remainingMs - Math.min(var5, 100.0F));
      }
   }

   public String v1() {
      return this.name;
   }

   public String v2() {
      return this.duration;
   }

   public float v3() {
      return this.remainingMs;
   }

   public long v4() {
      return this.sampledNanos;
   }

   public boolean v5() {
      return this.harmful;
   }

   @Nullable
   public BadLuckSupport v6() {
      return this.kind;
   }

   public class_2960 v7() {
      return this.icon;
   }

   public int v8() {
      return this.amplifier;
   }
}
