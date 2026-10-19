package cc.syky.ui;

import java.util.function.Function;
import net.minecraft.class_2561;
import net.minecraft.class_2583;
import net.minecraft.class_5223;
import net.minecraft.class_5250;
import org.jetbrains.annotations.Nullable;

public final class uiSupport192 {
   private static final int[] v1 = new int[0];
   private static final uiSupport192.Part1 v2 = (var0, var1) -> var1;

   private uiSupport192() {
   }

   public static String v1(class_2561 var0) {
      return class_5223.method_31402(var0);
   }

   public static class_2561 v1(class_2561 var0, uiSupport192.Part1 var1) {
      return v1(var0, var1, v1, null, v1, "");
   }

   public static class_2561 v1(class_2561 var0, int[] var1, Function<class_2583, class_2561> var2) {
      return v1(var0, v2, var1, var2, v1, "");
   }

   public static class_2561 v1(class_2561 var0, int[] var1, String var2, uiSupport192.Part1 var3) {
      return v1(var0, var3, v1, null, var1, var2);
   }

   private static class_2561 v1(class_2561 var0, uiSupport192.Part1 var1, int[] var2, @Nullable Function<class_2583, class_2561> var3, int[] var4, String var5) {
      uiSupport192.Part2 var6 = new uiSupport192.Part2(var1, var2, var3, var4, var5);
      class_5223.method_27476(var0, class_2583.field_24360, var6::v1);
      return var6.v1();
   }

   @FunctionalInterface
   public interface Part1 {
      class_2583 style(int var1, class_2583 var2);
   }

   public static final class Part2 {
      private final uiSupport192.Part1 v1;
      private final int[] v2;
      @Nullable
      private final Function<class_2583, class_2561> v3;
      private final int[] v4;
      private final String v5;
      private final class_5250 v6 = class_2561.method_43473();
      private final StringBuilder v7 = new StringBuilder();
      @Nullable
      private class_2583 v8;
      private class_2583 v9 = class_2583.field_24360;
      private int v10;
      private int v11;
      private int v12;

      public Part2(uiSupport192.Part1 var1, int[] var2, @Nullable Function<class_2583, class_2561> var3, int[] var4, String var5) {
         this.v1 = var1;
         this.v2 = var2;
         this.v3 = var3;
         this.v4 = var4;
         this.v5 = var5;
      }

      public boolean v1(int var1, class_2583 var2, int var3) {
         int var4 = this.v10;
         this.v10 = this.v10 + Character.charCount(var3);
         this.v9 = var2;
         if (this.v3 != null && this.v11 < this.v2.length && var4 >= this.v2[this.v11]) {
            this.v2();

            while (this.v11 < this.v2.length && var4 >= this.v2[this.v11]) {
               this.v6.method_10852(this.v3.apply(var2));
               this.v11++;
            }
         }

         while (this.v12 < this.v4.length && var4 >= this.v4[this.v12 + 1]) {
            this.v12 += 2;
         }

         if (this.v12 < this.v4.length && var4 >= this.v4[this.v12]) {
            if (var4 == this.v4[this.v12]) {
               this.v1(this.v1.style(var4, var2), this.v5);
            }

            return true;
         } else {
            this.v1(this.v1.style(var4, var2), var3);
            return true;
         }
      }

      private void v1(class_2583 var1, int var2) {
         this.v1(var1);
         this.v7.appendCodePoint(var2);
      }

      private void v1(class_2583 var1, String var2) {
         this.v1(var1);
         this.v7.append(var2);
      }

      private void v1(class_2583 var1) {
         if (this.v8 != null && !var1.equals(this.v8)) {
            this.v2();
         }

         this.v8 = var1;
      }

      private void v2() {
         if (this.v7.length() > 0 && this.v8 != null) {
            this.v6.method_10852(class_2561.method_43470(this.v7.toString()).method_10862(this.v8));
         }

         this.v7.setLength(0);
         this.v8 = null;
      }

      public class_2561 v1() {
         this.v2();

         while (this.v3 != null && this.v11 < this.v2.length) {
            this.v6.method_10852(this.v3.apply(this.v9));
            this.v11++;
         }

         return this.v6;
      }
   }
}
