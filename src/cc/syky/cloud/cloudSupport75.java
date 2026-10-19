package cc.syky.cloud;

import java.util.List;

public final class cloudSupport75 implements cloudSupport82 {
   private final cloudSupport80 v1;

   public cloudSupport75(cloudSupport80 var1) {
      this.v1 = var1;
   }

   @Override
   public String v1() {
      return "help";
   }

   @Override
   public String v2() {
      return "list available commands";
   }

   @Override
   public void v1(cloudSupport81 var1, List<String> var2) {
      var1.v1("syky commands:");

      for (cloudSupport82 var4 : this.v1.v1()) {
         var1.v1("  ." + var4.v1() + " — " + var4.v2());
      }
   }
}
