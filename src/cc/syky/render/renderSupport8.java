package cc.syky.render;

import com.mojang.blaze3d.textures.GpuTextureView;
import net.minecraft.class_276;
import org.jetbrains.annotations.Nullable;

public final class renderSupport8 implements AutoCloseable {
   private final renderSupport35 v1 = new renderSupport35("syky:world_mirror", 12, 12);
   private final renderSupport32 v2 = new renderSupport32();
   private boolean v3;
   private boolean v4;
   private boolean v5;

   public renderSupport8() {
   }

   public void v1(boolean var1) {
      this.v3 = var1;
      this.v4 = false;
      this.v5 = false;
   }

   public boolean v1() {
      return this.v3;
   }

   public boolean v1(class_276 var1) {
      if (var1.field_1482 > 0 && var1.field_1481 > 0) {
         if (this.v1.v2(Math.max(1, var1.field_1482 / 2), Math.max(1, var1.field_1481 / 2))) {
            this.v4 = false;
         }

         if (!this.v4) {
            this.v1.v1();
            this.v4 = true;
         }

         this.v2.v1();
         this.v5 = true;
         return true;
      } else {
         return false;
      }
   }

   @Nullable
   public GpuTextureView v2() {
      return this.v1.v4();
   }

   @Nullable
   public GpuTextureView v3() {
      return this.v1.v5();
   }

   @Nullable
   public GpuTextureView v4() {
      return this.v5 ? this.v1.v4() : null;
   }

   public void v1(long var1) {
      if (this.v2.v1(var1)) {
         this.v5();
      }
   }

   @Override
   public void close() {
      this.v5();
   }

   private void v5() {
      this.v1.v6();
      this.v4 = false;
      this.v5 = false;
   }
}
