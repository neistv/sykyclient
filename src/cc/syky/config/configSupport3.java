package cc.syky.config;

import cc.syky.cloud.cloudRecord10;
import cc.syky.cloud.cloudRecord11;
import cc.syky.cloud.cloudSupport95;
import cc.syky.cloud.cloudSupport99;
import cc.syky.hud.hudSupport75;
import java.util.ArrayList;
import java.util.List;

public final class configSupport3 {
   private configSupport3() {
   }

   public static List<configSupport4> v1(cloudSupport99 var0, hudSupport75 var1, cloudSupport95 var2) {
      ArrayList var3 = new ArrayList();

      for (String var5 : var0.v1()) {
         var3.add(new configSupport3.Part2(var0, var5));
      }

      for (String var8 : var2.v1()) {
         if (var1.v3(var8).isPresent()) {
            String var6 = var2.v6(var8);
            var3.add(new configSupport3.Part1(var1, var8, var6 == null ? var8 : var6));
         }
      }

      return var3;
   }

   public static List<String> v1(cloudSupport99 var0, hudSupport75 var1, cloudSupport95 var2, int var3) {
      if (var3 == -1) {
         return List.of();
      } else {
         ArrayList var4 = new ArrayList(1);

         for (configSupport4 var6 : v1(var0, var1, var2)) {
            if (var6.v3().v1() == var3) {
               var4.add(var6.v1());
            }
         }

         return var4;
      }
   }

   public static boolean v1(configSupport4 var0, configSupport4 var1) {
      return var0 != var1 && var0.v2() != var1.v2() && var0.v3().v1() != -1 && var0.v3().v1() == var1.v3().v1();
   }

   public record Part1(hudSupport75 binds, String targetId, String label) implements configSupport4 {
      @Override
      public boolean v2() {
         return false;
      }

      @Override
      public cloudRecord10 v3() {
         return this.binds.v3(this.targetId).map(cloudRecord11::v1).orElseGet(() -> cloudRecord10.v1(-1));
      }

      @Override
      public boolean v4() {
         return this.binds.v3(this.targetId).isEmpty();
      }

      @Override
      public void v1(cloudRecord10 var1) {
         if (var1.v1() == -1) {
            this.v5();
         } else {
            this.binds.v1(this.targetId, var1);
         }
      }

      @Override
      public void v5() {
         this.binds.v4(this.targetId);
      }

      public hudSupport75 v6() {
         return this.binds;
      }

      public String v7() {
         return this.targetId;
      }

      @Override
      public String v1() {
         return this.label;
      }
   }

   public record Part2(cloudSupport99 actions, String id) implements configSupport4 {
      @Override
      public String v1() {
         return this.actions.v1(this.id);
      }

      @Override
      public boolean v2() {
         return true;
      }

      @Override
      public cloudRecord10 v3() {
         return this.actions.v2(this.id);
      }

      @Override
      public boolean v4() {
         return this.actions.v4(this.id);
      }

      @Override
      public void v1(cloudRecord10 var1) {
         this.actions.v1(this.id, var1);
      }

      @Override
      public void v5() {
         this.actions.v5(this.id);
      }

      public cloudSupport99 v6() {
         return this.actions;
      }

      public String v7() {
         return this.id;
      }
   }
}
