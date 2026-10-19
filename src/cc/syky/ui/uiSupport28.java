package cc.syky.ui;

import cc.syky.hud.HudElement;
import cc.syky.hud.hudRecord4;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.jetbrains.annotations.Nullable;

public final class uiSupport28 {
   private final List<HudElement> v1 = new ArrayList<>();
   private final List<HudElement> v2 = Collections.unmodifiableList(this.v1);
   private int v3;

   public uiSupport28() {
   }

   public List<HudElement> v1() {
      return this.v2;
   }

   public int v2() {
      return this.v1.size();
   }

   public boolean v3() {
      return this.v1.isEmpty();
   }

   public boolean v1(HudElement var1) {
      return this.v1.contains(var1);
   }

   public int v4() {
      return this.v3;
   }

   @Nullable
   public HudElement v5() {
      return this.v1.size() == 1 ? this.v1.get(0) : null;
   }

   public void v2(HudElement var1) {
      if (this.v1.size() != 1 || this.v1.get(0) != var1) {
         this.v1.clear();
         this.v1.add(var1);
         this.v3++;
      }
   }

   public void v3(HudElement var1) {
      if (!this.v1.contains(var1)) {
         this.v1.add(var1);
         this.v3++;
      }
   }

   public void v4(HudElement var1) {
      if (this.v1.remove(var1)) {
         this.v3++;
      }
   }

   public void v6() {
      if (!this.v1.isEmpty()) {
         this.v1.clear();
         this.v3++;
      }
   }

   public void v1(List<HudElement> var1, List<HudElement> var2) {
      int var3 = var1.size();

      for (int var4 = 0; var4 < var2.size(); var4++) {
         if (!var1.contains(var2.get(var4))) {
            var3++;
         }
      }

      boolean var7 = var3 == this.v1.size();

      for (int var5 = 0; var7 && var5 < this.v1.size(); var5++) {
         HudElement var6 = this.v1.get(var5);
         var7 = var1.contains(var6) || var2.contains(var6);
      }

      if (!var7) {
         this.v1.clear();
         this.v1.addAll(var1);

         for (int var8 = 0; var8 < var2.size(); var8++) {
            HudElement var9 = (HudElement)var2.get(var8);
            if (!this.v1.contains(var9)) {
               this.v1.add(var9);
            }
         }

         this.v3++;
      }
   }

   public void v7() {
      for (int var1 = this.v1.size() - 1; var1 >= 0; var1--) {
         HudElement var2 = this.v1.get(var1);
         if (!var2.v10() || !var2.v42()) {
            this.v1.remove(var1);
            this.v3++;
         }
      }
   }

   public hudRecord4 v8() {
      float var1 = Float.POSITIVE_INFINITY;
      float var2 = Float.POSITIVE_INFINITY;
      float var3 = Float.NEGATIVE_INFINITY;
      float var4 = Float.NEGATIVE_INFINITY;

      for (int var5 = 0; var5 < this.v1.size(); var5++) {
         hudRecord4 var6 = this.v1.get(var5).v27();
         if (!var6.v1()) {
            var1 = Math.min(var1, var6.v2());
            var2 = Math.min(var2, var6.v3());
            var3 = Math.max(var3, var6.v2() + var6.v4());
            var4 = Math.max(var4, var6.v3() + var6.v5());
         }
      }

      return var1 > var3 ? hudRecord4.EMPTY : new hudRecord4(var1, var2, var3 - var1, var4 - var2);
   }
}
