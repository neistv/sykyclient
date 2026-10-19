package cc.syky.cloud;

import org.jetbrains.annotations.Nullable;

public enum cloudSupport49 {
   CAPE("cape", cloudSupport51.BODY),
   HAT("hat", cloudSupport51.HEAD),
   FACE("face", cloudSupport51.HEAD),
   BACK("back", cloudSupport51.BODY),
   AURA("aura", cloudSupport51.BODY);

   private static final cloudSupport49[] ALL = values();
   private final String id;
   private final cloudSupport51 anchor;

   private cloudSupport49(String var3, cloudSupport51 var4) {
      this.id = var3;
      this.anchor = var4;
   }

   public String v1() {
      return this.id;
   }

   public cloudSupport51 v2() {
      return this.anchor;
   }

   @Nullable
   public static cloudSupport49 v1(String var0) {
      for (cloudSupport49 var4 : ALL) {
         if (var4.id.equalsIgnoreCase(var0)) {
            return var4;
         }
      }

      return null;
   }
}
