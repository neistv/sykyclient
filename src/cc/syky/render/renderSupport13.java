package cc.syky.render;

import cc.syky.cloud.RingDataSupport;
import cc.syky.cloud.cloudSupport101;
import cc.syky.module.visual.visualSupport8;
import cc.syky.module.visual.visualSupport9;
import com.mojang.blaze3d.buffers.GpuBuffer;
import com.mojang.blaze3d.buffers.GpuBufferSlice;
import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.textures.GpuTextureView;
import it.unimi.dsi.fastutil.HashCommon;
import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import java.nio.ByteBuffer;
import net.fabricmc.fabric.api.client.rendering.v1.world.WorldRenderContext;
import net.minecraft.class_11286;
import net.minecraft.class_12249;
import net.minecraft.class_2338;
import net.minecraft.class_243;
import net.minecraft.class_265;
import net.minecraft.class_276;
import net.minecraft.class_310;
import net.minecraft.class_3610;
import net.minecraft.class_4184;
import net.minecraft.class_4588;
import net.minecraft.class_4597;
import net.minecraft.class_638;
import net.minecraft.class_758;
import net.minecraft.class_761;
import net.minecraft.class_2338.class_2339;
import net.minecraft.class_2350.class_2351;
import net.minecraft.class_846.class_851;
import org.jetbrains.annotations.Nullable;
import org.joml.FrustumIntersection;
import org.joml.Matrix4f;
import org.joml.Quaternionf;
import org.joml.Vector3f;
import org.lwjgl.system.MemoryUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public final class renderSupport13 {
   private static final Logger v1 = LoggerFactory.getLogger("syky.render3d");
   private final cloudSupport101 v2;
   private final renderSupport15 v3 = new renderSupport15();
   private final renderSupport12 v4 = new renderSupport12();
   private final renderSupport11 v5 = new renderSupport11();
   private final renderSupport11 v6 = new renderSupport11();
   private final renderSupport10 v7 = new renderSupport10();
   private final renderSupport15 v8 = new renderSupport15();
   private final renderSupport12 v9 = new renderSupport12();
   private final renderSupport8 v10 = new renderSupport8();
   private final renderSupport v11;
   private final renderSupport2 v12;
   private final renderSupport2 v13;
   private final RingDataSupport v14;
   private final BeamDataSupport v15;
   private boolean v16;
   private double v18;
   private double v19;
   private double v17;
   private final Matrix4f v20 = new Matrix4f();
   private final Vector3f v21 = new Vector3f(1.0F, 0.0F, 0.0F);
   private final Vector3f v22 = new Vector3f(0.0F, 1.0F, 0.0F);
   private final Vector3f v24 = new Vector3f(0.0F, 0.0F, -1.0F);
   private float v25;
   private boolean v26;
   private final Matrix4f v27 = new Matrix4f();
   private final FrustumIntersection v28 = new FrustumIntersection();
   private boolean v29;
   private long v30 = -1L;
   @Nullable
   private class_4597 v32;
   @Nullable
   private class_11286 v23;
   @Nullable
   private GpuBuffer v33;
   private final Matrix4f v31 = new Matrix4f();
   private static final int v34 = 8;
   private static final int v36 = 64;
   private final long[] v38 = new long[64];
   private final float[] v42 = new float[64];
   private final int[] v43 = new int[64];
   private int v37 = 1;
   private final class_2339 v48 = new class_2339();

   public renderSupport13(cloudSupport101 var1) {
      this.v2 = var1;
      this.v11 = new renderSupport(var1);
      this.v12 = new renderSupport2(var1, "hit");
      this.v13 = new renderSupport2(var1, "trail");
      this.v14 = new RingDataSupport(var1);
      this.v15 = new BeamDataSupport(var1);
   }

   public void v1() {
      if (!this.v16) {
         this.v16 = true;

         try {
            renderSupport5.v1();
         } catch (Throwable var11) {
            v1.error("world-glow pipeline registration failed; billboard effects unavailable", var11);
         }

         try {
            EMISSIVESupport.v1();
         } catch (Throwable var10) {
            v1.error("world-sprite pipeline registration failed; sprite billboards unavailable", var10);
         }

         try {
            renderSupport4.v1();
         } catch (Throwable var9) {
            v1.error("world-shape pipeline registration failed; the fill depth seal is unavailable", var9);
         }

         try {
            SEALSupport.v1();
         } catch (Throwable var8) {
            v1.error("world-line pipeline registration failed; outlines are unavailable", var8);
         }

         try {
            renderSupport29.v1();
         } catch (Throwable var7) {
            v1.error("stroke group pipeline registration failed; translucent outlines are unavailable", var7);
         }

         try {
            SEALSupport2.v1();
         } catch (Throwable var6) {
            v1.error("area pipeline registration failed; block overlays are unavailable", var6);
         }

         try {
            renderSupport.v1();
         } catch (Throwable var5) {
            v1.error("dust field pipeline registration failed; the mote field is unavailable", var5);
         }

         try {
            renderSupport2.v1();
         } catch (Throwable var4) {
            v1.error("burst pipeline registration failed; hit and trail particles are unavailable", var4);
         }

         try {
            RingDataSupport.v1();
         } catch (Throwable var3) {
            v1.error("ground ring pipeline registration failed; health rings are unavailable", var3);
         }

         try {
            BeamDataSupport.v1();
         } catch (Throwable var2) {
            v1.error("loot beam pipeline registration failed; loot beams are unavailable", var2);
         }

         v1.info("started");
      }
   }

   public void v2() {
      if (this.v16) {
         this.v16 = false;
         v1("billboardBatcher", this.v3::v6);
         v1("shapeBatcher", this.v4::v21);
         v1("solidDepth", this.v5::close);
         v1("entityFloor", this.v6::close);
         v1("cover", this.v7::close);
         v1("mirrorBillboards", this.v8::v6);
         v1("mirrorShapes", this.v9::v21);
         v1("mirror", this.v10::close);
         v1("dustField", this.v11::close);
         v1("hitBursts", this.v12::close);
         v1("trailBursts", this.v13::close);
         v1("groundRings", this.v14::close);
         v1("lootBeams", this.v15::close);
         class_11286 var1 = this.v23;
         if (var1 != null) {
            v1("drainProjection", var1::close);
            this.v23 = null;
         }

         GpuBuffer var2 = this.v33;
         if (var2 != null) {
            v1("neutralFog", var2::close);
            this.v33 = null;
         }

         this.v26 = false;
         v1.info("stopped");
      }
   }

   private static void v1(String var0, Runnable var1) {
      try {
         var1.run();
      } catch (Throwable var3) {
         v1.warn("{} teardown failed", var0, var3);
      }
   }

   public class_11286 v3() {
      class_11286 var1 = this.v23;
      if (var1 == null) {
         var1 = new class_11286("syky:world_drain");
         this.v23 = var1;
      }

      return var1;
   }

   public GpuBufferSlice v4() {
      GpuBuffer var1 = this.v33;
      if (var1 == null) {
         var1 = RenderSystem.getDevice().createBuffer(() -> "syky:deferred_no_fog", 136, class_758.field_60096);
         ByteBuffer var2 = MemoryUtil.memCalloc(class_758.field_60096);

         try {
            RenderSystem.getDevice().createCommandEncoder().writeToBuffer(var1.slice(), var2);
         } finally {
            MemoryUtil.memFree(var2);
         }

         this.v33 = var1;
      }

      return renderSupport31.v1(var1);
   }

   public renderSupport15 v5() {
      return this.v3;
   }

   public renderSupport15 v6() {
      return this.v8;
   }

   public renderSupport12 v7() {
      return this.v9;
   }

   public renderSupport8 v8() {
      return this.v10;
   }

   public Matrix4f v9() {
      return this.v31;
   }

   public class_276 v10() {
      return this.v2.v1().method_1522();
   }

   public void v11() {
      this.v37++;
   }

   public float v1(double var1, double var3, double var5) {
      int var7 = (int)Math.floor(var1);
      int var8 = (int)Math.floor(var3);
      int var9 = (int)Math.floor(var5);
      long var10 = class_2338.method_10064(var7, var8, var9);
      int var12 = (int)(HashCommon.mix(var10) & 63L);
      if (this.v43[var12] == this.v37 && this.v38[var12] == var10) {
         return this.v42[var12];
      } else {
         float var13 = Float.NaN;
         class_638 var14 = this.v2.v1().field_1687;
         if (var14 != null) {
            for (int var15 = 0; var15 <= 8; var15++) {
               this.v48.method_10103(var7, var8 - var15, var9);
               class_3610 var16 = var14.method_8316(this.v48);
               if (!var16.method_15769()) {
                  var13 = this.v48.method_10264() + var16.method_15763(var14, this.v48);
                  break;
               }

               class_265 var17 = var14.method_8320(this.v48).method_26220(var14, this.v48);
               if (!var17.method_1110()) {
                  float var18 = this.v48.method_10264() + (float)var17.method_1105(class_2351.field_11052);
                  if (var18 <= var3 + 0.001) {
                     var13 = var18;
                     break;
                  }
               }
            }
         }

         this.v38[var12] = var10;
         this.v42[var12] = var13;
         this.v43[var12] = this.v37;
         return var13;
      }
   }

   public void v1(long var1) {
      if (this.v16) {
         this.v4.v1(var1);
         this.v9.v1(var1);
         this.v10.v1(var1);
         this.v14.v1(var1);
         this.v7.v1(var1);
      }
   }

   public renderSupport12 v12() {
      return this.v4;
   }

   public void v13() {
      this.v5.v1();
      this.v6.v1();
   }

   public renderSupport10 v14() {
      return this.v7;
   }

   public void v15() {
      this.v5.v1(this.v2.v1().method_1522());
   }

   public void v16() {
      this.v6.v1(this.v2.v1().method_1522());
   }

   @Nullable
   public GpuTextureView v18() {
      return this.v6.v2(this.v2.v1().method_1522());
   }

   public renderRecord v19() {
      return this.v5.v2();
   }

   @Nullable
   public GpuTextureView v17() {
      return this.v5.v2(this.v2.v1().method_1522());
   }

   @Nullable
   public class_276 v20() {
      class_761 var1 = this.v2.v1().field_1769;
      return var1 == null ? null : var1.method_29360();
   }

   public boolean v21() {
      class_761 var1 = this.v2.v1().field_1769;
      if (var1 == null) {
         return false;
      } else {
         ObjectArrayList var2 = var1.method_62220();
         int var3 = 0;

         for (int var4 = var2.size(); var3 < var4; var3++) {
            if (((class_851)var2.get(var3)).method_64065()) {
               return true;
            }
         }

         return false;
      }
   }

   public renderSupport v22() {
      return this.v11;
   }

   public renderSupport2 v1(visualSupport8 var1) {
      return var1 == visualSupport8.TRAIL ? this.v13 : this.v12;
   }

   public RingDataSupport v24() {
      return this.v14;
   }

   public BeamDataSupport v25() {
      return this.v15;
   }

   public void v1(WorldRenderContext var1) {
      if (this.v16 && var1 != null) {
         class_310 var2 = this.v2.v1();
         if (var2.field_1773 != null && var2.field_1773.method_19418() != null) {
            class_4184 var3 = var2.field_1773.method_19418();
            class_243 var4 = var3.method_71156();
            this.v18 = var4.field_1352;
            this.v19 = var4.field_1351;
            this.v17 = var4.field_1350;
            Quaternionf var5 = var3.method_23767();
            this.v21.set(1.0F, 0.0F, 0.0F);
            var5.transform(this.v21);
            this.v22.set(0.0F, 1.0F, 0.0F);
            var5.transform(this.v22);
            this.v24.set(this.v22).cross(this.v21);
            int var6 = var2.method_22683().method_4506();
            float var7 = visualSupport9.v5();
            this.v25 = var6 > 0 && var7 > 1.0E-4F ? 2.0F / (var6 * var7) : 0.0F;
            Matrix4f var8 = visualSupport9.v14() ? visualSupport9.v3() : null;
            if (var8 != null) {
               this.v20.set(var8);
            } else {
               this.v20.rotation(new Quaternionf(var5).conjugate());
            }

            Matrix4f var9 = visualSupport9.v4();
            this.v29 = var9 != null;
            if (var9 != null) {
               this.v28.set(this.v27.set(var9).mul(this.v20), false);
            }

            this.v30 = visualSupport9.v2();
            this.v32 = var1.consumers();
            this.v26 = true;
         }
      }
   }

   @Nullable
   public class_4588 v1(renderSupport9 var1) {
      if (this.v32 == null) {
         return null;
      } else if (var1 == renderSupport9.SPRITE) {
         throw new IllegalArgumentException(
            var1 + " is billboard-only; lines/boxes are unsupported for it. Use TRANSLUCENT or OPAQUE, or render via Render3D.billboard()."
         );
      } else {
         return this.v32.method_73477(var1 == renderSupport9.TRANSLUCENT ? class_12249.field_64592 : class_12249.field_64042);
      }
   }

   public void v26() {
      if (this.v26) {
         this.v26 = false;
         this.v32 = null;
      }
   }

   public boolean v27() {
      return this.v26;
   }

   public double v28() {
      return this.v18;
   }

   public double v29() {
      return this.v19;
   }

   public double v30() {
      return this.v17;
   }

   public Matrix4f v32() {
      return this.v20;
   }

   public Vector3f v23() {
      return this.v21;
   }

   public Vector3f v33() {
      return this.v22;
   }

   public boolean v1(double var1, double var3, double var5, double var7, double var9, double var11, double var13, double var15) {
      return this.v26 && this.v3(var1, var3, var5, var7, var9, var11, var13, var15);
   }

   public boolean v2(double var1, double var3, double var5, double var7, double var9, double var11, double var13, double var15) {
      return this.v30 == visualSupport9.v2() && this.v3(var1, var3, var5, var7, var9, var11, var13, var15);
   }

   private boolean v3(double var1, double var3, double var5, double var7, double var9, double var11, double var13, double var15) {
      if (!this.v29) {
         return false;
      } else {
         double var17 = var1 - this.v18;
         double var19 = var3 - this.v19;
         double var21 = var5 - this.v17;
         double var23 = var7 - this.v18;
         double var25 = var9 - this.v19;
         double var27 = var11 - this.v17;
         double var29 = Math.sqrt(Math.max(var17 * var17, var23 * var23) + Math.max(var19 * var19, var25 * var25) + Math.max(var21 * var21, var27 * var27));
         double var31 = var13 + var15 * this.v25 * var29;
         return !this.v28
            .testAab(
               (float)(var17 - var31), (float)(var19 - var31), (float)(var21 - var31), (float)(var23 + var31), (float)(var25 + var31), (float)(var27 + var31)
            );
      }
   }

   public float v31() {
      return this.v25;
   }

   public Vector3f v34() {
      return this.v24;
   }

   public float v1(float var1, float var2, float var3) {
      if (this.v25 <= 0.0F) {
         return 0.0F;
      } else {
         float var4 = var1 * this.v24.x + var2 * this.v24.y + var3 * this.v24.z;
         return this.v25 * Math.max(var4, 0.05F);
      }
   }
}
