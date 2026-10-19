package cc.syky.config;

import net.minecraft.class_2561;
import org.jetbrains.annotations.Nullable;

public final class configSupport8 {
   private static final char v1 = '§';

   private configSupport8() {
   }

   @Nullable
   public static String v1(@Nullable class_2561 var0, int var1) {
      if (var0 == null) {
         return null;
      } else {
         String var2 = var0.getString();
         StringBuilder var3 = new StringBuilder(var2.length());

         for (int var4 = 0; var4 < var2.length(); var4++) {
            char var5 = var2.charAt(var4);
            if (var5 == 167) {
               var4++;
            } else {
               var3.append(var5 != '\n' && var5 != '\r' ? var5 : ' ');
            }
         }

         String var6 = var3.toString().trim();
         if (var6.isEmpty()) {
            return null;
         } else if (var6.length() <= var1) {
            return var6;
         } else {
            int var7 = Character.isHighSurrogate(var6.charAt(var1 - 1)) ? var1 - 1 : var1;
            return var6.substring(0, var7).trim() + "…";
         }
      }
   }
}
