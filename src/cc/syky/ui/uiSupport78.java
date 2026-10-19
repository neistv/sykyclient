package cc.syky.ui;

import cc.syky.hud.hudSupport64;
import java.util.Locale;
import java.util.function.Consumer;
import java.util.function.Supplier;

public final class uiSupport78<E extends Enum<E>> extends uiSupport80 {
   private final E[] v1;
   private final String[] v2;
   private final Supplier<E> v3;
   private final Consumer<E> v4;
   private final uiSupport90 v5;

   public uiSupport78(E[] var1, Supplier<E> var2, Consumer<E> var3, uiSupport90 var4, float var5) {
      super(new uiSupport74(var1.length), var1.length, var5);
      this.v1 = (E[])var1;
      this.v2 = new String[var1.length];

      for (int var6 = 0; var6 < var1.length; var6++) {
         this.v2[var6] = v1(var1[var6]);
      }

      this.v3 = var2;
      this.v4 = var3;
      this.v5 = var4;
   }

   @Override
   public String v1(int var1) {
      return this.v2[var1];
   }

   @Override
   public boolean v2(int var1) {
      return this.v1[var1] == this.v3.get();
   }

   @Override
   public void v3(int var1) {
      this.v4.accept(this.v1[var1]);
      uiSupport148.v1(uiSupport146.OPTION_PICKED);
      this.v5.v4();
   }

   public static String v1(Enum<?> var0) {
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
