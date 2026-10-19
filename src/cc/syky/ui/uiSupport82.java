package cc.syky.ui;

import java.util.function.IntConsumer;
import java.util.function.IntSupplier;

public final class uiSupport82 extends uiSupport80 {
   private final String[] v1;
   private final IntSupplier v2;
   private final IntConsumer v3;
   private final uiSupport90 v4;

   public uiSupport82(String[] var1, IntSupplier var2, IntConsumer var3, uiSupport90 var4, float var5) {
      super(new uiSupport74(var1.length), var1.length, var5);
      this.v1 = (String[])var1.clone();
      this.v2 = var2;
      this.v3 = var3;
      this.v4 = var4;
   }

   @Override
   public String v1(int var1) {
      return this.v1[var1];
   }

   @Override
   public boolean v2(int var1) {
      return this.v2.getAsInt() == var1;
   }

   @Override
   public void v3(int var1) {
      this.v3.accept(var1);
      uiSupport148.v1(uiSupport146.OPTION_PICKED);
      this.v4.v4();
   }
}
