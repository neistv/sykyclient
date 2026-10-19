package cc.syky.ui;

import cc.syky.hud.hudSupport67;
import cc.syky.module.utilities.EndCrystalSupport;
import com.mojang.blaze3d.textures.GpuTextureView;
import java.util.concurrent.atomic.AtomicInteger;
import org.jetbrains.annotations.Nullable;

public final class uiSupport62 {
   private static final String v1 = "clickgui-row-emblem";
   private static final int v2 = 2;
   private static final int v3 = 1;
   private static final int v4 = 2048;
   private static final int v5 = 8;
   private static final AtomicInteger v6 = new AtomicInteger();
   @Nullable
   private static GpuTextureView v7;
   private static int v8;
   private static int v9;
   private static int v10 = -1;
   private static boolean v11;
   private final EndCrystalSupport v12;

   private uiSupport62(EndCrystalSupport var1) {
      this.v12 = var1;
   }

   @Nullable
   public static uiSupport62 v1(String var0) {
      EndCrystalSupport var1 = EndCrystalSupport.v1(var0);
      if (var1 == null) {
         return null;
      } else {
         v11 = true;
         return new uiSupport62(var1);
      }
   }

   public static void v1() {
      v6.incrementAndGet();
   }

   public static void v1(float var0) {
      if (v11) {
         int var1 = EndCrystalSupport.COUNT;
         int var2 = v2(var0);
         int var3 = var2 + 2;
         int var4 = var3 * var1 * 2 <= 2048 ? 2 : 1;
         int var5 = var3 * var4;
         int var6 = v6.get();
         boolean var7 = v7 == null || var2 != v8 || var4 != v9 || var6 != v10;
         float var8 = (float)var2 * var4;
         float var9 = var5 * 0.5F;
         GpuTextureView var10 = uiSupport169.v1("clickgui-row-emblem", var5 * var1, var5, var7, (var4x, var5x) -> {
            for (int var6x = 0; var6x < var1; var6x++) {
               EndCrystalSupport var7x = EndCrystalSupport.VALUES.get(var6x);
               hudSupport67.v1(var5x, var7x.v1(EndCrystalSupport.v2(0)), (var6x + 0.5F) * var5, var9, var8);
            }
         });
         v7 = var10;
         if (var10 != null) {
            v8 = var2;
            v9 = var4;
            v10 = var6;
         }
      }
   }

   private static int v2(float var0) {
      float var1 = uiSupport169.v2();
      float var2 = 20.0F * var0 / (var1 > 0.0F ? var1 : 1.0F);
      return Math.max(8, Math.round(var2));
   }

   public void v1(float var1, float var2, float var3, float var4, float var5) {
      GpuTextureView var6 = v7;
      if (var6 != null && v8 > 0 && !(var5 <= 0.004F)) {
         int var7 = EndCrystalSupport.COUNT;
         int var8 = (v8 + 2) * v9;
         int var9 = 1 * v9;
         int var10 = var8 * var7;
         int var11 = this.v12.v3();
         float var12 = (float)(var11 * var8 + var9) / var10;
         float var13 = (float)((var11 + 1) * var8 - var9) / var10;
         float var14 = (float)var9 / var8;
         float var15 = uiSupport169.v1(var1);
         float var16 = uiSupport169.v1(var1 + 20.0F * var4) - var15;
         float var17 = uiSupport126.v1(var2, var3, var16, SignInSupport.v4(47.0F, var4));
         uiSupport169.v1(var6, var15, var17, var16, var16, var12, 1.0F - var14, var13, var14, v3(var5));
      }
   }

   private static int v3(float var0) {
      int var1 = Math.round(255.0F * Math.min(1.0F, var0));
      return var1 << 24 | var1 << 16 | var1 << 8 | var1;
   }
}
