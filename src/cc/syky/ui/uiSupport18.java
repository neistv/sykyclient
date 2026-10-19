package cc.syky.ui;

import cc.syky.hud.SleepInSupport;
import java.util.ArrayList;
import java.util.List;
import net.minecraft.class_12197;
import net.minecraft.class_12206;
import net.minecraft.class_12328;
import net.minecraft.class_12329;
import net.minecraft.class_1937;
import net.minecraft.class_6880;
import org.jetbrains.annotations.Nullable;

public final class uiSupport18 implements SleepInSupport.Part1 {
   private static final class_12197<Float> v1 = class_12206.field_64348;
   @Nullable
   private class_1937 v2;
   private final List<class_12328<Float, ?>> v3 = new ArrayList<>(2);
   private long v4;
   private int v5;

   public uiSupport18() {
   }

   public boolean v1(class_1937 var1) {
      if (var1 != this.v2) {
         this.v2 = var1;
         this.v3.clear();

         for (class_6880 var3 : var1.method_8597().comp_5222()) {
            class_12329 var4 = (class_12329)var3.comp_349();
            if (var4.method_76487().contains(v1)) {
               this.v3.add(var4.method_76479(v1, () -> this.v4));
            }
         }
      }

      return !this.v3.isEmpty();
   }

   @Override
   public float v1(long var1) {
      this.v4 = var1;
      this.v5++;
      Float var3 = (Float)v1.method_75650();

      for (class_12328 var5 : this.v3) {
         var3 = (Float)var5.applyTimeBased(var3, this.v5);
      }

      return var3;
   }

   public void v1() {
      this.v2 = null;
      this.v3.clear();
   }
}
