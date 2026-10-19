package cc.syky.cloud;

import java.net.Inet6Address;
import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.util.Objects;
import java.util.UUID;
import org.jetbrains.annotations.Nullable;

public record PresenceSnapshot(String server, String name, @Nullable UUID id, String endpoint, long seed) {
   public static final PresenceSnapshot NOWHERE = new PresenceSnapshot("", "", null, "", 0L);

   public boolean v1() {
      return !this.server.isEmpty() && !this.name.isEmpty() && this.id != null;
   }

   public boolean v1(PresenceSnapshot var1) {
      return this.server.equals(var1.server) && this.name.equals(var1.name) && Objects.equals(this.id, var1.id) && this.endpoint.equals(var1.endpoint);
   }

   public PresenceSnapshot v1(long var1) {
      return new PresenceSnapshot(this.server, this.name, this.id, this.endpoint, var1);
   }

   public static String v1(@Nullable SocketAddress var0) {
      if (var0 instanceof InetSocketAddress var1 && var1.getAddress() != null) {
         String var2 = var1.getAddress().getHostAddress();
         int var3 = var2.indexOf(37);
         if (var3 >= 0) {
            var2 = var2.substring(0, var3);
         }

         return (var1.getAddress() instanceof Inet6Address ? "[" + var2 + "]" : var2) + ":" + var1.getPort();
      } else {
         return "";
      }
   }

   public String v2() {
      return this.server;
   }

   public String v3() {
      return this.name;
   }

   @Nullable
   public UUID v4() {
      return this.id;
   }

   public String v5() {
      return this.endpoint;
   }

   public long v6() {
      return this.seed;
   }
}
