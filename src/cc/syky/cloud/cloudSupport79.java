package cc.syky.cloud;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import org.jetbrains.annotations.Nullable;

public final class cloudSupport79 {
   private cloudSupport79() {
   }

   public static cloudRecord9 v1(cloudSupport80 var0, String var1) {
      if (var1 != null && var0 != null) {
         String var2 = ".syky";
         if (var1.startsWith(var2)) {
            if (var1.length() == var2.length()) {
               return new cloudRecord9(var1.length(), v2(var0, ""));
            } else if (var1.charAt(var2.length()) != ' ') {
               return cloudRecord9.EMPTY;
            } else {
               String var3 = var1.substring(var2.length() + 1);
               int var4 = var2.length() + 1;
               int var5;
               if (!var3.isEmpty() && var3.charAt(var3.length() - 1) != ' ') {
                  var5 = var3.lastIndexOf(32) + 1;
               } else {
                  var5 = var3.length();
               }

               String var6 = var3.substring(var5);
               int var7 = v1(var3, var5);
               int var8 = var4 + var5;
               if (var7 == 0) {
                  return new cloudRecord9(var8, v2(var0, var6));
               } else {
                  String var9 = v1(var3);
                  cloudSupport82 var10 = var9 == null ? null : var0.v1(var9.toLowerCase(Locale.ROOT));
                  if (var10 == null) {
                     return new cloudRecord9(var8, List.of());
                  } else {
                     List var11 = v2(var3, var5);
                     return new cloudRecord9(var8, var10.v1(var11, var7 - 1, var6));
                  }
               }
            }
         } else {
            return var1.startsWith(".") && var2.startsWith(var1) ? new cloudRecord9(0, List.of(var2)) : cloudRecord9.EMPTY;
         }
      } else {
         return cloudRecord9.EMPTY;
      }
   }

   private static List<String> v2(cloudSupport80 var0, String var1) {
      String var2 = var1 == null ? "" : var1.toLowerCase(Locale.ROOT);
      ArrayList var3 = new ArrayList();

      for (cloudSupport82 var5 : var0.v1()) {
         if (var5.v1().toLowerCase(Locale.ROOT).startsWith(var2)) {
            var3.add(var5.v1());
         }
      }

      var3.sort(null);
      return var3;
   }

   private static int v1(String var0, int var1) {
      if (var1 <= 0) {
         return 0;
      } else {
         String var2 = var0.substring(0, var1).strip();
         return var2.isEmpty() ? 0 : var2.split("\\s+").length;
      }
   }

   private static List<String> v2(String var0, int var1) {
      if (var1 <= 0) {
         return List.of();
      } else {
         String var2 = var0.substring(0, var1).strip();
         if (var2.isEmpty()) {
            return List.of();
         } else {
            String[] var3 = var2.split("\\s+");
            return var3.length <= 1 ? List.of() : List.of(var3).subList(1, var3.length);
         }
      }
   }

   @Nullable
   private static String v1(String var0) {
      String var1 = var0.strip();
      if (var1.isEmpty()) {
         return null;
      } else {
         int var2 = var1.indexOf(32);
         return var2 < 0 ? var1 : var1.substring(0, var2);
      }
   }
}
