package cc.syky.internal;

import cc.syky.module.visual.visualSupport9;
import cc.syky.render.GlobalsSupport;
import cc.syky.ui.uiSupport152;
import cc.syky.ui.uiSupport153;
import net.minecraft.class_10017;
import net.minecraft.class_12075;
import net.minecraft.class_12245;
import net.minecraft.class_1297;
import net.minecraft.class_243;
import net.minecraft.class_2960;
import net.minecraft.class_310;
import net.minecraft.class_4587;
import net.minecraft.class_4588;
import net.minecraft.class_897;
import org.jetbrains.annotations.Nullable;

public final class InternalSupport31 {
   @Nullable
   private static InternalSupport33 v1;
   private static long v2 = -1L;
   private static final uiSupport153 v3 = new uiSupport153();
   private static final uiSupport152 v4 = new uiSupport152();
   private static final class_4587 v5 = new class_4587();
   private static final class_12075 v6 = new class_12075();
   private static final uiSupport153.Part1 v7 = InternalSupport31::v1;

   private InternalSupport31() {
   }

   public static void v1() {
      GlobalsSupport.v1();
      if (v1 == null) {
         InternalSupport33 var0 = new InternalSupport33();
         v1 = var0;
         visualSupport9.v1(var0);
      }
   }

   public static void v1(InternalSupport31.Part1 var0, class_1297 var1, float var2, int var3, float var4, float var5, float var6) {
      InternalSupport33 var7 = v1;
      if (var7 != null && var3 >>> 24 != 0) {
         if (v2 != visualSupport9.v3) {
            v2 = visualSupport9.v3;
            var7.v1();
            if (GlobalsSupport.v2()) {
               GlobalsSupport.v1(var7::v2);
            }
         }

         class_310 var8 = class_310.method_1551();
         class_897 var9 = var8.method_1561().method_3953(var1);
         if (var9 != var0.v1 || var0.v2 == null) {
            var0.v1 = var9;
            var0.v2 = var9.method_55269();
         }

         class_10017 var10 = var0.v2;
         var9.method_62354(var1, var10, var2);
         class_243 var11 = var8.field_1773.method_19418().method_71156();
         class_243 var12 = var9.method_23169(var10);
         v4.v1(
            (float)(var10.field_53325 - var11.field_1352),
            (float)(var10.field_53326 - var11.field_1351),
            (float)(var10.field_53327 - var11.field_1350),
            var3,
            var4,
            var5,
            var6
         );
         v3.v1(v7);
         v5.method_22903();

         try {
            v5.method_22904(
               var10.field_53325 - var11.field_1352 + var12.field_1352,
               var10.field_53326 - var11.field_1351 + var12.field_1351,
               var10.field_53327 - var11.field_1350 + var12.field_1350
            );
            var9.method_3936(var10, v5, v3, v6);
         } finally {
            v5.method_22909();
            v3.v1();
            v4.v1();
         }
      }
   }

   private static class_4588 v1(class_2960 var0, class_12245 var1) {
      InternalSupport33 var2 = v1;
      if (var2 == null) {
         throw new IllegalStateException("scan drawn before preload");
      } else {
         return v4.v1(var2.v1(GlobalsSupport.v1(var0, var1)));
      }
   }

   public static final class Part1 {
      @Nullable
      public class_897<?, ?> v1;
      @Nullable
      public class_10017 v2;

      public Part1() {
      }

      public void v1() {
         this.v1 = null;
         this.v2 = null;
      }
   }
}
