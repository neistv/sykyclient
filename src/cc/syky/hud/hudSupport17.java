package cc.syky.hud;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.function.Function;
import org.jetbrains.annotations.Nullable;

public final class hudSupport17<T> {
   public static final float v1 = 340.0F;
   public static final float v2 = 140.0F;
   private static final float v3 = 750.0F;
   private static final float v4 = 1000000.0F;
   private final Function<T, Object> v5;
   private final float v6;
   private final float v7;
   private final float v8;
   private final List<hudSupport17.Part1<T>> v9 = new ArrayList<>(8);
   private final List<hudSupport17.Part1<T>> v10 = Collections.unmodifiableList(this.v9);
   private float v11;
   private float v12;
   private long v13;
   private boolean v14;

   public hudSupport17(Function<T, Object> var1) {
      this(var1, 340.0F, 140.0F, 0.4619989F);
   }

   public hudSupport17(Function<T, Object> var1, float var2, float var3, float var4) {
      this.v5 = var1;
      this.v6 = var2;
      this.v7 = var3;
      this.v8 = var4;
   }

   public void v1(List<T> var1, long var2, boolean var4) {
      long var5 = this.v13;
      this.v13 = var2;
      boolean var7 = !this.v14 || (float)(var2 - var5) / 1000000.0F > 750.0F;
      this.v14 = true;
      this.v2(var1, var2, var4 || var7);
   }

   public void v1(float var1, float var2) {
      float var3 = 0.0F;
      float var4 = 0.0F;

      for (hudSupport17.Part1 var6 : this.v9) {
         var6.v2.v1(var6.v6);
         float var7 = var6.v2.v1();
         var3 += var2 * var7 * Math.clamp(var4, 0.0F, 1.0F);
         var6.v9 = var3;
         var6.v10 = var1 * var7;
         var3 += var6.v10;
         var4 += var7;
      }

      this.v11 = var3;
      this.v12 = Math.clamp(var4, 0.0F, 1.0F);
   }

   public List<hudSupport17.Part1<T>> v1() {
      return this.v10;
   }

   public boolean v2() {
      return this.v9.isEmpty();
   }

   public float v3() {
      return this.v11;
   }

   public float v4() {
      return this.v12;
   }

   public void v5() {
      this.v9.clear();
      this.v11 = 0.0F;
      this.v12 = 0.0F;
      this.v14 = false;
      this.v13 = 0L;
   }

   private void v2(List<T> var1, long var2, boolean var4) {
      for (hudSupport17.Part1 var6 : this.v9) {
         var6.v5 = false;
      }

      for (int var9 = 0; var9 < var1.size(); var9++) {
         Object var12 = var1.get(var9);
         Object var7 = this.v5.apply((T)var12);
         hudSupport17.Part1 var8 = this.v1(var7);
         if (var8 == null) {
            var8 = new hudSupport17.Part1<>(var7, var12);
            var8.v6 = var4 ? 1.0F : 0.0F;
            var8.v7 = var8.v6;
            var8.v8 = var2;
            this.v9.add(this.v1(var1, var9), var8);
         } else {
            var8.v3 = (T)var12;
            if (!var8.v4) {
               this.v1(var8, true, var2);
            }
         }

         var8.v5 = true;
      }

      for (hudSupport17.Part1 var13 : this.v9) {
         if (!var13.v5 && var13.v4) {
            this.v1(var13, false, var2);
         }
      }

      for (int var11 = this.v9.size() - 1; var11 >= 0; var11--) {
         hudSupport17.Part1 var14 = this.v9.get(var11);
         if (var4) {
            var14.v6 = var14.v4 ? 1.0F : 0.0F;
            var14.v7 = var14.v6;
            var14.v8 = var2;
         } else {
            var14.v6 = this.v1(var14, var2);
         }

         if (!var14.v4 && var14.v6 <= 0.0F) {
            this.v9.remove(var11);
         }
      }
   }

   private int v1(List<T> var1, int var2) {
      if (var2 == 0) {
         return 0;
      } else {
         hudSupport17.Part1 var3 = this.v1(this.v5.apply((T)var1.get(var2 - 1)));
         return var3 == null ? this.v9.size() : this.v9.indexOf(var3) + 1;
      }
   }

   private void v1(hudSupport17.Part1<T> var1, boolean var2, long var3) {
      float var5 = this.v1(var1, var3);
      var1.v7 = var2 ? var5 : Math.min(var5, this.v8);
      var1.v8 = var3;
      var1.v4 = var2;
   }

   private float v1(hudSupport17.Part1<T> var1, long var2) {
      float var4 = (float)(var2 - var1.v8) / 1000000.0F;
      float var5 = var1.v4 ? var4 / this.v6 : var4 / this.v7 * this.v8;
      return Math.clamp(var1.v4 ? var1.v7 + var5 : var1.v7 - var5, 0.0F, 1.0F);
   }

   @Nullable
   private hudSupport17.Part1<T> v1(Object var1) {
      for (int var2 = 0; var2 < this.v9.size(); var2++) {
         hudSupport17.Part1 var3 = this.v9.get(var2);
         if (var3.v1.equals(var1)) {
            return var3;
         }
      }

      return null;
   }

   public static final class Part1<T> {
      public final Object v1;
      public final hudSupport18 v2 = new hudSupport18();
      public T v3;
      public boolean v4 = true;
      public boolean v5;
      public float v6;
      public float v7;
      public long v8;
      public float v9;
      public float v10;

      public Part1(Object var1, T var2) {
         this.v1 = var1;
         this.v3 = (T)var2;
      }

      public T v1() {
         return this.v3;
      }

      public float v2() {
         return this.v6;
      }

      public boolean v3() {
         return this.v6 < 1.0F;
      }

      public boolean v4() {
         return this.v4;
      }

      public hudSupport18 v5() {
         return this.v2;
      }

      public float v6() {
         return this.v9;
      }

      public float v7() {
         return this.v10;
      }
   }
}
