package cc.syky.cloud;

import java.net.URI;
import java.util.List;
import java.util.UUID;
import org.jetbrains.annotations.Nullable;

public interface cloudSupport89 {
   void v1(Runnable var1);

   void v1(String var1, boolean var2);

   void v1(URI var1);

   void v1(cloudSupport89.Part4 var1);

   void v2(cloudSupport89.Part4 var1);

   int v1(cloudSupport89.Part1 var1);

   String v1();

   List<String> v2();

   CloudHttp.Part4 v3();

   @FunctionalInterface
   public interface Part1 {
      void player(UUID var1, String var2);
   }

   public record Part2(String provider, UUID id, String name, cloudSupport89.Part3 joiner) {
      public String v1() {
         return this.provider;
      }

      public UUID v2() {
         return this.id;
      }

      public String v3() {
         return this.name;
      }

      public cloudSupport89.Part3 v4() {
         return this.joiner;
      }
   }

   @FunctionalInterface
   public interface Part3 {
      void join(String var1) throws Exception;
   }

   @FunctionalInterface
   public interface Part4 {
      void player(UUID var1, String var2, @Nullable String var3, @Nullable String var4);
   }
}
