package cc.syky;

import java.util.Locale;
import org.jetbrains.annotations.Nullable;

public final class EndSupport {
   public static final String v1 = "minecraft:overworld";
   public static final String v2 = "minecraft:the_nether";
   public static final String v3 = "minecraft:the_end";
   public static final int v4 = 8;

   private EndSupport() {
   }

   @Nullable
   public static String v1(String var0) {
      if ("minecraft:overworld".equals(var0)) {
         return "minecraft:the_nether";
      } else {
         return "minecraft:the_nether".equals(var0) ? "minecraft:overworld" : null;
      }
   }

   public static int v1(int var0, String var1, String var2) {
      if ("minecraft:overworld".equals(var1) && "minecraft:the_nether".equals(var2)) {
         return Math.floorDiv(var0, 8);
      } else {
         return "minecraft:the_nether".equals(var1) && "minecraft:overworld".equals(var2)
            ? sykyRecord4.v1((int)Math.max(-2147483648L, Math.min(2147483647L, var0 * 8L)))
            : var0;
      }
   }

   public static String v2(String var0) {
      if ("minecraft:overworld".equals(var0)) {
         return "Overworld";
      } else if ("minecraft:the_nether".equals(var0)) {
         return "Nether";
      } else if ("minecraft:the_end".equals(var0)) {
         return "End";
      } else {
         String var1 = var0.substring(var0.indexOf(58) + 1);
         StringBuilder var2 = new StringBuilder(var1.length());
         boolean var3 = true;

         for (int var4 = 0; var4 < var1.length(); var4++) {
            char var5 = var1.charAt(var4);
            if (var5 != '_' && var5 != '/' && var5 != '-') {
               var2.append(var3 ? Character.toUpperCase(var5) : var5);
               var3 = false;
            } else {
               var2.append(' ');
               var3 = true;
            }
         }

         String var6 = var2.toString().trim();
         return var6.isEmpty() ? var0.toLowerCase(Locale.ROOT) : var6;
      }
   }
}
