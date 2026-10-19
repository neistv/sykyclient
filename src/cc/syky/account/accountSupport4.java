package cc.syky.account;

import cc.syky.cloud.cloudSupport101;
import cc.syky.cloud.cloudSupport15;
import cc.syky.cloud.cloudSupport57;
import cc.syky.hud.HUDEditorSupport;
import cc.syky.mixin.accessor.GameRendererAccessor;
import cc.syky.mixin.accessor.ProjectionMatrix3Accessor;
import cc.syky.module.visual.ViewModel;
import net.minecraft.class_1041;
import net.minecraft.class_310;
import org.jetbrains.annotations.Nullable;
import org.joml.Matrix3f;
import org.joml.Vector3f;

public final class accountSupport4 {
   private static final float v1 = 0.02F;
   private static final float v2 = 0.4F;
   private static final float v3 = 1.08F;
   private static final float v4 = 0.04F;
   private static final float v5 = 5.0F;
   private final cloudSupport101 v6;
   private final accountSupport5 v7 = new accountSupport5();
   private final Vector3f v8 = new Vector3f();
   private final Vector3f v9 = new Vector3f();
   private final Vector3f v10 = new Vector3f();
   private final Vector3f v11 = new Vector3f();
   private final Vector3f v12 = new Vector3f();
   @Nullable
   private ViewModel v13;
   private boolean v14;
   private accountSupport4.Part1 v15 = accountSupport4.Part1.NONE;
   private boolean v16;
   private int v18;
   private float v19;
   private float v17;
   private boolean v20;
   @Nullable
   private ViewModel.Part1 v21;
   private float v22;
   private float v24;
   private float v25;
   private int v26;
   private int v27;
   private float v28;
   private float v29;
   private final Vector3f v30 = new Vector3f();
   private final Vector3f v32 = new Vector3f();
   private final Vector3f v23 = new Vector3f();

   public accountSupport4(cloudSupport101 var1) {
      this.v6 = var1;
   }

   public void v1(ViewModel var1) {
      this.v13 = var1;
   }

   public boolean v1() {
      return this.v15 != accountSupport4.Part1.NONE;
   }

   public void v1(float var1, float var2) {
      accountSupport12.v1();
      this.v14 = false;
      class_310 var3 = this.v6.v1();
      if (var3 != null) {
         ProjectionMatrix3Accessor var4 = (ProjectionMatrix3Accessor)((GameRendererAccessor)var3.field_1773).syky$handProjection();
         int var5 = var4.syky$width();
         int var6 = var4.syky$height();
         float var7 = var4.syky$fov();
         if (var5 > 0 && var6 > 0 && !(var7 <= 0.0F) && !(var1 <= 0.0F) && !(var2 <= 0.0F)) {
            this.v7.v1(1.0F / (float)Math.tan(Math.toRadians(var7) * 0.5), (float)var5 / var6, var1, var2);
            this.v14 = true;
         }
      }
   }

   public int v1(float var1, float var2, boolean var3) {
      if (!this.v3()) {
         return -1;
      } else {
         float var4 = this.v7.v1(true, var1, var2, var3);
         float var5 = this.v7.v1(false, var1, var2, var3);
         if (Float.isNaN(var4)) {
            return Float.isNaN(var5) ? -1 : 0;
         } else {
            return !Float.isNaN(var5) && !(var4 <= var5) ? 0 : 1;
         }
      }
   }

   public boolean v1(int var1, float var2, float var3) {
      ViewModel var4 = this.v13;
      if (this.v15 == accountSupport4.Part1.NONE && var4 != null) {
         int var5 = this.v1(var2, var3, true);
         if (var5 < 0) {
            return false;
         } else {
            boolean var6 = var5 == 1;
            if (var1 == 2) {
               var4.v2(var6);
               var4.v20();
               return true;
            } else if (var1 != 0 && var1 != 1) {
               return false;
            } else {
               Vector3f var7 = this.v7.v1(var6, false, this.v8);
               if (var7 != null && this.v1(var6)) {
                  float var8 = Math.max(0.05F, -var7.z);
                  this.v22 = 2.0F * var8 * this.v7.v2() / (this.v7.v1() * this.v7.v3());
                  this.v24 = 2.0F * var8 / (this.v7.v1() * this.v7.v4());
                  this.v25 = this.v7.v1(var7);
                  this.v16 = var6;
                  this.v18 = var1;
                  this.v19 = var2;
                  this.v17 = var3;
                  this.v20 = false;
                  this.v21 = var4.v1(var6);
                  this.v15 = var1 == 0 ? accountSupport4.Part1.MOVE : accountSupport4.Part1.TURN;
                  if (this.v15 == accountSupport4.Part1.MOVE) {
                     this.v26 = var4.v3(var6);
                     this.v27 = this.v26;
                     this.v28 = 0.0F;
                     this.v29 = 0.0F;
                     this.v2(var4);
                  }

                  return true;
               } else {
                  return false;
               }
            }
         }
      } else {
         return false;
      }
   }

   public void v1(class_1041 var1, float var2, float var3, HUDEditorSupport var4) {
      ViewModel var5 = this.v13;
      ViewModel.Part1 var6 = this.v21;
      if (this.v15 != accountSupport4.Part1.NONE && var5 != null && var6 != null) {
         if (cloudSupport57.v1(var1, this.v18)) {
            float var10 = var2 - this.v19;
            float var8 = var3 - this.v17;
            if (this.v15 == accountSupport4.Part1.MOVE) {
               this.v1(var5, var6, var10, var8);
            } else if (this.v20 || cloudSupport15.v1(var10, var8, 1.0F)) {
               this.v20 = true;
               ViewModel.Part1 var9 = new ViewModel.Part1(
                  var6.v2(), var6.v3(), var6.v4(), var6.v5() + var8 * 0.4F, var6.v6() + var10 * 0.4F, var6.v7(), var6.v8()
               );
               var5.v1(this.v16, var9);
               this.v1(var5, this.v16, var6, var5.v1(this.v16));
               var5.v20();
            }
         } else {
            boolean var7 = this.v15 == accountSupport4.Part1.TURN && !this.v20;
            this.v2();
            if (var7) {
               var4.v2(this.v19, this.v17);
            }
         }
      }
   }

   private void v1(ViewModel var1, ViewModel.Part1 var2, float var3, float var4) {
      int var5 = var1.v3(this.v16);
      if (var5 != this.v26) {
         this.v26 = var5;
         Vector3f var6 = this.v7.v1(this.v16, true, this.v8);
         if (var6 != null) {
            this.v30.set(var6);
            ViewModel.v1(var1.v1(this.v16), this.v30, this.v11);
            var1.v1(this.v16, this.v12.set(this.v32).sub(this.v11));
         }

         ViewModel.Part1 var7 = var1.v1(this.v16);
         var2 = new ViewModel.Part1(var7.v2() - this.v28, var7.v3() - this.v29, var7.v4(), var7.v5(), var7.v6(), var7.v7(), var7.v8());
         this.v21 = var2;
      }

      this.v28 = var3 * this.v22;
      this.v29 = -var4 * this.v24;
      var1.v1(this.v16, new ViewModel.Part1(var2.v2() + this.v28, var2.v3() + this.v29, var2.v4(), var2.v5(), var2.v6(), var2.v7(), var2.v8()));
      var1.v20();
      this.v2(var1);
      float var9 = this.v25 + var3;
      float var10 = this.v7.v3() * 0.5F;
      float var8 = this.v7.v3() * 0.02F;
      if (this.v27 > 0 && var9 < var10 - var8 || this.v27 < 0 && var9 > var10 + var8) {
         this.v27 = -this.v27;
         var1.v4(!var1.v17());
      }
   }

   private void v2(ViewModel var1) {
      Vector3f var2 = this.v7.v1(this.v16, true, this.v8);
      if (var2 != null && var1.v3(this.v16) == this.v26) {
         this.v30.set(var2);
      }

      var1.v1(this.v16, this.v30, this.v7.v1(!this.v16, true, this.v23));
      ViewModel.v1(var1.v1(this.v16), this.v30, this.v32);
   }

   public boolean v1(float var1, float var2, double var3, boolean var5, boolean var6) {
      ViewModel var7 = this.v13;
      if (this.v15 == accountSupport4.Part1.NONE && var7 != null && var3 != 0.0) {
         int var8 = this.v1(var1, var2, false);
         if (var8 < 0) {
            return false;
         } else {
            boolean var9 = var8 == 1;
            ViewModel.Part1 var10 = var7.v1(var9);
            float var11 = (float)var3;
            var7.v20();
            if (var5) {
               Vector3f var13 = this.v7.v1(var9, false, this.v8);
               if (var13 != null && !(var13.lengthSquared() < 1.0E-8F)) {
                  var13.normalize(-var11 * 0.04F);
                  var7.v1(
                     var9,
                     new ViewModel.Part1(var10.v2() + var13.x, var10.v3() + var13.y, var10.v4() + var13.z, var10.v5(), var10.v6(), var10.v7(), var10.v8())
                  );
                  return true;
               } else {
                  return true;
               }
            } else if (!this.v1(var9)) {
               return true;
            } else {
               if (var6) {
                  var7.v1(var9, new ViewModel.Part1(var10.v2(), var10.v3(), var10.v4(), var10.v5(), var10.v6(), var10.v7() + var11 * 5.0F, var10.v8()));
               } else {
                  float var12 = var10.v8() * (float)Math.pow(1.08F, var11);
                  var7.v1(var9, new ViewModel.Part1(var10.v2(), var10.v3(), var10.v4(), var10.v5(), var10.v6(), var10.v7(), var12));
               }

               this.v1(var7, var9, var10, var7.v1(var9));
               return true;
            }
         }
      } else {
         return false;
      }
   }

   public void v2() {
      ViewModel var1 = this.v13;
      if (var1 != null && this.v15 == accountSupport4.Part1.MOVE) {
         var1.v5(this.v27 != this.v26);
      }

      this.v15 = accountSupport4.Part1.NONE;
      this.v21 = null;
   }

   private boolean v1(boolean var1) {
      Vector3f var2 = this.v7.v1(var1, this.v9);
      Vector3f var3 = this.v7.v1(var1, true, this.v10);
      if (var2 != null && var3 != null) {
         var3.sub(var2).div(this.v7.v1(var1));
         return true;
      } else {
         return false;
      }
   }

   private void v1(ViewModel var1, boolean var2, ViewModel.Part1 var3, ViewModel.Part1 var4) {
      this.v1(var3, this.v11);
      this.v1(var4, this.v12);
      this.v11.sub(this.v12);
      var1.v1(var2, new ViewModel.Part1(var4.v2() + this.v11.x, var4.v3() + this.v11.y, var4.v4() + this.v11.z, var4.v5(), var4.v6(), var4.v7(), var4.v8()));
   }

   private Vector3f v1(ViewModel.Part1 var1, Vector3f var2) {
      var2.set(this.v10).mul(var1.v8()).add(this.v9);
      return new Matrix3f().rotationXYZ((float)Math.toRadians(var1.v5()), (float)Math.toRadians(var1.v6()), (float)Math.toRadians(var1.v7())).transform(var2);
   }

   private boolean v3() {
      ViewModel var1 = this.v13;
      return this.v14 && var1 != null && var1.isEnabled();
   }

   public static enum Part1 {
      NONE,
      MOVE,
      TURN;

      private Part1() {
      }
   }
}
