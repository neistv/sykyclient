package cc.syky.config;

import org.jetbrains.annotations.Nullable;

public record configRecord2(int tier, boolean high, @Nullable Integer peakTier, @Nullable Boolean peakHigh, boolean retired) {
   public int v1() {
      return this.tier * 2 + (this.high ? 0 : 1);
   }

   public int v2() {
      return this.tier;
   }

   public boolean v3() {
      return this.high;
   }

   @Nullable
   public Integer v4() {
      return this.peakTier;
   }

   @Nullable
   public Boolean v5() {
      return this.peakHigh;
   }

   public boolean v6() {
      return this.retired;
   }
}
