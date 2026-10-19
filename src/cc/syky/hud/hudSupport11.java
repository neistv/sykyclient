package cc.syky.hud;

import cc.syky.cloud.cloudSupport12;
import cc.syky.ui.uiSupport169;
import java.util.List;
import java.util.function.Function;

public abstract class hudSupport11<T> extends AbstractHudWidget {
   public static final float v3 = 16.0F;
   public static final float v4 = 16.0F;
   public static final float v5 = 19.0F;
   private static final float v2 = 5.0F;
   private static final float v8 = 13.0F;
   private static final float v9 = 20.0F;
   private static final float v10 = 0.4F;
   public static final int v6 = -1;
   public static final int v7 = -855638017;
   private final hudSupport11.Part1 v11;
   private final cloudSupport12<List<T>> v12 = new cloudSupport12<>(var0 -> !var0.isEmpty());
   private final hudSupport17<T> v13;

   public hudSupport11(String var1, int var2, hudSupport52 var3, float var4, float var5, hudSupport11.Part1 var6, Function<T, Object> var7) {
      super(var1, var2, var3, var4, var5);
      this.v11 = var6;
      this.v13 = new hudSupport17<>(var7);
   }

   public abstract List<T> v14(hudSupport40 var1);

   public abstract float v40();

   public abstract void v2(float var1, float var2, float var3);

   public abstract float v1(T var1, float var2);

   public abstract void v1(T var1, float var2, float var3, float var4, float var5, float var6);

   public float v1(T var1, long var2) {
      return 1.0F;
   }

   @Override
   public boolean v11(hudSupport40 var1) {
      return this.v14(var1).isEmpty();
   }

   private hudSupport17<T> v5(hudSupport40 var1, float var2) {
      List var3 = this.v12.v1(this.v14(var1), this.v19());
      this.v13.v1(var3 == null ? List.of() : var3, System.nanoTime(), this.v18().v5());
      this.v13.v1(this.v6(19.0F, var2), this.v6(5.0F, var2));
      return this.v13;
   }

   @Override
   public void v17() {
      this.v12.v1();
      this.v13.v5();
   }

   @Override
   public float v3(hudSupport40 var1, hudRecord4 var2, float var3) {
      float var4 = this.v5(var1, var3).v4();
      float var5 = var2.v5() * 0.5F;
      return Math.min(var5, var5 + (20.0F * var3 - var5) * var4);
   }

   @Override
   public void v2(hudSupport40 var1, hudRecord4 var2, float var3) {
      hudSupport17 var4 = this.v5(var1, var3);
      float var5 = var2.v2();
      float var6 = var2.v3();
      float var7 = var2.v4();
      float var8 = var6 + this.v6(this.v11.v2(), var3);
      if (this.v2().v14()) {
         this.v2(var5, var8, var3);
      }

      this.v1("syky_sans_strong", this.v11.v1(), var5 + this.v40() * var3, var8 + this.v11.v3() * var3, 16.0F * var3, -1);
      float var9 = var8 + this.v6(this.v11.v4(), var3) + this.v6(this.v11.v5(), var3) * var4.v4();
      long var10 = System.nanoTime();

      for (hudSupport17.Part1 var13 : var4.v1()) {
         this.v1(var13, var1, var5, var9, var7, var3, var10);
      }
   }

   private void v1(hudSupport17.Part1<T> var1, hudSupport40 var2, float var3, float var4, float var5, float var6, long var7) {
      Object var9 = var1.v1();
      hudSupport18 var10 = var1.v5();
      float var11 = this.v6(19.0F, var6);
      float var12 = var4 + var1.v6() + (var1.v7() - var11) * 0.5F;
      float var13 = var10.v2() * this.v1((T)var9, var7);
      if (!(var13 <= 0.0F)) {
         this.v1(
            var3,
            var12,
            var5,
            var11,
            6.4F * var6,
            var13,
            var10.v4(),
            var10.v5(),
            var10.v6() * var2.v5(),
            var6x -> this.v1((T)var9, var3, var12, var5, var6, var6x)
         );
      }
   }

   @Override
   public AbstractHudWidget.Part1 v3(hudSupport40 var1, float var2) {
      hudSupport17 var3 = this.v5(var1, var2);
      float var4 = uiSupport169.v2("syky_sans_strong", this.v11.v1(), 16.0F * var2);
      float var5 = this.v40() * var2 + var4 + this.v11.v6() * var2;
      float var6 = 0.0F;

      for (hudSupport17.Part1 var8 : var3.v1()) {
         float var9 = this.v1((T)var8.v1(), var2) * var8.v5().v3();
         if (var9 > var6) {
            var6 = var9;
         }
      }

      float var10 = Math.max(this.v11.v7() * var2, Math.max(var5, var6));
      float var11 = this.v6(this.v11.v2(), var2) + this.v6(this.v11.v4(), var2) + this.v6(this.v11.v5(), var2) * var3.v4() + var3.v3() + this.v6(13.0F, var2);
      return this.v12(var10, var11);
   }

   public record Part1(String title, float padTop, float titleTop, float header, float headerToFirst, float padRight, float minWidth) {
      public String v1() {
         return this.title;
      }

      public float v2() {
         return this.padTop;
      }

      public float v3() {
         return this.titleTop;
      }

      public float v4() {
         return this.header;
      }

      public float v5() {
         return this.headerToFirst;
      }

      public float v6() {
         return this.padRight;
      }

      public float v7() {
         return this.minWidth;
      }
   }
}
