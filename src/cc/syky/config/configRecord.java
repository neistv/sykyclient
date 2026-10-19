package cc.syky.config;

import cc.syky.hud.hudSupport75;
import cc.syky.module.ModuleContract;
import cc.syky.ui.uiSupport143;
import cc.syky.ui.uiSupport146;
import cc.syky.ui.uiSupport148;
import cc.syky.ui.uiSupport226;
import java.util.List;
import net.minecraft.class_2960;
import org.jetbrains.annotations.Nullable;

public record configRecord(
   String title,
   @Nullable class_2960 icon,
   @Nullable ModuleContract module,
   @Nullable uiSupport226 modules,
   @Nullable hudSupport75 binds,
   @Nullable BooleanSetting gate,
   boolean nested,
   List<configRecord.Part1> actions,
   @Nullable String bindId
) {
   @Nullable
   public String v1() {
      return this.bindId;
   }

   public configRecord.Part1 v1(int var1) {
      return this.actions.get(var1);
   }

   public int v2() {
      return this.actions.size();
   }

   public static configRecord v1(ModuleContract var0, uiSupport226 var1, @Nullable hudSupport75 var2) {
      return new configRecord(
         var0.getDisplayName(), uiSupport143.v1(var0.getCategory()), var0, var1, var2, null, false, List.of(), var2 == null ? null : var0.getName()
      );
   }

   public static configRecord v1(String var0, @Nullable class_2960 var1) {
      return new configRecord(var0, var1, null, null, null, null, false, List.of(), null);
   }

   public static configRecord v1(String var0, @Nullable class_2960 var1, configRecord.Part1... var2) {
      return new configRecord(var0, var1, null, null, null, null, false, List.of(var2), null);
   }

   public static configRecord v1(String var0, @Nullable class_2960 var1, hudSupport75 var2, String var3, configRecord.Part1... var4) {
      return new configRecord(var0, var1, null, null, var2, null, false, List.of(var4), var3);
   }

   public configRecord v1(String var1, Setting<?> var2) {
      BooleanSetting var3 = var2 instanceof BooleanSetting var4 ? var4 : null;
      return new configRecord(var1, this.icon, this.module, this.modules, null, var3, true, List.of(), null);
   }

   public boolean v3() {
      BooleanSetting var1 = this.gate;
      if (var1 != null) {
         return var1.getValue();
      } else {
         ModuleContract var2 = this.module;
         return var2 == null || var2.isEnabled();
      }
   }

   public boolean v4() {
      if (this.gate != null) {
         return true;
      } else {
         ModuleContract var1 = this.module;
         uiSupport226 var2 = this.modules;
         return !this.nested && var1 != null && var2 != null && var2.v8(var1.getName()) == null;
      }
   }

   public void v5() {
      BooleanSetting var1 = this.gate;
      if (var1 != null) {
         var1.setValue(!var1.getValue());
         uiSupport148.v1(uiSupport146.v1(var1.getValue()));
      } else if (!this.nested) {
         ModuleContract var2 = this.module;
         uiSupport226 var3 = this.modules;
         if (var2 != null && var3 != null) {
            var3.v5(var2.getName());
            uiSupport148.v1(uiSupport146.v1(var2.isEnabled()));
         }
      }
   }

   @Nullable
   public String v6() {
      ModuleContract var1 = this.module;
      return var1 == null ? null : var1.getName();
   }

   public String v7() {
      return this.title;
   }

   @Nullable
   public class_2960 v8() {
      return this.icon;
   }

   @Nullable
   public ModuleContract v9() {
      return this.module;
   }

   @Nullable
   public uiSupport226 v10() {
      return this.modules;
   }

   @Nullable
   public hudSupport75 v11() {
      return this.binds;
   }

   @Nullable
   public BooleanSetting v12() {
      return this.gate;
   }

   public boolean v13() {
      return this.nested;
   }

   public List<configRecord.Part1> v14() {
      return this.actions;
   }

   public record Part1(class_2960 icon, float iconWidth, float iconHeight, String tip, Runnable run) {
      public class_2960 v1() {
         return this.icon;
      }

      public float v2() {
         return this.iconWidth;
      }

      public float v3() {
         return this.iconHeight;
      }

      public String v4() {
         return this.tip;
      }

      public Runnable v5() {
         return this.run;
      }
   }
}
