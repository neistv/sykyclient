package cc.syky.hud;

public final class hudSupport29 extends hudSupport10 {
   public static final String v2 = "gpu";
   private static final hudRecord2 v3 = new hudRecord2(28.0F, 28.0F, 9.0F, 4.0F, 45.0F, 8.0F);

   public hudSupport29(MicrosoftBasicSupport var1, hudSupport52 var2, float var3, float var4) {
      super("gpu", hudSupport49.v11, v3, var1, var2, var3, var4);
   }

   @Override
   public String v1(hudRecord6 var1) {
      return var1.v10();
   }

   @Override
   public int v2(hudRecord6 var1) {
      return var1.v11();
   }

   @Override
   public int v3(hudRecord6 var1) {
      return var1.v12();
   }
}
