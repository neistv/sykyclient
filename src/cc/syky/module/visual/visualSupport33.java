package cc.syky.module.visual;

import cc.syky.mixin.accessor.BlockModelsAccessor;
import cc.syky.ui.uiSupport260;
import com.google.common.collect.UnmodifiableIterator;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.IdentityHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import net.minecraft.class_1058;
import net.minecraft.class_10801;
import net.minecraft.class_1087;
import net.minecraft.class_10889;
import net.minecraft.class_2246;
import net.minecraft.class_2248;
import net.minecraft.class_2350;
import net.minecraft.class_2680;
import net.minecraft.class_2741;
import net.minecraft.class_5611;
import net.minecraft.class_5819;
import net.minecraft.class_773;
import net.minecraft.class_7764;
import net.minecraft.class_777;
import net.minecraft.class_10817.class_10818;
import org.jetbrains.annotations.Nullable;

public final class visualSupport33 {
   private static final List<class_2248> v1 = List.of(
      class_2246.field_10219, class_2246.field_10520, class_2246.field_10402, class_2246.field_22120, class_2246.field_22113
   );
   private static final int v2 = 32;
   private static final uiSupport260 v3 = new uiSupport260("fastgrass.mesh");

   private visualSupport33() {
   }

   @Nullable
   public static visualSupport33.Part2 v1(class_773 var0) {
      Map var1 = ((BlockModelsAccessor)var0).syky$models();
      if (var1.isEmpty()) {
         return null;
      } else {
         class_1087 var2 = var0.method_3333().method_68046();
         HashMap var3 = new HashMap();
         ConcurrentHashMap var4 = new ConcurrentHashMap();
         Set var5 = Collections.newSetFromMap(new IdentityHashMap());
         class_5819 var6 = class_5819.method_43047();
         ArrayList var7 = new ArrayList();

         for (class_2248 var9 : v1) {
            UnmodifiableIterator var10 = var9.method_9595().method_11662().iterator();

            while (var10.hasNext()) {
               class_2680 var11 = (class_2680)var10.next();
               if (!var11.method_28498(class_2741.field_12512) || !(Boolean)var11.method_11654(class_2741.field_12512)) {
                  class_1087 var12 = (class_1087)var1.get(var11);
                  if (var12 == null || var12 == var2) {
                     return null;
                  }

                  for (int var13 = 0; var13 < 32; var13++) {
                     var7.clear();
                     var12.method_68513(var6, var7);

                     for (class_10889 var15 : var7) {
                        class_10889 var16 = var4.computeIfAbsent(var15, visualSupport33::v2);
                        if (var9 == class_2246.field_10219) {
                           var5.add(var16);
                        }
                     }
                  }

                  var3.put(var11, new visualSupport33.Part1(var12, var4));
               }
            }
         }

         boolean var17 = !var5.isEmpty();

         for (class_10889 var19 : var5) {
            var17 &= v3(var19);
         }

         return new visualSupport33.Part2(Map.copyOf(var3), var17);
      }
   }

   private static class_10889 v1(class_10889 var0) {
      try {
         return v2(var0);
      } catch (Throwable var2) {
         v3.v1(var2);
         return var0;
      }
   }

   private static class_10889 v2(class_10889 var0) {
      List var1 = var0.method_68509(class_2350.field_11036);
      if (var1.isEmpty()) {
         return (class_10889)var0;
      } else {
         class_777 var2 = (class_777)var1.getFirst();
         class_10818 var3 = new class_10818();

         for (class_777 var5 : var0.method_68509(null)) {
            var3.method_68051(var5);
         }

         for (class_2350 var7 : class_2350.values()) {
            List var8 = var0.method_68509(var7);
            if (!var8.isEmpty()) {
               if (var7.method_10166().method_10178()) {
                  for (class_777 var10 : var8) {
                     var3.method_68053(var7, var10);
                  }
               } else {
                  var3.method_68053(var7, v1((class_777)var8.getFirst(), var2));
               }
            }
         }

         return new class_10801(var3.method_68050(), var0.comp_3751(), var0.comp_3752());
      }
   }

   private static class_777 v1(class_777 var0, class_777 var1) {
      class_1058 var2 = var0.comp_3724();
      class_1058 var3 = var1.comp_3724();
      return new class_777(
         var0.comp_5238(),
         var0.comp_5239(),
         var0.comp_5240(),
         var0.comp_5241(),
         v1(var0.comp_5242(), var2, var3),
         v1(var0.comp_5243(), var2, var3),
         v1(var0.comp_5244(), var2, var3),
         v1(var0.comp_5245(), var2, var3),
         var1.comp_3722(),
         var0.comp_3723(),
         var3,
         var0.comp_3725(),
         var0.comp_3726()
      );
   }

   private static long v1(long var0, class_1058 var2, class_1058 var3) {
      return class_5611.method_76640(
         var3.method_4580(v1(class_5611.method_76641(var0), var2.method_4594(), var2.method_4577())),
         var3.method_4570(v1(class_5611.method_76642(var0), var2.method_4593(), var2.method_4575()))
      );
   }

   private static float v1(float var0, float var1, float var2) {
      float var3 = var2 - var1;
      return var3 == 0.0F ? 0.0F : (var0 - var1) / var3;
   }

   private static boolean v3(class_10889 var0) {
      if (!var0.method_68509(null).isEmpty()) {
         return false;
      } else {
         Set var1 = Collections.newSetFromMap(new IdentityHashMap());

         for (class_2350 var5 : class_2350.values()) {
            List var6 = var0.method_68509(var5);
            if (var6.size() != 1) {
               return false;
            }

            class_1058 var7 = ((class_777)var6.getFirst()).comp_3724();
            if (var1.add(var7) && !v1(var7)) {
               return false;
            }
         }

         return true;
      }
   }

   private static boolean v1(class_1058 var0) {
      class_7764 var1 = var0.method_45851();
      if (var1.method_73020()) {
         return false;
      } else {
         for (int var2 = 0; var2 < var1.method_45815(); var2++) {
            for (int var3 = 0; var3 < var1.method_45807(); var3++) {
               if (var1.method_45810(0, var3, var2)) {
                  return false;
               }
            }
         }

         return true;
      }
   }

   public record Part1(class_1087 delegate, Map<class_10889, class_10889> cache) implements class_1087 {
      public void method_68513(class_5819 var1, List<class_10889> var2) {
         int var3 = var2.size();
         this.delegate.method_68513(var1, var2);
         int var4 = var3;

         for (int var5 = var2.size(); var4 < var5; var4++) {
            class_10889 var6 = (class_10889)var2.get(var4);
            var2.set(var4, this.cache.computeIfAbsent(var6, visualSupport33::v1));
         }
      }

      public class_1058 method_68511() {
         return this.delegate.method_68511();
      }

      public class_1087 v1() {
         return this.delegate;
      }

      public Map<class_10889, class_10889> v2() {
         return this.cache;
      }
   }

   public record Part2(Map<class_2680, class_1087> models, boolean grassOpaque) {
      public Map<class_2680, class_1087> v1() {
         return this.models;
      }

      public boolean v2() {
         return this.grassOpaque;
      }
   }
}
