package cc.syky.ui;

import cc.syky.hud.hudSupport54;
import cc.syky.hud.hudSupport61;
import org.jetbrains.annotations.Nullable;

public abstract class TypeASupport extends UiWidget {
   public static final float v7 = 16.0F;
   private static final float v1 = 11.0F;
   private static final float v8 = 14.0F;
   private static final float v13 = 9.0F;
   private final uiSupport116 v14 = new uiSupport116();
   private final uiSupport134 v15 = new uiSupport134();
   private final uiSupport134 v16 = new uiSupport134();
   private static final String v18 = "Type a note...";
   private static final hudSupport61 v19 = new hudSupport61(1600.0F);

   public TypeASupport(float var1, boolean var2) {
      super(var1, var2);
   }

   public abstract String v6();

   public abstract float v8();

   public abstract String v9();

   public int v10() {
      return SignInSupport.v49();
   }

   public boolean v11() {
      return false;
   }

   public abstract boolean v13();

   public abstract float v1(uiSupport35 var1, float var2);

   public abstract int v14();

   public abstract void v1(String var1);

   public abstract boolean v3(float var1, float var2, int var3);

   public boolean v12() {
      return false;
   }

   public void v2(String var1) {
   }

   @Override
   public boolean v15() {
      return this.v15.v1() || this.v16.v1();
   }

   public void v27() {
      this.v16.v3();
      this.v15.v1(this.v7(), this.v14());
   }

   public String v7() {
      return this.v6();
   }

   public boolean v28() {
      return this.v16.v1();
   }

   public void v3(String var1) {
      this.v15.v3();
      this.v16.v1(var1, 40, "syky_sans", "Type a note...");
   }

   @Override
   public void v16() {
      String var1 = this.v15.v2();
      if (var1 != null) {
         this.v1(var1);
      }

      String var2 = this.v16.v2();
      if (var2 != null) {
         this.v2(var2);
      }
   }

   @Override
   public void v18() {
      this.v15.v3();
      this.v16.v3();
   }

   @Nullable
   private uiSupport134 v1() {
      return this.v15.v1() ? this.v15 : (this.v16.v1() ? this.v16 : null);
   }

   private void v1(uiSupport134 var1) {
      if (var1 == this.v15) {
         this.v15.v1(this.v29(), this.v30(), this.v10, this.v12, 18.0F, this.v4, this.v5);
      } else {
         this.v16.v1(this.v3(), this.v30(), this.v10, this.v12, 18.0F, this.v4, this.v5);
      }
   }

   private float v3() {
      float var1 = this.v29() + uiSupport169.v2("syky_sans_strong", this.v14.v1(), 18.0F * this.v4) + SignInSupport.v4(16.0F, this.v4);
      return Math.min(var1, this.v9 + this.v11 / 2.0F);
   }

   public float v29() {
      return this.v9 + SignInSupport.v4(this.v8(), this.v4);
   }

   public float v30() {
      return this.v9 + this.v11 - SignInSupport.v4(16.0F, this.v4);
   }

   private float v4() {
      return this.v11() ? this.v30() - SignInSupport.v4(23.0F, this.v4) : this.v30();
   }

   @Override
   public void v1(uiSupport102 var1) {
      super.v1(var1);
      var1.v1(this.v9());
      var1.v1(this.v11());
      var1.v1(this.v15.v1());
      var1.v1(this.v16.v1());
   }

   @Override
   public void v1(uiSupport35 var1) {
      boolean var2 = this.v19().v1() && !this.v15() && this.v13() && var1.v2();
      this.v6.v2(var2 && this.v1(var1.v1, var1.v2) ? 1.0F : 0.0F);
      float var3 = this.v6.v2();
      if (this.v12() && this.v19().v1()) {
         var3 = Math.max(var3, v19.v1());
         uiSupport33.v1();
      }

      this.v5(var3);
      this.v26();
      float var4 = this.v1(var1, var3);
      if (this.v15.v1()) {
         this.v1(this.v15);
         this.v15.v1(var1);
      } else {
         boolean var5 = this.v16.v1();
         boolean var6 = this.v11() && !var5;
         String var7 = var5 ? "" : this.v9();
         float var8 = (this.v4 > 0.0F ? this.v11 / this.v4 : 0.0F) - this.v8() - 16.0F - (var6 ? 23.0F : 0.0F);
         this.v14.v1(this.v6(), var7, var8, 18.0F, 11.0F, 16.0F);
         uiSupport169.v1("syky_sans_strong", this.v14.v1(), this.v29(), this.v4(18.0F), 18.0F * this.v4, uiSupport155.v1(SignInSupport.v3(var4, var3), this.v5));
         if (var5) {
            this.v1(this.v16);
            this.v16.v1(var1);
         } else if (!var7.isEmpty()) {
            float var9 = this.v14.v2();
            uiSupport169.v2("syky_sans", var7, this.v4(), this.v4(var9), var9 * this.v4, uiSupport155.v1(this.v10(), this.v5));
         }

         if (var6) {
            float var10 = SignInSupport.v4(14.0F, this.v4);
            uiSupport169.v1(
               uiSupport143.v22,
               this.v30() - var10,
               this.v10 + uiSupport169.v1((this.v12 - var10) / 2.0F),
               var10,
               var10,
               uiSupport155.v1(SignInSupport.v49(), this.v5),
               uiRecord7.ZERO
            );
         }
      }
   }

   @Override
   public boolean v1(float var1, float var2, int var3) {
      if (this.v17() && this.v1(var1, var2)) {
         uiSupport134 var4 = this.v1();
         if (var4 != null) {
            this.v1(var4);
            if (var4.v1(var1, var2)) {
               return var4.v1(var1, var2, var3);
            } else {
               this.v16();
               return true;
            }
         } else {
            return this.v3(var1, var2, var3);
         }
      } else {
         return false;
      }
   }

   @Override
   public boolean v1(float var1, float var2, int var3, float var4, float var5) {
      uiSupport134 var6 = this.v1();
      return var6 != null && var6.v1(var1, var2, var3, var4, var5);
   }

   @Override
   public boolean v4(float var1, float var2, int var3) {
      uiSupport134 var4 = this.v1();
      return var4 != null && var4.v2(var1, var2, var3);
   }

   @Override
   public boolean v2(int var1, int var2) {
      uiSupport134 var3 = this.v1();
      return var3 != null && var3.v1(var1, var2);
   }

   @Override
   public boolean v3(int var1, int var2) {
      uiSupport134 var3 = this.v1();
      return var3 != null && var3.v2(var1, var2);
   }

   @Override
   public hudSupport54 v2(float var1, float var2) {
      if (this.v17() && this.v1(var1, var2)) {
         uiSupport134 var3 = this.v1();
         if (var3 != null) {
            this.v1(var3);
            return var3.v2(var1, var2);
         } else {
            return hudSupport54.POINTER;
         }
      } else {
         return hudSupport54.ARROW;
      }
   }

   @Nullable
   @Override
   public hudSupport54 v31() {
      uiSupport134 var1 = this.v1();
      return var1 == null ? null : var1.v4();
   }
}
