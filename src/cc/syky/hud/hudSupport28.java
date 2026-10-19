package cc.syky.hud;

import cc.syky.cloud.cloudSupport2;
import org.jetbrains.annotations.Nullable;

public final class hudSupport28 extends CopiedSupport {
   public static final String v2 = "playtime";
   private static final hudRecord2 v3 = new hudRecord2(25.0F, 25.0F, 5.0F, 5.0F, 36.0F, 8.0F);
   private static final long v4 = 60L;
   private static final long v5 = 3600L;
   private static final long v6 = 86400L;
   private static final long v7 = 60L;
   private static final long v8 = 24L;
   private static final long v9 = 600L;
   private long v10 = Long.MIN_VALUE;
   @Nullable
   private String v11;

   public hudSupport28(hudSupport52 var1, float var2, float var3) {
      super("playtime", hudSupport49.v5, v3, var1, var2, var3);
   }

   @Nullable
   @Override
   public String v1(cloudSupport2 var1) {
      long var2 = var1.v36();
      long var4 = v2(var2);
      if (var4 != this.v10) {
         this.v10 = var4;
         this.v11 = v1(var2);
      }

      return this.v11;
   }

   private static long v2(long var0) {
      if (var0 < 600L) {
         return var0;
      } else {
         return var0 < 86400L ? var0 - var0 % 60L : var0 - var0 % 3600L;
      }
   }

   public static String v1(long var0) {
      long var2 = Math.max(0L, var0);
      StringBuilder var4 = new StringBuilder(8);
      if (var2 < 60L) {
         return var4.append(var2).append('s').toString();
      } else {
         long var5 = var2 / 60L;
         if (var2 < 600L) {
            return v1(var4, var5, 'm', var2 % 60L, 's');
         } else if (var5 < 60L) {
            return var4.append(var5).append('m').toString();
         } else {
            long var7 = var5 / 60L;
            return var7 < 24L ? v1(var4, var7, 'h', var5 % 60L, 'm') : v1(var4, var7 / 24L, 'd', var7 % 24L, 'h');
         }
      }
   }

   private static String v1(StringBuilder var0, long var1, char var3, long var4, char var6) {
      var0.append(var1).append(var3);
      if (var4 > 0L) {
         var0.append(' ').append(var4).append(var6);
      }

      return var0.toString();
   }
}
