package cc.syky.render;

public record renderRecord(long copies, long wasted) {
   public long v1() {
      return this.copies;
   }

   public long v2() {
      return this.wasted;
   }
}
