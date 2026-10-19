package cc.syky.module.visual;

import cc.syky.config.configRecord2;
import cc.syky.config.configSupport13;
import java.util.EnumSet;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;
import java.util.Map.Entry;
import java.util.concurrent.ConcurrentHashMap;
import net.minecraft.class_2561;
import net.minecraft.class_2960;
import net.minecraft.class_5250;
import net.minecraft.class_11719.class_11721;
import org.jetbrains.annotations.Nullable;

public final class visualSupport16 {
   public static boolean v1;
   public static boolean v2 = true;
   public static boolean v3 = true;
   public static boolean v4 = true;
   public static NethPotSupport v5 = NethPotSupport.VANILLA;
   public static WhenNotSupport v6 = WhenNotSupport.NOT_FOUND;
   public static final EnumSet<CISSupport> v7 = EnumSet.allOf(CISSupport.class);
   private static final CISSupport[] v8 = CISSupport.values();
   private static final Map<UUID, visualSupport16.Part2> v9 = new ConcurrentHashMap<>();
   private static final int v10 = 512;
   private static volatile int v11 = -1;
   private static final class_2960 v12 = class_2960.method_60655("syky", "tiers");
   private static final int v13 = 11184810;
   private static final int v14 = 10671871;
   private static final int v15 = 13882323;
   private static final Map<String, Integer> v16 = Map.ofEntries(
      Map.entry("HT1", 15252026),
      Map.entry("LT1", 14005077),
      Map.entry("HT2", 12899303),
      Map.entry("LT2", 10528690),
      Map.entry("HT3", 16293722),
      Map.entry("LT3", 13007682),
      Map.entry("HT4", 8483994),
      Map.entry("LT4", 6642553),
      Map.entry("HT5", 9405096),
      Map.entry("LT5", 6642553)
   );

   private visualSupport16() {
   }

   public static void v1() {
      v9.clear();
   }

   @Nullable
   public static class_2561 v1(UUID var0, @Nullable String var1) {
      int var2 = configSupport13.v2();
      if (var2 != v11) {
         v9.clear();
         v11 = var2;
      }

      visualSupport16.Part2 var3 = v9.get(var0);
      if (var3 != null && var3.v1() == var2) {
         return var3.v2().orElse(null);
      } else {
         visualSupport16.Part3 var4 = v2(var0, var1);
         if (var4.v2()) {
            if (v9.size() >= 512) {
               v9.clear();
            }

            v9.put(var0, new visualSupport16.Part2(var2, Optional.ofNullable(var4.v1())));
         }

         return var4.v1();
      }
   }

   private static visualSupport16.Part3 v2(UUID var0, @Nullable String var1) {
      class_5250 var2 = null;
      boolean var3 = true;

      for (CISSupport var7 : v8) {
         if (v7.contains(var7)) {
            Optional var8 = configSupport13.v1(var7, var0, var1);
            if (var8.isEmpty()) {
               var3 = false;
            } else {
               visualSupport16.Part1 var9 = v1((Map<String, configRecord2>)var8.get());
               if (var9 != null) {
                  if (var2 == null) {
                     var2 = class_2561.method_43473();
                  } else {
                     var2.method_10852(class_2561.method_43470(" "));
                  }

                  NethPotSupport var10 = v2 ? var9.v1() : null;
                  String var11 = var7.v2();
                  if (var11 != null) {
                     String var12 = var10 != null ? var11 : var11 + " ";
                     var2.method_10852(class_2561.method_43470(var12).method_27694(var0x -> var0x.method_36139(11184810)));
                  }

                  if (var10 != null) {
                     var2.method_10852(v1(var10));
                  }

                  var2.method_10852(v1(var9.v2()));
               }
            }
         }
      }

      if (var2 == null) {
         return new visualSupport16.Part3(null, var3);
      } else {
         var2.method_10852(class_2561.method_43470(" | ").method_27694(var0x -> var0x.method_36139(11184810)));
         return new visualSupport16.Part3(var2, var3);
      }
   }

   @Nullable
   private static visualSupport16.Part1 v1(Map<String, configRecord2> var0) {
      if (var0.isEmpty()) {
         return null;
      } else {
         configRecord2 var1 = v1(var0, v5);
         visualSupport16.Part1 var2 = v2(var0);
         if (var1 == null) {
            return v6 != WhenNotSupport.NEVER ? var2 : null;
         } else {
            return v6 == WhenNotSupport.ALWAYS && var2 != null ? var2 : new visualSupport16.Part1(v5, var1);
         }
      }
   }

   @Nullable
   private static configRecord2 v1(Map<String, configRecord2> var0, NethPotSupport var1) {
      for (String var5 : var1.v3()) {
         configRecord2 var6 = (configRecord2)var0.get(var5);
         if (var6 != null) {
            return var6;
         }
      }

      return null;
   }

   @Nullable
   private static visualSupport16.Part1 v2(Map<String, configRecord2> var0) {
      String var1 = null;
      configRecord2 var2 = null;
      int var3 = Integer.MAX_VALUE;

      for (Entry var5 : var0.entrySet()) {
         int var6 = ((configRecord2)var5.getValue()).v1();
         if (var6 < var3) {
            var3 = var6;
            var2 = (configRecord2)var5.getValue();
            var1 = (String)var5.getKey();
         }
      }

      return var2 == null ? null : new visualSupport16.Part1(NethPotSupport.v2(var1), var2);
   }

   private static class_2561 v1(NethPotSupport var0) {
      return class_2561.method_43470(String.valueOf(var0.v2())).method_27694(var0x -> var0x.method_27704(new class_11721(v12)));
   }

   private static class_2561 v1(configRecord2 var0) {
      if (!var0.v6()) {
         return v1(var0.v2(), var0.v3(), false);
      } else {
         return var0.v4() != null && var0.v5() != null ? v1(var0.v4(), var0.v5(), true) : v1(var0.v2(), var0.v3(), true);
      }
   }

   private static class_2561 v1(int var0, boolean var1, boolean var2) {
      String var3 = (var2 ? "R" : "") + (var1 ? "H" : "L") + "T" + var0;
      int var4 = var2 ? 10671871 : v16.getOrDefault(var3, 13882323);
      return class_2561.method_43470(var3).method_27694(var1x -> var1x.method_36139(var4));
   }

   public record Part1(@Nullable NethPotSupport mode, configRecord2 ranking) {
      @Nullable
      public NethPotSupport v1() {
         return this.mode;
      }

      public configRecord2 v2() {
         return this.ranking;
      }
   }

   public record Part2(int revision, Optional<class_2561> prefix) {
      public int v1() {
         return this.revision;
      }

      public Optional<class_2561> v2() {
         return this.prefix;
      }
   }

   public record Part3(@Nullable class_2561 prefix, boolean settled) {
      @Nullable
      public class_2561 v1() {
         return this.prefix;
      }

      public boolean v2() {
         return this.settled;
      }
   }
}
