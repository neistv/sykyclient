package cc.syky.cloud;

import java.util.List;
import net.minecraft.class_2561;
import net.minecraft.class_345;
import net.minecraft.class_1259.class_1260;
import net.minecraft.class_1259.class_1261;

public record cloudRecord3(List<cloudRecord3.Part1> bars) {
   public static final cloudRecord3 EMPTY = new cloudRecord3(List.of());

   public boolean v1() {
      return this.bars.isEmpty();
   }

   public int v2() {
      return this.bars.size();
   }

   public int v3() {
      int var1 = 0;

      for (cloudRecord3.Part1 var3 : this.bars) {
         if (var3.v6() > var1) {
            var1 = var3.v6();
         }
      }

      return var1;
   }

   public List<cloudRecord3.Part1> v4() {
      return this.bars;
   }

   public record Part1(class_345 source, class_2561 name, int nameWidth) {
      public float v1() {
         return this.source.method_5412();
      }

      public class_1260 v2() {
         return this.source.method_5420();
      }

      public class_1261 v3() {
         return this.source.method_5415();
      }

      public class_345 v4() {
         return this.source;
      }

      public class_2561 v5() {
         return this.name;
      }

      public int v6() {
         return this.nameWidth;
      }
   }
}
