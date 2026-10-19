package cc.syky.ui;

import cc.syky.hud.hudSupport64;
import cc.syky.module.visual.visualSupport6;
import java.util.Locale;

public final class uiSupport76<E extends Enum<E>> extends uiSupport80 {
   private final visualSupport6<E> v1;
   private final E[] v2;
   private final String[] v3;

   public uiSupport76(visualSupport6<E> var1, float var2) {
      super(new uiSupport71(var1.v11().length), var1.v11().length, var2);
      this.v1 = var1;
      this.v2 = (E[])var1.v11();
      this.v3 = new String[this.v2.length];

      for (int var3 = 0; var3 < this.v2.length; var3++) {
         this.v3[var3] = v1(this.v2[var3]);
      }
   }

   @Override
   public String v1(int var1) {
      return this.v3[var1];
   }

   @Override
   public boolean v2(int var1) {
      return this.v1.v1(this.v2[var1]);
   }

   @Override
   public void v3(int var1) {
      this.v1.v2(this.v2[var1]);
      uiSupport148.v1(uiSupport146.v1(this.v1.v1(this.v2[var1])));
   }

   private static String v1(Enum<?> var0) {
      if (var0 instanceof hudSupport64 var3) {
         return var3.v1();
      } else {
         String var1 = var0.name();
         if (var1.isEmpty()) {
            return "";
         } else {
            String var2 = var1.toLowerCase(Locale.ROOT).replace('_', ' ');
            return Character.toUpperCase(var2.charAt(0)) + var2.substring(1);
         }
      }
   }
}
