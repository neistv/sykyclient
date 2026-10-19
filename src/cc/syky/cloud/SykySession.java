package cc.syky.cloud;

import org.jetbrains.annotations.Nullable;

public final class SykySession {
   @Nullable
   private static volatile SykySession.Part1 v1;

   private SykySession() {
   }

   @Nullable
   public static SykySession.Part1 v1() {
      return v1;
   }

   public static void v1(@Nullable SykySession.Part1 var0) {
      v1 = var0;
   }

   public record Part1(long uid, String username) {
      public long v1() {
         return this.uid;
      }

      public String v2() {
         return this.username;
      }
   }
}
