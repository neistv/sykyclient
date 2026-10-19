package cc.syky.module.visual;

import cc.syky.mixin.accessor.BufferBuilderAccessor;
import com.mojang.blaze3d.vertex.VertexFormat;
import com.mojang.blaze3d.vertex.VertexFormat.class_5596;
import java.nio.ByteOrder;
import net.minecraft.class_287;
import net.minecraft.class_3532;
import net.minecraft.class_4588;
import net.minecraft.class_9848;
import org.lwjgl.system.MemoryUtil;

public final class visualSupport10 {
   public static final int v1 = 36;
   public static final int v2 = 16;
   private static final int v5 = 16777215;
   private static final boolean v6 = ByteOrder.nativeOrder() == ByteOrder.LITTLE_ENDIAN;
   public static boolean v3 = true;
   public static long v4;

   private visualSupport10() {
   }

   public static long v1(class_4588 var0, VertexFormat var1, int var2) {
      if (v3 && var2 > 0 && v6 && var0 instanceof class_287 var3) {
         BufferBuilderAccessor var4 = (BufferBuilderAccessor)var3;
         if (var4.syky$vertexFormat() == var1 && var4.syky$drawMode() == class_5596.field_27382 && var4.syky$building() && var4.syky$currentMask() == 0) {
            int var5 = var4.syky$vertexCount();
            if (var5 > 16777215 - var2) {
               return 0L;
            } else {
               int var6 = var1.getVertexSize();
               long var7 = var4.syky$allocator().method_60808(var2 * var6);
               var4.syky$setVertexCount(var5 + var2);
               var4.syky$setVertexPointer(var7 + (long)(var2 - 1) * var6);
               v4++;
               return var7;
            }
         } else {
            return 0L;
         }
      } else {
         return 0L;
      }
   }

   public static int v1(int var0) {
      return class_9848.method_61337(var0);
   }

   public static short v1(float var0, float var1) {
      return (short)(v1(var0) & 255 | v1(var1) << 8);
   }

   public static byte v1(float var0) {
      return (byte)((int)(class_3532.method_15363(var0, -1.0F, 1.0F) * 127.0F) & 0xFF);
   }

   public static void v1(long var0, float var2, float var3, float var4, int var5, float var6, float var7, int var8, int var9, short var10, byte var11) {
      MemoryUtil.memPutFloat(var0, var2);
      MemoryUtil.memPutFloat(var0 + 4L, var3);
      MemoryUtil.memPutFloat(var0 + 8L, var4);
      MemoryUtil.memPutInt(var0 + 12L, var5);
      MemoryUtil.memPutFloat(var0 + 16L, var6);
      MemoryUtil.memPutFloat(var0 + 20L, var7);
      MemoryUtil.memPutInt(var0 + 24L, var8);
      MemoryUtil.memPutInt(var0 + 28L, var9);
      MemoryUtil.memPutShort(var0 + 32L, var10);
      MemoryUtil.memPutByte(var0 + 34L, var11);
   }

   public static void v1(long var0, float var2, float var3, float var4, int var5) {
      MemoryUtil.memPutFloat(var0, var2);
      MemoryUtil.memPutFloat(var0 + 4L, var3);
      MemoryUtil.memPutFloat(var0 + 8L, var4);
      MemoryUtil.memPutInt(var0 + 12L, var5);
   }
}
