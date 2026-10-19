package cc.syky.render;

import com.mojang.blaze3d.buffers.GpuBuffer;
import com.mojang.blaze3d.systems.CommandEncoder;
import java.nio.ByteBuffer;

public final class renderSupport27 {
   private final ByteBuffer v1;
   private int v2 = -1;

   public renderSupport27(int var1) {
      this.v1 = ByteBuffer.allocate(var1);
   }

   public void v1(CommandEncoder var1, GpuBuffer var2, ByteBuffer var3) {
      int var4 = var3.remaining();
      if (var4 == this.v2) {
         this.v1.position(0).limit(var4);
         if (var3.mismatch(this.v1) == -1) {
            return;
         }
      }

      this.v1.clear();
      this.v1.put(var3.duplicate());
      this.v2 = var4;
      var1.writeToBuffer(renderSupport31.v1(var2), var3);
   }

   public void v1() {
      this.v2 = -1;
   }
}
