package cc.syky.internal;

import cc.syky.ui.uiRecord13;
import com.mojang.blaze3d.systems.GpuDevice;
import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.textures.FilterMode;
import com.mojang.blaze3d.textures.TextureFormat;
import java.util.BitSet;
import net.minecraft.class_1011;
import net.minecraft.class_1044;
import net.minecraft.class_2960;
import net.minecraft.class_310;

public final class InternalSupport40 extends class_1044 {
   public static final class_2960 v1 = class_2960.method_60655("syky", "cosmetics/palette");
   public static final int v2 = 4;
   public static final int v3 = 1024;
   private final BitSet v4 = new BitSet(1024);
   private boolean v5;

   public InternalSupport40() {
      GpuDevice var1 = RenderSystem.getDevice();
      this.field_56974 = var1.createTexture(v1::toString, 13, TextureFormat.RGBA8, 4, 1024, 1, 1);
      this.field_60597 = var1.createTextureView(this.field_56974);
      this.field_63613 = RenderSystem.getSamplerCache().method_76520(FilterMode.NEAREST, false);
      var1.createCommandEncoder().clearColorTexture(this.field_56974, 0);
   }

   public void v1() {
      if (!this.v5) {
         class_310.method_1551().method_1531().method_4616(v1, this);
         this.v5 = true;
      }
   }

   public int v1(uiRecord13 var1) {
      int var2 = this.v4.nextClearBit(0);
      if (var2 >= 1024) {
         return -1;
      } else {
         this.v4.set(var2);
         class_1011 var3 = new class_1011(4, 1, false);

         try {
            var3.method_61941(0, 0, v1(var1.v1().v2(), var1.v2()));
            var3.method_61941(1, 0, v1(v1(var1.v4() / 4.0F), var1.v3()));
            int var4 = v1((var1.v5() + 8.0F) / 16.0F);
            int var5 = v1(((float)(Math.log(var1.v6()) / Math.log(2.0)) + 3.0F) / 8.0F);
            var3.method_61941(2, 0, v1(0, var4 << 16 | var5 << 8));
            var3.method_61941(3, 0, 0);
            RenderSystem.getDevice().createCommandEncoder().writeToTexture(this.field_56974, var3, 0, 0, 0, var2, 4, 1, 0, 0);
         } catch (Throwable var7) {
            try {
               var3.close();
            } catch (Throwable var6) {
               var7.addSuppressed(var6);
            }

            throw var7;
         }

         var3.close();
         return var2;
      }
   }

   public void v1(int var1) {
      if (var1 >= 0) {
         this.v4.clear(var1);
      }
   }

   private static int v1(float var0) {
      return Math.round(Math.min(1.0F, Math.max(0.0F, var0)) * 255.0F);
   }

   private static int v1(int var0, int var1) {
      return (var0 & 0xFF) << 24 | var1 & 16777215;
   }
}
