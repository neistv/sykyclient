package cc.syky.module.utilities;

import cc.syky.api.ModuleInfo;
import cc.syky.module.Module;
import cc.syky.module.ModuleCategory;
import cc.syky.ui.uiRecord14;
import cc.syky.ui.uiSupport210;
import cc.syky.ui.uiSupport211;
import cc.syky.ui.uiSupport212;
import cc.syky.ui.uiSupport213;
import cc.syky.ui.uiSupport214;
import java.util.Arrays;
import net.minecraft.class_10799;
import net.minecraft.class_2561;
import net.minecraft.class_2960;
import net.minecraft.class_310;
import net.minecraft.class_332;
import net.minecraft.class_5481;
import net.minecraft.class_634;
import net.minecraft.class_640;
import net.minecraft.class_7532;
import net.minecraft.class_9848;
import org.jetbrains.annotations.Nullable;

@ModuleInfo(
   name = "chatheads",
   displayName = "Chat Heads",
   category = ModuleCategory.UTILITIES,
   group = "Readouts",
   description = "module.chatheads.description"
)
public final class ChatHeads extends Module {
   @Nullable
   private static ChatHeads v2;
   private final uiRecord14 name;
   private final uiSupport210 displayName = new uiSupport210();

   public ChatHeads(uiRecord14 var1) {
      this.name = var1;
      v2 = this;
      this.setToggleActions(() -> uiSupport213.v2 = true, this::v20);
   }

   @Override
   public void onEnableHook() {
      this.v21();
   }

   private void v20() {
      uiSupport213.v2 = false;
      uiSupport213.v3 = null;
      uiSupport213.v4 = null;
      uiSupport213.v5 = null;
      uiSupport213.v6 = null;
      uiSupport213.v13 = null;
      v22();
      class_310 var1 = this.name.v2().v1();
      if (var1 != null) {
         this.displayName.v2(var1);
      }

      this.v21();
   }

   private void v21() {
      class_310 var1 = this.name.v2().v1();
      if (var1 != null && var1.field_1705 != null) {
         var1.field_1705.method_1743().method_1817();
      }
   }

   public static void v1(class_2561 var0) {
      uiSupport213.v3 = null;
      ChatHeads var1 = v2;
      if (var1 != null && var1.isEnabled()) {
         class_634 var2 = var1.name.v2().v4();
         if (var2 != null) {
            uiSupport213.v3 = uiSupport212.v1(var0, var2);
         }
      }
   }

   public static ChatHeads.Part1 v1(class_2561 var0, uiSupport214[] var1) {
      return uiSupport211.v1(var0, var1);
   }

   public static int[] v1(class_5481 var0) {
      ChatHeads var1 = v2;
      class_310 var2 = var1 == null ? null : var1.name.v2().v1();
      return var2 == null ? uiSupport211.v1 : uiSupport211.v1(var0, var2.field_1772);
   }

   public static void v17() {
      class_332 var0 = uiSupport213.v13;
      ChatHeads var1 = v2;

      try {
         if (var1 != null && var0 != null) {
            var1.displayName.v1(var1.name.v2().v1());
         }

         if (var0 != null && var1 != null) {
            for (int var2 = 0; var2 < uiSupport213.v12; var2++) {
               var1.v1(var0, uiSupport213.v8[var2], uiSupport213.v9[var2], uiSupport213.v10[var2], uiSupport213.v11[var2]);
            }
         }
      } finally {
         uiSupport213.v13 = null;
         v22();
      }
   }

   private static void v22() {
      Arrays.fill(uiSupport213.v8, 0, uiSupport213.v12, null);
      uiSupport213.v12 = 0;
   }

   private void v1(class_332 var1, uiSupport214 var2, int var3, int var4, float var5) {
      class_310 var6 = this.name.v2().v1();
      class_640 var7 = var2.v1(this.name.v2().v4());
      if (var6 != null && var7 != null) {
         class_2960 var8 = var7.method_52810().comp_1626().comp_3627();
         boolean var9 = var7.method_65195();
         int var10 = class_9848.method_61317(var5);
         byte var11 = 8;
         uiSupport210.Part1 var12 = this.displayName.v1(var6, var8, var9);
         if (var12 == null) {
            class_7532.method_44445(var1, var8, var3, var4, var11, var9, false, var10);
         } else {
            int var13 = var12.v2();
            var1.method_25293(class_10799.field_56883, var12.v1(), var3, var4, 0.0F, 0.0F, var11, var11, var13, var13, var13, var13, var10);
         }
      }
   }

   public record Part1(class_2561 text, uiSupport214[] heads) {
      public class_2561 v1() {
         return this.text;
      }

      public uiSupport214[] v2() {
         return this.heads;
      }
   }
}
