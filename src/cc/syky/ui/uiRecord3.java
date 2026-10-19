package cc.syky.ui;

import cc.syky.config.configSupport8;
import java.util.Objects;
import net.minecraft.class_1799;
import net.minecraft.class_2561;
import net.minecraft.class_9334;

public record uiRecord3(long id, class_1799 stack, String customName, String realName, int count, String countLabel, long lastNanos) {
   public static final int NAME_MAX = 32;
   public static final String COUNT_PREFIX = "x";

   public static uiRecord3 v1(long var0, class_1799 var2, int var3, long var4) {
      class_1799 var6 = var2.method_46651(1);
      String var7 = configSupport8.v1(v1(var6), 32);
      if (var7 == null) {
         var7 = "";
      }

      String var8 = configSupport8.v1(var6.method_7964(), 32);
      return new uiRecord3(var0, var6, var8 == null ? var7 : var8, var7, var3, v1(var3), var4);
   }

   public uiRecord3 v1(int var1, long var2) {
      int var4 = (int)Math.min(2147483647L, (long)this.count + var1);
      return new uiRecord3(this.id, this.stack, this.customName, this.realName, var4, v1(var4), var2);
   }

   public static String v1(int var0) {
      return "x" + var0;
   }

   private static class_2561 v1(class_1799 var0) {
      class_2561 var1 = var0.method_7909().method_63680();
      return Objects.equals(var0.method_58694(class_9334.field_50239), var1) ? var0.method_63693() : var1;
   }

   public long v1() {
      return this.id;
   }

   public class_1799 v2() {
      return this.stack;
   }

   public String v3() {
      return this.customName;
   }

   public String v4() {
      return this.realName;
   }

   public int v5() {
      return this.count;
   }

   public String v6() {
      return this.countLabel;
   }

   public long v7() {
      return this.lastNanos;
   }
}
