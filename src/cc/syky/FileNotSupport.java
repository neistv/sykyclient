package cc.syky;

import cc.syky.internal.InternalSupport22;
import cc.syky.internal.InternalSupport23;
import cc.syky.internal.InternalSupport56;
import cc.syky.internal.InternalSupport57;
import java.nio.file.Files;
import java.nio.file.InvalidPathException;
import java.nio.file.Path;
import net.minecraft.class_2960;
import org.jetbrains.annotations.Nullable;

public final class FileNotSupport {
   public static final long v1 = 8388608L;
   private final InternalSupport57 v2;
   private final InternalSupport56 v3;
   @Nullable
   private InternalSupport23 v4;
   private String v5 = "";
   private int v6;
   private boolean v7;
   @Nullable
   private String v8;
   private int v9;
   private int v10;
   private int v11;
   private boolean v12;
   private boolean v13;

   public FileNotSupport(InternalSupport57 var1, InternalSupport56 var2) {
      this.v2 = var1;
      this.v3 = var2;
   }

   @Nullable
   public InternalSupport23 v1() {
      return this.v4;
   }

   @Nullable
   public String v2() {
      return this.v7 && this.v4 == null ? "Loading..." : this.v8;
   }

   public void v1(String var1, int var2) {
      if (!var1.equals(this.v5)) {
         this.v5 = var1;
         this.v6++;
         this.v8 = null;
         this.v13 = false;
         this.v4();
         this.v7 = false;
         if (!var1.isEmpty()) {
            this.v2(var1, InternalSupport22.v1(var2, true));
         }
      }
   }

   public void v1(int var1) {
      if (var1 > 0 && !this.v7 && !this.v13 && this.v4 != null && !this.v5.isEmpty()) {
         if (InternalSupport22.v1(this.v10, this.v9, var1, this.v11, this.v12)) {
            this.v2(this.v5, InternalSupport22.v1(var1, this.v12));
         }
      }
   }

   public void v3() {
      this.v6++;
      this.v5 = "";
      this.v7 = false;
      this.v8 = null;
      this.v4();
   }

   private void v2(String var1, int var2) {
      this.v7 = true;
      int var3 = ++this.v6;
      this.v2.v1(() -> {
         Path var4 = v1(var1);
         if (var4 != null && Files.isRegularFile(var4)) {
            DecompilationFailedSupport.Part2 var5 = DecompilationFailedSupport.v1(var4, 8388608L, var2);
            this.v3.v1(() -> this.v1(var3, var5, var2));
         } else {
            this.v3.v1(() -> this.v1(var3, "File not found"));
         }
      });
   }

   @Nullable
   private static Path v1(String var0) {
      try {
         return Path.of(var0);
      } catch (InvalidPathException var2) {
         return null;
      }
   }

   private void v1(int var1, String var2) {
      if (var1 == this.v6) {
         this.v7 = false;
         this.v8 = var2;
         this.v4();
      }
   }

   private void v1(int var1, @Nullable DecompilationFailedSupport.Part2 var2, int var3) {
      if (var1 != this.v6) {
         if (var2 != null) {
            var2.v1().close();
         }
      } else if (var2 == null) {
         if (this.v4 == null) {
            this.v1(var1, "Can't read file");
         }

         this.v13 = true;
         this.v7 = false;
      } else {
         InternalSupport23 var4 = InternalSupport23.v1(class_2960.method_60655("syky", "inventory_background/picture_" + var1), var2);
         this.v7 = false;
         if (var4 == null) {
            if (this.v4 == null) {
               this.v8 = "Can't read file";
            }
         } else {
            this.v4();
            this.v4 = var4;
            this.v8 = null;
            this.v9 = Math.max(var2.v2(), var2.v3());
            this.v10 = var3;
            this.v11 = Math.max(var2.v7(), var2.v8());
            this.v12 = var2.v5() > 1;
         }
      }
   }

   private void v4() {
      InternalSupport23 var1 = this.v4;
      if (var1 != null) {
         var1.close();
         this.v4 = null;
      }
   }
}
