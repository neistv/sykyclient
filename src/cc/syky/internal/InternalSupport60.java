package cc.syky.internal;

import cc.syky.cloud.cloudSupport49;
import cc.syky.cloud.cloudSupport50;
import java.util.ArrayList;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.BiConsumer;
import org.jetbrains.annotations.Nullable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public final class InternalSupport60 {
   public static final Logger v3 = LoggerFactory.getLogger("syky.cosmetics");
   private static final InternalSupport60.Part3 v4 = new InternalSupport60.Part3();
   private static final InternalSupport60.Part5 v5 = new InternalSupport60.Part5(List.of(), 0);
   private final InternalSupport60.Part6 v6;
   private volatile BiConsumer<UUID, String> v7 = (var0, var1x) -> {};
   public final Map<String, InternalSupport60.Part1> v8 = new ConcurrentHashMap<>();
   private final Map<UUID, InternalSupport60.Part2> v9 = new ConcurrentHashMap<>();
   public static final long v1 = 60000000000L;
   private static final int v10 = 16384;
   public final Map<UUID, InternalSupport60.Part5> v11 = new ConcurrentHashMap<>();
   private final AtomicInteger v12 = new AtomicInteger();
   public final AtomicInteger v13 = new AtomicInteger();
   public static final long v2 = 60000000000L;

   public InternalSupport60(InternalSupport60.Part6 var1) {
      this.v6 = var1;
   }

   public static String v1(String var0) {
      int var1 = var0.indexOf(64);
      return var1 < 0 ? var0 : var0.substring(0, var1);
   }

   public void v1(BiConsumer<UUID, String> var1) {
      this.v7 = var1;
   }

   public boolean v1(UUID var1) {
      InternalSupport60.Part2 var2 = this.v9.get(var1);
      return var2 == null || System.nanoTime() - var2.v2() > 60000000000L;
   }

   public void v1(UUID var1, String var2) {
      if (this.v1(var1)) {
         this.v9.compute(var1, (var0, var1x) -> new InternalSupport60.Part2(var1x == null ? List.of() : var1x.v1(), System.nanoTime()));
         this.v7.accept(var1, var2);
      }
   }

   public void v1(UUID var1, List<String> var2) {
      List var3 = List.copyOf(var2);
      if (this.v9.size() > 16384) {
         this.v9.values().removeIf(var0 -> var0.v1().isEmpty());
      }

      InternalSupport60.Part2 var4 = this.v9.put(var1, new InternalSupport60.Part2(var3, System.nanoTime()));
      if (var4 == null || !var3.equals(var4.v1())) {
         this.v11.remove(var1);
         this.v13.incrementAndGet();
      }
   }

   public void v1() {
      this.v9.clear();
      this.v11.clear();
      this.v13.incrementAndGet();
   }

   public void v1(cloudSupport50 var1) {
      this.v8.put(var1.v1(), new InternalSupport60.Part7(var1));
      this.v11.clear();
      this.v13.incrementAndGet();
   }

   public void v2(String var1) {
      this.v8.remove(var1);
      this.v11.clear();
      this.v13.incrementAndGet();
   }

   @Nullable
   public cloudSupport50 v3(String var1) {
      return this.v8.get(var1) instanceof InternalSupport60.Part7 var2 ? var2.v1() : null;
   }

   public List<String> v2(UUID var1) {
      InternalSupport60.Part2 var2 = this.v9.get(var1);
      return var2 == null ? List.of() : var2.v1();
   }

   @Nullable
   public InternalSupport60.Part5 v3(UUID var1) {
      InternalSupport60.Part2 var2 = this.v9.get(var1);
      if (var2 != null && !var2.v1().isEmpty()) {
         List var3 = var2.v1();
         InternalSupport60.Part5 var4 = this.v11.get(var1);
         if (var4 != null) {
            return var4.v1().isEmpty() ? null : var4;
         } else {
            ArrayList var5 = new ArrayList(var3.size());
            EnumMap var6 = new EnumMap<>(cloudSupport49.class);
            boolean var7 = false;

            for (String var9 : var3) {
               InternalSupport60.Part1 var10 = this.v8.get(var9);
               if (var10 instanceof InternalSupport60.Part8 var11 && System.nanoTime() - var11.v2() > 60000000000L) {
                  this.v8.remove(var9, var11);
                  var10 = null;
               }

               if (var10 == null) {
                  this.v4(var9);
                  var10 = this.v8.get(var9);
               }

               if (var10 == null || var10 instanceof InternalSupport60.Part3) {
                  var7 = true;
               } else if (var10 instanceof InternalSupport60.Part7 var13 && var6.putIfAbsent(var13.v1().v2(), Boolean.TRUE) == null) {
                  var5.add(var13.v1());
               }
            }

            if (var7) {
               return null;
            } else {
               InternalSupport60.Part5 var12 = var5.isEmpty() ? v5 : new InternalSupport60.Part5(List.copyOf(var5), this.v12.incrementAndGet());
               this.v11.put(var1, var12);
               return var12.v1().isEmpty() ? null : var12;
            }
         }
      } else {
         return null;
      }
   }

   public int v2() {
      return this.v13.get();
   }

   private void v4(final String var1) {
      if (this.v8.putIfAbsent(var1, v4) == null) {
         try {
            this.v6.load(var1, new InternalSupport60.Part4() {
               @Override
               public void v1(cloudSupport50 var1x) {
                  if (!var1x.v1().equals(InternalSupport60.v1(var1))) {
                     this.v1("asked for " + var1 + ", got " + var1x.v1());
                  } else {
                     InternalSupport60.this.v8.put(var1, new InternalSupport60.Part7(var1x));
                     InternalSupport60.this.v11.clear();
                     InternalSupport60.this.v13.incrementAndGet();
                  }
               }

               @Override
               public void v1(String var1x) {
                  InternalSupport60.v3.warn("cosmetic {} did not load: {}", var1, var1x);
                  InternalSupport60.this.v8.put(var1, new InternalSupport60.Part8(var1x, System.nanoTime()));
                  InternalSupport60.this.v11.clear();
                  InternalSupport60.this.v13.incrementAndGet();
               }
            });
         } catch (RuntimeException var3) {
            v3.warn("cosmetic loader threw for {}", var1, var3);
            this.v8.put(var1, new InternalSupport60.Part8(String.valueOf(var3.getMessage()), System.nanoTime()));
         }
      }
   }

   public sealed interface Part1 permits InternalSupport60.Part3, InternalSupport60.Part7, InternalSupport60.Part8 {
   }

   public record Part2(List<String> refs, long at) {
      public List<String> v1() {
         return this.refs;
      }

      public long v2() {
         return this.at;
      }
   }

   public record Part3() implements InternalSupport60.Part1 {
   }

   public interface Part4 {
      void v1(cloudSupport50 var1);

      void v1(String var1);
   }

   public record Part5(List<cloudSupport50> cosmetics, int version) {
      @Nullable
      public cloudSupport50 v1(cloudSupport49 var1) {
         for (cloudSupport50 var3 : this.cosmetics) {
            if (var3.v2() == var1) {
               return var3;
            }
         }

         return null;
      }

      public List<cloudSupport50> v1() {
         return this.cosmetics;
      }

      public int v2() {
         return this.version;
      }
   }

   @FunctionalInterface
   public interface Part6 {
      void load(String var1, InternalSupport60.Part4 var2);
   }

   public record Part7(cloudSupport50 cosmetic) implements InternalSupport60.Part1 {
      public cloudSupport50 v1() {
         return this.cosmetic;
      }
   }

   public record Part8(String reason, long at) implements InternalSupport60.Part1 {
      public String v1() {
         return this.reason;
      }

      public long v2() {
         return this.at;
      }
   }
}
