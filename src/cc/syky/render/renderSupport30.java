package cc.syky.render;

import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.textures.GpuTexture;
import com.mojang.blaze3d.textures.GpuTextureView;
import net.minecraft.class_310;
import org.jetbrains.annotations.Nullable;

public final class renderSupport30 {
   private static final int v1 = 4;
   private static final GpuTextureView[] v2 = new GpuTextureView[4];
   private static final GpuTexture[] v3 = new GpuTexture[4];
   private static final boolean[] v4 = new boolean[4];
   private static int v5;

   private renderSupport30() {
   }

   public static boolean v1(@Nullable GpuTextureView var0) {
      return v1(var0, null);
   }

   public static boolean v1(@Nullable GpuTextureView var0, @Nullable GpuTexture var1) {
      if (v5 < 4 && var0 != null) {
         v3[v5] = var1;
         v4[v5] = false;
         v2[v5++] = var0;
         return true;
      } else {
         return false;
      }
   }

   public static void v1() {
      if (v5 > 0) {
         v5--;
         v2[v5] = null;
         v3[v5] = null;
      }
   }

   public static GpuTextureView v1(class_310 var0) {
      if (v5 > 0) {
         int var1 = v5 - 1;
         v4[var1] = true;
         v1(var1);
         return v2[var1];
      } else {
         return var0.method_1522().method_71639();
      }
   }

   public static boolean v2() {
      return v5 > 0 && !v4[v5 - 1];
   }

   public static void v3() {
      for (int var0 = 0; var0 < v5; var0++) {
         v4[var0] = true;
         v1(var0);
      }
   }

   public static void v4() {
      if (v5 > 0) {
         v1(v5 - 1);
      }
   }

   private static void v1(int var0) {
      GpuTexture var1 = v3[var0];
      if (var1 != null) {
         v3[var0] = null;
         RenderSystem.getDevice().createCommandEncoder().clearColorTexture(var1, 0);
      }
   }

   public static void v5() {
      while (v5 > 0) {
         v1();
      }
   }
}
