package cc.syky.ui;

import cc.syky.cloud.cloudSupport95;
import cc.syky.module.ModuleContract;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.function.BiConsumer;
import org.jetbrains.annotations.Nullable;

public final class uiSupport227 implements cloudSupport95 {
   private final uiSupport226 v1;
   private final BiConsumer<ModuleContract, String> v2;

   public uiSupport227(uiSupport226 var1) {
      this(var1, (var0, var1x) -> {});
   }

   public uiSupport227(uiSupport226 var1, BiConsumer<ModuleContract, String> var2) {
      this.v1 = var1;
      this.v2 = var2;
   }

   @Override
   public boolean v1(String var1) {
      return this.v1.v6(var1) != null;
   }

   @Override
   public boolean v2(String var1) {
      ModuleContract var2 = this.v1.v6(var1);
      return var2 != null && var2.isEnabled();
   }

   @Override
   public void v3(String var1) {
      this.v1.v5(var1);
   }

   @Override
   public void v4(String var1) {
      this.v1.v2(var1);
   }

   @Override
   public boolean v8(String var1) {
      String var2 = this.v1.v8(var1);
      ModuleContract var3 = this.v1.v6(var1);
      if (var2 != null && var3 != null) {
         this.v2.accept(var3, var2);
         return true;
      } else {
         return false;
      }
   }

   @Override
   public void v5(String var1) {
      this.v1.v4(var1);
   }

   @Nullable
   @Override
   public String v6(String var1) {
      ModuleContract var2 = this.v1.v6(var1);
      return var2 == null ? null : var2.getDisplayName();
   }

   @Override
   public Collection<String> v1() {
      ArrayList var1 = new ArrayList();

      for (ModuleContract var3 : this.v1.v1()) {
         var1.add(var3.getName());
      }

      return List.copyOf(var1);
   }
}
