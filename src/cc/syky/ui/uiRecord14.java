package cc.syky.ui;

import cc.syky.cloud.cloudSupport101;
import cc.syky.cloud.cloudSupport92;
import cc.syky.internal.InternalSupport56;
import cc.syky.internal.InternalSupport57;

public record uiRecord14(cloudSupport92 bus, cloudSupport101 mc, InternalSupport57 jobs, InternalSupport56 main) {
   public cloudSupport92 v1() {
      return this.bus;
   }

   public cloudSupport101 v2() {
      return this.mc;
   }

   public InternalSupport57 v3() {
      return this.jobs;
   }

   public InternalSupport56 v4() {
      return this.main;
   }
}
