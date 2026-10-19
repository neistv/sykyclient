package cc.syky.ui;

import java.util.UUID;

public record uiRecord15(uiRecord15.Part1 source, String name, UUID uuid, String accessToken) {
   private static final String OFFLINE_TOKEN = "0";

   public static uiRecord15 v1() {
      return new uiRecord15(uiRecord15.Part1.LAUNCH, "", new UUID(0L, 0L), "");
   }

   public static uiRecord15 v1(String var0) {
      return new uiRecord15(uiRecord15.Part1.OFFLINE, var0, uiSupport267.v2(var0), "0");
   }

   public static uiRecord15 v1(String var0, UUID var1, String var2) {
      return new uiRecord15(uiRecord15.Part1.MICROSOFT, var0, var1, var2);
   }

   @Override
   public String toString() {
      return "SessionSpec[" + this.source + " " + this.name + " " + this.uuid + "]";
   }

   public uiRecord15.Part1 v2() {
      return this.source;
   }

   public String v3() {
      return this.name;
   }

   public UUID v4() {
      return this.uuid;
   }

   public String v5() {
      return this.accessToken;
   }

   public static enum Part1 {
      LAUNCH,
      OFFLINE,
      MICROSOFT;

      private Part1() {
      }
   }
}
