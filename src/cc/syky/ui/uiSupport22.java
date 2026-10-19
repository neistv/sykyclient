package cc.syky.ui;

import cc.syky.hud.hudSupport60;
import java.util.function.BiPredicate;
import org.jetbrains.annotations.Nullable;

public final class uiSupport22<T> {
   private final float v1;
   @Nullable
   private T v2;
   @Nullable
   private T v3;
   private float v4;
   private long v5;
   private float v6 = 1.0F;

   public uiSupport22(float var1) {
      this.v1 = Math.max(1.0F, var1);
   }

   public void v1(T var1, long var2, BiPredicate<T, T> var4) {
      Object var5 = this.v2;
      this.v2 = (T)var1;
      if (var5 != null && !var4.test(var5, var1)) {
         float var8 = this.v2();
         float var7 = this.v3();
         if (this.v3 != null && !(var8 >= var7)) {
            this.v4 = var7;
         } else {
            this.v3 = (T)var5;
            this.v4 = var8;
         }

         this.v5 = var2;
         this.v6 = 0.0F;
      } else if (this.v3 != null) {
         float var6 = (float)(var2 - this.v5) / 1000000.0F / this.v1;
         if (var6 >= 1.0F) {
            this.v3 = null;
            this.v6 = 1.0F;
         } else {
            this.v6 = Math.max(0.0F, var6);
         }
      }
   }

   @Nullable
   public T v1() {
      return this.v3;
   }

   public float v2() {
      return this.v3 == null ? 1.0F : hudSupport60.v1(this.v6);
   }

   public float v3() {
      return this.v3 == null ? 0.0F : this.v4 * (1.0F - hudSupport60.v1(this.v6));
   }

   public float v4() {
      return this.v3 == null ? 1.0F : hudSupport60.v1(this.v6);
   }

   public void v5() {
      this.v2 = null;
      this.v3 = null;
      this.v4 = 0.0F;
      this.v5 = 0L;
      this.v6 = 1.0F;
   }
}
