package cc.syky.cloud;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;
import org.jetbrains.annotations.Nullable;

public final class cloudSupport90 {
   public static volatile boolean v1;
   @Nullable
   private static volatile UUID v2;
   private static final ConcurrentHashMap<UUID, cloudSupport90.Part3> v3 = new ConcurrentHashMap<>();
   private static final Set<UUID> v4 = ConcurrentHashMap.newKeySet();
   private static final ConcurrentLinkedQueue<cloudSupport90.Part1> v5 = new ConcurrentLinkedQueue<>();
   private static final int v6 = 4096;

   private cloudSupport90() {
   }

   public static boolean v1(UUID var0, String var1) {
      if (!v1) {
         return false;
      } else if (var0.equals(v2)) {
         return true;
      } else {
         cloudSupport90.Part3 var2 = v3.get(var0);
         if ((var2 == null || var2.v3() < System.currentTimeMillis()) && v4.add(var0)) {
            v5.add(new cloudSupport90.Part1(var0, var1));
         }

         return var2 != null && var2.v1();
      }
   }

   @Nullable
   public static cloudSupport90.Part2 v1(UUID var0) {
      cloudSupport90.Part3 var1 = v3.get(var0);
      return var1 != null && var1.v3() >= System.currentTimeMillis() ? var1.v2() : null;
   }

   public static boolean v2(UUID var0) {
      cloudSupport90.Part3 var1 = v3.get(var0);
      return var1 != null && var1.v3() >= System.currentTimeMillis() && var1.v1() && var1.v2() == null;
   }

   public static List<cloudSupport90.Part1> v1(int var0) {
      ArrayList var1 = new ArrayList();

      cloudSupport90.Part1 var2;
      while (var1.size() < var0 && (var2 = v5.poll()) != null) {
         var1.add(var2);
      }

      return var1;
   }

   public static void v1(List<cloudSupport90.Part1> var0, Set<UUID> var1, Map<UUID, cloudSupport90.Part2> var2, long var3) {
      if (v3.size() > 4096) {
         v3.clear();
      }

      long var5 = var3 + 60000L;

      for (cloudSupport90.Part1 var8 : var0) {
         v3.put(var8.v1(), new cloudSupport90.Part3(var1.contains(var8.v1()), (cloudSupport90.Part2)var2.get(var8.v1()), var5));
         v4.remove(var8.v1());
      }
   }

   public static void v1(List<cloudSupport90.Part1> var0, long var1) {
      long var3 = var1 + 15000L;

      for (cloudSupport90.Part1 var6 : var0) {
         v3.putIfAbsent(var6.v1(), new cloudSupport90.Part3(false, null, var3));
         v4.remove(var6.v1());
      }
   }

   public static void v3(UUID var0) {
      v3.remove(var0);
   }

   public static void v1() {
      v3.values().removeIf(var0 -> !var0.v1());
   }

   public static void v2() {
      v3.clear();
      v5.clear();
      v4.clear();
   }

   public static void v4(@Nullable UUID var0) {
      v2 = var0;
   }

   public static void v1(boolean var0) {
      v1 = var0;
      if (!var0) {
         v2();
      }
   }

   public record Part1(UUID id, String name) {
      public UUID v1() {
         return this.id;
      }

      public String v2() {
         return this.name;
      }
   }

   public record Part2(long uid, String username) {
      public long v1() {
         return this.uid;
      }

      public String v2() {
         return this.username;
      }
   }

   public record Part3(boolean syky, @Nullable cloudSupport90.Part2 identity, long expiresAt) {
      public boolean v1() {
         return this.syky;
      }

      @Nullable
      public cloudSupport90.Part2 v2() {
         return this.identity;
      }

      public long v3() {
         return this.expiresAt;
      }
   }
}
