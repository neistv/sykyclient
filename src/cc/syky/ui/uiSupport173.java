package cc.syky.ui;

import java.util.List;

public enum uiSupport173 {
   PANORAMA(4, 2, List.of()),
   GRID_3X2(
      3,
      2,
      List.of(
         new uiSupport173.Part1(0, 0, 0, -1, 0, 1, 0, 0, 0, 0, 1),
         new uiSupport173.Part1(1, 0, 0, 1, 0, 1, 0, 0, 0, 0, -1),
         new uiSupport173.Part1(2, 0, 0, 0, 1, -1, 0, 0, 0, -1, 0),
         new uiSupport173.Part1(0, 1, -1, 0, 0, 0, 0, -1, 0, -1, 0),
         new uiSupport173.Part1(1, 1, 0, 0, -1, 1, 0, 0, 0, -1, 0),
         new uiSupport173.Part1(2, 1, 1, 0, 0, 0, 0, 1, 0, -1, 0)
      )
   ),
   CROSS(
      4,
      3,
      List.of(
         new uiSupport173.Part1(1, 0, 0, 1, 0, 1, 0, 0, 0, 0, -1),
         new uiSupport173.Part1(0, 1, -1, 0, 0, 0, 0, -1, 0, -1, 0),
         new uiSupport173.Part1(1, 1, 0, 0, -1, 1, 0, 0, 0, -1, 0),
         new uiSupport173.Part1(2, 1, 1, 0, 0, 0, 0, 1, 0, -1, 0),
         new uiSupport173.Part1(3, 1, 0, 0, 1, -1, 0, 0, 0, -1, 0),
         new uiSupport173.Part1(1, 2, 0, -1, 0, 1, 0, 0, 0, 0, 1)
      )
   );

   private static final double ASPECT_TOLERANCE = 0.02;
   public final int columns;
   public final int rows;
   private final List<uiSupport173.Part1> faces;

   private uiSupport173(int var3, int var4, List<uiSupport173.Part1> var5) {
      this.columns = var3;
      this.rows = var4;
      this.faces = var5;
   }

   public static uiSupport173 v1(int var0, int var1) {
      if (v1(var0, var1, CROSS)) {
         return CROSS;
      } else {
         return v1(var0, var1, GRID_3X2) ? GRID_3X2 : PANORAMA;
      }
   }

   private static boolean v1(int var0, int var1, uiSupport173 var2) {
      return Math.abs((long)var0 * var2.rows - (long)var1 * var2.columns) <= 0.02 * var0 * var2.rows;
   }

   public List<uiSupport173.Part1> v1() {
      return this.faces;
   }

   public int v1(int var1) {
      return Math.max(1, var1 / this.columns);
   }

   public void v1(double var1, double var3, double var5, int var7, int var8, double[] var9) {
      if (this == PANORAMA) {
         double var25 = Math.sqrt(var1 * var1 + var5 * var5);
         double var12 = 0.5 + uiSupport174.v1(var1, -var5) / (Math.PI * 2);
         double var27 = 0.5 - uiSupport174.v1(var3, var25) / Math.PI;
         var9[0] = var12 * var7;
         var9[1] = var27 * var8;
         var9[2] = Double.NEGATIVE_INFINITY;
         var9[3] = 0.0;
         var9[4] = Double.POSITIVE_INFINITY;
         var9[5] = var8 - 1.0;
      } else {
         uiSupport173.Part1 var10 = this.faces.get(0);
         double var11 = Double.NEGATIVE_INFINITY;

         for (uiSupport173.Part1 var14 : this.faces) {
            double var15 = var14.nx * var1 + var14.ny * var3 + var14.nz * var5;
            if (var15 > var11) {
               var11 = var15;
               var10 = var14;
            }
         }

         double var26 = 0.5 * ((var10.rx * var1 + var10.ry * var3 + var10.rz * var5) / var11 + 1.0);
         double var28 = 0.5 * ((var10.dx * var1 + var10.dy * var3 + var10.dz * var5) / var11 + 1.0);
         double var17 = (double)var7 / this.columns;
         double var19 = (double)var8 / this.rows;
         double var21 = var10.column * var17;
         double var23 = var10.row * var19;
         var9[0] = var21 + var26 * var17;
         var9[1] = var23 + var28 * var19;
         var9[2] = Math.ceil(var21);
         var9[3] = Math.ceil(var23);
         var9[4] = Math.floor(var21 + var17) - 1.0;
         var9[5] = Math.floor(var23 + var19) - 1.0;
      }
   }

   public record Part1(int column, int row, int nx, int ny, int nz, int rx, int ry, int rz, int dx, int dy, int dz) {

      public int v1() {
         return this.column;
      }

      public int v2() {
         return this.row;
      }

      public int v3() {
         return this.nx;
      }

      public int v4() {
         return this.ny;
      }

      public int v5() {
         return this.nz;
      }

      public int v6() {
         return this.rx;
      }

      public int v7() {
         return this.ry;
      }

      public int v8() {
         return this.rz;
      }

      public int v9() {
         return this.dx;
      }

      public int v10() {
         return this.dy;
      }

      public int v11() {
         return this.dz;
      }
   }
}
