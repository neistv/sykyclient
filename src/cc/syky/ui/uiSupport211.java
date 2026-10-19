package cc.syky.ui;

import cc.syky.module.utilities.ChatHeads;
import java.util.Arrays;
import java.util.UUID;
import net.minecraft.class_11719;
import net.minecraft.class_2561;
import net.minecraft.class_2583;
import net.minecraft.class_2960;
import net.minecraft.class_327;
import net.minecraft.class_5223;
import net.minecraft.class_5481;
import net.minecraft.class_11719.class_11721;
import org.jetbrains.annotations.Nullable;

public final class uiSupport211 {
   private static final class_11719 v2 = new class_11721(class_2960.method_60655("syky", "chat_head"));
   private static final String v3 = "\ue810";
   public static final int[] v1 = new int[0];

   private uiSupport211() {
   }

   public static ChatHeads.Part1 v1(class_2561 var0, uiSupport214[] var1) {
      int var2 = var1.length;
      long[] var3 = new long[var2];

      for (int var4 = 0; var4 < var2; var4++) {
         var3[var4] = (long)v2(var0, var1[var4].v1(), v1(var1[var4])) << 32 | var4;
      }

      Arrays.sort(var3);
      int[] var7 = new int[var2];
      uiSupport214[] var5 = new uiSupport214[var2];

      for (int var6 = 0; var6 < var2; var6++) {
         var7[var6] = (int)(var3[var6] >>> 32);
         var5[var6] = var1[(int)var3[var6]];
      }

      return new ChatHeads.Part1(uiSupport192.v1(var0, var7, uiSupport211::v2), var5);
   }

   @Nullable
   private static String v1(uiSupport214 var0) {
      UUID var1 = var0.v1();
      return var1 != null && uiSupport223.v1(var1) ? "Protected" : var0.v2();
   }

   public static class_2561 v1(class_2561 var0, @Nullable UUID var1, @Nullable String var2) {
      return uiSupport192.v1(var0, new int[]{v2(var0, var1, var2)}, uiSupport211::v2);
   }

   public static int v2(class_2561 var0, @Nullable UUID var1, @Nullable String var2) {
      uiSupport211.Part1 var3 = new uiSupport211.Part1(var1, var2);
      class_5223.method_27476(var0, class_2583.field_24360, var3::v1);
      int var4 = var3.v5;
      int[] var5 = var2 == null ? uiSupport193.v3 : uiSupport193.v1(var3.v3.toString(), var2);
      int var6 = var5.length == 0 ? -1 : var5[0];
      if (var4 < 0) {
         return Math.max(var6, 0);
      } else {
         return var6 < 0 ? var4 : Math.min(var4, var6);
      }
   }

   public static int[] v1(class_5481 var0, class_327 var1) {
      int[] var2 = new int[1];
      var0.accept((var1x, var2x, var3x) -> {
         if (v1(var2x)) {
            var2[0]++;
         }

         return true;
      });
      if (var2[0] == 0) {
         return v1;
      } else {
         int[] var3 = new int[var2[0]];

         for (int var4 = 0; var4 < var3.length; var4++) {
            int var5 = var4;
            int[] var6 = new int[1];
            class_5481 var7 = var3x -> var0.accept((var3xx, var4x, var5x) -> (!v1(var4x) || var6[0]++ != var5) && var3x.accept(var3xx, var4x, var5x));
            var3[var4] = Math.round(var1.method_27527().method_30875(var7));
         }

         return var3;
      }
   }

   private static boolean v1(class_2583 var0) {
      return v2.equals(var0.method_27708());
   }

   private static class_2561 v2(class_2583 var0) {
      return class_2561.method_43470("\ue810")
         .method_10862(var0.method_27704(v2).method_10982(false).method_30938(false).method_36140(false).method_36141(false));
   }

   public static final class Part1 {
      @Nullable
      private final UUID v1;
      @Nullable
      private final String v2;
      public final StringBuilder v3 = new StringBuilder();
      @Nullable
      private class_2583 v4;
      public int v5 = -1;

      public Part1(@Nullable UUID var1, @Nullable String var2) {
         this.v1 = var1;
         this.v2 = var2;
      }

      public boolean v1(int var1, class_2583 var2, int var3) {
         if (this.v5 < 0 && var2 != this.v4) {
            this.v4 = var2;
            UUID var4 = uiSupport208.v1(var2);
            String var5 = uiSupport208.v2(var2);
            if (this.v1 != null && this.v1.equals(var4) || this.v2 != null && this.v2.equalsIgnoreCase(var5)) {
               this.v5 = this.v3.length();
            }
         }

         this.v3.appendCodePoint(var3);
         return true;
      }
   }
}
