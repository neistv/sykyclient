package cc.syky.cloud;

public record cloudRecord7(long count, long minNanos, long maxNanos, double meanNanos, long p50Nanos, long p95Nanos, long p99Nanos) {
   public static final cloudRecord7 EMPTY = new cloudRecord7(0L, 0L, 0L, 0.0, 0L, 0L, 0L);

   public boolean v1() {
      return this.count == 0L;
   }

   public double v2() {
      return this.meanNanos / 1000.0;
   }

   public double v3() {
      return this.meanNanos / 1000000.0;
   }

   public double v4() {
      return this.p99Nanos / 1000000.0;
   }

   public long v5() {
      return this.count;
   }

   public long v6() {
      return this.minNanos;
   }

   public long v7() {
      return this.maxNanos;
   }

   public double v8() {
      return this.meanNanos;
   }

   public long v9() {
      return this.p50Nanos;
   }

   public long v10() {
      return this.p95Nanos;
   }

   public long v11() {
      return this.p99Nanos;
   }
}
