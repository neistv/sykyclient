package cc.syky.hud;

import cc.syky.account.accountSupport4;
import cc.syky.cloud.cloudSupport101;
import cc.syky.cloud.cloudSupport14;
import cc.syky.cloud.cloudSupport57;
import cc.syky.module.visual.ViewModel;
import cc.syky.ui.uiSupport28;
import cc.syky.ui.uiSupport29;
import cc.syky.ui.uiSupport30;
import cc.syky.ui.uiSupport31;
import java.util.ArrayList;
import java.util.List;
import net.minecraft.class_1041;
import net.minecraft.class_310;
import net.minecraft.class_312;
import net.minecraft.class_3675;
import net.minecraft.class_408;
import org.jetbrains.annotations.Nullable;

public final class hudSupport32 {
   private static final float v1 = hudSupport61.v1(0.46666664F);
   private final HudManager v2;
   private final cloudSupport101 v3;
   private final hudSupport37 v4 = new hudSupport37();
   private final uiSupport28 v5 = new uiSupport28();
   private final hudSupport34 v6;
   private final cloudSupport14 v7;
   private final accountSupport4 v8;
   private final uiSupport31 v9 = new uiSupport31();
   private final uiSupport30 v10 = new uiSupport30();
   private final List<hudRecord4> v11 = new ArrayList<>();
   private final List<HudElement> v12 = new ArrayList<>();
   private boolean v13;
   private boolean v14;
   private int v15;
   private float v16;
   private float v18;
   private boolean v19;
   private boolean v17;
   private float v20;
   private float v21;
   private boolean v22;
   @Nullable
   private HudElement v24;
   private final hudSupport61 v25 = new hudSupport61(1600.0F);
   private long v26;
   private boolean v27;

   public hudSupport32(HudManager var1, cloudSupport101 var2) {
      this.v2 = var1;
      this.v3 = var2;
      this.v6 = new hudSupport34(var1, var2, this.v4, this.v5);
      this.v7 = new cloudSupport14(var1, this.v4, this.v5, this.v6);
      this.v8 = new accountSupport4(var2);
   }

   public void v1(ViewModel var1) {
      this.v8.v1(var1);
   }

   public boolean v1() {
      return this.v7.v1() || this.v8.v1();
   }

   public uiSupport28 v2() {
      return this.v5;
   }

   public void v1(boolean var1, float var2, float var3, float var4) {
      this.v4.v1(var2, var3, var4);
      if (!var1) {
         if (this.v13) {
            this.v12();
         }

         this.v13();
      } else {
         class_310 var5 = this.v3.v1();
         class_1041 var6 = var5 == null ? null : var5.method_22683();
         if (var6 != null) {
            this.v13 = true;
            boolean var7 = cloudSupport57.v1(var6, 0);
            boolean var8 = class_3675.method_15987(var6, 340) || class_3675.method_15987(var6, 344);
            boolean var9 = class_3675.method_15987(var6, 341) || class_3675.method_15987(var6, 345);
            this.v22 = class_3675.method_15987(var6, 342) || class_3675.method_15987(var6, 346);
            this.v20 = (float)class_312.method_68880(var6, var5.field_1729.method_1603());
            this.v21 = (float)class_312.method_68884(var6, var5.field_1729.method_1604());
            this.v5.v7();
            HUDEditorSupport var10 = this.v2.v1();
            hudSupport53.v1(hudSupport35.v1(this, var10), var7, hudSupport35.v1(this.v2, var10, this.v20, this.v21));
            this.v8.v1(var2, var3);
            if (this.v14) {
               this.v14 = false;
               boolean var11 = !this.v19 && this.v2(this.v16, this.v18) && this.v8.v1(this.v15, this.v16, this.v18);
               if (!var11 && this.v15 == 0) {
                  this.v7.v1(this.v16, this.v18, var8, this.v19);
               }
            }

            this.v8.v1(var6, this.v20, this.v21, var10);
            this.v7.v1(var7, this.v20, this.v21, var8, var9);
            this.v24 = !this.v1() && !var10.v1(this.v20, this.v21) ? hudSupport31.v1(this.v2, this.v20, this.v21, hudSupport31.v1) : null;
            this.v14();
            this.v13();
         }
      }
   }

   private void v12() {
      this.v13 = false;
      this.v7.v1(this.v20, this.v21);
      this.v8.v2();
      this.v5.v6();
      this.v24 = null;
      this.v10.v1();
      this.v14 = false;
      this.v17 = false;
   }

   public void v3() {
      this.v7.v2(this.v20, this.v21);
      this.v8.v2();
      this.v5.v6();
      this.v6.v7();
      this.v24 = null;
      this.v10.v1();
      this.v14 = false;
      this.v27 = false;
   }

   private void v13() {
      long var1 = System.nanoTime();
      float var3 = this.v26 == 0L ? 0.0F : Math.min(100.0F, (float)(var1 - this.v26) / 1000000.0F);
      this.v26 = var1;
      boolean var4 = this.v13 && !this.v5.v3();
      if (!var4) {
         this.v25.v1(v1, var1);
         if (!this.v27 && (!this.v13 || this.v24 == null)) {
            return;
         }
      }

      float var5 = 0.3F * this.v25.v1(var1);
      float var6 = 1.0F - (float)Math.exp(-var3 / 90.0F);
      boolean var7 = false;

      for (HudElement var9 : this.v2.v9()) {
         float var10 = 0.0F;
         if (this.v13) {
            if (this.v5.v1(var9)) {
               var10 = var5;
            } else if (var9 == this.v24) {
               var10 = 0.14F;
            }
         }

         float var11 = var9.v34();
         if (var11 == var10) {
            var7 |= var11 > 0.0F;
         } else {
            var11 += (var10 - var11) * var6;
            if (Math.abs(var11 - var10) < 0.002F) {
               var11 = var10;
            }

            var9.v6(var11);
            var7 |= var11 > 0.0F;
         }
      }

      this.v27 = var7;
   }

   private void v14() {
      this.v10.v1();
      if (this.v22) {
         float var1 = this.v4.v3;
         if (this.v7.v3()) {
            this.v7.v1(this.v12);
            this.v6.v1(this.v11, this.v12);
            uiSupport29.v1(this.v7.v4(), this.v11, this.v4.v1, this.v4.v2, var1, this.v10);
         } else if (!this.v7.v1() || this.v7.v2()) {
            if (!this.v5.v3()) {
               hudRecord4 var2 = this.v5.v8();
               if (!var2.v1()) {
                  if (this.v24 != null && !this.v5.v1(this.v24)) {
                     uiSupport29.v1(var2, this.v24.v27(), var1, this.v10);
                  } else {
                     this.v6.v1(this.v11, this.v5.v1());
                     uiSupport29.v1(var2, this.v11, this.v4.v1, this.v4.v2, var1, this.v10);
                  }
               }
            } else {
               if (this.v24 != null) {
                  this.v12.clear();
                  this.v12.add(this.v24);
                  this.v6.v1(this.v11, this.v12);
                  uiSupport29.v1(this.v24.v27(), this.v11, this.v4.v1, this.v4.v2, var1, this.v10);
               }
            }
         }
      }
   }

   public void v1(int var1, float var2, float var3) {
      if (this.v16()) {
         if (var1 == 0 || this.v1(var2, var3)) {
            this.v14 = true;
            this.v15 = var1;
            this.v16 = var2;
            this.v18 = var3;
            this.v19 = false;
         }
      }
   }

   public boolean v1(float var1, float var2) {
      return this.v16() && !this.v1() && this.v2(var1, var2) && this.v8.v1(var1, var2, true) >= 0;
   }

   public boolean v1(float var1, float var2, double var3) {
      if (this.v16() && !this.v1() && this.v2(var1, var2)) {
         class_310 var5 = this.v3.v1();
         class_1041 var6 = var5 == null ? null : var5.method_22683();
         if (var6 == null) {
            return false;
         } else {
            boolean var7 = class_3675.method_15987(var6, 340) || class_3675.method_15987(var6, 344);
            boolean var8 = class_3675.method_15987(var6, 341) || class_3675.method_15987(var6, 345);
            return this.v8.v1(var1, var2, var3, var7, var8);
         }
      } else {
         return false;
      }
   }

   private boolean v2(float var1, float var2) {
      return !this.v2.v1().v1(var1, var2) && hudSupport31.v1(this.v2, var1, var2, hudSupport31.v2) == null;
   }

   public void v4() {
      if (this.v14) {
         this.v19 = true;
      }
   }

   public void v1(HudElement var1) {
      if (var1 != null && var1.v42() && !this.v5.v1(var1)) {
         this.v5.v2(var1);
      }
   }

   public boolean v1(int var1, int var2, boolean var3) {
      this.v17 = false;
      if (!this.v16()) {
         return false;
      } else {
         boolean var4 = (var2 & 1) != 0;
         boolean var5 = (var2 & 2) != 0;
         boolean var6 = (var2 & 4) != 0;
         boolean var7 = this.v15();
         if (var1 == 256) {
            if (this.v8.v1()) {
               return false;
            } else if (this.v7.v7()) {
               return true;
            } else {
               HUDEditorSupport var12 = this.v2.v1();
               if (var12.v1()) {
                  if (!var12.v5()) {
                     var12.v4();
                  }

                  return true;
               } else if (!this.v5.v3()) {
                  this.v5.v6();
                  return true;
               } else {
                  return false;
               }
            }
         } else {
            boolean var8 = var1 == 263 || var1 == 262 || var1 == 265 || var1 == 264;
            if (!this.v1()) {
               switch (var1) {
                  case 65:
                     if (var5 && !var7 && !var4 && var3) {
                        this.v6.v4();
                        return true;
                     }
                     break;
                  case 89:
                     if (var5 && !var7 && !var4) {
                        return this.v6.v6();
                     }
                     break;
                  case 90:
                     if (var5 && !var7) {
                        return var4 ? this.v6.v6() : this.v6.v5();
                     }
                     break;
                  case 261:
                     if (!this.v5.v3() && var3) {
                        return this.v6.v3();
                     }
                     break;
                  case 262:
                  case 263:
                  case 264:
                  case 265:
                     if (!this.v5.v3() && var3) {
                        int var9 = var4 ? 10 : 1;
                        int var10 = var1 == 263 ? -var9 : (var1 == 262 ? var9 : 0);
                        int var11 = var1 == 265 ? -var9 : (var1 == 264 ? var9 : 0);
                        return this.v6.v1(var10, var11);
                     }

                     return false;
               }

               if (var6 && !var5 && !var7 && !this.v5.v3()) {
                  hudSupport36.Part1 var13 = v1(var1, var4);
                  if (var13 != null) {
                     this.v6.v1(var13);
                     this.v17 = true;
                     return true;
                  }
               }

               return false;
            } else {
               return var8 && !this.v5.v3() && var3;
            }
         }
      }
   }

   public boolean v1(int var1, int var2) {
      boolean var3 = this.v17 && (var2 & 4) != 0;
      this.v17 = false;
      return var3;
   }

   @Nullable
   private static hudSupport36.Part1 v1(int var0, boolean var1) {
      if (var0 == 72) {
         return var1 ? hudSupport36.Part1.DISTRIBUTE_H : hudSupport36.Part1.CENTER_H;
      } else if (var0 == 86) {
         return var1 ? hudSupport36.Part1.DISTRIBUTE_V : hudSupport36.Part1.CENTER_V;
      } else if (var1) {
         return null;
      } else {
         return switch (var0) {
            case 65 -> hudSupport36.Part1.LEFT;
            case 68 -> hudSupport36.Part1.RIGHT;
            case 83 -> hudSupport36.Part1.BOTTOM;
            case 87 -> hudSupport36.Part1.TOP;
            default -> null;
         };
      }
   }

   private boolean v15() {
      class_310 var1 = this.v3.v1();
      class_1041 var2 = var1 == null ? null : var1.method_22683();
      return var2 != null && class_3675.method_15987(var2, 346);
   }

   private boolean v16() {
      if (!this.v13) {
         return false;
      } else {
         class_310 var1 = this.v3.v1();
         return var1 != null && var1.field_1755 instanceof class_408 && !var1.field_1690.field_1842;
      }
   }

   public void v5() {
      if (this.v16()) {
         this.v9.v1(this);
      }
   }

   public void v6() {
      if (this.v16()) {
         this.v9.v2(this);
      }
   }

   public hudSupport37 v7() {
      return this.v4;
   }

   public HudManager v8() {
      return this.v2;
   }

   public cloudSupport14 v9() {
      return this.v7;
   }

   public uiSupport30 v10() {
      return this.v10;
   }

   @Nullable
   public hudSupport54 v11() {
      return this.v7.v6();
   }
}
