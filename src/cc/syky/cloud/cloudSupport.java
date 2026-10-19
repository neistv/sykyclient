package cc.syky.cloud;

import cc.syky.EndSupport;
import cc.syky.sykyRecord4;
import cc.syky.account.accountSupport22;
import cc.syky.hud.hudSupport49;
import cc.syky.internal.InternalSupport7;
import cc.syky.ui.uiRecord7;
import cc.syky.ui.uiSupport155;
import cc.syky.ui.uiSupport169;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import net.minecraft.class_1041;
import net.minecraft.class_243;
import net.minecraft.class_310;
import net.minecraft.class_332;
import net.minecraft.class_4184;
import org.joml.Matrix4f;
import org.joml.Quaternionf;
import org.joml.Vector4f;

public final class cloudSupport {
   private static final String v1 = "syky_sans_strong";
   private static final float v2 = 12.0F;
   private static final float v3 = 8.0F;
   private static final float v4 = 7.0F;
   private static final float v5 = 3.0F;
   private static final float v6 = 2.0F;
   private static final float v7 = 1.0F;
   private static final float v8 = 2.0F;
   private static final float v9 = 3.0F;
   private static final float v10 = 2.0F;
   private static final float v11 = 6.0F;
   private static final float v12 = 0.05F;
   private static final float v13 = 48.0F;
   private static final float v14 = 64.0F;
   private static final float v15 = 128.0F;
   private static final String v16 = " – ";
   private static final int v18 = -1;
   private static final int v19 = -4934476;
   private static final int v17 = 1493172224;
   private final cloudSupport101 v20;
   private final InternalSupport7 v21;
   private final Matrix4f v22 = new Matrix4f();
   private final Matrix4f v24 = new Matrix4f();
   private final Quaternionf v25 = new Quaternionf();
   private final Vector4f v26 = new Vector4f();
   private final cloudSupport.Part2 v27 = new cloudSupport.Part2();
   private float v28 = 1.0F;
   private final uiRecord7[] v29 = new uiRecord7[64];
   private int v30;
   private sykyRecord4[] v32 = new sykyRecord4[0];
   private float[] v23 = new float[0];
   private float[] v33 = new float[0];
   private float[] v31 = new float[0];
   private float[] v34 = new float[0];
   private float[] v36 = new float[0];
   private float[] v38 = new float[0];
   private float[] v42 = new float[0];
   private int[] v43 = new int[0];
   private int[] v37 = new int[0];
   private int[] v48 = new int[0];
   private float[] v40 = new float[0];
   private String[] v44 = new String[0];
   private float[] v47 = new float[0];
   private int v49 = -1;
   private static final float v46 = 180.0F;
   private static final float v51 = 0.3F;
   private final Map<String, cloudSupport.Part1> v50 = new HashMap<>();
   private final List<InternalSupport7.Part3> v60 = new ArrayList<>();
   private float[] v59 = new float[0];
   private int v53 = -1;
   private int v63;
   private long v64;

   public cloudSupport(cloudSupport101 var1, InternalSupport7 var2) {
      this.v20 = var1;
      this.v21 = var2;
   }

   public void v1(class_332 var1) {
      long var2 = System.nanoTime();
      float var4 = this.v64 == 0L ? 0.0F : Math.min(100.0F, (float)(var2 - this.v64) / 1000000.0F);
      this.v64 = var2;
      List var5 = this.v1(this.v21.v14(), var4);
      if (!var5.isEmpty()) {
         class_310 var6 = this.v20.v1();
         if (var6 != null && var6.field_1687 != null && var6.field_1724 != null && !var6.field_1690.field_1842) {
            Matrix4f var7 = accountSupport22.v3();
            class_4184 var8 = var6.field_1773.method_19418();
            if (var7 != null && var8 != null) {
               this.v28 = this.v21.v3().v5();
               this.v1(var5);
               this.v1(var5, var7, var8, var6.method_22683());
               if (this.v30 != 0) {
                  this.v1();
                  uiSupport169.v1(var1);

                  try {
                     this.v2();
                     this.v3();
                     this.v4();
                     this.v5();
                  } finally {
                     uiSupport169.v15();
                  }
               }
            }
         }
      }
   }

   private List<InternalSupport7.Part3> v1(List<InternalSupport7.Part3> var1, float var2) {
      int var3 = this.v21.v15();
      boolean var4 = var3 != this.v53;
      this.v53 = var3;
      if (var4) {
         for (cloudSupport.Part1 var6 : this.v50.values()) {
            var6.v2 = false;
         }

         for (InternalSupport7.Part3 var13 : var1) {
            cloudSupport.Part1 var7 = this.v50.computeIfAbsent(var13.v1().v4(), var1x -> new cloudSupport.Part1(var13));
            var7.v2 = true;
            var7.v3 = var13;
         }
      }

      float var12 = var2 / 180.0F;
      boolean var14 = var4;
      Iterator var15 = this.v50.values().iterator();

      while (var15.hasNext()) {
         cloudSupport.Part1 var8 = (cloudSupport.Part1)var15.next();
         var8.v1 = Math.max(0.0F, Math.min(1.0F, var8.v1 + (var8.v2 ? var12 : -var12)));
         if (!var8.v2 && var8.v1 <= 0.0F) {
            var15.remove();
            var14 = true;
         }
      }

      if (var14) {
         this.v63++;
         this.v60.clear();
         this.v60.addAll(var1);

         for (cloudSupport.Part1 var18 : this.v50.values()) {
            if (!var18.v2) {
               this.v60.add(var18.v3);
            }
         }

         if (this.v59.length < this.v60.size()) {
            this.v59 = new float[this.v60.size()];
         }
      }

      for (int var17 = 0; var17 < this.v60.size(); var17++) {
         cloudSupport.Part1 var19 = this.v50.get(this.v60.get(var17).v1().v4());
         float var9 = var19 == null ? 1.0F : var19.v1;
         float var10 = 1.0F - var9;
         this.v59[var17] = 1.0F - var10 * var10 * var10;
      }

      return this.v60;
   }

   private void v1(List<InternalSupport7.Part3> var1) {
      if (this.v63 != this.v49 || this.v40.length < var1.size()) {
         this.v49 = this.v63;
         if (this.v40.length < var1.size()) {
            this.v40 = new float[var1.size()];
            this.v44 = new String[var1.size()];
            this.v47 = new float[var1.size()];
         }

         for (int var2 = 0; var2 < var1.size(); var2++) {
            InternalSupport7.Part3 var3 = (InternalSupport7.Part3)var1.get(var2);
            this.v40[var2] = uiSupport169.v2("syky_sans_strong", var3.v1().v5(), 1.0F);
            String var4 = var3.v5() ? " – " + EndSupport.v2(var3.v1().v9()) : null;
            this.v44[var2] = var4;
            this.v47[var2] = var4 == null ? 0.0F : uiSupport169.v2("syky_sans_strong", var4, 1.0F);
         }

         this.v2(var1.size());
      }
   }

   private void v1(List<InternalSupport7.Part3> var1, Matrix4f var2, class_4184 var3, class_1041 var4) {
      this.v25.set(var3.method_23767());
      this.v22.rotation(this.v25.conjugate());
      this.v24.set(var2).mul(this.v22);
      class_243 var5 = var3.method_71156();
      float var6 = var4.method_4495();
      float var7 = var4.method_4489() / var6;
      float var8 = var4.method_4506() / var6;
      float var9 = var7 / 2.0F;
      float var10 = var8 / 2.0F;
      this.v30 = 0;

      for (int var11 = 0; var11 < var1.size(); var11++) {
         InternalSupport7.Part3 var12 = (InternalSupport7.Part3)var1.get(var11);
         double var13 = var12.v2() + 0.5 - var5.field_1352;
         sykyRecord4 var15 = var12.v1();
         double var16 = var12.v3() + 0.5 + (var15.v3() ? var15.v19().v3() : 0.0F) - var5.field_1351;
         double var18 = var12.v4() + 0.5 - var5.field_1350;
         double var20 = Math.sqrt(var13 * var13 + var16 * var16 + var18 * var18);
         boolean var22 = var12.v1().v13();
         float var23 = var22 ? 1.0F : (float)((var20 - 2.0) / 4.0);
         if (!(var23 <= 0.0F)) {
            this.v26.set((float)var13, (float)var16, (float)var18, 1.0F);
            this.v24.transform(this.v26);
            if (!(this.v26.w <= 0.05F)) {
               float var24 = (this.v26.x / this.v26.w * 0.5F + 0.5F) * var7;
               float var25 = (0.5F - this.v26.y / this.v26.w * 0.5F) * var8;
               float var26 = this.v59[var11];
               if (!(var26 <= 0.0F)) {
                  float var27 = var15.v2(this.v28) * (0.3F + 0.7F * var26);
                  float var28 = 48.0F * var27;
                  if (!(var24 < -var28) && !(var24 > var7 + var28) && !(var25 < -var28) && !(var25 > var8 + var28)) {
                     int var29 = (int)Math.round(var20);
                     float var30 = Math.max(this.v40[var11] * 8.0F, (this.v27.v2(var29) + this.v47[var11]) * 7.0F) * var27;
                     float var31 = (float)Math.hypot(var24 - var9, var25 - var10);
                     float var32 = var22 ? 1.0F : 1.0F - v1((var31 - 64.0F) / 64.0F);
                     int var33 = this.v30++;
                     this.v32[var33] = var12.v1();
                     this.v23[var33] = var24;
                     this.v33[var33] = var25;
                     this.v31[var33] = Math.min(1.0F, var23) * var26;
                     this.v34[var33] = this.v31[var33] * var32;
                     this.v36[var33] = var30 + 6.0F * var27;
                     this.v38[var33] = var27;
                     this.v42[var33] = (float)var20;
                     this.v43[var33] = var29;
                     this.v37[var33] = var11;
                     this.v48[var33] = var33;
                  }
               }
            }
         }
      }
   }

   private void v1() {
      for (int var1 = 1; var1 < this.v30; var1++) {
         int var2 = this.v48[var1];
         float var3 = this.v42[var2];

         int var4;
         for (var4 = var1 - 1; var4 >= 0 && this.v42[this.v48[var4]] < var3; var4--) {
            this.v48[var4 + 1] = this.v48[var4];
         }

         this.v48[var4 + 1] = var2;
      }
   }

   private static float v1(float var0) {
      float var1 = var0 <= 0.0F ? 0.0F : (var0 >= 1.0F ? 1.0F : var0);
      return var1 * var1 * (3.0F - 2.0F * var1);
   }

   private void v2() {
      for (int var1 = 0; var1 < this.v30; var1++) {
         int var2 = this.v48[var1];
         if (!(this.v34[var2] <= 0.0F)) {
            uiSupport169.v1(
               this.v23[var2] - this.v36[var2] / 2.0F,
               this.v1(var2),
               this.v36[var2],
               v6() * this.v38[var2],
               uiSupport155.v1(1493172224, this.v34[var2]),
               this.v2(3.0F * this.v38[var2])
            );
         }
      }
   }

   private void v3() {
      for (int var1 = 0; var1 < this.v30; var1++) {
         int var2 = this.v48[var1];
         float var3 = 12.0F * this.v38[var2];
         uiSupport169.v1(
            hudSupport49.v19,
            this.v23[var2] - var3 / 2.0F,
            this.v33[var2] - var3 / 2.0F,
            var3,
            var3,
            uiSupport155.v1(this.v32[var2].v12(), this.v31[var2]),
            uiRecord7.ZERO
         );
      }
   }

   private void v4() {
      for (int var1 = 0; var1 < this.v30; var1++) {
         int var2 = this.v48[var1];
         if (!(this.v34[var2] <= 0.0F)) {
            float var3 = 8.0F * this.v38[var2];
            float var4 = this.v23[var2] - this.v40[this.v37[var2]] * var3 / 2.0F;
            uiSupport169.v1("syky_sans_strong", this.v32[var2].v5(), var4, this.v1(var2) + 2.0F * this.v38[var2], var3, uiSupport155.v1(-1, this.v34[var2]));
         }
      }
   }

   private void v5() {
      for (int var1 = 0; var1 < this.v30; var1++) {
         int var2 = this.v48[var1];
         if (!(this.v34[var2] <= 0.0F)) {
            int var3 = this.v43[var2];
            int var4 = this.v37[var2];
            String var5 = this.v44[var4];
            float var6 = this.v27.v2(var3) + this.v47[var4];
            float var7 = this.v1(var2) + 11.0F * this.v38[var2];
            float var8 = 7.0F * this.v38[var2];
            int var9 = uiSupport155.v1(-4934476, this.v34[var2]);
            float var10 = this.v23[var2] - var6 * var8 / 2.0F;
            float var11 = var10 + uiSupport169.v1("syky_sans_strong", this.v27.v1(var3), var10, var7, var8, var9);
            if (var5 != null) {
               uiSupport169.v1("syky_sans_strong", var5, var11, var7, var8, var9);
            }
         }
      }
   }

   private float v1(int var1) {
      return this.v33[var1] + 8.0F * this.v38[var1];
   }

   private uiRecord7 v2(float var1) {
      int var2 = Math.min(this.v29.length - 1, Math.round(var1 * 2.0F));
      uiRecord7 var3 = this.v29[var2];
      if (var3 == null) {
         var3 = uiRecord7.v1(var2 / 2.0F);
         this.v29[var2] = var3;
      }

      return var3;
   }

   private static float v6() {
      return 20.0F;
   }

   private void v2(int var1) {
      if (this.v32.length < var1) {
         this.v32 = new sykyRecord4[var1];
         this.v23 = new float[var1];
         this.v33 = new float[var1];
         this.v31 = new float[var1];
         this.v34 = new float[var1];
         this.v36 = new float[var1];
         this.v38 = new float[var1];
         this.v42 = new float[var1];
         this.v43 = new int[var1];
         this.v37 = new int[var1];
         this.v48 = new int[var1];
      }
   }

   public static final class Part1 {
      public float v1;
      public boolean v2;
      public InternalSupport7.Part3 v3;

      public Part1(InternalSupport7.Part3 var1) {
         this.v3 = var1;
      }
   }

   public static final class Part2 {
      public static final int v1 = 10000;
      private final String[] v2 = new String[10000];
      private final float[] v3 = new float[10000];
      private String[] v4 = new String[0];
      private float[] v5 = new float[0];

      public Part2() {
      }

      public String v1(int var1) {
         if (var1 < 10000) {
            int var4 = Math.max(0, var1);
            String var5 = this.v2[var4];
            if (var5 == null) {
               var5 = var4 + "m";
               this.v2[var4] = var5;
               this.v3[var4] = uiSupport169.v2("syky_sans_strong", var5, 1.0F);
            }

            return var5;
         } else {
            int var2 = Math.min(var1 / 1000, 60000);
            if (this.v4.length <= var2) {
               this.v4 = Arrays.copyOf(this.v4, var2 + 1);
               this.v5 = Arrays.copyOf(this.v5, var2 + 1);
            }

            String var3 = this.v4[var2];
            if (var3 == null) {
               var3 = var2 + "km";
               this.v4[var2] = var3;
               this.v5[var2] = uiSupport169.v2("syky_sans_strong", var3, 1.0F);
            }

            return var3;
         }
      }

      public float v2(int var1) {
         this.v1(var1);
         return var1 < 10000 ? this.v3[Math.max(0, var1)] : this.v5[Math.min(var1 / 1000, 60000)];
      }
   }
}
