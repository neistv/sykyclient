package cc.syky.module.visual;

import cc.syky.AddImageSupport;
import cc.syky.internal.InternalSupport56;
import cc.syky.internal.InternalSupport57;
import java.nio.file.InvalidPathException;
import java.nio.file.Path;
import org.jetbrains.annotations.Nullable;

public final class visualSupport {
   private final InternalSupport57 v1;
   private final InternalSupport56 v2;
   private final String v3;
   private final Runnable v4;
   private boolean v5;
   @Nullable
   private Path v6;

   public visualSupport(InternalSupport57 var1, InternalSupport56 var2, String var3, Runnable var4) {
      this.v1 = var1;
      this.v2 = var2;
      this.v3 = var3;
      this.v4 = var4;
   }

   public boolean v1() {
      return this.v5;
   }

   public void v1(visualSupport7 var1) {
      if (!this.v5 && !AddImageSupport.v1()) {
         this.v5 = true;
         Path var2 = this.v6 != null ? this.v6 : v1(var1.v12());
         this.v1.v1(() -> {
            Path var3 = AddImageSupport.v1(var2, this.v3);
            this.v2.v1(() -> {
               this.v5 = false;
               if (var3 != null) {
                  this.v6 = var3.getParent();
                  String var3x = var3.toAbsolutePath().toString();
                  if (var3x.equals(var1.v12())) {
                     this.v4.run();
                  }

                  var1.v1(var3x);
               }
            });
         });
      }
   }

   @Nullable
   private static Path v1(String var0) {
      if (var0.isEmpty()) {
         return null;
      } else {
         try {
            return Path.of(var0).getParent();
         } catch (InvalidPathException var2) {
            return null;
         }
      }
   }
}
