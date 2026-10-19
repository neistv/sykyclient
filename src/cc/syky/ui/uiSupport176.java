package cc.syky.ui;

import java.lang.Character.UnicodeScript;
import java.text.Normalizer;
import java.text.Normalizer.Form;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public final class uiSupport176 {
   private static final Set<String> v1 = v1(
      "pvp",
      "пвп",
      "бой",
      "боя",
      "бою",
      "боем",
      "бій",
      "walka",
      "walki",
      "walce",
      "walkę",
      "walką",
      "boj",
      "boji",
      "boje",
      "boju",
      "souboj",
      "souboji",
      "pelea",
      "lucha"
   );
   private static final List<String> v2 = List.copyOf(
      v1("combat", "комбат", "kampf", "gevecht", "harc", "lupt", "savaş", "çatışm", "relog", "antirelog", "релог", "антирелог")
   );
   private static final List<String[]> v3 = List.of(v1("боевой", "режим"), v1("бойовий", "режим"));
   private static final List<String> v4 = List.copyOf(v1("战斗", "戰鬥", "戦闘", "전투"));
   private static final Set<String> v5 = v1("off", "выкл", "вимк", "вне", "disabled", "kapalı", "finished", "fini", "terminé", "terminado", "terminada");
   private static final List<String> v6 = List.copyOf(
      v1(
         "inactiv",
         "inaktiv",
         "neaktiv",
         "nieaktyw",
         "неактив",
         "deaktiv",
         "desactiv",
         "desativ",
         "выключ",
         "отключ",
         "вимкн",
         "wyłącz",
         "vypnut",
         "закончен",
         "окончен",
         "завершен",
         "beendet"
      )
   );
   private static final List<String[]> v7 = List.of(
      v1("не", "в"), v1("не", "у"), v1("ні", "в"), v1("nie", "w"), v1("not", "in"), v1("no", "longer"), v1("no", "estas"), v1("nicht", "im")
   );
   private static final List<String[]> v8 = List.of(v1("не", "актив"), v1("ні", "актив"), v1("nie", "aktyw"), v1("not", "activ"));
   private static final List<String> v9 = List.copyOf(v1("protec", "защит", "захист", "ochron", "schutz", "grace"));

   private uiSupport176() {
   }

   public static boolean v1(String var0) {
      String var1 = v2(var0);
      List var2 = v3(var1);
      return v1(var1, var2) && !v1(var2, v9) ? v4(var1) || !v1(var2) : false;
   }

   private static boolean v1(String var0, List<String> var1) {
      for (int var2 = 0; var2 < var1.size(); var2++) {
         String var3 = (String)var1.get(var2);
         if (v1.contains(var3) || v2(var3, v2)) {
            return true;
         }

         if (var2 + 1 < var1.size() && v1(var1, var2, v3, false)) {
            return true;
         }
      }

      for (String var5 : v4) {
         if (var0.contains(var5)) {
            return true;
         }
      }

      return false;
   }

   private static boolean v1(List<String> var0) {
      if (v1(var0, v6)) {
         return true;
      } else {
         for (int var1 = 0; var1 < var0.size(); var1++) {
            String var2 = (String)var0.get(var1);
            if (v5.contains(var2)) {
               return true;
            }

            if (var1 + 1 < var0.size() && (v1(var0, var1, v7, false) || v1(var0, var1, v8, true))) {
               return true;
            }
         }

         return false;
      }
   }

   private static boolean v1(List<String> var0, int var1, List<String[]> var2, boolean var3) {
      String var4 = (String)var0.get(var1);
      String var5 = (String)var0.get(var1 + 1);

      for (String[] var7 : var2) {
         if (var4.equals(var7[0]) && (var3 ? var5.startsWith(var7[1]) : var5.equals(var7[1]))) {
            return true;
         }
      }

      return false;
   }

   private static boolean v4(String var0) {
      for (int var1 = 0; var1 < var0.length(); var1++) {
         if (Character.isDigit(var0.charAt(var1))) {
            return true;
         }
      }

      return false;
   }

   private static boolean v1(List<String> var0, List<String> var1) {
      for (String var3 : var0) {
         if (v2(var3, var1)) {
            return true;
         }
      }

      return false;
   }

   private static boolean v2(String var0, List<String> var1) {
      for (String var3 : var1) {
         if (var0.startsWith(var3)) {
            return true;
         }
      }

      return false;
   }

   public static String v2(String var0) {
      StringBuilder var1 = new StringBuilder(var0.length());

      for (int var2 = 0; var2 < var0.length(); var2++) {
         char var3 = var0.charAt(var2);
         if (var3 == 167) {
            var2++;
         } else {
            var1.append(var3);
         }
      }

      String var6 = Normalizer.normalize(var1, Form.NFKD);
      StringBuilder var7 = new StringBuilder(var6.length());
      int var4 = 0;

      while (var4 < var6.length()) {
         int var5 = var6.codePointAt(var4);
         var4 += Character.charCount(var5);
         if (Character.getType(var5) != 6) {
            var7.appendCodePoint(v1(var5));
         }
      }

      return var7.toString().toLowerCase(Locale.ROOT);
   }

   private static int v1(int var0) {
      return switch (var0) {
         case 305, 618 -> 105;
         case 321, 322, 671 -> 108;
         case 610 -> 103;
         case 628 -> 110;
         case 640 -> 114;
         case 655 -> 121;
         case 665 -> 98;
         case 668 -> 104;
         case 7424 -> 97;
         case 7428 -> 99;
         case 7429 -> 100;
         case 7431 -> 101;
         case 7434 -> 106;
         case 7435 -> 107;
         case 7437 -> 109;
         case 7439 -> 111;
         case 7448 -> 112;
         case 7451 -> 116;
         case 7452 -> 117;
         case 7456 -> 118;
         case 7457 -> 119;
         case 7458 -> 122;
         case 42800 -> 102;
         case 42801 -> 115;
         default -> var0;
      };
   }

   public static List<String> v3(String var0) {
      ArrayList var1 = new ArrayList();
      int var2 = -1;
      UnicodeScript var3 = null;
      int var4 = 0;

      while (var4 < var0.length()) {
         int var5 = var0.codePointAt(var4);
         boolean var6 = Character.isLetter(var5);
         UnicodeScript var7 = var6 ? UnicodeScript.of(var5) : null;
         if (var2 >= 0 && (!var6 || var7 != var3)) {
            var1.add(var0.substring(var2, var4));
            var2 = -1;
         }

         if (var6 && var2 < 0) {
            var2 = var4;
            var3 = var7;
         }

         var4 += Character.charCount(var5);
      }

      if (var2 >= 0) {
         var1.add(var0.substring(var2));
      }

      return var1;
   }

   private static Set<String> v1(String... var0) {
      return Stream.of(var0).map(uiSupport176::v2).collect(Collectors.toUnmodifiableSet());
   }

   private static String[] v1(String var0, String var1) {
      return new String[]{v2(var0), v2(var1)};
   }
}
