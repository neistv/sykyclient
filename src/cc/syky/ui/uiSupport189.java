package cc.syky.ui;

import java.util.HashMap;
import java.util.Map;

public final class uiSupport189 {
   public static final int v1 = 512;
   private static final int v2 = 128;
   private static final int v3 = -1;
   private final Map<Integer, Integer> v4 = new HashMap<>();
   private int v5 = -1;
   private int v6 = -1;
   private int v7;

   public uiSupport189() {
   }

   public static boolean v1(int var0, int var1, int var2) {
      return var1 > 0 && var0 - var1 < var2;
   }

   public void v2(int var1, int var2, int var3) {
      if (var1 == this.v5 && var2 == this.v6) {
         this.v1(var1, var3 - this.v7);
      }

      this.v5 = var1;
      this.v6 = var2;
      this.v7 = var3;
   }

   public void v1() {
      this.v5 = -1;
      this.v6 = -1;
      this.v7 = 0;
   }

   public int v1(int var1) {
      return this.v4.getOrDefault(var1, 0);
   }

   public void v2() {
      this.v4.clear();
      this.v1();
   }

   private void v1(int var1, int var2) {
      if (var2 > 0 && var2 <= 512) {
         int var3 = this.v4.getOrDefault(var1, 0);
         if (var2 > var3) {
            if (var3 != 0 || this.v4.size() < 128) {
               this.v4.put(var1, var2);
            }
         }
      }
   }
}
