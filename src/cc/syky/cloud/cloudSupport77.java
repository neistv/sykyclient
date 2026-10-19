package cc.syky.cloud;

import cc.syky.hud.hudSupport75;
import cc.syky.module.ModuleContract;
import cc.syky.ui.uiSupport226;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import org.jetbrains.annotations.Nullable;

public final class cloudSupport77 implements cloudSupport82 {
   private static final String v1 = "list";
   private static final String v2 = "none";
   private final hudSupport75 v3;
   private final uiSupport226 v4;

   public cloudSupport77(hudSupport75 var1, uiSupport226 var2) {
      this.v3 = var1;
      this.v4 = var2;
   }

   @Override
   public String v1() {
      return "bind";
   }

   @Override
   public String v2() {
      return "bind <module> [toggle|hold] <key>|none | bind <module> | bind list";
   }

   @Override
   public void v1(cloudSupport81 var1, List<String> var2) {
      switch (v1(var2)) {
         case cloudSupport77.Part1.Part3 var5:
            var1.v2(var5.v1());
            break;
         case cloudSupport77.Part1.Part2 var6:
            this.v1(var1);
            break;
         case cloudSupport77.Part1.Part5 var7:
            this.v1(var1, var7.v1());
            break;
         case cloudSupport77.Part1.Part4 var8:
            this.v1(var1, var8.v1(), var8.v2());
            break;
         case cloudSupport77.Part1.Part6 var9:
            this.v2(var1, var9.v1(), var9.v2());
            break;
         case cloudSupport77.Part1.Part1 var10:
            this.v1(var1, var10.v1(), var10.v2(), var10.v3());
            break;
         default:
            throw new MatchException(null, null);
      }
   }

   public static cloudSupport77.Part1 v1(List<String> var0) {
      if (var0.isEmpty()) {
         return v3();
      } else if (var0.size() == 1 && "list".equalsIgnoreCase((String)var0.get(0))) {
         return new cloudSupport77.Part1.Part2();
      } else {
         String var1 = (String)var0.get(0);
         List var2 = var0.subList(1, var0.size());

         return (cloudSupport77.Part1)(switch (var2.size()) {
            case 0 -> new cloudSupport77.Part1.Part5(var1);
            case 1 -> v1(var1, (String)var2.get(0));
            case 2 -> v1(var1, (String)var2.get(0), (String)var2.get(1));
            default -> v3();
         });
      }
   }

   private static cloudSupport77.Part1 v1(String var0, String var1) {
      cloudSupport96 var2 = cloudSupport96.v1(var1, null);
      if (var2 != null) {
         return new cloudSupport77.Part1.Part6(var0, var2);
      } else {
         return (cloudSupport77.Part1)("none".equalsIgnoreCase(var1)
            ? new cloudSupport77.Part1.Part4(var0, null)
            : cloudSupport94.v2(var1).map(var1x -> new cloudSupport77.Part1.Part1(var0, var1x, null)).orElseGet(() -> v1(var1)));
      }
   }

   private static cloudSupport77.Part1 v1(String var0, String var1, String var2) {
      boolean var3 = cloudSupport96.v1(var1);
      boolean var4 = cloudSupport96.v1(var2);
      if (var3 && var4) {
         return new cloudSupport77.Part1.Part3("expected a key after " + var1.toLowerCase(Locale.ROOT) + ", got a mode");
      } else if (!var3 && !var4) {
         return new cloudSupport77.Part1.Part3("expected " + v4() + " next to the key");
      } else {
         cloudSupport96 var5 = cloudSupport96.v1(var3 ? var1 : var2, null);
         String var6 = var3 ? var2 : var1;
         return (cloudSupport77.Part1)("none".equalsIgnoreCase(var6)
            ? new cloudSupport77.Part1.Part4(var0, var5)
            : cloudSupport94.v2(var6).map(var2x -> new cloudSupport77.Part1.Part1(var0, var2x, var5)).orElseGet(() -> v1(var6)));
      }
   }

   private static cloudSupport77.Part1 v3() {
      return new cloudSupport77.Part1.Part3("usage: bind <module> [toggle|hold] <key>|none | bind <module> | bind list");
   }

   private static cloudSupport77.Part1 v1(String var0) {
      return new cloudSupport77.Part1.Part3("unknown key: " + var0);
   }

   private static String v4() {
      return String.join("|", cloudSupport96.LABELS);
   }

   private void v1(cloudSupport81 var1, String var2) {
      ModuleContract var3 = this.v2(var2);
      if (var3 == null) {
         var1.v2(v3(var2));
      } else {
         cloudRecord11 var4 = this.v3.v3(var3.getName()).orElse(null);
         if (var4 == null) {
            var1.v1(var3.getName() + " — not bound (" + v4() + " + a key to bind it)");
         } else {
            var1.v1(v1(var4));
         }
      }
   }

   private void v1(cloudSupport81 var1, String var2, @Nullable cloudSupport96 var3) {
      ModuleContract var4 = this.v2(var2);
      if (var4 == null) {
         var1.v2(v3(var2));
      } else {
         if (var3 == null) {
            this.v3.v4(var4.getName());
         } else {
            this.v3.v1(var4.getName(), cloudRecord10.v1(-1), var3);
         }

         var1.v1("unbound " + var4.getName());
      }
   }

   private void v2(cloudSupport81 var1, String var2, cloudSupport96 var3) {
      ModuleContract var4 = this.v2(var2);
      if (var4 == null) {
         var1.v2(v3(var2));
      } else {
         cloudRecord11 var5 = this.v3.v3(var4.getName()).orElse(null);
         if (var5 == null) {
            this.v3.v1(var4.getName(), cloudRecord10.v1(-1), var3);
            var1.v1(var4.getName() + " set to " + var3.v1() + " — not bound to a key yet");
         } else {
            this.v3.v1(var4.getName(), var5.v1(), var3);
            var1.v1(v1(this.v3.v3(var4.getName()).orElseThrow()));
         }
      }
   }

   private void v1(cloudSupport81 var1, String var2, cloudRecord10 var3, @Nullable cloudSupport96 var4) {
      ModuleContract var5 = this.v2(var2);
      if (var5 == null) {
         var1.v2(v3(var2));
      } else {
         if (var4 == null) {
            this.v3.v1(var5.getName(), var3);
         } else {
            this.v3.v1(var5.getName(), var3, var4);
         }

         var1.v1("bound " + v1(this.v3.v3(var5.getName()).orElseThrow()));
      }
   }

   private void v1(cloudSupport81 var1) {
      ArrayList var2 = new ArrayList<>(this.v3.v6());
      var2.sort((var0, var1x) -> var0.v2().compareToIgnoreCase(var1x.v2()));
      if (var2.isEmpty()) {
         var1.v1("no binds");
      } else {
         for (cloudRecord11 var4 : var2) {
            var1.v1(v1(var4));
         }
      }
   }

   private static String v1(cloudRecord11 var0) {
      return var0.v2() + " → " + cloudSupport94.v1(var0.v1()) + " [" + var0.v5().v1() + "]";
   }

   @Nullable
   private ModuleContract v2(String var1) {
      ModuleContract var2 = this.v4.v6(var1);
      if (var2 != null) {
         return var2;
      } else {
         for (ModuleContract var4 : this.v4.v1()) {
            if (var4.getName().equalsIgnoreCase(var1)) {
               return var4;
            }
         }

         return null;
      }
   }

   private static String v3(String var0) {
      return "unknown module: " + var0;
   }

   @Override
   public List<String> v1(List<String> var1, int var2, String var3) {
      String var4 = var3 == null ? "" : var3.toLowerCase(Locale.ROOT);

      return switch (var2) {
         case 0 -> this.v4(var4);
         case 1 -> v1(v1(cloudSupport96.LABELS, var4), v5(var4));
         case 2 -> {
            boolean var5 = !var1.isEmpty() && cloudSupport96.v1((String)var1.get(var1.size() - 1));
            yield var5 ? v5(var4) : v1(cloudSupport96.LABELS, var4);
         }
         default -> List.of();
      };
   }

   private List<String> v4(String var1) {
      ArrayList var2 = new ArrayList();

      for (ModuleContract var4 : this.v4.v1()) {
         if (var4.getName().toLowerCase(Locale.ROOT).startsWith(var1)) {
            var2.add(var4.getName());
         }
      }

      var2.sort(null);
      if ("list".startsWith(var1)) {
         var2.add(0, "list");
      }

      return var2;
   }

   private static List<String> v5(String var0) {
      return var0.isEmpty() ? List.of() : v1(cloudSupport94.v2(), var0);
   }

   private static List<String> v1(List<String> var0, String var1) {
      ArrayList var2 = new ArrayList();

      for (String var4 : var0) {
         if (var4.startsWith(var1)) {
            var2.add(var4);
         }
      }

      return var2;
   }

   private static List<String> v1(List<String> var0, List<String> var1) {
      if (var1.isEmpty()) {
         return var0;
      } else {
         ArrayList var2 = new ArrayList(var0);
         var2.addAll(var1);
         return var2;
      }
   }

   public sealed interface Part1
      permits cloudSupport77.Part1.Part3,
      cloudSupport77.Part1.Part2,
      cloudSupport77.Part1.Part5,
      cloudSupport77.Part1.Part4,
      cloudSupport77.Part1.Part6,
      cloudSupport77.Part1.Part1 {
      public record Part1(String module, cloudRecord10 key, @Nullable cloudSupport96 mode) implements cloudSupport77.Part1 {
         public String v1() {
            return this.module;
         }

         public cloudRecord10 v2() {
            return this.key;
         }

         @Nullable
         public cloudSupport96 v3() {
            return this.mode;
         }
      }

      public record Part2() implements cloudSupport77.Part1 {
      }

      public record Part3(String message) implements cloudSupport77.Part1 {
         public String v1() {
            return this.message;
         }
      }

      public record Part4(String module, @Nullable cloudSupport96 mode) implements cloudSupport77.Part1 {
         public String v1() {
            return this.module;
         }

         @Nullable
         public cloudSupport96 v2() {
            return this.mode;
         }
      }

      public record Part5(String module) implements cloudSupport77.Part1 {
         public String v1() {
            return this.module;
         }
      }

      public record Part6(String module, cloudSupport96 mode) implements cloudSupport77.Part1 {
         public String v1() {
            return this.module;
         }

         public cloudSupport96 v2() {
            return this.mode;
         }
      }
   }
}
