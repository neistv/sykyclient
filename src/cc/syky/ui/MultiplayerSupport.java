package cc.syky.ui;

import cc.syky.cloud.cloudSupport101;
import java.util.Objects;
import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.class_310;
import net.minecraft.class_642;
import org.jetbrains.annotations.Nullable;

public final class MultiplayerSupport {
   private static final int v1 = 20;
   private static final String v2 = ":25565";
   private static final String v3 = "Singleplayer";
   private static final String v4 = "Multiplayer";
   private static final String v5 = v5();
   private final cloudSupport101 v6;
   private final uiSupport246 v7;
   private long v8;
   @Nullable
   private String v9;
   @Nullable
   private String v10;
   @Nullable
   private String v11;

   public MultiplayerSupport(cloudSupport101 var1, uiSupport246 var2) {
      this.v6 = var1;
      this.v7 = var2;
   }

   public void v1() {
      this.v2();
   }

   public void v1(long var1) {
      if (var1 >= this.v8) {
         this.v8 = var1 + 20L;
         this.v2();
      }
   }

   private void v2() {
      if (uiSupport245.v1()) {
         String var1 = this.v3();
         if (!Objects.equals(var1, this.v9)) {
            this.v9 = var1;
            this.v7.v1(var1);
         }
      }
   }

   @Nullable
   private String v3() {
      if (uiSupport245.v2()) {
         String var1 = this.v4();
         if (var1 != null) {
            return var1;
         }
      }

      return uiSupport245.v3() ? v5 : null;
   }

   @Nullable
   private String v4() {
      class_310 var1 = this.v6.v1();
      if (var1 == null) {
         return null;
      } else {
         String var2 = this.v1(var1);
         if (var2 != null) {
            return uiSupport223.v5 ? "Protected" : var2;
         } else if (var1.method_1542()) {
            return "Singleplayer";
         } else {
            return var1.field_1687 == null ? null : "Multiplayer";
         }
      }
   }

   private static String v5() {
      String var0 = "Minecraft";
      String var1 = FabricLoader.getInstance().getModContainer("minecraft").map(var0x -> var0x.getMetadata().getVersion().getFriendlyString()).orElse("");
      return var1.isEmpty() ? var0 : var0 + " " + var1;
   }

   @Nullable
   private String v1(class_310 var1) {
      class_642 var2 = var1.method_1558();
      String var3 = var2 == null ? null : var2.field_3761;
      if (var3 == null || var3.isEmpty()) {
         this.v10 = null;
         this.v11 = null;
         return null;
      } else if (var3.equals(this.v10)) {
         return this.v11;
      } else {
         this.v10 = var3;
         this.v11 = var3.endsWith(":25565") ? var3.substring(0, var3.length() - ":25565".length()) : var3;
         return this.v11;
      }
   }
}
