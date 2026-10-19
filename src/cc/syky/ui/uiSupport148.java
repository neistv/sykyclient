package cc.syky.ui;

import cc.syky.cloud.cloudSupport101;
import cc.syky.config.configSupport11;
import cc.syky.internal.InternalSupport28;
import cc.syky.internal.InternalSupport57;
import cc.syky.module.visual.visualRecord;
import java.io.IOException;
import java.io.InputStream;
import java.util.EnumMap;
import java.util.EnumSet;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import net.minecraft.class_310;
import net.minecraft.class_3419;
import org.jetbrains.annotations.Nullable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public final class uiSupport148 {
   private static final Logger v1 = LoggerFactory.getLogger("syky.sound");
   private static final float v2 = (float)Math.sqrt(2.0);
   private static final int[] v3 = new int[uiSupport146.values().length];
   private static final Random v4 = new Random();
   private static final Set<configSupport11> v5 = EnumSet.noneOf(configSupport11.class);
   private static volatile boolean v6;
   @Nullable
   private static volatile Map<uiSupport147, visualRecord> v7;
   @Nullable
   private static cloudSupport101 v8;

   private uiSupport148() {
   }

   public static void v1(cloudSupport101 var0, InternalSupport57 var1) {
      v8 = var0;
      if (v7 == null) {
         var1.v1(uiSupport148::v4);
      }
   }

   public static void v1(configSupport11 var0, boolean var1) {
      boolean var2 = var1 ? v5.add(var0) : v5.remove(var0);
      if (var2) {
         v6 = !v5.isEmpty();
         v2();
      }
   }

   private static void v2() {
      InternalSupport28.v1(InternalSupport28.Part1.UI, v6 && v7 != null);
   }

   public static boolean v1(configSupport11 var0) {
      return v5.contains(var0);
   }

   public static void v1(uiSupport146 var0) {
      if (v5.contains(var0.v1())) {
         Map var1 = v7;
         if (var1 != null) {
            visualRecord var2 = (visualRecord)var1.get(var0.v1(v2(var0)));
            if (var2 != null) {
               InternalSupport28.v1().v1(var2, v2 * v3(), 0.0F);
            }
         }
      }
   }

   private static int v2(uiSupport146 var0) {
      int var1 = var0.v2();
      if (var1 == 1) {
         return 0;
      } else {
         int var2 = v3[var0.ordinal()];
         int var3 = v4.nextInt(var1 - 1);
         int var4 = var3 >= var2 ? var3 + 1 : var3;
         v3[var0.ordinal()] = var4;
         return var4;
      }
   }

   public static void v1() {
      v5.clear();
      v6 = false;
      InternalSupport28.v1(InternalSupport28.Part1.UI, false);
      v8 = null;
   }

   private static float v3() {
      cloudSupport101 var0 = v8;
      class_310 var1 = var0 != null ? var0.v1() : null;
      return var1 != null && var1.field_1690 != null ? var1.field_1690.method_71978(class_3419.field_15250) : 1.0F;
   }

   private static void v4() {
      EnumMap var0 = new EnumMap<>(uiSupport147.class);

      for (uiSupport147 var4 : uiSupport147.values()) {
         visualRecord var5 = v1(var4);
         if (var5 != null) {
            var0.put(var4, var5);
         }
      }

      v7 = var0;
      v2();
   }

   @Nullable
   private static visualRecord v1(uiSupport147 var0) {
      try {
         visualRecord var2;
         try (InputStream var1 = uiSupport148.class.getResourceAsStream(var0.v1())) {
            if (var1 == null) {
               v1.warn("built-in click {} is missing from the jar", var0.v1());
               return null;
            }

            var2 = DecompilationFailedSupport2.v1(var1.readAllBytes(), var0.v2());
         }

         return var2;
      } catch (RuntimeException | IOException var6) {
         v1.warn("failed to load built-in click {}", var0.v1(), var6);
         return null;
      }
   }
}
