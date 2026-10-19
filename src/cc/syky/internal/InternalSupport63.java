package cc.syky.internal;

import cc.syky.ui.uiSupport255;
import org.joml.Matrix4f;
import org.joml.Matrix4fc;

public final class InternalSupport63 {
   private final Matrix4f[] v1;

   public InternalSupport63(int var1) {
      this.v1 = new Matrix4f[var1];

      for (int var2 = 0; var2 < var1; var2++) {
         this.v1[var2] = new Matrix4f();
      }
   }

   public void v1(uiSupport255 var1, float[] var2, float[] var3, float[] var4) {
      for (int var5 = 0; var5 < var1.v1(); var5++) {
         int var6 = var5 * 3;
         float var7 = var1.v1(var5, 0);
         float var8 = var1.v1(var5, 1);
         float var9 = var1.v1(var5, 2);
         Matrix4f var10 = this.v1[var5];
         int var11 = var1.v2(var5);
         if (var11 >= 0) {
            var10.set(this.v1[var11]);
         } else {
            var10.identity();
         }

         var10.translate(var7 + var3[var6], var8 + var3[var6 + 1], var9 + var3[var6 + 2])
            .rotateZYX(var1.v2(var5, 2) + var2[var6 + 2], var1.v2(var5, 1) + var2[var6 + 1], var1.v2(var5, 0) + var2[var6])
            .scale(var4[var6], var4[var6 + 1], var4[var6 + 2])
            .translate(-var7, -var8, -var9);
      }
   }

   public Matrix4fc v1(int var1) {
      return this.v1[var1];
   }

   public int v1() {
      return this.v1.length;
   }
}
