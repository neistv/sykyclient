package cc.syky.config;

import cc.syky.cloud.cloudSupport101;
import cc.syky.internal.InternalSupport56;
import cc.syky.internal.InternalSupport57;
import cc.syky.ui.uiRecord5;
import java.io.IOException;
import java.lang.ProcessBuilder.Redirect;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import net.minecraft.class_156;
import net.minecraft.class_310;
import org.jetbrains.annotations.Nullable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public final class ConfigUi {
   private static final Logger v1 = LoggerFactory.getLogger("syky.config.ui");
   private final NewConfigSupport v2;
   private final Path v3;
   private final cloudSupport101 v4;
   private final InternalSupport57 v5;
   private final InternalSupport56 v6;

   public ConfigUi(NewConfigSupport var1, Path var2, cloudSupport101 var3, InternalSupport57 var4, InternalSupport56 var5) {
      this.v2 = var1;
      this.v3 = var2;
      this.v4 = var3;
      this.v5 = var4;
      this.v6 = var5;
   }

   public List<uiRecord5> v1() {
      String var1 = this.v2.v5();
      ArrayList var2 = new ArrayList();

      for (String var4 : this.v2.v4()) {
         var2.add(new uiRecord5(var4, var4.equals(var1)));
      }

      return var2;
   }

   public long v2() {
      try {
         return Files.getLastModifiedTime(this.v3).toMillis();
      } catch (RuntimeException | IOException var2) {
         return 0L;
      }
   }

   public String v3() {
      return this.v2.v5();
   }

   public boolean v4() {
      return this.v2.v6();
   }

   public boolean v5() {
      return this.v2.v7();
   }

   public void v1(String var1) {
      this.v2.v4(var1);
   }

   public void v1(boolean var1) {
      this.v2.v1(var1);
   }

   public boolean v6() {
      return this.v2.v8();
   }

   @Nullable
   public String v7() {
      return this.v2.v12();
   }

   @Nullable
   public String v2(String var1) {
      return this.v2.v5(var1);
   }

   public boolean v1(String var1, String var2) {
      return this.v2.v1(var1, var2);
   }

   public boolean v3(String var1) {
      try {
         this.v2.v6(var1);
         return true;
      } catch (Exception var3) {
         v1.warn("failed to delete config {}", var1, var3);
         return false;
      }
   }

   public void v8() {
      try {
         Files.createDirectories(this.v3);
         class_156.method_668().method_672(this.v3.toFile());
      } catch (Exception var2) {
         v1.warn("failed to open config folder", var2);
      }
   }

   public void v4(String var1) {
      if (this.v2.v1(var1)) {
         Path var2 = this.v2.v2(var1);
         this.v5.v1(() -> {
            if (!v1(var2)) {
               String var2x = v2(var2);
               if (var2x != null) {
                  this.v6.v1(() -> this.v5(var2x));
               }
            }
         });
      }
   }

   private static boolean v1(Path var0) {
      try {
         String var1 = var0.toAbsolutePath().toString().replace("'", "''");
         Process var2 = new ProcessBuilder(
               "powershell", "-NoProfile", "-NonInteractive", "-WindowStyle", "Hidden", "-Command", "Set-Clipboard -LiteralPath '" + var1 + "'"
            )
            .redirectOutput(Redirect.DISCARD)
            .redirectError(Redirect.DISCARD)
            .start();
         if (!var2.waitFor(5L, TimeUnit.SECONDS)) {
            var2.destroyForcibly();
            return false;
         } else {
            return var2.exitValue() == 0;
         }
      } catch (Throwable var3) {
         v1.debug("Set-Clipboard file copy failed, falling back to text", var3);
         return false;
      }
   }

   @Nullable
   private static String v2(Path var0) {
      try {
         return Files.readString(var0);
      } catch (Exception var2) {
         v1.warn("failed to read config for share", var2);
         return null;
      }
   }

   private void v5(String var1) {
      class_310 var2 = this.v4.v1();
      if (var2 != null && var2.field_1774 != null) {
         var2.field_1774.method_1455(var1);
      }
   }
}
