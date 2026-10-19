package cc.syky.account;

import cc.syky.ui.uiSupport155;
import cc.syky.ui.uiSupport169;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import net.minecraft.class_1011;
import net.minecraft.class_1043;
import net.minecraft.class_2960;
import net.minecraft.class_310;
import net.minecraft.class_1011.class_1012;

public final class accountSupport3 {
   private static final int v1 = 256;
   private static final int v2 = 24;
   private static final Map<class_2960, accountSupport3.Part1[]> v3 = new ConcurrentHashMap<>();

   private accountSupport3() {
   }

   public static List<class_1011> v1(class_1011 var0) {
      class_1011 var1 = var0;

      while (Math.min(var1.method_4307(), var1.method_4323()) / 2 >= 256) {
         class_1011 var2 = v2(var1);
         var1.close();
         var1 = var2;
      }

      ArrayList var3 = new ArrayList();
      var3.add(var1);

      while (Math.min(var1.method_4307(), var1.method_4323()) / 2 >= 24) {
         var1 = v2(var1);
         var3.add(var1);
      }

      return var3;
   }

   public static void v1(class_2960 var0, List<class_1011> var1, String var2) {
      class_310 var3 = class_310.method_1551();
      accountSupport3.Part1[] var4 = new accountSupport3.Part1[var1.size()];
      int var5 = 0;

      try {
         for (int var6 = 0; var6 < var4.length; var6++) {
            class_1011 var12 = (class_1011)var1.get(var6);
            class_2960 var8 = var6 == 0 ? var0 : class_2960.method_60655(var0.method_12836(), var0.method_12832() + "/" + var6);
            String var9 = var2 + "_" + var6;
            var3.method_1531().method_4616(var8, new class_1043(() -> var9, var12));
            var4[var6] = new accountSupport3.Part1(var8, Math.min(var12.method_4307(), var12.method_4323()));
            var5 = var6 + 1;
         }
      } catch (RuntimeException var10) {
         for (int var7 = 0; var7 < var5; var7++) {
            var3.method_1531().method_4615(var4[var7].v1());
         }

         for (int var11 = var5; var11 < var1.size(); var11++) {
            ((class_1011)var1.get(var11)).close();
         }

         throw var10;
      }

      v3.put(var0, var4);
   }

   public static class_2960 v1(class_2960 var0, float var1) {
      accountSupport3.Part1[] var2 = v3.get(var0);
      if (var2 == null) {
         return var0;
      } else {
         float var3 = var1 / uiSupport169.v2();
         class_2960 var4 = var2[0].v1();

         for (accountSupport3.Part1 var8 : var2) {
            if (var8.v2() < var3) {
               break;
            }

            var4 = var8.v1();
         }

         return var4;
      }
   }

   public static void v1(class_2960 var0) {
      class_310 var1 = class_310.method_1551();
      accountSupport3.Part1[] var2 = v3.remove(var0);
      if (var2 == null) {
         var1.method_1531().method_4615(var0);
      } else {
         for (accountSupport3.Part1 var6 : var2) {
            var1.method_1531().method_4615(var6.v1());
         }
      }
   }

   private static class_1011 v2(class_1011 var0) {
      int var1 = var0.method_4307() / 2;
      int var2 = var0.method_4323() / 2;
      class_1011 var3 = new class_1011(class_1012.field_4997, var1, var2, false);

      for (int var4 = 0; var4 < var2; var4++) {
         for (int var5 = 0; var5 < var1; var5++) {
            var3.method_61941(var5, var4, v1(var0, var5 * 2, var4 * 2));
         }
      }

      return var3;
   }

   private static int v1(class_1011 var0, int var1, int var2) {
      float var3 = 0.0F;
      float var4 = 0.0F;
      float var5 = 0.0F;
      float var6 = 0.0F;

      for (int var7 = 0; var7 < 2; var7++) {
         for (int var8 = 0; var8 < 2; var8++) {
            int var9 = var0.method_61940(var1 + var8, var2 + var7);
            float var10 = uiSupport155.v1(var9) / 255.0F;
            var3 += uiSupport155.v5(uiSupport155.v2(var9)) * var10;
            var4 += uiSupport155.v5(uiSupport155.v3(var9)) * var10;
            var5 += uiSupport155.v5(uiSupport155.v4(var9)) * var10;
            var6 += var10;
         }
      }

      return var6 <= 0.0F
         ? 0
         : uiSupport155.v1(uiSupport155.v1(var3 / var6), uiSupport155.v1(var4 / var6), uiSupport155.v1(var5 / var6), Math.round(var6 * 0.25F * 255.0F));
   }

   public record Part1(class_2960 id, int size) {
      public class_2960 v1() {
         return this.id;
      }

      public int v2() {
         return this.size;
      }
   }
}
