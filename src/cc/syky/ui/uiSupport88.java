package cc.syky.ui;

import cc.syky.hud.hudSupport;
import cc.syky.hud.hudSupport2;
import cc.syky.hud.hudSupport3;
import net.minecraft.class_1041;
import net.minecraft.class_310;
import org.jetbrains.annotations.Nullable;

public final class uiSupport88<T extends UiNode> {
   @Nullable
   private T v1;
   private final uiSupport91 v2 = new uiSupport91();
   private float v3;
   private float v4;
   private boolean v5;
   private boolean v6;
   private final uiSupport137 v7 = new uiSupport137();
   private final hudSupport3 v8 = new hudSupport3();
   private final float[] v9 = new float[4];
   private float v10 = Float.NaN;
   private float v11 = Float.NaN;
   private float v12 = Float.NaN;

   public uiSupport88() {
   }

   @Nullable
   public T v1() {
      return this.v1;
   }

   @Nullable
   public T v2() {
      return this.v2.v5() ? null : this.v1;
   }

   public float v3() {
      return this.v3;
   }

   public float v4() {
      return this.v4;
   }

   public void v1(float var1) {
      this.v4 = var1;
   }

   public boolean v5() {
      return this.v5;
   }

   public boolean v6() {
      return this.v7.v2();
   }

   public boolean v7() {
      return this.v6;
   }

   public float v2(float var1) {
      return this.v5 ? 0.0F : var1;
   }

   public float v3(float var1) {
      return this.v5 ? 0.0F : var1;
   }

   public void v1(T var1, float var2, float var3, float var4, float var5, float var6) {
      this.v2((T)var1, (var1.v9 - var2) / var4, (var1.v10 - var3) / var4, false);
      this.v2.v1(var1, var5, var6);
   }

   public void v1(T var1, float var2, float var3, boolean var4) {
      this.v2((T)var1, var2, var3, var4);
      this.v2.v1();
   }

   private void v2(T var1, float var2, float var3, boolean var4) {
      this.v1 = (T)var1;
      this.v3 = var2;
      this.v4 = var3;
      this.v5 = var4;
      this.v6 = false;
      this.v8.v3();
      this.v10 = Float.NaN;
      this.v11 = Float.NaN;
   }

   public void v8() {
      this.v7.v7();
      this.v2.v2();
   }

   public boolean v9() {
      return this.v2.v6();
   }

   public void v10() {
      this.v1 = null;
      this.v5 = false;
      this.v6 = false;
      this.v8.v3();
   }

   public void v1(T var1, float var2, float var3) {
      this.v6 = true;
      this.v7.v7();
      if (hudSupport.v1()) {
         this.v8.v1(var1.v9, var1.v10, var1.v11, var1.v12, var2, var3);
      }
   }

   public boolean v1(float var1, float var2, float var3, float var4, float var5) {
      UiNode var6 = this.v1;
      if (!this.v6 || var6 == null || var5 <= 0.0F) {
         return false;
      } else if (var1 == 0.0F && var2 == 0.0F) {
         return false;
      } else {
         boolean var7 = !this.v5;
         if (var7) {
            this.v3 += var3 / var5;
            this.v4 += var4 / var5;
            this.v5 = true;
         }

         class_1041 var8 = class_310.method_1551().method_22683();
         uiSupport137.Part1 var9 = this.v7
            .v1(var6.v9, var6.v10, var6.v11, v1(var6, var5), v2(var6, var5), var8.method_4486(), var8.method_4502(), var5, var1, var2);
         this.v3 = this.v3 + var9.v1() / var5;
         this.v4 = this.v4 + var9.v2() / var5;
         return var7;
      }
   }

   public void v4(float var1) {
      if (this.v6) {
         this.v6 = false;
         UiNode var2 = this.v1;
         if (var2 != null && var1 > 0.0F) {
            class_1041 var3 = class_310.method_1551().method_22683();
            this.v7.v1(var2.v9, var2.v10, var2.v11, v1(var2, var1), v2(var2, var1), var3.method_4486(), var3.method_4502(), var1);
         }

         this.v8.v1();
      }
   }

   public void v1(float var1, boolean var2) {
      UiNode var3 = this.v1;
      if (var3 != null && !this.v6 && var2 && !(var1 <= 0.0F) && var1 == this.v12 && !this.v7.v2()) {
         class_1041 var4 = class_310.method_1551().method_22683();
         this.v7.v1(var3.v9, var3.v10, var3.v11, v1(var3, var1), v2(var3, var1), var4.method_4486(), var4.method_4502(), var1);
      }
   }

   public void v1(float var1, float var2, float var3) {
      if (this.v1 != null && !this.v6 && !(var3 <= 0.0F) && this.v7.v1()) {
         this.v3 = (this.v7.v3() - this.v2(var1)) / var3;
         this.v4 = (this.v7.v4() - this.v3(var2)) / var3;
      }
   }

   private static float v1(UiNode var0, float var1) {
      return var0 instanceof UiScreen var2 ? var2.v3(624.0F) * var1 : var0.v12;
   }

   private static float v2(UiNode var0, float var1) {
      return (var0 instanceof UiScreen var2 ? var2.v9() : 52.0F) * var1;
   }

   public void v1(float var1, float var2, boolean var3, float var4, float var5, float var6, float var7) {
      boolean var8 = var7 == this.v12;
      this.v12 = var7;
      if (var8 && (var2 != this.v11 || var3 && var1 != this.v10)) {
         this.v10 = var1;
         this.v11 = var2;
         if (!(var7 <= 0.0F)) {
            class_1041 var9 = class_310.method_1551().method_22683();
            if (var3) {
               float var10 = this.v2(var5) + this.v3 * var7;
               this.v3 = this.v3 + (uiSupport89.v1(var10, var1, var4, var9.method_4486()) - var10) / var7;
            }

            float var11 = this.v3(var6) + this.v4 * var7;
            this.v4 = this.v4 + (uiSupport89.v1(var11, var2, 0.0F, var9.method_4502()) - var11) / var7;
         }
      }
   }

   public float v5(float var1) {
      float var2 = this.v7.v5();
      return SignInSupport.v4(this.v3 - var2 / var1, var1) + var2;
   }

   public float v6(float var1) {
      float var2 = this.v7.v6();
      return SignInSupport.v4(this.v4 - var2 / var1, var1) + var2;
   }

   public void v11() {
      UiNode var1 = this.v1;
      if (var1 != null && (this.v5 || this.v6) && hudSupport.v1()) {
         this.v8.v1(var1.v9, var1.v10, var1.v11, var1.v12, hudSupport.v3());
      } else {
         this.v8.v3();
      }
   }

   public boolean v1(uiSupport35 var1, float var2) {
      UiNode var3 = this.v1;
      if (var3 != null && !this.v5) {
         this.v2.v4();
         if (this.v2.v6()) {
            return false;
         } else {
            this.v3((T)var3, var2);
            uiSupport169.v1(this.v9[0], this.v9[1], this.v9[2], this.v9[3]);

            try {
               boolean var4 = this.v2.v1(var3, var2);

               try {
                  var3.v1(var1);
               } finally {
                  if (var4) {
                     this.v2.v7();
                  }
               }
            } finally {
               uiSupport169.v4();
            }

            return true;
         }
      } else {
         return true;
      }
   }

   public boolean v1(uiSupport35 var1, float var2, float var3, float var4, float var5, float var6) {
      UiNode var7 = this.v1;
      if (var7 != null && this.v5) {
         float var8 = this.v2.v4() * var3;
         if (this.v2.v6()) {
            return false;
         } else if (var8 <= 0.0F) {
            return true;
         } else {
            this.v3((T)var7, var2);
            boolean var9 = hudSupport2.v1(this.v8, var7.v9, var7.v10, var7.v11, var7.v12, var2, this.v9[0], this.v9[1], this.v9[2], this.v9[3]);

            try {
               boolean var10 = this.v2.v1(var7, var2, var3, var4, var5, var6);

               try {
                  uiSupport169.v3();

                  try {
                     var7.v1(var1);
                  } finally {
                     uiSupport169.v4();
                  }
               } finally {
                  if (var10) {
                     this.v2.v7();
                  }
               }
            } finally {
               if (var9) {
                  hudSupport2.v1();
               }
            }

            return true;
         }
      } else {
         return true;
      }
   }

   private void v3(T var1, float var2) {
      float var3 = hudSupport2.v1(var2);
      this.v9[0] = var1.v9 - var3;
      this.v9[1] = var1.v10 - var3;
      this.v9[2] = var1.v9 + var1.v11 + var3 - this.v9[0];
      this.v9[3] = var1.v10 + var1.v12 + var3 - this.v9[1];
      UiNode var4 = var1 instanceof UiScreen var5 ? var5.v13() : null;

      while (var4 != null) {
         float var10 = Math.min(this.v9[0], var4.v9 - var3);
         float var6 = Math.min(this.v9[1], var4.v10 - var3);
         float var7 = Math.max(this.v9[0] + this.v9[2], var4.v9 + var4.v11 + var3);
         float var8 = Math.max(this.v9[1] + this.v9[3], var4.v10 + var4.v12 + var3);
         this.v9[0] = var10;
         this.v9[1] = var6;
         this.v9[2] = var7 - var10;
         this.v9[3] = var8 - var6;
         var4 = var4 instanceof UiScreen var9 ? var9.v13() : null;
      }
   }

   public boolean v12() {
      return this.v1 != null && this.v5;
   }
}
