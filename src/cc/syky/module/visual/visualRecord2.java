package cc.syky.module.visual;

import cc.syky.mixin.accessor.BlockModelsAccessor;
import cc.syky.ui.uiSupport260;
import com.google.common.collect.UnmodifiableIterator;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.function.Supplier;
import net.fabricmc.fabric.api.renderer.v1.mesh.QuadEmitter;
import net.fabricmc.fabric.api.renderer.v1.mesh.ShadeMode;
import net.minecraft.class_1047;
import net.minecraft.class_1058;
import net.minecraft.class_1059;
import net.minecraft.class_10725;
import net.minecraft.class_1087;
import net.minecraft.class_10889;
import net.minecraft.class_11515;
import net.minecraft.class_11697;
import net.minecraft.class_1920;
import net.minecraft.class_2248;
import net.minecraft.class_2338;
import net.minecraft.class_2350;
import net.minecraft.class_2397;
import net.minecraft.class_2680;
import net.minecraft.class_4696;
import net.minecraft.class_5819;
import net.minecraft.class_773;
import net.minecraft.class_777;
import net.minecraft.class_7923;
import net.minecraft.class_2338.class_2339;
import org.jetbrains.annotations.Nullable;

public final class visualRecord2 {
   private static final class_2350[] v1 = class_2350.values();
   public static final float v2 = (float)Math.toRadians(60.0);
   public static final float v3 = (float)Math.toRadians(60.0);
   private static final float v4 = 0.12F;
   private static final float v5 = 0.1F;
   public static final uiSupport260 v6 = new uiSupport260("bushyleaves.mesh");
   public static volatile boolean v7;

   private visualRecord2() {
   }

   @Nullable
   public static Map<class_2680, class_1087> v1(class_773 var0, Supplier<class_11697> var1) {
      Map var2 = ((BlockModelsAccessor)var0).syky$models();
      if (var2.isEmpty()) {
         return null;
      } else {
         class_1059 var3 = ((class_11697)var1.get()).method_73025(class_10725.field_56382);
         class_1087 var4 = var0.method_3333().method_68046();
         HashMap var5 = new HashMap();
         HashMap var6 = new HashMap();
         class_5819 var7 = class_5819.method_43047();
         ArrayList var8 = new ArrayList();

         for (class_2248 var10 : class_7923.field_41175) {
            if (var10 instanceof class_2397) {
               UnmodifiableIterator var11 = var10.method_9595().method_11662().iterator();

               while (var11.hasNext()) {
                  class_2680 var12 = (class_2680)var11.next();
                  class_1087 var13 = (class_1087)var2.get(var12);
                  if (var13 != null && var13 != var4) {
                     var8.clear();
                     var13.method_68513(var7, var8);
                     class_777 var14 = v1(var8);
                     if (var14 != null) {
                        class_1058 var15 = var14.comp_3724();
                        if (!var6.containsKey(var15)) {
                           var6.put(var15, v1(var15, var3));
                        }

                        class_1058 var16 = (class_1058)var6.get(var15);
                        if (var16 != null) {
                           int var17 = var16.method_45851().method_45807() / var15.method_45851().method_45807();
                           var5.put(var12, new visualRecord2.Part1(var13, var16, var14.comp_3722(), var17));
                        }
                     }
                  }
               }
            }
         }

         v7 = false;
         return Map.copyOf(var5);
      }
   }

   @Nullable
   private static class_777 v1(List<class_10889> var0) {
      for (class_10889 var2 : var0) {
         for (class_2350 var6 : v1) {
            List var7 = var2.method_68509(var6);
            if (!var7.isEmpty()) {
               return (class_777)var7.getFirst();
            }
         }
      }

      return null;
   }

   @Nullable
   private static class_1058 v1(class_1058 var0, class_1059 var1) {
      class_1058 var2 = var1.method_4608(visualSupport60.v1(var0.method_45851().method_45816()));
      return var2.method_45851().method_45816().equals(class_1047.method_4539()) ? null : var2;
   }

   public static boolean v1(class_1920 var0, class_2338 var1) {
      if (v2(var0, var1)) {
         return true;
      } else {
         class_2339 var2 = new class_2339();

         for (class_2350 var6 : v1) {
            var2.method_25505(var1, var6);
            if (var0.method_8320(var2).method_26204() instanceof class_2397 && v2(var0, var2.method_10062())) {
               return true;
            }
         }

         return false;
      }
   }

   private static boolean v2(class_1920 var0, class_2338 var1) {
      class_2339 var2 = new class_2339();

      for (class_2350 var6 : v1) {
         class_2680 var7 = var0.method_8320(var2.method_25505(var1, var6));
         if (!(var7.method_26204() instanceof class_2397) && !var7.method_26216()) {
            return true;
         }
      }

      return false;
   }

   public record Part1(class_1087 delegate, class_1058 tuft, int tint, int tiles) implements class_1087 {
      public void method_68513(class_5819 var1, List<class_10889> var2) {
         this.delegate.method_68513(var1, var2);
      }

      public class_1058 method_68511() {
         return this.delegate.method_68511();
      }

      public class_1058 v1(class_1920 var1, class_2338 var2, class_2680 var3) {
         return this.delegate.particleSprite(var1, var2, var3);
      }

      public void v1(QuadEmitter var1, class_1920 var2, class_2338 var3, class_2680 var4, class_5819 var5, Predicate<class_2350> var6) {
         this.delegate.emitQuads(var1, var2, var3, var4, var5, var6);
         if (!visualRecord2.v7) {
            try {
               this.v1(var1, var2, var3, var4);
            } catch (Throwable var8) {
               visualRecord2.v7 = true;
               visualRecord2.v6.v1(var8);
            }
         }
      }

      private void v1(QuadEmitter var1, class_1920 var2, class_2338 var3, class_2680 var4) {
         if (class_4696.method_23679(var4) == class_11515.field_60925 && visualRecord2.v1(var2, var3)) {
            float var5 = visualSupport61.v3;
            float var6 = visualSupport60.v1(var5, this.tiles);
            float var7 = visualSupport60.v2(var5, this.tiles);
            visualRecord2.Part1.Part1 var8 = new visualRecord2.Part1.Part1(
               var6 / 2.0F, (var7 - 1.0F) / 2.0F, var6 / (2.0F * this.tiles), var7 / (2.0F * this.tiles)
            );
            long var9 = v1(var3.method_10063());
            long var11 = v1(var9);
            float var13 = (float) Math.PI * v2(var9);
            this.v1(var1, var8, var13, var9 >>> 16, var11);
            this.v1(var1, var8, var13 + visualRecord2.v2 + visualRecord2.v3 * v2(var9 >>> 32), var9 >>> 48, var11 >>> 32);
         }
      }

      private void v1(QuadEmitter var1, visualRecord2.Part1.Part1 var2, float var3, long var4, long var6) {
         float var8 = (float)Math.cos(var3);
         float var9 = (float)Math.sin(var3);
         float var10 = 0.12F * (2.0F * v2(var4) - 1.0F);
         float var11 = 0.5F - var9 * var10;
         float var12 = 0.5F + var8 * var10;
         float var13 = 0.1F * (2.0F * v2(var6) - 1.0F);
         float var14 = var11 - var8 * var2.v1();
         float var15 = var12 - var9 * var2.v1();
         float var16 = var11 + var8 * var2.v1();
         float var17 = var12 + var9 * var2.v1();
         float var18 = -var2.v2() + var13;
         float var19 = 1.0F + var2.v2() + var13;
         boolean var20 = (var6 & 65536L) != 0L;
         boolean var21 = (var6 & 131072L) != 0L;
         float var22 = 0.5F + (var20 ? var2.v3() : -var2.v3());
         float var23 = 1.0F - var22;
         float var24 = 0.5F + (var21 ? var2.v4() : -var2.v4());
         float var25 = 1.0F - var24;
         this.v1(var1, var14, var15, var22, var16, var17, var23, var18, var19, var24, var25);
         this.v1(var1, var16, var17, var23, var14, var15, var22, var18, var19, var24, var25);
      }

      private void v1(
         QuadEmitter var1, float var2, float var3, float var4, float var5, float var6, float var7, float var8, float var9, float var10, float var11
      ) {
         var1.pos(0, var2, var9, var3).uv(0, var4, var10);
         var1.pos(1, var2, var8, var3).uv(1, var4, var11);
         var1.pos(2, var5, var8, var6).uv(2, var7, var11);
         var1.pos(3, var5, var9, var6).uv(3, var7, var10);
         var1.spriteBake(this.tuft, 32);
         var1.tintIndex(this.tint);
         var1.shadeMode(ShadeMode.VANILLA);
         var1.emit();
      }

      private static long v1(long var0) {
         var0 = (var0 ^ var0 >>> 30) * -4658895280553007687L;
         var0 = (var0 ^ var0 >>> 27) * -7723592293110705685L;
         return var0 ^ var0 >>> 31;
      }

      private static float v2(long var0) {
         return (float)(var0 & 65535L) / 65536.0F;
      }

      public class_1087 v1() {
         return this.delegate;
      }

      public class_1058 v2() {
         return this.tuft;
      }

      public int v3() {
         return this.tint;
      }

      public int v4() {
         return this.tiles;
      }

      public record Part1(float halfWidth, float overhang, float halfU, float halfV) {
         public float v1() {
            return this.halfWidth;
         }

         public float v2() {
            return this.overhang;
         }

         public float v3() {
            return this.halfU;
         }

         public float v4() {
            return this.halfV;
         }
      }
   }
}
