package cc.syky.ui;

import cc.syky.DecompilationFailedSupport;
import cc.syky.cloud.CloudClient;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map.Entry;
import net.minecraft.class_1011;
import net.minecraft.class_2960;
import net.minecraft.class_310;
import org.jetbrains.annotations.Nullable;

public final class uiSupport119 {
   private static final int v2 = 256;
   private static final int v3 = 524288;
   private static final int v4 = 12;
   private static final int v5 = 64;
   private static final int v6 = 160;
   private static final int v7 = 40;
   private static final int v8 = 1381658;
   private static final float[][] v9 = new float[][]{
      {0.17F, 0.0F, 99.0F, 102.0F, 241.0F, 0.5F}, {0.6F, 0.27F, 236.0F, 72.0F, 153.0F, 0.34F}, {0.86F, 0.14F, 14.0F, 165.0F, 233.0F, 0.44F}
   };
   private static final float v10 = 0.3F;
   private static final float v11 = 0.35F;
   private static final int v12 = 1500;
   private static final int v13 = 375;
   private static final int v14 = 1048576;
   private final LinkedHashMap<Long, uiSupport119.Part2> v15 = new LinkedHashMap<>(16, 0.75F, true);
   public static final int v1 = 0;
   private static final int v16 = 3;
   private final CloudClient v18;
   private final LinkedHashMap<Long, uiSupport119.Part1> v19 = new LinkedHashMap<>(16, 0.75F, true);
   @Nullable
   private class_2960 v17;
   private int v20;

   public uiSupport119(CloudClient var1) {
      this.v18 = var1;
   }

   public int v1() {
      return this.v20;
   }

   @Nullable
   public class_2960 v1(long var1, long var3) {
      return this.v4(var1, var3).v2();
   }

   public int v2(long var1, long var3) {
      return this.v4(var1, var3).v3();
   }

   public static int v1(DecompilationFailedSupport.Part1 var0) {
      short var1 = 512;
      int[] var2 = new int[var1];
      long[] var3 = new long[var1];
      long[] var4 = new long[var1];
      long[] var5 = new long[var1];
      byte var6 = 5;

      for (int var10 : var0.v1()) {
         if (var10 >>> 24 >= 128) {
            int var11 = var10 >> 16 & 0xFF;
            int var12 = var10 >> 8 & 0xFF;
            int var13 = var10 & 0xFF;
            int var14 = var11 >> var6 << 6 | var12 >> var6 << 3 | var13 >> var6;
            var2[var14]++;
            var3[var14] += var11;
            var4[var14] += var12;
            var5[var14] += var13;
         }
      }

      int var15 = 0;

      for (int var16 = 1; var16 < var1; var16++) {
         if (var2[var16] > var2[var15]) {
            var15 = var16;
         }
      }

      int var17 = var2[var15];
      return var17 == 0 ? 0 : 0xFF000000 | (int)(var3[var15] / var17) << 16 | (int)(var4[var15] / var17) << 8 | (int)(var5[var15] / var17);
   }

   @Nullable
   public uiSupport119.Part2 v3(long var1, long var3) {
      uiSupport119.Part2 var5 = this.v15.get(var1);
      if (var5 != null && var5.v1() == var3) {
         return var5.v2() == null ? null : var5;
      } else {
         uiSupport119.Part2 var6 = new uiSupport119.Part2(var3, null, 0, 0);
         this.v15.put(var1, var6);
         if (var5 != null) {
            v1(var5.v2());
         }

         this.v4();
         if (var3 != 0L) {
            this.v6(var1, var3);
         }

         return null;
      }
   }

   public class_2960 v2() {
      class_2960 var1 = this.v17;
      if (var1 == null) {
         var1 = class_2960.method_60655("syky", "profile/banner");
         v1(var1, DecompilationFailedSupport.v1(v3()));
         this.v17 = var1;
      }

      return var1;
   }

   public static DecompilationFailedSupport.Part1 v3() {
      int[] var0 = new int[6400];
      float var1 = 0.25F;

      for (int var2 = 0; var2 < 40; var2++) {
         float var3 = (var2 + 0.5F) / 40.0F;

         for (int var4 = 0; var4 < 160; var4++) {
            float var5 = (var4 + 0.5F) / 160.0F;
            float var6 = 21.0F;
            float var7 = 21.0F;
            float var8 = 26.0F;

            for (float[] var12 : v9) {
               float var13 = (var5 - var12[0]) / 0.3F;
               float var14 = (var3 - var12[1]) * var1 / 0.3F;
               float var15 = var12[5] * (float)Math.exp(-2.2 * (var13 * var13 + var14 * var14));
               var6 += (var12[2] - var6) * var15;
               var7 += (var12[3] - var7) * var15;
               var8 += (var12[4] - var8) * var15;
            }

            float var16 = 1.0F - 0.35F * var3;
            var0[var2 * 160 + var4] = 0xFF000000 | v1(var6 * var16) << 16 | v1(var7 * var16) << 8 | v1(var8 * var16);
         }
      }

      return new DecompilationFailedSupport.Part1(var0, 160, 40);
   }

   private uiSupport119.Part1 v4(long var1, long var3) {
      uiSupport119.Part1 var5 = this.v19.get(var1);
      if (var5 != null && var5.v1() == var3) {
         return var5;
      } else {
         uiSupport119.Part1 var6 = new uiSupport119.Part1(var3, null, 0);
         this.v19.put(var1, var6);
         if (var5 != null) {
            v1(var5);
         }

         this.v5();
         if (var3 != 0L) {
            this.v5(var1, var3);
         }

         return var6;
      }
   }

   private void v5(long var1, long var3) {
      this.v18.v1("/avatars/" + var1 + "?v=" + var3, 524288, var5 -> {
         if (var5 != null) {
            DecompilationFailedSupport.Part1 var6 = DecompilationFailedSupport.v1(var5, 256);
            if (var6 != null) {
               int var7 = v1(var6);
               class_1011 var8 = DecompilationFailedSupport.v1(var6);
               class_310.method_1551().execute(() -> this.v1(var1, var3, var8, var7));
            }
         }
      });
   }

   private void v1(long var1, long var3, class_1011 var5, int var6) {
      uiSupport119.Part1 var7 = this.v19.get(var1);
      if (var7 != null && var7.v1() == var3 && var7.v2() == null) {
         class_2960 var8 = class_2960.method_60655("syky", "profile/avatar_" + var1 + "_" + var3);
         v1(var8, var5);
         this.v19.put(var1, new uiSupport119.Part1(var3, var8, var6));
         this.v20++;
      } else {
         var5.close();
      }
   }

   private void v6(long var1, long var3) {
      this.v18.v1("/banners/" + var1 + "?v=" + var3, 1048576, var5 -> {
         if (var5 != null) {
            DecompilationFailedSupport.Part1 var6 = DecompilationFailedSupport.v1(var5, 1500);
            if (var6 != null) {
               class_1011 var7 = DecompilationFailedSupport.v1(var6);
               int var8 = var6.v2();
               int var9 = var6.v3();
               class_310.method_1551().execute(() -> this.v1(var1, var3, var7, var8, var9));
            }
         }
      });
   }

   private void v1(long var1, long var3, class_1011 var5, int var6, int var7) {
      uiSupport119.Part2 var8 = this.v15.get(var1);
      if (var8 != null && var8.v1() == var3 && var8.v2() == null) {
         class_2960 var9 = class_2960.method_60655("syky", "profile/banner_" + var1 + "_" + var3);
         v1(var9, var5);
         this.v15.put(var1, new uiSupport119.Part2(var3, var9, var6, var7));
         this.v20++;
      } else {
         var5.close();
      }
   }

   private void v4() {
      Iterator var1 = this.v15.entrySet().iterator();

      while (this.v15.size() > 12 && var1.hasNext()) {
         v1(((uiSupport119.Part2)((Entry)var1.next()).getValue()).v2());
         var1.remove();
      }
   }

   private void v5() {
      Iterator var1 = this.v19.entrySet().iterator();

      while (this.v19.size() > 64 && var1.hasNext()) {
         v1((uiSupport119.Part1)((Entry)var1.next()).getValue());
         var1.remove();
      }
   }

   private static void v1(uiSupport119.Part1 var0) {
      v1(var0.v2());
   }

   private static void v1(@Nullable class_2960 var0) {
      if (var0 != null) {
         class_310.method_1551().method_1531().method_4615(var0);
      }
   }

   private static void v1(class_2960 var0, class_1011 var1) {
      try {
         class_310.method_1551().method_1531().method_4616(var0, new uiSupport121(var0, var1));
      } catch (RuntimeException var3) {
         var1.close();
         throw var3;
      }
   }

   private static int v1(float var0) {
      return Math.clamp((long)Math.round(var0), 0, 255);
   }

   public record Part1(long version, @Nullable class_2960 avatar, int colour) {
      public long v1() {
         return this.version;
      }

      @Nullable
      public class_2960 v2() {
         return this.avatar;
      }

      public int v3() {
         return this.colour;
      }
   }

   public record Part2(long version, @Nullable class_2960 texture, int width, int height) {
      public long v1() {
         return this.version;
      }

      @Nullable
      public class_2960 v2() {
         return this.texture;
      }

      public int v3() {
         return this.width;
      }

      public int v4() {
         return this.height;
      }
   }
}
