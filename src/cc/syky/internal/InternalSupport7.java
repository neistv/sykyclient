package cc.syky.internal;

import cc.syky.AreaSupport;
import cc.syky.EndSupport;
import cc.syky.LANRecord;
import cc.syky.sykyRecord4;
import cc.syky.sykyRecord5;
import cc.syky.cloud.cloudRecord10;
import cc.syky.cloud.cloudRecord11;
import cc.syky.cloud.cloudSupport58;
import cc.syky.cloud.cloudSupport93;
import cc.syky.cloud.cloudSupport95;
import cc.syky.cloud.cloudSupport96;
import cc.syky.config.configSupport;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.google.gson.JsonParser;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import java.util.function.Consumer;
import java.util.function.UnaryOperator;
import org.jetbrains.annotations.Nullable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public final class InternalSupport7 implements AutoCloseable {
   public static final String v1 = "wp.";
   private static final Logger v3 = LoggerFactory.getLogger("syky.waypoints");
   private static final String v4 = "0123456789abcdefghijklmnopqrstuvwxyz";
   private static final int v5 = 8;
   private static final int v6 = 16;
   public static final double v2 = 4.0;
   private static final Gson v7 = new GsonBuilder().setPrettyPrinting().create();
   private final InternalSupport8 v8;
   private final ExecutorService v9;
   private final Consumer<Runnable> v10;
   @Nullable
   private LANRecord v11;
   public String v12 = "";
   public List<sykyRecord4> v13 = List.of();
   public List<sykyRecord4> v14 = List.of();
   public List<sykyRecord4> v15 = List.of();
   private Map<LANRecord, List<sykyRecord4>> v16 = Map.of();
   private int v18;
   private List<InternalSupport7.Part3> v19 = List.of();
   public final Set<String> v17 = new HashSet<>();
   private final Set<String> v20 = new HashSet<>();
   private boolean v21;
   public int v22;
   private int v24;
   private final ArrayDeque<InternalSupport7.Part4> v25 = new ArrayDeque<>();
   private boolean v26;
   private Runnable v27 = () -> {};
   private final Map<String, String> v28 = new HashMap<>();
   public List<String> v29 = List.of();
   public int v30 = -1;
   private volatile boolean v32;
   private final cloudSupport95 v23 = new InternalSupport7.Part1();
   private final configSupport v33 = new configSupport();
   private final InternalSupport9 v31 = new InternalSupport9(this);
   private boolean v34;
   private final AtomicReference<String> v36 = new AtomicReference<>();
   private final cloudSupport93 v38 = new InternalSupport7.Part2();

   public InternalSupport7(InternalSupport8 var1, ExecutorService var2, Consumer<Runnable> var3) {
      this.v8 = var1;
      this.v9 = var2;
      this.v10 = var3;
      this.v33.v1().setOnChange(this::v17);
   }

   public static ExecutorService v1() {
      return Executors.newSingleThreadExecutor(var0 -> {
         Thread var1 = new Thread(var0, "syky-waypoints");
         var1.setDaemon(true);
         return var1;
      });
   }

   public void v2() {
      this.v2(this.v8::v1);
      this.v2(() -> {
         try {
            this.v8.v2().ifPresent(var1 -> this.v10.accept(() -> this.v5(var1)));
         } catch (IOException var2) {
            v3.warn("could not read the waypoint options; keeping the defaults", var2);
         }
      });
   }

   public configSupport v3() {
      return this.v33;
   }

   private void v5(String var1) {
      if (!this.v32 && !this.v34) {
         try {
            if (JsonParser.parseString(var1) instanceof JsonObject var2) {
               this.v33.v1(var2);
            }
         } catch (JsonParseException var4) {
            v3.warn("the waypoint options cannot be read ({}); keeping the defaults", var4.getMessage());
         }
      }
   }

   private void v17() {
      this.v34 = true;
      if (this.v36.getAndSet(v7.toJson(this.v33.v6())) == null) {
         this.v2(this::v20);
      }
   }

   private void v20() {
      String var1 = this.v36.getAndSet(null);
      if (var1 != null) {
         try {
            this.v8.v1(var1);
         } catch (IOException var3) {
            v3.warn("could not save the waypoint options", var3);
         }
      }
   }

   public void v1(Runnable var1) {
      this.v27 = var1;
   }

   public void v1(@Nullable LANRecord var1, String var2) {
      String var3 = var2 == null ? "" : var2;
      if (!Objects.equals(var1, this.v11)) {
         this.v4(var1, var3);
      } else {
         if (!var3.equals(this.v12)) {
            this.v31.v12();
            this.v12 = var3;
            this.v22();
            this.v22++;
            this.v27.run();
         }
      }
   }

   private void v4(@Nullable LANRecord var1, String var2) {
      this.v31.v12();
      this.v11 = var1;
      this.v12 = var2;
      this.v13 = List.of();
      this.v17.clear();
      this.v20.clear();
      this.v16 = Map.of();
      this.v18++;
      this.v28.clear();
      this.v21 = false;
      this.v22();
      this.v22++;
      this.v27.run();
      if (var1 != null) {
         this.v1(var1);
      }
   }

   public void v4() {
      LANRecord var1 = this.v11;
      int var2 = ++this.v18;
      this.v2(() -> {
         Map var3;
         try {
            var3 = this.v8.v3();
         } catch (IOException var5) {
            v3.warn("could not read the other worlds' waypoints", var5);
            return;
         }

         if (var1 != null) {
            var3.remove(var1);
         }

         Map var4 = Collections.unmodifiableMap(var3);
         this.v10.accept(() -> {
            if (!this.v32 && var2 == this.v18 && Objects.equals(var1, this.v11)) {
               this.v16 = var4;
               this.v22++;
            }
         });
      });
   }

   public Map<LANRecord, List<sykyRecord4>> v5() {
      return this.v16;
   }

   @Nullable
   public sykyRecord4 v2(LANRecord var1, String var2) {
      List var3 = var1.equals(this.v11) ? this.v13 : this.v16.get(var1);
      if (var3 != null) {
         for (sykyRecord4 var5 : var3) {
            if (var5.v4().equals(var2)) {
               return var5;
            }
         }
      }

      return null;
   }

   public void v6() {
      LANRecord var1 = this.v11;
      if (var1 != null) {
         this.v1(var1);
      }
   }

   private void v1(LANRecord var1) {
      int var2 = ++this.v24;
      this.v2(() -> {
         try {
            this.v1(var1, var2, this.v8.v2(var1));
         } catch (IOException var4) {
            v3.warn("could not read the waypoints of {}", var1.v2(), var4);
            this.v1(var1, var2, null);
         }
      });
   }

   @Nullable
   public LANRecord v7() {
      return this.v11;
   }

   public boolean v8() {
      return this.v11 != null;
   }

   public boolean v9() {
      return this.v21;
   }

   public String v10() {
      return this.v12;
   }

   public List<sykyRecord4> v11() {
      return this.v13;
   }

   public List<sykyRecord4> v12() {
      return this.v14;
   }

   public List<sykyRecord4> v13() {
      return this.v15;
   }

   public List<InternalSupport7.Part3> v14() {
      return this.v19;
   }

   public int v15() {
      return this.v22;
   }

   @Nullable
   public sykyRecord4 v1(String var1) {
      for (sykyRecord4 var3 : this.v13) {
         if (var3.v4().equals(var1)) {
            return var3;
         }
      }

      return null;
   }

   public boolean v1(sykyRecord4 var1) {
      return var1.v2(this.v12) || this.v17.contains(var1.v4()) && var1.v1(this.v12);
   }

   public String v2(sykyRecord4 var1) {
      return this.v28.computeIfAbsent(var1.v4(), InternalSupport7::v6);
   }

   private static String v6(String var0) {
      return "wp." + var0;
   }

   @Nullable
   public sykyRecord4 v1(String var1, int var2, int var3, int var4) {
      return this.v1(var1, var2, var3, var4, this.v12);
   }

   @Nullable
   public sykyRecord4 v1(String var1, int var2, int var3, int var4, String var5) {
      LANRecord var6 = this.v11;
      if (var6 != null && !var5.isEmpty()) {
         String var7 = AreaSupport.v1(var1);
         sykyRecord4 var8 = sykyRecord4.v1(v1(this.v13), var7.isEmpty() ? AreaSupport.v1(this.v13) : var7, var2, var3, var4, var5);
         this.v1(var6, var8);
         return var8;
      } else {
         return null;
      }
   }

   @Nullable
   public sykyRecord4 v1(LANRecord var1, String var2, int var3, int var4, int var5, String var6) {
      if (var1.equals(this.v11)) {
         return this.v1(var2, var3, var4, var5, var6);
      } else if (var6.isEmpty()) {
         return null;
      } else {
         List var7 = this.v16.getOrDefault(var1, List.of());
         String var8 = AreaSupport.v1(var2);
         sykyRecord4 var9 = sykyRecord4.v1(v1(var7), var8.isEmpty() ? AreaSupport.v1(var7) : var8, var3, var4, var5, var6);
         this.v1(var1, var9);
         return var9;
      }
   }

   @Nullable
   public sykyRecord4 v1(String var1, InternalSupport10 var2, String var3) {
      LANRecord var4 = this.v11;
      if (var4 != null && !var3.isEmpty() && !var2.v2()) {
         String var5 = AreaSupport.v1(var1);
         sykyRecord4 var6 = sykyRecord4.v1(v1(this.v13), var5.isEmpty() ? AreaSupport.v2(this.v13) : var5, var2, var3);
         this.v1(var4, var6);
         return var6;
      } else {
         return null;
      }
   }

   public void v1(String var1, float var2) {
      this.v1(var1, var1x -> var1x.v1(var2));
   }

   public void v1(String var1, sykyRecord5 var2) {
      this.v1(var1, var1x -> var1x.v1(var2));
   }

   public void v1(String var1, InternalSupport10 var2) {
      if (!var2.v2()) {
         this.v1(var1, var1x -> var1x.v3() ? var1x.v1(var2) : var1x);
      }
   }

   public InternalSupport9 v16() {
      return this.v31;
   }

   @Nullable
   public sykyRecord4 v1(int var1, int var2, int var3, String var4) {
      LANRecord var5 = this.v11;
      if (this.v33.v3() && var5 != null && !var4.isEmpty()) {
         sykyRecord4 var6 = sykyRecord4.v1(v1(this.v13), AreaSupport.v3(this.v13), var1, var2, var3, var4).v2(-38037).v4(true);
         this.v1(var5, var6);
         return var6;
      } else {
         return null;
      }
   }

   public void v1(double var1, double var3, double var5) {
      if (this.v33.v4()) {
         for (sykyRecord4 var8 : this.v14) {
            if (var8.v14()) {
               double var9 = var8.v6() + 0.5 - var1;
               double var11 = var8.v7() - var3;
               double var13 = var8.v8() + 0.5 - var5;
               if (var9 * var9 + var11 * var11 + var13 * var13 > 16.0) {
                  this.v20.add(var8.v4());
               } else if (this.v20.contains(var8.v4())) {
                  this.v3(var8.v4());
               }
            }
         }
      }
   }

   private void v1(LANRecord var1, sykyRecord4 var2) {
      this.v1(var1, var1x -> {
         for (sykyRecord4 var3 : var1x) {
            if (var3.v4().equals(var2.v4())) {
               return var1x;
            }
         }

         ArrayList var4 = new ArrayList(var1x.size() + 1);
         var4.addAll(var1x);
         var4.add(var2);
         return var4;
      });
   }

   public void v1(String var1, String var2) {
      LANRecord var3 = this.v11;
      if (var3 != null) {
         this.v1(var3, var1, var2);
      }
   }

   public void v1(LANRecord var1, String var2, String var3) {
      String var4 = AreaSupport.v1(var3);
      if (!var4.isEmpty()) {
         this.v1(var1, var2, var1x -> var1x.v5(var4));
      }
   }

   public void v2(LANRecord var1, String var2, @Nullable String var3) {
      String var4 = cloudSupport58.v1(var3);
      this.v1(var1, var2, var1x -> var1x.v6(var4));
   }

   public void v2(String var1, int var2, int var3, int var4) {
      this.v1(var1, var3x -> var3x.v1(var2, var3, var4));
   }

   public void v1(String var1, boolean var2) {
      LANRecord var3 = this.v11;
      if (var3 != null) {
         this.v1(var3, var1, var2);
      }
   }

   public void v1(LANRecord var1, String var2, boolean var3) {
      if (var1.equals(this.v11)) {
         this.v17.remove(var2);
      }

      this.v1(var1, var2, var1x -> var1x.v1(var3));
   }

   public void v2(String var1) {
      sykyRecord4 var2 = this.v1(var1);
      if (var2 != null && var2.v1(this.v12)) {
         this.v1(var1, !var2.v10());
      }
   }

   public void v2(String var1, boolean var2) {
      this.v1(var1, var1x -> var1x.v2(var2));
      this.v27.run();
   }

   public void v2(LANRecord var1, String var2, boolean var3) {
      this.v1(var1, var2, var1x -> var1x.v5(var3));
   }

   public void v1(String var1, int var2) {
      this.v1(var1, var1x -> var1x.v2(var2));
   }

   public void v3(String var1, boolean var2) {
      this.v1(var1, var1x -> var1x.v3(var2));
   }

   public void v3(String var1) {
      LANRecord var2 = this.v11;
      if (var2 != null) {
         this.v3(var2, var1);
      }
   }

   public void v3(LANRecord var1, String var2) {
      if (this.v2(var1, var2) != null) {
         if (var1.equals(this.v11)) {
            this.v17.remove(var2);
            this.v20.remove(var2);
         }

         this.v1(var1, var1x -> {
            ArrayList var2x = new ArrayList(var1x.size());

            for (sykyRecord4 var4 : var1x) {
               if (!var4.v4().equals(var2)) {
                  var2x.add(var4);
               }
            }

            return var2x;
         });
         this.v27.run();
      }
   }

   public void v1(String var1, UnaryOperator<sykyRecord4> var2) {
      LANRecord var3 = this.v11;
      if (var3 != null) {
         this.v1(var3, var1, var2);
      }
   }

   private void v1(LANRecord var1, String var2, UnaryOperator<sykyRecord4> var3) {
      if (this.v2(var1, var2) != null) {
         this.v1(var1, var2x -> {
            ArrayList var3x = new ArrayList(var2x);

            for (int var4 = 0; var4 < var3x.size(); var4++) {
               if (((sykyRecord4)var3x.get(var4)).v4().equals(var2)) {
                  var3x.set(var4, (sykyRecord4)var3.apply((sykyRecord4)var3x.get(var4)));
               }
            }

            return var3x;
         });
      }
   }

   private void v1(LANRecord var1, UnaryOperator<List<sykyRecord4>> var2) {
      if (var1.equals(this.v11)) {
         this.v13 = List.copyOf(var2.apply(this.v13));
         this.v22();
      } else {
         List var3 = this.v16.get(var1);
         if (var3 != null) {
            LinkedHashMap var4 = new LinkedHashMap<>(this.v16);
            List var5 = List.copyOf(var2.apply(var3));
            if (var5.isEmpty()) {
               var4.remove(var1);
            } else {
               var4.put(var1, var5);
            }

            this.v16 = Collections.unmodifiableMap(var4);
         }

         this.v18++;
      }

      this.v22++;
      int var8 = ++this.v24;
      synchronized (this.v25) {
         this.v25.add(new InternalSupport7.Part4(var1, var8, var2));
         if (this.v26) {
            return;
         }

         this.v26 = true;
      }

      this.v2(this::v21);
   }

   private void v21() {
      while (true) {
         ArrayList var3 = new ArrayList();
         LANRecord var1;
         int var2;
         synchronized (this.v25) {
            InternalSupport7.Part4 var5 = this.v25.peek();
            if (var5 == null) {
               this.v26 = false;
               return;
            }

            var1 = var5.v1();
            var2 = var5.v2();

            for (InternalSupport7.Part4 var6 = var5; var6 != null && var6.v1().equals(var1); var6 = this.v25.peek()) {
               this.v25.poll();
               var3.add(var6.v3());
               var2 = var6.v2();
            }
         }

         this.v1(var1, var2, var1x -> {
            List var2x = var1x;

            for (UnaryOperator var4 : var3) {
               var2x = var4.apply(var2x);
            }

            return var2x;
         });
      }
   }

   private void v1(LANRecord var1, int var2, UnaryOperator<List<sykyRecord4>> var3) {
      try {
         this.v1(var1, var2, this.v8.v1(var1, var3));
      } catch (RuntimeException | IOException var7) {
         v3.warn("could not save the waypoints of {}", var1.v2(), var7);

         try {
            this.v1(var1, var2, this.v8.v2(var1));
         } catch (IOException var6) {
            v3.warn("could not read the waypoints of {} back either", var1.v2(), var6);
         }
      }
   }

   private void v1(LANRecord var1, int var2, @Nullable List<sykyRecord4> var3) {
      this.v10.accept(() -> {
         if (!this.v32 && var1.equals(this.v11) && var2 == this.v24) {
            boolean var4 = !this.v21;
            this.v21 = true;
            if (var3 != null && !var3.equals(this.v13)) {
               this.v13 = var3;
               Set var5 = v2(var3);
               this.v17.retainAll(var5);
               this.v20.retainAll(var5);
               this.v22();
               this.v22++;
               this.v27.run();
            } else {
               if (var4) {
                  this.v22++;
               }
            }
         }
      });
   }

   private static Set<String> v2(List<sykyRecord4> var0) {
      HashSet var1 = new HashSet(var0.size() * 2);

      for (sykyRecord4 var3 : var0) {
         var1.add(var3.v4());
      }

      return var1;
   }

   public void v22() {
      String var1 = EndSupport.v1(this.v12);
      ArrayList var2 = new ArrayList();
      ArrayList var3 = new ArrayList();
      ArrayList var4 = new ArrayList();

      for (sykyRecord4 var6 : this.v13) {
         boolean var7 = var6.v9().equals(this.v12);
         if (var7) {
            var2.add(var6);
         } else {
            if (!var6.v9().equals(var1)) {
               continue;
            }

            var3.add(var6);
         }

         if (this.v1(var6)) {
            var4.add(new InternalSupport7.Part3(var6, var6.v3(this.v12), var6.v7(), var6.v4(this.v12), !var7));
         }
      }

      this.v14 = List.copyOf(var2);
      this.v15 = List.copyOf(var3);
      this.v19 = List.copyOf(var4);
   }

   public static String v1(List<sykyRecord4> var0) {
      ThreadLocalRandom var1 = ThreadLocalRandom.current();

      boolean var4;
      String var7;
      do {
         char[] var2 = new char[8];

         for (int var3 = 0; var3 < var2.length; var3++) {
            var2[var3] = "0123456789abcdefghijklmnopqrstuvwxyz".charAt(var1.nextInt("0123456789abcdefghijklmnopqrstuvwxyz".length()));
         }

         var7 = new String(var2);
         var4 = false;

         for (sykyRecord4 var6 : var0) {
            if (var6.v4().equals(var7)) {
               var4 = true;
               break;
            }
         }
      } while (var4);

      return var7;
   }

   public static boolean v4(String var0) {
      if (!var0.isEmpty() && var0.length() <= 16) {
         for (int var1 = 0; var1 < var0.length(); var1++) {
            if ("0123456789abcdefghijklmnopqrstuvwxyz".indexOf(var0.charAt(var1)) < 0) {
               return false;
            }
         }

         return true;
      } else {
         return false;
      }
   }

   public cloudSupport95 v18() {
      return this.v23;
   }

   public cloudSupport93 v19() {
      return this.v38;
   }

   @Nullable
   public sykyRecord4 v7(String var1) {
      if (var1 != null && var1.startsWith("wp.")) {
         int var2 = var1.length() - "wp.".length();

         for (sykyRecord4 var4 : this.v13) {
            if (var4.v4().length() == var2 && var1.startsWith(var4.v4(), "wp.".length())) {
               return var4;
            }
         }

         return null;
      } else {
         return null;
      }
   }

   @Nullable
   public sykyRecord4 v8(String var1) {
      sykyRecord4 var2 = this.v7(var1);
      return var2 != null && var2.v1(this.v12) ? var2 : null;
   }

   private void v2(Runnable var1) {
      if (!this.v32) {
         try {
            this.v9.execute(var1);
         } catch (RejectedExecutionException var3) {
            v3.debug("waypoint task dropped: shutting down");
         }
      }
   }

   @Override
   public void close() {
      this.v32 = true;
      this.v9.shutdown();

      try {
         if (!this.v9.awaitTermination(2L, TimeUnit.SECONDS)) {
            this.v9.shutdownNow();
         }
      } catch (InterruptedException var2) {
         this.v9.shutdownNow();
         Thread.currentThread().interrupt();
      }
   }

   public final class Part1 implements cloudSupport95 {
      public Part1() {
      }

      @Override
      public boolean v1(String var1) {
         return InternalSupport7.this.v8(var1) != null;
      }

      @Override
      public boolean v2(String var1) {
         sykyRecord4 var2 = InternalSupport7.this.v8(var1);
         return var2 != null && InternalSupport7.this.v1(var2);
      }

      @Override
      public void v3(String var1) {
         sykyRecord4 var2 = InternalSupport7.this.v8(var1);
         if (var2 != null) {
            InternalSupport7.this.v2(var2.v4());
         }
      }

      @Override
      public void v4(String var1) {
         sykyRecord4 var2 = InternalSupport7.this.v8(var1);
         if (var2 != null && !var2.v2(InternalSupport7.this.v12) && InternalSupport7.this.v17.add(var2.v4())) {
            InternalSupport7.this.v22();
            InternalSupport7.this.v22++;
         }
      }

      @Override
      public void v5(String var1) {
         sykyRecord4 var2 = InternalSupport7.this.v7(var1);
         if (var2 != null && InternalSupport7.this.v17.remove(var2.v4())) {
            InternalSupport7.this.v22();
            InternalSupport7.this.v22++;
         }
      }

      @Nullable
      @Override
      public String v6(String var1) {
         sykyRecord4 var2 = InternalSupport7.this.v8(var1);
         return var2 == null ? null : var2.v5();
      }

      @Override
      public Collection<String> v1() {
         if (InternalSupport7.this.v30 != InternalSupport7.this.v22) {
            ArrayList var1 = new ArrayList(InternalSupport7.this.v14.size() + InternalSupport7.this.v15.size());

            for (sykyRecord4 var3 : InternalSupport7.this.v14) {
               var1.add(InternalSupport7.this.v2(var3));
            }

            for (sykyRecord4 var5 : InternalSupport7.this.v15) {
               if (var5.v11()) {
                  var1.add(InternalSupport7.this.v2(var5));
               }
            }

            InternalSupport7.this.v29 = List.copyOf(var1);
            InternalSupport7.this.v30 = InternalSupport7.this.v22;
         }

         return InternalSupport7.this.v29;
      }
   }

   public final class Part2 implements cloudSupport93 {
      public Part2() {
      }

      @Override
      public boolean v1(String var1) {
         return var1 != null && var1.startsWith("wp.");
      }

      @Override
      public Collection<cloudRecord11> v1() {
         ArrayList var1 = new ArrayList(InternalSupport7.this.v13.size());

         for (sykyRecord4 var3 : InternalSupport7.this.v13) {
            var1.add(new cloudRecord11(InternalSupport7.this.v2(var3), var3.v20(), var3.v21(), var3.v22()));
         }

         return var1;
      }

      @Override
      public void v1(String var1, @Nullable cloudRecord10 var2, cloudSupport96 var3) {
         sykyRecord4 var4 = InternalSupport7.this.v7(var1);
         if (var4 != null) {
            InternalSupport7.this.v1(var4.v4(), var2x -> var2x.v1(var2, var3));
         }
      }
   }

   public record Part3(sykyRecord4 waypoint, int x, int y, int z, boolean linked) {
      public sykyRecord4 v1() {
         return this.waypoint;
      }

      public int v2() {
         return this.x;
      }

      public int v3() {
         return this.y;
      }

      public int v4() {
         return this.z;
      }

      public boolean v5() {
         return this.linked;
      }
   }

   public record Part4(LANRecord key, int request, UnaryOperator<List<sykyRecord4>> edit) {
      public LANRecord v1() {
         return this.key;
      }

      public int v2() {
         return this.request;
      }

      public UnaryOperator<List<sykyRecord4>> v3() {
         return this.edit;
      }
   }
}
