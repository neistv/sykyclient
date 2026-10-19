package cc.syky.render;

import java.nio.ByteBuffer;
import org.jetbrains.annotations.Nullable;
import org.lwjgl.system.MemoryUtil;

public final class renderSupport42 implements AutoCloseable {
   @Nullable
   private ByteBuffer v1;
   private int v2;
   private int v3;

   public renderSupport42(int var1) {
      this.v2 = Math.max(16, var1);
      this.v1 = MemoryUtil.memAlloc(this.v2);
   }

   public static int v1(int var0, int var1) {
      return var0 + var1 - 1 & ~(var1 - 1);
   }

   public int v1(ByteBuffer var1, int var2) {
      int var3 = var1.remaining();
      int var4 = v1(this.v3, var2);
      this.v1(var4 + var3);
      renderSupport47.v1(this.v1).limit(this.v2);
      renderSupport47.v1(this.v1).position(var4);
      renderSupport47.v1(this.v1).put(var1);
      this.v3 = var4 + var3;
      return var4;
   }

   public int v1(ByteBuffer var1, int var2, int var3, int var4) {
      int var5 = v1(this.v3, var4);
      this.v1(var5 + var3);
      renderSupport47.v1(this.v1).limit(this.v2);
      renderSupport47.v1(this.v1).put(var5, var1, var2, var3);
      this.v3 = var5 + var3;
      return var5;
   }

   private void v1(int var1) {
      if (this.v1 == null || var1 > this.v2) {
         int var2 = Math.max(this.v2, 16);

         while (var2 < var1) {
            var2 <<= 1;
            if (var2 < 0) {
               throw new IllegalStateException("BatchScratch capacity overflow for " + var1 + " bytes");
            }
         }

         this.v1 = this.v1 == null ? MemoryUtil.memAlloc(var2) : MemoryUtil.memRealloc(this.v1, var2);
         this.v2 = var2;
      }
   }

   public ByteBuffer v1() {
      renderSupport47.v1(this.v1).position(0);
      renderSupport47.v1(this.v1).limit(this.v3);
      return renderSupport47.v1(this.v1);
   }

   public int v2() {
      return this.v3;
   }

   public long v1(long var1) {
      long var3 = renderSupport44.v1(var1 ^ this.v3);
      ByteBuffer var5 = this.v1;
      if (var5 == null) {
         return var3;
      } else {
         int var6;
         for (var6 = 0; var6 + 8 <= this.v3; var6 += 8) {
            var3 = renderSupport44.v1(var3 ^ var5.getLong(var6));
         }

         while (var6 < this.v3) {
            var3 = renderSupport44.v1(var3 ^ var5.get(var6));
            var6++;
         }

         return var3;
      }
   }

   public void v1(renderSupport42 var1) {
      this.v3 = 0;
      int var2 = var1.v3;
      this.v1(var2);
      if (var2 > 0) {
         MemoryUtil.memCopy(MemoryUtil.memAddress(renderSupport47.v1(var1.v1), 0), MemoryUtil.memAddress(renderSupport47.v1(this.v1), 0), var2);
      }

      this.v3 = var2;
   }

   public boolean v2(renderSupport42 var1) {
      int var2 = this.v3;
      if (var1.v3 != var2) {
         return false;
      } else if (var2 == 0) {
         return true;
      } else {
         ByteBuffer var3 = renderSupport47.v1(this.v1);
         ByteBuffer var4 = renderSupport47.v1(var1.v1);
         var3.limit(var2).position(0);
         var4.limit(var2).position(0);
         return var3.mismatch(var4) < 0;
      }
   }

   public void v3() {
      this.v3 = 0;
   }

   @Override
   public void close() {
      if (this.v1 != null) {
         MemoryUtil.memFree(this.v1);
         this.v1 = null;
      }

      this.v2 = 0;
      this.v3 = 0;
   }
}
