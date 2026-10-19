package cc.syky.hud;

import cc.syky.account.accountSupport11;
import cc.syky.cloud.cloudSupport101;
import cc.syky.render.renderSupport35;
import cc.syky.render.renderSupport38;
import cc.syky.render.renderSupport47;
import com.mojang.blaze3d.systems.CommandEncoder;
import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.textures.GpuTexture;
import com.mojang.blaze3d.textures.GpuTextureView;
import java.util.HashMap;
import java.util.Map;
import net.minecraft.class_10366;
import net.minecraft.class_11278;
import net.minecraft.class_310;
import net.minecraft.class_4597;
import net.minecraft.class_9799;
import net.minecraft.class_4597.class_4598;
import org.jetbrains.annotations.Nullable;
import org.joml.Matrix4fStack;

public final class hudSupport69 implements AutoCloseable {
   private static final int v1 = 2048;
   private final cloudSupport101 v2;
   @Nullable
   private class_11278 v3;
   @Nullable
   private class_9799 v4;
   @Nullable
   private class_4598 v5;
   private final Map<String, renderSupport35> v6 = new HashMap<>();
   private final accountSupport11 v7;
   private int v8;
   private int v9;
   private int v10;

   public hudSupport69(cloudSupport101 var1, accountSupport11 var2) {
      this.v2 = var1;
      this.v7 = var2;
   }

   @Nullable
   public GpuTextureView v1(String var1, int var2, int var3, boolean var4, hudSupport69.Part1 var5) {
      class_310 var6 = this.v2.v1();
      if (var6 != null && var2 > 0 && var3 > 0 && var2 <= 2048 && var3 <= 2048) {
         int var7 = this.v7.v1("gpu.gui.capture");

         GpuTextureView var8;
         try {
            var8 = this.v1(var6, var1, var2, var3, var4, var5);
         } finally {
            this.v7.v1(var7);
         }

         return var8;
      } else {
         return null;
      }
   }

   public boolean v1(String var1, int var2, int var3) {
      renderSupport35 var4 = this.v6.get(var1);
      return var4 != null && var4.v1(var2, var3);
   }

   @Nullable
   public GpuTextureView v1(String var1, int var2, int var3, int[] var4, int var5, hudSupport69.Part1 var6) {
      class_310 var7 = this.v2.v1();
      renderSupport35 var8 = this.v6.get(var1);
      if (var7 != null && var8 != null && var8.v1(var2, var3)) {
         int var9 = this.v7.v1("gpu.gui.capture");

         GpuTextureView var21;
         try {
            this.v5();
            this.v10++;
            CommandEncoder var10 = RenderSystem.getDevice().createCommandEncoder();
            GpuTexture var11 = var8.v2();
            GpuTexture var12 = var8.v3();
            var10.clearDepthTexture(var12, 0.0);

            for (int var13 = 0; var13 < var5; var13++) {
               int var14 = var4[4 * var13];
               int var15 = var4[4 * var13 + 1];
               int var16 = var4[4 * var13 + 2];
               int var17 = var4[4 * var13 + 3];
               var10.clearColorAndDepthTextures(var11, 0, var12, 1.0, var14, var3 - var15 - var17, var16, var17);
            }

            this.v2(var8, var2, var3, var7, var6);
            var21 = var8.v4();
         } finally {
            this.v7.v1(var9);
         }

         return var21;
      } else {
         return null;
      }
   }

   @Nullable
   private GpuTextureView v1(class_310 var1, String var2, int var3, int var4, boolean var5, hudSupport69.Part1 var6) {
      this.v5();
      renderSupport35 var7 = this.v6.get(var2);
      if (var7 == null) {
         var7 = new renderSupport35("syky:gui_capture", 14, 8);
         this.v6.put(var2, var7);
      }

      boolean var8 = var7.v2(var3, var4);
      if (!var5 && !var8) {
         this.v9++;
      } else {
         this.v8++;
         this.v1(var7, var3, var4, var1, var6);
      }

      return var7.v4();
   }

   public int v1() {
      return this.v8;
   }

   public int v2() {
      return this.v9;
   }

   public int v3() {
      return this.v10;
   }

   public void v4() {
      this.v8 = 0;
      this.v9 = 0;
      this.v10 = 0;
   }

   private void v1(renderSupport35 var1, int var2, int var3, class_310 var4, hudSupport69.Part1 var5) {
      var1.v1();
      this.v2(var1, var2, var3, var4, var5);
   }

   private void v2(renderSupport35 var1, int var2, int var3, class_310 var4, hudSupport69.Part1 var5) {
      GpuTextureView var6 = renderSupport38.v1();
      GpuTextureView var7 = renderSupport38.v2();
      Matrix4fStack var8 = RenderSystem.getModelViewStack();
      boolean var9 = false;
      boolean var10 = false;

      try {
         RenderSystem.backupProjectionMatrix();
         var9 = true;
         var8.pushMatrix();
         var10 = true;
         var8.identity();
         renderSupport38.v1(var1.v4());
         renderSupport38.v2(var1.v5());
         RenderSystem.setProjectionMatrix(renderSupport47.v1(this.v3).method_71092(var2, var3), class_10366.field_54954);
         var5.draw(renderSupport47.v1(this.v5), var4);
         hudSupport67.v1(var4);
         renderSupport47.v1(this.v5).method_22993();
      } finally {
         hudSupport67.v6();
         renderSupport38.v1(var6);
         renderSupport38.v2(var7);
         if (var9) {
            RenderSystem.restoreProjectionMatrix();
         }

         if (var10) {
            var8.popMatrix();
         }
      }
   }

   private void v5() {
      if (this.v4 == null) {
         this.v4 = new class_9799(65536);
         this.v5 = class_4597.method_22991(this.v4);
         this.v3 = new class_11278("syky_gui_capture", -1000.0F, 1000.0F, true);
      }
   }

   @Override
   public void close() {
      for (renderSupport35 var2 : this.v6.values()) {
         var2.v6();
      }

      this.v6.clear();
      if (this.v3 != null) {
         this.v3.close();
         this.v3 = null;
      }

      this.v5 = null;
      if (this.v4 != null) {
         this.v4.close();
         this.v4 = null;
      }
   }

   @FunctionalInterface
   public interface Part1 {
      void draw(class_4598 var1, class_310 var2);
   }
}
