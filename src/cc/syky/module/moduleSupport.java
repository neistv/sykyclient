package cc.syky.module;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Arrays;
import java.util.Comparator;

public final class moduleSupport {
   public static final int v1 = 16;
   public static final int v2 = 32;
   public static final int v3 = 0;
   public static final int v4 = 1;
   public static final int v5 = 2;
   public static final int v6 = 3;
   public static final int v7 = 4;
   public static final int v8 = 1;
   public static final int v9 = 2;
   public static final int v10 = 4;
   public static final int v11 = 8;
   public static final int v12 = 16;
   public static final int v13 = 4;
   public static final int v14 = 16;
   public static final int v15 = 4;
   public static final int v16 = 14;
   public static final float v18 = 0.7F;
   public static final int v19 = 3;
   private static final int v27 = 1;
   private static final int v28 = 18;
   public static final int v17 = 8;
   public static final int v20 = 2;
   public static final int v21 = 64;
   public static final int v22 = 49;
   public static final long v24 = 1500000000L;
   public static final long v25 = 15000000000L;
   public static final long v26 = 1000000000L;
   private static final int[] v29 = new int[1024];
   private static final int[] v30 = new int[1024];
   private final int[] v32 = new int[1024];
   private final int[] v23 = new int[1024];
   private final long[] v33 = new long[1024];
   private final boolean[] v31 = new boolean[1024];
   private final boolean[] v34 = new boolean[1024];
   private final boolean[] v36 = new boolean[1024];
   private boolean v38;
   private int v42;
   private int v43;
   private int v37;
   private final int[] v48 = new int[324];
   private final int[] v40 = new int[324];
   private final int[] v44 = new int[324];
   private final float[] v47 = new float[324];
   private final float[] v49 = new float[324];
   private final ByteBuffer v46 = ByteBuffer.allocateDirect(1024).order(ByteOrder.nativeOrder());
   private final ByteBuffer v51 = ByteBuffer.allocateDirect(1024).order(ByteOrder.nativeOrder());

   public moduleSupport() {
   }

   public void v1() {
      Arrays.fill(this.v31, false);
      Arrays.fill(this.v34, false);
      this.v38 = false;
   }

   public int v1(moduleSupport.Part2 var1, int var2, int var3, long var4, moduleSupport.Part1 var6) {
      int var7 = 0;
      if (!this.v38 || var2 != this.v42 || var3 != this.v43) {
         boolean var8 = false;

         for (int var9 = 0; var9 < v29.length; var9++) {
            int var10 = var2 + v29[var9];
            int var11 = var3 + v30[var9];
            int var12 = v1(var10, var11);
            if (!this.v31[var12] || this.v32[var12] != var10 || this.v23[var12] != var11) {
               if (var7 == 8) {
                  var8 = true;
                  break;
               }

               this.v1(var1, var10, var11, var12, var4, var6);
               var7++;
            }
         }

         this.v38 = !var8;
         this.v42 = var2;
         this.v43 = var3;
         if (!this.v38) {
            return var7;
         }
      }

      int var14 = 0;

      for (int var15 = 0; var15 < 64 && var14 < 2; var15++) {
         int var16 = this.v37;
         this.v37 = (this.v37 + 1) % v29.length;
         int var17 = v1(var2 + v29[var16], var3 + v30[var16]);
         long var18 = !this.v34[var17] ? 1000000000L : (var16 < 49 ? 1500000000L : 15000000000L);
         if (var4 - this.v33[var17] >= var18) {
            this.v1(var1, this.v32[var17], this.v23[var17], var17, var4, var6);
            var14++;
         }
      }

      return var7 + var14;
   }

   private void v1(moduleSupport.Part2 var1, int var2, int var3, int var4, long var5, moduleSupport.Part1 var7) {
      this.v46.clear();
      this.v51.clear();
      boolean var8 = var1.v1(var2, var3);
      if (var8) {
         int var9 = var1.v1();

         for (int var10 = 0; var10 < 18; var10++) {
            for (int var11 = 0; var11 < 18; var11++) {
               this.v1(var1, var11 - 1, var10 - 1, var11 + var10 * 18, var9);
            }
         }

         boolean var15 = false;

         for (int var16 = 0; var16 < 16; var16++) {
            for (int var12 = 0; var12 < 16; var12++) {
               int var13 = var12 + 1 + (var16 + 1) * 18;
               v1(this.v46, this.v51, this.v48[var13] - var9, this.v44[var13], this.v47[var13], this.v49[var13], this.v2(var13));
               var15 |= (this.v44[var13] & 8) != 0;
            }
         }

         this.v36[var4] = var15;
      } else {
         this.v36[var4] = false;

         for (int var14 = 0; var14 < 256; var14++) {
            v1(this.v46, this.v51, 0, 0, 0.0F, 0.0F, 1.0F);
         }
      }

      this.v46.flip();
      this.v51.flip();
      var7.write(Math.floorMod(var2, 32), Math.floorMod(var3, 32), this.v46, this.v51);
      this.v32[var4] = var2;
      this.v23[var4] = var3;
      this.v31[var4] = true;
      this.v34[var4] = var8;
      this.v33[var4] = var5;
   }

   public boolean v1(int var1, int var2, int var3) {
      for (int var4 = 0; var4 < 1024; var4++) {
         if (this.v31[var4] && this.v36[var4] && Math.abs(this.v32[var4] - var1) <= var3 && Math.abs(this.v23[var4] - var2) <= var3) {
            return true;
         }
      }

      return false;
   }

   private void v1(moduleSupport.Part2 var1, int var2, int var3, int var4, int var5) {
      int var6 = var1.v2(var2, var3);
      this.v48[var4] = var6;
      this.v40[var4] = var6;
      this.v44[var4] = 0;
      this.v47[var4] = 0.0F;
      this.v49[var4] = 0.0F;
      if (var6 != Integer.MIN_VALUE) {
         int var7 = var6 - 1;
         int var8 = var7 >= var5 ? var1.v1(var2, var7, var3) : 0;
         boolean var9 = var8 == 2;

         int var10;
         for (var10 = 0; var10 < 4 && var7 >= var5 && var1.v1(var2, var7, var3) != 0; var10++) {
            var7--;
         }

         this.v44[var4] = 1 | (var9 ? 2 : 0) | (var8 == 3 ? 8 : 0) | (var8 == 4 ? 16 : 0);
         if (var10 == 4) {
            this.v49[var4] = 1.0F;
         } else if (var7 >= var5) {
            int var11 = var7 + 1;

            for (int var12 = 0; var12 < 16 && var7 >= var5 && var1.v1(var2, var7, var3) == 0; var12++) {
               var7--;
            }

            this.v40[var4] = var7 + 1;
            this.v47[var4] = v1(var11 - (var7 + 1)) * (var9 ? 0.3F : 1.0F);
            this.v44[var4] = this.v44[var4] | 4;
         }
      }
   }

   private float v2(int var1) {
      int var2 = this.v40[var1];
      int var3 = 0;

      for (int var4 = -1; var4 <= 1; var4++) {
         for (int var5 = -1; var5 <= 1; var5++) {
            int var6 = var1 + var5 + var4 * 18;
            if (this.v48[var6] == Integer.MIN_VALUE || this.v40[var6] == var2) {
               var3++;
            }
         }
      }

      return var3 / 9.0F;
   }

   public static float v1(int var0) {
      float var1 = Math.clamp((var0 - 4) / 10.0F, 0.0F, 1.0F);
      return 1.0F - var1 * var1 * (3.0F - 2.0F * var1);
   }

   public static void v1(ByteBuffer var0, ByteBuffer var1, int var2, int var3, float var4, float var5, float var6) {
      int var7 = Math.clamp((long)var2, 0, 4095);
      var0.put((byte)(var7 & 0xFF));
      var0.put((byte)(var7 >> 8));
      var0.put((byte)var3);
      var0.put((byte)0);
      var1.put((byte)Math.round(Math.clamp(var4, 0.0F, 1.0F) * 255.0F));
      var1.put((byte)Math.round(Math.clamp(var5, 0.0F, 1.0F) * 255.0F));
      var1.put((byte)0);
      var1.put((byte)Math.round(Math.clamp(var6, 0.0F, 1.0F) * 255.0F));
   }

   public static int v1(int var0, int var1) {
      return Math.floorMod(var0, 32) + Math.floorMod(var1, 32) * 32;
   }

   static {
      Integer[] var0 = new Integer[1024];

      for (int var1 = 0; var1 < var0.length; var1++) {
         var0[var1] = var1;
      }

      Arrays.sort(var0, Comparator.comparingInt(var0x -> {
         int var1x = var0x % 32 - 16;
         int var2x = var0x / 32 - 16;
         return var1x * var1x + var2x * var2x;
      }));

      for (int var2 = 0; var2 < var0.length; var2++) {
         v29[var2] = var0[var2] % 32 - 16;
         v30[var2] = var0[var2] / 32 - 16;
      }
   }

   public interface Part1 {
      void write(int var1, int var2, ByteBuffer var3, ByteBuffer var4);
   }

   public interface Part2 {
      boolean v1(int var1, int var2);

      int v1();

      int v2(int var1, int var2);

      int v1(int var1, int var2, int var3);
   }
}
