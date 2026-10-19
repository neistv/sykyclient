package cc.syky.ui;

import java.util.Arrays;
import java.util.List;
import net.minecraft.class_10017;
import net.minecraft.class_1058;
import net.minecraft.class_1087;
import net.minecraft.class_11659;
import net.minecraft.class_11785;
import net.minecraft.class_11791;
import net.minecraft.class_12075;
import net.minecraft.class_12245;
import net.minecraft.class_1921;
import net.minecraft.class_243;
import net.minecraft.class_2561;
import net.minecraft.class_2680;
import net.minecraft.class_2960;
import net.minecraft.class_3879;
import net.minecraft.class_4587;
import net.minecraft.class_4588;
import net.minecraft.class_5481;
import net.minecraft.class_630;
import net.minecraft.class_777;
import net.minecraft.class_811;
import net.minecraft.class_10017.class_10018;
import net.minecraft.class_10017.class_11680;
import net.minecraft.class_10444.class_10445;
import net.minecraft.class_11659.class_11660;
import net.minecraft.class_11659.class_11947;
import net.minecraft.class_11683.class_11792;
import net.minecraft.class_12247.class_12338;
import net.minecraft.class_327.class_6415;
import org.jetbrains.annotations.Nullable;
import org.joml.Matrix4f;
import org.joml.Quaternionf;

public final class uiSupport153 implements class_11659 {
   private static final int v1 = 32;
   private final Object[] v2 = new Object[32];
   private final float[] v3 = new float[96];
   private int v4;
   @Nullable
   private uiSupport153.Part1 v5;

   public uiSupport153() {
   }

   public void v1(uiSupport153.Part1 var1) {
      this.v5 = var1;
      Arrays.fill(this.v2, 0, this.v4, null);
      this.v4 = 0;
   }

   public void v1() {
      this.v5 = null;
      Arrays.fill(this.v2, 0, this.v4, null);
      this.v4 = 0;
   }

   private boolean v1(Object var1, class_4587 var2) {
      Matrix4f var3 = var2.method_23760().method_23761();
      float var4 = var3.m30();
      float var5 = var3.m31();
      float var6 = var3.m32();

      for (int var7 = 0; var7 < this.v4; var7++) {
         if (this.v2[var7] == var1 && this.v3[var7 * 3] == var4 && this.v3[var7 * 3 + 1] == var5 && this.v3[var7 * 3 + 2] == var6) {
            return true;
         }
      }

      if (this.v4 < 32) {
         this.v2[this.v4] = var1;
         this.v3[this.v4 * 3] = var4;
         this.v3[this.v4 * 3 + 1] = var5;
         this.v3[this.v4 * 3 + 2] = var6;
         this.v4++;
      }

      return false;
   }

   @Nullable
   private class_4588 v1(class_1921 var1, @Nullable class_1058 var2) {
      uiSupport153.Part1 var3 = this.v5;
      if (var3 == null) {
         return null;
      } else {
         class_12245 var4 = var1.field_64013.field_63996;
         if (var2 != null) {
            return var2.method_24108(var3.begin(var2.method_45852(), var4));
         } else {
            class_2960 var5 = v1(var1);
            return var5 == null ? null : var3.begin(var5, var4);
         }
      }
   }

   @Nullable
   private static class_2960 v1(class_1921 var0) {
      class_12338 var1 = (class_12338)var0.field_64013.field_63987.get("Sampler0");
      return var1 == null ? null : var1.comp_5228();
   }

   public <S> void method_73490(
      class_3879<? super S> var1,
      S var2,
      class_4587 var3,
      class_1921 var4,
      int var5,
      int var6,
      int var7,
      @Nullable class_1058 var8,
      int var9,
      @Nullable class_11792 var10
   ) {
      if (!this.v1(var1, var3)) {
         class_4588 var11 = this.v1(var4, var8);
         if (var11 != null) {
            var1.method_2819(var2);
            var1.method_62100(var3, var11, var5, var6, var7);
         }
      }
   }

   public void method_73494(
      class_630 var1,
      class_4587 var2,
      class_1921 var3,
      int var4,
      int var5,
      @Nullable class_1058 var6,
      boolean var7,
      boolean var8,
      int var9,
      @Nullable class_11792 var10,
      int var11
   ) {
      if (!this.v1(var1, var2)) {
         class_4588 var12 = this.v1(var3, var6);
         if (var12 != null) {
            var1.method_22699(var2, var12, var4, var5, var9);
         }
      }
   }

   public class_11785 method_73529(int var1) {
      return this;
   }

   public void method_73479(class_4587 var1, float var2, List<class_11680> var3) {
   }

   public void method_73482(class_4587 var1, @Nullable class_243 var2, int var3, class_2561 var4, boolean var5, int var6, double var7, class_12075 var9) {
   }

   public void method_73478(class_4587 var1, float var2, float var3, class_5481 var4, boolean var5, class_6415 var6, int var7, int var8, int var9, int var10) {
   }

   public void method_73488(class_4587 var1, class_10017 var2, Quaternionf var3) {
   }

   public void method_73486(class_4587 var1, class_10018 var2) {
   }

   public void method_73481(class_4587 var1, class_2680 var2, int var3, int var4, int var5) {
   }

   public void method_73485(class_4587 var1, class_11791 var2) {
   }

   public void method_73484(class_4587 var1, class_1921 var2, class_1087 var3, float var4, float var5, float var6, int var7, int var8, int var9) {
   }

   public void method_73480(class_4587 var1, class_811 var2, int var3, int var4, int var5, int[] var6, List<class_777> var7, class_1921 var8, class_10445 var9) {
   }

   public void method_73483(class_4587 var1, class_1921 var2, class_11660 var3) {
   }

   public void method_74315(class_11947 var1) {
   }

   public interface Part1 {
      class_4588 begin(class_2960 var1, class_12245 var2);
   }
}
