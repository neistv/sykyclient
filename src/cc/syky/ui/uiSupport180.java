package cc.syky.ui;

import it.unimi.dsi.fastutil.longs.LongOpenHashSet;
import it.unimi.dsi.fastutil.longs.LongSet;
import net.minecraft.class_2338;
import net.minecraft.class_4076;

public final class uiSupport180 {
   public static boolean v1;
   private static final LongSet v2 = new LongOpenHashSet();

   private uiSupport180() {
   }

   public static void v1(class_2338 var0) {
      int var1 = class_4076.method_18675(var0.method_10263());
      int var2 = class_4076.method_18675(var0.method_10260());
      int var3 = var0.method_10264();
      int var4 = class_4076.method_18675(var3 - 1);
      int var5 = class_4076.method_18675(var3 + 1);

      for (int var6 = var4; var6 <= var5; var6++) {
         v2.add(class_4076.method_18685(var1, var6, var2));
      }
   }

   public static void v1(class_4076 var0) {
      v2.add(var0.method_18694());
   }

   public static LongSet v1() {
      return v2;
   }

   public static void v2() {
      v2.clear();
   }
}
