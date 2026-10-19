package cc.syky.config;

import cc.syky.ui.uiRecord;
import java.util.ArrayList;
import java.util.List;
import java.util.function.IntPredicate;
import net.minecraft.class_2960;

public final class configSupport6 {
   private static final long v3 = 1000000000L;
   public static final long v1 = 250000000L;
   public static final int v2 = 4;
   private static final long v4 = 4000000000L;
   private final List<configSupport6.Part1> v5 = new ArrayList<>(4);
   private final List<uiRecord> v6 = new ArrayList<>(4);
   private List<uiRecord> v7 = List.of();
   private long v8 = 4000000000L;
   private long v9;

   public configSupport6() {
   }

   public void v1(long var1) {
      this.v8 = var1;
   }

   public void v1(int var1, String var2, class_2960 var3, int var4, long var5) {
      for (int var7 = 0; var7 < this.v5.size(); var7++) {
         if (this.v5.get(var7).v1 == var1) {
            return;
         }
      }

      this.v5.add(new configSupport6.Part1(var1, new uiRecord(this.v9++, var2, var3, var4, var5), var5));
   }

   public void v1(long var1, IntPredicate var3) {
      for (int var4 = this.v5.size() - 1; var4 >= 0; var4--) {
         configSupport6.Part1 var5 = this.v5.get(var4);
         if (!var5.v4 && !var3.test(var5.v1)) {
            this.v1(var5.v2);
            var5.v4 = true;
         }

         if (var1 - var5.v3 > 250000000L) {
            this.v5.remove(var4);
         }
      }

      this.v2(var1);
   }

   public List<uiRecord> v1() {
      return this.v7;
   }

   public boolean v2() {
      return this.v5.isEmpty() && this.v6.isEmpty();
   }

   public void v3() {
      this.v5.clear();
      if (!this.v6.isEmpty()) {
         this.v6.clear();
         this.v7 = List.of();
      }
   }

   private void v1(uiRecord var1) {
      this.v6.add(0, var1);

      while (this.v6.size() > 4) {
         this.v6.remove(this.v6.size() - 1);
      }

      this.v7 = List.copyOf(this.v6);
   }

   private void v2(long var1) {
      boolean var3 = false;

      for (int var4 = this.v6.size() - 1; var4 >= 0 && var1 - this.v6.get(var4).v5() >= this.v8; var4--) {
         this.v6.remove(var4);
         var3 = true;
      }

      if (var3) {
         this.v7 = this.v6.isEmpty() ? List.of() : List.copyOf(this.v6);
      }
   }

   public static final class Part1 {
      public final int v1;
      public final uiRecord v2;
      public final long v3;
      public boolean v4;

      public Part1(int var1, uiRecord var2, long var3) {
         this.v1 = var1;
         this.v2 = var2;
         this.v3 = var3;
      }
   }
}
