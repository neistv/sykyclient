package cc.syky.hud;

import cc.syky.cloud.cloudSupport95;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Locale;
import org.jetbrains.annotations.Nullable;

public final class hudSupport51 implements cloudSupport95 {
   public static final String v1 = "hud.";
   private final HudManager v2;

   public hudSupport51(HudManager var1) {
      this.v2 = var1;
   }

   public static String v1(BossBarSupport2 var0) {
      return "hud." + var0.name().toLowerCase(Locale.ROOT);
   }

   @Nullable
   public static BossBarSupport2 v9(String var0) {
      if (var0 != null && var0.startsWith("hud.")) {
         String var1 = var0.substring("hud.".length()).toUpperCase(Locale.ROOT);

         for (BossBarSupport2 var5 : BossBarSupport2.values()) {
            if (var5.name().equals(var1)) {
               return var5;
            }
         }

         return null;
      } else {
         return null;
      }
   }

   @Nullable
   public String v1(HudElement var1) {
      BossBarSupport2 var2 = this.v2.v3(var1);
      return var2 == null ? null : v1(var2);
   }

   @Override
   public boolean v1(String var1) {
      return v9(var1) != null;
   }

   @Override
   public boolean v2(String var1) {
      BossBarSupport2 var2 = v9(var1);
      return var2 != null && this.v2.v3(var2);
   }

   @Override
   public void v3(String var1) {
      BossBarSupport2 var2 = v9(var1);
      if (var2 != null) {
         this.v2.v2(var2);
      }
   }

   @Override
   public void v4(String var1) {
      BossBarSupport2 var2 = v9(var1);
      if (var2 != null) {
         this.v2.v1(var2, true);
      }
   }

   @Override
   public void v5(String var1) {
      BossBarSupport2 var2 = v9(var1);
      if (var2 != null) {
         this.v2.v1(var2, false);
      }
   }

   @Nullable
   @Override
   public String v6(String var1) {
      BossBarSupport2 var2 = v9(var1);
      return var2 == null ? null : var2.v1();
   }

   @Override
   public Collection<String> v1() {
      ArrayList var1 = new ArrayList(BossBarSupport2.values().length);

      for (BossBarSupport2 var5 : BossBarSupport2.values()) {
         var1.add(v1(var5));
      }

      return List.copyOf(var1);
   }
}
