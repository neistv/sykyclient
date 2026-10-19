package cc.syky.cloud;

import org.jetbrains.annotations.Nullable;

public final class cloudSupport58 {
   public static final int v1 = 40;

   private cloudSupport58() {
   }

   @Nullable
   public static String v1(@Nullable String var0) {
      if (var0 == null) {
         return null;
      } else {
         StringBuilder var1 = new StringBuilder(var0.length());
         var0.codePoints().filter(var0x -> !Character.isISOControl(var0x)).forEach(var1::appendCodePoint);
         String var2 = var1.toString().strip();
         if (var2.isEmpty()) {
            return null;
         } else if (var2.length() <= 40) {
            return var2;
         } else {
            int var3 = Character.isLowSurrogate(var2.charAt(40)) ? 39 : 40;
            return var2.substring(0, var3).strip();
         }
      }
   }
}
