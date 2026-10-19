package cc.syky.render;

import com.mojang.blaze3d.pipeline.RenderPipeline;
import com.mojang.blaze3d.textures.GpuTextureView;
import java.nio.ByteBuffer;
import org.jetbrains.annotations.Nullable;

public final class renderSupport44 implements AutoCloseable {
   public static final int v1 = 16;
   private final renderSupport44.Part1 v3;
   private final renderSupport42 v4;
   private renderSupport41[] v5;
   private int v6;
   @Nullable
   private renderSupport44.Part3 v7;
   private long v8;

   public renderSupport44(renderSupport44.Part1 var1, int var2) {
      this.v3 = var1;
      this.v4 = new renderSupport42(var2);
      this.v5 = new renderSupport41[64];

      for (int var3 = 0; var3 < this.v5.length; var3++) {
         this.v5[var3] = new renderSupport41();
      }
   }

   public boolean v1() {
      return this.v6 == 0 && this.v7 == null;
   }

   public void v1(renderSupport44.Part3 var1) {
      if (this.v7 != var1) {
         this.v7();
         this.v7 = var1;
      }
   }

   private void v7() {
      renderSupport44.Part3 var1 = this.v7;
      if (var1 != null) {
         this.v7 = null;
         var1.release();
      }
   }

   public int v2() {
      return this.v6;
   }

   public long v3() {
      return this.v8;
   }

   public long v4() {
      this.v7();
      long var1 = v1(-7046029254386353131L ^ this.v6);

      for (int var3 = 0; var3 < this.v6; var3++) {
         renderSupport41 var4 = this.v5[var3];
         var1 = v1(var1 ^ System.identityHashCode(var4.v1));
         var1 = v1(var1 ^ System.identityHashCode(var4.v2));
         var1 = v1(var1 ^ ((long)var4.v3 << 32 | var4.v4 & 4294967295L));
         var1 = v1(var1 ^ System.identityHashCode(var4.v5));
         var1 = v1(var1 ^ System.identityHashCode(var4.v6));
         var1 = v1(var1 ^ (var4.v7 ? 1L : 0L));
         var1 = v1(var1 ^ ((long)var4.v8 << 32 | var4.v9 & 4294967295L));
         var1 = v1(var1 ^ ((long)var4.v10 << 32 | var4.v11 & 4294967295L));
         var1 = v1(var1 ^ ((long)var4.v12 << 32 | var4.v13 & 4294967295L));
         var1 = v1(var1 ^ ((long)var4.v14 << 32 | var4.v15 & 4294967295L));
         var1 = v1(var1 ^ var4.v16);
      }

      return this.v4.v1(var1);
   }

   public static long v1(long var0) {
      var0 = (var0 ^ var0 >>> 30) * -4658895280553007687L;
      var0 = (var0 ^ var0 >>> 27) * -7723592293110705685L;
      return var0 ^ var0 >>> 31;
   }

   public void v1(
      RenderPipeline var1,
      String var2,
      ByteBuffer var3,
      @Nullable GpuTextureView var4,
      @Nullable GpuTextureView var5,
      boolean var6,
      int var7,
      int var8,
      int var9,
      int var10,
      int var11,
      int var12,
      int var13,
      int var14
   ) {
      this.v1(var1, var2, var3, var4, var5, var6, var7, var8, var9, var10, var11, var12, var13, var14, 0);
   }

   public void v1(
      RenderPipeline var1,
      String var2,
      ByteBuffer var3,
      @Nullable GpuTextureView var4,
      @Nullable GpuTextureView var5,
      boolean var6,
      int var7,
      int var8,
      int var9,
      int var10,
      int var11,
      int var12,
      int var13,
      int var14,
      int var15
   ) {
      this.v7();
      int var16 = var3.remaining();

      assert var13 == 0 || var16 == var13 : "instanced record wrote " + var16 + " bytes for a stride of " + var13;

      int var17 = this.v4.v1(var3, 16);
      renderSupport41 var18 = this.v8();
      var18.v1(var1, var2, var17, var16, var4, var5, var6, var7, var8, var9, var10, var11, var12, var13, var14);
      var18.v16 = var15;
   }

   private renderSupport41 v8() {
      if (this.v6 == this.v5.length) {
         renderSupport41[] var1 = new renderSupport41[this.v5.length * 2];
         System.arraycopy(this.v5, 0, var1, 0, this.v5.length);

         for (int var2 = this.v5.length; var2 < var1.length; var2++) {
            var1[var2] = new renderSupport41();
         }

         this.v5 = var1;
      }

      return this.v5[this.v6++];
   }

   // $VF: Could not verify finally blocks. A semaphore variable has been added to preserve control flow.
   // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
   public void v5() {
      this.v7();
      if (this.v6 != 0) {
         this.v8++;
         boolean var5 = false /* VF: Semaphore variable */;

         try {
            var5 = true;
            this.v3.v1(this.v4, this.v5, this.v6);
            var5 = false;
         } finally {
            if (var5) {
               for (int var3 = 0; var3 < this.v6; var3++) {
                  this.v5[var3].v1();
               }

               this.v6 = 0;
               this.v4.v3();
            }
         }

         for (int var1 = 0; var1 < this.v6; var1++) {
            this.v5[var1].v1();
         }

         this.v6 = 0;
         this.v4.v3();
      }
   }

   public void v6() {
      this.v7();

      for (int var1 = 0; var1 < this.v6; var1++) {
         this.v5[var1].v1();
      }

      this.v6 = 0;
      this.v4.v3();
   }

   public void v1(renderSupport44.Part2 var1) {
      this.v7();
      var1.v2();
      if (var1.v1.length < this.v6) {
         renderSupport41[] var2 = new renderSupport41[Math.max(this.v6, var1.v1.length * 2)];
         System.arraycopy(var1.v1, 0, var2, 0, var1.v1.length);

         for (int var3 = var1.v1.length; var3 < var2.length; var3++) {
            var2[var3] = new renderSupport41();
         }

         var1.v1 = var2;
      }

      for (int var4 = 0; var4 < this.v6; var4++) {
         var1.v1[var4].v1(this.v5[var4]);
      }

      var1.v2 = this.v6;
      var1.v3.v1(this.v4);
   }

   public boolean v2(renderSupport44.Part2 var1) {
      this.v7();
      if (var1.v2 == this.v6 && var1.v3.v2() == this.v4.v2()) {
         for (int var2 = 0; var2 < this.v6; var2++) {
            if (!this.v5[var2].v2(var1.v1[var2])) {
               return false;
            }
         }

         return this.v4.v2(var1.v3);
      } else {
         return false;
      }
   }

   @Override
   public void close() {
      this.v7 = null;

      for (int var1 = 0; var1 < this.v6; var1++) {
         this.v5[var1].v1();
      }

      this.v6 = 0;
      this.v4.close();
   }

   public interface Part1 {
      void v1(renderSupport42 var1, renderSupport41[] var2, int var3);
   }

   public static final class Part2 implements AutoCloseable {
      public renderSupport41[] v1 = new renderSupport41[0];
      public int v2 = -1;
      public final renderSupport42 v3 = new renderSupport42(16);

      public Part2() {
      }

      public boolean v1() {
         return this.v2 >= 0;
      }

      public void v2() {
         for (int var1 = 0; var1 < Math.max(this.v2, 0); var1++) {
            this.v1[var1].v1();
         }

         this.v2 = -1;
         this.v3.v3();
      }

      @Override
      public void close() {
         this.v2();
         this.v3.close();
      }
   }

   public interface Part3 {
      void release();
   }
}
