package cc.syky.render;

import cc.syky.cloud.cloudSupport101;
import cc.syky.ui.uiSupport155;
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

public final class renderSupport24 extends renderSupport37 {
   private static final class_2960 v12 = class_2960.method_60655("syky", "pipeline/shadow");
   private static final class_2960 v13 = class_2960.method_60655("syky", "core/gui/shadow");
   private static final int v14 = 128;
   public static final int v10 = 64;
   public static final int v11 = 16320;
   private static final RenderPipeline v15 = class_10799.method_67887(
      RenderPipeline.builder(new Snippet[0])
         .withLocation(v12)
         .withVertexShader(v13)
         .withFragmentShader(v13)
         .withVertexFormat(class_290.field_60033, class_5596.field_27379)
         .withUniform("ShadowData", class_10789.field_60031)
         .withBlend(BlendFunction.TRANSLUCENT)
         .withDepthTestFunction(DepthTestFunction.NO_DEPTH_TEST)
         .withDepthWrite(false)
         .withCull(false)
         .build()
   );

   public renderSupport24(cloudSupport101 var1, renderSupport44 var2) {
      super(var1, var2, 128);
   }

   public void v1(float var1, float var2, float var3, float var4, float var5, int var6, float var7, float var8, float var9) {
      this.v1(var1, var2, var3, var4, var5, var6, var7, var8, var9, 0.0F);
   }

   public void v1(float var1, float var2, float var3, float var4, float var5, int var6, float var7, float var8, float var9, float var10) {
      var1 += renderSupport33.v2();
      var2 += renderSupport33.v3();
      if (uiSupport155.v1(var6) != 0) {
         class_310 var11 = this.v1(var1, var2, var3, var4, var5 + var7 + var8 + var9);
         if (var11 != null) {
            this.v1();
            v1(renderSupport47.v1(this.v3), var1, var2, var3, var4, this.v6, this.v7, this.v5, var7, var5, var8, var9, var10, var6);
            this.v1(v15, "ShadowData", null, null, 64, 16320);
         }
      }
   }

   public static void v1(
      ByteBuffer var0,
      float var1,
      float var2,
      float var3,
      float var4,
      float var5,
      float var6,
      float var7,
      float var8,
      float var9,
      float var10,
      float var11,
      float var12,
      int var13
   ) {
      var0.clear();
      var0.putFloat(var1).putFloat(var2).putFloat(var3).putFloat(var4);
      var0.putFloat(var5).putFloat(var6).putFloat(var7).putFloat(var8);
      var0.putFloat(var9).putFloat(var10).putFloat(var11).putFloat(var12);
      uiSupport155.v1(var0, var13);
      var0.flip();
   }
}
