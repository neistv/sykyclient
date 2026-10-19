package cc.syky.module.visual;

import cc.syky.ui.uiSupport260;
import com.mojang.blaze3d.systems.CommandEncoder;
import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.textures.GpuTexture;
import com.mojang.serialization.MapCodec;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Map.Entry;
import java.util.concurrent.ConcurrentHashMap;
import net.minecraft.class_1011;
import net.minecraft.class_1058;
import net.minecraft.class_1059;
import net.minecraft.class_1079;
import net.minecraft.class_1084;
import net.minecraft.class_12253;
import net.minecraft.class_2960;
import net.minecraft.class_310;
import net.minecraft.class_3298;
import net.minecraft.class_3300;
import net.minecraft.class_4725;
import net.minecraft.class_7368;
import net.minecraft.class_7764;
import net.minecraft.class_7771;
import net.minecraft.class_7948;
import net.minecraft.class_7948.class_7949;
import org.jetbrains.annotations.Nullable;

public final class visualSupport60 implements class_7948 {
   public static final visualSupport60 v1 = new visualSupport60();
   private static final uiSupport260 v2 = new uiSupport260("bushyleaves.atlas");
   private static final String v3 = "leaf_tuft/";
   private static final int v4 = 4;
   private static final int v5 = 2;
   private static final int v6 = 256;
   private static volatile Map<class_2960, visualSupport60.Part1> v7 = Map.of();
   private static final double v8 = 0.25;
   private static final double v9 = 2.4;

   private visualSupport60() {
   }

   public static class_2960 v1(class_2960 var0) {
      return class_2960.method_60655("syky", "leaf_tuft/" + var0.method_12836() + "/" + var0.method_12832());
   }

   public static float v1(float var0, int var1) {
      return Math.min(var0, (float)var1);
   }

   public static float v2(float var0, int var1) {
      return Math.min(0.875F * var0, (float)var1);
   }

   public void method_47673(class_3300 var1, class_7949 var2) {
      ConcurrentHashMap var3 = new ConcurrentHashMap();
      v7 = var3;

      try {
         Map var4 = var1.method_14488("textures/block", var0 -> var0.method_12832().endsWith("leaves.png"));

         for (Entry var6 : var4.entrySet()) {
            class_2960 var7 = v1(field_42075.method_45115((class_2960)var6.getKey()));
            class_3298 var8 = (class_3298)var6.getValue();
            var2.method_47670(var7, var3x -> v1(var7, var8, var3));
         }
      } catch (Throwable var9) {
         if (class_310.method_1551().method_22108()) {
            v2.v1(var9);
         }
      }
   }

   public MapCodec<? extends class_7948> method_67288() {
      return MapCodec.unit(v1);
   }

   // $VF: Could not verify finally blocks. A semaphore variable has been added to preserve control flow.
   // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
   public static void v1(class_1059 var0, int var1, float var2) {
      GpuTexture var3 = var0.method_68004();
      CommandEncoder var4 = RenderSystem.getDevice().createCommandEncoder();

      for (Entry var6 : v7.entrySet()) {
         visualSupport60.Part1 var7 = (visualSupport60.Part1)var6.getValue();
         class_1058 var8 = var0.method_4608((class_2960)var6.getKey());
         class_7764 var9 = var8.method_45851();
         if (var9.method_45816().equals(var6.getKey()) && var9.method_45807() == var7.v2 && var9.method_45815() == var7.v2) {
            int var10 = Math.round(var7.v2 / (var8.method_4577() - var8.method_4594()));
            int var11 = Math.round(var7.v2 / (var8.method_4575() - var8.method_4593()));
            int var12 = Math.round(var8.method_4594() * var10);
            int var13 = Math.round(var8.method_4593() * var11);
            class_1011[] var14 = class_4725.method_24102((class_2960)var6.getKey(), new class_1011[]{v1(var7, var2)}, var1, var7.v4, var7.v5);
            boolean var25 = false /* VF: Semaphore variable */;

            try {
               var25 = true;

               for (int var15 = 0; var15 < var14.length; var15++) {
                  int var16 = var7.v2 >> var15;
                  var4.writeToTexture(var3, var14[var15], var15, 0, var12 >> var15, var13 >> var15, var16, var16, 0, 0);
               }

               var25 = false;
            } finally {
               if (var25) {
                  for (class_1011 var23 : var14) {
                     var23.close();
                  }
               }
            }

            for (class_1011 var18 : var14) {
               var18.close();
            }
         }
      }
   }

   @Nullable
   private static class_7764 v1(class_2960 var0, class_3298 var1, Map<class_2960, visualSupport60.Part1> var2) {
      try {
         class_7368 var3 = var1.method_14481();
         if (var3.method_43041(class_1079.field_55537).isPresent()) {
            return null;
         } else {
            Optional var4 = var3.method_43041(class_1084.field_55542);

            Object var19;
            try (InputStream var5 = var1.method_14482()) {
               class_1011 var6 = class_1011.method_4309(var5);

               label156: {
                  Object var20;
                  label157: {
                     class_7764 var22;
                     try {
                        int var7 = var6.method_4307();
                        if (var7 != var6.method_4323() || var7 < 4) {
                           var19 = null;
                           break label156;
                        }

                        int var8 = var7 * 4 <= 256 ? 4 : 2;
                        int var9 = var7 * var8;
                        if (var9 > 256) {
                           var20 = null;
                           break label157;
                        }

                        int[] var10 = new int[var9 * var9];

                        for (int var11 = 0; var11 < var9; var11++) {
                           for (int var12 = 0; var12 < var9; var12++) {
                              var10[var11 * var9 + var12] = var6.method_61940(var12 % var7, var11 % var7);
                           }
                        }

                        visualSupport60.Part1 var21 = new visualSupport60.Part1(
                           var8,
                           var9,
                           var10,
                           var4.<class_12253>map(class_1084::comp_5160).orElse(class_12253.field_64076),
                           var4.<Float>map(class_1084::comp_5264).orElse(0.0F)
                        );
                        var2.put(var0, var21);
                        var22 = new class_7764(var0, new class_7771(var9, var9), v1(var21, visualSupport61.v3), Optional.empty(), List.of(), var4);
                     } catch (Throwable var15) {
                        if (var6 != null) {
                           try {
                              var6.close();
                           } catch (Throwable var14) {
                              var15.addSuppressed(var14);
                           }
                        }

                        throw var15;
                     }

                     if (var6 != null) {
                        var6.close();
                     }

                     return var22;
                  }

                  if (var6 != null) {
                     var6.close();
                  }

                  return (class_7764)var20;
               }

               if (var6 != null) {
                  var6.close();
               }
            }

            return (class_7764)var19;
         }
      } catch (RuntimeException | IOException var17) {
         return null;
      } catch (Throwable var18) {
         v2.v1(var18);
         return null;
      }
   }

   private static class_1011 v1(visualSupport60.Part1 var0, float var1) {
      int var2 = var0.v2;
      float var3 = v1(var1, var0.v1) / var0.v1;
      float var4 = v2(var1, var0.v1) / var0.v1;
      class_1011 var5 = new class_1011(var2, var2, false);

      for (int var6 = 0; var6 < var2; var6++) {
         for (int var7 = 0; var7 < var2; var7++) {
            int var8 = var0.v3[var6 * var2 + var7];
            double var9 = v1((var7 + 0.5) / var2, (var6 + 0.5) / var2, var3, var4);
            boolean var11 = var9 < 1.0 - 0.25 * v1(var7, var6);
            var5.method_61941(var7, var6, var11 ? var8 : var8 & 16777215);
         }
      }

      return var5;
   }

   public static double v1(double var0, double var2, float var4, float var5) {
      double var6 = (var0 - 0.5) / (var4 * 0.5);
      double var8 = (var2 - 0.5) / (var5 * 0.5);
      double var10 = Math.atan2(var8, var6);
      double var12 = 1.0 - 0.06 * (0.5 + 0.5 * Math.sin(3.0 * var10 + 0.4)) - 0.03 * (0.5 + 0.5 * Math.sin(7.0 * var10 + 2.1));
      double var14 = Math.pow(Math.pow(Math.abs(var6), 2.4) + Math.pow(Math.abs(var8), 2.4), 0.4166666666666667);
      return var14 / var12;
   }

   private static double v1(int var0, int var1) {
      int var2 = var0 * 668265261 ^ var1 * 374761393;
      var2 ^= var2 >>> 15;
      var2 *= 739982445;
      var2 ^= var2 >>> 12;
      return (var2 & 65535) / 65536.0;
   }

   public static final class Part1 {
      public final int v1;
      public final int v2;
      public final int[] v3;
      public final class_12253 v4;
      public final float v5;

      public Part1(int var1, int var2, int[] var3, class_12253 var4, float var5) {
         this.v1 = var1;
         this.v2 = var2;
         this.v3 = var3;
         this.v4 = var4;
         this.v5 = var5;
      }
   }
}
