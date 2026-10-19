package cc.syky.ui;

import net.minecraft.class_10590;
import net.minecraft.class_1268;
import net.minecraft.class_1657;
import net.minecraft.class_1743;
import net.minecraft.class_1786;
import net.minecraft.class_1792;
import net.minecraft.class_1794;
import net.minecraft.class_1799;
import net.minecraft.class_1820;
import net.minecraft.class_1821;
import net.minecraft.class_1922;
import net.minecraft.class_2338;
import net.minecraft.class_239;
import net.minecraft.class_2680;
import net.minecraft.class_3965;
import net.minecraft.class_7923;
import net.minecraft.class_8162;
import net.minecraft.class_9334;
import net.minecraft.class_9424;
import net.minecraft.class_239.class_240;
import org.jetbrains.annotations.Nullable;

public final class uiSupport188 {
   private static final int v6 = 1;
   public static boolean v1;
   public static int v2;
   public static boolean v3;
   public static final uiSupport189 v4 = new uiSupport189();
   public static boolean v5;

   private uiSupport188() {
   }

   public static boolean v1(class_1657 var0, @Nullable class_239 var1, @Nullable class_1922 var2) {
      if (!v1) {
         return false;
      } else if (var1 != null && var1.method_17783() == class_240.field_1332) {
         return var2 != null && v2(var0, var1, var2);
      } else {
         class_1799 var3 = var0.method_5998(class_1268.field_5808);
         return var1 != null && var1.method_17783() == class_240.field_1331
            ? v1(var0, var3, v1(var3))
            : var3.method_57826(class_9334.field_63631) && v1(var0, var3, v1(var3));
      }
   }

   public static boolean v2(class_1657 var0, @Nullable class_239 var1, class_1922 var2) {
      if (v1 && var1 != null && var1.method_17783() == class_240.field_1332) {
         class_1799 var3 = var0.method_5998(class_1268.field_5808);
         return v1(var0, var3, v1(var3, var2, ((class_3965)var1).method_17777()));
      } else {
         return false;
      }
   }

   public static boolean v1(class_1657 var0, class_1268 var1) {
      return v1 && v1(var0, var0.method_5998(var1), 1);
   }

   public static boolean v2(class_1657 var0, class_1268 var1) {
      if (!v1) {
         return false;
      } else {
         class_1799 var2 = var0.method_5998(var1);
         return v1(var2.method_7909()) && v1(var0, var2, 1);
      }
   }

   private static boolean v1(class_1792 var0) {
      return var0 instanceof class_1794
         || var0 instanceof class_1743
         || var0 instanceof class_1821
         || var0 instanceof class_1820
         || var0 instanceof class_1786
         || var0 instanceof class_8162;
   }

   private static int v1(class_1799 var0) {
      class_10590 var1 = (class_10590)var0.method_58694(class_9334.field_55878);
      return var1 == null ? 0 : var1.comp_3481();
   }

   private static int v1(class_1799 var0, class_1922 var1, class_2338 var2) {
      class_9424 var3 = (class_9424)var0.method_58694(class_9334.field_50077);
      if (var3 != null && var3.comp_2500() > 0) {
         class_2680 var4 = var1.method_8320(var2);
         return !var4.method_26215() && var4.method_26214(var1, var2) != 0.0F ? var3.comp_2500() : 0;
      } else {
         return 0;
      }
   }

   private static boolean v1(class_1657 var0, class_1799 var1, int var2) {
      if (var2 > 0 && !var0.method_68878() && var1.method_7963()) {
         int var3 = v3 ? Math.max(var2, v4.v1(class_7923.field_41178.method_10206(var1.method_7909()))) : var2;
         if (!uiSupport189.v1(var1.method_7936() - var1.method_7919(), var3, v2)) {
            return false;
         } else {
            v5 = true;
            return true;
         }
      } else {
         return false;
      }
   }
}
