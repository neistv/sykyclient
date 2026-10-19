package cc.syky.ui;

import cc.syky.cloud.cloudSupport16;
import net.minecraft.class_2960;
import org.jetbrains.annotations.Nullable;

public abstract class uiSupport54 extends UiWidget {
   public final uiSupport54.Part1 v8;
   private final long v1;
   private final String v7;
   private String v13 = "";
   private String v14 = "";
   private String v15 = "";
   private long v16;
   private float v18 = -1.0F;
   private uiRecord7 v19 = uiRecord7.ZERO;
   private uiRecord7 v17 = uiRecord7.ZERO;
   private uiRecord7 v20 = uiRecord7.ZERO;

   public uiSupport54(uiSupport54.Part1 var1, long var2, String var4, float var5, boolean var6) {
      super(var5, var6);
      this.v8 = var1;
      this.v1 = var2;
      this.v7 = v1(var4, var2);
   }

   public static String v1(String var0, long var1) {
      return var0 + var1;
   }

   public long v11() {
      return this.v1;
   }

   public String v12() {
      return this.v13;
   }

   public String f_() {
      return this.v15;
   }

   @Override
   public String v2() {
      return this.v7;
   }

   public void v2(String var1, long var2) {
      if (!var1.equals(this.v13)) {
         this.v13 = var1;
         this.v14 = uiSupport122.v1(var1);
         this.v15 = uiSupport101.v1(var1);
      }

      this.v16 = var2;
   }

   public abstract String v4();

   public int v6(float var1) {
      return SignInSupport.v3(1.0F, var1);
   }

   public int v8() {
      return cloudSupport16.v3();
   }

   @Nullable
   public class_2960 v6() {
      return null;
   }

   @Nullable
   public class_2960 v7() {
      return null;
   }

   @Nullable
   public class_2960 v10() {
      return null;
   }

   public String v9() {
      return "";
   }

   public boolean v5() {
      return false;
   }

   public abstract void v1(uiSupport35 var1, float var2);

   @Override
   public void v1(uiSupport102 var1) {
      super.v1(var1);
      var1.v1(this.v13);
      var1.v1(this.v4());
      var1.v1(this.v5());
      var1.v1(this.v7());
      var1.v1(this.v1() != null);
      var1.v1(this.v10());
      var1.v1(this.v9());
   }

   @Nullable
   private class_2960 v1() {
      return this.v8.v27().v1(this.v1, this.v16);
   }

   @Override
   public void v1(uiSupport35 var1) {
      boolean var2 = this.v19().v1() && !this.v8.v28() && var1.v2();
      this.v6.v2(var2 && this.v1(var1.v1, var1.v2) ? 1.0F : 0.0F);
      float var3 = this.v6.v2();
      this.v5(var3);
      this.v26();
      float var4 = SignInSupport.v4(38.0F, this.v4);
      this.v7(var4);
      float var5 = this.v9 + SignInSupport.v4(16.0F, this.v4);
      float var6 = uiSupport126.v1(this.v10, this.v12, var4, this.v13());
      class_2960 var7 = this.v6();
      class_2960 var8 = this.v10();
      if (var8 != null) {
         uiSupport169.v1(var8, var5, var6, var4, uiSupport155.v1(-1, this.v5), this.v20);
      } else if (var7 != null) {
         float var9 = SignInSupport.v4(26.0F, this.v4);
         uiSupport169.v1(
            var7,
            var5 + uiSupport169.v1((var4 - var9) / 2.0F),
            var6 + uiSupport169.v1((var4 - var9) / 2.0F),
            var9,
            var9,
            uiSupport155.v1(SignInSupport.v19(), this.v5),
            uiRecord7.ZERO
         );
      } else {
         uiSupport122.v1(this.v1(), this.v14, var5, var6, var4, this.v19, SignInSupport.v19(), 17.0F * this.v4, this.v5);
      }

      if (this.v5()) {
         float var16 = SignInSupport.v4(14.0F, this.v4);
         uiSupport169.v1(var5 + var4 - var16, var6 + var4 - var16, var16, var16, uiSupport155.v1(-8126666, this.v5), this.v17);
      }

      float var17 = this.v10 + this.v12 / 2.0F;
      float var10 = this.v9 + SignInSupport.v4(65.0F, this.v4);
      float var11 = 18.0F * this.v4;
      float var12 = var17 + -20.0F * this.v4;
      uiSupport169.v1("syky_sans_strong", this.v13, var10, var12, var11, uiSupport155.v1(this.v6(var3), this.v5));
      String var13 = this.v9();
      if (!var13.isEmpty()) {
         uiSupport169.v1(
            "syky_sans",
            var13,
            uiSupport169.v1(var10 + uiSupport169.v2("syky_sans_strong", this.v13, var11) + 6.0F * this.v4),
            var12,
            var11,
            uiSupport155.v1(this.v8(), this.v5)
         );
      }

      class_2960 var14 = this.v7();
      if (var14 != null) {
         float var15 = SignInSupport.v4(14.0F, this.v4);
         uiSupport169.v1(
            var14,
            uiSupport169.v1(var10 + uiSupport169.v2("syky_sans_strong", this.v13, var11) + 6.0F * this.v4),
            var12 + 0.600625F * var11 - var15 / 2.0F,
            var15,
            var15,
            uiSupport155.v1(this.v8(), this.v5),
            uiRecord7.ZERO
         );
      }

      uiSupport169.v1("syky_sans", this.v4(), var10, var17 + 0.0F * this.v4, 17.0F * this.v4, uiSupport155.v1(this.v8(), this.v5));
      this.v1(var1, var3);
   }

   private void v7(float var1) {
      if (this.v18 != var1) {
         this.v18 = var1;
         this.v19 = uiRecord7.v1(var1 / 2.0F);
         this.v20 = uiRecord7.v1(SignInSupport.v4(10.857142F, this.v4));
         this.v17 = uiRecord7.v1(SignInSupport.v4(14.0F, this.v4) / 2.0F);
      }
   }

   public float v13() {
      return SignInSupport.v4(71.0F, this.v4);
   }

   public float v14() {
      return this.v10 + this.v12 / 2.0F;
   }

   public interface Part1 {
      uiSupport119 v27();

      boolean v28();
   }
}
