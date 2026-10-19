package cc.syky.internal;

import cc.syky.sykyRecord4;
import java.util.Arrays;
import java.util.function.LongConsumer;

public final class InternalSupport10 {
   public static final int v1 = 16384;
   public static final InternalSupport10 v2 = new InternalSupport10(new long[0]);
   private static final int v3 = 26;
   private static final long v4 = 67108863L;
   private static final int v5 = 33554432;
   private static final int v6 = 2048;
   private static final long v7 = 4095L;
   private final long[] v8;

   private InternalSupport10(long[] var1) {
      this.v8 = var1;
   }

   public static long v1(int var0, int var1, int var2) {
      long var3 = sykyRecord4.v1(var0) + 33554432L;
      long var5 = sykyRecord4.v1(var2) + 33554432L;
      long var7 = Math.max(-2048, Math.min(2047, var1)) + 2048L;
      return (var7 << 52 | var5 << 26 | var3) ^ Long.MIN_VALUE;
   }

   public static int v1(long var0) {
      return (int)((var0 ^ Long.MIN_VALUE) & 67108863L) - 33554432;
   }

   public static int v2(long var0) {
      return (int)((var0 ^ Long.MIN_VALUE) >>> 26 & 67108863L) - 33554432;
   }

   public static int v3(long var0) {
      return (int)((var0 ^ Long.MIN_VALUE) >>> 52 & 4095L) - 2048;
   }

   public static InternalSupport10 v1(long[] var0) {
      if (var0.length == 0) {
         return v2;
      } else {
         long[] var1 = (long[])var0.clone();
         Arrays.sort(var1);
         int var2 = 1;

         for (int var3 = 1; var3 < var1.length; var3++) {
            if (var1[var3] != var1[var2 - 1]) {
               var1[var2++] = var1[var3];
            }
         }

         return new InternalSupport10(Arrays.copyOf(var1, Math.min(var2, 16384)));
      }
   }

   public int v1() {
      return this.v8.length;
   }

   public boolean v2() {
      return this.v8.length == 0;
   }

   public boolean v2(int var1, int var2, int var3) {
      return this.v4(v1(var1, var2, var3));
   }

   public boolean v4(long var1) {
      return Arrays.binarySearch(this.v8, var1) >= 0;
   }

   public long v1(int var1) {
      return this.v8[var1];
   }

   public void v1(LongConsumer var1) {
      for (long var5 : this.v8) {
         var1.accept(var5);
      }
   }

   public InternalSupport10 v5(long var1) {
      int var3 = Arrays.binarySearch(this.v8, var1);
      if (var3 < 0 && this.v8.length < 16384) {
         int var4 = -var3 - 1;
         long[] var5 = new long[this.v8.length + 1];
         System.arraycopy(this.v8, 0, var5, 0, var4);
         var5[var4] = var1;
         System.arraycopy(this.v8, var4, var5, var4 + 1, this.v8.length - var4);
         return new InternalSupport10(var5);
      } else {
         return this;
      }
   }

   public InternalSupport10 v6(long var1) {
      int var3 = Arrays.binarySearch(this.v8, var1);
      if (var3 < 0) {
         return this;
      } else if (this.v8.length == 1) {
         return v2;
      } else {
         long[] var4 = new long[this.v8.length - 1];
         System.arraycopy(this.v8, 0, var4, 0, var3);
         System.arraycopy(this.v8, var3 + 1, var4, var3, this.v8.length - var3 - 1);
         return new InternalSupport10(var4);
      }
   }

   public InternalSupport10 v2(long[] var1) {
      int var2 = 16384 - this.v8.length;
      if (var1.length != 0 && var2 > 0) {
         long[] var3 = new long[Math.min(var1.length, var2)];
         int var4 = 0;

         for (long var8 : v1(var1).v8) {
            if (var4 == var3.length) {
               break;
            }

            if (!this.v4(var8)) {
               var3[var4++] = var8;
            }
         }

         if (var4 == 0) {
            return this;
         } else {
            long[] var10 = Arrays.copyOf(this.v8, this.v8.length + var4);
            System.arraycopy(var3, 0, var10, this.v8.length, var4);
            return v1(var10);
         }
      } else {
         return this;
      }
   }

   public long v3() {
      if (this.v8.length == 0) {
         throw new IllegalStateException("an empty area has no anchor");
      } else {
         long var1 = Long.MAX_VALUE;
         long var3 = Long.MAX_VALUE;
         long var5 = Long.MAX_VALUE;
         long var7 = Long.MIN_VALUE;
         long var9 = Long.MIN_VALUE;
         long var11 = Long.MIN_VALUE;

         for (long var16 : this.v8) {
            var1 = Math.min(var1, (long)v1(var16));
            var7 = Math.max(var7, (long)v1(var16));
            var3 = Math.min(var3, (long)v3(var16));
            var9 = Math.max(var9, (long)v3(var16));
            var5 = Math.min(var5, (long)v2(var16));
            var11 = Math.max(var11, (long)v2(var16));
         }

         double var36 = (var1 + var7) / 2.0;
         double var37 = (var3 + var9) / 2.0;
         double var17 = (var5 + var11) / 2.0;
         long var19 = this.v8[0];
         double var21 = Double.MAX_VALUE;

         for (long var26 : this.v8) {
            double var28 = v1(var26) - var36;
            double var30 = v3(var26) - var37;
            double var32 = v2(var26) - var17;
            double var34 = var28 * var28 + var30 * var30 + var32 * var32;
            if (var34 < var21) {
               var21 = var34;
               var19 = var26;
            }
         }

         return var19;
      }
   }

   @Override
   public boolean equals(Object var1) {
      return var1 == this || var1 instanceof InternalSupport10 var2 && Arrays.equals(this.v8, var2.v8);
   }

   @Override
   public int hashCode() {
      return Arrays.hashCode(this.v8);
   }

   @Override
   public String toString() {
      return "BlockArea[" + this.v8.length + " blocks]";
   }
}
