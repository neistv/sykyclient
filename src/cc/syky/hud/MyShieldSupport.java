package cc.syky.hud;

import java.util.List;

public final class MyShieldSupport {
   private static final int v1 = 1000;
   private static final float v2 = 0.001F;
   private static final String[] v3 = new String[1000];

   private MyShieldSupport() {
   }

   public static long v1(float var0) {
      return !(var0 > 0.0F) ? 0L : (long)Math.ceil(var0 * 10.0F - 0.001F);
   }

   public static String v2(float var0) {
      long var1 = v1(var0);
      if (var1 >= 1000L) {
         return v1(var1);
      } else {
         int var3 = (int)var1;
         String var4 = v3[var3];
         if (var4 == null) {
            var4 = v1(var1);
            v3[var3] = var4;
         }

         return var4;
      }
   }

   private static String v1(long var0) {
      StringBuilder var2 = new StringBuilder(8);
      hudSupport16.v1(var2, var0);
      return var2.toString();
   }

   public static boolean v1(MyShieldSupport.Part1 var0, hudRecord5 var1) {
      return switch (var0) {
         case BOTH -> true;
         case MINE -> var1.v2();
         case ENEMIES -> !var1.v2();
      };
   }

   public static List<hudRecord5> v1(List<hudRecord5> var0, MyShieldSupport.Part1 var1, List<hudRecord5> var2) {
      if (var1 == MyShieldSupport.Part1.BOTH) {
         return var0;
      } else {
         var2.clear();

         for (int var3 = 0; var3 < var0.size(); var3++) {
            hudRecord5 var4 = (hudRecord5)var0.get(var3);
            if (v1(var1, var4)) {
               var2.add(var4);
            }
         }

         return var2.isEmpty() ? List.of() : List.copyOf(var2);
      }
   }

   public static boolean v1(hudRecord5 var0, hudRecord5 var1) {
      return var0.v2() != var1.v2() ? var0.v2() : var0.v4() < var1.v4();
   }

   public static enum Part1 implements hudSupport64 {
      BOTH("Both"),
      MINE("My shield"),
      ENEMIES("Enemy shields");

      private final String label;

      private Part1(String var3) {
         this.label = var3;
      }

      @Override
      public String v1() {
         return this.label;
      }
   }
}
