package cc.syky.ui;

import net.minecraft.class_2960;

public final class uiSupport96 {
   public static final float v1 = 10.0F;
   public static final float v2 = 40.0F;
   public static final float v3 = 10.0F;
   public static final float v4 = 22.0F;
   public static final float v5 = 7.0F;

   private uiSupport96() {
   }

   public static float v1() {
      return 15.0F;
   }

   public static float v1(int var0, boolean[] var1, float[] var2, float[] var3) {
      float var4 = 16.0F;

      for (int var5 = 0; var5 < var0; var5++) {
         if (var5 > 0) {
            var4 += var2[var5 - 1] + 6.0F + (var1[var5] ? v1() : 0.0F);
         }

         var3[var5] = var4;
      }

      return var0 == 0 ? 32.0F : var3[var0 - 1] + var2[var0 - 1] + 16.0F;
   }

   public static float v1(float var0, float var1) {
      return var0 + SignInSupport.v4(16.0F, var1);
   }

   public static float v1(float var0) {
      return SignInSupport.v4(189.0F, var0);
   }

   public static void v1(float var0, float var1, float var2, float var3, float var4, boolean var5, float var6) {
      if (!(var4 <= 0.002F)) {
         int var7 = var5 ? 649276974 : uiSupport95.v1();
         int var8 = var5 ? 1085484590 : uiSupport95.v2();
         uiSupport169.v1(
            var0,
            var1,
            var2,
            var3,
            uiSupport155.v1(var7, var4),
            uiSupport155.v1(SignInSupport.v1(var8, var6), var4),
            SignInSupport.v2(var6),
            1.0F,
            uiRecord7.v1(12.0F * var6)
         );
      }
   }

   public static void v1(float var0, float var1, float var2, float var3) {
      uiSupport169.v1(var0, var1, var2, SignInSupport.v2(var3), SignInSupport.v1(SignInSupport.v94(), var3), uiRecord7.ZERO);
   }

   public static int v1(float var0, boolean var1) {
      return var1 ? -5034450 : uiSupport155.v1(uiSupport95.v3(), uiSupport95.v4(), var0);
   }

   public static int v2(float var0, boolean var1) {
      return var1 ? -6414047 : uiSupport155.v1(SignInSupport.v28(), SignInSupport.v30(), var0);
   }

   public static void v1(String var0, float var1, float var2, float var3, int var4, float var5) {
      float var6 = 18.0F * var5;
      uiSupport169.v1("syky_sans_strong", var0, var1 + SignInSupport.v4(40.0F, var5), uiSupport169.v1(var2 + var3 / 2.0F, var6), var6, var4);
   }

   public static void v1(class_2960 var0, float var1, float var2, float var3, float var4, float var5, int var6, float var7) {
      float var8 = SignInSupport.v4(var1, var7);
      float var9 = SignInSupport.v4(var2, var7);
      float var10 = SignInSupport.v4(22.0F, var7);
      uiSupport169.v1(
         var0,
         var3 + SignInSupport.v4(7.0F, var7) + uiSupport169.v1((var10 - var8) * 0.5F),
         var4 + uiSupport169.v1((var5 - var9) * 0.5F),
         var8,
         var9,
         var6,
         uiRecord7.ZERO
      );
   }

   public static void v1(uiSupport109 var0, String var1, float var2, float var3, float var4, boolean var5, float var6) {
      float var7 = SignInSupport.v4(21.0F, var6);
      float var8 = var0.v1(var2 + SignInSupport.v4(10.0F, var6), var3 + uiSupport169.v1((var4 - var7) / 2.0F), var6, 1.0F);
      int var9 = uiSupport155.v1(uiSupport95.v3(), uiSupport95.v4(), Math.max(var8, var5 ? 1.0F : 0.0F));
      float var10 = 18.0F * var6;
      uiSupport169.v1("syky_sans_strong", var1, var2 + SignInSupport.v4(40.0F, var6), uiSupport169.v1(var3 + var4 / 2.0F, var10), var10, var9);
   }
}
