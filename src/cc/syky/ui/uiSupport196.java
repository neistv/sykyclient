package cc.syky.ui;

import cc.syky.cloud.cloudSupport57;
import cc.syky.cloud.cloudSupport94;
import java.util.HashMap;
import java.util.Map;

public final class uiSupport196 {
   private static final int[] v1 = new int[]{39, 44, 45, 46, 47, 59, 61, 91, 92, 93, 96};

   private uiSupport196() {
   }

   public static uiSupport197 v1() {
      HashMap var0 = new HashMap();

      for (int var4 : v1) {
         v1(var0, var4);
      }

      for (int var5 = 48; var5 <= 57; var5++) {
         v1(var0, var5);
      }

      for (int var6 = 65; var6 <= 90; var6++) {
         v1(var0, var6);
      }

      return uiSupport197.v1(var0);
   }

   private static void v1(Map<Character, Character> var0, int var1) {
      String var2 = cloudSupport57.v1(var1);
      if (var2 != null && var2.length() == 1) {
         char var3 = var2.charAt(0);
         char var4 = cloudSupport94.v4(var1);
         if (var3 != var4) {
            var0.putIfAbsent(var3, var4);
         }
      }
   }
}
