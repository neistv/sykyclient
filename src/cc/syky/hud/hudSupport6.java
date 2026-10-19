package cc.syky.hud;

import cc.syky.ui.uiSupport7;
import java.util.Objects;
import org.jetbrains.annotations.Nullable;

public final class hudSupport6 {
   private static final float v1 = 250.0F;
   private final uiSupport7 v2 = new uiSupport7();
   private final uiSupport7 v3 = new uiSupport7();
   @Nullable
   private Object v4;
   @Nullable
   private Object v5;
   private long v6;
   private float v7 = 1.0F;
   private float v8 = 1.0F;
   private long v9;
   private boolean v10;
   private float v11 = 1.0F;
   private boolean v12;

   public hudSupport6() {
   }

   public void v1(uiSupport7.Part1 var1) {
      this.v2.v1(var1);
      this.v3.v1(var1);
   }

   public void v1(@Nullable Object var1, long var2, boolean var4) {
      boolean var5 = !Objects.equals(var1, this.v4);
      boolean var6 = this.v10;
      boolean var7 = var6 && this.v1(var2);
      this.v10 = true;
      this.v9 = var2;
      if (var6 && !var4) {
         if (var5) {
            this.v12 = true;
            if (var1 != null && this.v4 != null && !var7) {
               this.v11 = this.v8 >= 1.0F ? 1.0F : this.v3.v3();
               this.v5 = this.v4;
               this.v4 = var1;
               this.v6 = var2;
               this.v7 = 0.0F;
               this.v8 = 0.0F;
               this.v18();
            } else {
               this.v2(var1, var2);
            }
         } else {
            this.v12 = false;
            if (this.v8 >= 1.0F) {
               this.v6 = var2;
               this.v7 = 1.0F;
            } else if (var7) {
               this.v2(var2);
            } else {
               this.v8 = this.v7 + (float)(var2 - this.v6) / 1000000.0F / 520.0F;
               if (this.v8 >= 1.0F) {
                  this.v2(var2);
               } else {
                  this.v18();
               }
            }
         }
      } else {
         this.v12 = var5 && var6;
         this.v2(var1, var2);
      }
   }

   public void v1(@Nullable Object var1, long var2) {
      this.v10 = true;
      this.v9 = var2;
      this.v12 = false;
      this.v2(var1, var2);
   }

   private boolean v1(long var1) {
      return (float)(var1 - this.v9) / 1000000.0F > 250.0F;
   }

   private void v2(@Nullable Object var1, long var2) {
      this.v4 = var1;
      this.v2(var2);
   }

   private void v2(long var1) {
      this.v5 = null;
      this.v8 = 1.0F;
      this.v7 = 1.0F;
      this.v6 = var1;
      this.v11 = 1.0F;
      this.v2.v8();
      this.v3.v8();
   }

   private void v18() {
      this.v2.v1(this.v8);
      this.v3.v2(this.v8);
   }

   @Nullable
   public Object v1() {
      return this.v4;
   }

   @Nullable
   public Object v2() {
      return this.v5;
   }

   public boolean v3() {
      return this.v5 != null && this.v8 < 1.0F;
   }

   public float v4() {
      return this.v8;
   }

   public boolean v5() {
      return this.v12;
   }

   public float v6() {
      return this.v3() ? this.v3.v1() : 1.0F;
   }

   public float v7() {
      return this.v3() ? this.v3.v2() : 1.0F;
   }

   public float v8() {
      return this.v2.v3() * this.v11;
   }

   public float v9() {
      return this.v2.v4();
   }

   public float v10() {
      return this.v2.v5();
   }

   public float v11() {
      return this.v3.v3();
   }

   public float v12() {
      return this.v3.v4();
   }

   public float v13() {
      return this.v3.v5();
   }

   public boolean v14() {
      return this.v3() && this.v8() > 0.0F && !this.v2.v7();
   }

   public boolean v15() {
      return this.v3() && !this.v3.v7();
   }

   public float v16() {
      return this.v3() ? this.v3.v6() : 0.0F;
   }
}
