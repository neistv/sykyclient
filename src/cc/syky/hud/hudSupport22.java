package cc.syky.hud;

import cc.syky.cloud.BossBarSupport;
import cc.syky.cloud.cloudRecord3;
import cc.syky.cloud.cloudSupport101;
import cc.syky.cloud.cloudSupport12;
import cc.syky.cloud.cloudSupport13;
import cc.syky.ui.uiSupport169;
import com.mojang.blaze3d.textures.GpuTextureView;
import java.util.List;
import net.minecraft.class_2960;
import net.minecraft.class_310;
import net.minecraft.class_327;
import net.minecraft.class_4588;
import net.minecraft.class_1259.class_1261;
import net.minecraft.class_327.class_6415;
import net.minecraft.class_4597.class_4598;
import org.jetbrains.annotations.Nullable;
import org.joml.Matrix4f;

public final class hudSupport22 extends HiddenSupport {
   public static final String v2 = "bossbar";
   private static final class_2960[] v3 = v1(
      "pink_background", "blue_background", "red_background", "green_background", "yellow_background", "purple_background", "white_background"
   );
   private static final class_2960[] v4 = v1(
      "pink_progress", "blue_progress", "red_progress", "green_progress", "yellow_progress", "purple_progress", "white_progress"
   );
   private static final class_2960[] v5 = v1("notched_6_background", "notched_10_background", "notched_12_background", "notched_20_background");
   private static final class_2960[] v6 = v1("notched_6_progress", "notched_10_progress", "notched_12_progress", "notched_20_progress");
   private static final int v7 = 2048;
   private final cloudSupport101 v8;
   @Nullable
   private cloudRecord3 v9;
   private final cloudSupport12<cloudRecord3> v10 = new cloudSupport12<>(var0 -> !var0.v1());

   public hudSupport22(cloudSupport101 var1, hudSupport52 var2, float var3, float var4) {
      super("bossbar", 0, var2, var3, var4, 2.0F);
      this.v8 = var1;
      this.v44();
   }

   @Override
   public float a_(hudSupport40 var1) {
      return this.v9();
   }

   @Override
   public boolean v11(hudSupport40 var1) {
      return this.v47() || var1.v6().v40().v1();
   }

   @Override
   public boolean v30() {
      return true;
   }

   @Override
   public void v1(hudSupport40 var1, hudRecord4 var2, float var3) {
      this.v1(var2.v2(), var2.v3(), var2.v4(), var2.v5(), 0.0F);
   }

   @Override
   public AbstractHudWidget.Part1 v3(hudSupport40 var1, float var2) {
      cloudRecord3 var3 = this.v18(var1);
      return this.v12(this.v6(cloudSupport13.v1(var3.v3()), var2), this.v6(cloudSupport13.v2(var3.v2()), var2));
   }

   @Nullable
   @Override
   public GpuTextureView v15(hudSupport40 var1) {
      cloudRecord3 var2 = this.v18(var1);
      float var3 = var1.v5();
      float var4 = var3 > 0.0F ? 1.0F / var3 : 1.0F;
      float var5 = cloudSupport13.v1(var2.v3());
      float var6 = cloudSupport13.v2(var2.v2());
      if (var5 > 0.0F && var6 > 0.0F) {
         int var7 = Math.max(1, (int)Math.min(2048.0F / var5, 2048.0F / var6));
         int var8 = Math.min(var7, Math.max(1, (int)Math.ceil(this.a_(var1) * var4)));
         int var9 = Math.round(var5 * var8);
         int var10 = Math.round(var6 * var8);
         return uiSupport169.v1("bossbar", var9, var10, (var4x, var5x) -> this.v1(var5x, var4x, var2, var5, var8));
      } else {
         return null;
      }
   }

   private void v1(class_310 var1, class_4598 var2, cloudRecord3 var3, float var4, int var5) {
      Matrix4f var6 = new Matrix4f().scale(var5, var5, 1.0F);
      float var7 = (var4 - 182.0F) * 0.5F;
      List var8 = var3.v4();
      class_4588 var9 = hudSupport68.v1(var1, var2);

      for (int var10 = 0; var10 < var8.size(); var10++) {
         v1(var1, var9, var6, (cloudRecord3.Part1)var8.get(var10), var7, cloudSupport13.v4(var10));
      }

      class_327 var15 = var1.field_1772;
      int var11 = 15728880;

      for (int var12 = 0; var12 < var8.size(); var12++) {
         cloudRecord3.Part1 var13 = (cloudRecord3.Part1)var8.get(var12);
         float var14 = (var4 - 1.0F - var13.v6()) * 0.5F;
         var15.method_27522(var13.v5(), var14, cloudSupport13.v3(var12), -1, true, var6, var2, class_6415.field_33993, 0, var11);
      }
   }

   private static void v1(class_310 var0, class_4588 var1, Matrix4f var2, cloudRecord3.Part1 var3, float var4, float var5) {
      int var6 = var3.v2().ordinal();
      class_1261 var7 = var3.v3();
      int var8 = var7.ordinal() - 1;
      v1(var0, var1, var2, v3[var6], var4, var5, 182);
      if (var8 >= 0) {
         v1(var0, var1, var2, v5[var8], var4, var5, 182);
      }

      int var9 = cloudSupport13.v1(var3.v1());
      if (var9 > 0) {
         v1(var0, var1, var2, v4[var6], var4, var5, var9);
         if (var8 >= 0) {
            v1(var0, var1, var2, v6[var8], var4, var5, var9);
         }
      }
   }

   private static void v1(class_310 var0, class_4588 var1, Matrix4f var2, class_2960 var3, float var4, float var5, int var6) {
      hudSupport68.v1(var0, var1, var2, var3, 182, 5, 0, 0, var4, var5, var6, 5, -1);
   }

   private cloudRecord3 v18(hudSupport40 var1) {
      cloudRecord3 var2 = this.v10.v1(var1.v6().v40(), this.v19());
      return var2 != null && !var2.v1() ? var2 : this.v40();
   }

   @Override
   public void v17() {
      this.v10.v1();
   }

   private cloudRecord3 v40() {
      if (this.v9 == null) {
         class_327 var1 = this.v49();
         this.v9 = var1 == null ? cloudRecord3.EMPTY : BossBarSupport.v1(var1);
      }

      return this.v9;
   }

   @Nullable
   private class_327 v49() {
      class_310 var1 = this.v8.v1();
      return var1 == null ? null : var1.field_1772;
   }

   private static class_2960[] v1(String... var0) {
      class_2960[] var1 = new class_2960[var0.length];

      for (int var2 = 0; var2 < var0.length; var2++) {
         var1[var2] = class_2960.method_60656("boss_bar/" + var0[var2]);
      }

      return var1;
   }
}
