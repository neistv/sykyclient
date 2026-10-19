package cc.syky.cloud;

import org.jetbrains.annotations.Nullable;

public enum cloudSupport44 {
   IDLE("idle"),
   WALK("walk"),
   SPRINT("sprint"),
   SNEAK("sneak"),
   SWIM("swim"),
   GLIDE("glide"),
   AIR("air"),
   RISE("rise"),
   FALL("fall");

   private static final cloudSupport44[] ALL = values();
   private final String id;

   private cloudSupport44(String var3) {
      this.id = var3;
   }

   public String v1() {
      return this.id;
   }

   public cloudSupport44 v2() {
      return switch (this) {
         case IDLE, WALK, SNEAK, SWIM, AIR, RISE, FALL -> IDLE;
         case SPRINT -> WALK;
         case GLIDE -> AIR;
      };
   }

   @Nullable
   public static cloudSupport44 v1(String var0) {
      for (cloudSupport44 var4 : ALL) {
         if (var4.id.equalsIgnoreCase(var0)) {
            return var4;
         }
      }

      return null;
   }

   public static int v3() {
      return ALL.length;
   }

   public static cloudSupport44 v1(int var0) {
      return ALL[var0];
   }
}
