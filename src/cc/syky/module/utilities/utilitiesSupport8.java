package cc.syky.module.utilities;

import java.util.List;
import net.minecraft.class_10583;
import net.minecraft.class_12125;
import net.minecraft.class_1268;
import net.minecraft.class_1297;
import net.minecraft.class_1321;
import net.minecraft.class_1492;
import net.minecraft.class_1496;
import net.minecraft.class_1498;
import net.minecraft.class_1657;
import net.minecraft.class_1675;
import net.minecraft.class_239;
import net.minecraft.class_3966;
import net.minecraft.class_3988;
import net.minecraft.class_9334;
import net.minecraft.class_3959.class_3960;
import org.jetbrains.annotations.Nullable;

public final class utilitiesSupport8 {
   public static boolean v1;
   public static boolean v2;
   public static boolean v3;
   public static boolean v4;

   private utilitiesSupport8() {
   }

   public static boolean v1(class_1657 var0, @Nullable class_239 var1) {
      if (!v1 && !v2 && !v3 && !v4) {
         return false;
      } else {
         return var1 instanceof class_3966 var2 && v2(var2.method_17782(), var0) ? true : v1(var0);
      }
   }

   private static boolean v1(class_1657 var0) {
      if (var0.method_5998(class_1268.field_5808).method_58694(class_9334.field_63631) == null) {
         return false;
      } else {
         for (class_3966 var3 : class_1675.method_75209(var0, var0.method_76693(), var1 -> class_12125.method_75244(var0, var1), class_3960.field_17558)
            .right()
            .orElse(List.of())) {
            if (v2(var3.method_17782(), var0)) {
               return true;
            }
         }

         return false;
      }
   }

   private static boolean v2(class_1297 var0, class_1657 var1) {
      utilitiesSupport8.Part1 var2 = v1(var0, var1);
      return var2 != null && v1(var2);
   }

   public static boolean v1(utilitiesSupport8.Part1 var0) {
      return switch (var0) {
         case OWN_PET -> v1;
         case OTHER_PET -> v2;
         case PET_UNKNOWN_OWNER -> v1 || v2;
         case VILLAGER -> v3;
         case PLAYER -> v4;
      };
   }

   @Nullable
   public static utilitiesSupport8.Part1 v1(class_1297 var0, class_1657 var1) {
      if (var0 instanceof class_1657) {
         return utilitiesSupport8.Part1.PLAYER;
      } else if (var0 instanceof class_3988) {
         return utilitiesSupport8.Part1.VILLAGER;
      } else if (var0 instanceof class_1321 var4) {
         if (!var4.method_6181()) {
            return null;
         } else {
            class_10583 var3 = var4.method_66287();
            if (var3 == null) {
               return utilitiesSupport8.Part1.PET_UNKNOWN_OWNER;
            } else {
               return var1.method_5667().equals(var3.method_66263()) ? utilitiesSupport8.Part1.OWN_PET : utilitiesSupport8.Part1.OTHER_PET;
            }
         }
      } else {
         return var0 instanceof class_1496 var2 && v1(var2) && var2.method_6727() ? utilitiesSupport8.Part1.PET_UNKNOWN_OWNER : null;
      }
   }

   private static boolean v1(class_1496 var0) {
      return var0 instanceof class_1498 || var0 instanceof class_1492;
   }

   public static enum Part1 {
      OWN_PET,
      OTHER_PET,
      PET_UNKNOWN_OWNER,
      VILLAGER,
      PLAYER;

      private Part1() {
      }
   }
}
