package cc.syky.internal;

import cc.syky.FogSupport2;
import com.mojang.blaze3d.systems.CommandEncoder;
import com.mojang.blaze3d.systems.GpuDevice;
import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.textures.FilterMode;
import com.mojang.blaze3d.textures.TextureFormat;
import java.util.ArrayList;
import java.util.List;
import net.minecraft.class_1011;
import net.minecraft.class_1044;
import net.minecraft.class_2960;
import net.minecraft.class_310;
import org.jetbrains.annotations.Nullable;

public final class InternalSupport45 implements AutoCloseable {
   public static final int v1 = 1024;
   public static final int v2 = 2;
   private static final int v3 = 32;
   private final List<InternalSupport45.Part2> v4 = new ArrayList<>();
   private int v5;
   @Nullable
   private InternalSupport45.Part1 v6;
   @Nullable
   private InternalSupport45.Part1 v7;

   public InternalSupport45() {
   }

   public InternalSupport45.Part1 v1(class_1011 var1, boolean var2) {
      return this.v1(var1, var2, false);
   }

   private InternalSupport45.Part1 v1(class_1011 var1, boolean var2, boolean var3) {
      int var4 = var1.method_4307() + 4;
      int var5 = var1.method_4323() + 4;

      for (InternalSupport45.Part2 var7 : this.v4) {
         if (var7.v2 == var2) {
            int[] var8 = var7.v1(var4, var5);
            if (var8 != null) {
               return v1(var7, var1, var8, var3);
            }
         }
      }

      if (this.v4.size() >= 32) {
         throw new IllegalStateException("cosmetic atlas is full");
      } else {
         short var9 = 1024;

         while (var9 < Math.max(var4, var5)) {
            var9 *= 2;
         }

         InternalSupport45.Part2 var10 = new InternalSupport45.Part2(class_2960.method_60655("syky", "cosmetics/page_" + this.v5++), var9, var2);
         class_310.method_1551().method_1531().method_4616(var10.v1, var10);
         this.v4.add(var10);
         int[] var11 = var10.v1(var4, var5);
         if (var11 == null) {
            throw new IllegalStateException("a fresh page cannot hold " + var4 + "x" + var5);
         } else {
            return v1(var10, var1, var11, var3);
         }
      }
   }

   private static InternalSupport45.Part1 v1(InternalSupport45.Part2 var0, class_1011 var1, int[] var2, boolean var3) {
      v1(var0, var1, var2[0], var2[1]);
      var0.v7++;
      float var4 = var0.v3;
      return new InternalSupport45.Part1(
         var0, (var2[0] + 2) / var4, (var2[1] + 2) / var4, (var2[0] + 2 + var1.method_4307()) / var4, (var2[1] + 2 + var1.method_4323()) / var4, var3
      );
   }

   public InternalSupport45.Part1 v1(boolean var1) {
      InternalSupport45.Part1 var2 = var1 ? this.v7 : this.v6;
      if (var2 == null) {
         class_1011 var3 = new class_1011(4, 4, false);

         try {
            var3.method_4326(0, 0, 4, 4, -1);
            var2 = this.v1(var3, var1, true);
         } catch (Throwable var7) {
            try {
               var3.close();
            } catch (Throwable var6) {
               var7.addSuppressed(var6);
            }

            throw var7;
         }

         var3.close();
         if (var1) {
            this.v7 = var2;
         } else {
            this.v6 = var2;
         }
      }

      return var2;
   }

   public void v1(InternalSupport45.Part1 var1) {
      if (!var1.v6()) {
         InternalSupport45.Part2 var2 = var1.v1();
         if (--var2.v7 <= 0 && this.v4.remove(var2)) {
            FogSupport2.v2(var2.v1);
            class_310.method_1551().method_1531().method_4615(var2.v1);
         }
      }
   }

   private static void v1(InternalSupport45.Part2 var0, class_1011 var1, int var2, int var3) {
      int var4 = var1.method_4307();
      int var5 = var1.method_4323();
      class_1011 var6 = new class_1011(var4 + 4, var5 + 4, false);

      try {
         for (int var7 = 0; var7 < var5 + 4; var7++) {
            int var8 = Math.min(var5 - 1, Math.max(0, var7 - 2));

            for (int var9 = 0; var9 < var4 + 4; var9++) {
               int var10 = Math.min(var4 - 1, Math.max(0, var9 - 2));
               var6.method_61941(var9, var7, var1.method_61940(var10, var8));
            }
         }

         CommandEncoder var13 = RenderSystem.getDevice().createCommandEncoder();
         var13.writeToTexture(var0.method_68004(), var6, 0, 0, var2, var3, var4 + 4, var5 + 4, 0, 0);
      } catch (Throwable var12) {
         try {
            var6.close();
         } catch (Throwable var11) {
            var12.addSuppressed(var11);
         }

         throw var12;
      }

      var6.close();
   }

   public int v1() {
      return this.v4.size();
   }

   @Override
   public void close() {
      for (InternalSupport45.Part2 var2 : this.v4) {
         class_310.method_1551().method_1531().method_4615(var2.v1);
      }

      this.v4.clear();
      this.v6 = null;
      this.v7 = null;
   }

   public record Part1(InternalSupport45.Part2 page, float u0, float v0, float u1, float v1, boolean shared) {
      public InternalSupport45.Part2 v1() {
         return this.page;
      }

      public float v2() {
         return this.u0;
      }

      public float v3() {
         return this.v0;
      }

      public float v4() {
         return this.u1;
      }

      public float v5() {
         return this.v1;
      }

      public boolean v6() {
         return this.shared;
      }
   }

   public static final class Part2 extends class_1044 {
      public final class_2960 v1;
      public final boolean v2;
      public final int v3;
      private int v4;
      private int v5;
      private int v6;
      public int v7;

      public Part2(class_2960 var1, int var2, boolean var3) {
         this.v1 = var1;
         this.v3 = var2;
         this.v2 = var3;
         GpuDevice var4 = RenderSystem.getDevice();
         this.field_56974 = var4.createTexture(var1::toString, 13, TextureFormat.RGBA8, var2, var2, 1, 1);
         this.field_60597 = var4.createTextureView(this.field_56974);
         this.field_63613 = RenderSystem.getSamplerCache().method_76520(var3 ? FilterMode.LINEAR : FilterMode.NEAREST, false);
         var4.createCommandEncoder().clearColorTexture(this.field_56974, 0);
      }

      @Nullable
      public int[] v1(int var1, int var2) {
         if (var1 <= this.v3 && var2 <= this.v3) {
            if (this.v6 + var1 > this.v3) {
               this.v4 = this.v4 + this.v5;
               this.v5 = 0;
               this.v6 = 0;
            }

            if (this.v4 + var2 > this.v3) {
               return null;
            } else {
               int[] var3 = new int[]{this.v6, this.v4};
               this.v6 += var1;
               this.v5 = Math.max(this.v5, var2);
               return var3;
            }
         } else {
            return null;
         }
      }
   }
}
