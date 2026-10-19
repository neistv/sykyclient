package cc.syky.cloud;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Optional;
import java.util.OptionalInt;
import java.util.Map.Entry;
import org.jetbrains.annotations.Nullable;

public final class cloudSupport94 {
   public static final int v1 = -1;
   public static final int v2 = 1;
   public static final int v3 = 2;
   public static final int v4 = 4;
   public static final int v5 = 8;
   public static final int v6 = 15;
   public static final int v7 = 340;
   public static final int v8 = 341;
   public static final int v9 = 342;
   public static final int v10 = 343;
   public static final int v11 = 344;
   public static final int v12 = 345;
   public static final int v13 = 346;
   public static final int v14 = 347;
   public static final int v15 = 32;
   public static final int v16 = 39;
   public static final int v18 = 44;
   public static final int v19 = 45;
   public static final int v17 = 46;
   public static final int v20 = 47;
   public static final int v21 = 48;
   public static final int v22 = 49;
   public static final int v24 = 57;
   public static final int v25 = 59;
   public static final int v26 = 61;
   public static final int v27 = 65;
   public static final int v28 = 67;
   public static final int v29 = 68;
   public static final int v30 = 70;
   public static final int v32 = 72;
   public static final int v23 = 83;
   public static final int v33 = 86;
   public static final int v31 = 87;
   public static final int v34 = 88;
   public static final int v36 = 89;
   public static final int v38 = 90;
   public static final int v42 = 91;
   public static final int v43 = 92;
   public static final int v37 = 93;
   public static final int v48 = 96;
   public static final int v40 = 256;
   public static final int v44 = 257;
   public static final int v47 = 258;
   public static final int v49 = 259;
   public static final int v46 = 260;
   public static final int v51 = 261;
   public static final int v50 = 262;
   public static final int v60 = 263;
   public static final int v59 = 264;
   public static final int v53 = 265;
   public static final int v63 = 266;
   public static final int v64 = 267;
   public static final int v61 = 268;
   public static final int v66 = 269;
   public static final int v68 = 280;
   public static final int v52 = 290;
   public static final int v75 = 320;
   public static final int v73 = 330;
   public static final int v74 = 331;
   public static final int v72 = 332;
   public static final int v80 = 333;
   public static final int v84 = 334;
   public static final int v94 = 335;
   public static final int v82 = 0;
   public static final int v99 = 1;
   public static final int v120 = 2;
   public static final int v88 = 65536;
   public static final int v103 = 8;
   private static final Map<String, Integer> v101;
   private static final Map<Integer, String> v96;
   private static final List<String> v105;

   private cloudSupport94() {
   }

   public static int v1(int var0) {
      return 65536 | var0;
   }

   public static boolean v2(int var0) {
      return var0 != -1 && (var0 & 65536) != 0;
   }

   public static int v3(int var0) {
      return var0 & -65537;
   }

   public static char v4(int var0) {
      return var0 >= 65 && var0 <= 90 ? (char)(var0 + 32) : (char)var0;
   }

   public static OptionalInt v1(String var0) {
      if (var0 == null) {
         return OptionalInt.empty();
      } else {
         Integer var1 = v101.get(var0.toLowerCase(Locale.ROOT));
         return var1 != null ? OptionalInt.of(var1) : OptionalInt.empty();
      }
   }

   public static Optional<String> v5(int var0) {
      return var0 == -1 ? Optional.empty() : Optional.ofNullable(v96.get(var0));
   }

   public static int v1() {
      return v101.size();
   }

   public static List<String> v2() {
      return v105;
   }

   public static Optional<cloudRecord10> v2(String var0) {
      if (var0 != null && !var0.isBlank()) {
         String[] var1 = var0.toLowerCase(Locale.ROOT).split("\\+");
         int var2 = 0;
         Integer var3 = null;

         for (String var7 : var1) {
            String var8 = var7.trim();
            if (var8.isEmpty()) {
               return Optional.empty();
            }

            Integer var9 = v3(var8);
            if (var9 != null) {
               var2 |= var9;
            } else {
               if (var3 != null) {
                  return Optional.empty();
               }

               Integer var10 = v101.get(var8);
               if (var10 == null) {
                  return Optional.empty();
               }

               var3 = var10;
            }
         }

         return var3 == null ? Optional.empty() : Optional.of(new cloudRecord10(var3, var2));
      } else {
         return Optional.empty();
      }
   }

   @Nullable
   private static Integer v3(String var0) {
      return switch (var0) {
         case "shift" -> 1;
         case "ctrl", "control" -> 2;
         case "alt" -> 4;
         case "super", "win", "cmd" -> 8;
         default -> null;
      };
   }

   public static String v1(cloudRecord10 var0) {
      if (var0.v1() == -1) {
         return "none";
      } else {
         String var1 = v96.get(var0.v1());
         if (var1 == null) {
            var1 = "?" + var0.v1();
         }

         return v6(var0.v2()) + var1;
      }
   }

   private static String v6(int var0) {
      if (var0 == 0) {
         return "";
      } else {
         StringBuilder var1 = new StringBuilder();
         if ((var0 & 1) != 0) {
            var1.append("shift+");
         }

         if ((var0 & 2) != 0) {
            var1.append("ctrl+");
         }

         if ((var0 & 4) != 0) {
            var1.append("alt+");
         }

         if ((var0 & 8) != 0) {
            var1.append("super+");
         }

         return var1.toString();
      }
   }

   public static String v2(cloudRecord10 var0) {
      if (v2(var0.v1())) {
         return v6(var0.v2()) + "M" + (v3(var0.v1()) + 1);
      } else {
         String var1 = v1(var0);
         return var0.v2() == 0 && var1.length() <= 3 ? var1.toUpperCase(Locale.ROOT) : var1;
      }
   }

   static {
      HashMap var0 = new HashMap();

      for (int var1 = 0; var1 < 26; var1++) {
         var0.put(String.valueOf((char)(97 + var1)), 65 + var1);
      }

      for (int var4 = 0; var4 < 10; var4++) {
         var0.put(String.valueOf((char)(48 + var4)), 48 + var4);
      }

      for (int var5 = 1; var5 <= 12; var5++) {
         var0.put("f" + var5, 290 + var5 - 1);
      }

      for (int var6 = 13; var6 <= 25; var6++) {
         var0.put("f" + var6, 290 + var6 - 1);
      }

      for (int var7 = 0; var7 <= 9; var7++) {
         var0.put("kp" + var7, 320 + var7);
      }

      var0.put("world1", 161);
      var0.put("world2", 162);
      var0.put("space", 32);
      var0.put("apostrophe", 39);
      var0.put("comma", 44);
      var0.put("minus", 45);
      var0.put("period", 46);
      var0.put("slash", 47);
      var0.put("semicolon", 59);
      var0.put("equal", 61);
      var0.put("lbracket", 91);
      var0.put("backslash", 92);
      var0.put("rbracket", 93);
      var0.put("grave", 96);
      var0.put("escape", 256);
      var0.put("enter", 257);
      var0.put("tab", 258);
      var0.put("backspace", 259);
      var0.put("insert", 260);
      var0.put("delete", 261);
      var0.put("right", 262);
      var0.put("left", 263);
      var0.put("down", 264);
      var0.put("up", 265);
      var0.put("pgup", 266);
      var0.put("pgdown", 267);
      var0.put("home", 268);
      var0.put("end", 269);
      var0.put("capslock", 280);
      var0.put("scrolllock", 281);
      var0.put("numlock", 282);
      var0.put("printscreen", 283);
      var0.put("pause", 284);
      var0.put("kp_decimal", 330);
      var0.put("kp_divide", 331);
      var0.put("kp_multiply", 332);
      var0.put("kp_subtract", 333);
      var0.put("kp_add", 334);
      var0.put("kp_enter", 335);
      var0.put("kp_equal", 336);
      var0.put("lshift", 340);
      var0.put("lctrl", 341);
      var0.put("lalt", 342);
      var0.put("lsuper", 343);
      var0.put("rshift", 344);
      var0.put("rctrl", 345);
      var0.put("ralt", 346);
      var0.put("rsuper", 347);
      var0.put("menu", 348);

      for (int var8 = 0; var8 < 8; var8++) {
         var0.put("mouse" + (var8 + 1), 65536 | var8);
      }

      v101 = Collections.unmodifiableMap(var0);
      HashMap var9 = new HashMap();

      for (Entry var3 : v101.entrySet()) {
         var9.putIfAbsent((Integer)var3.getValue(), (String)var3.getKey());
      }

      v96 = Collections.unmodifiableMap(var9);
      ArrayList var10 = new ArrayList<>(v101.keySet());
      var10.sort(null);
      v105 = List.copyOf(var10);
   }
}
