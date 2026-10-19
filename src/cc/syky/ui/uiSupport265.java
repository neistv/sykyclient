package cc.syky.ui;

public final class uiSupport265 extends Exception {
   private static final long v1 = 1L;
   private final TheSignSupport v2;
   private final int v3;

   public uiSupport265(TheSignSupport var1, int var2, String var3) {
      super(var3);
      this.v2 = var1;
      this.v3 = var2;
   }

   public TheSignSupport v1() {
      return this.v2;
   }

   public boolean v2() {
      return this.v3 == 401;
   }
}
