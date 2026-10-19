package cc.syky.ui;

import cc.syky.module.utilities.CommandFix;
import net.minecraft.class_327;
import net.minecraft.class_332;
import net.minecraft.class_342;
import org.jetbrains.annotations.Nullable;

public final class uiSupport145 {
   private static final int v1 = -805306368;
   private static final int v2 = -11141291;
   private static final int v3 = 2;
   private static final int v4 = 2;
   private final class_342 v5;
   private final class_327 v6;
   @Nullable
   private String v7;
   @Nullable
   private String v8;

   public uiSupport145(class_342 var1, class_327 var2) {
      this.v5 = var1;
      this.v6 = var2;
   }

   public void v1() {
      String var1 = this.v5.method_1882();
      if (!var1.equals(this.v7)) {
         this.v7 = var1;
         this.v8 = CommandFix.v2(var1);
      }
   }

   public void v1(class_332 var1) {
      String var2 = this.v8;
      if (var2 != null) {
         int var3 = this.v6.method_1727(var2) + 4;
         int var4 = 9 + 2;
         int var5 = this.v5.method_46426();
         int var6 = this.v5.method_46427() - var4 * this.v2() - 1;
         var1.method_25294(var5, var6, var5 + var3, var6 + var4, -805306368);
         var1.method_25303(this.v6, var2, var5 + 2, var6 + 1, -11141291);
      }
   }

   private int v2() {
      String var1 = this.v7;
      return var1 != null && var1.startsWith("/") ? 2 : 1;
   }
}
