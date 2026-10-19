package cc.syky.hud;

import cc.syky.ui.uiSupport169;
import com.mojang.blaze3d.textures.GpuTextureView;
import java.util.Arrays;
import net.minecraft.class_1792;
import net.minecraft.class_1799;
import net.minecraft.class_1802;
import net.minecraft.class_310;
import org.jetbrains.annotations.Nullable;

public final class hudSupport14 {
   public static final int v1 = 20;
   private static final long v2 = 50000000L;
   private final String v3;
   private final class_1799[] v4;
   private final boolean[] v5;
   private final long[] v6;
   private final boolean[] v7;
   private final class_1799[] v8;
   private final float[] v9;
   private final float[] v10;
   private final float[] v11;
   private final int[] v12;
   private final boolean[] v13;
   private final int[] v14;
   private final int[] v15;
   private int v16;
   private long v18;
   private final long v19;
   private int v17;
   private int v20;
   private int v21;
   private int v22;
   private int v24 = -1;
   private int v25;
   private int v26;
   private int v27;
   private boolean v28;
   private final hudSupport69.Part1 v29 = (var1x, var2x) -> this.v1(var2x);

   public hudSupport14(String var1, int var2) {
      this.v3 = var1;
      this.v19 = (var1.hashCode() & 2147483647L) % 50000000L;
      this.v4 = new class_1799[var2];
      this.v8 = new class_1799[var2];
      Arrays.fill(this.v4, class_1799.field_8037);
      Arrays.fill(this.v8, class_1799.field_8037);
      this.v5 = new boolean[var2];
      this.v6 = new long[var2];
      this.v7 = new boolean[var2];
      this.v9 = new float[var2];
      this.v10 = new float[var2];
      this.v11 = new float[var2];
      this.v12 = new int[var2 * 4];
      this.v13 = new boolean[var2];
      this.v14 = new int[var2];
      this.v15 = new int[var2 * 4];
   }

   public void v1(int var1, int var2, int var3, int var4) {
      this.v17 = Math.min(var1, this.v4.length);
      this.v20 = var2;
      this.v21 = var3;
      this.v22 = var4;
   }

   public void v1(int var1, class_1799 var2, float var3, float var4, float var5, int var6, int var7, int var8, int var9) {
      this.v8[var1] = var2;
      int var10 = Math.max(0, var6);
      int var11 = Math.max(0, var7);
      int var12 = Math.min(this.v20, var6 + var8);
      int var13 = Math.min(this.v21, var7 + var9);
      int var14 = 4 * var1;
      boolean var15 = this.v9[var1] != var3
         || this.v10[var1] != var4
         || this.v11[var1] != var5
         || this.v12[var14] != var10
         || this.v12[var14 + 1] != var11
         || this.v12[var14 + 2] != var12 - var10
         || this.v12[var14 + 3] != var13 - var11;
      this.v9[var1] = var3;
      this.v10[var1] = var4;
      this.v11[var1] = var5;
      this.v12[var14] = var10;
      this.v12[var14 + 1] = var11;
      this.v12[var14 + 2] = Math.max(0, var12 - var10);
      this.v12[var14 + 3] = Math.max(0, var13 - var11);
      class_1799 var16 = this.v4[var1];
      boolean var17 = v1(var2, var16);
      this.v13[var1] = var15 || !var17;
      if (var17 && !var2.method_7960() && var16.method_7947() != var2.method_7947()) {
         var16.method_7939(var2.method_7947());
      }
   }

   @Nullable
   public GpuTextureView v1() {
      this.v18 = System.nanoTime();
      long var1 = this.v4();
      boolean var3 = !this.v28
         || this.v17 != this.v24
         || this.v20 != this.v25
         || this.v21 != this.v26
         || this.v22 != this.v27
         || !uiSupport169.v1(this.v3, this.v20, this.v21);
      this.v16 = 0;
      boolean var4 = false;

      for (int var5 = 0; var5 < this.v17; var5++) {
         if (var3 || this.v13[var5] || this.v5[var5] && var1 != this.v6[var5]) {
            this.v14[this.v16++] = var5;
         }

         var4 |= this.v7[var5];
      }

      if (this.v16 > 0 && var4) {
         var3 = true;
      }

      if (var3) {
         this.v16 = 0;
         int var8 = 0;

         while (var8 < this.v17) {
            this.v14[this.v16++] = var8++;
         }

         GpuTextureView var9 = uiSupport169.v1(this.v3, this.v20, this.v21, true, this.v29);
         this.v1(var9 != null);
         return var9;
      } else if (this.v16 == 0) {
         return uiSupport169.v1(this.v3, this.v20, this.v21, false, this.v29);
      } else {
         for (int var6 = 0; var6 < this.v16; var6++) {
            System.arraycopy(this.v12, 4 * this.v14[var6], this.v15, 4 * var6, 4);
         }

         GpuTextureView var7 = uiSupport169.v1(this.v3, this.v20, this.v21, this.v15, this.v16, this.v29);
         if (var7 == null) {
            this.v28 = false;
         }

         return var7;
      }
   }

   public boolean v1(int var1, int var2, int var3) {
      return this.v28 && var1 == this.v25 && var2 == this.v26 && var3 == this.v27 && uiSupport169.v1(this.v3, var1, var2);
   }

   @Nullable
   public GpuTextureView v2(int var1, int var2, int var3) {
      return !this.v1(var1, var2, var3) ? null : uiSupport169.v1(this.v3, var1, var2, false, this.v29);
   }

   public boolean v2() {
      for (int var1 = 0; var1 < this.v24; var1++) {
         if (this.v5[var1]) {
            return true;
         }
      }

      return false;
   }

   public class_1799 v1(int var1) {
      return this.v4[var1];
   }

   public void v3() {
      this.v28 = false;
   }

   private void v1(boolean var1) {
      this.v28 = var1;
      this.v24 = this.v17;
      this.v25 = this.v20;
      this.v26 = this.v21;
      this.v27 = this.v22;
   }

   private void v1(class_310 var1) {
      for (int var2 = 0; var2 < this.v16; var2++) {
         int var3 = this.v14[var2];
         class_1799 var4 = this.v8[var3];
         if (!v1(var4, this.v4[var3])) {
            this.v4[var3] = var4.method_7960() ? class_1799.field_8037 : var4.method_7972();
         }

         int var5 = hudSupport67.v1(var1, var4, this.v9[var3], this.v10[var3], this.v11[var3]);
         this.v5[var3] = (var5 & 1) != 0 || v1(var4);
         this.v7[var3] = (var5 & 2) != 0;
         this.v6[var3] = this.v4();
      }
   }

   private long v4() {
      return Math.floorDiv(this.v18 - this.v19, 50000000L);
   }

   private static boolean v1(class_1799 var0, class_1799 var1) {
      return !var0.method_7960() && !var1.method_7960() ? var0 == var1 || class_1799.method_31577(var0, var1) : var0.method_7960() && var1.method_7960();
   }

   private static boolean v1(class_1799 var0) {
      if (var0.method_7960()) {
         return false;
      } else {
         class_1792 var1 = var0.method_7909();
         return var1 == class_1802.field_8557 || var1 == class_1802.field_8251 || var1 == class_1802.field_38747;
      }
   }
}
