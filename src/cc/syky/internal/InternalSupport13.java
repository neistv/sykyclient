package cc.syky.internal;

import cc.syky.sykyRecord6;
import cc.syky.update.UpdateBootWatch;
import cc.syky.update.UpdateKeys;
import cc.syky.update.UpdateManager;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.Instant;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Optional;
import net.fabricmc.loader.api.FabricLoader;
import net.fabricmc.loader.api.ModContainer;
import net.fabricmc.loader.api.SemanticVersion;
import net.fabricmc.loader.api.Version;
import net.fabricmc.loader.api.VersionParsingException;
import org.jetbrains.annotations.Nullable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public final class InternalSupport13 implements AutoCloseable {
   private static final Logger v1 = LoggerFactory.getLogger("syky.update");
   private final Path v2;
   private final InternalSupport57 v3;
   private final UpdateManager v4;
   private volatile InternalSupport13.Part1 v5 = InternalSupport13.Part1.DISABLED;
   @Nullable
   private volatile String v6;
   @Nullable
   private volatile InternalSupport12.Part1 v7;
   private volatile boolean v8;

   public InternalSupport13(Path var1, InternalSupport57 var2) {
      this.v2 = var1;
      this.v3 = var2;
      this.v4 = new UpdateManager(var1);
   }

   public void v1() {
      this.v3.v1(this::v4);
   }

   public InternalSupport13.Part1 v2() {
      return this.v5;
   }

   @Nullable
   public String v3() {
      return this.v6;
   }

   @Override
   public void close() {
      this.v8 = true;
      InternalSupport12.Part1 var1 = this.v7;
      if (var1 != null) {
         this.v7 = null;
         if (var1.v6() < 5L) {
            InternalSupport14.v1(this.v2, var1);
         }
      }
   }

   private void v4() {
      if (!FabricLoader.getInstance().isDevelopmentEnvironment()) {
         if (UpdateKeys.v3.isEmpty()) {
            v1.warn("no update signing keys are baked into this build — the updater is off");
         } else {
            Path var1 = UpdateBootWatch.ownJar();
            if (var1 != null && v1(var1)) {
               InternalSupport12 var2 = InternalSupport12.v1(this.v2);
               InternalSupport12.Part1 var3 = this.v1(var2);
               this.v7 = var3;
               if (var3 == null) {
                  this.v5 = InternalSupport13.Part1.CHECKING;
               } else {
                  this.v5 = InternalSupport13.Part1.READY;
                  this.v6 = var3.v2();
               }

               List var4 = v2(var2);
               if (var4.isEmpty()) {
                  v1.warn("no update endpoints are configured — the updater is off");
                  this.v5 = InternalSupport13.Part1.DISABLED;
               } else {
                  InternalSupport12.Part2 var5 = var2.v3();
                  UpdateManager.Part2 var6 = this.v4.v1(var4, var5);
                  if (!this.v8) {
                     if (var6 == null) {
                        v1.info("no mirror returned a usable manifest");
                        this.v5 = var3 == null ? InternalSupport13.Part1.FAILED : InternalSupport13.Part1.READY;
                     } else {
                        sykyRecord6 var7 = var6.v1();
                        if (var6.v2()) {
                           var2.v1(var7.v1());
                           InternalSupport12.Part2 var8 = var6.v3();
                           if (var8 != null) {
                              var2.v1(var8);
                           } else if (var5 != null) {
                              var2.v4();
                           }

                           var2.v1();
                        }

                        String var10 = v5();
                        Optional var9 = var7.v2(var10);
                        if (var9.isEmpty()) {
                           v1.info("no release is published for Minecraft {}", var10);
                           this.v1(var2, var3, null);
                        } else {
                           this.v1(var2, var3, (sykyRecord6.Part1)var9.get());
                        }
                     }
                  }
               }
            } else {
               v1.info("this install cannot replace its own jar — the updater is off");
            }
         }
      }
   }

   private void v1(InternalSupport12 var1, @Nullable InternalSupport12.Part1 var2, @Nullable sykyRecord6.Part1 var3) {
      Version var4 = ((ModContainer)FabricLoader.getInstance().getModContainer("syky").orElseThrow()).getMetadata().getVersion();
      if (var3 != null && v1(var3.v1(), var4)) {
         if (var2 != null && var2.v2().equals(var3.v1())) {
            v1.info("{} is already staged and installs on exit", var3.v1());
         } else if (!v1(var3)) {
            this.v5 = var2 == null ? InternalSupport13.Part1.UP_TO_DATE : InternalSupport13.Part1.READY;
         } else {
            this.v5 = InternalSupport13.Part1.DOWNLOADING;
            String var5 = this.v4.v1(var3);
            if (!this.v8) {
               if (var5 == null) {
                  v1.info("no mirror delivered {}", var3.v1());
                  this.v5 = var2 == null ? InternalSupport13.Part1.FAILED : InternalSupport13.Part1.READY;
               } else {
                  Path var6 = UpdateBootWatch.ownJar();
                  if (var6 == null) {
                     this.v5 = InternalSupport13.Part1.DISABLED;
                  } else {
                     if (var2 != null) {
                        this.v1(var2);
                     }

                     InternalSupport12.Part1 var7 = new InternalSupport12.Part1(
                        var3.v1(), var5, var3.v2(), var6.toString(), var4.getFriendlyString(), 0L, Instant.now().getEpochSecond()
                     );
                     var1.v1(var7);
                     var1.v1();
                     this.v7 = var7;
                     this.v6 = var3.v1();
                     this.v5 = InternalSupport13.Part1.READY;
                     v1.info("update {} is staged and installs when the game closes", var3.v1());
                  }
               }
            }
         }
      } else {
         if (var2 != null) {
            this.v1(var1, var2);
            this.v7 = null;
            this.v6 = null;
         }

         this.v5 = InternalSupport13.Part1.UP_TO_DATE;
      }
   }

   @Nullable
   private InternalSupport12.Part1 v1(InternalSupport12 var1) {
      InternalSupport12.Part1 var2 = var1.v5();
      if (var2 == null) {
         return null;
      } else {
         Path var3 = this.v2.resolve(var2.v3());
         if (!Files.isRegularFile(var3)) {
            var1.v6();
            var1.v1();
            return null;
         } else {
            boolean var4 = Instant.now().getEpochSecond() - var2.v7() > UpdateKeys.v10.toSeconds();
            if (!var4 && var2.v6() < 5L) {
               return var2;
            } else {
               v1.info("dropping staged {}", var2.v2());
               this.v1(var1, var2);
               return null;
            }
         }
      }
   }

   private void v1(InternalSupport12 var1, InternalSupport12.Part1 var2) {
      var1.v6();
      var1.v1();
      this.v1(var2);
   }

   private void v1(InternalSupport12.Part1 var1) {
      try {
         Files.deleteIfExists(this.v2.resolve(var1.v3()));
      } catch (IOException var3) {
         v1.debug("could not remove the staged jar", var3);
      }
   }

   private static boolean v1(sykyRecord6.Part1 var0) {
      if (var0.v5() > 0 && Runtime.version().feature() < var0.v5()) {
         v1.warn("{} needs Java {} and this runtime is {}", new Object[]{var0.v1(), var0.v5(), Runtime.version().feature()});
         return false;
      } else {
         String var1 = var0.v4();
         if (var1 == null) {
            return true;
         } else {
            Version var2 = FabricLoader.getInstance().getModContainer("fabricloader").map(var0x -> var0x.getMetadata().getVersion()).orElse(null);
            if (var2 instanceof SemanticVersion var3) {
               try {
                  if (var3.compareTo(SemanticVersion.parse(var1)) < 0) {
                     v1.warn("{} needs Fabric Loader {} and this install has {}", new Object[]{var0.v1(), var1, var3});
                     return false;
                  }
               } catch (VersionParsingException var5) {
                  v1.debug("unparseable minLoader on {}", var0.v1(), var5);
               }

               return true;
            } else {
               return true;
            }
         }
      }
   }

   private static List<String> v2(InternalSupport12 var0) {
      LinkedHashSet var1 = new LinkedHashSet<>(UpdateKeys.v2);
      var1.addAll(var0.v2());
      return new ArrayList<>(var1);
   }

   private static boolean v1(String var0, Version var1) {
      try {
         SemanticVersion var2 = SemanticVersion.parse(var0);
         if (var1 instanceof SemanticVersion var3) {
            return var2.compareTo(var3) > 0;
         } else {
            v1.warn("installed version {} is not semantic — skipping the comparison", var1.getFriendlyString());
            return false;
         }
      } catch (VersionParsingException var4) {
         v1.warn("release version {} is not semantic and is ignored", var0, var4);
         return false;
      }
   }

   private static String v5() {
      return FabricLoader.getInstance().getModContainer("minecraft").map(var0 -> var0.getMetadata().getVersion().getFriendlyString()).orElse("unknown");
   }

   private static boolean v1(Path var0) {
      Path var1 = var0.getParent();
      return var1 != null && Files.isWritable(var1) && Files.isWritable(var0);
   }

   public static enum Part1 {
      DISABLED,
      CHECKING,
      DOWNLOADING,
      UP_TO_DATE,
      READY,
      FAILED;

      private Part1() {
      }
   }
}
