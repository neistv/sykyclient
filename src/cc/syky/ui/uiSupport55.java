package cc.syky.ui;

import cc.syky.cloud.cloudSupport19;
import cc.syky.hud.hudSupport54;
import cc.syky.hud.hudSupport57;
import cc.syky.internal.InternalSupport25;
import java.util.List;
import java.util.function.Consumer;
import net.minecraft.class_2960;
import org.jetbrains.annotations.Nullable;

public final class uiSupport55 extends UiScreen implements uiSupport86 {
   private static final float v1 = 372.0F;
   private static final float v2 = 20.0F;
   private static final float v3 = 20.0F;
   private static final float v4 = 24.0F;
   private static final float v5 = 8.0F;
   private static final float v6 = 16.0F;
   private static final float v7 = 22.0F;
   private static final float v8 = 41.0F;
   private static final float v13 = 12.0F;
   private static final float v14 = 14.0F;
   private static final float v15 = 10.0F;
   private final uiSupport55.Part1 v16;
   private final Consumer<Boolean> v18;
   private final Runnable v19;
   private final uiSupport53 v17;
   private final uiSupport53 v20;
   private final hudSupport57 v21;
   private final hudSupport57 v22 = new hudSupport57(0.0F, 90.0F);
   private boolean v24;
   private float v25 = 1.0F;
   private final List<String> v26;

   public uiSupport55(uiSupport55.Part1 var1, float var2, Consumer<Boolean> var3, Runnable var4) {
      this.v16 = var1;
      this.v25 = var2;
      this.v18 = var3;
      this.v19 = var4;
      this.v24 = var1.v4();
      this.v21 = new hudSupport57(this.v24 ? 1.0F : 0.0F, 90.0F);
      this.v17 = new uiSupport53(uiSupport53.Part2.QUIET, "Cancel", null, var2, var4);
      this.v20 = new uiSupport53(var1.v7(), var1.v5(), var1.v6(), var2, this::v1);
      this.v26 = InternalSupport25.v1(var1.v2(), 332.0F, var0 -> uiSupport169.v2("syky_sans", var0, 16.0F));
   }

   private void v1() {
      this.v18.accept(this.v24);
   }

   @Override
   public float v2() {
      return 372.0F;
   }

   @Override
   public float a_(float var1) {
      return 52.0F + Math.max(1, this.v26.size()) * 22.0F + (this.v16.v3() == null ? 20.0F : 67.0F) + 38.0F + 20.0F;
   }

   @Override
   public void v2(float var1) {
      this.v25 = var1;
      this.v17.v1(var1);
      this.v20.v1(var1);
   }

   private float v5(float var1) {
      return SignInSupport.v4(var1, this.v25);
   }

   private float v5() {
      return this.v10 + this.v5(52.0F + Math.max(1, this.v26.size()) * 22.0F + 12.0F);
   }

   private float v6() {
      return this.v9 + this.v5(10.0F);
   }

   private float v7() {
      return this.v9 + this.v11 - this.v5(10.0F);
   }

   private boolean v6(float var1, float var2) {
      if (this.v16.v3() == null) {
         return false;
      } else {
         float var3 = this.v5();
         return var1 >= this.v6() && var1 <= this.v7() && var2 >= var3 && var2 <= var3 + this.v5(41.0F);
      }
   }

   private void v8() {
      float var1 = this.v5(38.0F);
      float var2 = this.v10 + this.v12 - this.v5(20.0F) - var1;
      float var3 = this.v9 + this.v5(20.0F);
      if (!this.v16.v8()) {
         this.v20.v1(var3, var2, this.v9 + this.v11 - this.v5(20.0F) - var3, var1);
      } else {
         float var4 = this.v5(10.0F);
         float var5 = (this.v11 - 2.0F * this.v5(20.0F) - var4) / 2.0F;
         this.v17.v1(var3, var2, uiSupport169.v1(var3 + var5) - var3, var1);
         this.v20.v1(uiSupport169.v1(var3 + var5 + var4), var2, this.v9 + this.v11 - this.v5(20.0F) - uiSupport169.v1(var3 + var5 + var4), var1);
      }
   }

   @Override
   public void v1(uiSupport35 var1) {
      this.v8();
      uiSupport97.v1(this.v9, this.v10, this.v11, this.v12, this.v25);
      float var2 = this.v9 + this.v5(20.0F);
      float var3 = 20.0F * this.v25;
      uiSupport169.v1("syky_sans_strong", this.v16.v1(), var2, uiSupport169.v1(this.v10 + 32.0F * this.v25, var3), var3, cloudSupport19.v8());
      float var4 = 16.0F * this.v25;
      float var5 = this.v10 + 52.0F * this.v25;

      for (String var7 : this.v26) {
         uiSupport169.v1("syky_sans", var7, var2, uiSupport169.v1(var5 + 22.0F * this.v25 / 2.0F, var4), var4, cloudSupport19.v9());
         var5 += 22.0F * this.v25;
      }

      String var8 = this.v16.v3();
      if (var8 != null) {
         this.v1(var1, var8);
      }

      if (this.v16.v8()) {
         this.v17.v1(var1);
      }

      this.v20.v1(var1);
   }

   private void v1(uiSupport35 var1, String var2) {
      float var3 = this.v5();
      float var4 = this.v6();
      float var5 = this.v5(41.0F);
      this.v22.v2(var1.v2() && this.v6(var1.v1, var1.v2) ? 1.0F : 0.0F);
      uiSupport96.v1(var4, var3, this.v7() - var4, var5, SignInSupport.v1(this.v22.v2()), false, this.v25);
      this.v21.v2(this.v24 ? 1.0F : 0.0F);
      float var6 = SignInSupport.v1(this.v21.v2());
      if (var6 > 0.002F) {
         float var7 = var4 + this.v5(10.0F);
         float var8 = var3 + uiSupport169.v1(15.67F * this.v25);
         float var9 = 16.0F * this.v25;
         float var10 = 11.5556F * this.v25;
         boolean var11 = uiSupport132.v1(uiSupport132.v3, var6, var7, var8, var9, var10, this.v25);

         try {
            uiSupport72.v1(var7, var8, var9, var10, var11 ? 1.0F : var6);
         } finally {
            if (var11) {
               uiSupport132.v2(uiSupport132.v3, var6, var7, var8, var9, var10, this.v25);
            }
         }
      }

      float var15 = 18.0F * this.v25;
      uiSupport169.v1(
         "syky_sans",
         var2,
         var4 + this.v5(36.0F),
         uiSupport169.v1(var3 + var5 / 2.0F, var15),
         var15,
         uiSupport155.v1(uiSupport79.v2(), uiSupport79.v3(), Math.max(var6, SignInSupport.v1(this.v22.v2())))
      );
   }

   @Override
   public boolean v1(float var1, float var2, int var3) {
      if (!this.v1(var1, var2)) {
         return false;
      } else {
         this.v8();
         if (var3 != 0) {
            return true;
         } else if (this.v6(var1, var2)) {
            this.v24 = !this.v24;
            return true;
         } else if (this.v16.v8() && this.v17.v1(var1, var2)) {
            return this.v17.v1(var1, var2, var3);
         } else {
            return this.v20.v1(var1, var2) ? this.v20.v1(var1, var2, var3) : true;
         }
      }
   }

   @Override
   public boolean v2(int var1, int var2) {
      if (var1 != 257 && var1 != 335) {
         return false;
      } else {
         this.v1();
         return true;
      }
   }

   @Override
   public hudSupport54 v2(float var1, float var2) {
      this.v8();
      if (this.v6(var1, var2)) {
         return hudSupport54.POINTER;
      } else if (this.v16.v8() && this.v17.v1(var1, var2)) {
         return this.v17.v2(var1, var2);
      } else {
         return this.v20.v1(var1, var2) ? this.v20.v2(var1, var2) : hudSupport54.ARROW;
      }
   }

   public record Part1(
      String title,
      String body,
      @Nullable String option,
      boolean optionOn,
      String verb,
      @Nullable class_2960 verbGlyph,
      uiSupport53.Part2 verbLook,
      boolean cancellable
   ) {
      public Part1(String var1, String var2, @Nullable String var3, boolean var4, String var5, @Nullable class_2960 var6, uiSupport53.Part2 var7) {
         this(var1, var2, var3, var4, var5, var6, var7, true);
      }

      public static uiSupport55.Part1 v1(String var0, String var1) {
         return new uiSupport55.Part1(var0, var1, null, false, "OK", null, uiSupport53.Part2.QUIET, false);
      }

      public String v1() {
         return this.title;
      }

      public String v2() {
         return this.body;
      }

      @Nullable
      public String v3() {
         return this.option;
      }

      public boolean v4() {
         return this.optionOn;
      }

      public String v5() {
         return this.verb;
      }

      @Nullable
      public class_2960 v6() {
         return this.verbGlyph;
      }

      public uiSupport53.Part2 v7() {
         return this.verbLook;
      }

      public boolean v8() {
         return this.cancellable;
      }
   }
}
