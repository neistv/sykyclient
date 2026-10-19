package cc.syky.internal;

import cc.syky.cloud.cloudSupport66;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Locale;
import java.util.Properties;
import java.util.Set;
import org.jetbrains.annotations.Nullable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public final class InternalSupport12 {
   private static final Logger v2 = LoggerFactory.getLogger("syky.update.state");
   public static final String v1 = "state.properties";
   private static final int v3 = 8;
   private static final String v4 = "endpoints";
   private static final String v5 = "staged.version";
   private static final String v6 = "staged.file";
   private static final String v7 = "staged.sha256";
   private static final String v8 = "staged.target";
   private static final String v9 = "staged.attempts";
   private static final String v10 = "staged.epochSec";
   private static final String v11 = "staged.previous";
   private static final String v12 = "changelog.seen";
   private static final String v13 = "modules.new";
   private static final String v14 = "modules.newFor";
   private static final String v15 = "manifest.url";
   private static final String v16 = "manifest.etag";
   private static final String v18 = "manifest.lastModified";
   private static final List<String> v19 = List.of("quarantine", "verify.version", "verify.failures", "verify.previous");
   private final Path v17;
   private final Properties v20 = new Properties();
   private final Set<String> v21 = new LinkedHashSet<>();

   private InternalSupport12(Path var1) {
      this.v17 = var1;
   }

   public static InternalSupport12 v1(Path var0) {
      InternalSupport12 var1 = new InternalSupport12(var0.resolve("state.properties"));
      if (!Files.isRegularFile(var1.v17)) {
         return var1;
      } else {
         try (InputStream var2 = Files.newInputStream(var1.v17)) {
            var1.v20.load(var2);
         } catch (IllegalArgumentException | IOException var7) {
            v2.warn("update state at {} is unreadable and was reset", var1.v17, var7);
            var1.v20.clear();
         }

         return var1;
      }
   }

   public synchronized void v1() {
      if (!this.v21.isEmpty()) {
         try {
            Properties var1 = new Properties();
            if (Files.isRegularFile(this.v17)) {
               try (InputStream var2 = Files.newInputStream(this.v17)) {
                  var1.load(var2);
               } catch (IllegalArgumentException | IOException var7) {
                  v2.debug("ignoring an unreadable state file while merging", var7);
               }
            }

            for (String var3 : this.v21) {
               String var4 = this.v20.getProperty(var3);
               if (var4 == null) {
                  var1.remove(var3);
               } else {
                  var1.setProperty(var3, var4);
               }
            }

            ByteArrayOutputStream var10 = new ByteArrayOutputStream();
            var1.store(var10, "syky updater state - safe to delete");
            cloudSupport66.v1(this.v17, var10.toByteArray());
            this.v21.clear();
         } catch (IOException var8) {
            v2.warn("could not persist update state to {}", this.v17, var8);
         }
      }
   }

   private synchronized void v1(String var1, String var2) {
      this.v20.setProperty(var1, var2);
      this.v21.add(var1);
   }

   private synchronized void v4(String var1) {
      this.v20.remove(var1);
      this.v21.add(var1);
   }

   private void v2(String var1, @Nullable String var2) {
      if (var2 == null) {
         this.v4(var1);
      } else {
         this.v1(var1, var2);
      }
   }

   public List<String> v2() {
      return this.v6("endpoints");
   }

   public void v1(List<String> var1) {
      LinkedHashSet var2 = new LinkedHashSet(var1);
      var2.addAll(this.v6("endpoints"));
      List var3 = v1(var2, 8);
      if (!var3.equals(this.v6("endpoints"))) {
         this.v1("endpoints", String.join(",", var3));
      }
   }

   @Nullable
   public InternalSupport12.Part2 v3() {
      String var1 = this.v20.getProperty("manifest.url");
      String var2 = this.v20.getProperty("manifest.etag");
      String var3 = this.v20.getProperty("manifest.lastModified");
      return var1 != null && (var2 != null || var3 != null) ? new InternalSupport12.Part2(var1, var2, var3) : null;
   }

   public void v1(InternalSupport12.Part2 var1) {
      this.v1("manifest.url", var1.v1());
      this.v2("manifest.etag", var1.v2());
      this.v2("manifest.lastModified", var1.v3());
   }

   public void v4() {
      this.v4("manifest.url");
      this.v4("manifest.etag");
      this.v4("manifest.lastModified");
   }

   @Nullable
   public InternalSupport12.Part1 v5() {
      String var1 = this.v20.getProperty("staged.version");
      String var2 = this.v20.getProperty("staged.file");
      String var3 = this.v20.getProperty("staged.sha256");
      String var4 = this.v20.getProperty("staged.target");
      return var1 != null && var2 != null && var3 != null && var4 != null
         ? new InternalSupport12.Part1(
            var1, var2, var3, var4, this.v20.getProperty("staged.previous", ""), this.v5("staged.attempts"), this.v5("staged.epochSec")
         )
         : null;
   }

   public void v1(InternalSupport12.Part1 var1) {
      this.v1("staged.version", var1.v2());
      this.v1("staged.file", var1.v3());
      this.v1("staged.sha256", var1.v1());
      this.v1("staged.target", var1.v4());
      this.v1("staged.attempts", Long.toString(var1.v6()));
      this.v1("staged.epochSec", Long.toString(var1.v7()));
      this.v1("staged.previous", var1.v5());
   }

   public void v6() {
      this.v4("staged.version");
      this.v4("staged.file");
      this.v4("staged.sha256");
      this.v4("staged.target");
      this.v4("staged.attempts");
      this.v4("staged.epochSec");
      this.v4("staged.previous");
   }

   @Nullable
   public String v7() {
      return this.v20.getProperty("changelog.seen");
   }

   public void v1(String var1) {
      this.v1("changelog.seen", var1);
   }

   public void v2(String var1) {
      if (this.v7() == null && !var1.isEmpty()) {
         this.v1(var1);
      }
   }

   public void v8() {
      for (String var2 : v19) {
         if (this.v20.containsKey(var2)) {
            this.v4(var2);
         }
      }
   }

   public Set<String> v9() {
      String var1 = this.v20.getProperty("modules.new");
      LinkedHashSet var2 = new LinkedHashSet();
      if (var1 == null) {
         return var2;
      } else {
         for (String var6 : var1.split(",")) {
            String var7 = var6.trim();
            if (!var7.isEmpty()) {
               var2.add(var7);
            }
         }

         return var2;
      }
   }

   public void v1(Set<String> var1) {
      this.v2("modules.new", var1.isEmpty() ? null : String.join(",", var1));
   }

   @Nullable
   public String v10() {
      return this.v20.getProperty("modules.newFor");
   }

   public void v3(String var1) {
      this.v1("modules.newFor", var1);
   }

   private long v5(String var1) {
      String var2 = this.v20.getProperty(var1);
      if (var2 == null) {
         return 0L;
      } else {
         try {
            return Long.parseLong(var2.trim());
         } catch (NumberFormatException var4) {
            return 0L;
         }
      }
   }

   private List<String> v6(String var1) {
      String var2 = this.v20.getProperty(var1);
      if (var2 != null && !var2.isBlank()) {
         ArrayList var3 = new ArrayList();

         for (String var7 : var2.split(",", -1)) {
            String var8 = var7.trim();
            if (!var8.isEmpty()) {
               var3.add(var8);
            }
         }

         return var3;
      } else {
         return List.of();
      }
   }

   private static List<String> v1(Set<String> var0, int var1) {
      ArrayList var2 = new ArrayList(var0);
      return var2.size() <= var1 ? var2 : new ArrayList<>(var2.subList(0, var1));
   }

   public record Part1(String version, String fileName, String sha256, String target, String previous, long attempts, long epochSec) {
      public String v1() {
         return this.sha256.toLowerCase(Locale.ROOT);
      }

      public String v2() {
         return this.version;
      }

      public String v3() {
         return this.fileName;
      }

      public String v4() {
         return this.target;
      }

      public String v5() {
         return this.previous;
      }

      public long v6() {
         return this.attempts;
      }

      public long v7() {
         return this.epochSec;
      }
   }

   public record Part2(String url, @Nullable String etag, @Nullable String lastModified) {
      public String v1() {
         return this.url;
      }

      @Nullable
      public String v2() {
         return this.etag;
      }

      @Nullable
      public String v3() {
         return this.lastModified;
      }
   }
}
