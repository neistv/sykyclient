package cc.syky.render;

import cc.syky.internal.InternalSupport36;
import cc.syky.module.visual.visualSupport9;
import com.mojang.blaze3d.buffers.GpuBuffer;
import com.mojang.blaze3d.buffers.GpuBufferSlice;
import com.mojang.blaze3d.pipeline.RenderPipeline;
import com.mojang.blaze3d.systems.RenderPass;
import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.textures.GpuTextureView;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.OptionalDouble;
import java.util.OptionalInt;
import org.jetbrains.annotations.Nullable;
import org.joml.Matrix4f;
import org.joml.Vector3f;
import org.joml.Vector4f;

public final class AreaItemsSupport {
   private static final int v1 = 6;
   private static final int v2 = 18;
   private static final int v3 = 6;
   private static final int v4 = 0;
   private static final int v5 = 1;
   private static final int v6 = 2;
   private final List<AreaItemsSupport.Part1> v7 = new ArrayList<>();
   private int v8;
   private final Matrix4f v9 = new Matrix4f();
   private final Vector3f v10 = new Vector3f();
   private GpuBufferSlice[] v11 = new GpuBufferSlice[16];
   private boolean v12;
   private boolean v13;
   private boolean v14;
   @Nullable
   private GpuBuffer v15;

   public AreaItemsSupport() {
   }

   public void v1(renderSupport13 var1, InternalSupport36 var2, int var3, int var4, float var5, float var6, double var7, int var9, float var10) {
      boolean var11 = var3 >>> 24 != 0;
      boolean var12 = var4 >>> 24 != 0 && var5 > 0.0F;
      boolean var13 = var9 >>> 24 != 0 && var10 > 0.0F;
      if (!var2.v3() && (var11 || var12 || var13)) {
         if (this.v8 == 0) {
            this.v9.set(var1.v32());
            this.v12 = false;
            this.v13 = false;
            this.v14 = false;
         }

         if (this.v8 == this.v7.size()) {
            this.v7.add(new AreaItemsSupport.Part1());
         }

         AreaItemsSupport.Part1 var14 = this.v7.get(this.v8);
         var14.v1 = var2;
         v1(var3, var14.v2);
         v1(var4, var14.v3);
         v1(var9, var14.v4);
         var14.v6 = var12;
         var14.v7 = var13;
         Vector3f var15 = var1.v34();
         var14.v5.zero().m00(var6).m01(var5).m10(var1.v31()).m11(var15.x).m12(var15.y).m13(var15.z).m20(var10);
         var14.v8.v1 = 0;
         var14.v9.v1 = 0;
         if (var11) {
            v1(var1, var2.v1(), var14.v8, var7);
         }

         if (var12 || var13) {
            v1(var1, var2.v2(), var14.v9, var7);
         }

         if (var14.v8.v1 + var14.v9.v1 > 0) {
            this.v8++;
         } else {
            var14.v1 = null;
         }
      }
   }

   private static void v1(renderSupport13 var0, int[] var1, AreaItemsSupport.Part2 var2, double var3) {
      double var5 = var0.v28();
      double var7 = var0.v29();
      double var9 = var0.v30();
      double var11 = var3 * var3;
      int var13 = 0;

      for (int var14 = var1.length / 7; var13 < var14; var13++) {
         int var15 = var13 * 7;
         int var16 = var1[var15];
         int var17 = var1[var15 + 1];
         int var18 = var1[var15 + 2];
         int var19 = var1[var15 + 3];
         int var20 = var1[var15 + 4];
         int var21 = var1[var15 + 5];
         double var22 = Math.max(0.0, Math.max(var16 - var5, var5 - var19));
         double var24 = Math.max(0.0, Math.max(var17 - var7, var7 - var20));
         double var26 = Math.max(0.0, Math.max(var18 - var9, var9 - var21));
         if (!(var22 * var22 + var24 * var24 + var26 * var26 > var11) && visualSupport9.v1(var16, var17, var18, var19, var20, var21)) {
            var2.v1(var13, (float)(var16 - var5), (float)(var17 - var7), (float)(var18 - var9));
         }
      }
   }

   private static void v1(int var0, Vector4f var1) {
      var1.set((var0 >>> 16 & 0xFF) / 255.0F, (var0 >>> 8 & 0xFF) / 255.0F, (var0 & 0xFF) / 255.0F, (var0 >>> 24) / 255.0F);
   }

   public boolean v1() {
      return this.v8 == 0 || this.v12 && this.v13;
   }

   public void v2() {
      if (!this.v12 && this.v8 > 0) {
         this.v12 = true;
         this.v1("syky:area_fill", SEALSupport2.v1, 0, 6, null);
         this.v1("syky:area_skirt", SEALSupport2.v2, 2, 6, null);
      }
   }

   public void v1(@Nullable renderSupport29 var1) {
      if (!this.v13 && this.v8 > 0) {
         this.v13 = true;
         RenderPipeline var2 = var1 != null ? SEALSupport2.v4 : SEALSupport2.v3;
         this.v1("syky:area_line", var2, 1, 18, var1);
      }
   }

   public boolean v3() {
      if (this.v13) {
         return false;
      } else {
         for (int var1 = 0; var1 < this.v8; var1++) {
            AreaItemsSupport.Part1 var2 = this.v7.get(var1);
            if (var2.v6 && var2.v9.v1 > 0 && var2.v3.w < 1.0F) {
               return true;
            }
         }

         return false;
      }
   }

   public void v4() {
      if (!this.v14 && this.v8 > 0) {
         this.v14 = true;
         this.v1("syky:area_seal", SEALSupport2.v5, 1, 18, null);
      }
   }

   public void v5() {
      this.v14 = true;
   }

   public void v6() {
      for (int var1 = 0; var1 < this.v8; var1++) {
         this.v7.get(var1).v1 = null;
      }

      this.v8 = 0;
   }

   public void v7() {
      this.v6();
      if (this.v15 != null) {
         this.v15.close();
         this.v15 = null;
      }
   }

   private static boolean v1(AreaItemsSupport.Part1 var0, int var1) {
      return var1 == 0 || (var1 == 1 ? var0.v6 : var0.v7);
   }

   private void v1(String var1, RenderPipeline var2, int var3, int var4, @Nullable renderSupport29 var5) {
      boolean var6 = var3 == 0;
      int var7 = 0;

      for (int var8 = 0; var8 < this.v8; var8++) {
         AreaItemsSupport.Part1 var9 = this.v7.get(var8);
         if (v1(var9, var3)) {
            AreaItemsSupport.Part2 var10 = var6 ? var9.v8 : var9.v9;
            Vector4f var11 = var6 ? var9.v2 : (var3 == 1 ? var9.v3 : var9.v4);

            for (int var12 = 0; var12 < var10.v1; var12++) {
               if (var7 == this.v11.length) {
                  this.v11 = Arrays.copyOf(this.v11, var7 * 2);
               }

               this.v10.set(var10.v3[var12 * 3], var10.v3[var12 * 3 + 1], var10.v3[var12 * 3 + 2]);
               this.v11[var7++] = RenderSystem.getDynamicUniforms().method_71106(this.v9, var11, this.v10, var9.v5);
            }
         }
      }

      if (var7 != 0) {
         GpuTextureView var22 = var5 != null ? var5.v2() : renderSupport14.v1();
         GpuTextureView var23 = var5 != null ? var5.v3() : renderSupport14.v2();
         if (var22 != null) {
            GpuBuffer var24 = this.v15;
            if (var24 == null) {
               var24 = renderSupport31.v1("syky:area_dummy_vertex");
               this.v15 = var24;
            }

            int var25 = 0;
            RenderPass var26 = RenderSystem.getDevice()
               .createCommandEncoder()
               .createRenderPass(() -> var1, var22, OptionalInt.empty(), var23, OptionalDouble.empty());

            try {
               var26.setPipeline(var2);
               if (var5 != null) {
                  var5.v1(var26);
               }

               var26.setUniform("Projection", RenderSystem.getProjectionMatrixBuffer());
               var26.setVertexBuffer(0, var24);

               for (int var13 = 0; var13 < this.v8; var13++) {
                  AreaItemsSupport.Part1 var14 = this.v7.get(var13);
                  if (v1(var14, var3)) {
                     InternalSupport36 var15 = var14.v1;
                     AreaItemsSupport.Part2 var16 = var6 ? var14.v8 : var14.v9;
                     if (var15 == null) {
                        var25 += var16.v1;
                     } else {
                        int[] var17 = var6 ? var15.v1() : var15.v2();

                        for (int var18 = 0; var18 < var16.v1; var25++) {
                           int var19 = var16.v2[var18];
                           if (!var15.v3()) {
                              var26.setUniform("DynamicTransforms", this.v11[var25]);
                              var26.setUniform("AreaItems", var6 ? var15.v1(var19) : var15.v2(var19));
                              var26.draw(0, var17[var19 * 7 + 6] * var4);
                           }

                           var18++;
                        }
                     }
                  }
               }
            } catch (Throwable var21) {
               if (var26 != null) {
                  try {
                     var26.close();
                  } catch (Throwable var20) {
                     var21.addSuppressed(var20);
                  }
               }

               throw var21;
            }

            if (var26 != null) {
               var26.close();
            }

            Arrays.fill(this.v11, 0, var7, null);
         }
      }
   }

   public static final class Part1 {
      @Nullable
      public InternalSupport36 v1;
      public final Vector4f v2 = new Vector4f();
      public final Vector4f v3 = new Vector4f();
      public final Vector4f v4 = new Vector4f();
      public final Matrix4f v5 = new Matrix4f();
      public boolean v6;
      public boolean v7;
      public final AreaItemsSupport.Part2 v8 = new AreaItemsSupport.Part2();
      public final AreaItemsSupport.Part2 v9 = new AreaItemsSupport.Part2();

      public Part1() {
      }
   }

   public static final class Part2 {
      public int v1;
      public int[] v2 = new int[8];
      public float[] v3 = new float[24];

      public Part2() {
      }

      public void v1(int var1, float var2, float var3, float var4) {
         if (this.v1 == this.v2.length) {
            this.v2 = Arrays.copyOf(this.v2, this.v1 * 2);
            this.v3 = Arrays.copyOf(this.v3, this.v1 * 6);
         }

         this.v2[this.v1] = var1;
         this.v3[this.v1 * 3] = var2;
         this.v3[this.v1 * 3 + 1] = var3;
         this.v3[this.v1 * 3 + 2] = var4;
         this.v1++;
      }
   }
}
