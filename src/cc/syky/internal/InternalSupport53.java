package cc.syky.internal;

import com.mojang.blaze3d.textures.GpuTextureView;
import java.io.InputStream;
import java.util.Optional;
import net.minecraft.class_1011;
import net.minecraft.class_1043;
import net.minecraft.class_2960;
import net.minecraft.class_310;
import net.minecraft.class_3298;
import net.minecraft.class_918;
import org.jetbrains.annotations.Nullable;

public final class InternalSupport53 {
   @Nullable
   private static class_1043 v1;
   @Nullable
   private static class_1043 v2;
   private static boolean v3;
   private static boolean v4;

   private InternalSupport53() {
   }

   public static void v1(boolean var0) {
      if (var0) {
         if (v2 == null && !v4) {
            v2 = v1(class_918.field_43086, "syky_glint_armor_gray");
            v4 = v2 == null;
         }
      } else if (v1 == null && !v3) {
         v1 = v1(class_918.field_43087, "syky_glint_item_gray");
         v3 = v1 == null;
      }
   }

   @Nullable
   public static GpuTextureView v2(boolean var0) {
      class_1043 var1 = var0 ? v2 : v1;
      return var1 == null ? null : var1.method_71659();
   }

   public static void v1() {
      if (v1 != null) {
         v1.close();
         v1 = null;
      }

      if (v2 != null) {
         v2.close();
         v2 = null;
      }

      v3 = false;
      v4 = false;
   }

   @Nullable
   private static class_1043 v1(class_2960 var0, String var1) {
      class_310 var2 = class_310.method_1551();
      if (var2 == null) {
         return null;
      } else {
         Optional var3 = var2.method_1478().method_14486(var0);
         if (var3.isEmpty()) {
            return null;
         } else {
            class_1011 var4;
            try (InputStream var5 = ((class_3298)var3.get()).method_14482()) {
               var4 = class_1011.method_4309(var5);
            } catch (Throwable var11) {
               return null;
            }

            try {
               v1(var4);
               return new class_1043(() -> var1, var4);
            } catch (Throwable var9) {
               var4.close();
               return null;
            }
         }
      }
   }

   private static void v1(class_1011 var0) {
      int var1 = var0.method_4307();
      int var2 = var0.method_4323();

      for (int var3 = 0; var3 < var2; var3++) {
         for (int var4 = 0; var4 < var1; var4++) {
            int var5 = var0.method_61940(var4, var3);
            int var6 = var5 >>> 24 & 0xFF;
            int var7 = var5 >>> 16 & 0xFF;
            int var8 = var5 >>> 8 & 0xFF;
            int var9 = var5 & 0xFF;
            int var10 = Math.max(var7, Math.max(var8, var9));
            var0.method_61941(var4, var3, var6 << 24 | var10 << 16 | var10 << 8 | var10);
         }
      }
   }
}
