package cc.syky.cloud;

import net.minecraft.class_2960;
import org.jetbrains.annotations.Nullable;

public record cloudRecord(String id, String displayName, String keyLabel, @Nullable class_2960 icon) {
   public String v1() {
      return this.id;
   }

   public String v2() {
      return this.displayName;
   }

   public String v3() {
      return this.keyLabel;
   }

   @Nullable
   public class_2960 v4() {
      return this.icon;
   }
}
