package cc.syky.cloud;

import cc.syky.render.font.FontData;

public final class cloudSupport28 {
   public final int v1;
   public final float v2;
   public final float v3;
   public final float v4;
   public final float v5;
   public final float v6;
   public final float v7;
   public final float v8;
   public final float v9;
   public final float v10;
   public final boolean v11;

   public cloudSupport28(FontData.GlyphData var1, float var2, float var3) {
      this.v1 = var1.unicode;
      this.v2 = var1.advance;
      if (var1.atlasBounds != null) {
         this.v3 = var1.atlasBounds.left / var2;
         this.v4 = var1.atlasBounds.right / var2;
         this.v5 = 1.0F - var1.atlasBounds.top / var3;
         this.v6 = 1.0F - var1.atlasBounds.bottom / var3;
      } else {
         this.v3 = this.v4 = this.v5 = this.v6 = 0.0F;
      }

      if (var1.planeBounds != null) {
         this.v7 = var1.planeBounds.left;
         this.v8 = var1.planeBounds.bottom;
         this.v9 = var1.planeBounds.right;
         this.v10 = var1.planeBounds.top;
         this.v11 = true;
      } else {
         this.v7 = this.v8 = this.v9 = this.v10 = 0.0F;
         this.v11 = false;
      }
   }

   public float v1() {
      return this.v9 - this.v7;
   }

   public float v2() {
      return this.v10 - this.v8;
   }
}
