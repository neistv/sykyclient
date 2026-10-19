package cc.syky.ui;

import cc.syky.hud.OffHandSupport;
import cc.syky.hud.PercentSupport;
import net.minecraft.class_1799;
import org.jetbrains.annotations.Nullable;

public record uiRecord4(@Nullable OffHandSupport.Part1 piece, class_1799 stack, String name, int remaining, int max, String points) {
   public static uiRecord4 v1(OffHandSupport.Part1 var0, class_1799 var1) {
      int var2 = var1.method_7936();
      int var3 = PercentSupport.v1(var1.method_7919(), var2);
      return new uiRecord4(var0, var1.method_7972(), var1.method_63693().getString(), var3, var2, Integer.toString(var3));
   }

   public int v1() {
      return PercentSupport.v2(this.remaining, this.max);
   }

   @Nullable
   public OffHandSupport.Part1 v2() {
      return this.piece;
   }

   public class_1799 v3() {
      return this.stack;
   }

   public String v4() {
      return this.name;
   }

   public int v5() {
      return this.remaining;
   }

   public int v6() {
      return this.max;
   }

   public String v7() {
      return this.points;
   }
}
