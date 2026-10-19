package cc.syky.cloud;

import cc.syky.render.renderSupport43;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Map.Entry;
import java.util.function.Supplier;
import net.minecraft.class_310;
import net.minecraft.class_327;
import net.minecraft.class_332;
import net.minecraft.class_9779;

public final class cloudSupport54 {
   private static final int v1 = -1073741824;
   private static final int v2 = -3355444;
   private static final int v3 = -1;
   private static final int v4 = -40864;
   private static final int v5 = -10040065;
   private static final double v6 = 4.0;
   private static final double v7 = 33.3;
   private static final long v8 = 1L;
   private static final long v9 = 200L;
   private static final int v10 = 4;
   private static final int v11 = 4;
   private static final int v12 = 1;
   private static final String v13 = "section                        n   p50    p95    p99    mean";
   private final cloudSupport53 v14;
   private final Supplier<renderSupport43.Part1> v15;
   private volatile boolean v16;
   private long v18;
   private List<cloudSupport54.Part1> v19 = List.of();
   private String v17 = "";

   public cloudSupport54(cloudSupport53 var1, Supplier<renderSupport43.Part1> var2) {
      this.v14 = var1;
      this.v15 = var2;
   }

   public boolean v1() {
      return this.v16;
   }

   public void v1(boolean var1) {
      this.v16 = var1;
   }

   public void v1(class_332 var1, class_9779 var2) {
      if (this.v16) {
         class_310 var3 = class_310.method_1551();
         if (var3 != null) {
            long var4 = System.currentTimeMillis();
            if (var4 - this.v18 >= 200L || this.v19.isEmpty()) {
               this.v19 = this.v3();
               this.v17 = this.v2();
               this.v18 = var4;
            }

            class_327 var6 = var3.field_1772;
            int var7 = 9 + 1;
            int var8 = this.v19.size();
            int var9 = Math.max(var6.method_1727("section                        n   p50    p95    p99    mean"), var6.method_1727(this.v17)) + 8;
            int var10 = var7 * (var8 + 2) + 8;
            int var11 = var3.method_22683().method_4486();
            int var12 = var11 - var9 - 4;
            byte var13 = 4;
            var1.method_25294(var12, var13, var12 + var9, var13 + var10, -1073741824);
            int var14 = var12 + 4;
            int var15 = var13 + 4;
            var1.method_51433(var6, "section                        n   p50    p95    p99    mean", var14, var15, -3355444, false);
            var15 += var7;

            for (cloudSupport54.Part1 var17 : this.v19) {
               int var18 = var17.warn ? -40864 : -1;
               var1.method_51433(var6, var17.line, var14, var15, var18, false);
               var15 += var7;
            }

            var1.method_51433(var6, this.v17, var14, var15, -10040065, false);
         }
      }
   }

   private String v2() {
      renderSupport43.Part1 var1 = this.v15.get();
      return "batch2d  " + (var1 == null ? "n/a" : var1.v2());
   }

   private List<cloudSupport54.Part1> v3() {
      Map var1 = this.v14.v3();
      ArrayList var2 = new ArrayList(var1.size());

      for (Entry var4 : var1.entrySet()) {
         cloudRecord7 var5 = (cloudRecord7)var4.getValue();
         if (var5.v5() >= 1L) {
            String var6 = v1((String)var4.getKey(), var5);
            boolean var7 = var5.v4() >= v1((String)var4.getKey());
            var2.add(new cloudSupport54.Part1(var6, var5, var7));
         }
      }

      var2.sort(Comparator.<cloudSupport54.Part1>comparingLong(var0 -> var0.snap.v11()).reversed());
      return var2;
   }

   private static double v1(String var0) {
      return "frame.total".equals(var0) ? 33.3 : 4.0;
   }

   private static String v1(String var0, cloudRecord7 var1) {
      return String.format(
         Locale.ROOT,
         "%-30s %3d %5.2f %5.2f %5.2f %6.2f",
         v1(var0, 30),
         Math.min(var1.v5(), 999L),
         var1.v9() / 1000000.0,
         var1.v10() / 1000000.0,
         var1.v4(),
         var1.v3()
      );
   }

   private static String v1(String var0, int var1) {
      return var0.length() <= var1 ? var0 : var0.substring(0, var1 - 1) + "…";
   }

   public record Part1(String line, cloudRecord7 snap, boolean warn) {

      public String v1() {
         return this.line;
      }

      public cloudRecord7 v2() {
         return this.snap;
      }

      public boolean v3() {
         return this.warn;
      }
   }
}
