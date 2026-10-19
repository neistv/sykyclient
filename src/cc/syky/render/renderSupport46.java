package cc.syky.render;

import cc.syky.account.BlurParamsSupport;
import cc.syky.account.accountSupport11;
import cc.syky.account.accountSupport7;
import cc.syky.account.accountSupport9;
import cc.syky.cloud.BlurDataSupport;
import cc.syky.cloud.FogSupport;
import cc.syky.cloud.MsdfDataSupport;
import cc.syky.cloud.cloudSupport101;
import cc.syky.cloud.cloudSupport53;
import cc.syky.hud.hudSupport69;
import cc.syky.internal.InternalSupport37;
import cc.syky.module.SHIELDSupport;
import cc.syky.ui.uiSupport159;
import cc.syky.ui.uiSupport161;
import cc.syky.ui.uiSupport166;
import org.jetbrains.annotations.Nullable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public final class renderSupport46 {
   private static final Logger v1 = LoggerFactory.getLogger("syky.render");
   private static final int v2 = 256;
   private static final int v3 = 65536;
   private final cloudSupport101 v4;
   private final renderSupport43 v5 = new renderSupport43();
   private final accountSupport11 v6;
   @Nullable
   private renderSupport39 v7;
   @Nullable
   private renderSupport44 v8;
   @Nullable
   private RectDataSupport v9;
   @Nullable
   private RectBoxDataSupport v10;
   @Nullable
   private renderSupport25 v11;
   @Nullable
   private LineDataSupport v12;
   @Nullable
   private renderSupport24 v13;
   @Nullable
   private uiSupport161 v14;
   @Nullable
   private BlurDataSupport v15;
   @Nullable
   private renderSupport19 v16;
   @Nullable
   private SHIELDSupport v18;
   @Nullable
   private COMPOSITESupport v19;
   @Nullable
   private BlurParamsSupport v17;
   @Nullable
   private FogSupport v20;
   @Nullable
   private renderSupport18 v21;
   @Nullable
   private renderSupport16 v22;
   @Nullable
   private RainParamsSupport v24;
   @Nullable
   private accountSupport9 v25;
   @Nullable
   private renderSupport21 v26;
   @Nullable
   private VeilDataSupport v27;
   @Nullable
   private accountSupport7 v28;
   @Nullable
   private uiSupport159 v29;
   @Nullable
   private MsdfDataSupport v30;
   @Nullable
   private hudSupport69 v32;
   @Nullable
   private renderSupport22 v23;
   @Nullable
   private renderSupport22 v33;
   private final renderSupport13 v31;
   private final uiSupport166 v34;
   private boolean v36;

   public renderSupport46(cloudSupport101 var1, cloudSupport53 var2) {
      this.v4 = var1;
      this.v6 = new accountSupport11(new InternalSupport37(), var2);
      this.v31 = new renderSupport13(var1);
      this.v34 = new uiSupport166(var1);
   }

   public accountSupport11 v1() {
      return this.v6;
   }

   public cloudSupport101 v2() {
      return this.v4;
   }

   public void v3() {
      if (!this.v36) {
         this.v36 = true;
         this.v7 = new renderSupport39(this.v4, 256, this.v5);
         this.v8 = new renderSupport44(this.v7, 65536);
         this.v9 = new RectDataSupport(this.v4, this.v8);
         this.v10 = new RectBoxDataSupport(this.v4, this.v8);
         this.v11 = new renderSupport25(this.v4, this.v8);
         this.v12 = new LineDataSupport(this.v4, this.v8);
         this.v13 = new renderSupport24(this.v4, this.v8);
         this.v14 = new uiSupport161(this.v4, this.v8);
         this.v15 = new BlurDataSupport(this.v4, this.v6);
         this.v16 = new renderSupport19(this.v4);
         this.v18 = new SHIELDSupport(this.v4);
         this.v19 = new COMPOSITESupport(this.v4);
         this.v17 = new BlurParamsSupport(this.v4);
         this.v20 = new FogSupport(this.v4);
         this.v21 = new renderSupport18(this.v4);
         this.v22 = new renderSupport16(this.v4);
         this.v24 = new RainParamsSupport(this.v4);
         this.v26 = new renderSupport21();
         this.v27 = new VeilDataSupport();
         this.v25 = new accountSupport9(this.v4, this.v26, this.v27);
         this.v28 = new accountSupport7(this.v4);
         this.v29 = new uiSupport159(this.v4, this.v8);
         this.v30 = new MsdfDataSupport(this.v4, this.v8);
         this.v32 = new hudSupport69(this.v4, this.v6);
         this.v23 = new renderSupport22(this.v4);
         this.v33 = new renderSupport22(this.v4);

         try {
            renderSupport6.v1();
         } catch (Throwable var2) {
            v1.error("fire screen pipeline registration failed; the fire overlay recolour is unavailable", var2);
         }

         this.v31.v1();
         this.v34.v1("syky_sans", "syky_sans");
         this.v34.v1("syky_sans_strong", "syky_sans_strong");
         this.v34.v1("syky_sans_quiet", "syky_sans_quiet");
         v1.info("started");
      }
   }

   public void v4() {
      if (this.v36) {
         this.v36 = false;
         this.v9 = v1(this.v9, "rect");
         this.v10 = v1(this.v10, "box");
         this.v11 = v1(this.v11, "outline");
         this.v12 = v1(this.v12, "line");
         this.v13 = v1(this.v13, "shadow");
         this.v14 = v1(this.v14, "groupShadow");
         this.v15 = v1(this.v15, "blur");
         this.v16 = v1(this.v16, "colorGrade");
         this.v18 = v1(this.v18, "motionBlur");
         this.v19 = v1(this.v19, "handBlur");
         this.v17 = v1(this.v17, "fogBlur");
         this.v20 = v1(this.v20, "wetSurfaces");
         this.v21 = v1(this.v21, "customSky");
         this.v22 = v1(this.v22, "vignette");
         this.v24 = v1(this.v24, "rainDrops");
         this.v25 = v1(this.v25, "layer");
         this.v26 = v1(this.v26, "layerTransform");
         this.v27 = v1(this.v27, "layerVeil");
         this.v28 = v1(this.v28, "wobble");
         this.v29 = v1(this.v29, "texture");
         this.v30 = v1(this.v30, "msdf");
         this.v23 = v1(this.v23, "hudComposite");
         this.v33 = v1(this.v33, "watermarkComposite");
         this.v32 = v1(this.v32, "guiCapture");

         try {
            this.v31.v2();
         } catch (Throwable var2) {
            v1.warn("render3D teardown failed", var2);
         }

         this.v34.v2();
         this.v8 = v1(this.v8, "batch");
         this.v7 = v1(this.v7, "batchSink");
         v1.info("stopped");
      }
   }

   @Nullable
   private static <T extends AutoCloseable> T v1(@Nullable T var0, String var1) {
      if (var0 != null) {
         try {
            var0.close();
         } catch (Throwable var3) {
            v1.warn("{} teardown failed", var1, var3);
         }
      }

      return null;
   }

   @Nullable
   public renderSupport44 v5() {
      return this.v8;
   }

   public renderSupport43 v6() {
      return this.v5;
   }

   public void v7() {
      renderSupport44 var1 = this.v8;
      if (var1 != null) {
         int var2 = this.v6.v1("gpu.batch2d");

         try {
            var1.v5();
         } finally {
            this.v6.v1(var2);
         }
      }
   }

   public RectDataSupport v8() {
      if (this.v9 == null) {
         throw new IllegalStateException("RenderCore not started");
      } else {
         return this.v9;
      }
   }

   public RectBoxDataSupport v9() {
      if (this.v10 == null) {
         throw new IllegalStateException("RenderCore not started");
      } else {
         return this.v10;
      }
   }

   public renderSupport25 v10() {
      if (this.v11 == null) {
         throw new IllegalStateException("RenderCore not started");
      } else {
         return this.v11;
      }
   }

   public LineDataSupport v11() {
      if (this.v12 == null) {
         throw new IllegalStateException("RenderCore not started");
      } else {
         return this.v12;
      }
   }

   public renderSupport24 v12() {
      if (this.v13 == null) {
         throw new IllegalStateException("RenderCore not started");
      } else {
         return this.v13;
      }
   }

   public uiSupport161 v13() {
      if (this.v14 == null) {
         throw new IllegalStateException("RenderCore not started");
      } else {
         return this.v14;
      }
   }

   public BlurDataSupport v14() {
      if (this.v15 == null) {
         throw new IllegalStateException("RenderCore not started");
      } else {
         return this.v15;
      }
   }

   public renderSupport19 v15() {
      if (this.v16 == null) {
         throw new IllegalStateException("RenderCore not started");
      } else {
         return this.v16;
      }
   }

   public SHIELDSupport v16() {
      if (this.v18 == null) {
         throw new IllegalStateException("RenderCore not started");
      } else {
         return this.v18;
      }
   }

   public COMPOSITESupport v18() {
      if (this.v19 == null) {
         throw new IllegalStateException("RenderCore not started");
      } else {
         return this.v19;
      }
   }

   public BlurParamsSupport v19() {
      if (this.v17 == null) {
         throw new IllegalStateException("RenderCore not started");
      } else {
         return this.v17;
      }
   }

   public FogSupport v17() {
      if (this.v20 == null) {
         throw new IllegalStateException("RenderCore not started");
      } else {
         return this.v20;
      }
   }

   public RainParamsSupport v20() {
      if (this.v24 == null) {
         throw new IllegalStateException("RenderCore not started");
      } else {
         return this.v24;
      }
   }

   public renderSupport18 v21() {
      if (this.v21 == null) {
         throw new IllegalStateException("RenderCore not started");
      } else {
         return this.v21;
      }
   }

   @Nullable
   public accountSupport9 v22() {
      return this.v25;
   }

   @Nullable
   public renderSupport21 v24() {
      return this.v26;
   }

   @Nullable
   public accountSupport7 v25() {
      return this.v28;
   }

   public renderSupport16 v26() {
      if (this.v22 == null) {
         throw new IllegalStateException("RenderCore not started");
      } else {
         return this.v22;
      }
   }

   public uiSupport159 v27() {
      if (this.v29 == null) {
         throw new IllegalStateException("RenderCore not started");
      } else {
         return this.v29;
      }
   }

   public MsdfDataSupport v28() {
      if (this.v30 == null) {
         throw new IllegalStateException("RenderCore not started");
      } else {
         return this.v30;
      }
   }

   @Nullable
   public hudSupport69 v29() {
      return this.v32;
   }

   @Nullable
   public renderSupport22 v30() {
      return this.v23;
   }

   @Nullable
   public renderSupport22 v32() {
      return this.v33;
   }

   public renderSupport13 v23() {
      return this.v31;
   }

   public void v1(long var1) {
      if (this.v36) {
         v1(this.v16, var1);
         v1(this.v18, var1);
         v1(this.v19, var1);
         v1(this.v20, var1);
         v1(this.v24, var1);
         v1(this.v25, var1);
         v1(this.v26, var1);
         v1(this.v27, var1);
         BlurParamsSupport var3 = this.v17;
         if (var3 != null) {
            var3.v1(var1);
         }

         accountSupport7 var4 = this.v28;
         if (var4 != null) {
            var4.v1(var1);
         }

         renderSupport22 var5 = this.v23;
         if (var5 != null) {
            var5.v2(var1);
         }

         renderSupport22 var6 = this.v33;
         if (var6 != null) {
            var6.v2(var1);
         }

         this.v31.v1(var1);
      }
   }

   private static void v1(@Nullable renderSupport36 var0, long var1) {
      if (var0 != null) {
         var0.v1(var1);
      }
   }

   public uiSupport166 v33() {
      return this.v34;
   }
}
