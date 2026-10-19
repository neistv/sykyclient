package cc.syky.internal;

import cc.syky.cloud.cloudSupport38;
import cc.syky.cloud.cloudSupport39;
import cc.syky.cloud.cloudSupport50;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.regex.Pattern;
import java.util.stream.Stream;
import org.jetbrains.annotations.Nullable;

public final class InternalSupport61 implements InternalSupport60.Part6 {
   private static final Pattern v1 = Pattern.compile("[a-z0-9][a-z0-9_.-]{0,63}");
   private final Path v2;
   private final Executor v3;
   @Nullable
   private final InternalSupport60.Part6 v4;

   public InternalSupport61(Path var1, Executor var2, @Nullable InternalSupport60.Part6 var3) {
      this.v2 = var1;
      this.v3 = var2;
      this.v4 = var3;
   }

   public Path v1() {
      return this.v2;
   }

   public boolean v1(String var1) {
      return v1.matcher(var1).matches() && Files.isRegularFile(this.v2.resolve(var1).resolve("cosmetic.json"));
   }

   public List<String> v2() {
      ArrayList var1 = new ArrayList();
      if (!Files.isDirectory(this.v2)) {
         return var1;
      } else {
         try (Stream var2 = Files.list(this.v2)) {
            var2.<String>map(var0 -> var0.getFileName().toString()).filter(this::v1).sorted().forEach(var1::add);
         } catch (IOException var7) {
         }

         return var1;
      }
   }

   public cloudSupport50 v2(String var1) throws cloudSupport38 {
      if (!this.v1(var1)) {
         throw new cloudSupport38("no source folder for " + var1);
      } else {
         Path var2 = this.v2.resolve(var1);
         return cloudSupport39.v1((cloudSupport39.Part1)(var1x -> {
            Path var2x = var2.resolve(var1x).normalize();
            if (!var2x.startsWith(var2)) {
               throw new IOException(var1x + " is outside the cosmetic's folder");
            } else {
               return Files.readAllBytes(var2x);
            }
         }));
      }
   }

   @Override
   public void load(String var1, InternalSupport60.Part4 var2) {
      String var3 = InternalSupport60.v1(var1);
      if (!this.v1(var3)) {
         if (this.v4 != null) {
            this.v4.load(var1, var2);
         } else {
            var2.v1("not found");
         }
      } else {
         this.v3.execute(() -> {
            try {
               var2.v1(this.v2(var3));
            } catch (cloudSupport38 var4) {
               var2.v1(String.valueOf(var4.getMessage()));
            } catch (RuntimeException var5) {
               var2.v1(String.valueOf(var5));
            }
         });
      }
   }
}
