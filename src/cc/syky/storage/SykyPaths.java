package cc.syky.storage;

import java.nio.file.Path;

public record SykyPaths(Path root) {
   public static final String ROOT_NAME = "syky";

   public static SykyPaths v1(Path var0) {
      return new SykyPaths(var0.resolve("syky"));
   }

   public Path v1() {
      return this.root.resolve("configs");
   }

   public Path v2() {
      return this.root.resolve("backups");
   }

   public Path v3() {
      return this.root.resolve("sounds");
   }

   public Path v4() {
      return this.root.resolve("cache");
   }

   public Path v5() {
      return this.root.resolve("update");
   }

   public Path v6() {
      return this.root.resolve("debug");
   }

   public Path v7() {
      return this.root.resolve("crash");
   }

   public Path v8() {
      return this.root.resolve("accounts.dat");
   }

   public Path v9() {
      return this.root.resolve("waypoints");
   }

   public Path v10() {
      return this.root;
   }
}
