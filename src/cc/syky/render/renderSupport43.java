package cc.syky.render;

import org.jetbrains.annotations.Nullable;

public final class renderSupport43 {
   private static final renderSupport43.Part1 v1 = new renderSupport43.Part1(0, 0, 0, 0, 0, 0, 0, 0L, 0L);
   private int v2;
   private int v3;
   private int v4;
   private int v5;
   private int v6;
   private int v7;
   private int v8;
   private long v9;
   private long v10;
   private final long[] v11 = new long[9];
   @Nullable
   private renderSupport43.Part1 v12 = v1;

   public renderSupport43() {
   }

   public void v1(int var1, int var2, int var3, int var4, int var5, int var6, long var7, long var9) {
      this.v2++;
      this.v3 += var1;
      this.v4 += var2;
      this.v5 += var3;
      this.v6 += var4;
      this.v7 += var5;
      this.v8 += var6;
      this.v9 += var7;
      this.v10 += var9;
   }

   public void v1() {
      this.v11[0] = this.v2;
      this.v11[1] = this.v3;
      this.v11[2] = this.v4;
      this.v11[3] = this.v5;
      this.v11[4] = this.v6;
      this.v11[5] = this.v7;
      this.v11[6] = this.v8;
      this.v11[7] = this.v9;
      this.v11[8] = this.v10;
      this.v12 = null;
      this.v2 = 0;
      this.v3 = 0;
      this.v4 = 0;
      this.v5 = 0;
      this.v6 = 0;
      this.v7 = 0;
      this.v8 = 0;
      this.v9 = 0L;
      this.v10 = 0L;
   }

   public renderSupport43.Part1 v2() {
      this.v1();
      return this.v3();
   }

   public renderSupport43.Part1 v3() {
      renderSupport43.Part1 var1 = this.v12;
      if (var1 == null) {
         var1 = new renderSupport43.Part1(
            (int)this.v11[0],
            (int)this.v11[1],
            (int)this.v11[2],
            (int)this.v11[3],
            (int)this.v11[4],
            (int)this.v11[5],
            (int)this.v11[6],
            this.v11[7],
            this.v11[8]
         );
         this.v12 = var1;
      }

      return var1;
   }

   public record Part1(
      int passes,
      int primitives,
      int draws,
      int instancedDraws,
      int pipelineSwitches,
      int scissorChanges,
      int textureBinds,
      long bytesUploaded,
      long bytesBound
   ) {
      public double v1() {
         return this.draws == 0 ? 0.0 : (double)this.primitives / this.draws;
      }

      public String v2() {
         return String.format(
            "passes=%d prims=%d draws=%d (inst=%d, %.1f prim/draw) pipeSw=%d scissor=%d texBind=%d up=%dB bound=%dB",
            this.passes,
            this.primitives,
            this.draws,
            this.instancedDraws,
            this.v1(),
            this.pipelineSwitches,
            this.scissorChanges,
            this.textureBinds,
            this.bytesUploaded,
            this.bytesBound
         );
      }

      public int v3() {
         return this.passes;
      }

      public int v4() {
         return this.primitives;
      }

      public int v5() {
         return this.draws;
      }

      public int v6() {
         return this.instancedDraws;
      }

      public int v7() {
         return this.pipelineSwitches;
      }

      public int v8() {
         return this.scissorChanges;
      }

      public int v9() {
         return this.textureBinds;
      }

      public long v10() {
         return this.bytesUploaded;
      }

      public long v11() {
         return this.bytesBound;
      }
   }
}
