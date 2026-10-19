package cc.syky.cloud;

import java.util.List;
import java.util.Locale;
import org.jetbrains.annotations.Nullable;

public enum cloudSupport96 {
   TOGGLE,
   HOLD;

   public static final List<String> LABELS = List.of("toggle", "hold");

   private cloudSupport96() {
   }

   @Nullable
   public static cloudSupport96 v1(@Nullable String var0, @Nullable cloudSupport96 var1) {
      if (var0 == null) {
         return var1;
      } else {
         try {
            return valueOf(var0.toUpperCase(Locale.ROOT));
         } catch (IllegalArgumentException var3) {
            return var1;
         }
      }
   }

   public String v1() {
      return this.name().toLowerCase(Locale.ROOT);
   }

   public static boolean v1(@Nullable String var0) {
      return v1(var0, null) != null;
   }
}
