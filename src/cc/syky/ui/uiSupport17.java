package cc.syky.ui;

import org.jetbrains.annotations.Nullable;

public final class uiSupport17 {
   private static final int v1 = 33;
   private static final int v2 = 44;
   private static final int v3 = 59;
   private static final int v4 = 6;

   private uiSupport17() {
   }

   @Nullable
   public static uiSupport17.Part1 v1(byte[] var0) {
      if (var0.length >= 13 && var0[0] == 71 && var0[1] == 73 && var0[2] == 70) {
         int var1 = v2(var0, 6);
         int var2 = v2(var0, 8);
         int var3 = var0[10] & 255;
         int var4 = 13;
         if ((var3 & 128) != 0) {
            var4 += 3 * (1 << (var3 & 7) + 1);
         }

         int var5 = 0;
         boolean var6 = false;

         while (true) {
            if (var4 >= var0.length) {
               var6 = true;
               break;
            }

            int var7 = var0[var4++] & 255;
            if (var7 == 59) {
               break;
            }

            if (var7 == 33) {
               if (var4 >= var0.length) {
                  var6 = true;
                  break;
               }

               var4 = v1(var0, ++var4);
            } else {
               if (var7 != 44) {
                  var6 = true;
                  break;
               }

               var5++;
               if (var4 + 9 > var0.length) {
                  var6 = true;
                  break;
               }

               int var8 = var0[var4 + 8] & 255;
               var4 += 9;
               if ((var8 & 128) != 0) {
                  var4 += 3 * (1 << (var8 & 7) + 1);
               }

               var4 = v1(var0, ++var4);
            }

            if (var4 < 0) {
               var6 = true;
               break;
            }
         }

         return new uiSupport17.Part1(Math.max(1, var1), Math.max(1, var2), Math.max(1, var5), var6);
      } else {
         return null;
      }
   }

   private static int v1(byte[] var0, int var1) {
      int var2 = var1;

      while (var2 < var0.length) {
         int var3 = var0[var2++] & 255;
         if (var3 == 0) {
            return var2;
         }

         var2 += var3;
      }

      return -1;
   }

   private static int v2(byte[] var0, int var1) {
      return var0[var1] & 0xFF | (var0[var1 + 1] & 0xFF) << 8;
   }

   public record Part1(int width, int height, int frames, boolean truncated) {
      public long v1() {
         return (long)this.width * this.height * this.frames * 4L;
      }

      public int v2() {
         return this.width;
      }

      public int v3() {
         return this.height;
      }

      public int v4() {
         return this.frames;
      }

      public boolean v5() {
         return this.truncated;
      }
   }
}
