package cc.syky.ui;

import cc.syky.module.moduleSupport;
import java.util.function.Predicate;
import net.minecraft.class_2680;
import net.minecraft.class_2806;
import net.minecraft.class_2818;
import net.minecraft.class_3481;
import net.minecraft.class_3486;
import net.minecraft.class_638;
import net.minecraft.class_2338.class_2339;
import net.minecraft.class_2902.class_2903;
import org.jetbrains.annotations.Nullable;

public final class uiSupport170 implements moduleSupport.Part2 {
   private static final Predicate<class_2680> v1 = class_2903.field_13197.method_16402();
   private final class_2339 v2 = new class_2339();
   @Nullable
   private class_638 v3;
   private int v4;
   private int v5;
   @Nullable
   private class_2818 v6;
   private int v7 = Integer.MIN_VALUE;
   private int v8 = Integer.MIN_VALUE;

   public uiSupport170() {
   }

   public uiSupport170 v1(class_638 var1) {
      this.v3 = var1;
      this.v6 = null;
      this.v7 = Integer.MIN_VALUE;
      this.v8 = Integer.MIN_VALUE;
      return this;
   }

   @Override
   public boolean v1(int var1, int var2) {
      this.v4 = var1 << 4;
      this.v5 = var2 << 4;
      return this.v3(this.v4, this.v5) != null;
   }

   @Override
   public int v1() {
      class_638 var1 = this.v3;
      return var1 == null ? 0 : var1.method_31607();
   }

   @Override
   public int v2(int var1, int var2) {
      int var3 = this.v4 + var1;
      int var4 = this.v5 + var2;
      class_2818 var5 = this.v3(var3, var4);
      return var5 == null ? Integer.MIN_VALUE : var5.method_12032(class_2903.field_13197).method_12603(var3 & 15, var4 & 15);
   }

   @Override
   public int v1(int var1, int var2, int var3) {
      int var4 = this.v4 + var1;
      int var5 = this.v5 + var3;
      class_2818 var6 = this.v3(var4, var5);
      if (var6 == null) {
         return 0;
      } else {
         class_2680 var7 = var6.method_8320(this.v2.method_10103(var4, var2, var5));
         if (!v1.test(var7)) {
            return 0;
         } else if (var7.method_26227().method_15767(class_3486.field_15517)) {
            return 3;
         } else if (var7.method_26164(class_3481.field_15503)) {
            return 2;
         } else {
            return !var7.method_26164(class_3481.field_29822) && !var7.method_26164(class_3481.field_15466) ? 1 : 4;
         }
      }
   }

   @Nullable
   private class_2818 v3(int var1, int var2) {
      int var3 = var1 >> 4;
      int var4 = var2 >> 4;
      if (var3 != this.v7 || var4 != this.v8) {
         class_638 var5 = this.v3;
         this.v6 = var5 == null ? null : var5.method_2935().method_2857(var3, var4, class_2806.field_12803, false);
         this.v7 = var3;
         this.v8 = var4;
      }

      return this.v6;
   }
}
