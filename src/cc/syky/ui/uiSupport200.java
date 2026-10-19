package cc.syky.ui;

import org.jetbrains.annotations.Nullable;

public final class uiSupport200 {
   private static final String v1 = " (x";
   private static final String v2 = ")";
   @Nullable
   private String v3;
   private int v4;

   public uiSupport200() {
   }

   public static String v1(int var0) {
      return " (x" + var0 + ")";
   }

   public static String v1(String var0, int var1) {
      return var0 + v1(var1);
   }

   public int v1(String var1, String var2) {
      int var3;
      if (this.v4 > 1 && var1.equals(this.v3) && var2.equals(v1(var1, this.v4))) {
         var3 = this.v4;
      } else {
         if (!var2.equals(var1)) {
            this.v3 = var1;
            this.v4 = 1;
            return 0;
         }

         var3 = 1;
      }

      this.v3 = var1;
      this.v4 = var3 + 1;
      return this.v4;
   }

   public void v1() {
      this.v3 = null;
      this.v4 = 0;
   }
}
