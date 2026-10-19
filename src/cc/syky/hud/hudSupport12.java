package cc.syky.hud;

import org.jetbrains.annotations.Nullable;

public abstract class hudSupport12 extends HudElement {
   private float v2;
   private boolean v3;

   public hudSupport12(String var1, int var2, hudSupport52 var3, float var4, float var5) {
      super(var1, var2, var3, var4, var5);
   }

   @Override
   public boolean v37() {
      return true;
   }

   @Nullable
   public abstract hudSupport12.Part1 v14(hudSupport40 var1);

   @Override
   public final boolean v1(hudSupport40 var1, float[] var2) {
      hudSupport12.Part1 var3 = this.v14(var1);
      if (var3 == null) {
         return false;
      } else {
         var2[0] = var3.v22;
         var2[1] = var3.v21;
         return true;
      }
   }

   public final void v1(hudSupport40 var1, hudSupport12.Part1 var2, float var3) {
      float var4 = this.v1(var1, var3);
      float var5 = this.v2(var1, var2.v21);
      var2.v16 = this.v8(var4);
      var2.v18 = this.v8(var5);
      var2.v19 = var2.v16 + this.v15();
      var2.v17 = var2.v18 + this.v16();
   }

   public final void v1(hudSupport12.Part1 var1, hudSupport12.Part1 var2, hudSupport6 var3) {
      float var4 = this.v3 ? this.v2 : var2.v20;
      var1.v22 = var4 + (var1.v20 - var4) * var3.v6();
   }

   public final void v1(hudSupport40 var1, hudSupport12.Part1 var2, @Nullable hudSupport12.Part1 var3) {
      this.v1(var1, var2, var2.v22);
      if (var3 != null) {
         var3.v16 = var2.v16;
         var3.v18 = var2.v18;
         var3.v19 = var2.v19;
         var3.v17 = var2.v17;
      }
   }

   public final void v1(hudSupport6 var1, hudSupport12.Part1 var2) {
      if (!var1.v3()) {
         this.v3 = false;
      } else if (var1.v5()) {
         this.v3 = var2.v22 > 0.0F;
         this.v2 = var2.v22;
      }
   }

   public static class Part1 {
      public float v16;
      public float v18;
      public float v19;
      public float v17;
      public float v20;
      public float v21;
      public float v22;

      public Part1() {
      }
   }
}
