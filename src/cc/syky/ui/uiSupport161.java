package cc.syky.ui;

import cc.syky.cloud.cloudSupport101;
import cc.syky.hud.hudSupport65;
import cc.syky.render.renderSupport33;
import cc.syky.render.renderSupport37;
import cc.syky.render.renderSupport44;
import cc.syky.render.renderSupport47;
import com.mojang.blaze3d.pipeline.BlendFunction;
import com.mojang.blaze3d.pipeline.RenderPipeline;
import com.mojang.blaze3d.pipeline.RenderPipeline.Snippet;
import com.mojang.blaze3d.platform.DepthTestFunction;
import com.mojang.blaze3d.vertex.VertexFormat.class_5596;
import java.nio.ByteBuffer;
import net.minecraft.class_10789;
import net.minecraft.class_10799;
import net.minecraft.class_290;
import net.minecraft.class_2960;
import net.minecraft.class_310;

public final class uiSupport161 extends renderSupport37 {
   private static final class_2960 v11 = class_2960.method_60655("syky", "pipeline/group_shadow");
   private static final class_2960 v12 = class_2960.method_60655("syky", "core/gui/group_shadow");
   private static final int v13 = 3;
   private static final int v14 = 2;
   public static final int v10 = 1072;
   private static final RenderPipeline v15 = class_10799.method_67887(
      RenderPipeline.builder(new Snippet[0])
         .withLocation(v11)
         .withVertexShader(v12)
         .withFragmentShader(v12)
         .withVertexFormat(class_290.field_60033, class_5596.field_27379)
         .withUniform("GroupShadowData", class_10789.field_60031)
         .withBlend(BlendFunction.TRANSLUCENT)
         .withDepthTestFunction(DepthTestFunction.NO_DEPTH_TEST)
         .withDepthWrite(false)
         .withCull(false)
         .build()
   );

   public uiSupport161(cloudSupport101 var1, renderSupport44 var2) {
      super(var1, var2, 1072);
   }

   public void v1(hudSupport65 var1, int var2) {
      int var3 = var1.v2();
      if (var3 != 0 && uiSupport155.v1(var2) != 0) {
         class_310 var4 = this.v1.v1();
         if (var4 != null && var4.method_1522() != null) {
            this.v1(var4);
            float var5 = renderSupport33.v2();
            float var6 = renderSupport33.v3();
            float var7 = 0.5F / this.v5;
            float var8 = Float.POSITIVE_INFINITY;
            float var9 = Float.POSITIVE_INFINITY;
            float var10 = Float.NEGATIVE_INFINITY;
            float var11 = Float.NEGATIVE_INFINITY;
            boolean var12 = false;

            for (int var13 = 0; var13 < var3; var13++) {
               if (var1.v9(var13)) {
                  float var14 = 3.0F * Math.max(var1.v6(var13), var7) + Math.max(Math.abs(var1.v7(var13)), Math.abs(var1.v8(var13))) + 1.0F;
                  var8 = Math.min(var8, var1.v1(var13) - var14);
                  var9 = Math.min(var9, var1.v2(var13) - var14);
                  var10 = Math.max(var10, var1.v1(var13) + var1.v3(var13) + var14);
                  var11 = Math.max(var11, var1.v2(var13) + var1.v4(var13) + var14);
                  var12 = true;
               }
            }

            if (var12) {
               float var17 = var8 + var5;
               float var18 = var9 + var6;
               float var15 = var10 - var8;
               float var16 = var11 - var9;
               if (var15 > 0.0F && var16 > 0.0F && Float.isFinite(var17 + var18 + var15 + var16)) {
                  this.v1();
                  this.v1(renderSupport47.v1(this.v3), var1, var17, var18, var15, var16, var5, var6, var2);
                  this.v1(v15, "GroupShadowData", null, null, 0, 1072);
               }
            }
         }
      }
   }

   private void v1(ByteBuffer var1, hudSupport65 var2, float var3, float var4, float var5, float var6, float var7, float var8, int var9) {
      var1.clear();
      var1.putFloat(var3).putFloat(var4).putFloat(var5).putFloat(var6);
      var1.putFloat(this.v6).putFloat(this.v7).putFloat(this.v5).putFloat(var2.v2());
      uiSupport155.v1(var1, var9);

      for (int var10 = 0; var10 < var2.v2(); var10++) {
         var1.putFloat(var2.v1(var10) + var7).putFloat(var2.v2(var10) + var8).putFloat(var2.v3(var10)).putFloat(var2.v4(var10));
         var1.putFloat(var2.v5(var10)).putFloat(var2.v6(var10)).putFloat(var2.v7(var10)).putFloat(var2.v8(var10));
      }

      var1.flip();
   }
}
