package cc.syky.module.visual;

import cc.syky.hud.hudSupport64;
import org.jetbrains.annotations.Nullable;

public enum CISSupport implements hudSupport64 {
   MCTIERS("McTiers", null),
   QAZTIERS("qaztiers", "KZ"),
   ATIERS("Atiers", "AT"),
   MYTIERS("MyTiers", "MT"),
   CISTIERS("CISTiers", "CIS");

   private final String label;
   @Nullable
   private final String badge;

   private CISSupport(String var3, @Nullable String var4) {
      this.label = var3;
      this.badge = var4;
   }

   @Override
   public String v1() {
      return this.label;
   }

   @Nullable
   public String v2() {
      return this.badge;
   }
}
