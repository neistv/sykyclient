package cc.syky.cloud;

public final class cloudSupport98 {
   public static final int v1 = 256;

   private cloudSupport98() {
   }

   public static cloudRecord10 v1(int var0, int var1) {
      return new cloudRecord10(var0, var1 & ~v1(var0));
   }

   public static int v1(int var0) {
      return switch (var0) {
         case 340, 344 -> 1;
         case 341, 345 -> 2;
         case 342, 346 -> 4;
         case 343, 347 -> 8;
         default -> 0;
      };
   }
}
