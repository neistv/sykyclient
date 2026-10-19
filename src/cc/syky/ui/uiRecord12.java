package cc.syky.ui;

import cc.syky.cloud.cloudSupport36;
import org.jetbrains.annotations.Nullable;

public record uiRecord12(int texture, cloudSupport36 surface, @Nullable uiRecord13 fx, int tint, int fxTexture) {
   public uiRecord12(int texture, cloudSupport36 surface, @Nullable uiRecord13 fx, int tint, int fxTexture) {
      if (texture < -1 || fxTexture < -1) {
         throw new IllegalArgumentException("texture index " + texture + "/" + fxTexture);
      } else if (surface == cloudSupport36.NONE && fx == null) {
         throw new IllegalArgumentException("a material with no surface and no effect draws nothing");
      } else {
         this.texture = texture;
         this.surface = surface;
         this.fx = fx;
         this.tint = tint;
         this.fxTexture = fxTexture;
      }
   }

   public boolean v1() {
      return this.surface != cloudSupport36.NONE;
   }

   public int v2() {
      return this.fxTexture >= 0 ? this.fxTexture : this.texture;
   }

   public int v3() {
      return this.texture;
   }

   public cloudSupport36 v4() {
      return this.surface;
   }

   @Nullable
   public uiRecord13 v5() {
      return this.fx;
   }

   public int v6() {
      return this.tint;
   }

   public int v7() {
      return this.fxTexture;
   }
}
