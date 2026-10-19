package cc.syky.hud;

import cc.syky.cloud.cloudRecord5;
import cc.syky.cloud.cloudSupport12;
import cc.syky.ui.uiRecord7;
import cc.syky.ui.uiSupport169;
import cc.syky.ui.uiSupport21;
import cc.syky.ui.uiSupport22;
import cc.syky.ui.uiSupport23;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.function.Function;
import java.util.function.IntFunction;
import net.minecraft.class_2960;
import org.jetbrains.annotations.Nullable;

public abstract class hudSupport21<T> extends AbstractHudWidget {
   public static final float v3 = 36.0F;
   private static final float v2 = 18.0F;
   private static final float v6 = 6.0F;
   public static final float v4 = 18.0F;
   private static final float v7 = 9.0F;
   private static final float v8 = 9.0F;
   private static final float v9 = 36.0F;
   private static final float v10 = 10.0F;
   private static final float v11 = 12.0F;
   public static final float v5 = 16.0F;
   private static final int v12 = -419430401;
   private static final int v13 = -1;
   private static final float v14 = 2.0F;
   private static final float v15 = 420.0F;
   private static final float v16 = 280.0F;
   private static final float v18 = 300.0F;
   private static final float v19 = 18.0F;
   private static final float v17 = 280.0F;
   private static final float v20 = 220.0F;
   private static final float v21 = 5.0F;
   private static final float v22 = 14.0F;
   private static final float v24 = 0.25F;
   private static final int v25 = 536870911;
   private static final float v26 = 5.0F;
   private static final int v27 = -2130706433;
   private final hudSupport17<T> v28;
   private final cloudSupport12<List<T>> v29 = new cloudSupport12<>(var0 -> !var0.isEmpty());
   private final List<hudSupport17.Part1<T>> v30 = new ArrayList<>(8);
   private final List<hudSupport21.Part1<T>> v32 = new ArrayList<>(8);
   private final List<hudSupport21.Part1<T>> v23 = new ArrayList<>(8);
   private final Function<T, Object> v33;
   @Nullable
   private List<T> v31;
   private final uiSupport21 v34 = new uiSupport21(280.0F);
   private float v36 = -1.0F;
   private float v38;
   private float v42;
   private long v43;
   private float v37 = -1.0F;

   public hudSupport21(String var1, int var2, hudSupport52 var3, float var4, float var5, Function<T, Object> var6) {
      super(var1, var2, var3, var4, var5);
      this.v33 = var6;
      this.v28 = new hudSupport17<>(var6, 420.0F, 280.0F, 0.46F);
   }

   public abstract List<T> v15(hudSupport40 var1);

   public abstract T v44();

   public abstract boolean v1(T var1, T var2);

   public abstract String v4(T var1);

   @Nullable
   public class_2960 v3(T var1) {
      return null;
   }

   public abstract String v2(T var1);

   public abstract float v1(T var1, float var2);

   public boolean v2(T var1, T var2) {
      return this.v4((T)var1).equals(this.v4((T)var2)) && Objects.equals(this.v3((T)var1), this.v3((T)var2));
   }

   public boolean v47() {
      return false;
   }

   public float v5(T var1) {
      return 1.0F;
   }

   public void v49() {
   }

   public void v1(T var1, float var2, float var3, float var4, float var5, float var6) {
      class_2960 var7 = this.v3((T)var1);
      if (var7 != null) {
         if (this.v47()) {
            this.v1(var7, var2, var3, var4, var4, CopiedSupport2.v1(-1, var6), uiRecord7.ZERO);
         } else {
            uiSupport169.v1(var7, var2, var3, var4, var4, CopiedSupport2.v1(-1, var6), uiRecord7.ZERO);
         }
      }
   }

   public final void v1(hudSupport13 var1, int var2, float var3, float var4, float var5, float var6, float var7) {
      float var8 = this.v6(18.0F, var6);
      float var9 = (var5 - var8) * 0.5F;
      var1.v1(var2, var3 + var9, var4 + var9, var8, var7);
      uiSupport169.v12();
   }

   public final int v46() {
      return this.v30.size();
   }

   public final T v3(int var1) {
      return this.v30.get(var1).v1();
   }

   @Nullable
   public final T v4(int var1) {
      return this.v32.get(var1).v7.v1();
   }

   public static float v1(int var0, int var1, IntFunction<String> var2, float var3) {
      float var4 = 0.0F;

      for (int var5 = var0; var5 <= var1; var5++) {
         var4 = Math.max(var4, uiSupport169.v2("syky_sans_strong", (String)var2.apply(var5), var3));
      }

      return var4;
   }

   @Override
   public boolean v4() {
      return true;
   }

   private float v1(hudSupport21.Part1<T> var1, float var2) {
      return this.v3().v2() != hudSupport52.Part1.BOTTOM ? var1.v5 : this.v42 - var1.v5 - var2 * var1.v2.v1();
   }

   @Override
   public boolean v11(hudSupport40 var1) {
      return this.v15(var1).isEmpty();
   }

   private List<T> v18(hudSupport40 var1) {
      List var2 = this.v15(var1);
      if (var2.isEmpty() && var1.v7()) {
         List var3 = this.v31;
         if (var3 == null) {
            var3 = List.of(this.v44());
            this.v31 = var3;
         }

         var2 = var3;
      }

      List var4 = this.v29.v1(var2, this.v19());
      return var4 == null ? List.of() : var4;
   }

   private boolean v6(T var1) {
      return var1 == this.v44();
   }

   private boolean v3(T var1, T var2) {
      return this.v6((T)var1) ? false : this.v6((T)var2) || this.v1((T)var1, (T)var2);
   }

   private void v5(hudSupport40 var1, float var2) {
      long var3 = this.v24();
      if (var3 != this.v43 || var2 != this.v37) {
         this.v43 = var3;
         this.v37 = var2;
         this.v28.v1(this.v18(var1), var3, this.v18().v5());
         this.v40();
         this.v1(var2, var3);
      }
   }

   private void v40() {
      this.v30.clear();
      this.v32.clear();

      for (int var1 = 0; var1 < this.v23.size(); var1++) {
         this.v23.get(var1).v6 = false;
      }

      for (hudSupport17.Part1 var2 : this.v28.v1()) {
         int var3 = this.v30.size();

         while (var3 > 0 && this.v3((T)var2.v1(), this.v30.get(var3 - 1).v1())) {
            var3--;
         }

         this.v30.add(var3, var2);
         this.v32.add(var3, this.v7(this.v33.apply((T)var2.v1())));
      }

      for (int var5 = this.v23.size() - 1; var5 >= 0; var5--) {
         if (!this.v23.get(var5).v6) {
            this.v23.remove(var5);
         }
      }
   }

   private hudSupport21.Part1<T> v7(Object var1) {
      for (int var2 = 0; var2 < this.v23.size(); var2++) {
         hudSupport21.Part1 var3 = this.v23.get(var2);
         if (var3.v1.equals(var1)) {
            var3.v6 = true;
            return var3;
         }
      }

      hudSupport21.Part1 var4 = new hudSupport21.Part1(var1);
      var4.v6 = true;
      this.v23.add(var4);
      return var4;
   }

   private void v1(float var1, long var2) {
      float var4 = this.v6(6.0F, var1);
      float var5 = this.v6(36.0F, var1);
      float var6 = 0.0F;
      float var7 = 0.0F;
      float var8 = 0.0F;

      for (int var9 = 0; var9 < this.v30.size(); var9++) {
         hudSupport17.Part1 var10 = this.v30.get(var9);
         hudSupport21.Part1 var11 = this.v32.get(var9);
         var11.v2.v1(var10.v2());
         float var12 = var11.v2.v1();
         var6 += var4 * var12 * hudSupport60.v1(Math.min(1.0F, var7));
         float var13 = var1 > 0.0F ? var6 / var1 : 0.0F;
         boolean var14 = Math.abs(var13 - var11.v4) > 18.0F;
         var11.v4 = var13;
         var11.v5 = var11.v3.v1(var6, var14, var2);
         var6 += var5 * var12;
         var7 += var12;
         if (var10.v4()) {
            var8 = Math.max(var8, this.v8((T)var10.v1()));
         }

         var11.v7.v1((T)var10.v1(), var2, this::v2);
      }

      this.v42 = var6;
      if (this.v30.isEmpty()) {
         this.v34.v2();
         this.v36 = -1.0F;
         this.v38 = 0.0F;
      } else {
         float var16 = this.v36;
         if (var8 > 0.0F) {
            this.v36 = var8;
         }

         float var17 = this.v36 < 0.0F ? 0.0F : this.v36;
         float var18 = var17 * var1;
         float var19 = this.v8(var18);
         if (var19 < var18) {
            var19 += uiSupport169.v2();
         }

         this.v38 = var1 > 0.0F ? this.v34.v1(var19 / var1, var17 != var16, var2) * var1 : 0.0F;
      }
   }

   private float v8(T var1) {
      float var2 = 36.0F + uiSupport169.v2("syky_sans_strong", this.v4((T)var1), 16.0F) + 10.0F;
      if (!this.v6((T)var1)) {
         var2 += 12.0F + this.v1((T)var1, 16.0F);
      }

      return var2;
   }

   @Override
   public final void v17() {
      this.v29.v1();
      this.v28.v5();
      this.v30.clear();
      this.v32.clear();
      this.v23.clear();
      this.v34.v2();
      this.v36 = -1.0F;
      this.v38 = 0.0F;
      this.v42 = 0.0F;
      this.v43 = 0L;
      this.v37 = -1.0F;
      this.v49();
   }

   @Override
   public float v3(hudSupport40 var1, hudRecord4 var2, float var3) {
      return Math.min(18.0F * var3, var2.v5() * 0.5F);
   }

   @Override
   public void v4(hudSupport40 var1, float var2) {
      this.v5(var1, var2);
   }

   @Override
   public void v1(hudSupport40 var1, hudRecord4 var2, float var3) {
      this.v5(var1, var3);
      float var4 = this.v6(36.0F, var3);
      float var5 = var2.v4();

      for (int var6 = 0; var6 < this.v30.size(); var6++) {
         uiSupport23 var7 = this.v32.get(var6).v2;
         float var8 = var7.v2();
         if (!(var8 <= 0.0F)) {
            float var9 = var5 * var7.v3();
            float var10 = var4 * var7.v4();
            this.v1(
               var2.v2() + (var5 - var9) * 0.5F,
               var2.v3() + this.v1(this.v32.get(var6), var4),
               var9,
               var10,
               Math.min(18.0F * var3, var10 * 0.5F),
               var3,
               var8,
               var7.v5() * var1.v5()
            );
         }
      }
   }

   @Override
   public void v2(hudSupport40 var1, hudRecord4 var2, float var3) {
      this.v5(var1, var3);

      for (int var4 = 0; var4 < this.v30.size(); var4++) {
         this.v1(this.v30.get(var4), this.v32.get(var4), var1, var2, var3);
      }
   }

   private void v1(hudSupport17.Part1<T> var1, hudSupport21.Part1<T> var2, hudSupport40 var3, hudRecord4 var4, float var5) {
      uiSupport23 var6 = var2.v2;
      float var7 = var6.v2();
      if (!(var7 <= 0.0F)) {
         float var8 = this.v6(36.0F, var5);
         float var9 = var4.v3() + this.v1(var2, var8) + (var8 * var6.v1() - var8) * 0.5F;
         Object var10 = var1.v1();
         if (var1.v2() >= 0.46F) {
            this.v1((T)var10, var2.v7, var4.v2(), var9, var4.v4(), var8, var5, var7);
         } else {
            this.v1(
               var4.v2(),
               var9,
               var4.v4(),
               var8,
               7.0F * var5,
               var7,
               var6.v3(),
               var6.v4(),
               var6.v5() * var3.v5(),
               var7x -> this.v1((T)var10, var2.v7, var4.v2(), var9, var4.v4(), var8, var5, var7x)
            );
         }
      }
   }

   private void v1(T var1, uiSupport22<T> var2, float var3, float var4, float var5, float var6, float var7, float var8) {
      Object var9 = var2.v1();
      if (var9 == null) {
         this.v1((T)var1, var3, var4, var5, var6, var7, var8 * this.v5((T)var1));
      } else {
         float var10 = 5.0F * var7;
         float var11 = var2.v2();
         this.v1((T)var9, var3, var4 - var10 * var2.v4(), var5, var6, var7, var8 * var2.v3() * this.v5((T)var9));
         this.v1((T)var1, var3, var4 + var10 * (1.0F - var11), var5, var6, var7, var8 * var11 * this.v5((T)var1));
      }
   }

   private void v1(T var1, float var2, float var3, float var4, float var5, float var6, float var7) {
      if (!(var7 <= 0.0F)) {
         float var8 = 18.0F * var6;
         float var9 = var3 + (var5 - var8) * 0.5F;
         float var10 = 16.0F * var6;
         float var11 = var3 + var5 * 0.5F + (uiSupport169.v1(18.0F, 16.0F) - 18.0F) * var6;
         float var12 = var2 + 36.0F * var6;
         float var13 = var2 + var4 - 10.0F * var6;
         String var14 = this.v4((T)var1);
         if (this.v6((T)var1)) {
            this.v1(var2 + 9.0F * var6, var9, var8, var8, this.v2(CopiedSupport2.v1(536870911, var7)), uiRecord7.v1(5.0F * var6));
            this.v1("syky_sans_strong", var14, var12, var11, var10, CopiedSupport2.v1(-2130706433, var7), v1(var14, var12, var13, var10, var6));
         } else {
            this.v1((T)var1, var2 + 9.0F * var6, var9, var8, var6, var7);
            String var15 = this.v2((T)var1);
            float var16 = var13 - uiSupport169.v2("syky_sans_strong", var15, var10);
            this.v1("syky_sans_strong", var14, var12, var11, var10, CopiedSupport2.v1(-419430401, var7), v1(var14, var12, var16 - 12.0F * var6, var10, var6));
            this.v1("syky_sans_strong", var15, var16, var11, var10, CopiedSupport2.v1(-1, var7));
         }
      }
   }

   private static cloudRecord5 v1(String var0, float var1, float var2, float var3, float var4) {
      float var5 = var1 + uiSupport169.v2("syky_sans_strong", var0, var3) - var2;
      if (var5 <= 0.001F) {
         return cloudRecord5.NONE;
      } else {
         float var6 = 14.0F * var4;
         return cloudRecord5.NONE.v1(var2, var6 * hudSupport60.v1(Math.min(1.0F, var5 / (var6 * 0.25F))));
      }
   }

   @Override
   public AbstractHudWidget.Part1 v3(hudSupport40 var1, float var2) {
      this.v5(var1, var2);
      return this.v12(this.v38, this.v42);
   }

   public static final class Part1<T> {
      public final Object v1;
      public final uiSupport23 v2 = new uiSupport23();
      public final uiSupport21 v3 = new uiSupport21(300.0F);
      public float v4 = Float.NaN;
      public float v5;
      public boolean v6;
      public final uiSupport22<T> v7 = new uiSupport22<>(220.0F);

      public Part1(Object var1) {
         this.v1 = var1;
      }
   }
}
