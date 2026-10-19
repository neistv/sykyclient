package cc.syky.module.visual;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import net.minecraft.class_1011;
import net.minecraft.class_1043;
import net.minecraft.class_2960;
import net.minecraft.class_310;
import net.minecraft.class_3298;
import net.minecraft.class_1011.class_1012;
import org.jetbrains.annotations.Nullable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public final class visualSupport54 {
   public static final Logger v3 = LoggerFactory.getLogger("syky.hearts");
   public static final int v1 = -60653;
   public static final int v2 = -2838729;
   private static final String v4 = "hud/heart/";
   private static final int v5 = 65536;
   private static final List<visualSupport54> v6 = new ArrayList<>();
   private final Map<class_2960, visualSupport54.Part1> v7 = new HashMap<>();
   private boolean v8;
   private boolean v9;
   private int v10;

   private visualSupport54() {
   }

   public static visualSupport54 v1(String var0, String... var1) {
      visualSupport54 var2 = new visualSupport54();

      for (String var6 : var1) {
         var2.v7.put(v1(var6), new visualSupport54.Part1(var0, var6));
      }

      v6.add(var2);
      return var2;
   }

   public static class_2960 v1(String var0) {
      return class_2960.method_60656("hud/heart/" + var0);
   }

   public void v1(int var1) {
      if (!this.v8 && (!this.v9 || var1 != this.v10)) {
         class_310 var2 = class_310.method_1551();
         if (var2 != null) {
            for (visualSupport54.Part1 var4 : this.v7.values()) {
               if (!var4.v1(var2, var1)) {
                  this.v2();
                  this.v8 = true;
                  return;
               }
            }

            this.v9 = true;
            this.v10 = var1;
         }
      }
   }

   @Nullable
   public visualSupport54.Part3 v1(class_2960 var1) {
      if (!this.v9) {
         return null;
      } else {
         visualSupport54.Part1 var2 = this.v7.get(var1);
         return var2 == null ? null : var2.v10;
      }
   }

   public static void v1() {
      for (visualSupport54 var1 : v6) {
         var1.v2();
         var1.v8 = false;
      }
   }

   private void v2() {
      for (visualSupport54.Part1 var2 : this.v7.values()) {
         var2.v1();
      }

      this.v9 = false;
   }

   @Nullable
   public static visualSupport54.Part2 v1(class_310 var0, class_2960 var1) {
      Optional var2 = var0.method_1478().method_14486(var1);
      if (var2.isEmpty()) {
         v3.debug("heart recolour: {} not in the resource manager", var1);
         return null;
      } else {
         try {
            Object var15;
            try (InputStream var3 = ((class_3298)var2.get()).method_14482()) {
               class_1011 var4 = class_1011.method_4309(var3);

               label119: {
                  visualSupport54.Part2 var16;
                  try {
                     int var5 = var4.method_4307();
                     int var6 = var4.method_4323();
                     if (var5 <= 0 || var6 <= 0 || var5 * var6 > 65536) {
                        v3.debug("heart recolour: {} is {}x{}, not a heart sprite", new Object[]{var1, var5, var6});
                        var15 = null;
                        break label119;
                     }

                     int[] var7 = new int[var5 * var6];

                     for (int var8 = 0; var8 < var6; var8++) {
                        for (int var9 = 0; var9 < var5; var9++) {
                           var7[var8 * var5 + var9] = var4.method_61940(var9, var8);
                        }
                     }

                     var16 = new visualSupport54.Part2(var7, var5, var6);
                  } catch (Throwable var12) {
                     if (var4 != null) {
                        try {
                           var4.close();
                        } catch (Throwable var11) {
                           var12.addSuppressed(var11);
                        }
                     }

                     throw var12;
                  }

                  if (var4 != null) {
                     var4.close();
                  }

                  return var16;
               }

               if (var4 != null) {
                  var4.close();
               }
            }

            return (visualSupport54.Part2)var15;
         } catch (Throwable var14) {
            v3.debug("heart recolour: reading {} failed", var1, var14);
            return null;
         }
      }
   }

   public static int v1(int[] var0) {
      int[] var1 = new int[var0.length];
      int var2 = 0;

      for (int var6 : var0) {
         if (var6 >>> 24 == 255) {
            var1[var2++] = var6;
         }
      }

      if (var2 == 0) {
         return 0;
      } else {
         Arrays.sort(var1, 0, var2);
         int var7 = var1[0];
         int var8 = 0;
         int var9 = 0;

         for (int var10 = 0; var10 < var2; var10++) {
            var9 = var10 > 0 && var1[var10] == var1[var10 - 1] ? var9 + 1 : 1;
            if (var9 > var8) {
               var8 = var9;
               var7 = var1[var10];
            }
         }

         return var7;
      }
   }

   public static final class Part1 {
      private final class_2960 v1;
      private final class_2960 v2;
      private final class_2960 v3;
      private final String v4;
      @Nullable
      private int[] v5;
      private int v6;
      private int v7;
      private int v8;
      @Nullable
      private class_1043 v9;
      @Nullable
      public visualSupport54.Part3 v10;

      public Part1(String var1, String var2) {
         this.v1 = v1(var2);
         this.v2 = v1(var2.replace("_blinking", ""));
         this.v3 = class_2960.method_60655("syky", "hud/heart/" + var1 + "/" + var2);
         this.v4 = "syky_heart_" + var1 + "_" + var2;
      }

      private static class_2960 v1(String var0) {
         return class_2960.method_60656("textures/gui/sprites/hud/heart/" + var0 + ".png");
      }

      public boolean v1(class_310 var1, int var2) {
         if (!this.v1(var1)) {
            return false;
         } else {
            int[] var3 = this.v5;
            if (var3 == null) {
               return false;
            } else {
               try {
                  class_1043 var4 = this.v9;
                  if (var4 == null) {
                     class_1011 var5 = new class_1011(class_1012.field_4997, this.v6, this.v7, true);
                     this.v1(var5, var3, var2);
                     var4 = new class_1043(() -> this.v4, var5);
                     var1.method_1531().method_4616(this.v3, var4);
                     this.v9 = var4;
                     this.v10 = new visualSupport54.Part3(this.v3, this.v6, this.v7);
                  } else {
                     this.v1(var4.method_4525(), var3, var2);
                     var4.method_4524();
                  }

                  return true;
               } catch (Throwable var6) {
                  visualSupport54.v3.debug("heart recolour bake failed for {}", this.v1, var6);
                  return false;
               }
            }
         }
      }

      private boolean v1(class_310 var1) {
         if (this.v5 != null) {
            return true;
         } else {
            visualSupport54.Part2 var2 = visualSupport54.v1(var1, this.v1);
            if (var2 == null) {
               return false;
            } else {
               visualSupport54.Part2 var3 = this.v2.equals(this.v1) ? var2 : visualSupport54.v1(var1, this.v2);
               if (var3 == null) {
                  return false;
               } else {
                  this.v8 = visualSupport54.v1(var3.v1());
                  this.v6 = var2.v2();
                  this.v7 = var2.v3();
                  this.v5 = var2.v1();
                  return true;
               }
            }
         }
      }

      public void v1() {
         class_1043 var1 = this.v9;
         this.v9 = null;
         this.v10 = null;
         this.v5 = null;
         if (var1 != null) {
            class_310 var2 = class_310.method_1551();

            try {
               if (var2 == null) {
                  var1.close();
               } else {
                  var2.method_1531().method_4615(this.v3);
               }
            } catch (Throwable var4) {
               visualSupport54.v3.debug("heart recolour: releasing {} failed", this.v3, var4);
            }
         }
      }

      private void v1(class_1011 var1, int[] var2, int var3) {
         for (int var4 = 0; var4 < this.v7; var4++) {
            int var5 = var4 * this.v6;

            for (int var6 = 0; var6 < this.v6; var6++) {
               var1.method_61941(var6, var4, visualSupport55.v1(var2[var5 + var6], var3, this.v8));
            }
         }
      }
   }

   public record Part2(int[] pixels, int width, int height) {
      public int[] v1() {
         return this.pixels;
      }

      public int v2() {
         return this.width;
      }

      public int v3() {
         return this.height;
      }
   }

   public record Part3(class_2960 id, int width, int height) {
      public class_2960 v1() {
         return this.id;
      }

      public int v2() {
         return this.width;
      }

      public int v3() {
         return this.height;
      }
   }
}
