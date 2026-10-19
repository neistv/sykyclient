package cc.syky.ui;

import org.jetbrains.annotations.Nullable;

public final class uiSupport116 {
   private static final String v1 = "...";
   private String v2 = "";
   private float v3;
   private float v4 = -1.0F;
   @Nullable
   private String v5;
   @Nullable
   private String v6;

   public uiSupport116() {
   }

   public String v1() {
      return this.v2;
   }

   public float v2() {
      return this.v3;
   }

   public void v1(String var1, String var2, float var3, float var4, float var5, float var6) {
      if (var3 != this.v4 || !var1.equals(this.v5) || !var2.equals(this.v6)) {
         this.v4 = var3;
         this.v5 = var1;
         this.v6 = var2;
         this.v3 = var4;
         float var7 = uiSupport169.v2("syky_sans_strong", var1, var4);
         if (var7 <= 0.0F && !var1.isEmpty()) {
            this.v4 = -1.0F;
            this.v2 = var1;
         } else {
            float var8 = var2.isEmpty() ? 0.0F : uiSupport169.v2("syky_sans", var2, 1.0F);
            if (var8 <= 0.0F) {
               this.v2 = var7 <= var3 ? var1 : v1("syky_sans_strong", var1, var3, var4);
            } else {
               float var9 = var3 - var7 - var6;
               if (var9 >= var8 * var4) {
                  this.v2 = var1;
               } else {
                  this.v3 = Math.max(var5, var9 / var8);
                  float var10 = var3 - var6 - var8 * this.v3;
                  this.v2 = var7 <= var10 ? var1 : v1("syky_sans_strong", var1, var10, var4);
               }
            }
         }
      }
   }

   public static String v1(String var0, String var1, float var2, float var3) {
      float[] var4 = new float[var1.length() + 1];
      uiSupport169.v1(var0, var1, 1.0F, var4);
      float var5 = uiSupport169.v2(var0, "...", var3);
      int var6 = 0;

      for (int var7 = 1; var7 <= var1.length() && !(var4[var7] * var3 + var5 > var2); var7++) {
         if (var7 == var1.length() || !Character.isLowSurrogate(var1.charAt(var7))) {
            var6 = var7;
         }
      }

      return var1.substring(0, var6).stripTrailing() + "...";
   }
}
