package cc.syky.internal;

import cc.syky.cloud.cloudRecord11;
import cc.syky.cloud.cloudSupport95;
import cc.syky.hud.hudSupport75;
import cc.syky.ui.uiSupport150;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

public final class InternalSupport24 implements Supplier<List<uiSupport150.Part1>> {
   private static final long v1 = 250000000L;
   private final hudSupport75 v2;
   private final cloudSupport95 v3;
   private List<uiSupport150.Part1> v4 = List.of();
   private long v5;

   public InternalSupport24(hudSupport75 var1, cloudSupport95 var2) {
      this.v2 = var1;
      this.v3 = var2;
   }

   public List<uiSupport150.Part1> v1() {
      long var1 = System.nanoTime();
      if (this.v5 != 0L && var1 - this.v5 < 250000000L) {
         return this.v4;
      } else {
         ArrayList var3 = new ArrayList();

         for (String var5 : this.v3.v1()) {
            cloudRecord11 var6 = this.v2.v3(var5).orElse(null);
            if (var6 != null && var6.v3() != -1) {
               String var7 = this.v3.v6(var5);
               var3.add(new uiSupport150.Part1(var5, var7 == null ? var5 : var7));
            }
         }

         this.v4 = List.copyOf(var3);
         this.v5 = var1;
         return this.v4;
      }
   }
}
