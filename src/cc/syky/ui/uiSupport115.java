package cc.syky.ui;

import cc.syky.hud.hudSupport57;
import java.util.ArrayList;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.Function;
import java.util.function.Predicate;
import org.jetbrains.annotations.Nullable;

public final class uiSupport115<R extends UiWidget> extends UiNode {
   public static final float v1 = 27.1F;
   private final Object v6;
   private final String v7;
   private final List<R> v8 = new ArrayList<>();
   public int v2 = -1;
   private final hudSupport57 v13;
   public float v3;
   private float v14;
   private float v15 = 54.0F;
   public boolean v4;
   private boolean v16;
   private boolean v18;
   private float v19;
   public boolean v5;

   public uiSupport115(Object var1, String var2, float var3, boolean var4) {
      this.v6 = var1;
      this.v7 = var2;
      this.v19 = var3;
      float var5 = var4 ? 0.0F : 1.0F;
      this.v13 = uiSupport103.v1(var5);
      this.v3 = var5;
   }

   public Object v1() {
      return this.v6;
   }

   public String v2() {
      return this.v7;
   }

   public List<R> v3() {
      return this.v8;
   }

   public uiSupport115<R> v1(float var1) {
      this.v15 = var1;
      return this;
   }

   private float v15() {
      return this.v7.isEmpty() ? 0.0F : 27.1F;
   }

   public void v1(int var1) {
      this.v2 = var1;
      this.v5 = true;
   }

   public void v2(float var1) {
      this.v19 = var1;

      for (UiWidget var3 : this.v8) {
         var3.v1(var1);
      }
   }

   public <T> void v1(List<T> var1, Function<T, String> var2, Function<T, R> var3, BiConsumer<R, T> var4, Predicate<R> var5) {
      this.v16 = false;
      ArrayList var6 = new ArrayList(var1.size());

      for (Object var8 : var1) {
         UiWidget var9 = this.v1((String)var2.apply(var8));
         if (var9 == null) {
            var9 = (UiWidget)var3.apply(var8);
            if (!var5.test(var9)) {
               continue;
            }
         } else {
            var4.accept(var9, var8);
         }

         var9.v19().v1(var5.test(var9));
         var6.add(var9);
      }

      uiSupport104.v1(this.v8, var6, var0 -> true, var0 -> {
         if (var0.v15()) {
            var0.v18();
         }

         var0.v19().v1(false);
      });
      this.v8.clear();
      this.v8.addAll(var6);
   }

   public void v4() {
      this.v16 = true;

      for (UiWidget var2 : this.v8) {
         if (var2.v15()) {
            var2.v18();
         }

         var2.v19().v1(false);
      }
   }

   public boolean v5() {
      for (UiWidget var2 : this.v8) {
         if (var2.v19().v1()) {
            return true;
         }
      }

      return false;
   }

   public boolean v6() {
      if (uiSupport103.v2(this.v3) > 0.0F) {
         return true;
      } else {
         for (UiWidget var2 : this.v8) {
            if (var2.v19().v5() > 0.0F) {
               return true;
            }
         }

         return false;
      }
   }

   public void v7() {
      this.v18 = false;

      for (UiWidget var2 : this.v8) {
         var2.v19().v2();
      }

      this.v13.v3(this.v5() ? 1.0F : 0.0F);
      this.v10();
   }

   public void v1(boolean var1) {
      this.v18 = var1;
   }

   public boolean v8() {
      return this.v16 && this.v8.isEmpty() && uiSupport103.v4(this.v3);
   }

   public float v9() {
      int var1 = 0;

      for (UiWidget var3 : this.v8) {
         if (var3.v19().v1()) {
            var1++;
         }
      }

      return var1 == 0 ? 0.0F : this.v15() + var1 * this.v15;
   }

   public void v10() {
      if (this.v18) {
         this.v4 = this.v5();
      } else {
         float var1 = 0.0F;
         boolean var2 = false;

         for (int var3 = this.v8.size() - 1; var3 >= 0; var3--) {
            UiWidget var4 = this.v8.get(var3);
            float var5 = var4.v19().v3();
            if (var4.v19().v6()) {
               this.v8.remove(var3);
            } else {
               var1 += var5;
               var2 |= var4.v19().v1();
            }
         }

         this.v14 = var1 * this.v15;
         this.v4 = var2;
         if (uiSupport103.v1()) {
            this.v13.v2(var2 ? 1.0F : 0.0F);
         } else {
            this.v13.v3(var2 ? 1.0F : 0.0F);
         }

         this.v3 = this.v13.v2();
      }
   }

   public float v11() {
      return this.v3 * SignInSupport.v4(this.v15(), this.v19) + this.v14 / this.v15 * SignInSupport.v4(this.v15, this.v19);
   }

   private float v16() {
      return this.v10 + this.v3 * SignInSupport.v4(this.v15(), this.v19);
   }

   public void v1(float var1, float var2, float var3) {
      this.v1(var1, var2, var3, this.v11());
      float var4 = SignInSupport.v4(this.v15, this.v19);
      float var5 = this.v16();
      float var6 = 0.0F;
      float var7 = 0.0F;
      UiWidget var8 = null;
      UiWidget var9 = null;

      for (UiWidget var11 : this.v8) {
         float var12 = var11.v19().v4() * var4;
         var11.v1(this.v9, var5 + var6, this.v11, var12);
         var11.v3(this.v15);
         var11.v2(var7);
         var6 += var12;
         var7 = Math.max(var7, var11.v19().v5());
         if (var12 > 0.0F) {
            if (var8 == null) {
               var8 = var11;
            }

            var9 = var11;
         }
      }

      for (UiWidget var14 : this.v8) {
         var14.v1(var14 == var8, var14 == var9);
      }
   }

   public boolean v1(uiSupport35 var1, float var2, float var3) {
      float var4 = this.v12();
      if (var4 >= 1.0F && !this.v7.isEmpty()) {
         this.v3(1.0F);
      }

      this.v18();
      boolean var5 = var4 > 0.0F && var4 < 1.0F && !this.v7.isEmpty();

      for (UiWidget var7 : this.v8) {
         if (v1(var7, var2, var3)) {
            float var8 = var7.v19().v5();
            if (var8 >= 1.0F) {
               var7.v1(var1, 1.0F, var7.v21() < 1.0F ? UiWidget.Part1.BAND : UiWidget.Part1.ALL);
            } else if (var8 > 0.0F) {
               var5 = true;
            }
         }
      }

      return var5;
   }

   public void v1(List<UiWidget> var1, float var2, float var3) {
      for (UiWidget var5 : this.v8) {
         if (v1(var5, var2, var3) && var5.v19().v5() >= 1.0F && var5.v21() < 1.0F) {
            var1.add(var5);
         }
      }
   }

   public void v2(uiSupport35 var1, float var2, float var3) {
      float var4 = this.v12();
      if (var4 > 0.0F && !this.v7.isEmpty()) {
         this.v3(var4);
      }

      this.v18();

      for (UiWidget var6 : this.v8) {
         float var7 = var6.v19().v5();
         if (var7 > 0.0F && v1(var6, var2, var3)) {
            var6.v2(var1, var7);
         }
      }
   }

   public float v12() {
      return uiSupport103.v2(this.v3);
   }

   public float v13() {
      return this.v10 + 19.1F * this.v19;
   }

   public void v3(float var1) {
      uiSupport169.v1("syky_sans", this.v7, this.v9 + 16.0F * this.v19, this.v10, 16.0F * this.v19, uiSupport155.v1(SignInSupport.v34(), var1));
   }

   private void v18() {
      float var1 = this.v16();
      float var2 = this.v10 + this.v12 - var1;
      float var3 = 0.0F;

      for (UiWidget var5 : this.v8) {
         var3 = Math.max(var3, var5.v19().v5());
      }

      if (var2 > 0.01F && var3 > 0.0F) {
         v1(this.v9, var1, this.v11, var2, var3, this.v19);
      }
   }

   public static void v1(float var0, float var1, float var2, float var3, float var4, float var5) {
      uiSupport169.v1(
         var0,
         var1,
         var2,
         var3,
         uiSupport155.v1(SignInSupport.v36(), var4),
         uiSupport155.v1(SignInSupport.v1(SignInSupport.v38(), var5), var4),
         SignInSupport.v2(var5),
         1.0F,
         uiRecord7.v1(18.0F * var5)
      );
   }

   @Override
   public void v1(uiSupport35 var1) {
      this.v2(var1, -Float.MAX_VALUE, Float.MAX_VALUE);
   }

   public boolean v3(float var1, float var2) {
      float var3 = this.v12();
      return var3 > 0.0F && var3 < 1.0F && !this.v7.isEmpty() && this.v10 < var2 && this.v13() > var1;
   }

   public void v2(List<UiWidget> var1, float var2, float var3) {
      for (UiWidget var5 : this.v8) {
         if (v1(var5, var2, var3)) {
            float var6 = var5.v19().v5();
            if (var6 > 0.0F && var6 < 1.0F) {
               var1.add(var5);
            }
         }
      }
   }

   private static boolean v1(UiWidget var0, float var1, float var2) {
      return var0.v10 < var2 && var0.v10 + var0.v12 > var1;
   }

   public void v1(uiSupport102 var1) {
      var1.v1(this);
      var1.v1(this.v9);
      var1.v1(this.v10);
      var1.v1(this.v11);
      var1.v1(this.v12);
      var1.v1(this.v3);
      var1.v1(this.v2);

      for (UiWidget var3 : this.v8) {
         var3.v1(var1);
      }
   }

   @Nullable
   public R v1(String var1) {
      for (UiWidget var3 : this.v8) {
         if (var3.v2().equals(var1)) {
            return (R)var3;
         }
      }

      return null;
   }

   @Nullable
   public R v14() {
      for (UiWidget var2 : this.v8) {
         if (var2.v15()) {
            return (R)var2;
         }
      }

      return null;
   }

   @Nullable
   public R v1(float var1, float var2, int var3, boolean var4) {
      for (UiWidget var6 : this.v8) {
         if (var4 ? var6.v2(var1, var2, var3) : var6.v17() && var6.v1(var1, var2)) {
            return (R)var6;
         }
      }

      return null;
   }
}
