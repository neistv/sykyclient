package cc.syky.ui;

import cc.syky.hud.hudSupport54;
import cc.syky.hud.hudSupport57;
import net.minecraft.class_2960;
import org.jetbrains.annotations.Nullable;

public final class uiSupport108 extends UiNode {
   public static final float v1 = 32.0F;
   public static final float v2 = 10.0F;
   public static final float v3 = 200.0F;
   private final class_2960 v4;
   private final float v5;
   private final float v6;
   private final String v7;
   private final Runnable v8;
   private final hudSupport57 v13 = new hudSupport57(0.0F, 90.0F);
   private final hudSupport57 v14 = new hudSupport57(0.0F, 150.0F);
   private boolean v15;
   private float v16 = 1.0F;

   public uiSupport108(class_2960 var1, float var2, float var3, String var4, Runnable var5) {
      this.v4 = var1;
      this.v5 = var2;
      this.v6 = var3;
      this.v7 = var4;
      this.v8 = var5;
   }

   public void v1(float var1) {
      this.v16 = var1;
   }

   public void v1(boolean var1) {
      this.v15 = var1;
      this.v14.v2(var1 ? 1.0F : 0.0F);
   }

   public void v2(boolean var1) {
      this.v15 = var1;
      this.v14.v3(var1 ? 1.0F : 0.0F);
   }

   public String v1() {
      return this.v7;
   }

   @Override
   public void v1(uiSupport35 var1) {
      float var2 = this.v11 / 2.0F;
      uiRecord7 var3 = uiRecord7.v1(var2);
      uiSupport169.v1(this.v9, this.v10, this.v11, this.v12, v3(), SignInSupport.v1(v4(), this.v16), SignInSupport.v2(this.v16), 1.0F, var3);
      this.v13.v2(this.v4(var1) ? 1.0F : 0.0F);
      float var4 = SignInSupport.v1(this.v13.v2());
      if (var4 > 0.0F) {
         uiSupport169.v1(this.v9, this.v10, this.v11, this.v12, uiSupport155.v1(SignInSupport.v29(), var4), var3);
      }

      float var5 = this.v14.v2();
      int var6 = uiSupport155.v1(SignInSupport.v28(), SignInSupport.v73(), var5);
      int var7 = uiSupport155.v1(SignInSupport.v30(), SignInSupport.v73(), var5);
      int var8 = uiSupport155.v1(var6, var7, SignInSupport.v1(this.v13.v2()));
      float var9 = SignInSupport.v4(this.v5, this.v16);
      float var10 = SignInSupport.v4(this.v6, this.v16);
      uiSupport169.v1(
         this.v4, this.v9 + uiSupport169.v1((this.v11 - var9) * 0.5F), this.v10 + uiSupport169.v1((this.v12 - var10) * 0.5F), var9, var10, var8, uiRecord7.ZERO
      );
   }

   public void v2() {
      this.v8.run();
   }

   @Override
   public hudSupport54 v2(float var1, float var2) {
      return hudSupport54.POINTER;
   }

   @Nullable
   public static uiSupport108 v1(uiSupport108[] var0, float var1, float var2) {
      for (uiSupport108 var6 : var0) {
         if (var6.v1(var1, var2)) {
            return var6;
         }
      }

      return null;
   }

   private static int v3() {
      return uiSupport49.v2(uiSupport47.EDGE, 10);
   }

   private static int v4() {
      return uiSupport49.v2(uiSupport47.EDGE, 18);
   }
}
