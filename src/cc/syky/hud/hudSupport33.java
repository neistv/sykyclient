package cc.syky.hud;

import java.util.ArrayDeque;

public final class hudSupport33 {
   private static final int v1 = 100;
   private final ArrayDeque<hudSupport47> v2 = new ArrayDeque<>();
   private final ArrayDeque<hudSupport47> v3 = new ArrayDeque<>();

   public hudSupport33() {
   }

   public void v1(hudSupport47 var1) {
      this.v2.push(var1);

      while (this.v2.size() > 100) {
         this.v2.removeLast();
      }

      this.v3.clear();
   }

   public boolean v1(HudManager var1) {
      return v1(var1, this.v2, this.v3);
   }

   public boolean v2(HudManager var1) {
      return v1(var1, this.v3, this.v2);
   }

   public void v1() {
      this.v2.clear();
      this.v3.clear();
   }

   private static boolean v1(HudManager var0, ArrayDeque<hudSupport47> var1, ArrayDeque<hudSupport47> var2) {
      hudSupport47 var3 = (hudSupport47)var1.poll();
      if (var3 == null) {
         return false;
      } else {
         var2.push(hudSupport47.v1(var0, var3.v1()));
         var3.v1(var0);
         return true;
      }
   }
}
