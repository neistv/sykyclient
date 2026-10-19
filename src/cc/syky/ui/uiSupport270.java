package cc.syky.ui;

import java.util.UUID;
import org.jetbrains.annotations.Nullable;

public interface uiSupport270 {
   @Nullable
   uiSupport270.Part3 v1();

   uiSupport270.Part2 v2();

   boolean v3();

   @Nullable
   String v4();

   uiSupport270.Part1 v1(uiRecord15 var1) throws Exception;

   void v1(uiSupport270.Part1 var1);

   void v1(String var1);

   void v2(String var1);

   public interface Part1 {
   }

   public static enum Part2 {
      MENU,
      WORLD;

      private Part2() {
      }
   }

   public record Part3(String name, UUID uuid, uiSupport272 kind) {
      public String v1() {
         return this.name;
      }

      public UUID v2() {
         return this.uuid;
      }

      public uiSupport272 v3() {
         return this.kind;
      }
   }
}
