package cc.syky.ui;

import cc.syky.cloud.PresenceService;
import cc.syky.cloud.cloudSupport69;
import com.mojang.blaze3d.systems.GpuDevice;
import com.mojang.blaze3d.systems.RenderSystem;
import java.util.function.BiConsumer;
import net.minecraft.class_1041;
import net.minecraft.class_310;
import net.minecraft.class_437;
import net.minecraft.class_500;
import net.minecraft.class_638;
import net.minecraft.class_641;
import net.minecraft.class_642;
import org.jetbrains.annotations.Nullable;

public final class uiSupport251 {
   private static final int v1 = 20;
   private final uiSupport252 v2;
   private final BiConsumer<String, String> v3;
   @Nullable
   private class_437 v4;
   @Nullable
   private class_638 v5;
   private String v6 = "none";
   private boolean v7;
   private boolean v8;
   private int v9;

   public uiSupport251(uiSupport252 var1, BiConsumer<String, String> var2) {
      this.v2 = var1;
      this.v3 = var2;
   }

   public void v1() {
      class_310 var1 = class_310.method_1551();
      if (var1 != null) {
         class_437 var2 = var1.field_1755;
         if (var2 != this.v4) {
            String var3 = this.v4 == null ? "none" : v1(this.v4);
            String var4 = var2 == null ? "none" : v1(var2);
            this.v4 = var2;
            this.v2.v7 = var2 == null ? null : var4;
            this.v3.accept("screen", var3 + " → " + var4);
         }

         class_638 var5 = var1.field_1687;
         if (var5 != this.v5) {
            if (var5 == null) {
               this.v3.accept("world", "leave");
            } else {
               this.v3.accept("world", (this.v5 == null ? "join " : "change ") + var5.method_27983().method_29177());
            }

            this.v5 = var5;
         }

         String var6 = v1(var1);
         if (!var6.equals(this.v6)) {
            this.v3.accept("server", var6.equals("none") ? "disconnect " + this.v6 : "connect " + var6);
            this.v6 = var6;
            this.v2.v8 = var6;
         }

         if (!this.v7 && var1.method_18506() == null) {
            this.v7 = true;
            this.v3.accept("lifecycle", "loaded");
         }

         if (!"shutdown".equals(this.v2.v6)) {
            this.v2.v6 = !this.v7 ? "boot" : (var5 != null ? "world" : "menu");
         }

         if (++this.v9 % 20 == 0) {
            this.v1(var1, var5 != null);
         }
      }
   }

   private void v1(class_310 var1, boolean var2) {
      class_1041 var3 = var1.method_22683();
      if (var3 != null) {
         this.v2.v9 = var3.method_4489() + "x" + var3.method_4506();
         this.v2.v10 = var3.method_4495();
      }

      this.v2.v2(var1.method_1548().method_1676());
      this.v2.v14 = PresenceService.v1(var1);
      class_642 var4 = var1.method_1558();
      if (var4 != null) {
         this.v2.v1(var4.field_3761);
      }

      if (var1.field_1755 instanceof class_500 var5) {
         class_641 var9 = var5.method_2529();
         if (var9 != null) {
            for (int var7 = 0; var7 < var9.method_2984(); var7++) {
               this.v2.v1(var9.method_2982(var7).field_3761);
            }
         }
      }

      if (var2) {
         this.v2.v15 = cloudSupport69.v1();
      }

      if (!this.v8) {
         GpuDevice var8 = RenderSystem.tryGetDevice();
         if (var8 != null) {
            this.v2.v11 = var8.getRenderer();
            this.v2.v12 = var8.getVendor();
            this.v2.v13 = var8.getVersion();
            this.v8 = true;
         }
      }
   }

   private static String v1(class_310 var0) {
      if (var0.method_1562() == null) {
         return "none";
      } else if (var0.method_1496()) {
         return "singleplayer";
      } else {
         class_642 var1 = var0.method_1558();
         return var1 != null && var1.method_52811() ? "realms" : "multiplayer";
      }
   }

   public static String v1(Object var0) {
      Class var1 = var0.getClass();
      String var2 = var1.getSimpleName();
      if (!var2.isEmpty()) {
         return var2;
      } else {
         String var3 = var1.getName();
         return var3.substring(var3.lastIndexOf(46) + 1);
      }
   }
}
