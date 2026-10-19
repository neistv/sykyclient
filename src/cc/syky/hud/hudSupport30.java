package cc.syky.hud;

public final class hudSupport30 extends hudSupport10 {
   public static final String v2 = "cpu";
   private static final hudRecord2 v3 = new hudRecord2(24.0F, 24.0F, 8.0F, 6.0F, 38.0F, 8.0F);

   public hudSupport30(MicrosoftBasicSupport var1, hudSupport52 var2, float var3, float var4) {
      super("cpu", hudSupport49.v10, v3, var1, var2, var3, var4);
   }

   @Override
   public String v1(hudRecord6 var1) {
      return var1.v7();
   }

   @Override
   public int v2(hudRecord6 var1) {
      return var1.v8();
   }

   @Override
   public int v3(hudRecord6 var1) {
      return var1.v9();
   }
}
