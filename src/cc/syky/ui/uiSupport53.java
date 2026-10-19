package cc.syky.ui;

import cc.syky.cloud.cloudSupport16;
import cc.syky.hud.hudSupport54;
import cc.syky.hud.hudSupport57;
import cc.syky.hud.hudSupport60;
import java.util.function.IntSupplier;
import net.minecraft.class_2960;
import org.jetbrains.annotations.Nullable;

public final class uiSupport53 extends uiSupport45 {
   private final uiSupport53.Part2 v1;
   private final String v2;
   @Nullable
   private final class_2960 v3;
   @Nullable
   private final uiSupport53.Part1 v4;
   private boolean v5;
   private final Runnable v6;
   private final hudSupport57 v7 = new hudSupport57(0.0F, 90.0F);
   private final hudSupport57 v8 = new hudSupport57(0.0F, 150.0F);
   private final hudSupport57 v13 = new hudSupport57(1.0F, 150.0F);
   private boolean v14 = true;
   private float v15 = -1.0F;
   private IntSupplier v16 = () -> 0;

   public uiSupport53(uiSupport53.Part2 var1, String var2, @Nullable class_2960 var3, float var4, Runnable var5) {
      this(var1, var2, var3, null, var4, var5);
   }

   private uiSupport53(uiSupport53.Part2 var1, String var2, @Nullable class_2960 var3, @Nullable uiSupport53.Part1 var4, float var5, Runnable var6) {
      super(var5);
      this.v1 = var1;
      this.v2 = var2;
      this.v3 = var3;
      this.v4 = var4;
      this.v6 = var6;
   }

   public static uiSupport53 v1(uiSupport53.Part2 var0, uiSupport53.Part1 var1, float var2, Runnable var3) {
      return new uiSupport53(var0, "", null, var1, var2, var3);
   }

   public static uiSupport53 v2(uiSupport53.Part2 var0, uiSupport53.Part1 var1, float var2, Runnable var3) {
      uiSupport53 var4 = new uiSupport53(var0, "", null, var1, var2, var3);
      var4.v5 = true;
      return var4;
   }

   public uiSupport53 v1() {
      this.v5 = true;
      return this;
   }

   public static uiSupport53.Part1 v1(class_2960 var0, float var1, float var2) {
      return v1(var0, var1, var2, 0.0F);
   }

   public static uiSupport53.Part1 v1(class_2960 var0, float var1, float var2, float var3) {
      return (var4, var5, var6, var7, var8, var9) -> {
         float var10 = SignInSupport.v4(var1, var9);
         float var11 = SignInSupport.v4(var2, var9);
         uiSupport169.v1(
            var0,
            var4 + uiSupport169.v1((var6 - var10) / 2.0F + var3 * var9),
            var5 + uiSupport169.v1((var7 - var11) / 2.0F),
            var10,
            var11,
            var8,
            uiRecord7.ZERO
         );
      };
   }

   public static uiSupport53.Part1 v4() {
      return (var0, var1, var2, var3, var4, var5) -> uiSupport111.v1(
         uiSupport110.FRIEND,
         var0 + uiSupport169.v1((var2 - uiSupport110.FRIEND.v1() * var5) / 2.0F),
         var1 + uiSupport169.v1((var3 - uiSupport110.FRIEND.v2() * var5) / 2.0F),
         var5,
         var4,
         1.0F
      );
   }

   public void v1(boolean var1) {
      this.v8.v2(var1 ? 1.0F : 0.0F);
   }

   public void v2(boolean var1) {
      this.v14 = var1;
   }

   public void v3(boolean var1) {
      this.v13.v2(var1 ? 1.0F : 0.0F);
   }

   public void v4(boolean var1) {
      this.v13.v3(var1 ? 1.0F : 0.0F);
   }

   public float v5() {
      return this.v13.v2();
   }

   public float v6() {
      if (this.v4 != null) {
         return 38.0F;
      } else if (this.v1 == uiSupport53.Part2.SEND) {
         return 200.0F;
      } else {
         if (this.v15 < 0.0F) {
            this.v15 = uiSupport169.v2("syky_sans", this.v2, 16.0F);
         }

         float var1 = this.v3 != null ? 40.0F : 16.0F;
         int var2 = this.v14();
         float var3 = var2 > 0 ? 8.0F + uiSupport51.v1(var2) : 0.0F;
         return (float)Math.ceil(var1 + this.v15 + var3 + 16.0F);
      }
   }

   public void v1(IntSupplier var1) {
      this.v16 = var1;
   }

   private int v14() {
      return this.v16.getAsInt();
   }

   public float v7() {
      return this.v8.v2();
   }

   public float v8() {
      return this.v7.v2();
   }

   @Override
   public int v9() {
      return uiSupport97.v1();
   }

   @Override
   public float v2() {
      float var1 = this.v13();
      return this.v5 && var1 > 0.0F ? this.v12 / var1 / 2.0F : 12.0F;
   }

   private float v15() {
      return this.v1 != uiSupport53.Part2.QUIET && this.v1 != uiSupport53.Part2.ACCEPT && this.v1 != uiSupport53.Part2.DANGER
         ? hudSupport60.v1(this.v13.v2())
         : 1.0F;
   }

   @Override
   public int v3() {
      return switch (this.v1) {
         case QUIET -> SignInSupport.v26();
         case ACCEPT -> cloudSupport16.v6();
         case SEND -> uiSupport155.v1(SignInSupport.v26(), cloudSupport16.v6(), this.v15());
         case SEND_INSIDE -> uiSupport155.v1(cloudSupport16.v6(), this.v15());
         case DANGER -> 649276974;
      };
   }

   @Override
   public int v10() {
      return switch (this.v1) {
         case QUIET -> SignInSupport.v27();
         case ACCEPT -> cloudSupport16.v7();
         case SEND -> uiSupport155.v1(SignInSupport.v27(), cloudSupport16.v9(), this.v15());
         case SEND_INSIDE -> uiSupport155.v1(cloudSupport16.v9(), this.v15());
         case DANGER -> 1085484590;
      };
   }

   @Override
   public int v11() {
      return this.v1 == uiSupport53.Part2.DANGER ? 649276974 : super.v11();
   }

   @Override
   public float v12() {
      return hudSupport60.v1(this.v8.v2());
   }

   @Override
   public float v2(uiSupport35 var1) {
      this.v7.v2(this.v14 && var1.v2() && this.v1(var1.v1, var1.v2) ? 1.0F : 0.0F);
      return hudSupport60.v1(this.v7.v2());
   }

   @Override
   public void v3(uiSupport35 var1) {
      float var2 = this.v13();
      float var3 = 16.0F * var2;
      float var4 = hudSupport60.v1(this.v7.v2());
      int var5 = uiSupport155.v1(cloudSupport16.v4(), cloudSupport16.v5(), var4);

      int var6 = switch (this.v1) {
         case QUIET -> uiSupport155.v1(var5, SignInSupport.v9(), this.v12());
         case ACCEPT -> cloudSupport16.v8();
         case SEND, SEND_INSIDE -> uiSupport155.v1(var5, cloudSupport16.v10(), this.v15());
         case DANGER -> -5034450;
      };
      uiSupport53.Part1 var7 = this.v4;
      if (var7 != null) {
         int var15 = uiSupport155.v1(SignInSupport.v28(), SignInSupport.v30(), var4);

         var7.draw(this.v9, this.v10, this.v11, this.v12, switch (this.v1) {
            case SEND, SEND_INSIDE -> uiSupport155.v1(var15, cloudSupport16.v10(), this.v15());
            default -> var15;
         }, var2);
      } else {
         float var8 = uiSupport169.v1(this.v10 + this.v12 / 2.0F, var3);
         class_2960 var9 = this.v3;
         if (var9 != null) {
            float var16 = SignInSupport.v4(18.0F, var2);
            float var17 = 0.0F;
            if (this.v1 != uiSupport53.Part2.SEND) {
               float var18 = SignInSupport.v4(27.0F, var2) + uiSupport169.v2("syky_sans", this.v2, var3);
               var17 = Math.max(0.0F, uiSupport169.v1((this.v11 - var18) / 2.0F) - SignInSupport.v4(13.0F, var2));
            }

            uiSupport169.v1(
               var9, this.v9 + SignInSupport.v4(13.0F, var2) + var17, this.v10 + uiSupport169.v1((this.v12 - var16) / 2.0F), var16, var16, var6, uiRecord7.ZERO
            );
            uiSupport169.v1("syky_sans", this.v2, this.v9 + SignInSupport.v4(40.0F, var2) + var17, var8, var3, var6);
         } else {
            float var10 = uiSupport169.v2("syky_sans", this.v2, var3);
            int var11 = this.v14();
            if (var11 <= 0) {
               uiSupport169.v1("syky_sans", this.v2, this.v9 + (this.v11 - var10) / 2.0F, var8, var3, var6);
            } else {
               float var12 = SignInSupport.v4(uiSupport51.v1(var11), var2);
               float var13 = SignInSupport.v4(8.0F, var2);
               float var14 = this.v9 + uiSupport169.v1((this.v11 - (var10 + var13 + var12)) / 2.0F);
               uiSupport169.v1("syky_sans", this.v2, var14, var8, var3, var6);
               uiSupport51.v1(var14 + var10 + var13 + var12, this.v10 + uiSupport169.v1((this.v12 - uiSupport51.v1(var2)) / 2.0F), var11, var2, 1.0F);
            }
         }
      }
   }

   @Override
   public boolean v1(float var1, float var2, int var3) {
      if (var3 == 0 && this.v1(var1, var2)) {
         this.v3(var1, var2);
         return true;
      } else {
         return false;
      }
   }

   @Override
   public void v3(float var1, float var2) {
      if (this.v14) {
         this.v6.run();
      }
   }

   @Override
   public hudSupport54 v2(float var1, float var2) {
      return this.v1(var1, var2) && this.v14 ? hudSupport54.POINTER : hudSupport54.ARROW;
   }

   @FunctionalInterface
   public interface Part1 {
      void draw(float var1, float var2, float var3, float var4, int var5, float var6);
   }

   public static enum Part2 {
      QUIET,
      ACCEPT,
      SEND,
      SEND_INSIDE,
      DANGER;

      private Part2() {
      }
   }
}
