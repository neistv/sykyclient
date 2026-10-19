package cc.syky.cloud;

import org.jetbrains.annotations.Nullable;

public enum cloudSupport36 {
   NONE("none"),
   SOLID("solid"),
   CUTOUT("cutout"),
   TRANSLUCENT("translucent"),
   EMISSIVE("emissive");

   private static final cloudSupport36[] ALL = values();
   private final String id;

   private cloudSupport36(String var3) {
      this.id = var3;
   }

   public String v1() {
      return this.id;
   }

   @Nullable
   public static cloudSupport36 v1(String var0) {
      for (cloudSupport36 var4 : ALL) {
         if (var4.id.equalsIgnoreCase(var0)) {
            return var4;
         }
      }

      return null;
   }

   public static cloudSupport36 v1(int var0) {
      if (var0 >= 0 && var0 < ALL.length) {
         return ALL[var0];
      } else {
         throw new IllegalArgumentException("no surface " + var0);
      }
   }
}
