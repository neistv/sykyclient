package cc.syky.ui;

import cc.syky.internal.InternalSupport10;
import it.unimi.dsi.fastutil.longs.LongArrayList;
import it.unimi.dsi.fastutil.objects.Reference2ByteOpenHashMap;
import net.minecraft.class_1299;
import net.minecraft.class_1944;
import net.minecraft.class_1948;
import net.minecraft.class_2248;
import net.minecraft.class_2338;
import net.minecraft.class_2346;
import net.minecraft.class_2350;
import net.minecraft.class_247;
import net.minecraft.class_259;
import net.minecraft.class_265;
import net.minecraft.class_2680;
import net.minecraft.class_2784;
import net.minecraft.class_2818;
import net.minecraft.class_2874;
import net.minecraft.class_3558;
import net.minecraft.class_638;
import net.minecraft.class_2338.class_2339;
import org.jetbrains.annotations.Nullable;

public final class uiSupport178 {
   private static final class_265 v1 = class_259.method_1081(0.2, 0.0, 0.2, 0.8, 0.9, 0.8);
   private static final class_2350[] v2 = class_2350.values();
   private static final class_2350[] v3 = new class_2350[]{class_2350.field_11043, class_2350.field_11035, class_2350.field_11039, class_2350.field_11034};
   private static final Reference2ByteOpenHashMap<class_2680> v4 = new Reference2ByteOpenHashMap();
   private static final Reference2ByteOpenHashMap<class_2680> v5 = new Reference2ByteOpenHashMap();
   private static final int v6 = 64;
   private static final int v7 = 32;

   private uiSupport178() {
   }

   @Nullable
   public static uiSupport178.Part1 v1(class_638 var0, uiSupport178.Part2 var1, int var2, int var3, int var4, class_2339 var5) {
      if (!var0.method_8393(var2, var4)) {
         return null;
      } else {
         class_2818 var6 = var0.method_8497(var2, var4);
         int var7 = var0.method_31603(var3);
         if (var7 >= 0 && var7 < var6.method_12006().length) {
            boolean var8 = var6.method_38259(var7).method_38292();
            byte[] var9 = var8 ? null : new byte[4096];
            byte[] var10 = null;
            LongArrayList var11 = new LongArrayList();
            LongArrayList var12 = new LongArrayList();
            class_2784 var13 = var0.method_8621();
            int var14 = var2 << 4;
            int var15 = var3 << 4;
            int var16 = var4 << 4;
            int var17 = var8 ? 2 : 16;

            for (int var18 = 0; var18 < 16; var18++) {
               for (int var19 = 0; var19 < 16; var19++) {
                  int var20 = var14 + var19;
                  int var21 = var16 + var18;
                  boolean var22 = var19 == 0 || var19 == 15 || var18 == 0 || var18 == 15;
                  class_2680 var23 = var6.method_8320(var5.method_10103(var20, var15 - 2, var21));
                  class_2680 var24 = var6.method_8320(var5.method_10103(var20, var15 - 1, var21));
                  class_2680 var25 = var6.method_8320(var5.method_10103(var20, var15, var21));

                  for (int var26 = 0; var26 < var17; var26++) {
                     int var27 = var15 + var26;
                     class_2680 var28 = var6.method_8320(var5.method_10103(var20, var27 + 1, var21));
                     if (var9 != null) {
                        int var29 = (var26 * 16 + var18) * 16 + var19;
                        var9[var29] = (byte)var25.method_26193();
                        if (var25.method_26211()) {
                           byte var30 = v1(var25);
                           if (var30 != 0) {
                              if (var10 == null) {
                                 var10 = new byte[4096];
                              }

                              var10[var29] = var30;
                           }
                        }
                     }

                     if (v1(var0, var13, var24, var25, var28, var20, var27, var21, var5)
                        && var1.v1(var0.method_8314(class_1944.field_9282, var5.method_10103(var20, var27, var21)))) {
                        var11.add(InternalSupport10.v1(var20, var27 - 1, var21));
                     }

                     if (v1(var0, var6, var22, var23, var24, var25, var20, var27, var21, var5)) {
                        var12.add(InternalSupport10.v1(var20, var27, var21));
                     }

                     var23 = var24;
                     var24 = var25;
                     var25 = var28;
                  }
               }
            }

            return var11.isEmpty() && var12.isEmpty() && var9 == null
               ? uiSupport178.Part1.EMPTY
               : new uiSupport178.Part1(var11.toLongArray(), var12.toLongArray(), var9, var10);
         } else {
            return uiSupport178.Part1.EMPTY;
         }
      }
   }

   private static boolean v1(class_638 var0, class_2784 var1, class_2680 var2, class_2680 var3, class_2680 var4, int var5, int var6, int var7, class_2339 var8) {
      if (!var2.method_26215() && !var3.method_26216()) {
         if (!var2.method_26170(var0, var8.method_10103(var5, var6 - 1, var7), class_1299.field_6051)) {
            return false;
         } else {
            var8.method_10103(var5, var6, var7);
            return v1(var0, var8, var3) && !v2(var0, var8, var3) && var1.method_11952(var8) ? v1(var0, var8.method_10103(var5, var6 + 1, var7), var4) : false;
         }
      } else {
         return false;
      }
   }

   private static boolean v1(
      class_638 var0, class_2818 var1, boolean var2, class_2680 var3, class_2680 var4, class_2680 var5, int var6, int var7, int var8, class_2339 var9
   ) {
      if (!var5.method_26216() && var5.method_45474() && var5.method_26227().method_15769()) {
         if (var4.method_26204() instanceof class_2346 && v1(var0, var1, false, var6, var7 - 1, var8, var9)) {
            return false;
         } else if ((v1(var4, var0, var9.method_10103(var6, var7 - 1, var8)) & 64) != 0) {
            return true;
         } else {
            boolean var10 = (v1(var3, var0, var9.method_10103(var6, var7 - 2, var8)) & 64) != 0 || !var4.method_26215();
            if (!var10) {
               return false;
            } else {
               for (class_2350 var14 : v3) {
                  var9.method_10103(var6 + var14.method_10148(), var7, var8 + var14.method_10165());
                  class_2680 var15 = var2 ? var0.method_8320(var9) : var1.method_8320(var9);
                  if ((v1(var15, var0, var9) & 1 << var14.method_10153().ordinal()) != 0
                     && !v1(var0, var1, var2, var6 + var14.method_10148(), var7, var8 + var14.method_10165(), var9)) {
                     return true;
                  }
               }

               return false;
            }
         }
      } else {
         return false;
      }
   }

   private static boolean v1(class_638 var0, class_2818 var1, boolean var2, int var3, int var4, int var5, class_2339 var6) {
      for (int var7 = 0; var7 < 32; var7++) {
         var6.method_10103(var3, var4 - var7, var5);
         class_2680 var8 = var2 ? var0.method_8320(var6) : var1.method_8320(var6);
         if (!(var8.method_26204() instanceof class_2346)) {
            return var7 > 0 && class_2346.method_10128(var8);
         }
      }

      return false;
   }

   private static byte v1(class_2680 var0, class_638 var1, class_2338 var2) {
      if (var0.method_26215()) {
         return 0;
      } else {
         byte var3 = v5.getOrDefault(var0, (byte)-1);
         if (var3 != -1) {
            return var3;
         } else {
            int var4 = class_2248.method_20044(var1, var2, class_2350.field_11036) ? 64 : 0;

            for (class_2350 var8 : v3) {
               if (var0.method_26206(var1, var2, var8)) {
                  var4 |= 1 << var8.ordinal();
               }
            }

            v5.put(var0, (byte)var4);
            return (byte)var4;
         }
      }
   }

   private static byte v1(class_2680 var0) {
      byte var1 = v4.getOrDefault(var0, (byte)-1);
      if (var1 != -1) {
         return var1;
      } else {
         int var2 = 0;

         for (class_2350 var6 : v2) {
            if (class_259.method_20713(class_3558.method_51562(var0, var6), class_259.method_1073())) {
               var2 |= 1 << var6.ordinal();
            }
         }

         v4.put(var0, (byte)var2);
         return (byte)var2;
      }
   }

   private static boolean v1(class_638 var0, class_2338 var1, class_2680 var2) {
      return class_1948.method_8662(var0, var1, var2, var2.method_26227(), class_1299.field_6051);
   }

   private static boolean v2(class_638 var0, class_2338 var1, class_2680 var2) {
      class_265 var3 = var2.method_26220(var0, var1);
      return !var3.method_1110() && class_259.method_1074(var3, v1, class_247.field_16896);
   }

   public record Part1(long[] floors, long[] mounts, @Nullable byte[] opacity, @Nullable byte[] faces) {
      public static final uiSupport178.Part1 EMPTY = new uiSupport178.Part1(new long[0], new long[0], null, null);

      public long[] v1() {
         return this.floors;
      }

      public long[] v2() {
         return this.mounts;
      }

      @Nullable
      public byte[] v3() {
         return this.opacity;
      }

      @Nullable
      public byte[] v4() {
         return this.faces;
      }
   }

   public record Part2(int blockLimit, int maxLight) {
      public static uiSupport178.Part2 v1(class_2874 var0) {
         return new uiSupport178.Part2(var0.method_44223(), var0.method_44222().method_35011());
      }

      public boolean v1(int var1) {
         return (var1 <= this.blockLimit || this.blockLimit >= 15) && var1 <= this.maxLight;
      }

      public int v1() {
         return Math.min(this.blockLimit < 15 ? this.blockLimit + 1 : 16, this.maxLight + 1);
      }

      public int v2() {
         return this.blockLimit;
      }

      public int v3() {
         return this.maxLight;
      }
   }
}
