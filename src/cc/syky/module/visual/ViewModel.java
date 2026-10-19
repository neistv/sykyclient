package cc.syky.module.visual;

import cc.syky.account.accountSupport12;
import cc.syky.api.ModuleInfo;
import cc.syky.config.BooleanSetting;
import cc.syky.config.FloatSetting;
import cc.syky.config.SettingCondition;
import cc.syky.hud.hudSupport60;
import cc.syky.module.Module;
import cc.syky.module.ModuleCategory;
import cc.syky.ui.uiRecord14;
import net.fabricmc.fabric.api.client.rendering.v1.world.WorldRenderContext;
import net.minecraft.class_1306;
import net.minecraft.class_310;
import net.minecraft.class_746;
import org.jetbrains.annotations.Nullable;
import org.joml.Matrix3f;
import org.joml.Vector3f;
import org.joml.Vector3fc;

@ModuleInfo(
   name = "viewmodel",
   displayName = "ViewModel",
   category = ModuleCategory.VISUAL,
   group = "View & Motion",
   description = "module.viewmodel.description"
)
public final class ViewModel extends Module {
   private static final float name = 12.0F;
   private static final float displayName = 25.0F;
   private static final long category = 400000000L;
   private static final float group = 0.36F;
   private static final float description = 0.64F;
   private static final long defaultEnabled = 2000000000L;
   private static final float subscriptions = 0.1F;
   public static final visualSupport57 v2 = new visualSupport57(10.0F);
   private final FloatSetting mainX = this.settings.add(new FloatSetting("mainX", 0.0F, -1.5F, 1.5F));
   private final FloatSetting mainY = this.settings.add(new FloatSetting("mainY", 0.0F, -1.5F, 1.5F));
   private final FloatSetting mainZ = this.settings.add(new FloatSetting("mainZ", 0.0F, -1.5F, 1.5F));
   private final FloatSetting mainRotX = this.settings.add(new FloatSetting("mainRotX", 0.0F, -180.0F, 180.0F));
   private final FloatSetting mainRotY = this.settings.add(new FloatSetting("mainRotY", 0.0F, -180.0F, 180.0F));
   private final FloatSetting mainRotZ = this.settings.add(new FloatSetting("mainRotZ", 0.0F, -180.0F, 180.0F));
   private final FloatSetting mainScale = this.settings.add(new FloatSetting("mainScale", 1.0F, 0.1F, 3.0F));
   private final BooleanSetting symmetrical = this.settings.add(new BooleanSetting("symmetrical", false));
   private final FloatSetting offX = this.settings.add(new FloatSetting("offX", 0.0F, -1.5F, 1.5F), SettingCondition.v2(this.symmetrical));
   private final FloatSetting offY = this.settings.add(new FloatSetting("offY", 0.0F, -1.5F, 1.5F), SettingCondition.v2(this.symmetrical));
   private final FloatSetting offZ = this.settings.add(new FloatSetting("offZ", 0.0F, -1.5F, 1.5F), SettingCondition.v2(this.symmetrical));
   private final FloatSetting offRotX = this.settings.add(new FloatSetting("offRotX", 0.0F, -180.0F, 180.0F), SettingCondition.v2(this.symmetrical));
   private final FloatSetting offRotY = this.settings.add(new FloatSetting("offRotY", 0.0F, -180.0F, 180.0F), SettingCondition.v2(this.symmetrical));
   private final FloatSetting offRotZ = this.settings.add(new FloatSetting("offRotZ", 0.0F, -180.0F, 180.0F), SettingCondition.v2(this.symmetrical));
   private final FloatSetting offScale = this.settings.add(new FloatSetting("offScale", 1.0F, 0.1F, 3.0F), SettingCondition.v2(this.symmetrical));
   private final BooleanSetting swapHands = this.settings.add(new BooleanSetting("swapHands", false));
   private float v27;
   private float v28;
   private float v29;
   private float v30;
   private float v32;
   private float v23;
   private float v33 = 1.0F;
   private float v31;
   private float v34;
   private float v36;
   private float v38;
   private float v42;
   private float v43;
   private float v37 = 1.0F;
   private long v48;
   private long v40;
   @Nullable
   private class_1306 v44;
   private int v47 = -1;
   private final Vector3f v49 = new Vector3f();
   private final Vector3f v46 = new Vector3f();
   private final Vector3f v51 = new Vector3f();
   private boolean v50;
   private final Vector3f[] v60 = new Vector3f[]{new Vector3f(), new Vector3f()};
   private final long[] v59 = new long[2];
   private final Vector3f v53 = new Vector3f();
   private final Vector3f v63 = new Vector3f();
   private final Vector3f v64 = new Vector3f();
   private long v61;
   private final uiRecord14 v66;

   public ViewModel(uiRecord14 var1) {
      this.v66 = var1;
   }

   @Override
   public void onEnableHook() {
      this.v24();
      this.v48 = 0L;
      v2.v1(true);
      this.v25();
   }

   @Override
   public void onTickHook() {
      v2.v1();
   }

   @Override
   public void onDisableHook() {
      v2.v1(false);
      this.v48 = 0L;
      this.v47 = -1;
      this.v61 = 0L;
      this.v59[0] = 0L;
      this.v59[1] = 0L;
      visualSupport51.v1();
      this.v9(false);
   }

   @Override
   public void onWorldRenderContext(WorldRenderContext var1) {
      this.v22();
      long var2 = System.nanoTime();
      float var4 = this.v48 == 0L ? 0.0F : Math.min((float)(var2 - this.v48) / 1.0E9F, 0.1F);
      this.v48 = var2;
      float var5 = var2 - this.v40 < 400000000L ? 25.0F : 12.0F;
      float var6 = var4 <= 0.0F ? 0.0F : 1.0F - (float)Math.exp(-var5 * var4);
      this.v27 = this.v27 + (this.mainX.getValue() - this.v27) * var6;
      this.v28 = this.v28 + (this.mainY.getValue() - this.v28) * var6;
      this.v29 = this.v29 + (this.mainZ.getValue() - this.v29) * var6;
      this.v30 = this.v30 + (this.mainRotX.getValue() - this.v30) * var6;
      this.v32 = this.v32 + (this.mainRotY.getValue() - this.v32) * var6;
      this.v23 = this.v23 + (this.mainRotZ.getValue() - this.v23) * var6;
      this.v33 = this.v33 + (this.mainScale.getValue() - this.v33) * var6;
      ViewModel.Part1 var7 = this.v1(false);
      this.v31 = this.v31 + (var7.v2() - this.v31) * var6;
      this.v34 = this.v34 + (var7.v3() - this.v34) * var6;
      this.v36 = this.v36 + (var7.v4() - this.v36) * var6;
      this.v38 = this.v38 + (var7.v5() - this.v38) * var6;
      this.v42 = this.v42 + (var7.v6() - this.v42) * var6;
      this.v43 = this.v43 + (var7.v7() - this.v43) * var6;
      this.v37 = this.v37 + (var7.v8() - this.v37) * var6;
      this.v25();
   }

   public ViewModel.Part1 v1(boolean var1) {
      if (!var1 && !this.symmetrical.getValue()) {
         return new ViewModel.Part1(
            this.offX.getValue(),
            this.offY.getValue(),
            this.offZ.getValue(),
            this.offRotX.getValue(),
            this.offRotY.getValue(),
            this.offRotZ.getValue(),
            this.offScale.getValue()
         );
      } else {
         ViewModel.Part1 var2 = new ViewModel.Part1(
            this.mainX.getValue(),
            this.mainY.getValue(),
            this.mainZ.getValue(),
            this.mainRotX.getValue(),
            this.mainRotY.getValue(),
            this.mainRotZ.getValue(),
            this.mainScale.getValue()
         );
         return var1 ? var2 : var2.v1();
      }
   }

   public void v1(boolean var1, ViewModel.Part1 var2) {
      if (!var1 && this.symmetrical.getValue()) {
         this.v1(true, var2.v1());
      } else {
         (var1 ? this.mainX : this.offX).setValue(var2.v2());
         (var1 ? this.mainY : this.offY).setValue(var2.v3());
         (var1 ? this.mainZ : this.offZ).setValue(var2.v4());
         (var1 ? this.mainRotX : this.offRotX).setValue(var2.v5());
         (var1 ? this.mainRotY : this.offRotY).setValue(var2.v6());
         (var1 ? this.mainRotZ : this.offRotZ).setValue(var2.v7());
         (var1 ? this.mainScale : this.offScale).setValue(var2.v8());
      }
   }

   public void v2(boolean var1) {
      this.v1(var1, new ViewModel.Part1(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 1.0F));
   }

   public int v3(boolean var1) {
      int var2 = this.v44 == class_1306.field_6182 ? -1 : 1;
      return var1 ? var2 : -var2;
   }

   public boolean v17() {
      return this.swapHands.getValue();
   }

   public void v4(boolean var1) {
      this.swapHands.setValue(var1);
   }

   public void v20() {
      this.v40 = System.nanoTime();
   }

   public boolean v21() {
      return this.symmetrical.getValue();
   }

   public void v1(boolean var1, Vector3fc var2, @Nullable Vector3fc var3) {
      this.v47 = var1 ? 1 : 0;
      this.v61 = 0L;
      this.v49.set(var2);
      this.v50 = var3 != null;
      if (var3 != null) {
         this.v51.set(var3);
      }
   }

   public void v5(boolean var1) {
      if (var1 && this.v47 >= 0) {
         this.v61 = System.nanoTime() + 2000000000L;
      } else {
         this.v47 = -1;
         this.v61 = 0L;
      }
   }

   public void v1(boolean var1, Vector3fc var2) {
      ViewModel.Part1 var3 = this.v1(var1);
      this.v1(var1, new ViewModel.Part1(var3.v2() + var2.x(), var3.v3() + var2.y(), var3.v4() + var2.z(), var3.v5(), var3.v6(), var3.v7(), var3.v8()));
      ViewModel.Part1 var4 = this.v8(var1);
      ViewModel.Part1 var5 = new ViewModel.Part1(var4.v2() + var2.x(), var4.v3() + var2.y(), var4.v4() + var2.z(), var4.v5(), var4.v6(), var4.v7(), var4.v8());
      this.v2(var1, var5);
      if (this.symmetrical.getValue()) {
         this.v2(!var1, var5.v1());
      }
   }

   public static Vector3f v1(ViewModel.Part1 var0, Vector3fc var1, Vector3f var2) {
      return new Matrix3f()
         .rotationXYZ((float)Math.toRadians(var0.v5()), (float)Math.toRadians(var0.v6()), (float)Math.toRadians(var0.v7()))
         .transform(var2.set(var1))
         .add(var0.v2(), var0.v3(), var0.v4());
   }

   private void v22() {
      class_746 var1 = this.v66.v2().v2();
      if (var1 == null) {
         this.v44 = null;
      } else {
         class_1306 var2 = var1.method_6068();
         if (this.v44 != null && var2 != this.v44 && this.v47 < 0) {
            this.v7(true);
            this.v7(false);
         }

         if (this.v44 != null && var2 != this.v44 && this.v47 >= 0) {
            this.v6(this.v47 == 1);
            if (this.v61 != 0L) {
               this.v47 = -1;
               this.v61 = 0L;
            }
         } else if (this.v61 != 0L && System.nanoTime() - this.v61 > 0L) {
            this.v47 = -1;
            this.v61 = 0L;
         }

         this.v44 = var2;
      }
   }

   private void v6(boolean var1) {
      ViewModel.Part1 var2 = this.v1(!var1);
      ViewModel.Part1 var3 = this.v8(!var1);
      if (this.v50) {
         v1(var3, this.v51, this.v53).add(this.v2(!var1, this.v46));
      } else {
         this.v1(!var1, this.v53);
      }

      ViewModel.Part1 var4 = this.v1(this.v1(var1));
      ViewModel.Part1 var5 = this.v1(this.v8(var1));
      this.v1(var1, var4);
      this.v2(var1, var5);
      if (this.symmetrical.getValue()) {
         this.v2(!var1, var5.v1());
      } else {
         this.v1(!var1, var2.v1());
         this.v2(!var1, var3.v1());
      }

      if (this.v50) {
         this.v51.x = -this.v51.x;
         v1(this.v8(!var1), this.v51, this.v63);
         this.v2(!var1, (Vector3fc)this.v53.sub(this.v63));
      } else {
         this.v2(!var1, (Vector3fc)this.v53);
      }

      this.v49.x = -this.v49.x;
   }

   private void v7(boolean var1) {
      accountSupport12.Part1 var2 = accountSupport12.v2(var1);
      if (var2 == null) {
         this.v1(var1, this.v53);
         this.v2(var1, (Vector3fc)this.v53);
      } else {
         ViewModel.Part1 var3 = this.v8(var1);
         Vector3f var4 = var2.v1(true, this.v46);
         v1(var3, var4, this.v53).add(this.v2(var1, this.v63));
         var4.x = -var4.x;
         v1(var3, var4, this.v63);
         this.v2(var1, (Vector3fc)this.v53.sub(this.v63));
      }
   }

   private Vector3f v1(boolean var1, Vector3f var2) {
      this.v2(var1, var2);
      var2.x = var2.x + 1.28F * this.v3(var1);
      return var2;
   }

   private void v2(boolean var1, Vector3fc var2) {
      int var3 = var1 ? 0 : 1;
      this.v60[var3].set(var2);
      this.v59[var3] = System.nanoTime();
   }

   private Vector3f v2(boolean var1, Vector3f var2) {
      int var3 = var1 ? 0 : 1;
      if (this.v59[var3] == 0L) {
         return var2.zero();
      } else {
         float var4 = (float)(System.nanoTime() - this.v59[var3]) / 1.0E9F / 0.36F;
         if (var4 >= 1.0F) {
            this.v59[var3] = 0L;
            return var2.zero();
         } else {
            return var2.set(this.v60[var3]).mul(1.0F - hudSupport60.v5(var4));
         }
      }
   }

   private ViewModel.Part1 v1(ViewModel.Part1 var1) {
      float var2 = v1(var1, this.v49, this.v46).x;
      ViewModel.Part1 var3 = var1.v1();
      return new ViewModel.Part1(var3.v2() + 2.0F * var2, var3.v3(), var3.v4(), var3.v5(), var3.v6(), var3.v7(), var3.v8());
   }

   private ViewModel.Part1 v8(boolean var1) {
      return var1
         ? new ViewModel.Part1(this.v27, this.v28, this.v29, this.v30, this.v32, this.v23, this.v33)
         : new ViewModel.Part1(this.v31, this.v34, this.v36, this.v38, this.v42, this.v43, this.v37);
   }

   private void v2(boolean var1, ViewModel.Part1 var2) {
      if (var1) {
         this.v27 = var2.v2();
         this.v28 = var2.v3();
         this.v29 = var2.v4();
         this.v30 = var2.v5();
         this.v32 = var2.v6();
         this.v23 = var2.v7();
         this.v33 = var2.v8();
      } else {
         this.v31 = var2.v2();
         this.v34 = var2.v3();
         this.v36 = var2.v4();
         this.v38 = var2.v5();
         this.v42 = var2.v6();
         this.v43 = var2.v7();
         this.v37 = var2.v8();
      }
   }

   private void v24() {
      this.v27 = this.mainX.getValue();
      this.v28 = this.mainY.getValue();
      this.v29 = this.mainZ.getValue();
      this.v30 = this.mainRotX.getValue();
      this.v32 = this.mainRotY.getValue();
      this.v23 = this.mainRotZ.getValue();
      this.v33 = this.mainScale.getValue();
      ViewModel.Part1 var1 = this.v1(false);
      this.v31 = var1.v2();
      this.v34 = var1.v3();
      this.v36 = var1.v4();
      this.v38 = var1.v5();
      this.v42 = var1.v6();
      this.v43 = var1.v7();
      this.v37 = var1.v8();
   }

   private void v9(boolean var1) {
      if (var1 != visualSupport51.v31) {
         visualSupport51.v31 = var1;
         class_310 var2 = this.v66.v2().v1();
         if (var2 != null && var2.field_1690 != null) {
            var2.field_1690.method_1643();
         }
      }
   }

   private void v25() {
      this.v9(this.swapHands.getValue());
      Vector3f var1 = this.v2(true, this.v64);
      visualSupport51.v17 = this.v27 + var1.x;
      visualSupport51.v20 = this.v28 + var1.y;
      visualSupport51.v21 = this.v29 + var1.z;
      visualSupport51.v34 = var1.x;
      visualSupport51.v36 = var1.y;
      visualSupport51.v38 = var1.z;
      visualSupport51.v22 = this.v30;
      visualSupport51.v24 = this.v32;
      visualSupport51.v25 = this.v23;
      visualSupport51.v26 = this.v33;
      Vector3f var2 = this.v2(false, this.v64);
      visualSupport51.v27 = this.v31 + var2.x;
      visualSupport51.v28 = this.v34 + var2.y;
      visualSupport51.v29 = this.v36 + var2.z;
      visualSupport51.v42 = var2.x;
      visualSupport51.v43 = var2.y;
      visualSupport51.v37 = var2.z;
      visualSupport51.v30 = this.v38;
      visualSupport51.v32 = this.v42;
      visualSupport51.v23 = this.v43;
      visualSupport51.v33 = this.v37;
   }

   public record Part1(float x, float y, float z, float rotX, float rotY, float rotZ, float scale) {
      public ViewModel.Part1 v1() {
         return new ViewModel.Part1(-this.x, this.y, this.z, this.rotX, -this.rotY, -this.rotZ, this.scale);
      }

      public float v2() {
         return this.x;
      }

      public float v3() {
         return this.y;
      }

      public float v4() {
         return this.z;
      }

      public float v5() {
         return this.rotX;
      }

      public float v6() {
         return this.rotY;
      }

      public float v7() {
         return this.rotZ;
      }

      public float v8() {
         return this.scale;
      }
   }
}
