package cc.syky.hud;

import cc.syky.cloud.cloudSupport57;
import cc.syky.config.SettingRegistry;
import cc.syky.config.configRecord;
import cc.syky.internal.InternalSupport20;
import cc.syky.render.renderSupport47;
import cc.syky.ui.KeySupport;
import cc.syky.ui.SignInSupport;
import cc.syky.ui.UiNode;
import cc.syky.ui.UiScreen;
import cc.syky.ui.uiSupport142;
import cc.syky.ui.uiSupport143;
import cc.syky.ui.uiSupport169;
import cc.syky.ui.uiSupport35;
import cc.syky.ui.uiSupport62;
import cc.syky.ui.uiSupport69;
import cc.syky.ui.uiSupport89;
import cc.syky.ui.uiSupport91;
import net.minecraft.class_1041;
import net.minecraft.class_2960;
import net.minecraft.class_310;
import net.minecraft.class_408;
import org.jetbrains.annotations.Nullable;

public final class HUDEditorSupport {
   private static final String v1 = "_hudglobal";
   private static final float v2 = 15.0F;
   private static final float v3 = 15.0F;
   private static final float v4 = 16.0F;
   private static final float v5 = 18.0F;
   private static final String v6 = "HUD Editor";
   private final HudManager v7;
   @Nullable
   private HudElement v8;
   @Nullable
   private UiScreen v9;
   private final uiSupport91 v10 = new uiSupport91();
   private float v11;
   private float v12;
   private float v13 = 1.0F;
   private boolean v14;
   private boolean v15;
   private boolean v16;
   private boolean v18;
   private final float[] v19 = new float[4];
   private final hudSupport3 v17 = new hudSupport3();
   private float v20;
   private float v21;
   private static final int v22 = 0;
   private static final int v24 = 1;
   private static final int v25 = 2;

   public HUDEditorSupport(HudManager var1) {
      this.v7 = var1;
   }

   public boolean v1() {
      return this.v9 != null && !this.v10.v5();
   }

   @Nullable
   public HudElement v2() {
      return this.v8;
   }

   @Nullable
   public UiScreen v3() {
      return this.v9;
   }

   public boolean v1(float var1, float var2) {
      return this.v9 == null ? false : this.v14 || this.v9.v1(var1, var2);
   }

   public void v1(HudElement var1, float var2, float var3) {
      if (var1 != null) {
         this.v1(var1, var1.v1(), var1.v2().v4(), var2, var3);
      }
   }

   public void v2(float var1, float var2) {
      this.v1(null, "_hudglobal", this.v7.v2().v4(), var1, var2);
   }

   private void v1(@Nullable HudElement var1, String var2, SettingRegistry var3, float var4, float var5) {
      this.v8 = var1;
      this.v13 = this.v11();
      this.v9 = uiSupport69.v1(var2, var3, this.v1(var1), this.v13);
      this.v9.v4(0.0F);
      uiSupport89.v1(this.v9, var4, var5, this.v9.v2(), this.v9.a_(624.0F), this.v13, 0.0F);
      this.v11 = this.v9.v9;
      this.v12 = this.v9.v10;
      this.v10.v1(this.v9, var4, var5);
   }

   private configRecord v1(@Nullable HudElement var1) {
      if (var1 == null) {
         return configRecord.v1("HUD Editor", null);
      } else {
         class_2960 var2 = var1.v38();
         if (!(var1 instanceof LoadingSupport var3)) {
            if (this.v7.v4(var1)) {
               String var9 = this.v2(var1);
               return var9 == null
                  ? configRecord.v1(v4(var1), var2, this.v3(var1))
                  : configRecord.v1(v4(var1), var2, renderSupport47.v1(this.v7.v5()), var9, this.v3(var1));
            } else {
               return configRecord.v1(v4(var1), var2);
            }
         } else {
            InternalSupport20 var4 = var3.v47();
            int var5 = var3.v44();
            configRecord.Part1 var6 = new configRecord.Part1(uiSupport143.v9, 15.0F, 15.0F, "Add one more", var4::v3);
            configRecord.Part1 var7 = var5 == 0 && var4.v2(var5) == null
               ? this.v3(var1)
               : new configRecord.Part1(uiSupport143.v42, 16.0F, 18.0F, "Remove this one", () -> this.v1(var4, var5));
            String var8 = this.v2(var1);
            return var8 == null
               ? configRecord.v1(v4(var1), var2, var6, var7)
               : configRecord.v1(v4(var1), var2, renderSupport47.v1(this.v7.v5()), var8, var6, var7);
         }
      }
   }

   @Nullable
   private String v2(HudElement var1) {
      hudSupport51 var2 = this.v7.v6();
      return var2 != null && this.v7.v5() != null ? var2.v1(var1) : null;
   }

   private configRecord.Part1 v3(HudElement var1) {
      return new configRecord.Part1(uiSupport143.v42, 16.0F, 18.0F, "Remove from HUD", () -> {
         this.v7.v5(var1);
         this.v4();
      });
   }

   private void v1(InternalSupport20 var1, int var2) {
      var1.v5(var2);
      this.v4();
   }

   private static String v4(HudElement var0) {
      String var1 = var0.v1();
      StringBuilder var2 = new StringBuilder(var1.length() + 4);
      var2.append(Character.toUpperCase(var1.charAt(0)));

      for (int var3 = 1; var3 < var1.length(); var3++) {
         char var4 = var1.charAt(var3);
         if (var4 == '_' || var4 == '-') {
            var2.append(' ');
         } else if (Character.isUpperCase(var4)) {
            var2.append(' ').append(Character.toLowerCase(var4));
         } else {
            var2.append(var4);
         }
      }

      return var2.toString();
   }

   public void v4() {
      if (this.v9 != null && !this.v10.v5()) {
         this.v9.e_();
         this.v10.v2();
         this.v12();
      }
   }

   public boolean v5() {
      return this.v1() && renderSupport47.v1(this.v9).v12();
   }

   private void v1(float[] var1) {
      UiScreen var2 = this.v9;
      if (var2 == null) {
         var1[2] = 0.0F;
         var1[3] = 0.0F;
      } else {
         float var3 = hudSupport2.v1(this.v13);
         float var4 = var2.v9 - var3;
         float var5 = var2.v10 - var3;
         float var6 = var2.v9 + var2.v11 + var3;
         float var7 = var2.v10 + var2.v12 + var3;
         UiNode var8 = var2.v13();

         while (var8 != null) {
            var4 = Math.min(var4, var8.v9 - var3);
            var5 = Math.min(var5, var8.v10 - var3);
            var6 = Math.max(var6, var8.v9 + var8.v11 + var3);
            var7 = Math.max(var7, var8.v10 + var8.v12 + var3);
            var8 = var8 instanceof uiSupport69 var9 ? var9.v13() : null;
         }

         var1[0] = var4;
         var1[1] = var5;
         var1[2] = var6 - var4;
         var1[3] = var7 - var5;
      }
   }

   public void v6() {
      if (this.v9 != null) {
         this.v12();
         this.v7();
      }
   }

   public void v7() {
      if (this.v9 != null) {
         this.v9 = null;
         this.v8 = null;
         this.v10.v3();
         this.v14 = false;
         this.v15 = false;
         this.v16 = false;
         this.v17.v3();
      }
   }

   public boolean v1(int var1, float var2, float var3) {
      if (v10()) {
         return false;
      } else {
         this.v20 = var2;
         this.v21 = var3;
         UiScreen var4 = this.v9;
         if (var4 != null && !this.v10.v5() && var1 != 0 && var1 != 1) {
            boolean var5 = var4.v1(var2, var3) ? var4.v1(var2, var3, var1) : var4.v2(var2, var3, var1);
            if (var5) {
               this.v14 = true;
               return true;
            }
         }

         if (var1 == 1) {
            return this.v3(var2, var3);
         } else if (var1 == 2) {
            return this.v4(var2, var3);
         } else if (var1 != 0 || this.v9 == null) {
            return false;
         } else if (this.v10.v5()) {
            this.v14 = this.v9.v1(var2, var3);
            return this.v14;
         } else {
            this.v14 = true;
            if (this.v9.v3(var2, var3)) {
               this.v15 = true;
               this.v9.v4(var2, var3);
               this.v16 = this.v9.v5(0.0F, 0.0F);
               if (!this.v16 && hudSupport.v1()) {
                  this.v17.v1(this.v9.v9, this.v9.v10, this.v9.v11, this.v9.v12, var2, var3);
               }

               return true;
            } else {
               if (this.v9.v1(var2, var3)) {
                  this.v9.v1(var2, var3, 0);
               } else if (!this.v9.v12()) {
                  this.v4();
               }

               return true;
            }
         }
      }
   }

   private void v1(class_310 var1, float var2, float var3) {
      UiScreen var4 = this.v9;
      if (var4 != null) {
         float var5 = var4.v2() * this.v13;
         float var6 = var4.a_(624.0F) * this.v13;
         float var7 = var1.method_22683().method_4486();
         float var8 = var1.method_22683().method_4502();
         this.v11 = Math.max(0.0F, Math.min(this.v11 + var2, Math.max(0.0F, var7 - var5)));
         this.v12 = Math.max(0.0F, Math.min(this.v12 + var3, Math.max(0.0F, var8 - var6)));
      }
   }

   private boolean v3(float var1, float var2) {
      if (this.v9 != null && this.v9.v1(var1, var2)) {
         if (this.v10.v5() || !(this.v9 instanceof uiSupport69 var5 && v1(var5, var1, var2))) {
            this.v4();
         }

         return true;
      } else if (this.v7.v3().v1()) {
         return false;
      } else {
         HudElement var3 = hudSupport31.v1(this.v7, var1, var2, hudSupport31.v2);
         if (var3 != null) {
            this.v7.v3().v1(var3);
            this.v1(var3, var1, var2);
         } else {
            if (this.v7.v3().v1(var1, var2)) {
               return false;
            }

            this.v2(var1, var2);
         }

         return true;
      }
   }

   private static boolean v1(uiSupport69 var0, float var1, float var2) {
      boolean var3 = var0.v7();
      var0.v1(var1, var2, 1);
      return var3 || var0.v7();
   }

   private boolean v4(float var1, float var2) {
      if (this.v9 != null && this.v9.v1(var1, var2)) {
         return true;
      } else if (this.v7.v3().v1()) {
         return false;
      } else {
         HudElement var3 = hudSupport31.v1(this.v7, var1, var2, hudSupport31.v2);
         if (var3 == null) {
            return false;
         } else {
            this.v2(var3, var1, var2);
            return true;
         }
      }
   }

   public void v2(HudElement var1, float var2, float var3) {
      hudSupport75 var4 = this.v7.v5();
      String var5 = this.v2(var1);
      if (var1 != null && var4 != null && var5 != null) {
         this.v8 = var1;
         this.v13 = this.v11();
         KeySupport var6 = new KeySupport(var5, var4, this.v13, this::v4);
         this.v9 = var6;
         var6.v4(0.0F);
         uiSupport89.v1(var6, var2, var3, var6.v2(), var6.a_(624.0F), this.v13, 0.0F);
         this.v11 = var6.v9;
         this.v12 = var6.v10;
         this.v10.v1(var6, var2, var3);
      }
   }

   public void v1(boolean var1) {
      class_310 var2 = class_310.method_1551();
      if (var2 != null && var2.method_22683() != null) {
         if (!var1) {
            this.v6();
         } else {
            boolean var3 = cloudSupport57.v1(var2.method_22683(), 0);
            float var4 = (float)uiSupport142.v1(var2);
            float var5 = (float)uiSupport142.v2(var2);
            if (this.v14) {
               if (var3) {
                  if (this.v15) {
                     float var6 = var4 - this.v20;
                     float var7 = var5 - this.v21;
                     if (!renderSupport47.v1(this.v9).v5(var6, var7) && !this.v16) {
                        this.v1(var2, var6, var7);
                     }
                  } else if (this.v9 != null) {
                     this.v9.v1(var4, var5, 0, var4 - this.v20, var5 - this.v21);
                  }
               } else {
                  this.v14 = false;
                  if (this.v15) {
                     this.v15 = false;
                     renderSupport47.v1(this.v9).v16();
                     if (!this.v16) {
                        this.v17.v1();
                     }

                     this.v16 = false;
                  } else if (this.v9 != null) {
                     this.v9.v4(var4, var5, 0);
                  }
               }
            }

            if (this.v1() && !this.v15 && (var4 != this.v20 || var5 != this.v21)) {
               renderSupport47.v1(this.v9).v11(var4, var5);
            }

            this.v20 = var4;
            this.v21 = var5;
         }
      }
   }

   public boolean v8() {
      return this.v1() && renderSupport47.v1(this.v9).v3();
   }

   public boolean v1(int var1, int var2) {
      this.v18 = false;
      if (!this.v8()) {
         return false;
      } else {
         UiScreen var3 = renderSupport47.v1(this.v9);
         if (var1 == 256) {
            var3.e_();
            return true;
         } else {
            boolean var4 = var3.v2(var1, var2);
            this.v18 = var4 && !var3.v3();
            return var4;
         }
      }
   }

   public boolean v2(int var1, int var2) {
      if (this.v18) {
         this.v18 = false;
         return true;
      } else {
         return this.v8() && renderSupport47.v1(this.v9).v3(var1, var2);
      }
   }

   public boolean v1(float var1, float var2, double var3, double var5) {
      return this.v9 != null && this.v9.v1(var1, var2) ? this.v10.v5() || this.v9.v1(var1, var2, var3, var5) : false;
   }

   public void v9() {
      if (this.v9 != null) {
         class_310 var1 = class_310.method_1551();
         if (var1 != null && var1.method_22683() != null) {
            if (!(var1.field_1755 instanceof class_408)) {
               this.v6();
            } else if (v10()) {
               this.v6();
            } else if (this.v8 != null && !this.v8.v10()) {
               this.v6();
            } else {
               float var2 = this.v10.v4();
               if (this.v10.v6()) {
                  this.v6();
               } else {
                  uiSupport169.v9();
                  uiSupport169.v1(null);

                  try {
                     this.v9.v10();
                     this.v9.v1(!this.v15 || this.v16);
                     this.v1(var1);
                     this.v9.v11();
                     if (hudSupport.v1()) {
                        this.v17.v1(this.v9.v9, this.v9.v10, this.v9.v11, this.v9.v12, hudSupport.v3());
                     } else {
                        this.v17.v3();
                     }

                     float var3 = (float)uiSupport142.v1(var1);
                     float var4 = (float)uiSupport142.v2(var1);
                     uiSupport35 var5 = new uiSupport35(
                        var3, var4, var1.method_61966().method_60636(), var1.method_22683().method_4486(), var1.method_22683().method_4502()
                     );
                     this.v1(this.v19);
                     uiSupport62.v1(this.v13);
                     boolean var6 = hudSupport2.v1(
                        this.v17, this.v9.v9, this.v9.v10, this.v9.v11, this.v9.v12, this.v13, this.v19[0], this.v19[1], this.v19[2], this.v19[3]
                     );

                     try {
                        boolean var7 = this.v10.v1(this.v9, this.v13);

                        try {
                           this.v9.v1(var5);
                        } finally {
                           if (var7) {
                              this.v10.v7();
                           }
                        }
                     } finally {
                        if (var6) {
                           hudSupport2.v1();
                        }
                     }

                     if (this.v9 instanceof uiSupport69 var23) {
                        var23.v1(var5, var2, 1.0F, 1.0F, 0.0F);
                     }
                  } finally {
                     uiSupport169.v10();
                     uiSupport169.v15();
                  }
               }
            }
         }
      }
   }

   private void v1(class_310 var1) {
      UiScreen var2 = renderSupport47.v1(this.v9);
      float var3 = var2.v2() * this.v13;
      float var4 = var2.a_(624.0F) * this.v13;
      float var5 = var1.method_22683().method_4486();
      float var6 = var1.method_22683().method_4502();
      float var7 = uiSupport89.v1(this.v11, var3, 0.0F, var5);
      float var8 = uiSupport89.v1(this.v12, var4, 0.0F, var6);
      var2.v1(uiSupport169.v1(var7), uiSupport169.v1(var8), uiSupport169.v1(var3), var4);
   }

   private static boolean v10() {
      class_310 var0 = class_310.method_1551();
      return var0 != null && var0.field_1690 != null && var0.field_1690.field_1842;
   }

   private float v11() {
      class_1041 var1 = class_310.method_1551().method_22683();
      return SignInSupport.v2(var1.method_4486(), var1.method_4502()) / 984.0F;
   }

   private void v12() {
      this.v7.v13();
   }
}
