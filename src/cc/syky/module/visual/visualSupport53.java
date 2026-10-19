package cc.syky.module.visual;

import java.util.Arrays;
import net.minecraft.class_1297;
import net.minecraft.class_1657;
import net.minecraft.class_310;
import net.minecraft.class_638;
import net.minecraft.class_746;
import org.jetbrains.annotations.Nullable;

public final class visualSupport53<E extends class_1297> {
   private final Object[] v1;
   private final double[] v2;
   private int v3;

   public visualSupport53(int var1) {
      this.v1 = new Object[var1];
      this.v2 = new double[var1];
   }

   public void v1() {
      Arrays.fill(this.v1, null);
      this.v3 = 0;
   }

   public boolean v1(@Nullable class_310 var1, visualSupport53.Part1<E> var2) {
      this.v1();
      class_638 var3 = var1 == null ? null : var1.field_1687;
      class_746 var4 = var1 == null ? null : var1.field_1724;
      if (var3 != null && var4 != null) {
         double var5 = var4.method_23317();
         double var7 = var4.method_23318();
         double var9 = var4.method_23321();

         for (class_1297 var12 : var3.method_18112()) {
            class_1297 var13 = var2.v2(var12, var4);
            if (var13 != null) {
               double var14 = var13.method_5649(var5, var7, var9);
               if (var2.v1(var13, var14) && this.v1(var14) && var2.v3(var13, var4)) {
                  this.v1((E)var13, var14);
               }
            }
         }

         return true;
      } else {
         return false;
      }
   }

   private boolean v1(double var1) {
      return this.v3 < this.v1.length || var1 < this.v2[this.v3 - 1];
   }

   private void v1(E var1, double var2) {
      int var4;
      for (var4 = this.v3 < this.v1.length ? this.v3++ : this.v1.length - 1; var4 > 0 && this.v2[var4 - 1] > var2; var4--) {
         this.v1[var4] = this.v1[var4 - 1];
         this.v2[var4] = this.v2[var4 - 1];
      }

      this.v1[var4] = var1;
      this.v2[var4] = var2;
   }

   public int v2() {
      return this.v3;
   }

   public boolean v3() {
      return this.v3 == 0;
   }

   public E v1(int var1) {
      return (E)this.v1[var1];
   }

   public interface Part1<E extends class_1297> {
      @Nullable
      E v2(class_1297 var1, class_1657 var2);

      default boolean v1(E var1, double var2) {
         return true;
      }

      default boolean v3(E var1, class_1657 var2) {
         return true;
      }
   }
}
