package cc.syky.hud;

import cc.syky.cloud.cloudSupport101;
import cc.syky.cloud.cloudSupport2;
import cc.syky.ui.uiSupport223;
import net.minecraft.class_310;
import net.minecraft.class_642;
import org.jetbrains.annotations.Nullable;

public final class SingleplayerSupport extends CopiedSupport {
   public static final String v2 = "serverIp";
   private static final hudRecord2 v3 = new hudRecord2(22.0F, 22.0F, 10.0F, 7.0F, 40.0F, 8.0F);
   private static final String v4 = ":25565";
   private static final String v5 = "Singleplayer";
   private final cloudSupport101 v6;

   public SingleplayerSupport(cloudSupport101 var1, hudSupport52 var2, float var3, float var4) {
      super("serverIp", hudSupport49.v15, v3, var2, var3, var4);
      this.v6 = var1;
   }

   @Nullable
   @Override
   public String v1(cloudSupport2 var1) {
      String var2 = this.v49();
      if (var2 != null) {
         return uiSupport223.v5 ? "Protected" : var2;
      } else {
         class_310 var3 = this.v6.v1();
         return var3 != null && var3.method_1542() ? "Singleplayer" : null;
      }
   }

   @Nullable
   @Override
   public String v44() {
      return this.v49();
   }

   @Nullable
   private String v49() {
      class_310 var1 = this.v6.v1();
      if (var1 == null) {
         return null;
      } else {
         class_642 var2 = var1.method_1558();
         if (var2 == null) {
            return null;
         } else {
            String var3 = var2.field_3761;
            if (var3 != null && !var3.isEmpty()) {
               return var3.endsWith(":25565") ? var3.substring(0, var3.length() - ":25565".length()) : var3;
            } else {
               return null;
            }
         }
      }
   }
}
