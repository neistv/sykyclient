package cc.syky.ui;

import net.minecraft.class_2960;

public record uiRecord(long id, String name, class_2960 icon, int percent, long sampledNanos) {
   public long v1() {
      return this.id;
   }

   public String v2() {
      return this.name;
   }

   public class_2960 v3() {
      return this.icon;
   }

   public int v4() {
      return this.percent;
   }

   public long v5() {
      return this.sampledNanos;
   }
}
