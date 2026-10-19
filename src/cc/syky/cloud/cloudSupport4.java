package cc.syky.cloud;

import cc.syky.hud.BadLuckSupport;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import net.minecraft.class_1291;
import net.minecraft.class_1293;
import net.minecraft.class_2960;
import net.minecraft.class_4081;
import net.minecraft.class_5321;
import net.minecraft.class_6880;
import org.jetbrains.annotations.Nullable;

public final class cloudSupport4 {
   private static final float v1 = 50.0F;
   private static final String v2 = "∞";
   private final Map<class_2960, class_2960> v3 = new HashMap<>();
   private final List<cloudRecord2> v4 = new ArrayList<>(8);
   private long v5;

   public cloudSupport4() {
   }

   public List<cloudRecord2> v1(Collection<class_1293> var1, long var2) {
      this.v5++;
      this.v4.clear();

      for (class_1293 var5 : var1) {
         cloudRecord2 var6 = this.v1(var5, var2);
         if (var6 != null) {
            this.v4.add(var6);
         }
      }

      return List.copyOf(this.v4);
   }

   public long v1() {
      return this.v5;
   }

   @Nullable
   private cloudRecord2 v1(class_1293 var1, long var2) {
      class_6880 var4 = var1.method_5579();
      Optional var5 = var4.method_40230();
      if (var5.isEmpty()) {
         return null;
      } else {
         class_2960 var6 = ((class_5321)var5.get()).method_29177();
         class_2960 var7 = this.v1(var6);
         String var8 = v1(((class_1291)var4.comp_349()).method_5560().getString(), var1.method_5578());
         boolean var9 = var1.method_48559();
         String var10 = var9 ? "∞" : v1(var1);
         float var11 = var9 ? Float.MAX_VALUE : Math.max(0, var1.method_5584()) * 50.0F;
         boolean var12 = ((class_1291)var4.comp_349()).method_18792() == class_4081.field_18272;
         BadLuckSupport var13 = BadLuckSupport.v1(var6.method_12836(), var6.method_12832());
         return new cloudRecord2(var8, var10, var11, var2, var12, var13, var7, var1.method_5578());
      }
   }

   public class_2960 v1(class_2960 var1) {
      return this.v3.computeIfAbsent(var1, var0 -> class_2960.method_60655(var0.method_12836(), "textures/mob_effect/" + var0.method_12832() + ".png"));
   }

   public static String v1(String var0, int var1) {
      if (var1 <= 0) {
         return var0;
      } else {
         StringBuilder var2 = new StringBuilder(var0.length() + 4);
         var2.append(var0).append(' ').append(var1 + 1);
         return var2.toString();
      }
   }

   private static String v1(class_1293 var0) {
      int var1 = var0.method_5584() / 20;
      int var2 = var1 / 60;
      int var3 = var1 % 60;
      StringBuilder var4 = new StringBuilder(5);
      var4.append(var2).append(':');
      if (var3 < 10) {
         var4.append('0');
      }

      var4.append(var3);
      return var4.toString();
   }
}
