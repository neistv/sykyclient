package cc.syky.render;

import cc.syky.cloud.cloudRecord4;
import cc.syky.cloud.cloudRecord8;
import cc.syky.module.visual.visualSupport9;
import cc.syky.ui.uiSupport169;
import com.mojang.blaze3d.textures.GpuTextureView;
import java.nio.ByteBuffer;
import org.jetbrains.annotations.Nullable;
import org.joml.Matrix4f;
import org.joml.Vector3f;

public final class renderSupport45 {
   private renderSupport45() {
   }

   public static void v1(cloudRecord8 var0) {
      renderSupport46 var1 = uiSupport169.v1();
      if (var1 != null) {
         var1.v15().v1(var0);
      }
   }

   public static void v1(Matrix4f var0, Matrix4f var1, Matrix4f var2, Vector3f var3, float var4, float var5, int var6, int var7, float var8, boolean var9) {
      renderSupport46 var10 = uiSupport169.v1();
      renderSupport10.Part4 var11 = visualSupport9.v22();
      if (var10 != null && var11 != null) {
         var10.v16()
            .v1(
               var0,
               var1,
               var2,
               var3,
               var4,
               var5,
               var6,
               var7,
               var8,
               var11.v1(),
               var11.v2(),
               var11.v3(),
               visualSupport9.v20(),
               var9 ? visualSupport9.v16() : null,
               var9 ? visualSupport9.v18() : null
            );
      }
   }

   @Nullable
   public static COMPOSITESupport v1() {
      renderSupport46 var0 = uiSupport169.v1();
      return var0 == null ? null : var0.v18();
   }

   public static void v1(Matrix4f var0, float var1, float var2, float var3, float var4) {
      renderSupport46 var5 = uiSupport169.v1();
      renderSupport10.Part4 var6 = visualSupport9.v22();
      if (var5 != null && var6 != null) {
         var5.v19().v1(var0, var1, var2, var3, var4, var6.v1(), var6.v2(), var6.v3(), visualSupport9.v20());
      }
   }

   public static void v1(cloudRecord4 var0) {
      renderSupport46 var1 = uiSupport169.v1();
      if (var1 != null) {
         var1.v17().v1(var0);
      }
   }

   public static void v2(cloudRecord4 var0) {
      renderSupport46 var1 = uiSupport169.v1();
      if (var1 != null) {
         renderSupport10.Part3 var2 = visualSupport9.v17();
         if (var2 != null) {
            var1.v17().v1(var0, var2.v1(), var2.v2(), var2.v1());
         }
      }
   }

   public static void v1(cloudRecord4 var0, GpuTextureView var1) {
      renderSupport46 var2 = uiSupport169.v1();
      if (var2 != null) {
         var2.v17().v1(var0, var1);
      }
   }

   public static void v1(int var0, int var1, ByteBuffer var2, ByteBuffer var3) {
      renderSupport46 var4 = uiSupport169.v1();
      if (var4 != null) {
         var4.v17().v1(var0, var1, var2, var3);
      }
   }

   public static void v2() {
      renderSupport46 var0 = uiSupport169.v1();
      if (var0 != null) {
         var0.v17().v7();
      }
   }

   public static boolean v1(Matrix4f var0, float var1, float var2, float var3, float var4, float var5) {
      renderSupport46 var6 = uiSupport169.v1();
      return var6 == null ? false : var6.v21().v1(var0, var1, var2, var3, var4, var5);
   }

   public static boolean v1(GpuTextureView var0, Matrix4f var1, float var2) {
      renderSupport46 var3 = uiSupport169.v1();
      return var3 == null ? false : var3.v21().v1(var0, var1, var2);
   }

   public static void v1(int var0, float var1, float var2) {
      renderSupport46 var3 = uiSupport169.v1();
      if (var3 != null) {
         var3.v26().v1(var0, var1, var2);
      }
   }

   public static void v1(float var0, float var1, float var2, float var3, float var4, float var5) {
      renderSupport46 var6 = uiSupport169.v1();
      if (var6 != null) {
         var6.v20().v1(var0, var1, var2, var3, var4, var5);
      }
   }
}
