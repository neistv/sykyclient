package cc.syky.cloud;

import cc.syky.account.accountSupport22;
import cc.syky.ui.uiSupport169;
import java.util.Random;
import net.minecraft.class_1041;
import net.minecraft.class_1657;
import net.minecraft.class_243;
import net.minecraft.class_310;
import net.minecraft.class_332;
import net.minecraft.class_3959;
import net.minecraft.class_3965;
import net.minecraft.class_4184;
import net.minecraft.class_638;
import net.minecraft.class_746;
import net.minecraft.class_239.class_240;
import net.minecraft.class_3959.class_242;
import net.minecraft.class_3959.class_3960;
import org.jetbrains.annotations.Nullable;
import org.joml.Matrix4f;
import org.joml.Quaternionf;
import org.joml.Vector3fc;
import org.joml.Vector4f;

public final class cloudSupport31 {
   private static final String v17 = "syky_sans";
   private static final int v20 = 128;
   private static final int v21 = 6;
   private static final int v22 = 10;
   private static final int v24 = -1;
   private static final int v25 = 0;
   private static final int v26 = 1;
   private static final int v27 = 2;
   private static final float v28 = 0.05F;
   private static final float v29 = 80.0F;
   private static final float v30 = 210.0F;
   private static final float v32 = 42.0F;
   private static final float v23 = 3.5F;
   private static final float v33 = 0.07F;
   private static final float v31 = 16.0F;
   private static final float v34 = 0.2F;
   private static final float v36 = 0.5F;
   private static final long v38 = 420L;
   private static final long v42 = 3400L;
   private static final float v43 = 5.0F;
   private static final float v37 = 36.0F;
   private static final float v48 = 0.78F;
   private static final float v40 = 0.25F;
   private static final float v44 = 0.75F;
   private static final float v47 = 0.45F;
   private static final float v49 = 6.5F;
   private static final float v46 = 0.96F;
   private static final int v51 = 8;
   private static final int v50 = 7;
   private static final int v60 = 5;
   private static final float v59 = 0.34F;
   private static final float v53 = 0.25F;
   private static final float v63 = 0.42F;
   private static final float v64 = 7.0F;
   private static final float v61 = 0.55F;
   private static final float v66 = 0.35F;
   private static final float v68 = 6.0F;
   private static final float v52 = 1.22F;
   private static final float v75 = 0.8F;
   private static final float v73 = 0.09F;
   private static final float v74 = 0.5F;
   private static final int v72 = 4;
   private static final float v80 = 0.06F;
   private static final float v84 = 0.95F;
   private static final float v94 = 512.0F;
   private static final float v82 = 1.15F;
   private static final float v99 = 0.7F;
   private static final float v120 = 10.0F;
   private static final float v88 = 110.0F;
   private static final float v103 = 3.0F;
   private static final float v101 = 90.0F;
   private static final int v96 = 1374496513;
   private static final int v105 = 461845907;
   private static final int v87 = 668265263;
   private static final int v85 = 374761393;
   private static final int v119 = -1640531535;
   private static final int v98 = -2048144777;
   private static final int v124 = 2146121005;
   private static final int v117 = -2073254261;
   public static boolean v1 = false;
   public static int v2 = -1;
   public static int v3 = -1;
   public static int v4 = 1308622847;
   public static int v5 = -1;
   public static int v6 = -1;
   public static int v7 = -1;
   public static float v8 = 1.0F;
   public static int v9 = 26;
   public static float v10 = 48.0F;
   public static float v11 = 0.6F;
   public static float v12 = 0.45F;
   public static float v13 = 2.5F;
   public static float v14 = 0.45F;
   public static cloudSupport33 v15 = cloudSupport33.LINES;
   public static boolean v16 = true;
   public static int v18 = 15;
   public static int v19 = 255;
   private static final cloudSupport31.Part1[] v45 = new cloudSupport31.Part1[128];
   private static final cloudSupport31.Part1[] v104 = new cloudSupport31.Part1[128];
   private static int v125;
   private static int v141;
   private static final cloudSupport31.Part1[] v145;
   private static final Random v162;
   private static float v107;
   private static float v118;
   private static float v159;
   private static float v176;
   private static long v116;
   private static long v147;
   private static int v93;
   private static float v157;
   private static float v166;
   private static float v121;
   private static float v137;
   private static float v187;
   private static float v138;
   private static boolean v106;
   private static float v100;
   private static float v191;
   private static float v112;
   private static float v216;
   private static int v41;
   private static final Matrix4f v190;
   private static final Matrix4f v70;
   private static final Matrix4f v133;
   private static final Quaternionf v160;
   private static final Vector4f v172;
   private static final float[] v249;

   private cloudSupport31() {
   }

   public static void v1() {
      v1 = false;
      v2();
   }

   public static void v2() {
      for (cloudSupport31.Part1 var3 : v45) {
         var3.v3 = false;
      }

      v125 = 0;
      v147 = 0L;
      v41 = 0;
   }

   public static void v1(class_310 var0) {
      class_638 var1 = var0.field_1687;
      class_746 var2 = var0.field_1724;
      if (var1 != null && var2 != null) {
         Matrix4f var3 = accountSupport22.v3();
         class_4184 var4 = var0.field_1773.method_19418();
         if (var3 != null && var4 != null) {
            long var5 = System.currentTimeMillis();
            v1(var3, var4);
            v70.set(v190).invert();
            v216 = Math.min(v10, var0.field_1690.method_38521() * 16.0F);
            if (var5 >= v147) {
               v1(var5, v1(var4));
            }

            int var7 = 0;

            for (cloudSupport31.Part1 var11 : v45) {
               if (var11.v3 && var5 >= var11.v8) {
                  var11.v3 = false;
               }

               if (var11.v3) {
                  var7++;
               }
            }

            if (v18 != 0 && v19 != 0) {
               int var13 = v1(var5);
               class_243 var14 = var4.method_71156();

               for (int var15 = 0; var7 < var13 && var15 < 6; var15++) {
                  cloudSupport31.Part1 var16 = v6();
                  if (var16 == null) {
                     break;
                  }

                  int var12 = v1(var16, var1, var2, var14, var5);
                  if (var12 == -1) {
                     break;
                  }

                  if (var12 == 0 && ++v41 >= 10) {
                     v1(var5, v1(var4));
                     break;
                  }

                  if (var12 != 0) {
                     v41 = 0;
                  }

                  if (var12 == 1) {
                     var7++;
                  }
               }
            }
         }
      } else {
         v2();
      }
   }

   public static void v1(class_332 var0) {
      if (v1) {
         class_310 var1 = class_310.method_1551();
         if (var1 == null || var1.field_1687 == null || var1.field_1724 == null) {
            v2();
         } else if (!var1.field_1690.field_1842) {
            Matrix4f var2 = accountSupport22.v3();
            class_4184 var3 = var1.field_1773.method_19418();
            if (var2 != null && var3 != null) {
               long var4 = System.currentTimeMillis();
               int var6 = (int)(var4 / (long)v3());
               v1(var2, var3);
               class_243 var7 = var3.method_71156();
               class_1041 var8 = var1.method_22683();
               float var9 = var8.method_4495();
               float var10 = var8.method_4489() / var9;
               float var11 = var8.method_4506() / var9;
               v125 = 0;
               v141++;

               for (cloudSupport31.Part1 var15 : v45) {
                  if (var15.v3 && v1(var15, var7, var10, var11, var6)) {
                     var15.v2 = v141;
                     v104[v125++] = var15;
                  }
               }

               if (v125 != 0) {
                  uiSupport169.v1(var0);

                  try {
                     v8();
                     v1(var6);
                     v10();
                     v11();
                  } finally {
                     uiSupport169.v15();
                  }
               }
            }
         }
      }
   }

   private static float v3() {
      float var0 = Math.min(1.0F, Math.max(0.0F, v12));
      return Math.max(1.0F, 210.0F + -168.0F * var0);
   }

   private static void v1(long var0, float var2) {
      v116 = var0;
      v93 = v162.nextInt();
      v41 = 0;
      v187 = 0.0F;
      v138 = 0.0F;
      v106 = false;
      cloudSupport32 var3 = v4();
      long var4 = 0L;
      float var7 = 1.0F;
      float var6;
      float var8;
      switch (var3) {
         case HORIZON:
            v107 = 0.2F + v162.nextFloat() * 0.6F;
            v118 = v1(var2 + (v162.nextFloat() - 0.5F) * 0.12F, 0.1F, 0.86F);
            v159 = 0.32F + v162.nextFloat() * 0.44F;
            v176 = 0.03F + v162.nextFloat() * 0.07F;
            var6 = 0.6F + v162.nextFloat() * 0.4F;
            v100 = 1.25F;
            v191 = 0.8F;
            v112 = 1.1F;
            var8 = 1.2F;
            break;
         case DEEP:
            v107 = 0.2F + v162.nextFloat() * 0.6F;
            v118 = v1(var2 + (v162.nextFloat() - 0.5F) * 0.3F, 0.12F, 0.82F);
            v159 = 0.04F + v162.nextFloat() * 0.09F;
            v176 = v159;
            var6 = 0.75F + v162.nextFloat() * 0.25F;
            v100 = 0.45F;
            v191 = 1.5F;
            v112 = 1.7F;
            var8 = 1.5F;
            break;
         case SCATTER:
            v107 = 0.5F;
            v118 = 0.5F;
            v159 = 0.42F + v162.nextFloat() * 0.35F;
            v176 = 0.3F + v162.nextFloat() * 0.28F;
            var6 = v162.nextFloat();
            var7 = 3.0F;
            v100 = 1.5F;
            v191 = 0.7F;
            v112 = 0.7F;
            var8 = 1.0F;
            break;
         case BURST:
            v107 = 0.15F + v162.nextFloat() * 0.7F;
            v118 = 0.2F + v162.nextFloat() * 0.6F;
            v159 = 0.025F + v162.nextFloat() * 0.06F;
            v176 = v159;
            var6 = v5();
            v100 = 1.35F;
            v191 = 0.6F;
            v112 = 0.3F;
            var8 = 0.45F;
            break;
         case LADDER:
            v107 = 0.12F + v162.nextFloat() * 0.76F;
            v118 = 0.4F + (v162.nextFloat() - 0.5F) * 0.3F;
            v159 = 0.02F + v162.nextFloat() * 0.045F;
            v176 = 0.24F + v162.nextFloat() * 0.22F;
            var6 = v5();
            v100 = 1.1F;
            v191 = 0.85F;
            v112 = 1.0F;
            var8 = 1.0F;
            break;
         case CREEP:
            boolean var9 = v162.nextBoolean();
            v107 = var9 ? 0.1F : 0.9F;
            v118 = v1(var2 + (v162.nextFloat() - 0.5F) * 0.4F, 0.15F, 0.85F);
            v159 = 0.05F + v162.nextFloat() * 0.08F;
            v176 = v159 * (0.8F + v162.nextFloat() * 1.4F);
            v187 = (var9 ? 1.0F : -1.0F) * (0.09F + v162.nextFloat() * 0.12F);
            v138 = (v162.nextFloat() - 0.5F) * 0.05F;
            var6 = 0.35F + v162.nextFloat() * 0.5F;
            v100 = 0.9F;
            v191 = 0.95F;
            v112 = 0.8F;
            var8 = 0.0F;
            var4 = (long)(0.95F / Math.abs(v187) * 1000.0F);
            break;
         case LEGOS:
            v107 = 0.12F + v162.nextFloat() * 0.76F;
            v118 = 0.18F + v162.nextFloat() * 0.64F;
            v159 = (0.06F + v14 * 0.5F) * (0.6F + v162.nextFloat() * 0.9F);
            v176 = v159;
            v106 = true;
            var6 = 0.0F;
            v100 = 1.0F;
            v191 = 1.0F;
            v112 = 1.0F;
            var8 = 1.0F;
            break;
         case SWEEP:
            v107 = 0.12F + v162.nextFloat() * 0.76F;
            v118 = 0.18F + v162.nextFloat() * 0.64F;
            v159 = (0.06F + v14 * 0.5F) * (0.6F + v162.nextFloat() * 0.9F);
            v176 = v159;
            var6 = v5();
            v100 = 1.0F;
            v191 = 1.0F;
            v112 = 1.0F;
            var8 = 1.0F;
            break;
         default:
            throw new IllegalStateException("unhandled zone mode " + var3);
      }

      long var15 = var4 > 0L ? var4 : (long)(v13 * 1000.0F * var8 * (0.6F + v162.nextFloat() * 0.85F));
      v147 = var0 + Math.max(300L, var15);
      v157 = 7.0F + var6 * Math.max(0.0F, v216 - 7.0F);
      v121 = v157;
      v137 = Math.max(6.0F, v157 * 0.35F) * var7;
      v166 = v137;

      for (cloudSupport31.Part1 var14 : v45) {
         if (var14.v3 && v162.nextFloat() < 0.78F) {
            var14.v3 = false;
         }
      }
   }

   private static cloudSupport32 v4() {
      cloudSupport32[] var0 = cloudSupport32.values();
      float var1 = 0.0F;

      for (cloudSupport32 var5 : var0) {
         if ((v19 & 1 << var5.ordinal()) != 0) {
            var1 += v249[var5.ordinal()];
         }
      }

      if (!(var1 > 0.0F)) {
         return cloudSupport32.SWEEP;
      } else {
         float var7 = v162.nextFloat() * var1;

         for (cloudSupport32 var6 : var0) {
            if ((v19 & 1 << var6.ordinal()) != 0) {
               var7 -= v249[var6.ordinal()];
               if (var7 <= 0.0F) {
                  return var6;
               }
            }
         }

         return cloudSupport32.SWEEP;
      }
   }

   private static float v5() {
      return (float)Math.pow(v162.nextFloat(), 0.55F);
   }

   private static float v1(class_4184 var0) {
      Vector3fc var1 = var0.method_19335();
      float var2 = (float)Math.sqrt(var1.x() * var1.x() + var1.z() * var1.z());
      if (!(var2 > 1.0E-5F)) {
         return 0.5F;
      } else {
         v172.set(var1.x() / var2 * 512.0F, 0.0F, var1.z() / var2 * 512.0F, 1.0F);
         v190.transform(v172);
         return v172.w <= 0.05F ? 0.5F : v1(0.5F - v172.y / v172.w * 0.5F, 0.05F, 0.95F);
      }
   }

   private static int v1(long var0) {
      int var2 = Math.min(Math.round(v9 * v100), 128);
      long var3 = Math.max(1L, (long)((float)(v147 - v116) * 0.75F));
      float var5 = Math.min(1.0F, Math.max(0.0F, (float)(var0 - v116) / (float)var3));
      return Math.max(1, Math.round(var2 * (0.25F + 0.75F * var5)));
   }

   private static float v1(float var0, float var1, float var2) {
      return var0 < var1 ? var1 : Math.min(var0, var2);
   }

   @Nullable
   private static cloudSupport31.Part1 v6() {
      for (cloudSupport31.Part1 var3 : v45) {
         if (!var3.v3) {
            return var3;
         }
      }

      return null;
   }

   private static int v1(cloudSupport31.Part1 var0, class_638 var1, class_1657 var2, class_243 var3, long var4) {
      float var6 = (float)(var4 - v116) / 1000.0F;
      float var7 = v1(v107 + v187 * var6, 0.06F, 0.94F);
      float var8 = v1(v118 + v138 * var6, 0.06F, 0.94F);
      float var9 = 0.5F;
      float var10 = 0.5F;

      for (int var11 = 0; var11 < 4; var11++) {
         float var12 = v162.nextFloat() * (float) (Math.PI * 2);
         float var13 = (float)Math.sqrt(v162.nextFloat());
         var9 = var7 + var13 * v159 * (float)Math.cos(var12);
         var10 = var8 + var13 * v176 * (float)Math.sin(var12);
         if (var9 >= 0.0F && var9 <= 1.0F && var10 >= 0.0F && var10 <= 1.0F) {
            break;
         }
      }

      float var32 = v1(var9, 0.005F, 0.995F) * 2.0F - 1.0F;
      float var33 = 1.0F - v1(var10, 0.005F, 0.995F) * 2.0F;
      v172.set(var32, var33, -1.0F, 1.0F);
      v70.transform(v172);
      if (Math.abs(v172.w) < 1.0E-9F) {
         return -1;
      } else {
         double var34 = v172.x / v172.w;
         double var15 = v172.y / v172.w;
         double var17 = v172.z / v172.w;
         double var19 = Math.sqrt(var34 * var34 + var15 * var15 + var17 * var17);
         if (!(var19 > 1.0E-6)) {
            return -1;
         } else {
            double var21 = v216 / var19;
            class_243 var23 = var3.method_1031(var34 * var21, var15 * var21, var17 * var21);
            class_3965 var24 = var1.method_17742(new class_3959(var3, var23, class_3960.field_17558, class_242.field_1348, var2));
            if (var24.method_17783() != class_240.field_1332) {
               return 0;
            } else {
               class_243 var25 = var24.method_17784();
               double var26 = Math.sqrt(var25.method_1025(var3));
               if (!v106 && !v1(var26)) {
                  return 2;
               } else {
                  var0.v3 = true;
                  var0.v4 = var25.field_1352;
                  var0.v5 = var25.field_1351;
                  var0.v6 = var25.field_1350;
                  var0.v7 = v162.nextInt();
                  float var28 = 420.0F + v162.nextFloat() * 2980.0F;
                  var0.v8 = var4 + (long)(var28 * (1.0F - v11 * 0.45F) * v112);
                  float var29 = v162.nextFloat();
                  float var30 = v106 ? 1.0F : v2(var26);
                  float var31 = (5.0F + var29 * var29 * 31.0F) * v191 * var30;
                  var0.v9 = v1(var31, 3.0F, 90.0F);
                  var0.v11 = v7();
                  var0.v10 = v1(
                     var0.v11 == cloudSupport34.PANEL ? var0.v9 * (0.12F + v162.nextFloat() * 1.1F) : var0.v9 * (0.6F + v162.nextFloat() * 0.9F), 3.0F, 90.0F
                  );
                  var0.v12 = v16 && v162.nextFloat() < 0.45F;
                  return 1;
               }
            }
         }
      }
   }

   private static boolean v1(double var0) {
      float var2 = (float)((var0 - v157) / v166);
      if (v162.nextFloat() > (float)Math.exp(-var2 * var2)) {
         v166 = Math.min(v166 * 1.22F, Math.max(v216, 6.0F));
         return false;
      } else {
         v166 = Math.max(v137, v166 * 0.8F);
         v157 = v1(v157 + (float)(var0 - v157) * 0.09F, v121 * 0.5F, Math.max(v216, 7.0F));
         return true;
      }
   }

   private static float v2(double var0) {
      float var2 = v1(((float)var0 - 10.0F) / 100.0F, 0.0F, 1.0F);
      float var3 = var2 * var2 * (3.0F - 2.0F * var2);
      return 1.15F + -0.45F * var3;
   }

   private static cloudSupport34 v7() {
      cloudSupport34[] var0 = cloudSupport34.values();
      int var1 = v18;
      if (var1 == 0) {
         return cloudSupport34.BOX;
      } else {
         for (int var2 = 0; var2 < 8; var2++) {
            cloudSupport34 var3 = var0[v162.nextInt(var0.length)];
            if ((var1 & 1 << var3.ordinal()) != 0) {
               return var3;
            }
         }

         for (cloudSupport34 var5 : var0) {
            if ((var1 & 1 << var5.ordinal()) != 0) {
               return var5;
            }
         }

         return cloudSupport34.BOX;
      }
   }

   private static void v1(Matrix4f var0, class_4184 var1) {
      v160.set(var1.method_23767());
      v133.rotation(v160.conjugate());
      v190.set(var0).mul(v133);
   }

   private static boolean v1(cloudSupport31.Part1 var0, class_243 var1, float var2, float var3, int var4) {
      v172.set((float)(var0.v4 - var1.field_1352), (float)(var0.v5 - var1.field_1351), (float)(var0.v6 - var1.field_1350), 1.0F);
      v190.transform(v172);
      if (v172.w <= 0.05F) {
         var0.v3 = false;
         return false;
      } else {
         float var5 = (v172.x / v172.w * 0.5F + 0.5F) * var2;
         float var6 = (0.5F - v172.y / v172.w * 0.5F) * var3;
         if (!(var5 < -80.0F) && !(var5 > var2 + 80.0F) && !(var6 < -80.0F) && !(var6 > var3 + 80.0F)) {
            float var7 = v11 * 3.5F;
            var5 += v3(var0.v7 ^ 1374496513, var4) * var7;
            var6 += v3(var0.v7 ^ 461845907, var4) * var7;
            if (v2(var0.v7 ^ 668265263, var4) < v11 * 0.07F) {
               var5 += v3(var0.v7 ^ 374761393, var4) * 16.0F;
               var6 += v3(var0.v7 ^ -1640531535, var4) * 16.0F;
            }

            float var8 = 1.0F + v3(var0.v7 ^ -2048144777, var4) * v11 * 0.2F;
            var0.v13 = var5;
            var0.v14 = var6;
            var0.v15 = Math.max(1.0F, var0.v9 * var8);
            var0.v16 = Math.max(1.0F, var0.v10 * var8);
            return !(v2(var0.v7, var4) < v1(var0));
         } else {
            var0.v3 = false;
            return false;
         }
      }
   }

   private static float v1(cloudSupport31.Part1 var0) {
      float var1 = (var0.v7 >>> 5 & 0xFF) / 255.0F;
      return var1 * var1 * v11 * 0.5F;
   }

   private static void v8() {
      float var0 = v8;

      for (int var1 = 0; var1 < v125; var1++) {
         cloudSupport31.Part1 var2 = v104[var1];
         float var3 = var2.v13 - var2.v15;
         float var4 = var2.v14 - var2.v16;
         float var5 = var2.v15 * 2.0F;
         float var6 = var2.v16 * 2.0F;
         if (var2.v11 == cloudSupport34.PANEL) {
            uiSupport169.v1(var3, var4, var5, var6, v4);
         } else if (var2.v11 == cloudSupport34.TICKS) {
            float var7 = Math.max(var0, Math.min(var5, var6) * 0.42F);
            float var8 = var7 - var0;
            uiSupport169.v1(var3, var4, var0, var7, v5);
            uiSupport169.v1(var3 + var5 - var0, var4, var0, var7, v5);
            uiSupport169.v1(var3, var4 + var6 - var7, var0, var7, v5);
            uiSupport169.v1(var3 + var5 - var0, var4 + var6 - var7, var0, var7, v5);
            if (var8 > 0.0F) {
               uiSupport169.v1(var3 + var0, var4, var8, var0, v5);
               uiSupport169.v1(var3 + var5 - var7, var4, var8, var0, v5);
               uiSupport169.v1(var3 + var0, var4 + var6 - var0, var8, var0, v5);
               uiSupport169.v1(var3 + var5 - var7, var4 + var6 - var0, var8, var0, v5);
            }
         }
      }
   }

   private static void v1(int var0) {
      float var1 = v8;

      for (int var2 = 0; var2 < v125; var2++) {
         cloudSupport31.Part1 var3 = v104[var2];
         if (var3.v11 == cloudSupport34.CROSS) {
            float var4 = var3.v13 - var3.v15;
            float var5 = var3.v14 - var3.v16;
            float var6 = var3.v13 + var3.v15;
            float var7 = var3.v14 + var3.v16;
            uiSupport169.v3(var4, var5, var6, var7, v3, var1);
            uiSupport169.v3(var4, var7, var6, var5, v3, var1);
         }
      }

      if (v15 == cloudSupport33.LINES || v15 == cloudSupport33.LINES_AND_CURVE) {
         v1(var0, var1);
      }

      if (v15 == cloudSupport33.CURVE || v15 == cloudSupport33.LINES_AND_CURVE) {
         v1(var1);
      }
   }

   private static void v1(int var0, float var1) {
      if (v125 >= 2) {
         int var2 = var0 / 5;

         for (int var3 = 0; var3 < v125; var3++) {
            cloudSupport31.Part1 var4 = v104[var3];
            if (!(v2(var4.v7 ^ 2146121005, var2) > 0.34F)) {
               cloudSupport31.Part1 var5 = v1(var4, var2);
               if (var5 != null) {
                  uiSupport169.v3(var4.v13, var4.v14, var5.v13, var5.v14, v6, var1);
               }
            }
         }
      }
   }

   @Nullable
   private static cloudSupport31.Part1 v1(cloudSupport31.Part1 var0, int var1) {
      int var2 = (int)(v2(v93 ^ var0.v1, var1) * 128.0F);

      for (int var3 = 0; var3 < 128; var3++) {
         cloudSupport31.Part1 var4 = v45[(var2 + var3) % 128];
         if (var4 != var0 && var4.v2 == v141) {
            return var4;
         }
      }

      return null;
   }

   private static void v1(float var0) {
      int var1 = v9();
      if (var1 >= 4) {
         float var2 = 0.0F;
         float var3 = 0.0F;
         boolean var4 = false;

         for (int var5 = 0; var5 + 3 < var1; var5++) {
            cloudSupport31.Part1 var6 = v145[var5];
            cloudSupport31.Part1 var7 = v145[var5 + 1];
            cloudSupport31.Part1 var8 = v145[var5 + 2];
            cloudSupport31.Part1 var9 = v145[var5 + 3];

            for (int var10 = 0; var10 <= 7; var10++) {
               float var11 = var10 / 7.0F;
               float var12 = v1(var6.v13, var7.v13, var8.v13, var9.v13, var11);
               float var13 = v1(var6.v14, var7.v14, var8.v14, var9.v14, var11);
               if (var4) {
                  float var14 = var12 - var2;
                  float var15 = var13 - var3;
                  if (var14 * var14 + var15 * var15 > 0.25F) {
                     uiSupport169.v3(var2, var3, var12, var13, v6, var0);
                  }
               }

               var2 = var12;
               var3 = var13;
               var4 = true;
            }
         }
      }
   }

   private static int v9() {
      int var0 = (int)(v2(v93 ^ -2073254261, 0) * 128.0F);
      int var1 = 0;

      for (int var2 = 0; var2 < 128 && var1 < 8; var2++) {
         cloudSupport31.Part1 var3 = v45[(var0 + var2) % 128];
         if (var3.v2 == v141) {
            v145[var1++] = var3;
         }
      }

      return var1;
   }

   private static float v1(float var0, float var1, float var2, float var3, float var4) {
      float var5 = var4 * var4;
      float var6 = var5 * var4;
      return 0.5F
         * (2.0F * var1 + (var2 - var0) * var4 + (2.0F * var0 - 5.0F * var1 + 4.0F * var2 - var3) * var5 + (3.0F * var1 - var0 - 3.0F * var2 + var3) * var6);
   }

   private static void v10() {
      for (int var0 = 0; var0 < v125; var0++) {
         cloudSupport31.Part1 var1 = v104[var0];
         if (var1.v11 == cloudSupport34.BOX || var1.v11 == cloudSupport34.CROSS) {
            uiSupport169.v2(var1.v13 - var1.v15, var1.v14 - var1.v16, var1.v15 * 2.0F, var1.v16 * 2.0F, var1.v11 == cloudSupport34.BOX ? v2 : v3, v8);
         }
      }
   }

   private static void v11() {
      if (v16) {
         for (int var0 = 0; var0 < v125; var0++) {
            cloudSupport31.Part1 var1 = v104[var0];
            if (var1.v12) {
               uiSupport169.v1("syky_sans", cloudSupport30.v1(var1.v7), var1.v13 - var1.v15, var1.v14 - var1.v16 - 1.0F - 6.24F, 6.5F, v7);
            }
         }
      }
   }

   private static int v1(int var0, int var1) {
      int var2 = var0 * -1640531527 + var1 * -2048144789;
      var2 ^= var2 >>> 15;
      var2 *= 625341585;
      return var2 ^ var2 >>> 13;
   }

   private static float v2(int var0, int var1) {
      return (v1(var0, var1) >>> 8) / 1.6777216E7F;
   }

   private static float v3(int var0, int var1) {
      return v2(var0, var1) * 2.0F - 1.0F;
   }

   static {
      for (int var0 = 0; var0 < 128; v45[var0].v1 = var0++) {
         v45[var0] = new cloudSupport31.Part1();
      }

      v145 = new cloudSupport31.Part1[8];
      v162 = new Random();
      v107 = 0.5F;
      v118 = 0.4F;
      v159 = 0.25F;
      v176 = 0.25F;
      v157 = 24.0F;
      v166 = 12.0F;
      v121 = 24.0F;
      v137 = 12.0F;
      v100 = 1.0F;
      v191 = 1.0F;
      v112 = 1.0F;
      v216 = 48.0F;
      v190 = new Matrix4f();
      v70 = new Matrix4f();
      v133 = new Matrix4f();
      v160 = new Quaternionf();
      v172 = new Vector4f();
      v249 = new float[]{0.22F, 0.18F, 0.15F, 0.14F, 0.1F, 0.11F, 0.1F, 0.15F};
   }

   public static final class Part1 {
      public int v1;
      public int v2 = -1;
      public boolean v3;
      public double v4;
      public double v5;
      public double v6;
      public int v7;
      public long v8;
      public float v9;
      public float v10;
      public cloudSupport34 v11 = cloudSupport34.BOX;
      public boolean v12;
      public float v13;
      public float v14;
      public float v15;
      public float v16;

      public Part1() {
      }
   }
}
