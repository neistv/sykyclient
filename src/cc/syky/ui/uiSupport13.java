package cc.syky.ui;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BooleanSupplier;
import net.minecraft.class_1799;

public final class uiSupport13 {
   private static final long v5 = 1000000000L;
   public static final int v1 = 1;
   public static final int v2 = 15;
   public static final int v3 = 4;
   public static final int v4 = 12;
   private final List<uiRecord3> v6 = new ArrayList<>(13);
   private List<uiRecord3> v7 = List.of();
   private long v8 = 4000000000L;
   private long v9;
   private BooleanSupplier v10 = () -> false;

   public uiSupport13() {
   }

   public void v1(BooleanSupplier var1) {
      this.v10 = var1;
   }

   public void v1(long var1) {
      this.v8 = var1;
   }

   public void v1(class_1799 var1, int var2, long var3) {
      if (var2 > 0 && !var1.method_7960() && this.v10.getAsBoolean()) {
         for (int var5 = 0; var5 < this.v6.size(); var5++) {
            uiRecord3 var6 = this.v6.get(var5);
            if (class_1799.method_31577(var6.v2(), var1)) {
               this.v6.set(var5, var6.v1(var2, var3));
               this.v5();
               return;
            }
         }

         this.v6.add(0, uiRecord3.v1(this.v9++, var1, var2, var3));
         if (this.v6.size() > 12) {
            this.v6.remove(this.v4());
         }

         this.v5();
      }
   }

   public void v2(long var1) {
      if (!this.v10.getAsBoolean()) {
         this.v3();
      } else {
         boolean var3 = false;

         for (int var4 = this.v6.size() - 1; var4 >= 0; var4--) {
            if (var1 - this.v6.get(var4).v7() >= this.v8) {
               this.v6.remove(var4);
               var3 = true;
            }
         }

         if (var3) {
            this.v5();
         }
      }
   }

   public List<uiRecord3> v1() {
      return this.v7;
   }

   public boolean v2() {
      return this.v6.isEmpty();
   }

   public void v3() {
      if (!this.v6.isEmpty()) {
         this.v6.clear();
         this.v7 = List.of();
      }
   }

   private int v4() {
      int var1 = 1;

      for (int var2 = 2; var2 < this.v6.size(); var2++) {
         if (this.v6.get(var2).v7() <= this.v6.get(var1).v7()) {
            var1 = var2;
         }
      }

      return var1;
   }

   private void v5() {
      this.v7 = this.v6.isEmpty() ? List.of() : List.copyOf(this.v6);
   }
}
