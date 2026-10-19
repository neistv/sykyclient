package cc.syky.ui;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import net.minecraft.class_2561;
import net.minecraft.class_2583;
import net.minecraft.class_5223;
import net.minecraft.class_634;
import net.minecraft.class_640;
import org.jetbrains.annotations.Nullable;

public final class uiSupport212 {
   public static final int v1 = 32;

   private uiSupport212() {
   }

   @Nullable
   public static uiSupport214[] v1(class_2561 var0, class_634 var1) {
      ArrayList var2 = new ArrayList();
      UUID var3 = uiSupport194.v2;
      if (var3 != null) {
         class_640 var4 = var1.method_2871(var3);
         if (var4 != null) {
            var2.add(new uiSupport212.Part2(-1, uiSupport214.v1(var4)));
         }
      }

      if (uiSupport194.v1) {
         uiSupport212.Part1 var7 = new uiSupport212.Part1(var1, var2);
         class_5223.method_27476(var0, class_2583.field_24360, var7::v1);
         v1(var7.v3.toString(), var1, var2);
      }

      if (var2.isEmpty()) {
         return null;
      } else {
         var2.sort(Comparator.comparingInt(uiSupport212.Part2::v1));
         int var8 = Math.min(var2.size(), 32);
         uiSupport214[] var5 = new uiSupport214[var8];

         for (int var6 = 0; var6 < var8; var6++) {
            var5[var6] = ((uiSupport212.Part2)var2.get(var6)).v2();
         }

         return var5;
      }
   }

   private static void v1(String var0, class_634 var1, List<uiSupport212.Part2> var2) {
      Map var3 = null;
      int var4 = 0;

      while (var4 < var0.length()) {
         if (!uiSupport193.v1(var0.charAt(var4))) {
            var4++;
         } else {
            int var5 = uiSupport193.v1(var0, var4);
            if (var5 - var4 <= 16) {
               if (var3 == null) {
                  var3 = v1(var1);
               }

               class_640 var6 = (class_640)var3.get(var0.substring(var4, var5));
               if (var6 != null) {
                  v1(var2, var4, uiSupport214.v1(var6));
               }
            }

            var4 = var5;
         }
      }
   }

   public static void v1(List<uiSupport212.Part2> var0, int var1, uiSupport214 var2) {
      UUID var3 = var2.v1();

      for (int var4 = 0; var4 < var0.size(); var4++) {
         uiSupport212.Part2 var5 = (uiSupport212.Part2)var0.get(var4);
         if (var3 != null && var3.equals(var5.v2().v1())) {
            if (var5.v1() < 0 || var1 < var5.v1()) {
               var0.set(var4, new uiSupport212.Part2(var1, var5.v2()));
            }

            return;
         }
      }

      var0.add(new uiSupport212.Part2(var1, var2));
   }

   private static Map<String, class_640> v1(class_634 var0) {
      HashMap var1 = new HashMap();

      for (class_640 var3 : var0.method_2880()) {
         var1.putIfAbsent(var3.method_2966().name(), var3);
      }

      return var1;
   }

   public static final class Part1 {
      private final class_634 v1;
      private final List<uiSupport212.Part2> v2;
      public final StringBuilder v3 = new StringBuilder();
      @Nullable
      private class_2583 v4;

      public Part1(class_634 var1, List<uiSupport212.Part2> var2) {
         this.v1 = var1;
         this.v2 = var2;
      }

      public boolean v1(int var1, class_2583 var2, int var3) {
         if (var2 != this.v4) {
            this.v4 = var2;
            this.v1(var2);
         }

         this.v3.appendCodePoint(var3);
         return true;
      }

      private void v1(class_2583 var1) {
         UUID var2 = uiSupport208.v1(var1);
         if (var2 != null) {
            uiSupport212.v1(this.v2, this.v3.length(), uiSupport214.v1(var2, this.v1));
         } else {
            String var3 = uiSupport208.v2(var1);
            class_640 var4 = var3 == null ? null : this.v1.method_73471(var3);
            if (var4 != null) {
               uiSupport212.v1(this.v2, this.v3.length(), uiSupport214.v1(var4));
            }
         }
      }
   }

   public record Part2(int at, uiSupport214 head) {
      public int v1() {
         return this.at;
      }

      public uiSupport214 v2() {
         return this.head;
      }
   }
}
