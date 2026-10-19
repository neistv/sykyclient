package cc.syky.ui;

import cc.syky.hud.hudSupport54;
import cc.syky.hud.hudSupport60;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import org.jetbrains.annotations.Nullable;

public final class uiSupport117<R extends UiWidget> {
   private final List<uiSupport115<R>> v2 = new ArrayList<>();
   private boolean v3;
   private float v4;
   private float v5;
   private float v6 = -Float.MAX_VALUE;
   private float v7 = Float.MAX_VALUE;
   private final List<UiWidget> v8 = new ArrayList<>();
   private final List<UiWidget> v9 = new ArrayList<>();
   private final List<uiSupport115<R>> v10 = new ArrayList<>();
   private boolean[] v11 = new boolean[0];
   private boolean v12;
   public static final float v1 = 460.0F;
   private final uiSupport117.Part1 v13 = new uiSupport117.Part1();
   private final uiSupport117.Part1 v14 = new uiSupport117.Part1();
   private float v15;
   private float v16;
   private boolean v18;
   private boolean v19;
   private boolean v17;
   private float v20 = 1.0F;
   private float v21 = 1.0F;
   private float v22 = 82.0F;

   public uiSupport117(float var1) {
      this.v4 = var1;
   }

   public void v1(float var1) {
      this.v22 = var1;
   }

   public void v2(float var1) {
      this.v4 = var1;

      for (uiSupport115 var3 : this.v2) {
         var3.v2(var1);
      }
   }

   public void v1(boolean var1) {
      this.v12 = var1;
   }

   public List<uiSupport115<R>> v1() {
      return this.v2;
   }

   public boolean v2() {
      return this.v2.isEmpty();
   }

   public boolean v3() {
      return this.v3 && uiSupport103.v1();
   }

   public static boolean v1(float var0, float var1) {
      float var2 = SignInSupport.v4(736.0F, var1) + 16.0F * var1;
      return var0 + uiSupport169.v2() >= var2;
   }

   @Nullable
   public uiSupport115<R> v1(Object var1, String var2) {
      for (uiSupport115 var4 : this.v2) {
         if (Objects.equals(var4.v1(), var1) && var4.v2().equals(var2)) {
            return var4;
         }
      }

      return null;
   }

   public uiSupport115<R> v1(Object var1, String var2, boolean var3) {
      return new uiSupport115<>(var1, var2, this.v4, var3);
   }

   public void v1(List<uiSupport115<R>> var1) {
      if (this.v3) {
         this.v3(var1);
      }

      int var2 = 0;

      for (uiSupport115 var4 : this.v2) {
         int var5 = var1.indexOf(var4);
         if (var5 >= 0) {
            var2 = var5 + 1;
         } else {
            var4.v4();
            var1.add(Math.min(var2, var1.size()), var4);
            var2++;
         }
      }

      this.v2.clear();
      this.v2.addAll(var1);
      if (!this.v3) {
         this.v8();
      }

      this.v3 = true;
   }

   public void v2(List<uiSupport115<R>> var1) {
      this.v18 = false;
      this.v2.clear();
      this.v2.addAll(var1);

      for (uiSupport115 var3 : this.v2) {
         if (!var3.v5) {
            var3.v2 = -1;
         }

         var3.v10();
      }

      this.v8();
      this.v3 = true;
   }

   public uiSupport117<R> v4() {
      uiSupport117 var1 = new uiSupport117(this.v4);
      var1.v2.addAll(this.v2);
      var1.v3 = true;
      var1.v12 = this.v12;
      var1.v22 = this.v22;
      var1.v15 = this.v15;
      var1.v16 = this.v16;
      return var1;
   }

   private void v3(List<uiSupport115<R>> var1) {
      float var2 = 0.0F;
      float var3 = 0.0F;

      for (uiSupport115 var5 : var1) {
         if (var5.v2 >= 0) {
            float var6 = var5.v9() + 16.0F;
            if (var5.v2 == 1) {
               var3 += var6;
            } else {
               var2 += var6;
            }
         }
      }

      for (uiSupport115 var8 : var1) {
         if (var8.v2 < 0) {
            var8.v2 = var2 <= var3 ? 0 : 1;
            float var9 = var8.v9() + 16.0F;
            if (var8.v2 == 1) {
               var3 += var9;
            } else {
               var2 += var9;
            }
         }
      }
   }

   private void v8() {
      float var1 = 0.0F;
      float var2 = 0.0F;

      for (uiSupport115 var4 : this.v2) {
         float var5 = var4.v9() + 16.0F;
         if (var4.v2 < 0) {
            var4.v2 = var1 <= var2 ? 0 : 1;
         }

         if (var4.v2 == 1) {
            var2 += var5;
         } else {
            var1 += var5;
         }
      }
   }

   public boolean v5() {
      if (this.v12) {
         this.v10();
      }

      boolean var1 = false;

      for (int var2 = this.v2.size() - 1; var2 >= 0; var2--) {
         uiSupport115 var3 = this.v2.get(var2);
         var3.v10();
         if (var3.v8()) {
            this.v2.remove(var2);
         } else {
            var1 |= var3.v4;
         }
      }

      if (this.v12) {
         this.v9();
      }

      return var1;
   }

   private void v9() {
      boolean var1 = false;
      boolean var2 = false;
      boolean var3 = false;
      boolean var4 = false;
      boolean var5 = false;
      boolean var6 = false;

      for (uiSupport115 var8 : this.v2) {
         boolean var9 = var8.v6();
         boolean var10 = var8.v4 || var9;
         if (var8.v2 == 1) {
            var2 |= var10;
            var4 |= var9;
            var6 |= var8.v4;
         } else {
            var1 |= var10;
            var3 |= var9;
            var5 |= var8.v4;
         }
      }

      boolean var11 = !this.v18 || !uiSupport103.v1();
      boolean var12 = this.v19;
      boolean var13 = this.v17;
      if (var12) {
         var1 = false;
      }

      if (var13) {
         var2 = false;
      }

      if (!var11 && var5 && !var3 && this.v14.v3 > 0.0F) {
         this.v1(0);
      }

      if (!var11 && var6 && !var4 && this.v13.v3 > 0.0F) {
         this.v1(1);
      }

      v1(this.v13, var1 && !var2 ? 1.0F : 0.0F, var11 || !var3, var5);
      v1(this.v14, var2 && !var1 ? 1.0F : 0.0F, var11 || !var4, var6);
      if (var11) {
         this.v18 = this.v3;
      }

      this.v15 = this.v13.v1();
      this.v16 = this.v14.v1();
      if (var12 && this.v16 >= 1.0F) {
         this.v1(0);
      }

      if (var13 && this.v15 >= 1.0F) {
         this.v1(1);
      }
   }

   private void v10() {
      boolean var1 = false;
      boolean var2 = false;
      boolean var3 = false;
      boolean var4 = false;

      for (uiSupport115 var6 : this.v2) {
         boolean var7 = var6.v6();
         boolean var8 = var6.v5();
         if (var6.v2 == 1) {
            var2 |= var7;
            var4 |= var8;
         } else {
            var1 |= var7;
            var3 |= var8;
         }
      }

      boolean var9 = this.v18 && uiSupport103.v1();
      this.v19 = var9 && !var3 && var1 && var4;
      this.v17 = var9 && !var4 && var2 && var3;
      this.v1(0, this.v19);
      this.v1(1, this.v17);
   }

   private void v1(int var1, boolean var2) {
      for (uiSupport115 var4 : this.v2) {
         if (var4.v2 == 1 == (var1 == 1) && (!var2 || !var4.v5())) {
            var4.v1(var2);
         }
      }
   }

   private void v1(int var1) {
      for (uiSupport115 var3 : this.v2) {
         if (var3.v2 == 1 == (var1 == 1)) {
            var3.v7();
         }
      }
   }

   private static void v1(uiSupport117.Part1 var0, float var1, boolean var2, boolean var3) {
      if (var2) {
         var0.v1(var1);
      } else if (var3) {
         var0.v2(var1);
      }
   }

   public float v2(boolean var1) {
      float var2 = SignInSupport.v4(16.0F, this.v4);
      float var3 = 0.0F;
      float var4 = 0.0F;
      float var5 = 0.0F;
      float var6 = 0.0F;

      for (uiSupport115 var8 : this.v2) {
         float var9 = var2 * var8.v3;
         float var10 = var8.v11() + var9;
         if (var1 && var8.v2 == 1) {
            var4 += var10;
            var6 = var9;
         } else {
            var3 += var10;
            var5 = var9;
         }
      }

      this.v5 = Math.max(0.0F, Math.max(var3 - var5, var4 - var6));
      return this.v5;
   }

   public float v6() {
      return this.v5;
   }

   public void v1(float var1, float var2, boolean var3, float var4, float var5) {
      this.v6 = var4;
      this.v7 = var5;
      float var6 = SignInSupport.v4(16.0F, this.v4);
      float var7 = SignInSupport.v4(368.0F, this.v4);
      float var8 = SignInSupport.v4(384.0F, this.v4);
      float var9 = SignInSupport.v4(736.0F, this.v4);
      float var10 = SignInSupport.v4(16.0F, this.v4);
      float var11 = var3 ? this.v15 : 0.0F;
      float var12 = var3 ? this.v16 : 0.0F;
      float var13 = var8 - var7;
      float var14 = var7 - var6 + (var9 - var7) * var11;
      float var15 = var8 + (var6 - var8) * var12;
      float var16 = var12 > 0.0F ? Math.min(var6, var15 - var13 - (var7 - var6)) : var6;
      float var17 = var11 > 0.0F ? Math.max(var15, var6 + var14 + var13) : var15;
      float var18 = var14;
      float var19 = var11 > 0.0F ? var9 - var8 : var9 - var15;
      this.v20 = 1.0F - var12;
      this.v21 = 1.0F - var11;
      float var20 = 0.0F;
      float var21 = 0.0F;

      for (uiSupport115 var23 : this.v2) {
         boolean var24 = var3 && var23.v2 == 1;
         var23.v1(var1 + (var24 ? var17 : var16), var2 + (var24 ? var21 : var20), var24 ? var19 : var18);
         float var25 = var23.v11() + var10 * var23.v3;
         if (var24) {
            var21 += var25;
         } else {
            var20 += var25;
         }
      }
   }

   public void v1(UiNode var1, float var2, float var3, float var4, float var5, float var6) {
      boolean var7 = v1(var4, this.v4);
      float var8 = this.v2(var7);
      float var9 = var3 + SignInSupport.v4(this.v22, this.v4) + var6;
      this.v1(var2, var9, var7, var3, var3 + var5);
      float var10 = var2 + SignInSupport.v4(16.0F, this.v4);
      float var11 = var2 + SignInSupport.v4(16.0F + (var7 ? 720.0F : 352.0F), this.v4);
      var1.v1(var10, var9, var11 - var10, var8);
   }

   public boolean v1(uiSupport35 var1) {
      return this.v1(var1, this.v6, this.v7);
   }

   public boolean v1(uiSupport35 var1, float var2, float var3) {
      boolean var4 = false;

      for (uiSupport115 var6 : this.v2) {
         if (v1(var6, var2, var3) && !this.v1(var6)) {
            var4 |= var6.v1(var1, var2, var3);
         }
      }

      this.v4(var1, var2, var3);
      if (var4) {
         this.v3(var1, var2, var3);
      }

      var4 |= this.v1(var1, 0, this.v20, var2, var3);
      return var4 | this.v1(var1, 1, this.v21, var2, var3);
   }

   private boolean v1(uiSupport115<R> var1) {
      return (var1.v2 == 1 ? this.v21 : this.v20) < 1.0F;
   }

   private boolean v1(uiSupport35 var1, int var2, float var3, float var4, float var5) {
      if (!(var3 >= 1.0F) && !(var3 <= 0.0F)) {
         float var6 = Float.MAX_VALUE;
         float var7 = Float.MAX_VALUE;
         float var8 = -Float.MAX_VALUE;
         float var9 = -Float.MAX_VALUE;

         for (uiSupport115 var11 : this.v2) {
            if (var11.v2 == 1 == (var2 == 1) && v1(var11, var4, var5) && var11.v6()) {
               var6 = Math.min(var6, var11.v9);
               var7 = Math.min(var7, var11.v10);
               var8 = Math.max(var8, var11.v9 + var11.v11);
               var9 = Math.max(var9, var11.v10 + var11.v12);
            }
         }

         if (var6 > var8) {
            return false;
         } else {
            float var23 = SignInSupport.v4(uiSupport103.v3(var3) * this.v4);
            float var24 = 2.0F * var23;
            uiSupport169.v6(var6 - var24, var7 - var24, var8 - var6 + 2.0F * var24, var9 - var7 + 2.0F * var24);

            try {
               boolean var12 = uiSupport169.v5();

               try {
                  for (uiSupport115 var14 : this.v2) {
                     if (var14.v2 == 1 == (var2 == 1) && v1(var14, var4, var5)) {
                        var14.v2(var1, var4, var5);
                     }
                  }
               } finally {
                  if (var12) {
                     uiSupport169.v1(var3, 0.0F, 0.0F, 1.0F, 1.0F, var23);
                  }
               }
            } finally {
               uiSupport169.v17();
            }

            return true;
         }
      } else {
         return false;
      }
   }

   public void v2(uiSupport35 var1, float var2, float var3) {
      for (uiSupport115 var5 : this.v2) {
         if (v1(var5, var2, var3)) {
            var5.v2(var1, var2, var3);
         }
      }
   }

   private void v3(uiSupport35 var1, float var2, float var3) {
      this.v8.clear();
      this.v10.clear();

      for (uiSupport115 var5 : this.v2) {
         if (v1(var5, var2, var3) && !this.v1(var5)) {
            var5.v2(this.v8, var2, var3);
            if (var5.v3(var2, var3)) {
               this.v10.add(var5);
            }
         }
      }

      int var27 = this.v8.size();
      int var28 = var27 + this.v10.size();
      if (var28 != 0) {
         if (this.v11.length < var28) {
            this.v11 = new boolean[var28];
         }

         Arrays.fill(this.v11, 0, var28, false);
         boolean var6 = false;

         for (int var7 = 0; var7 < var28; var7++) {
            if (!this.v11[var7]) {
               float var8 = this.v1(var7, var27);
               int var9 = uiSupport103.v5(var8);
               float var10 = SignInSupport.v4(uiSupport103.v3(var8) * this.v4);
               float var11 = 2.0F * var10;
               float var12 = Float.MAX_VALUE;
               float var13 = Float.MAX_VALUE;
               float var14 = -Float.MAX_VALUE;
               float var15 = -Float.MAX_VALUE;

               for (int var16 = var7; var16 < var28; var16++) {
                  if (!this.v11[var16] && uiSupport103.v5(this.v1(var16, var27)) == var9) {
                     if (var16 < var27) {
                        UiWidget var17 = this.v8.get(var16);
                        var12 = Math.min(var12, var17.v9);
                        var13 = Math.min(var13, var17.v10);
                        var14 = Math.max(var14, var17.v9 + var17.v11);
                        var15 = Math.max(var15, var17.v10 + var17.v12);
                     } else {
                        uiSupport115 var30 = this.v10.get(var16 - var27);
                        var12 = Math.min(var12, var30.v9);
                        var13 = Math.min(var13, var30.v10);
                        var14 = Math.max(var14, var30.v9 + var30.v11);
                        var15 = Math.max(var15, var30.v13());
                     }
                  }
               }

               uiSupport169.v6(var12 - var11, var13 - var11, var14 - var12 + 2.0F * var11, var15 - var13 + 2.0F * var11);

               try {
                  boolean var29 = !var6 && uiSupport169.v5();
                  var6 |= !var29;

                  try {
                     for (int var31 = var7; var31 < var28; var31++) {
                        if (!this.v11[var31] && uiSupport103.v5(this.v1(var31, var27)) == var9) {
                           float var18 = var29 ? 1.0F : var8;
                           if (var31 < var27) {
                              this.v8.get(var31).v2(var1, var18);
                           } else {
                              this.v10.get(var31 - var27).v3(var18);
                           }

                           this.v11[var31] = true;
                        }
                     }
                  } finally {
                     if (var29) {
                        uiSupport169.v1(var8, 0.0F, 0.0F, 1.0F, 1.0F, var10);
                     }
                  }
               } finally {
                  uiSupport169.v17();
               }
            }
         }
      }
   }

   private void v4(uiSupport35 var1, float var2, float var3) {
      this.v9.clear();

      for (uiSupport115 var5 : this.v2) {
         if (v1(var5, var2, var3) && !this.v1(var5)) {
            var5.v1(this.v9, var2, var3);
         }
      }

      for (int var21 = 0; var21 < this.v9.size(); var21++) {
         float var22 = this.v9.get(var21).v21();
         if (!(var22 <= 0.0F)) {
            float var6 = Float.MAX_VALUE;
            float var7 = Float.MAX_VALUE;
            float var8 = -Float.MAX_VALUE;
            float var9 = -Float.MAX_VALUE;

            for (int var10 = var21; var10 < this.v9.size(); var10++) {
               UiWidget var11 = this.v9.get(var10);
               if (var11.v21() == var22) {
                  var6 = Math.min(var6, var11.v9);
                  var7 = Math.min(var7, var11.v10);
                  var8 = Math.max(var8, var11.v9 + var11.v11);
                  var9 = Math.max(var9, var11.v10 + var11.v12);
               }
            }

            uiSupport169.v6(var6, var7, var8 - var6, var9 - var7);

            try {
               boolean var23 = uiSupport169.v5();

               try {
                  for (int var25 = var21; var25 < this.v9.size(); var25++) {
                     UiWidget var12 = this.v9.get(var25);
                     if (var12.v21() == var22) {
                        var12.v1(var1, var23 ? 1.0F : var22, UiWidget.Part1.CONTENT);
                     }
                  }
               } finally {
                  if (var23) {
                     uiSupport169.v2(var22);
                  }
               }
            } finally {
               uiSupport169.v17();
            }

            for (int var24 = this.v9.size() - 1; var24 > var21; var24--) {
               if (this.v9.get(var24).v21() == var22) {
                  this.v9.remove(var24);
               }
            }
         }
      }
   }

   private float v1(int var1, int var2) {
      return var1 < var2 ? this.v8.get(var1).v19().v5() : this.v10.get(var1 - var2).v12();
   }

   private static boolean v1(UiNode var0, float var1, float var2) {
      return var0.v10 < var2 && var0.v10 + var0.v12 > var1;
   }

   public void v1(uiSupport102 var1) {
      this.v1(var1, this.v6, this.v7);
   }

   public void v1(uiSupport102 var1, float var2, float var3) {
      var1.v1(this.v15);
      var1.v1(this.v16);

      for (uiSupport115 var5 : this.v2) {
         if (v1(var5, var2, var3)) {
            var5.v1(var1);
         }
      }
   }

   @Nullable
   public R v7() {
      for (uiSupport115 var2 : this.v2) {
         UiWidget var3 = var2.v14();
         if (var3 != null) {
            return (R)var3;
         }
      }

      return null;
   }

   @Nullable
   public R v2(float var1, float var2) {
      for (uiSupport115 var4 : this.v2) {
         UiWidget var5 = var4.v1(var1, var2, 0, false);
         if (var5 != null) {
            return (R)var5;
         }
      }

      return null;
   }

   public boolean v1(float var1, float var2, int var3) {
      for (uiSupport115 var5 : this.v2) {
         if (var5.v1(var1, var2, var3, true) != null) {
            return true;
         }
      }

      return false;
   }

   public boolean v3(float var1, float var2) {
      for (uiSupport115 var4 : this.v2) {
         if (var4.v1(var1, var2)) {
            return true;
         }
      }

      return false;
   }

   public boolean v2(float var1, float var2, int var3) {
      for (uiSupport115 var5 : this.v2) {
         if (var5.v1(var1, var2)) {
            for (UiWidget var7 : var5.v3()) {
               if (var7.v1(var1, var2) && var7.v1(var1, var2, var3)) {
                  return true;
               }
            }
         }
      }

      return false;
   }

   public hudSupport54 v4(float var1, float var2) {
      UiWidget var3 = this.v2(var1, var2);
      return var3 == null ? hudSupport54.ARROW : var3.v2(var1, var2);
   }

   public static final class Part1 {
      private float v1;
      private float v2;
      public float v3;
      private long v4;

      public Part1() {
      }

      public void v1(float var1) {
         this.v1 = var1;
         this.v2 = var1;
         this.v3 = var1;
      }

      public void v2(float var1) {
         if (var1 != this.v2) {
            this.v1 = this.v3;
            this.v2 = var1;
            this.v4 = System.nanoTime();
         }
      }

      public float v1() {
         if (this.v3 == this.v2) {
            return this.v3;
         } else {
            float var1 = (float)(System.nanoTime() - this.v4) / 4.6E8F;
            if (var1 >= 1.0F) {
               this.v3 = this.v2;
            } else {
               this.v3 = this.v1 + (this.v2 - this.v1) * hudSupport60.v5(var1);
               uiSupport33.v1();
            }

            return this.v3;
         }
      }
   }
}
