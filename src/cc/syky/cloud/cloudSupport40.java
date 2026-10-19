package cc.syky.cloud;

import cc.syky.internal.InternalSupport61;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public final class cloudSupport40 {
   private cloudSupport40() {
   }

   public static void v1(String[] var0) throws IOException {
      if (var0.length != 2) {
         System.err.println("usage: Baker <source folder> <output folder>");
         System.exit(2);
      }

      Path var1 = Path.of(var0[0]);
      Path var2 = Path.of(var0[1]);
      InternalSupport61 var3 = new InternalSupport61(var1, Runnable::run, null);
      List var4 = var3.v2();
      if (var4.isEmpty()) {
         System.err.println("no cosmetics under " + var1.toAbsolutePath());
         System.exit(1);
      }

      Files.createDirectories(var2);
      int var5 = 0;

      for (String var7 : var4) {
         try {
            cloudSupport50 var8 = var3.v2(var7);
            byte[] var9 = PNGNotSupport.v1(var8);
            PNGNotSupport.v1(var9);
            Files.write(var2.resolve(var7 + ".sykc"), var9);
            System.out.printf("%-24s %-6s %7d bytes  %s%n", var7, var8.v2().v1(), var9.length, PNGNotSupport.v2(var9));
         } catch (cloudSupport38 var10) {
            var5++;
            System.err.println(var7 + ": " + var10.getMessage());
         }
      }

      if (var5 > 0) {
         System.exit(1);
      }
   }
}
