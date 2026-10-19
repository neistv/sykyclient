package cc.syky.render;

import cc.syky.cloud.cloudSupport69;
import com.mojang.blaze3d.pipeline.RenderPipeline;
import com.mojang.blaze3d.textures.GpuTextureView;
import com.mojang.blaze3d.vertex.VertexFormat;
import com.mojang.blaze3d.vertex.VertexFormat.class_5596;
import java.util.function.Supplier;
import net.minecraft.class_12249;
import net.minecraft.class_1921;
import net.minecraft.class_287;
import net.minecraft.class_290;
import net.minecraft.class_4588;
import net.minecraft.class_4720;
import net.minecraft.class_9799;
import net.minecraft.class_9801;
import org.jetbrains.annotations.Nullable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public final class renderSupport12 {
   public static final Logger v1 = LoggerFactory.getLogger("syky.render3d.shape");
   private static final int v2 = 4096;
   private final renderSupport12.Part1 v3 = new renderSupport12.Part1(class_12249::method_76023);
   private final renderSupport12.Part1 v4 = new renderSupport12.Part1(renderSupport4::v6);
   private final renderSupport12.Part1 v5 = new renderSupport12.Part1(renderSupport4::v2);
   private final renderSupport12.Part1 v6 = new renderSupport12.Part1(renderSupport4::v3);
   private final renderSupport12.Part1 v7 = new renderSupport12.Part1(renderSupport4::v4);
   private final renderSupport12.Part1 v8 = new renderSupport12.Part1(renderSupport4::v5);
   private final renderSupport12.Part1 v9 = new renderSupport12.Part1(SEALSupport::v3, class_290.field_1580);
   private final renderSupport12.Part1 v10 = new renderSupport12.Part1(SEALSupport::v4, class_290.field_1580);
   private final renderSupport12.Part1 v11 = new renderSupport12.Part1(SEALSupport::v2, class_290.field_1580);
   private final renderSupport12.Part1[] v12 = new renderSupport12.Part1[]{this.v3, this.v8, this.v4, this.v5, this.v6, this.v7, this.v9, this.v10, this.v11};
   private final AreaItemsSupport v13 = new AreaItemsSupport();
   private final renderSupport29 v14 = new renderSupport29();
   @Nullable
   private class_4588 v15;

   public renderSupport12() {
   }

   public class_4588 v1() {
      return this.v3.v1();
   }

   public class_4588 v2() {
      return this.v8.v1();
   }

   public class_4588 v3() {
      return this.v5.v1();
   }

   public class_4588 v1(int var1) {
      class_4588 var2 = this.v3.v1();
      if (var1 >>> 24 == 0) {
         return var2;
      } else {
         class_4588 var3 = this.v15;
         if (var3 == null) {
            var3 = class_4720.method_24037(var2, this.v4.v1());
            this.v15 = var3;
         }

         return var3;
      }
   }

   public class_4588 v2(int var1) {
      this.v9.v1 |= var1 >>> 24 < 255;
      return this.v9.v1();
   }

   public class_4588 v3(int var1) {
      this.v10.v1 |= var1 >>> 24 < 255;
      return this.v10.v1();
   }

   public class_4588 v4() {
      return this.v11.v1();
   }

   public boolean v5() {
      return this.v3.v2() && this.v8.v2() && this.v9.v2() && this.v13.v1();
   }

   public AreaItemsSupport v6() {
      return this.v13;
   }

   public boolean v7() {
      return this.v6.v2() && this.v7.v2();
   }

   public boolean v8() {
      return this.v5.v2() && this.v10.v2();
   }

   public boolean v9() {
      return this.v10.v2();
   }

   public void v10() {
      this.v15 = null;
      this.v13.v2();
      this.v3.v3();
      this.v8.v3();
   }

   public void v11() {
      GpuTextureView var1 = renderSupport14.v1();
      GpuTextureView var2 = renderSupport14.v2();
      boolean var3 = this.v9.v1 || this.v13.v3();
      if (renderSupport29.v1 && var3 && var1 != null && var2 != null) {
         this.v14.v1(var1, var2);

         try {
            this.v13.v1(this.v14);
            this.v9.v1(this.v14, SEALSupport.v3);
         } finally {
            this.v14.v1(var1);
         }
      } else {
         this.v13.v1(null);
         this.v9.v3();
      }
   }

   public void v12() {
      this.v15 = null;
      this.v4.v3();
   }

   public void v13() {
      this.v13.v4();
      this.v11.v3();
   }

   public void v14() {
      this.v5.v3();
   }

   public void v15() {
      GpuTextureView var1 = renderSupport14.v1();
      if (renderSupport29.v1 && this.v10.v1 && var1 != null) {
         this.v14.v1(var1, null);

         try {
            this.v10.v1(this.v14, SEALSupport.v5);
         } finally {
            this.v14.v1(var1);
         }
      } else {
         this.v10.v3();
      }
   }

   public void v16() {
      this.v7.v3();
      this.v6.v3();
   }

   public class_4588 v18() {
      return this.v7.v1();
   }

   public class_4588 v19() {
      return this.v6.v1();
   }

   public void v17() {
      this.v15 = null;
      this.v13.v5();
      this.v4.v4();
      this.v11.v4();
   }

   public void v20() {
      this.v15 = null;
      this.v13.v6();

      for (renderSupport12.Part1 var4 : this.v12) {
         var4.v5();
      }
   }

   public void v1(long var1) {
      this.v14.v1(var1);
   }

   public void v21() {
      this.v13.v7();
      this.v14.close();

      for (renderSupport12.Part1 var4 : this.v12) {
         var4.v6();
      }
   }

   public static final class Part1 {
      private final class_9799 v2 = new class_9799(4096);
      private final Supplier<class_1921> v3;
      private final VertexFormat v4;
      @Nullable
      private class_287 v5;
      public boolean v1;

      public Part1(Supplier<class_1921> var1) {
         this(var1, class_290.field_1576);
      }

      public Part1(Supplier<class_1921> var1, VertexFormat var2) {
         this.v3 = var1;
         this.v4 = var2;
      }

      public class_4588 v1() {
         if (this.v5 == null) {
            this.v5 = cloudSupport69.v1(() -> new class_287(this.v2, class_5596.field_27382, this.v4));
         }

         return this.v5;
      }

      public boolean v2() {
         return this.v5 == null;
      }

      public void v3() {
         class_287 var1 = this.v5;
         this.v5 = null;
         this.v1 = false;
         if (var1 != null) {
            class_9801 var2 = null;

            try {
               var2 = var1.method_60794();
               if (var2 != null) {
                  this.v3.get().method_60895(var2);
               }
            } catch (Throwable var6) {
               if (var2 != null) {
                  try {
                     var2.close();
                  } catch (Throwable var5) {
                  }
               }

               renderSupport12.v1.warn("shape batch flush failed", var6);
            }
         }
      }

      public void v1(renderSupport29 var1, RenderPipeline var2) {
         class_287 var3 = this.v5;
         this.v5 = null;
         this.v1 = false;
         if (var3 != null) {
            try {
               class_9801 var4 = var3.method_60794();
               if (var4 != null) {
                  var1.v1(var4, var2);
               }
            } catch (Throwable var5) {
               renderSupport12.v1.warn("grouped stroke flush failed", var5);
            }
         }
      }

      public boolean v4() {
         class_287 var1 = this.v5;
         this.v5 = null;
         this.v1 = false;
         if (var1 == null) {
            return false;
         } else {
            try {
               class_9801 var2 = var1.method_60794();
               if (var2 != null) {
                  var2.close();
                  return true;
               }
            } catch (Throwable var3) {
               renderSupport12.v1.warn("stale shape builder cleanup failed", var3);
            }

            return false;
         }
      }

      public void v5() {
         if (this.v4()) {
            renderSupport12.v1.warn("dropped a stale shape batch from previous frame (drain missed?)");
         }
      }

      public void v6() {
         this.v5();

         try {
            this.v2.close();
         } catch (Throwable var2) {
            renderSupport12.v1.warn("shape allocator close failed", var2);
         }
      }
   }
}
