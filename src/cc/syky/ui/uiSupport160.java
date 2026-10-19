package cc.syky.ui;

import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.textures.GpuTexture;
import com.mojang.blaze3d.textures.GpuTextureView;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;
import net.minecraft.class_1011;
import net.minecraft.class_1043;
import net.minecraft.class_2960;
import net.minecraft.class_310;
import net.minecraft.class_3298;
import net.minecraft.class_1011.class_1012;
import org.jetbrains.annotations.Nullable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public final class uiSupport160 implements AutoCloseable {
   private static final Logger v1 = LoggerFactory.getLogger("syky.render.atlas");
   private static final String[] v2 = new String[]{"textures/ui/icons", "textures/ui/hud"};
   private static final Set<String> v3 = Set.of("textures/ui/hud/white_pixel.png");
   private static final int v4 = 48;
   private static final int v5 = 2;
   private static final int v6 = 1;
   private static final int v7 = 256;
   private final class_1043 v8;
   private final GpuTextureView v9;
   private final Map<class_2960, uiSupport160.Part1> v10;

   private uiSupport160(class_1043 var1, GpuTextureView var2, Map<class_2960, uiSupport160.Part1> var3) {
      this.v8 = var1;
      this.v9 = var2;
      this.v10 = var3;
   }

   public GpuTextureView v1() {
      return this.v9;
   }

   @Nullable
   public uiSupport160.Part1 v1(class_2960 var1) {
      return this.v10.get(var1);
   }

   public boolean v2() {
      GpuTexture var1 = this.v8.method_68004();
      return var1 == null || var1.isClosed();
   }

   @Nullable
   public static uiSupport160 v1(class_310 var0) {
      ArrayList var1 = new ArrayList();
      class_1011 var2 = null;
      class_1043 var3 = null;

      Object var34;
      try {
         for (String var7 : v2) {
            Map var8 = var0.method_1478().method_14488(var7, var0x -> var0x.method_12832().endsWith(".png"));

            for (Entry var10 : var8.entrySet()) {
               class_2960 var11 = (class_2960)var10.getKey();
               if (var11.method_12836().equals("syky") && !v3.contains(var11.method_12832())) {
                  class_1011 var12;
                  try (InputStream var13 = ((class_3298)var10.getValue()).method_14482()) {
                     var12 = class_1011.method_4309(var13);
                  }

                  if (var12.method_4307() <= 48 && var12.method_4323() <= 48) {
                     var1.add(new uiSupport160.Part2(var11, var12));
                  } else {
                     var12.close();
                  }
               }
            }
         }

         if (var1.isEmpty()) {
            return null;
         }

         v1(var1);
         int var25 = v1(v2(var1));
         var2 = new class_1011(class_1012.field_4997, 256, var25, true);
         HashMap var29 = new HashMap(var1.size() * 2);

         for (uiSupport160.Part2 var33 : var1) {
            v1(var2, var33);
            v2(var2, var33);
            var29.put(
               var33.v1,
               new uiSupport160.Part1(var33.v5 / 256.0F, (float)var33.v6 / var25, (var33.v5 + var33.v3) / 256.0F, (float)(var33.v6 + var33.v4) / var25)
            );
         }

         var3 = new class_1043(() -> "syky:icon_atlas", var2);
         var2 = null;
         GpuTexture var32 = var3.method_68004();
         if (var32 != null) {
            GpuTextureView var35 = RenderSystem.getDevice().createTextureView(var32);
            v1.info("icon atlas: packed {} icons into {}x{}", new Object[]{var1.size(), 256, var25});
            uiSupport160 var36 = new uiSupport160(var3, var35, var29);
            var3 = null;
            return var36;
         }

         var34 = null;
      } catch (Throwable var23) {
         v1.debug("icon atlas build failed; drawing icons per-texture", var23);

         for (uiSupport160.Part2 var6 : var1) {
            var6.v2.close();
         }

         return null;
      } finally {
         if (var3 != null) {
            var3.close();
         } else if (var2 != null) {
            var2.close();
         }
      }

      return (uiSupport160)var34;
   }

   private static void v1(List<uiSupport160.Part2> var0) {
      var0.sort(Comparator.<uiSupport160.Part2>comparingInt(var0x -> var0x.v4).reversed());
      int var1 = 2;
      int var2 = 2;
      int var3 = 0;

      for (uiSupport160.Part2 var5 : var0) {
         if (var1 + var5.v3 + 2 > 256) {
            var1 = 2;
            var2 += var3 + 2;
            var3 = 0;
         }

         var5.v5 = var1;
         var5.v6 = var2;
         var1 += var5.v3 + 2;
         var3 = Math.max(var3, var5.v4);
      }
   }

   private static int v2(List<uiSupport160.Part2> var0) {
      int var1 = 0;

      for (uiSupport160.Part2 var3 : var0) {
         var1 = Math.max(var1, var3.v6 + var3.v4);
      }

      return var1 + 2;
   }

   private static int v1(int var0) {
      byte var1 = 1;

      while (var1 < var0) {
         var1 <<= 1;
      }

      return var1;
   }

   private static void v1(class_1011 var0, uiSupport160.Part2 var1) {
      for (int var2 = 0; var2 < var1.v4; var2++) {
         for (int var3 = 0; var3 < var1.v3; var3++) {
            var0.method_61941(var1.v5 + var3, var1.v6 + var2, var1.v2.method_61940(var3, var2));
         }
      }

      var1.v2.close();
   }

   private static void v2(class_1011 var0, uiSupport160.Part2 var1) {
      int var2 = var1.v5;
      int var3 = var1.v6;
      int var4 = var1.v5 + var1.v3 - 1;
      int var5 = var1.v6 + var1.v4 - 1;

      for (int var6 = 1; var6 <= 1; var6++) {
         for (int var7 = 0; var7 < var1.v3; var7++) {
            var0.method_61941(var2 + var7, var3 - var6, var0.method_61940(var2 + var7, var3));
            var0.method_61941(var2 + var7, var5 + var6, var0.method_61940(var2 + var7, var5));
         }

         for (int var8 = 0; var8 < var1.v4; var8++) {
            var0.method_61941(var2 - var6, var3 + var8, var0.method_61940(var2, var3 + var8));
            var0.method_61941(var4 + var6, var3 + var8, var0.method_61940(var4, var3 + var8));
         }

         var0.method_61941(var2 - var6, var3 - var6, var0.method_61940(var2, var3));
         var0.method_61941(var4 + var6, var3 - var6, var0.method_61940(var4, var3));
         var0.method_61941(var2 - var6, var5 + var6, var0.method_61940(var2, var5));
         var0.method_61941(var4 + var6, var5 + var6, var0.method_61940(var4, var5));
      }
   }

   @Override
   public void close() {
      try {
         this.v9.close();
      } catch (Throwable var2) {
      }

      this.v8.close();
   }

   public record Part1(float u0, float v0, float u1, float v1) {
      public float v1() {
         return this.u0;
      }

      public float v2() {
         return this.v0;
      }

      public float v3() {
         return this.u1;
      }

      public float v4() {
         return this.v1;
      }
   }

   public static final class Part2 {
      public final class_2960 v1;
      public final class_1011 v2;
      public final int v3;
      public final int v4;
      public int v5;
      public int v6;

      public Part2(class_2960 var1, class_1011 var2) {
         this.v1 = var1;
         this.v2 = var2;
         this.v3 = var2.method_4307();
         this.v4 = var2.method_4323();
      }
   }
}
