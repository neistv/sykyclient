package cc.syky.ui;

import cc.syky.hud.hudSupport54;
import cc.syky.render.font.MsdfFont;
import java.util.function.DoubleConsumer;
import java.util.function.DoubleSupplier;
import org.jetbrains.annotations.Nullable;

public final class uiSupport64 {
   private static final int v1 = 14;
   private static final float v2 = 10.0F;
   private static final float v3 = 1.0F;
   private static final int v4 = 452984831;
   private static final int v5 = 184549375;
   private static final int v6 = 1090519039;
   private final DoubleSupplier v7;
   private final DoubleConsumer v8;
   private final double v9;
   private final double v10;
   private final boolean v11;
   private final uiSupport64.Part1 v12;
   private final float v13;
   private final MsdfFont v14;
   private double v15 = Double.NaN;
   private boolean v16;
   private float v18;
   private float v19;
   private float v17;
   private float v20;
   private float v21 = 1.0F;
   private float v22;

   public uiSupport64(DoubleSupplier var1, DoubleConsumer var2, double var3, double var5, boolean var7, uiSupport64.Part1 var8, float var9) {
      this.v7 = var1;
      this.v8 = var2;
      this.v9 = var3;
      this.v10 = var5;
      this.v11 = var7;
      this.v12 = var8;
      this.v13 = var9;
      this.v14 = new MsdfFont("syky_sans_strong", 14, this::v1);
   }

   public float v1() {
      return this.v13;
   }

   public boolean v2() {
      return this.v14.v3();
   }

   public void v3() {
      this.v14.v3(false);
   }

   private void v1(float var1, float var2, float var3, float var4, float var5) {
      this.v21 = var5;
      this.v17 = Math.max(0.0F, var2);
      this.v20 = SignInSupport.v4(30.0F, var5);
      this.v18 = var1;
      this.v19 = uiSupport126.v1(var3, var4, this.v20, SignInSupport.v4(47.0F, var5));
      float var6 = 18.0F * var5;
      this.v14.v1(this.v18 + 10.0F * var5, this.v19, Math.max(0.0F, this.v17 - 20.0F * var5), this.v20);
      this.v14.v1(var6, (this.v20 - var6 * this.v5()) / 2.0F, 1.0F * var5);
   }

   private float v5() {
      if (this.v22 <= 0.0F) {
         this.v22 = uiSupport169.v2("syky_sans_strong");
      }

      return this.v22;
   }

   public void v1(uiSupport35 var1, float var2, float var3, float var4, float var5, float var6, float var7, float var8) {
      this.v1(var2, var3, var4, var5, var6);
      this.v6();
      float var9 = 6.0F * var6;
      uiSupport169.v1(
         this.v18,
         this.v19,
         this.v17,
         this.v20,
         uiSupport155.v1(SignInSupport.v192, var7),
         uiSupport155.v1(SignInSupport.v1(318767103, this.v21), var7),
         SignInSupport.v2(this.v21),
         1.0F,
         uiRecord7.v1(var9)
      );
      int var10 = this.v14.v3() ? 452984831 : (this.v1(var1) ? 184549375 : 0);
      if (var10 != 0) {
         uiSupport169.v1(this.v18, this.v19, this.v17, this.v20, uiSupport155.v1(var10, var7), var9);
      }

      int var11 = var8 >= 1.0F ? SignInSupport.v107() : uiSupport155.v1(SignInSupport.v121(), SignInSupport.v107(), var8);
      int var12 = uiSupport155.v1(var11, var7);
      this.v14.v1(var12, var12, uiSupport155.v1(1090519039, var7), var12);
      this.v14.v1(var1);
   }

   private boolean v1(uiSupport35 var1) {
      return var1.v2() && this.v1(var1.v1, var1.v2);
   }

   private void v6() {
      boolean var1 = this.v14.v3();
      if (var1 != this.v16) {
         this.v16 = var1;
         this.v15 = Double.NaN;
      }

      if (!var1) {
         double var2 = this.v7.getAsDouble();
         if (Double.compare(var2, this.v15) != 0) {
            this.v14.v2(this.v12.format(var2));
            this.v15 = var2;
         }
      }
   }

   private void v1(String var1) {
      double var2 = this.v2(var1);
      if (!Double.isNaN(var2)) {
         double var4 = Math.max(this.v9, Math.min(this.v10, var2));
         this.v8.accept(this.v11 ? Math.rint(var4) : var4);
      }
   }

   private double v2(String var1) {
      String var2 = var1.trim();
      if (var2.isEmpty()) {
         return Double.NaN;
      } else {
         int var3 = var2.charAt(0) == '-' ? 1 : 0;
         boolean var4 = false;

         for (boolean var5 = false; var3 < var2.length(); var3++) {
            char var6 = var2.charAt(var3);
            if (var6 >= '0' && var6 <= '9') {
               var4 = true;
            } else {
               if (var6 != '.' || var5 || this.v11) {
                  return Double.NaN;
               }

               var5 = true;
            }
         }

         if (!var4) {
            return Double.NaN;
         } else {
            try {
               return Double.parseDouble(var2);
            } catch (NumberFormatException var7) {
               return Double.NaN;
            }
         }
      }
   }

   private boolean v1(int var1) {
      if (var1 >= 48 && var1 <= 57) {
         return true;
      } else {
         return var1 == 45 ? this.v9 < 0.0 : var1 == 46 && !this.v11;
      }
   }

   public boolean v1(float var1, float var2, float var3, float var4, float var5, float var6, float var7, int var8) {
      this.v1(var3, var4, var5, var6, var7);
      if (var8 == 0 && this.v1(var1, var2)) {
         boolean var9 = this.v14.v3();
         this.v14.v2(var1, var2, var8);
         if (!var9) {
            this.v14.v4();
         }

         return true;
      } else {
         return false;
      }
   }

   public boolean v1(float var1, float var2, int var3, float var4, float var5) {
      return this.v14.v1(var1, var2, var3, var4, var5);
   }

   public boolean v1(float var1, float var2, int var3) {
      return this.v14.v4(var1, var2, var3);
   }

   public boolean v1(int var1, int var2) {
      return this.v14.v2(var1, var2);
   }

   public boolean v2(int var1, int var2) {
      return !this.v14.v3() ? false : !this.v1(var1) || this.v14.v3(var1, var2);
   }

   public hudSupport54 v1(float var1, float var2, float var3, float var4, float var5, float var6, float var7) {
      this.v1(var3, var4, var5, var6, var7);
      return this.v1(var1, var2) ? hudSupport54.IBEAM : hudSupport54.ARROW;
   }

   @Nullable
   public hudSupport54 v4() {
      return this.v14.v31();
   }

   public boolean v2(float var1, float var2, float var3, float var4, float var5, float var6, float var7) {
      this.v1(var3, var4, var5, var6, var7);
      return this.v1(var1, var2);
   }

   private boolean v1(float var1, float var2) {
      float var3 = 2.0F * this.v21;
      return var1 >= this.v18 - var3 && var1 <= this.v18 + this.v17 + var3 && var2 >= this.v19 - var3 && var2 <= this.v19 + this.v20 + var3;
   }

   @FunctionalInterface
   public interface Part1 {
      String format(double var1);
   }
}
