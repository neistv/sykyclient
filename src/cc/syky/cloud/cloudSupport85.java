package cc.syky.cloud;

import cc.syky.module.ModuleContract;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;
import java.util.function.BooleanSupplier;
import java.util.function.Consumer;
import java.util.function.Supplier;

public final class cloudSupport85 {
   private static final int v1 = 20;
   private static final int v2 = 12000;
   private final Supplier<? extends Iterable<? extends ModuleContract>> v3;
   private final List<cloudSupport85.Part1> v4;
   private final Supplier<? extends Collection<String>> v5;
   private final BooleanSupplier v6;
   private final Consumer<cloudSupport85.Part2> v7;
   private final Map<String, cloudSupport85.Part3> v8 = new HashMap<>();
   private int v9;
   private boolean v10;
   private boolean v11;

   public cloudSupport85(
      Supplier<? extends Iterable<? extends ModuleContract>> var1,
      List<cloudSupport85.Part1> var2,
      Supplier<? extends Collection<String>> var3,
      BooleanSupplier var4,
      Consumer<cloudSupport85.Part2> var5
   ) {
      this.v3 = var1;
      this.v4 = List.copyOf(var2);
      this.v5 = var3;
      this.v6 = var4;
      this.v7 = var5;
   }

   public cloudSupport85(
      Supplier<? extends Iterable<? extends ModuleContract>> var1, List<cloudSupport85.Part1> var2, BooleanSupplier var3, Consumer<cloudSupport85.Part2> var4
   ) {
      this(var1, var2, List::of, var3, var4);
   }

   public void v1(boolean var1) {
      if (!this.v6.getAsBoolean()) {
         this.v8.clear();
         this.v9 = 0;
         this.v10 = false;
         this.v11 = false;
      } else {
         if (var1) {
            this.v11 = true;

            for (ModuleContract var3 : this.v3.get()) {
               this.v1(var3.getName(), var3.isEnabled());
            }

            for (cloudSupport85.Part1 var6 : this.v4) {
               this.v1(var6.v1(), var6.v2().getAsBoolean());
            }
         } else if (this.v10) {
            for (cloudSupport85.Part3 var7 : this.v8.values()) {
               var7.v4 = false;
            }
         }

         this.v10 = var1;
         if (++this.v9 >= 12000) {
            this.v1();
         }
      }
   }

   private void v1(String var1, boolean var2) {
      cloudSupport85.Part3 var3 = this.v8.computeIfAbsent(var1, var0 -> new cloudSupport85.Part3());
      if (var2) {
         var3.v1++;
         if (var3.v4 && !var3.v3) {
            var3.v2++;
         }
      }

      var3.v3 = var2;
      var3.v4 = true;
   }

   public void v1() {
      this.v9 = 0;
      HashMap var1 = new HashMap();
      HashMap var2 = new HashMap();

      for (Entry var4 : this.v8.entrySet()) {
         cloudSupport85.Part3 var5 = (cloudSupport85.Part3)var4.getValue();
         if (var5.v1 >= 20L) {
            var1.put((String)var4.getKey(), var5.v1 / 20L);
            var5.v1 %= 20L;
         }

         if (var5.v2 > 0L) {
            var2.put((String)var4.getKey(), var5.v2);
            var5.v2 = 0L;
         }
      }

      Set var6 = this.v11 ? Set.copyOf((Collection<? extends String>)this.v5.get()) : Set.of();
      this.v11 = false;
      if (!var1.isEmpty() || !var2.isEmpty() || !var6.isEmpty()) {
         this.v7.accept(new cloudSupport85.Part2(var1, var2, var6));
      }
   }

   public record Part1(String key, BooleanSupplier on) {
      public String v1() {
         return this.key;
      }

      public BooleanSupplier v2() {
         return this.on;
      }
   }

   public record Part2(Map<String, Long> seconds, Map<String, Long> activations, Set<String> bound) {
      public Part2(Map<String, Long> var1, Map<String, Long> var2) {
         this(var1, var2, Set.of());
      }

      public Map<String, Long> v1() {
         return this.seconds;
      }

      public Map<String, Long> v2() {
         return this.activations;
      }

      public Set<String> v3() {
         return this.bound;
      }
   }

   public static final class Part3 {
      public long v1;
      public long v2;
      public boolean v3;
      public boolean v4;

      public Part3() {
      }
   }
}
