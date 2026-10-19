package cc.syky.render;

import com.mojang.blaze3d.pipeline.RenderPipeline;
import com.mojang.blaze3d.textures.GpuTextureView;
import org.jetbrains.annotations.Nullable;

public final class renderSupport40 {
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
   public boolean v12;
   public int v13;
   public int v14;
   public int v15;

   public renderSupport40() {
   }

   public void v1(renderSupport41 var1, int var2, int var3, boolean var4, int var5) {
      this.v1 = var1.v1;
      this.v2 = var1.v2;
      this.v3 = var2;
      this.v4 = var3;
      this.v5 = var1.v5;
      this.v6 = var1.v6;
      this.v7 = var1.v7;
      this.v8 = var1.v8;
      this.v9 = var1.v9;
      this.v10 = var1.v10;
      this.v11 = var1.v11;
      this.v12 = var4;
      this.v13 = var5;
      this.v14 = var1.v12;
      this.v15 = var1.v13;
   }

   public void v1() {
      this.v1 = null;
      this.v2 = null;
      this.v5 = null;
      this.v6 = null;
   }
}
