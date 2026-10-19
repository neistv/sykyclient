package cc.syky.cloud;

import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Locale;
import java.util.UUID;
import org.jetbrains.annotations.Nullable;

public final class cloudSupport87 {
   public static final int v1 = 64;
   public static final long v2 = 10000L;
   public static final long v3 = 10000L;
   private static final Long v4 = -1L;
   private static final int v5 = 256;
   private final HashMap<UUID, Long> v6 = new HashMap<>();
   private long[] v7 = new long[256];
   private int v8;

   public cloudSupport87() {
   }

   public static long v1(String var0) {
      long var1 = -3750763034362895579L;

      for (byte var6 : var0.toLowerCase(Locale.ROOT).getBytes(StandardCharsets.UTF_8)) {
         var1 ^= var6 & 255;
         var1 *= 1099511628211L;
      }

      var1 ^= var1 >>> 33;
      var1 *= -49064778989728563L;
      var1 ^= var1 >>> 33;
      var1 *= -4265267296055464877L;
      var1 ^= var1 >>> 33;
      return var1 >>> 32;
   }

   public static boolean v1(UUID var0, String var1) {
      return var0.equals(UUID.nameUUIDFromBytes(("OfflinePlayer:" + var1).getBytes(StandardCharsets.UTF_8)));
   }

   public void v1() {
      this.v8 = 0;
   }

   public void v2(UUID var1, String var2) {
      Long var3 = this.v6.get(var1);
      if (var3 == null) {
         var3 = v1(var1, var2) ? v1(var2) : v4;
         this.v6.put(var1, var3);
      }

      if (var3 >= 0L) {
         if (this.v8 == this.v7.length) {
            this.v7 = Arrays.copyOf(this.v7, this.v8 * 2);
         }

         this.v7[this.v8++] = var3;
      }
   }

   public long[] v1(int var1) {
      if (this.v6.size() > 2 * var1 + 256) {
         this.v6.clear();
      }

      Arrays.sort(this.v7, 0, this.v8);
      long[] var2 = new long[Math.min(this.v8, 64)];
      int var3 = 0;

      for (int var4 = 0; var4 < this.v8 && var3 < var2.length; var4++) {
         if (var3 == 0 || this.v7[var4] != var2[var3 - 1]) {
            var2[var3++] = this.v7[var4];
         }
      }

      return var3 == var2.length ? var2 : Arrays.copyOf(var2, var3);
   }

   public static double v1(long[] var0, long[] var1) {
      int var2 = 0;
      int var3 = 0;
      int var4 = 0;
      int var5 = 0;
      if (var0.length != 0 && var1.length != 0) {
         for (; var5 < 64 && (var2 < var0.length || var3 < var1.length); var5++) {
            if (var3 != var1.length && (var2 >= var0.length || var0[var2] >= var1[var3])) {
               if (var2 != var0.length && var1[var3] >= var0[var2]) {
                  var4++;
                  var2++;
                  var3++;
               } else {
                  var3++;
               }
            } else {
               var2++;
            }
         }

         return (double)var4 / var5;
      } else {
         return 0.0;
      }
   }

   public static final class Part1 {
      public static final long v1 = 3000L;
      public static final long v2 = 2000L;
      public static final long v3 = 60000L;
      public static final double v4 = 0.8;
      @Nullable
      private long[] v5;
      private long v6;
      @Nullable
      private long[] v7;
      private long v8 = -1L;
      private boolean v9;

      public Part1() {
      }

      public void v1() {
         this.v5 = null;
         this.v7 = null;
         this.v8 = -1L;
         this.v9 = false;
      }

      public void v1(boolean var1) {
         this.v9 = var1;
      }

      @Nullable
      public cloudSupport87.Part1.Part1 v1(long[] var1, long var2) {
         long[] var4 = this.v7;
         this.v7 = var1;
         if (var1.length == 0) {
            return null;
         } else {
            long[] var5 = this.v5;
            if (var5 == null) {
               if (this.v8 < 0L) {
                  this.v8 = var2;
               }

               boolean var6 = var4 != null && Arrays.equals(var4, var1);
               return !var6 && var2 - this.v8 < 3000L ? null : this.v1(var1, var2, true);
            } else if (var2 - this.v6 >= 2000L && !Arrays.equals(var5, var1)) {
               if (cloudSupport87.v1(var5, var1) < 0.8) {
                  return this.v1(var1, var2, true);
               } else {
                  return !this.v9 && var2 - this.v6 >= 60000L ? this.v1(var1, var2, false) : null;
               }
            } else {
               return null;
            }
         }
      }

      private cloudSupport87.Part1.Part1 v1(long[] var1, long var2, boolean var4) {
         this.v5 = var1;
         this.v6 = var2;
         return new cloudSupport87.Part1.Part1(var1, var4);
      }

      public record Part1(long[] hashes, boolean fresh) {
         public long[] v1() {
            return this.hashes;
         }

         public boolean v2() {
            return this.fresh;
         }
      }
   }
}
