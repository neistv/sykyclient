package cc.syky.ui;

import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Optional;
import java.util.Map.Entry;
import net.minecraft.class_1011;
import net.minecraft.class_1043;
import net.minecraft.class_1060;
import net.minecraft.class_2960;
import net.minecraft.class_310;
import net.minecraft.class_3298;
import org.jetbrains.annotations.Nullable;

public final class uiSupport210 {
   private static final int v1 = 128;
   private static final uiSupport210.Part1 v2 = new uiSupport210.Part1(class_2960.method_60655("syky", "chat_head/unreadable"), 0);
   private final LinkedHashMap<class_2960, uiSupport210.Part1> v3 = new LinkedHashMap<>(16, 0.75F, true);
   private final LinkedHashMap<class_2960, uiSupport210.Part1> v4 = new LinkedHashMap<>(16, 0.75F, true);
   private int v5;

   public uiSupport210() {
   }

   @Nullable
   public uiSupport210.Part1 v1(class_310 var1, class_2960 var2, boolean var3) {
      LinkedHashMap var4 = var3 ? this.v3 : this.v4;
      uiSupport210.Part1 var5 = (uiSupport210.Part1)var4.get(var2);
      if (var5 == null) {
         var5 = this.v2(var1, var2, var3);
         var4.put(var2, var5);
      }

      return var5 == v2 ? null : var5;
   }

   public void v1(@Nullable class_310 var1) {
      if (var1 != null) {
         v1(var1, this.v3);
         v1(var1, this.v4);
      }
   }

   public void v2(class_310 var1) {
      v2(var1, this.v3);
      v2(var1, this.v4);
   }

   private uiSupport210.Part1 v2(class_310 var1, class_2960 var2, boolean var3) {
      class_1060 var4 = var1.method_1531();
      class_1011 var5 = var4.method_4619(var2) instanceof class_1043 var6 ? var6.method_4525() : null;

      class_1011 var13;
      try {
         class_1011 var14 = var5 == null ? v1(var1, var2) : null;

         try {
            class_1011 var8 = var5 != null ? var5 : var14;
            var13 = var8 == null ? null : v1(var8, var3);
         } catch (Throwable var11) {
            if (var14 != null) {
               try {
                  var14.close();
               } catch (Throwable var10) {
                  var11.addSuppressed(var10);
               }
            }

            throw var11;
         }

         if (var14 != null) {
            var14.close();
         }
      } catch (IllegalStateException var12) {
         var13 = null;
      }

      if (var13 == null) {
         return v2;
      } else {
         class_2960 var15 = class_2960.method_60655("syky", "chat_head/" + this.v5++);
         var4.method_4616(var15, new class_1043(var15::toString, var13));
         return new uiSupport210.Part1(var15, var13.method_4307());
      }
   }

   @Nullable
   private static class_1011 v1(class_310 var0, class_2960 var1) {
      Optional var2 = var0.method_1478().method_14486(var1);
      if (var2.isEmpty()) {
         return null;
      } else {
         try {
            class_1011 var4;
            try (InputStream var3 = ((class_3298)var2.get()).method_14482()) {
               var4 = class_1011.method_4309(var3);
            }

            return var4;
         } catch (IOException var8) {
            return null;
         }
      }
   }

   @Nullable
   private static class_1011 v1(class_1011 var0, boolean var1) {
      int var2 = var0.method_4307();
      if (var2 >= 64 && var2 % 64 == 0 && var0.method_4323() >= var2 / 2) {
         int var3 = var2 / 8;
         class_1011 var4 = new class_1011(var3, var3, false);

         for (int var5 = 0; var5 < var3; var5++) {
            for (int var6 = 0; var6 < var3; var6++) {
               int var7 = var0.method_61940(var3 + var6, var3 + var5);
               var4.method_61941(var6, var5, var1 ? v1(var0.method_61940(5 * var3 + var6, var3 + var5), var7) : var7);
            }
         }

         return var4;
      } else {
         return null;
      }
   }

   public static int v1(int var0, int var1) {
      int var2 = var0 >>> 24;
      if (var2 == 255) {
         return var0;
      } else if (var2 == 0) {
         return var1;
      } else {
         int var3 = var1 >>> 24;
         int var4 = var3 * (255 - var2);
         int var5 = var2 * 255 + var4;
         if (var5 == 0) {
            return 0;
         } else {
            int var6 = ((var0 >>> 16 & 0xFF) * var2 * 255 + (var1 >>> 16 & 0xFF) * var4) / var5;
            int var7 = ((var0 >>> 8 & 0xFF) * var2 * 255 + (var1 >>> 8 & 0xFF) * var4) / var5;
            int var8 = ((var0 & 0xFF) * var2 * 255 + (var1 & 0xFF) * var4) / var5;
            return (var5 + 127) / 255 << 24 | var6 << 16 | var7 << 8 | var8;
         }
      }
   }

   private static void v1(class_310 var0, LinkedHashMap<class_2960, uiSupport210.Part1> var1) {
      Iterator var2 = var1.entrySet().iterator();

      while (var1.size() > 128 && var2.hasNext()) {
         v1(var0, (uiSupport210.Part1)((Entry)var2.next()).getValue());
         var2.remove();
      }
   }

   private static void v2(class_310 var0, LinkedHashMap<class_2960, uiSupport210.Part1> var1) {
      for (uiSupport210.Part1 var3 : var1.values()) {
         v1(var0, var3);
      }

      var1.clear();
   }

   private static void v1(class_310 var0, uiSupport210.Part1 var1) {
      if (var1 != v2) {
         var0.method_1531().method_4615(var1.v1());
      }
   }

   public record Part1(class_2960 texture, int side) {
      public class_2960 v1() {
         return this.texture;
      }

      public int v2() {
         return this.side;
      }
   }
}
