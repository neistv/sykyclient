package cc.syky.internal;

import cc.syky.cloud.cloudSupport101;
import cc.syky.ui.uiSupport155;
import java.util.ArrayList;
import java.util.List;
import net.fabricmc.fabric.api.client.rendering.v1.world.WorldRenderContext;
import net.minecraft.class_11659;
import net.minecraft.class_12075;
import net.minecraft.class_243;
import net.minecraft.class_2561;
import net.minecraft.class_310;
import net.minecraft.class_327;
import net.minecraft.class_4587;
import net.minecraft.class_5481;
import net.minecraft.class_327.class_6415;
import org.jetbrains.annotations.Nullable;

public final class InternalSupport32 {
   private static final float v1 = 0.025F;
   private static final float v2 = 0.25F;
   private static final float v3 = 0.5F;
   @Nullable
   private static cloudSupport101 v4;
   private static final List<InternalSupport32.Part1> v5 = new ArrayList<>();
   private static int v6;
   private static final class_4587 v7 = new class_4587();

   private InternalSupport32() {
   }

   public static void v1(cloudSupport101 var0) {
      v4 = var0;
   }

   public static void v1() {
      v4 = null;
      v3();
   }

   public static void v2() {
      v3();
   }

   private static void v3() {
      for (int var0 = 0; var0 < v6; var0++) {
         v5.get(var0).v1();
      }

      v6 = 0;
   }

   public static void v1(String var0, double var1, double var3, double var5, float var7, int var8) {
      v1(var0, var1, var3, var5, var7, var8, true);
   }

   public static void v1(String var0, double var1, double var3, double var5, float var7, int var8, boolean var9) {
      if (var0 != null && !var0.isEmpty()) {
         if (v6 == v5.size()) {
            v5.add(new InternalSupport32.Part1());
         }

         v5.get(v6++).v1(var0, var1, var3, var5, var7, var8, var9);
      }
   }

   public static void v1(WorldRenderContext var0) {
      try {
         if (v6 == 0 || var0 == null) {
            return;
         }

         class_310 var1 = v4 == null ? null : v4.v1();
         class_11659 var2 = var0.commandQueue();
         if (var1 == null || var2 == null || var1.field_1772 == null) {
            return;
         }

         class_12075 var3 = var0.worldState().field_63082;
         class_243 var4 = var3.field_63078;
         class_327 var5 = var1.field_1772;
         int var6 = (int)(var1.field_1690.method_19343(0.25F) * 255.0F) << 24;
         v1(var4);

         for (int var7 = 0; var7 < v6; var7++) {
            InternalSupport32.Part1 var8 = v5.get(var7);
            v7.method_22903();

            try {
               v7.method_22904(var8.v2 - var4.field_1352, var8.v3 - var4.field_1351, var8.v4 - var4.field_1350);
               v7.method_22907(var3.field_63081);
               float var9 = 0.025F * var8.v5;
               v7.method_22905(var9, -var9, var9);
               class_5481 var10 = class_2561.method_43470(var8.v1).method_30937();
               float var11 = -var5.method_1727(var8.v1) / 2.0F;
               int var12 = 15728880;
               if (var8.v7) {
                  var2.method_73478(v7, var11, 0.0F, var10, false, class_6415.field_33994, var12, uiSupport155.v1(var8.v6, 0.5F), var6, 0);
               }

               var2.method_73478(v7, var11, 0.0F, var10, false, class_6415.field_33993, var12, var8.v6, 0, 0);
            } finally {
               v7.method_22909();
            }
         }
      } finally {
         v3();
      }
   }

   private static void v1(class_243 var0) {
      for (int var1 = 0; var1 < v6; var1++) {
         v5.get(var1).v1(var0);
      }

      for (int var4 = 1; var4 < v6; var4++) {
         InternalSupport32.Part1 var2 = v5.get(var4);

         int var3;
         for (var3 = var4 - 1; var3 >= 0 && v5.get(var3).v8 < var2.v8; var3--) {
            v5.set(var3 + 1, v5.get(var3));
         }

         v5.set(var3 + 1, var2);
      }
   }

   public static final class Part1 {
      @Nullable
      public String v1;
      public double v2;
      public double v3;
      public double v4;
      public float v5;
      public int v6;
      public boolean v7;
      public double v8;

      public Part1() {
      }

      public void v1(String var1, double var2, double var4, double var6, float var8, int var9, boolean var10) {
         this.v1 = var1;
         this.v2 = var2;
         this.v3 = var4;
         this.v4 = var6;
         this.v5 = var8;
         this.v6 = var9;
         this.v7 = var10;
      }

      public void v1(class_243 var1) {
         double var2 = this.v2 - var1.field_1352;
         double var4 = this.v3 - var1.field_1351;
         double var6 = this.v4 - var1.field_1350;
         this.v8 = var2 * var2 + var4 * var4 + var6 * var6;
      }

      public void v1() {
         this.v1 = null;
      }
   }
}
