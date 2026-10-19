package cc.syky.cloud;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import java.security.SecureRandom;
import java.time.Instant;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Base64;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.TreeMap;
import java.util.Map.Entry;
import java.util.function.Consumer;
import java.util.function.LongSupplier;
import org.jetbrains.annotations.Nullable;

public final class GETSupport {
   public static final int v1 = 2000;
   public static final int v2 = 50;
   public static final int v3 = 100;
   public static final int v4 = 99;
   public static final long v5 = 1000L;
   public static final long v6 = 15000L;
   public static final long v7 = 120000L;
   public static final long v8 = 5000L;
   public static final long v9 = 172800000L;
   public static final int v10 = 200;
   public static final long v11 = 10000L;
   private final GETSupport.Part8 v12;
   private final LongSupplier v13;
   private final SecureRandom v14 = new SecureRandom();
   private final Map<Long, GETSupport.Part3> v15 = new HashMap<>();
   private final Map<Long, GETSupport.Part10> v16 = new HashMap<>();
   private final Map<Long, GETSupport.Part4> v18 = new HashMap<>();
   @Nullable
   private SykySession.Part1 v19;
   private boolean v17;
   private boolean v20;
   private boolean v21;
   private boolean v22;
   private int v24;
   private int v25;
   private int v26;

   public GETSupport(GETSupport.Part8 var1) {
      this(var1, System::currentTimeMillis);
   }

   public GETSupport(GETSupport.Part8 var1, LongSupplier var2) {
      this.v12 = var1;
      this.v13 = var2;
   }

   public int v1() {
      return this.v25;
   }

   public List<GETSupport.Part14> v1(long var1) {
      GETSupport.Part3 var3 = this.v15.get(var1);
      if (var3 != null && var3.v14 == null) {
         if (var3.v17 == null || var3.v20 != var3.v19) {
            var3.v17 = this.v9(var3);
            var3.v20 = var3.v19;
         }

         return var3.v17;
      } else {
         return List.of();
      }
   }

   public List<GETSupport.Part6> v2(long var1) {
      GETSupport.Part3 var3 = this.v15.get(var1);
      if (var3 != null && !var3.v13.isEmpty()) {
         ArrayList var4 = new ArrayList(var3.v13.size());

         for (GETSupport.Part5 var6 : var3.v13) {
            GETSupport.Part17 var7 = var3.v2.get(var6.v1().v3());
            var4.add(new GETSupport.Part6(this.v3(var3, var7 != null ? var7 : var6.v1()), var6.v2()));
         }

         return var4;
      } else {
         return List.of();
      }
   }

   public boolean v1(long var1, long var3) {
      GETSupport.Part3 var5 = this.v15.get(var1);
      return var5 != null && v1(var5, var3) >= 0;
   }

   private static int v1(GETSupport.Part3 var0, long var1) {
      for (int var3 = 0; var3 < var0.v13.size(); var3++) {
         if (var0.v13.get(var3).v1().v3() == var1) {
            return var3;
         }
      }

      return -1;
   }

   public boolean v1(GETSupport.Part14 var1) {
      return var1.v4() && var1.v3() > 0L && var1.v1() == GETSupport.Part9.WORDS && this.v13.getAsLong() - var1.v6().toEpochMilli() < 172800000L;
   }

   public GETSupport.Part15 v3(long var1) {
      GETSupport.Part3 var3 = this.v15.get(var1);
      return var3 == null ? GETSupport.Part15.LOADING : var3.v4;
   }

   public String v4(long var1) {
      GETSupport.Part3 var3 = this.v15.get(var1);
      return var3 == null ? "" : var3.v5;
   }

   public boolean v5(long var1) {
      GETSupport.Part3 var3 = this.v15.get(var1);
      return var3 != null && var3.v4 == GETSupport.Part15.READY && var3.v7 && !var3.v8;
   }

   public boolean v6(long var1) {
      GETSupport.Part3 var3 = this.v15.get(var1);
      return var3 != null && var3.v8;
   }

   @Nullable
   public GETSupport.Part4 v7(long var1) {
      return this.v18.get(var1);
   }

   public List<Long> v2() {
      ArrayList var1 = new ArrayList();

      for (Entry var3 : this.v16.entrySet()) {
         if (this.v8((Long)var3.getKey()) != null) {
            var1.add(var3);
         }
      }

      var1.sort((var0, var1x) -> Long.compare(((GETSupport.Part10)var1x.getValue()).v1(), ((GETSupport.Part10)var0.getValue()).v1()));
      ArrayList var5 = new ArrayList(var1.size());

      for (Entry var4 : var1) {
         var5.add((Long)var4.getKey());
      }

      return var5;
   }

   @Nullable
   public GETSupport.Part10 v8(long var1) {
      GETSupport.Part3 var3 = this.v15.get(var1);
      return var3 != null && var3.v14 != null ? null : this.v16.get(var1);
   }

   public void v1(long var1, boolean var3, Consumer<String> var4) {
      if (this.v7()) {
         GETSupport.Part3 var5 = this.v13(var1);
         long var6 = this.v13.getAsLong() + 10000L;
         var5.v14 = new GETSupport.Part2(var1, var3, var6);
         var5.v15 = var5.v2.isEmpty() ? this.v12(var1) : Math.max(var5.v2.lastKey(), this.v12(var1));
         var5.v16 = var4;

         for (GETSupport.Part3 var9 : this.v15.values()) {
            GETSupport.Part2 var10 = var9.v14;
            if (var10 != null && var9 != var5) {
               var9.v14 = new GETSupport.Part2(var10.v1(), var10.v2(), var6);
            }
         }

         this.v5(var5);
         int var11 = this.v24;
         int var12 = ++this.v26;
         this.v12.v1(10000L, () -> {
            if (var11 == this.v24 && var12 == this.v26) {
               for (GETSupport.Part3 var4x : List.copyOf(this.v15.values())) {
                  if (var4x.v14 != null) {
                     this.v1(var4x);
                  }
               }
            }
         });
      }
   }

   private void v1(GETSupport.Part3 var1) {
      GETSupport.Part2 var2 = var1.v14;
      Consumer var3 = var1.v16;
      long var4 = var1.v15;
      var1.v14 = null;
      var1.v16 = null;
      if (var2 != null && var4 > 0L) {
         this.v2(var1, var4);
         int var6 = this.v24;
         this.v12.v1("DELETE", "/v1/messages/" + var2.v1() + "?for=" + (var2.v2() ? "both" : "me") + "&up_to=" + var4, null, var0 -> {}, var4x -> {
            if (var6 == this.v24) {
               var1.v18 = 0L;
               var1.v4 = GETSupport.Part15.LOADING;
               this.v2(var1);
               this.v9();
               if (var3 != null) {
                  var3.accept(var4x.v4());
               }
            }
         });
      } else {
         this.v5(var1);
      }
   }

   public void v3() {
      this.v26++;

      for (GETSupport.Part3 var2 : this.v15.values()) {
         if (var2.v14 != null) {
            var2.v14 = null;
            var2.v16 = null;
            this.v5(var2);
         }
      }
   }

   public List<GETSupport.Part2> v4() {
      ArrayList var1 = new ArrayList();

      for (GETSupport.Part3 var3 : this.v15.values()) {
         GETSupport.Part2 var4 = var3.v14;
         if (var4 != null) {
            var1.add(var4);
         }
      }

      var1.sort(Comparator.comparingLong(GETSupport.Part2::v3));
      return var1;
   }

   private long v12(long var1) {
      GETSupport.Part10 var3 = this.v16.get(var1);
      return var3 == null ? 0L : var3.v1();
   }

   private void v2(GETSupport.Part3 var1, long var2) {
      var1.v18 = Math.max(var1.v18, var2);
      var1.v2.headMap(var2, true).clear();
      var1.v13 = var1.v13.stream().filter(var2x -> var2x.v1().v3() > var2).toList();
      GETSupport.Part10 var4 = this.v16.get(var1.v1);
      if (var4 != null && var4.v1() <= var2) {
         this.v16.remove(var1.v1);
      }

      this.v4(var1);
      this.v5(var1);
   }

   public void v5() {
      SykySession.Part1 var1 = SykySession.v1();
      if (!this.v22 || !Objects.equals(var1, this.v19)) {
         this.v22 = true;
         this.v1(var1);
         this.v9();
      }
   }

   public void v6() {
      this.v5();
      this.v9();
   }

   private void v1(@Nullable SykySession.Part1 var1) {
      this.v24++;
      this.v19 = var1;
      this.v15.clear();
      this.v16.clear();
      this.v18.clear();
      this.v17 = false;
      this.v20 = false;
      this.v21 = false;
      this.v11();
   }

   private boolean v7() {
      SykySession.Part1 var1 = SykySession.v1();
      return var1 != null && var1.equals(this.v19);
   }

   private long v8() {
      SykySession.Part1 var1 = this.v19;
      return var1 == null ? 0L : var1.v1();
   }

   private void v9() {
      if (this.v7()) {
         if (this.v20) {
            this.v21 = true;
         } else {
            this.v20 = true;
            int var1 = this.v24;
            this.v12.v1("GET", "/v1/conversations", null, var2 -> {
               if (var1 == this.v24) {
                  this.v20 = false;
                  this.v17 = true;

                  for (JsonObject var4 : v2(var2, "conversations")) {
                     JsonObject var5 = var4.getAsJsonObject("peer");
                     JsonObject var6 = var4.getAsJsonObject("last");
                     if (var5 != null && var6 != null) {
                        long var7 = cloudSupport60.v3(var5, "uid");
                        this.v18.put(var7, new GETSupport.Part4(var7, cloudSupport60.v2(var5, "username"), cloudSupport60.v3(var5, "avatar")));
                        GETSupport.Part17 var9 = v1(var6);
                        GETSupport.Part10 var10 = this.v16.get(var7);
                        if (var10 == null || var10.v1() <= var9.v3()) {
                           int var11 = Math.min(99, (int)cloudSupport60.v3(var4, "unread"));
                           this.v16.put(var7, new GETSupport.Part10(var9.v3(), var9.v5(), var9.v4() == this.v8(), var9.v6(), var11, var9.v1()));
                        }

                        GETSupport.Part3 var12 = this.v15.get(var7);
                        if (var12 != null) {
                           var12.v12 = Math.max(var12.v12, cloudSupport60.v3(var4, "peer_read"));
                           var12.v19++;
                        }
                     }
                  }

                  this.v11();
                  if (this.v21) {
                     this.v21 = false;
                     this.v9();
                  }
               }
            }, var2 -> {
               if (var1 == this.v24) {
                  this.v20 = false;
                  if (this.v21) {
                     this.v21 = false;
                     this.v9();
                  }
               }
            });
         }
      }
   }

   private void v1(long var1, GETSupport.Part17 var3) {
      GETSupport.Part10 var4 = this.v16.get(var1);
      if (var4 == null || var4.v1() < var3.v3()) {
         boolean var5 = var3.v4() == this.v8();
         int var6 = var4 == null ? 0 : var4.v5();
         if (!var5) {
            GETSupport.Part3 var7 = this.v15.get(var1);
            if (var7 == null || var3.v3() > var7.v10) {
               var6 = Math.min(99, var6 + 1);
            }
         }

         this.v16.put(var1, new GETSupport.Part10(var3.v3(), var3.v5(), var5, var3.v6(), var6, var3.v1()));
      }
   }

   private void v1(long var1, int var3) {
      GETSupport.Part10 var4 = this.v16.get(var1);
      if (var4 != null && var4.v5() != var3) {
         this.v16.put(var1, new GETSupport.Part10(var4.v1(), var4.v2(), var4.v3(), var4.v4(), var3, var4.v6()));
      }
   }

   private GETSupport.Part3 v13(long var1) {
      return this.v15.computeIfAbsent(var1, GETSupport.Part3::new);
   }

   public void v9(long var1) {
      if (this.v7()) {
         GETSupport.Part3 var3 = this.v13(var1);
         if (var3.v4 == GETSupport.Part15.READY) {
            this.v3(var3);
         } else if (!var3.v6) {
            this.v2(var3);
         }
      }
   }

   private void v2(GETSupport.Part3 var1) {
      var1.v6 = true;
      if (var1.v4 == GETSupport.Part15.FAILED) {
         var1.v4 = GETSupport.Part15.LOADING;
         var1.v19++;
         this.v11();
      }

      int var2 = this.v24;
      this.v12.v1("GET", "/v1/messages/" + var1.v1 + "?limit=50", null, var3 -> {
         if (var2 == this.v24) {
            var1.v6 = false;
            var1.v7 = this.v1(var1, var3).size() >= 50;
            this.v4(var1);
            var1.v4 = GETSupport.Part15.READY;
            var1.v5 = "";
            this.v5(var1);
         }
      }, var3 -> {
         if (var2 == this.v24) {
            var1.v6 = false;
            var1.v4 = GETSupport.Part15.FAILED;
            var1.v5 = var3.v4();
            this.v5(var1);
         }
      });
   }

   public void v10(long var1) {
      GETSupport.Part3 var3 = this.v15.get(var1);
      if (var3 != null && this.v5(var1) && !var3.v2.isEmpty()) {
         var3.v8 = true;
         long var4 = var3.v2.firstKey();
         int var6 = this.v24;
         this.v12.v1("GET", "/v1/messages/" + var3.v1 + "?before=" + var4 + "&limit=50", null, var3x -> {
            if (var6 == this.v24) {
               var3.v8 = false;
               var3.v7 = this.v1(var3, var3x).size() >= 50;
               this.v4(var3);
               this.v5(var3);
            }
         }, var3x -> {
            if (var6 == this.v24) {
               var3.v8 = false;
               this.v5(var3);
            }
         });
      }
   }

   private void v3(GETSupport.Part3 var1) {
      if (!var1.v9 && !var1.v6) {
         if (var1.v2.isEmpty()) {
            this.v2(var1);
         } else {
            var1.v9 = true;
            long var2 = var1.v2.lastKey();
            int var4 = this.v24;
            this.v12.v1("GET", "/v1/messages/" + var1.v1 + "?after=" + var2 + "&limit=100", null, var3 -> {
               if (var4 == this.v24) {
                  var1.v9 = false;
                  boolean var4x = this.v1(var1, var3).size() >= 100;
                  this.v4(var1);
                  this.v5(var1);
                  if (var4x) {
                     this.v3(var1);
                  }
               }
            }, var3 -> {
               if (var4 == this.v24) {
                  var1.v9 = false;
               }
            });
         }
      }
   }

   private List<GETSupport.Part17> v1(GETSupport.Part3 var1, JsonObject var2) {
      ArrayList var3 = new ArrayList();

      for (JsonObject var5 : v2(var2, "messages")) {
         GETSupport.Part17 var6 = v1(var5);
         if (var6.v3() > 0L) {
            var3.add(var6);
            this.v2(var1, var6, v2(var5));
         }
      }

      var1.v10 = Math.max(var1.v10, cloudSupport60.v3(var2, "read"));
      var1.v12 = Math.max(var1.v12, cloudSupport60.v3(var2, "peer_read"));
      if (var2.has("pinned")) {
         var1.v13 = v3(var2.get("pinned"));
      }

      if (!var3.isEmpty()) {
         this.v1(var1.v1, var1.v2.lastEntry().getValue());
      }

      return var3;
   }

   private void v1(GETSupport.Part3 var1, GETSupport.Part17 var2) {
      if (var2.v3() > var1.v18 && !var1.v2.containsKey(var2.v3())) {
         var1.v2.put(var2.v3(), var2);
      }
   }

   private void v4(GETSupport.Part3 var1) {
      if (!var1.v2.isEmpty() && (var1.v2.firstKey() <= var1.v10 || !var1.v7)) {
         long var2 = this.v8();
         int var4 = 0;

         for (GETSupport.Part17 var6 : var1.v2.tailMap(var1.v10, false).values()) {
            if (var6.v4() != var2) {
               if (++var4 >= 99) {
                  break;
               }
            }
         }

         this.v1(var1.v1, var4);
      }
   }

   private void v5(GETSupport.Part3 var1) {
      var1.v19++;
      this.v11();
   }

   public void v11(long var1) {
      GETSupport.Part3 var3 = this.v15.get(var1);
      if (var3 != null && var3.v4 == GETSupport.Part15.READY && this.v7()) {
         long var4 = this.v6(var3);
         if (var4 > var3.v10 && this.v13.getAsLong() >= var3.v11) {
            long var6 = var3.v10;
            var3.v10 = var4;
            this.v1(var3.v1, 0);
            this.v5(var3);
            JsonObject var8 = new JsonObject();
            var8.addProperty("up_to", var4);
            int var9 = this.v24;
            this.v12.v1("POST", "/v1/messages/" + var1 + "/read", var8, var0 -> {}, var7 -> {
               if (var9 == this.v24 && var3.v10 == var4) {
                  var3.v10 = var6;
                  var3.v11 = this.v13.getAsLong() + 5000L;
               }
            });
         }
      }
   }

   private long v6(GETSupport.Part3 var1) {
      long var2 = this.v8();

      for (GETSupport.Part17 var5 : var1.v2.descendingMap().values()) {
         if (var5.v4() != var2) {
            return var5.v3();
         }
      }

      return 0L;
   }

   public void v1(long var1, String var3) {
      this.v1(var1, var3, 0L);
   }

   public void v1(long var1, String var3, long var4) {
      this.v1(var1, var3, var4, null);
   }

   public void v1(long var1, String var3, long var4, @Nullable String var6) {
      String var7 = cloudSupport86.v1(var3);
      if (!var7.isEmpty() && this.v7()) {
         this.v1(var1, var7, var4, cloudSupport86.v2(var6), null, null);
      }
   }

   public void v1(long var1, GETSupport.Part1 var3, long var4) {
      if (this.v7()) {
         this.v1(var1, var3.v1(), var4, null, var3, null);
      }
   }

   public void v1(long var1, String var3, @Nullable byte[] var4, long var5) {
      if (this.v7()) {
         String var7 = var4 == null ? null : Base64.getEncoder().encodeToString(var4);
         this.v1(var1, var3, var5, null, null, new GETSupport.Part7(var3, null, var7));
      }
   }

   private void v1(long var1, String var3, long var4, @Nullable String var6, @Nullable GETSupport.Part1 var7, @Nullable GETSupport.Part7 var8) {
      GETSupport.Part3 var9 = this.v13(var1);
      GETSupport.Part17 var10 = var4 > 0L ? var9.v2.get(var4) : null;
      GETSupport.Part13 var11 = var10 == null ? null : v1(v1(var10), var6);
      var9.v3.add(new GETSupport.Part11(this.v10(), var3, Instant.ofEpochMilli(this.v13.getAsLong()), var11 == null ? 0L : var4, var11, var7, var8));
      this.v5(var9);
      this.v8(var9);
   }

   public void v2(long var1, String var3) {
      GETSupport.Part3 var4 = this.v15.get(var1);
      GETSupport.Part11 var5 = var4 == null ? null : v1(var4, var3);
      if (var4 != null && var5 != null && var5.v13) {
         var4.v3.remove(var5);
         var4.v3.add(new GETSupport.Part11(var5.v1, var5.v3, Instant.ofEpochMilli(this.v13.getAsLong()), var5.v5, var5.v6, var5.v7, var5.v8));
         this.v5(var4);
         this.v8(var4);
      }
   }

   public void v3(long var1, String var3) {
      GETSupport.Part3 var4 = this.v15.get(var1);
      GETSupport.Part11 var5 = var4 == null ? null : v1(var4, var3);
      if (var4 != null && var5 != null && var5.v13) {
         var4.v3.remove(var5);
         this.v5(var4);
      }
   }

   public void v1(long var1, long var3, String var5, Consumer<String> var6) {
      GETSupport.Part3 var7 = this.v15.get(var1);
      GETSupport.Part17 var8 = var7 == null ? null : var7.v2.get(var3);
      String var9 = cloudSupport86.v1(var5);
      if (var7 != null && var8 != null && var8.v1() == GETSupport.Part9.WORDS && !var9.isEmpty() && !var9.equals(var8.v5())) {
         this.v2(var7, var8.v1(var9, Instant.ofEpochMilli(this.v13.getAsLong())));
         JsonObject var10 = new JsonObject();
         var10.addProperty("body", var9);
         int var11 = this.v24;
         this.v12.v1("PATCH", "/v1/messages/" + var1 + "/" + var3, var10, var6x -> {
            if (var11 == this.v24 && var7.v2.containsKey(var3)) {
               this.v2(var7, v1(var6x).v1(var8.v2()));
            }
         }, var7x -> {
            if (var11 == this.v24) {
               if (var7.v2.containsKey(var3)) {
                  this.v2(var7, var8);
               }

               var6.accept(var7x.v4());
            }
         });
      }
   }

   public void v1(long var1, long var3, boolean var5, Consumer<String> var6) {
      GETSupport.Part3 var7 = this.v15.get(var1);
      GETSupport.Part17 var8 = var7 == null ? null : var7.v2.get(var3);
      if (var7 != null && var8 != null) {
         List var9 = var7.v13;
         this.v3(var7, var3);
         int var10 = this.v24;
         this.v12.v1("DELETE", "/v1/messages/" + var1 + "/" + var3 + (var5 ? "" : "?for=me"), null, var0 -> {}, var6x -> {
            if (var10 == this.v24 && var6x.v2() != 404) {
               this.v1(var7, var8);
               if (var7.v13.size() < var9.size()) {
                  var7.v13 = var9;
               }

               this.v4(var7);
               this.v5(var7);
               var6.accept(var6x.v4());
            }
         });
      }
   }

   public void v2(long var1, long var3, boolean var5, Consumer<String> var6) {
      GETSupport.Part3 var7 = this.v15.get(var1);
      GETSupport.Part17 var8 = var7 == null ? null : var7.v2.get(var3);
      if (var7 != null && var8 != null) {
         ArrayList var9 = new ArrayList(var7.v13.size() + 1);
         var9.add(new GETSupport.Part5(var8, var5));

         for (GETSupport.Part5 var11 : var7.v13) {
            if (var11.v1().v3() != var3) {
               var9.add(var11);
            }
         }

         JsonObject var12 = new JsonObject();
         var12.addProperty("for_both", var5);
         this.v1(var7, "PUT", "/v1/messages/" + var1 + "/" + var3 + "/pin", var12, List.copyOf(var9), var6);
      }
   }

   public void v1(long var1, long var3, Consumer<String> var5) {
      GETSupport.Part3 var6 = this.v15.get(var1);
      if (var6 != null && v1(var6, var3) >= 0) {
         List var7 = var6.v13.stream().filter(var2 -> var2.v1().v3() != var3).toList();
         this.v1(var6, "DELETE", "/v1/messages/" + var1 + "/" + var3 + "/pin", null, var7, var5);
      }
   }

   public void v1(long var1, Consumer<String> var3) {
      GETSupport.Part3 var4 = this.v15.get(var1);
      if (var4 != null && !var4.v13.isEmpty()) {
         this.v1(var4, "DELETE", "/v1/messages/" + var1 + "/pin", null, List.of(), var3);
      }
   }

   private void v1(GETSupport.Part3 var1, String var2, String var3, @Nullable JsonObject var4, List<GETSupport.Part5> var5, Consumer<String> var6) {
      List var7 = var1.v13;
      var1.v13 = var5;
      this.v5(var1);
      int var8 = this.v24;
      this.v12.v1(var2, var3, var4, var0 -> {}, var6x -> {
         if (var8 == this.v24) {
            if (var1.v13 == var5) {
               var1.v13 = var7;
               this.v5(var1);
            }

            var6.accept(var6x.v4());
         }
      });
   }

   private void v2(GETSupport.Part3 var1, GETSupport.Part17 var2) {
      GETSupport.Part17 var3 = var1.v2.get(var2.v3());
      var1.v2.put(var2.v3(), var3 == null ? var2 : var2.v1(var3.v2()));
      GETSupport.Part13 var4 = v1(var2);

      for (Entry var6 : var1.v2.entrySet()) {
         GETSupport.Part13 var7 = ((GETSupport.Part17)var6.getValue()).v7();
         if (var7 != null && var7.v1() == var2.v3()) {
            var6.setValue(((GETSupport.Part17)var6.getValue()).v1(v1(var4, var7.v4())));
         }
      }

      int var8 = v1(var1, var2.v3());
      if (var8 >= 0) {
         ArrayList var9 = new ArrayList<>(var1.v13);
         var9.set(var8, new GETSupport.Part5(var2, var1.v13.get(var8).v2()));
         var1.v13 = List.copyOf(var9);
      }

      GETSupport.Part10 var10 = this.v16.get(var1.v1);
      if (var10 != null && var10.v1() == var2.v3()) {
         this.v16.put(var1.v1, new GETSupport.Part10(var10.v1(), var2.v5(), var10.v3(), var10.v4(), var10.v5(), var10.v6()));
      }

      this.v5(var1);
   }

   private void v3(GETSupport.Part3 var1, long var2) {
      var1.v2.remove(var2);

      for (Entry var5 : var1.v2.entrySet()) {
         GETSupport.Part13 var6 = ((GETSupport.Part17)var5.getValue()).v7();
         if (var6 != null && var6.v1() == var2) {
            var5.setValue(((GETSupport.Part17)var5.getValue()).v1(null));
         }
      }

      if (v1(var1, var2) >= 0) {
         var1.v13 = var1.v13.stream().filter(var2x -> var2x.v1().v3() != var2).toList();
      }

      GETSupport.Part10 var7 = this.v16.get(var1.v1);
      if (var7 != null && var7.v1() == var2) {
         this.v9();
      }

      this.v4(var1);
      this.v5(var1);
   }

   private static GETSupport.Part13 v1(GETSupport.Part17 var0) {
      String var1 = var0.v5();
      if (var1.codePointCount(0, var1.length()) > 200) {
         var1 = var1.substring(0, var1.offsetByCodePoints(0, 200));
      }

      return new GETSupport.Part13(var0.v3(), var0.v4(), var1, null);
   }

   private static GETSupport.Part13 v1(GETSupport.Part13 var0, @Nullable String var1) {
      return new GETSupport.Part13(var0.v1(), var0.v2(), var0.v3(), var1);
   }

   @Nullable
   private static GETSupport.Part11 v1(GETSupport.Part3 var0, String var1) {
      for (GETSupport.Part11 var3 : var0.v3) {
         if (var3.v2.equals(var1)) {
            return var3;
         }
      }

      return null;
   }

   @Nullable
   private static GETSupport.Part11 v7(GETSupport.Part3 var0) {
      for (GETSupport.Part11 var2 : var0.v3) {
         if (!var2.v13) {
            return var2;
         }
      }

      return null;
   }

   private void v8(GETSupport.Part3 var1) {
      GETSupport.Part11 var2 = v7(var1);
      if (var2 != null && !var2.v12 && this.v13.getAsLong() >= var2.v10) {
         var2.v12 = true;
         if (var2.v9 == 0L) {
            var2.v9 = this.v13.getAsLong();
         }

         JsonObject var3 = new JsonObject();
         GETSupport.Part1 var4 = var2.v7;
         if (var4 != null) {
            JsonObject var5 = new JsonObject();
            var5.addProperty("x", var4.v2());
            var5.addProperty("y", var4.v3());
            var5.addProperty("z", var4.v4());
            var5.addProperty("dim", var4.v5());
            if (var4.v6() != null) {
               var5.addProperty("address", var4.v6());
            }

            var3.add("waypoint", var5);
         } else if (var2.v8 != null) {
            JsonObject var6 = new JsonObject();
            var6.addProperty("address", var2.v8.v1());
            if (var2.v8.v3() != null) {
               var6.addProperty("icon", var2.v8.v3());
            }

            var3.add("invite", var6);
         } else {
            var3.addProperty("body", var2.v3);
         }

         var3.addProperty("nonce", var2.v1);
         if (var2.v5 > 0L) {
            var3.addProperty("reply_to", var2.v5);
            GETSupport.Part13 var7 = var2.v6;
            if (var7 != null && var7.v4() != null && var4 == null && var2.v8 == null) {
               var3.addProperty("quote", var7.v4());
            }
         }

         int var8 = this.v24;
         this.v12.v1("POST", "/v1/messages/" + var1.v1, var3, var4x -> {
            if (var8 == this.v24) {
               var2.v12 = false;
               GETSupport.Part17 var5x = v1(var4x);
               if (var5x.v3() > 0L) {
                  this.v1(var1, var5x, var2.v1);
               } else {
                  var1.v3.remove(var2);
                  this.v5(var1);
               }

               this.v8(var1);
            }
         }, var4x -> {
            if (var8 == this.v24) {
               var2.v12 = false;
               long var5x = this.v13.getAsLong();
               if (var4x.v1() && var5x - var2.v9 < 120000L) {
                  var2.v11 = var2.v11 == 0L ? 1000L : Math.min(15000L, var2.v11 * 2L);
                  var2.v10 = var5x + var2.v11;
                  this.v12.v1(var2.v11, () -> {
                     if (var8 == this.v24) {
                        this.v8(var1);
                     }
                  });
               } else {
                  var2.v13 = true;
                  this.v5(var1);
                  this.v8(var1);
               }
            }
         });
      }
   }

   private void v1(GETSupport.Part3 var1, GETSupport.Part17 var2, @Nullable String var3) {
      this.v2(var1, var2, var3);
      this.v1(var1.v1, var2);
      this.v5(var1);
   }

   private void v2(GETSupport.Part3 var1, GETSupport.Part17 var2, @Nullable String var3) {
      GETSupport.Part17 var4 = var2;
      if (var3 != null) {
         Iterator var5 = var1.v3.iterator();

         while (var5.hasNext()) {
            GETSupport.Part11 var6 = (GETSupport.Part11)var5.next();
            if (var6.v1.equals(var3)) {
               var5.remove();
               var4 = var2.v1(var6.v2);
               break;
            }
         }
      }

      this.v1(var1, var4);
   }

   private String v10() {
      byte[] var1 = new byte[16];
      this.v14.nextBytes(var1);
      return Base64.getUrlEncoder().withoutPadding().encodeToString(var1);
   }

   public void v1(String var1, JsonObject var2) {
      if (this.v22 && this.v7()) {
         long var3 = this.v8();
         switch (var1) {
            case "message":
               GETSupport.Part17 var23 = v1(var2);
               long var26 = cloudSupport60.v3(var2, "to");
               if (var23.v3() <= 0L || var23.v4() != var3 && var26 != var3) {
                  return;
               }

               long var29 = var23.v4() == var3 ? var26 : var23.v4();
               GETSupport.Part3 var31 = this.v15.get(var29);
               if (var31 == null) {
                  this.v1(var29, var23);
                  this.v11();
                  return;
               }

               this.v1(var31, var23, v2(var2));
               this.v8(var31);
               break;
            case "message_read":
               long var22 = cloudSupport60.v3(var2, "reader");
               long var28 = cloudSupport60.v3(var2, "peer");
               long var30 = cloudSupport60.v3(var2, "up_to");
               if (var22 == var3) {
                  GETSupport.Part3 var13 = this.v15.get(var28);
                  if (var13 != null) {
                     var13.v10 = Math.max(var13.v10, var30);
                     this.v4(var13);
                     this.v5(var13);
                  }

                  GETSupport.Part10 var14 = this.v16.get(var28);
                  if (var14 != null && var30 >= var14.v1()) {
                     this.v1(var28, 0);
                  } else if (var13 == null || var13.v2.isEmpty() || var13.v2.firstKey() > var30 + 1L) {
                     this.v9();
                  }

                  this.v11();
               } else if (var28 == var3) {
                  GETSupport.Part3 var32 = this.v13(var22);
                  if (var30 > var32.v12) {
                     var32.v12 = var30;
                     Instant var33 = v1(var2, "at");
                     if (var33 != null) {
                        for (Entry var16 : var32.v2.headMap(var30, true).entrySet()) {
                           GETSupport.Part17 var17 = (GETSupport.Part17)var16.getValue();
                           if (var17.v4() == var3 && var17.v9() == null) {
                              var16.setValue(var17.v1(var33));
                           }
                        }
                     }

                     this.v5(var32);
                  }
               }
               break;
            case "message_edited":
               GETSupport.Part17 var21 = v1(var2);
               long var25 = cloudSupport60.v3(var2, "to");
               GETSupport.Part3 var10 = this.v15.get(var21.v4() == var3 ? var25 : var21.v4());
               if (var10 != null && var10.v2.containsKey(var21.v3())) {
                  this.v2(var10, var21);
               }
               break;
            case "message_deleted":
               long var20 = cloudSupport60.v3(var2, "peer");
               long var27 = cloudSupport60.v3(var2, "id");
               GETSupport.Part3 var11 = this.v15.get(var20);
               if (var11 != null && var11.v2.containsKey(var27)) {
                  this.v3(var11, var27);
               } else {
                  GETSupport.Part10 var12 = this.v16.get(var20);
                  if (var12 != null && var12.v1() == var27) {
                     this.v9();
                  }
               }
               break;
            case "chat_cleared":
               GETSupport.Part3 var19 = this.v15.get(cloudSupport60.v3(var2, "peer"));
               long var24 = cloudSupport60.v3(var2, "up_to");
               if (var19 != null && var24 > 0L) {
                  this.v2(var19, var24);
               } else {
                  this.v9();
               }
               break;
            case "message_pinned":
               GETSupport.Part3 var18 = this.v15.get(cloudSupport60.v3(var2, "peer"));
               if (var18 != null) {
                  var18.v13 = v3(var2.has("pinned") ? var2.get("pinned") : var2.get("message"));
                  this.v5(var18);
               }
               break;
            case "gateway_ready":
               this.v9();

               for (GETSupport.Part3 var8 : this.v15.values()) {
                  if (var8.v4 == GETSupport.Part15.READY) {
                     this.v3(var8);
                  } else if (var8.v4 == GETSupport.Part15.FAILED) {
                     this.v2(var8);
                  }

                  GETSupport.Part11 var9 = v7(var8);
                  if (var9 != null) {
                     var9.v10 = 0L;
                     this.v8(var8);
                  }
               }
         }
      }
   }

   private void v11() {
      this.v25++;
   }

   private List<GETSupport.Part14> v9(GETSupport.Part3 var1) {
      ArrayList var2 = new ArrayList(var1.v2.size() + var1.v3.size());

      for (GETSupport.Part17 var4 : var1.v2.values()) {
         var2.add(this.v3(var1, var4));
      }

      long var7 = this.v8();

      for (GETSupport.Part11 var6 : var1.v3) {
         var2.add(
            new GETSupport.Part14(
               var6.v2,
               0L,
               true,
               var6.v3,
               var6.v4,
               var6.v13 ? GETSupport.Part16.FAILED : GETSupport.Part16.SENDING,
               v1(var6.v6, var7),
               null,
               null,
               var6.v7,
               var6.v8
            )
         );
      }

      return List.copyOf(var2);
   }

   private GETSupport.Part14 v3(GETSupport.Part3 var1, GETSupport.Part17 var2) {
      long var3 = this.v8();
      boolean var5 = var2.v4() == var3;
      GETSupport.Part16 var6 = var5 && var2.v3() <= var1.v12 ? GETSupport.Part16.READ : GETSupport.Part16.SENT;
      return new GETSupport.Part14(var2.v2(), var2.v3(), var5, var2.v5(), var2.v6(), var6, v1(var2.v7(), var3), var2.v8(), var2.v9(), var2.v10(), var2.v11());
   }

   @Nullable
   private static GETSupport.Part18 v1(@Nullable GETSupport.Part13 var0, long var1) {
      return var0 == null ? null : new GETSupport.Part18(var0.v1(), var0.v2() == var1, var0.v3(), var0.v4());
   }

   private static GETSupport.Part17 v1(JsonObject var0) {
      long var1 = cloudSupport60.v3(var0, "id");
      GETSupport.Part13 var3 = null;
      JsonElement var4 = var0.get("reply");
      if (var4 != null && var4.isJsonObject()) {
         JsonObject var5 = var4.getAsJsonObject();
         String var6 = cloudSupport60.v2(var5, "quote");
         var3 = new GETSupport.Part13(
            cloudSupport60.v3(var5, "id"), cloudSupport60.v3(var5, "from"), cloudSupport60.v2(var5, "body"), var6.isEmpty() ? null : var6
         );
      }

      return new GETSupport.Part17(
         "m:" + var1,
         var1,
         cloudSupport60.v3(var0, "from"),
         cloudSupport60.v2(var0, "body"),
         v3(var0),
         var3,
         v1(var0, "edited_at"),
         v1(var0, "read_at"),
         v2(var0.get("waypoint")),
         v1(var0.get("invite"))
      );
   }

   @Nullable
   private static GETSupport.Part7 v1(@Nullable JsonElement var0) {
      if (var0 != null && var0.isJsonObject()) {
         JsonObject var1 = var0.getAsJsonObject();
         String var2 = cloudSupport60.v2(var1, "address");
         String var3 = cloudSupport60.v2(var1, "server");
         String var4 = cloudSupport60.v2(var1, "icon");
         return var2.isEmpty() ? null : new GETSupport.Part7(var2, var3.isEmpty() ? null : var3, var4.isEmpty() ? null : var4);
      } else {
         return null;
      }
   }

   @Nullable
   private static GETSupport.Part1 v2(@Nullable JsonElement var0) {
      if (var0 != null && var0.isJsonObject()) {
         JsonObject var1 = var0.getAsJsonObject();
         String var2 = cloudSupport60.v2(var1, "dim");
         if (!var2.isEmpty() && var1.has("x") && var1.has("y") && var1.has("z")) {
            String var3 = cloudSupport60.v2(var1, "address");
            String var4 = cloudSupport60.v2(var1, "server");
            return new GETSupport.Part1(
               (int)cloudSupport60.v3(var1, "x"),
               (int)cloudSupport60.v3(var1, "y"),
               (int)cloudSupport60.v3(var1, "z"),
               var2,
               var3.isEmpty() ? null : var3,
               var4.isEmpty() ? null : var4
            );
         } else {
            return null;
         }
      } else {
         return null;
      }
   }

   private static List<GETSupport.Part5> v3(@Nullable JsonElement var0) {
      if (var0 != null && !var0.isJsonNull()) {
         ArrayList var1 = new ArrayList();
         if (var0.isJsonObject()) {
            var1.add(new GETSupport.Part5(v1(var0.getAsJsonObject()), true));
         } else if (var0.isJsonArray()) {
            for (JsonElement var3 : var0.getAsJsonArray()) {
               if (var3.isJsonObject()) {
                  JsonObject var4 = var3.getAsJsonObject();
                  JsonElement var5 = var4.get("pin");
                  boolean var6 = var5 == null || !var5.isJsonObject() || cloudSupport60.v1(var5.getAsJsonObject(), "for_both", true);
                  var1.add(new GETSupport.Part5(v1(var4), var6));
               }
            }
         }

         return List.copyOf(var1);
      } else {
         return List.of();
      }
   }

   @Nullable
   private static Instant v1(JsonObject var0, String var1) {
      String var2 = cloudSupport60.v2(var0, var1);
      if (var2.isEmpty()) {
         return null;
      } else {
         try {
            return Instant.parse(var2);
         } catch (DateTimeParseException var4) {
            return null;
         }
      }
   }

   @Nullable
   private static String v2(JsonObject var0) {
      String var1 = cloudSupport60.v2(var0, "nonce");
      return var1.isEmpty() ? null : var1;
   }

   private static Instant v3(JsonObject var0) {
      String var1 = cloudSupport60.v2(var0, "created_at");
      if (var1.isEmpty()) {
         return Instant.EPOCH;
      } else {
         try {
            return Instant.parse(var1);
         } catch (DateTimeParseException var3) {
            return Instant.EPOCH;
         }
      }
   }

   private static List<JsonObject> v2(JsonObject var0, String var1) {
      JsonElement var2 = var0.get(var1);
      if (var2 != null && var2.isJsonArray()) {
         JsonArray var3 = var2.getAsJsonArray();
         ArrayList var4 = new ArrayList(var3.size());

         for (JsonElement var6 : var3) {
            if (var6.isJsonObject()) {
               var4.add(var6.getAsJsonObject());
            }
         }

         return var4;
      } else {
         return List.of();
      }
   }

   public record Part1(int x, int y, int z, String dimension, @Nullable String address, @Nullable String server) {
      public String v1() {
         return this.x + " " + this.y + " " + this.z;
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

      public String v5() {
         return this.dimension;
      }

      @Nullable
      public String v6() {
         return this.address;
      }

      @Nullable
      public String v7() {
         return this.server;
      }
   }

   public record Part10(long lastId, String lastBody, boolean lastMine, Instant lastAt, int unread, GETSupport.Part9 lastKind) {
      public long v1() {
         return this.lastId;
      }

      public String v2() {
         return this.lastBody;
      }

      public boolean v3() {
         return this.lastMine;
      }

      public Instant v4() {
         return this.lastAt;
      }

      public int v5() {
         return this.unread;
      }

      public GETSupport.Part9 v6() {
         return this.lastKind;
      }
   }

   public static final class Part11 {
      public final String v1;
      public final String v2;
      public final String v3;
      public final Instant v4;
      public final long v5;
      @Nullable
      public final GETSupport.Part13 v6;
      @Nullable
      public final GETSupport.Part1 v7;
      @Nullable
      public final GETSupport.Part7 v8;
      public long v9;
      public long v10;
      public long v11;
      public boolean v12;
      public boolean v13;

      public Part11(
         String var1, String var2, Instant var3, long var4, @Nullable GETSupport.Part13 var6, @Nullable GETSupport.Part1 var7, @Nullable GETSupport.Part7 var8
      ) {
         this.v1 = var1;
         this.v2 = "n:" + var1;
         this.v3 = var2;
         this.v4 = var3;
         this.v5 = var4;
         this.v6 = var6;
         this.v7 = var7;
         this.v8 = var8;
      }
   }

   public record Part12(int status, String code, String reason) {
      public boolean v1() {
         return this.status == 0 || this.status >= 500 || this.status == 429;
      }

      public int v2() {
         return this.status;
      }

      public String v3() {
         return this.code;
      }

      public String v4() {
         return this.reason;
      }
   }

   public record Part13(long id, long from, String body, @Nullable String fragment) {
      public long v1() {
         return this.id;
      }

      public long v2() {
         return this.from;
      }

      public String v3() {
         return this.body;
      }

      @Nullable
      public String v4() {
         return this.fragment;
      }
   }

   public record Part14(
      String key,
      long id,
      boolean mine,
      String body,
      Instant at,
      GETSupport.Part16 delivery,
      @Nullable GETSupport.Part18 reply,
      @Nullable Instant editedAt,
      @Nullable Instant readAt,
      @Nullable GETSupport.Part1 place,
      @Nullable GETSupport.Part7 invite
   ) {
      public GETSupport.Part9 v1() {
         return GETSupport.Part9.v1(this.place, this.invite);
      }

      public String v2() {
         return this.key;
      }

      public long v3() {
         return this.id;
      }

      public boolean v4() {
         return this.mine;
      }

      public String v5() {
         return this.body;
      }

      public Instant v6() {
         return this.at;
      }

      public GETSupport.Part16 v7() {
         return this.delivery;
      }

      @Nullable
      public GETSupport.Part18 v8() {
         return this.reply;
      }

      @Nullable
      public Instant v9() {
         return this.editedAt;
      }

      @Nullable
      public Instant v10() {
         return this.readAt;
      }

      @Nullable
      public GETSupport.Part1 v11() {
         return this.place;
      }

      @Nullable
      public GETSupport.Part7 v12() {
         return this.invite;
      }
   }

   public static enum Part15 {
      LOADING,
      READY,
      FAILED;

      private Part15() {
      }
   }

   public static enum Part16 {
      SENDING,
      SENT,
      READ,
      FAILED;

      private Part16() {
      }
   }

   public record Part17(
      String key,
      long id,
      long from,
      String body,
      Instant at,
      @Nullable GETSupport.Part13 quote,
      @Nullable Instant editedAt,
      @Nullable Instant readAt,
      @Nullable GETSupport.Part1 place,
      @Nullable GETSupport.Part7 invite
   ) {
      public GETSupport.Part17 v1(String var1) {
         return new GETSupport.Part17(var1, this.id, this.from, this.body, this.at, this.quote, this.editedAt, this.readAt, this.place, this.invite);
      }

      public GETSupport.Part17 v1(String var1, @Nullable Instant var2) {
         return new GETSupport.Part17(this.key, this.id, this.from, var1, this.at, this.quote, var2, this.readAt, this.place, this.invite);
      }

      public GETSupport.Part17 v1(@Nullable GETSupport.Part13 var1) {
         return new GETSupport.Part17(this.key, this.id, this.from, this.body, this.at, var1, this.editedAt, this.readAt, this.place, this.invite);
      }

      public GETSupport.Part17 v1(Instant var1) {
         return new GETSupport.Part17(this.key, this.id, this.from, this.body, this.at, this.quote, this.editedAt, var1, this.place, this.invite);
      }

      public GETSupport.Part9 v1() {
         return GETSupport.Part9.v1(this.place, this.invite);
      }

      public String v2() {
         return this.key;
      }

      public long v3() {
         return this.id;
      }

      public long v4() {
         return this.from;
      }

      public String v5() {
         return this.body;
      }

      public Instant v6() {
         return this.at;
      }

      @Nullable
      public GETSupport.Part13 v7() {
         return this.quote;
      }

      @Nullable
      public Instant v8() {
         return this.editedAt;
      }

      @Nullable
      public Instant v9() {
         return this.readAt;
      }

      @Nullable
      public GETSupport.Part1 v10() {
         return this.place;
      }

      @Nullable
      public GETSupport.Part7 v11() {
         return this.invite;
      }
   }

   public record Part18(long id, boolean mine, String body, @Nullable String quote) {
      public long v1() {
         return this.id;
      }

      public boolean v2() {
         return this.mine;
      }

      public String v3() {
         return this.body;
      }

      @Nullable
      public String v4() {
         return this.quote;
      }
   }

   public record Part2(long peer, boolean forBoth, long at) {
      public long v1() {
         return this.peer;
      }

      public boolean v2() {
         return this.forBoth;
      }

      public long v3() {
         return this.at;
      }
   }

   public static final class Part3 {
      public final long v1;
      public final TreeMap<Long, GETSupport.Part17> v2 = new TreeMap<>();
      public final List<GETSupport.Part11> v3 = new ArrayList<>();
      public GETSupport.Part15 v4 = GETSupport.Part15.LOADING;
      public String v5 = "";
      public boolean v6;
      public boolean v7;
      public boolean v8;
      public boolean v9;
      public long v10;
      public long v11;
      public long v12;
      public List<GETSupport.Part5> v13 = List.of();
      @Nullable
      public GETSupport.Part2 v14;
      public long v15;
      @Nullable
      public Consumer<String> v16;
      public long v18;
      public int v19;
      @Nullable
      public List<GETSupport.Part14> v17;
      public int v20 = -1;

      public Part3(long var1) {
         this.v1 = var1;
      }
   }

   public record Part4(long uid, String name, long avatar) {
      public long v1() {
         return this.uid;
      }

      public String v2() {
         return this.name;
      }

      public long v3() {
         return this.avatar;
      }
   }

   public record Part5(GETSupport.Part17 message, boolean forBoth) {
      public GETSupport.Part17 v1() {
         return this.message;
      }

      public boolean v2() {
         return this.forBoth;
      }
   }

   public record Part6(GETSupport.Part14 message, boolean forBoth) {
      public GETSupport.Part14 v1() {
         return this.message;
      }

      public boolean v2() {
         return this.forBoth;
      }
   }

   public record Part7(String address, @Nullable String server, @Nullable String icon) {
      public String v1() {
         return this.address;
      }

      @Nullable
      public String v2() {
         return this.server;
      }

      @Nullable
      public String v3() {
         return this.icon;
      }
   }

   public interface Part8 {
      void v1(String var1, String var2, @Nullable JsonObject var3, Consumer<JsonObject> var4, Consumer<GETSupport.Part12> var5);

      void v1(long var1, Runnable var3);
   }

   public static enum Part9 {
      WORDS,
      PLACE,
      INVITE;

      private Part9() {
      }

      public static GETSupport.Part9 v1(@Nullable GETSupport.Part1 var0, @Nullable GETSupport.Part7 var1) {
         return var0 != null ? PLACE : (var1 != null ? INVITE : WORDS);
      }
   }
}
