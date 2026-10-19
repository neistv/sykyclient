package cc.syky.ui;

import cc.syky.Syky;
import cc.syky.sykyRecord9;
import cc.syky.cloud.CloudClient;
import cc.syky.cloud.FromYouSupport;
import cc.syky.cloud.SykySession;
import cc.syky.cloud.cloudSupport101;
import cc.syky.cloud.cloudSupport15;
import cc.syky.cloud.cloudSupport57;
import cc.syky.config.ConfigUi;
import cc.syky.config.configSupport10;
import cc.syky.hud.hudSupport;
import cc.syky.hud.hudSupport2;
import cc.syky.hud.hudSupport3;
import cc.syky.hud.hudSupport5;
import cc.syky.hud.hudSupport53;
import cc.syky.hud.hudSupport54;
import cc.syky.hud.hudSupport60;
import cc.syky.hud.hudSupport62;
import cc.syky.hud.hudSupport70;
import cc.syky.hud.hudSupport75;
import cc.syky.module.visual.visualSupport2;
import cc.syky.render.font.MsdfFont;
import java.util.HashMap;
import java.util.Map;
import net.minecraft.class_1041;
import net.minecraft.class_11905;
import net.minecraft.class_11908;
import net.minecraft.class_11909;
import net.minecraft.class_2561;
import net.minecraft.class_304;
import net.minecraft.class_310;
import net.minecraft.class_332;
import net.minecraft.class_3675;
import org.jetbrains.annotations.Nullable;

public final class uiSupport141 extends uiSupport36 {
   private static final float v2 = 28.0F;
   private static final float v3 = (float)Math.sqrt(Math.PI * 2);
   private static final int v4 = 0;
   private static final int v5 = 256;
   private static final float v6 = 67.0F;
   private final uiSupport226 v7;
   private final hudSupport75 v8;
   private final cloudSupport101 v9;
   private final configSupport10 v10;
   private final ConfigUi v11;
   private final CloudClient v12;
   private final sykyRecord9 v13;
   private float v14 = 1.0F;
   private int v15 = -1;
   private float v16;
   private float v18;
   @Nullable
   private ModulesSupport v19;
   @Nullable
   private uiSupport40 v17;
   @Nullable
   private NothingFoundSupport v20;
   private final hudSupport5 v21 = new hudSupport5(uiSupport6.Part1.PANEL);
   private boolean v22;
   private long v24;
   private final float[] v25 = new float[4];
   private final float[] v26 = new float[2];
   private final float[] v27 = new float[4];
   private final float[] v28 = new float[2];
   private boolean v29;
   private boolean v30;
   @Nullable
   private uiSupport45 v32;
   private float v23;
   private float v33;
   @Nullable
   private visualSupport2 v31;
   private float v34;
   private float v36;
   private float v38;
   private float v42;
   private uiRecord6 v43 = uiRecord6.CENTRED;
   private final hudSupport3 v37 = new hudSupport3();
   private final float[] v48 = new float[4];
   private static final float v40 = 0.7F;
   private final Map<class_304, Boolean> v44 = new HashMap<>();

   public static void v1(AltManagerSupport var0) {
      uiSupport139.v1(var0);
   }

   public uiSupport141(uiSupport226 var1, hudSupport75 var2, cloudSupport101 var3, configSupport10 var4, ConfigUi var5, CloudClient var6, sykyRecord9 var7) {
      super(class_2561.method_43470("syky"));
      this.v12 = var6;
      this.v13 = var7;
      this.v7 = var1;
      this.v8 = var2;
      this.v9 = var3;
      this.v10 = var4;
      this.v11 = var5;
      uiSupport139.v7();
      if (uiSupport139.v2() && var6.v6() && SykySession.v1() == null) {
         uiSupport139.v1(AltManagerSupport.ACCOUNT);
         uiSupport139.v1(0.0F);
      }

      this.v21.v1(false);
      this.v24 = System.nanoTime();
   }

   @Override
   public void method_25426() {
      super.method_25426();
      uiSupport259.v1("ui.clickgui.init", this::v5);
   }

   private void v5() {
      if (this.v20 != null) {
         uiSupport139.v1(this.v20.v3());
      }

      this.v6();
      this.v31 = null;
      uiSupport139.v1(this.v43.v1(uiSupport139.v4()), this.v43.v2(uiSupport139.v5()));
      this.v1.v5();
      this.v1();
      NothingFoundSupport var1 = new NothingFoundSupport(this.v7, this.v8, this.v10, this.v14, uiSupport139.v1(), this.v12, this.v13);
      var1.v1(uiSupport139.v3());
      if (NothingFoundSupport.v19()) {
         var1.v1(new AutoSaveSupport(this.v11, this.v14, this.v10::v2));
      }

      this.v20 = var1;
      ModulesSupport var2 = new ModulesSupport(this.v14, uiSupport139.v1(), var2x -> {
         uiSupport139.v1(var2x);
         uiSupport139.v1(0.0F);
         if (var2x == AltManagerSupport.ACCOUNT) {
            var1.v21();
         }

         var1.v1(var2x);
         if (this.v17 != null) {
            this.v17.v1().v1(var1.v7());
         }
      });
      var2.v1(AltManagerSupport.SOCIALS, () -> FromYouSupport.v1(this.v12));
      this.v19 = var2;
      uiSupport40 var3 = new uiSupport40(this.v14, var1::v1, this::v19, this::v18, this::v22, this::v17, this::v20, this::v21);
      var3.v1().v1(var1.v7());
      this.v17 = var3;
      this.v1.v1(var1);
      this.v1.v1(var3);
      this.v1.v1(this.v19);
      this.v8();
   }

   private void v6() {
      this.v15 = hudSupport62.v2();
      this.v16 = SignInSupport.v2(this.field_22789, this.field_22790);
      this.v18 = this.v16 * 0.63414633F;
      this.v16 = uiSupport169.v1(this.v16);
      this.v18 = uiSupport169.v1(this.v18);
      this.v14 = this.v16 / 984.0F;
      this.v43 = uiRecord6.v1(this.field_22789, this.field_22790, this.v16, this.v18, 67.0F * this.v14, 120.0F * this.v14, 160.0F * this.v14);
   }

   private boolean v7() {
      return this.v22 || this.v21.v2() || this.v21.v3() && this.v21.v1() < 0.7F;
   }

   private void v1(float var1, float var2, float[] var3) {
      var3[0] = var1;
      var3[1] = var2;
      if (!this.v22 && this.v21.v3()) {
         float var4 = this.v21.v8();
         float var5 = this.v21.v9();
         if (this.v20 != null && this.v20.v1(this.v28)) {
            float var6 = this.v28[0] + (var1 - this.v28[0]) / var4;
            float var7 = this.v28[1] + (var2 - this.v28[1]) / var5;
            if (this.v20.v6(var6, var7)) {
               var3[0] = var6;
               var3[1] = var7;
               return;
            }
         }

         float var8 = this.v1.v9 + this.v1.v11 * 0.5F;
         float var9 = this.v1.v10 + this.v1.v12 * 0.5F;
         var3[0] = var8 + (var1 - var8) / var4;
         var3[1] = var9 + (var2 - var9) / var5;
      }
   }

   private class_11909 v1(class_11909 var1) {
      this.v1((float)var1.comp_4798(), (float)var1.comp_4799(), this.v26);
      return this.v26[0] == (float)var1.comp_4798() && this.v26[1] == (float)var1.comp_4799()
         ? var1
         : new class_11909(this.v26[0], this.v26[1], var1.comp_4800());
   }

   private void v8() {
      if (this.v19 != null && this.v20 != null) {
         float var1 = this.v16;
         float var2 = this.v18;
         float var3 = this.field_22789 * uiSupport139.v4() - var1 / 2.0F;
         float var4 = this.field_22790 * uiSupport139.v5() - var2 / 2.0F;
         float var5 = this.v1(uiSupport139.v4(), this.v38, (float)this.field_22789);
         float var6 = this.v1(uiSupport139.v5(), this.v42, (float)this.field_22790);
         var3 = uiSupport169.v1(var3 - var5) + var5;
         var4 = uiSupport169.v1(var4 - var6) + var6;
         this.v1.v1(var3, var4, var1, var2);
         boolean var7 = this.v20 != null && this.v20.v12();
         if (this.v19.v1() != this.v20.v1()) {
            this.v19.v1(this.v20.v1());
            if (this.v17 != null) {
               this.v17.v1().v1(this.v20.v7());
            }
         }

         this.v19.v1(var7);
         this.v19.v1(this.v14);
         this.v19.v1(var3, var4, SignInSupport.v4(231.0F, this.v14), var2);
         this.v19.v1(this.field_22789, this.field_22790);
         float var8 = SignInSupport.v4(231.0F, this.v14) + SignInSupport.v2(this.v14);
         float var9 = var3 + var8;
         float var10 = var1 - var8;
         if (this.v17 != null) {
            this.v17.v1(this.v14);
            this.v17.v3(!this.v11.v4() && this.v11.v5());
            this.v17.v6(var7);
            this.v17.v1().v4(this.v20.v1() == AltManagerSupport.ALTS && uiSupport223.v2);
            this.v17.v5(this.v20 != null && this.v20.v18());
            this.v17.v4(this.v20 != null && this.v20.v16());
            this.v17.v1(this.v20 != null ? this.v20.v22() : null, this.v20 != null ? this.v20.v24() : null, this.v20 != null && this.v20.v25());
            this.v17.v2(this.v20 == null || this.v20.v32());
            this.v17.v1(this.v20 != null && this.v20.v28());
            this.v17.v1(this.v20 != null ? this.v20.v26() : null, this.v20 != null && this.v20.v27());
            this.v17.v1(this.v20 != null && this.v20.v23(), this.v20 != null && this.v20.v33());
            this.v17.v1(var9, var4, var10, var2);
            this.v17.v1(this.field_22789, this.field_22790);
         }

         this.v20.v2(this.v14);
         this.v20.v1(!this.v29 && this.v31 == null);
         this.v20.v1(var9, var4, var10, var2);
         this.v20.v1(this.field_22789, this.field_22790);
      }
   }

   @Override
   public void method_25394(class_332 var1, int var2, int var3, float var4) {
   }

   public void v1(int var1, int var2, float var3) {
      if (this.v15 != hudSupport62.v2() && !cloudSupport57.v1(this.v9.v1().method_22683(), 0)) {
         this.v6();
         this.v31 = null;
         uiSupport139.v1(this.v43.v1(uiSupport139.v4()), this.v43.v2(uiSupport139.v5()));
      }

      uiSupport163.v1();

      boolean var4;
      try {
         try {
            var4 = this.v1(null, var1, var2, var3);
         } finally {
            uiSupport169.v10();
         }
      } finally {
         uiSupport163.v2();
      }

      if (var4) {
         uiSupport142.v3(this.v9.v1());
      }
   }

   private void v1(float[] var1) {
      float var2 = this.v1.v11 * this.v21.v8();
      float var3 = this.v1.v12 * this.v21.v9();
      var1[0] = this.v1.v9 + this.v1.v11 * 0.5F - var2 * 0.5F;
      var1[1] = this.v1.v10 + this.v1.v12 * 0.5F - var3 * 0.5F;
      var1[2] = var2;
      var1[3] = var3;
   }

   @Override
   public void v1() {
      if (this.v20 != null) {
         this.v20.v17();
      }
   }

   private boolean v1(@Nullable class_332 var1, int var2, int var3, float var4) {
      if (this.v20 == null) {
         return false;
      } else {
         uiSupport258 var5 = Syky.profilerOrNull();
         long var6 = var5 == null ? 0L : var5.v3();
         this.v16();
         this.v8();
         this.v21.v1(!this.v22, this.v9());
         if (this.v21.v2()) {
            return true;
         } else {
            boolean var8 = this.v21.v3();
            if (!var8 && !this.v22 && !this.v29 && !this.v37.v4() && this.v31 == null) {
               this.v1(this.v27);
               uiSupport169.v3(this.v27[0], this.v27[1], this.v27[2], this.v27[3]);
            } else {
               uiSupport169.v9();
            }

            if (hudSupport.v1() && (!var8 || this.v22)) {
               if (this.v22) {
                  this.v37.v2();
               } else if (this.v29 && !this.v37.v4()) {
                  this.v37.v1(this.v1.v9, this.v1.v10, this.v1.v11, this.v1.v12, var2, var3);
               }
            } else {
               this.v37.v3();
            }

            this.v37.v1(this.v1.v9, this.v1.v10, this.v1.v11, this.v1.v12, hudSupport.v3());
            int var9 = uiSupport169.v1("gpu.clickgui");
            uiSupport169.v1(var1);

            try {
               this.v1(var2, var3, this.v26);
               float var10 = this.v26[0];
               float var11 = this.v26[1];
               uiSupport35 var12 = new uiSupport35(var10, var11, var4, this.field_22789, this.field_22790);
               if (this.v7()) {
                  var12 = var12.v1();
               }

               this.v20.v2(var12);
               this.v20.v2(this.v48);
               if (var5 != null) {
                  var5.v1("clickgui.prepare", var6);
               }

               uiSupport62.v1(this.v14);
               boolean var13 = hudSupport2.v1(
                  this.v37, this.v1.v9, this.v1.v10, this.v1.v11, this.v1.v12, this.v14, this.v48[0], this.v48[1], this.v48[2], this.v48[3]
               );

               try {
                  float var14 = this.v21.v7();
                  float var15 = this.v12();
                  float var16 = this.v21.v8();
                  float var17 = this.v21.v9();
                  this.v1(this.v27);
                  float var18 = this.v27[0];
                  float var19 = this.v27[1];
                  float var20 = this.v27[2];
                  float var21 = this.v27[3];
                  float var22 = this.v14 * Math.min(var16, var17);
                  float var23 = 28.0F * var22;
                  uiRecord7 var24 = uiRecord7.v1(var23);
                  int var25 = uiSupport169.v1("gpu.clickgui.glass");
                  uiSupport169.v1(var18, var19, var20, var21, var23, var22, var14, var15);
                  uiSupport169.v1(var18, var19, var20, var21, var24, SignInSupport.v1(), var14, var15, 0.0F, uiSupport49.v3());
                  uiSupport169.v19();
                  uiSupport169.v1(var25);
                  uiSupport169.v1(
                     var18,
                     var19,
                     var20,
                     var21,
                     uiSupport155.v1(SignInSupport.v1(SignInSupport.v2(), this.v14), var14),
                     SignInSupport.v2(this.v14),
                     var24,
                     Math.max(1.0F, v3 * var15 / uiSupport169.v2())
                  );
                  boolean var26 = var8 && this.v10();

                  try {
                     uiSupport35 var27 = this.v1(var10, var11) ? var12.v1() : var12;
                     this.v1.v5(var27);
                     uiSupport169.v19();
                     long var28 = var5 == null ? 0L : var5.v3();
                     this.v1.v1(var27);
                     if (var5 != null) {
                        var5.v1("clickgui.tree", var28);
                     }

                     this.v20.v3(var12);
                  } finally {
                     if (var26) {
                        this.v11();
                     }
                  }
               } finally {
                  if (var13) {
                     hudSupport2.v1();
                  }
               }

               this.v20.v1(var12, this.v21.v7(), this.v21.v8(), this.v21.v9(), this.v12());
            } finally {
               uiSupport169.v15();
               uiSupport169.v1(var9);
            }

            this.v1(var2, var3, this.v26);
            this.v2(this.v26[0], this.v26[1]);
            return false;
         }
      }
   }

   private float v9() {
      long var1 = System.nanoTime();
      float var3 = this.v24 == 0L ? 0.0F : (float)(var1 - this.v24) / 1000000.0F;
      this.v24 = var1;
      return var3;
   }

   private boolean v10() {
      this.v2(this.v25);
      return uiSupport169.v2(this.v25[0], this.v25[1], this.v25[2], this.v25[3]);
   }

   private void v11() {
      float var1 = this.v1.v9 + this.v1.v11 * 0.5F;
      float var2 = this.v1.v10 + this.v1.v12 * 0.5F;
      float var3 = 2.0F * this.v12() + 1.0F;
      float var4 = this.v21.v8();
      float var5 = this.v21.v9();
      float var6 = var1 + (this.v25[0] - var1) * var4 - var3;
      float var7 = var2 + (this.v25[1] - var2) * var5 - var3;
      float var8 = var1 + (this.v25[0] + this.v25[2] - var1) * var4 + var3;
      float var9 = var2 + (this.v25[1] + this.v25[3] - var2) * var5 + var3;
      uiSupport169.v1(this.v21.v7(), var1, var2, var4, var5, this.v12(), var6, var7, var8 - var6, var9 - var7);
   }

   private void v2(float[] var1) {
      float var2 = hudSupport2.v1(this.v14);
      float var3 = this.v1.v9 - var2;
      float var4 = this.v1.v10 - var2;
      float var5 = this.v1.v9 + this.v1.v11 + var2;
      float var6 = this.v1.v10 + this.v1.v12 + var2;
      if (this.v48[2] > 0.0F && this.v48[3] > 0.0F) {
         var3 = Math.min(var3, this.v48[0]);
         var4 = Math.min(var4, this.v48[1]);
         var5 = Math.max(var5, this.v48[0] + this.v48[2]);
         var6 = Math.max(var6, this.v48[1] + this.v48[3]);
      }

      var1[0] = var3;
      var1[1] = var4;
      var1[2] = var5 - var3;
      var1[3] = var6 - var4;
   }

   private float v12() {
      return hudSupport70.v1() ? this.v21.v10() * this.v14 : 0.0F;
   }

   private boolean v1(float var1, float var2) {
      return this.v20 != null && (this.v20.v6(var1, var2) || this.v17 != null && this.v20.v11() && this.v17.v4(var1, var2));
   }

   private void v2(float var1, float var2) {
      hudSupport54 var3 = this.v1.v31();
      if (this.v7()) {
         hudSupport53.v1(var3, this.v13(), hudSupport54.ARROW);
      } else {
         hudSupport54 var4 = this.v1.v2(var1, var2);
         if (this.v20 != null && this.v20.v11() && this.v20.v6(var1, var2)) {
            hudSupport53.v1(var3, this.v13(), this.v20.v2(var1, var2));
         } else if (this.v20 != null && this.v17 != null && this.v20.v11() && this.v17.v4(var1, var2)) {
            hudSupport53.v1(var3, this.v13(), hudSupport54.ARROW);
         } else {
            hudSupport53.v1(var3, this.v13(), var4);
         }
      }
   }

   private boolean v13() {
      class_310 var1 = this.v9.v1();
      class_1041 var2 = var1 == null ? null : var1.method_22683();
      return var2 != null && cloudSupport57.v1(var2, 0);
   }

   public void method_25419() {
      uiSupport259.v1("ui.clickgui.close", this::v14);
   }

   private void v14() {
      if (!this.v22) {
         this.v22 = true;
         if (this.v20 != null) {
            uiSupport139.v1(this.v20.v3());
         }
      }
   }

   public boolean v2() {
      if (!this.v22) {
         return false;
      } else {
         this.v22 = false;
         return true;
      }
   }

   public void method_25393() {
      super.method_25393();
      uiSupport259.v1("ui.clickgui.tick", this::v24);
   }

   @Override
   public boolean method_25402(class_11909 var1, boolean var2) {
      return uiSupport259.v1("ui.clickgui.mouseClicked", () -> this.v1(var1, var2), false);
   }

   private boolean v1(class_11909 var1, boolean var2) {
      if (this.v7()) {
         return true;
      } else {
         class_11909 var3 = this.v1(var1);
         float var4 = (float)var3.comp_4798();
         float var5 = (float)var3.comp_4799();
         if (this.v17 != null && (!this.v17.v7(var4, var5) || this.v20 != null && this.v20.v11())) {
            this.v17.v3();
         }

         if (this.v20 != null) {
            this.v20.v2(var4, var5, var3.method_74245());
            if (!this.v1.v1(var4, var5) && !this.v20.v1(var4, var5)) {
               this.v20.v3(var4, var5, var3.method_74245());
            }
         }

         if (var3.method_74245() == 0 && this.v20 != null && this.v20.v4(var4, var5)) {
            return true;
         } else if (this.v20 != null && this.v20.v11() && this.v20.v6(var4, var5)) {
            this.v20.v1(var4, var5, var3.method_74245());
            return true;
         } else if (var3.method_74245() == 0 && this.v3(var4, var5) && this.v4(var4, var5)) {
            this.v29 = true;
            boolean var6 = this.v20 != null && this.v20.v11();
            this.v32 = !var6 && this.v17 != null ? this.v17.v6(var4, var5) : null;
            this.v30 = var6 || this.v32 != null;
            this.v23 = 0.0F;
            this.v33 = 0.0F;
            this.v31 = null;
            if (hudSupport.v1()) {
               this.v37.v1(this.v1.v9, this.v1.v10, this.v1.v11, this.v1.v12, var4, var5);
            }

            return true;
         } else if (this.v20 != null && this.v17 != null && this.v20.v11() && this.v17.v4(var4, var5)) {
            this.v20.v3(var4, var5, var3.method_74245());
            return true;
         } else {
            return super.method_25402(var3, var2) ? true : this.v20 != null && this.v1.v1(var4, var5) && this.v20.v3(var4, var5, var3.method_74245());
         }
      }
   }

   private boolean v3(float var1, float var2) {
      float var3 = this.v1.v12 * 0.10737179F;
      return var1 >= this.v1.v9 && var1 < this.v1.v9 + this.v1.v11 && var2 >= this.v1.v10 && var2 < this.v1.v10 + var3;
   }

   @Override
   public boolean method_25401(double var1, double var3, double var5, double var7) {
      if (uiSupport259.v1("ui.clickgui.mouseScrolled", this::v7, false)) {
         return true;
      } else {
         this.v1((float)var1, (float)var3, this.v26);
         return super.method_25401(this.v26[0], this.v26[1], var5, var7);
      }
   }

   @Override
   public boolean method_25403(class_11909 var1, double var2, double var4) {
      return uiSupport259.v1("ui.clickgui.mouseDragged", () -> this.v1(var1, var2, var4), false);
   }

   private boolean v1(class_11909 var1, double var2, double var4) {
      if (this.v20 != null && this.v20.v8()) {
         this.v20.v5((float)var2, (float)var4);
         return true;
      } else if (this.v29) {
         if (this.v30) {
            this.v23 += (float)var2;
            this.v33 += (float)var4;
            this.v30 = !cloudSupport15.v1(this.v23, this.v33, this.v14);
         }

         uiSupport139.v1(this.v43.v1(uiSupport139.v4(), (float)var2 / this.field_22789), this.v43.v2(uiSupport139.v5(), (float)var4 / this.field_22790));
         return true;
      } else {
         return super.method_25403(this.v1(var1), var2, var4);
      }
   }

   @Override
   public boolean method_25406(class_11909 var1) {
      return uiSupport259.v1("ui.clickgui.mouseReleased", () -> this.v2(var1), false);
   }

   private boolean v2(class_11909 var1) {
      class_11909 var2 = this.v1(var1);
      if (this.v20 != null && this.v20.v8()) {
         this.v20.v9();
         return true;
      } else if (this.v29) {
         this.v29 = false;
         this.v37.v1();
         this.v15();
         if (this.v30) {
            uiSupport45 var3 = this.v32;
            if (var3 != null) {
               var3.v3((float)var2.comp_4798(), (float)var2.comp_4799());
            } else if (this.v20 != null) {
               this.v20.v3((float)var2.comp_4798(), (float)var2.comp_4799(), var2.method_74245());
            }
         }

         this.v30 = false;
         this.v32 = null;
         return true;
      } else {
         return super.method_25406(var2);
      }
   }

   private void v15() {
      float var1 = this.v43.v1(uiSupport139.v4());
      float var2 = this.v43.v2(uiSupport139.v5());
      if (var1 == uiSupport139.v4() && var2 == uiSupport139.v5()) {
         this.v31 = null;
      } else {
         this.v34 = uiSupport139.v4();
         this.v36 = uiSupport139.v5();
         this.v38 = var1;
         this.v42 = var2;
         this.v31 = new visualSupport2(380L, hudSupport60::v3);
      }
   }

   private float v1(float var1, float var2, float var3) {
      return this.v31 == null ? 0.0F : (var1 - var2) * var3;
   }

   private void v16() {
      visualSupport2 var1 = this.v31;
      if (var1 != null) {
         float var2 = var1.v1();
         uiSupport139.v1(this.v34 + (this.v38 - this.v34) * var2, this.v36 + (this.v42 - this.v36) * var2);
         if (var1.v2()) {
            uiSupport139.v1(this.v38, this.v42);
            this.v31 = null;
         }
      }
   }

   @Override
   public boolean method_25404(class_11908 var1) {
      return uiSupport259.v1("ui.clickgui.keyPressed", () -> this.v1(var1), false);
   }

   private boolean v1(class_11908 var1) {
      int var2 = var1.comp_4795();
      if (var2 == 256) {
         if (this.v20 != null) {
            this.v20.v6();
         }

         this.method_25419();
         return true;
      } else {
         if (var2 >= 49 && var2 <= 57 && !this.v3()) {
            class_310 var3 = this.v9.v1();
            if (var3.field_1724 != null) {
               var3.field_1724.method_31548().method_61496(var2 - 49);
               return true;
            }
         }

         return this.v1(var2, var1.comp_4797(), false, 0);
      }
   }

   @Override
   public boolean method_25400(class_11905 var1) {
      return uiSupport259.v1("ui.clickgui.charTyped", () -> this.v1(0, var1.comp_4794(), true, var1.comp_4793()), false);
   }

   private boolean v1(int var1, int var2, boolean var3, int var4) {
      NothingFoundSupport var5 = this.v20;
      uiSupport40 var6 = this.v17;
      if (var5 != null) {
         if (var3 ? var5.v3(var4, var2) : var5.v2(var1, var2)) {
            return true;
         }

         if (!var3 && var1 == 70 && MsdfFont.v1(var2)) {
            if (!var5.v10() && var6 != null) {
               var6.v1().v5();
            }

            return true;
         }

         if (var5.v11()) {
            return false;
         }
      }

      if (var6 != null) {
         return var3 ? var6.v3(var4, var2) : var6.v2(var1, var2);
      } else {
         return false;
      }
   }

   private boolean v4(float var1, float var2) {
      boolean var3 = this.v20 != null && this.v20.v11();
      return this.v17 != null && this.v17.v1(var1, var2) && !this.v17.v5(var1, var2) && !var3 ? false : this.v20 == null || this.v20.v7(var1, var2);
   }

   private void v18() {
      if (this.v11.v6()) {
         uiSupport148.v1(uiSupport146.OPTION_PICKED);
      }
   }

   private void v19() {
      if (this.v20 != null) {
         class_310 var1 = this.v9.v1();
         this.v20.v1(new AutoSaveSupport(this.v11, this.v14, this.v10::v2), (float)uiSupport142.v1(var1), (float)uiSupport142.v2(var1));
      }
   }

   private void v17() {
      if (this.v20 != null) {
         class_310 var1 = this.v9.v1();
         this.v20.v9((float)uiSupport142.v1(var1), (float)uiSupport142.v2(var1));
      }
   }

   private void v20() {
      if (this.v20 != null) {
         class_310 var1 = this.v9.v1();
         this.v20.v8((float)uiSupport142.v1(var1), (float)uiSupport142.v2(var1));
      }
   }

   private void v21() {
      if (this.v20 != null) {
         class_310 var1 = this.v9.v1();
         this.v20.v10((float)uiSupport142.v1(var1), (float)uiSupport142.v2(var1));
      }
   }

   private void v22() {
      if (this.v20 != null) {
         class_310 var1 = this.v9.v1();
         this.v20.v3((float)uiSupport142.v1(var1), (float)uiSupport142.v2(var1));
      }
   }

   public boolean v3() {
      return this.v20 != null && this.v20.v2() || this.v17 != null && this.v17.v2();
   }

   private void v24() {
      class_310 var1 = this.v9.v1();
      if (var1.field_1724 != null) {
         class_1041 var2 = var1.method_22683();
         if (this.v3()) {
            this.v1(var1);
         } else {
            this.v1(var2, var1.field_1690.field_1903);
            this.v1(var2, var1.field_1690.field_1832);
            this.v1(var2, var1.field_1690.field_1867);
            this.v1(var2, var1.field_1690.field_1894);
            this.v1(var2, var1.field_1690.field_1881);
            this.v1(var2, var1.field_1690.field_1913);
            this.v1(var2, var1.field_1690.field_1849);
         }
      }
   }

   private void v1(class_310 var1) {
      this.v44.clear();
      var1.field_1690.field_1903.method_23481(false);
      var1.field_1690.field_1832.method_23481(false);
      var1.field_1690.field_1867.method_23481(false);
      var1.field_1690.field_1894.method_23481(false);
      var1.field_1690.field_1881.method_23481(false);
      var1.field_1690.field_1913.method_23481(false);
      var1.field_1690.field_1849.method_23481(false);
   }

   private void v1(class_1041 var1, class_304 var2) {
      int var3 = class_3675.method_15981(var2.method_1428()).method_1444();
      boolean var4 = class_3675.method_15987(var1, var3);
      Boolean var5 = this.v44.put(var2, var4);
      if (var5 == null || var5 != var4) {
         var2.method_23481(var4);
      }
   }
}
