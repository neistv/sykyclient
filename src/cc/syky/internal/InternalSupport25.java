package cc.syky.internal;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class InternalSupport25 {
   private InternalSupport25() {
   }

   public static List<String> v1(String var0, float var1, InternalSupport25.Part1 var2) {
      if (var0 != null && !var0.isEmpty()) {
         if (var1 <= 0.0F) {
            return List.of(var0);
         } else {
            ArrayList var3 = new ArrayList();
            StringBuilder var4 = new StringBuilder();

            for (String var8 : var0.split("\\s+")) {
               if (!var8.isEmpty()) {
                  if (var4.length() == 0) {
                     v1(var3, var4, var8, var1, var2);
                  } else {
                     int var9 = var4.length();
                     var4.append(' ').append(var8);
                     if (!(var2.widthOf(var4.toString()) <= var1)) {
                        var4.setLength(var9);
                        var3.add(var4.toString());
                        var4.setLength(0);
                        v1(var3, var4, var8, var1, var2);
                     }
                  }
               }
            }

            if (var4.length() > 0) {
               var3.add(var4.toString());
            }

            return var3;
         }
      } else {
         return List.of();
      }
   }

   private static void v1(List<String> var0, StringBuilder var1, String var2, float var3, InternalSupport25.Part1 var4) {
      if (var4.widthOf(var2) <= var3) {
         var1.append(var2);
      } else {
         String var5 = var2;

         while (!var5.isEmpty()) {
            int var6 = v2(var5, var3, var4);
            if (var6 >= var5.length()) {
               var1.append(var5);
               return;
            }

            var0.add(var5.substring(0, var6));
            var5 = var5.substring(var6);
         }
      }
   }

   private static int v2(String var0, float var1, InternalSupport25.Part1 var2) {
      int var3 = 0;
      int var4 = 1;

      while (var4 <= var0.length() && !(var2.widthOf(var0.substring(0, var4)) > var1)) {
         var3 = var4++;
      }

      return Math.max(1, var3);
   }

   public static float v1(List<String> var0, InternalSupport25.Part1 var1) {
      float var2 = 0.0F;

      for (String var4 : var0) {
         var2 = Math.max(var2, var1.widthOf(var4));
      }

      return var2;
   }

   public static List<String> v1(List<String> var0) {
      return Collections.unmodifiableList(new ArrayList<>(var0));
   }

   @FunctionalInterface
   public interface Part1 {
      float widthOf(String var1);
   }
}
