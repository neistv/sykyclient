package cc.syky.ui;

import java.time.Instant;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReferenceArray;
import org.jetbrains.annotations.Nullable;

public final class HHMmSupport2 {
   public static final int v1 = 300;
   private static final int v2 = 2000;
   private static final int v3 = 6;
   private static final int v4 = 20;
   private static final DateTimeFormatter v5 = DateTimeFormatter.ofPattern("HH:mm:ss").withZone(ZoneId.systemDefault());
   private final AtomicReferenceArray<String> v6 = new AtomicReferenceArray<>(300);
   private final AtomicLong v7 = new AtomicLong();

   public HHMmSupport2() {
   }

   public void v1(String var1) {
      long var2 = this.v7.getAndIncrement();
      this.v6.set((int)(var2 % 300L), var1);
   }

   public void v1(List<String> var1) {
      int var2 = Math.min(var1.size(), 300);
      long var3 = this.v7.getAndAdd(var2);

      for (int var5 = 0; var5 < var2; var5++) {
         this.v6.set((int)((var3 + var5) % 300L), (String)var1.get(var5));
      }
   }

   public List<String> v1() {
      long var1 = this.v7.get();
      long var3 = Math.max(0L, var1 - 300L);
      ArrayList var5 = new ArrayList((int)(var1 - var3));

      for (long var6 = var3; var6 < var1; var6++) {
         String var8 = this.v6.get((int)(var6 % 300L));
         if (var8 != null) {
            var5.add(var8);
         }
      }

      return var5;
   }

   public static List<String> v1(long var0, String var2, String var3, String var4, String var5, @Nullable Throwable var6) {
      ArrayList var7 = new ArrayList();
      String var8 = "[" + v5.format(Instant.ofEpochMilli(var0)) + "] [" + var2 + "/" + var3 + "] (" + var4 + ") ";
      v1(var7, var8, var5);
      if (var6 != null) {
         String var9 = var6.getMessage();
         v1(var7, var6.getClass().getName() + (var9 == null ? "" : ": "), var9 == null ? "" : var9);
         StackTraceElement[] var10 = var6.getStackTrace();

         for (int var11 = 0; var11 < var10.length && var11 < 6; var11++) {
            var7.add("\tat " + NativeMethodSupport.v1(var10[var11]));
         }
      }

      return var7;
   }

   private static void v1(List<String> var0, String var1, String var2) {
      List var3 = var2.lines().limit(20L).toList();
      if (var3.isEmpty()) {
         var0.add(var1.stripTrailing());
      } else {
         var0.add(NativeMethodSupport.v1(var1 + (String)var3.get(0), 2000));

         for (int var4 = 1; var4 < var3.size(); var4++) {
            var0.add(NativeMethodSupport.v1((String)var3.get(var4), 2000));
         }
      }
   }
}
