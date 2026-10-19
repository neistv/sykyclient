package cc.syky.cloud;

import java.util.List;

public record cloudRecord9(int tokenStart, List<String> options) {
   public static final cloudRecord9 EMPTY = new cloudRecord9(0, List.of());

   public boolean v1() {
      return this.options.isEmpty();
   }

   public int v2() {
      return this.tokenStart;
   }

   public List<String> v3() {
      return this.options;
   }
}
