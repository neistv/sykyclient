package cc.syky.ui;

import cc.syky.hud.hudSupport54;
import cc.syky.render.font.MsdfFont;
import net.minecraft.class_2960;
import net.minecraft.class_310;
import org.jetbrains.annotations.Nullable;

public final class HEXSupport extends UiNode {
   private static final String v2 = "syky_sans_strong";
   private static final class_2960 v3 = class_2960.method_60655("syky", "textures/ui/icons/check.png");
   private static final String v4 = "HEX";
   private static final float v5 = 13.0F;
   private static final int v6 = 1509949439;
   private static final float v7 = 12.0F;
   private static final float v8 = 30.0F;
   public static final float v1 = 30.0F;
   private static final float v13 = 8.0F;
   private static final float v14 = 8.0F;
   private static final int v15 = SignInSupport.v1(153);
   private static final int v16 = 452984831;
   private static final int v18 = 184549375;
   private static final float v19 = 60.0F;
   private static final float v17 = 30.0F;
   private static final float v20 = 13.5F;
   private static final int v21 = -419430401;
   private static final int v22 = 1090519039;
   private static final float v24 = 10.0F;
   private static final float v25 = 1.0F;
   private static final float v26 = 16.0F;
   private static final float v27 = 7.0F;
   private static final float v28 = 4.0F;
   private static final float v29 = 8.0F;
   private static final float v30 = 15.0F;
   private static final float v32 = 1.3F;
   private static final int v23 = -1711276033;
   private static final int v33 = -218103809;
   private static final long v31 = 900L;
   private static final int v34 = 9;
   private static final int v36 = 4;
   private final HEXSupport.Part1 v38;
   private final MsdfFont v42;
   private final MsdfFont v43;
   private float v37;
   private int v48 = -1;
   private int v40 = -1;
   private boolean v44;
   private boolean v47;
   private long v49 = Long.MIN_VALUE;
   private float v46;
   private float v51;
   private float v50;
   private float v60;
   private float v59;
   private float v53;
   private float v63;
   private float v64;
   private float v61;
   private float v66;

   public HEXSupport(HEXSupport.Part1 var1, float var2) {
      this.v38 = var1;
      this.v37 = var2;
      this.v42 = new MsdfFont("syky_sans_strong", 9, this::v1);
      this.v43 = new MsdfFont("syky_sans_strong", 4, this::v2);
      v1(this.v42);
      v1(this.v43);
   }

   private static void v1(MsdfFont var0) {
      var0.v1(-419430401, -419430401, 1090519039, -419430401);
   }

   public void v1(float var1) {
      this.v37 = var1;
   }

   public boolean v1() {
      return this.v42.v3() || this.v43.v3();
   }

   public void v2() {
      this.v42.v3(false);
      this.v43.v3(false);
   }

   private void v3() {
      float var1 = this.v37;
      this.v60 = SignInSupport.v4(30.0F, var1);
      this.v50 = this.v10 + uiSupport169.v1((this.v12 - this.v60) * 0.5F);
      this.v66 = SignInSupport.v4(30.0F, var1);
      this.v61 = this.v9 + this.v11 - this.v66;
      this.v64 = SignInSupport.v4(60.0F, var1);
      this.v63 = this.v61 - SignInSupport.v4(8.0F, var1) - this.v64;
      float var2 = this.v4() * 13.0F * var1;
      this.v59 = this.v9 + var2 + 12.0F * var1;
      this.v53 = Math.max(0.0F, this.v63 - 8.0F * var1 - this.v59);
      float var3 = this.v59 + 31.0F * var1;
      this.v42.v1(var3, this.v50, Math.max(0.0F, this.v59 + this.v53 - 10.0F * var1 - var3), this.v60);
      this.v43.v1(this.v63 + 10.0F * var1, this.v50, Math.max(0.0F, this.v64 - 20.0F * var1), this.v60);
      float var4 = this.v2(13.5F * var1);
      this.v42.v1(13.5F * var1, var4 - this.v50, 1.0F * var1);
      this.v43.v1(13.5F * var1, var4 - this.v50, 1.0F * var1);
   }

   private float v2(float var1) {
      return this.v50 + (this.v60 - var1 * this.v5()) / 2.0F;
   }

   private float v4() {
      if (this.v46 <= 0.0F) {
         this.v46 = uiSupport169.v2("syky_sans_strong", "HEX", 1.0F);
      }

      return this.v46;
   }

   private float v5() {
      if (this.v51 <= 0.0F) {
         this.v51 = uiSupport169.v2("syky_sans_strong");
      }

      return this.v51;
   }

   @Override
   public void v1(uiSupport35 var1) {
      this.v3();
      this.v6();
      float var2 = this.v37;
      int var3 = this.v38.v1();
      uiSupport169.v1("syky_sans_strong", "HEX", this.v9, this.v2(13.0F * var2), 13.0F * var2, 1509949439);
      this.v1(var1, this.v59, this.v53, this.v42.v3());
      float var4 = 16.0F * var2;
      uiSupport169.v1(this.v59 + 7.0F * var2, this.v50 + (this.v60 - var4) / 2.0F, var4, var4, 0xFF000000 | var3 & 16777215, 4.0F * var2);
      this.v42.v1(var1);
      this.v1(var1, this.v63, this.v64, this.v43.v3());
      this.v43.v1(var1);
      this.v2(var1);
   }

   private void v1(uiSupport35 var1, float var2, float var3, boolean var4) {
      float var5 = 8.0F * this.v37;
      uiSupport169.v1(var2, this.v50, var3, this.v60, v15, var5);
      int var6 = var4 ? 452984831 : (this.v1(var1, var2, var3) ? 184549375 : 0);
      if (var6 != 0) {
         uiSupport169.v1(var2, this.v50, var3, this.v60, var6, var5);
      }
   }

   private void v2(uiSupport35 var1) {
      boolean var2 = var1.v2() && this.v3(var1.v1, var1.v2);
      float var3 = 8.0F * this.v37;
      uiSupport169.v1(this.v61, this.v50, this.v66, this.v60, v15, var3);
      if (var2) {
         uiSupport169.v1(this.v61, this.v50, this.v66, this.v60, 184549375, var3);
      }

      float var4 = this.v61 + this.v66 / 2.0F;
      float var5 = this.v50 + this.v60 / 2.0F;
      int var6 = var2 ? -218103809 : -1711276033;
      if (v8() < this.v49) {
         float var7 = 15.0F * this.v37;
         uiSupport169.v1(v3, var4 - var7 / 2.0F, var5 - var7 / 2.0F, var7, var7, var6, uiRecord7.ZERO);
      } else {
         this.v2(var4, var5, var6);
      }
   }

   private void v2(float var1, float var2, int var3) {
      float var4 = 15.0F * this.v37;
      float var5 = 1.3F * this.v37;
      float var6 = var4 * 0.68F;
      float var7 = var4 * 0.78F;
      float var8 = var4 * 0.26F;
      float var9 = var1 - (var6 + var8) / 2.0F;
      float var10 = var2 - (var7 + var8) / 2.0F;
      uiSupport169.v1(var9, var10 + var8, var6, var7, var3, var5, var4 * 0.16F);
      uiSupport169.v1(var9 + var8, var10, var6, var5, var3, var5 / 2.0F);
      uiSupport169.v1(var9 + var8 + var6 - var5, var10, var5, var7, var3, var5 / 2.0F);
   }

   private void v6() {
      boolean var1 = this.v42.v3();
      boolean var2 = this.v43.v3();
      if (var1 != this.v44) {
         this.v44 = var1;
         this.v48 = -1;
      }

      if (var2 != this.v47) {
         this.v47 = var2;
         this.v40 = -1;
      }

      int var3 = this.v38.v1();
      int var4 = var3 & 16777215;
      int var5 = var3 >>> 24 & 0xFF;
      if (!var1 && var4 != this.v48) {
         this.v42.v2(uiSupport83.v1(var3));
         this.v48 = var4;
      }

      if (!var2 && var5 != this.v40) {
         this.v43.v2(uiSupport83.v3(var5));
         this.v40 = var5;
      }
   }

   private void v1(String var1) {
      int var2 = uiSupport83.v1(var1);
      if (var2 != -1) {
         int var3 = uiSupport83.v2(var1);
         if (var3 != -1) {
            this.v38.v2(var3);
         }

         this.v38.v1(var2);
      }
   }

   private void v2(String var1) {
      int var2 = uiSupport83.v3(var1);
      if (var2 != -1) {
         this.v38.v2(uiSupport83.v4(var2));
      }
   }

   @Override
   public boolean v1(float var1, float var2, int var3) {
      this.v3();
      if (var3 != 0 || !this.v1(var1, var2)) {
         return false;
      } else if (this.v3(var1, var2)) {
         this.v7();
         this.v2();
         return true;
      } else if (this.v2(this.v59, this.v53, var1, var2)) {
         return this.v1(this.v42, this.v43, var1, var2, var3);
      } else if (this.v2(this.v63, this.v64, var1, var2)) {
         return this.v1(this.v43, this.v42, var1, var2, var3);
      } else {
         this.v2();
         return false;
      }
   }

   private boolean v1(MsdfFont var1, MsdfFont var2, float var3, float var4, int var5) {
      var2.v3(false);
      boolean var6 = var1.v3();
      boolean var7 = var1.v2(var3, var4, var5);
      if (!var6) {
         var1.v4();
      }

      return var7;
   }

   @Override
   public boolean v1(float var1, float var2, int var3, float var4, float var5) {
      return this.v42.v1(var1, var2, var3, var4, var5) || this.v43.v1(var1, var2, var3, var4, var5);
   }

   @Override
   public boolean v4(float var1, float var2, int var3) {
      return this.v42.v4(var1, var2, var3) || this.v43.v4(var1, var2, var3);
   }

   @Override
   public boolean v2(int var1, int var2) {
      return this.v42.v2(var1, var2) || this.v43.v2(var1, var2);
   }

   @Override
   public boolean v3(int var1, int var2) {
      return this.v42.v3(var1, var2) || this.v43.v3(var1, var2);
   }

   @Override
   public hudSupport54 v2(float var1, float var2) {
      this.v3();
      if (this.v3(var1, var2)) {
         return hudSupport54.POINTER;
      } else {
         return !this.v2(this.v59, this.v53, var1, var2) && !this.v2(this.v63, this.v64, var1, var2) ? hudSupport54.ARROW : hudSupport54.IBEAM;
      }
   }

   @Nullable
   @Override
   public hudSupport54 v31() {
      hudSupport54 var1 = this.v42.v31();
      return var1 != null ? var1 : this.v43.v31();
   }

   private boolean v1(uiSupport35 var1, float var2, float var3) {
      return var1.v2() && this.v2(var2, var3, var1.v1, var1.v2);
   }

   private boolean v2(float var1, float var2, float var3, float var4) {
      return var3 >= var1 && var3 <= var1 + var2 && var4 >= this.v50 && var4 <= this.v50 + this.v60;
   }

   private boolean v3(float var1, float var2) {
      return this.v2(this.v61, this.v66, var1, var2);
   }

   private void v7() {
      class_310 var1 = class_310.method_1551();
      if (var1 != null && var1.field_1774 != null) {
         var1.field_1774.method_1455(uiSupport83.v2(this.v38.v1()));
         this.v49 = v8() + 900L;
      }
   }

   private static long v8() {
      return System.nanoTime() / 1000000L;
   }

   public interface Part1 {
      int v1();

      void v1(int var1);

      void v2(int var1);
   }
}
