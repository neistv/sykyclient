package cc.syky.hud;

import cc.syky.cloud.cloudSupport101;
import cc.syky.cloud.cloudSupport12;
import cc.syky.config.FloatSetting;
import cc.syky.ui.WinsSupport;
import cc.syky.ui.uiRecord2;
import cc.syky.ui.uiSupport169;
import com.mojang.blaze3d.textures.GpuTextureView;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import net.minecraft.class_310;
import net.minecraft.class_327;
import net.minecraft.class_327.class_6415;
import net.minecraft.class_4597.class_4598;
import org.jetbrains.annotations.Nullable;
import org.joml.Matrix4f;

public final class hudSupport27 extends HiddenSupport {
   public static final String v2 = "scoreboard";
   private static final float v3 = 9.0F;
   private static final float v4 = 4.0F;
   private static final float v5 = 3.0F;
   private static final float v6 = 3.0F;
   private static final float v7 = 1.0F;
   private static final float v8 = 8.0F;
   private static final float v9 = 16.0F;
   private final cloudSupport101 v10;
   private final FloatSetting v11;
   @Nullable
   private uiRecord2 v12;
   private final cloudSupport12<uiRecord2> v13 = new cloudSupport12<>(var0 -> !var0.v1());
   private static final AtomicInteger v14 = new AtomicInteger();
   @Nullable
   private uiRecord2 v15;
   private int v16;
   private int v18;

   public hudSupport27(cloudSupport101 var1, hudSupport52 var2, float var3, float var4) {
      super("scoreboard", 1, var2, var3, var4, 4.0F);
      this.v10 = var1;
      this.v11 = this.v2().v1(new FloatSetting("radius", 8.0F, 0.0F, 16.0F));
      this.v44();
   }

   @Override
   public float a_(hudSupport40 var1) {
      return this.v9();
   }

   @Override
   public boolean v11(hudSupport40 var1) {
      return this.v47() || var1.v6().v48().v1();
   }

   @Override
   public boolean v30() {
      return true;
   }

   @Override
   public float v3(hudSupport40 var1, hudRecord4 var2, float var3) {
      return this.v11.getValue() * var3;
   }

   @Override
   public AbstractHudWidget.Part1 v3(hudSupport40 var1, float var2) {
      uiRecord2 var3 = this.v18(var1);
      float var4 = 10.0F + var3.v2() * 9.0F;
      float var5 = this.v6(var3.v5() + 8.0F, var2);
      float var6 = this.v6(var4 + 3.0F + 3.0F, var2);
      return this.v12(var5, var6);
   }

   @Nullable
   @Override
   public GpuTextureView v15(hudSupport40 var1) {
      uiRecord2 var2 = this.v18(var1);
      float var3 = var1.v5();
      float var4 = var3 > 0.0F ? 1.0F / var3 : 1.0F;
      float var5 = this.a_(var1) * var4;
      int var6 = Math.max(1, (int)Math.ceil(var5));
      int var7 = Math.round((var2.v5() + 8.0F) * var6);
      int var8 = Math.round((10.0F + var2.v2() * 9.0F + 3.0F + 3.0F) * var6);
      int var9 = v14.get();
      boolean var10 = this.v15 == null || var6 != this.v16 || var9 != this.v18 || !var2.equals(this.v15);
      GpuTextureView var11 = uiSupport169.v1("scoreboard", var7, var8, var10, (var3x, var4x) -> this.v1(var4x, var3x, var2, var6));
      if (var10 && var11 != null) {
         this.v15 = var2;
         this.v16 = var6;
         this.v18 = var9;
      }

      return var11;
   }

   private void v1(class_310 var1, class_4598 var2, uiRecord2 var3, float var4) {
      class_327 var5 = var1.field_1772;
      Matrix4f var6 = new Matrix4f().scale(var4, var4, 1.0F);
      int var7 = 15728880;
      float var8 = var3.v5();
      float var9 = 4.0F + (var8 - var3.v4()) / 2.0F;
      var5.method_27522(var3.v3(), var9, 3.0F, -1, false, var6, var2, class_6415.field_33993, 0, var7);
      float var10 = 4.0F + var8;
      List var11 = var3.v6();

      for (int var12 = 0; var12 < var11.size(); var12++) {
         uiRecord2.Part1 var13 = (uiRecord2.Part1)var11.get(var12);
         float var14 = 13.0F + var12 * 9.0F;
         var5.method_27522(var13.v1(), 4.0F, var14, -1, false, var6, var2, class_6415.field_33993, 0, var7);
         var5.method_27522(var13.v2(), var10 - var13.v3(), var14, -1, false, var6, var2, class_6415.field_33993, 0, var7);
      }
   }

   private uiRecord2 v18(hudSupport40 var1) {
      uiRecord2 var2 = this.v13.v1(var1.v6().v48(), this.v19());
      return var2 != null && !var2.v1() ? var2 : this.v49();
   }

   @Override
   public void v17() {
      this.v13.v1();
   }

   private uiRecord2 v49() {
      if (this.v12 == null) {
         class_327 var1 = this.v46();
         this.v12 = var1 == null ? uiRecord2.EMPTY : WinsSupport.v1(var1);
      }

      return this.v12;
   }

   public static void v40() {
      v14.incrementAndGet();
   }

   @Nullable
   private class_327 v46() {
      class_310 var1 = this.v10.v1();
      return var1 == null ? null : var1.field_1772;
   }
}
