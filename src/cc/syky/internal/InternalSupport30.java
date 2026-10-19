package cc.syky.internal;

import cc.syky.serverrules.ServerRulesStore;
import cc.syky.serverrules.serverrulesSupport;
import cc.syky.ui.uiSupport226;
import java.util.Set;
import org.jetbrains.annotations.Nullable;

public final class InternalSupport30 {
   private final ServerRulesStore v1;
   private final uiSupport226 v2;
   @Nullable
   private String v3;
   private boolean v4;

   public InternalSupport30(ServerRulesStore var1, uiSupport226 var2) {
      this.v1 = var1;
      this.v2 = var2;
   }

   public void v1(@Nullable String var1) {
      this.v3 = var1;
      this.v1(false);
      this.v4 = true;
   }

   public void v1() {
      this.v3 = null;
      this.v4 = false;
      this.v1(false);
   }

   public void v2() {
      this.v1(this.v4);
   }

   @Nullable
   public serverrulesSupport.Part1 v3() {
      return this.v3 == null ? null : this.v1.v1().v1(this.v3);
   }

   private void v1(boolean var1) {
      serverrulesSupport.Part1 var2 = this.v3();
      this.v2.v1(var2 == null ? Set.of() : var2.v3(), var2 == null ? null : var2.v2(), var1);
   }
}
