package cc.syky.module.visual;

public enum visualSupport15 {
   SUNRISE(23000L),
   DAY(1000L),
   NOON(6000L),
   SUNSET(12000L),
   NIGHT(13000L),
   MIDNIGHT(18000L),
   CUSTOM(-1L);

   private final long ticks;

   private visualSupport15(long var3) {
      this.ticks = var3;
   }

   public long v1() {
      return this.ticks;
   }
}
