package cc.syky.cloud;

import cc.syky.config.configRecord;
import cc.syky.hud.hudSupport54;
import cc.syky.hud.hudSupport57;
import cc.syky.hud.hudSupport60;
import cc.syky.hud.hudSupport75;
import cc.syky.ui.SignInSupport;
import cc.syky.ui.uiRecord7;
import cc.syky.ui.uiSupport108;
import cc.syky.ui.uiSupport132;
import cc.syky.ui.uiSupport133;
import cc.syky.ui.uiSupport146;
import cc.syky.ui.uiSupport148;
import cc.syky.ui.uiSupport155;
import cc.syky.ui.uiSupport169;
import cc.syky.ui.uiSupport35;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import net.minecraft.class_1011;
import net.minecraft.class_2960;
import net.minecraft.class_310;
import net.minecraft.class_3298;
import org.jetbrains.annotations.Nullable;

public final class cloudSupport20 {
   private static final String v1 = "syky_sans_strong";
   private static final String v2 = "…";
   private static final float v3 = 37.0F;
   private static final float v4 = 38.0F;
   private static final float v5 = 96.0F;
   private static final float v6 = 12.0F;
   private static final float v7 = 32.0F;
   private static final float v8 = 16.0F;
   private static final float v9 = 20.0F;
   private static final float v10 = 16.0F;
   private static final float v11 = 32.0F;
   private static final float v12 = 10.0F;
   private static final float v13 = 90.0F;
   private static final float v14 = 5.0F;
   private static final float v15 = 150.0F;
   private final configRecord v16;
   private final float v18;
   private final hudSupport57 v19;
   private final uiSupport108[] v17;
   private final hudSupport57 v20 = new hudSupport57(0.0F, 150.0F);
   private final hudSupport57 v21 = new hudSupport57(0.0F, 90.0F);
   private final hudSupport57 v22 = new hudSupport57(0.0F, 90.0F);
   private final hudSupport57 v24 = new hudSupport57(0.0F, 90.0F);
   private final hudSupport57 v25 = new hudSupport57(0.0F, 90.0F);
   private boolean v26;
   private cloudSupport20.Part1 v27 = cloudSupport20.Part1.NONE;
   private int v28 = -1;
   private float v29;
   private float v30;
   private float v32;
   private float v23;
   private int v33 = -1;
   @Nullable
   private String v31;
   @Nullable
   private String v34;
   private float v36;
   private final hudSupport57 v38 = new hudSupport57(0.0F, 150.0F);
   private float v42;
   @Nullable
   private String v43;
   @Nullable
   private String v37;
   @Nullable
   private hudSupport57 v48;
   private float v40;
   private float v44;
   @Nullable
   private String v47;
   private float v49;
   private float v46;
   private static final float v51 = 22.0F;
   private final uiSupport133 v50 = new uiSupport133();
   private static final Map<class_2960, float[]> v60 = new HashMap<>();
   private static final float[] v59 = new float[]{0.0F, 0.0F, 1.0F, 1.0F, 1.0F, 1.0F, Float.MAX_VALUE};
   private static final float v53 = 32.0F;
   private static final float v63 = 0.90909094F;

   public cloudSupport20(configRecord var1, float var2) {
      this.v16 = var1;
      this.v40 = var2;
      this.v18 = uiSupport169.v2("syky_sans_strong", var1.v7(), 18.0F);
      this.v19 = new hudSupport57(var1.v3() ? 1.0F : 0.0F, 150.0F);
      this.v13();
      this.v34 = this.v31;
      this.v20.v3(this.v31 != null ? 1.0F : 0.0F);
      this.v36 = this.v31 != null ? 1.0F : 0.0F;
      this.v38.v3(this.v15());
      this.v42 = this.v38.v2();
      this.v17 = new uiSupport108[var1.v2()];

      for (int var3 = 0; var3 < this.v17.length; var3++) {
         configRecord.Part1 var4 = var1.v1(var3);
         this.v17[var3] = new uiSupport108(var4.v1(), var4.v2(), var4.v3(), var4.v4(), var4.v5());
      }
   }

   public void v1(float var1) {
      this.v40 = var1;
   }

   public float v1() {
      float var1 = this.v16.v8() == null ? 18.0F : 50.0F;
      float var2 = this.v14() ? 155.0F : 0.0F;
      return var1 + this.v18 + 16.0F + var2 + this.v20() + 18.0F;
   }

   private boolean v2(float var1, float var2, float var3, float var4) {
      if (!this.v16.v4()) {
         return false;
      } else {
         float var5 = 5.0F * this.v40;
         float var6 = var3 + 18.0F * this.v40 - var5;
         float var7 = var3 + (this.v10() + this.v18) * this.v40 + var5;
         float var8 = 20.0F * this.v40 + 2.0F * var5;
         float var9 = var4 + (52.0F * this.v40 - 20.0F * this.v40) / 2.0F - var5;
         return var1 >= var6 && var1 < var7 && var2 >= var9 && var2 < var9 + var8;
      }
   }

   private float v10() {
      return this.v16.v8() == null ? 18.0F : 50.0F;
   }

   private float v11() {
      int var1 = this.v17.length;
      return var1 == 0 ? 0.0F : var1 * 32.0F + (var1 - 1) * 10.0F;
   }

   private float v1(float var1, float var2, int var3) {
      int var4 = this.v17.length;
      float var5 = 18.0F + (var4 - var3) * 32.0F + (var4 - 1 - var3) * 10.0F;
      return var1 + var2 - SignInSupport.v4(var5, this.v40);
   }

   private float v2(float var1) {
      return var1 + SignInSupport.v4(10.0F, this.v40);
   }

   private float v12() {
      return SignInSupport.v4(32.0F, this.v40);
   }

   private int v3(float var1, float var2, float var3, float var4, float var5) {
      float var6 = this.v12();
      float var7 = this.v2(var4);
      if (!(var2 < var7) && !(var2 >= var7 + var6)) {
         for (int var8 = 0; var8 < this.v17.length; var8++) {
            float var9 = this.v1(var3, var5, var8);
            if (var1 >= var9 && var1 < var9 + var6) {
               return var8;
            }
         }

         return -1;
      } else {
         return -1;
      }
   }

   private boolean v4(float var1, float var2, float var3, float var4, float var5) {
      return this.v3(var1, var2, var3, var4, var5) >= 0;
   }

   private void v13() {
      hudSupport75 var1 = this.v16.v11();
      String var2 = this.v16.v1();
      if (var1 != null && var2 != null) {
         int var3 = var1.v2();
         if (var3 != this.v33) {
            this.v33 = var3;
            cloudRecord11 var4 = var1.v3(var2).orElse(null);
            cloudRecord10 var5 = var4 != null && var4.v3() != -1 ? var4.v1() : null;
            this.v31 = var5 == null ? null : cloudSupport94.v2(var5);
         }
      } else {
         this.v31 = null;
      }
   }

   private boolean v14() {
      return this.v16.v11() != null && this.v16.v1() != null;
   }

   private float v15() {
      String var1 = this.v34;
      if (var1 == null) {
         return 0.0F;
      } else {
         float var2 = (float)Math.ceil(this.v1(var1) + 24.0F);
         return var2 <= 118.0F ? Math.max(38.0F, var2) : 96.0F;
      }
   }

   private float v1(String var1) {
      if (!var1.equals(this.v47) || this.v49 <= 0.0F) {
         this.v47 = var1;
         this.v49 = uiSupport169.v2("syky_sans_strong", var1, 18.0F);
         this.v46 = uiSupport169.v1("syky_sans_strong", var1, 18.0F);
      }

      return this.v49;
   }

   private float v16() {
      return this.v42 * hudSupport60.v1(this.v36);
   }

   private float v18() {
      if (!this.v14()) {
         return 0.0F;
      } else {
         this.v13();
         return 37.0F + this.v16();
      }
   }

   private float v19() {
      return SignInSupport.v4(37.0F, this.v40);
   }

   private float v17() {
      float var1 = this.v15();
      return SignInSupport.v4(var1, this.v40) + (this.v42 - var1) * this.v40;
   }

   private float v3(float var1, float var2) {
      return var1 + var2 - SignInSupport.v4(18.0F + this.v20(), this.v40);
   }

   private float v20() {
      return this.v17.length == 0 ? 0.0F : this.v11() + 10.0F;
   }

   private float v4(float var1, float var2) {
      if (!this.v14()) {
         return this.v3(var1, var2);
      } else {
         this.v13();
         return this.v3(var1, var2) - this.v19() - this.v17() * hudSupport60.v1(this.v36);
      }
   }

   private float v3(float var1) {
      return var1 + SignInSupport.v4(10.0F, this.v40);
   }

   private float v21() {
      return SignInSupport.v4(32.0F, this.v40);
   }

   private float v5(float var1, float var2) {
      return this.v4(var1, var2) + this.v19();
   }

   private boolean v5(float var1, float var2, float var3, float var4, float var5) {
      float var6 = this.v3(var4);
      return this.v18() > 0.0F && var1 >= this.v4(var3, var5) && var1 < this.v3(var3, var5) && var2 >= var6 && var2 < var6 + this.v21();
   }

   private boolean v6(float var1, float var2, float var3, float var4, float var5) {
      return this.v31 != null && this.v5(var1, var2, var3, var4, var5) && var1 >= this.v5(var3, var5);
   }

   public boolean v2() {
      return this.v26;
   }

   public void v3() {
      this.v26 = false;
   }

   public boolean v4() {
      if (!this.v26) {
         return false;
      } else {
         this.v26 = false;
         return true;
      }
   }

   public boolean v1(int var1) {
      if (this.v26 && var1 != 0 && var1 != 1) {
         this.v1(cloudSupport98.v1(cloudSupport94.v1(var1), cloudSupport21.v1()));
         return true;
      } else {
         return false;
      }
   }

   public boolean v1(int var1, int var2) {
      if (this.v26 && var1 != 256) {
         this.v1(cloudSupport98.v1(var1, var2));
         return true;
      } else {
         return false;
      }
   }

   public boolean v5() {
      return this.v26;
   }

   private void v1(cloudRecord10 var1) {
      this.v26 = false;
      hudSupport75 var2 = this.v16.v11();
      String var3 = this.v16.v1();
      if (var2 != null && var3 != null) {
         var2.v1(var3, var1, var2.v2(var3));
         uiSupport148.v1(uiSupport146.OPTION_PICKED);
      }
   }

   public boolean v1(float var1, float var2, float var3, float var4, float var5) {
      return this.v6(var2, var4) && var1 >= var3 && var1 < var3 + var5;
   }

   public void v1(float var1, float var2, float var3, float var4) {
      this.v29 = var1;
      this.v30 = var2;
      this.v32 = 0.0F;
      this.v23 = 0.0F;
      this.v28 = -1;
      if (this.v2(var1, var2, var3, var4)) {
         this.v27 = cloudSupport20.Part1.SWITCH;
      } else if ((this.v28 = this.v3(var1, var2, var3, var4, this.v44)) >= 0) {
         this.v27 = cloudSupport20.Part1.ACTION;
      } else if (this.v5(var1, var2, var3, var4, this.v44)) {
         this.v27 = this.v6(var1, var2, var3, var4, this.v44) ? cloudSupport20.Part1.REBIND : cloudSupport20.Part1.BIND;
      } else {
         this.v27 = cloudSupport20.Part1.NONE;
      }
   }

   public void v1(float var1, float var2) {
      this.v29 = var1;
      this.v30 = var2;
      this.v32 = 0.0F;
      this.v23 = 0.0F;
      this.v28 = -1;
      this.v27 = cloudSupport20.Part1.DISMISS;
   }

   public void v6() {
      this.v27 = cloudSupport20.Part1.NONE;
   }

   public void v2(float var1, float var2) {
      if (this.v27 != cloudSupport20.Part1.NONE) {
         this.v32 += var1;
         this.v23 += var2;
         if (cloudSupport15.v1(this.v32, this.v23, this.v40)) {
            this.v27 = cloudSupport20.Part1.NONE;
         }
      }
   }

   public cloudSupport20.Part2 v7() {
      cloudSupport20.Part1 var1 = this.v27;
      this.v27 = cloudSupport20.Part1.NONE;
      switch (var1) {
         case SWITCH:
            this.v16.v5();
            break;
         case BIND:
            return cloudSupport20.Part2.OPEN_BIND;
         case REBIND:
            this.v26 = true;
            break;
         case ACTION:
            if (this.v28 >= 0 && this.v28 < this.v17.length) {
               this.v17[this.v28].v2();
            }
            break;
         case DISMISS:
            return cloudSupport20.Part2.DISMISS_CHILD;
      }

      return cloudSupport20.Part2.NONE;
   }

   public float v8() {
      return this.v29;
   }

   public float v9() {
      return this.v30;
   }

   private boolean v6(float var1, float var2) {
      return var1 >= var2 && var1 < var2 + 52.0F * this.v40;
   }

   public hudSupport54 v2(float var1, float var2, float var3, float var4, float var5) {
      return !this.v5(var1, var2, var3, var4, var5) && !this.v4(var1, var2, var3, var4, var5) && !this.v2(var1, var2, var3, var4)
         ? hudSupport54.ARROW
         : hudSupport54.POINTER;
   }

   private static float[] v1(class_2960 var0) {
      return v60.computeIfAbsent(var0, cloudSupport20::v2);
   }

   private static float[] v2(class_2960 var0) {
      Optional var1 = class_310.method_1551().method_1478().method_14486(var0);
      if (var1.isEmpty()) {
         return v59;
      } else {
         try {
            float[] var17;
            try (InputStream var2 = ((class_3298)var1.get()).method_14482()) {
               class_1011 var3;
               label116: {
                  var3 = class_1011.method_4309(var2);

                  try {
                     int var4 = var3.method_4307();
                     int var5 = var3.method_4323();
                     int var6 = var4;
                     int var7 = var5;
                     int var8 = -1;
                     int var9 = -1;

                     for (int var10 = 0; var10 < var5; var10++) {
                        for (int var11 = 0; var11 < var4; var11++) {
                           if (var3.method_61940(var11, var10) >>> 24 != 0) {
                              var6 = Math.min(var6, var11);
                              var8 = Math.max(var8, var11);
                              var7 = Math.min(var7, var10);
                              var9 = Math.max(var9, var10);
                           }
                        }
                     }

                     if (var8 >= 0) {
                        var17 = new float[]{
                           (float)var6 / var4,
                           (float)var7 / var5,
                           (float)(var8 + 1) / var4,
                           (float)(var9 + 1) / var5,
                           var8 + 1 - var6,
                           var9 + 1 - var7,
                           Math.max(var4, var5)
                        };
                        break label116;
                     }

                     var17 = v59;
                  } catch (Throwable var14) {
                     if (var3 != null) {
                        try {
                           var3.close();
                        } catch (Throwable var13) {
                           var14.addSuppressed(var13);
                        }
                     }

                     throw var14;
                  }

                  if (var3 != null) {
                     var3.close();
                  }

                  return var17;
               }

               if (var3 != null) {
                  var3.close();
               }
            }

            return var17;
         } catch (Exception var16) {
            return v59;
         }
      }
   }

   public void v1(uiSupport35 var1, float var2, float var3, float var4) {
      this.v44 = var4;
      this.v13();
      this.v19.v2(this.v16.v3() ? 1.0F : 0.0F);
      float var5 = this.v19.v2();
      this.v21.v2(var1.v2() && this.v2(var1.v1, var1.v2, var2, var3) ? 1.0F : 0.0F);
      float var6 = hudSupport60.v1(this.v21.v2());
      if (this.v16.v8() != null) {
         float var7 = SignInSupport.v4(20.0F, this.v40);
         int var8 = uiSupport155.v1(SignInSupport.v99(), SignInSupport.v82(), var5);
         int var9 = uiSupport155.v1(SignInSupport.v120(), SignInSupport.v82(), var5);
         float[] var10 = v1(this.v16.v8());
         float var11 = 20.0F / Math.max(var10[4], var10[5]);
         float var12 = var10[6] <= 32.0F ? Math.min(0.90909094F, var11) : var11;
         float var13 = Math.min(var7, uiSupport169.v1(var10[4] * var12 * this.v40));
         float var14 = Math.min(var7, uiSupport169.v1(var10[5] * var12 * this.v40));
         uiSupport169.v1(
            this.v16.v8(),
            var2 + SignInSupport.v4(18.0F, this.v40) + uiSupport169.v1((var7 - var13) * 0.5F),
            var3 + uiSupport169.v1((SignInSupport.v4(52.0F, this.v40) - var14) * 0.5F),
            var13,
            var14,
            var10[0],
            var10[1],
            var10[2],
            var10[3],
            uiSupport155.v1(var8, var9, var6),
            uiRecord7.ZERO
         );
      }

      float var15 = 18.0F * this.v40;
      int var16 = uiSupport155.v1(SignInSupport.v40(), SignInSupport.v48(), var5);
      int var17 = uiSupport155.v1(SignInSupport.v120(), SignInSupport.v88(), var5);
      uiSupport169.v1(
         "syky_sans_strong",
         this.v16.v7(),
         var2 + this.v10() * this.v40,
         uiSupport169.v1(var3 + 52.0F * this.v40 / 2.0F, var15),
         var15,
         uiSupport155.v1(var16, this.v16.v4() ? var17 : var16, var6)
      );
      this.v20.v2(this.v31 != null ? 1.0F : 0.0F);
      this.v36 = this.v20.v2();
      String var18 = this.v34;
      if (this.v31 != null) {
         this.v34 = this.v31;
      } else if (this.v20.v1()) {
         this.v34 = null;
      }

      if (var18 == null) {
         this.v38.v3(this.v15());
      } else {
         this.v38.v2(this.v15());
      }

      this.v42 = this.v38.v2();
      this.v1(var1, var2, var3, var4, this.v36);
      float var19 = this.v12();

      for (int var20 = 0; var20 < this.v17.length; var20++) {
         uiSupport108 var22 = this.v17[var20];
         var22.v1(this.v40);
         var22.v1(this.v1(var2, var4, var20), this.v2(var3), var19, var19);
         var22.v1(var1);
      }

      float var21 = SignInSupport.v2(this.v40);
      float var23 = var2 + SignInSupport.v4(16.0F, this.v40);
      float var24 = var2 + var4 - SignInSupport.v4(16.0F, this.v40);
      uiSupport169.v1(
         var23, var3 + SignInSupport.v4(52.0F, this.v40), var24 - var23, var21, SignInSupport.v1(SignInSupport.v94(), this.v40), SignInSupport.v3(var21)
      );
   }

   private void v1(uiSupport35 var1, float var2, float var3, float var4, float var5) {
      if (this.v14()) {
         float var6 = this.v4(var2, var4);
         float var7 = this.v3(var3);
         float var8 = this.v3(var2, var4) - var6;
         float var9 = this.v21();
         uiRecord7 var10 = uiRecord7.v1(var9 / 2.0F);
         boolean var11 = var1.v2() && this.v5(var1.v1, var1.v2, var2, var3, var4);
         boolean var12 = var11 && var1.v1 >= this.v5(var2, var4) && this.v31 != null;
         this.v22.v2(var11 && !var12 ? 1.0F : 0.0F);
         this.v24.v2(var12 ? 1.0F : 0.0F);
         this.v25.v2(this.v26 ? 1.0F : 0.0F);
         uiSupport169.v1(
            var6, var7, var8, var9, SignInSupport.v103(), SignInSupport.v1(SignInSupport.v101(), this.v40), SignInSupport.v2(this.v40), 1.0F, var10
         );
         float var13 = this.v31 != null ? this.v5(var2, var4) : var6 + var8;
         v1(var6, var7, var8, var9, var10, var6, var13, hudSupport60.v1(this.v22.v2()));
         v1(var6, var7, var8, var9, var10, var13, var6 + var8, hudSupport60.v1(this.v24.v2()));
         int var14 = uiSupport155.v1(SignInSupport.v105(), SignInSupport.v96(), var5);
         int var15 = uiSupport155.v1(SignInSupport.v120(), SignInSupport.v87(), var5);
         float var16 = SignInSupport.v4(16.0F, this.v40);
         float var17 = SignInSupport.v2(this.v40);
         float var18 = var17 + uiSupport169.v1((this.v19() - 2.0F * var17 - var16) / 2.0F);
         float var19 = var17 + uiSupport169.v1((this.v19() - var17 - var16) / 2.0F);
         uiSupport169.v1(
            SignInSupport.v162(),
            var6 + var18 + (var19 - var18) * hudSupport60.v1(this.v36),
            var7 + uiSupport169.v1((var9 - var16) / 2.0F),
            var16,
            var16,
            uiSupport155.v1(var14, var15, hudSupport60.v1(this.v22.v2())),
            uiRecord7.ZERO
         );
         String var20 = this.v34;
         float var21 = hudSupport60.v1(this.v36);
         if (var20 != null && !(var21 <= 0.002F)) {
            var13 = this.v5(var2, var4);
            float var22 = this.v17();
            String var23 = this.v26 ? "…" : var20;
            if (this.v43 != null && !var23.equals(this.v43)) {
               this.v37 = this.v43;
               hudSupport57 var24 = new hudSupport57(0.0F, 150.0F);
               var24.v2(1.0F);
               this.v48 = var24;
               this.v50.v1();
            }

            this.v43 = var23;
            float var40 = 1.0F;
            hudSupport57 var25 = this.v48;
            if (var25 != null) {
               var40 = hudSupport60.v1(var25.v2());
               if (var25.v1()) {
                  this.v48 = null;
                  this.v37 = null;
               }
            }

            boolean var26 = var21 < 0.998F || this.v48 != null || !this.v38.v1();
            if (var26) {
               uiSupport169.v6(var13, var7, this.v3(var2, var4) - var13, var9);
            }

            try {
               float var27 = hudSupport60.v1(this.v25.v2());
               if (var27 > 0.0F) {
                  float var28 = SignInSupport.v4(2.0F, this.v40);
                  uiSupport169.v1(
                     this.v3(var2, var4) - var22,
                     var7 + var28,
                     var22 - var28,
                     var9 - 2.0F * var28,
                     uiSupport155.v1(SignInSupport.v98(), var27 * var21),
                     uiRecord7.v5(var9 / 2.0F - var28)
                  );
               }

               float var41 = SignInSupport.v2(this.v40);
               float var29 = SignInSupport.v4(20.0F, this.v40) * var21;
               uiSupport169.v1(
                  var13, var7 + (var9 - var29) / 2.0F, var41, var29, uiSupport155.v1(SignInSupport.v1(SignInSupport.v101(), this.v40), var21), uiRecord7.ZERO
               );
               int var30 = uiSupport155.v1(SignInSupport.v119(), SignInSupport.v85(), var5);
               int var31 = uiSupport155.v1(SignInSupport.v120(), SignInSupport.v88(), var5);
               int var32 = uiSupport155.v1(var30, var31, hudSupport60.v1(this.v24.v2()));
               float var33 = this.v3(var2, var4);
               String var34 = this.v37;
               if (var34 != null) {
                  this.v1(var34, var21 * (1.0F - var40), false, var33, var22, var7, var9, var32, false);
               }

               boolean var35 = this.v20.v1() && this.v38.v1() && this.v48 == null;
               this.v1(var23, var21 * var40, true, var33, var22, var7, var9, var32, var12 && var35);
            } finally {
               if (var26) {
                  uiSupport169.v17();
               }
            }
         } else {
            this.v43 = null;
            this.v37 = null;
            this.v48 = null;
         }
      }
   }

   private void v1(String var1, float var2, boolean var3, float var4, float var5, float var6, float var7, int var8, boolean var9) {
      if (!(var2 <= 0.0F)) {
         float var10 = 18.0F * this.v40;
         float var11 = var4 - var5 / 2.0F;
         float var12 = uiSupport169.v1(var6 + var7 / 2.0F, var10);
         float var13 = var4 - var5 + 12.0F * this.v40;
         float var14 = var4 - 12.0F * this.v40;
         boolean var15 = "…".equals(var1);
         float var16 = var15 ? uiSupport169.v2("syky_sans_strong", var1, 18.0F) : this.v1(var1);
         float var17 = (var15 ? uiSupport169.v1("syky_sans_strong", var1, 18.0F) : this.v46) * this.v40;
         float var18 = var16 * this.v40;
         float var19 = var18 - (var14 - var13);
         boolean var20 = var19 > 0.0F;
         float var21 = 0.0F;
         if (var3) {
            if (var20) {
               var21 = this.v50.v1(var9, var19 / this.v40, System.nanoTime()) * this.v40;
            } else {
               this.v50.v1();
            }
         }

         float var22 = var20 ? var13 - var21 : var11 - var17 - var18 / 2.0F;
         float var23 = var20 ? var13 : var22;
         float var24 = var20 ? var14 - var13 : var18;
         boolean var25 = uiSupport132.v1(uiSupport132.v2, var2, var23, var6, var24, var7, this.v40);

         try {
            int var26 = var25 ? var8 : uiSupport155.v1(var8, var2);
            if (var20) {
               cloudRecord5 var27 = uiSupport133.v1(var13, var14, var21, var19, 22.0F * this.v40);
               uiSupport169.v1("syky_sans_strong", var1, var22, var12, var10, var26, var27);
            } else {
               uiSupport169.v3("syky_sans_strong", var1, var11 - var17, var12, var10, var26);
            }
         } finally {
            if (var25) {
               uiSupport132.v2(uiSupport132.v2, var2, var23, var6, var24, var7, this.v40);
            }
         }
      }
   }

   private static void v1(float var0, float var1, float var2, float var3, uiRecord7 var4, float var5, float var6, float var7) {
      if (!(var7 <= 0.0F) && !(var6 <= var5)) {
         uiSupport169.v6(var5, var1, var6 - var5, var3);

         try {
            uiSupport169.v1(var0, var1, var2, var3, uiSupport155.v1(SignInSupport.v29(), var7), var4);
         } finally {
            uiSupport169.v17();
         }
      }
   }

   public static enum Part1 {
      NONE,
      SWITCH,
      BIND,
      REBIND,
      ACTION,
      DISMISS;

      private Part1() {
      }
   }

   public static enum Part2 {
      NONE,
      OPEN_BIND,
      DISMISS_CHILD;

      private Part2() {
      }
   }
}
