package cc.syky.ui;

import net.minecraft.class_2561;
import net.minecraft.class_2583;
import net.minecraft.class_2588;
import net.minecraft.class_7417;
import net.minecraft.class_8828;
import org.jetbrains.annotations.Nullable;

public final class uiSupport205 {
   private uiSupport205() {
   }

   public static class_2561 v1(class_2561 var0, int[] var1, boolean var2, int var3) {
      return uiSupport192.v1(var0, new uiSupport205.Part1(var1, var2, var3));
   }

   @Nullable
   public static String v1(class_2561 var0) {
      class_2561 var1 = var0;

      for (int var2 = 0; var2 < 4; var2++) {
         class_7417 var3 = var1.method_10851();
         if (var3 instanceof class_2588 var5) {
            return var5.method_11022();
         }

         if (!(var3 instanceof class_8828 var4) || !var4.comp_737().isEmpty() || var1.method_10855().size() != 1) {
            return null;
         }

         var1 = (class_2561)var1.method_10855().get(0);
      }

      return null;
   }

   public static final class Part1 implements uiSupport192.Part1 {
      private final int[] v1;
      private final boolean v2;
      private final int v3;
      private int v4;

      public Part1(int[] var1, boolean var2, int var3) {
         this.v1 = var1;
         this.v2 = var2;
         this.v3 = var3;
      }

      @Override
      public class_2583 style(int var1, class_2583 var2) {
         while (this.v4 < this.v1.length && var1 >= this.v1[this.v4 + 1]) {
            this.v4 += 2;
         }

         if (this.v4 < this.v1.length && var1 >= this.v1[this.v4]) {
            class_2583 var3 = this.v2 ? var2.method_30938(true) : var2;
            return this.v3 >= 0 ? var3.method_36139(this.v3) : var3;
         } else {
            return var2;
         }
      }
   }
}
