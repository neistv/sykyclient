package cc.syky.cloud;

import org.jetbrains.annotations.Nullable;

public enum cloudSupport37 {
   GLOW("glow", 0),
   HOLOGRAM("hologram", 1),
   ENERGY("energy", 2),
   FOIL("foil", 3),
   SHIMMER("shimmer", 4);

   private static final cloudSupport37[] ALL = values();
   private final String id;
   private final int code;

   private cloudSupport37(String var3, int var4) {
      this.id = var3;
      this.code = var4;
   }

   public String v1() {
      return this.id;
   }

   public int v2() {
      return this.code;
   }

   @Nullable
   public static cloudSupport37 v1(String var0) {
      for (cloudSupport37 var4 : ALL) {
         if (var4.id.equalsIgnoreCase(var0)) {
            return var4;
         }
      }

      return null;
   }

   @Nullable
   public static cloudSupport37 v1(int var0) {
      for (cloudSupport37 var4 : ALL) {
         if (var4.code == var0) {
            return var4;
         }
      }

      return null;
   }
}
