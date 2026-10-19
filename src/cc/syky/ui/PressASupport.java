package cc.syky.ui;

import cc.syky.cloud.cloudRecord10;
import cc.syky.cloud.cloudRecord11;
import cc.syky.cloud.cloudSupport21;
import cc.syky.cloud.cloudSupport94;
import cc.syky.cloud.cloudSupport98;
import cc.syky.hud.hudSupport57;
import cc.syky.hud.hudSupport60;
import cc.syky.hud.hudSupport75;
import org.jetbrains.annotations.Nullable;

public final class PressASupport {
   private static final String v4 = "syky_sans_strong";
   private static final String v5 = "—";
   private static final String v6 = "Press a key";
   private static final float v7 = 15.0F;
   public static final float v1 = 66.0F;
   public static final float v2 = 21.0F;
   private static final float v8 = 10.0F;
   private static final float v9 = 8.0F;
   private static final float v10 = 9.0F;
   private static final int v11 = 268435455;
   private static final float v12 = 150.0F;
   public static final float v3 = 83.0F;
   private final String v13;
   private final hudSupport75 v14;
   private boolean v15;
   private final hudSupport57 v16 = new hudSupport57(0.0F, 90.0F);
   private final hudSupport57 v18 = new hudSupport57(0.0F, 90.0F);
   private final hudSupport57 v19 = new hudSupport57(0.0F, 90.0F);
   private String v17 = "";
   private int v20;
   @Nullable
   private String v21;
   private int v22;
   @Nullable
   private hudSupport57 v24;
   private final hudSupport57 v25 = new hudSupport57(0.0F, 150.0F);
   private float v26 = Float.NaN;
   private int v27 = -1;
   @Nullable
   private cloudRecord10 v28;
   @Nullable
   private String v29;
   private float v30 = Float.NaN;
   private uiRecord7 v32 = uiRecord7.ZERO;

   public PressASupport(String var1, hudSupport75 var2) {
      this.v13 = var1;
      this.v14 = var2;
   }

   public void v1() {
      int var1 = this.v14.v2();
      if (var1 != this.v27) {
         this.v27 = var1;
         cloudRecord11 var2 = this.v14.v3(this.v13).orElse(null);
         this.v28 = var2 != null && var2.v3() != -1 ? var2.v1() : null;
         this.v29 = this.v28 == null ? null : cloudSupport94.v2(this.v28);
      }
   }

   @Nullable
   public cloudRecord10 v2() {
      this.v1();
      return this.v28;
   }

   public boolean v3() {
      return this.v2() != null;
   }

   public boolean v4() {
      return this.v15;
   }

   public void v5() {
      this.v15 = false;
   }

   private void v1(cloudRecord10 var1) {
      this.v15 = false;
      this.v14.v1(this.v13, var1, this.v14.v2(this.v13));
      uiSupport148.v1(uiSupport146.OPTION_PICKED);
   }

   private void v7() {
      this.v14.v1(this.v13, cloudRecord10.v1(-1), this.v14.v2(this.v13));
      uiSupport148.v1(uiSupport146.OPTION_PICKED);
   }

   private String v8() {
      return this.v15 ? "Press a key" : (this.v29 != null ? this.v29 : "—");
   }

   private static float v1(String var0) {
      float var1 = uiSupport169.v2("syky_sans_strong", var0, 15.0F);
      return Math.max(66.0F, (float)Math.ceil(var1 + 20.0F));
   }

   private float v9() {
      return Float.isNaN(this.v26) ? v1(this.v8()) : this.v26;
   }

   public float v1(float var1, float var2) {
      return var1 - this.v9() * var2;
   }

   public float v2(float var1, float var2) {
      float var3 = this.v1(var1, var2);
      return this.v29 == null ? var3 : var3 - 17.0F * var2;
   }

   public boolean v1(float var1, float var2, float var3, float var4, float var5) {
      return var1 >= this.v1(var3, var5) && var1 < var3 && var2 >= var4 && var2 < var4 + 21.0F * var5;
   }

   private float v3(float var1, float var2) {
      return this.v1(var1, var2) - 12.5F * var2;
   }

   public boolean v2(float var1, float var2, float var3, float var4, float var5) {
      if (this.v29 == null) {
         return false;
      } else {
         float var6 = 20.0F * var5 / 2.0F;
         return Math.abs(var1 - this.v3(var3, var5)) <= var6 && Math.abs(var2 - (var4 + 21.0F * var5 / 2.0F)) <= var6;
      }
   }

   public void v1(uiSupport35 var1, float var2, float var3, float var4, float var5) {
      this.v1();
      if (var4 != this.v30) {
         this.v30 = var4;
         this.v32 = uiRecord7.v1(6.0F * var4);
      }

      String var6 = this.v8();
      if (Float.isNaN(this.v26)) {
         this.v25.v3(v1(var6));
      } else {
         this.v25.v2(v1(var6));
      }

      this.v26 = this.v25.v2();
      float var7 = this.v1(var2, var4);
      float var8 = this.v26 * var4;
      float var9 = 21.0F * var4;
      boolean var10 = var1.v2() && this.v1(var1.v1, var1.v2, var2, var3, var4);
      uiSupport169.v1(
         var7,
         var3,
         var8,
         var9,
         uiSupport155.v1(SignInSupport.v45(), var5),
         uiSupport155.v1(SignInSupport.v1(SignInSupport.v101(), var4), var5),
         SignInSupport.v2(var4),
         1.0F,
         this.v32
      );
      this.v16.v2(this.v15 ? 1.0F : (var10 ? 0.7F : 0.0F));
      float var11 = hudSupport60.v1(this.v16.v2());
      if (var11 > 0.0F) {
         uiSupport169.v1(var7, var3, var8, var9, uiSupport155.v1(268435455, var11 * var5), this.v32);
      }

      if (!var6.equals(this.v17)) {
         if (!this.v17.isEmpty()) {
            this.v21 = this.v17;
            this.v22 = this.v20;
            hudSupport57 var12 = new hudSupport57(0.0F, 150.0F);
            var12.v2(1.0F);
            this.v24 = var12;
         }

         this.v17 = var6;
         this.v20 = !this.v15 && this.v29 == null ? SignInSupport.v121() : SignInSupport.v37();
      }

      float var19 = 1.0F;
      hudSupport57 var13 = this.v24;
      if (var13 != null) {
         var19 = var13.v2();
         if (var13.v1()) {
            this.v24 = null;
            this.v21 = null;
         }
      }

      boolean var14 = this.v24 != null || !this.v25.v1();
      if (var14) {
         uiSupport169.v6(var7, var3, var8, var9);
      }

      try {
         String var15 = this.v21;
         if (var15 != null) {
            v1(var15, this.v22, 1.0F - var19, var7, var3, var8, var9, var4, var5);
         }

         v1(this.v17, this.v20, var19, var7, var3, var8, var9, var4, var5);
      } finally {
         if (var14) {
            uiSupport169.v17();
         }
      }

      this.v18.v2(this.v29 != null ? 1.0F : 0.0F);
      float var20 = hudSupport60.v1(this.v18.v2());
      this.v19.v2(var1.v2() && this.v2(var1.v1, var1.v2, var2, var3, var4) ? 1.0F : 0.0F);
      float var16 = hudSupport60.v1(this.v19.v2());
      uiSupport112.v2(
         this.v3(var2, var4), var3 + var9 / 2.0F, var4, var20, uiSupport155.v1(uiSupport155.v1(SignInSupport.v124(), SignInSupport.v117(), var16), var5)
      );
   }

   private static void v1(String var0, int var1, float var2, float var3, float var4, float var5, float var6, float var7, float var8) {
      if (!(var2 <= 0.0F) && !var0.isEmpty()) {
         float var9 = v1(var0, (v1(var0) - 20.0F) * var7, 15.0F * var7);
         float var10 = var3 + var5 / 2.0F;
         float var11 = var2 < 1.0F ? uiSupport169.v2("syky_sans_strong", var0, var9) : 0.0F;
         boolean var12 = uiSupport132.v1(uiSupport132.v2, var2, var10 - var11 / 2.0F, var4, var11, var6, var7);

         try {
            uiSupport169.v3(
               "syky_sans_strong", var0, var10, uiSupport169.v1(var4 + var6 / 2.0F, var9), var9, uiSupport155.v1(var1, (var12 ? 1.0F : var2) * var8)
            );
         } finally {
            if (var12) {
               uiSupport132.v2(uiSupport132.v2, var2, var10 - var11 / 2.0F, var4, var11, var6, var7);
            }
         }
      }
   }

   private static float v1(String var0, float var1, float var2) {
      float var3 = uiSupport169.v2("syky_sans_strong", var0, var2);
      return !(var3 <= 0.0F) && !(var3 <= var1) ? Math.max(9.0F, var2 * var1 / var3) : var2;
   }

   public boolean v3(float var1, float var2, float var3, float var4, float var5) {
      this.v1();
      if (this.v2(var1, var2, var3, var4, var5)) {
         this.v7();
         return true;
      } else if (this.v1(var1, var2, var3, var4, var5)) {
         this.v15 = true;
         return true;
      } else {
         return false;
      }
   }

   public boolean v1(int var1) {
      if (this.v15 && !uiSupport90.v2(var1)) {
         this.v1(cloudSupport98.v1(cloudSupport94.v1(var1), cloudSupport21.v1()));
         return true;
      } else {
         return false;
      }
   }

   public boolean v1(int var1, int var2) {
      if (!this.v15) {
         return false;
      } else if (var1 == 256) {
         return false;
      } else {
         this.v1(cloudSupport98.v1(var1, var2));
         return true;
      }
   }

   public boolean v6() {
      return this.v15;
   }
}
