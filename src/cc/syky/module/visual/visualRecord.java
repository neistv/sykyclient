package cc.syky.module.visual;

public record visualRecord(short[] samples) {
   public short[] v1() {
      return this.samples;
   }
}
