package cc.syky;

import java.nio.charset.StandardCharsets;
import java.util.Locale;
import java.util.zip.CRC32;
import org.jetbrains.annotations.Nullable;

public record LANRecord(String kind, String id) {
   private static final String DEFAULT_PORT = ":25565";
   private static final int MAX_STEM = 80;

   public LANRecord(String kind, String id) {
      if (kind != null && !kind.isEmpty() && id != null && !id.isEmpty()) {
         this.kind = kind;
         this.id = id;
      } else {
         throw new IllegalArgumentException("a world key needs a kind and an id");
      }
   }

   public static LANRecord v1(String var0) {
      return new LANRecord("server", v7(var0));
   }

   public static LANRecord v2(String var0) {
      String var1 = var0 == null ? "" : var0.trim();
      int var2 = var1.lastIndexOf(58);
      if (var2 > 0 && var1.indexOf(58) == var2 && v6(var1.substring(var2 + 1))) {
         var1 = var1.substring(0, var2);
      }

      return new LANRecord("lan", var1.isEmpty() ? "lan" : var1);
   }

   private static boolean v6(String var0) {
      if (var0.isEmpty()) {
         return false;
      } else {
         for (int var1 = 0; var1 < var0.length(); var1++) {
            if (var0.charAt(var1) < '0' || var0.charAt(var1) > '9') {
               return false;
            }
         }

         return true;
      }
   }

   public static LANRecord v3(String var0) {
      return new LANRecord("realm", var0.trim().isEmpty() ? "realm" : var0.trim());
   }

   public static LANRecord v4(String var0) {
      return new LANRecord("world", var0.trim().isEmpty() ? "world" : var0.trim());
   }

   private static String v7(String var0) {
      String var1 = var0 == null ? "" : var0.trim().toLowerCase(Locale.ROOT);
      if (var1.endsWith(":25565")) {
         var1 = var1.substring(0, var1.length() - ":25565".length());
      }

      while (var1.endsWith(".")) {
         var1 = var1.substring(0, var1.length() - 1);
      }

      return var1.isEmpty() ? "unknown" : var1;
   }

   public String v1() {
      StringBuilder var1 = new StringBuilder(this.kind.length() + 1 + this.id.length());
      var1.append(this.kind).append('-');
      boolean var2 = false;
      int var3 = 0;

      while (var3 < this.id.length()) {
         int var4 = this.id.codePointAt(var3);
         var3 += Character.charCount(var4);
         if (var4 >= 32 && var4 != 127 && "<>:\"/\\|?*".indexOf(var4) < 0) {
            var1.appendCodePoint(var4);
         } else {
            var1.append('_');
            var2 = true;
         }
      }

      for (var3 = var1.length(); var3 > this.kind.length() + 1 && (var1.charAt(var3 - 1) == '.' || var1.charAt(var3 - 1) == ' '); var2 = true) {
         var3--;
      }

      var1.setLength(var3);
      if (var1.length() > 80) {
         int var6 = Character.isHighSurrogate(var1.charAt(79)) ? 79 : 80;
         var1.setLength(var6);
         var2 = true;
      }

      if (var2) {
         CRC32 var7 = new CRC32();
         var7.update(this.id.getBytes(StandardCharsets.UTF_8));
         var1.append('~').append(String.format(Locale.ROOT, "%08x", var7.getValue()));
      }

      return var1.toString();
   }

   public String v2() {
      return this.kind + " " + this.id;
   }

   public String v3() {
      String var1 = this.kind;

      return switch (var1) {
         case "realm" -> "Realm " + this.id;
         case "lan" -> "LAN " + this.id;
         default -> this.id;
      };
   }

   @Nullable
   public static LANRecord v5(String var0) {
      int var1 = var0.indexOf(32);
      if (var1 > 0 && var1 != var0.length() - 1) {
         try {
            return new LANRecord(var0.substring(0, var1), var0.substring(var1 + 1));
         } catch (IllegalArgumentException var3) {
            return null;
         }
      } else {
         return null;
      }
   }

   public String v4() {
      return this.kind;
   }

   public String v5() {
      return this.id;
   }
}
