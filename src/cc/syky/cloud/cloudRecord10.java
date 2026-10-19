package cc.syky.cloud;

public record cloudRecord10(int code, int modifiers) {
   public cloudRecord10(int code, int modifiers) {
      modifiers &= 15;
      this.code = code;
      this.modifiers = modifiers;
   }

   public static cloudRecord10 v1(int var0) {
      return new cloudRecord10(var0, 0);
   }

   public int v1() {
      return this.code;
   }

   public int v2() {
      return this.modifiers;
   }
}
