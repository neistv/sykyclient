package cc.syky.internal;

import cc.syky.AddImageSupport;
import cc.syky.DecompilationFailedSupport;
import cc.syky.hud.MySettingsSupport;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import java.nio.file.Path;
import net.minecraft.class_2960;
import net.minecraft.class_310;
import org.jetbrains.annotations.Nullable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public final class InternalSupport20 {
   private static final Logger v2 = LoggerFactory.getLogger("syky.hud.image");
   public static final String v1 = "_hudimages";
   private static final String v3 = "path";
   private final MySettingsSupport v4;
   private final InternalSupport57 v5;
   private final InternalSupport20.Part1[] v6 = new InternalSupport20.Part1[12];
   @Nullable
   private Path v7;

   public InternalSupport20(MySettingsSupport var1, InternalSupport57 var2) {
      this.v4 = var1;
      this.v5 = var2;

      for (int var3 = 0; var3 < this.v6.length; var3++) {
         this.v6[var3] = new InternalSupport20.Part1();
      }
   }

   public boolean v1(int var1) {
      return var1 == 0 || this.v11(var1) && this.v6[var1].v1;
   }

   @Nullable
   public InternalSupport23 v2(int var1) {
      return this.v11(var1) ? this.v6[var1].v3 : null;
   }

   public boolean v3(int var1) {
      return this.v11(var1) && this.v6[var1].v5;
   }

   public boolean v1() {
      for (int var1 = 1; var1 < this.v6.length; var1++) {
         if (!this.v6[var1].v1) {
            return true;
         }
      }

      return false;
   }

   public int v2() {
      int var1 = 1;

      for (int var2 = 1; var2 < this.v6.length; var2++) {
         if (this.v6[var2].v1) {
            var1++;
         }
      }

      return var1;
   }

   public int v3() {
      for (int var1 = 1; var1 < this.v6.length; var1++) {
         if (!this.v6[var1].v1) {
            this.v7(var1);
            this.v6[var1].v1 = true;
            this.v5();
            return var1;
         }
      }

      return -1;
   }

   public void v1(int var1, int var2) {
      if (this.v11(var1) && !this.v6[var1].v5 && !AddImageSupport.v1()) {
         InternalSupport20.Part1 var3 = this.v6[var1];
         var3.v5 = true;
         int var4 = ++var3.v4;
         Path var5 = this.v7;
         this.v5.v1(() -> {
            Path var5x = AddImageSupport.v1(var5);
            if (var5x == null) {
               class_310.method_1551().execute(() -> this.v3(var1, var4));
            } else {
               this.v1(var1, var4, var5x, var2, true);
            }
         });
      }
   }

   public void v2(int var1, int var2) {
      if (this.v11(var1)) {
         InternalSupport20.Part1 var3 = this.v6[var1];
         Path var4 = var3.v2;
         if (var4 != null && !var3.v5 && var3.v3 != null) {
            if (InternalSupport22.v1(var3.v8, var3.v7, var2, var3.v9, var3.v10)) {
               var3.v5 = true;
               int var5 = ++var3.v4;
               this.v5.v1(() -> this.v1(var1, var5, var4, var2, false));
            }
         }
      }
   }

   public void v4(int var1) {
      if (this.v11(var1)) {
         InternalSupport20.Part1 var2 = this.v6[var1];
         var2.v4++;
         var2.v5 = false;
         var2.v2 = null;
         v1(var2);
         this.v5();
      }
   }

   public void v5(int var1) {
      this.v1(var1, var1 != 0);
   }

   public void v6(int var1) {
      this.v1(var1, true);
   }

   private void v1(int var1, boolean var2) {
      if (this.v11(var1)) {
         InternalSupport20.Part1 var3 = this.v6[var1];
         var3.v4++;
         var3.v5 = false;
         var3.v2 = null;
         if (var1 != 0) {
            var3.v1 = false;
         }

         var3.v6 = var2 && var3.v3 != null;
         if (!var3.v6) {
            v1(var3);
         }

         this.v5();
      }
   }

   public void v7(int var1) {
      if (this.v11(var1) && this.v6[var1].v6) {
         InternalSupport20.Part1 var2 = this.v6[var1];
         var2.v6 = false;
         v1(var2);
      }
   }

   public long v8(int var1) {
      long var2 = 0L;

      for (int var4 = 0; var4 < this.v6.length; var4++) {
         InternalSupport23 var5 = this.v6[var4].v3;
         if (var5 != null && var4 != var1) {
            var2 += var5.v7();
         }
      }

      return Math.max(0L, Math.min(4194304L, 16777216L - var2));
   }

   @Nullable
   public Path v9(int var1) {
      return this.v11(var1) ? this.v6[var1].v2 : null;
   }

   public void v4() {
      this.v6();
      JsonObject var1 = this.v4.v11("_hudimages");
      if (var1 != null) {
         for (int var2 = 0; var2 < this.v6.length; var2++) {
            JsonElement var3 = var1.get(v10(var2));
            if (var3 != null && var3.isJsonObject()) {
               this.v6[var2].v1 = true;
               JsonElement var4 = var3.getAsJsonObject().get("path");
               if (var4 != null && var4.isJsonPrimitive()) {
                  String var5 = var4.getAsString();
                  if (!var5.isBlank()) {
                     this.v1(var2, var5);
                  }
               }
            }
         }
      }
   }

   private void v6() {
      for (InternalSupport20.Part1 var4 : this.v6) {
         var4.v4++;
         var4.v5 = false;
         var4.v1 = false;
         var4.v2 = null;
         var4.v6 = false;
         var4.v7 = 0;
         var4.v8 = 0;
         var4.v9 = 0;
         var4.v10 = false;
         v1(var4);
      }
   }

   private void v1(int var1, String var2) {
      Path var3;
      try {
         var3 = Path.of(var2);
      } catch (RuntimeException var7) {
         v2.warn("the config names a path this platform cannot read: {}", var2);
         return;
      }

      InternalSupport20.Part1 var4 = this.v6[var1];
      var4.v2 = var3;
      var4.v5 = true;
      int var5 = ++var4.v4;
      int var6 = Math.round(244.0F);
      this.v5.v1(() -> this.v1(var1, var5, var3, var6, false));
   }

   public void v5() {
      JsonObject var1 = new JsonObject();

      for (int var2 = 0; var2 < this.v6.length; var2++) {
         InternalSupport20.Part1 var3 = this.v6[var2];
         if (var3.v1 || var2 == 0) {
            JsonObject var4 = new JsonObject();
            Path var5 = var3.v2;
            if (var5 != null) {
               var4.addProperty("path", var5.toString());
            }

            if (var2 != 0 || var5 != null) {
               var1.add(v10(var2), var4);
            }
         }
      }

      this.v4.v2("_hudimages", var1);
   }

   private static String v10(int var0) {
      return "image_" + (var0 + 1);
   }

   private void v1(int var1, int var2, Path var3, int var4, boolean var5) {
      long var6 = this.v8(var1);
      int var8 = InternalSupport22.v1(var4, false);
      DecompilationFailedSupport.Part2 var9 = DecompilationFailedSupport.v1(var3, var6, var8);
      class_310 var10 = class_310.method_1551();
      if (var10 == null) {
         if (var9 != null) {
            var9.v1().close();
         }
      } else {
         var10.execute(() -> this.v1(var1, var2, var3, var9, var8, var5));
      }
   }

   private void v1(int var1, int var2, Path var3, @Nullable DecompilationFailedSupport.Part2 var4, int var5, boolean var6) {
      if (!this.v11(var1)) {
         v1(var4);
      } else {
         InternalSupport20.Part1 var7 = this.v6[var1];
         if (var7.v4 != var2) {
            v1(var4);
         } else {
            var7.v5 = false;
            if (var4 != null) {
               InternalSupport23 var8 = InternalSupport23.v1(class_2960.method_60655("syky", "hud_image/" + var1 + "_" + var2), var4);
               if (var8 != null) {
                  v1(var7);
                  var7.v3 = var8;
                  var7.v7 = Math.max(var4.v2(), var4.v3());
                  var7.v8 = var5;
                  var7.v9 = Math.max(var4.v7(), var4.v8());
                  var7.v10 = var4.v5() > 1;
                  var7.v2 = var3;
                  var7.v1 = true;
                  Path var9 = var3.getParent();
                  if (var9 != null) {
                     this.v7 = var9;
                  }

                  if (var6) {
                     this.v5();
                  }
               }
            }
         }
      }
   }

   private void v3(int var1, int var2) {
      if (this.v11(var1) && this.v6[var1].v4 == var2) {
         this.v6[var1].v5 = false;
      }
   }

   private static void v1(@Nullable DecompilationFailedSupport.Part2 var0) {
      if (var0 != null) {
         var0.v1().close();
      }
   }

   private static void v1(InternalSupport20.Part1 var0) {
      InternalSupport23 var1 = var0.v3;
      if (var1 != null) {
         var1.close();
         var0.v3 = null;
      }
   }

   private boolean v11(int var1) {
      return var1 >= 0 && var1 < this.v6.length;
   }

   public static final class Part1 {
      public boolean v1;
      @Nullable
      public Path v2;
      @Nullable
      public InternalSupport23 v3;
      public int v4;
      public boolean v5;
      public boolean v6;
      public int v7;
      public int v8;
      public int v9;
      public boolean v10;

      public Part1() {
      }
   }
}
