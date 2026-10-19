package cc.syky.ui;

import java.util.List;
import net.minecraft.class_2561;

public record uiRecord2(class_2561 title, int titleWidth, int width, List<uiRecord2.Part1> lines) {
   public static final uiRecord2 EMPTY = new uiRecord2(class_2561.method_43473(), 0, 0, List.of());

   public boolean v1() {
      return this.lines.isEmpty();
   }

   public int v2() {
      return this.lines.size();
   }

   public class_2561 v3() {
      return this.title;
   }

   public int v4() {
      return this.titleWidth;
   }

   public int v5() {
      return this.width;
   }

   public List<uiRecord2.Part1> v6() {
      return this.lines;
   }

   public record Part1(class_2561 name, class_2561 score, int scoreWidth) {
      public class_2561 v1() {
         return this.name;
      }

      public class_2561 v2() {
         return this.score;
      }

      public int v3() {
         return this.scoreWidth;
      }
   }
}
