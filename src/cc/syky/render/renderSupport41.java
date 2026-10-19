package cc.syky.render;

import com.mojang.blaze3d.pipeline.RenderPipeline;
import com.mojang.blaze3d.textures.GpuTextureView;
import java.util.Objects;
import org.jetbrains.annotations.Nullable;

public final class renderSupport41 {
   @Nullable
   public RenderPipeline v1;
   @Nullable
   public String v2;
   public int v3;
   public int v4;
   @Nullable
   public GpuTextureView v5;
   @Nullable
   public GpuTextureView v6;
   public boolean v7;
   public int v8;
   public int v9;
   public int v10;
   public int v11;
   public int v12;
   public int v13;
   public int v14;
   public int v15;
   public int v16;

   public renderSupport41() {
   }

   public void v1(
      RenderPipeline var1,
      String var2,
      int var3,
      int var4,
      @Nullable GpuTextureView var5,
      @Nullable GpuTextureView var6,
      boolean var7,
      int var8,
      int var9,
      int var10,
      int var11,
      int var12,
      int var13,
      int var14,
      int var15
   ) {
      this.v1 = var1;
      this.v2 = var2;
      this.v3 = var3;
      this.v4 = var4;
      this.v5 = var5;
      this.v6 = var6;
      this.v7 = var7;
      this.v8 = var8;
      this.v9 = var9;
      this.v10 = var10;
      this.v11 = var11;
      this.v12 = var12;
      this.v13 = var13;
      this.v14 = var14;
      this.v15 = var15;
   }

   public void v1(renderSupport41 var1) {
      this.v1 = var1.v1;
      this.v2 = var1.v2;
      this.v3 = var1.v3;
      this.v4 = var1.v4;
      this.v5 = var1.v5;
      this.v6 = var1.v6;
      this.v7 = var1.v7;
      this.v8 = var1.v8;
      this.v9 = var1.v9;
      this.v10 = var1.v10;
      this.v11 = var1.v11;
      this.v12 = var1.v12;
      this.v13 = var1.v13;
      this.v14 = var1.v14;
      this.v15 = var1.v15;
      this.v16 = var1.v16;
   }

   public boolean v2(renderSupport41 var1) {
      return this.v1 == var1.v1
         && Objects.equals(this.v2, var1.v2)
         && this.v3 == var1.v3
         && this.v4 == var1.v4
         && this.v5 == var1.v5
         && this.v6 == var1.v6
         && this.v7 == var1.v7
         && this.v8 == var1.v8
         && this.v9 == var1.v9
         && this.v10 == var1.v10
         && this.v11 == var1.v11
         && this.v12 == var1.v12
         && this.v13 == var1.v13
         && this.v14 == var1.v14
         && this.v15 == var1.v15
         && this.v16 == var1.v16;
   }

   public void v1() {
      this.v1 = null;
      this.v2 = null;
      this.v5 = null;
      this.v6 = null;
      this.v16 = 0;
   }
}
