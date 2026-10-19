package cc.syky.hud;

public final class SleepInSupport {
   public static final int v1 = 4;
   public static final float v2 = 15.0F;
   public static final float v3 = 4.0F;
   public static final int v4 = 24000;
   private static final int v5 = 1000;
   private static final long v6 = 1000L;
   private static final long v7 = 12000L;
   private static final long v8 = 13000L;
   private static final long v9 = 23000L;
   private static final int v10 = 6;
   private static final int v11 = 20;
   private static final float v12 = 0.5F;

   private SleepInSupport() {
   }

   public static boolean v1(float var0) {
      return (int)(15.0F - var0) >= 4;
   }

   public static float v1(float var0, float var1) {
      float var2 = var0 - 4.0F;
      return var2 < 0.5F ? 0.0F : Math.clamp((var0 - var1) / var2, 0.0F, 1.0F);
   }

   public static float v2(float var0, float var1) {
      return var0 + (4.0F - var0) * var1;
   }

   public static long v1(SleepInSupport.Part1 var0, long var1, float var3, long var4) {
      long var6 = 0L;

      while (var6 < var4) {
         long var8 = Math.min(var6 + 20L, var4);
         if (v1(v2(var0.v1(var1 + var8), var3))) {
            for (long var10 = var6 + 1L; var10 < var8; var10++) {
               if (v1(v2(var0.v1(var1 + var10), var3))) {
                  return var10;
               }
            }

            return var8;
         }

         var6 = var8;
      }

      return -1L;
   }

   public static int v1(long var0, float var2) {
      return var0 > 0L && !(var2 <= 0.0F) ? (int)Math.ceil((double)var0 / var2) : 0;
   }

   public static int v1(long var0) {
      long var2 = Math.floorMod(var0, 24000L);
      int var4 = (int)((var2 / 1000L + 6L) % 24L);
      int var5 = (int)(var2 % 1000L * 60L / 1000L);
      return var4 * 60 + var5;
   }

   public static String v1(int var0, boolean var1) {
      int var2 = var0 / 60;
      int var3 = var0 % 60;
      StringBuilder var4 = new StringBuilder(8);
      if (var1) {
         int var5 = var2 % 12 == 0 ? 12 : var2 % 12;
         var4.append(var5).append(':');
         v1(var4, var3);
         var4.append(var2 < 12 ? " AM" : " PM");
      } else {
         v1(var4, var2);
         var4.append(':');
         v1(var4, var3);
      }

      return var4.toString();
   }

   public static String v2(long var0) {
      long var2 = Math.floorMod(var0, 24000L);
      if (var2 >= 23000L || var2 < 1000L) {
         return "Sunrise";
      } else if (var2 < 12000L) {
         return "Day";
      } else {
         return var2 < 13000L ? "Sunset" : "Night";
      }
   }

   public static String v1(int var0) {
      StringBuilder var1 = new StringBuilder(16).append("Sleep in ").append(var0 / 60).append(':');
      v1(var1, var0 % 60);
      return var1.toString();
   }

   private static void v1(StringBuilder var0, int var1) {
      if (var1 < 10) {
         var0.append('0');
      }

      var0.append(var1);
   }

   @FunctionalInterface
   public interface Part1 {
      float v1(long var1);
   }
}
