package cc.syky.hud;

import java.util.ArrayList;
import java.util.EnumSet;
import java.util.List;
import java.util.Objects;
import org.jetbrains.annotations.Nullable;

public final class hudSupport47 {
   private final List<hudSupport47.Part1> v1;
   private final List<hudSupport47.Part2> v2;
   @Nullable
   private final EnumSet<BossBarSupport2> v3;

   private hudSupport47(List<hudSupport47.Part1> var1, List<hudSupport47.Part2> var2, @Nullable EnumSet<BossBarSupport2> var3) {
      this.v1 = var1;
      this.v2 = var2;
      this.v3 = var3;
   }

   public static hudSupport47 v1(HudManager var0, boolean var1) {
      ArrayList var2 = new ArrayList();

      for (HudElement var4 : var0.v9()) {
         var2.add(new hudSupport47.Part1(var4.v1(), var4.v3(), var4.v7(), var4.v8()));
      }

      ArrayList var7 = new ArrayList();

      for (HudElement var5 : var0.v8().v1()) {
         hudRecord3 var6 = var5.v11();
         if (var6 != null) {
            var7.add(new hudSupport47.Part2(var5.v1(), var6.v1().v1(), var6.v2(), var6.v3()));
         }
      }

      return new hudSupport47(List.copyOf(var2), List.copyOf(var7), var1 ? var0.v7() : null);
   }

   public boolean v1() {
      return this.v3 != null;
   }

   public void v1(HudManager var1) {
      this.v2(var1);

      for (hudSupport47.Part1 var3 : this.v1) {
         HudElement var4 = var1.v1(var3.v1());
         if (var4 != null) {
            var4.v26();
         }
      }

      if (this.v3 != null) {
         var1.v1(this.v3);
      }

      var1.v14();
      var1.v13();
   }

   public void v2(HudManager var1) {
      hudSupport41 var2 = var1.v8();
      var2.v4();

      for (hudSupport47.Part2 var4 : this.v2) {
         HudElement var5 = var1.v1(var4.v1());
         HudElement var6 = var1.v1(var4.v2());
         if (var5 != null && var6 != null) {
            var2.v2(var5, var6, var4.v3(), var4.v4());
         }
      }

      for (hudSupport47.Part1 var8 : this.v1) {
         HudElement var9 = var1.v1(var8.v1());
         if (var9 != null) {
            var9.v1(var8.v2());
            var9.v1(var8.v3(), var8.v4());
         }
      }
   }

   @Override
   public boolean equals(Object var1) {
      return var1 instanceof hudSupport47 var2 && this.v1.equals(var2.v1) && this.v2.equals(var2.v2) && Objects.equals(this.v3, var2.v3);
   }

   @Override
   public int hashCode() {
      return Objects.hash(this.v1, this.v2, this.v3);
   }

   public record Part1(String id, hudSupport52 anchor, float x, float y) {
      public String v1() {
         return this.id;
      }

      public hudSupport52 v2() {
         return this.anchor;
      }

      public float v3() {
         return this.x;
      }

      public float v4() {
         return this.y;
      }
   }

   public record Part2(String id, String parent, hudRecord3.Part1 side, hudRecord3.Part2 align) {
      public String v1() {
         return this.id;
      }

      public String v2() {
         return this.parent;
      }

      public hudRecord3.Part1 v3() {
         return this.side;
      }

      public hudRecord3.Part2 v4() {
         return this.align;
      }
   }
}
