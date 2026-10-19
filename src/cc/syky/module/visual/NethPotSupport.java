package cc.syky.module.visual;

import cc.syky.hud.hudSupport64;
import org.jetbrains.annotations.Nullable;

public enum NethPotSupport implements hudSupport64 {
   VANILLA("Vanilla", '\ue708', "vanilla"),
   UHC("UHC", '\ue707', "uhc"),
   POT("Pot", '\ue704', "pot"),
   NETHPOT("Neth Pot", '\ue703', "nethop", "neth_pot", "npot", "netherpot", "nethpot", "netherite"),
   SMP("SMP", '\ue705', "smp"),
   SWORD("Sword", '\ue706', "sword"),
   AXE("Axe", '\ue701', "axe"),
   MACE("Mace", '\ue702', "mace");

   private final String label;
   private final char icon;
   private final String[] ids;

   private NethPotSupport(String var3, char var4, String... var5) {
      this.label = var3;
      this.icon = var4;
      this.ids = var5;
   }

   @Override
   public String v1() {
      return this.label;
   }

   public char v2() {
      return this.icon;
   }

   public String[] v3() {
      return this.ids;
   }

   public boolean v1(@Nullable String var1) {
      for (String var5 : this.ids) {
         if (var5.equalsIgnoreCase(var1)) {
            return true;
         }
      }

      return false;
   }

   @Nullable
   public static NethPotSupport v2(@Nullable String var0) {
      for (NethPotSupport var4 : values()) {
         if (var4.v1(var0)) {
            return var4;
         }
      }

      return null;
   }
}
