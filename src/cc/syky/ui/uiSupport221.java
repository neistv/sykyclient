package cc.syky.ui;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import net.minecraft.class_2558;
import net.minecraft.class_2561;
import net.minecraft.class_2568;
import net.minecraft.class_2583;
import net.minecraft.class_5223;
import net.minecraft.class_5224;
import net.minecraft.class_2558.class_10606;
import net.minecraft.class_2558.class_10608;
import net.minecraft.class_2558.class_10609;
import net.minecraft.class_2558.class_10610;
import net.minecraft.class_2568.class_10611;
import net.minecraft.class_2568.class_10613;
import net.minecraft.class_2568.class_5248;
import org.jetbrains.annotations.Nullable;

public final class uiSupport221 {
   private static final String v1 = "[A-Za-z0-9_]";
   private static final String v2 = Matcher.quoteReplacement("Protected");
   @Nullable
   private static volatile uiSupport221.Part3 v3;

   private uiSupport221() {
   }

   public static class_2561 v1(class_2561 var0, @Nullable String var1) {
      if (var0 != null && var1 != null && !var1.isEmpty()) {
         uiSupport221.Part2 var2 = new uiSupport221.Part2(var1, true);
         class_5223.method_27476(var0, class_2583.field_24360, var2);
         boolean var3 = var2.v1() || !v1(var1) && uiSupport193.v1(uiSupport192.v1(var0), var1).length > 0;
         if (!var3 && var2.v1 == null) {
            return var0;
         } else {
            int[] var4 = var3 ? uiSupport193.v1(uiSupport192.v1(var0), var1) : uiSupport193.v3;
            Map var5 = var2.v1;
            return uiSupport192.v1(var0, var4, "Protected", var5 == null ? (var0x, var1x) -> var1x : (var1x, var2x) -> var5.getOrDefault(var2x, var2x));
         }
      } else {
         return var0;
      }
   }

   public static String v1(String var0, String var1) {
      Pattern var2 = v2(var1);
      return var2 != null && var0 != null && !var0.isEmpty() && v2(var0, var1) ? var2.matcher(var0).replaceAll(v2) : var0;
   }

   public static class_2583 v1(class_2583 var0, String var1) {
      class_2583 var2 = var0;
      class_2568 var3 = var0.method_10969();
      if (var3 instanceof class_10613 var4) {
         class_2561 var6 = v1(var4.comp_3510(), var1);
         if (var6 != var4.comp_3510()) {
            var2 = var0.method_10949(new class_10613(var6));
         }
      } else if (var3 instanceof class_10611 var5) {
         class_5248 var12 = var5.comp_3508();
         if (uiSupport223.v1(var12.field_24352) || var12.field_24353.map(var1x -> v2(var1x, var1)).orElse(false)) {
            var2 = var0.method_10949(new class_10613(uiSupport223.v1()));
         }
      }

      class_2558 var9 = var0.method_10970();
      if (var9 instanceof class_10610 var10 && v2(var10.comp_3507(), var1)) {
         var2 = var2.method_10958(new class_10610(v1(var10.comp_3507(), var1)));
      } else if (var9 instanceof class_10609 var13 && v2(var13.comp_3506(), var1)) {
         var2 = var2.method_10958(new class_10609(v1(var13.comp_3506(), var1)));
      } else if (var9 instanceof class_10606 var7 && v2(var7.comp_3503(), var1)) {
         var2 = var2.method_10958(new class_10606(v1(var7.comp_3503(), var1)));
      } else if (var9 instanceof class_10608 var8 && v2(var8.comp_3505().toString(), var1)) {
         var2 = var2.method_10958(null);
      }

      String var11 = var0.method_10955();
      if (var11 != null && v2(var11, var1)) {
         var2 = var2.method_10975(v1(var11, var1));
      }

      return var2;
   }

   public static boolean v2(class_2561 var0, String var1) {
      uiSupport221.Part2 var2 = new uiSupport221.Part2(var1, false);
      class_5223.method_27476(var0, class_2583.field_24360, var2);
      return var2.v1() || !v1(var1) && uiSupport193.v1(uiSupport192.v1(var0), var1).length > 0;
   }

   public static boolean v2(String var0, String var1) {
      uiSupport221.Part1 var2 = new uiSupport221.Part1(var1);

      for (int var3 = 0; var3 < var0.length() && !var2.v3; var3++) {
         var2.v1(var0.charAt(var3));
      }

      var2.v2();
      return var2.v3 || !v1(var1) && uiSupport193.v1(var0, var1).length > 0;
   }

   public static boolean v1(String var0) {
      return uiSupport193.v1(var0, 0) == var0.length();
   }

   @Nullable
   private static Pattern v2(@Nullable String var0) {
      if (var0 != null && !var0.isEmpty()) {
         uiSupport221.Part3 var1 = v3;
         if (var1 == null || !var0.equals(var1.v1())) {
            var1 = new uiSupport221.Part3(var0, Pattern.compile("(?<![A-Za-z0-9_])" + Pattern.quote(var0) + "(?![A-Za-z0-9_])", 2));
            v3 = var1;
         }

         return var1.v2();
      } else {
         return null;
      }
   }

   public static class Part1 {
      public final String v2;
      private final boolean v1;
      private int v4;
      private boolean v5 = true;
      public boolean v3;

      public Part1(String var1) {
         this.v2 = var1;
         this.v1 = uiSupport221.v1(var1);
      }

      public void v1(int var1) {
         if (var1 < 128 && uiSupport193.v1((char)var1)) {
            this.v5 = this.v5 && this.v4 < this.v2.length() && Character.toLowerCase((char)var1) == Character.toLowerCase(this.v2.charAt(this.v4));
            this.v4++;
         } else {
            this.v2();
         }
      }

      public void v2() {
         if (this.v1 && this.v5 && this.v4 == this.v2.length()) {
            this.v3 = true;
         }

         this.v4 = 0;
         this.v5 = true;
      }
   }

   public static final class Part2 extends uiSupport221.Part1 implements class_5224 {
      private final boolean v4;
      @Nullable
      private class_2583 v5;
      @Nullable
      public Map<class_2583, class_2583> v1;

      public Part2(String var1, boolean var2) {
         super(var1);
         this.v4 = var2;
      }

      public boolean accept(int var1, class_2583 var2, int var3) {
         if (this.v4 && var2 != this.v5) {
            this.v5 = var2;
            class_2583 var4 = uiSupport221.v1(var2, this.v2);
            if (var4 != var2) {
               if (this.v1 == null) {
                  this.v1 = new HashMap<>();
               }

               this.v1.put(var2, var4);
            }
         }

         this.v1(var3);
         return true;
      }

      public boolean v1() {
         this.v2();
         return this.v3;
      }
   }

   public record Part3(String name, Pattern pattern) {
      public String v1() {
         return this.name;
      }

      public Pattern v2() {
         return this.pattern;
      }
   }
}
