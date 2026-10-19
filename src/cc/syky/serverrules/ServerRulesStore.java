package cc.syky.serverrules;

import cc.syky.cloud.cloudSupport66;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;
import java.util.function.Consumer;
import org.jetbrains.annotations.Nullable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public final class ServerRulesStore {
   private static final Logger v3 = LoggerFactory.getLogger("syky.serverrules");
   public static final String v1 = "cc/syky/serverrules/server_rules.json";
   public static final int v2 = 524288;
   private final Path v4;
   private final Consumer<Runnable> v5;
   private volatile serverrulesSupport v6 = serverrulesSupport.v5;
   private volatile Runnable v7 = () -> {};

   public ServerRulesStore(Path var1, Consumer<Runnable> var2) {
      this.v4 = var1;
      this.v5 = var2;
   }

   public void v1(Runnable var1) {
      this.v7 = var1;
   }

   public void v1(@Nullable String var1) {
      serverrulesSupport var2 = v1(var1, "the jar");
      serverrulesSupport var3 = v1(this.v3(), "the cache");
      this.v6 = var3.v1() > var2.v1() ? var3 : var2;
      v3.info("server rules revision {} ({} servers)", this.v6.v1(), this.v6.v2().size());
   }

   public serverrulesSupport v1() {
      return this.v6;
   }

   public String v2() {
      return "\"r" + this.v6.v1() + "\"";
   }

   public void v2(String var1) {
      serverrulesSupport var2;
      try {
         var2 = serverrulesSupport.v2(var1);
      } catch (IllegalArgumentException var5) {
         v3.warn("server rules from the server were refused: {}", var5.getMessage());
         return;
      }

      if (var2.v1() < this.v6.v1()) {
         v3.debug("server rules revision {} is older than {}, ignored", var2.v1(), this.v6.v1());
      } else {
         try {
            cloudSupport66.v1(this.v4, var1);
         } catch (IOException var4) {
            v3.warn("server rules could not be cached", var4);
         }

         serverrulesSupport var3 = this.v6;
         this.v6 = var2;
         if (var2.v1() != var3.v1() || !var2.v2().equals(var3.v2())) {
            v3.info("server rules now revision {} ({} servers)", var2.v1(), var2.v2().size());
            this.v5.accept(this.v7);
         }
      }
   }

   @Nullable
   private String v3() {
      try {
         if (Files.size(this.v4) > 524288L) {
            v3.warn("cached server rules are implausibly large and were ignored");
            return null;
         } else {
            return Files.readString(this.v4, StandardCharsets.UTF_8);
         }
      } catch (NoSuchFileException var2) {
         return null;
      } catch (RuntimeException | IOException var3) {
         v3.warn("cached server rules could not be read", var3);
         return null;
      }
   }

   private static serverrulesSupport v1(@Nullable String var0, String var1) {
      if (var0 == null) {
         return serverrulesSupport.v5;
      } else {
         try {
            return serverrulesSupport.v2(var0);
         } catch (IllegalArgumentException var3) {
            v3.warn("server rules in {} were refused: {}", var1, var3.getMessage());
            return serverrulesSupport.v5;
         }
      }
   }
}
