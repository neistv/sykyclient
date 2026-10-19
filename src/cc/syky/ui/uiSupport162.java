package cc.syky.ui;

import org.jetbrains.annotations.Nullable;

public final class uiSupport162 {
   private static final uiSupport162.Part1 v1 = new uiSupport162.Part1(0L, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0L);
   private int v2;
   private int v3;
   private int v4;
   private int v5;
   private int v6;
   private int v7;
   private int v8;
   private int v9;
   private int v10;
   private int v11;
   private long v12;
   private long v13;
   private int v14 = -1;
   private boolean v15;
   private final long[] v16 = new long[12];
   @Nullable
   private uiSupport162.Part1 v18 = v1;

   public uiSupport162() {
   }

   public void v1(boolean var1) {
      this.v6();
      this.v2++;
      if (var1) {
         this.v3++;
      }

      this.v15 = var1;
      this.v14 = 0;
   }

   public void v1() {
      this.v4++;
   }

   public void v1(int var1, int var2, int var3, int var4, long var5) {
      this.v8 += var1;
      this.v9 += var2;
      this.v10 += var3;
      this.v11 += var4;
      this.v12 += var5;
   }

   public void v2() {
      this.v5++;
      if (this.v14 >= 0) {
         this.v14++;
      }
   }

   public void v3() {
      this.v6();
      this.v16[0] = this.v13++;
      this.v16[1] = this.v2;
      this.v16[2] = this.v3;
      this.v16[3] = this.v4;
      this.v16[4] = this.v5;
      this.v16[5] = this.v6;
      this.v16[6] = this.v7;
      this.v16[7] = this.v8;
      this.v16[8] = this.v9;
      this.v16[9] = this.v10;
      this.v16[10] = this.v11;
      this.v16[11] = this.v12;
      this.v18 = null;
      this.v2 = 0;
      this.v3 = 0;
      this.v4 = 0;
      this.v5 = 0;
      this.v6 = 0;
      this.v7 = 0;
      this.v8 = 0;
      this.v9 = 0;
      this.v10 = 0;
      this.v11 = 0;
      this.v12 = 0L;
      this.v14 = -1;
   }

   public uiSupport162.Part1 v4() {
      this.v3();
      return this.v5();
   }

   public uiSupport162.Part1 v5() {
      uiSupport162.Part1 var1 = this.v18;
      if (var1 == null) {
         var1 = new uiSupport162.Part1(
            this.v16[0],
            (int)this.v16[1],
            (int)this.v16[2],
            (int)this.v16[3],
            (int)this.v16[4],
            (int)this.v16[5],
            (int)this.v16[6],
            (int)this.v16[7],
            (int)this.v16[8],
            (int)this.v16[9],
            (int)this.v16[10],
            this.v16[11]
         );
         this.v18 = var1;
      }

      return var1;
   }

   private void v6() {
      if (this.v14 == 0) {
         this.v6++;
         if (this.v15) {
            this.v7++;
         }
      }

      this.v14 = -1;
      this.v15 = false;
   }

   public record Part1(
      long index,
      int builds,
      int recaptures,
      int nestedBuilds,
      int reads,
      int wastedBuilds,
      int wastedRecaptures,
      int tiles,
      int tilesOnDemand,
      int tileOverflow,
      int rawMisses,
      long rawTexels
   ) {
      public boolean v1() {
         return this.wastedBuilds > 0;
      }

      public String v2() {
         return String.format(
            "builds=%d (recapture=%d, nested=%d) reads=%d wasted=%d (recapture=%d) tiles=%d (on demand=%d, overflow=%d) raw misses=%d raw texels=%d",
            this.builds,
            this.recaptures,
            this.nestedBuilds,
            this.reads,
            this.wastedBuilds,
            this.wastedRecaptures,
            this.tiles,
            this.tilesOnDemand,
            this.tileOverflow,
            this.rawMisses,
            this.rawTexels
         );
      }

      public long v3() {
         return this.index;
      }

      public int v4() {
         return this.builds;
      }

      public int v5() {
         return this.recaptures;
      }

      public int v6() {
         return this.nestedBuilds;
      }

      public int v7() {
         return this.reads;
      }

      public int v8() {
         return this.wastedBuilds;
      }

      public int v9() {
         return this.wastedRecaptures;
      }

      public int v10() {
         return this.tiles;
      }

      public int v11() {
         return this.tilesOnDemand;
      }

      public int v12() {
         return this.tileOverflow;
      }

      public int v13() {
         return this.rawMisses;
      }

      public long v14() {
         return this.rawTexels;
      }
   }
}
